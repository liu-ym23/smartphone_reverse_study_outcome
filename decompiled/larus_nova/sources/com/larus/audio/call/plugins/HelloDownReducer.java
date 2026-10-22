package com.larus.audio.call.plugins;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.larus.audio.call.mgr.AVKitCoreStates$DownWaiting;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.DownStateReducer;
import com.larus.audio.call.mgr.StateTriggerEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/audio/call/plugins/HelloDownReducer;", "Lcom/larus/audio/call/mgr/DownStateReducer;", "<init>", "()V", "reduceDown", "Lcom/larus/audio/call/mgr/Transition;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "state", "event", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", AiBotPollingAuthResult.STATUS_PENDING, "Lcom/larus/audio/call/mgr/PendingSlot;", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HelloDownReducer implements DownStateReducer {
    public HelloDownReducer() {
    }

    @Override // com.larus.audio.call.mgr.DownStateReducer
    public final com.larus.audio.call.mgr.h b(AVKitDuplexState.DownState r100, StateTriggerEvent r101, com.larus.audio.call.mgr.b.C3963b r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, AiBotPollingAuthResult.STATUS_PENDING);
        if (Intrinsics.areEqual(r101, TriggerHello.f289430a) == true) goto L5;
    L7:
        return null;
    L5:
        if ((r100 instanceof AVKitCoreStates$DownWaiting) == false) goto L7;
        return com.larus.audio.call.mgr.e.a(new WaitingHello(r101));
    }
}
