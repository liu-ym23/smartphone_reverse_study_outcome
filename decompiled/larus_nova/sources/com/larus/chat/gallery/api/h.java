package com.larus.chat.gallery.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h f324156f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f324157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f324158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f324159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f324160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f324161e;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f324157a == r101.f324157a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f324158b, r101.f324158b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f324159c, r101.f324159c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f324160d, r101.f324160d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f324161e, r101.f324161e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f324157a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f324158b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f324159c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f324160d;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f324161e;
        if (r112 == null) goto L23;
        r103 = r112.hashCode();
    L23:
        return r111 + r103;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "FindSimilarAvailability(available=" + this.f324157a + ", entranceText=" + this.f324158b + ", sendText=" + this.f324159c + ", artifactType=" + this.f324160d + ", bizPayload=" + this.f324161e + ')';
    }

    static {
        f324156f = new h(false, null, null, null, null);
    }

    public h(boolean r100, String r101, String r102, String r103, String r104) {
        this.f324157a = r100;
        this.f324158b = r101;
        this.f324159c = r102;
        this.f324160d = r103;
        this.f324161e = r104;
    }
}
