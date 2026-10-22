package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f443883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f443884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f443885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f443886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f443887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f443888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f443889g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f443883a, r101.f443883a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f443884b, r101.f443884b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f443885c, r101.f443885c) == true) goto L18;
        return false;
    L18:
        if (this.f443886d == r101.f443886d) goto L21;
        return false;
    L21:
        if (this.f443887e == r101.f443887e) goto L24;
        return false;
    L24:
        if (this.f443888f == r101.f443888f) goto L27;
        return false;
    L27:
        if (this.f443889g == r101.f443889g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f443883a.hashCode() * 31) + this.f443884b.hashCode()) * 31) + this.f443885c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f443886d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f443887e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f443888f == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f443889g == true) goto L19;
        r101 = 1237;
    L19:
        return r107 + r101;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "FollowerBean(id=" + this.f443883a + ", name=" + this.f443884b + ", avatarKey=" + this.f443885c + ", deletable=" + this.f443886d + ", deleteQuitWarning=" + this.f443887e + ", deleteDirect=" + this.f443888f + ", showExternal=" + this.f443889g + ')';
    }

    public i(String r100, String r101, String r102, boolean r103, boolean r104, boolean r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "avatarKey");
        this.f443883a = r100;
        this.f443884b = r101;
        this.f443885c = r102;
        this.f443886d = r103;
        this.f443887e = r104;
        this.f443888f = r105;
        this.f443889g = r106;
    }
}
