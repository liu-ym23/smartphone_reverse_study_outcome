package jjb;

import com.bytedance.lark.rustclient.internal.l;
import com.bytedance.lark.rustclient.internal.m;
import com.bytedance.lark.sdk.refactor.n;
import com.bytedance.lark.sdk.refactor.state.LoginState;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.Contexts;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements com.ss.android.lark.passportc.task.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j0c.b f499367d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f499368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f499369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f499370c;

    /* JADX INFO: renamed from: jjb.a$a, reason: collision with other inner class name */
    public static final class C6447a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f499371a = null;

        static {
            int[] r100 = new int[Scene.values().length];
            r100[Scene.SWITCH_FOREGROUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f499371a = r100;
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
        f499367d = new j0c.b("make_rust_background_offline");
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final j0c.b F() {
        return f499367d;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final Observable<j0c.c> I(j0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Scene r101 = r100.f496853b;
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 != 1) goto L9;
        Log.i("ComponentTask", "user{" + r100.f496852a.f475033a.userId + "} from background online switch to foreground online , skip rust background offline");
        b(r100.f496852a.f475033a.userId);
        Observable<j0c.c> r103 = Observable.just(new j0c.c(f499367d, true, null, 12));
        Intrinsics.checkNotNull(r103);
        return r103;
    L9:
        User r104 = r100.f496852a.f475033a;
        LoginState r105 = this.f499370c.f(r104.userId);
        Log.i("ComponentTask", "user{" + r100.f496852a.f475033a.userId + "} execute rust background offline task ,scene = " + r100.f496853b + " , loginState = " + r105);
        if (r105 != LoginState.BACKGROUND) goto L13;
        return Observable.create(new jjb.b(this, r104, r100));
    L13:
        return Observable.just(new j0c.c(f499367d, true, null, 12));
    L5:
        r102 = b.f499371a[r101.ordinal()];
        goto L7
    }

    public final void b(String r100) {
        Pair<Long, Long> r101 = this.f499370c.i(r100);
        if (r101 != null) goto L5;
        Log.e("RustSDK", "MakeRustOfflineTask get container id is null ");
        return;
    L5:
        Log.i("RustSDK", "MakeRustOnlineTask unregisterReceiver container id : " + r101);
        this.f499368a.a(r100, r101);
    }

    @Inject
    public a(m r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        Intrinsics.checkNotNullParameter(r101, "dispatcher");
        this.f499368a = r100;
        this.f499369b = r101;
        this.f499370c = (n) ((DwarfSPIEntryPoint) EntryPoints.get(Contexts.getApplication(LarkContext.getApplication()), DwarfSPIEntryPoint.class)).dwarfSPI().get(n.class);
    }

    public static final void a(a r100, String r101, boolean r102) {
        r100.getClass();
        if (com.ss.android.lark.featuregating.b.f420726d.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L5;
        ((jdb.e) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(jdb.e.class)).Tc(r101, r102);
        return;
    L5:
        i3c.b.a(r101, r102);
    }
}
