package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/DislikeInfoList;", "Ljava/io/Serializable;", "id", "", "iconHeaderUrl", "", "dislikeReason", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getDislikeReason", "()Ljava/lang/String;", "getIconHeaderUrl", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/ss/android/ugc/aweme/discover/model/DislikeInfoList;", "equals", "", "other", "", "hashCode", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DislikeInfoList implements Serializable {

    @SerializedName("dislike_reason")
    private final String dislikeReason;

    @SerializedName("icon_header_url")
    private final String iconHeaderUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final Integer f450483id;

    public DislikeInfoList() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DislikeInfoList copy$default(DislikeInfoList r100, Integer r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f450483id;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.iconHeaderUrl;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.dislikeReason;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.f450483id;
    }

    public final String component2() {
        return this.iconHeaderUrl;
    }

    public final String component3() {
        return this.dislikeReason;
    }

    public final DislikeInfoList copy(Integer r100, String r101, String r102) {
        return new DislikeInfoList(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DislikeInfoList) == false) goto L12;
        DislikeInfoList r101 = (DislikeInfoList) r100;
        if (Intrinsics.areEqual(this.f450483id, r101.f450483id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.iconHeaderUrl, r101.iconHeaderUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.dislikeReason, r101.dislikeReason) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.f450483id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.iconHeaderUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.dislikeReason;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "DislikeInfoList(id=" + this.f450483id + ", iconHeaderUrl=" + this.iconHeaderUrl + ", dislikeReason=" + this.dislikeReason + ")";
    }

    public final String getDislikeReason() {
        return this.dislikeReason;
    }

    public final String getIconHeaderUrl() {
        return this.iconHeaderUrl;
    }

    public final Integer getId() {
        return this.f450483id;
    }

    public DislikeInfoList(Integer r100, String r101, String r102) {
        this.f450483id = r100;
        this.iconHeaderUrl = r101;
        this.dislikeReason = r102;
    }

    public /* synthetic */ DislikeInfoList(Integer r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
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
