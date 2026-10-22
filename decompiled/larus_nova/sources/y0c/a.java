package y0c;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes37.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f565606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f565607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f565608c;

    public a(b r100) {
        this.f565607b = true;
        this.f565608c = true;
        this.f565606a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r100) {
        b r101 = this.f565606a;
        if (r101 == null) goto L6;
        r101.onDoubleTap(r100);
    L6:
        return super.onDoubleTap(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r100) {
        Log.d("GestureCallbackHandler", "onDown...");
        b r101 = this.f565606a;
        if (r101 == null) goto L6;
        r101.onDown(r100);
    L6:
        return this.f565607b;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        b r101 = this.f565606a;
        if (r101 == null) goto L5;
        r101.onLongPress(r100);
    L5:
        super.onLongPress(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        b r101 = this.f565606a;
        if (r101 == null) goto L6;
        r101.onSingleTapUp(r100);
    L6:
        return super.onSingleTapUp(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        return super.onFling(r100, r101, r102, r103);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        b r104 = this.f565606a;
        if (r104 == null) goto L8;
        if (this.f565608c == false) goto L8;
        r104.onScroll(r100, r101, r102, r103);
    L8:
        return super.onScroll(r100, r101, r102, r103);
    }
}
