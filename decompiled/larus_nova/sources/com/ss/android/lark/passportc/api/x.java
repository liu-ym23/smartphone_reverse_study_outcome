package com.ss.android.lark.passportc.api;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class x extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f438119c;

    @Override // com.ss.android.lark.passportc.api.z
    public final String a() {
        return this.f438119c;
    }

    public x(List<? extends User> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "expectedBackgroundUserList");
        super(r100, r101);
        this.f438119c = "OnlineForeground";
    }
}
