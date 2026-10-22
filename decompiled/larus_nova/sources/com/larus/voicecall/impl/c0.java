package com.larus.voicecall.impl;

import com.huawei.hms.api.FailedBinderCallBack;
import com.larus.audio.call.mgr.StateTriggerEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f377186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateTriggerEvent.Error f377187b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f377186a, r101.f377186a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f377187b, r101.f377187b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f377186a.hashCode() * 31) + this.f377187b.hashCode();
    }

    public final String toString() {
        return "RealtimeRetryRequest(callId=" + this.f377186a + ", errorEvent=" + this.f377187b + ')';
    }

    public c0(String r100, StateTriggerEvent.Error r101) {
        Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(r101, "errorEvent");
        this.f377186a = r100;
        this.f377187b = r101;
    }
}
