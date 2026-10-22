package com.larus.audio.call.mgr;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/larus/audio/call/mgr/AVKitCoreStates$Paused;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState$Active;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState$Active;", "triggerBy", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "resumeDownState", "<init>", "(Lcom/larus/audio/call/mgr/StateTriggerEvent;Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;)V", "getTriggerBy", "()Lcom/larus/audio/call/mgr/StateTriggerEvent;", "getResumeDownState", "()Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "toSimpleString", "", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AVKitCoreStates$Paused implements AVKitDuplexState.UpState, AVKitDuplexState.DownState, AVKitDuplexState.UpState.Active, AVKitDuplexState.DownState.Active {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateTriggerEvent f289166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AVKitDuplexState.DownState f289167b;

    @Override // com.larus.audio.call.mgr.AVKitDuplexState.UpState, com.larus.audio.call.mgr.AVKitDuplexState.DownState
    public final String toSimpleString() {
        return "Paused";
    }

    @Override // com.larus.audio.call.mgr.AVKitDuplexState.UpState, com.larus.audio.call.mgr.AVKitDuplexState.DownState
    public final StateTriggerEvent getTriggerBy() {
        return this.f289166a;
    }

    public AVKitCoreStates$Paused(StateTriggerEvent r100, AVKitDuplexState.DownState r101) {
        this.f289166a = r100;
        this.f289167b = r101;
    }
}
