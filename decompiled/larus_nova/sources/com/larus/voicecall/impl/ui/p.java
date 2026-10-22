package com.larus.voicecall.impl.ui;

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
import com.larus.audio.call.mgr.CallDuplexStates$DeepThinking;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import com.larus.audio.call.plugins.WaitingHello;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class p {
    public static final MajorState a(AVKitDuplexState r100) {
        AVKitDuplexState.UpState r101 = r100.getUpState();
        AVKitDuplexState.DownState r102 = r100.getDownState();
        if ((r101 instanceof AVKitCoreStates$Invalid) == false) goto L6;
        return MajorState.c.f289181c;
    L6:
        if ((r101 instanceof AVKitCoreStates$Error) == false) goto L9;
        return b((AVKitCoreStates$Error) r101);
    L9:
        if ((r102 instanceof AVKitCoreStates$Error) == false) goto L12;
        return b((AVKitCoreStates$Error) r102);
    L12:
        if ((r101 instanceof AVKitCoreStates$Connecting) == true) goto L68;
        if ((r102 instanceof AVKitCoreStates$Connecting) == true) goto L68;
        if ((r101 instanceof AVKitCoreStates$Paused) == true) goto L81;
        if ((r102 instanceof AVKitCoreStates$Paused) == true) goto L81;
        if ((r102 instanceof AVKitCoreStates$Speaking) == false) goto L25;
        return MajorState.h.f289190c;
    L25:
        if ((r102 instanceof CallDuplexStates$DeepThinking) == false) goto L28;
        return new MajorState.i.a();
    L28:
        if ((r102 instanceof WaitingHello) == false) goto L31;
        return MajorState.j.f289191c;
    L31:
        if ((r102 instanceof AVKitCoreStates$Thinking) == false) goto L34;
        return new MajorState.i();
    L34:
        if ((r101 instanceof AVKitCoreStates$Recognizing) == false) goto L42;
        MajorState.From r103 = MajorState.From.ASR;
        if (Intrinsics.areEqual(r102.getTriggerBy(), StateTriggerEvent.QueryBegin.f289206a) == false) goto L38;
        MajorState.InterruptType r104 = MajorState.InterruptType.AUTO;
    L39:
        MajorState.d r105 = new MajorState.d(r103, r104);
    L76:
        return r105;
    L38:
        r104 = MajorState.InterruptType.NOTHING;
        goto L39
    L42:
        if ((r101 instanceof AVKitCoreStates$Listening) == false) goto L80;
        if ((r102 instanceof AVKitCoreStates$DownWaiting) == false) goto L80;
        StateTriggerEvent r106 = r102.getTriggerBy();
        if (Intrinsics.areEqual(r106, StateTriggerEvent.PlayEnd.f289205a) == false) goto L48;
    L57:
        MajorState.From r107 = MajorState.From.PLAY_COMPLETE;
        StateTriggerEvent r108 = r102.getTriggerBy();
        if (Intrinsics.areEqual(r108, StateTriggerEvent.Interrupt.f289203a) == false) goto L61;
        MajorState.InterruptType r109 = MajorState.InterruptType.USER;
    L64:
        r105 = new MajorState.d(r107, r109);
        goto L76
    L61:
        if (Intrinsics.areEqual(r108, StateTriggerEvent.QueryBegin.f289206a) == false) goto L63;
        r109 = MajorState.InterruptType.AUTO;
        goto L64
    L63:
        r109 = MajorState.InterruptType.NOTHING;
        goto L64
    L48:
        if (Intrinsics.areEqual(r106, StateTriggerEvent.Interrupt.f289203a) == true) goto L57;
        if (Intrinsics.areEqual(r106, StateTriggerEvent.TtsStreamEnd.f289216a) == false) goto L54;
        return new MajorState.d(MajorState.From.TTS_ENDED, MajorState.InterruptType.NOTHING);
    L54:
        if (Intrinsics.areEqual(r106, StateTriggerEvent.Resume.f289213a) == false) goto L79;
        return new MajorState.d(MajorState.From.RESUME, MajorState.InterruptType.NOTHING);
    L79:
        return MajorState.j.f289191c;
    L80:
        return MajorState.c.f289181c;
    L81:
        return new MajorState.g(MajorState.c.f289181c);
    L68:
        return MajorState.a.f289179c;
    }

    public static final MajorState.f b(AVKitCoreStates$Error r100) {
        Object r101 = r100.f289162c.get("vui_error_code");
        Integer r102 = null;
        if ((r101 instanceof Integer) == false) goto L5;
        Integer r103 = (Integer) r101;
    L6:
        if (r103 == null) goto L8;
        int r104 = r103.intValue();
    L9:
        Object r105 = r100.f289162c.get("sub_error_code");
        if ((r105 instanceof Integer) == false) goto L13;
        r102 = (Integer) r105;
    L13:
        return new MajorState.f(r100.f289160a, r104, r100.f289161b, r102);
    L8:
        r104 = -1;
        goto L9
    L5:
        r103 = null;
        goto L6
    }
}
