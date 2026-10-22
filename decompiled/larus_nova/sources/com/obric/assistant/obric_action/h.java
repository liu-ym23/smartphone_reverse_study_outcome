package com.obric.assistant.obric_action;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f390443d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f390444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f390445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f390446c;

    public static final class a {
        public a() {
        }

        public final h<Unit> b(boolean r100) {
            if (r100 == false) goto L6;
            return c(this, null, null, 3);
        L6:
            return a(this, null, 3);
        }

        public static h a(a r100, String r101, int r102) {
            if ((r102 & 1) == 0) goto L5;
            r101 = "failed";
        L5:
            r100.getClass();
            return new h(false, r101, null);
        }

        public static h c(a r100, Object r101, String r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = null;
        L8:
            r100.getClass();
            return new h(true, r102, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f390444a == r101.f390444a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f390445b, r101.f390445b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f390446c, r101.f390446c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f390444a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f390445b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        T r106 = this.f390446c;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ObricActionResult(success=" + this.f390444a + ", msg=" + this.f390445b + ", data=" + this.f390446c + ')';
    }

    static {
        f390443d = new a();
    }

    public h(boolean r100, String r101, T r102) {
        this.f390444a = r100;
        this.f390445b = r101;
        this.f390446c = r102;
    }
}
