package com.larus.bmhome.interactionpanel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/interactionpanel/InteractionPanelType;", "", "<init>", "(Ljava/lang/String;I)V", "CLARIFICATION", "INPUT_AREA_BLOCK", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InteractionPanelType extends Enum<InteractionPanelType> {
    public static final InteractionPanelType CLARIFICATION = null;
    public static final InteractionPanelType INPUT_AREA_BLOCK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractionPanelType[] f312290a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312291b = null;

    public static EnumEntries<InteractionPanelType> getEntries() {
        return f312291b;
    }

    static {
        InteractionPanelType r100 = new InteractionPanelType("CLARIFICATION", 0);
        CLARIFICATION = r100;
        InteractionPanelType r101 = new InteractionPanelType("INPUT_AREA_BLOCK", 1);
        INPUT_AREA_BLOCK = r101;
        InteractionPanelType[] r102 = {r100, r101};
        f312290a = r102;
        f312291b = EnumEntriesKt.enumEntries(r102);
    }

    public static InteractionPanelType[] values() {
        return (InteractionPanelType[]) f312290a.clone();
    }

    public static InteractionPanelType valueOf(String r100) {
        return (InteractionPanelType) r27.a.a(InteractionPanelType.class, r100);
    }

    public InteractionPanelType(String r100, int r101) {
        super(r100, r101);
    }
}
