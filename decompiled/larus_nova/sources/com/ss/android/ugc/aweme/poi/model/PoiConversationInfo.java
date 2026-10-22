package com.ss.android.ugc.aweme.poi.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/model/PoiConversationInfo;", "Ljava/io/Serializable;", "conShortId", "", "avatarUrl", "", "(JLjava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getConShortId", "()J", "setConShortId", "(J)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiConversationInfo implements Serializable {

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("con_short_id")
    private long conShortId;

    public PoiConversationInfo() {
        this(0, null, 3, null);
    }

    public static /* synthetic */ PoiConversationInfo copy$default(PoiConversationInfo r100, long r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.conShortId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.avatarUrl;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.conShortId;
    }

    public final String component2() {
        return this.avatarUrl;
    }

    public final PoiConversationInfo copy(long r100, String r101) {
        return new PoiConversationInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiConversationInfo) == true) goto L8;
        return false;
    L8:
        PoiConversationInfo r101 = (PoiConversationInfo) r100;
        if (this.conShortId == r101.conShortId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatarUrl, r101.avatarUrl) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.conShortId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.avatarUrl;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return r101 + r103;
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    public String toString() {
        return "PoiConversationInfo(conShortId=" + this.conShortId + ", avatarUrl=" + this.avatarUrl + ')';
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final long getConShortId() {
        return this.conShortId;
    }

    public final void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public final void setConShortId(long r100) {
        this.conShortId = r100;
    }

    public PoiConversationInfo(long r100, String r101) {
        this.conShortId = r100;
        this.avatarUrl = r101;
    }

    public /* synthetic */ PoiConversationInfo(long r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
