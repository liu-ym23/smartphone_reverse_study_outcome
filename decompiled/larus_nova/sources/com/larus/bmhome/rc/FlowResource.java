package com.larus.bmhome.rc;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.upload.FlowResourceType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/rc/FlowResource;", "", "uri", "", "resourceType", "", "meta", "Lcom/larus/bmhome/rc/FlowResourceMeta;", LocationMonitorConst.IDENTIFIER, "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/rc/FlowResourceMeta;Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "getResourceType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMeta", "()Lcom/larus/bmhome/rc/FlowResourceMeta;", "getIdentifier", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/rc/FlowResourceMeta;Ljava/lang/String;)Lcom/larus/bmhome/rc/FlowResource;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowResource {
    private final transient String identifier;

    @SerializedName("meta")
    private final FlowResourceMeta meta;

    @SerializedName("resource_type")
    private final Integer resourceType;

    @SerializedName("uri")
    private final String uri;

    public FlowResource() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FlowResource copy$default(FlowResource r100, String r101, Integer r102, FlowResourceMeta r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.uri;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.resourceType;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.meta;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.identifier;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.uri;
    }

    public final Integer component2() {
        return this.resourceType;
    }

    public final FlowResourceMeta component3() {
        return this.meta;
    }

    public final String component4() {
        return this.identifier;
    }

    public final FlowResource copy(String r100, Integer r101, FlowResourceMeta r102, String r103) {
        return new FlowResource(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowResource) == true) goto L8;
        return false;
    L8:
        FlowResource r101 = (FlowResource) r100;
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resourceType, r101.resourceType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.meta, r101.meta) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.identifier, r101.identifier) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.uri;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.resourceType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        FlowResourceMeta r107 = this.meta;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.identifier;
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
        return "FlowResource(uri=" + this.uri + ", resourceType=" + this.resourceType + ", meta=" + this.meta + ", identifier=" + this.identifier + ')';
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final FlowResourceMeta getMeta() {
        return this.meta;
    }

    public final Integer getResourceType() {
        return this.resourceType;
    }

    public final String getUri() {
        return this.uri;
    }

    public FlowResource(String r100, Integer r101, FlowResourceMeta r102, String r103) {
        this.uri = r100;
        this.resourceType = r101;
        this.meta = r102;
        this.identifier = r103;
    }

    public /* synthetic */ FlowResource(String r100, Integer r101, FlowResourceMeta r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = Integer.valueOf(FlowResourceType.Unknown.getValue());
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
