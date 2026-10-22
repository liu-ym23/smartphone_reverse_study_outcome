package com.bytedance.ee.bear.middleground.feed.view.apapterv2;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ BaseContent a;
    public final /* synthetic */ BaseFeedItemAdapter<BaseContent> b;

    public a(BaseContent r1, BaseFeedItemAdapter<BaseContent> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (TextUtils.isEmpty(this.a.getUserId()) == true) goto L6;
        this.b.b.invoke(this.a.getUserId());
        return;
    }
}
