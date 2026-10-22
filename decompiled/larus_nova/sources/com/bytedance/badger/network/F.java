package com.bytedance.badger.network;

import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class F extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f199049a;

    public F(b r100) {
        this.f199049a = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        BadgerCore.Companion.getClass();
        int r100 = BadgerCore.updateFeatures$default(j.a(), this.f199049a.f199074b, 30000, false, 4, null);
        z0 r101 = d0.f199093a;
        d0.d(this.f199049a, r100, new D(this), new E(this), 16);
        return Unit.INSTANCE;
    }
}
