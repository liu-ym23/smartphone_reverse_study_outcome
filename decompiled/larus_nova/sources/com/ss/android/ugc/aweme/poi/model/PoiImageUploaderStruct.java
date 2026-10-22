package com.ss.android.ugc.aweme.poi.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006 "}, d2 = {"Lcom/ss/android/ugc/aweme/poi/model/PoiImageUploaderStruct;", "Ljava/io/Serializable;", "uploaderName", "", "type", "", "avatar", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "uid", "secUid", "(Ljava/lang/String;ILcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "getSecUid", "()Ljava/lang/String;", "getType", "()I", "getUid", "getUploaderName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiImageUploaderStruct implements Serializable {
    public static final Companion Companion = null;
    public static final int UPLOADER_SOURCE_AWEME_USER = 0;
    public static final int UPLOADER_SOURCE_MP = 1;
    public static final int UPLOADER_SOURCE_THIRD_PARTY = 2;

    @SerializedName("avatar_thumb")
    private final PoiImageUrlModel avatar;

    @SerializedName("sec_uid")
    private final String secUid;

    @SerializedName("type")
    private final int type;

    @SerializedName("uid")
    private final String uid;

    @SerializedName("uploader_name")
    private final String uploaderName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/model/PoiImageUploaderStruct$Companion;", "", "()V", "UPLOADER_SOURCE_AWEME_USER", "", "UPLOADER_SOURCE_MP", "UPLOADER_SOURCE_THIRD_PARTY", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
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

    public PoiImageUploaderStruct() {
        this(null, 0, null, null, null, 31, null);
    }

    public static /* synthetic */ PoiImageUploaderStruct copy$default(PoiImageUploaderStruct r100, String r101, int r102, PoiImageUrlModel r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.uploaderName;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.type;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.avatar;
    L11:
        PoiImageUrlModel r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.uid;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.secUid;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.uploaderName;
    }

    public final int component2() {
        return this.type;
    }

    public final PoiImageUrlModel component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.uid;
    }

    public final String component5() {
        return this.secUid;
    }

    public final PoiImageUploaderStruct copy(String r100, int r101, PoiImageUrlModel r110, String r111, String r112) {
        return new PoiImageUploaderStruct(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiImageUploaderStruct) == true) goto L8;
        return false;
    L8:
        PoiImageUploaderStruct r101 = (PoiImageUploaderStruct) r100;
        if (Intrinsics.areEqual(this.uploaderName, r101.uploaderName) == true) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.secUid, r101.secUid) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.uploaderName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.type) * 31;
        PoiImageUrlModel r104 = this.avatar;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.uid;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.secUid;
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
        return "PoiImageUploaderStruct(uploaderName=" + this.uploaderName + ", type=" + this.type + ", avatar=" + this.avatar + ", uid=" + this.uid + ", secUid=" + this.secUid + ')';
    }

    public final PoiImageUrlModel getAvatar() {
        return this.avatar;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUploaderName() {
        return this.uploaderName;
    }

    public PoiImageUploaderStruct(String r100, int r101, PoiImageUrlModel r102, String r103, String r104) {
        this.uploaderName = r100;
        this.type = r101;
        this.avatar = r102;
        this.uid = r103;
        this.secUid = r104;
    }

    public /* synthetic */ PoiImageUploaderStruct(String r100, int r101, PoiImageUrlModel r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        int r105 = 0;
    L11:
        if ((r110 & 4) == 0) goto L13;
        PoiImageUrlModel r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
