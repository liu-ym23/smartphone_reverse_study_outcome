package com.larus.dora.impl.noti_v3.overview.ui;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class v<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NotificationBroadcastV3Fragment f336443a;

    public v(NotificationBroadcastV3Fragment r100) {
        this.f336443a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        if (((Boolean) r100).booleanValue() == false) goto L6;
        NotificationBroadcastV3Fragment r102 = this.f336443a;
        int r103 = NotificationBroadcastV3Fragment.f336411l;
        r102.X90();
    L6:
        return Unit.INSTANCE;
    }
}
