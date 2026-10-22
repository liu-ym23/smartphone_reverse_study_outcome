package com.ss.android.lark.flow.feed.long_click;

import android.view.View;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowFeedMenuUtil.FeedMenuListAdapter f423408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ aeb.d f423409b;

    public f(FlowFeedMenuUtil.FeedMenuListAdapter r100, aeb.d r101) {
        this.f423408a = r100;
        this.f423409b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f423408a.f423395b.invoke();
        aeb.d r101 = this.f423409b;
        UIFeedCard r102 = this.f423408a.f423399f;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedCardData");
        r102 = null;
    L5:
        r101.o(r102, FeedActionEvent.LONG_CLICK, this.f423408a.f423396c);
    }
}
