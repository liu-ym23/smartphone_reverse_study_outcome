package com.bytedance.android.livesdk.ktvimpl.mv;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import com.bytedance.android.live.ktv.common.view.ContinuousSurfaceAdapterView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/SmoothEnterSurfaceView;", "Lcom/bytedance/android/live/ktv/common/view/ContinuousSurfaceAdapterView;", "Lcom/bytedance/android/livesdk/ktvimpl/mv/x;", "e", "Lcom/bytedance/android/livesdk/ktvimpl/mv/x;", "getSmoothEnterCallback", "()Lcom/bytedance/android/livesdk/ktvimpl/mv/x;", "setSmoothEnterCallback", "(Lcom/bytedance/android/livesdk/ktvimpl/mv/x;)V", "smoothEnterCallback", "", "isBusinessVisibale", "Z", "()Z", "setBusinessVisibale", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SmoothEnterSurfaceView extends ContinuousSurfaceAdapterView {
    public x e;
    public final Handler f;
    public final b g;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ SmoothEnterSurfaceView a;

        public b(SmoothEnterSurfaceView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            x r0 = this.a.getSmoothEnterCallback();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final String name() {
        return "SmoothEnterSurfaceView";
    }

    public final void setBusinessVisibale(boolean r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.SurfaceView*/.onAttachedToWindow();
        this.f.postDelayed(this.g, 300);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.SurfaceView*/.onDetachedFromWindow();
        x r0 = this.e;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        super/*android.view.SurfaceView*/.onDetachedFromWindow();
    }

    public final x getSmoothEnterCallback() {
        return this.e;
    }

    public final void setSmoothEnterCallback(x r1) {
        this.e = r1;
    }

    public SmoothEnterSurfaceView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.f = new Handler(Looper.getMainLooper());
        this.g = new b(this);
    }
}
