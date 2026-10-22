package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.AbsBaseBean;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsBaseBean f232662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsFeedItemBase<AbsBaseBean> f232663b;

    public a(AbsBaseBean r100, AbsFeedItemBase<AbsBaseBean> r101) {
        this.f232662a = r100;
        this.f232663b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        tt5.a.b("AbsFeedItemBase", "onClick()... uid = " + this.f232662a.getUserId());
        this.f232663b.f232618a.invoke(this.f232662a.getUserId());
    }
}
