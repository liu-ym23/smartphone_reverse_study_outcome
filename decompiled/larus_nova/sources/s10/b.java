package s10;

import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import gm2.l;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import vlc.j;
import vlc.k;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements amc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s10.a f540132a;

    public static final class a<T> implements h80.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f540133a;

        public a(b r100) {
            this.f540133a = r100;
        }

        @Override // h80.d
        public final Object get() {
            return Long.valueOf(this.f540133a.f540132a.f540127m);
        }
    }

    @Override // amc.b
    public final long a() {
        return 200;
    }

    @Override // amc.b
    public final boolean c() {
        return true;
    }

    @Override // amc.b
    public final long d() {
        return AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
    }

    @Override // amc.b
    public final void e() {
    }

    @Override // amc.b
    public final com.ss.ugc.live.sdk.msg.dispatch.g g() {
        return null;
    }

    @Override // amc.b
    public final int j() {
        return 512;
    }

    @Override // amc.b
    public final k f() {
        return new l(new a(this));
    }

    @Override // amc.b
    public final List<vlc.b> getInterceptors() {
        return this.f540132a.f540130p;
    }

    @Override // amc.b
    public final Set<String> h() {
        return this.f540132a.f540123i;
    }

    @Override // amc.b
    public final List<j> i() {
        return this.f540132a.f540131q;
    }

    @Override // amc.b
    public final List<com.ss.ugc.live.sdk.msg.dispatch.a> b() {
        return CollectionsKt.emptyList();
    }

    public b(s10.a r100) {
        this.f540132a = r100;
    }
}
