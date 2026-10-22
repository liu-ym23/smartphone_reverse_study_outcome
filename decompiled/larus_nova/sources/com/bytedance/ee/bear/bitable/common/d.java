package com.bytedance.ee.bear.bitable.common;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f209807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f209808b;

    public d(float r100, View r101) {
        this.f209807a = r100;
        this.f209808b = r101;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L14;
        int r104 = e.f209809a;
        float r105 = this.f209807a;
        View r106 = this.f209808b;
        if (r106 == null) goto L13;
        r100 = r106;
    L13:
        e.a(r105, r100);
    L31:
        return false;
    L14:
        if (r101 != null) goto L16;
    L18:
        boolean r107 = false;
    L19:
        if (r107 == true) goto L26;
        if (r101 != null) goto L22;
    L24:
        r102 = false;
    L25:
        if (r102 == false) goto L31;
    L22:
        if (r101.getAction() != 1) goto L24;
    L26:
        int r108 = e.f209809a;
        View r109 = this.f209808b;
        if (r109 == null) goto L30;
        r100 = r109;
    L30:
        e.a(1.0f, r100);
        goto L31
    L16:
        if (r101.getAction() != 3) goto L18;
        r107 = true;
        goto L19
    L5:
        if (r101.getAction() != 0) goto L7;
        r103 = true;
        goto L8
    }
}
