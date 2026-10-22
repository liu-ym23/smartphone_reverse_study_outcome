package com.obric.assistant.special_input;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f392762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f392763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f392764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f392765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f392766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f392767f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r101 = (q0) r100;
        if (this.f392762a == r101.f392762a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f392763b, r101.f392763b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f392764c, r101.f392764c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f392765d, r101.f392765d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f392766e, r101.f392766e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f392767f, r101.f392767f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f392762a * 31;
        String r101 = this.f392763b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f392764c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f392765d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f392766e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f392767f;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PhoneOperationSpecialPanelDraftContext(requestType=" + this.f392762a + ", panelType=" + this.f392763b + ", omniTaskId=" + this.f392764c + ", refMessageId=" + this.f392765d + ", sourceFrom=" + this.f392766e + ", complexSourceType=" + this.f392767f + ')';
    }

    public q0(int r100, String r101, String r102, String r103, String r104, String r105) {
        this.f392762a = r100;
        this.f392763b = r101;
        this.f392764c = r102;
        this.f392765d = r103;
        this.f392766e = r104;
        this.f392767f = r105;
    }
}
