package com.larus.voicecall.impl;

import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StateTriggerEvent.Error f378209a;

    public d() {
    }

    public final StateTriggerEvent.Error a(AVKitDuplexState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        StateTriggerEvent.Error r101 = f0.a(r100);
        if (r101 != null) goto L7;
        this.f378209a = null;
        return null;
    L7:
        if (r101 != this.f378209a) goto L9;
        return null;
    L9:
        this.f378209a = r101;
        return r101;
    }
}
