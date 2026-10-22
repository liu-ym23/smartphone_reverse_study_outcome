package com.bytedance.ee.bear.middleground.feed.view.apapterv2;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.BaseContent;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseContent f232699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseFeedItemAdapter<BaseContent> f232700b;

    public a(BaseContent r100, BaseFeedItemAdapter<BaseContent> r101) {
        this.f232699a = r100;
        this.f232700b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (TextUtils.isEmpty(this.f232699a.getUserId()) == true) goto L6;
        this.f232700b.f232688b.invoke(this.f232699a.getUserId());
        return;
    }
}
