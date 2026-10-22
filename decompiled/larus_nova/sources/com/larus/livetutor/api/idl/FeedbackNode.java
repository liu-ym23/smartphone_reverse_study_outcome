package com.larus.livetutor.api.idl;

import com.alipay.sdk.m.x.d;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jn\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016¨\u00062"}, d2 = {"Lcom/larus/livetutor/api/idl/FeedbackNode;", "Ljava/io/Serializable;", "feedbackNodeId", "", "title", "", "evaluateLabelIds", "", "feedbackNodeIds", "subTitle", "feedbackNodeIcon", "selectedFeedbackNodeIcon", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFeedbackNodeId", "()Ljava/lang/Integer;", "setFeedbackNodeId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "getEvaluateLabelIds", "()Ljava/util/List;", "setEvaluateLabelIds", "(Ljava/util/List;)V", "getFeedbackNodeIds", "setFeedbackNodeIds", "getSubTitle", "setSubTitle", "getFeedbackNodeIcon", "setFeedbackNodeIcon", "getSelectedFeedbackNodeIcon", "setSelectedFeedbackNodeIcon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/livetutor/api/idl/FeedbackNode;", "equals", "", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackNode implements Serializable {

    @SerializedName("evaluate_label_ids")
    private List<Integer> evaluateLabelIds;

    @SerializedName("feedback_node_icon")
    private String feedbackNodeIcon;

    @SerializedName("feedback_node_id")
    private Integer feedbackNodeId;

    @SerializedName("feedback_node_ids")
    private List<Integer> feedbackNodeIds;

    @SerializedName("selected_feedback_node_icon")
    private String selectedFeedbackNodeIcon;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private String subTitle;

    @SerializedName("title")
    private String title;

    public FeedbackNode() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedbackNode copy$default(FeedbackNode r100, Integer r101, String r102, List r103, List r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.feedbackNodeId;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.title;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.evaluateLabelIds;
    L11:
        List r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.feedbackNodeIds;
    L14:
        List r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.subTitle;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.feedbackNodeIcon;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.selectedFeedbackNodeIcon;
    L23:
        Integer r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Integer component1() {
        return this.feedbackNodeId;
    }

    public final String component2() {
        return this.title;
    }

    public final List<Integer> component3() {
        return this.evaluateLabelIds;
    }

    public final List<Integer> component4() {
        return this.feedbackNodeIds;
    }

    public final String component5() {
        return this.subTitle;
    }

    public final String component6() {
        return this.feedbackNodeIcon;
    }

    public final String component7() {
        return this.selectedFeedbackNodeIcon;
    }

    public final FeedbackNode copy(Integer r110, String r111, List<Integer> r112, List<Integer> r113, String r114, String r115, String r116) {
        return new FeedbackNode(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeedbackNode) == true) goto L8;
        return false;
    L8:
        FeedbackNode r101 = (FeedbackNode) r100;
        if (Intrinsics.areEqual(this.feedbackNodeId, r101.feedbackNodeId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.evaluateLabelIds, r101.evaluateLabelIds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.feedbackNodeIds, r101.feedbackNodeIds) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.feedbackNodeIcon, r101.feedbackNodeIcon) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.selectedFeedbackNodeIcon, r101.selectedFeedbackNodeIcon) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.feedbackNodeId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<Integer> r107 = this.evaluateLabelIds;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<Integer> r110 = this.feedbackNodeIds;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.subTitle;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.feedbackNodeIcon;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.selectedFeedbackNodeIcon;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "FeedbackNode(feedbackNodeId=" + this.feedbackNodeId + ", title=" + this.title + ", evaluateLabelIds=" + this.evaluateLabelIds + ", feedbackNodeIds=" + this.feedbackNodeIds + ", subTitle=" + this.subTitle + ", feedbackNodeIcon=" + this.feedbackNodeIcon + ", selectedFeedbackNodeIcon=" + this.selectedFeedbackNodeIcon + ')';
    }

    public final List<Integer> getEvaluateLabelIds() {
        return this.evaluateLabelIds;
    }

    public final String getFeedbackNodeIcon() {
        return this.feedbackNodeIcon;
    }

    public final Integer getFeedbackNodeId() {
        return this.feedbackNodeId;
    }

    public final List<Integer> getFeedbackNodeIds() {
        return this.feedbackNodeIds;
    }

    public final String getSelectedFeedbackNodeIcon() {
        return this.selectedFeedbackNodeIcon;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setEvaluateLabelIds(List<Integer> r100) {
        this.evaluateLabelIds = r100;
    }

    public final void setFeedbackNodeIcon(String r100) {
        this.feedbackNodeIcon = r100;
    }

    public final void setFeedbackNodeId(Integer r100) {
        this.feedbackNodeId = r100;
    }

    public final void setFeedbackNodeIds(List<Integer> r100) {
        this.feedbackNodeIds = r100;
    }

    public final void setSelectedFeedbackNodeIcon(String r100) {
        this.selectedFeedbackNodeIcon = r100;
    }

    public final void setSubTitle(String r100) {
        this.subTitle = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public FeedbackNode(Integer r100, String r101, List<Integer> r102, List<Integer> r103, String r104, String r105, String r106) {
        this.feedbackNodeId = r100;
        this.title = r101;
        this.evaluateLabelIds = r102;
        this.feedbackNodeIds = r103;
        this.subTitle = r104;
        this.feedbackNodeIcon = r105;
        this.selectedFeedbackNodeIcon = r106;
    }

    public /* synthetic */ FeedbackNode(Integer r100, String r101, List r102, List r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        Integer r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        List r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        List r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
