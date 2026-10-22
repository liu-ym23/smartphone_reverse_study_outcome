package xm6;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.xbridge.ReadableMapImpl;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.common.utils.j;
import com.ss.android.ugc.aweme.poi.utils.Md5Utils;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, ConcurrentHashMap<String, String>> f564547a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, ConcurrentHashMap<String, ConcurrentHashMap<String, Object>>> f564548b = null;

    static {
        f564547a = new HashMap();
        f564548b = new HashMap();
    }

    @JvmStatic
    public static final String c() {
        StringBuilder r100 = new StringBuilder();
        String r101 = HostServiceUtilsKt.E().getDeviceId();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.append(r101);
        r100.append(System.currentTimeMillis());
        return Md5Utils.a(r100.toString());
    }

    public static JSONObject a(ConcurrentHashMap r100) {
        String r101 = (String) r100.get("extra");
        if (j.a(r101) == true) goto L10;
        JSONObject r102 = new JSONObject();
    L8:
        com.bytedance.locallife.common.utils.a.c(r102, "ad_entrance", r100.get("ad_entrance"));
        com.bytedance.locallife.common.utils.a.c(r102, "value", r100.get("creative_id"));
        com.bytedance.locallife.common.utils.a.c(r102, "group_id", r100.get("ad_groupid"));
        com.bytedance.locallife.common.utils.a.c(r102, "is_other_channel", r100.get("is_other_channel"));
        com.bytedance.locallife.common.utils.a.c(r102, "log_extra", r100.get("log_extra"));
        com.bytedance.locallife.common.utils.a.c(r102, com.bytedance.android.ec.core.event.a.KEY_AD_TYPE, r100.get(com.bytedance.android.ec.core.event.a.KEY_AD_TYPE));
        com.bytedance.locallife.common.utils.a.c(r102, "groupon_id", r100.get("groupon_id"));
        com.bytedance.locallife.common.utils.a.c(r102, "ad_extra_data", r100.get("ad_extra_data"));
        return r102;
    L10:
        Intrinsics.checkNotNull(r101);     // Catch: JSONException -> L6
        r102 = new JSONObject(r101);     // Catch: JSONException -> L6
    L6:
        r102 = new JSONObject();
        goto L8
    }

    public static String b(ConcurrentHashMap r100) {
        String r101 = (String) r100.get(BdpAppEventConstant.PARAMS_LIFE_EXTRA_INFO);     // Catch: Exception -> L15
        if (j.a(r101) == false) goto L6;
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L15
    L8:
        if (j.a(r102.optString("life_share_ext")) == false) goto L10;
        String r103 = r102.optString("life_share_ext");     // Catch: Exception -> L15
    L13:
        return r102.put("life_share_ext", kn6.a.a(r103)).toString();
    L10:
        r103 = (String) r100.get("life_share_ext");     // Catch: Exception -> L15
        if (r103 != null) goto L13;
        r103 = SliceInitService.DEFAULT_SWITCH;
        goto L13
    L6:
        r102 = new JSONObject();     // Catch: Exception -> L15
    L15:
        String r104 = (String) r100.get(BdpAppEventConstant.PARAMS_LIFE_EXTRA_INFO);
        if (r104 != null) goto L19;
        return SliceInitService.DEFAULT_SWITCH;
    L19:
        return r104;
    }

    @JvmStatic
    public static final synchronized boolean d(String r100, HashMap<String, String> r110) {
        monitor-enter(a.class);
        Intrinsics.checkNotNullParameter(r100, "sessionId");     // Catch: Throwable -> L17
        HashMap<String, ConcurrentHashMap<String, String>> r101 = f564547a;     // Catch: Throwable -> L17
        ConcurrentHashMap<String, String> r102 = r101.get(r100);     // Catch: Throwable -> L17
        if (r102 == null) goto L7;
        boolean r103 = true;
    L8:
        if (r110 != null) goto L11;
        monitor-exit(a.class);
        return r103;
    L11:
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L17
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L17
        r105.put("session_id", r100);     // Catch: Throwable -> L17
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L17
        EventCenter.enqueueEvent(new Event("poi_session_info_update", r104, new ReadableMapImpl(r105)));     // Catch: Throwable -> L17
        r110.toString();     // Catch: Throwable -> L17
        if (r102 != null) goto L14;
        r101.put(r100, b.a(r110));     // Catch: Throwable -> L17
    L15:
        monitor-exit(a.class);
        return r103;
    L14:
        b.b(r102, r110);     // Catch: Throwable -> L17
        goto L15
    L7:
        r103 = false;
    L17:
        th = move-exception;
        throw th;
    }
}
