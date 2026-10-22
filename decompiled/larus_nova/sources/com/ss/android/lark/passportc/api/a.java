package com.ss.android.lark.passportc.api;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final User f438108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f438109d;

    @Override // com.ss.android.lark.passportc.api.z
    public final String a() {
        return this.f438109d;
    }

    public a(User r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        super(null, 3);
        this.f438108c = r100;
        this.f438109d = "BringNewForeground";
    }
}
