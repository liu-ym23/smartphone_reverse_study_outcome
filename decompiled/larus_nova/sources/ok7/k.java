package ok7;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@XBridgeMethod(name = "luckycatGetDogCommonParams", owner = "pengweitao")
public final class k extends ok7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523693a;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class a {
    }

    static {
    }

    public k() {
        this.f523693a = "luckycatGetDogCommonParams";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f523693a;
    }

    @Override // ok7.a
    public final void e(XReadableMap r110, i r111) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogXBridge", "luckycatGetDogCommonParams on call");
        JSONObject r100 = new JSONObject();     // Catch: JSONException -> L34
        HashMap r101 = new HashMap();     // Catch: JSONException -> L34
        ek7.b.e(r101);     // Catch: JSONException -> L34
        HashMap r102 = new HashMap();     // Catch: JSONException -> L34
        Iterator r103 = r101.entrySet().iterator();     // Catch: JSONException -> L34
    L5:
        if (r103.hasNext() == false) goto L8;
        Map.Entry r112 = (Map.Entry) r103.next();     // Catch: JSONException -> L34
        r102.put(r112.getKey(), r112.getValue());     // Catch: JSONException -> L34
        goto L5
    L8:
        if (r102.containsKey("luckydog_settings_version") == true) goto L11;
        com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.h r104 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;     // Catch: JSONException -> L34
        r102.put("luckydog_settings_version", Integer.valueOf(com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.c(ILuckyDogCommonSettingsService.Channel.STATIC)));     // Catch: JSONException -> L34
    L11:
        if (r102.containsKey("luckydog_static_settings_version") == true) goto L14;
        com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.h r105 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;     // Catch: JSONException -> L34
        r102.put("luckydog_static_settings_version", Integer.valueOf(com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.c(ILuckyDogCommonSettingsService.Channel.STATIC)));     // Catch: JSONException -> L34
    L14:
        if (r102.containsKey("luckydog_dynamic_settings_version") == true) goto L17;
        com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.h r106 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;     // Catch: JSONException -> L34
        r102.put("luckydog_dynamic_settings_version", Integer.valueOf(com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.c(ILuckyDogCommonSettingsService.Channel.DYNAMIC)));     // Catch: JSONException -> L34
    L17:
        if (r102.containsKey("luckydog_polling_settings_version") == true) goto L20;
        com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.h r107 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;     // Catch: JSONException -> L34
        r102.put("luckydog_polling_settings_version", Integer.valueOf(com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.c(ILuckyDogCommonSettingsService.Channel.POLL)));     // Catch: JSONException -> L34
    L20:
        if (r102.containsKey("static_settings_version") == false) goto L23;
        r102.remove("static_settings_version");     // Catch: JSONException -> L34
    L23:
        if (r102.containsKey("dynamic_settings_version") == false) goto L26;
        r102.remove("dynamic_settings_version");     // Catch: JSONException -> L34
    L26:
        if (r102.containsKey("polling_settings_version") == false) goto L28;
        r102.remove("polling_settings_version");     // Catch: JSONException -> L34
    L28:
        r100.put("dog_params", GsonProtectorUtils.toJson(new Gson(), r102));     // Catch: JSONException -> L34
        JSONObject r113 = new JSONObject(r102);     // Catch: Throwable -> L31
    L32:
        r100.put("dog_params_json", r113);     // Catch: JSONException -> L34
        r111.a(1, r100, "success");     // Catch: JSONException -> L34
        return;
    L31:
        r113 = new JSONObject();     // Catch: JSONException -> L34
    L34:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyDogXBridge", e.getLocalizedMessage());
        i.b(r111, 0, null, "fail", 2);
    }
}
