package n4a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class s4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f517730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f517731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AMapLocationClient f517732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WebView f517733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f517734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AMapLocationClientOption f517735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f517736g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f517737h;

    public class a implements AMapLocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s4 f517738a;

        public a(s4 r100) {
            this.f517738a = r100;
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation r210) {
            ArrayList r100 = new ArrayList();
            Object[] r110 = {r210};
            f06.b r111 = new f06.b();
            g06.a r101 = ApiHookConfig.f245611b.get(101329);
            if (r101 == null) goto L5;
            f06.a[] r102 = r101.f479473i;
        L6:
            f06.a[] r103 = r102;
            int r104 = r103.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r103[r105];
            int r112 = r105;
            int r113 = r104;
            f06.a[] r114 = r103;
            f06.d r107 = r106.preInvoke(101329, "com/loc/i$a", "onLocationChanged", this, r110, "void", r111);     // Catch: Exception -> L39
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L39
        L17:
            if (r107.f474982a == false) goto L20;
            return;
        L20:
            if (this.f517738a.f517736g == false) goto L48;
            s4 r108 = this.f517738a;
            JSONObject r109 = new JSONObject();
            String r115 = "errorInfo";
            if (r210 != null) goto L26;
            r109.put("errorCode", -1);     // Catch: Throwable -> L38
            String r116 = "unknownError";
        L29:
            r109.put(r115, r116);     // Catch: Throwable -> L38
            goto L30
        L26:
            if (r210.getErrorCode() != 0) goto L28;
            r109.put("errorCode", 0);     // Catch: Throwable -> L38
            JSONObject r117 = new JSONObject();     // Catch: Throwable -> L38
            r117.put("x", r210.getLongitude());     // Catch: Throwable -> L38
            r117.put("y", r210.getLatitude());     // Catch: Throwable -> L38
            r117.put("precision", r210.getAccuracy());     // Catch: Throwable -> L38
            r117.put("type", r210.getLocationType());     // Catch: Throwable -> L38
            r117.put(DistrictSearchQuery.KEYWORDS_COUNTRY, r210.getCountry());     // Catch: Throwable -> L38
            r117.put("province", r210.getProvince());     // Catch: Throwable -> L38
            r117.put("city", r210.getCity());     // Catch: Throwable -> L38
            r117.put("cityCode", r210.getCityCode());     // Catch: Throwable -> L38
            r117.put(DistrictSearchQuery.KEYWORDS_DISTRICT, r210.getDistrict());     // Catch: Throwable -> L38
            r117.put("adCode", r210.getAdCode());     // Catch: Throwable -> L38
            r117.put("street", r210.getStreet());     // Catch: Throwable -> L38
            r117.put("streetNum", r210.getStreetNum());     // Catch: Throwable -> L38
            r117.put("floor", r210.getFloor());     // Catch: Throwable -> L38
            r117.put("address", r210.getAddress());     // Catch: Throwable -> L38
            r109.put("result", r117);     // Catch: Throwable -> L38
            goto L30
        L28:
            r109.put("errorCode", r210.getErrorCode());     // Catch: Throwable -> L38
            r109.put("errorInfo", r210.getErrorInfo());     // Catch: Throwable -> L38
            r115 = "locationDetail";
            r116 = r210.getLocationDetail();     // Catch: Throwable -> L38
        L30:
            String r118 = r109.toString();
            r108.getClass();
            WebView r119 = r108.f517733d;     // Catch: Throwable -> L35
            if (r119 == null) goto L49;
            r119.evaluateJavascript("javascript:" + r108.f517734e + "('" + r118 + "')", new r4());     // Catch: Throwable -> L35
            return;
        L49:
            return;
        L35:
            th = move-exception;
            c4.g(th, "H5LocationClient", "callbackJs()");
            return;
        L48:
            return;
        L14:
            r105 = r112 + 1;
            r104 = r113;
            r103 = r114;
            goto L8
        L15:
            r107 = new f06.d(false, null);
            goto L17
        L5:
            r102 = ApiHookConfig.f245613d;
            goto L6
        }
    }

    public s4(Context r100, WebView r101) {
        this.f517730a = new Object();
        this.f517732c = null;
        this.f517733d = null;
        this.f517734e = "AMap.Geolocation.cbk";
        this.f517735f = null;
        this.f517736g = false;
        this.f517737h = null;
        this.f517731b = r100.getApplicationContext();
        this.f517733d = r101;
        this.f517737h = new a(this);
    }

    public final void a(String r110) {
        if (this.f517735f != null) goto L5;
        this.f517735f = new AMapLocationClientOption();
    L5:
        int r100 = 5;
        long r101 = 30000;
        boolean r102 = true;
        JSONObject r103 = new JSONObject(r110);     // Catch: Throwable -> L19
        r101 = r103.optLong(RemoteMessageConst.TO, 30000);     // Catch: Throwable -> L19
        if (r103.optInt("useGPS", 1) != 1) goto L9;
        boolean r111 = true;
    L41:
        if (r103.optInt("watch", 0) != 1) goto L13;
        boolean r104 = true;
    L43:
        r100 = r103.optInt(VideoThumbInfo.KEY_INTERVAL, 5);     // Catch: Throwable -> L34
        String r105 = r103.optString("callback", null);     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r105) == true) goto L17;
    L16:
        this.f517734e = r105;     // Catch: Throwable -> L34
        goto L37
    L17:
        r105 = "AMap.Geolocation.cbk";
    L37:
        this.f517735f.setHttpTimeOut(r101);     // Catch: Throwable -> L35
        if (r111 == false) goto L25;
        AMapLocationClientOption r112 = this.f517735f;     // Catch: Throwable -> L35
        AMapLocationClientOption.AMapLocationMode r106 = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;     // Catch: Throwable -> L35
    L24:
        r112.setLocationMode(r106);     // Catch: Throwable -> L35
        AMapLocationClientOption r113 = this.f517735f;     // Catch: Throwable -> L35
        if (r104 == false) goto L30;
        r102 = false;
    L30:
        r113.setOnceLocation(r102);     // Catch: Throwable -> L35
        if (r104 == false) goto L45;
        this.f517735f.setInterval(r100 * 1000);     // Catch: Throwable -> L35
        return;
    L45:
        return;
    L25:
        r112 = this.f517735f;     // Catch: Throwable -> L35
        r106 = AMapLocationClientOption.AMapLocationMode.Battery_Saving;     // Catch: Throwable -> L35
    L46:
        return;
    L13:
        r104 = false;
    L20:
        r104 = false;
        goto L37
    L9:
        r111 = false;
    L19:
        r111 = false;
        goto L20
    }

    public final void b() {
        Object r100 = this.f517730a;
        monitor-enter(r100);
        this.f517736g = false;     // Catch: Throwable -> L11
        AMapLocationClient r101 = this.f517732c;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        r101.unRegisterLocationListener(this.f517737h);     // Catch: Throwable -> L11
        this.f517732c.stopLocation();     // Catch: Throwable -> L11
        this.f517732c.onDestroy();     // Catch: Throwable -> L11
        this.f517732c = null;     // Catch: Throwable -> L11
    L8:
        this.f517735f = null;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @JavascriptInterface
    public final void getLocation(String r100) {
        Object r101 = this.f517730a;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f517736g == true) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L8:
        a(r100);     // Catch: Throwable -> L13
        AMapLocationClient r102 = this.f517732c;     // Catch: Throwable -> L13
        if (r102 == null) goto L11;
        r102.setLocationOption(this.f517735f);     // Catch: Throwable -> L13
        this.f517732c.stopLocation();     // Catch: Throwable -> L13
        this.f517732c.startLocation();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    @JavascriptInterface
    public final void stopLocation() {
        if (this.f517736g == true) goto L5;
        return;
    L5:
        AMapLocationClient r100 = this.f517732c;
        if (r100 == null) goto L9;
        r100.stopLocation();
        return;
    }
}
