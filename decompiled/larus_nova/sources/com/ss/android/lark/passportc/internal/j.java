package com.ss.android.lark.passportc.internal;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class j implements p {
    @Inject
    public j() {
    }

    @Override // com.ss.android.lark.passportc.internal.p
    public final User a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        User r101 = new User();
        r101.userId = r100;
        return r101;
    }
}
