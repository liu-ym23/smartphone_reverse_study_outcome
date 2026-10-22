package com.larus.bmhome.chat.component.list.pipeline;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskStageEnum;", "", "order", "", "<init>", "(Ljava/lang/String;II)V", "getOrder", "()I", "PRE_DEPENDENT", "UPDATE", "NEED_TRAVERSAL", "DIRECT_ADD", "DELETE", "TRANSFORM_TO_MARK_WIDGET", "FINAL_FILTER", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PipelineTaskStageEnum extends Enum<PipelineTaskStageEnum> {
    public static final PipelineTaskStageEnum DELETE = null;
    public static final PipelineTaskStageEnum DIRECT_ADD = null;
    public static final PipelineTaskStageEnum FINAL_FILTER = null;
    public static final PipelineTaskStageEnum NEED_TRAVERSAL = null;
    public static final PipelineTaskStageEnum PRE_DEPENDENT = null;
    public static final PipelineTaskStageEnum TRANSFORM_TO_MARK_WIDGET = null;
    public static final PipelineTaskStageEnum UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PipelineTaskStageEnum[] f301192a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f301193b = null;
    private final int order;

    public static EnumEntries<PipelineTaskStageEnum> getEntries() {
        return f301193b;
    }

    static {
        PipelineTaskStageEnum r100 = new PipelineTaskStageEnum("PRE_DEPENDENT", 0, 0);
        PRE_DEPENDENT = r100;
        PipelineTaskStageEnum r101 = new PipelineTaskStageEnum("UPDATE", 1, 1);
        UPDATE = r101;
        PipelineTaskStageEnum r102 = new PipelineTaskStageEnum("NEED_TRAVERSAL", 2, 2);
        NEED_TRAVERSAL = r102;
        PipelineTaskStageEnum r103 = new PipelineTaskStageEnum("DIRECT_ADD", 3, 3);
        DIRECT_ADD = r103;
        PipelineTaskStageEnum r104 = new PipelineTaskStageEnum("DELETE", 4, 4);
        DELETE = r104;
        PipelineTaskStageEnum r105 = new PipelineTaskStageEnum("TRANSFORM_TO_MARK_WIDGET", 5, 5);
        TRANSFORM_TO_MARK_WIDGET = r105;
        PipelineTaskStageEnum r110 = new PipelineTaskStageEnum("FINAL_FILTER", 6, 6);
        FINAL_FILTER = r110;
        PipelineTaskStageEnum[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f301192a = r111;
        f301193b = EnumEntriesKt.enumEntries(r111);
    }

    public static PipelineTaskStageEnum[] values() {
        return (PipelineTaskStageEnum[]) f301192a.clone();
    }

    public final int getOrder() {
        return this.order;
    }

    public static PipelineTaskStageEnum valueOf(String r100) {
        return (PipelineTaskStageEnum) a.a(PipelineTaskStageEnum.class, r100);
    }

    public PipelineTaskStageEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.order = r102;
    }
}
