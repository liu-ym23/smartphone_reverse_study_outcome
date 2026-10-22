package com.larus.account.base.provider;

import com.alipay.sdk.m.p.e;
import com.larus.account.base.model.AuthorizationPlatform;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J8\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\nH&J\b\u0010\u0011\u001a\u00020\nH&J\b\u0010\u0012\u001a\u00020\nH&J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nH&J\b\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018H&J \u0010\u0019\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001a2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u001b"}, d2 = {"Lcom/larus/account/base/provider/IThirdPartyPlatformAuthorizationProvider;", "", "init", "", "refreshToken", "setDPopGenerator", "generator", "Lcom/larus/account/base/provider/IDPopGenerator;", "getAuthorizationHeader", "", "", e.f25671s, "url", "whiteCheck", "", "checkMainThread", "getAuthorizationHeaderFromNet", "getLarkAccessToken", "getLarkAuthSchema", "needIntercept", "host", "providePlatform", "Lcom/larus/account/base/model/AuthorizationPlatform;", "getLarkHostList", "", "getTicketAndSignature", "Lkotlin/Pair;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IThirdPartyPlatformAuthorizationProvider {

    public static final class a {
        public static /* synthetic */ Map a(IThirdPartyPlatformAuthorizationProvider r100, String r101, String r102, int r103) {
            if ((r103 & 8) == 0) goto L5;
            boolean r104 = true;
        L7:
            return r100.g(r101, r102, false, r104);
        L5:
            r104 = false;
            goto L7
        }
    }

    List<String> a();

    Map<String, String> b(String r100);

    AuthorizationPlatform c();

    String d();

    String e();

    Pair<String, String> f(String r100);

    Map<String, String> g(String r100, String r101, boolean r102, boolean r103);

    void init();
}
