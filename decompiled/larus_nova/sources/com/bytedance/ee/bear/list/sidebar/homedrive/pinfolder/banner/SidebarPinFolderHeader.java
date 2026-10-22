package com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.banner;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class SidebarPinFolderHeader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f229578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifeCycleFragment f229579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f229580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ce5.a f229581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f229582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f229583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f229584g;

    public final Context getContext() {
        return this.f229578a;
    }

    public SidebarPinFolderHeader(Context r100, LifeCycleFragment r101, View r102, ce5.a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "rootView");
        Intrinsics.checkNotNullParameter(r103, "userComponentAbility");
        this.f229578a = r100;
        this.f229579b = r101;
        this.f229580c = r102;
        this.f229581d = r103;
        this.f229582e = LazyKt.lazy(new SidebarPinFolderHeader$mBannerView$2(this));
        this.f229583f = LazyKt.lazy(new SidebarPinFolderHeader$mBannerModel$2(this));
        this.f229584g = LazyKt.lazy(new SidebarPinFolderHeader$mBannerPresenter$2(this));
    }
}
