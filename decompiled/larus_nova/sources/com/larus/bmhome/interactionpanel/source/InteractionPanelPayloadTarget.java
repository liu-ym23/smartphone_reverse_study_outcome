package com.larus.bmhome.interactionpanel.source;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/interactionpanel/source/InteractionPanelPayloadTarget;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_HOST", "THREAD_HOST", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InteractionPanelPayloadTarget extends Enum<InteractionPanelPayloadTarget> {
    public static final InteractionPanelPayloadTarget MAIN_HOST = null;
    public static final InteractionPanelPayloadTarget THREAD_HOST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractionPanelPayloadTarget[] f312402a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312403b = null;

    public static EnumEntries<InteractionPanelPayloadTarget> getEntries() {
        return f312403b;
    }

    static {
        InteractionPanelPayloadTarget r100 = new InteractionPanelPayloadTarget("MAIN_HOST", 0);
        MAIN_HOST = r100;
        InteractionPanelPayloadTarget r101 = new InteractionPanelPayloadTarget("THREAD_HOST", 1);
        THREAD_HOST = r101;
        InteractionPanelPayloadTarget[] r102 = {r100, r101};
        f312402a = r102;
        f312403b = EnumEntriesKt.enumEntries(r102);
    }

    public static InteractionPanelPayloadTarget[] values() {
        return (InteractionPanelPayloadTarget[]) f312402a.clone();
    }

    public static InteractionPanelPayloadTarget valueOf(String r100) {
        return (InteractionPanelPayloadTarget) a.a(InteractionPanelPayloadTarget.class, r100);
    }

    public InteractionPanelPayloadTarget(String r100, int r101) {
        super(r100, r101);
    }
}
