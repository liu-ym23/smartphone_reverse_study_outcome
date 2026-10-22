package com.larus.avlink.record.page;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/record/page/BottomStatus;", "", "<init>", "(Ljava/lang/String;I)V", State.RECORDING, "END_RECORDING", "OFFLINE_RECORDING", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BottomStatus extends Enum<BottomStatus> {
    public static final BottomStatus END_RECORDING = null;
    public static final BottomStatus OFFLINE_RECORDING = null;
    public static final BottomStatus RECORDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BottomStatus[] f294144a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294145b = null;

    public static EnumEntries<BottomStatus> getEntries() {
        return f294145b;
    }

    static {
        BottomStatus r100 = new BottomStatus(State.RECORDING, 0);
        RECORDING = r100;
        BottomStatus r101 = new BottomStatus("END_RECORDING", 1);
        END_RECORDING = r101;
        BottomStatus r102 = new BottomStatus("OFFLINE_RECORDING", 2);
        OFFLINE_RECORDING = r102;
        BottomStatus[] r103 = {r100, r101, r102};
        f294144a = r103;
        f294145b = EnumEntriesKt.enumEntries(r103);
    }

    public static BottomStatus[] values() {
        return (BottomStatus[]) f294144a.clone();
    }

    public static BottomStatus valueOf(String r100) {
        return (BottomStatus) r27.a.a(BottomStatus.class, r100);
    }

    public BottomStatus(String r100, int r101) {
        super(r100, r101);
    }
}
