package com.bytedance.android.shopping.store.utils;

import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z {
    public static final String c(Object r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.toString();
    }

    public static final Pair<String, String>[] b(Object r2, Object r3) {
        return new Pair[]{TuplesKt.to("shop_id", c(r2)), TuplesKt.to("sec_shop_id", c(r3))};
    }

    public static final Pair<String, String>[] a(Object r7, Object r8, Object r9, Object r10, Object r11, Object r12, Object r13, Object r14, boolean r15, Object r16, Object r17, Pair<String, String>... r18) {
        Intrinsics.checkNotNullParameter(r18, "extraParams");
        String r1 = c(r7);
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        dm.a.a("StoreEventParamsCommonHelper").b("author_id is empty when building store common event params", null);
    L11:
        Pair[] r5 = new Pair[13];
        r5[0] = TuplesKt.to("author_id", r1);
        r5[1] = TuplesKt.to("enter_from", c(r8));
        r5[2] = TuplesKt.to("store_source_page", c(r9));
        r5[3] = TuplesKt.to("store_source_method", c(r10));
        r5[4] = TuplesKt.to("store_group_type", c(r11));
        r5[5] = TuplesKt.to("entrance_location", c(r12));
        r5[6] = TuplesKt.to("page_name", c(r13));
        r5[7] = TuplesKt.to("source_page", c(r13));
        r5[8] = TuplesKt.to("follow_status", c(r14));
        if (r15 == false) goto L14;
        String r2 = CommentScene.COMMENTSCENE_NO_AWEME;
    L15:
        r5[9] = TuplesKt.to("is_enter_preview", r2);
        r5[10] = TuplesKt.to("temp_id", c(r16));
        r5[11] = TuplesKt.to("store_type", c("shop"));
        r5[12] = TuplesKt.to("entrance_info", c(r17));
        List r3 = CollectionsKt.mutableListOf(r5);
        CollectionsKt.addAll(r3, r18);
        Object[] r0 = r3.toArray(new Pair[0]);
        if (r0 == null) goto L20;
        return (Pair[]) r0;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L14:
        r2 = "0";
        goto L15
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r4 = false;
        goto L9
    }
}
