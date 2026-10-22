package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Rect;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes32.dex */
public class e extends f<BackgroundDrawable> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f383140e;

    public BackgroundDrawable l() {
        return new BackgroundDrawable(this.f383141a, this.f383144d);
    }

    public final BorderRadius m() {
        T r100 = this.f383142b;
        if (r100 != 0) goto L7;
        return null;
    L7:
        return ((BackgroundDrawable) r100).A;
    }

    @Override // com.lynx.tasm.behavior.ui.utils.f
    public /* bridge */ /* synthetic */ d a() {
        return l();
    }

    public e(LynxContext r100) {
        super(r100);
        this.f383140e = 0;
    }

    public final void n(int r100) {
        this.f383140e = r100;
        if (r100 == 0) goto L5;
    L7:
        b().setColor(r100);
        return;
    L5:
        if (this.f383142b != 0) goto L7;
    }

    public final void p(int r100, Integer r101) {
        float r102 = 1.0E21f;
        if (r101 != null) goto L5;
        float r103 = 1.0E21f;
    L6:
        if (r101 == null) goto L9;
        r102 = r101.intValue() >>> 24;
    L9:
        o(r100, r103, r102);
        return;
    L5:
        r103 = r101.intValue() & 16777215;
        goto L6
    }

    public final boolean q(int r100, ReadableArray r101) {
        int r102 = 0;
        if (r101 != null) goto L5;
    L22:
        if (r100 != 0) goto L26;
        int r103 = 0;
    L24:
        if (r103 >= 4) goto L27;
        r103 = r103 + 1;
        r(r103, new BorderRadius.a());
    L27:
        return false;
    L26:
        r(r100, new BorderRadius.a());
        goto L27
    L5:
        if (r101.size() <= 0) goto L22;
        if (r100 != 0) goto L17;
        if (r101.size() != 16) goto L12;
        boolean r104 = true;
    L13:
        LLog.DCHECK(r104);
    L14:
        if (r102 >= 4) goto L21;
        int r105 = r102 + 1;
        r(r105, BorderRadius.a.a(r101, r102 * 4));
        r102 = r105;
    L21:
        return true;
    L12:
        r104 = false;
        goto L13
    L17:
        if (r101.size() != 4) goto L19;
        boolean r106 = true;
    L20:
        LLog.DCHECK(r106);
        r(r100, BorderRadius.a.a(r101, 0));
        goto L21
    L19:
        r106 = false;
        goto L20
    }

    public final void r(int r100, BorderRadius.a r101) {
        BackgroundDrawable r102 = b();
        r102.getClass();
        if (r100 > 0) goto L5;
        return;
    L5:
        if (r100 > 8) goto L17;
        BorderRadius r103 = r102.A;
        if (r103 != null) goto L10;
        r102.A = new BorderRadius();
        Rect r104 = r102.getBounds();
        r102.A.d(r104.width(), r104.height());
    L12:
        if (r102.A.c(r100 - 1, r101) == false) goto L16;
        r102.f383106w = true;
        r102.invalidateSelf();
        return;
    L16:
        return;
    L10:
        r103.f383121d = null;
        goto L12
    }

    public final void s(int r100, int r101) {
        BackgroundDrawable r102 = b();
        r102.getClass();
        if (r100 > 8) goto L16;
        if (r100 >= 0) goto L7;
        return;
    L7:
        if (r102.f383095l != null) goto L14;
        r102.f383095l = new BorderStyle[9];
    L14:
        BorderStyle r103 = BorderStyle.parse(r101);     // Catch: Throwable -> L13
        BorderStyle[] r104 = r102.f383095l;     // Catch: Throwable -> L13
        if (r104[r100] == r103) goto L17;
        r104[r100] = r103;     // Catch: Throwable -> L13
        r102.invalidateSelf();     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L19:
        return;
    }

    public final void o(int r100, float r101, float r102) {
        BackgroundDrawable r103 = b();
        if (r103.f383093j != null) goto L5;
        r103.f383093j = new k(0.0f);
    L5:
        r103.f383093j.b(r100, r101);
        if (r103.f383094k != null) goto L8;
        r103.f383094k = new k(255.0f);
    L8:
        r103.f383094k.b(r100, r102);
    }
}
