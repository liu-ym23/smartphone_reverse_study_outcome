package com.bytedance.awemeopen.apps.framework.feed.ui.information.warning;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<f, g> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DmtTextView f196540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f196541f;

    public static final class a extends IWrittenLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f196542c;

        @Override // com.bytedance.awemeopen.writtenlayout.IWrittenLayout
        public final View f() {
            ViewGroup.MarginLayoutParams r100 = new ViewGroup.MarginLayoutParams(-1, -2);
            r100.setMargins(0, g(8), 0, 0);
            Unit r101 = Unit.INSTANCE;
            final d r102 = this.f196542c;
            Function1 r103 = new WarningElementView$createView$1$createView$2(r102, this);
            Intrinsics.checkNotNullParameter(r100, "lparams");
            return o(0, r100, r103);
        }

        public a(d r100, Context r101) {
            this.f196542c = r100;
            super(r101);
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        g r100 = (g) this.f195898c;
        Observer<String> r101 = new b(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "observer");
        r100.f196544a.a(r101);
        g r102 = (g) this.f195898c;
        Observer<String> r103 = new c(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "observer");
        r102.f196545b.a(r103);
    }

    public final void e() {
        DmtTextView r100 = this.f196540e;
        ImageView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvRiskWarningHint");
        r100 = null;
    L5:
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
    L9:
        ImageView r104 = this.f196541f;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("ivRiskWarningIcon");
        r104 = null;
    L12:
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        float r106 = 16;
        r105.width = MathKt.roundToInt(TypedValue.applyDimension(1, r106, d(Resources.getSystem())));
        r105.height = MathKt.roundToInt(TypedValue.applyDimension(1, r106, d(Resources.getSystem())));
        if (r103 == null) goto L16;
        r103.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 4, d(Resources.getSystem()))));
    L16:
        DmtTextView r107 = this.f196540e;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("tvRiskWarningHint");
        r107 = null;
    L19:
        r107.setLayoutParams(r103);
        ImageView r108 = this.f196541f;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("ivRiskWarningIcon");
        r108 = null;
    L22:
        r108.setLayoutParams(r105);
        ImageView r109 = this.f196541f;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("ivRiskWarningIcon");
    L26:
        r101.setImageResource(R.drawable.aos_common_feed_ic_home_dangerous);
        return;
    L25:
        r101 = r109;
        goto L26
    L8:
        r103 = null;
        goto L9
    }

    public static DisplayMetrics d(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return new a(this, getContext()).j();
    }

    public d(Context r100, f r101, g r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
    }
}
