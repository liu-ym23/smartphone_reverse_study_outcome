package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f365098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f365099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f365100f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f365095a, r101.f365095a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365096b, r101.f365096b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365097c, r101.f365097c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365098d, r101.f365098d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365099e, r101.f365099e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365100f, r101.f365100f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f365095a.hashCode() * 31;
        String r101 = this.f365096b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f365097c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f365098d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f365099e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f365100f;
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
        return "AppletDebuggerMessageContext(menuItemKey=" + this.f365095a + ", conversationId=" + this.f365096b + ", messageId=" + this.f365097c + ", localMessageId=" + this.f365098d + ", logId=" + this.f365099e + ", sectionId=" + this.f365100f + ')';
    }

    public /* synthetic */ e(String r100, String r101, String r110, String r111) {
        this("copy_logid", r100, r101, r110, r111, null);
    }

    public e(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "menuItemKey");
        this.f365095a = r100;
        this.f365096b = r101;
        this.f365097c = r102;
        this.f365098d = r103;
        this.f365099e = r104;
        this.f365100f = r105;
    }
}
