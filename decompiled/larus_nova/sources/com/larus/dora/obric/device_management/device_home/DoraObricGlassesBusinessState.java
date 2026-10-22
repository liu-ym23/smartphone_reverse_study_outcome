package com.larus.dora.obric.device_management.device_home;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricGlassesBusinessState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", State.RECORDING, "INTERPRETING", "VIDEO_RECORDING", "VIDEO_CALL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGlassesBusinessState extends Enum<DoraObricGlassesBusinessState> {
    public static final DoraObricGlassesBusinessState IDLE = null;
    public static final DoraObricGlassesBusinessState INTERPRETING = null;
    public static final DoraObricGlassesBusinessState RECORDING = null;
    public static final DoraObricGlassesBusinessState VIDEO_CALL = null;
    public static final DoraObricGlassesBusinessState VIDEO_RECORDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricGlassesBusinessState[] f339155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339156b = null;

    public static EnumEntries<DoraObricGlassesBusinessState> getEntries() {
        return f339156b;
    }

    static {
        DoraObricGlassesBusinessState r100 = new DoraObricGlassesBusinessState("IDLE", 0);
        IDLE = r100;
        DoraObricGlassesBusinessState r101 = new DoraObricGlassesBusinessState(State.RECORDING, 1);
        RECORDING = r101;
        DoraObricGlassesBusinessState r102 = new DoraObricGlassesBusinessState("INTERPRETING", 2);
        INTERPRETING = r102;
        DoraObricGlassesBusinessState r103 = new DoraObricGlassesBusinessState("VIDEO_RECORDING", 3);
        VIDEO_RECORDING = r103;
        DoraObricGlassesBusinessState r104 = new DoraObricGlassesBusinessState("VIDEO_CALL", 4);
        VIDEO_CALL = r104;
        DoraObricGlassesBusinessState[] r105 = {r100, r101, r102, r103, r104};
        f339155a = r105;
        f339156b = EnumEntriesKt.enumEntries(r105);
    }

    public static DoraObricGlassesBusinessState[] values() {
        return (DoraObricGlassesBusinessState[]) f339155a.clone();
    }

    public static DoraObricGlassesBusinessState valueOf(String r100) {
        return (DoraObricGlassesBusinessState) r27.a.a(DoraObricGlassesBusinessState.class, r100);
    }

    public DoraObricGlassesBusinessState(String r100, int r101) {
        super(r100, r101);
    }
}
