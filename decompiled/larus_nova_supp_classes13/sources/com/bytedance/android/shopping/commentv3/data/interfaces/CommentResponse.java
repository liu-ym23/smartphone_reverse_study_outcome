package com.bytedance.android.shopping.commentv3.data.interfaces;

import com.bytedance.android.ec.model.response.PromotionProductCommentDTO;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductSkuStruct;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R,\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR&\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR\u001e\u00100\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R \u00106\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R \u0010<\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006B"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentResponse;", "Ljava/io/Serializable;", "()V", "commentTitle", "", "getCommentTitle", "()Ljava/lang/String;", "setCommentTitle", "(Ljava/lang/String;)V", "comments", "", "Lcom/bytedance/android/ec/model/response/PromotionProductCommentDTO;", "getComments", "()Ljava/util/List;", "setComments", "(Ljava/util/List;)V", "events", "Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentPageEvents;", "getEvents", "()Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentPageEvents;", "setEvents", "(Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentPageEvents;)V", "global", "", "", "getGlobal", "()Ljava/util/Map;", "setGlobal", "(Ljava/util/Map;)V", "groups", "Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentGroupList;", "getGroups", "()Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentGroupList;", "setGroups", "(Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentGroupList;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "productName", "getProductName", "setProductName", "skuInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductSkuStruct;", "getSkuInfo", "setSkuInfo", "statusCode", "", "getStatusCode", "()I", "setStatusCode", "(I)V", "subTitle", "Lcom/bytedance/android/shopping/commentv3/data/interfaces/SubTitle;", "getSubTitle", "()Lcom/bytedance/android/shopping/commentv3/data/interfaces/SubTitle;", "setSubTitle", "(Lcom/bytedance/android/shopping/commentv3/data/interfaces/SubTitle;)V", "toastData", "Lcom/bytedance/android/shopping/commentv3/data/interfaces/ToastData;", "getToastData", "()Lcom/bytedance/android/shopping/commentv3/data/interfaces/ToastData;", "setToastData", "(Lcom/bytedance/android/shopping/commentv3/data/interfaces/ToastData;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentResponse implements Serializable {

    @SerializedName("comment_title")
    private String commentTitle;

    @SerializedName("comments")
    private List<PromotionProductCommentDTO> comments;

    @SerializedName("events")
    private CommentPageEvents events;

    @SerializedName("global")
    private Map<String, ? extends Object> global;

    @SerializedName("components")
    private CommentGroupList groups;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("product_name")
    private String productName;

    @SerializedName("sku_info")
    private List<PromotionProductSkuStruct> skuInfo;

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("sub_title")
    private SubTitle subTitle;

    @SerializedName("toast_data")
    private ToastData toastData;

    public CommentResponse() {
    }

    public final String getCommentTitle() {
        return this.commentTitle;
    }

    public final List<PromotionProductCommentDTO> getComments() {
        return this.comments;
    }

    public final CommentPageEvents getEvents() {
        return this.events;
    }

    public final Map<String, Object> getGlobal() {
        return this.global;
    }

    public final CommentGroupList getGroups() {
        return this.groups;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final List<PromotionProductSkuStruct> getSkuInfo() {
        return this.skuInfo;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final SubTitle getSubTitle() {
        return this.subTitle;
    }

    public final ToastData getToastData() {
        return this.toastData;
    }

    public final void setCommentTitle(String r1) {
        this.commentTitle = r1;
    }

    public final void setComments(List<PromotionProductCommentDTO> r1) {
        this.comments = r1;
    }

    public final void setEvents(CommentPageEvents r1) {
        this.events = r1;
    }

    public final void setGlobal(Map<String, ? extends Object> r1) {
        this.global = r1;
    }

    public final void setGroups(CommentGroupList r1) {
        this.groups = r1;
    }

    public final void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public final void setProductName(String r1) {
        this.productName = r1;
    }

    public final void setSkuInfo(List<PromotionProductSkuStruct> r1) {
        this.skuInfo = r1;
    }

    public final void setStatusCode(int r1) {
        this.statusCode = r1;
    }

    public final void setSubTitle(SubTitle r1) {
        this.subTitle = r1;
    }

    public final void setToastData(ToastData r1) {
        this.toastData = r1;
    }
}
