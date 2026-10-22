package com.bytedance.lark.rustclient.api;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f253918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f253919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<Integer> f253920c;

    public o(Set r100, PThreadPoolExecutor r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "commandValues");
        Intrinsics.checkNotNullParameter(r101, "executor");
        Intrinsics.checkNotNullParameter(r102, "enabledProvider");
        this.f253918a = r101;
        this.f253919b = r102;
        Set<Integer> r103 = CollectionsKt.toSet(r100);
        this.f253920c = r103;
        if ((!r103.isEmpty()) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("commandValues must not be empty".toString());
    }
}
