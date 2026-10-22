package vz4;

import com.larus.office.plugins.titlebar.ActionBarVisibilityPlugin;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements vz4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, String> f557708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vz4.b.InterfaceC8053b f557709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f557710c;

    public static final class a {
    }

    public final class b implements vz4.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f557711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f557712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f557713c;

        @Override // vz4.b.a, java.lang.AutoCloseable
        public final void close() {
            if (this.f557712b.compareAndSet(false, true) == false) goto L6;
            c r100 = this.f557713c;
            String r101 = this.f557711a;
            tt5.a.h("AppletCapsuleVisibility", "releaseHiddenToken: token=" + r101 + ", owner=" + r100.f557708a.remove(r101) + ", size=" + r100.f557708a.size());
            r100.a();
            return;
        }

        public b(c r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "owner");
            Intrinsics.checkNotNullParameter(r102, "token");
            this.f557713c = r100;
            this.f557711a = r102;
            this.f557712b = new AtomicBoolean(false);
        }
    }

    static {
    }

    @Override // vz4.b
    public final boolean nc() {
        return this.f557708a.isEmpty();
    }

    public c() {
        this.f557708a = new LinkedHashMap();
    }

    public final void a() {
        boolean r100 = nc();
        if (Intrinsics.areEqual(this.f557710c, Boolean.valueOf(r100)) == false) goto L5;
        return;
    L5:
        this.f557710c = Boolean.valueOf(r100);
        tt5.a.h("AppletCapsuleVisibility", "dispatchVisibilityIfNeeded: visible=" + r100 + ", hiddenOwners=" + this.f557708a.values());
        vz4.b.InterfaceC8053b r101 = this.f557709b;
        if (r101 == null) goto L9;
        r101.a(r100);
        return;
    }

    @Override // vz4.b
    public final void If(ActionBarVisibilityPlugin.b r100) {
        this.f557709b = r100;
        if (r100 == null) goto L6;
        r100.a(nc());
        return;
    }

    @Override // vz4.b
    public final b qh(String r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        String r101 = r100 + '_' + UUID.randomUUID();
        this.f557708a.put(r101, r100);
        tt5.a.h("AppletCapsuleVisibility", "acquireHiddenToken: owner=" + r100 + ", token=" + r101 + ", size=" + this.f557708a.size());
        a();
        return new b(this, r100, r101);
    }
}
