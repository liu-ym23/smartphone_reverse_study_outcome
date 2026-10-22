package com.bytedance.badger.utils;

import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class t extends Lambda implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f199286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AtomicBoolean f199287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f199288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ r f199289d;

    public t(AtomicReference r100, AtomicBoolean r101, CountDownLatch r102, r r103) {
        this.f199286a = r100;
        this.f199287b = r101;
        this.f199288c = r102;
        this.f199289d = r103;
        super(3);
    }

    public final void a(ServiceConnection r100, ServiceConnection r101, Throwable r102) {
        this.f199286a.set(r102);
        f.c(f.f199243d, this.f199287b, this.f199288c, new s(this, r100, r101));
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101, Object r102) {
        a((ServiceConnection) r100, (ServiceConnection) r101, (Throwable) r102);
        return Unit.INSTANCE;
    }
}
