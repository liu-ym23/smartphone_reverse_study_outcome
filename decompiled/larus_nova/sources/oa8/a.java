package oa8;

import com.larus.office.h;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements do4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f522579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<String> f522580b;

    /* JADX INFO: renamed from: oa8.a$a, reason: collision with other inner class name */
    public static final class C7030a {
    }

    public final class b implements do4.a.InterfaceC5692a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f522581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f522582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f522583c;

        @Override // do4.a.InterfaceC5692a, java.lang.AutoCloseable
        public final void close() {
            if (this.f522582b.compareAndSet(false, true) == false) goto L12;
            a r100 = this.f522583c;
            monitor-enter(r100);
            r100.a(this.f522581a, false);     // Catch: Throwable -> L9
            Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L9
            monitor-exit(r100);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public b(a r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "key");
            this.f522583c = r100;
            this.f522581a = r101;
            this.f522582b = new AtomicBoolean(false);
        }
    }

    static {
    }

    @Override // do4.a
    public final synchronized b s1() {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter("NativeFormEdit", "owner");     // Catch: Throwable -> L7
        String r100 = "token:NativeFormEdit:" + UUID.randomUUID();     // Catch: Throwable -> L7
        a(r100, true);     // Catch: Throwable -> L7
        b r101 = new b(this, r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "hostAbilityProvider");
        this.f522579a = r100;
        this.f522580b = new LinkedHashSet();
    }

    @Override // do4.a
    public final synchronized void xg(boolean r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter("EmbeddedDocument", "owner");     // Catch: Throwable -> L7
        a("owner:EmbeddedDocument", r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a(String r100, boolean r101) {
        boolean r102 = !this.f522580b.isEmpty();
        if (r101 == false) goto L5;
        this.f522580b.add(r100);
    L6:
        boolean r103 = !this.f522580b.isEmpty();
        FLogger.f375446a.i("BaseMainAIChatVisibility", "update key=" + r100 + " hidden=" + r101 + " active=" + this.f522580b.size());
        if (r102 == r103) goto L12;
        com.larus.office.a r104 = this.f522579a.Ff();
        if (r104 == null) goto L13;
        r104.setChatInputVisibility("base_main_visibility", !r103);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        this.f522580b.remove(r100);
        goto L6
    }
}
