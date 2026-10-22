package sl4;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.bytedance.dux.common.DuxConfig;
import com.bytedance.dux.common.PadAdaptScene;
import com.bytedance.dux.filterpanel.DuxFilterPanelView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements jm4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DuxFilterPanelView f542464a;

    public d(DuxFilterPanelView r100) {
        this.f542464a = r100;
    }

    @Override // jm4.b
    public final void a(hm4.d r100) {
        Intrinsics.checkNotNullParameter(r100, "breakPointUpdate");
        DuxFilterPanelView r101 = this.f542464a;
        int r102 = DuxFilterPanelView.f205078f;
        r101.getClass();
        Map<PadAdaptScene, Boolean> r103 = DuxConfig.f204897a;
        if (DuxConfig.a(PadAdaptScene.FILTER_PANEL) == false) goto L15;
        NestedScrollView r104 = r101.f205079a;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L14;
        int r106 = im4.a.f490534a;
        Context r107 = r101.getContext();
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        hm4.a r108 = gm4.a.d(r107);
        if (MathKt.roundToInt(TypedValue.applyDimension(1, r108.f485915b, im4.a.a(Resources.getSystem()))) < MathKt.roundToInt(TypedValue.applyDimension(1, 705, im4.a.a(Resources.getSystem())))) goto L10;
        int r109 = MathKt.roundToInt(TypedValue.applyDimension(1, 273, im4.a.a(Resources.getSystem())));
    L11:
        r105.height = r109;
        r104.setLayoutParams(r105);
        return;
    L10:
        r109 = (int) ((((double) MathKt.roundToInt(TypedValue.applyDimension(1, r108.f485915b, im4.a.a(Resources.getSystem())))) * 0.73d) - ((double) MathKt.roundToInt(TypedValue.applyDimension(1, 127, im4.a.a(Resources.getSystem())))));
        goto L11
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
