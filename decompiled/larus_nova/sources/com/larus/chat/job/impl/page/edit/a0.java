package com.larus.chat.job.impl.page.edit;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatJobEditOptionKey f325225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f325226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f325227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f325228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f325229e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (this.f325225a == r101.f325225a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f325226b, r101.f325226b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f325227c, r101.f325227c) == true) goto L18;
        return false;
    L18:
        if (this.f325228d == r101.f325228d) goto L21;
        return false;
    L21:
        if (this.f325229e == r101.f325229e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f325225a.hashCode() * 31) + this.f325226b.hashCode()) * 31) + this.f325227c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f325228d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f325229e == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatJobEditOptionRow(key=" + this.f325225a + ", label=" + this.f325226b + ", value=" + this.f325227c + ", enabled=" + this.f325228d + ", clickable=" + this.f325229e + ')';
    }

    public a0(ChatJobEditOptionKey r100, String r101, String r102, int r103) {
        boolean r104 = false;
        if ((r103 & 8) == 0) goto L5;
        boolean r105 = true;
    L7:
        if ((r103 & 16) == 0) goto L9;
        r104 = r105;
    L9:
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "label");
        Intrinsics.checkNotNullParameter(r102, "value");
        this.f325225a = r100;
        this.f325226b = r101;
        this.f325227c = r102;
        this.f325228d = r105;
        this.f325229e = r104;
        return;
    L5:
        r105 = false;
        goto L7
    }
}
