package com.larus.reach.impl;

import com.larus.reach.api.ReachRequestSource;
import com.larus.reach.api.ReachType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {
    public static final boolean a(ns9.t r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getType() != ReachType.BANNER) goto L13;
        ReachRequestSource r101 = r100.f520408a.f520398f;
        if (r101 != ReachRequestSource.SERVER_CMD) goto L7;
    L12:
        return true;
    L7:
        if (r101 == ReachRequestSource.INAPP_PUSH_PULL) goto L12;
        if (r101 == ReachRequestSource.CLIENT_BRIDGE) goto L12;
        if (r101 == ReachRequestSource.LOCAL_SUBMIT) goto L12;
    L13:
        return false;
    }
}
