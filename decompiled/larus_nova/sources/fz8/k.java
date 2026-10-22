package fz8;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f479414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Boolean> f479415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f479416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MotionEvent f479417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GestureDetector f479418e;

    public static final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f479419a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            return true;
        }

        public a(k r100) {
            this.f479419a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            k r101 = this.f479419a;
            Function0<Boolean> r102 = r101.getOnDetectedLongPress();
            boolean r103 = false;
            if (r102 != null) goto L5;
        L7:
            r101.f479416c = r103;
            k r104 = this.f479419a;
            if (r104.f479416c == false) goto L11;
            k.a(r104);
            return;
        L11:
            return;
        L5:
            if (r102.invoke().booleanValue() != true) goto L7;
            r103 = true;
            goto L7
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            k r101 = this.f479419a;
            if (r101.f479416c == true) goto L9;
            Function0<Unit> r102 = r101.getOnDetectedTap();
            if (r102 == null) goto L10;
            r102.invoke();
            return false;
        L10:
            return false;
        L9:
            return false;
        }
    }

    public final Function0<Boolean> getOnDetectedLongPress() {
        return this.f479415b;
    }

    public final Function0<Unit> getOnDetectedTap() {
        return this.f479414a;
    }

    public k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f479418e = new GestureDetector(r100, new a(this));
    }

    public static final void a(k r100) {
        MotionEvent r101 = r100.f479417d;
        if (r101 == null) goto L7;
        MotionEvent r102 = MotionEvent.obtain(r101);
        r102.setAction(3);
        super.dispatchTouchEvent(r102);
        r102.recycle();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getActionMasked() != 0) goto L5;
        this.f479416c = false;
    L5:
        MotionEvent r101 = this.f479417d;
        if (r101 == null) goto L8;
        r101.recycle();
    L8:
        this.f479417d = MotionEvent.obtain(r100);
        if (this.f479414a != null) goto L13;
        if (this.f479415b != null) goto L13;
    L16:
        if (this.f479416c == false) goto L18;
        boolean r102 = true;
    L20:
        if (r100.getActionMasked() != 1) goto L22;
    L23:
        MotionEvent r103 = this.f479417d;
        if (r103 == null) goto L26;
        r103.recycle();
    L26:
        this.f479417d = null;
        this.f479416c = false;
    L27:
        return r102;
    L22:
        if (r100.getActionMasked() != 3) goto L27;
    L18:
        r102 = super.dispatchTouchEvent(r100);
    L13:
        if (this.f479416c == true) goto L16;
        this.f479418e.onTouchEvent(r100);
        goto L16
    }

    public final void setOnDetectedLongPress(Function0<Boolean> r100) {
        this.f479415b = r100;
        if (r100 == null) goto L5;
        return;
    L5:
        if (this.f479414a != null) goto L12;
        MotionEvent r101 = this.f479417d;
        if (r101 == null) goto L9;
        r101.recycle();
    L9:
        this.f479417d = null;
        this.f479416c = false;
        return;
    }

    public final void setOnDetectedTap(Function0<Unit> r100) {
        this.f479414a = r100;
        if (r100 == null) goto L5;
        return;
    L5:
        if (this.f479415b != null) goto L12;
        MotionEvent r101 = this.f479417d;
        if (r101 == null) goto L9;
        r101.recycle();
    L9:
        this.f479417d = null;
        this.f479416c = false;
        return;
    }
}
