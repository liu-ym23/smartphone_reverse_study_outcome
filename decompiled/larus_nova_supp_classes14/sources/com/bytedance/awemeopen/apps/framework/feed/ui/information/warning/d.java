package com.bytedance.awemeopen.apps.framework.feed.ui.information.warning;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<f, g> {
    public DmtTextView e;
    public ImageView f;

    public static final class a extends IWrittenLayout {
        public final /* synthetic */ d c;

        public final View f() {
            ViewGroup.MarginLayoutParams r0 = new ViewGroup.MarginLayoutParams(-1, -2);
            r0.setMargins(0, g(8), 0, 0);
            Unit r1 = Unit.INSTANCE;
            final d r3 = this.c;
            Function1<LinearLayout, Unit> r2 = new WarningElementView$createView$1$createView$2(r3, this);
            Intrinsics.checkNotNullParameter(r0, "lparams");
            return o(0, r0, r2);
        }

        public a(d r1, Context r2) {
            this.c = r1;
            super(r2);
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        g r0 = (g) this.c;
        Observer<String> r1 = new b(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
        g r2 = (g) this.c;
        Observer<String> r3 = new c(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "observer");
        r2.b.a(r3);
    }

    public final void e() {
        AppCompatTextView r0 = this.e;
        ImageView r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvRiskWarningHint");
        r0 = null;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r1;
    L9:
        ImageView r4 = this.f;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("ivRiskWarningIcon");
        r4 = null;
    L12:
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        float r6 = 16;
        r5.width = MathKt.roundToInt(TypedValue.applyDimension(1, r6, d(Resources.getSystem())));
        r5.height = MathKt.roundToInt(TypedValue.applyDimension(1, r6, d(Resources.getSystem())));
        if (r3 == null) goto L16;
        r3.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 4, d(Resources.getSystem()))));
    L16:
        AppCompatTextView r7 = this.e;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("tvRiskWarningHint");
        r7 = null;
    L19:
        r7.setLayoutParams(r3);
        ImageView r8 = this.f;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("ivRiskWarningIcon");
        r8 = null;
    L22:
        r8.setLayoutParams(r5);
        ImageView r9 = this.f;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("ivRiskWarningIcon");
    L26:
        r2.setImageResource(2131231412);
        return;
    L25:
        r2 = r9;
        goto L26
    L8:
        r3 = null;
        goto L9
    }

    public static DisplayMetrics d(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        return new a(this, getContext()).j();
    }

    public d(Context r2, f r3, g r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
    }
}
