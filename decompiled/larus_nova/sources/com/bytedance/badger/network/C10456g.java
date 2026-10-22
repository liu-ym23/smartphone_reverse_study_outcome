package com.bytedance.badger.network;

import com.bytedance.badger.data.BadgerUpdateInfo;
import com.bytedance.badger.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.bytedance.badger.network.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes47.dex */
final class C10456g extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f199101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ n0 f199102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function6 f199103c;

    public C10456g(int r100, n0 r101, Function6 r102) {
        this.f199101a = r100;
        this.f199102b = r101;
        this.f199103c = r102;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        BadgerUpdateInfo r101 = (BadgerUpdateInfo) r100;
        e.f("BadgerNetworkHandler", "collectFullReport - scene complete, status: " + this.f199101a);
        o0.f199132a.c(this.f199102b, this.f199103c);
        com.bytedance.badger.monitor.c.f199044c.getClass();
        com.bytedance.badger.monitor.c.e();
        return Unit.INSTANCE;
    }
}
