package zi3;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f572241a = null;

    public b() {
    }

    @Override // zi3.c
    public final void a(Context r100, List<PanelItem> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "items");
    }

    @Override // zi3.c
    public final View b(Context r100, Function1<? super View, Unit> r101, Function1<? super View, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onMenuClick");
        Intrinsics.checkNotNullParameter(r102, "onCloseClick");
        return null;
    }

    @Override // zi3.c
    public final boolean c() {
        return true;
    }

    @Override // zi3.c
    public final View d(Context r100, Function1<? super View, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        return null;
    }

    @Override // zi3.c
    public final boolean e() {
        return false;
    }

    static {
        f572241a = new b();
    }
}
