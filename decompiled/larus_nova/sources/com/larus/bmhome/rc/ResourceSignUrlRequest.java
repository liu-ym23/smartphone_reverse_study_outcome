package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ:\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/rc/ResourceSignUrlRequest;", "", "tenantId", "", "resourceIds", "", "mode", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", "getTenantId", "()Ljava/lang/String;", "getResourceIds", "()Ljava/util/List;", "getMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)Lcom/larus/bmhome/rc/ResourceSignUrlRequest;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceSignUrlRequest {

    @SerializedName("mode")
    private final Integer mode;

    @SerializedName(EffectConfiguration.KEY_RESOURCE_IDS)
    private final List<String> resourceIds;

    @SerializedName("tenant_id")
    private final String tenantId;

    public ResourceSignUrlRequest() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResourceSignUrlRequest copy$default(ResourceSignUrlRequest r100, String r101, List r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.tenantId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.resourceIds;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.mode;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.tenantId;
    }

    public final List<String> component2() {
        return this.resourceIds;
    }

    public final Integer component3() {
        return this.mode;
    }

    public final ResourceSignUrlRequest copy(String r100, List<String> r101, Integer r102) {
        return new ResourceSignUrlRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResourceSignUrlRequest) == true) goto L8;
        return false;
    L8:
        ResourceSignUrlRequest r101 = (ResourceSignUrlRequest) r100;
        if (Intrinsics.areEqual(this.tenantId, r101.tenantId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resourceIds, r101.resourceIds) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mode, r101.mode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.tenantId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.resourceIds;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.mode;
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
        return "ResourceSignUrlRequest(tenantId=" + this.tenantId + ", resourceIds=" + this.resourceIds + ", mode=" + this.mode + ')';
    }

    public final Integer getMode() {
        return this.mode;
    }

    public final List<String> getResourceIds() {
        return this.resourceIds;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public ResourceSignUrlRequest(String r100, List<String> r101, Integer r102) {
        this.tenantId = r100;
        this.resourceIds = r101;
        this.mode = r102;
    }

    public /* synthetic */ ResourceSignUrlRequest(String r100, List r101, Integer r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = Integer.valueOf(SignUrlMode.Outer.getValue());
    L11:
        this(r100, r101, r102);
    }
}
