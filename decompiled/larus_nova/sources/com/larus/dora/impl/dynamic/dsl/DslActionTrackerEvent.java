package com.larus.dora.impl.dynamic.dsl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslActionTrackerEvent;", "", "eventName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "DORA_CARD_CLICK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DslActionTrackerEvent extends Enum<DslActionTrackerEvent> {

    @SerializedName("dora_card_click")
    public static final DslActionTrackerEvent DORA_CARD_CLICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DslActionTrackerEvent[] f335153a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335154b = null;
    private final String eventName;

    public static EnumEntries<DslActionTrackerEvent> getEntries() {
        return f335154b;
    }

    static {
        DslActionTrackerEvent r100 = new DslActionTrackerEvent();
        DORA_CARD_CLICK = r100;
        DslActionTrackerEvent[] r101 = {r100};
        f335153a = r101;
        f335154b = EnumEntriesKt.enumEntries(r101);
    }

    public DslActionTrackerEvent() {
        super("DORA_CARD_CLICK", 0);
        this.eventName = "dora_card_click";
    }

    public static DslActionTrackerEvent[] values() {
        return (DslActionTrackerEvent[]) f335153a.clone();
    }

    public final String getEventName() {
        return this.eventName;
    }

    public static DslActionTrackerEvent valueOf(String r100) {
        return (DslActionTrackerEvent) r27.a.a(DslActionTrackerEvent.class, r100);
    }
}
