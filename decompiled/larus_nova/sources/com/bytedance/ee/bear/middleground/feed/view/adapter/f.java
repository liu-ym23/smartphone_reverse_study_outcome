package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.FeedCommentDetailBean;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedItemComment f232673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f232674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FeedCommentDetailBean f232675c;

    public f(FeedItemComment r100, int r101, FeedCommentDetailBean r102) {
        this.f232673a = r100;
        this.f232674b = r101;
        this.f232675c = r102;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        Function5<View, Integer, String, String, String, Unit> r101 = this.f232673a.f232622d;
        Intrinsics.checkNotNull(r100);
        r101.invoke(r100, Integer.valueOf(this.f232674b), this.f232675c.getMessageId(), this.f232675c.getComment_id(), this.f232675c.getReply_id());
        return true;
    }
}
