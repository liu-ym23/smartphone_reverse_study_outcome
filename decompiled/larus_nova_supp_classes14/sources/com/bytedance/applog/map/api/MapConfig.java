package com.bytedance.applog.map.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class MapConfig {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/applog/map/api/MapConfig$MapScreenCaptureMethod;", "", "Canvas", "PixCopy", "map-api_release"}, k = 1, mv = {1, 6, 0})
    public static final enum MapScreenCaptureMethod extends Enum<MapScreenCaptureMethod> {
        public static final MapScreenCaptureMethod Canvas = null;
        public static final MapScreenCaptureMethod PixCopy = null;
        public static final /* synthetic */ MapScreenCaptureMethod[] a = null;

        public static MapScreenCaptureMethod valueOf(String r1) {
            return (MapScreenCaptureMethod) r27.a.a(MapScreenCaptureMethod.class, r1);
        }

        public static MapScreenCaptureMethod[] values() {
            return (MapScreenCaptureMethod[]) a.clone();
        }

        static {
            MapScreenCaptureMethod r0 = new MapScreenCaptureMethod("Canvas", 0);
            Canvas = r0;
            MapScreenCaptureMethod r1 = new MapScreenCaptureMethod("PixCopy", 1);
            PixCopy = r1;
            a = new MapScreenCaptureMethod[]{r0, r1};
        }

        public MapScreenCaptureMethod(String r1, int r2) {
            super(r1, r2);
        }
    }
}
