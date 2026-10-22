package com.ss.android.ugc.aweme.poi.model.feed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/model/feed/TagRateSurveyFreqLimitInfo;", "Ljava/io/Serializable;", "freqActionType", "", "freqActionName", "", "freqLimitSeconds", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", "getFreqActionName", "()Ljava/lang/String;", "getFreqActionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFreqLimitSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)Lcom/ss/android/ugc/aweme/poi/model/feed/TagRateSurveyFreqLimitInfo;", "equals", "", "other", "", "hashCode", "toString", "Companion", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TagRateSurveyFreqLimitInfo implements Serializable {
    public static final Companion Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("freq_action_name")
    private final String freqActionName;

    @SerializedName("freq_action_type")
    private final Integer freqActionType;

    @SerializedName("freq_limit_seconds")
    private final Long freqLimitSeconds;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/model/feed/TagRateSurveyFreqLimitInfo$Companion;", "", "()V", "serialVersionUID", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public TagRateSurveyFreqLimitInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ TagRateSurveyFreqLimitInfo copy$default(TagRateSurveyFreqLimitInfo r100, Integer r101, String r102, Long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.freqActionType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.freqActionName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.freqLimitSeconds;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.freqActionType;
    }

    public final String component2() {
        return this.freqActionName;
    }

    public final Long component3() {
        return this.freqLimitSeconds;
    }

    public final TagRateSurveyFreqLimitInfo copy(Integer r100, String r101, Long r102) {
        return new TagRateSurveyFreqLimitInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TagRateSurveyFreqLimitInfo) == true) goto L8;
        return false;
    L8:
        TagRateSurveyFreqLimitInfo r101 = (TagRateSurveyFreqLimitInfo) r100;
        if (Intrinsics.areEqual(this.freqActionType, r101.freqActionType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.freqActionName, r101.freqActionName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.freqLimitSeconds, r101.freqLimitSeconds) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.freqActionType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.freqActionName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.freqLimitSeconds;
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
        return "TagRateSurveyFreqLimitInfo(freqActionType=" + this.freqActionType + ", freqActionName=" + this.freqActionName + ", freqLimitSeconds=" + this.freqLimitSeconds + ')';
    }

    public final String getFreqActionName() {
        return this.freqActionName;
    }

    public final Integer getFreqActionType() {
        return this.freqActionType;
    }

    public final Long getFreqLimitSeconds() {
        return this.freqLimitSeconds;
    }

    public TagRateSurveyFreqLimitInfo(Integer r100, String r101, Long r102) {
        this.freqActionType = r100;
        this.freqActionName = r101;
        this.freqLimitSeconds = r102;
    }

    public /* synthetic */ TagRateSurveyFreqLimitInfo(Integer r100, String r101, Long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0L;
    L11:
        this(r100, r101, r102);
    }
}
