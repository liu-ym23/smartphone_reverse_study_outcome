package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/rc/ResourcePrepareUploadData;", "", "serviceId", "", "uploadPathPrefix", "uploadHost", "uploadAuthToken", "Lcom/larus/bmhome/rc/ResourceUploadAuthToken;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/rc/ResourceUploadAuthToken;)V", "getServiceId", "()Ljava/lang/String;", "getUploadPathPrefix", "getUploadHost", "getUploadAuthToken", "()Lcom/larus/bmhome/rc/ResourceUploadAuthToken;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourcePrepareUploadData {

    @SerializedName("service_id")
    private final String serviceId;

    @SerializedName("upload_auth_token")
    private final ResourceUploadAuthToken uploadAuthToken;

    @SerializedName("upload_host")
    private final String uploadHost;

    @SerializedName("upload_path_prefix")
    private final String uploadPathPrefix;

    public ResourcePrepareUploadData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ResourcePrepareUploadData copy$default(ResourcePrepareUploadData r100, String r101, String r102, String r103, ResourceUploadAuthToken r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.serviceId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.uploadPathPrefix;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.uploadHost;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.uploadAuthToken;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.serviceId;
    }

    public final String component2() {
        return this.uploadPathPrefix;
    }

    public final String component3() {
        return this.uploadHost;
    }

    public final ResourceUploadAuthToken component4() {
        return this.uploadAuthToken;
    }

    public final ResourcePrepareUploadData copy(String r100, String r101, String r102, ResourceUploadAuthToken r103) {
        return new ResourcePrepareUploadData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResourcePrepareUploadData) == true) goto L8;
        return false;
    L8:
        ResourcePrepareUploadData r101 = (ResourcePrepareUploadData) r100;
        if (Intrinsics.areEqual(this.serviceId, r101.serviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uploadPathPrefix, r101.uploadPathPrefix) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uploadHost, r101.uploadHost) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uploadAuthToken, r101.uploadAuthToken) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.serviceId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.uploadPathPrefix;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.uploadHost;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ResourceUploadAuthToken r110 = this.uploadAuthToken;
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
        return "ResourcePrepareUploadData(serviceId=" + this.serviceId + ", uploadPathPrefix=" + this.uploadPathPrefix + ", uploadHost=" + this.uploadHost + ", uploadAuthToken=" + this.uploadAuthToken + ')';
    }

    public final String getServiceId() {
        return this.serviceId;
    }

    public final ResourceUploadAuthToken getUploadAuthToken() {
        return this.uploadAuthToken;
    }

    public final String getUploadHost() {
        return this.uploadHost;
    }

    public final String getUploadPathPrefix() {
        return this.uploadPathPrefix;
    }

    public ResourcePrepareUploadData(String r100, String r101, String r102, ResourceUploadAuthToken r103) {
        this.serviceId = r100;
        this.uploadPathPrefix = r101;
        this.uploadHost = r102;
        this.uploadAuthToken = r103;
    }

    public /* synthetic */ ResourcePrepareUploadData(String r100, String r110, String r111, ResourceUploadAuthToken r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r110 = null;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r111 = null;
    L12:
        if ((r113 & 8) == 0) goto L14;
        r112 = new ResourceUploadAuthToken(null, null, null, null, null, 31, null);
    L14:
        this(r100, r110, r111, r112);
    }
}
