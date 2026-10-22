package com.larus.bmhome.chat.component.list.pipeline;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import td8.c;
import td8.d;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskProvider;", "", "stage", "Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskStageEnum;", "type", "Lcom/larus/bmhome/chat/component/list/pipeline/PipelineTaskType;", "order", "", "providerPipelineTask", "Lcom/larus/bmhome/chat/component/list/pipeline/ITask;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/bmhome/chat/component/list/pipeline/ITaskContext;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface PipelineTaskProvider {
    c a(d r100);

    int order();

    PipelineTaskStageEnum stage();

    PipelineTaskType type();
}
