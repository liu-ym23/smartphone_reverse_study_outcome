package ev0;

import com.bytedance.android.live.profit.taskcenter.panel.model.PanelInfo;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f474202a = null;

    static {
        f474202a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        PanelInfo.State r101 = (PanelInfo.State) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.isAtLeast(PanelInfo.State.SHOWING);
    }
}
