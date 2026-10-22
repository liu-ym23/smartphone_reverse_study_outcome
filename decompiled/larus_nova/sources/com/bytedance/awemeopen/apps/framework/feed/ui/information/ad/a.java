package com.bytedance.awemeopen.apps.framework.feed.ui.information.ad;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<b, c> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l14.c f196016e;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        l14.c r101 = this.f196016e;
        if (r101 == null) goto L7;
        View r102 = r101.createView(getContext());
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new View(getContext());
    }

    public a(Context r100, b r101, c r102, l14.c r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
        this.f196016e = r103;
    }
}
