package com.bytedance.dux.filterpanel;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.bytedance.dux.button.DuxButton;
import com.bytedance.dux.common.DuxConfig;
import com.bytedance.dux.common.PadAdaptScene;
import com.bytedance.dux.window.controller.DuxBreakPointController;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import gm4.a;
import hm4.c;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import sl4.d;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0006\u0010\r\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/dux/filterpanel/DuxFilterPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "count", "", "setMaxSelectCount", "Lcom/bytedance/dux/button/DuxButton;", "getResetBtn", "getConfirmBtn", "", "Lcom/bytedance/dux/filterpanel/DuxFilterGroupView;", "getFilterGroupViewSet", "Landroid/widget/LinearLayout;", "getFilterGroupContainer", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxFilterPanelView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f205078f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollView f205079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f205080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DuxButton f205081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DuxButton f205082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<DuxFilterGroupView> f205083e;

    public DuxFilterPanelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public DuxFilterPanelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    public final void setMaxSelectCount(int r100) {
    }

    public final DuxButton getConfirmBtn() {
        return this.f205082d;
    }

    public final LinearLayout getFilterGroupContainer() {
        return this.f205080b;
    }

    public final Set<DuxFilterGroupView> getFilterGroupViewSet() {
        return this.f205083e;
    }

    public final DuxButton getResetBtn() {
        return this.f205081c;
    }

    public DuxFilterPanelView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f205083e = new LinkedHashSet();
        ViewGroup.inflate(r100, R.layout.dux_layout_filter_panel_view, this);
        Map<PadAdaptScene, Boolean> r103 = DuxConfig.f204897a;
        if (DuxConfig.a(PadAdaptScene.FILTER_PANEL) == false) goto L8;
        ViewGroup.LayoutParams r104 = new ViewGroup.LayoutParams(-1, -2);
    L9:
        setLayoutParams(r104);
        NestedScrollView r105 = (NestedScrollView) findViewById(R.id.scrollView);
        this.f205079a = r105;
        this.f205080b = (LinearLayout) findViewById(R.id.filter_group_container);
        LinearLayout r106 = (LinearLayout) findViewById(R.id.btn_container);
        this.f205081c = (DuxButton) findViewById(R.id.btn_reset);
        this.f205082d = (DuxButton) findViewById(R.id.btn_confirm);
        DuxBreakPointController r107 = a.f481672a;
        a.b(new c(r105), new d(this));
        return;
    L8:
        Resources r108 = Resources.getSystem();
        r104 = new ViewGroup.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 400, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()))));
        goto L9
    }
}
