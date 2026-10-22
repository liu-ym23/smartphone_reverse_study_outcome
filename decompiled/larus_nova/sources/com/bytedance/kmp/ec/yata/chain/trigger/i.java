package com.bytedance.kmp.ec.yata.chain.trigger;

import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "历史遗留老逻辑")
public final class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f251330e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f251332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f251333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f251334d;

    public static final class a {
        public static i b(i r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            i r101 = r100.f251334d;
            if (r101 != null) goto L9;
            return r100;
        L9:
            return b(r101);
        }

        public static void a(i r100, i r101) {
            Intrinsics.checkNotNullParameter(r101, "info");
            if (r100 != null) goto L5;
            return;
        L5:
            i r102 = r100.f251334d;
            if (r102 != null) goto L9;
            r100.f251334d = r101;
            r101.f251333c = r100;
            return;
        L9:
            a(r102, r101);
        }
    }

    static {
    }

    public i() {
        String r100 = null;
        this(r100, r100, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f251331a, r101.f251331a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f251332b, r101.f251332b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f251333c, r101.f251333c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f251334d, r101.f251334d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f251331a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Object r104 = this.f251332b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        i r107 = this.f251333c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        i r110 = this.f251334d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PipDataNode(key=" + this.f251331a + ", data=" + this.f251332b + ", previous=" + this.f251333c + ", next=" + this.f251334d + ')';
    }

    public /* synthetic */ i(String r100, Object r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101, null, null);
    }

    public i(String r100, Object r101, i r102, i r103) {
        this.f251331a = r100;
        this.f251332b = r101;
        this.f251333c = r102;
        this.f251334d = r103;
    }
}
