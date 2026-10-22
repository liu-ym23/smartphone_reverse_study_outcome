package com.ss.android.lark.conditional.access.auth.v2;

import android.util.LruCache;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f417840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<LruCache<String, d>, Unit> f417841b;

    /* JADX WARN: Multi-variable type inference failed */
    public p(int r100, Function1<? super LruCache<String, d>, Unit> r101) {
        this.f417840a = r100;
        this.f417841b = r101;
    }

    public final void a() {
        LruCache r100 = new LruCache(this.f417840a);
        int r101 = (y.f417935d + y.f417936e) - this.f417840a;
        int r102 = 0;
    L4:
        if (r102 >= this.f417840a) goto L12;
        r101 = (r101 + 1) % y.f417936e;
        Pair r103 = y.a(r101);
        if (r103 == null) goto L8;
        d r104 = (d) r103.getSecond();
    L9:
        if (r104 == null) goto L11;
        r100.put(r103.getFirst(), r103.getSecond());
    L11:
        r102 = r102 + 1;
        goto L4
    L8:
        r104 = null;
        goto L9
    L12:
        this.f417841b.invoke((LruCache<String, d>) r100);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
