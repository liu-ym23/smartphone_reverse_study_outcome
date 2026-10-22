package com.obric.assistant.wakeup.bluetooth_headset.api;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueDeviceConnectState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "CONNECTED", State.DISCONNECTED, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlueDeviceConnectState extends Enum<BlueDeviceConnectState> {
    public static final BlueDeviceConnectState CONNECTED = null;
    public static final BlueDeviceConnectState DISCONNECTED = null;
    public static final BlueDeviceConnectState NA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlueDeviceConnectState[] f394390a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f394391b = null;

    public static EnumEntries<BlueDeviceConnectState> getEntries() {
        return f394391b;
    }

    static {
        BlueDeviceConnectState r100 = new BlueDeviceConnectState("NA", 0);
        NA = r100;
        BlueDeviceConnectState r101 = new BlueDeviceConnectState("CONNECTED", 1);
        CONNECTED = r101;
        BlueDeviceConnectState r102 = new BlueDeviceConnectState(State.DISCONNECTED, 2);
        DISCONNECTED = r102;
        BlueDeviceConnectState[] r103 = {r100, r101, r102};
        f394390a = r103;
        f394391b = EnumEntriesKt.enumEntries(r103);
    }

    public static BlueDeviceConnectState[] values() {
        return (BlueDeviceConnectState[]) f394390a.clone();
    }

    public static BlueDeviceConnectState valueOf(String r100) {
        return (BlueDeviceConnectState) a.a(BlueDeviceConnectState.class, r100);
    }

    public BlueDeviceConnectState(String r100, int r101) {
        super(r100, r101);
    }
}
