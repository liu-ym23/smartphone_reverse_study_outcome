package yo2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.popup.LiveRepelPopupRegion;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f extends d<f> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f568663x = 0;

    public static final class a {
    }

    static {
    }

    @Override // yo2.d
    public final void f() {
    }

    public f() {
        LiveRepelPopupRegion r100 = LiveRepelPopupRegion.NONE;
    }

    @Override // yo2.d
    public final void d() {
        super.d();
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LiveRepelPopupRegion r101 = LiveRepelPopupRegion.NONE;
        this.f568641c = r100;
    }

    @Override // yo2.d
    public final void g(View r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter((f) r101, "popup");
    }
}
