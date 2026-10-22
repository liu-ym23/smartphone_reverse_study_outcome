package com.bytedance.awemeopen.apps.framework.feed.ui.information.username;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
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
public final class f extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<g, i> {
    public TextView e;
    public j f;
    public boolean g;
    public final c h;

    public static final class a {
    }

    public static final class b extends IWrittenLayout {
        public final /* synthetic */ f c;

        public final View f() {
            LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, -2);
            Resources r2 = Resources.getSystem();
            r0.setMargins(0, MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()))), 0, 0);
            Unit r1 = Unit.INSTANCE;
            final f r3 = this.c;
            Function1<LinearLayout, Unit> r4 = new UserNameElementView$createView$1$createView$2(r3, this);
            Intrinsics.checkNotNullParameter(r0, "lparams");
            return o(0, r0, r4);
        }

        public b(f r1, Context r2) {
            this.c = r1;
            super(r2);
        }
    }

    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ f a;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            TextView r1 = this.a.e;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
            r1 = null;
        L5:
            ViewParent r2 = r1.getParent();
            if ((r2 instanceof ViewGroup) == false) goto L8;
            ViewGroup r3 = (ViewGroup) r2;
        L10:
            if (r3 != null) goto L12;
        L59:
            return true;
        L12:
            if (r3.getWidth() == 0) goto L59;
            TextView r4 = this.a.e;
            if (r4 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
            r4 = null;
        L17:
            r4.getViewTreeObserver().removeOnPreDrawListener(this);
            f r5 = this.a;
            TextView r6 = r5.e;
            if (r6 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
            r6 = null;
        L20:
            ViewParent r7 = r6.getParent();
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup r8 = (ViewGroup) r7;
            TextView r9 = r5.e;
            if (r9 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
            r9 = null;
        L23:
            TextPaint r10 = r9.getPaint();
            TextView r11 = r5.e;
            if (r11 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
            r11 = null;
        L26:
            float r12 = r10.measureText(r11.getText().toString());
            j r13 = r5.f;
            if (r13 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("tagViewManage");
            r13 = null;
        L29:
            int r14 = r13.b.size();
            int r15 = 0;
            int r16 = 0;
            boolean r17 = true;
        L31:
            if (r15 >= r14) goto L39;
            View r18 = r13.b.valueAt(r15);
            r18.measure(0, 0);
            if (x54.b.c(r18) == false) goto L37;
            if (r17 == true) goto L36;
            Resources r19 = Resources.getSystem();
            r16 = r16 + MathKt.roundToInt(TypedValue.applyDimension(1, 6, WindowDisplayMetricsOverride.apply(r19, r19.getDisplayMetrics())));
        L36:
            r16 = r16 + r18.getMeasuredWidth();
            r17 = false;
        L37:
            r15 = r15 + 1;
            goto L31
        L39:
            if (r12 <= (r8.getWidth() - r16)) goto L48;
            j r20 = r5.f;
            if (r20 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("tagViewManage");
            r20 = null;
        L43:
            r20.b(0);
            TextView r21 = r5.e;
            if (r21 != null) goto L46;
            Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
            TextView r22 = null;
        L47:
            r22.setMaxWidth(r8.getWidth() - r16);
            goto L59
        L46:
            r22 = r21;
            goto L47
        L48:
            j r23 = r5.f;
            if (r23 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("tagViewManage");
            r23 = null;
        L51:
            float r24 = 6;
            Resources r25 = Resources.getSystem();
            r23.b(MathKt.roundToInt(TypedValue.applyDimension(1, r24, WindowDisplayMetricsOverride.apply(r25, r25.getDisplayMetrics()))));
            TextView r26 = r5.e;
            if (r26 != null) goto L54;
            Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
            TextView r27 = null;
        L55:
            if (r16 == 0) goto L57;
            int r28 = r8.getWidth() - r16;
            Resources r29 = Resources.getSystem();
            int r30 = r28 - MathKt.roundToInt(TypedValue.applyDimension(1, r24, WindowDisplayMetricsOverride.apply(r29, r29.getDisplayMetrics())));
        L58:
            r27.setMaxWidth(r30);
            goto L59
        L57:
            r30 = r8.getWidth();
            goto L58
        L54:
            r27 = r26;
            goto L55
        L8:
            r3 = null;
            goto L10
        }

        public c(f r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        TextView r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
        r0 = null;
    L5:
        r0.setOnClickListener(new com.bytedance.awemeopen.apps.framework.feed.ui.information.username.c(this));
        i r1 = (i) this.c;
        Observer<Boolean> r2 = new d(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "observer");
        r1.a.a(r2);
        i r3 = (i) this.c;
        Observer<h> r4 = new e(this);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "observer");
        r3.b.a(r4);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        return new b(this, getContext()).j();
    }

    public f(Context r2, g r3, i r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
        this.h = new c(this);
    }
}
