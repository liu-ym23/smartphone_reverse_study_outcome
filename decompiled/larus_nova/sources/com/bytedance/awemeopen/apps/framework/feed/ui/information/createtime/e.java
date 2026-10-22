package com.bytedance.awemeopen.apps.framework.feed.ui.information.createtime;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<b, c> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f196065e;

    public static final class a extends IWrittenLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f196066c;

        @Override // com.bytedance.awemeopen.writtenlayout.IWrittenLayout
        public final View f() {
            LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-2, -2);
            Resources r101 = Resources.getSystem();
            r100.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 6, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
            final e r102 = this.f196066c;
            Function1 r103 = new AwemeCreateTimeView$createView$1$createView$2(r102, this);
            Intrinsics.checkNotNullParameter(r100, "lparams");
            return n(r100, r103);
        }

        public a(e r100, Context r101) {
            this.f196066c = r100;
            super(r101);
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        c r100 = (c) this.f195898c;
        Observer<String> r101 = new d(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "observer");
        r100.f196063a.a(r101);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return new a(this, r100.getContext()).j();
    }

    public e(Context r100, b r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
    }
}
