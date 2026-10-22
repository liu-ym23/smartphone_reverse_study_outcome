package com.ss.android.ugc.aweme.poi.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013JD\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/ss/android/ugc/aweme/poi/model/HeadVideoStrict;", "Ljava/io/Serializable;", "hasVideo", "", "entryDesc", "", "avatarList", "", "userCnt", "", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", "getAvatarList", "()Ljava/util/List;", "getEntryDesc", "()Ljava/lang/String;", "getHasVideo", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUserCnt", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)Lcom/ss/android/ugc/aweme/poi/model/HeadVideoStrict;", "equals", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class HeadVideoStrict implements Serializable {

    @SerializedName("avatar_icon_list")
    private final List<String> avatarList;

    @SerializedName("entry_desc")
    private final String entryDesc;

    @SerializedName("has_video")
    private final Boolean hasVideo;

    @SerializedName("user_cnt")
    private final Integer userCnt;

    public HeadVideoStrict() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeadVideoStrict copy$default(HeadVideoStrict r100, Boolean r101, String r102, List r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.hasVideo;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.entryDesc;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.avatarList;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.userCnt;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Boolean component1() {
        return this.hasVideo;
    }

    public final String component2() {
        return this.entryDesc;
    }

    public final List<String> component3() {
        return this.avatarList;
    }

    public final Integer component4() {
        return this.userCnt;
    }

    public final HeadVideoStrict copy(Boolean r100, String r101, List<String> r102, Integer r103) {
        return new HeadVideoStrict(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HeadVideoStrict) == true) goto L8;
        return false;
    L8:
        HeadVideoStrict r101 = (HeadVideoStrict) r100;
        if (Intrinsics.areEqual(this.hasVideo, r101.hasVideo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entryDesc, r101.entryDesc) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarList, r101.avatarList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userCnt, r101.userCnt) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.hasVideo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.entryDesc;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.avatarList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.userCnt;
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
        return "HeadVideoStrict(hasVideo=" + this.hasVideo + ", entryDesc=" + this.entryDesc + ", avatarList=" + this.avatarList + ", userCnt=" + this.userCnt + ')';
    }

    public final List<String> getAvatarList() {
        return this.avatarList;
    }

    public final String getEntryDesc() {
        return this.entryDesc;
    }

    public final Boolean getHasVideo() {
        return this.hasVideo;
    }

    public final Integer getUserCnt() {
        return this.userCnt;
    }

    public HeadVideoStrict(Boolean r100, String r101, List<String> r102, Integer r103) {
        this.hasVideo = r100;
        this.entryDesc = r101;
        this.avatarList = r102;
        this.userCnt = r103;
    }

    public /* synthetic */ HeadVideoStrict(Boolean r100, String r101, List r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
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
