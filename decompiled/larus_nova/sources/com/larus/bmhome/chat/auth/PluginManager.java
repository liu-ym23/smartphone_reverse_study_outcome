package com.larus.bmhome.chat.auth;

import com.larus.platform.service.AccountService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class PluginManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, PluginManager> f297302d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f297303e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final PluginAuthRepository f297304f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PluginItemPagingCache f297305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f297306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0 f297307c;

    public static final class a {
        public static PluginManager a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "botId");
            ConcurrentHashMap<String, PluginManager> r101 = PluginManager.f297302d;
            StringBuilder r102 = new StringBuilder();
            AccountService r103 = AccountService.f365697a;
            r102.append(r103.getUserId());
            r102.append('_');
            r102.append(r100);
            PluginManager r104 = r101.get(r102.toString());
            if (r104 != null) goto L6;
            PluginManager r105 = new PluginManager(r100);
            r101.put(r103.getUserId() + '_' + r100, r105);
            return r105;
        L6:
            return r104;
        }
    }

    static {
        f297302d = new ConcurrentHashMap();
        f297303e = new ConcurrentHashMap();
        f297304f = new PluginAuthRepository();
    }

    public PluginManager(String r100) {
        this.f297305a = new PluginItemPagingCache(r100, new PluginManager$cache$1(f297304f));
        this.f297306b = new b(r100);
        this.f297307c = new n0();
    }
}
