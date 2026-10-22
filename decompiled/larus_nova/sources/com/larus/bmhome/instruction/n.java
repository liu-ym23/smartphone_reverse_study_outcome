package com.larus.bmhome.instruction;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f312183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final aq8.e f312184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f312185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f312186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f312187e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f312183a, r101.f312183a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f312184b, r101.f312184b) == true) goto L15;
        return false;
    L15:
        if (this.f312185c == r101.f312185c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f312186d, r101.f312186d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f312187e, r101.f312187e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f312183a.hashCode() * 31;
        aq8.e r101 = this.f312184b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        if (this.f312185c == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        String r107 = this.f312186d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        a r110 = this.f312187e;
        if (r110 == null) goto L19;
        r102 = r110.hashCode();
    L19:
        return r109 + r102;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "InstructionActionData(instructionHandlerType=" + this.f312183a + ", instructionExtraData=" + this.f312184b + ", autoSend=" + this.f312185c + ", uri=" + this.f312186d + ", actionSchemaConfig=" + this.f312187e + ')';
    }

    public n(String r100, aq8.e r101, boolean r102, String r103, a r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = false;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 16) == 0) goto L14;
        r104 = null;
    L14:
        Intrinsics.checkNotNullParameter(r100, "instructionHandlerType");
        this.f312183a = r100;
        this.f312184b = r101;
        this.f312185c = r102;
        this.f312186d = r103;
        this.f312187e = r104;
    }
}
