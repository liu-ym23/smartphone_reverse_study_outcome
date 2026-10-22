package zoc;

import com.ss.android.lark.passportc.task.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.Lazy;
import io.reactivex.Observable;
import j0c.e;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yoc.h;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j0c.b f573170b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public Lazy<h> f573171a;

    public static final class a {
    }

    @Inject
    public b() {
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ boolean G() {
        return false;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ Observable H(e r100) {
        return com.ss.android.lark.passportc.task.e.a(this, r100);
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final List<j0c.b> dependencies() {
        return CollectionsKt.mutableListOf(new j0c.b[]{new j0c.b("switch_user")});
    }

    static {
        f573170b = new j0c.b("floating_panel_init");
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final j0c.b F() {
        return f573170b;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final Observable<j0c.c> I(e r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        j0c.b r101 = f573170b;
        Lazy<h> r102 = this.f573171a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("repository");
        r102 = null;
    L6:
        boolean r103 = true;
        return Observable.just(new j0c.c(r101, r103, r102.get().toString(), 4));
    }
}
