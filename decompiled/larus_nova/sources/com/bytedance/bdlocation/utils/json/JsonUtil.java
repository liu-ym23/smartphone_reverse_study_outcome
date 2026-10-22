package com.bytedance.bdlocation.utils.json;

import android.location.Location;
import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.BaseStation;
import com.bytedance.bdlocation.network.model.BssInfo;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.utils.json.deserializer.BDLocationDeserializer;
import com.bytedance.bdlocation.utils.json.deserializer.LocationDeserializer;
import com.bytedance.bdlocation.utils.json.serializer.BDLocationSerializer;
import com.bytedance.bdlocation.utils.json.serializer.LocationSerializer;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class JsonUtil {
    public static Gson sGson;

    private JsonUtil() {
    }

    static {
        sGson = new GsonBuilder().addDeserializationExclusionStrategy(new SuperclassExclusionStrategy()).addSerializationExclusionStrategy(new SuperclassExclusionStrategy()).registerTypeHierarchyAdapter(Location.class, new LocationSerializer()).registerTypeHierarchyAdapter(Location.class, new LocationDeserializer()).registerTypeHierarchyAdapter(BDLocation.class, new BDLocationSerializer()).registerTypeHierarchyAdapter(BDLocation.class, new BDLocationDeserializer()).create();
    }

    private static JSONObject getBssInfoJson(BssInfo r100) {
        if (r100 == null) goto L4;
        JSONObject r101 = new JSONObject();
        r101.put("bid", r100.bid);     // Catch: JSONException -> L8
        r101.put("bsss", r100.bsss);     // Catch: JSONException -> L8
        r101.put("bw", r100.f199862bw);     // Catch: JSONException -> L8
        r101.put("ci", r100.f199863ci);     // Catch: JSONException -> L8
        r101.put("cid", r100.cid);     // Catch: JSONException -> L8
        r101.put("cpid", r100.cpid);     // Catch: JSONException -> L8
        r101.put("earfcn", r100.earfcn);     // Catch: JSONException -> L8
        r101.put("is_registered", r100.isRegistered);     // Catch: JSONException -> L8
        r101.put("lac", r100.f199864lac);     // Catch: JSONException -> L8
        r101.put("lat", r100.lat);     // Catch: JSONException -> L8
        r101.put("longi", r100.longi);     // Catch: JSONException -> L8
        r101.put("mcc", r100.f199865mcc);     // Catch: JSONException -> L8
        r101.put("mnc", r100.f199866mnc);     // Catch: JSONException -> L8
        r101.put("nci", r100.nci);     // Catch: JSONException -> L8
        r101.put("nid", r100.nid);     // Catch: JSONException -> L8
        r101.put("pci", r100.pci);     // Catch: JSONException -> L8
        r101.put("psc", r100.f199867psc);     // Catch: JSONException -> L8
        r101.put("rssi", r100.rssi);     // Catch: JSONException -> L8
        r101.put(WsConstants.KEY_SESSION_ID, r100.sid);     // Catch: JSONException -> L8
        r101.put("tac", r100.f199868tac);     // Catch: JSONException -> L8
        r101.put("timestamp", r100.timestamp);     // Catch: JSONException -> L8
        r101.put("radio_type", r100.radioType);     // Catch: JSONException -> L8
    L7:
        return r101;
    L4:
        return new JSONObject();
    }

    public static JsonElement safeToJsonTree(Object r100) {
        return sGson.toJsonTree(r100);
    L4:
        th = move-exception;
        Logger.d("BDLocation", "Util#safeToJsonTree occurs exception that " + th.getMessage());
        th.printStackTrace();
        return null;
    }

    public static JsonElement toJsonTreeSafely(Object r100) {
        return new Gson().toJsonTree(r100);
    L4:
        return null;
    }

    public static void convertWifiInfoToJSON(JSONObject r100, List<WifiInfo> r101) {
        if (r101 != null) goto L15;
        return;
    L15:
        JSONArray r102 = new JSONArray();     // Catch: JSONException -> L12
        Iterator<WifiInfo> r103 = r101.iterator();     // Catch: JSONException -> L12
    L6:
        if (r103.hasNext() == false) goto L10;
        WifiInfo r104 = r103.next();     // Catch: JSONException -> L12
        if (r104 == null) goto L6;
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L12
        r105.put("frequency", r104.frequency);     // Catch: JSONException -> L12
        r105.put("is_current", r104.isCurrent);     // Catch: JSONException -> L12
        r105.put("rssi", r104.rssi);     // Catch: JSONException -> L12
        r105.put("Timestamp", r104.timeStamp);     // Catch: JSONException -> L12
        r105.put("wifi_mac", r104.wifiMac);     // Catch: JSONException -> L12
        r105.put("wifi_name", r104.wifiName);     // Catch: JSONException -> L12
        r102.put(r105);     // Catch: JSONException -> L12
        goto L6
    L10:
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L12
        r106.put("wifi_info_list", r102);     // Catch: JSONException -> L12
        r100.put("location", r106);     // Catch: JSONException -> L12
        r100.put("upload_source", "cold_boot_get_wifi_cache_list");     // Catch: JSONException -> L12
        r100.put("timestamp", System.currentTimeMillis() / 1000);     // Catch: JSONException -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    public static JsonElement toJsonTreeSafely(Object r100, Type r101) {
        return new Gson().toJsonTree(r100, r101);
    L4:
        return null;
    }

    public static void convertBssInfoToJSON(JSONObject r100, BaseStation r101, boolean r102) {
        if (r101 != null) goto L22;
        return;
    L22:
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L19
        BssInfo r104 = r101.current;     // Catch: JSONException -> L19
        if (r104 == null) goto L7;
        r103.put("current", getBssInfoJson(r104));     // Catch: JSONException -> L19
    L7:
        if (r102 == false) goto L17;
        List<BssInfo> r105 = r101.neighboring;     // Catch: JSONException -> L19
        if (r105 == null) goto L17;
        if (r105.isEmpty() == true) goto L17;
        JSONArray r106 = new JSONArray();     // Catch: JSONException -> L19
        Iterator<BssInfo> r107 = r101.neighboring.iterator();     // Catch: JSONException -> L19
    L14:
        if (r107.hasNext() == false) goto L16;
        r106.put(getBssInfoJson(r107.next()));     // Catch: JSONException -> L19
        goto L14
    L16:
        r103.put("neighboring", r106);     // Catch: JSONException -> L19
    L17:
        JSONObject r108 = new JSONObject();     // Catch: JSONException -> L19
        r108.put("base_station", r103);     // Catch: JSONException -> L19
        r100.put("location", r108);     // Catch: JSONException -> L19
        r100.put("upload_source", "cold_boot_get_base_station");     // Catch: JSONException -> L19
        r100.put("timestamp", System.currentTimeMillis() / 1000);     // Catch: JSONException -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public static int safeOptInt(JSONObject r100, String r101, int r102) {
        if (r100 != null) goto L4;
        return r102;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        return r100.optInt(r101);
    L8:
        th = move-exception;
        th.printStackTrace();
        return r102;
    L14:
        return r102;
    }

    public static long safeOptLong(JSONObject r100, String r101, long r102) {
        if (r100 != null) goto L4;
        return r102;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        return r100.optLong(r101, r102);
    L8:
        th = move-exception;
        th.printStackTrace();
        return r102;
    L14:
        return r102;
    }

    public static String safeOptString(JSONObject r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return r102;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        return r100.optString(r101);
    L8:
        th = move-exception;
        th.printStackTrace();
        return r102;
    L14:
        return r102;
    }

    public static void safePutBoolean(JSONObject r100, String r101, boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.put(r101, r102);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutDouble(JSONObject r100, String r101, double r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.put(r101, r102);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutInt(JSONObject r100, String r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.put(r101, r102);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutLong(JSONObject r100, String r101, long r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.put(r101, r102);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutObject(JSONObject r100, String r101, Object r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.put(r101, r102);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutString(JSONObject r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.put(r101, r102);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
