package com.larus.dora.impl.noti_v3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.noti_v3.NotificationBroadcastV3Tracker", f = "NotificationBroadcastV3Tracker.kt", i = {}, l = {129}, m = "loadFreshUserSettings", n = {}, s = {})
public final class NotificationBroadcastV3Tracker$loadFreshUserSettings$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationBroadcastV3Tracker this$0;

    public NotificationBroadcastV3Tracker$loadFreshUserSettings$1(NotificationBroadcastV3Tracker r100, Continuation<? super NotificationBroadcastV3Tracker$loadFreshUserSettings$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        NotificationBroadcastV3Tracker r101 = this.this$0;
        NotificationBroadcastV3Tracker r102 = NotificationBroadcastV3Tracker.f336406a;
        return r101.c(this);
    }
}
