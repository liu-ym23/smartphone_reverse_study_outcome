package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/rc/ResourceRegisterRequest;", "", "tenantId", "", "sceneId", "resourceList", "", "Lcom/larus/bmhome/rc/FlowResource;", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getTenantId", "()Ljava/lang/String;", "getSceneId", "getResourceList", "()Ljava/util/List;", "getExtra", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceRegisterRequest {

    @SerializedName("extra")
    private final String extra;

    @SerializedName("resource_list")
    private final List<FlowResource> resourceList;

    @SerializedName("scene_id")
    private final String sceneId;

    @SerializedName("tenant_id")
    private final String tenantId;

    public ResourceRegisterRequest() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResourceRegisterRequest copy$default(ResourceRegisterRequest r100, String r101, String r102, List r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.tenantId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.sceneId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.resourceList;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.extra;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.tenantId;
    }

    public final String component2() {
        return this.sceneId;
    }

    public final List<FlowResource> component3() {
        return this.resourceList;
    }

    public final String component4() {
        return this.extra;
    }

    public final ResourceRegisterRequest copy(String r100, String r101, List<FlowResource> r102, String r103) {
        return new ResourceRegisterRequest(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResourceRegisterRequest) == true) goto L8;
        return false;
    L8:
        ResourceRegisterRequest r101 = (ResourceRegisterRequest) r100;
        if (Intrinsics.areEqual(this.tenantId, r101.tenantId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sceneId, r101.sceneId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.resourceList, r101.resourceList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.tenantId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.sceneId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<FlowResource> r107 = this.resourceList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.extra;
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
        return "ResourceRegisterRequest(tenantId=" + this.tenantId + ", sceneId=" + this.sceneId + ", resourceList=" + this.resourceList + ", extra=" + this.extra + ')';
    }

    public final String getExtra() {
        return this.extra;
    }

    public final List<FlowResource> getResourceList() {
        return this.resourceList;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public ResourceRegisterRequest(String r100, String r101, List<FlowResource> r102, String r103) {
        this.tenantId = r100;
        this.sceneId = r101;
        this.resourceList = r102;
        this.extra = r103;
    }

    public /* synthetic */ ResourceRegisterRequest(String r100, String r101, List r102, String r103, int r104, DefaultConstructorMarker r105) {
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
