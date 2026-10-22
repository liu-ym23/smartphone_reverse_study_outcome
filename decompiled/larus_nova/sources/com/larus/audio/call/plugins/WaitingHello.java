package com.larus.audio.call.plugins;

import com.larus.audio.call.mgr.AVKitCoreStates$Thinking;
import com.larus.audio.call.mgr.StateTriggerEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/call/plugins/WaitingHello;", "Lcom/larus/audio/call/mgr/AVKitCoreStates$Thinking;", "triggerBy", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "(Lcom/larus/audio/call/mgr/StateTriggerEvent;)V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class WaitingHello extends AVKitCoreStates$Thinking {
    public WaitingHello(StateTriggerEvent r100) {
        super(r100);
    }
}
