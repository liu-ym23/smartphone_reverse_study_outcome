package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.cpscard;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<j, k> {
    public AoImageView e;
    public m f;
    public TextView g;
    public TextView h;
    public EllipticalTextView i;
    public TextView j;
    public TextView k;
    public RelativeLayout l;
    public TextView m;
    public TextView n;
    public RelativeLayout o;

    public static final class a extends IWrittenLayout {
        public final /* synthetic */ i c;

        public final View f() {
            Resources r2 = Resources.getSystem();
            int r1 = MathKt.roundToInt(TypedValue.applyDimension(1, 260, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
            Resources r4 = Resources.getSystem();
            ViewGroup.MarginLayoutParams r0 = new ViewGroup.MarginLayoutParams(r1, MathKt.roundToInt(TypedValue.applyDimension(1, 144, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()))));
            Resources r3 = Resources.getSystem();
            r0.setMargins(0, 0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()))));
            final i r5 = this.c;
            Function1<RelativeLayout, Unit> r6 = new CpsShoppingCardElementView$createView$1$createView$2(r5, this);
            Intrinsics.checkNotNullParameter(r0, "lparams");
            Intrinsics.checkNotNullParameter(r0, "lparams");
            RelativeLayout r7 = new RelativeLayout(getContext());
            r7.setLayoutParams(r0);
            r6.invoke(r7);
            return r7;
        }

        public a(i r1, Context r2) {
            this.c = r1;
            super(r2);
        }
    }

    public static final class b extends com.bytedance.awemeopen.apps.framework.utils.o {
        public final /* synthetic */ i d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((j) this.d.b).a.b(Unit.INSTANCE);
        }

        public b(i r1) {
            this.d = r1;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        b().setOnClickListener(new b(this));
        k r0 = (k) this.c;
        Observer<List<String>> r1 = new c(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
        k r2 = (k) this.c;
        Observer<p> r3 = new d(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "observer");
        r2.c.a(r3);
        k r4 = (k) this.c;
        Observer<String> r5 = new e(this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "observer");
        r4.b.a(r5);
        k r6 = (k) this.c;
        Observer<String> r7 = new f(this);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "observer");
        r6.d.a(r7);
        k r8 = (k) this.c;
        Observer<String> r9 = new g(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "observer");
        r8.e.a(r9);
        k r10 = (k) this.c;
        Observer<String> r11 = new h(this);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "observer");
        r10.f.a(r11);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        return new a(this, getContext()).j();
    }

    public i(Context r2, j r3, k r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
    }
}
