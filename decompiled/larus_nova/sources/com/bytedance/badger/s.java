package com.bytedance.badger;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class s extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ z64.c f199174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f199175b;

    public s(z64.c r100, int r101) {
        this.f199174a = r100;
        this.f199175b = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        com.bytedance.badger.t.c r101 = (com.bytedance.badger.t.c) r100;
        r101.b(this.f199174a.getSceneId());
        r101.b(this.f199175b);
        return Unit.INSTANCE;
    }
}
