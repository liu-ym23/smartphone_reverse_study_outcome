package com.larus.live.impl.ttlivesdk;

import com.bytedance.android.livehostapi.platform.LiveHostUser;
import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.provider.IThirdPartyPlatformLoginProvider;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class g extends LiveHostUser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<UserChangedCallback> f355845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f355846b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livehostapi.platform.LiveHostUser, com.bytedance.android.livehostapi.hostdefault.HostUserDefault, com.bytedance.android.livehostapi.platform.IMiddlewareHostUser
    public final long hostUserId() {
        ILoginService r100 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r100 == null) goto L11;
        q38.a r101 = r100.getAccountInfo();
        if (r101 == null) goto L11;
        String r102 = r101.f531530c;
        if (r102 == null) goto L11;
        Long r103 = StringsKt.toLongOrNull(r102);
        if (r103 == null) goto L11;
        return r103.longValue();
    L11:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.live.impl.ttlivesdk.e] */
    public g() {
        this.f355845a = new CopyOnWriteArrayList();
        this.f355846b = "";
        Iterator r100 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((IThirdPartyPlatformLoginProvider) r101).c() != LoginPlatform.DOUYIN) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        IThirdPartyPlatformLoginProvider r103 = (IThirdPartyPlatformLoginProvider) r101;
        if (r103 == 0) goto L21;
        r103.r(new e(this));
        return;
    L21:
        return;
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final void c(boolean r100) {
        Iterator<T> r101 = this.f355845a.iterator();
    L4:
        if (r101.hasNext() == false) goto L18;
        UserChangedCallback r102 = (UserChangedCallback) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        r102.onUserChanged(r100);     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L4;
        r105.printStackTrace();
        FLogger.f375446a.e("ECommerce_HostUser", "onUserChanged crash " + r105.getMessage());
        AppHost.Companion r106 = AppHost.f326268a;
        if (r106.isTestChannel() == true) goto L17;
        if (r106.isDebugChannel() == false) goto L4;
    L17:
        throw r105;
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.bytedance.android.livehostapi.platform.LiveHostUser, com.bytedance.android.livehostapi.hostdefault.HostUserDefault, com.bytedance.android.livehostapi.platform.IHostUser, com.bytedance.android.livehostapi.platform.IMiddlewareHostUser
    public final void registerCurrentUserUpdateListener(UserChangedCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f355845a.add(r100);
    }

    @Override // com.bytedance.android.livehostapi.platform.LiveHostUser, com.bytedance.android.livehostapi.hostdefault.HostUserDefault, com.bytedance.android.livehostapi.platform.IHostUser, com.bytedance.android.livehostapi.platform.IMiddlewareHostUser
    public final void unRegisterCurrentUserUpdateListener(UserChangedCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f355845a.remove(r100);
    }
}
