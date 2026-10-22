package com.bytedance.supervisor.runtime.config;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.supervisor.runtime.common.Logger;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.token.TokenConfig;
import com.bytedance.supervisor.token.TokenConfigList;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kf7.e;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nf7.c;
import nf7.d;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f270341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, TokenConfig> f270342b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f270343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f270344d;

    public b() {
    }

    static {
        f270342b = new ConcurrentHashMap();
        f270343c = "Unknown";
        f270344d = "";
    }

    public static final String a(Context r100) {
        String r101 = "";
        Logger.c("TokenConfigManager", "getLocalCache start");
        d.a("TokenConfigManager", "getLocalCache start");
        boolean r102 = true;
        if (f270344d.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        Logger.c("TokenConfigManager", Intrinsics.stringPlus("getLocalCache from localConfig: ", f270344d));
        return f270344d;
    L8:
        int r104 = c.f518961a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("token_config_cache", "fileName");
        lf7.b r105 = lf7.d.f509087a;     // Catch: Exception -> L18
        if (r105 != null) goto L12;
        e r106 = null;
    L13:
        if (r106 == null) goto L23;
        String r107 = r106.a(r100);     // Catch: Exception -> L18
        if (r107 == null) goto L23;
    L24:
        Logger.c("TokenConfigManager", Intrinsics.stringPlus("getLocalCache from data cache: ", r107));
        if (r107.length() != 0) goto L27;
        boolean r108 = true;
    L28:
        if (r108 == false) goto L57;
        int r109 = c.f518961a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        StringBuilder r110 = new StringBuilder();
        Logger.c("TokenConfigManager", "onReadAssetContent ----->");     // Catch: Throwable -> L44
        d.a("TokenConfigManager", "onReadAssetContent ----->");     // Catch: Throwable -> L44
        int r111 = nf7.a.f518959a;     // Catch: Throwable -> L44
        lf7.b r112 = lf7.d.f509087a;     // Catch: Throwable -> L44
        if (r112 != null) goto L33;
        boolean r113 = false;
    L34:
        if (r113 == false) goto L36;
        InputStream r114 = r100.getApplicationContext().getResources().getAssets().open("sensitive_api_config_boe");     // Catch: Throwable -> L44
    L37:
        BufferedReader r115 = new BufferedReader(new InputStreamReader(r114));     // Catch: Throwable -> L44
    L38:
        String r116 = r115.readLine();     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(r116) == true) goto L41;
        r110.append(r116);     // Catch: Throwable -> L44
    L41:
        if (r116 != null) goto L38;
        r115.close();     // Catch: Throwable -> L44
        r114.close();     // Catch: Throwable -> L44
        int r117 = Logger.f270338a;     // Catch: Throwable -> L44
        Logger.c("TokenConfigManager", Intrinsics.stringPlus("result = ", r110));     // Catch: Throwable -> L44
    L50:
        String r118 = r110.toString();
        if (r118.length() > 0) goto L54;
        r102 = false;
    L54:
        if (r102 == false) goto L56;
        f270343c = "builtin";
    L56:
        Logger.c("TokenConfigManager", Intrinsics.stringPlus("getLocalCache from assets: ", r118));
        return r118;
    L36:
        r114 = r100.getApplicationContext().getResources().getAssets().open("sensitive_api_config");     // Catch: Throwable -> L44
        goto L37
    L33:
        r113 = r112.f509073g;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        int r119 = Logger.f270338a;
        Logger.b("TokenConfigManager", Intrinsics.stringPlus("onReadPluginAssetContent failed, error: ", th.getMessage()));
        int r120 = d.f518962a;
        String r121 = th.getMessage();
        if (r121 == null) goto L49;
        r101 = r121;
    L49:
        d.b("read_builtin_data", r101, null);
        goto L50
    L57:
        f270343c = "local";
        return r107;
    L27:
        r108 = false;
    L23:
        r107 = "";
        goto L24
    L12:
        r106 = r105.f509068b;     // Catch: Exception -> L18
    L18:
        e = move-exception;
        int r122 = Logger.f270338a;
        Logger.b("file", e.getMessage());
        int r123 = d.f518962a;
        String r124 = e.getMessage();
        if (r124 != null) goto L22;
        r124 = "";
    L22:
        d.b("read_local_data", r124, null);
        goto L23
    L5:
        r103 = false;
        goto L6
    }

    public static final void b(String r100) {
        int r101 = Logger.f270338a;
        Logger.c("TokenConfigManager", Intrinsics.stringPlus("parseConfig start: ", r100));
        f270342b.clear();
        List<TokenConfig> r102 = ((TokenConfigList) new Gson().fromJson(r100, TokenConfigList.class)).getConfigList();     // Catch: Exception -> L8
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));     // Catch: Exception -> L8
        Iterator<T> r104 = r102.iterator();     // Catch: Exception -> L8
    L5:
        if (r104.hasNext() == false) goto L15;
        TokenConfig r105 = (TokenConfig) r104.next();     // Catch: Exception -> L8
        int r106 = Logger.f270338a;     // Catch: Exception -> L8
        Logger.c("TokenConfigManager", "parseConfig: " + r105.getIdentifier() + ':' + r105);     // Catch: Exception -> L8
        r103.add(f270342b.put(r105.getIdentifier(), r105));     // Catch: Exception -> L8
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        int r107 = d.f518962a;
        d.b("parse_data", Intrinsics.stringPlus("parseConfig: ", e.getMessage()), r100);
        int r108 = Logger.f270338a;
        Logger.b("TokenConfigManager", Intrinsics.stringPlus("e:", e.getMessage()));
    }

    public static List c(Token r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        TokenConfig r101 = f270342b.get(r100.getIdentifier());
        if (r101 != null) goto L5;
        List<String> r102 = null;
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r102 = r101.getAtomicInfoList();
        goto L6
    }

    public static void d(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        r100.registerActivityLifecycleCallbacks(new a(r100));
    }
}
