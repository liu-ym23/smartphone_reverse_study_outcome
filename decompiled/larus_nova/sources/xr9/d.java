package xr9;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d implements wr9.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f564887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f564888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet<wr9.f> f564889c;

    public final void b() {
        if (this.f564888b.compareAndSet(true, false) == false) goto L6;
        c r100 = this.f564887a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        r100.f564885e.remove(this);
        return;
    }

    @Override // wr9.i
    public final wr9.j o() {
        return this.f564887a.f564886f.get();
    }

    @Override // wr9.i
    public final void start() {
        if (this.f564888b.compareAndSet(false, true) == false) goto L9;
        c r100 = this.f564887a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if (r100.f564885e.add(this) == false) goto L10;
        a(r100.f564886f.get());
        return;
    L10:
        return;
    }

    @Override // wr9.i, java.lang.AutoCloseable
    public final void close() {
        b();
    }

    public d(c r100) {
        Intrinsics.checkNotNullParameter(r100, "engine");
        this.f564887a = r100;
        this.f564888b = new AtomicBoolean(false);
        this.f564889c = new CopyOnWriteArraySet();
    }

    @Override // wr9.i
    public final void G8(com.larus.avlink.gallery.power.monitor.e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f564889c.remove(r100);
    }

    @Override // wr9.i
    public final void Gb(com.larus.avlink.gallery.power.monitor.e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f564889c.add(r100);
    }

    public final void a(wr9.j r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        if (this.f564888b.get() == true) goto L5;
        return;
    L5:
        Iterator<T> r101 = this.f564889c.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        ((wr9.f) r101.next()).a(r100);     // Catch: Throwable -> L11
        goto L7
    }
}
