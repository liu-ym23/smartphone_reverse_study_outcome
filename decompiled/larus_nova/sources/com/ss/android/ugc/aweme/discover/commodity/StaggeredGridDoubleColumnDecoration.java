package com.ss.android.ugc.aweme.discover.commodity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.discover.commodity.helper.ECSearchResourceHelper;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/StaggeredGridDoubleColumnDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StaggeredGridDoubleColumnDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f450023i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f450024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f450025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f450026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f450027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f450028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<View, Boolean> f450029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f450030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f450031h;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/StaggeredGridDoubleColumnDecoration$Companion;", "", "", "TAG_VALUE", "Ljava/lang/String;", "TAG_VALUE_FOR_AD_BRAND_SHOP_TOP_CARD", "TAG_VALUE_FOR_MARKETING_BANNER", "TAG_VALUE_FOR_SINGLE_LYNX_CARD", "TAG_VALUE_FOR_SINGLE_NATIVE_CARD", "TAG_VALUE_FOR_TOP_SECTION", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        public static void a(View r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            if (r101 == false) goto L5;
            r100.setTag("need_decoration");
            return;
        L5:
            r100.setTag(null);
        }
    }

    static {
        f450023i = new Companion(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r110, View r210, RecyclerView r211, RecyclerView.State r212) {
        Intrinsics.checkNotNullParameter(r110, "outRect");
        Intrinsics.checkNotNullParameter(r210, "view");
        Intrinsics.checkNotNullParameter(r211, "parent");
        Intrinsics.checkNotNullParameter(r212, "state");
        boolean r100 = true;
        if (CollectionsKt.contains(CollectionsKt.mutableListOf(new String[]{"ecom_order_center", "search_order_center", "search_ecommerce", "search_product_detail", "homepage_mall_feed", UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "homepage_follow", "homepage_hangout_feed", "homepage_fresh", "homepage_life_feed", "homepage_mediumvideo", "homepage_tablive", "search_order_center_tab_shop"}), this.f450031h) == true) goto L10;
        ITradeSearchHostService r101 = TradeSearch.c(TradeSearch.f453393a);
        if (r101 == null) goto L52;
        ITradeSearchHostAppInfo r102 = r101.getITradeSearchHostAppInfo();
        if (r102 == null) goto L52;
        if (r102.isSaas() == true) goto L10;
    L52:
        f450023i.getClass();
        Intrinsics.checkNotNullParameter(r210, "view");
        Logger.a("MarginDebug", "view tag = " + r210.getTag());
        if (Intrinsics.areEqual("need_decoration_for_single_lynx_card", r210.getTag()) == false) goto L60;
        Logger.a("MarginDebug", "singleLynxCardPaddingBottom = " + this.f450028e);
        Integer r103 = this.f450028e;
        if (r103 == null) goto L57;
        r110.bottom = r103.intValue();
        return;
    L57:
        r110.bottom = DimenExtensionsKt.b(3);
        return;
    L60:
        if (this.f450029f.invoke(r210).booleanValue() == true) goto L62;
        return;
    L62:
        ViewGroup.LayoutParams r104 = r210.getLayoutParams();
        if (r104 == null) goto L71;
        if ((((StaggeredGridLayoutManager.LayoutParams) r104).getSpanIndex() % 2) != 0) goto L67;
        r110.left = this.f450026c;
        r110.right = this.f450027d;
    L68:
        r110.top = this.f450024a;
        r110.bottom = this.f450025b;
        return;
    L67:
        r110.left = this.f450027d;
        r110.right = this.f450026c;
        goto L68
    L71:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    L10:
        int r105 = DimenExtensionsKt.b(Float.valueOf(ECSearchResourceHelper.f450039b.a()));
        int r106 = DimenExtensionsKt.b(4);
        f450023i.getClass();
        Intrinsics.checkNotNullParameter(r210, "view");
        if (Intrinsics.areEqual("need_decoration_for_top_section", r210.getTag()) == false) goto L27;
        Object r107 = r210.getTag(R.id.ec_card_ui_grid_left);
        Object r108 = r210.getTag(R.id.ec_card_ui_grid_right);
        if ((r107 instanceof Integer) == true) goto L15;
        r107 = null;
    L15:
        Integer r109 = (Integer) r107;
        if (r109 == null) goto L18;
        int r111 = DimenExtensionsKt.b(r109);
    L19:
        r110.left = r111;
        if ((r108 instanceof Integer) == true) goto L22;
        r108 = null;
    L22:
        Integer r112 = (Integer) r108;
        if (r112 == null) goto L25;
        int r113 = DimenExtensionsKt.b(r112);
    L26:
        r110.right = r113;
        r110.bottom = r105;
    L50:
        if (r100 == false) goto L52;
        return;
    L25:
        r113 = r105;
        goto L26
    L18:
        r111 = r105;
        goto L19
    L27:
        Intrinsics.checkNotNullParameter(r210, "view");
        if (Intrinsics.areEqual("need_decoration_for_marketing_banner", r210.getTag()) == false) goto L30;
        r110.left = 0;
        r110.right = 0;
        r110.bottom = 0;
        goto L50
    L30:
        Intrinsics.checkNotNullParameter(r210, "view");
        if (Intrinsics.areEqual("need_decoration_for_ad_brand_shop_top_card", r210.getTag()) == false) goto L33;
        r110.left = r105;
        r110.right = r105;
        r110.bottom = r105;
        goto L50
    L33:
        Intrinsics.checkNotNullParameter(r210, "view");
        if (Intrinsics.areEqual("need_decoration_for_single_lynx_card", r210.getTag()) == true) goto L39;
        Intrinsics.checkNotNullParameter(r210, "view");
        if (Intrinsics.areEqual("need_decoration_for_single_native_card", r210.getTag()) == true) goto L39;
        r100 = false;
    L39:
        Integer r114 = this.f450030g;
        if (r114 == null) goto L42;
        int r115 = r114.intValue();
    L43:
        r110.left = r115;
        Integer r116 = this.f450030g;
        if (r116 == null) goto L46;
        r105 = r116.intValue();
    L46:
        r110.right = r105;
        Integer r117 = this.f450028e;
        if (r117 == null) goto L49;
        r106 = r117.intValue();
    L49:
        r110.bottom = r106;
        goto L50
    L42:
        r115 = r105;
        goto L43
    }

    public /* synthetic */ StaggeredGridDoubleColumnDecoration(float r110, float r111, float r112, Integer r113, Function1 r114) {
        this(r110, r111, 0.0f, r112, r113, r114, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StaggeredGridDoubleColumnDecoration(float r100, float r101, float r102, float r103, Integer r104, Function1<? super View, Boolean> r105, Integer r106, String r107) {
        Intrinsics.checkNotNullParameter(r105, "needDecoration");
        this.f450028e = r104;
        this.f450029f = r105;
        this.f450030g = r106;
        this.f450031h = r107;
        this.f450024a = DimenExtensionsKt.a(Float.valueOf(r102));
        this.f450025b = DimenExtensionsKt.a(Float.valueOf(r103));
        this.f450026c = DimenExtensionsKt.a(Float.valueOf(r100));
        this.f450027d = DimenExtensionsKt.a(Float.valueOf(r101)) / 2;
    }
}
