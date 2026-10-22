package com.larus.chat.gallery.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f324126d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f324127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f324128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SelectResultReason f324129c;

    public static final class a {
        public static a0 a(boolean r100, SelectResultReason r101) {
            Intrinsics.checkNotNullParameter(r101, "reason");
            return new a0(false, r100, r101);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (this.f324127a == r101.f324127a) goto L12;
        return false;
    L12:
        if (this.f324128b == r101.f324128b) goto L15;
        return false;
    L15:
        if (this.f324129c == r101.f324129c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f324127a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f324128b == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.f324129c.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SelectResult(success=" + this.f324127a + ", selected=" + this.f324128b + ", reason=" + this.f324129c + ')';
    }

    public a0(boolean r100, boolean r101, SelectResultReason r102) {
        Intrinsics.checkNotNullParameter(r102, "reason");
        this.f324127a = r100;
        this.f324128b = r101;
        this.f324129c = r102;
    }
}
