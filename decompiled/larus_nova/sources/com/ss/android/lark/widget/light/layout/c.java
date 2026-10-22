package com.ss.android.lark.widget.light.layout;

import android.graphics.Picture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Layout;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f446152a;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Picture f446153a;

        public a(Looper r100) {
            super(r100);
            this.f446153a = new Picture();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Layout r101 = (Layout) r100.obj;
            r101.draw(this.f446153a.beginRecording(e.b(r101), e.a(r101)));     // Catch: Exception -> L5
            this.f446153a.endRecording();     // Catch: Exception -> L5
            return;
        }
    }

    public c() {
    }

    @Override // com.ss.android.lark.widget.light.layout.b
    public final void a(f r100) {
        if (f446152a != null) goto L5;
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("GlyphWarmer");
        ThreadMethodProxy.start(r101);
        f446152a = new a(r101.getLooper());
    L5:
        a r102 = f446152a;
        r102.sendMessage(r102.obtainMessage(1, r100));
    }
}
