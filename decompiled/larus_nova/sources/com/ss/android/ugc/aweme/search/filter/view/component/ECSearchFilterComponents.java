package com.ss.android.ugc.aweme.search.filter.view.component;

import com.bytedance.android.ec.window.base.search.repository.vo.WindowSearchProductListResponseVO;
import com.ss.android.ugc.aweme.search.filter.ECSearchFilterComponentFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/ECSearchFilterComponents;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchFilterComponents {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, ECSearchFilterComponentFactory> f452994a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECSearchFilterComponents f452995b = null;

    private ECSearchFilterComponents() {
    }

    static {
        f452995b = new ECSearchFilterComponents();
        f452994a = MapsKt.mapOf(new Pair[]{new Pair("c_default", new ECSearchFilterComponents$shopComponents$1()), new Pair("c_default_remix", new ECSearchFilterComponents$shopComponents$2()), new Pair("c_select_board", new ECSearchFilterComponents$shopComponents$3()), new Pair("c_vertical_line", new ECSearchFilterComponents$shopComponents$4()), new Pair("c_dropdown_with_default_select", new ECSearchFilterComponents$shopComponents$5()), new Pair("c_dropdown_without_default_select", new ECSearchFilterComponents$shopComponents$6()), new Pair(WindowSearchProductListResponseVO.COMPONENT_ID_PRICE, new ECSearchFilterComponents$shopComponents$7()), new Pair("c_price_sort_support_counter_select", new ECSearchFilterComponents$shopComponents$8()), new Pair("c_column_switch", new ECSearchFilterComponents$shopComponents$9()), new Pair("c_ecom_ai_entrance", new ECSearchFilterComponents$shopComponents$10()), new Pair("c_dropdown", new ECSearchFilterComponents$shopComponents$11()), new Pair("c_dropdown_no_button", new ECSearchFilterComponents$shopComponents$12()), new Pair("c_dropdown_in_select_board", new ECSearchFilterComponents$shopComponents$13()), new Pair("c_single_text_in_select_board", new ECSearchFilterComponents$shopComponents$14()), new Pair("c_double_text_in_select_board", new ECSearchFilterComponents$shopComponents$15()), new Pair("c_interval_input", new ECSearchFilterComponents$shopComponents$16()), new Pair("c_tab_select", new ECSearchFilterComponents$shopComponents$17()), new Pair("c_location", new ECSearchFilterComponents$shopComponents$18()), new Pair("c_slide_filter", new ECSearchFilterComponents$shopComponents$19()), new Pair("c_slide_sub_filter", new ECSearchFilterComponents$shopComponents$20()), new Pair("c_select_sideslip", new ECSearchFilterComponents$shopComponents$21())});
    }
}
