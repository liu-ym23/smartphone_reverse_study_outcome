package com.bytedance.awemeopen.apps.framework.feed.ui.information.tag;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<c, d> {

    public static final class a extends IWrittenLayout {
        @Override // com.bytedance.awemeopen.writtenlayout.IWrittenLayout
        public final View f() {
            ViewGroup.MarginLayoutParams r100 = new ViewGroup.MarginLayoutParams(-1, -2);
            r100.setMargins(0, g(6), 0, 0);
            Unit r101 = Unit.INSTANCE;
            Function1 r102 = new TagElementView$createView$1$createView$2(this);
            Intrinsics.checkNotNullParameter(r100, "lparams");
            return o(0, r100, r102);
        }

        public a(Context r100) {
            super(r100);
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return new a(getContext()).j();
    }

    public b(Context r100, c r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
    }
}
