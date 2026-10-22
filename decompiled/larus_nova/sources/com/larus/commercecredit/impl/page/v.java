package com.larus.commercecredit.impl.page;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class v implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f325789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f325790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f325791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CommerceCreditWebFragment f325792d;

    public v(View r100, CommerceCreditWebFragment r101) {
        this.f325792d = r101;
        this.f325791c = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = r101.getAction();
        if (r102 == 0) goto L23;
        if (r102 != 1) goto L6;
    L21:
        r100.getParent().requestDisallowInterceptTouchEvent(false);
        return false;
    L6:
        if (r102 != 2) goto L8;
        float r103 = r101.getY() - this.f325789a;
        if (Math.abs(r103) <= this.f325791c) goto L16;
        if (this.f325790b == true) goto L16;
        this.f325790b = true;
    L16:
        if (this.f325790b == true) goto L18;
    L24:
        return false;
    L18:
        if (r103 <= 0.0f) goto L24;
        CommerceCreditWebFragment r104 = this.f325792d;
        int r105 = CommerceCreditWebFragment.f325734h;
        r104.X90();
        return true;
    L8:
        if (r102 == 3) goto L21;
    L23:
        this.f325789a = r101.getY();
        this.f325790b = false;
        r100.getParent().requestDisallowInterceptTouchEvent(true);
        goto L24
    }
}
