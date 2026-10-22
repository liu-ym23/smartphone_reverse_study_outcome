package com.bytedance.android.window.shop.innerflow.repo;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b(\u0010)R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0086D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001b\u0010\u001d\u001a\u00060\u001bj\u0002`\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\b¨\u0006,"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/repo/ECWindowInnerFlowReqParam;", "Ljava/io/Serializable;", "", "secAuthorId", "Ljava/lang/String;", "getSecAuthorId", "()Ljava/lang/String;", "setSecAuthorId", "(Ljava/lang/String;)V", "", "pageNum", "J", "getPageNum", "()J", "setPageNum", "(J)V", "", "pageSize", "I", "getPageSize", "()I", "customId", "getCustomId", "setCustomId", "promotionId", "getPromotionId", "setPromotionId", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "filterPromotionIds", "Ljava/lang/StringBuilder;", "getFilterPromotionIds", "()Ljava/lang/StringBuilder;", "innerFlowType", "getInnerFlowType", "setInnerFlowType", "(I)V", "passThroughApi", "getPassThroughApi", "setPassThroughApi", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowReqParam implements Serializable {
    public static final a Companion = null;
    private String customId;
    private final StringBuilder filterPromotionIds;
    private int innerFlowType;
    private long pageNum;
    private final int pageSize;
    private String passThroughApi;
    private String promotionId;
    private String secAuthorId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECWindowInnerFlowReqParam() {
        this.secAuthorId = "";
        this.pageSize = 10;
        this.filterPromotionIds = new StringBuilder();
    }

    public final String getCustomId() {
        return this.customId;
    }

    public final StringBuilder getFilterPromotionIds() {
        return this.filterPromotionIds;
    }

    public final int getInnerFlowType() {
        return this.innerFlowType;
    }

    public final long getPageNum() {
        return this.pageNum;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final String getPassThroughApi() {
        return this.passThroughApi;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final void setCustomId(String r1) {
        this.customId = r1;
    }

    public final void setInnerFlowType(int r1) {
        this.innerFlowType = r1;
    }

    public final void setPageNum(long r1) {
        this.pageNum = r1;
    }

    public final void setPassThroughApi(String r1) {
        this.passThroughApi = r1;
    }

    public final void setPromotionId(String r1) {
        this.promotionId = r1;
    }

    public final void setSecAuthorId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.secAuthorId = r2;
    }
}
