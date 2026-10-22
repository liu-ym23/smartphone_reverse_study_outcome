package com.bytedance.applog.priority.original;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements CoroutineScope {
    public final InsertCacheConfig a;
    public final Function0<SQLiteDatabase> b;
    public final Function2<j, String, j> c;
    public Job d;
    public final ReentrantLock e;
    public final List<Pair<j, String>> f;
    public final b g;
    public final boolean h;

    public static final class a {
    }

    public static final class b {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final CoroutineContext getCoroutineContext() {
        return Dispatchers.getIO();
    }

    public final void a(int r4) {
        if (this.h == false) goto L32;
        Set<Integer> r0 = this.a.getNotFlushType();
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == true) goto L33;
        this.e.lock();     // Catch: Throwable -> L26
        if (((ArrayList) this.f).isEmpty() == false) goto L29;
        this.e.unlock();
        return;
    L29:
        ((SQLiteDatabase) this.b.invoke()).beginTransaction();     // Catch: Throwable -> L22
        Iterator<T> r5 = this.f.iterator();     // Catch: Throwable -> L22
    L17:
        if (r5.hasNext() == false) goto L19;
        Pair r2 = (Pair) r5.next();     // Catch: Throwable -> L22
        j r3 = (j) r2.component1();     // Catch: Throwable -> L22
        String r6 = (String) r2.component2();     // Catch: Throwable -> L22
        this.c.invoke(r3, r6);     // Catch: Throwable -> L22
        goto L17
    L19:
        ((ArrayList) this.f).clear();     // Catch: Throwable -> L22
        ((SQLiteDatabase) this.b.invoke()).setTransactionSuccessful();     // Catch: Throwable -> L22
        Object r7 = this.b.invoke();     // Catch: Throwable -> L26
    L21:
        ((SQLiteDatabase) r7).endTransaction();     // Catch: Throwable -> L26
        goto L24
    L22:
        r7 = this.b.invoke();     // Catch: Throwable -> L26
    L24:
        this.e.unlock();
        return;
    L33:
        return;
    L7:
        if (r0.contains(Integer.valueOf(r4)) != true) goto L9;
        r1 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(InsertCacheConfig r2, Function0<SQLiteDatabase> r3, Function2<? super j, ? super String, j> r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "db");
        Intrinsics.checkNotNullParameter(r4, "insertDirect");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = new ReentrantLock();
        this.f = new ArrayList();
        this.g = new b(this);
        if (r2.getCacheEnable() == true) goto L5;
    L7:
        boolean r5 = false;
    L8:
        this.h = r5;
        return;
    L5:
        if (r2.getMaxCacheSize() <= 0) goto L7;
        r5 = true;
        goto L8
    }
}
