package com.larus.camera.impl.ui.component.capture;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class x1 extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f322053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f322054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f322055c;

    public x1(m1 r100) {
        this.f322054b = r100;
        this.f322055c = null;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        this.f322053a = false;
        return super.onDown(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        if (Math.abs(r103) > Math.abs(r102)) goto L5;
        return false;
    L5:
        if (this.f322053a == false) goto L7;
    L16:
        return true;
    L7:
        if (r103 <= 20.0f) goto L12;
        this.f322053a = true;
        Function0<Unit> r104 = this.f322054b;
        if (r104 == null) goto L16;
        r104.invoke();
        goto L16
    L12:
        if (r103 >= (-20.0f)) goto L16;
        this.f322053a = true;
        Function0<Unit> r105 = this.f322055c;
        if (r105 == null) goto L16;
        r105.invoke();
        goto L16
    }
}
