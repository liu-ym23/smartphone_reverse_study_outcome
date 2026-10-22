package com.obric.assistant.interaction.impl.event.processor.base;

import com.obric.assistant.interaction.base.model.InteractionEvent;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/event/processor/base/IEventProcessor;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "process", "", "event", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IEventProcessor {
    void process(InteractionEvent r100);

    CoroutineScope scope();
}
