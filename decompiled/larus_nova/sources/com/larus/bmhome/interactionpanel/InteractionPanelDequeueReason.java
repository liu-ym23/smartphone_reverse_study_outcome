package com.larus.bmhome.interactionpanel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/interactionpanel/InteractionPanelDequeueReason;", "", "<init>", "(Ljava/lang/String;I)V", "CONSUMED", "HIDDEN", "EXPIRED", "SOURCE_INVALIDATED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InteractionPanelDequeueReason extends Enum<InteractionPanelDequeueReason> {
    public static final InteractionPanelDequeueReason CONSUMED = null;
    public static final InteractionPanelDequeueReason EXPIRED = null;
    public static final InteractionPanelDequeueReason HIDDEN = null;
    public static final InteractionPanelDequeueReason SOURCE_INVALIDATED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractionPanelDequeueReason[] f312259a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312260b = null;

    public static EnumEntries<InteractionPanelDequeueReason> getEntries() {
        return f312260b;
    }

    static {
        InteractionPanelDequeueReason r100 = new InteractionPanelDequeueReason("CONSUMED", 0);
        CONSUMED = r100;
        InteractionPanelDequeueReason r101 = new InteractionPanelDequeueReason("HIDDEN", 1);
        HIDDEN = r101;
        InteractionPanelDequeueReason r102 = new InteractionPanelDequeueReason("EXPIRED", 2);
        EXPIRED = r102;
        InteractionPanelDequeueReason r103 = new InteractionPanelDequeueReason("SOURCE_INVALIDATED", 3);
        SOURCE_INVALIDATED = r103;
        InteractionPanelDequeueReason[] r104 = {r100, r101, r102, r103};
        f312259a = r104;
        f312260b = EnumEntriesKt.enumEntries(r104);
    }

    public static InteractionPanelDequeueReason[] values() {
        return (InteractionPanelDequeueReason[]) f312259a.clone();
    }

    public static InteractionPanelDequeueReason valueOf(String r100) {
        return (InteractionPanelDequeueReason) r27.a.a(InteractionPanelDequeueReason.class, r100);
    }

    public InteractionPanelDequeueReason(String r100, int r101) {
        super(r100, r101);
    }
}
