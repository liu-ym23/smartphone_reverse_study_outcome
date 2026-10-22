package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0006\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/bean/UpdateWcbSuggestsRequest;", "", "userId", "", "messageId", "suggests", "isFirstMet", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getMessageId", "setMessageId", "getSuggests", "setSuggests", "()Ljava/lang/Boolean;", "setFirstMet", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/bean/UpdateWcbSuggestsRequest;", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateWcbSuggestsRequest {

    @SerializedName("is_first_met")
    private Boolean isFirstMet;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private String messageId;

    @SerializedName("new_suggests")
    private String suggests;

    @SerializedName("user_id")
    private String userId;

    public UpdateWcbSuggestsRequest() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ UpdateWcbSuggestsRequest copy$default(UpdateWcbSuggestsRequest r100, String r101, String r102, String r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.userId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.messageId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.suggests;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.isFirstMet;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.messageId;
    }

    public final String component3() {
        return this.suggests;
    }

    public final Boolean component4() {
        return this.isFirstMet;
    }

    public final UpdateWcbSuggestsRequest copy(String r100, String r101, String r102, Boolean r103) {
        return new UpdateWcbSuggestsRequest(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UpdateWcbSuggestsRequest) == true) goto L8;
        return false;
    L8:
        UpdateWcbSuggestsRequest r101 = (UpdateWcbSuggestsRequest) r100;
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.suggests, r101.suggests) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isFirstMet, r101.isFirstMet) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.userId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.messageId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.suggests;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isFirstMet;
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
        return "UpdateWcbSuggestsRequest(userId=" + this.userId + ", messageId=" + this.messageId + ", suggests=" + this.suggests + ", isFirstMet=" + this.isFirstMet + ')';
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getSuggests() {
        return this.suggests;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Boolean isFirstMet() {
        return this.isFirstMet;
    }

    public final void setFirstMet(Boolean r100) {
        this.isFirstMet = r100;
    }

    public final void setMessageId(String r100) {
        this.messageId = r100;
    }

    public final void setSuggests(String r100) {
        this.suggests = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }

    public UpdateWcbSuggestsRequest(String r100, String r101, String r102, Boolean r103) {
        this.userId = r100;
        this.messageId = r101;
        this.suggests = r102;
        this.isFirstMet = r103;
    }

    public /* synthetic */ UpdateWcbSuggestsRequest(String r100, String r101, String r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = Boolean.TRUE;
    L14:
        this(r100, r101, r102, r103);
    }
}
