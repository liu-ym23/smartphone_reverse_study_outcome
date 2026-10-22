package com.bytedance.awemeopen.apps.framework.feed.ui.level1.common;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<com.bytedance.awemeopen.apps.framework.feed.ui.level1.common.a, b> {

    public static final class a extends IWrittenLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f196561c;

        @Override // com.bytedance.awemeopen.writtenlayout.IWrittenLayout
        public final View f() {
            FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-1, -2);
            final c r101 = this.f196561c;
            Function1<LinearLayout, Unit> r102 = new CommonElementView$createView$1$createView$1(r101);
            Intrinsics.checkNotNullParameter(r100, "lparams");
            return o(0, r100, r102);
        }

        public a(c r100, Context r101) {
            this.f196561c = r100;
            super(r101);
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return new a(this, getContext()).j();
    }

    public c(Context r100, com.bytedance.awemeopen.apps.framework.feed.ui.level1.common.a r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
    }
}
