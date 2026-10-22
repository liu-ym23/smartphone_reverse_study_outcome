package com.obric.cae.libs.location.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.libs.location.geofence.StarGeofence;

/* JADX INFO: loaded from: classes6.dex */
public class AoiBoard implements Parcelable {
    public static final Parcelable.Creator<AoiBoard> CREATOR = null;
    private String aoiBoard;
    private Confidence confidence;
    private ConfidenceSource confidenceSource;
    private State curState;
    private Event event;
    private long eventTime;
    private String geofenceId;
    private String poiId;
    private String poiName;
    private TransitionType transitionType;
    private Type type;

    /* JADX INFO: loaded from: classes33.dex */
    public static final enum Confidence extends Enum<Confidence> {
        public static final Confidence HIGH = null;
        public static final Confidence LOW = null;
        public static final Confidence MAX = null;
        public static final Confidence MEDIUM = null;
        public static final Confidence MIN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Confidence[] f395880b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395881a;

        static {
            Confidence r100 = new Confidence(0, 0, "MIN");
            MIN = r100;
            Confidence r101 = new Confidence(1, 1, "LOW");
            LOW = r101;
            Confidence r102 = new Confidence(2, 2, "MEDIUM");
            MEDIUM = r102;
            Confidence r103 = new Confidence(3, 3, "HIGH");
            HIGH = r103;
            Confidence r104 = new Confidence(4, 4, "MAX");
            MAX = r104;
            f395880b = new Confidence[]{r100, r101, r102, r103, r104};
        }

        public static Confidence[] values() {
            return (Confidence[]) f395880b.clone();
        }

        public int getValue() {
            return this.f395881a;
        }

        public static Confidence valueOf(String r100) {
            return (Confidence) r27.a.a(Confidence.class, r100);
        }

        public Confidence(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395881a = r101;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final enum ConfidenceSource extends Enum<ConfidenceSource> {
        public static final ConfidenceSource DEFAULT = null;
        public static final ConfidenceSource DISTANCE = null;
        public static final ConfidenceSource RETRY = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ ConfidenceSource[] f395882b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395883a;

        static {
            ConfidenceSource r100 = new ConfidenceSource(0, 0, "DEFAULT");
            DEFAULT = r100;
            ConfidenceSource r101 = new ConfidenceSource(1, 1, "DISTANCE");
            DISTANCE = r101;
            ConfidenceSource r102 = new ConfidenceSource(2, 2, "RETRY");
            RETRY = r102;
            f395882b = new ConfidenceSource[]{r100, r101, r102};
        }

        public static ConfidenceSource[] values() {
            return (ConfidenceSource[]) f395882b.clone();
        }

        public int getValue() {
            return this.f395883a;
        }

        public static ConfidenceSource valueOf(String r100) {
            return (ConfidenceSource) r27.a.a(ConfidenceSource.class, r100);
        }

        public ConfidenceSource(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395883a = r101;
        }
    }

    public static final enum Event extends Enum<Event> {
        public static final Event ENTER = null;
        public static final Event EXIT = null;
        public static final Event UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Event[] f395884b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395885a;

        static {
            Event r100 = new Event(0, 0, "UNKNOWN");
            UNKNOWN = r100;
            Event r101 = new Event(1, 1, "ENTER");
            ENTER = r101;
            Event r102 = new Event(2, 2, "EXIT");
            EXIT = r102;
            f395884b = new Event[]{r100, r101, r102};
        }

        public static Event[] values() {
            return (Event[]) f395884b.clone();
        }

        public int getValue() {
            return this.f395885a;
        }

        public static Event valueOf(String r100) {
            return (Event) r27.a.a(Event.class, r100);
        }

        public Event(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395885a = r101;
        }
    }

    public static final enum State extends Enum<State> {
        public static final State INSIDE = null;
        public static final State OUTSIDE = null;
        public static final State UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ State[] f395886b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395887a;

        static {
            State r100 = new State(0, 0, "UNKNOWN");
            UNKNOWN = r100;
            State r101 = new State(1, 1, "INSIDE");
            INSIDE = r101;
            State r102 = new State(2, 2, "OUTSIDE");
            OUTSIDE = r102;
            f395886b = new State[]{r100, r101, r102};
        }

        public static State[] values() {
            return (State[]) f395886b.clone();
        }

        public int getValue() {
            return this.f395887a;
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395887a = r101;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final enum TransitionType extends Enum<TransitionType> {
        public static final TransitionType ENTERED_AND_EXITED = null;
        public static final TransitionType ENTERED_ONLY = null;
        public static final TransitionType EXITED_ONLY = null;
        public static final TransitionType UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ TransitionType[] f395888b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395889a;

        static {
            TransitionType r100 = new TransitionType(0, 0, "UNKNOWN");
            UNKNOWN = r100;
            TransitionType r101 = new TransitionType(1, 1, "ENTERED_ONLY");
            ENTERED_ONLY = r101;
            TransitionType r102 = new TransitionType(2, 2, "EXITED_ONLY");
            EXITED_ONLY = r102;
            TransitionType r103 = new TransitionType(3, 3, "ENTERED_AND_EXITED");
            ENTERED_AND_EXITED = r103;
            f395888b = new TransitionType[]{r100, r101, r102, r103};
        }

        public static TransitionType[] values() {
            return (TransitionType[]) f395888b.clone();
        }

        public int getValue() {
            return this.f395889a;
        }

        public static TransitionType valueOf(String r100) {
            return (TransitionType) r27.a.a(TransitionType.class, r100);
        }

        public TransitionType(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395889a = r101;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type AIRPORT = null;
        public static final Type MALL = null;
        public static final Type SUBWAY_STATION = null;
        public static final Type TRAIN_STATION = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Type[] f395890b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395891a;

        static {
            Type r100 = new Type(0, 0, "UNKNOWN");
            UNKNOWN = r100;
            Type r101 = new Type(1, 1, "AIRPORT");
            AIRPORT = r101;
            Type r102 = new Type(2, 2, "TRAIN_STATION");
            TRAIN_STATION = r102;
            Type r103 = new Type(3, 3, "SUBWAY_STATION");
            SUBWAY_STATION = r103;
            Type r104 = new Type(4, 4, "MALL");
            MALL = r104;
            f395890b = new Type[]{r100, r101, r102, r103, r104};
        }

        public static Type[] values() {
            return (Type[]) f395890b.clone();
        }

        public int getValue() {
            return this.f395891a;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395891a = r101;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public class a implements Parcelable.Creator<AoiBoard> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AoiBoard createFromParcel(Parcel r100) {
            return new AoiBoard(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final AoiBoard[] newArray(int r100) {
            return new AoiBoard[r100];
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
        return "[AoiBoard: poiId=" + this.poiId + ", name=" + this.poiName + ", geofenceId=" + this.geofenceId + ", curState=" + this.curState + ", transitionType=" + this.transitionType + ", confidence=" + this.confidence + ", confidenceSource=" + this.confidenceSource + ", type=" + this.type + ", geofenceId=" + this.geofenceId + ", eventTime=" + this.eventTime + ", aoiBoard=(" + this.aoiBoard + ")]";
    }

    public AoiBoard() {
        this.poiId = "";
        this.poiName = "";
        this.aoiBoard = "";
        this.curState = State.UNKNOWN;
        this.transitionType = TransitionType.ENTERED_AND_EXITED;
        this.confidence = Confidence.MIN;
        this.confidenceSource = ConfidenceSource.DEFAULT;
        this.event = Event.UNKNOWN;
        this.type = Type.UNKNOWN;
        this.geofenceId = "";
        this.eventTime = 0;
    }

    public String getAoiBoard() {
        return this.aoiBoard;
    }

    public Confidence getConfidence() {
        return this.confidence;
    }

    public ConfidenceSource getConfidenceSource() {
        return this.confidenceSource;
    }

    public State getCurState() {
        return this.curState;
    }

    public Event getEvent() {
        return this.event;
    }

    public long getEventTime() {
        return this.eventTime;
    }

    public String getGeofenceId() {
        return this.geofenceId;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public TransitionType getTransitionType() {
        return this.transitionType;
    }

    public Type getType() {
        return this.type;
    }

    public AoiBoard(Parcel r100) {
        this.poiId = "";
        this.poiName = "";
        this.aoiBoard = "";
        this.curState = State.UNKNOWN;
        this.transitionType = TransitionType.ENTERED_AND_EXITED;
        this.confidence = Confidence.MIN;
        this.confidenceSource = ConfidenceSource.DEFAULT;
        this.event = Event.UNKNOWN;
        this.type = Type.UNKNOWN;
        this.geofenceId = "";
        this.eventTime = 0;
        readFromParcel(r100);
    }

    public void applyEvent(Event r100) {
        if (r100 != Event.ENTER) goto L6;
        this.curState = State.INSIDE;
    L9:
        setEvent(r100);
        return;
    L6:
        if (r100 != Event.EXIT) goto L8;
        this.curState = State.OUTSIDE;
        goto L9
    L8:
        this.curState = State.UNKNOWN;
        goto L9
    }

    public void applyState(State r100) {
        if (r100 != null) goto L5;
        r100 = State.UNKNOWN;
    L5:
        if (this.curState == r100) goto L7;
        boolean r101 = true;
    L8:
        this.curState = r100;
        if (r101 == false) goto L11;
    L14:
        this.eventTime = System.currentTimeMillis();
        return;
    L11:
        if (r100 != State.UNKNOWN) goto L13;
        return;
    L13:
        if (this.eventTime <= 0) goto L14;
        return;
    L7:
        r101 = false;
        goto L8
    }

    public boolean isBoundTo(StarGeofence r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.geofenceId.isEmpty() == true) goto L10;
        return this.geofenceId.equals(r100.getGeofenceId());
    L10:
        if (this.poiId.isEmpty() == false) goto L12;
        return false;
    L12:
        if (this.poiId.equals(r100.getPoiId()) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public boolean isSecondLayerEnabledBy(StarGeofence r100) {
        if (isBoundTo(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getGeoState() != StarGeofence.GeoState.INSIDE) goto L7;
        return true;
    }

    public void readFromParcel(Parcel r100) {
        this.poiId = r100.readString();
        this.poiName = r100.readString();
        this.aoiBoard = r100.readString();
        this.curState = State.values()[r100.readInt()];
        this.transitionType = TransitionType.values()[r100.readInt()];
        this.confidence = Confidence.values()[r100.readInt()];
        this.confidenceSource = ConfidenceSource.values()[r100.readInt()];
        this.event = Event.values()[r100.readInt()];
        this.type = Type.values()[r100.readInt()];
        this.geofenceId = r100.readString();
        this.eventTime = r100.readLong();
    }

    public void setAoiBoard(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.aoiBoard = r100;
    }

    public void setConfidence(Confidence r100) {
        if (r100 != null) goto L4;
        r100 = Confidence.MIN;
    L4:
        this.confidence = r100;
    }

    public void setConfidenceSource(ConfidenceSource r100) {
        if (r100 != null) goto L4;
        r100 = ConfidenceSource.DEFAULT;
    L4:
        this.confidenceSource = r100;
    }

    public void setCurState(State r100) {
        if (r100 != null) goto L4;
        r100 = State.UNKNOWN;
    L4:
        this.curState = r100;
    }

    public void setEvent(Event r100) {
        if (r100 != null) goto L4;
        r100 = Event.UNKNOWN;
    L4:
        this.event = r100;
        if (r100 == Event.UNKNOWN) goto L8;
        this.eventTime = System.currentTimeMillis();
        return;
    }

    public void setEventTime(long r100) {
        this.eventTime = Math.max(0, r100);
    }

    public void setGeofenceId(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.geofenceId = r100;
    }

    public void setPoiId(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.poiId = r100;
    }

    public void setPoiName(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.poiName = r100;
    }

    public void setTransitionType(TransitionType r100) {
        if (r100 != null) goto L4;
        r100 = TransitionType.UNKNOWN;
    L4:
        this.transitionType = r100;
    }

    public void setType(Type r100) {
        if (r100 != null) goto L4;
        r100 = Type.UNKNOWN;
    L4:
        this.type = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.poiId);
        r100.writeString(this.poiName);
        r100.writeString(this.aoiBoard);
        r100.writeInt(this.curState.ordinal());
        r100.writeInt(this.transitionType.ordinal());
        r100.writeInt(this.confidence.ordinal());
        r100.writeInt(this.confidenceSource.ordinal());
        r100.writeInt(this.event.ordinal());
        r100.writeInt(this.type.ordinal());
        r100.writeString(this.geofenceId);
        r100.writeLong(this.eventTime);
    }

    public AoiBoard(String r100, String r101, String r102) {
        this.poiId = "";
        this.poiName = "";
        this.aoiBoard = "";
        this.curState = State.UNKNOWN;
        this.transitionType = TransitionType.ENTERED_AND_EXITED;
        this.confidence = Confidence.MIN;
        this.confidenceSource = ConfidenceSource.DEFAULT;
        this.event = Event.UNKNOWN;
        this.type = Type.UNKNOWN;
        this.geofenceId = "";
        this.eventTime = 0;
        setPoiId(r100);
        setPoiName(r101);
        setAoiBoard(r102);
    }
}
