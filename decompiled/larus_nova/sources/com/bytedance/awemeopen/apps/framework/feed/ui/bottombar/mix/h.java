package com.bytedance.awemeopen.apps.framework.feed.ui.bottombar.mix;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
public final class h extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<i, j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f195961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f195962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f195963g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AoImageView f195964h;

    public static final class a extends IWrittenLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f195965c;

        @Override // com.bytedance.awemeopen.writtenlayout.IWrittenLayout
        public final View f() {
            Resources r100 = Resources.getSystem();
            FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 40, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()))));
            float r102 = 12;
            Resources r103 = Resources.getSystem();
            int r104 = MathKt.roundToInt(TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
            Resources r105 = Resources.getSystem();
            int r106 = MathKt.roundToInt(TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())));
            Resources r107 = Resources.getSystem();
            r101.setMargins(r104, 0, r106, MathKt.roundToInt(TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()))));
            Unit r108 = Unit.INSTANCE;
            final h r109 = this.f195965c;
            Function1 r110 = new MixBarElementView$createView$1$createView$2(r109, this);
            Intrinsics.checkNotNullParameter(r101, "lparams");
            return o(0, r101, r110);
        }

        public a(h r100, Context r101) {
            this.f195965c = r100;
            super(r101);
        }
    }

    public static final class b extends o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h f195966d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((i) this.f195966d.f195897b).f195967a.b(Unit.INSTANCE);
        }

        public b(h r100) {
            this.f195966d = r100;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        j r100 = (j) this.f195898c;
        Observer<String> r101 = new d(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "observer");
        r100.f195968a.a(r101);
        j r102 = (j) this.f195898c;
        Observer<String> r103 = new e(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "observer");
        r102.f195969b.a(r103);
        j r104 = (j) this.f195898c;
        Observer<List<String>> r105 = new f(this);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "observer");
        r104.f195970c.a(r105);
        j r106 = (j) this.f195898c;
        Observer<String> r107 = new g();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "observer");
        r106.f195971d.a(r107);
        b().setOnClickListener(new b(this));
    }

    public final void d() {
        TextView r100 = this.f195961e;
        TextView r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        r100 = null;
    L6:
        if (TextUtils.isEmpty(r100.getText()) == true) goto L18;
        TextView r102 = this.f195963g;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("name");
        r102 = null;
    L11:
        if (TextUtils.isEmpty(r102.getText()) == true) goto L18;
        TextView r103 = this.f195962f;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("point");
    L17:
        r101.setVisibility(0);
        return;
    L16:
        r101 = r103;
    L18:
        TextView r104 = this.f195962f;
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

    public h(Context r100, i r101, j r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
    }
}
