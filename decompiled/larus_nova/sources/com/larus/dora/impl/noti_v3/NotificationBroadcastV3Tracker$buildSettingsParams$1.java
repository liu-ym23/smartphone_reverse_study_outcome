package com.larus.dora.impl.noti_v3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.noti_v3.NotificationBroadcastV3Tracker", f = "NotificationBroadcastV3Tracker.kt", i = {0, 1, 2, 2, 2, 2, 2}, l = {97, 98, 105}, m = "buildSettingsParams", n = {"device", "userSettings", "userSettings", "deviceInfo", "v3Settings", "serviceConfigMap", "notificationAppList"}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "L$3", "L$4"})
final class NotificationBroadcastV3Tracker$buildSettingsParams$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationBroadcastV3Tracker this$0;

    public NotificationBroadcastV3Tracker$buildSettingsParams$1(NotificationBroadcastV3Tracker r100, Continuation<? super NotificationBroadcastV3Tracker$buildSettingsParams$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return NotificationBroadcastV3Tracker.a(this.this$0, null, this);
    }
}
