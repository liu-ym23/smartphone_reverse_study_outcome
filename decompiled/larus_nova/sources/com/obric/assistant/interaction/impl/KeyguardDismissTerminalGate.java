package com.obric.assistant.interaction.impl;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/KeyguardDismissTerminalGate;", "", "<init>", "()V", "isCompleted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "tryComplete", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyguardDismissTerminalGate {
    private final AtomicBoolean isCompleted;

    public final boolean tryComplete() {
        return this.isCompleted.compareAndSet(false, true);
    }

    public KeyguardDismissTerminalGate() {
        this.isCompleted = new AtomicBoolean(false);
    }
}
