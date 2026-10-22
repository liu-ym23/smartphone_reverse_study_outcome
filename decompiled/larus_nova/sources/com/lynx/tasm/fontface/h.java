package com.lynx.tasm.fontface;

import android.graphics.Typeface;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f383436c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f383437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Typeface[] f383438b;

    static {
        f383436c = h.class.getSimpleName();
    }

    public h(Typeface r100) {
        Typeface[] r101 = new Typeface[4];
        this.f383438b = r101;
        this.f383437a = r100;
        r101[0] = r100;
    }

    public final Typeface a(int r100) {
        if (r100 >= 0) goto L4;
    L5:
        r100 = 0;
    L6:
        Typeface[] r101 = this.f383438b;
        if (r101[r100] != null) goto L13;
        r101[r100] = Typeface.create(this.f383437a, r100);     // Catch: ArrayIndexOutOfBoundsException -> L10
    L10:
        e = move-exception;
        LLog.e(f383436c, "create typeface failed, style: " + r100 + ", origin typeface: " + this.f383437a + ", Typeface.create function is not thread safe lower than Android 9, exception: " + e);
    L13:
        return this.f383438b[r100];
    L4:
        if (r100 <= 3) goto L6;
        goto L5
    }
}
