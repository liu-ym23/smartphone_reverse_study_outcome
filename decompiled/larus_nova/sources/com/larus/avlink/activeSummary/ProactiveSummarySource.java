package com.larus.avlink.activeSummary;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/activeSummary/ProactiveSummarySource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "IM_FRONTIER", "IM_FRONTIER_CACHE", "SSE_FRONTIER", "SSE_FRONTIER_CACHE", FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, "PUSH_CACHE", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProactiveSummarySource extends Enum<ProactiveSummarySource> {
    public static final ProactiveSummarySource IM_FRONTIER = null;
    public static final ProactiveSummarySource IM_FRONTIER_CACHE = null;
    public static final ProactiveSummarySource PUSH = null;
    public static final ProactiveSummarySource PUSH_CACHE = null;
    public static final ProactiveSummarySource SSE_FRONTIER = null;
    public static final ProactiveSummarySource SSE_FRONTIER_CACHE = null;
    public static final ProactiveSummarySource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProactiveSummarySource[] f291433a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291434b = null;
    private final String value;

    public static EnumEntries<ProactiveSummarySource> getEntries() {
        return f291434b;
    }

    static {
        ProactiveSummarySource r100 = new ProactiveSummarySource("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        ProactiveSummarySource r101 = new ProactiveSummarySource("IM_FRONTIER", 1, "im_frontier");
        IM_FRONTIER = r101;
        ProactiveSummarySource r102 = new ProactiveSummarySource("IM_FRONTIER_CACHE", 2, "im_frontier_cache");
        IM_FRONTIER_CACHE = r102;
        ProactiveSummarySource r103 = new ProactiveSummarySource("SSE_FRONTIER", 3, "sse_frontier");
        SSE_FRONTIER = r103;
        ProactiveSummarySource r104 = new ProactiveSummarySource("SSE_FRONTIER_CACHE", 4, "sse_frontier_cache");
        SSE_FRONTIER_CACHE = r104;
        ProactiveSummarySource r105 = new ProactiveSummarySource(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 5, "push");
        PUSH = r105;
        ProactiveSummarySource r110 = new ProactiveSummarySource("PUSH_CACHE", 6, "push_cache");
        PUSH_CACHE = r110;
        ProactiveSummarySource[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f291433a = r111;
        f291434b = EnumEntriesKt.enumEntries(r111);
    }

    public static ProactiveSummarySource[] values() {
        return (ProactiveSummarySource[]) f291433a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ProactiveSummarySource valueOf(String r100) {
        return (ProactiveSummarySource) r27.a.a(ProactiveSummarySource.class, r100);
    }

    public ProactiveSummarySource(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
