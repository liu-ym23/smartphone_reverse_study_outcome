package com.bytedance.badger.network;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
final class x extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ z0 f199157a;

    public x(z0 r100) {
        this.f199157a = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        z0 r100 = this.f199157a;
        int r101 = r100.f199168d;
        int r102 = r100.f199169e;
        LinkedBlockingQueue r103 = new LinkedBlockingQueue(128);
        return new PThreadPoolExecutor(r101, r102, 60, TimeUnit.SECONDS, r103, new w0(r100.f199167c), new x0());
    }
}
