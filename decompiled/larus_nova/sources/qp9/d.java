package qp9;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d implements GestureDetector.OnDoubleTapListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f534388a;

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return false;
    }

    public d(h r100) {
        this.f534388a = r100;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        h r101 = this.f534388a;
        if (r101.f534393b == false) goto L7;
        i r102 = r101.f534392a;
        if (r102 == null) goto L7;
        r102.onDoubleTap(r100);
        return true;
    L7:
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        i r101 = this.f534388a.f534392a;
        if (r101 == null) goto L5;
        r101.onSingleTapConfirmed(r100);
        return true;
    L5:
        return false;
    }
}
