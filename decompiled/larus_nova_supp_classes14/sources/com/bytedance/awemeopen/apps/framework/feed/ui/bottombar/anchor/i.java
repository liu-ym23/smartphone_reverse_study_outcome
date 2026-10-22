package com.bytedance.awemeopen.apps.framework.feed.ui.bottombar.anchor;

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
public final class i extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<j, k> {
    public TextView e;
    public TextView f;
    public TextView g;
    public AoImageView h;

    public static final class a extends IWrittenLayout {
        public final /* synthetic */ i c;

        public final View f() {
            Resources r2 = Resources.getSystem();
            FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 40, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()))));
            final i r3 = this.c;
            Function1<LinearLayout, Unit> r1 = new BottomBarElementView$createView$1$createView$1(r3, this);
            Intrinsics.checkNotNullParameter(r0, "lparams");
            return o(0, r0, r1);
        }

        public a(i r1, Context r2) {
            this.c = r1;
            super(r2);
        }
    }

    public static final class b extends o {
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
        k r0 = (k) this.c;
        Observer<Boolean> r1 = new c(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.f.a(r1);
        k r2 = (k) this.c;
        Observer<String> r3 = new d(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "observer");
        r2.a.a(r3);
        k r4 = (k) this.c;
        Observer<String> r5 = new e(this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "observer");
        r4.b.a(r5);
        k r6 = (k) this.c;
        Observer<List<String>> r7 = new f(this);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "observer");
        r6.c.a(r7);
        k r8 = (k) this.c;
        Observer<Integer> r9 = new g(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "observer");
        r8.d.a(r9);
        k r10 = (k) this.c;
        Observer<String> r11 = new h();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "observer");
        r10.e.a(r11);
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

    public i(Context r2, j r3, k r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
    }
}
