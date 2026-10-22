package com.bytedance.badger.network;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
final class y extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ z0 f199158a;

    public y(z0 r100) {
        this.f199158a = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return new PThreadScheduledThreadPoolExecutor(1, new v0(this.f199158a.f199167c));
    }
}
