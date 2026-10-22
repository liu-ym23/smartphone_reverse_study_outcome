package com.ss.android.lark.flow.chat.creategroup.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f422059f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f422060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f422061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f422062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f422063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f422064e;

    public static final class a {
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
        if (this.f422060a == r101.f422060a) goto L12;
        return false;
    L12:
        if (this.f422061b == r101.f422061b) goto L15;
        return false;
    L15:
        if (this.f422062c == r101.f422062c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f422063d, r101.f422063d) == true) goto L21;
        return false;
    L21:
        if (this.f422064e == r101.f422064e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f422060a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f422061b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        long r105 = this.f422062c;
        int r106 = (((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.f422063d.hashCode()) * 31;
        if (this.f422064e == true) goto L15;
        r100 = 1237;
    L15:
        return r106 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowGroupCreateUserRelation(isFriend=" + this.f422060a + ", requestUserApply=" + this.f422061b + ", requestUserApplyId=" + this.f422062c + ", requestUserApplyReason=" + this.f422063d + ", targetUserApply=" + this.f422064e + ')';
    }

    public e(boolean r100, boolean r101, long r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r103, "requestUserApplyReason");
        this.f422060a = r100;
        this.f422061b = r101;
        this.f422062c = r102;
        this.f422063d = r103;
        this.f422064e = r104;
    }
}
