package com.larus.im.internal.utils;

import com.larus.im.internal.delegate.g1;
import com.larus.im.internal.delegate.i1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f350541a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f350542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f350543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f350544c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f350545d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f350546e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f350547f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f350542a, r101.f350542a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f350543b, r101.f350543b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f350544c, r101.f350544c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f350545d, r101.f350545d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f350546e, r101.f350546e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f350547f, r101.f350547f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.f350542a.hashCode() * 31) + this.f350543b.hashCode()) * 31) + this.f350544c.hashCode()) * 31) + this.f350545d.hashCode()) * 31) + this.f350546e.hashCode()) * 31) + this.f350547f.hashCode();
        }

        public final String toString() {
            return "DbInitialInfo(uid=" + this.f350542a + ", userName=" + this.f350543b + ", senderId=" + this.f350544c + ", secUid=" + this.f350545d + ", dbName=" + this.f350546e + ", dbSuffix=" + this.f350547f + ')';
        }

        public a(String r100, String r101, String r102, String r103, String r104, String r105) {
            Intrinsics.checkNotNullParameter(r100, "uid");
            Intrinsics.checkNotNullParameter(r101, "userName");
            Intrinsics.checkNotNullParameter(r102, "senderId");
            Intrinsics.checkNotNullParameter(r103, "secUid");
            Intrinsics.checkNotNullParameter(r104, "dbName");
            Intrinsics.checkNotNullParameter(r105, "dbSuffix");
            this.f350542a = r100;
            this.f350543b = r101;
            this.f350544c = r102;
            this.f350545d = r103;
            this.f350546e = r104;
            this.f350547f = r105;
        }
    }

    static {
    }

    public i() {
    }

    public static a a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        com.larus.im.internal.delegate.b r102 = com.larus.im.internal.delegate.b.f348193b;
        String r103 = r102.h();
        String r104 = r102.getUserId();
        String r105 = r102.j();
        if (r101 == false) goto L5;
        String r106 = "minor_" + r100;
    L6:
        String r107 = g1.f348229b.c();
        String r108 = i1.f348244b.a();
        if (r108 != null) goto L9;
    L12:
        boolean r109 = true;
    L13:
        if (r109 == false) goto L15;
        String r110 = r107 + r106;
    L17:
        return new a(r100, r103, r104, r105, r110, r106);
    L15:
        com.larus.im.internal.delegate.a.f348188b.e("DbInitializeHelper", "set db version suffix: " + r108);
        r110 = r107 + r106 + '_' + r108;
        goto L17
    L9:
        if (r108.length() == 0) goto L12;
        r109 = false;
        goto L13
    L5:
        r106 = r100;
        goto L6
    }
}
