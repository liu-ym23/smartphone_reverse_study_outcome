package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b1 extends com.bytedance.android.ec.core.event.a {
    public Integer a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        appendParam("words_source", this.d);
        appendParam("words_position", String.valueOf(this.a));
        appendParam("words_content", this.b);
        appendParam(SimilarProductParam.ENTER_FROM, "search_order_center_product_flow_page");
        appendParam("enter_from_second", this.f);
        appendParam("impr_id", this.c);
        appendParam("group_id", this.e);
        appendParam("from_gid", this.g);
        appendParam("guess_like_item_rank", this.h);
        appendParam("group_result_id", this.i);
    }

    public b1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super(r2);
    }
}
