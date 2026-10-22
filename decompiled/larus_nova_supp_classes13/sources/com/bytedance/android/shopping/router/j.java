package com.bytedance.android.shopping.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.searchsimilar.utils.SimilarProductHelper;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements bf.c {
    public j() {
    }

    public final void a() {
    }

    public final String b() {
        return "ec_similar_product";
    }

    public final boolean c(Context r11, Uri r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "uri");
        new SimilarProductHelper().a(r11, r12, r13);
        String r14 = UriProtector.getQueryParameter(r12, SimilarProductParam.AWEME_ID);
        String r0 = "";
        if (r14 != null) goto L5;
        r14 = "";
    L5:
        String r2 = UriProtector.getQueryParameter(r12, "author_id");
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String r15 = UriProtector.getQueryParameter(r12, SimilarProductParam.ENTER_FROM);
        if (r15 == null) goto L13;
        r0 = r15;
    L13:
        if (r14.length() != 0) goto L15;
        boolean r16 = true;
    L17:
        if (r16 == false) goto L20;
        int r17 = com.bytedance.android.ec.core.monitor.d.a;
        com.bytedance.android.ec.core.monitor.d.b(SimilarProductParam.AWEME_ID, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("scene", "ec_similar_product_page"), TuplesKt.to("error_desc", "aweme_id字段为空")}));
    L20:
        if (r2.length() != 0) goto L22;
        boolean r18 = true;
    L23:
        if (r18 == false) goto L26;
        int r19 = com.bytedance.android.ec.core.monitor.d.a;
        com.bytedance.android.ec.core.monitor.d.b("author_id", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("scene", "ec_similar_product_page"), TuplesKt.to("error_desc", "author_id字段为空")}));
    L26:
        if (r0.length() != 0) goto L28;
        boolean r110 = true;
    L29:
        if (r110 == false) goto L31;
        int r111 = com.bytedance.android.ec.core.monitor.d.a;
        com.bytedance.android.ec.core.monitor.d.b(SimilarProductParam.ENTER_FROM, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("scene", "ec_similar_product_page"), TuplesKt.to("error_desc", "enter_from字段为空")}));
    L31:
        return true;
    L28:
        r110 = false;
        goto L29
    L22:
        r18 = false;
        goto L23
    L15:
        r16 = false;
        goto L17
    }
}
