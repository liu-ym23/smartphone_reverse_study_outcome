package com.bytedance.awemeopen.apps.framework.feed.ui.bottombar.mix;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.utils.o;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<i, j> {
    public TextView e;
    public TextView f;
    public TextView g;
    public AoImageView h;

    public static final class a extends IWrittenLayout {
        public final /* synthetic */ h c;

        public final View f() {
            Resources r2 = Resources.getSystem();
            FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 40, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()))));
            float r1 = 12;
            Resources r3 = Resources.getSystem();
            int r4 = MathKt.roundToInt(TypedValue.applyDimension(1, r1, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
            Resources r5 = Resources.getSystem();
            int r6 = MathKt.roundToInt(TypedValue.applyDimension(1, r1, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics())));
            Resources r7 = Resources.getSystem();
            r0.setMargins(r4, 0, r6, MathKt.roundToInt(TypedValue.applyDimension(1, r1, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()))));
            Unit r8 = Unit.INSTANCE;
            final h r9 = this.c;
            Function1<LinearLayout, Unit> r10 = new MixBarElementView$createView$1$createView$2(r9, this);
            Intrinsics.checkNotNullParameter(r0, "lparams");
            return o(0, r0, r10);
        }

        public a(h r1, Context r2) {
            this.c = r1;
            super(r2);
        }
    }

    public static final class b extends o {
        public final /* synthetic */ h d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((i) this.d.b).a.b(Unit.INSTANCE);
        }

        public b(h r1) {
            this.d = r1;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        j r0 = (j) this.c;
        Observer<String> r1 = new d(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
        j r2 = (j) this.c;
        Observer<String> r3 = new e(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "observer");
        r2.b.a(r3);
        j r4 = (j) this.c;
        Observer<List<String>> r5 = new f(this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "observer");
        r4.c.a(r5);
        j r6 = (j) this.c;
        Observer<String> r7 = new g();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "observer");
        r6.d.a(r7);
        b().setOnClickListener(new b(this));
    }

    public final void d() {
        TextView r0 = this.e;
        TextView r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        r0 = null;
    L6:
        if (TextUtils.isEmpty(r0.getText()) == true) goto L18;
        TextView r2 = this.g;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("name");
        r2 = null;
    L11:
        if (TextUtils.isEmpty(r2.getText()) == true) goto L18;
        TextView r3 = this.f;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("point");
    L17:
        r1.setVisibility(0);
        return;
    L16:
        r1 = r3;
    L18:
        TextView r4 = this.f;
        if (r4 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("point");
    L22:
        r1.setVisibility(8);
        return;
    L21:
        r1 = r4;
        goto L22
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        return new a(this, getContext()).j();
    }

    public h(Context r2, i r3, j r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
    }
}
