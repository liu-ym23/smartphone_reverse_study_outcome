package com.bytedance.android.shopping.store.search.presenter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.widget.flow.FlowLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.home.presenter.ShopSearchBasePresenter;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.bytedance.android.shopping.store.search.activity.ShopSearchResultActivity;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchViewModel;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.facebook.drawee.view.DraweeView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/search/presenter/ShopSearchHotViewPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ShopSearchBasePresenter;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchHotViewPresenter extends ShopSearchBasePresenter {
    public static final /* synthetic */ int l = 0;
    public int f;
    public List<SearchSuggestWord> g;
    public final List<SearchSuggestWord> h;
    public final QLiveData<List<SearchSuggestWord>> i;
    public final QLiveData<Integer> j;
    public FlowLayout k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ShopSearchHotViewPresenter a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ SearchSuggestWord c;

        public b(ShopSearchHotViewPresenter r1, Function1 r2, SearchSuggestWord r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r11) {
            String r12 = this.c.getWord();
            String r0 = "";
            if (r12 != null) goto L5;
            r12 = "";
        L5:
            this.a.E().getSearchParam().setSearchKeyword(r12);
            this.a.E().getSearchParam().setStoreHotSearch(true);
            this.a.E().getSearchParam().putPassThroughParam("is_store_hot_search", Boolean.TRUE);
            this.a.E().getSearchParam().putPassThroughParam("page_name", "ecom_shop_search");
            this.a.E().getSearchParam().setSearchSource("shop_hot_search");
            this.a.E().getSearchParam().setFromSug(false);
            this.a.E().getSearchParam().setHotSearchMethod("shop_search_page");
            ECShopSearchParam r1 = this.a.E().getSearchParam();
            if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() == 2) goto L8;
        L10:
            r1.setHotSearchIconType(r0);
            this.a.S(true, this.c);
            Lazy r2 = ECStoreFoldPhoneHelper.a;
            ECStoreFoldPhoneHelper.f(this.a.D());
            int r3 = ShopSearchResultActivity.m;
            QContext r4 = this.a.u();
            Context r5 = com.bytedance.android.ec.core.utils.l0.c(r4.c());
            if ((r5 instanceof FragmentActivity) == true) goto L13;
            r5 = null;
        L13:
            if (r5 != null) goto L15;
            r5 = r4.a();
        L15:
            ShopSearchResultActivity.a.a(r5, this.a.E().getSearchParam(), 1, BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1.b8121.c369113.d675871_i" + (this.c.getIndex() + 1), PageFinder.via(this.a.y()), null, 4, null), 16);
            this.a.E().getSearchContent().g(r12);
            this.a.E().getPostKeyword().setValue(r12);
            return;
        L8:
            if (this.c.getIcon() == null) goto L10;
            r0 = "hot_search_word_fire";
            goto L10
        }
    }

    static {
    }

    public final void I() {
        Map r0 = qm.a.a;
        qm.a.a("ec_perf_duration_shop_search", "render_start", System.currentTimeMillis());
        View r1 = w().b(2131367515).f();
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        List<SearchSuggestWord> r4 = null;
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 == null) goto L8;
        r3.setMarginStart(com.bytedance.android.shopping.extensions.b.a(16));
        r3.setMarginEnd(com.bytedance.android.shopping.extensions.b.a(16));
    L8:
        r1.requestLayout();
        FrameLayout r5 = (FrameLayout) w().b(2131371373).f();
        if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() != 2) goto L11;
        FlowLayout r6 = new FlowLayout(u().c());
        this.k = r6;
        r6.setMaxLine(3);
        int r7 = ExtensionsKt.a(8);
        int r8 = ExtensionsKt.a(8);
        r6.g = r7;
        r6.f = r8;
        ViewGroup.MarginLayoutParams r9 = new ViewGroup.MarginLayoutParams(-1, -1);
        r9.topMargin = ExtensionsKt.a(8);
        Unit r10 = Unit.INSTANCE;
        r6.setLayoutParams(r9);
        r5.addView(r6);
        this.i.b(ECQuickUtilKt.a(u()), new i(r6, this, r5));
    L12:
        ((LinearLayout) w().b(2131367514).f()).setOnClickListener(new j(this));
        this.j.b(ECQuickUtilKt.a(u()), new k(this));
        if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() == 2) goto L45;
        int r11 = ((k1.l() - (com.bytedance.android.shopping.extensions.b.a(16) * 2)) - com.bytedance.android.shopping.extensions.b.a(16)) / 2;
        Paint r12 = new Paint();
        r12.setTextSize(com.bytedance.android.shopping.extensions.b.a(Float.valueOf(17.0f)));
        List<SearchSuggestWord> r13 = this.g;
        if (r13 == null) goto L45;
        Iterator<T> r14 = r13.iterator();
        int r15 = 0;
    L19:
        if (r14.hasNext() == false) goto L45;
        Object r16 = r14.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        SearchSuggestWord r18 = (SearchSuggestWord) r16;
        String r19 = r18.getWord();
        if (r19 == null) goto L44;
        ECUrlModel r110 = r18.getIcon();
        if (r110 == null) goto L32;
        List r111 = r110.getUrlList();
        if (r111 == null) goto L32;
        if ((!r111.isEmpty()) != true) goto L32;
    L33:
        boolean r112 = true;
    L35:
        if (r112 == false) goto L37;
        int r113 = r11 - com.bytedance.android.shopping.extensions.b.a(18);
    L38:
        r18.setTrimWord(r19);
        int r114 = r19.length();
        int r115 = 5;
    L39:
        if (r115 >= r114) goto L44;
        if (r12.measureText(r19.substring(0, r115)) >= r113) goto L42;
        r115 = r115 + 1;
        goto L39
    L42:
        r18.setTrimWord(r19.substring(0, r115 - 1));
        goto L44
    L37:
        r113 = r11;
    L32:
        if (K(r18) != null) goto L33;
        r112 = false;
    L44:
        r15 = r17;
    L45:
        List<SearchSuggestWord> r20 = this.g;
        if (r20 != null) goto L48;
    L52:
        Map r21 = qm.a.a;
        qm.a.a("ec_perf_duration_shop_search", "render_end", System.currentTimeMillis());
        qm.a.c("ec_perf_duration_shop_search");
        Q();
        return;
    L48:
        if ((!r20.isEmpty()) == false) goto L50;
        r4 = r20;
    L50:
        if (r4 == null) goto L52;
        ((FrameLayout) w().b(2131371130).f()).setVisibility(0);
        this.j.g(Integer.valueOf(O()));
        this.i.g(N());
        goto L52
    L11:
        View r22 = new zm.b(u().c(), com.bytedance.android.shopping.extensions.b.a(16), new ShopSearchHotViewPresenter$initHotWordsContainer$$inlined$apply$lambda$1(this));
        r5.addView(r22);
        this.i.b(ECQuickUtilKt.a(u()), new h(r22));
        goto L12
    }

    public final List<SearchSuggestWord> N() {
        ((ArrayList) this.h).clear();
        List<SearchSuggestWord> r0 = this.g;
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        int r3 = this.f;
        List<SearchSuggestWord> r4 = this.g;
        Intrinsics.checkNotNull(r4);
        if (r3 < r4.size()) goto L16;
        this.f = 0;
    L16:
        if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() != 2) goto L18;
        List<SearchSuggestWord> r5 = this.h;
        List<SearchSuggestWord> r6 = this.g;
        Intrinsics.checkNotNull(r6);
        int r7 = this.f;
        List<SearchSuggestWord> r8 = this.g;
        Intrinsics.checkNotNull(r8);
        ((ArrayList) r5).addAll(r6.subList(r7, r8.size()));
    L19:
        Iterator<T> r9 = this.h.iterator();
    L21:
        if (r9.hasNext() == false) goto L27;
        Object r10 = r9.next();
        int r11 = r1 + 1;
        if (r1 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        ((SearchSuggestWord) r10).setIndex(r1);
        r1 = r11;
        goto L21
    L27:
        return this.h;
    L18:
        List<SearchSuggestWord> r12 = this.h;
        List<SearchSuggestWord> r13 = this.g;
        Intrinsics.checkNotNull(r13);
        int r14 = this.f;
        List<SearchSuggestWord> r15 = this.g;
        Intrinsics.checkNotNull(r15);
        ((ArrayList) r12).addAll(r13.subList(r14, RangesKt.coerceAtMost(r14 + 12, r15.size())));
        this.f += 12;
        goto L19
    L11:
        return this.h;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public final int O() {
        List<SearchSuggestWord> r0 = this.g;
        List<SearchSuggestWord> r1 = r0;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        return 8;
    L13:
        if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() != 2) goto L22;
        int r3 = r0.size();
        FlowLayout r4 = this.k;
        if (r4 == null) goto L17;
        int r5 = r4.getVisibleViewCount();
    L18:
        if (r3 > r5) goto L25;
        return 8;
    L25:
        return 0;
    L17:
        r5 = 0;
        goto L18
    L22:
        if (r0.size() > 12) goto L26;
        return 8;
    L26:
        return 0;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L10
    }

    public ShopSearchHotViewPresenter() {
        this.h = new ArrayList();
        this.i = new QLiveData();
        this.j = new QLiveData();
    }

    public final void Q() {
        E().doEventAction("trending_show", new Pair[]{TuplesKt.to("shop_id", E().getSearchParam().getShopId()), TuplesKt.to("words_num", String.valueOf(com.bytedance.android.shopping.extensions.k.f(Integer.valueOf(((ArrayList) this.h).size())))), TuplesKt.to("words_source", "shop_hot_search"), TuplesKt.to("enter_from", "search_store"), TuplesKt.to("enter_from_second", E().getSearchParam().getEnterFromSecond()), TuplesKt.to("page_name", "ecom_shop_search"), TuplesKt.to("btm_id", new BtmItemBuilder("a1.b8121.c369113.d675871", null, 2, null).withPageFinder(PageFinder.via(y())).obtainEventBtmParams())});
    }

    public static Integer K(SearchSuggestWord r3) {
        String r4 = r3.getWordsType();
        if (r4 == null) goto L5;
        Integer r5 = StringsKt.toIntOrNull(r4);
    L6:
        if (r5 != null) goto L9;
    L11:
        if (r5 != null) goto L14;
    L16:
        if (r5 != null) goto L19;
        return null;
    L19:
        if (r5.intValue() == 17) goto L21;
        return null;
    L21:
        return 2131248298;
    L14:
        if (r5.intValue() != 2) goto L16;
        return 2131248299;
    L9:
        if (r5.intValue() != 1) goto L11;
        return 2131248300;
    L5:
        r5 = null;
        goto L6
    }

    public final void A(QModel r7) {
        th.a.c(u().c(), 2131560957, (ViewGroup) w().b(2131371130).f(), true);
        List<SearchSuggestWord> r8 = E().getSearchParam().getSearchSuggestWords();
        if (r8 != null) goto L5;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new ShopSearchHotViewPresenter$fillHotWordsByRequest$1(this, null), 3, null);
        return;
    L5:
        this.g = CollectionsKt.toMutableList(r8);
        I();
    }

    public final View G(SearchSuggestWord r14, Function1<? super View, ? extends View> r15) {
        S(false, r14);
        ViewGroup.LayoutParams r3 = null;
        View r1 = LayoutInflater.from(u().c()).inflate(2131560970, null);
        View r2 = (View) r15.invoke(r1);
        DraweeView r5 = (ECDraweeView) r1.findViewById(2131387371);
        r5.setVisibility(0);
        ViewGroup.LayoutParams r4 = r5.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r4 = null;
    L5:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r4;
        if (r6 == null) goto L9;
        r6.setMarginStart(r5.getDp(4));
    L9:
        if (r14.getIcon() == null) goto L11;
        com.bytedance.android.ec.core.imagex.h0.d(r5, r14.getIcon(), E().getImageCallerContext(), null, null, null, null, 120);
    L21:
        r1.setOnClickListener(new b(this, r15, r14));
        if (r2 != null) goto L25;
        return r1;
    L25:
        return r2;
    L11:
        Integer r7 = K(r14);
        if (r7 == null) goto L14;
        r5.setImageResource(r7.intValue());
        wg.a.i(r5, r5.getDp(14));
        goto L21
    L14:
        r5.setVisibility(8);
        ViewGroup.LayoutParams r8 = r5.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r3 = r8;
    L18:
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r3;
        if (r9 == null) goto L21;
        r9.setMarginStart(0);
        goto L21
    }

    public final void S(boolean r8, SearchSuggestWord r9) {
        if (r8 == false) goto L4;
        String r10 = "trending_words_click";
    L5:
        ShopSearchViewModel r0 = E();
        Pair[] r1 = new Pair[11];
        r1[0] = TuplesKt.to("shop_id", E().getSearchParam().getShopId());
        r1[1] = TuplesKt.to("words_num", String.valueOf(com.bytedance.android.shopping.extensions.k.f(Integer.valueOf(((ArrayList) this.h).size()))));
        r1[2] = TuplesKt.to("words_source", "shop_hot_search");
        r1[3] = TuplesKt.to("enter_from", "search_store");
        r1[4] = TuplesKt.to("enter_from_second", E().getSearchParam().getEnterFromSecond());
        r1[5] = TuplesKt.to("page_name", "ecom_shop_search");
        r1[6] = TuplesKt.to("words_position", String.valueOf(r9.getIndex()));
        r1[7] = TuplesKt.to("words_content", r9.getWord());
        r1[8] = TuplesKt.to("group_id", r9.getId());
        if (r9.getIcon() == null) goto L8;
        String r2 = CommentScene.COMMENTSCENE_NO_AWEME;
    L9:
        r1[9] = TuplesKt.to("hot_icon_type", r2);
        r1[10] = TuplesKt.to("btm_id", new BtmItemBuilder("a1.b8121.c369113.d675871_i" + (r9.getIndex() + 1), null, 2, null).withPageFinder(PageFinder.via(y())).obtainEventBtmParams());
        r0.doEventAction(r10, r1);
        return;
    L8:
        r2 = "0";
        goto L9
    L4:
        r10 = "trending_words_show";
        goto L5
    }
}
