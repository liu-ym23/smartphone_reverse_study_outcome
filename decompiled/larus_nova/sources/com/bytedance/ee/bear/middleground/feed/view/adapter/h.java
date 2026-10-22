package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.FeedCommentDetailBean;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedItemComment f232678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FeedCommentDetailBean f232679b;

    public h(FeedItemComment r100, FeedCommentDetailBean r101) {
        this.f232678a = r100;
        this.f232679b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function2<String, Boolean, Unit> r101 = this.f232678a.f232623e;
        String r102 = this.f232679b.getMessageId();
        boolean r103 = true;
        if (this.f232679b.getIs_whole() == 1) goto L6;
        r103 = false;
    L6:
        r101.invoke(r102, Boolean.valueOf(r103));
    }
}
