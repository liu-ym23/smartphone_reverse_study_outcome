package org.koin.core;

import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nwc.c;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes42.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f526126b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.koin.core.a f526127a;

    public static final class a {
        @JvmStatic
        public static b a() {
            b r100 = new b();
            c r101 = r100.f526127a.f526122a;
            if (r101.f521032d != null) goto L11;
            mwc.c r102 = org.koin.core.scope.c.f526154d;
            org.koin.core.scope.c r103 = new org.koin.core.scope.c(r102, true);
            r101.f521030b.put(r102.f516126a, r103);
            r101.f521032d = r103;
            c r104 = r100.f526127a.f526122a;
            if (r104.f521033e != null) goto L9;
            r104.f521033e = r104.a("-Root-", r102, null);
            return r100;
        L9:
            throw new IllegalStateException("Try to recreate Root scope".toString());
        L11:
            throw new IllegalStateException("Try to recreate Root scope definition".toString());
        }
    }

    static {
    }

    public final void a() {
        if (this.f526127a.f526124c.c(Level.DEBUG) == false) goto L5;
        Function0<Unit> r100 = new KoinApplication$createEagerInstances$duration$1(this);
        Intrinsics.checkNotNullParameter(r100, "code");
        long r101 = System.currentTimeMillis();
        r100.invoke();
        double r102 = System.currentTimeMillis() - r101;
        this.f526127a.f526124c.a("instances started in " + r102 + " ms");
        return;
    L5:
        this.f526127a.a();
    }

    public b() {
        this.f526127a = new org.koin.core.a();
    }
}
