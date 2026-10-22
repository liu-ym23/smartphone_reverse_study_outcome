package com.ss.android.lark.chat.base.model.dispatch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f411770f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f411771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f411772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f411773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f411774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f411775e;

    public static final class a {
    }

    static {
        f411770f = new f(false, false, false, true, false);
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f411771a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f411772b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f411773c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f411774d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f411775e == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        if (this.f411771a == false) goto L6;
        return "{ bizEnablePreUpload: " + this.f411771a + " }";
    L6:
        if (Intrinsics.areEqual(this, f411770f) == false) goto L9;
        return "{ default }";
    L9:
        return "{ isChat: " + this.f411772b + ", isThreadChat: " + this.f411773c + ", isSecretChat: " + this.f411774d + ", isPostInputState: " + this.f411775e + " }";
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof f) == false) goto L5;
        f r101 = (f) r100;
    L7:
        if (r101 != null) goto L10;
        return false;
    L10:
        if (this.f411771a == r101.f411771a) goto L12;
        return false;
    L12:
        if (this.f411772b == r101.f411772b) goto L14;
        return false;
    L14:
        if (this.f411773c == r101.f411773c) goto L16;
        return false;
    L16:
        if (this.f411774d == r101.f411774d) goto L18;
        return false;
    L18:
        if (this.f411775e != r101.f411775e) goto L25;
        return true;
    L25:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public f(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.f411771a = r100;
        this.f411772b = r101;
        this.f411773c = r102;
        this.f411774d = r103;
        this.f411775e = r104;
    }
}
