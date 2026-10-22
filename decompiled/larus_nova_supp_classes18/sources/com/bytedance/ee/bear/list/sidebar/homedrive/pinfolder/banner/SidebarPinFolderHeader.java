package com.bytedance.ee.bear.list.sidebar.homedrive.pinfolder.banner;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SidebarPinFolderHeader {
    public final Context a;
    public final LifeCycleFragment b;
    public final View c;
    public final ce5.a d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    public final Context getContext() {
        return this.a;
    }

    public SidebarPinFolderHeader(Context r2, LifeCycleFragment r3, View r4, ce5.a r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        Intrinsics.checkNotNullParameter(r5, "userComponentAbility");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = LazyKt.lazy(new SidebarPinFolderHeader$mBannerView$2(this));
        this.f = LazyKt.lazy(new SidebarPinFolderHeader$mBannerModel$2(this));
        this.g = LazyKt.lazy(new SidebarPinFolderHeader$mBannerPresenter$2(this));
    }
}
