package vz4;

import com.larus.office.plugins.titlebar.ActionBarVisibilityPlugin;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements vz4.b {
    public final LinkedHashMap<String, String> a;
    public vz4.b.InterfaceC0315b b;
    public Boolean c;

    public static final class a {
    }

    public final class b implements vz4.b.a {
        public final String a;
        public final AtomicBoolean b;
        public final /* synthetic */ c c;

        @Override // vz4.b.a, java.lang.AutoCloseable
        public final void close() {
            if (this.b.compareAndSet(false, true) == false) goto L6;
            c r0 = this.c;
            String r1 = this.a;
            tt5.a.h("AppletCapsuleVisibility", "releaseHiddenToken: token=" + r1 + ", owner=" + r0.a.remove(r1) + ", size=" + r0.a.size());
            r0.a();
            return;
        }

        public b(c r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "owner");
            Intrinsics.checkNotNullParameter(r4, "token");
            this.c = r2;
            this.a = r4;
            this.b = new AtomicBoolean(false);
        }
    }

    static {
    }

    @Override // vz4.b
    public final boolean nc() {
        return this.a.isEmpty();
    }

    public c() {
        this.a = new LinkedHashMap();
    }

    public final void a() {
        boolean r0 = nc();
        if (Intrinsics.areEqual(this.c, Boolean.valueOf(r0)) == false) goto L5;
        return;
    L5:
        this.c = Boolean.valueOf(r0);
        tt5.a.h("AppletCapsuleVisibility", "dispatchVisibilityIfNeeded: visible=" + r0 + ", hiddenOwners=" + this.a.values());
        vz4.b.InterfaceC0315b r1 = this.b;
        if (r1 == null) goto L9;
        r1.a(r0);
        return;
    }

    @Override // vz4.b
    public final void If(ActionBarVisibilityPlugin.b r2) {
        this.b = r2;
        if (r2 == null) goto L6;
        r2.a(nc());
        return;
    }

    @Override // vz4.b
    public final b qh(String r4) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        String r0 = r4 + '_' + UUID.randomUUID();
        this.a.put(r0, r4);
        tt5.a.h("AppletCapsuleVisibility", "acquireHiddenToken: owner=" + r4 + ", token=" + r0 + ", size=" + this.a.size());
        a();
        return new b(this, r4, r0);
    }
}
