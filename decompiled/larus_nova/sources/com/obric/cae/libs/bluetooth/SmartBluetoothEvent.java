package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class SmartBluetoothEvent implements Parcelable {
    public static final Parcelable.Creator<SmartBluetoothEvent> CREATOR = null;
    private static final int PROFILE_PBAP = 6;
    private static final int VERSION = 1;
    private final BluetoothDevice mBluetoothDevice;
    private final int mProfile;
    private final int mState;

    /* JADX INFO: loaded from: classes33.dex */
    public static final enum A2dpState extends Enum<A2dpState> {
        public static final A2dpState STATE_CONNECTED = null;
        public static final A2dpState STATE_CONNECTING = null;
        public static final A2dpState STATE_DISCONNECTED = null;
        public static final A2dpState STATE_DISCONNECTING = null;
        public static final A2dpState STATE_NOT_PLAYING = null;
        public static final A2dpState STATE_PLAYING = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ A2dpState[] f395859b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395860a;

        static {
            A2dpState r100 = new A2dpState(0, 0, "STATE_DISCONNECTED");
            STATE_DISCONNECTED = r100;
            A2dpState r101 = new A2dpState(1, 1, "STATE_CONNECTING");
            STATE_CONNECTING = r101;
            A2dpState r102 = new A2dpState(2, 2, "STATE_CONNECTED");
            STATE_CONNECTED = r102;
            A2dpState r103 = new A2dpState(3, 3, "STATE_DISCONNECTING");
            STATE_DISCONNECTING = r103;
            A2dpState r104 = new A2dpState(4, 10, "STATE_PLAYING");
            STATE_PLAYING = r104;
            A2dpState r105 = new A2dpState(5, 11, "STATE_NOT_PLAYING");
            STATE_NOT_PLAYING = r105;
            f395859b = new A2dpState[]{r100, r101, r102, r103, r104, r105};
        }

        public static A2dpState[] values() {
            return (A2dpState[]) f395859b.clone();
        }

        public int getValue() {
            return this.f395860a;
        }

        public static A2dpState valueOf(String r100) {
            return (A2dpState) r27.a.a(A2dpState.class, r100);
        }

        public A2dpState(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395860a = r101;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final enum GattState extends Enum<GattState> {
        public static final GattState STATE_CONNECTED = null;
        public static final GattState STATE_DISCONNECTED = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GattState[] f395861b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395862a;

        static {
            GattState r100 = new GattState(0, 0, "STATE_DISCONNECTED");
            STATE_DISCONNECTED = r100;
            GattState r101 = new GattState(1, 2, "STATE_CONNECTED");
            STATE_CONNECTED = r101;
            f395861b = new GattState[]{r100, r101};
        }

        public static GattState[] values() {
            return (GattState[]) f395861b.clone();
        }

        public int getValue() {
            return this.f395862a;
        }

        public static GattState valueOf(String r100) {
            return (GattState) r27.a.a(GattState.class, r100);
        }

        public GattState(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395862a = r101;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final enum HeadsetState extends Enum<HeadsetState> {
        public static final HeadsetState STATE_AUDIO_CONNECTED = null;
        public static final HeadsetState STATE_AUDIO_CONNECTING = null;
        public static final HeadsetState STATE_AUDIO_DISCONNECTED = null;
        public static final HeadsetState STATE_CONNECTED = null;
        public static final HeadsetState STATE_CONNECTING = null;
        public static final HeadsetState STATE_DISCONNECTED = null;
        public static final HeadsetState STATE_DISCONNECTING = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ HeadsetState[] f395863b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395864a;

        static {
            HeadsetState r100 = new HeadsetState(0, 0, "STATE_DISCONNECTED");
            STATE_DISCONNECTED = r100;
            HeadsetState r101 = new HeadsetState(1, 1, "STATE_CONNECTING");
            STATE_CONNECTING = r101;
            HeadsetState r102 = new HeadsetState(2, 2, "STATE_CONNECTED");
            STATE_CONNECTED = r102;
            HeadsetState r103 = new HeadsetState(3, 3, "STATE_DISCONNECTING");
            STATE_DISCONNECTING = r103;
            HeadsetState r104 = new HeadsetState(4, 10, "STATE_AUDIO_DISCONNECTED");
            STATE_AUDIO_DISCONNECTED = r104;
            HeadsetState r105 = new HeadsetState(5, 11, "STATE_AUDIO_CONNECTING");
            STATE_AUDIO_CONNECTING = r105;
            HeadsetState r110 = new HeadsetState(6, 12, "STATE_AUDIO_CONNECTED");
            STATE_AUDIO_CONNECTED = r110;
            f395863b = new HeadsetState[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static HeadsetState[] values() {
            return (HeadsetState[]) f395863b.clone();
        }

        public int getValue() {
            return this.f395864a;
        }

        public static HeadsetState valueOf(String r100) {
            return (HeadsetState) r27.a.a(HeadsetState.class, r100);
        }

        public HeadsetState(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395864a = r101;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final enum PbapState extends Enum<PbapState> {
        public static final PbapState STATE_CONNECTED = null;
        public static final PbapState STATE_CONNECTING = null;
        public static final PbapState STATE_DISCONNECTED = null;
        public static final PbapState STATE_DISCONNECTING = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PbapState[] f395865b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395866a;

        static {
            PbapState r100 = new PbapState(0, 0, "STATE_DISCONNECTED");
            STATE_DISCONNECTED = r100;
            PbapState r101 = new PbapState(1, 1, "STATE_CONNECTING");
            STATE_CONNECTING = r101;
            PbapState r102 = new PbapState(2, 2, "STATE_CONNECTED");
            STATE_CONNECTED = r102;
            PbapState r103 = new PbapState(3, 3, "STATE_DISCONNECTING");
            STATE_DISCONNECTING = r103;
            f395865b = new PbapState[]{r100, r101, r102, r103};
        }

        public static PbapState[] values() {
            return (PbapState[]) f395865b.clone();
        }

        public int getValue() {
            return this.f395866a;
        }

        public static PbapState valueOf(String r100) {
            return (PbapState) r27.a.a(PbapState.class, r100);
        }

        public PbapState(int r100, int r101, String r102) {
            super(r102, r100);
            this.f395866a = r101;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public class a implements Parcelable.Creator<SmartBluetoothEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SmartBluetoothEvent createFromParcel(Parcel r100) {
            return new SmartBluetoothEvent(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SmartBluetoothEvent[] newArray(int r100) {
            return new SmartBluetoothEvent[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String getProfileName() {
        int r100 = this.mProfile;
        if (r100 != 1) goto L5;
        return "HEADSET";
    L5:
        if (r100 != 2) goto L7;
        return "A2DP";
    L7:
        if (r100 != 6) goto L9;
        return "PBAP";
    L9:
        if (r100 == 7) goto L12;
        return "WAIT_ADAPT";
    L12:
        return "GATT";
    }

    public String getStateName() {
        int r100 = this.mProfile;
        if (r100 != 1) goto L28;
        int r101 = this.mState;
        if (r101 != HeadsetState.STATE_DISCONNECTED.getValue()) goto L8;
        return "STATE_DISCONNECTED";
    L8:
        if (r101 != HeadsetState.STATE_CONNECTING.getValue()) goto L11;
        return "STATE_CONNECTING";
    L11:
        if (r101 != HeadsetState.STATE_CONNECTED.getValue()) goto L14;
        return "STATE_CONNECTED";
    L14:
        if (r101 != HeadsetState.STATE_DISCONNECTING.getValue()) goto L17;
        return "STATE_DISCONNECTING";
    L17:
        if (r101 != HeadsetState.STATE_AUDIO_DISCONNECTED.getValue()) goto L20;
        return "STATE_AUDIO_DISCONNECTED";
    L20:
        if (r101 != HeadsetState.STATE_AUDIO_CONNECTING.getValue()) goto L23;
        return "STATE_AUDIO_CONNECTING";
    L23:
        if (r101 != HeadsetState.STATE_AUDIO_CONNECTED.getValue()) goto L26;
        return "STATE_AUDIO_CONNECTED";
    L26:
        return "UNKNOWN";
    L28:
        if (r100 != 2) goto L50;
        int r102 = this.mState;
        if (r102 != A2dpState.STATE_DISCONNECTED.getValue()) goto L33;
        return "STATE_DISCONNECTED";
    L33:
        if (r102 != A2dpState.STATE_CONNECTING.getValue()) goto L36;
        return "STATE_CONNECTING";
    L36:
        if (r102 != A2dpState.STATE_CONNECTED.getValue()) goto L39;
        return "STATE_CONNECTED";
    L39:
        if (r102 != A2dpState.STATE_DISCONNECTING.getValue()) goto L42;
        return "STATE_DISCONNECTING";
    L42:
        if (r102 != A2dpState.STATE_PLAYING.getValue()) goto L45;
        return "STATE_PLAYING";
    L45:
        if (r102 != A2dpState.STATE_NOT_PLAYING.getValue()) goto L48;
        return "STATE_NOT_PLAYING";
    L48:
        return "UNKNOWN";
    L50:
        if (r100 != 6) goto L66;
        int r103 = this.mState;
        if (r103 != PbapState.STATE_DISCONNECTED.getValue()) goto L55;
        return "STATE_DISCONNECTED";
    L55:
        if (r103 != PbapState.STATE_CONNECTING.getValue()) goto L58;
        return "STATE_CONNECTING";
    L58:
        if (r103 != PbapState.STATE_CONNECTED.getValue()) goto L61;
        return "STATE_CONNECTED";
    L61:
        if (r103 != PbapState.STATE_DISCONNECTING.getValue()) goto L64;
        return "STATE_DISCONNECTING";
    L64:
        return "UNKNOWN";
    L66:
        if (r100 != 7) goto L74;
        int r104 = this.mState;
        if (r104 != GattState.STATE_DISCONNECTED.getValue()) goto L71;
        return "STATE_DISCONNECTED";
    L71:
        if (r104 == GattState.STATE_CONNECTED.getValue()) goto L73;
        return "UNKNOWN";
    L73:
        return "STATE_CONNECTED";
    L74:
        return "WAIT_ADAPT";
    }

    public String toString() {
        if (this.mBluetoothDevice != null) goto L7;
        return "null";
    L7:
        return "SmartBluetoothEvent[1, " + this.mBluetoothDevice.getName() + ", " + this.mBluetoothDevice.getAddress() + ", " + getProfileName() + ", " + getStateName() + ']';
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    public int getProfile() {
        return this.mProfile;
    }

    public int getState() {
        return this.mState;
    }

    public SmartBluetoothEvent(Parcel r100) {
        this.mBluetoothDevice = (BluetoothDevice) r100.readParcelable(BluetoothDevice.class.getClassLoader());
        this.mProfile = r100.readInt();
        this.mState = r100.readInt();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        SmartBluetoothEvent r101 = (SmartBluetoothEvent) r100;
        if (this.mProfile != r101.mProfile) goto L17;
        if (this.mState != r101.mState) goto L17;
        return Objects.equals(this.mBluetoothDevice, r101.mBluetoothDevice);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.mBluetoothDevice, 0);
        r100.writeInt(this.mProfile);
        r100.writeInt(this.mState);
    }

    public SmartBluetoothEvent(BluetoothDevice r100, int r101, int r102) {
        this.mBluetoothDevice = r100;
        this.mProfile = r101;
        this.mState = r102;
    }
}
