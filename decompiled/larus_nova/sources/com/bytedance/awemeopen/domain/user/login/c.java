package com.bytedance.awemeopen.domain.user.login;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoginHelper f198513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<com.bytedance.awemeopen.bizmodels.user.b> f198514b;

    public static final class a {
    }

    static {
    }

    public c() {
        LoginHelper r100 = LoginHelper.f198497a;
        Intrinsics.checkNotNullParameter(r100, "loginHelper");
        this.f198513a = r100;
        this.f198514b = new HashSet();
    }
}
