package com.obric.assistant.state.multitask.core;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import jha.g;
import jha.q;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0080\u0001\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H¦@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/state/multitask/core/TaskFlowCriticalResolver;", "", JSEventListener.ACTION_RESOLVE, "", "id", "Lcom/obric/assistant/state/multitask/core/TaskFlowId;", "taskStateEvent", "Lcom/obric/assistant/state/multitask/core/TaskStateEvent;", "(Lcom/obric/assistant/state/multitask/core/TaskFlowId;Lcom/obric/assistant/state/multitask/core/TaskStateEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "multitask_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface TaskFlowCriticalResolver {
    Unit a(g r100, q r101);
}
