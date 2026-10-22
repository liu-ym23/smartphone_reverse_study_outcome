package com.bytedance.badger.v;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
final class o extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f199348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TimeUnit f199349b;

    public o(long r100, TimeUnit r101) {
        this.f199348a = r100;
        this.f199349b = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return new w(this.f199348a, this.f199349b);
    }
}
