package st2;

import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.ugc.live.sdk.msg.dispatch.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import vlc.j;
import vlc.k;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements amc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f543556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f543557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Set f543558c;

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
    public final k f() {
        return null;
    }

    @Override // amc.b
    public final g g() {
        return null;
    }

    @Override // amc.b
    public final int j() {
        return 512;
    }

    @Override // amc.b
    public final List<com.ss.ugc.live.sdk.msg.dispatch.a> b() {
        return CollectionsKt.emptyList();
    }

    @Override // amc.b
    public final List<vlc.b> getInterceptors() {
        return this.f543556a;
    }

    @Override // amc.b
    public final Set<String> h() {
        return this.f543558c;
    }

    @Override // amc.b
    public final List<j> i() {
        return this.f543557b;
    }

    public c(ArrayList r100, ArrayList r101, Set r102) {
        this.f543556a = r100;
        this.f543557b = r101;
        this.f543558c = r102;
    }
}
