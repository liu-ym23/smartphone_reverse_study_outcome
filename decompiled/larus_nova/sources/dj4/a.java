package dj4;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements GestureDetector.OnDoubleTapListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f468907a;

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return false;
    }

    public a(e r100) {
        this.f468907a = r100;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        e r101 = this.f468907a;
        if (r101.f468912b == false) goto L7;
        f r102 = r101.f468911a;
        if (r102 == null) goto L7;
        r102.onDoubleTap(r100);
        return true;
    L7:
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        f r101 = this.f468907a.f468911a;
        if (r101 == null) goto L5;
        r101.onSingleTapConfirmed(r100);
        return true;
    L5:
        return false;
    }
}
