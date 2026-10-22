package com.larus.avlink.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f293948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f293949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f293950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f293951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f293952e;

    public i() {
        this(null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f293948a, r101.f293948a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f293949b, r101.f293949b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f293950c, r101.f293950c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f293951d, r101.f293951d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f293952e, r101.f293952e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f293948a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f293949b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f293950c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f293951d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f293952e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "CommandSend(command=" + this.f293948a + ", messageId=" + this.f293949b + ", commandStartTime=" + this.f293950c + ", commandReceivedTime=" + this.f293951d + ", commandSendTime=" + this.f293952e + ')';
    }

    public /* synthetic */ i(Integer r100, String r110, Long r111, Long r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        Long r103 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        Long r104 = null;
    L18:
        this(r101, r102, r103, r104, null);
        return;
    L17:
        r104 = r112;
        goto L18
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public i(Integer r100, String r101, Long r102, Long r103, Long r104) {
        this.f293948a = r100;
        this.f293949b = r101;
        this.f293950c = r102;
        this.f293951d = r103;
        this.f293952e = r104;
    }
}
