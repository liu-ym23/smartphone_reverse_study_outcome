package com.ss.android.lark.feed.molten;

import com.bytedance.lark.lark_biz_feed_android.f1;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import eeb.a;
import geb.c;
import javax.inject.Provider;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedMoltenModuleIncluded_ProvidesUserForegroundScopeFactory implements Factory<f1> {
    private final a module;
    private final Provider<UserSession> userSessionProvider;

    @Override // javax.inject.Provider
    public f1 get() {
        return providesUserForegroundScope(this.module, this.userSessionProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedMoltenModuleIncluded_ProvidesUserForegroundScopeFactory(a r100, Provider<UserSession> r101) {
        this.module = r100;
        this.userSessionProvider = r101;
    }

    public static FeedMoltenModuleIncluded_ProvidesUserForegroundScopeFactory create(a r100, Provider<UserSession> r101) {
        return new FeedMoltenModuleIncluded_ProvidesUserForegroundScopeFactory(r100, r101);
    }

    public static f1 providesUserForegroundScope(a r100, UserSession r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "userSession");
        ULong r102 = UStringsKt.toULongOrNull(r101.f438138b);
        if (r102 == null) goto L5;
        long r103 = r102.m9675unboximpl();
    L6:
        c.d("FeedMoltenModuleIncluded", "providesUserForegroundScope uid:" + r101.f438138b + ", userId: " + ULong.m9669toStringimpl(r103));
        return (f1) Preconditions.checkNotNullFromProvides(new f1(r103));
    L5:
        r103 = 0;
        goto L6
    }
}
