package com.bytedance.bdp.service.plug.map.model;

import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.bytedance.bdp.service.plug.map.listener.BdpMapCallback;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
public interface BdpMap {

    public interface GeocoderSearchedListener {
        void onGeocoderSearchedListener(boolean r100, BdpLatLng r101);
    }

    public static final enum MapType extends Enum<MapType> {
        private static final /* synthetic */ MapType[] $VALUES = null;
        public static final MapType AMAP_2D = null;
        public static final MapType AMAP_3D = null;

        static {
            MapType r100 = new MapType("AMAP_3D", 0);
            AMAP_3D = r100;
            MapType r101 = new MapType("AMAP_2D", 1);
            AMAP_2D = r101;
            $VALUES = new MapType[]{r100, r101};
        }

        public static MapType[] values() {
            return (MapType[]) $VALUES.clone();
        }

        public static MapType valueOf(String r100) {
            return (MapType) a.a(MapType.class, r100);
        }

        private MapType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface OnAnchorPointTapListener {
        void onAnchorPointTap(BdpLatLng r100);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(BdpCameraPosition r100);

        void onCameraChangeFinish(BdpCameraPosition r100);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(BdpMarkerOptions r100);
    }

    public interface OnLabelClickListener {
        void onLabelClick(BdpMarkerOptions r100);
    }

    public interface OnLocateChangeListener {
        void onLocationChanged(Location r100, String r101);
    }

    public interface OnMapClickListener {
        void onMapClick(BdpLatLng r100);
    }

    public interface OnMapLoadedListener {
        void onMapLoaded();
    }

    public interface OnMarkerClickListener {
        void onMarkerClick(BdpMarkerOptions r100);
    }

    public interface OnPOIClickListener {
        void onPOIClick(String r100, BdpLatLng r101);
    }

    public interface RegeocodeSearchedListener {
        void onRegeocodeSearchedListener(boolean r100, String r101, String r102);
    }

    public interface SearchRouteCompleteListener {
        void onSearchRouteComplete();
    }

    void addCircle(BdpCircleOptions r100);

    boolean addGroundOverlay(BdpGroundOverlayOptions r100);

    void addMarker(BdpMarkerOptions r100);

    void addPolygon(BdpPolygonOptions r100);

    void addPolyline(BdpPolylineOptions r100);

    void cleanCircles();

    void cleanMarkers();

    void cleanPolyLines();

    void cleanPolygons();

    View createMapView(Context r100);

    void enable3D(boolean r100);

    void enableBuilding(boolean r100);

    void enableOverLook(boolean r100);

    void enablePoi(boolean r100);

    void enableRotate(boolean r100);

    void enableSatellite(boolean r100);

    void enableScroll(boolean r100);

    void enableTraffic(boolean r100);

    void enableZoom(boolean r100);

    BdpLatLng getCenterLocation();

    List<BdpMarkerOptions> getMapScreenMarkers();

    MapType getMapType();

    BdpVisibleRegion getRegion();

    float getRotate();

    float getScale();

    float getSkew();

    void includePoints(List<BdpLatLng> r100, int r101, int r102, int r103, int r104);

    boolean isLocatePointShowing();

    boolean isMyLocationShowing();

    boolean isRouteOverlayShowing();

    Point mapToScreen(BdpLatLng r100);

    void moveCameraToLatLng(BdpLatLng r100);

    boolean moveMarker(BdpMarkerAction r100, BdpMapCallback r101);

    void onActivityCreated(Bundle r100);

    void onDestroy();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle r100);

    void queryAddressNameByLatLng(BdpLatLng r100, RegeocodeSearchedListener r101);

    void queryLatLngByAddressName(String r100, GeocoderSearchedListener r101);

    void removeGroundOverlay(String r100);

    void removeRouteOverlay();

    BdpLatLng screenToMap(Point r100);

    void searchRouteAndShowOverlay(BdpLatLng r100, BdpLatLng r101, SearchRouteCompleteListener r102);

    void setAnchorPointTapListener(OnAnchorPointTapListener r100);

    boolean setCenterOffset(double r100, double r101);

    void setHasGrantLocatingPermission(boolean r100);

    void setMapLoadedListener(OnMapLoadedListener r100);

    void setMaxScale(float r100);

    void setMinScale(float r100);

    void setMyLocatePointStyle(BdpLocatePointStyle r100);

    void setOnCameraChangeListener(OnCameraChangeListener r100);

    void setOnInfoWindowClickListener(OnInfoWindowClickListener r100);

    void setOnLabelClickListener(OnLabelClickListener r100);

    void setOnLocationChangedListener(OnLocateChangeListener r100);

    void setOnMapClickListener(OnMapClickListener r100);

    void setOnMarkerClickListener(OnMarkerClickListener r100);

    void setOnPOIClickListener(OnPOIClickListener r100);

    void setRotate(float r100);

    void setScale(float r100);

    void setSkew(float r100);

    void showCompass(boolean r100);

    void showLocateBluePoint(Location r100);

    void showScale(boolean r100);

    void startLocation();

    void stopLocation();

    boolean translateMarker(BdpMarkerAction r100, BdpMapCallback r101);

    boolean updateGroundOverlay(BdpGroundOverlayOptions r100);
}
