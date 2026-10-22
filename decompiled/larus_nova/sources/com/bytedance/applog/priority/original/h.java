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

/* JADX INFO: loaded from: classes14.dex */
public final class h implements CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InsertCacheConfig f192731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<SQLiteDatabase> f192732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<j, String, j> f192733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Job f192734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReentrantLock f192735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Pair<j, String>> f192736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f192737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f192738h;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f192739a;

        public b(h r100) {
            this.f192739a = r100;
        }
    }

    static {
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return Dispatchers.getIO();
    }

    public final void a(int r100) {
        if (this.f192738h == false) goto L32;
        Set<Integer> r101 = this.f192731a.getNotFlushType();
        boolean r102 = false;
        if (r101 != null) goto L7;
    L9:
        if (r102 == true) goto L33;
        this.f192735e.lock();     // Catch: Throwable -> L26
        if (((ArrayList) this.f192736f).isEmpty() == false) goto L29;
        this.f192735e.unlock();
        return;
    L29:
        this.f192732b.invoke().beginTransaction();     // Catch: Throwable -> L22
        Iterator<T> r103 = this.f192736f.iterator();     // Catch: Throwable -> L22
    L17:
        if (r103.hasNext() == false) goto L19;
        Pair r104 = (Pair) r103.next();     // Catch: Throwable -> L22
        j r105 = (j) r104.component1();     // Catch: Throwable -> L22
        String r106 = (String) r104.component2();     // Catch: Throwable -> L22
        this.f192733c.invoke(r105, r106);     // Catch: Throwable -> L22
        goto L17
    L19:
        ((ArrayList) this.f192736f).clear();     // Catch: Throwable -> L22
        this.f192732b.invoke().setTransactionSuccessful();     // Catch: Throwable -> L22
        SQLiteDatabase r107 = this.f192732b.invoke();     // Catch: Throwable -> L26
    L21:
        r107.endTransaction();     // Catch: Throwable -> L26
        goto L24
    L22:
        r107 = this.f192732b.invoke();     // Catch: Throwable -> L26
    L24:
        this.f192735e.unlock();
        return;
    L33:
        return;
    L7:
        if (r101.contains(Integer.valueOf(r100)) != true) goto L9;
        r102 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(InsertCacheConfig r100, Function0<SQLiteDatabase> r101, Function2<? super j, ? super String, j> r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "db");
        Intrinsics.checkNotNullParameter(r102, "insertDirect");
        this.f192731a = r100;
        this.f192732b = r101;
        this.f192733c = r102;
        this.f192735e = new ReentrantLock();
        this.f192736f = new ArrayList();
        this.f192737g = new b(this);
        if (r100.getCacheEnable() == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        this.f192738h = r103;
        return;
    L5:
        if (r100.getMaxCacheSize() <= 0) goto L7;
        r103 = true;
        goto L8
    }
}
