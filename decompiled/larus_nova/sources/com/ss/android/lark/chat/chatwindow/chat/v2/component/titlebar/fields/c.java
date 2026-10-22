package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f414395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f414396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f414397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f414398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f414399e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f414395a, r101.f414395a) == true) goto L12;
        return false;
    L12:
        if (this.f414396b == r101.f414396b) goto L15;
        return false;
    L15:
        if (this.f414397c == r101.f414397c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f414398d, r101.f414398d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f414399e, r101.f414399e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f414395a.hashCode() * 31;
        int r101 = 1231;
        if (this.f414396b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f414397c == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        String r105 = this.f414398d;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f414399e;
        if (r109 == null) goto L19;
        r106 = r109.hashCode();
    L19:
        return r108 + r106;
    L13:
        r107 = r105.hashCode();
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "UserFields(userId=" + this.f414395a + ", isLoading=" + this.f414396b + ", needForceServer=" + this.f414397c + ", first=" + this.f414398d + ", second=" + this.f414399e + ')';
    }

    public c(String r100, boolean r101, boolean r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f414395a = r100;
        this.f414396b = r101;
        this.f414397c = r102;
        this.f414398d = r103;
        this.f414399e = r104;
    }
}
