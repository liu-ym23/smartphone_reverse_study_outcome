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
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<f, g> {
    public TextView e;

    public static final class a extends IWrittenLayout {
        public final /* synthetic */ e c;

        public final View f() {
            LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -2);
            Resources r2 = Resources.getSystem();
            r0.setMargins(0, MathKt.roundToInt(TypedValue.applyDimension(1, 6, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()))), 0, 0);
            Unit r1 = Unit.INSTANCE;
            final e r3 = this.c;
            Function1<LinearLayout, Unit> r4 = new RecommendTagElementView$createView$1$createView$2(r3, this);
            Intrinsics.checkNotNullParameter(r0, "lparams");
            return o(0, r0, r4);
        }

        public a(e r1, Context r2) {
            this.c = r1;
            super(r2);
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        g r0 = (g) this.c;
        Observer<String> r1 = new c(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        return new a(this, getContext()).j();
    }

    public e(Context r2, f r3, g r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
    }
}
