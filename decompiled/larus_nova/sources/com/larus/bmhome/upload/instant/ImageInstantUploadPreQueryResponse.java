package com.larus.bmhome.upload.instant;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/upload/instant/ImageInstantUploadPreQueryResponse;", "", BaseHttpRequestInfo.KEY_HIT, "", "targetUri", "", "targetResourceId", "registerUri", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHit", "()Z", "getTargetUri", "()Ljava/lang/String;", "getTargetResourceId", "getRegisterUri", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageInstantUploadPreQueryResponse {

    @SerializedName(BaseHttpRequestInfo.KEY_HIT)
    private final boolean hit;

    @SerializedName("register_uri")
    private final String registerUri;

    @SerializedName("target_resource_id")
    private final String targetResourceId;

    @SerializedName("target_uri")
    private final String targetUri;

    public ImageInstantUploadPreQueryResponse() {
        this(false, null, null, null, 15, null);
    }

    public static /* synthetic */ ImageInstantUploadPreQueryResponse copy$default(ImageInstantUploadPreQueryResponse r100, boolean r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.hit;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.targetUri;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.targetResourceId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.registerUri;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.hit;
    }

    public final String component2() {
        return this.targetUri;
    }

    public final String component3() {
        return this.targetResourceId;
    }

    public final String component4() {
        return this.registerUri;
    }

    public final ImageInstantUploadPreQueryResponse copy(boolean r100, String r101, String r102, String r103) {
        return new ImageInstantUploadPreQueryResponse(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageInstantUploadPreQueryResponse) == true) goto L8;
        return false;
    L8:
        ImageInstantUploadPreQueryResponse r101 = (ImageInstantUploadPreQueryResponse) r100;
        if (this.hit == r101.hit) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.targetUri, r101.targetUri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.targetResourceId, r101.targetResourceId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.registerUri, r101.registerUri) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.hit == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.targetUri;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.targetResourceId;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.registerUri;
        if (r109 == null) goto L19;
        r103 = r109.hashCode();
    L19:
        return r108 + r103;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "ImageInstantUploadPreQueryResponse(hit=" + this.hit + ", targetUri=" + this.targetUri + ", targetResourceId=" + this.targetResourceId + ", registerUri=" + this.registerUri + ')';
    }

    public final boolean getHit() {
        return this.hit;
    }

    public final String getRegisterUri() {
        return this.registerUri;
    }

    public final String getTargetResourceId() {
        return this.targetResourceId;
    }

    public final String getTargetUri() {
        return this.targetUri;
    }

    public ImageInstantUploadPreQueryResponse(boolean r100, String r101, String r102, String r103) {
        this.hit = r100;
        this.targetUri = r101;
        this.targetResourceId = r102;
        this.registerUri = r103;
    }

    public /* synthetic */ ImageInstantUploadPreQueryResponse(boolean r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
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
