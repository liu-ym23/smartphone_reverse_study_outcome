package com.larus.caijing_pay.impl.config;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService;
import com.larus.platform.service.AccountService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xc4.a;
import xc4.b;
import xc4.c;
import xc4.d;
import xc4.e;
import xc4.f;
import xc4.g;
import xc4.h;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/caijing_pay/impl/config/CJAccountServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/account/CJAccountService;", "<init>", "()V", "getHostCurrentUserInfo", "Lcom/bytedance/caijing/sdk/infra/base/api/account/HostUserInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJAccountServiceImpl implements CJAccountService {
    public CJAccountServiceImpl() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public String getUserId() {
        return null;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public boolean isTTTokenInit() {
        return true;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public f getHostCurrentUserInfo() {
        AccountService r100 = AccountService.f365697a;
        String r101 = r100.getUserId();
        String r102 = r100.getNickname();
        String r103 = r100.getSecUserId();
        String r104 = r100.B();
        String r105 = r100.s();
        if (r105 != null) goto L6;
        r105 = "";
    L6:
        return new f(r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public List<String> allUidList() {
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public List<String> switchAccountNeedKeepActivitys() {
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public void addHostAccountKickOutHandler(c r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public void addHostLoginStatusChangeListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public void addTokenInitListener(h r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public void removeHostAccountKickOutHandler(c r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public void removeHostLoginStatusChangeListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public void getLatestUserInfoOpt(Function1<? super f, Unit> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onSuc");
        Intrinsics.checkNotNullParameter(r101, "onFail");
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public void queryShareAccount(String r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "accountType");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public void showSwitchAccount(Activity r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public void hostShowLogin(Activity r100, b r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.account.CJAccountService
    public void showSwitchAccount(LifecycleOwner r100, String r101, a r102, g r103) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter(r103, "callback");
    }
}
