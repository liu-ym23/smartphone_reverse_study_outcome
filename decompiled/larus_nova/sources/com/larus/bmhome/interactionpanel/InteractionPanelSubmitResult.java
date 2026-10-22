package com.larus.bmhome.interactionpanel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/interactionpanel/InteractionPanelSubmitResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "CANCELLED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InteractionPanelSubmitResult extends Enum<InteractionPanelSubmitResult> {
    public static final InteractionPanelSubmitResult CANCELLED = null;
    public static final InteractionPanelSubmitResult FAILURE = null;
    public static final InteractionPanelSubmitResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractionPanelSubmitResult[] f312288a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312289b = null;

    public static EnumEntries<InteractionPanelSubmitResult> getEntries() {
        return f312289b;
    }

    static {
        InteractionPanelSubmitResult r100 = new InteractionPanelSubmitResult("SUCCESS", 0);
        SUCCESS = r100;
        InteractionPanelSubmitResult r101 = new InteractionPanelSubmitResult("FAILURE", 1);
        FAILURE = r101;
        InteractionPanelSubmitResult r102 = new InteractionPanelSubmitResult("CANCELLED", 2);
        CANCELLED = r102;
        InteractionPanelSubmitResult[] r103 = {r100, r101, r102};
        f312288a = r103;
        f312289b = EnumEntriesKt.enumEntries(r103);
    }

    public static InteractionPanelSubmitResult[] values() {
        return (InteractionPanelSubmitResult[]) f312288a.clone();
    }

    public static InteractionPanelSubmitResult valueOf(String r100) {
        return (InteractionPanelSubmitResult) r27.a.a(InteractionPanelSubmitResult.class, r100);
    }

    public InteractionPanelSubmitResult(String r100, int r101) {
        super(r100, r101);
    }
}
