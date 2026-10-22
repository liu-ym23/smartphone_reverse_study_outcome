package com.bytedance.ee.bear.profile;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HalfProfileActivity f236284a;

    public d(HalfProfileActivity r100) {
        this.f236284a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        if (r103 != 0.0f) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        return false;
    L8:
        float r105 = r101.getRawY();
        if (r100 == null) goto L11;
        float r106 = r100.getRawY();
    L13:
        if ((r105 - r106) <= 0.0f) goto L17;
        j r107 = this.f236284a.f236248j;
        if (r107 == null) goto L20;
        r107.j(0.0f, 100);
    L20:
        return true;
    L17:
        HalfProfileActivity r108 = this.f236284a;
        j r109 = r108.f236248j;
        if (r109 == null) goto L20;
        r109.j(r108.f236244f, 100);
        goto L20
    L11:
        r106 = 0.0f;
        goto L13
    L5:
        r104 = false;
        goto L6
    }
}
