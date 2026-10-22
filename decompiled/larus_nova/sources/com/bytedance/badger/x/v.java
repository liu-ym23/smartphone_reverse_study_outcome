package com.bytedance.badger.x;

import android.content.Context;
import com.bytedance.badger.network.y0;
import com.bytedance.badger.network.z0;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
final class v extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f0 f199411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ q f199412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f199413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f199414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ List f199415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f199416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ List f199417g;

    public v(f0 r100, q r101, Context r102, Function1 r103, List r104, int r105, List r106) {
        this.f199411a = r100;
        this.f199412b = r101;
        this.f199413c = r102;
        this.f199414d = r103;
        this.f199415e = r104;
        this.f199416f = r105;
        this.f199417g = r106;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        a(((Number) r100).intValue(), ((Number) r101).longValue());
        return Unit.INSTANCE;
    }

    public final void a(int r100, long r101) {
        d0 r102 = new d0(this, r100);
        z0 r103 = this.f199411a.f199386d;     // Catch: RejectedExecutionException -> L8
        if (r101 > 0) goto L6;
        r103.a(r102);     // Catch: RejectedExecutionException -> L8
    L11:
        return;
    L6:
        Lazy r104 = r103.f199166b;     // Catch: RejectedExecutionException -> L8
        KProperty r105 = z0.f199163f[1];     // Catch: RejectedExecutionException -> L8
        ((ScheduledExecutorService) r104.getValue()).schedule(new y0(r103, r102), r101, TimeUnit.MILLISECONDS);     // Catch: RejectedExecutionException -> L8
    L8:
        e = move-exception;
        List r106 = CollectionsKt.toMutableList(this.f199415e);
        r106.add(e);
        this.f199414d.invoke(new a0(r100, r106, 2));
    }
}
