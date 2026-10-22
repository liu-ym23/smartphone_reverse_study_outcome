package com.larus.bmhome.taskskill.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/taskskill/model/PcDeviceUiState;", "", "<init>", "(Ljava/lang/String;I)V", "AUTHORIZED_AVAILABLE", "UNAUTHORIZED_AVAILABLE", "OFFLINE", "NEED_UPGRADE", "CONTROL_DISABLED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PcDeviceUiState extends Enum<PcDeviceUiState> {
    public static final PcDeviceUiState AUTHORIZED_AVAILABLE = null;
    public static final PcDeviceUiState CONTROL_DISABLED = null;
    public static final PcDeviceUiState NEED_UPGRADE = null;
    public static final PcDeviceUiState OFFLINE = null;
    public static final PcDeviceUiState UNAUTHORIZED_AVAILABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PcDeviceUiState[] f314344a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314345b = null;

    public static EnumEntries<PcDeviceUiState> getEntries() {
        return f314345b;
    }

    static {
        PcDeviceUiState r100 = new PcDeviceUiState("AUTHORIZED_AVAILABLE", 0);
        AUTHORIZED_AVAILABLE = r100;
        PcDeviceUiState r101 = new PcDeviceUiState("UNAUTHORIZED_AVAILABLE", 1);
        UNAUTHORIZED_AVAILABLE = r101;
        PcDeviceUiState r102 = new PcDeviceUiState("OFFLINE", 2);
        OFFLINE = r102;
        PcDeviceUiState r103 = new PcDeviceUiState("NEED_UPGRADE", 3);
        NEED_UPGRADE = r103;
        PcDeviceUiState r104 = new PcDeviceUiState("CONTROL_DISABLED", 4);
        CONTROL_DISABLED = r104;
        PcDeviceUiState[] r105 = {r100, r101, r102, r103, r104};
        f314344a = r105;
        f314345b = EnumEntriesKt.enumEntries(r105);
    }

    public static PcDeviceUiState[] values() {
        return (PcDeviceUiState[]) f314344a.clone();
    }

    public static PcDeviceUiState valueOf(String r100) {
        return (PcDeviceUiState) r27.a.a(PcDeviceUiState.class, r100);
    }

    public PcDeviceUiState(String r100, int r101) {
        super(r100, r101);
    }
}
