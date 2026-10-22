package ok7;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.v;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.api.ILuckyDogSettingsService;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@XBridgeMethod(name = "luckycatGetCommonSettingsInfo", owner = "pengweitao")
public class e extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f523688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Gson f523689c;

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return "luckycatGetCommonSettingsInfo";
    }

    public e() {
        this.f523687a = "LuckyDogGetSettingsMethod";
        this.f523688b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
        this.f523689c = new Gson();
    }

    public String f() {
        return this.f523687a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f523688b;
    }

    public final void g(XReadableMap r110, com.bytedance.ies.xbridge.XBridgeMethod.Callback r111, boolean r210) {
        LinkedHashMap r100 = new LinkedHashMap();
        int r101 = il7.a.f490307f;
        String r102 = s.f(r110, "activity_id", "");
        com.bytedance.ies.xbridge.model.params.a.Companion.getClass();
        int r103 = com.bytedance.ies.xbridge.model.params.a.C3558a.a(r110, "settings_type");
        v r104 = s.a(r110, "static_settings_keys");
        v r112 = s.a(r110, "personal_settings_keys");
        v r113 = s.a(r110, "polling_settings_keys");
        il7.a r114 = new il7.a();
        r114.f490308a = r102;
        r114.f490309b = r103;
        int r105 = 0;
        if (r104 == null) goto L8;
        ArrayList r106 = new ArrayList();
        int r115 = r104.size();
        int r116 = 0;
    L5:
        if (r116 >= r115) goto L11;
        r106.add(r104.get(r116).asString());
        r116 = r116 + 1;
    L11:
        r114.f490310c = r106;
        if (r112 == null) goto L17;
        ArrayList r107 = new ArrayList();
        int r108 = r112.size();
        int r109 = 0;
    L14:
        if (r109 >= r108) goto L20;
        r107.add(r112.get(r109).asString());
        r109 = r109 + 1;
    L20:
        r114.f490311d = r107;
        if (r113 == null) goto L26;
        ArrayList r117 = new ArrayList();
        int r118 = r113.size();
    L23:
        if (r105 >= r118) goto L29;
        r117.add(r113.get(r105).asString());
        r105 = r105 + 1;
    L29:
        r114.f490312e = r117;
        if (r114.f490311d != null) goto L32;
    L74:
        onFailure(r111, -3, "Value did not match expected type", new LinkedHashMap());
        com.bytedance.ug.sdk.luckydog.api.log.d.a(f(), "the param is illegal");
        return;
    L32:
        if (r114.f490310c == null) goto L74;
        if (r117 == null) goto L74;
        String r119 = f();
        StringBuilder r120 = new StringBuilder("the activity id is : ");
        String r121 = r114.f490308a;
        if (r121 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("activityId");
    L38:
        r120.append(r121);
        r120.append(", the setting type is : ");
        r120.append(Integer.valueOf(r114.f490309b).intValue());
        r120.append(", the static settingsKeys is: ");
        r120.append(r114.f490310c);
        r120.append(" the personal settings keys is : ");
        r120.append(r114.f490311d);
        r120.append(" the polling settings keys is ");
        r120.append(r114.f490312e);
        com.bytedance.ug.sdk.luckydog.api.log.d.a(r119, r120.toString());
        if ((Integer.valueOf(r114.f490309b).intValue() & 1) == 0) goto L47;
        List<String> r122 = r114.f490310c;
        if (r122 == null) goto L47;
        String r123 = r114.f490308a;
        if (r123 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("activityId");
    L45:
        r100.put("static_settings", e(1, r123, r122, r210));
    L47:
        if ((Integer.valueOf(r114.f490309b).intValue() & 2) == 0) goto L55;
        List<String> r124 = r114.f490311d;
        if (r124 == null) goto L55;
        String r125 = r114.f490308a;
        if (r125 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("activityId");
    L53:
        r100.put("personal_settings", e(2, r125, r124, r210));
    L55:
        if ((Integer.valueOf(r114.f490309b).intValue() & 4) == 0) goto L63;
        List<String> r126 = r114.f490312e;
        if (r126 == null) goto L63;
        String r127 = r114.f490308a;
        if (r127 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("activityId");
    L61:
        r100.put("polling_settings", e(4, r127, r126, r210));
    L63:
        if (Integer.valueOf(r114.f490309b).intValue() != 0) goto L65;
    L72:
        com.bytedance.ug.sdk.luckydog.api.log.d.a(f(), "the data size is : " + r100.size());
        onSuccess(r111, r100, "success");
        return;
    L65:
        if ((Integer.valueOf(r114.f490309b).intValue() & 1) != 0) goto L72;
        if ((Integer.valueOf(r114.f490309b).intValue() & 2) != 0) goto L72;
        if ((Integer.valueOf(r114.f490309b).intValue() & 4) != 0) goto L72;
        onFailure(r111, -3, "unknow type" + Integer.valueOf(r114.f490309b).intValue(), new LinkedHashMap());
        return;
    L26:
        if (r110.hasKey("polling_settings_keys") == true) goto L28;
        r117 = new ArrayList();
        goto L29
    L28:
        r117 = null;
        goto L29
    L17:
        if (r110.hasKey("personal_settings_keys") == true) goto L19;
        r107 = new ArrayList();
        goto L20
    L19:
        r107 = null;
        goto L20
    L8:
        if (r110.hasKey("static_settings_keys") == true) goto L10;
        r106 = new ArrayList();
        goto L11
    L10:
        r106 = null;
        goto L11
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public void handle(XReadableMap r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        g(r100, r101, false);
    }

    public final Map e(int r110, String r111, List r112, boolean r113) {
        LinkedHashMap r100 = new LinkedHashMap();
        fk7.d r101 = fk7.c.b(ILuckyDogSettingsService.class);
        if (r101 != null) goto L5;
    L38:
        return r100;
    L5:
        if ((r101 instanceof ILuckyDogSettingsService) == false) goto L38;
        if ((!r112.isEmpty()) == false) goto L29;
        Iterator r114 = r112.iterator();
    L10:
        if (r114.hasNext() == false) goto L38;
        String r115 = (String) r114.next();
        ILuckyDogSettingsService r102 = (ILuckyDogSettingsService) r101;
        if (r110 == 2) goto L16;
        if (r110 == 4) goto L15;
        ILuckyDogCommonSettingsService.Channel r103 = ILuckyDogCommonSettingsService.Channel.STATIC;
    L17:
        Object r104 = r102.getSettingsByKey(r103, "data." + r115);
        if (r104 == null) goto L10;
        if (r113 == false) goto L28;
        if ((r104 instanceof String) == false) goto L28;
        JSONObject r105 = new JSONObject();
        r105.put("key", r115);
        r100.put(r115, new JSONObject(r104.toString()));     // Catch: Exception -> L25
        r105.put("result", "success");     // Catch: Exception -> L25
    L27:
        com.bytedance.ug.sdk.luckydog.api.log.e.a("luckydog_get_settings_decode", r105, null);
    L25:
        e = move-exception;
        r100.put(r115, r104);
        r105.put("result", "fail");
        com.bytedance.ug.sdk.luckydog.api.log.d.b(f(), e.toString());
    L28:
        r100.put(r115, r104);
        goto L10
    L15:
        r103 = ILuckyDogCommonSettingsService.Channel.POLL;
        goto L17
    L16:
        r103 = ILuckyDogCommonSettingsService.Channel.DYNAMIC;
        goto L17
    L29:
        ILuckyDogSettingsService r106 = (ILuckyDogSettingsService) r101;
        if (r110 == 2) goto L34;
        if (r110 == 4) goto L33;
        ILuckyDogCommonSettingsService.Channel r116 = ILuckyDogCommonSettingsService.Channel.STATIC;
    L35:
        Object r117 = r106.getSettingsByKey(r116, "data." + r111);
        if (r117 == null) goto L38;
        r100.putAll((Map) GsonProtectorUtils.fromJson(this.f523689c, r117.toString(), Map.class));
        goto L38
    L33:
        r116 = ILuckyDogCommonSettingsService.Channel.POLL;
        goto L35
    L34:
        r116 = ILuckyDogCommonSettingsService.Channel.DYNAMIC;
        goto L35
    }
}
