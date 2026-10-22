package com.bytedance.android.shopping.feed.repository.dto;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/SearchSuggestRequestParams;", "Ljava/io/Serializable;", "", "businessId", "Ljava/lang/String;", "getBusinessId", "()Ljava/lang/String;", "setBusinessId", "(Ljava/lang/String;)V", "pd", "getPd", "setPd", "categoryName", "getCategoryName", "setCategoryName", "wordSource", "getWordSource", "setWordSource", "promotionId", "getPromotionId", "setPromotionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSuggestRequestParams implements Serializable {
    public static final String BUSINESS_ID = "30030";
    public static final String CATEGORY_NAME = "search_product_detail";
    public static final a Companion = null;
    public static final String PD = "search_product_detail";
    public static final String WORD_SOURCE = "search_product_detail";
    private String businessId;
    private String categoryName;
    private String pd;
    private String promotionId;
    private String wordSource;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SearchSuggestRequestParams() {
        this(null, null, null, null, null, 31, null);
    }

    public final String getBusinessId() {
        return this.businessId;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final String getPd() {
        return this.pd;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getWordSource() {
        return this.wordSource;
    }

    public final void setBusinessId(String r1) {
        this.businessId = r1;
    }

    public final void setCategoryName(String r1) {
        this.categoryName = r1;
    }

    public final void setPd(String r1) {
        this.pd = r1;
    }

    public final void setPromotionId(String r1) {
        this.promotionId = r1;
    }

    public final void setWordSource(String r1) {
        this.wordSource = r1;
    }

    public SearchSuggestRequestParams(String r1, String r2, String r3, String r4, String r5) {
        this.businessId = r1;
        this.pd = r2;
        this.categoryName = r3;
        this.wordSource = r4;
        this.promotionId = r5;
    }

    public /* synthetic */ SearchSuggestRequestParams(String r5, String r6, String r7, String r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        String r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
