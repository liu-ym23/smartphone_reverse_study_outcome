package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
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

        public AnomalyStatus(int r1, int r2, int r3) {
            this.fusionLocationMask = r1;
            this.naviMatchMask = r2;
            this.cruiseMatchMask = r3;
        }
    }

    public static final class AreaContext {
        public final double confidence;
        public final int type;

        public AreaContext(int r1, double r2) {
            this.type = r1;
            this.confidence = r2;
        }
    }

    public static final class CruiseMatch {
        public final long dlinkId;
        public final double heading;
        public final float linkRemainDistance;
        public final float linkRemainPercent;
        public final LatLng projectionLocation;
        public final String roadVersion;

        public CruiseMatch(long r1, LatLng r3, float r4, float r5, double r6, String r8) {
            this.dlinkId = r1;
            this.projectionLocation = r3;
            this.linkRemainDistance = r4;
            this.linkRemainPercent = r5;
            this.heading = r6;
            if (r8 != null) goto L5;
            r8 = "";
        L5:
            this.roadVersion = r8;
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

        public FusionLocation(long r4, int r6, boolean r7, LatLng r8, float r9, double r10, float r12, double r13, float r15, double r16, float r18, double r19) {
            this.locationTimestampMs = r4;
            this.locationType = r6;
            this.inputHasLatlng = r7;
            this.location = r8;
            this.locationAccuracy = r9;
            this.speed = r10;
            this.speedAccuracy = r12;
            this.speedBearing = r13;
            this.speedBearingAccuracy = r15;
            this.bearing = r16;
            this.bearingAccuracy = r18;
            this.altitude = r19;
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

        public GuideLocationFix(long r4, LatLng r6, LatLng r7, double r8, double r10, float r12, double r13, int r15, int r16, int r17, long r18, int r20, int r21, float r22, float r23, String r24, LocationSemantics r25, int r26) {
            this.locationTimestampMs = r4;
            this.location = r6;
            this.shownLocation = r7;
            this.altitude = r8;
            this.speed = r10;
            this.accuracy = r12;
            this.heading = r13;
            this.locationType = r15;
            this.locationSource = r16;
            this.matchStatus = r17;
            this.dlinkId = r18;
            this.linkIdx = r20;
            this.pointIdx = r21;
            this.linkRemainDistance = r22;
            this.linkRemainPercent = r23;
            if (r24 != null) goto L5;
            String r1 = "";
        L6:
            this.linkForm = r1;
            this.semantics = r25;
            this.locationState = r26;
            return;
        L5:
            r1 = r24;
            goto L6
        }
    }

    public static final class LatLng {
        public final double lat;
        public final double lon;

        public LatLng(double r1, double r3) {
            this.lat = r1;
            this.lon = r3;
        }
    }

    public static final class LocationSemantics {
        public final AreaContext[] areas;
        public final int geofenceZone;
        public final int indoorState;

        public LocationSemantics(int r1, int r2, AreaContext[] r3) {
            this.geofenceZone = r1;
            this.indoorState = r2;
            if (r3 != null) goto L5;
            AreaContext[] r4 = new AreaContext[0];
        L6:
            this.areas = r4;
            return;
        L5:
            r4 = (AreaContext[]) r3.clone();
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

        public NaviMatch(long r1, LatLng r3, int r4, int r5, float r6, float r7, boolean r8, float r9, double r10) {
            this.locationTimestampMs = r1;
            this.projectionLocation = r3;
            this.linkIndex = r4;
            this.pointIndex = r5;
            this.linkRemainDistance = r6;
            this.linkRemainPercent = r7;
            this.rerouteTriggered = r8;
            this.deviateConfidence = r9;
            this.heading = r10;
        }
    }

    public LocationOutput(AnomalyStatus r1, FusionLocation r2, NaviMatch r3, CruiseMatch r4, GuideLocationFix r5, SensorBatch.GpsStruct r6) {
        this.anomalyStatus = r1;
        this.fusion = r2;
        this.navi = r3;
        this.cruise = r4;
        this.glf = r5;
        this.gps = r6;
    }
}
