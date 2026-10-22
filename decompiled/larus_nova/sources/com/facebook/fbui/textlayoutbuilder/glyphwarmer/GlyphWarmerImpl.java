package com.facebook.fbui.textlayoutbuilder.glyphwarmer;

import android.graphics.Picture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Layout;
import com.facebook.fbui.textlayoutbuilder.GlyphWarmer;
import com.facebook.fbui.textlayoutbuilder.util.LayoutMeasureUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes23.dex */
public class GlyphWarmerImpl implements GlyphWarmer {
    private static WarmHandler sWarmHandler;

    public static class WarmHandler extends Handler {
        private static final int NO_OP = 1;
        private final Picture mPicture;

        public WarmHandler(Looper r100) {
            super(r100);
            this.mPicture = new Picture();
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            Layout r101 = (Layout) r100.obj;
            r101.draw(this.mPicture.beginRecording(LayoutMeasureUtil.getWidth(r101), LayoutMeasureUtil.getHeight(r101)));     // Catch: Exception -> L5
            this.mPicture.endRecording();     // Catch: Exception -> L5
            return;
        }
    }

    public GlyphWarmerImpl() {
    }

    private WarmHandler getWarmHandler() {
        if (sWarmHandler != null) goto L6;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("GlyphWarmer");
        ThreadMethodProxy.start(r100);
        sWarmHandler = new WarmHandler(r100.getLooper());
    L6:
        return sWarmHandler;
    }

    public Looper getWarmHandlerLooper() {
        return getWarmHandler().getLooper();
    }

    @Override // com.facebook.fbui.textlayoutbuilder.GlyphWarmer
    public void warmLayout(Layout r100) {
        WarmHandler r101 = getWarmHandler();
        r101.sendMessage(r101.obtainMessage(1, r100));
    }
}
