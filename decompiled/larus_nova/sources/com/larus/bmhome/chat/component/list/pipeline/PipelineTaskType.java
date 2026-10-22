package com.larus.bmhome.chat.component.list.pipeline;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskType;", "", "<init>", "(Ljava/lang/String;I)V", "FOR_EACH", "PICK_FIRST", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PipelineTaskType extends Enum<PipelineTaskType> {
    public static final PipelineTaskType FOR_EACH = null;
    public static final PipelineTaskType PICK_FIRST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PipelineTaskType[] f301194a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f301195b = null;

    public static EnumEntries<PipelineTaskType> getEntries() {
        return f301195b;
    }

    static {
        PipelineTaskType r100 = new PipelineTaskType("FOR_EACH", 0);
        FOR_EACH = r100;
        PipelineTaskType r101 = new PipelineTaskType("PICK_FIRST", 1);
        PICK_FIRST = r101;
        PipelineTaskType[] r102 = {r100, r101};
        f301194a = r102;
        f301195b = EnumEntriesKt.enumEntries(r102);
    }

    public static PipelineTaskType[] values() {
        return (PipelineTaskType[]) f301194a.clone();
    }

    public static PipelineTaskType valueOf(String r100) {
        return (PipelineTaskType) a.a(PipelineTaskType.class, r100);
    }

    public PipelineTaskType(String r100, int r101) {
        super(r100, r101);
    }
}
