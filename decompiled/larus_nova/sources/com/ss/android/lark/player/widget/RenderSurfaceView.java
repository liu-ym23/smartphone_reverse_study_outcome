package com.ss.android.lark.player.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes37.dex */
public class RenderSurfaceView extends SurfaceView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f438728a;

    public interface a {
    }

    public interface b {
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SurfaceHolder> f438729a;

        public c(SurfaceHolder r100) {
            this.f438729a = new WeakReference(r100);
        }
    }

    public class d implements SurfaceHolder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RenderSurfaceView f438730a;

        public d(RenderSurfaceView r100) {
            this.f438730a = r100;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder r100) {
            Log.d("RenderSurfaceView", "<---surfaceCreated---->");
            a r101 = this.f438730a.f438728a;
            if (r101 == null) goto L6;
            c r102 = new c(r100);
            VideoView r103 = ((VideoView.a) r101).f438765a;
            r103.f438758k = r102;
            VideoView.b(r103, r102);
            return;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder r100) {
            Log.d("RenderSurfaceView", "***surfaceDestroyed***");
            a r101 = this.f438730a.f438728a;
            if (r101 == null) goto L6;
            new WeakReference(r100);
            ((VideoView.a) r101).f438765a.f438758k = null;
            return;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
            Log.d("RenderSurfaceView", "surfaceChanged : width = " + r102 + " height = " + r103);
            a r104 = this.f438730a.f438728a;
            if (r104 == null) goto L6;
            new WeakReference(r100);
            r104.getClass();
            return;
        }
    }

    public a getRenderCallback() {
        return this.f438728a;
    }

    public RenderSurfaceView(Context r100) {
        this(r100, null);
    }

    public void setRenderCallback(a r100) {
        this.f438728a = r100;
    }

    public RenderSurfaceView(Context r100, AttributeSet r101) {
        super(r100, r101);
        getHolder().addCallback(new d(this));
    }
}
