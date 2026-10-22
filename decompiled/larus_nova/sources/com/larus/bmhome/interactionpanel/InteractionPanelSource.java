package com.larus.bmhome.interactionpanel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/interactionpanel/InteractionPanelSource;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_MESSAGE", "THREAD_MESSAGE", "GENERAL_INTERACTION_ASK_NOTIFY", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InteractionPanelSource extends Enum<InteractionPanelSource> {
    public static final InteractionPanelSource GENERAL_INTERACTION_ASK_NOTIFY = null;
    public static final InteractionPanelSource MAIN_MESSAGE = null;
    public static final InteractionPanelSource THREAD_MESSAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractionPanelSource[] f312286a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312287b = null;

    public static EnumEntries<InteractionPanelSource> getEntries() {
        return f312287b;
    }

    static {
        InteractionPanelSource r100 = new InteractionPanelSource("MAIN_MESSAGE", 0);
        MAIN_MESSAGE = r100;
        InteractionPanelSource r101 = new InteractionPanelSource("THREAD_MESSAGE", 1);
        THREAD_MESSAGE = r101;
        InteractionPanelSource r102 = new InteractionPanelSource("GENERAL_INTERACTION_ASK_NOTIFY", 2);
        GENERAL_INTERACTION_ASK_NOTIFY = r102;
        InteractionPanelSource[] r103 = {r100, r101, r102};
        f312286a = r103;
        f312287b = EnumEntriesKt.enumEntries(r103);
    }

    public static InteractionPanelSource[] values() {
        return (InteractionPanelSource[]) f312286a.clone();
    }

    public static InteractionPanelSource valueOf(String r100) {
        return (InteractionPanelSource) r27.a.a(InteractionPanelSource.class, r100);
    }

    public InteractionPanelSource(String r100, int r101) {
        super(r100, r101);
    }
}
