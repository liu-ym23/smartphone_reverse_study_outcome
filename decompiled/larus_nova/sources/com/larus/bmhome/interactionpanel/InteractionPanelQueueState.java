package com.larus.bmhome.interactionpanel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/interactionpanel/InteractionPanelQueueState;", "", "<init>", "(Ljava/lang/String;I)V", "QUEUED", "SUBMITTING", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InteractionPanelQueueState extends Enum<InteractionPanelQueueState> {
    public static final InteractionPanelQueueState QUEUED = null;
    public static final InteractionPanelQueueState SUBMITTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractionPanelQueueState[] f312278a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312279b = null;

    public static EnumEntries<InteractionPanelQueueState> getEntries() {
        return f312279b;
    }

    static {
        InteractionPanelQueueState r100 = new InteractionPanelQueueState("QUEUED", 0);
        QUEUED = r100;
        InteractionPanelQueueState r101 = new InteractionPanelQueueState("SUBMITTING", 1);
        SUBMITTING = r101;
        InteractionPanelQueueState[] r102 = {r100, r101};
        f312278a = r102;
        f312279b = EnumEntriesKt.enumEntries(r102);
    }

    public static InteractionPanelQueueState[] values() {
        return (InteractionPanelQueueState[]) f312278a.clone();
    }

    public static InteractionPanelQueueState valueOf(String r100) {
        return (InteractionPanelQueueState) r27.a.a(InteractionPanelQueueState.class, r100);
    }

    public InteractionPanelQueueState(String r100, int r101) {
        super(r100, r101);
    }
}
