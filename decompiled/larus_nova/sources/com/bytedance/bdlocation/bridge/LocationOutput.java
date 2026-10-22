package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
public final class LocationOutput {
    public final AnomalyStatus anomalyStatus;
    public final CruiseMatch cruise;
    public final FusionLocation fusion;
    public final GuideLocationFix glf;
    public final SensorBatch.GpsStruct gps;
    public final NaviMatch navi;

    public static final class AnomalyStatus {
        public final int cruiseMatchMask;
        public final int fusionLocationMask;
        public final int naviMatchMask;

        public AnomalyStatus(int r100, int r101, int r102) {
            this.fusionLocationMask = r100;
            this.naviMatchMask = r101;
            this.cruiseMatchMask = r102;
        }
    }

    public static final class AreaContext {
        public final double confidence;
        public final int type;

        public AreaContext(int r100, double r101) {
            this.type = r100;
            this.confidence = r101;
        }
    }

    public static final class CruiseMatch {
        public final long dlinkId;
        public final double heading;
        public final float linkRemainDistance;
        public final float linkRemainPercent;
        public final LatLng projectionLocation;
        public final String roadVersion;

        public CruiseMatch(long r100, LatLng r101, float r102, float r103, double r104, String r105) {
            this.dlinkId = r100;
            this.projectionLocation = r101;
            this.linkRemainDistance = r102;
            this.linkRemainPercent = r103;
            this.heading = r104;
            if (r105 != null) goto L5;
            r105 = "";
        L5:
            this.roadVersion = r105;
        }
    }

    public static final class FusionLocation {
        public final double altitude;
        public final double bearing;
        public final float bearingAccuracy;
        public final boolean inputHasLatlng;
        public final LatLng location;
        public final float locationAccuracy;
        public final long locationTimestampMs;
        public final int locationType;
        public final double speed;
        public final float speedAccuracy;
        public final double speedBearing;
        public final float speedBearingAccuracy;

        public FusionLocation(long r100, int r101, boolean r102, LatLng r103, float r104, double r110, float r111, double r112, float r113, double r114, float r115, double r116) {
            this.locationTimestampMs = r100;
            this.locationType = r101;
            this.inputHasLatlng = r102;
            this.location = r103;
            this.locationAccuracy = r104;
            this.speed = r110;
            this.speedAccuracy = r111;
            this.speedBearing = r112;
            this.speedBearingAccuracy = r113;
            this.bearing = r114;
            this.bearingAccuracy = r115;
            this.altitude = r116;
        }
    }

    public static final class GuideLocationFix {
        public final float accuracy;
        public final double altitude;
        public final long dlinkId;
        public final double heading;
        public final String linkForm;
        public final int linkIdx;
        public final float linkRemainDistance;
        public final float linkRemainPercent;
        public final LatLng location;
        public final int locationSource;
        public final int locationState;
        public final long locationTimestampMs;
        public final int locationType;
        public final int matchStatus;
        public final int pointIdx;
        public final LocationSemantics semantics;
        public final LatLng shownLocation;
        public final double speed;

        public GuideLocationFix(long r100, LatLng r101, LatLng r102, double r103, double r110, float r111, double r112, int r113, int r114, int r115, long r116, int r210, int r211, float r212, float r213, String r214, LocationSemantics r215, int r216) {
            this.locationTimestampMs = r100;
            this.location = r101;
            this.shownLocation = r102;
            this.altitude = r103;
            this.speed = r110;
            this.accuracy = r111;
            this.heading = r112;
            this.locationType = r113;
            this.locationSource = r114;
            this.matchStatus = r115;
            this.dlinkId = r116;
            this.linkIdx = r210;
            this.pointIdx = r211;
            this.linkRemainDistance = r212;
            this.linkRemainPercent = r213;
            if (r214 != null) goto L5;
            String r104 = "";
        L6:
            this.linkForm = r104;
            this.semantics = r215;
            this.locationState = r216;
            return;
        L5:
            r104 = r214;
            goto L6
        }
    }

    public static final class LatLng {
        public final double lat;
        public final double lon;

        public LatLng(double r100, double r101) {
            this.lat = r100;
            this.lon = r101;
        }
    }

    public static final class LocationSemantics {
        public final AreaContext[] areas;
        public final int geofenceZone;
        public final int indoorState;

        public LocationSemantics(int r100, int r101, AreaContext[] r102) {
            this.geofenceZone = r100;
            this.indoorState = r101;
            if (r102 != null) goto L5;
            AreaContext[] r103 = new AreaContext[0];
        L6:
            this.areas = r103;
            return;
        L5:
            r103 = (AreaContext[]) r102.clone();
            goto L6
        }
    }

    public static final class NaviMatch {
        public final float deviateConfidence;
        public final double heading;
        public final int linkIndex;
        public final float linkRemainDistance;
        public final float linkRemainPercent;
        public final long locationTimestampMs;
        public final int pointIndex;
        public final LatLng projectionLocation;
        public final boolean rerouteTriggered;

        public NaviMatch(long r100, LatLng r101, int r102, int r103, float r104, float r105, boolean r106, float r107, double r110) {
            this.locationTimestampMs = r100;
            this.projectionLocation = r101;
            this.linkIndex = r102;
            this.pointIndex = r103;
            this.linkRemainDistance = r104;
            this.linkRemainPercent = r105;
            this.rerouteTriggered = r106;
            this.deviateConfidence = r107;
            this.heading = r110;
        }
    }

    public LocationOutput(AnomalyStatus r100, FusionLocation r101, NaviMatch r102, CruiseMatch r103, GuideLocationFix r104, SensorBatch.GpsStruct r105) {
        this.anomalyStatus = r100;
        this.fusion = r101;
        this.navi = r102;
        this.cruise = r103;
        this.glf = r104;
        this.gps = r105;
    }
}
