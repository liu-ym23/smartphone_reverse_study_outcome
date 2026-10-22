package com.ss.android.lark.quicklaunchbar.widget;

import android.view.View;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f439146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QuickLaunchBar f439147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j2c.a f439148c;

    public b(boolean r100, QuickLaunchBar r101, j2c.a r102, int r103) {
        this.f439146a = r100;
        this.f439147b = r101;
        this.f439148c = r102;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        if (this.f439146a == false) goto L5;
        QuickLaunchBar r101 = this.f439147b;
        int r102 = QuickLaunchBar.f439134g;
        r101.getClass();
    L6:
        this.f439148c.getClass();
        return false;
    L5:
        QuickLaunchBar r103 = this.f439147b;
        int r104 = QuickLaunchBar.f439134g;
        r103.getClass();
        goto L6
    }
}
