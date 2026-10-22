package com.larus.bmhome.chat.component.list.pipeline;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import td8.a;
import td8.c;
import td8.d;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/component/list/pipeline/AddEduCameraContinuerShootTaskProvider;", "Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskProvider;", "<init>", "()V", "stage", "Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskStageEnum;", "type", "Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskType;", "order", "", "providerPipelineTask", "Lcom/larus/bmhome/chat/component/list/pipeline/ITask;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/bmhome/chat/component/list/pipeline/ITaskContext;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddEduCameraContinuerShootTaskProvider implements PipelineTaskProvider {
    public AddEduCameraContinuerShootTaskProvider() {
    }

    @Override // com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider
    public final int order() {
        return 300;
    }

    @Override // com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider
    public final PipelineTaskStageEnum stage() {
        return PipelineTaskStageEnum.PRE_DEPENDENT;
    }

    @Override // com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider
    public final PipelineTaskType type() {
        return PipelineTaskType.PICK_FIRST;
    }

    @Override // com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider
    public final c a(d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.E8() == false) goto L7;
        return new a(r100);
    L7:
        return new com.larus.bmhome.chat.component.list.pipeline.pre_dependent.a(r100);
    }
}
