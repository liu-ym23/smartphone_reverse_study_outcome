package com.ss.android.lark.storage.kv.storage;

import android.content.Context;
import com.ss.android.lark.storage.kv.repo.KVRepoConfig;
import com.ss.android.lark.storage.kv.repo.c;
import com.ss.android.lark.storage.kv.repo.g;
import com.ss.android.lark.storage.kv.statistics.MonitorProxyFactory;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f441090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f441091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KVRepoConfig f441092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m6c.a f441093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f441094e;

    public a(Context r100, String r101, KVRepoConfig r102) {
        com.ss.android.lark.storage.kv.statistics.a r103 = com.ss.android.lark.storage.kv.statistics.a.f441083a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spaceName");
        Intrinsics.checkNotNullParameter(r102, "defaultRepoConfig");
        Intrinsics.checkNotNullParameter(r103, "monitor");
        this.f441090a = r100;
        this.f441091b = r101;
        this.f441092c = r102;
        this.f441093d = r103;
        this.f441094e = LazyKt.lazy(KVStorage$scope$2.INSTANCE);
    }

    public final com.ss.android.lark.storage.kv.repo.a a(com.ss.android.lark.storage.a r100, String r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r111, "configBuilder");
        KVRepoConfig r101 = this.f441092c;
        KVRepoConfig r102 = new KVRepoConfig(r101.f441065a, new ArrayList(r101.f441066b), r101.f441067c);
        r111.invoke(r102);
        com.ss.android.lark.storage.kv.repo.a r112 = new com.ss.android.lark.storage.kv.repo.a(r102.f441067c.b(this.f441090a, this.f441091b, r100, r110, r102.f441065a));
        Iterator<T> r113 = r102.f441066b.iterator();
    L4:
        if (r113.hasNext() == false) goto L6;
        g r103 = (g) r113.next();
        r103.b(r100);
        Intrinsics.checkNotNullParameter(r103, "proxyProvider");
        c r104 = r103.a(r112.f441076c);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r112.f441076c = r104;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r112.f441079b = r104;
        goto L4
    L6:
        MonitorProxyFactory r114 = new MonitorProxyFactory(this.f441093d);
        Intrinsics.checkNotNullParameter(r114, "proxyProvider");
        c r105 = r114.a(r112.f441076c);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r112.f441076c = r105;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r112.f441079b = r105;
        com.ss.android.lark.storage.kv.statistics.a r106 = com.ss.android.lark.storage.kv.statistics.a.f441083a;
        Intrinsics.checkNotNullParameter(r112, "kvRepo");
        return r112;
    }

    public static /* synthetic */ com.ss.android.lark.storage.kv.repo.a b(a r100, com.ss.android.lark.storage.a r101, String r102, Function1 r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = KVStorage$getRepo$1.INSTANCE;
    L9:
        return r100.a(r101, r102, r103);
    }
}
