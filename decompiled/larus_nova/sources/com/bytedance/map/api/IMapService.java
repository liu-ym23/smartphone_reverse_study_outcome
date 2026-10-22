package com.bytedance.map.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.map.api.animation.AnimationStyle;
import com.bytedance.map.api.listener.CancelableCallback;
import com.bytedance.map.api.listener.FirstMapTileLoadedListener;
import com.bytedance.map.api.listener.MapActionListener;
import com.bytedance.map.api.listener.MapActionReasonListener;
import com.bytedance.map.api.listener.MapScreenShotListener;
import com.bytedance.map.api.listener.MapShotStatusListener;
import com.bytedance.map.api.listener.MarkerActionListener;
import com.bytedance.map.api.listener.PoiClickListener;
import com.bytedance.map.api.listener.PolygonClickListener;
import com.bytedance.map.api.listener.PolylineClickListener;
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
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public interface IMapService {
    IArc addArc(BDArcOptions r100);

    ICircle addCircle(BDCircleOptions r100);

    void addFirstMapTileLoadedListener(FirstMapTileLoadedListener r100);

    IHeatMap addHeatMap(BDHeatMapOptions r100);

    void addMapActionListener(MapActionListener r100);

    void addMapActionReasonListener(MapActionReasonListener r100);

    IMarker addMarker(BDMarkerOptions r100);

    void addMarkerActionListener(MarkerActionListener r100);

    List<IMarker> addMarkers(List<BDMarkerOptions> r100);

    void addPoiClickListener(PoiClickListener r100);

    IPolygon addPolygon(BDPolygonOptions r100);

    void addPolygonClickListener(PolygonClickListener r100);

    IPolyline addPolyline(BDPolylineOptions r100);

    void addPolylineClickListener(PolylineClickListener r100);

    ITextPath addTextPath(BDTextPathOptions r100);

    void attachToParentView(ViewGroup r100);

    float calculateLineDistance(BDLatLng r100, BDLatLng r101);

    void clear();

    BDLatLng getCenter();

    int getLogoPosition();

    void getMapScreenShot(MapScreenShotListener r100);

    Bitmap getMapScreenShotFromCache();

    int getMapType();

    List<IMarker> getMarkers();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    View getRealMapView();

    float getRotationDegree();

    Point getScaleControlPosition();

    float getScalePerPixel();

    BDMapUiConfigs getUiSettings();

    Map<String, Double> getVisibleRegion();

    float getZoom();

    int getZoomPosition();

    void initMap(MapInitConfig r100);

    boolean isAvailable(Context r100);

    boolean isCompassEnabled();

    boolean isGestureScaleByMapCenter();

    boolean isIndoorSwitchEnabled();

    boolean isMyLocationButtonEnabled();

    boolean isPoiClickEnabled();

    boolean isRotateGesturesEnabled();

    boolean isScaleControlsEnabled();

    boolean isScrollGesturesEnabled();

    boolean isSupportSetRotation();

    boolean isTiltGesturesEnabled();

    boolean isZoomControlsEnabled();

    boolean isZoomGesturesEnabled();

    void launchMapShotToCache(MapShotStatusListener r100);

    void onCreate(Bundle r100);

    void onDestroy();

    void onLowMemory();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle r100);

    void onStart();

    void onStop();

    void removeAllArcs();

    void removeAllCircles();

    void removeAllHeatMaps();

    void removeAllMarkers();

    void removeAllPolygons();

    void removeAllPolylines();

    void removeAllTextPaths();

    void removeArc(IArc r100);

    void removeCircle(ICircle r100);

    void removeHeatMap(IHeatMap r100);

    void removeMarker(IMarker r100);

    void removePolygon(IPolygon r100);

    void removePolyline(IPolyline r100);

    void removeTextPath(ITextPath r100);

    void setAllGesturesEnabled(boolean r100);

    void setBound(List<BDLatLng> r100, int r101, int r102, int r103, int r104, boolean r105);

    void setBound(List<BDLatLng> r100, int r101, int r102, int r103, int r104, boolean r105, int r106);

    void setBound(List<BDLatLng> r100, int r101, int r102, int r103, boolean r104);

    void setBound(List<BDLatLng> r100, int r101, int r102, int r103, boolean r104, int r105);

    void setBound(List<BDLatLng> r100, int r101, boolean r102);

    void setBound(List<BDLatLng> r100, int r101, boolean r102, int r103);

    void setCenter(BDLatLng r100, boolean r101);

    void setCenter(BDLatLng r100, boolean r101, int r102);

    void setCenter(BDLatLng r100, boolean r101, int r102, CancelableCallback r103);

    void setCenterAndZoom(BDLatLng r100, float r101, boolean r102);

    void setCenterAndZoom(BDLatLng r100, float r101, boolean r102, int r103);

    void setCompassEnabled(boolean r100);

    void setCustomMapStyle(BDMapStyleOptions r100);

    void setCustomMapStyle(BDMapStyleType r100);

    void setCustomMapStyle(boolean r100, String r101);

    void setGestureScaleByMapCenter(boolean r100);

    void setHandleGesture(boolean r100);

    void setIndoorSwitchEnabled(boolean r100);

    void setLimitRegion(BDLatLng r100, BDLatLng r101);

    void setLocationOverlay(BDLocationOverlayConfig r100);

    void setLogoBottomMargin(int r100);

    void setLogoLeftMargin(int r100);

    void setLogoPosition(int r100);

    boolean setMarkerIcon(IMarker r100, Bitmap r101);

    void setMaxZoomLevel(float r100);

    void setMinZoomLevel(float r100);

    void setMonitorBizName(String r100);

    void setMyLocationButtonEnabled(boolean r100);

    void setPoiClickEnabled(boolean r100);

    void setPointToCenter(int r100, int r101);

    void setRotateGesturesEnabled(boolean r100);

    void setRotationDegree(float r100, boolean r101, int r102);

    void setScaleControlPosition(Point r100);

    void setScaleControlsEnabled(boolean r100);

    void setScrollGesturesEnabled(boolean r100);

    void setTiltGesturesEnabled(boolean r100);

    void setTrafficEnabled(boolean r100);

    void setUiSettings(BDMapUiConfigs r100);

    void setZoom(float r100, boolean r101);

    void setZoom(float r100, boolean r101, int r102);

    void setZoomControlsEnabled(boolean r100);

    void setZoomGesturesEnabled(boolean r100);

    void setZoomInByScreenCenter(boolean r100);

    void setZoomPosition(int r100);

    void showMapPoi(boolean r100);

    void startMarkerAnimation(IMarker r100, List<AnimationStyle> r101);

    Point transLatLngToPoint(BDLatLng r100);

    BDLatLng transPointToLatLng(Point r100);
}
