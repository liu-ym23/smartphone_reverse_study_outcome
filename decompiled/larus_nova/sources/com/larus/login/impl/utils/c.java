package com.larus.login.impl.utils;

import com.larus.account.base.model.LoginPlatform;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoginPlatform f358316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f358317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f358318c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f358316a == r101.f358316a) goto L12;
        return false;
    L12:
        if (this.f358317b == r101.f358317b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f358318c, r101.f358318c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        LoginPlatform r100 = this.f358316a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f358317b) * 31;
        String r104 = this.f358318c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LoginFailedConfig(platform=" + this.f358316a + ", errorCode=" + this.f358317b + ", errorMessage=" + this.f358318c + ')';
    }

    public c(LoginPlatform r100, int r101, String r102) {
        this.f358316a = r100;
        this.f358317b = r101;
        this.f358318c = r102;
    }
}
