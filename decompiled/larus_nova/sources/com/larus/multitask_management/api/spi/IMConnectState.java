package com.larus.multitask_management.api.spi;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/multitask_management/api/spi/IMConnectState;", "", "<init>", "(Ljava/lang/String;I)V", State.DISCONNECTED, "CONNECTING", "CONNECTED", "multitask_management_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IMConnectState extends Enum<IMConnectState> {
    public static final IMConnectState CONNECTED = null;
    public static final IMConnectState CONNECTING = null;
    public static final IMConnectState DISCONNECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IMConnectState[] f359389a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359390b = null;

    public static EnumEntries<IMConnectState> getEntries() {
        return f359390b;
    }

    static {
        IMConnectState r100 = new IMConnectState(State.DISCONNECTED, 0);
        DISCONNECTED = r100;
        IMConnectState r101 = new IMConnectState("CONNECTING", 1);
        CONNECTING = r101;
        IMConnectState r102 = new IMConnectState("CONNECTED", 2);
        CONNECTED = r102;
        IMConnectState[] r103 = {r100, r101, r102};
        f359389a = r103;
        f359390b = EnumEntriesKt.enumEntries(r103);
    }

    public static IMConnectState[] values() {
        return (IMConnectState[]) f359389a.clone();
    }

    public static IMConnectState valueOf(String r100) {
        return (IMConnectState) a.a(IMConnectState.class, r100);
    }

    public IMConnectState(String r100, int r101) {
        super(r100, r101);
    }
}
