package sr9;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c0 implements qs8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f543237a;

    @Override // qs8.a
    public final void I4(boolean r100) {
    }

    @Override // qs8.a
    public final void J1(float r100, boolean r101) {
    }

    @Override // qs8.a
    public final void d5(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
    }

    @Override // qs8.a
    public final void h3() {
    }

    @Override // qs8.a
    public final void setProgressViewVisibility(boolean r100) {
    }

    @Override // qs8.a
    public final void z1(Function1<? super PlayerProgressView, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
    }

    @Override // qs8.a
    public final View asView() {
        return this.f543237a;
    }

    public c0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f543237a = new View(r100);
    }
}
