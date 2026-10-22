package nwb;

import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class i implements com.ss.android.lark.passportc.task.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0c.b f521023a = null;

    public static final class a {
    }

    @Inject
    public i() {
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
        f521023a = new j0c.b("update_device_id");
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final j0c.b F() {
        return f521023a;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final Observable<j0c.c> I(j0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return Observable.just(new j0c.c(f521023a, true, null, 12));
    }
}
