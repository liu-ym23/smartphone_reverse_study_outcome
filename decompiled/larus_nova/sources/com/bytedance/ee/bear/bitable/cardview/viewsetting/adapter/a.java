package com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter;

import android.view.View;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewSettingSelectFieldListAdapter<SelectFieldViewHolder> f209252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FilterFieldOption f209253b;

    public a(ViewSettingSelectFieldListAdapter<SelectFieldViewHolder> r100, int r101, FilterFieldOption r102) {
        this.f209252a = r100;
        this.f209253b = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ViewSettingSelectFieldListAdapter.b r101 = this.f209252a.f209245c;
        if (r101 == null) goto L6;
        r101.a(this.f209253b.getId());
        return;
    }
}
