package com.ss.android.lark.feed.shared.page.binder2;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements aeb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedCommonViewHolder f421352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ seb.b f421353b;

    public e(FeedCommonViewHolder r100, seb.b r101) {
        this.f421352a = r100;
        this.f421353b = r101;
    }

    @Override // aeb.a
    public final void a(UIFeedCard r100, FeedActionType r101, FeedActionStatus r102, FeedActionEvent r103) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r102, "actionStatus");
        Intrinsics.checkNotNullParameter(r103, "event");
        aeb.f r104 = this.f421352a.f421332z;
        if (r104 == null) goto L5;
        r104.b(r101, r102, r100);
    L5:
        seb.b r105 = this.f421353b;
        if (r105 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r102, "actionStatus");
        Intrinsics.checkNotNullParameter(r103, "event");
        r105.f541665a.a(r100, r101, r102, r103);
        return;
    }
}
