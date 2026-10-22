package com.bytedance.ee.bear.more.protocol3.panel;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g0 extends com.bytedance.ee.bear.more.protocol3.k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<ViewGroup, View> f234970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View.OnClickListener f234971f;

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(com.bytedance.ee.bear.more.protocol3.k r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        return false;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        if ((r100 instanceof FrameLayout) == false) goto L6;
        FrameLayout r101 = (FrameLayout) r100;
        r101.removeAllViews();
        r101.addView(this.f234970e.invoke(r100));
        r100.setOnClickListener(this.f234971f);
        return;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final View c(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        FrameLayout r101 = new FrameLayout(r100.getContext());
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r101.addView(this.f234970e.invoke(r100));
        r101.setOnClickListener(this.f234971f);
        return r101;
    }

    public g0(String r100, Function1 r101, CustomMoreItem.b r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "renderer");
        super(r100);
        this.f234970e = r101;
        this.f234971f = r102;
    }
}
