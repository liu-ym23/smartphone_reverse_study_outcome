package com.bytedance.badger;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class f extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f199031a;

    public f(int r100) {
        this.f199031a = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        ((com.bytedance.badger.t.c) r100).b(this.f199031a);
        return Unit.INSTANCE;
    }
}
