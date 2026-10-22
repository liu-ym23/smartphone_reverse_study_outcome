package com.bytedance.kmp.ec.yata.store.frontier;

import com.bytedance.kmp.ec.yata.common.platform.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<c>> f251769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f251770b;

    public b() {
        this.f251769a = new LinkedHashMap();
        this.f251770b = new m();
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "yataSession");
        ReentrantLock r101 = this.f251770b.f251546a;
        r101.lock();
        List<c> r102 = this.f251769a.remove(r100);     // Catch: Throwable -> L6
        r101.unlock();
        return;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }
}
