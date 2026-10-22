package com.ss.android.lark.locationmessage.ui.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.locationmessage.statistics.NavigateHitPoint$Event;
import com.ss.android.lark.locationmessage.statistics.NavigateHitPoint$MapType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class MapRouteService {

    @Retention(RetentionPolicy.SOURCE)
    public @interface MapCustomRouteURI {
        public static final String CUSTOM_URI_AMAP = "androidamap://keywordNavi?keyword=%1$s&style=0";
        public static final String CUSTOM_URI_BAIDUMAP = "baidumap://map/direction?destination=%1$s&mode=driving";
        public static final String CUSTOM_URI_GOOGLEMAP = "https://www.google.com/maps/search/?api=1&query=%1$s";
        public static final String CUSTOM_URI_QQMAP = "qqmap://map/search?type=drive&keyword=%1$s";
        public static final String CUSTOM_URI_WAZEMAP = "https://waze.com/ul?q=%1$s&navigate=yes";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MapPackageName {
        public static final String PACKAGE_NAME_AMAP = "com.autonavi.minimap";
        public static final String PACKAGE_NAME_BAIDUMAP = "com.baidu.BaiduMap";
        public static final String PACKAGE_NAME_GOOGLEMAP = "com.google.android.apps.maps";
        public static final String PACKAGE_NAME_QQMAP = "com.tencent.map";
        public static final String PACKAGE_NAME_WAZE = "com.waze";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MapRouteURI {
        public static final String URI_AMAP = "amapuri://route/plan/?dlat=%1$s&dlon=%2$s&dname=%3$s&dev=0&t=0";
        public static final String URI_BAIDUMAP = "baidumap://map/direction?destination=name:%1$s|latlng:%2$s,%3$s&coord_type=gcj02&mode=driving";
        public static final String URI_GOOGLEMAP = "https://www.google.com/maps/dir/?api=1&destination=%1$s/%2$s&travelmode=drive";
        public static final String URI_QQMAP = "qqmap://map/routeplan?type=drive&to=%1$s&tocoord=%2$s,%3$s";
        public static final String URI_WAZEMAP = "https://waze.com/ul?ll=%1$s,%2$s&navigate=yes";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MapType {
        public static final int AMAP = 0;
        public static final int BAIDUMAP = 1;
        public static final int GOOGLEMAP = 3;
        public static final int QQMAP = 2;
        public static final int WAZEMAP = 4;
    }

    public static boolean a(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return false;
    L11:
        r100.getPackageManager().getApplicationInfo(r101, 8192);     // Catch: PackageManager.NameNotFoundException -> L8
        return true;
    L8:
        e = move-exception;
        Log.e("MapRouteService", "isInstalled called, e:" + e);
        return false;
    }

    public static void b(Context r110, d r111, String r112, String r113, String r114) {
        int r100 = r111.getType();
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L12;
        if (r100 != 3) goto L8;
        String r101 = "google";
    L45:
        Statistics.sendEvent(NavigateHitPoint$Event.MESSAGE_LOCATION_NAVIGATION, new JSONObject().put("navigation_map_type", r101));     // Catch: JSONException -> L17
    L19:
        Intent r102 = new Intent();
        r102.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r102.setPackage(r111.f431357b);
        r102.addCategory("android.intent.category.DEFAULT");
        if (oqb.c.a(r113) != 360.0d) goto L22;
    L34:
        String r103 = String.format(r111.f431359d, new Object[]{r112});
    L36:
        if (TextUtils.isEmpty(r103) == false) goto L38;
        return;
    L38:
        r102.setData(UriProtector.parse(r103));
        if ((r110 instanceof Activity) == true) goto L42;
        r102.addFlags(268435456);
    L42:
        if (r102.resolveActivity(r110.getPackageManager()) == null) goto L47;
        r110.startActivity(r102);
        return;
    L47:
        return;
    L22:
        if (oqb.c.a(r114) == 360.0d) goto L34;
        r103 = String.format(r111.f431358c, new Object[]{r113, r114, r112});
        int r104 = r111.f431356a;
        if (r104 != 1) goto L27;
        boolean r105 = true;
    L28:
        if (r105 == true) goto L33;
        if (r104 != 2) goto L31;
        boolean r106 = true;
    L32:
        if (r106 == false) goto L36;
    L31:
        r106 = false;
    L33:
        r103 = String.format(r111.f431358c, new Object[]{r112, r113, r114});
        goto L36
    L27:
        r105 = false;
    L17:
        e = move-exception;
        Log.d("sendNavigationClick failed to e:" + e);
        goto L19
    L8:
        if (r100 == 4) goto L10;
        r101 = "none";
        goto L45
    L10:
        r101 = NavigateHitPoint$MapType.WAZE;
        goto L45
    L12:
        r101 = "tencent";
        goto L45
    L13:
        r101 = "baidu";
        goto L45
    L14:
        r101 = "gaode";
        goto L45
    }
}
