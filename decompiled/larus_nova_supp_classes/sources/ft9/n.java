package ft9;

import android.content.Context;
import android.util.Pair;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.model.SettingsRequestModel;
import com.bytedance.news.common.settings.api.request.RequestV3Service;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.settings.ObricSettingRequestDelegate;
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
public final class n implements RequestV3Service {
    public final Context a;

    public static final class a {
    }

    static {
    }

    public n() {
        this.a = AppHost.a.getApplication();
    }

    public final Context getContext() {
        return this.a;
    }

    public static String a(String r5) {
        byte[] r1 = new byte[1];
        HashMap r2 = new HashMap();     // Catch: Throwable -> L5
        Pair r3 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new b());     // Catch: Throwable -> L5
        r2.put(r3.first, r3.second);     // Catch: Throwable -> L5
        NetworkClient.ReqContext r4 = new NetworkClient.ReqContext();     // Catch: Throwable -> L5
        r4.addCommonParams = true;     // Catch: Throwable -> L5
        r2.put("Content-Type", "application/json");     // Catch: Throwable -> L5
        return NetworkClient.getDefault().post(r5, r1, r2, r4);
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
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

    @Override // com.bytedance.news.common.settings.api.request.RequestV3Service
    public final h37.c requestV3(SettingsRequestModel r10) {
        k.a.getClass();
        v2 r2 = k.k;
        JSONObject r3 = null;
        if (r2 == null) goto L5;
        k.a r4 = new k.a(r2, k.g.incrementAndGet());
    L6:
        h37.c r5 = new h37.c();
    L68:
        th = move-exception;
        FLogger.a.e("SettingsRequestServiceImpl", th.getMessage());     // Catch: Throwable -> L94
        if (r5.a == true) goto L106;
        ObricSettingRequestDelegate.b.a(r5);
        return r5;
    L106:
        return r5;
    L94:
        th = move-exception;
        if (r5.a == true) goto L98;
        ObricSettingRequestDelegate.b.a(r5);
    L98:
        throw th;
    L8:
        if (NetworkUtils.isNetworkAvailable(this.a) == false) goto L10;
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L68
        String r7 = g.a;     // Catch: Throwable -> L68
        r6.append(g.a);     // Catch: Throwable -> L68
        r6.append("?app=1");     // Catch: Throwable -> L68
        r6.append("&aid=" + AppHost.a.getAppId());     // Catch: Throwable -> L68
        r6.append("&default=1");     // Catch: Throwable -> L68
        String r1 = r6.toString();     // Catch: Throwable -> L68
        if (r1.length() <= 0) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == true) goto L19;
    L23:
        String r11 = a(r1);     // Catch: Throwable -> L68
        if (r11 != null) goto L26;
    L29:
        boolean r0 = true;
    L30:
        if (r0 == false) goto L39;
        if (r11 != null) goto L33;
        long r9 = 0;
    L34:
        b(r9);     // Catch: Throwable -> L68
        if (r5.a == true) goto L38;
        ObricSettingRequestDelegate.b.a(r5);
    L38:
        return r5;
    L33:
        r9 = 1;
        goto L34
    L39:
        JSONObject r12 = new JSONObject(r11);     // Catch: Throwable -> L68
        if ("success".equals(r12.optString("message")) == true) goto L46;
        b(2);     // Catch: Throwable -> L68
        if (r5.a == true) goto L45;
        ObricSettingRequestDelegate.b.a(r5);
    L45:
        return r5;
    L46:
        JSONObject r13 = r12.optJSONObject("data");     // Catch: Throwable -> L68
        if (r13 == null) goto L49;
        JSONObject r14 = r13.optJSONObject("settings");     // Catch: Throwable -> L68
    L50:
        if (r13 == null) goto L52;
        String r15 = r13.optString("ctx_infos");     // Catch: Throwable -> L68
    L54:
        if (k.f(r14, r4, r15) == false) goto L73;
        if (r4 == null) goto L57;
        v2 r16 = r4.a;     // Catch: Throwable -> L68
    L58:
        if (r16 == null) goto L73;
        Object r17 = g.c;     // Catch: Throwable -> L68
        monitor-enter(r17);     // Catch: Throwable -> L68
    L70:
        th = move-exception;
        throw th;     // Catch: Throwable -> L68
    L63:
        if (Intrinsics.areEqual(g.d, r16) == false) goto L65;
        g.d = null;     // Catch: Throwable -> L70
        g.e = false;     // Catch: Throwable -> L70
    L65:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L70
        monitor-exit(r17);     // Catch: Throwable -> L68
        goto L73
    L57:
        r16 = null;
    L73:
        if (r14 != null) goto L75;
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L68
    L76:
        k.j = r19;     // Catch: Throwable -> L68
        Iterator r20 = k.b.iterator();     // Catch: Throwable -> L68
    L78:
        if (r20.hasNext() == false) goto L80;
        ((Function1) r20.next()).invoke(r19);     // Catch: Throwable -> L68
        goto L78
    L80:
        JSONObject r21 = ObricSettingRequestDelegate.b.b(r14);     // Catch: Throwable -> L68
        if (r21 == null) goto L84;
        r14 = r21;
    L84:
        SettingsData r22 = new SettingsData(r14, null);     // Catch: Throwable -> L68
        h37.c r23 = new h37.c();     // Catch: Throwable -> L68
        r23.b = r22;     // Catch: Throwable -> L68
        if (r13 == null) goto L87;
        r3 = r13.optJSONObject("vid_info");     // Catch: Throwable -> L68
    L87:
        r23.c = r3;     // Catch: Throwable -> L68
        r23.d = r15;     // Catch: Throwable -> L68
        r23.a = true;     // Catch: Throwable -> L68
        return r23;
    L75:
        r19 = r14;
        goto L76
    L52:
        r15 = null;
        goto L54
    L49:
        r14 = null;
        goto L50
    L26:
        if (r11.length() == 0) goto L29;
        r0 = false;
        goto L30
    L19:
        if (StringsKt.startsWith$default(r1, "https", false, 2, null) == true) goto L23;
        if (StringsKt.startsWith$default(r1, "http", false, 2, null) == false) goto L23;
        r1 = new Regex("http").replaceFirst(r1, "https");     // Catch: Throwable -> L68
        goto L23
    L16:
        r8 = false;
        goto L17
    L10:
        if (r5.a == true) goto L12;
        ObricSettingRequestDelegate.b.a(r5);
    L12:
        return r5;
    L5:
        r4 = null;
        goto L6
    }
}
