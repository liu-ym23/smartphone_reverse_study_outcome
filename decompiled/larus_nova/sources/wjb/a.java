package wjb;

import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.task.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import j0c.b;
import j0c.c;
import j0c.e;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f560058a = null;

    /* JADX INFO: renamed from: wjb.a$a, reason: collision with other inner class name */
    public static final class C8123a {
    }

    @Inject
    public a() {
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
    public final List<b> dependencies() {
        return CollectionsKt.mutableListOf(new b[]{new b("switch_user")});
    }

    static {
        f560058a = new b("load_on_boarding");
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final b F() {
        return f560058a;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final Observable<c> I(e r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Scene r101 = r100.f496853b;
        Scene r102 = Scene.FIRST_ONLINE;
        return Observable.just(new c(f560058a, true, null, 12));
    }
}
