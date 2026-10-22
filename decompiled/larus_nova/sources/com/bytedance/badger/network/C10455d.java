package com.bytedance.badger.network;

import com.bytedance.badger.e;
import com.bytedance.badger.monitor.TriggerStage;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import z64.f;

/* JADX INFO: renamed from: com.bytedance.badger.network.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes47.dex */
final class C10455d extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TriggerStage f199091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f199092b;

    public C10455d(TriggerStage r100, f r101) {
        this.f199091a = r100;
        this.f199092b = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r210) {
        Throwable r100 = (Throwable) r210;
        e.c("BadgerNetworkHandler", "sendFollowUpRequest - failed to send follow-up request", r100);
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.f199044c, this.f199091a, r100, 0, null, 0, 0, 0, this.f199092b, null, false, 0, null, null, 7948);
        return Unit.INSTANCE;
    }
}
