package com.bytedance.awemeopen.apps.framework.feed.ui.information.recommend.tag;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<f, g> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f196327e;

    public static final class a extends IWrittenLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f196328c;

        @Override // com.bytedance.awemeopen.writtenlayout.IWrittenLayout
        public final View f() {
            LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-2, -2);
            Resources r101 = Resources.getSystem();
            r100.setMargins(0, MathKt.roundToInt(TypedValue.applyDimension(1, 6, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()))), 0, 0);
            Unit r102 = Unit.INSTANCE;
            final e r103 = this.f196328c;
            Function1 r104 = new RecommendTagElementView$createView$1$createView$2(r103, this);
            Intrinsics.checkNotNullParameter(r100, "lparams");
            return o(0, r100, r104);
        }

        public a(e r100, Context r101) {
            this.f196328c = r100;
            super(r101);
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        g r100 = (g) this.f195898c;
        Observer<String> r101 = new c(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "observer");
        r100.f196330a.a(r101);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return new a(this, getContext()).j();
    }

    public e(Context r100, f r101, g r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
    }
}
