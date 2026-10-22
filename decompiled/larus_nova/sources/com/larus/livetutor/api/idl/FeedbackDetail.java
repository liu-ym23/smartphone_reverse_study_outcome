package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/larus/livetutor/api/idl/FeedbackDetail;", "Ljava/io/Serializable;", "levelOneLabel", "", "", "levelTwoLabel", "customFeedback", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getLevelOneLabel", "()Ljava/util/List;", "setLevelOneLabel", "(Ljava/util/List;)V", "getLevelTwoLabel", "setLevelTwoLabel", "getCustomFeedback", "()Ljava/lang/String;", "setCustomFeedback", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackDetail implements Serializable {

    @SerializedName("custom_feedback")
    private String customFeedback;

    @SerializedName("level_one_label")
    private List<Integer> levelOneLabel;

    @SerializedName("level_two_label")
    private List<Integer> levelTwoLabel;

    public FeedbackDetail() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedbackDetail copy$default(FeedbackDetail r100, List r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.levelOneLabel;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.levelTwoLabel;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.customFeedback;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<Integer> component1() {
        return this.levelOneLabel;
    }

    public final List<Integer> component2() {
        return this.levelTwoLabel;
    }

    public final String component3() {
        return this.customFeedback;
    }

    public final FeedbackDetail copy(List<Integer> r100, List<Integer> r101, String r102) {
        return new FeedbackDetail(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeedbackDetail) == true) goto L8;
        return false;
    L8:
        FeedbackDetail r101 = (FeedbackDetail) r100;
        if (Intrinsics.areEqual(this.levelOneLabel, r101.levelOneLabel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.levelTwoLabel, r101.levelTwoLabel) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.customFeedback, r101.customFeedback) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<Integer> r100 = this.levelOneLabel;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Integer> r104 = this.levelTwoLabel;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.customFeedback;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "FeedbackDetail(levelOneLabel=" + this.levelOneLabel + ", levelTwoLabel=" + this.levelTwoLabel + ", customFeedback=" + this.customFeedback + ')';
    }

    public final String getCustomFeedback() {
        return this.customFeedback;
    }

    public final List<Integer> getLevelOneLabel() {
        return this.levelOneLabel;
    }

    public final List<Integer> getLevelTwoLabel() {
        return this.levelTwoLabel;
    }

    public final void setCustomFeedback(String r100) {
        this.customFeedback = r100;
    }

    public final void setLevelOneLabel(List<Integer> r100) {
        this.levelOneLabel = r100;
    }

    public final void setLevelTwoLabel(List<Integer> r100) {
        this.levelTwoLabel = r100;
    }

    public FeedbackDetail(List<Integer> r100, List<Integer> r101, String r102) {
        this.levelOneLabel = r100;
        this.levelTwoLabel = r101;
        this.customFeedback = r102;
    }

    public /* synthetic */ FeedbackDetail(List r100, List r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
