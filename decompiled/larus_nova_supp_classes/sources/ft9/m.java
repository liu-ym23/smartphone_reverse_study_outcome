package ft9;

import android.content.Context;
import android.util.Pair;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.news.common.settings.api.SettingsData;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import hq9.v2;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.c3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class m implements h37.b {
    public final Context a;

    public static final class a {
    }

    static {
    }

    @Override // h37.b
    public final h37.c request() {
        k.a.getClass();
        v2 r3 = k.k;
        JSONObject r4 = null;
        if (r3 == null) goto L5;
        k.a r5 = new k.a(r3, k.g.incrementAndGet());
    L6:
        h37.c r6 = new h37.c();
    L74:
        th = move-exception;
        FLogger.a.e("SettingsRequestServiceImpl", th.getMessage());
        return r6;
    L8:
        if (NetworkUtils.isNetworkAvailable(this.a) == true) goto L10;
        return r6;
    L10:
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L74
        String r8 = g.a;     // Catch: Throwable -> L74
        r7.append(g.a);     // Catch: Throwable -> L74
        r7.append("?app=1");     // Catch: Throwable -> L74
        r7.append("&aid=" + AppHost.a.getAppId());     // Catch: Throwable -> L74
        r7.append("&default=1");     // Catch: Throwable -> L74
        String r2 = r7.toString();     // Catch: Throwable -> L74
        if (r2.length() <= 0) goto L13;
        boolean r9 = true;
    L14:
        if (r9 == true) goto L16;
    L20:
        String r0 = a(r2);     // Catch: Throwable -> L74
        if (r0 != null) goto L23;
    L26:
        boolean r1 = true;
    L27:
        if (r1 == false) goto L33;
        if (r0 != null) goto L30;
        long r10 = 0;
    L31:
        b(r10);     // Catch: Throwable -> L74
        return r6;
    L30:
        r10 = 1;
        goto L31
    L33:
        JSONObject r11 = new JSONObject(r0);     // Catch: Throwable -> L74
        if ("success".equals(r11.optString("message")) == true) goto L37;
        b(2);     // Catch: Throwable -> L74
        return r6;
    L37:
        JSONObject r12 = r11.optJSONObject("data");     // Catch: Throwable -> L74
        if (r12 == null) goto L40;
        JSONObject r13 = r12.optJSONObject("settings");     // Catch: Throwable -> L74
    L41:
        if (r12 == null) goto L43;
        String r14 = r12.optString("ctx_infos");     // Catch: Throwable -> L74
    L45:
        if (k.f(r13, r5, r14) == false) goto L62;
        if (r5 == null) goto L48;
        v2 r15 = r5.a;     // Catch: Throwable -> L74
    L49:
        if (r15 == null) goto L62;
        Object r16 = g.c;     // Catch: Throwable -> L74
        monitor-enter(r16);     // Catch: Throwable -> L74
    L59:
        th = move-exception;
        throw th;     // Catch: Throwable -> L74
    L54:
        if (Intrinsics.areEqual(g.d, r15) == false) goto L56;
        g.d = null;     // Catch: Throwable -> L59
        g.e = false;     // Catch: Throwable -> L59
    L56:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L59
        monitor-exit(r16);     // Catch: Throwable -> L74
        goto L62
    L48:
        r15 = null;
    L62:
        if (r13 != null) goto L64;
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L74
    L65:
        k.j = r18;     // Catch: Throwable -> L74
        Iterator r19 = k.b.iterator();     // Catch: Throwable -> L74
    L67:
        if (r19.hasNext() == false) goto L69;
        ((Function1) r19.next()).invoke(r18);     // Catch: Throwable -> L74
        goto L67
    L69:
        SettingsData r20 = new SettingsData(r13, null);     // Catch: Throwable -> L74
        h37.c r21 = new h37.c();     // Catch: Throwable -> L74
        r21.b = r20;     // Catch: Throwable -> L74
        if (r12 == null) goto L72;
        r4 = r12.optJSONObject("vid_info");     // Catch: Throwable -> L74
    L72:
        r21.c = r4;     // Catch: Throwable -> L74
        r21.d = r14;     // Catch: Throwable -> L74
        r21.a = true;     // Catch: Throwable -> L74
        return r21;
    L64:
        r18 = r13;
        goto L65
    L43:
        r14 = null;
        goto L45
    L40:
        r13 = null;
        goto L41
    L23:
        if (r0.length() == 0) goto L26;
        r1 = false;
        goto L27
    L16:
        if (StringsKt.startsWith$default(r2, "https", false, 2, null) == true) goto L20;
        if (StringsKt.startsWith$default(r2, "http", false, 2, null) == false) goto L20;
        r2 = new Regex("http").replaceFirst(r2, "https");     // Catch: Throwable -> L74
        goto L20
    L13:
        r9 = false;
        goto L14
    L5:
        r5 = null;
        goto L6
    }

    public m() {
        this.a = AppHost.a.getApplication();
    }

    public final Context getContext() {
        return this.a;
    }

    public static void b(long r2) {
        e10 r0 = e10.a;
        if (e10.E0() == false) goto L5;
        long r1 = 1;
    L6:
        c3.g(Long.valueOf(r1), Long.valueOf(r2));
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final String a(String r6) {
        byte[] r1 = new byte[1];
        HashMap r2 = new HashMap();     // Catch: Throwable -> L5
        Pair r3 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new b());     // Catch: Throwable -> L5
        r2.put(r3.first, r3.second);     // Catch: Throwable -> L5
        NetworkClient.ReqContext r4 = new NetworkClient.ReqContext();     // Catch: Throwable -> L5
        r4.addCommonParams = true;     // Catch: Throwable -> L5
        r2.put("Content-Type", "application/json");     // Catch: Throwable -> L5
        return NetworkClient.getDefault().post(r6, r1, r2, r4);
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
