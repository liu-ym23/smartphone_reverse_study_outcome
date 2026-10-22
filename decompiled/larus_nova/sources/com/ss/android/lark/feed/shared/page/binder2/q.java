package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes35.dex */
public final class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap<FeedActionType, aeb.c> f421375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FeedActionType f421376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UIFeedCard f421377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ aeb.a f421378d;

    public q(LinkedHashMap<FeedActionType, aeb.c> r100, FeedActionType r101, UIFeedCard r102, aeb.a r103) {
        this.f421375a = r100;
        this.f421376b = r101;
        this.f421377c = r102;
        this.f421378d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        aeb.c r101 = this.f421375a.get(this.f421376b);
        if (r101 == null) goto L8;
        aeb.d r102 = r101.m();
        if (r102 == null) goto L9;
        r102.o(this.f421377c, FeedActionEvent.LEFT_SWIPE, this.f421378d);
        return;
    L9:
        return;
    }
}
