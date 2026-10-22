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
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class i extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<j, k> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f195932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f195933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f195934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AoImageView f195935h;

    public static final class a extends IWrittenLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f195936c;

        @Override // com.bytedance.awemeopen.writtenlayout.IWrittenLayout
        public final View f() {
            Resources r100 = Resources.getSystem();
            FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 40, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()))));
            final i r102 = this.f195936c;
            Function1<LinearLayout, Unit> r103 = new BottomBarElementView$createView$1$createView$1(r102, this);
            Intrinsics.checkNotNullParameter(r101, "lparams");
            return o(0, r101, r103);
        }

        public a(i r100, Context r101) {
            this.f195936c = r100;
            super(r101);
        }
    }

    public static final class b extends o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ i f195937d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((j) this.f195937d.f195897b).f195938a.b(Unit.INSTANCE);
        }

        public b(i r100) {
            this.f195937d = r100;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        k r100 = (k) this.f195898c;
        Observer<Boolean> r101 = new c(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "observer");
        r100.f195944f.a(r101);
        k r102 = (k) this.f195898c;
        Observer<String> r103 = new d(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "observer");
        r102.f195939a.a(r103);
        k r104 = (k) this.f195898c;
        Observer<String> r105 = new e(this);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "observer");
        r104.f195940b.a(r105);
        k r106 = (k) this.f195898c;
        Observer<List<String>> r107 = new f(this);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "observer");
        r106.f195941c.a(r107);
        k r108 = (k) this.f195898c;
        Observer<Integer> r109 = new g(this);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "observer");
        r108.f195942d.a(r109);
        k r110 = (k) this.f195898c;
        Observer<String> r111 = new h();
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "observer");
        r110.f195943e.a(r111);
        b().setOnClickListener(new b(this));
    }

    public final void d() {
        TextView r100 = this.f195932e;
        TextView r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        r100 = null;
    L6:
        if (TextUtils.isEmpty(r100.getText()) == true) goto L18;
        TextView r102 = this.f195934g;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("name");
        r102 = null;
    L11:
        if (TextUtils.isEmpty(r102.getText()) == true) goto L18;
        TextView r103 = this.f195933f;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("point");
    L17:
        r101.setVisibility(0);
        return;
    L16:
        r101 = r103;
    L18:
        TextView r104 = this.f195933f;
        if (r104 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("point");
    L22:
        r101.setVisibility(8);
        return;
    L21:
        r101 = r104;
        goto L22
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return new a(this, getContext()).j();
    }

    public i(Context r100, j r101, k r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
    }
}
