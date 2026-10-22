package com.obric.cae.libs.location.geofence;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.libs.location.poi.AoiBoard;

/* JADX INFO: loaded from: classes6.dex */
public class StarGeofence implements Parcelable {
    public static final Parcelable.Creator<StarGeofence> CREATOR = null;
    public static final String KEY_CURRENT_LOCATION = "current-location";
    public static final String KEY_GEOFENCE_EVENT = "geofence-event";
    public static final String KEY_GEOFENCE_ID = "geofence-id";
    private String address;
    private GeoConfidence confidence;
    private long eventTimestamp;
    private boolean firstBreach;
    private GeoState geoState;
    private GeoType geoType;
    private String geofenceId;
    private double latitude;
    private double longitude;
    private String packageName;
    private String poiId;
    private int radius;
    private GeoTransitionType transitionType;

    public static final enum GeoConfidence extends Enum<GeoConfidence> {
        public static final GeoConfidence HIGH = null;
        public static final GeoConfidence LOW = null;
        public static final GeoConfidence MEDIUM = null;
        public static final GeoConfidence UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoConfidence[] f395870b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395871a;

        static {
            GeoConfidence r100 = new GeoConfidence(0, 0, "UNKNOWN");
            UNKNOWN = r100;
            GeoConfidence r101 = new GeoConfidence(1, 1, "LOW");
            LOW = r101;
            GeoConfidence r102 = new GeoConfidence(2, 2, "MEDIUM");
            MEDIUM = r102;
            GeoConfidence r103 = new GeoConfidence(3, 3, "HIGH");
            HIGH = r103;
            f395870b = new GeoConfidence[]{r100, r101, r102, r103};
        }

        public static GeoConfidence[] values() {
            return (GeoConfidence[]) f395870b.clone();
        }

        public int getValue() {
            return this.f395871a;
        }

        public static GeoConfidence valueOf(String r100) {
            return (GeoConfidence) r27.a.a(GeoConfidence.class, r100);
        }

        public GeoConfidence(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395871a = r101;
        }
    }

    public static final enum GeoEvent extends Enum<GeoEvent> {
        public static final GeoEvent ENTER = null;
        public static final GeoEvent EXIT = null;
        public static final GeoEvent UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoEvent[] f395872b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395873a;

        static {
            GeoEvent r100 = new GeoEvent(0, 0, "UNKNOWN");
            UNKNOWN = r100;
            GeoEvent r101 = new GeoEvent(1, 1, "ENTER");
            ENTER = r101;
            GeoEvent r102 = new GeoEvent(2, 2, "EXIT");
            EXIT = r102;
            f395872b = new GeoEvent[]{r100, r101, r102};
        }

        public static GeoEvent[] values() {
            return (GeoEvent[]) f395872b.clone();
        }

        public int getValue() {
            return this.f395873a;
        }

        public static GeoEvent valueOf(String r100) {
            return (GeoEvent) r27.a.a(GeoEvent.class, r100);
        }

        public GeoEvent(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395873a = r101;
        }
    }

    public static final enum GeoState extends Enum<GeoState> {
        public static final GeoState INSIDE = null;
        public static final GeoState OUTSIDE = null;
        public static final GeoState UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoState[] f395874b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395875a;

        static {
            GeoState r100 = new GeoState(0, 0, "UNKNOWN");
            UNKNOWN = r100;
            GeoState r101 = new GeoState(1, 1, "INSIDE");
            INSIDE = r101;
            GeoState r102 = new GeoState(2, 2, "OUTSIDE");
            OUTSIDE = r102;
            f395874b = new GeoState[]{r100, r101, r102};
        }

        public static GeoState[] values() {
            return (GeoState[]) f395874b.clone();
        }

        public int getValue() {
            return this.f395875a;
        }

        public static GeoState valueOf(String r100) {
            return (GeoState) r27.a.a(GeoState.class, r100);
        }

        public GeoState(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395875a = r101;
        }
    }

    public static final enum GeoTransitionType extends Enum<GeoTransitionType> {
        public static final GeoTransitionType ENTERED_AND_EXITED = null;
        public static final GeoTransitionType ENTERED_ONLY = null;
        public static final GeoTransitionType EXITED_ONLY = null;
        public static final GeoTransitionType UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoTransitionType[] f395876b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395877a;

        static {
            GeoTransitionType r100 = new GeoTransitionType(0, 0, "UNKNOWN");
            UNKNOWN = r100;
            GeoTransitionType r101 = new GeoTransitionType(1, 1, "ENTERED_ONLY");
            ENTERED_ONLY = r101;
            GeoTransitionType r102 = new GeoTransitionType(2, 2, "EXITED_ONLY");
            EXITED_ONLY = r102;
            GeoTransitionType r103 = new GeoTransitionType(3, 3, "ENTERED_AND_EXITED");
            ENTERED_AND_EXITED = r103;
            f395876b = new GeoTransitionType[]{r100, r101, r102, r103};
        }

        public static GeoTransitionType[] values() {
            return (GeoTransitionType[]) f395876b.clone();
        }

        public int getValue() {
            return this.f395877a;
        }

        public static GeoTransitionType valueOf(String r100) {
            return (GeoTransitionType) r27.a.a(GeoTransitionType.class, r100);
        }

        public GeoTransitionType(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395877a = r101;
        }
    }

    public static final enum GeoType extends Enum<GeoType> {
        public static final GeoType COMPANY = null;
        public static final GeoType HOME = null;
        public static final GeoType INDOOR = null;
        public static final GeoType MALL = null;
        public static final GeoType OUTDOOR = null;
        public static final GeoType TRAFFIC = null;
        public static final GeoType UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoType[] f395878b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395879a;

        static {
            GeoType r100 = new GeoType(0, 0, "UNKNOWN");
            UNKNOWN = r100;
            GeoType r101 = new GeoType(1, 1, "HOME");
            HOME = r101;
            GeoType r102 = new GeoType(2, 2, "COMPANY");
            COMPANY = r102;
            GeoType r103 = new GeoType(3, 3, "TRAFFIC");
            TRAFFIC = r103;
            GeoType r104 = new GeoType(4, 4, "MALL");
            MALL = r104;
            GeoType r105 = new GeoType(5, 5, "INDOOR");
            INDOOR = r105;
            GeoType r110 = new GeoType(6, 6, "OUTDOOR");
            OUTDOOR = r110;
            f395878b = new GeoType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static GeoType[] values() {
            return (GeoType[]) f395878b.clone();
        }

        public int getValue() {
            return this.f395879a;
        }

        public static GeoType valueOf(String r100) {
            return (GeoType) r27.a.a(GeoType.class, r100);
        }

        public GeoType(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395879a = r101;
        }
    }

    public class a implements Parcelable.Creator<StarGeofence> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final StarGeofence createFromParcel(Parcel r100) {
            return new StarGeofence(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final StarGeofence[] newArray(int r100) {
            return new StarGeofence[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "[StarGeofence: " + this.geofenceId + ", from: " + this.packageName + ", (" + this.latitude + ", " + this.longitude + ", " + this.radius + "), address: " + this.address + ", eventTime: " + this.eventTimestamp + ", transitionType: " + this.transitionType + ", curState: " + this.geoState + ", geoType: " + this.geoType + ", firstBreach: " + this.firstBreach + ", poiId: " + this.poiId + "]";
    }

    public StarGeofence() {
        this.packageName = "";
        this.geofenceId = "";
        this.address = "";
        this.transitionType = GeoTransitionType.UNKNOWN;
        this.confidence = GeoConfidence.HIGH;
        this.geoState = GeoState.UNKNOWN;
        this.geoType = GeoType.UNKNOWN;
        this.firstBreach = true;
        this.poiId = "";
    }

    public String getAddress() {
        return this.address;
    }

    public GeoConfidence getConfidence() {
        return this.confidence;
    }

    public long getEventTimestamp() {
        return this.eventTimestamp;
    }

    public GeoState getGeoState() {
        return this.geoState;
    }

    public GeoType getGeoType() {
        return this.geoType;
    }

    public String getGeofenceId() {
        return this.geofenceId;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public int getRadius() {
        return this.radius;
    }

    public GeoTransitionType getTransitionType() {
        return this.transitionType;
    }

    public boolean isFirstBreach() {
        return this.firstBreach;
    }

    public StarGeofence(Parcel r100) {
        this.packageName = "";
        this.geofenceId = "";
        this.address = "";
        this.transitionType = GeoTransitionType.UNKNOWN;
        this.confidence = GeoConfidence.HIGH;
        this.geoState = GeoState.UNKNOWN;
        this.geoType = GeoType.UNKNOWN;
        this.firstBreach = true;
        this.poiId = "";
        readFromParcel(r100);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof StarGeofence) == false) goto L14;
        StarGeofence r101 = (StarGeofence) r100;
        if (this.latitude != r101.getLatitude()) goto L11;
        if (this.longitude != r101.getLongitude()) goto L11;
        if (this.radius != r101.getRadius()) goto L11;
    L12:
        return true;
    L11:
        if (this.geofenceId.equalsIgnoreCase(r101.getGeofenceId()) == true) goto L12;
        return false;
    L14:
        return false;
    }

    public boolean isBoundTo(AoiBoard r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (this.poiId.isEmpty() == true) goto L8;
        if (this.poiId.equals(r100.getPoiId()) == false) goto L8;
        return true;
    }

    public void readFromParcel(Parcel r100) {
        this.packageName = r100.readString();
        this.geofenceId = r100.readString();
        this.latitude = r100.readDouble();
        this.longitude = r100.readDouble();
        this.radius = r100.readInt();
        this.address = r100.readString();
        this.eventTimestamp = r100.readLong();
        this.transitionType = GeoTransitionType.values()[r100.readInt()];
        this.confidence = GeoConfidence.values()[r100.readInt()];
        this.geoState = GeoState.values()[r100.readInt()];
        this.geoType = GeoType.values()[r100.readInt()];
        this.firstBreach = r100.readBoolean();
        this.poiId = r100.readString();
    }

    public void setAddress(String r100) {
        this.address = r100;
    }

    public void setConfidence(GeoConfidence r100) {
        this.confidence = r100;
    }

    public void setEventTimestamp(long r100) {
        this.eventTimestamp = r100;
    }

    public void setFirstBreach(boolean r100) {
        this.firstBreach = r100;
    }

    public void setGeoState(GeoState r100) {
        this.geoState = r100;
    }

    public void setGeoType(GeoType r100) {
        this.geoType = r100;
    }

    public void setGeofenceId(String r100) {
        this.geofenceId = r100;
    }

    public void setLatitude(double r100) {
        this.latitude = r100;
    }

    public void setLongitude(double r100) {
        this.longitude = r100;
    }

    public void setPackageName(String r100) {
        this.packageName = r100;
    }

    public void setPoiId(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.poiId = r100;
    }

    public void setRadius(int r100) {
        this.radius = r100;
    }

    public void setTransitionType(GeoTransitionType r100) {
        this.transitionType = r100;
    }

    public boolean shouldEnableAoiBoard(AoiBoard r100) {
        if (isBoundTo(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.geoState != GeoState.INSIDE) goto L7;
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.packageName);
        r100.writeString(this.geofenceId);
        r100.writeDouble(this.latitude);
        r100.writeDouble(this.longitude);
        r100.writeInt(this.radius);
        r100.writeString(this.address);
        r100.writeLong(this.eventTimestamp);
        r100.writeInt(this.transitionType.ordinal());
        r100.writeInt(this.confidence.ordinal());
        r100.writeInt(this.geoState.ordinal());
        r100.writeInt(this.geoType.ordinal());
        r100.writeBoolean(this.firstBreach);
        r100.writeString(this.poiId);
    }

    public StarGeofence(String r100, String r101, double r102, double r103, int r104, GeoTransitionType r110) {
        this.packageName = "";
        this.geofenceId = "";
        this.address = "";
        this.transitionType = GeoTransitionType.UNKNOWN;
        this.confidence = GeoConfidence.HIGH;
        this.geoState = GeoState.UNKNOWN;
        this.geoType = GeoType.UNKNOWN;
        this.firstBreach = true;
        this.poiId = "";
        this.packageName = r100;
        this.geofenceId = r101;
        this.latitude = r102;
        this.longitude = r103;
        this.radius = r104;
        this.transitionType = r110;
    }
}
