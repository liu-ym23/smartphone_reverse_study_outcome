package com.larus.dora.impl.assistant;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f332043d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f332044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f332045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f332046c;

    public static final class a {
        public static e a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "errorCode");
            return new e(false, r100, r101);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f332044a == r101.f332044a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f332045b, r101.f332045b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f332046c, r101.f332046c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f332044a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f332045b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f332046c;
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
        return "DoraWifiIntentResult(success=" + this.f332044a + ", errorCode=" + this.f332045b + ", errorMsg=" + this.f332046c + ')';
    }

    public e(boolean r100, String r101, String r102) {
        this.f332044a = r100;
        this.f332045b = r101;
        this.f332046c = r102;
    }
}
