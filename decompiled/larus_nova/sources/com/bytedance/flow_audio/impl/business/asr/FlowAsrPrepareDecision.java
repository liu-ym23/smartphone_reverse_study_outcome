package com.bytedance.flow_audio.impl.business.asr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/flow_audio/impl/business/asr/FlowAsrPrepareDecision;", "", "<init>", "(Ljava/lang/String;I)V", "START_PREPARE", "ALREADY_PREPARED", "IGNORE", "flow_audio_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAsrPrepareDecision extends Enum<FlowAsrPrepareDecision> {
    public static final FlowAsrPrepareDecision ALREADY_PREPARED = null;
    public static final FlowAsrPrepareDecision IGNORE = null;
    public static final FlowAsrPrepareDecision START_PREPARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowAsrPrepareDecision[] f243784a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243785b = null;

    public static EnumEntries<FlowAsrPrepareDecision> getEntries() {
        return f243785b;
    }

    static {
        FlowAsrPrepareDecision r100 = new FlowAsrPrepareDecision("START_PREPARE", 0);
        START_PREPARE = r100;
        FlowAsrPrepareDecision r101 = new FlowAsrPrepareDecision("ALREADY_PREPARED", 1);
        ALREADY_PREPARED = r101;
        FlowAsrPrepareDecision r102 = new FlowAsrPrepareDecision("IGNORE", 2);
        IGNORE = r102;
        FlowAsrPrepareDecision[] r103 = {r100, r101, r102};
        f243784a = r103;
        f243785b = EnumEntriesKt.enumEntries(r103);
    }

    public static FlowAsrPrepareDecision[] values() {
        return (FlowAsrPrepareDecision[]) f243784a.clone();
    }

    public static FlowAsrPrepareDecision valueOf(String r100) {
        return (FlowAsrPrepareDecision) r27.a.a(FlowAsrPrepareDecision.class, r100);
    }

    public FlowAsrPrepareDecision(String r100, int r101) {
        super(r100, r101);
    }
}
