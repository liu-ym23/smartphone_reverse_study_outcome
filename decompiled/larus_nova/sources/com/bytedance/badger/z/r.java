package com.bytedance.badger.z;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class r extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f199490a;

    public r(int r100) {
        this.f199490a = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        ((com.bytedance.badger.t.c) r100).b(this.f199490a);
        return Unit.INSTANCE;
    }
}
