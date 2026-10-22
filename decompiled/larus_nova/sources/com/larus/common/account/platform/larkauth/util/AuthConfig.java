package com.larus.common.account.platform.larkauth.util;

import a09.e;
import a09.f;
import a09.g;
import android.net.Uri;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.common.account.platform.larkauth.model.AuthorizationModel;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import xp9.p;
import zz8.d;

/* JADX INFO: loaded from: classes4.dex */
public final class AuthConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AuthConfig f326151a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f326152b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f326153c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f326154d = null;

    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/common/account/platform/larkauth/util/AuthConfig$refreshHostList$hostList$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "larkauth_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    public AuthConfig() {
    }

    static {
        f326151a = new AuthConfig();
        f326152b = LazyKt.lazy(new com.larus.common.account.platform.larkauth.util.a());
        f326153c = LazyKt.lazy(new b());
        List<String> r100 = d.f574109a;
        f326154d = CollectionsKt.toMutableList(d.f574109a);
    }

    public static List a() {
        ArrayList r100 = new ArrayList();
        r100.add("workspace-ws77bf30fc029e0f87-http-8080.ide.byted.org");
        r100.add("workspace-ws2b6f31a3eaba5c9d-http-8080.ide.byted.org");
        if (AppHost.f326268a.isDebug() == false) goto L17;
        String r101 = ((Keva) f326153c.getValue()).getString("doc_host", "");
        FLogger r102 = FLogger.f375446a;
        r102.i("AuthConfig", "Doc debug host: " + r101);
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L15
        if (StringsKt.contains$default(r101, "http", false, 2, null) == false) goto L8;
        String r103 = r101;
    L9:
        Uri r104 = UriProtector.parse(r103);     // Catch: Exception -> L15
        if (r104 == null) goto L17;
        String r105 = r104.getHost();     // Catch: Exception -> L15
        if (r105 == null) goto L17;
        r102.i("AuthConfig", "Get doc host: ".concat(r105));     // Catch: Exception -> L15
        r100.add(r105);     // Catch: Exception -> L15
        goto L17
    L8:
        r103 = "http://" + r101;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        FLogger.f375446a.e("AuthConfig", "getHostFromUrl fail, url: " + r101, e);
    L17:
        return r100;
    }

    public final Object b(Continuation<? super Unit> r110) {
        if ((r110 instanceof AuthConfig$refreshHostList$1) == false) goto L7;
        AuthConfig$refreshHostList$1 r100 = (AuthConfig$refreshHostList$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        String r112 = "";
        Boolean r113 = null;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L55:
        String r114 = (String) r111;
        if (r114 == null) goto L58;
        Intrinsics.checkNotNullParameter(r114, "res");
        e r105 = (e) new Gson().fromJson(r114, e.class);     // Catch: Exception -> L80
        if (r105.a() == 0) goto L63;
    L82:
        Pair r106 = null;
    L83:
        if (r106 == null) goto L85;
        List r107 = (List) r106.getFirst();
    L86:
        if (r106 == null) goto L88;
        String r108 = (String) r106.getSecond();
    L90:
        if (o0.d(r108) == false) goto L104;
        FLogger.f375446a.i("AuthConfig", "get share domain from net=" + r108);
        String r109 = p.f564779a;
        if (r108 != null) goto L94;
        String r115 = "";
    L95:
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        p.f564779a = r115;
        Keva r116 = (Keva) f326152b.getValue();     // Catch: Exception -> L102
        if (r108 == null) goto L100;
        r112 = r108;
    L100:
        r116.storeString("key_share_domain", r112);     // Catch: Exception -> L102
    L102:
        e = move-exception;
        FLogger.f375446a.e("AuthConfig", "refreshHostList error e=" + e.getMessage());
        goto L104
    L94:
        r115 = r108;
    L104:
        FLogger r117 = FLogger.f375446a;
        StringBuilder r118 = new StringBuilder("Host list is empty: ");
        if (r107 == null) goto L107;
        r113 = Boxing.boxBoolean(!r107.isEmpty());
    L107:
        r118.append(r113);
        r117.i("AuthConfig", r118.toString());
        if (r107 != null) goto L110;
    L112:
        if (r104 == false) goto L128;
        List<String> r119 = f326154d;
        r119.clear();
        r119.addAll(r107);
        r119.addAll(a());
        ((Keva) f326152b.getValue()).storeString("key_authorization_host", new Gson().toJson(r119));     // Catch: Exception -> L116
    L116:
        e = move-exception;
        FLogger.f375446a.e("AuthConfig", "refreshHostList error e=" + e.getMessage());
    L128:
        ((Keva) f326152b.getValue()).storeString("domains_all", f.b(r114));     // Catch: Exception -> L120
    L123:
        return Unit.INSTANCE;
    L120:
        e = move-exception;
        FLogger.f375446a.e("AuthConfig", "refreshHostList KEY_DOMAINS_ALL error e=" + e.getMessage());
        goto L123
    L110:
        if ((!r107.isEmpty()) != true) goto L112;
        r104 = true;
        goto L112
    L88:
        r108 = null;
        goto L90
    L85:
        r107 = null;
        goto L86
    L63:
        if (Intrinsics.areEqual(r105.c(), "success") == false) goto L82;
        a09.d r120 = r105.b();     // Catch: Exception -> L80
        if (r120 == null) goto L71;
        a09.b r121 = r120.a();     // Catch: Exception -> L80
        if (r121 == null) goto L71;
        List<String> r122 = r121.a();     // Catch: Exception -> L80
        if (r122 == null) goto L71;
        List r123 = CollectionsKt.filterNotNull(r122);     // Catch: Exception -> L80
    L72:
        a09.d r124 = r105.b();     // Catch: Exception -> L80
        if (r124 == null) goto L77;
        g r125 = r124.b();     // Catch: Exception -> L80
        if (r125 == null) goto L77;
        String r126 = r125.a();     // Catch: Exception -> L80
    L78:
        r106 = new Pair(r123, r126);     // Catch: Exception -> L80
    L77:
        r126 = null;
    L71:
        r123 = null;
    L80:
        e = move-exception;
        e.printStackTrace();
        goto L82
    L58:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        String r127 = ((Keva) f326152b.getValue()).getString("key_authorization_host", "");
        Intrinsics.checkNotNull(r127);
        if (r127.length() <= 0) goto L17;
        boolean r128 = true;
    L18:
        if (r128 == true) goto L126;
    L42:
        f326154d.addAll(a());
        String r129 = ((Keva) f326152b.getValue()).getString("key_share_domain", "");
        Intrinsics.checkNotNull(r129);
        if (r129.length() <= 0) goto L45;
        boolean r130 = true;
    L46:
        if (r130 == false) goto L48;
        FLogger.f375446a.i("AuthConfig", "get share domain from cache=".concat(r129));
        String r131 = p.f564779a;
        Intrinsics.checkNotNullParameter(r129, "<set-?>");
        p.f564779a = r129;
    L48:
        e10 r132 = e10.f368561a;
        if (e10.Z().getFetchDomainsAll() == true) goto L52;
        FLogger.f375446a.i("AuthConfig", "fetchDomainsAll false return");
        return Unit.INSTANCE;
    L52:
        AuthorizationModel r133 = AuthorizationModel.f326136a;
        r100.label = 1;
        r111 = r133.b(r100);
        if (r111 != r102) goto L55;
        return r102;
    L45:
        r130 = false;
        goto L46
    L126:
        Gson r134 = new Gson();     // Catch: Exception -> L40
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L22
        Object r136 = Result.m9449constructorimpl((List) r134.fromJson(r127, new a().getType()));     // Catch: Throwable -> L22
    L25:
        if (Result.m9455isFailureimpl(r136) == false) goto L27;
        r136 = null;
    L27:
        List r137 = (List) r136;     // Catch: Exception -> L40
        FLogger r138 = FLogger.f375446a;     // Catch: Exception -> L40
        StringBuilder r139 = new StringBuilder("get authorization host list from cache=");     // Catch: Exception -> L40
        if (r137 == null) goto L30;
        Integer r140 = Boxing.boxInt(r137.size());     // Catch: Exception -> L40
    L31:
        r139.append(r140);     // Catch: Exception -> L40
        r138.i("AuthConfig", r139.toString());     // Catch: Exception -> L40
        if (r137 != null) goto L34;
    L36:
        boolean r141 = false;
    L37:
        if (r141 == false) goto L42;
        List<String> r142 = f326154d;     // Catch: Exception -> L40
        r142.clear();     // Catch: Exception -> L40
        r142.addAll(r137);     // Catch: Exception -> L40
        goto L42
    L34:
        if ((!r137.isEmpty()) != true) goto L36;
        r141 = true;
        goto L37
    L30:
        r140 = null;
    L22:
        th = move-exception;
        Result.Companion r143 = Result.Companion;     // Catch: Exception -> L40
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L40
    L40:
        e = move-exception;
        FLogger.f375446a.e("AuthConfig", "refreshHostList error e=" + e.getMessage());
        goto L42
    L17:
        r128 = false;
    L7:
        r100 = new AuthConfig$refreshHostList$1(this, r110);
        goto L8
    }
}
