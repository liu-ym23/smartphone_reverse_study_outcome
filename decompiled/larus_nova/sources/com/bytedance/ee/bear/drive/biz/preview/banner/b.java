package com.bytedance.ee.bear.drive.biz.preview.banner;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.facade.common.widget.DLPRiskBannerView;
import com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView;
import i75.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f223233a;

    public b(a r100) {
        this.f223233a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        com.bytedance.ee.bear.drive.biz.preview.screen.a r101 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) r100;
        a r102 = this.f223233a;
        boolean r103 = r101.f223712a;
        r102.f223218o = r103;
        r102.g(r103, r101.f223713b);
        a r104 = this.f223233a;
        String r105 = r101.f223713b;
        DLPRiskBannerView r106 = r104.f223211h;
        if (r106 == null) goto L5;
        boolean r107 = h.e(r105);
        ViewGroup.LayoutParams r108 = r106.getLayoutParams();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        r104.d((LinearLayout.LayoutParams) r108, r107, r104.f223218o);
    L5:
        a r109 = this.f223233a;
        String r110 = r101.f223713b;
        ForbiddenBannerView r111 = r109.f223214k;
        if (r111 == null) goto L9;
        boolean r112 = h.e(r110);
        ViewGroup.LayoutParams r113 = r111.getLayoutParams();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        r109.d((LinearLayout.LayoutParams) r113, r112, r109.f223218o);
        return;
    }
}
