package com.bytedance.map.api.listener;

import com.bytedance.map.api.model.BDLatLng;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public interface MapActionReasonListener {

    public static final enum MapActionReason extends Enum<MapActionReason> {
        private static final /* synthetic */ MapActionReason[] $VALUES = null;
        public static final MapActionReason REASON_API = null;
        public static final MapActionReason REASON_GESTURE = null;
        public static final MapActionReason REASON_SDK = null;

        static {
            MapActionReason r100 = new MapActionReason("REASON_GESTURE", 0);
            REASON_GESTURE = r100;
            MapActionReason r101 = new MapActionReason("REASON_SDK", 1);
            REASON_SDK = r101;
            MapActionReason r102 = new MapActionReason("REASON_API", 2);
            REASON_API = r102;
            $VALUES = new MapActionReason[]{r100, r101, r102};
        }

        public static MapActionReason[] values() {
            return (MapActionReason[]) $VALUES.clone();
        }

        public static MapActionReason valueOf(String r100) {
            return (MapActionReason) a.a(MapActionReason.class, r100);
        }

        private MapActionReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    void onMapMove(BDLatLng r100, MapActionReason r101);

    void onMapMoveEnd(BDLatLng r100, MapActionReason r101);

    void onMapZoom(float r100, MapActionReason r101);

    void onMapZoomEnd(float r100, MapActionReason r101);
}
