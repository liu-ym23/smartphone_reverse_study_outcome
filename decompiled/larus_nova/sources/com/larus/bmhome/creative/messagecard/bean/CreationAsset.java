package com.larus.bmhome.creative.messagecard.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.api.creation.UserCreationImage;
import ep8.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/creative/messagecard/bean/CreationAsset;", "Ljava/io/Serializable;", "id", "", "assetType", "", "imageContent", "Lcom/larus/platform/api/creation/UserCreationImage;", "videoContent", "Lcom/larus/bmhome/creative/messagecard/bean/VideoInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/platform/api/creation/UserCreationImage;Lcom/larus/bmhome/creative/messagecard/bean/VideoInfo;)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/platform/api/creation/UserCreationImage;Lcom/larus/bmhome/creative/messagecard/bean/VideoInfo;)Lcom/larus/bmhome/creative/messagecard/bean/CreationAsset;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationAsset implements Serializable {

    @SerializedName("type")
    public final Integer assetType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public final String f310757id;

    @SerializedName("image_content")
    public final UserCreationImage imageContent;

    @SerializedName("video_content")
    public final a videoContent;

    public CreationAsset() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CreationAsset copy$default(CreationAsset r100, String r101, Integer r102, UserCreationImage r103, a r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f310757id;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.assetType;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.imageContent;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.videoContent;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.f310757id;
    }

    public final Integer component2() {
        return this.assetType;
    }

    public final UserCreationImage component3() {
        return this.imageContent;
    }

    public final a component4() {
        return this.videoContent;
    }

    public final CreationAsset copy(String r100, @CreationAssetType Integer r101, UserCreationImage r102, a r103) {
        return new CreationAsset(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationAsset) == true) goto L8;
        return false;
    L8:
        CreationAsset r101 = (CreationAsset) r100;
        if (Intrinsics.areEqual(this.f310757id, r101.f310757id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.assetType, r101.assetType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageContent, r101.imageContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoContent, r101.videoContent) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.f310757id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.assetType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        UserCreationImage r107 = this.imageContent;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        a r110 = this.videoContent;
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
        return "CreationAsset(id=" + this.f310757id + ", assetType=" + this.assetType + ", imageContent=" + this.imageContent + ", videoContent=" + this.videoContent + ')';
    }

    public CreationAsset(String r100, @CreationAssetType Integer r101, UserCreationImage r102, a r103) {
        this.f310757id = r100;
        this.assetType = r101;
        this.imageContent = r102;
        this.videoContent = r103;
    }

    public /* synthetic */ CreationAsset(String r100, Integer r101, UserCreationImage r102, a r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
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
