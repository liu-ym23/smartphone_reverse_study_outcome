package com.bytedance.awemeopen.domain.user;

import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.bizmodels.user.j;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements com.bytedance.awemeopen.bizmodels.user.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f198487a;

    @Override // com.bytedance.awemeopen.bizmodels.user.h
    public final void c() {
        int r100 = c.f198483d;
        AoLogger.g("RefreshUserInfoProcessHelper", new Object[]{"autoLoginFetchUserInfoByAccessToken(),userInfoSource callback==tokenInvalid"});
        j r101 = this.f198487a;
        if (r101 == null) goto L6;
        r101.onFail(new RuntimeException("tokenInvalid"));
        return;
    }

    public d(e r100) {
        this.f198487a = r100;
    }

    @Override // com.bytedance.awemeopen.bizmodels.user.h
    public final void a(User r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        int r101 = c.f198483d;
        AoLogger.g("RefreshUserInfoProcessHelper", new Object[]{"autoLoginFetchUserInfoByAccessToken(),userInfoSource callback==success,save login info"});
        j r102 = this.f198487a;
        if (r102 == null) goto L6;
        r102.a(new com.bytedance.awemeopen.bizmodels.user.i(r100.t(), r100.a()));
        return;
    }

    @Override // com.bytedance.awemeopen.bizmodels.user.h
    public final void b(Exception r100) {
        int r101 = c.f198483d;
        AoLogger.g("RefreshUserInfoProcessHelper", new Object[]{"autoLoginFetchUserInfoByAccessToken(),userInfoSource callback==fail"});
        j r102 = this.f198487a;
        if (r102 == null) goto L6;
        r102.onFail(r100);
        return;
    }
}
