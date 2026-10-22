package com.larus.bmhome.chat.markdown.vlm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/markdown/vlm/FlowVLMContainerViewType;", "", "<init>", "(Ljava/lang/String;I)V", "NoContent", "SingleItem", "MultipleItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowVLMContainerViewType extends Enum<FlowVLMContainerViewType> {
    public static final FlowVLMContainerViewType MultipleItem = null;
    public static final FlowVLMContainerViewType NoContent = null;
    public static final FlowVLMContainerViewType SingleItem = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowVLMContainerViewType[] f307318a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f307319b = null;

    public static EnumEntries<FlowVLMContainerViewType> getEntries() {
        return f307319b;
    }

    static {
        FlowVLMContainerViewType r100 = new FlowVLMContainerViewType("NoContent", 0);
        NoContent = r100;
        FlowVLMContainerViewType r101 = new FlowVLMContainerViewType("SingleItem", 1);
        SingleItem = r101;
        FlowVLMContainerViewType r102 = new FlowVLMContainerViewType("MultipleItem", 2);
        MultipleItem = r102;
        FlowVLMContainerViewType[] r103 = {r100, r101, r102};
        f307318a = r103;
        f307319b = EnumEntriesKt.enumEntries(r103);
    }

    public static FlowVLMContainerViewType[] values() {
        return (FlowVLMContainerViewType[]) f307318a.clone();
    }

    public static FlowVLMContainerViewType valueOf(String r100) {
        return (FlowVLMContainerViewType) a.a(FlowVLMContainerViewType.class, r100);
    }

    public FlowVLMContainerViewType(String r100, int r101) {
        super(r100, r101);
    }
}
