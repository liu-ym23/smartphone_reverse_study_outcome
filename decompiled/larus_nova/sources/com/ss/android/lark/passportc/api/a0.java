package com.ss.android.lark.passportc.api;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a0 extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f438110c;

    @Override // com.ss.android.lark.passportc.api.z
    public final String a() {
        return this.f438110c;
    }

    public a0(List<? extends User> r100) {
        Intrinsics.checkNotNullParameter(r100, "expectedBackgroundUserList");
        super(r100, 2);
        this.f438110c = "UpdateBackground";
    }
}
