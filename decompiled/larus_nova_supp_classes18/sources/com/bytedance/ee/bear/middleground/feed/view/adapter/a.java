package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.AbsBaseBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ AbsBaseBean a;
    public final /* synthetic */ AbsFeedItemBase<AbsBaseBean> b;

    public a(AbsBaseBean r1, AbsFeedItemBase<AbsBaseBean> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        tt5.a.b("AbsFeedItemBase", "onClick()... uid = " + this.a.getUserId());
        this.b.a.invoke(this.a.getUserId());
    }
}
