package com.bytedance.map.api;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.map.api.animation.AnimationStyle;
import com.bytedance.map.api.cache.BDMapServicePool;
import com.bytedance.map.api.edit.EditHandler;
import com.bytedance.map.api.listener.CancelableCallback;
import com.bytedance.map.api.listener.FirstMapTileLoadedListener;
import com.bytedance.map.api.listener.MapActionListener;
import com.bytedance.map.api.listener.MapActionReasonListener;
import com.bytedance.map.api.listener.MapScreenShotListener;
import com.bytedance.map.api.listener.MapShotStatusListener;
import com.bytedance.map.api.listener.MarkerActionListener;
import com.bytedance.map.api.listener.PoiClickListener;
import com.bytedance.map.api.listener.PolygonClickListener;
import com.bytedance.map.api.listener.PolygonEditListener;
import com.bytedance.map.api.listener.PolylineClickListener;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDArcOptions;
import com.bytedance.map.api.model.BDCircleOptions;
import com.bytedance.map.api.model.BDHeatMapOptions;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.BDLocationOverlayConfig;
import com.bytedance.map.api.model.BDMapStyleOptions;
import com.bytedance.map.api.model.BDMapStyleType;
import com.bytedance.map.api.model.BDMapUiConfigs;
import com.bytedance.map.api.model.BDMarkerOptions;
import com.bytedance.map.api.model.BDPolygonOptions;
import com.bytedance.map.api.model.BDPolylineOptions;
import com.bytedance.map.api.model.BDTextPathOptions;
import com.bytedance.map.api.model.IArc;
import com.bytedance.map.api.model.ICircle;
import com.bytedance.map.api.model.IHeatMap;
import com.bytedance.map.api.model.IMarker;
import com.bytedance.map.api.model.IPolygon;
import com.bytedance.map.api.model.IPolyline;
import com.bytedance.map.api.model.ITextPath;
import com.bytedance.map.api.monitor.MapMonitor;
import com.bytedance.map.api.plugin.MapPluginManager;
import com.bytedance.map.api.trace.MapTraceReporter;
import com.bytedance.map.api.utils.OptionsMapParser;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class BDMapClient implements MapActionListener, MarkerActionListener {
    private static final String TAG = "BDMapClient";
    private Context mContext;
    private long mCreateTime;
    private EditHandler mEditHandler;
    private boolean mIsMapServiceReused;
    private IMapService mMapService;
    private int mMapType;
    private ViewGroup mParentView;
    private MapTraceReporter mTraceReporter;

    @Override // com.bytedance.map.api.listener.MapActionListener
    public void onMapClick(BDLatLng r100) {
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public void onMapMove(BDLatLng r100) {
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public void onMapZoom(float r100) {
    }

    private boolean shouldRecycleOnDestroy() {
        ViewGroup r100 = this.mParentView;
        if (r100 != null) goto L6;
        MapLogger.i(TAG, "recycle disabled on destroy: parentView is null");
        return false;
    L6:
        int r101 = r100.getWidth();
        if (r101 > 0) goto L11;
        MapLogger.i(TAG, "recycle disabled on destroy: parentWidth=" + r101);
        return false;
    L11:
        if (isFullPageWidth(r101) == false) goto L14;
        MapLogger.i(TAG, "recycle disabled on destroy: full page parentWidth=" + r101);
        return false;
    L14:
        return true;
    }

    public void clear() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.clear();
    }

    public BDLatLng getCenter() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCenter();
    }

    public int getLogoPosition() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getLogoPosition();
    }

    public Bitmap getMapScreenShotFromCache() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMapScreenShotFromCache();
    }

    public int getMapType() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getMapType();
    }

    public List<IMarker> getMarkers() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMarkers();
    }

    public float getMaxZoomLevel() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return -1.0f;
    L7:
        return r100.getMaxZoomLevel();
    }

    public float getMinZoomLevel() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return -1.0f;
    L7:
        return r100.getMinZoomLevel();
    }

    public View getRealMapView() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRealMapView();
    }

    public float getRotationDegree() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        MapLogger.e(TAG, "BDMapClient.getRotationDegree: mMapService == null, return -1.0f, init?");
        return -1.0f;
    L7:
        return r100.getRotationDegree();
    }

    public Point getScaleControlPosition() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getScaleControlPosition();
    }

    public float getScalePerPixel() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return -1.0f;
    L7:
        return r100.getScalePerPixel();
    }

    public BDMapUiConfigs getUiSettings() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getUiSettings();
    }

    public Map<String, Double> getVisibleRegion() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getVisibleRegion();
    }

    public float getZoom() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getZoom();
    }

    public int getZoomPosition() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return 2;
    L7:
        return r100.getZoomPosition();
    }

    public boolean isCompassEnabled() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isCompassEnabled();
    }

    public boolean isGestureScaleByMapCenter() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isGestureScaleByMapCenter();
    }

    public boolean isIndoorSwitchEnabled() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isIndoorSwitchEnabled();
    }

    public boolean isInit() {
        if (this.mMapService == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isMyLocationButtonEnabled() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isMyLocationButtonEnabled();
    }

    public boolean isPoiClickEnabled() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isPoiClickEnabled();
    }

    public boolean isRotateGesturesEnabled() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isRotateGesturesEnabled();
    }

    public boolean isScaleControlsEnabled() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isScaleControlsEnabled();
    }

    public boolean isScrollGesturesEnabled() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isScrollGesturesEnabled();
    }

    public boolean isSupportSetRotation() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        MapLogger.e(TAG, "BDMapClient.isSupportSetRotation: mMapService == null, init?");
        return false;
    L7:
        return r100.isSupportSetRotation();
    }

    public boolean isTiltGesturesEnabled() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isTiltGesturesEnabled();
    }

    public boolean isZoomControlsEnabled() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isZoomControlsEnabled();
    }

    public boolean isZoomGesturesEnabled() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isZoomGesturesEnabled();
    }

    public synchronized void onDestroy() {
        monitor-enter(this);
        StringBuilder r100 = new StringBuilder("onDestroy mapServiceNull=");     // Catch: Throwable -> L26
        boolean r101 = true;
        if (this.mMapService != null) goto L7;
        boolean r102 = true;
    L8:
        r100.append(r102);     // Catch: Throwable -> L26
        r100.append(", traceReporterNull=");     // Catch: Throwable -> L26
        if (this.mTraceReporter == null) goto L12;
        r101 = false;
    L12:
        r100.append(r101);     // Catch: Throwable -> L26
        MapLogger.i(TAG, r100.toString());     // Catch: Throwable -> L26
        IMapService r103 = this.mMapService;     // Catch: Throwable -> L26
        if (r103 != null) goto L16;
        monitor-exit(this);
        return;
    L16:
        int r104 = r103.getMapType();     // Catch: Throwable -> L26
        IMapService r105 = this.mMapService;     // Catch: Throwable -> L26
        this.mMapService = null;     // Catch: Throwable -> L26
        this.mEditHandler = null;     // Catch: Throwable -> L26
        MapLogger.i(TAG, "onDestroy release map service to pool, mapType=" + r105.getMapType());     // Catch: Throwable -> L26
        r105.clear();     // Catch: Throwable -> L19
    L21:
        BDMapServicePool.release(this.mContext, r105, shouldRecycleOnDestroy());     // Catch: Throwable -> L26
        MapMonitor.destroyMap();     // Catch: Throwable -> L26
        MapMonitor.uploadMapDisplayTime(SystemClock.elapsedRealtime() - this.mCreateTime);     // Catch: Throwable -> L26
        MapTraceReporter r106 = this.mTraceReporter;     // Catch: Throwable -> L26
        if (r106 == null) goto L24;
        r106.reportMapDestroy(r104);     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        MapLogger.i(TAG, "onDestroy clear failed", th);     // Catch: Throwable -> L26
        goto L21
    L7:
        r102 = false;
    L26:
        th = move-exception;
        throw th;
    }

    public void onLowMemory() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.onLowMemory();
    }

    public void onPause() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.onPause();
    }

    public void onResume() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.onResume();
    }

    public void onStart() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.onStart();
    }

    public void onStop() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.onStop();
    }

    public void removeAllArcs() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeAllArcs();
    }

    public void removeAllCircles() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeAllCircles();
    }

    public void removeAllHeatMaps() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeAllHeatMaps();
    }

    public void removeAllMarkers() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeAllMarkers();
    }

    public void removeAllPolygons() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeAllPolygons();
    }

    public void removeAllPolylines() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeAllPolylines();
    }

    public void removeAllTextPaths() {
        IMapService r100 = this.mMapService;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeAllTextPaths();
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public void onMapLoad() {
        int r100 = getMapType();
        StringBuilder r101 = new StringBuilder("onMapLoad traceReporterNull=");
        if (this.mTraceReporter != null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        r101.append(", mapType=");
        r101.append(r100);
        MapLogger.i(TAG, r101.toString());
        MapTraceReporter r103 = this.mTraceReporter;
        if (r103 == null) goto L10;
        r103.reportMapLoadFinish(MapTraceReporter.MapLoadFinishReason.SUCCESS, r100, this.mIsMapServiceReused);
        return;
    L10:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public BDMapClient(MapInitConfig r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        applyAliMapOverride(r100);
        MapTraceReporter r101 = new MapTraceReporter(r100.getExtraParams());
        this.mTraceReporter = r101;
        r101.reportMapLoadStart(r100);
        Context r102 = r100.getContext();
        this.mContext = r102;
        new MapPluginManager(r102).installAndLoadMapPlugin(null);
        this.mMapType = r100.getMapType();
        BDMapServicePool.AcquireResult r103 = BDMapServicePool.acquireWithResult(r100);
        this.mMapService = r103.getService();
        this.mIsMapServiceReused = r103.isReused();
        this.mEditHandler = new EditHandler(this.mContext, this);
        if (this.mMapService == null) goto L8;
        this.mCreateTime = SystemClock.elapsedRealtime();
        this.mMapService.addMapActionListener(this);
        this.mMapService.addMarkerActionListener(this);
        return;
    L8:
        this.mTraceReporter.reportMapLoadFinish(MapTraceReporter.MapLoadFinishReason.INIT_FAILED, this.mMapType, this.mIsMapServiceReused);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_map_api_BDMapClient_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static void applyAliMapOverride(MapInitConfig r100) {
        Map<String, Object> r101 = r100.getExtraParams();
        if (r101 != null) goto L5;
        return;
    L5:
        if (Boolean.TRUE.equals(r101.get("useAliMap")) == false) goto L9;
        r100.setMapType(1);
        return;
    }

    private boolean isFullPageWidth(int r100) {
        Context r101 = this.mContext;
        if (r101 == null) goto L18;
        if (r100 <= 0) goto L21;
        Resources r102 = r101.getResources();
        if (r102 != null) goto L9;
        return false;
    L9:
        DisplayMetrics r103 = INVOKEVIRTUAL_com_bytedance_map_api_BDMapClient_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r102);
        if (r103 == null) goto L19;
        int r104 = r103.widthPixels;
        if (r104 > 0) goto L15;
        return false;
    L15:
        if (r100 <= (r104 - 5)) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    L21:
        return false;
    L18:
        return false;
    }

    public IArc addArc(BDArcOptions r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.addArc(r100);
    }

    public ICircle addCircle(BDCircleOptions r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.addCircle(r100);
    }

    public void addFirstMapTileLoadedListener(FirstMapTileLoadedListener r100) {
        IMapService r101 = this.mMapService;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.addFirstMapTileLoadedListener(r100);
        return;
    L9:
        return;
    }

    public IHeatMap addHeatMap(BDHeatMapOptions r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.addHeatMap(r100);
    }

    public void addMapActionListener(MapActionListener r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.addMapActionListener(r100);
    }

    public void addMapActionReasonListener(MapActionReasonListener r100) {
        IMapService r101 = this.mMapService;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.addMapActionReasonListener(r100);
        return;
    L9:
        return;
    }

    public IMarker addMarker(BDMarkerOptions r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.addMarker(r100);
    }

    public void addMarkerActionListener(MarkerActionListener r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.addMarkerActionListener(r100);
    }

    public void addMarkers(List<BDMarkerOptions> r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.addMarkers(r100);
    }

    public void addPoiClickListener(PoiClickListener r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.addPoiClickListener(r100);
    }

    public IPolygon addPolygon(BDPolygonOptions r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.addPolygon(r100);
    }

    public void addPolygonClickListener(PolygonClickListener r100) {
        IMapService r101 = this.mMapService;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.addPolygonClickListener(r100);
        return;
    L9:
        return;
    }

    public void addPolygonEditListener(PolygonEditListener r100) {
        EditHandler r101 = this.mEditHandler;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setPolygonEditListener(r100);
    }

    public IPolyline addPolyline(BDPolylineOptions r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.addPolyline(r100);
    }

    public void addPolylineClickListener(PolylineClickListener r100) {
        IMapService r101 = this.mMapService;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.addPolylineClickListener(r100);
        return;
    L9:
        return;
    }

    public ITextPath addTextPath(BDTextPathOptions r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.addTextPath(r100);
    }

    public void attachToParentView(ViewGroup r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        this.mParentView = r100;
        r101.attachToParentView(r100);
    }

    public void endPolygonEdit(IPolygon r100) {
        EditHandler r101 = this.mEditHandler;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.resetEditState(r100);
    }

    public void getMapScreenShot(MapScreenShotListener r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.getMapScreenShot(r100);
    }

    public void launchMapShotToCache(MapShotStatusListener r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.launchMapShotToCache(r100);
    }

    public void onCreate(Bundle r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.onCreate(r100);
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public void onMapMoveEnd(BDLatLng r100) {
        MapMonitor.moveMap();
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public void onMapTouch(MotionEvent r100) {
        EditHandler r101 = this.mEditHandler;
        if (r101 == null) goto L6;
        r101.onTouchEvent(r100);
        return;
    }

    @Override // com.bytedance.map.api.listener.MapActionListener
    public void onMapZoomEnd(float r100) {
        MapMonitor.zoomMap();
    }

    @Override // com.bytedance.map.api.listener.MarkerActionListener
    public void onMarkerClick(IMarker r100) {
        MapMonitor.tapAnnotation();
        EditHandler r101 = this.mEditHandler;
        if (r101 == null) goto L6;
        r101.onPointClick(r100);
        return;
    }

    public void onSaveInstanceState(Bundle r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.onSaveInstanceState(r100);
    }

    public void removeArc(IArc r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.removeArc(r100);
    }

    public void removeCircle(ICircle r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.removeCircle(r100);
    }

    public void removeHeatMap(IHeatMap r100) {
        IMapService r101 = this.mMapService;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.removeHeatMap(r100);
        return;
    L9:
        return;
    }

    public void removeMarker(IMarker r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.removeMarker(r100);
    }

    public void removePolygon(IPolygon r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.removePolygon(r100);
    }

    public void removePolyline(IPolyline r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.removePolyline(r100);
    }

    public void removeTextPath(ITextPath r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.removeTextPath(r100);
    }

    public void setAllGesturesEnabled(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setAllGesturesEnabled(r100);
    }

    public void setCompassEnabled(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setCompassEnabled(r100);
    }

    public void setCustomMapStyle(BDMapStyleOptions r100) {
        IMapService r101 = this.mMapService;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.setCustomMapStyle(r100);
        return;
    L9:
        return;
    }

    public void setGestureScaleByMapCenter(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setGestureScaleByMapCenter(r100);
    }

    public void setHandleGesture(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setHandleGesture(r100);
    }

    public void setIndoorSwitchEnabled(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setIndoorSwitchEnabled(r100);
    }

    public void setLocationOverlay(BDLocationOverlayConfig r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setLocationOverlay(r100);
    }

    public void setLogoBottomMargin(int r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setLogoBottomMargin(r100);
    }

    public void setLogoLeftMargin(int r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setLogoLeftMargin(r100);
    }

    public void setLogoPosition(int r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setLogoPosition(r100);
    }

    public void setMaxZoomLevel(float r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setMaxZoomLevel(r100);
    }

    public void setMinZoomLevel(float r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setMinZoomLevel(r100);
    }

    public void setMonitorBizName(String r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setMonitorBizName(r100);
    }

    public void setMyLocationButtonEnabled(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setMyLocationButtonEnabled(r100);
    }

    public void setPoiClickEnabled(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setPoiClickEnabled(r100);
    }

    public void setRotateGesturesEnabled(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setRotateGesturesEnabled(r100);
    }

    public void setScaleControlPosition(Point r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setScaleControlPosition(r100);
    }

    public void setScaleControlsEnabled(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setScaleControlsEnabled(r100);
    }

    public void setScrollGesturesEnabled(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setScrollGesturesEnabled(r100);
    }

    public void setTiltGesturesEnabled(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setTiltGesturesEnabled(r100);
    }

    public void setTrafficEnabled(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setTrafficEnabled(r100);
    }

    public void setUiSettings(BDMapUiConfigs r100) {
        IMapService r101 = this.mMapService;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.setUiSettings(r100);
        return;
    L9:
        return;
    }

    public void setZoomControlsEnabled(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setZoomControlsEnabled(r100);
    }

    public void setZoomGesturesEnabled(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setZoomGesturesEnabled(r100);
    }

    public void setZoomInByScreenCenter(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setZoomInByScreenCenter(r100);
    }

    public void setZoomPosition(int r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setZoomPosition(r100);
    }

    public void showMapPoi(boolean r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.showMapPoi(r100);
    }

    public void startPolygonEdit(IPolygon r100) {
        EditHandler r101 = this.mEditHandler;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.initEditState(r100);
    }

    public Point transLatLngToPoint(BDLatLng r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.transLatLngToPoint(r100);
    }

    public BDLatLng transPointToLatLng(Point r100) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.transPointToLatLng(r100);
    }

    public void setCustomMapStyle(BDMapStyleType r100) {
        IMapService r101 = this.mMapService;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.setCustomMapStyle(r100);
        return;
    L9:
        return;
    }

    public IMarker addMarker(Map<String, Object> r100, Bitmap r101) {
        if (this.mMapService == null) goto L19;
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        BDMarkerOptions r102 = OptionsMapParser.parseMarkerOptions(r100);
        if (r102 != null) goto L10;
        return null;
    L10:
        r102.setIcon(r101);
        IMarker r103 = addMarker(r102);
        if (r103 != null) goto L13;
        return null;
    L13:
        List<AnimationStyle> r104 = OptionsMapParser.parseAnimations(r100);
        if (r104 != null) goto L16;
    L18:
        return r103;
    L16:
        if (r104.isEmpty() == true) goto L18;
        startMarkerAnimation(r103, r104);
    L19:
        return null;
    }

    public float calculateLineDistance(BDLatLng r100, BDLatLng r101) {
        IMapService r102 = this.mMapService;
        if (r102 != null) goto L7;
        return 0.0f;
    L7:
        return r102.calculateLineDistance(r100, r101);
    }

    public void setCenter(BDLatLng r100, boolean r101) {
        IMapService r102 = this.mMapService;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setCenter(r100, r101);
    }

    public void setCustomMapStyle(boolean r100, String r101) {
        IMapService r102 = this.mMapService;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setCustomMapStyle(r100, r101);
    }

    public void setLimitRegion(BDLatLng r100, BDLatLng r101) {
        IMapService r102 = this.mMapService;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setLimitRegion(r100, r101);
    }

    public boolean setMarkerIcon(IMarker r100, Bitmap r101) {
        IMapService r102 = this.mMapService;
        if (r102 == null) goto L9;
        if (r100 == null) goto L11;
        if (r101 != null) goto L8;
        return false;
    L8:
        return r102.setMarkerIcon(r100, r101);
    L11:
        return false;
    L9:
        return false;
    }

    public void setPointToCenter(int r100, int r101) {
        IMapService r102 = this.mMapService;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setPointToCenter(r100, r101);
    }

    public void setZoom(float r100, boolean r101) {
        IMapService r102 = this.mMapService;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setZoom(r100, r101);
    }

    public void startMarkerAnimation(IMarker r100, List<AnimationStyle> r101) {
        IMapService r102 = this.mMapService;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.startMarkerAnimation(r100, r101);
    }

    public void setBound(List<BDLatLng> r100, int r101, boolean r102) {
        IMapService r103 = this.mMapService;
        if (r103 != null) goto L5;
        return;
    L5:
        r103.setBound(r100, r101, r102);
    }

    public void setCenter(BDLatLng r100, boolean r101, int r102) {
        IMapService r103 = this.mMapService;
        if (r103 != null) goto L5;
        return;
    L5:
        r103.setCenter(r100, r101, r102);
    }

    public void setCenterAndZoom(BDLatLng r100, float r101, boolean r102) {
        IMapService r103 = this.mMapService;
        if (r103 == null) goto L8;
        if (r100 == null) goto L9;
        r103.setCenterAndZoom(r100, r101, r102);
        return;
    L9:
        return;
    }

    public void setRotationDegree(float r100, boolean r101, int r102) {
        IMapService r103 = this.mMapService;
        if (r103 != null) goto L6;
        MapLogger.e(TAG, "BDMapClient.setRotationDegree: mMapService == null, init?");
        return;
    L6:
        r103.setRotationDegree(r100, r101, r102);
    }

    public void setZoom(float r100, boolean r101, int r102) {
        IMapService r103 = this.mMapService;
        if (r103 != null) goto L5;
        return;
    L5:
        r103.setZoom(r100, r101, r102);
    }

    public void setBound(List<BDLatLng> r100, int r101, boolean r102, int r103) {
        IMapService r104 = this.mMapService;
        if (r104 != null) goto L5;
        return;
    L5:
        r104.setBound(r100, r101, r102, r103);
    }

    public void setCenter(BDLatLng r100, boolean r101, int r102, CancelableCallback r103) {
        IMapService r104 = this.mMapService;
        if (r104 != null) goto L8;
        if (r101 == false) goto L10;
        if (r103 == null) goto L11;
        r103.onCancel();
        return;
    L11:
        return;
    L10:
        return;
    L8:
        r104.setCenter(r100, r101, r102, r103);
    }

    public void setCenterAndZoom(BDLatLng r100, float r101, boolean r102, int r103) {
        IMapService r104 = this.mMapService;
        if (r104 == null) goto L8;
        if (r100 == null) goto L9;
        r104.setCenterAndZoom(r100, r101, r102, r103);
        return;
    L9:
        return;
    }

    public void setBound(List<BDLatLng> r100, int r101, int r102, int r110, boolean r111) {
        IMapService r103 = this.mMapService;
        if (r103 != null) goto L5;
        return;
    L5:
        r103.setBound(r100, r101, r102, r110, r111);
    }

    public void setBound(List<BDLatLng> r100, int r101, int r110, int r111, int r112, boolean r113) {
        IMapService r102 = this.mMapService;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setBound(r100, r101, r110, r111, r112, r113);
    }

    public void setBound(List<BDLatLng> r100, int r101, int r110, int r111, boolean r112, int r113) {
        IMapService r102 = this.mMapService;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setBound(r100, r101, r110, r111, r112, r113);
    }

    public void setBound(List<BDLatLng> r100, int r110, int r111, int r112, int r113, boolean r114, int r115) {
        IMapService r101 = this.mMapService;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setBound(r100, r110, r111, r112, r113, r114, r115);
    }
}
