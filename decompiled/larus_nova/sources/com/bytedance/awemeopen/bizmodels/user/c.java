package com.bytedance.awemeopen.bizmodels.user;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f198217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f198218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f198219c;

    public c() {
        this("", "", "");
    }

    public c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "accessToken");
        Intrinsics.checkNotNullParameter(r101, "openId");
        this.f198217a = r100;
        this.f198218b = r101;
        this.f198219c = r102;
    }
}
