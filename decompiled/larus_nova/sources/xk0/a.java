package xk0;

import android.view.SurfaceView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<b> f564124a;

    @Override // xk0.b
    public final SurfaceView q1() {
        b r100 = this.f564124a.get();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.q1();
    }

    public a(WeakReference<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "callBackRef");
        this.f564124a = r100;
    }
}
