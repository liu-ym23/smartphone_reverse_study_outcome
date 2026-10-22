package com.bytedance.badger;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class i extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f199034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ z64.c f199035b;

    public i(String r100, z64.c r101) {
        this.f199034a = r100;
        this.f199035b = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        com.bytedance.badger.t.c r101 = (com.bytedance.badger.t.c) r100;
        r101.c(this.f199034a);
        r101.b(this.f199035b.getSceneId());
        return Unit.INSTANCE;
    }
}
