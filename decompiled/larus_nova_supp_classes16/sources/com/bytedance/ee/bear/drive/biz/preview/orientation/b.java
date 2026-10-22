package com.bytedance.ee.bear.drive.biz.preview.orientation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements ru5.a.b, sa5.d {
    public final String a;
    public final d b;

    @Override // sa5.d
    public final boolean onBackPressed() {
        if (this.b.isLandscape() == false) goto L5;
        this.b.b(false);
    L5:
        return false;
    }

    public b(String r1, DriveOrientationPlugin.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(ru5.d r6, Boolean r7) {
        tt5.a.h("DriveSdk", "onOrientationStateChange, orientation = " + r6 + ", locked = " + r7);
        if (r6 == null) goto L32;
        if (r7 != null) goto L7;
        return;
    L7:
        if (r7.booleanValue() == false) goto L10;
    L18:
        byte r8 = 1;
    L19:
        if (r8 != (-1)) goto L21;
        return;
    L21:
        int r0 = this.b.a();
        if (r0 != 1) goto L26;
        if (r8 == 0) goto L25;
        if (r8 != 8) goto L26;
    L25:
        o75.b.a().Ke().u(this.a, 1);
    L30:
        this.b.b(r7.booleanValue());
        return;
    L26:
        if (r0 == 0) goto L28;
        if (r0 != 8) goto L30;
    L28:
        if (r8 != 1) goto L30;
        o75.b.a().Ke().u(this.a, 0);
        goto L30
    L10:
        if (r6.isLandscape() == false) goto L16;
        if (r6.a() == false) goto L14;
        r8 = 8;
        goto L19
    L14:
        r8 = 0;
        goto L19
    L16:
        if (r6.a() == false) goto L18;
        r8 = -1;
        goto L19
    }
}
