package com.bytedance.android.shopping.orderlist.search.starter;

import com.bytedance.android.shopping.orderlist.common.utils.o;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\u000fR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/search/starter/OrderSearchResultParams;", "Ljava/io/Serializable;", "sourceBtmToken", "", "schemaParamsMap", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getSchemaParamsMap", "()Ljava/util/Map;", "getSourceBtmToken", "()Ljava/lang/String;", "getChineseKeyword", "getEnterFrom", "getSearchSource", "isHideGul", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderSearchResultParams implements Serializable {
    private final Map<String, String> schemaParamsMap;
    private final String sourceBtmToken;

    /* JADX WARN: Multi-variable type inference failed */
    public OrderSearchResultParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public final String getChineseKeyword() {
        String r0 = this.schemaParamsMap.get("keyword");
        if (r0 == null) goto L6;
        String r1 = o.a(r0);
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final String getEnterFrom() {
        String r0 = this.schemaParamsMap.get(SimilarProductParam.ENTER_FROM);
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String getSearchSource() {
        String r0 = this.schemaParamsMap.get("search_source");
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final boolean isHideGul() {
        String r0 = this.schemaParamsMap.get("hide_guess_you_like");
        if (r0 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r0, "1");
    }

    public final Map<String, String> getSchemaParamsMap() {
        return this.schemaParamsMap;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public OrderSearchResultParams(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "schemaParamsMap");
        this.sourceBtmToken = r2;
        this.schemaParamsMap = r3;
    }

    public /* synthetic */ OrderSearchResultParams(String r1, Map r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = new LinkedHashMap();
    L8:
        this(r1, r2);
    }
}
