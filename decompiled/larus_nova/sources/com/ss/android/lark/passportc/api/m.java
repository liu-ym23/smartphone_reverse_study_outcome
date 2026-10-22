package com.ss.android.lark.passportc.api;

import com.bytedance.ee.bear.middleground.unbundle.BenefitManagerImpl;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
public interface m {
    void a(Function1<? super f0c.h, Unit> r100);

    void b(BenefitManagerImpl.b r100);

    void c(o r100);

    void d(o r100);

    UserSession getSession();

    f0c.h getState();

    User getUser();
}
