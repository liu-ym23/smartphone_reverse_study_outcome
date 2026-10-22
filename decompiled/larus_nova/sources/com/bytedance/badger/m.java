package com.bytedance.badger;

import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class m extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int[] f199039a;

    public m(int[] r100) {
        this.f199039a = r100;
        super(1);
    }

    public final void a(com.bytedance.badger.t.c r100) {
        r100.d(ArraysKt.toList(this.f199039a));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        a((com.bytedance.badger.t.c) r100);
        return Unit.INSTANCE;
    }
}
