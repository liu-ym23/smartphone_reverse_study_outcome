package com.ss.android.ugc.aweme.discover.commodity.marketing.service;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.ugc.aweme.discover.commodity.helper.ILynxOperatePageExecutor;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderItem;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderLine;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectItemStatus;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectListStatus;
import com.ss.android.ugc.aweme.discover.viewmodel.ECSearchEnterViewModel;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.saas.result.ECSearchResultListSaaSVM;
import com.ss.android.ugc.aweme.search.common.utils.JsonExtKt;
import com.ss.android.ugc.aweme.search.common.viewpager.IECPhotoSearchBaseFragment;
import com.ss.android.ugc.aweme.search.common.viewpager.IECSearchBaseFragment;
import com.ss.android.ugc.aweme.search.filter.ECSearchFilterViewModel;
import com.ss.android.ugc.aweme.search.filter.IFilterAbility;
import com.ss.android.ugc.aweme.search.filter.utils.ECSearchSelectStatusHelper;
import com.ss.android.ugc.aweme.search.filter.view.good.GoodFilterUitls;
import com.ss.android.ugc.aweme.search.model.SearchEnterParam;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/service/ECSearchMarketingServiceImpl;", "Lcom/ss/android/ugc/aweme/discover/commodity/marketing/service/ECSearchMarketingService;", "<init>", "()V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchMarketingServiceImpl implements ECSearchMarketingService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Fragment> f450350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f450351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<ILynxOperatePageExecutor> f450352c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/service/ECSearchMarketingServiceImpl$Companion;", "", "()V", "DEBUG_TAG", "", "PASS_THROUGH_KEY", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.marketing.service.ECSearchMarketingService
    public final void release() {
        WeakReference<Fragment> r100 = this.f450350a;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    public ECSearchMarketingServiceImpl() {
        this.f450351b = new JSONObject();
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.marketing.service.ECSearchMarketingService
    public final void a(JSONObject r210) {
        Logger.a("ec_slide_filter", "onBannerFilterSelect");
        boolean r100 = r210.optBoolean("is_select");
        String r101 = r210.optString("data_id");
        JSONObject r102 = r210.optJSONObject("filter_data");
        boolean r103 = r210.optBoolean("is_ban_search", false);
        String r104 = r210.optString("status_path", r101);
        boolean r105 = r210.optBoolean("is_list_item", false);
        boolean r106 = r210.optBoolean("need_keep_head_card", false);
        WeakReference<Fragment> r110 = this.f450350a;
        if (r110 == null) goto L149;
        Fragment r111 = r110.get();
        if (r111 == null) goto L150;
        ECSearchFilterViewModel.Companion.getClass();
        ECSearchFilterViewModel r112 = ECSearchFilterViewModel.Companion.a(r111);
        List<RenderLine> r113 = ECSearchFilterViewModel.Companion.a(r111).getSelectStatusHelper().f452970a;
        String r114 = "";
        if (r113 == null) goto L28;
        Iterator<T> r115 = r113.iterator();
        String r116 = "";
        boolean r117 = false;
    L10:
        if (r115.hasNext() == false) goto L27;
        List<RenderItem> r118 = ((RenderLine) r115.next()).getRenderItemList();
        if (r118 == null) goto L10;
        Iterator<T> r119 = r118.iterator();
    L15:
        if (r119.hasNext() == false) goto L10;
        RenderItem r120 = (RenderItem) r119.next();
        if (Intrinsics.areEqual(r120.getDataId(), r101) == false) goto L15;
        GoodFilterUitls r107 = GoodFilterUitls.f453241a;
        String r121 = r120.getComponentId();
        r107.getClass();
        if (GoodFilterUitls.b(r121) == false) goto L15;
        String r108 = r120.getComponentId();
        if (r108 != null) goto L23;
        r116 = "";
    L24:
        r105 = true;
        r117 = true;
        goto L15
    L23:
        r116 = r108;
        goto L24
    L27:
        r114 = r116;
    L29:
        boolean r211 = r117;
        if (r105 == false) goto L77;
        Intrinsics.checkNotNullParameter(r101, "dataId");
        SelectItemStatus r109 = new SelectListStatus();
        r109.setDataId(r101);
        if (r102 == null) goto L34;
        String r122 = r102.optString("text");
    L35:
        r109.setText(r122);
        if (r102 == null) goto L38;
        String r123 = r102.optString("type");
    L39:
        r109.setType(r123);
        if (r102 == null) goto L42;
        String r124 = r102.optString("log_text");
    L43:
        r109.setLogText(r124);
        if (r102 == null) goto L46;
        String r125 = r102.optString("condition_field");
    L47:
        r109.setConditionField(r125);
        if (r102 == null) goto L50;
        String r126 = r102.optString("condition_value");
    L51:
        r109.setConditionValue(r126);
        if (r102 == null) goto L54;
        String r127 = r102.optString("extra_data");
    L55:
        r109.setExtraData(r127);
        if (r102 == null) goto L60;
        JSONObject r128 = r102.optJSONObject("extra_info");
        if (r128 == null) goto L60;
        Map<String, ? extends Object> r129 = JsonExtKt.b(r128);
    L61:
        r109.setExtraInfo(r129);
        if (r102 == null) goto L66;
        JSONObject r130 = r102.optJSONObject("log_info");
        if (r130 == null) goto L66;
        Map<String, ? extends Object> r131 = JsonExtKt.b(r130);
    L67:
        r109.setLogInfo(r131);
        if (r102 == null) goto L70;
        boolean r132 = r102.has("need_mutex");
    L71:
        if (r132 == false) goto L76;
        if (r102 == null) goto L74;
        String r133 = r102.optString("need_mutex");
    L75:
        r109.setMutex(r133);
        goto L76
    L74:
        r133 = null;
    L76:
        r109.setStatusPath(r101);
        r109.setComponentId(r114);
    L122:
        if (r102 == null) goto L126;
        JSONObject r134 = r102.optJSONObject("log_info");
        if (r134 == null) goto L126;
        Map<String, ? extends Object> r135 = JsonExtKt.b(r134);
    L127:
        ECSearchSelectStatusHelper r136 = r112.getSelectStatusHelper();
        if (r100 == false) goto L130;
        SelectItemStatus r137 = r109;
    L131:
        r136.n(r104, r137, true);
        Logger.a("ec_slide_filter", "券点击 isFromCSlideFilterClick " + r211 + " isSelect " + r100);
        if (r100 == false) goto L134;
        String r138 = "selected";
    L135:
        if (r103 == true) goto L151;
        IFilterAbility r139 = r112.getFilterContainer();
        if (r139 == null) goto L152;
        SearchResultParam r140 = new SearchResultParam();
        r140.getCommodityResultParam().setFilterOption(r109.getLogText());
        r140.getCommodityResultParam().setFilterOptionId(r109.getDataId());
        r140.getCommodityResultParam().setKeepHeadCard(r106);
        r140.getCommodityResultParam().setFilterLogInfo(r135);
        r140.getCommodityResultParam().setIsHidden("0");
        r140.getCommodityResultParam().setTabSearchType(r138);
        r140.setEnterMethod("coupon_banner_search");
        r140.getCommodityResultParam().setIsBannerSearch(true);
        r140.getCommodityResultParam().setIsBannerSelect(r100);
        if (r211 == false) goto L141;
        r112.setHasSideBar(r100);
    L141:
        Unit r141 = Unit.INSTANCE;
        IFilterAbility.DefaultImpls.a(r139, false, false, r140, null, 26);
        return;
    L152:
        return;
    L151:
        return;
    L134:
        r138 = "unchecked";
        goto L135
    L130:
        r137 = null;
    L126:
        r135 = null;
        goto L127
    L70:
        r132 = false;
    L66:
        r131 = null;
    L60:
        r129 = null;
        goto L61
    L54:
        r127 = null;
        goto L55
    L50:
        r126 = null;
        goto L51
    L46:
        r125 = null;
        goto L47
    L42:
        r124 = null;
        goto L43
    L38:
        r123 = null;
        goto L39
    L34:
        r122 = null;
        goto L35
    L77:
        r109 = new SelectItemStatus();
        r109.setDataId(r101);
        if (r102 == null) goto L80;
        String r142 = r102.optString("text");
    L81:
        r109.setText(r142);
        if (r102 == null) goto L84;
        String r143 = r102.optString("type");
    L85:
        r109.setType(r143);
        if (r102 == null) goto L88;
        String r144 = r102.optString("log_text");
    L89:
        r109.setLogText(r144);
        if (r102 == null) goto L92;
        String r145 = r102.optString("condition_field");
    L93:
        r109.setConditionField(r145);
        if (r102 == null) goto L96;
        String r146 = r102.optString("condition_value");
    L97:
        r109.setConditionValue(r146);
        if (r102 == null) goto L100;
        String r147 = r102.optString("extra_data");
    L101:
        r109.setExtraData(r147);
        if (r102 == null) goto L106;
        JSONObject r148 = r102.optJSONObject("extra_info");
        if (r148 == null) goto L106;
        Map<String, ? extends Object> r149 = JsonExtKt.b(r148);
    L107:
        r109.setExtraInfo(r149);
        if (r102 == null) goto L112;
        JSONObject r150 = r102.optJSONObject("log_info");
        if (r150 == null) goto L112;
        Map<String, ? extends Object> r151 = JsonExtKt.b(r150);
    L113:
        r109.setLogInfo(r151);
        if (r102 == null) goto L116;
        boolean r152 = r102.has("need_mutex");
    L117:
        if (r152 == false) goto L122;
        if (r102 == null) goto L120;
        String r153 = r102.optString("need_mutex");
    L121:
        r109.setMutex(r153);
        goto L122
    L120:
        r153 = null;
        goto L121
    L116:
        r152 = false;
    L112:
        r151 = null;
    L106:
        r149 = null;
        goto L107
    L100:
        r147 = null;
        goto L101
    L96:
        r146 = null;
        goto L97
    L92:
        r145 = null;
        goto L93
    L88:
        r144 = null;
        goto L89
    L84:
        r143 = null;
        goto L85
    L80:
        r142 = null;
        goto L81
    L28:
        r117 = false;
        goto L29
    L150:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.ugc.aweme.discover.commodity.marketing.service.ECSearchMarketingService
    public final void b(JSONObject r100) {
        WeakReference<Fragment> r101 = this.f450350a;
        if (r101 == null) goto L43;
        Fragment r102 = r101.get();
        if (r102 == 0) goto L44;
        boolean r103 = false;
        boolean r104 = this.f450351b.optBoolean("from_saas", false);     // Catch: Exception -> L9
    L11:
        if (r104 == true) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L18;
        return;
    L18:
        if (r100 != null) goto L20;
    L22:
        if (r103 == false) goto L24;
        return;
    L24:
        ECSearchEnterViewModel.Companion r106 = ECSearchEnterViewModel.Companion;
        FragmentActivity r107 = r102.getActivity();
        r106.getClass();
        SearchEnterParam r108 = ECSearchEnterViewModel.Companion.c(r107);
        if (r108 != null) goto L27;
        return;
    L27:
        Logger.e("enterParam: " + r108.getExtra());
        String r109 = r108.getExtra();
        Object r110 = null;
        String r111 = null;
        if (r109 != null) goto L33;
        if (r100 == null) goto L31;
        r111 = r100.toString();
    L31:
        r108.setExtra(r111);
        return;
    L33:
        if (r100 == null) goto L35;
        r110 = r100.opt("coupon_industry_pass_through");
    L35:
        JSONObject r112 = new JSONObject(r109);
        Logger.e("enterParam json before: " + r112);
        if (r110 != null) goto L38;
        r112.remove("coupon_industry_pass_through");
    L39:
        Logger.e("enterParam json after: " + r112);
        r108.setExtra(r112.toString());
        return;
    L38:
        r112.put("coupon_industry_pass_through", r110);
        goto L39
    L20:
        if ((r102 instanceof IECPhotoSearchBaseFragment) == false) goto L22;
        ((IECPhotoSearchBaseFragment) r102).gf(r100);
        r103 = true;
        goto L22
    L13:
        if ((r102 instanceof IECSearchBaseFragment) == false) goto L15;
        ((IECSearchBaseFragment) r102).updateSearchParams(r100);
        r105 = true;
    L9:
        r104 = false;
        goto L11
    L44:
        return;
    }

    public final ECSearchMarketingServiceImpl c(Object r100) {
        Intrinsics.checkNotNullParameter("from_saas", "key");
        if (r100 != null) goto L5;
        return this;
    L5:
        this.f450351b.put("from_saas", r100);
        return this;
    }

    public final ECSearchMarketingServiceImpl d(ECSearchResultListSaaSVM r100) {
        if (r100 == null) goto L4;
        this.f450352c = new WeakReference(r100);
    L4:
        return this;
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.marketing.service.ECSearchMarketingService
    public final ECSearchMarketingServiceImpl fragment(Fragment r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        this.f450350a = new WeakReference(r100);
        return this;
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.marketing.service.ECSearchMarketingService
    public final void insertCardByLynx(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Logger.e("insertCardByLynx # MarketingRitServiceImpl");
        WeakReference<ILynxOperatePageExecutor> r101 = this.f450352c;
        if (r101 == null) goto L8;
        ILynxOperatePageExecutor r102 = r101.get();
        if (r102 == null) goto L9;
        r102.insertCardByLynx(r100);
        return;
    L9:
        return;
    }
}
