package com.bytedance.ee.bear.drive.biz.preview.orientation;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements ru5.a.b, sa5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f223673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f223674b;

    @Override // sa5.d
    public final boolean onBackPressed() {
        if (this.f223674b.isLandscape() == false) goto L5;
        this.f223674b.b(false);
    L5:
        return false;
    }

    public b(String r100, DriveOrientationPlugin.b r101) {
        this.f223673a = r100;
        this.f223674b = r101;
    }

    @Override // ru5.a.b
    public final void a(ru5.d r100, Boolean r101) {
        tt5.a.h("DriveSdk", "onOrientationStateChange, orientation = " + r100 + ", locked = " + r101);
        if (r100 == null) goto L32;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.booleanValue() == false) goto L10;
    L18:
        byte r102 = 1;
    L19:
        if (r102 != (-1)) goto L21;
        return;
    L21:
        int r103 = this.f223674b.a();
        if (r103 != 1) goto L26;
        if (r102 == 0) goto L25;
        if (r102 != 8) goto L26;
    L25:
        o75.b.a().Ke().u(this.f223673a, 1);
    L30:
        this.f223674b.b(r101.booleanValue());
        return;
    L26:
        if (r103 == 0) goto L28;
        if (r103 != 8) goto L30;
    L28:
        if (r102 != 1) goto L30;
        o75.b.a().Ke().u(this.f223673a, 0);
        goto L30
    L10:
        if (r100.isLandscape() == false) goto L16;
        if (r100.a() == false) goto L14;
        r102 = 8;
        goto L19
    L14:
        r102 = 0;
        goto L19
    L16:
        if (r100.a() == false) goto L18;
        r102 = -1;
        goto L19
    }
}
