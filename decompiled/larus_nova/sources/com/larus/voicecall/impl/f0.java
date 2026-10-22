package com.larus.voicecall.impl;

import com.huawei.hms.api.FailedBinderCallBack;
import com.larus.audio.call.mgr.AVKitCoreStates$Error;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class f0 {
    public static final StateTriggerEvent.Error a(AVKitDuplexState r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        AVKitDuplexState.UpState r101 = r100.getUpState();
        if ((r101 instanceof AVKitCoreStates$Error) == false) goto L5;
        AVKitCoreStates$Error r102 = (AVKitCoreStates$Error) r101;
    L6:
        if (r102 == null) goto L8;
        StateTriggerEvent r103 = r102.getTriggerBy();
    L10:
        if ((r103 instanceof StateTriggerEvent.Error) == false) goto L12;
        StateTriggerEvent.Error r104 = (StateTriggerEvent.Error) r103;
    L13:
        if (r104 != null) goto L25;
        AVKitDuplexState.DownState r105 = r100.getDownState();
        if ((r105 instanceof AVKitCoreStates$Error) == false) goto L17;
        AVKitCoreStates$Error r106 = (AVKitCoreStates$Error) r105;
    L18:
        if (r106 == null) goto L20;
        StateTriggerEvent r107 = r106.getTriggerBy();
    L22:
        if ((r107 instanceof StateTriggerEvent.Error) == true) goto L27;
        return null;
    L27:
        return (StateTriggerEvent.Error) r107;
    L20:
        r107 = null;
        goto L22
    L17:
        r106 = null;
        goto L18
    L25:
        return r104;
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public static final boolean b(c0 r100, String r101, AVKitDuplexState r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        if (Intrinsics.areEqual(r100.f377186a, r101) == false) goto L26;
        StateTriggerEvent.Error r103 = r100.f377187b;
        AVKitDuplexState.UpState r104 = r102.getUpState();
        StateTriggerEvent r105 = null;
        if ((r104 instanceof AVKitCoreStates$Error) == false) goto L7;
        AVKitCoreStates$Error r106 = (AVKitCoreStates$Error) r104;
    L8:
        if (r106 == null) goto L10;
        StateTriggerEvent r107 = r106.getTriggerBy();
    L12:
        if (r107 == r103) goto L22;
        AVKitDuplexState.DownState r108 = r102.getDownState();
        if ((r108 instanceof AVKitCoreStates$Error) == false) goto L16;
        AVKitCoreStates$Error r109 = (AVKitCoreStates$Error) r108;
    L17:
        if (r109 == null) goto L19;
        r105 = r109.getTriggerBy();
    L19:
        if (r105 == r103) goto L22;
        boolean r110 = false;
    L23:
        if (r110 == false) goto L27;
        return true;
    L27:
        return false;
    L16:
        r109 = null;
    L22:
        r110 = true;
        goto L23
    L10:
        r107 = null;
        goto L12
    L7:
        r106 = null;
        goto L8
    L26:
        return false;
    }
}
