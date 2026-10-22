package com.larus.audio.call.mgr;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/call/mgr/AVKitCoreStates$Finished;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "triggerBy", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "(Lcom/larus/audio/call/mgr/StateTriggerEvent;)V", "getTriggerBy", "()Lcom/larus/audio/call/mgr/StateTriggerEvent;", "toSimpleString", "", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AVKitCoreStates$Finished implements AVKitDuplexState.UpState, AVKitDuplexState.DownState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateTriggerEvent f289164a;

    @Override // com.larus.audio.call.mgr.AVKitDuplexState.UpState, com.larus.audio.call.mgr.AVKitDuplexState.DownState
    public final String toSimpleString() {
        return "Finished";
    }

    @Override // com.larus.audio.call.mgr.AVKitDuplexState.UpState, com.larus.audio.call.mgr.AVKitDuplexState.DownState
    public final StateTriggerEvent getTriggerBy() {
        return this.f289164a;
    }

    public AVKitCoreStates$Finished(StateTriggerEvent r100) {
        this.f289164a = r100;
    }
}
