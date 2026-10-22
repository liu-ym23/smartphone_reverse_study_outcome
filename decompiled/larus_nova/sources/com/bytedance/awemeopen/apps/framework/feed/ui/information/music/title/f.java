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
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<g, h> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MarqueeView f196209e;

    public static final class a extends IWrittenLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f196210c;

        @Override // com.bytedance.awemeopen.writtenlayout.IWrittenLayout
        public final View f() {
            LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-1, -2);
            Resources r101 = Resources.getSystem();
            r100.setMargins(0, MathKt.roundToInt(TypedValue.applyDimension(1, 6, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()))), 0, 0);
            Unit r102 = Unit.INSTANCE;
            final f r103 = this.f196210c;
            Function1 r104 = new MusicTitleElementView$createView$1$createView$2(this, r103);
            Intrinsics.checkNotNullParameter(r100, "lparams");
            return o(0, r100, r104);
        }

        public a(f r100, Context r101) {
            this.f196210c = r100;
            super(r101);
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        h r100 = (h) this.f195898c;
        Observer<Boolean> r101 = new c(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "observer");
        r100.f196211a.a(r101);
        h r102 = (h) this.f195898c;
        Observer<Boolean> r103 = new d(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "observer");
        r102.f196212b.a(r103);
        h r104 = (h) this.f195898c;
        Observer<String> r105 = new e(this);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "observer");
        r104.f196213c.a(r105);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return new a(this, getContext()).j();
    }

    public f(Context r100, g r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
    }
}
