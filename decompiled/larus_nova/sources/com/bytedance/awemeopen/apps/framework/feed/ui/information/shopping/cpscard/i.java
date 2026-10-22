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
    public AoImageView f196487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m f196488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f196489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f196490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EllipticalTextView f196491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f196492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f196493k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RelativeLayout f196494l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f196495m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f196496n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RelativeLayout f196497o;

    public static final class a extends IWrittenLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f196498c;

        @Override // com.bytedance.awemeopen.writtenlayout.IWrittenLayout
        public final View f() {
            Resources r100 = Resources.getSystem();
            int r101 = MathKt.roundToInt(TypedValue.applyDimension(1, 260, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
            Resources r102 = Resources.getSystem();
            ViewGroup.MarginLayoutParams r103 = new ViewGroup.MarginLayoutParams(r101, MathKt.roundToInt(TypedValue.applyDimension(1, 144, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()))));
            Resources r104 = Resources.getSystem();
            r103.setMargins(0, 0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()))));
            final i r105 = this.f196498c;
            Function1<RelativeLayout, Unit> r106 = new CpsShoppingCardElementView$createView$1$createView$2(r105, this);
            Intrinsics.checkNotNullParameter(r103, "lparams");
            Intrinsics.checkNotNullParameter(r103, "lparams");
            RelativeLayout r107 = new RelativeLayout(getContext());
            r107.setLayoutParams(r103);
            r106.invoke(r107);
            return r107;
        }

        public a(i r100, Context r101) {
            this.f196498c = r100;
            super(r101);
        }
    }

    public static final class b extends com.bytedance.awemeopen.apps.framework.utils.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ i f196499d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((j) this.f196499d.f195897b).f196500a.b(Unit.INSTANCE);
        }

        public b(i r100) {
            this.f196499d = r100;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        b().setOnClickListener(new b(this));
        k r100 = (k) this.f195898c;
        Observer<List<String>> r101 = new c(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "observer");
        r100.f196501a.a(r101);
        k r102 = (k) this.f195898c;
        Observer<p> r103 = new d(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "observer");
        r102.f196503c.a(r103);
        k r104 = (k) this.f195898c;
        Observer<String> r105 = new e(this);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "observer");
        r104.f196502b.a(r105);
        k r106 = (k) this.f195898c;
        Observer<String> r107 = new f(this);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "observer");
        r106.f196504d.a(r107);
        k r108 = (k) this.f195898c;
        Observer<String> r109 = new g(this);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "observer");
        r108.f196505e.a(r109);
        k r110 = (k) this.f195898c;
        Observer<String> r111 = new h(this);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "observer");
        r110.f196506f.a(r111);
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
