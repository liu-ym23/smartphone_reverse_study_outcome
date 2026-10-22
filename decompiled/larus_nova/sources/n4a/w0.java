package n4a;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.camera.video.AudioStats;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f517843a;

    public w0() {
    }

    public static int a(String r110, List<GeoFence> r111, Bundle r112) {
        JSONObject r100 = new JSONObject(r110);     // Catch: Throwable -> L15
        int r101 = r100.optInt("status", 0);     // Catch: Throwable -> L15
        int r102 = r100.optInt("infocode", 0);     // Catch: Throwable -> L15
        if (r101 != 1) goto L20;
        JSONArray r103 = r100.optJSONArray("pois");     // Catch: Throwable -> L15
        if (r103 == null) goto L21;
        int r104 = 0;
    L8:
        if (r104 >= r103.length()) goto L22;
        GeoFence r105 = new GeoFence();     // Catch: Throwable -> L15
        PoiItem r106 = new PoiItem();     // Catch: Throwable -> L15
        JSONObject r107 = JSONArrayProtectorUtils.getJSONObject(r103, r104);     // Catch: Throwable -> L15
        r106.setPoiId(r107.optString("id"));     // Catch: Throwable -> L15
        r106.setPoiName(r107.optString("name"));     // Catch: Throwable -> L15
        r106.setPoiType(r107.optString("type"));     // Catch: Throwable -> L15
        r106.setTypeCode(r107.optString("typecode"));     // Catch: Throwable -> L15
        r106.setAddress(r107.optString("address"));     // Catch: Throwable -> L15
        String r108 = r107.optString("location");     // Catch: Throwable -> L15
        if (r108 == null) goto L13;
        String[] r109 = r108.split(",");     // Catch: Throwable -> L15
        r106.setLongitude(CastDoubleProtector.parseDouble(r109[0]));     // Catch: Throwable -> L15
        r106.setLatitude(CastDoubleProtector.parseDouble(r109[1]));     // Catch: Throwable -> L15
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L15
        ArrayList r114 = new ArrayList();     // Catch: Throwable -> L15
        DPoint r115 = new DPoint(r106.getLatitude(), r106.getLongitude());     // Catch: Throwable -> L15
        r114.add(r115);     // Catch: Throwable -> L15
        r113.add(r114);     // Catch: Throwable -> L15
        r105.setPointList(r113);     // Catch: Throwable -> L15
        r105.setCenter(r115);     // Catch: Throwable -> L15
    L13:
        r106.setTel(r107.optString("tel"));     // Catch: Throwable -> L15
        r106.setProvince(r107.optString("pname"));     // Catch: Throwable -> L15
        r106.setCity(r107.optString("cityname"));     // Catch: Throwable -> L15
        r106.setAdname(r107.optString("adname"));     // Catch: Throwable -> L15
        r105.setPoiItem(r106);     // Catch: Throwable -> L15
        StringBuilder r116 = new StringBuilder();     // Catch: Throwable -> L15
        r116.append(b());     // Catch: Throwable -> L15
        r105.setFenceId(r116.toString());     // Catch: Throwable -> L15
        r105.setCustomId(r112.getString(GeoFence.BUNDLE_KEY_CUSTOMID));     // Catch: Throwable -> L15
        r105.setPendingIntentAction(r112.getString("pendingIntentAction"));     // Catch: Throwable -> L15
        r105.setType(2);     // Catch: Throwable -> L15
        r105.setRadius(r112.getFloat("fenceRadius"));     // Catch: Throwable -> L15
        r105.setExpiration(r112.getLong("expiration"));     // Catch: Throwable -> L15
        r105.setActivatesAction(r112.getInt("activatesAction", 1));     // Catch: Throwable -> L15
        ((ArrayList) r111).add(r105);     // Catch: Throwable -> L15
        r104 = r104 + 1;
        goto L8
    L22:
        return r102;
    L21:
        return r102;
    L20:
        return r102;
    L15:
        return 5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.amap.api.fence.DistrictItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.List] */
    public static int d(String r310, List r311, Bundle r312) {
        JSONObject r100 = new JSONObject(r310);     // Catch: Throwable -> L37
        int r101 = r100.optInt("status", 0);     // Catch: Throwable -> L37
        int r102 = r100.optInt("infocode", 0);     // Catch: Throwable -> L37
        String r103 = r312.getString(GeoFence.BUNDLE_KEY_CUSTOMID);     // Catch: Throwable -> L37
        String r104 = r312.getString("pendingIntentAction");     // Catch: Throwable -> L37
        float r105 = r312.getFloat("fenceRadius");     // Catch: Throwable -> L37
        long r106 = r312.getLong("expiration");     // Catch: Throwable -> L37
        int r107 = r312.getInt("activatesAction", 1);     // Catch: Throwable -> L37
        if (r101 != 1) goto L50;
        JSONArray r108 = r100.optJSONArray("districts");     // Catch: Throwable -> L37
        if (r108 == null) goto L50;
        int r109 = 0;
    L8:
        if (r109 >= r108.length()) goto L50;
        ArrayList r110 = new ArrayList();     // Catch: Throwable -> L37
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L37
        GeoFence r112 = new GeoFence();     // Catch: Throwable -> L37
        JSONObject r113 = JSONArrayProtectorUtils.getJSONObject(r108, r109);     // Catch: Throwable -> L37
        String r114 = r113.optString("citycode");     // Catch: Throwable -> L37
        String r115 = r113.optString("adcode");     // Catch: Throwable -> L37
        String r116 = r113.optString("name");     // Catch: Throwable -> L37
        JSONArray r313 = r108;
        String r117 = JSONObjectProtectorUtils.getString(r113, "center");     // Catch: Throwable -> L37
        int r118 = r102;
        DPoint r119 = new DPoint();     // Catch: Throwable -> L37
        int r120 = r109;
        String r121 = ",";
        if (r117 == null) goto L15;
        String[] r122 = r117.split(",");     // Catch: Throwable -> L37
        r119.setLatitude(CastDoubleProtector.parseDouble(r122[1]));     // Catch: Throwable -> L37
        r119.setLongitude(CastDoubleProtector.parseDouble(r122[0]));     // Catch: Throwable -> L37
        r112.setCenter(r119);     // Catch: Throwable -> L37
    L15:
        r112.setCustomId(r103);     // Catch: Throwable -> L37
        r112.setPendingIntentAction(r104);     // Catch: Throwable -> L37
        r112.setType(3);     // Catch: Throwable -> L37
        r112.setRadius(r105);     // Catch: Throwable -> L37
        r112.setExpiration(r106);     // Catch: Throwable -> L37
        r112.setActivatesAction(r107);     // Catch: Throwable -> L37
        StringBuilder r123 = new StringBuilder();     // Catch: Throwable -> L37
        r123.append(b());     // Catch: Throwable -> L37
        r112.setFenceId(r123.toString());     // Catch: Throwable -> L37
        String r124 = r113.optString(SVGRenderEngine.POLYLINE);     // Catch: Throwable -> L37
        if (r124 == null) goto L34;
        String[] r125 = r124.split("\\|");     // Catch: Throwable -> L37
        int r126 = r125.length;     // Catch: Throwable -> L37
        float r127 = Float.MIN_VALUE;
        int r128 = 0;
        float r129 = Float.MAX_VALUE;
    L18:
        String r210 = r103;
        if (r128 >= r126) goto L32;
        String r130 = r125[r128];     // Catch: Throwable -> L37
        String[] r211 = r125;
        ?? r131 = new DistrictItem();     // Catch: Throwable -> L37
        String r212 = r104;
        ?? r132 = new ArrayList();     // Catch: Throwable -> L37
        r131.setCitycode(r114);     // Catch: Throwable -> L37
        r131.setAdcode(r115);     // Catch: Throwable -> L37
        String r213 = r115;
        String r133 = r116;
        r131.setDistrictName(r133);     // Catch: Throwable -> L37
        r116 = r133;
        String[] r134 = r130.split(com.alipay.sdk.m.u.i.f25853b);     // Catch: Throwable -> L37
        float r214 = r105;
        int r135 = 0;
    L22:
        if (r135 >= r134.length) goto L28;
        String[] r136 = r134[r135].split(r121);     // Catch: Throwable -> L37
        String r215 = r121;
        String[] r216 = r134;
        if (r136.length <= 1) goto L27;
        r132.add(new DPoint(CastDoubleProtector.parseDouble(r136[1]), CastDoubleProtector.parseDouble(r136[0])));     // Catch: Throwable -> L37
    L27:
        r135 = r135 + 1;     // Catch: Throwable -> L37
        r126 = r126;
        r121 = r215;
        r134 = r216;
        r106 = r106;
        r128 = r128;
        goto L22
    L28:
        String r217 = r121;
        long r218 = r106;
        int r137 = r126;
        int r314 = r128;
        if (r132.size() <= 100.0f) goto L31;
        r132 = c(r132);     // Catch: Throwable -> L37
    L31:
        r111.add(r132);     // Catch: Throwable -> L37
        r131.setPolyline(r132);     // Catch: Throwable -> L37
        ArrayList r138 = r110;
        r138.add(r131);     // Catch: Throwable -> L37
        r127 = Math.max(r127, a.q(r119, r132));     // Catch: Throwable -> L37
        r129 = Math.min(r129, a.b(r119, r132));     // Catch: Throwable -> L37
        r128 = r314 + 1;     // Catch: Throwable -> L37
        r126 = r137;
        r110 = r138;
        r103 = r210;
        r125 = r211;
        r104 = r212;
        r115 = r213;
        r105 = r214;
        r121 = r217;
        r106 = r218;
        goto L18
    L32:
        String r219 = r104;
        float r220 = r105;
        long r221 = r106;
        r112.setMaxDis2Center(r127);     // Catch: Throwable -> L37
        r112.setMinDis2Center(r129);     // Catch: Throwable -> L37
        r112.setDistrictItemList(r110);     // Catch: Throwable -> L37
        r112.setPointList(r111);     // Catch: Throwable -> L37
        ((ArrayList) r311).add(r112);     // Catch: Throwable -> L37
    L35:
        r109 = r120 + 1;
        r108 = r313;
        r102 = r118;
        r107 = r107;
        r103 = r210;
        r104 = r219;
        r105 = r220;
        r106 = r221;
        goto L8
    L34:
        r210 = r103;
        r219 = r104;
        r220 = r105;
        r221 = r106;
    L50:
        return r102;
    L37:
        return 5;
    }

    public static synchronized long b() {
        monitor-enter(w0.class);
        long r100 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        long r101 = f517843a;     // Catch: Throwable -> L11
        if (r100 <= r101) goto L7;
        f517843a = r100;     // Catch: Throwable -> L11
    L8:
        long r102 = f517843a;     // Catch: Throwable -> L11
        monitor-exit(w0.class);
        return r102;
    L7:
        f517843a = r101 + 1;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static List c(List r210) {
        if (r210 != null) goto L7;
        return null;
    L7:
        if (r210.size() > 2) goto L9;
        return r210;
    L9:
        ArrayList r100 = new ArrayList();
        DPoint r101 = (DPoint) ListProtector.get(r210, 0);
        int r102 = 1;
        DPoint r103 = (DPoint) ListProtector.get(r210, r210.size() - 1);
        double r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r105 = 0.0d;
        int r106 = 1;
        int r110 = 0;
    L11:
        if (r106 >= (r210.size() - r102)) goto L32;
        DPoint r111 = (DPoint) ListProtector.get(r210, r106);
        double r112 = r111.getLongitude() - r101.getLongitude();
        double r113 = r111.getLatitude() - r101.getLatitude();
        double r114 = r103.getLongitude() - r101.getLongitude();
        double r115 = r103.getLatitude() - r101.getLatitude();
        double r116 = ((r112 * r114) + (r113 * r115)) / ((r114 * r114) + (r115 * r115));
        if (r101.getLongitude() == r103.getLongitude()) goto L15;
    L17:
        boolean r117 = false;
    L19:
        if (r116 < r104) goto L26;
        if (r117 == true) goto L26;
        if (r116 <= 1.0d) goto L25;
        double r118 = r103.getLongitude();
        double r119 = r103.getLatitude();
    L27:
        double r107 = r119;
    L28:
        DPoint r120 = r101;
        double r108 = j4.b(new DPoint(r111.getLatitude(), r111.getLongitude()), new DPoint(r107, r118));
        if (r108 <= r105) goto L31;
        r105 = r108;
        r110 = r106;
    L31:
        r106 = r106 + 1;
        r101 = r120;
        r102 = 1;
        r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L11
    L25:
        double r121 = r101.getLongitude() + (r114 * r116);
        double r122 = r101.getLatitude() + (r116 * r115);
        r118 = r121;
        r107 = r122;
    L26:
        r118 = r101.getLongitude();
        r119 = r101.getLatitude();
        goto L27
    L15:
        if (r101.getLatitude() != r103.getLatitude()) goto L17;
        r117 = true;
        goto L19
    L32:
        DPoint r123 = r101;
        if (r105 >= 100.0f) goto L36;
        r100.add(r123);
        r100.add(r103);
        return r100;
    L36:
        List r109 = c(r210.subList(0, r110 + 1));
        List r124 = c(r210.subList(r110, r210.size()));
        r100.addAll(r109);
        ListProtector.remove(r100, r100.size() - 1);
        r100.addAll(r124);
        return r100;
    }
}
