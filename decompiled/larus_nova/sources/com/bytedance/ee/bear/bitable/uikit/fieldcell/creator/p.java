package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.common.widgets.rating.BTRatingBar;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.RatingBarModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class p extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<RatingBarModel> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final sr4.e f216184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BTRatingBar f216185f;

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.RATINGBAR.getValue();
    }

    public p(iv4.b r100) {
        super(r100);
        this.f216184e = new sr4.e(16, 4, null);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void g(List<RatingBarModel> r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        BTRatingBar r102 = this.f216185f;
        if (r102 == null) goto L15;
        h(r102, (RatingBarModel) ListProtector.get(r100, 0));
        return;
    L15:
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public View b(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = c(r100, r101);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.common.widgets.rating.BTRatingBar");
        this.f216185f = (BTRatingBar) r102;
        com.bytedance.ee.bear.bitable.m.f(r102, -1);
        return r102;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = ht4.b.f487130a;
        getType();
        return new CardRatingBar(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final /* bridge */ /* synthetic */ void f(View r100, h0 r101) {
        h(r100, (RatingBarModel) r101);
    }

    public final void h(View r100, RatingBarModel r101) {
        Intrinsics.checkNotNullParameter(r100, "kitView");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if ((r100 instanceof BTRatingBar) == false) goto L24;
        Map<String, com.bytedance.ee.bear.bitable.common.widgets.rating.a.b> r102 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.f210055a;
        if (com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.c(r101.getSymbol()) == false) goto L14;
        ArrayList r103 = new ArrayList();
        int r104 = r101.getMinRate();
        int r105 = r101.getMaxRate();
        if (r104 > r105) goto L13;
    L8:
        Map<String, com.bytedance.ee.bear.bitable.common.widgets.rating.a.b> r106 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.f210055a;
        com.bytedance.ee.bear.bitable.common.widgets.rating.a.c r107 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.b(String.valueOf(r104));
        if (r107 == null) goto L11;
        r103.add(r107);
    L11:
        if (r104 == r105) goto L13;
        r104 = r104 + 1;
    L13:
        BTRatingBar.a r108 = new BTRatingBar.a();
        r108.f210048e = r101.getRate();
        r108.f210047d = Integer.valueOf(r101.getMinRate());
        r108.f210046c = Integer.valueOf(r101.getMaxRate());
        r108.f210052i = true;
        Boolean r109 = Boolean.FALSE;
        r108.f210049f = r109;
        r108.f210053j = r103;
        r108.f210050g = true;
        r108.f210054k = r109;
        r108.f210051h = this.f216184e;
        ((BTRatingBar) r100).setRatingBarInfo(r108);
        return;
    L14:
        com.bytedance.ee.bear.bitable.common.widgets.rating.a.b r110 = com.bytedance.ee.bear.bitable.common.widgets.rating.a.C3021a.a(r101.getSymbol());
        BTRatingBar r111 = (BTRatingBar) r100;
        BTRatingBar.a r112 = new BTRatingBar.a();
        r112.f210048e = r101.getRate();
        r112.f210046c = Integer.valueOf(r101.getMaxRate());
        r112.f210047d = Integer.valueOf(r101.getMinRate());
        Integer r113 = null;
        if (r110 == null) goto L17;
        Integer r114 = Integer.valueOf(r110.f210057a);
    L18:
        r112.f210044a = r114;
        if (r110 == null) goto L21;
        r113 = Integer.valueOf(r110.f210058b);
    L21:
        r112.f210045b = r113;
        r112.f210052i = false;
        Boolean r115 = Boolean.FALSE;
        r112.f210049f = r115;
        r112.f210050g = true;
        r112.f210054k = r115;
        r112.f210051h = this.f216184e;
        r111.setRatingBarInfo(r112);
        return;
    L17:
        r114 = null;
        goto L18
    }
}
