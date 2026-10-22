package com.larus.bmhome.chat.bubble.floating.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0004\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/network/ExperienceCommonBizData;", "", "showMessage", "", "isSuccess", "", "failReason", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getShowMessage", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFailReason", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/larus/bmhome/chat/bubble/floating/network/ExperienceCommonBizData;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExperienceCommonBizData {

    @SerializedName("fail_reason")
    private final String failReason;

    @SerializedName("is_success")
    private final Boolean isSuccess;

    @SerializedName("show_message")
    private final String showMessage;

    public ExperienceCommonBizData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ExperienceCommonBizData copy$default(ExperienceCommonBizData r100, String r101, Boolean r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.showMessage;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.isSuccess;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.failReason;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.showMessage;
    }

    public final Boolean component2() {
        return this.isSuccess;
    }

    public final String component3() {
        return this.failReason;
    }

    public final ExperienceCommonBizData copy(String r100, Boolean r101, String r102) {
        return new ExperienceCommonBizData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ExperienceCommonBizData) == true) goto L8;
        return false;
    L8:
        ExperienceCommonBizData r101 = (ExperienceCommonBizData) r100;
        if (Intrinsics.areEqual(this.showMessage, r101.showMessage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isSuccess, r101.isSuccess) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.failReason, r101.failReason) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.showMessage;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isSuccess;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.failReason;
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
        return "ExperienceCommonBizData(showMessage=" + this.showMessage + ", isSuccess=" + this.isSuccess + ", failReason=" + this.failReason + ')';
    }

    public final String getFailReason() {
        return this.failReason;
    }

    public final String getShowMessage() {
        return this.showMessage;
    }

    public final Boolean isSuccess() {
        return this.isSuccess;
    }

    public ExperienceCommonBizData(String r100, Boolean r101, String r102) {
        this.showMessage = r100;
        this.isSuccess = r101;
        this.failReason = r102;
    }

    public /* synthetic */ ExperienceCommonBizData(String r100, Boolean r101, String r102, int r103, DefaultConstructorMarker r104) {
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
