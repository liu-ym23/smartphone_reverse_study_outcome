package com.bytedance.lark.policy.event;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/policy/event/InnerEvent;", "", "<init>", "(Ljava/lang/String;I)V", "EVENT_TIMER", "EVENT_FACTOR_CHANGE", "EVENT_POLICY_CHANGE", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InnerEvent extends Enum<InnerEvent> {
    public static final InnerEvent EVENT_FACTOR_CHANGE = null;
    public static final InnerEvent EVENT_POLICY_CHANGE = null;
    public static final InnerEvent EVENT_TIMER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InnerEvent[] f253803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f253804b = null;

    public static EnumEntries<InnerEvent> getEntries() {
        return f253804b;
    }

    static {
        InnerEvent r100 = new InnerEvent("EVENT_TIMER", 0);
        EVENT_TIMER = r100;
        InnerEvent r101 = new InnerEvent("EVENT_FACTOR_CHANGE", 1);
        EVENT_FACTOR_CHANGE = r101;
        InnerEvent r102 = new InnerEvent("EVENT_POLICY_CHANGE", 2);
        EVENT_POLICY_CHANGE = r102;
        InnerEvent[] r103 = {r100, r101, r102};
        f253803a = r103;
        f253804b = EnumEntriesKt.enumEntries(r103);
    }

    public static InnerEvent[] values() {
        return (InnerEvent[]) f253803a.clone();
    }

    public static InnerEvent valueOf(String r100) {
        return (InnerEvent) r27.a.a(InnerEvent.class, r100);
    }

    public InnerEvent(String r100, int r101) {
        super(r100, r101);
    }
}
