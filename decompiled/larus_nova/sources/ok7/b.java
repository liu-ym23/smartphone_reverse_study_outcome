package ok7;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.api.ILuckyDogSettingsService;
import com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.LuckyDogCommonSettingServiceImpl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    public static JSONObject a(ILuckyDogCommonSettingsService.Channel r100, String r101) {
        ILuckyDogSettingsService r102 = (ILuckyDogSettingsService) fk7.c.b(ILuckyDogSettingsService.class);
        if (r102 == null) goto L7;
        Object r103 = r102.getSettingsByKey(r100, "data.common_info." + r101);
        if ((r103 instanceof JSONObject) == false) goto L7;
        JSONObject r104 = (JSONObject) r103;
    L8:
        if (r104 == null) goto L10;
        return r104;
    L10:
        return new JSONObject();
    L7:
        r104 = null;
        goto L8
    }

    public static Object b(String r100, String r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ContainerHelper", "getKeyContent is called, activityId is " + r100 + ", key is " + r101);
        fk7.d r102 = fk7.c.b(ILuckyDogSettingsService.class);
        if ((r102 instanceof LuckyDogCommonSettingServiceImpl) == false) goto L13;
        Object r103 = ((LuckyDogCommonSettingServiceImpl) r102).getSettingsByKey(ILuckyDogCommonSettingsService.Channel.STATIC, "data.extra");
        if ((r103 instanceof JSONObject) == false) goto L8;
        JSONObject r104 = (JSONObject) r103;
    L14:
        if (r104 == null) goto L64;
        int r105 = 0;
        if (TextUtils.isEmpty(r100) == true) goto L18;
        JSONArray r106 = r104.optJSONArray("activity_data");     // Catch: Exception -> L61
        if (r106 == null) goto L64;
    L55:
        if (r105 >= r106.length()) goto L64;
        if (r100.equals(JSONArrayProtectorUtils.getJSONObject(r106, r105).optString("activity_id")) == true) goto L58;
        r105 = r105 + 1;
        goto L55
    L58:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ContainerHelper", "getKeyContent from cache");     // Catch: Exception -> L61
        return JSONArrayProtectorUtils.getJSONObject(r106, r105).opt(r101);
    L61:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("ContainerHelper", "getKeyContent meet exception, " + e);
        goto L64
    L18:
        if (r104.optJSONObject(r101) != null) goto L20;
    L23:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ContainerHelper", "getKeyContent from disk");
        int r107 = r101.hashCode();     // Catch: Exception -> L50
        if (r107 == 106852524) goto L38;
        if (r107 == 634509239) goto L35;
        if (r107 == 952219641) goto L32;
    L40:
        r105 = -1;
    L41:
        if (r105 == 0) goto L49;
        if (r105 == 1) goto L49;
        if (r105 == 2) goto L47;
        return new JSONObject();
    L47:
        return a(ILuckyDogCommonSettingsService.Channel.DYNAMIC, r101);
    L49:
        return a(ILuckyDogCommonSettingsService.Channel.STATIC, r101);
    L32:
        if (r101.equals("cooling") == false) goto L40;
    L35:
        if (r101.equals("passport_data") == false) goto L40;
        r105 = 1;
        goto L41
    L38:
        if (r101.equals("popup") == false) goto L40;
        r105 = 2;
    L50:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("ContainerHelper", "getKeyContent meet exception, " + e);
        goto L64
    L20:
        if ((!"time_table".equalsIgnoreCase(r101)) == false) goto L23;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ContainerHelper", "getKeyContent from cache");
        return r104.optJSONObject(r101);
    L64:
        return new JSONObject();
    L8:
        if ((r103 instanceof String) == false) goto L13;
        r104 = new JSONObject(r103.toString()).optJSONObject("old_dog");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("ContainerHelper", "Exception when fetch old_dog settings " + e);
    L13:
        r104 = null;
        goto L14
    }

    public static Object c(String r100, String r101, String r102, String r103) {
        if (TextUtils.isEmpty(r101) == false) goto L24;
        return null;
    L24:
        Object r104 = b(r100, r101);     // Catch: Exception -> L21
        com.bytedance.ug.sdk.luckydog.api.log.d.a("ContainerHelper", "keyObject is " + r104);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r102) == false) goto L10;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ContainerHelper", "return key content");     // Catch: Exception -> L21
        return r104;
    L10:
        if (TextUtils.isEmpty(r104.toString()) == false) goto L12;
        return null;
    L12:
        JSONObject r105 = (JSONObject) r104;     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r103) == false) goto L16;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ContainerHelper", "return subKey content");     // Catch: Exception -> L21
        return r105.opt(r102);
    L16:
        JSONObject r106 = r105.optJSONObject(r102);     // Catch: Exception -> L21
        if (r106 != null) goto L19;
        return null;
    L19:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ContainerHelper", "return subSubKey content");     // Catch: Exception -> L21
        return r106.opt(r103);
    L21:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
