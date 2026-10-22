package com.bytedance.ee.bear.templates;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f238869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f238870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f238871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f238872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f238873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f238874f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f238875a;

        public a() {
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f238869a == r101.f238869a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f238870b, r101.f238870b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f238871c, r101.f238871c) == true) goto L18;
        return false;
    L18:
        if (this.f238872d == r101.f238872d) goto L21;
        return false;
    L21:
        if (this.f238873e == r101.f238873e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f238874f, r101.f238874f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f238869a * 31) + this.f238870b.hashCode()) * 31) + this.f238871c.hashCode()) * 31;
        if (this.f238872d == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.f238873e) * 31) + this.f238874f.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ShowBottomActionSheetParams(objType=" + this.f238869a + ", objToken=" + this.f238870b + ", name=" + this.f238871c + ", showEditItem=" + this.f238872d + ", shareSource=" + this.f238873e + ", extraInfo=" + this.f238874f + ')';
    }

    public c(int r100, String r101, String r102, boolean r103, int r104, int r105) {
        if ((r105 & 8) == 0) goto L6;
        r103 = false;
    L6:
        if ((r105 & 16) == 0) goto L9;
        r104 = 3;
    L9:
        if ((r105 & 32) == 0) goto L11;
        a r106 = new a();
    L12:
        Intrinsics.checkNotNullParameter(r101, "objToken");
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r106, "extraInfo");
        this.f238869a = r100;
        this.f238870b = r101;
        this.f238871c = r102;
        this.f238872d = r103;
        this.f238873e = r104;
        this.f238874f = r106;
        return;
    L11:
        r106 = null;
        goto L12
    }
}
