package com.larus.home.impl.sdk;

import com.larus.account.base.model.AuthorizationPlatform;
import com.larus.account.base.provider.IThirdPartyPlatformAuthorizationProvider;
import com.larus.platform.api.IFlowOfficeAuthService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J \u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00132\u0006\u0010\u0010\u001a\u00020\u000eH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/larus/home/impl/sdk/OfficeAuthServiceImpl;", "Lcom/larus/platform/api/IFlowOfficeAuthService;", "<init>", "()V", "authorizationProvider", "Lcom/larus/account/base/provider/IThirdPartyPlatformAuthorizationProvider;", "getAuthorizationProvider", "()Lcom/larus/account/base/provider/IThirdPartyPlatformAuthorizationProvider;", "authorizationProvider$delegate", "Lkotlin/Lazy;", "isLarkPlatform", "", "getAuthorizationHeader", "", "", com.alipay.sdk.m.p.e.f25671s, "url", "getAuthorizationHeaderFromNet", "getTicketAndSignature", "Lkotlin/Pair;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeAuthServiceImpl implements IFlowOfficeAuthService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OfficeAuthServiceImpl f346128a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f346129b = null;

    private OfficeAuthServiceImpl() {
    }

    static {
        f346128a = new OfficeAuthServiceImpl();
        f346129b = LazyKt.lazy(new u0());
    }

    public final boolean d() {
        IThirdPartyPlatformAuthorizationProvider r100 = (IThirdPartyPlatformAuthorizationProvider) f346129b.getValue();
        if (r100 == null) goto L5;
        AuthorizationPlatform r101 = r100.c();
    L7:
        if (r101 != AuthorizationPlatform.LARK) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public final Map<String, String> b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        IThirdPartyPlatformAuthorizationProvider r101 = (IThirdPartyPlatformAuthorizationProvider) f346129b.getValue();
        if (r101 == null) goto L7;
        Map<String, String> r102 = r101.b(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return MapsKt.emptyMap();
    }

    public final Pair<String, String> c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        IThirdPartyPlatformAuthorizationProvider r101 = (IThirdPartyPlatformAuthorizationProvider) f346129b.getValue();
        if (r101 == null) goto L7;
        Pair<String, String> r102 = r101.f(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return TuplesKt.to(null, null);
    }

    public final Map<String, String> a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "url");
        IThirdPartyPlatformAuthorizationProvider r102 = (IThirdPartyPlatformAuthorizationProvider) f346129b.getValue();
        if (r102 == null) goto L7;
        Map<String, String> r103 = IThirdPartyPlatformAuthorizationProvider.a.a(r102, r100, r101, 12);
        if (r103 == null) goto L7;
        return r103;
    L7:
        return MapsKt.emptyMap();
    }
}
