package com.bytedance.baidumap.model.mapview;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.CustomMapStyleCallBack;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapCustomStyleOptions;
import com.baidu.mapapi.map.MapView;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDMapStyleOptions;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MapView f199523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f199524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f199525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f199526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f199527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f199528f;

    /* JADX INFO: renamed from: com.bytedance.baidumap.model.mapview.a$a, reason: collision with other inner class name */
    public class C2880a implements CustomMapStyleCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f199529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f199530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f199531c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f199532d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CustomStyleLoadTrace f199533e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f199534f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f199535g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ a f199536h;

        @Override // com.baidu.mapapi.map.CustomMapStyleCallBack
        public final boolean onPreLoadLastCustomMapStyle(String r100) {
            MapLogger.i("BaiduMapView", "onPreLoadLastCustomMapStyle styleId=" + this.f199529a + ", attempt=" + this.f199530b + ", operationId=" + this.f199531c + ", customStylePath:" + r100 + ", cost=" + (SystemClock.elapsedRealtime() - this.f199532d));
            return false;
        }

        @Override // com.baidu.mapapi.map.CustomMapStyleCallBack
        public final boolean onCustomMapStyleLoadSuccess(boolean r110, String r111) {
            long r100 = SystemClock.elapsedRealtime();
            MapLogger.i("BaiduMapView", "onCustomMapStyleLoadSuccess styleId=" + this.f199529a + ", attempt=" + this.f199530b + ", operationId=" + this.f199531c + ", hasUpdate:" + r110 + ", customStylePath:" + r111 + ", cost=" + (r100 - this.f199532d));
            a r112 = this.f199536h;
            CustomStyleLoadTrace r113 = this.f199533e;
            boolean r101 = this.f199534f;
            long r102 = r100 - this.f199532d;
            if (r113 != null) goto L5;
            r112.getClass();
            MapLogger.i("BaiduMapView", "custom style success report skipped, trace is null");
            return false;
        L5:
            if (r101 == false) goto L7;
            r113.a(EventConstant.Value.RETRY, "retry_success", r112.f199528f, r102, r111);
        L8:
            r113.c();
            return false;
        L7:
            r113.a(SoloKtvContext.SOLO_PAGE_FIRST, "first_success", r112.f199528f, r102, r111);
            goto L8
        }

        @Override // com.baidu.mapapi.map.CustomMapStyleCallBack
        public final boolean onCustomMapStyleLoadFailed(int r110, String r210, String r211) {
            MapLogger.i("BaiduMapView", "onCustomMapStyleLoadFailed styleId=" + this.f199529a + ", attempt=" + this.f199530b + ", operationId=" + this.f199531c + ", status:" + r110 + ", message:" + r210 + ", customStylePath:" + r211 + ", cost=" + (SystemClock.elapsedRealtime() - this.f199532d));
            a r100 = this.f199536h;
            CustomStyleLoadTrace r111 = this.f199533e;
            String r112 = this.f199529a;
            String r113 = this.f199535g;
            String r101 = this.f199530b;
            long r114 = this.f199532d;
            int r102 = this.f199531c;
            r100.getClass();
            if (r111 != null) goto L5;
            MapLogger.i("BaiduMapView", "custom style failure skipped, trace is null: styleId=" + r112 + ", attempt=" + r101 + ", errorCode=" + r110 + ", errorMsg=" + r210);
            return false;
        L5:
            boolean r103 = EventConstant.Value.RETRY.equals(r101);
            if (r100.f199528f == false) goto L8;
            String r104 = "destroyed";
        L9:
            long r115 = SystemClock.elapsedRealtime() - r114;
            if (r103 == false) goto L12;
            boolean r116 = r100.f199528f;
            Integer r105 = Integer.valueOf(r110);
            r111.a(EventConstant.Value.RETRY, MapMonitorConst.RETRY_FAIL, r116, r115, r211);
            r111.f199515m = r105;
            r111.f199516n = r210;
            r111.c();
            return false;
        L12:
            r111.f199519q = Integer.valueOf(r110);
            r111.f199520r = r210;
            r111.f199521s = r115;
            if (r104 == null) goto L15;
            MapLogger.i("BaiduMapView", "custom style retry skipped: styleId=" + r112 + ", skipReason=" + r104);
            r111.b(r100.f199528f, r104, Integer.valueOf(r110), r210, r115, r211);
            r111.c();
            return false;
        L15:
            MapLogger.i("BaiduMapView", "custom style retry scheduled: styleId=" + r112 + ", operationId=" + r102 + ", delay=300");
            r100.f199524b.postDelayed(new com.bytedance.baidumap.model.mapview.b(r100, r102, r112, r111, r113), 300);
            return false;
        L8:
            r104 = null;
            goto L9
        }

        public C2880a(a r100, String r101, String r102, int r103, long r104, CustomStyleLoadTrace r105, boolean r106, String r107) {
            this.f199536h = r100;
            this.f199529a = r101;
            this.f199530b = r102;
            this.f199531c = r103;
            this.f199532d = r104;
            this.f199533e = r105;
            this.f199534f = r106;
            this.f199535g = r107;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f199537a = null;

        static {
            int[] r100 = new int[LogoPosition.values().length];
            f199537a = r100;
            r100[LogoPosition.logoPostionleftBottom.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f199537a[LogoPosition.logoPostionCenterBottom.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f199537a[LogoPosition.logoPostionRightBottom.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f199537a[LogoPosition.logoPostionleftTop.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f199537a[LogoPosition.logoPostionCenterTop.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f199537a[LogoPosition.logoPostionRightTop.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final void onDestroy() {
        this.f199528f = true;
        MapView r100 = this.f199523a;
        if (r100 == null) goto L6;
        r100.onDestroy();
        return;
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final void b() {
        MapView r100 = this.f199523a;
        if (r100 == null) goto L6;
        r100.getMap();
        return;
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final boolean d() {
        MapView r100 = this.f199523a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isShowScaleControl();
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final boolean g() {
        MapView r100 = this.f199523a;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getMap() != null) goto L8;
        return false;
    L8:
        return this.f199527e;
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final int getLogoPosition() {
        MapView r100 = this.f199523a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        LogoPosition r101 = r100.getLogoPosition();
        if (r101 != null) goto L9;
        return 0;
    L9:
        switch(b.f199537a[r101.ordinal()]) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L17;
        };
    L11:
        return 5;
    L12:
        return 4;
    L13:
        return 3;
    L14:
        return 2;
    L15:
        return 1;
    L17:
        return 0;
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final BaiduMap getMap() {
        MapView r100 = this.f199523a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMap();
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final Point getScaleControlPosition() {
        MapView r100 = this.f199523a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getScaleControlPosition();
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final boolean i() {
        if (this.f199523a != null) goto L7;
        return false;
    L7:
        return this.f199526d;
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final void onPause() {
        MapView r100 = this.f199523a;
        if (r100 == null) goto L6;
        r100.onPause();
        return;
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final void onResume() {
        MapView r100 = this.f199523a;
        if (r100 == null) goto L6;
        r100.onResume();
        return;
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final View getRealMapView() {
        return this.f199523a;
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final void a(boolean r100) {
        MapView r101 = this.f199523a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.showZoomControls(r100);
        this.f199526d = r100;
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final void c(boolean r100) {
        MapView r101 = this.f199523a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getMap() != null) goto L7;
        return;
    L7:
        if (this.f199523a.getMap().getUiSettings() == null) goto L13;
        this.f199523a.getMap().getUiSettings().setEnlargeCenterWithDoubleClickEnable(r100);
        this.f199527e = r100;
        return;
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final void h(boolean r100) {
        MapView r101 = this.f199523a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.showScaleControl(r100);
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final void onSaveInstanceState(Bundle r100) {
        MapView r101 = this.f199523a;
        if (r101 == null) goto L6;
        r101.onSaveInstanceState(r100);
        return;
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final void setLogoPosition(int r100) {
        MapView r101 = this.f199523a;
        if (r101 != null) goto L5;
        return;
    L5:
        LogoPosition r102 = LogoPosition.logoPostionleftBottom;
        if (r100 != 1) goto L8;
        r102 = LogoPosition.logoPostionCenterBottom;
    L21:
        r101.setLogoPosition(r102);
        return;
    L8:
        if (r100 != 2) goto L10;
        r102 = LogoPosition.logoPostionRightBottom;
        goto L21
    L10:
        if (r100 != 3) goto L12;
        r102 = LogoPosition.logoPostionleftTop;
        goto L21
    L12:
        if (r100 != 4) goto L14;
        r102 = LogoPosition.logoPostionCenterTop;
        goto L21
    L14:
        if (r100 != 5) goto L21;
        r102 = LogoPosition.logoPostionRightTop;
        goto L21
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final void setScaleControlPosition(Point r100) {
        MapView r101 = this.f199523a;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.setScaleControlPosition(r100);
        return;
    L9:
        return;
    }

    public a(Context r100, BaiduMapOptions r101) {
        this.f199524b = new Handler(Looper.getMainLooper());
        this.f199525c = new AtomicInteger(0);
        this.f199526d = false;
        this.f199527e = false;
        this.f199528f = false;
        this.f199523a = new MapView(r100, r101);
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final void e(BDMapStyleOptions r110, CustomStyleLoadTrace r111) {
        long r100 = SystemClock.elapsedRealtime();
        int r101 = this.f199525c.incrementAndGet();
        if (this.f199523a == null) goto L22;
        if (r110 == null) goto L22;
        boolean r102 = r110.isEnable();
        String r112 = r110.getStyleId();
        this.f199523a.setMapCustomStyleEnable(r102);
        if (r102 == true) goto L10;
        MapLogger.i("BaiduMapView", "setCustomMapStyle options disabled: styleId=" + r112 + ", cost=" + (SystemClock.elapsedRealtime() - r100));
        CustomStyleLoadTrace.StyleSource r113 = k(r112, r110.getStyleDataPath());
        r111.f199507e = "MapView";
        r111.f199508f = r113;
        r111.a(SoloKtvContext.SOLO_PAGE_FIRST, "disabled", this.f199528f, SystemClock.elapsedRealtime() - r100, null);
        r111.c();
        return;
    L10:
        String r103 = r110.getStyleDataPath();
        if (r112 != null) goto L13;
    L14:
        if (r103 != null) goto L16;
    L20:
        MapLogger.i("BaiduMapView", "setCustomMapStyle options skipped, empty style config, cost=" + (SystemClock.elapsedRealtime() - r100));
        CustomStyleLoadTrace.StyleSource r114 = CustomStyleLoadTrace.StyleSource.UNKNOWN;
        r111.f199507e = "MapView";
        r111.f199508f = r114;
        r111.b(this.f199528f, "invalid_style", null, null, -1, null);
        r111.c();
        return;
    L16:
        if (r103.isEmpty() == true) goto L20;
    L18:
        CustomStyleLoadTrace.StyleSource r115 = k(r112, r103);
        r111.f199507e = "MapView";
        r111.f199508f = r115;
        l(r111, r112, r103, SoloKtvContext.SOLO_PAGE_FIRST, r101);
        MapLogger.i("BaiduMapView", "setCustomMapStyle options finish sdk call: styleId=" + r112 + ", operationId=" + r101 + ", cost=" + (SystemClock.elapsedRealtime() - r100));
        return;
    L13:
        if (r112.isEmpty() == false) goto L18;
    L22:
        StringBuilder r116 = new StringBuilder("setCustomMapStyle options skipped, mMapView/options is null: optionsNull=");
        if (r110 != null) goto L25;
        boolean r117 = true;
    L26:
        r116.append(r117);
        r116.append(", operationId=");
        r116.append(r101);
        r116.append(", cost=");
        r116.append(SystemClock.elapsedRealtime() - r100);
        MapLogger.i("BaiduMapView", r116.toString());
        return;
    L25:
        r117 = false;
        goto L26
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final void j(Context r100, Bundle r101) {
        this.f199528f = false;
        MapView r102 = this.f199523a;
        if (r102 == null) goto L6;
        r102.onCreate(r100, r101);
        return;
    }

    public final CustomStyleLoadTrace.StyleSource k(String r100, String r101) {
        boolean r102 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r101 != null) goto L10;
    L12:
        r102 = false;
    L13:
        if (r103 == false) goto L17;
        if (r102 == false) goto L17;
        return CustomStyleLoadTrace.StyleSource.MIXED;
    L17:
        if (r103 == true) goto L19;
        if (r102 == false) goto L24;
        return CustomStyleLoadTrace.StyleSource.LOCAL;
    L24:
        return CustomStyleLoadTrace.StyleSource.UNKNOWN;
    L19:
        return CustomStyleLoadTrace.StyleSource.ONLINE;
    L10:
        if (r101.isEmpty() == true) goto L12;
    L5:
        if (r100.isEmpty() == true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.bytedance.baidumap.model.mapview.e
    public final void f(boolean r110, String r111, CustomStyleLoadTrace r112) {
        long r100 = SystemClock.elapsedRealtime();
        int r101 = this.f199525c.incrementAndGet();
        MapView r102 = this.f199523a;
        if (r102 != null) goto L6;
        MapLogger.i("BaiduMapView", "setCustomMapStyle skipped, mMapView is null: enable=" + r110 + ", styleId=" + r111 + ", operationId=" + r101 + ", cost=" + (SystemClock.elapsedRealtime() - r100));
        return;
    L6:
        r102.setMapCustomStyleEnable(r110);
        if (r110 == true) goto L10;
        MapLogger.i("BaiduMapView", "setCustomMapStyle disabled: styleId=" + r111 + ", cost=" + (SystemClock.elapsedRealtime() - r100));
        CustomStyleLoadTrace.StyleSource r113 = k(r111, null);
        r112.f199507e = "MapView";
        r112.f199508f = r113;
        r112.a(SoloKtvContext.SOLO_PAGE_FIRST, "disabled", this.f199528f, SystemClock.elapsedRealtime() - r100, null);
        r112.c();
        return;
    L10:
        if (r111 != null) goto L12;
    L16:
        MapLogger.i("BaiduMapView", "setCustomMapStyle skipped, empty styleId, cost=" + (SystemClock.elapsedRealtime() - r100));
        CustomStyleLoadTrace.StyleSource r114 = CustomStyleLoadTrace.StyleSource.UNKNOWN;
        r112.f199507e = "MapView";
        r112.f199508f = r114;
        r112.b(this.f199528f, "invalid_style", null, null, SystemClock.elapsedRealtime() - r100, null);
        r112.c();
        return;
    L12:
        if (r111.isEmpty() == true) goto L16;
        CustomStyleLoadTrace.StyleSource r115 = CustomStyleLoadTrace.StyleSource.ONLINE;
        r112.f199507e = "MapView";
        r112.f199508f = r115;
        l(r112, r111, null, SoloKtvContext.SOLO_PAGE_FIRST, r101);
        MapLogger.i("BaiduMapView", "setCustomMapStyle finish sdk call: styleId=" + r111 + ", operationId=" + r101 + ", cost=" + (SystemClock.elapsedRealtime() - r100));
    }

    public final void l(CustomStyleLoadTrace r110, String r111, String r112, String r113, int r210) {
        long r100 = SystemClock.elapsedRealtime();
        boolean r101 = EventConstant.Value.RETRY.equals(r113);
        MapLogger.i("BaiduMapView", "setCustomMapStyle attempt start: attempt=" + r113 + ", styleId=" + r111 + ", operationId=" + r210);
        boolean r114 = false;
        if (this.f199523a != null) goto L5;
        boolean r102 = true;
    L6:
        boolean r115 = this.f199528f;
        if (r102 == true) goto L21;
        if (r115 == true) goto L21;
        MapView r116 = this.f199523a;
        MapCustomStyleOptions r117 = new MapCustomStyleOptions();
        if (r111 != null) goto L13;
    L15:
        if (r112 != null) goto L17;
    L19:
        r116.setMapCustomStyle(r117, new C2880a(this, r111, r113, r210, r100, r110, r101, r112));
        return;
    L17:
        if (r112.isEmpty() == true) goto L19;
        r117.localCustomStylePath(r112);
        goto L19
    L13:
        if (r111.isEmpty() == true) goto L15;
        r117.customStyleId(r111);
    L21:
        StringBuilder r103 = new StringBuilder("setCustomMapStyle attempt skipped, map view unavailable: attempt=");
        r103.append(r113);
        r103.append(", styleId=");
        r103.append(r111);
        r103.append(", operationId=");
        r103.append(r210);
        r103.append(", mapViewNull=");
        r103.append(r102);
        r103.append(", isDestroyed=");
        r103.append(r115);
        r103.append(", traceNull=");
        if (r110 != null) goto L24;
        r114 = true;
    L24:
        r103.append(r114);
        r103.append(", cost=");
        r103.append(SystemClock.elapsedRealtime() - r100);
        MapLogger.i("BaiduMapView", r103.toString());
        if (r110 != null) goto L27;
        return;
    L27:
        if (r115 == false) goto L29;
        String r104 = "destroyed";
    L31:
        if (r102 == false) goto L33;
        String r105 = "map_view_null";
    L34:
        r110.b(r115, r104, null, r105, SystemClock.elapsedRealtime() - r100, null);
        r110.c();
        return;
    L33:
        r105 = null;
        goto L34
    L29:
        r104 = null;
        goto L31
    L5:
        r102 = false;
        goto L6
    }
}
