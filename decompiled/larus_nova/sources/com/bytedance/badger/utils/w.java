package com.bytedance.badger.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class w extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e0 f199297a;

    public w(e0 r100) {
        this.f199297a = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        e0 r100 = this.f199297a;
        f0 r101 = r100.f199238a;
        r101.f199254k.a(r101.f199246c, r100.f199239b);
        return Unit.INSTANCE;
    }
}
