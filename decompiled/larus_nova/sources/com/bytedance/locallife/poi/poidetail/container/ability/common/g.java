package com.bytedance.locallife.poi.poidetail.container.ability.common;

import com.bytedance.locallife.model.poi.resp.PoiExtension;
import com.bytedance.locallife.model.poi.resp.PoiStruct;
import com.larus.nova.R;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class g {
    public g() {
    }

    public final List<Class<?>> b() {
        return CollectionsKt.listOf(new Class[]{PoiStruct.class, PoiExtension.class});
    }

    public final List<Integer> a() {
        return CollectionsKt.mutableListOf(new Integer[]{Integer.valueOf(R.layout.saas_poi_detail_new_page_header), Integer.valueOf(R.layout.saas_poi_detail_head_bg), Integer.valueOf(R.layout.saas_poi_detail_modal_head), Integer.valueOf(R.layout.saas_poi_component_collect_recommend), Integer.valueOf(R.layout.saas_poi_detail_feeds_status_view), Integer.valueOf(R.layout.saas_poi_shelf_status_view), Integer.valueOf(R.layout.saas_poi_item_exp_collect_share), Integer.valueOf(R.layout.saas_poi_detail_common_tags_layout), Integer.valueOf(R.layout.saas_poi_dito_placeholder), Integer.valueOf(R.layout.saas_poi_detail_head_image), Integer.valueOf(R.layout.saas_poi_detail_navigation_bar)});
    }
}
