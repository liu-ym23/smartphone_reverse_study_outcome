package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.DeleteBean;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedItemDelete f232681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DeleteBean f232682b;

    public j(FeedItemDelete r100, DeleteBean r101) {
        this.f232681a = r100;
        this.f232682b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f232681a.f232636b.invoke(this.f232682b.getMessageId());
    }
}
