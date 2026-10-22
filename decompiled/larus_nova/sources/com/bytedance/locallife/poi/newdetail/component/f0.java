package com.bytedance.locallife.poi.newdetail.component;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes21.dex */
public final class f0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f263151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PoiRecommendDitoView f263152b;

    public f0(AppCompatImageView r100, PoiRecommendDitoView r101) {
        this.f263151a = r100;
        this.f263152b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.locallife.common.utils.g.a(this.f263151a) == false) goto L5;
        return;
    L5:
        this.f263152b.K.clear();
        PoiRecommendDitoView r101 = this.f263152b;
        r101.getClass();
        r101.post(new i0(r101));
    }
}
