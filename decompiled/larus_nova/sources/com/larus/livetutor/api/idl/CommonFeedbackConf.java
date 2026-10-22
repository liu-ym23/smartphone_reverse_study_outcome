package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003JU\u0010!\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\nHÖ\u0001J\t\u0010'\u001a\u00020\tHÖ\u0001R(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R,\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006("}, d2 = {"Lcom/larus/livetutor/api/idl/CommonFeedbackConf;", "Ljava/io/Serializable;", "evaluateLabels", "", "Lcom/larus/livetutor/api/idl/EvaluateLabel;", "feedbackNodes", "Lcom/larus/livetutor/api/idl/FeedbackNode;", "rootFeedbackNodeMap", "", "", "", "feedbackCardType", "Lcom/larus/livetutor/api/idl/FeedbackCardType;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;Lcom/larus/livetutor/api/idl/FeedbackCardType;)V", "getEvaluateLabels", "()Ljava/util/List;", "setEvaluateLabels", "(Ljava/util/List;)V", "getFeedbackNodes", "setFeedbackNodes", "getRootFeedbackNodeMap", "()Ljava/util/Map;", "setRootFeedbackNodeMap", "(Ljava/util/Map;)V", "getFeedbackCardType", "()Lcom/larus/livetutor/api/idl/FeedbackCardType;", "setFeedbackCardType", "(Lcom/larus/livetutor/api/idl/FeedbackCardType;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonFeedbackConf implements Serializable {

    @SerializedName("evaluate_labels")
    private List<EvaluateLabel> evaluateLabels;

    @SerializedName("feedback_card_type")
    private FeedbackCardType feedbackCardType;

    @SerializedName("feedback_nodes")
    private List<FeedbackNode> feedbackNodes;

    @SerializedName("root_feedback_node_map")
    private Map<String, Integer> rootFeedbackNodeMap;

    public CommonFeedbackConf() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonFeedbackConf copy$default(CommonFeedbackConf r100, List r101, List r102, Map r103, FeedbackCardType r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.evaluateLabels;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.feedbackNodes;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.rootFeedbackNodeMap;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.feedbackCardType;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<EvaluateLabel> component1() {
        return this.evaluateLabels;
    }

    public final List<FeedbackNode> component2() {
        return this.feedbackNodes;
    }

    public final Map<String, Integer> component3() {
        return this.rootFeedbackNodeMap;
    }

    public final FeedbackCardType component4() {
        return this.feedbackCardType;
    }

    public final CommonFeedbackConf copy(List<EvaluateLabel> r100, List<FeedbackNode> r101, Map<String, Integer> r102, FeedbackCardType r103) {
        return new CommonFeedbackConf(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommonFeedbackConf) == true) goto L8;
        return false;
    L8:
        CommonFeedbackConf r101 = (CommonFeedbackConf) r100;
        if (Intrinsics.areEqual(this.evaluateLabels, r101.evaluateLabels) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feedbackNodes, r101.feedbackNodes) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rootFeedbackNodeMap, r101.rootFeedbackNodeMap) == true) goto L18;
        return false;
    L18:
        if (this.feedbackCardType == r101.feedbackCardType) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        List<EvaluateLabel> r100 = this.evaluateLabels;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<FeedbackNode> r104 = this.feedbackNodes;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Integer> r107 = this.rootFeedbackNodeMap;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        FeedbackCardType r110 = this.feedbackCardType;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "CommonFeedbackConf(evaluateLabels=" + this.evaluateLabels + ", feedbackNodes=" + this.feedbackNodes + ", rootFeedbackNodeMap=" + this.rootFeedbackNodeMap + ", feedbackCardType=" + this.feedbackCardType + ')';
    }

    public final List<EvaluateLabel> getEvaluateLabels() {
        return this.evaluateLabels;
    }

    public final FeedbackCardType getFeedbackCardType() {
        return this.feedbackCardType;
    }

    public final List<FeedbackNode> getFeedbackNodes() {
        return this.feedbackNodes;
    }

    public final Map<String, Integer> getRootFeedbackNodeMap() {
        return this.rootFeedbackNodeMap;
    }

    public final void setEvaluateLabels(List<EvaluateLabel> r100) {
        this.evaluateLabels = r100;
    }

    public final void setFeedbackCardType(FeedbackCardType r100) {
        this.feedbackCardType = r100;
    }

    public final void setFeedbackNodes(List<FeedbackNode> r100) {
        this.feedbackNodes = r100;
    }

    public final void setRootFeedbackNodeMap(Map<String, Integer> r100) {
        this.rootFeedbackNodeMap = r100;
    }

    public CommonFeedbackConf(List<EvaluateLabel> r100, List<FeedbackNode> r101, Map<String, Integer> r102, FeedbackCardType r103) {
        this.evaluateLabels = r100;
        this.feedbackNodes = r101;
        this.rootFeedbackNodeMap = r102;
        this.feedbackCardType = r103;
    }

    public /* synthetic */ CommonFeedbackConf(List r100, List r101, Map r102, FeedbackCardType r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
