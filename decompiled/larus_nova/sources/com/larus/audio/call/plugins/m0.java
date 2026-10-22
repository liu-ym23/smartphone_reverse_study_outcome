package com.larus.audio.call.plugins;

import com.larus.audio.call.mgr.AVKitCoreStates$Connecting;
import com.larus.audio.call.mgr.AVKitCoreStates$DownWaiting;
import com.larus.audio.call.mgr.AVKitCoreStates$Error;
import com.larus.audio.call.mgr.AVKitCoreStates$Invalid;
import com.larus.audio.call.mgr.AVKitCoreStates$Listening;
import com.larus.audio.call.mgr.AVKitCoreStates$Paused;
import com.larus.audio.call.mgr.AVKitCoreStates$Recognizing;
import com.larus.audio.call.mgr.AVKitCoreStates$Speaking;
import com.larus.audio.call.mgr.AVKitCoreStates$Thinking;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class m0 {
    public static final boolean a(AVKitDuplexState r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100.getUpState() instanceof AVKitCoreStates$Listening) == true) goto L5;
    L9:
        return false;
    L5:
        if ((r100.getDownState() instanceof AVKitCoreStates$DownWaiting) == false) goto L9;
        if (Intrinsics.areEqual(((AVKitCoreStates$DownWaiting) r100.getDownState()).getTriggerBy(), StateTriggerEvent.PlayEnd.f289205a) == false) goto L9;
        return true;
    }

    public static final int b(AVKitDuplexState r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        AVKitDuplexState.UpState r102 = r100.getUpState();
        AVKitDuplexState.DownState r103 = r100.getDownState();
        if ((r102 instanceof AVKitCoreStates$Invalid) == false) goto L6;
        return -1;
    L6:
        if ((r102 instanceof AVKitCoreStates$Error) == false) goto L8;
    L62:
        return 6;
    L8:
        if ((r103 instanceof AVKitCoreStates$Error) == true) goto L62;
        if ((r102 instanceof AVKitCoreStates$Connecting) == false) goto L13;
    L53:
        StateTriggerEvent r104 = r102.getTriggerBy();
        StateTriggerEvent.SceneSwitched r105 = StateTriggerEvent.SceneSwitched.f289214a;
        if (Intrinsics.areEqual(r104, r105) == false) goto L56;
    L59:
        boolean r106 = true;
    L60:
        if (r106 == false) goto L73;
        return 12;
    L73:
        return 1;
    L56:
        if (Intrinsics.areEqual(r103.getTriggerBy(), r105) == true) goto L59;
        r106 = false;
        goto L60
    L13:
        if ((r103 instanceof AVKitCoreStates$Connecting) == true) goto L53;
        if ((r102 instanceof AVKitCoreStates$Paused) == false) goto L18;
    L52:
        return 7;
    L18:
        if ((r103 instanceof AVKitCoreStates$Paused) == true) goto L52;
        boolean r107 = r102 instanceof AVKitCoreStates$Recognizing;
        if (r107 == false) goto L27;
        if ((r103 instanceof AVKitCoreStates$Speaking) == false) goto L27;
        if (r101 == false) goto L27;
        return 17;
    L27:
        if ((r103 instanceof AVKitCoreStates$Speaking) == false) goto L30;
        return 5;
    L30:
        if ((r103 instanceof WaitingHello) == false) goto L33;
        return 9;
    L33:
        if ((r103 instanceof AVKitCoreStates$Thinking) == false) goto L36;
        return 4;
    L36:
        if (r107 == false) goto L39;
    L37:
        return 3;
    L39:
        if ((r102 instanceof AVKitCoreStates$Listening) == true) goto L41;
        return -1;
    L41:
        if ((r103 instanceof AVKitCoreStates$DownWaiting) == false) goto L70;
        StateTriggerEvent r108 = r103.getTriggerBy();
        if (Intrinsics.areEqual(r108, StateTriggerEvent.PlayEnd.f289205a) == true) goto L37;
        if (Intrinsics.areEqual(r108, StateTriggerEvent.Interrupt.f289203a) == true) goto L37;
        if (Intrinsics.areEqual(r108, StateTriggerEvent.TtsStreamEnd.f289216a) == true) goto L37;
        if (Intrinsics.areEqual(r108, StateTriggerEvent.Resume.f289213a) == true) goto L37;
        return 2;
    L70:
        return -1;
    }
}
