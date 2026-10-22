package com.bytedance.android.shopping.api.mall;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/MallPreloadName;", "", "Companion", "a", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface MallPreloadName {
    public static final a Companion = null;
    public static final String LOAD_SEARCH_CACHE = "load_search_cache";
    public static final String MALL_LYNX_PRELOAD_TEMPLATE = "mall_lynx_preload_template";
    public static final String MALL_LYNX_VIEW_CREATE = "mall_lynx_view_create";
    public static final String MALL_PRE_DECODE = "mall_preload_decode";
    public static final String MALL_STRAIGHT_OUT = "mall_straight_out";
    public static final String PRE_INIT_LYNX_CREATE_SERVICE = "pre_init_lynx_create_view_service";
    public static final String PRE_LOAD_TEMPLATE_TO_RAM = "pre_load_template_to_ram";

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }
}
