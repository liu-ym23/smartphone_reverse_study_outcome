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
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<g, i> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f196523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j f196524f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f196525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f196526h;

    public static final class a {
    }

    public static final class b extends IWrittenLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f196527c;

        @Override // com.bytedance.awemeopen.writtenlayout.IWrittenLayout
        public final View f() {
            LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-1, -2);
            Resources r101 = Resources.getSystem();
            r100.setMargins(0, MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()))), 0, 0);
            Unit r102 = Unit.INSTANCE;
            final f r103 = this.f196527c;
            Function1 r104 = new UserNameElementView$createView$1$createView$2(r103, this);
            Intrinsics.checkNotNullParameter(r100, "lparams");
            return o(0, r100, r104);
        }

        public b(f r100, Context r101) {
            this.f196527c = r100;
            super(r101);
        }
    }

    public static final class c implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f196528a;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            TextView r100 = this.f196528a.f196523e;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
            r100 = null;
        L5:
            ViewParent r101 = r100.getParent();
            if ((r101 instanceof ViewGroup) == false) goto L8;
            ViewGroup r102 = (ViewGroup) r101;
        L10:
            if (r102 != null) goto L12;
        L59:
            return true;
        L12:
            if (r102.getWidth() == 0) goto L59;
            TextView r103 = this.f196528a.f196523e;
            if (r103 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
            r103 = null;
        L17:
            r103.getViewTreeObserver().removeOnPreDrawListener(this);
            f r104 = this.f196528a;
            TextView r105 = r104.f196523e;
            if (r105 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
            r105 = null;
        L20:
            ViewParent r106 = r105.getParent();
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup r107 = (ViewGroup) r106;
            TextView r108 = r104.f196523e;
            if (r108 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
            r108 = null;
        L23:
            TextPaint r109 = r108.getPaint();
            TextView r110 = r104.f196523e;
            if (r110 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
            r110 = null;
        L26:
            float r111 = r109.measureText(r110.getText().toString());
            j r112 = r104.f196524f;
            if (r112 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("tagViewManage");
            r112 = null;
        L29:
            int r113 = r112.f196537b.size();
            int r114 = 0;
            int r115 = 0;
            boolean r116 = true;
        L31:
            if (r114 >= r113) goto L39;
            View r117 = r112.f196537b.valueAt(r114);
            r117.measure(0, 0);
            if (x54.b.c(r117) == false) goto L37;
            if (r116 == true) goto L36;
            Resources r118 = Resources.getSystem();
            r115 = r115 + MathKt.roundToInt(TypedValue.applyDimension(1, 6, WindowDisplayMetricsOverride.apply(r118, r118.getDisplayMetrics())));
        L36:
            r115 = r115 + r117.getMeasuredWidth();
            r116 = false;
        L37:
            r114 = r114 + 1;
            goto L31
        L39:
            if (r111 <= (r107.getWidth() - r115)) goto L48;
            j r119 = r104.f196524f;
            if (r119 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("tagViewManage");
            r119 = null;
        L43:
            r119.b(0);
            TextView r120 = r104.f196523e;
            if (r120 != null) goto L46;
            Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
            TextView r121 = null;
        L47:
            r121.setMaxWidth(r107.getWidth() - r115);
            goto L59
        L46:
            r121 = r120;
            goto L47
        L48:
            j r122 = r104.f196524f;
            if (r122 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("tagViewManage");
            r122 = null;
        L51:
            float r123 = 6;
            Resources r124 = Resources.getSystem();
            r122.b(MathKt.roundToInt(TypedValue.applyDimension(1, r123, WindowDisplayMetricsOverride.apply(r124, r124.getDisplayMetrics()))));
            TextView r125 = r104.f196523e;
            if (r125 != null) goto L54;
            Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
            TextView r126 = null;
        L55:
            if (r115 == 0) goto L57;
            int r127 = r107.getWidth() - r115;
            Resources r128 = Resources.getSystem();
            int r129 = r127 - MathKt.roundToInt(TypedValue.applyDimension(1, r123, WindowDisplayMetricsOverride.apply(r128, r128.getDisplayMetrics())));
        L58:
            r126.setMaxWidth(r129);
            goto L59
        L57:
            r129 = r107.getWidth();
            goto L58
        L54:
            r126 = r125;
            goto L55
        L8:
            r102 = null;
            goto L10
        }

        public c(f r100) {
            this.f196528a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        TextView r100 = this.f196523e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
        r100 = null;
    L5:
        r100.setOnClickListener(new com.bytedance.awemeopen.apps.framework.feed.ui.information.username.c(this));
        i r101 = (i) this.f195898c;
        Observer<Boolean> r102 = new d(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "observer");
        r101.f196534a.a(r102);
        i r103 = (i) this.f195898c;
        Observer<h> r104 = new e(this);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "observer");
        r103.f196535b.a(r104);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return new b(this, getContext()).j();
    }

    public f(Context r100, g r101, i r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
        this.f196526h = new c(this);
    }
}
