package jjb;

import com.bytedance.lark.rustclient.internal.l;
import com.bytedance.lark.rustclient.internal.m;
import com.bytedance.lark.sdk.refactor.n;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements com.ss.android.lark.passportc.task.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j0c.b f499403d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f499404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f499405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f499406c;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f499407a = null;

        static {
            int[] r100 = new int[Scene.values().length];
            r100[Scene.SWITCH_BACKGROUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f499407a = r100;
        }
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ boolean G() {
        return false;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ Observable H(j0c.e r100) {
        return com.ss.android.lark.passportc.task.e.a(this, r100);
    }

    static {
        f499403d = new j0c.b("make_rust_offline");
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final j0c.b F() {
        return f499403d;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final Observable<j0c.c> I(j0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Log.i("ComponentTask", "user{" + r100.f496852a.f475033a.userId + "} execute rust foreground offline task ,scene = " + r100.f496853b);
        Scene r101 = r100.f496853b;
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 != 1) goto L10;
        return Observable.create(new g(r100, this));
    L10:
        return Observable.create(new f(this, r100));
    L5:
        r102 = b.f499407a[r101.ordinal()];
        goto L7
    }

    public static final void b(e r100, String r101) {
        Pair<Long, Long> r102 = r100.f499406c.i(r101);
        if (r102 != null) goto L5;
        Log.e("RustSDK", "MakeRustOfflineTask get container id is null ");
        return;
    L5:
        Log.i("RustSDK", "MakeRustOnlineTask unregisterReceiver container id : " + r102);
        r100.f499404a.a(r101, r102);
    }

    @Inject
    public e(m r100, l r101, n r102) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        Intrinsics.checkNotNullParameter(r101, "dispatcher");
        Intrinsics.checkNotNullParameter(r102, "rustSdk");
        this.f499404a = r100;
        this.f499405b = r101;
        this.f499406c = r102;
    }

    public static final void a(e r100, String r101, boolean r102) {
        r100.getClass();
        if (com.ss.android.lark.featuregating.b.f420726d.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L5;
        ((jdb.e) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(jdb.e.class)).Tc(r101, r102);
        return;
    L5:
        i3c.b.a(r101, r102);
    }
}
