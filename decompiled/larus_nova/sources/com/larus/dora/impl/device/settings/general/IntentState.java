package com.larus.dora.impl.device.settings.general;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/impl/device/settings/general/IntentState;", "", "<init>", "(Ljava/lang/String;I)V", "ACTION_NO_DEVICE_CONNECTED", "ACTION_SERVER_UNBIND_NETWORK_ERROR", "ACTION_SERVER_UNBIND_FAILED", "ACTION_SPP_DISCONNECT_FAILED", "ACTION_UNBIND_SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IntentState extends Enum<IntentState> {
    public static final IntentState ACTION_NO_DEVICE_CONNECTED = null;
    public static final IntentState ACTION_SERVER_UNBIND_FAILED = null;
    public static final IntentState ACTION_SERVER_UNBIND_NETWORK_ERROR = null;
    public static final IntentState ACTION_SPP_DISCONNECT_FAILED = null;
    public static final IntentState ACTION_UNBIND_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IntentState[] f334326a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334327b = null;

    public static EnumEntries<IntentState> getEntries() {
        return f334327b;
    }

    static {
        IntentState r100 = new IntentState("ACTION_NO_DEVICE_CONNECTED", 0);
        ACTION_NO_DEVICE_CONNECTED = r100;
        IntentState r101 = new IntentState("ACTION_SERVER_UNBIND_NETWORK_ERROR", 1);
        ACTION_SERVER_UNBIND_NETWORK_ERROR = r101;
        IntentState r102 = new IntentState("ACTION_SERVER_UNBIND_FAILED", 2);
        ACTION_SERVER_UNBIND_FAILED = r102;
        IntentState r103 = new IntentState("ACTION_SPP_DISCONNECT_FAILED", 3);
        ACTION_SPP_DISCONNECT_FAILED = r103;
        IntentState r104 = new IntentState("ACTION_UNBIND_SUCCESS", 4);
        ACTION_UNBIND_SUCCESS = r104;
        IntentState[] r105 = {r100, r101, r102, r103, r104};
        f334326a = r105;
        f334327b = EnumEntriesKt.enumEntries(r105);
    }

    public static IntentState[] values() {
        return (IntentState[]) f334326a.clone();
    }

    public static IntentState valueOf(String r100) {
        return (IntentState) r27.a.a(IntentState.class, r100);
    }

    public IntentState(String r100, int r101) {
        super(r100, r101);
    }
}
