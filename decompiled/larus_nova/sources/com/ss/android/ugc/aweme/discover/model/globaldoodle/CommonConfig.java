package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/CommonConfig;", "Ljava/io/Serializable;", "byteSurveyUrl", "", "byteSurvey", "", "(Ljava/lang/String;Z)V", "getByteSurvey", "()Z", "setByteSurvey", "(Z)V", "getByteSurveyUrl", "()Ljava/lang/String;", "setByteSurveyUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CommonConfig implements Serializable {

    @SerializedName("byte_survey")
    private boolean byteSurvey;

    @SerializedName("byte_survey_url")
    private String byteSurveyUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public CommonConfig() {
        String r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CommonConfig copy$default(CommonConfig r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.byteSurveyUrl;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.byteSurvey;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.byteSurveyUrl;
    }

    public final boolean component2() {
        return this.byteSurvey;
    }

    public final CommonConfig copy(String r100, boolean r101) {
        return new CommonConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommonConfig) == true) goto L8;
        return false;
    L8:
        CommonConfig r101 = (CommonConfig) r100;
        if (Intrinsics.areEqual(this.byteSurveyUrl, r101.byteSurveyUrl) == true) goto L12;
        return false;
    L12:
        if (this.byteSurvey == r101.byteSurvey) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.byteSurveyUrl;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.byteSurvey == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CommonConfig(byteSurveyUrl=" + this.byteSurveyUrl + ", byteSurvey=" + this.byteSurvey + ')';
    }

    public final boolean getByteSurvey() {
        return this.byteSurvey;
    }

    public final String getByteSurveyUrl() {
        return this.byteSurveyUrl;
    }

    public final void setByteSurvey(boolean r100) {
        this.byteSurvey = r100;
    }

    public final void setByteSurveyUrl(String r100) {
        this.byteSurveyUrl = r100;
    }

    public CommonConfig(String r100, boolean r101) {
        this.byteSurveyUrl = r100;
        this.byteSurvey = r101;
    }

    public /* synthetic */ CommonConfig(String r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
