package com.bytedance.dorax.kmp.registry;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/dorax/kmp/registry/DeviceConnectionState;", "", "<init>", "(Ljava/lang/String;I)V", State.DISCONNECTED, "CONNECTING", "CONNECTED", "ERROR", "library_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum DeviceConnectionState extends Enum<DeviceConnectionState> {
    public static final DeviceConnectionState CONNECTED = null;
    public static final DeviceConnectionState CONNECTING = null;
    public static final DeviceConnectionState DISCONNECTED = null;
    public static final DeviceConnectionState ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeviceConnectionState[] f204765a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f204766b = null;

    public static EnumEntries<DeviceConnectionState> getEntries() {
        return f204766b;
    }

    static {
        DeviceConnectionState r100 = new DeviceConnectionState(State.DISCONNECTED, 0);
        DISCONNECTED = r100;
        DeviceConnectionState r101 = new DeviceConnectionState("CONNECTING", 1);
        CONNECTING = r101;
        DeviceConnectionState r102 = new DeviceConnectionState("CONNECTED", 2);
        CONNECTED = r102;
        DeviceConnectionState r103 = new DeviceConnectionState("ERROR", 3);
        ERROR = r103;
        DeviceConnectionState[] r104 = {r100, r101, r102, r103};
        f204765a = r104;
        f204766b = EnumEntriesKt.enumEntries(r104);
    }

    public static DeviceConnectionState[] values() {
        return (DeviceConnectionState[]) f204765a.clone();
    }

    public static DeviceConnectionState valueOf(String r100) {
        return (DeviceConnectionState) a.a(DeviceConnectionState.class, r100);
    }

    public DeviceConnectionState(String r100, int r101) {
        super(r100, r101);
    }
}
