package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.home.entity.ECTopSearchInfo;
import com.bytedance.android.shopping.store.home.view.SearchHotWordFlipperAdapter;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e3 implements View.OnClickListener {
    public final /* synthetic */ ECShopTopBarSearchPresenterV2 a;

    public e3(ECShopTopBarSearchPresenterV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        boolean r0 = true;
        if (ECShopABSettings.getEC_SHOP_SEARCH_HOT_WORD_SCROLL() == 0) goto L5;
        boolean r14 = true;
    L6:
        SearchSuggestWord r2 = null;
        String r3 = "";
        if (r14 == false) goto L18;
        ECShopTopBarSearchPresenterV2 r4 = this.a;
        SearchHotWordFlipperAdapter r5 = r4.z;
        ECViewFlipper r6 = r4.x;
        if (r6 == null) goto L11;
        int r7 = r6.getCurrentPos();
    L12:
        SearchSuggestWord r8 = r5.y2(r7);
        if (r8 == null) goto L15;
        ECUrlModel r9 = r8.getIcon();
    L16:
        if (r9 == null) goto L18;
        String r10 = "hot_search_word_fire";
    L19:
        if (r14 == false) goto L33;
        ECShopTopBarSearchPresenterV2 r15 = this.a;
        SearchHotWordFlipperAdapter r11 = r15.z;
        ECViewFlipper r16 = r15.x;
        if (r16 == null) goto L23;
        int r17 = r16.getCurrentPos();
    L24:
        SearchSuggestWord r18 = r11.y2(r17);
        if (r18 != null) goto L27;
    L43:
        String r12 = r3;
        ECShopTopBarSearchPresenterV2 r19 = this.a;
        Map r20 = MapsKt.mapOf(TuplesKt.to("enter_type", "click_search_btn"));
        Map r110 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("hot_search_method", "shop_product_tab_search_bar"), TuplesKt.to("hot_search_icon_type", r10)});
        if (r12.length() > 0) goto L47;
        r0 = false;
    L47:
        if (r0 == false) goto L49;
        r110.put("search_source", "hint_word_search");
    L49:
        Unit r111 = Unit.INSTANCE;
        ECShopBasePresenter.l0(r19, r12, null, null, r20, r110, 6);
        return;
    L27:
        if ((!r18.isDefaultWord()) == false) goto L29;
        r2 = r18;
    L29:
        if (r2 == null) goto L43;
        String r112 = r2.getWord();
        if (r112 == null) goto L43;
    L42:
        r3 = r112;
        goto L43
    L23:
        r17 = 0;
        goto L24
    L33:
        ECTopSearchInfo r113 = (ECTopSearchInfo) this.a.T().getTopSearchInfo().getValue();
        if (r113 == null) goto L43;
        List<SearchSuggestWord> r114 = r113.getWords();
        if (r114 == null) goto L43;
        SearchSuggestWord r115 = (SearchSuggestWord) CollectionsKt.firstOrNull(r114);
        if (r115 == null) goto L43;
        r112 = r115.getWord();
        if (r112 != null) goto L42;
    L15:
        r9 = null;
        goto L16
    L11:
        r7 = 0;
    L18:
        r10 = "";
        goto L19
    L5:
        r14 = false;
        goto L6
    }
}
