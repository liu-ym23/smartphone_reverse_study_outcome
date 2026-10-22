package com.bytedance.awemeopen.apps.framework.feed.ui.information.music.title;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.base.view.MarqueeView;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<g, h> {
    public MarqueeView e;

    public static final class a extends IWrittenLayout {
        public final /* synthetic */ f c;

        public final View f() {
            LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, -2);
            Resources r2 = Resources.getSystem();
            r0.setMargins(0, MathKt.roundToInt(TypedValue.applyDimension(1, 6, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()))), 0, 0);
            Unit r1 = Unit.INSTANCE;
            final f r3 = this.c;
            Function1<LinearLayout, Unit> r4 = new MusicTitleElementView$createView$1$createView$2(this, r3);
            Intrinsics.checkNotNullParameter(r0, "lparams");
            return o(0, r0, r4);
        }

        public a(f r1, Context r2) {
            this.c = r1;
            super(r2);
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        h r0 = (h) this.c;
        Observer<Boolean> r1 = new c(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
        h r2 = (h) this.c;
        Observer<Boolean> r3 = new d(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "observer");
        r2.b.a(r3);
        h r4 = (h) this.c;
        Observer<String> r5 = new e(this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "observer");
        r4.c.a(r5);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        return new a(this, getContext()).j();
    }

    public f(Context r2, g r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
    }
}
