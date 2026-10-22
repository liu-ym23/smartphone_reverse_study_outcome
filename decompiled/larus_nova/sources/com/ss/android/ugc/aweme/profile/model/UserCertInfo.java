package com.ss.android.ugc.aweme.profile.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0002\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/profile/model/UserCertInfo;", "Ljava/io/Serializable;", "isBizAccount", "", "labelStyle", "labelText", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLabelStyle", "getLabelText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/ss/android/ugc/aweme/profile/model/UserCertInfo;", "equals", "", "other", "", "hashCode", "toString", "Companion", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class UserCertInfo implements Serializable {
    public static final Companion Companion = null;
    public static final int LABEL_STYLE_BLUE_V = 2;
    public static final int LABEL_STYLE_BLUE_V_BLACK_GOLDEN = 6;
    public static final int LABEL_STYLE_BLUE_V_LINEAR = 5;
    public static final int LABEL_STYLE_NONE = 0;
    public static final int LABEL_STYLE_RED_V = 7;
    public static final int LABEL_STYLE_YELLOW_V = 1;
    public static final int LABEL_STYLE_YELLOW_V_BLACK_GOLDEN = 4;
    public static final int LABEL_STYLE_YELLOW_V_LINEAR = 3;

    @SerializedName("is_biz_account")
    private final Integer isBizAccount;

    @SerializedName("label_style")
    private final Integer labelStyle;

    @SerializedName("label_text")
    private final String labelText;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/aweme/profile/model/UserCertInfo$Companion;", "", "", "LABEL_STYLE_BLUE_V", "I", "LABEL_STYLE_BLUE_V_BLACK_GOLDEN", "LABEL_STYLE_BLUE_V_LINEAR", "LABEL_STYLE_NONE", "LABEL_STYLE_RED_V", "LABEL_STYLE_YELLOW_V", "LABEL_STYLE_YELLOW_V_BLACK_GOLDEN", "LABEL_STYLE_YELLOW_V_LINEAR", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
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

    public UserCertInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ UserCertInfo copy$default(UserCertInfo r100, Integer r101, Integer r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.isBizAccount;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.labelStyle;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.labelText;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.isBizAccount;
    }

    public final Integer component2() {
        return this.labelStyle;
    }

    public final String component3() {
        return this.labelText;
    }

    public final UserCertInfo copy(Integer r100, Integer r101, String r102) {
        return new UserCertInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserCertInfo) == true) goto L8;
        return false;
    L8:
        UserCertInfo r101 = (UserCertInfo) r100;
        if (Intrinsics.areEqual(this.isBizAccount, r101.isBizAccount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.labelStyle, r101.labelStyle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.labelText, r101.labelText) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.isBizAccount;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.labelStyle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.labelText;
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
        return "UserCertInfo(isBizAccount=" + this.isBizAccount + ", labelStyle=" + this.labelStyle + ", labelText=" + this.labelText + ')';
    }

    public final Integer getLabelStyle() {
        return this.labelStyle;
    }

    public final String getLabelText() {
        return this.labelText;
    }

    public final Integer isBizAccount() {
        return this.isBizAccount;
    }

    public UserCertInfo(Integer r100, Integer r101, String r102) {
        this.isBizAccount = r100;
        this.labelStyle = r101;
        this.labelText = r102;
    }

    public /* synthetic */ UserCertInfo(Integer r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
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
