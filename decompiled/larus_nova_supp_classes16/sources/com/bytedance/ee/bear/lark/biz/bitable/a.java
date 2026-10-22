package com.bytedance.ee.bear.lark.biz.bitable;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lc5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends BaseTitleBar.c {
    public final /* synthetic */ BitableHomeActivity k;

    public final void performAction(View r9) {
        PostCard r10 = ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).w2("/search/space_search/activity").j("KEY_SEARCH_BAR_DY", (int) this.k.getResources().getDimension(2131167714)).j("KEY_SEARCH_OBJ_TYPE", 8).l("fixed_filter_type", true).i("module", "lark_workspace_bitable_landing").g(2130772285, 2130772285);
        this.k.getClass();
        r10.a(new ArrayList(CollectionsKt.listOf(new String[]{CommonMoreItemId.COPY_LINK.getId(), CommonMoreItemId.MAKE_COPY.getId(), CommonMoreItemId.DELETE.getId(), "shareV2", "SecretMoreItem"}))).e();
        lc5.f.a r11 = lc5.f.a;
        p r7 = new p("lark_workspace_bitable_landing", "recent", "search", "search_main_view", "recent", "ccm_bitable_workspace_landing_page_click");
        Intrinsics.checkNotNullParameter(r7, "param");
        r11.I(r7);
    }

    public a(Drawable r1, BitableHomeActivity r2) {
        this.k = r2;
        super(r1);
    }
}
