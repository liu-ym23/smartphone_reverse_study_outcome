package com.google.android.gms.common.util.concurrent;

import bv7.a;
import com.google.android.gms.common.internal.Preconditions;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes23.dex */
public class NamedThreadFactory implements ThreadFactory {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private final String f274609zza;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private final ThreadFactory f274610zzb;

    public NamedThreadFactory(String r100) {
        this.f274610zzb = Executors.defaultThreadFactory();
        Preconditions.checkNotNull(r100, "Name must not be null");
        this.f274609zza = r100;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        a r101 = new a(r100);
        Thread r102 = this.f274610zzb.newThread(r101);
        ThreadMethodProxy.setName(r102, this.f274609zza);
        return r102;
    }
}
