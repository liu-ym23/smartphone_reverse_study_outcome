package com.larus.bmhome.instruction.core.model.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/instruction/core/model/widget/PanelState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "RENDER", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PanelState extends Enum<PanelState> {
    public static final PanelState IDLE = null;
    public static final PanelState RENDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelState[] f312057a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312058b = null;

    public static EnumEntries<PanelState> getEntries() {
        return f312058b;
    }

    static {
        PanelState r100 = new PanelState("IDLE", 0);
        IDLE = r100;
        PanelState r101 = new PanelState("RENDER", 1);
        RENDER = r101;
        PanelState[] r102 = {r100, r101};
        f312057a = r102;
        f312058b = EnumEntriesKt.enumEntries(r102);
    }

    public static PanelState[] values() {
        return (PanelState[]) f312057a.clone();
    }

    public static PanelState valueOf(String r100) {
        return (PanelState) a.a(PanelState.class, r100);
    }

    public PanelState(String r100, int r101) {
        super(r100, r101);
    }
}
