package aw4;

import android.app.Application;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Flowable;
import java.io.IOException;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import znc.h;
import znc.j;
import znc.k;
import znc.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements a {
    public final Application a;
    public volatile m b;

    public final synchronized h b() throws IOException {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.b != null) goto L6;
        Biz r0 = Biz.DOCS;     // Catch: Throwable -> L9
        String r1 = ay4.c.b(r0, "LRU").getRealPath();     // Catch: Throwable -> L9
        Application r2 = this.a;     // Catch: Throwable -> L9
        com.ss.android.lark.vfs.h r3 = ay4.d.a();     // Catch: Throwable -> L9
        int r4 = ay4.c.b.a;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r2, "context");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r0, "biz");     // Catch: Throwable -> L9
        String r5 = r3.z(ay4.c.b.a(r2, r0, "")).subPath("LRU").getRealPath();     // Catch: Throwable -> L9
        m.a r6 = new m.a();     // Catch: Throwable -> L9
        r6.a(r1);     // Catch: Throwable -> L9
        r6.f = new com.suite.lark.platform.component.storage.file.cache.a(ay4.d.a());     // Catch: Throwable -> L9
        r6.c = 1;     // Catch: Throwable -> L9
        r6.e = 104857600;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r5, "sourceDirectory");     // Catch: Throwable -> L9
        r6.b = new PolarisFileWrapper(r5);     // Catch: Throwable -> L9
        this.b = new m(r6);     // Catch: Throwable -> L9
    L6:
        m r7 = this.b;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r7;
    }

    @Override // aw4.a
    public final Flowable<Boolean> clearCache() {
        return Flowable.just("").observeOn(fo5.d.b()).map(new d(this)).doOnError(new e()).onErrorReturnItem(Boolean.FALSE);
    }

    @Override // aw4.a
    public final Flowable<Long> getCacheSize() {
        return Flowable.just("").observeOn(fo5.d.b()).map(new b(this)).doOnError(new c()).onErrorReturnItem(0L);
    }

    public f() {
        this.b = null;
        this.a = eu5.b.a;
    }

    @Override // aw4.a
    public final <T extends Serializable> T get(String r3) throws IOException {
        h r0 = b();     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r0, "<this>");     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r3, "key");     // Catch: Throwable -> L4
        return (T) r0.c(r3, new j());
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // aw4.a
    public final void a(String r3, Serializable r4) {
        m r0 = b();     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r0, "<this>");     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r3, "key");     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r4, "obj");     // Catch: Throwable -> L4
        m r1 = r0;     // Catch: Throwable -> L4
        r1.d(r3, new k(r4));     // Catch: Throwable -> L4
        return;
    }
}
