package com.bytedance.flow_audio.api.business.asr.result;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/flow_audio/api/business/asr/result/FlowAsrResultType;", "", "<init>", "(Ljava/lang/String;I)V", "INTERIM", "STREAM_FINAL", "FINAL", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAsrResultType extends Enum<FlowAsrResultType> {
    public static final FlowAsrResultType FINAL = null;
    public static final FlowAsrResultType INTERIM = null;
    public static final FlowAsrResultType STREAM_FINAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowAsrResultType[] f243675a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243676b = null;

    public static EnumEntries<FlowAsrResultType> getEntries() {
        return f243676b;
    }

    static {
        FlowAsrResultType r100 = new FlowAsrResultType("INTERIM", 0);
        INTERIM = r100;
        FlowAsrResultType r101 = new FlowAsrResultType("STREAM_FINAL", 1);
        STREAM_FINAL = r101;
        FlowAsrResultType r102 = new FlowAsrResultType("FINAL", 2);
        FINAL = r102;
        FlowAsrResultType[] r103 = {r100, r101, r102};
        f243675a = r103;
        f243676b = EnumEntriesKt.enumEntries(r103);
    }

    public static FlowAsrResultType[] values() {
        return (FlowAsrResultType[]) f243675a.clone();
    }

    public static FlowAsrResultType valueOf(String r100) {
        return (FlowAsrResultType) a.a(FlowAsrResultType.class, r100);
    }

    public FlowAsrResultType(String r100, int r101) {
        super(r100, r101);
    }
}
