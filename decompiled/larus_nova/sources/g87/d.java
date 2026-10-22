package g87;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.PowerManager;
import android.text.TextUtils;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.log.ILogger;
import com.bytedance.push.utils.k;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.message.util.ToolUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import v67.r;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f480427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f480428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ILogger f480429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v67.e f480430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f480431e;

    public class a extends k<String> {
        public a() {
        }

        @Override // com.bytedance.push.utils.k
        public final String create(Object[] r100) {
            return UUID.randomUUID().toString();
        }
    }

    public final boolean c() {
        Intent r100 = PushCommonSupport.getInstance().getIPushCommonConfiguration().registerReceiver(this.f480427a, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Exception -> L11
        if (r100 == null) goto L9;
        if (r100.getIntExtra("plugged", -1) != 2) goto L9;
        return true;
    L9:
        return false;
    L15:
        return true;
    }

    public final String b() {
        String r100 = ToolUtils.getCurProcessName(this.f480427a);
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.contains(":") == true) goto L8;
        return "";
    L8:
        return "_" + r100.split(":")[1];
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public final void d(boolean r210) {
        String r100 = "fg_duration";
        int r101 = 0;
        SharedPreferences r102 = this.f480427a.getSharedPreferences("ttpush_statistics_" + ToolUtils.getCurProcessName(this.f480427a), 0);
        r r103 = (r) rgc.b.a(r.class);
        SharedPreferences.Editor r104 = r102.edit();
        Map<String, ?> r105 = r102.getAll();
        if (r105 != null) goto L5;
        return;
    L5:
        String r106 = b();
        Iterator<Map.Entry<String, ?>> r107 = r105.entrySet().iterator();
    L7:
        if (r107.hasNext() == false) goto L59;
        Map.Entry<String, ?> r108 = r107.next();
        String r110 = r108.getKey();     // Catch: Exception -> L55
        if (r110 == null) goto L86;
        if (r110.startsWith("push_stats_") == false) goto L54;
        Object r109 = r108.getValue();     // Catch: Exception -> L55
        if ((r109 instanceof String) == false) goto L53;
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L55
        JSONObject r112 = new JSONObject((String) r109);     // Catch: Exception -> L55
        String r113 = r112.optString(AppbrandHostConstants.SCHEMA_INSPECT.SESSION);     // Catch: Exception -> L55
        if (TextUtils.isEmpty(r113) == true) goto L7;
        if (r210 == true) goto L23;
        if (TextUtils.equals(r113, this.f480428b.get(new Object[r101])) == true) goto L7;
    L23:
        long r114 = r112.optLong("bg_duration");     // Catch: Exception -> L55
        SharedPreferences.Editor r115 = r104;
        long r116 = r112.optLong(r100);     // Catch: Exception -> L51
        r111.put("bg_duration", r114);     // Catch: Exception -> L51
        r111.put(r100, r116);     // Catch: Exception -> L51
        Iterator<Map.Entry<String, ?>> r117 = r107;
        String r118 = r100;
        this.f480429c.d("push_proc_stat", "save to monitor: " + r112);     // Catch: Exception -> L46
        r101 = 0;
        r103.monitorStatusAndDuration("push_alive_stats" + r106, 0, r111, r112);     // Catch: Exception -> L44
        SharedPreferences.Editor r119 = r115;
        r119.remove(r110);     // Catch: Exception -> L42
        if (this.f480430d == null) goto L41;
        JSONObject r120 = new JSONObject();     // Catch: Exception -> L42
        r120.put("process", ToolUtils.getCurProcessName(this.f480427a));     // Catch: Exception -> L42
        r120.put(AppbrandHostConstants.SCHEMA_INSPECT.SESSION, r113);     // Catch: Exception -> L42
        r111.put("bg_duration", r114);     // Catch: Exception -> L42
        String r121 = r118;
        r111.put(r121, r116);     // Catch: Exception -> L39
        ((n67.c) this.f480430d).b("pushsdk_alive_stats", r120);     // Catch: Exception -> L39
    L58:
        r104 = r119;
        r100 = r121;
        r107 = r117;
    L39:
        e = e;
    L57:
        e.printStackTrace();
        goto L58
    L41:
        r121 = r118;
    L42:
        e = e;
    L43:
        r121 = r118;
    L44:
        e = e;
        r119 = r115;
    L46:
        e = e;
        r119 = r115;
        r121 = r118;
        r101 = 0;
    L51:
        e = e;
        r117 = r107;
        r101 = 0;
        r121 = r100;
        r119 = r115;
        goto L57
    L53:
        r117 = r107;
        r121 = r100;
        r119 = r104;
        goto L58
    L54:
        return;
    L86:
        return;
    L55:
        e = e;
        r117 = r107;
        r121 = r100;
        r119 = r104;
        goto L57
    L59:
        r104.apply();
    }

    public static void a(d r110, g87.a r111) {
        r110.getClass();
        if (TextUtils.isEmpty(r110.b()) == true) goto L38;
        boolean r100 = true;
        if (((r111.f480412c - r111.f480411b) - r111.f480416g) <= TimeUnit.SECONDS.toMillis(5)) goto L9;
        boolean r101 = true;
    L11:
        if (r101 == false) goto L27;
        r r102 = (r) rgc.b.a(r.class);     // Catch: Exception -> L37
        String r103 = r110.b();     // Catch: Exception -> L37
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L37
        String r105 = "1";
        if (r111.f480417h == false) goto L16;
        Object r106 = "1";
    L17:
        r104.put("foreground", r106);     // Catch: Exception -> L37
        if (r111.f480418i == false) goto L20;
        Object r107 = "1";
    L21:
        r104.put("screenOn", r107);     // Catch: Exception -> L37
        if (r111.f480419j == true) goto L25;
        r105 = "0";
    L25:
        r104.put("usbCharging", r105);     // Catch: Exception -> L37
        r104.put("blockTimeStamp", r110.f480431e + r111.f480416g);     // Catch: Exception -> L37
        r102.monitorStatusAndDuration("push_block_stats" + r103, 0, r104, null);     // Catch: Exception -> L37
        r110.f480431e = 0;     // Catch: Exception -> L37
        goto L38
    L20:
        r107 = "0";
        goto L21
    L16:
        r106 = "0";
        goto L17
    L27:
        if (com.ss.android.pushmanager.setting.a.b().d() == false) goto L41;
    L34:
        r110.f480431e = 0;     // Catch: Exception -> L37
        goto L38
    L41:
        r100 = ((PowerManager) r110.f480427a.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).isInteractive();     // Catch: Exception -> L36
    L29:
        if (r100 == true) goto L34;
        if (r110.c() == true) goto L34;
        r110.f480431e += r111.f480416g;     // Catch: Exception -> L37
        goto L38
    L9:
        r101 = false;
    L38:
        return;
    }

    public d(Context r100, ILogger r101, v67.e r102) {
        this.f480428b = new a();
        this.f480427a = r100;
        this.f480429c = r101;
        this.f480430d = r102;
    }
}
