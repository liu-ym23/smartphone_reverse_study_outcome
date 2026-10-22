package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;
import android.view.animation.RotateAnimation;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ ShopSearchHotViewPresenter a;

    public j(ShopSearchHotViewPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        ShopSearchHotViewPresenter r12 = this.a;
        List<SearchSuggestWord> r0 = r12.g;
        r12.getClass();
        List<SearchSuggestWord> r1 = r0;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == false) goto L14;
        return;
    L14:
        SimpleDraweeView r14 = this.a.w().b(2131387413).f();
        RotateAnimation r3 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r3.setDuration(500);
        r14.startAnimation(r3);
        ShopSearchHotViewPresenter r15 = this.a;
        r15.E().doEventAction("search_process_page_change_click", new Pair[]{TuplesKt.to("store_type", "shop"), TuplesKt.to("author_id", r15.E().getSearchParam().getAuthorId()), TuplesKt.to("shop_id", r15.E().getSearchParam().getShopId())});
        this.a.Q();
        return;
    L11:
        r12.i.g(r12.N());
        r13 = false;
        goto L12
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }
}
