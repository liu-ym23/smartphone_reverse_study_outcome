package com.larus.dora.impl.device.settings.unbind;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindState;", "", "<init>", "(Ljava/lang/String;I)V", "NO_DEVICE_CONNECTED", "SERVER_UNBIND_NETWORK_ERROR", "SERVER_UNBIND_FAILED", "SPP_DISCONNECT_FAILED", "UNBIND_SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraUnbindState extends Enum<DoraUnbindState> {
    public static final DoraUnbindState NO_DEVICE_CONNECTED = null;
    public static final DoraUnbindState SERVER_UNBIND_FAILED = null;
    public static final DoraUnbindState SERVER_UNBIND_NETWORK_ERROR = null;
    public static final DoraUnbindState SPP_DISCONNECT_FAILED = null;
    public static final DoraUnbindState UNBIND_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraUnbindState[] f334934a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334935b = null;

    public static EnumEntries<DoraUnbindState> getEntries() {
        return f334935b;
    }

    static {
        DoraUnbindState r100 = new DoraUnbindState("NO_DEVICE_CONNECTED", 0);
        NO_DEVICE_CONNECTED = r100;
        DoraUnbindState r101 = new DoraUnbindState("SERVER_UNBIND_NETWORK_ERROR", 1);
        SERVER_UNBIND_NETWORK_ERROR = r101;
        DoraUnbindState r102 = new DoraUnbindState("SERVER_UNBIND_FAILED", 2);
        SERVER_UNBIND_FAILED = r102;
        DoraUnbindState r103 = new DoraUnbindState("SPP_DISCONNECT_FAILED", 3);
        SPP_DISCONNECT_FAILED = r103;
        DoraUnbindState r104 = new DoraUnbindState("UNBIND_SUCCESS", 4);
        UNBIND_SUCCESS = r104;
        DoraUnbindState[] r105 = {r100, r101, r102, r103, r104};
        f334934a = r105;
        f334935b = EnumEntriesKt.enumEntries(r105);
    }

    public static DoraUnbindState[] values() {
        return (DoraUnbindState[]) f334934a.clone();
    }

    public static DoraUnbindState valueOf(String r100) {
        return (DoraUnbindState) r27.a.a(DoraUnbindState.class, r100);
    }

    public DoraUnbindState(String r100, int r101) {
        super(r100, r101);
    }
}
