package com.bytedance.badger.network;

import com.bytedance.badger.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.bytedance.badger.network.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes47.dex */
final class C10458k extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a0 f199113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f199114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f199115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function6 f199116d;

    public C10458k(a0 r100, int r101, int r102, Function6 r103) {
        this.f199113a = r100;
        this.f199114b = r101;
        this.f199115c = r102;
        this.f199116d = r103;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        e.f("BadgerNetworkRetryHandler", "network is available and callback, execute...");
        u0 r100 = u0.f199154h;
        a0 r101 = this.f199113a;
        int r102 = this.f199114b;
        int r103 = this.f199115c;
        Function6 r104 = this.f199116d;
        com.bytedance.badger.C.a r105 = com.bytedance.badger.C.a.f199020d;
        r100.getClass();
        u0.b(r101, r102, r103, r104, r105);
        return Unit.INSTANCE;
    }
}
