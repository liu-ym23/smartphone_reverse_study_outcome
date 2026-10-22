package com.larus.livetutor.impl.tutor.data.feedback;

import com.alipay.sdk.m.x.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J7\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\tHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/larus/livetutor/impl/tutor/data/feedback/CommonFeedbackModel;", "", "title", "", "subTitle", "entities", "", "Lcom/larus/livetutor/impl/tutor/data/feedback/CommonFeedbackItemEntity;", "feedbackId", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "getSubTitle", "setSubTitle", "getEntities", "()Ljava/util/List;", "setEntities", "(Ljava/util/List;)V", "getFeedbackId", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonFeedbackModel {
    private List<CommonFeedbackItemEntity> entities;
    private final int feedbackId;
    private String subTitle;
    private String title;

    public CommonFeedbackModel() {
        this(null, null, null, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonFeedbackModel copy$default(CommonFeedbackModel r100, String r101, String r102, List r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.subTitle;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.entities;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.feedbackId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final List<CommonFeedbackItemEntity> component3() {
        return this.entities;
    }

    public final int component4() {
        return this.feedbackId;
    }

    public final CommonFeedbackModel copy(String r100, String r101, List<CommonFeedbackItemEntity> r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "subTitle");
        Intrinsics.checkNotNullParameter(r102, "entities");
        return new CommonFeedbackModel(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommonFeedbackModel) == true) goto L8;
        return false;
    L8:
        CommonFeedbackModel r101 = (CommonFeedbackModel) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.entities, r101.entities) == true) goto L18;
        return false;
    L18:
        if (this.feedbackId == r101.feedbackId) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.subTitle.hashCode()) * 31) + this.entities.hashCode()) * 31) + this.feedbackId;
    }

    public String toString() {
        return "CommonFeedbackModel(title=" + this.title + ", subTitle=" + this.subTitle + ", entities=" + this.entities + ", feedbackId=" + this.feedbackId + ')';
    }

    public final List<CommonFeedbackItemEntity> getEntities() {
        return this.entities;
    }

    public final int getFeedbackId() {
        return this.feedbackId;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setEntities(List<CommonFeedbackItemEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entities = r100;
    }

    public final void setSubTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.subTitle = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public CommonFeedbackModel(String r100, String r101, List<CommonFeedbackItemEntity> r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "subTitle");
        Intrinsics.checkNotNullParameter(r102, "entities");
        this.title = r100;
        this.subTitle = r101;
        this.entities = r102;
        this.feedbackId = r103;
    }

    public /* synthetic */ CommonFeedbackModel(String r100, String r101, List r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = new ArrayList();
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
