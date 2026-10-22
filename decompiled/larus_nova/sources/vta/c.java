package vta;

import android.content.SharedPreferences;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements uta.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f557257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f557258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f557259c;

    public c(e r100, com.ss.android.dypay.activity.f.e.C4734e r101, long r102) {
        this.f557257a = r100;
        this.f557258b = r101;
        this.f557259c = r102;
    }

    @Override // uta.d
    public final void a() {
        Function1 r100 = this.f557258b;
        if (r100 == null) goto L5;
        Unit r101 = (Unit) r100.invoke(Boolean.FALSE);
    L5:
        JSONObject r102 = sta.a.f543575a;
        JSONObject r103 = new JSONObject();
        r103.put("net_duration", Long.valueOf(System.currentTimeMillis() - this.f557259c));     // Catch: Exception -> L11
    L13:
        r103.put("is_success", "0");     // Catch: Exception -> L12
    L9:
        sta.a.e("api", "settings_monitor", null, r103, null, 52);
    }

    @Override // uta.d
    public final void b(String r100) {
        SharedPreferences r101 = d.f557260a;
        e r102 = this.f557257a;
        String r103 = r102.f557264b;
        String r104 = r102.f557265c;
        JSONObject r105 = new JSONObject(r100);     // Catch: Exception -> L29
        if (Intrinsics.areEqual(r105.optString("ret_code"), "CC000000") == false) goto L30;
        String r106 = r103 + r104 + "last_update_time";     // Catch: Exception -> L29
        long r107 = System.currentTimeMillis();     // Catch: Exception -> L29
        SharedPreferences r108 = d.a();     // Catch: Exception -> L29
        if (r108 == null) goto L12;
        SharedPreferences.Editor r109 = r108.edit();     // Catch: Exception -> L29
        if (r109 == null) goto L12;
        SharedPreferences.Editor r110 = r109.putLong(r106, r107);     // Catch: Exception -> L29
        if (r110 == null) goto L12;
        r110.apply();     // Catch: Exception -> L29
    L12:
        JSONObject r111 = r105.optJSONObject("sdk_conf_data");     // Catch: Exception -> L29
        if (r111 == null) goto L30;
        String r112 = r103 + r104 + "sdk_conf_info";     // Catch: Exception -> L29
        String r113 = r111.toString();     // Catch: Exception -> L29
        SharedPreferences r114 = d.a();     // Catch: Exception -> L29
        if (r114 == null) goto L21;
        SharedPreferences.Editor r115 = r114.edit();     // Catch: Exception -> L29
        if (r115 == null) goto L21;
        SharedPreferences.Editor r116 = r115.putString(r112, r113);     // Catch: Exception -> L29
        if (r116 == null) goto L21;
        r116.apply();     // Catch: Exception -> L29
    L21:
        b r117 = b.a.a(r111);     // Catch: Exception -> L29
        d.f557261b.put(r103 + r104, r117);     // Catch: Exception -> L29
        if (r117 == null) goto L26;
        h r118 = r117.f557248a;     // Catch: Exception -> L29
        if (r118 == null) goto L26;
        boolean r119 = r118.f557283k;     // Catch: Exception -> L29
    L27:
        d.f557262c = r119;     // Catch: Exception -> L29
    L26:
        r119 = true;
    L30:
        Function1 r120 = this.f557258b;
        if (r120 == null) goto L33;
        Unit r121 = (Unit) r120.invoke(Boolean.TRUE);
    L33:
        JSONObject r122 = sta.a.f543575a;
        JSONObject r123 = new JSONObject();
        r123.put("net_duration", Long.valueOf(System.currentTimeMillis() - this.f557259c));     // Catch: Exception -> L39
    L43:
        r123.put("is_success", "1");     // Catch: Exception -> L40
    L37:
        sta.a.e("api", "settings_monitor", null, r123, null, 52);
    }
}
