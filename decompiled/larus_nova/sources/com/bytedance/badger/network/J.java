package com.bytedance.badger.network;

import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class J extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f199053a;

    public J(b r100) {
        this.f199053a = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        BadgerCore.Companion.getClass();
        BadgerCore r100 = j.a();
        b r101 = this.f199053a;
        int r102 = r100.updateFeatures(r101.f199074b, 30000, r101.f199081i);
        z0 r103 = d0.f199093a;
        d0.d(this.f199053a, r102, new H(this), new I(this), 16);
        return Unit.INSTANCE;
    }
}
