package com.bytedance.sdk.account.settings.common;

import com.bytedance.sdk.account.impl.z;
import com.ss.android.account.k;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import wqa.f;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<a> f269410a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JSONObject f269411b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f269412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f269413b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f269414c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TokenShareMatcher f269415d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<String> f269416e;

        public a(boolean r100, boolean r101, String r102, TokenShareMatcher r103, List<String> r104) {
            this.f269412a = r100;
            this.f269413b = r101;
            this.f269414c = r102;
            this.f269415d = r103;
            this.f269416e = r104;
        }
    }

    static {
        f269410a = new AtomicReference();
    }

    public static a a() {
        f r100 = k.f406318b;
        if (r100 == null) goto L8;
        JSONObject r101 = z.a(r100.getApplicationContext()).getAccountSettingsConfig();
        if (r101 == null) goto L8;
        JSONObject r102 = r101.optJSONObject("share_token_config");
    L10:
        if (r102 == f269411b) goto L29;
        f269411b = r102;
        if (r102 != null) goto L32;
        f269410a.set(null);
        tb7.a.a("ShareTokenCfgMgr", "share_token_config is null, clear snapshot");
        goto L29
    L32:
        ShareTokenConfigParser.c r103 = ShareTokenConfigParser.a(r102);     // Catch: Throwable -> L26
        TokenShareMatcher r104 = TokenShareMatcher.a(r103);     // Catch: Throwable -> L18
    L20:
        boolean r110 = r103.f269347a;     // Catch: Throwable -> L26
        boolean r111 = r103.f269348b;     // Catch: Throwable -> L26
        String r112 = r103.f269349c;     // Catch: Throwable -> L26
        f269410a.set(new a(r110, r111, r112, r104, r103.f269354h));     // Catch: Throwable -> L26
        StringBuilder r105 = new StringBuilder("share_token_config updated, enable=");     // Catch: Throwable -> L26
        r105.append(r110);     // Catch: Throwable -> L26
        r105.append(", shadow=");     // Catch: Throwable -> L26
        r105.append(r111);     // Catch: Throwable -> L26
        r105.append(", version=");     // Catch: Throwable -> L26
        r105.append(r112);     // Catch: Throwable -> L26
        r105.append(", hasMatcher=");     // Catch: Throwable -> L26
        if (r104 == null) goto L23;
        boolean r106 = true;
    L24:
        r105.append(r106);     // Catch: Throwable -> L26
        tb7.a.a("ShareTokenCfgMgr", r105.toString());     // Catch: Throwable -> L26
        goto L29
    L23:
        r106 = false;
        goto L24
    L18:
        th = move-exception;
        tb7.a.c("ShareTokenCfgMgr", "build TokenShareMatcher failed", th);     // Catch: Throwable -> L26
        r104 = null;
    L26:
        th = move-exception;
        tb7.a.c("ShareTokenCfgMgr", "parse share_token_config failed", th);
        f269410a.set(null);
    L29:
        return f269410a.get();
    L8:
        r102 = null;
        goto L10
    }
}
