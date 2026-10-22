package com.obric.assistant.wakeup.bluetooth_headset.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueDeviceSwitchState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "ON", "OFF", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlueDeviceSwitchState extends Enum<BlueDeviceSwitchState> {
    public static final BlueDeviceSwitchState NA = null;
    public static final BlueDeviceSwitchState OFF = null;
    public static final BlueDeviceSwitchState ON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlueDeviceSwitchState[] f394392a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f394393b = null;

    public static EnumEntries<BlueDeviceSwitchState> getEntries() {
        return f394393b;
    }

    static {
        BlueDeviceSwitchState r100 = new BlueDeviceSwitchState("NA", 0);
        NA = r100;
        BlueDeviceSwitchState r101 = new BlueDeviceSwitchState("ON", 1);
        ON = r101;
        BlueDeviceSwitchState r102 = new BlueDeviceSwitchState("OFF", 2);
        OFF = r102;
        BlueDeviceSwitchState[] r103 = {r100, r101, r102};
        f394392a = r103;
        f394393b = EnumEntriesKt.enumEntries(r103);
    }

    public static BlueDeviceSwitchState[] values() {
        return (BlueDeviceSwitchState[]) f394392a.clone();
    }

    public static BlueDeviceSwitchState valueOf(String r100) {
        return (BlueDeviceSwitchState) a.a(BlueDeviceSwitchState.class, r100);
    }

    public BlueDeviceSwitchState(String r100, int r101) {
        super(r100, r101);
    }
}
