package com.larus.livetutor.impl.tutor.data.feedback;

import com.alipay.sdk.m.x.d;
import com.larus.livetutor.api.idl.EvaluateLabel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003JQ\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010,\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0005HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\"\"\u0004\b#\u0010$¨\u00060"}, d2 = {"Lcom/larus/livetutor/impl/tutor/data/feedback/CommonFeedbackItemEntity;", "", "title", "", "feedbackNodeId", "", "commonLabels", "", "Lcom/larus/livetutor/api/idl/EvaluateLabel;", "selectedIds", "style", "Lcom/larus/livetutor/impl/tutor/data/feedback/LabelStyle;", "isNextOptLabel", "", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Lcom/larus/livetutor/impl/tutor/data/feedback/LabelStyle;Z)V", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "getFeedbackNodeId", "()I", "setFeedbackNodeId", "(I)V", "getCommonLabels", "()Ljava/util/List;", "setCommonLabels", "(Ljava/util/List;)V", "getSelectedIds", "setSelectedIds", "getStyle", "()Lcom/larus/livetutor/impl/tutor/data/feedback/LabelStyle;", "setStyle", "(Lcom/larus/livetutor/impl/tutor/data/feedback/LabelStyle;)V", "()Z", "setNextOptLabel", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonFeedbackItemEntity {
    private List<EvaluateLabel> commonLabels;
    private int feedbackNodeId;
    private boolean isNextOptLabel;
    private List<Integer> selectedIds;
    private LabelStyle style;
    private String title;

    public CommonFeedbackItemEntity() {
        this(null, 0, null, null, null, false, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonFeedbackItemEntity copy$default(CommonFeedbackItemEntity r100, String r101, int r102, List r103, List r104, LabelStyle r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.feedbackNodeId;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.commonLabels;
    L11:
        List r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.selectedIds;
    L14:
        List r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.style;
    L17:
        LabelStyle r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.isNextOptLabel;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.feedbackNodeId;
    }

    public final List<EvaluateLabel> component3() {
        return this.commonLabels;
    }

    public final List<Integer> component4() {
        return this.selectedIds;
    }

    public final LabelStyle component5() {
        return this.style;
    }

    public final boolean component6() {
        return this.isNextOptLabel;
    }

    public final CommonFeedbackItemEntity copy(String r100, int r110, List<EvaluateLabel> r111, List<Integer> r112, LabelStyle r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r111, "commonLabels");
        Intrinsics.checkNotNullParameter(r112, "selectedIds");
        Intrinsics.checkNotNullParameter(r113, "style");
        return new CommonFeedbackItemEntity(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommonFeedbackItemEntity) == true) goto L8;
        return false;
    L8:
        CommonFeedbackItemEntity r101 = (CommonFeedbackItemEntity) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (this.feedbackNodeId == r101.feedbackNodeId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.commonLabels, r101.commonLabels) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectedIds, r101.selectedIds) == true) goto L21;
        return false;
    L21:
        if (this.style == r101.style) goto L24;
        return false;
    L24:
        if (this.isNextOptLabel == r101.isNextOptLabel) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((this.title.hashCode() * 31) + this.feedbackNodeId) * 31) + this.commonLabels.hashCode()) * 31) + this.selectedIds.hashCode()) * 31) + this.style.hashCode()) * 31;
        if (this.isNextOptLabel == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "CommonFeedbackItemEntity(title=" + this.title + ", feedbackNodeId=" + this.feedbackNodeId + ", commonLabels=" + this.commonLabels + ", selectedIds=" + this.selectedIds + ", style=" + this.style + ", isNextOptLabel=" + this.isNextOptLabel + ')';
    }

    public final List<EvaluateLabel> getCommonLabels() {
        return this.commonLabels;
    }

    public final int getFeedbackNodeId() {
        return this.feedbackNodeId;
    }

    public final List<Integer> getSelectedIds() {
        return this.selectedIds;
    }

    public final LabelStyle getStyle() {
        return this.style;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isNextOptLabel() {
        return this.isNextOptLabel;
    }

    public final void setCommonLabels(List<EvaluateLabel> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commonLabels = r100;
    }

    public final void setFeedbackNodeId(int r100) {
        this.feedbackNodeId = r100;
    }

    public final void setNextOptLabel(boolean r100) {
        this.isNextOptLabel = r100;
    }

    public final void setSelectedIds(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.selectedIds = r100;
    }

    public final void setStyle(LabelStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.style = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public CommonFeedbackItemEntity(String r100, int r101, List<EvaluateLabel> r102, List<Integer> r103, LabelStyle r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r102, "commonLabels");
        Intrinsics.checkNotNullParameter(r103, "selectedIds");
        Intrinsics.checkNotNullParameter(r104, "style");
        this.title = r100;
        this.feedbackNodeId = r101;
        this.commonLabels = r102;
        this.selectedIds = r103;
        this.style = r104;
        this.isNextOptLabel = r105;
    }

    public /* synthetic */ CommonFeedbackItemEntity(String r100, int r101, List r102, List r103, LabelStyle r104, boolean r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = "";
    L5:
        boolean r105 = false;
        if ((r111 & 2) == 0) goto L8;
        int r113 = 0;
    L10:
        if ((r111 & 4) == 0) goto L12;
        r102 = new ArrayList();
    L12:
        List r106 = r102;
        if ((r111 & 8) == 0) goto L15;
        r103 = new ArrayList();
    L15:
        List r107 = r103;
        if ((r111 & 16) == 0) goto L18;
        r104 = LabelStyle.LABEL_NORMAL;
    L18:
        LabelStyle r108 = r104;
        if ((r111 & 32) != 0) goto L22;
        r105 = r110;
    L22:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L8:
        r113 = r101;
        goto L10
    }
}
