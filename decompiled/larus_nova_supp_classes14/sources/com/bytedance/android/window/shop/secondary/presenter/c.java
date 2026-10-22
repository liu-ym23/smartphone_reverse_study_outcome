package com.bytedance.android.window.shop.secondary.presenter;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ ECWindowSecondaryHeadPresenter a;
    public final /* synthetic */ uq3.c b;

    public c(ECWindowSecondaryHeadPresenter r1, uq3.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        UrlBuilderV2 r0 = new UrlBuilderV2(this.b.c);
        r0.addOrReplaceParam("author_id", ECWindowSecondaryHeadPresenter.D(this.a).getShopParam().getAuthorId());
        r0.addOrReplaceParam("sec_author_id", ECWindowSecondaryHeadPresenter.D(this.a).getShopParam().getSecAuthorId());
        Integer r7 = this.b.d;
        Context r1 = null;
        if (r7 == null) goto L5;
        String r8 = String.valueOf(r7.intValue());
    L6:
        Intrinsics.checkNotNullParameter("0", CommentConstants$CmtLongPanelStrategy.DEFAULT);
        if (r8 != null) goto L9;
        r8 = "0";
    L9:
        r0.addOrReplaceParam("follow_status", r8);
        r0.addOrReplaceParam("entrance_info", String.valueOf(ECWindowSecondaryHeadPresenter.D(this.a).getEntranceInfo()));
        p r9 = p.a;
        QContext r2 = this.a.u();
        Context r3 = l0.c(r2.c());
        if ((r3 instanceof FragmentActivity) == false) goto L13;
        r1 = r3;
    L13:
        if (r1 != null) goto L15;
        r1 = r2.a();
    L15:
        r9.openSchema(r1, r0.build());
        ECWindowSecondaryHeadPresenter.D(this.a).doEventAction("window_secondary_page_click", new Pair[]{TuplesKt.to("click_area", CommentServiceId.HOT_SPOT)});
        return;
    L5:
        r8 = null;
        goto L6
    }
}
