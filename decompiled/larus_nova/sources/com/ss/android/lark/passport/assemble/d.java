package com.ss.android.lark.passport.assemble;

import com.ss.android.lark.passport.signinsdk_api.account.TenantInfo;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport_user.api.IUserListService;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class d implements yzb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IUserListService f437694a;

    @Override // yzb.b
    public final String c() {
        User r100 = this.f437694a.getForegroundUser();
        if (r100 == null) goto L6;
        String r101 = r100.userId;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // yzb.b
    public final List<User> getAllValidUserList() {
        return this.f437694a.getAllValidUserList();
    }

    @Override // yzb.b
    public final User getForegroundUser() {
        return this.f437694a.getForegroundUser();
    }

    @Override // yzb.b
    public final String d() {
        User r100 = getForegroundUser();
        if (r100 == null) goto L6;
        String r101 = r100.userId;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // yzb.b
    public final boolean isLogin() {
        if (getForegroundUser() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Inject
    public d(IUserListService r100) {
        Intrinsics.checkNotNullParameter(r100, "userListService");
        this.f437694a = r100;
    }

    @Override // yzb.b
    public final User a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        l r101 = this.f437694a.s(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f437705a;
    }

    @Override // yzb.b
    public final TenantInfo b(User r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        return new TenantInfo();
    }
}
