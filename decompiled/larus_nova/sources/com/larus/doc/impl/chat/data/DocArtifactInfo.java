package com.larus.doc.impl.chat.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/doc/impl/chat/data/DocArtifactInfo;", "Ljava/io/Serializable;", "artifactMetaId", "", "resourceId", "resourceType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getArtifactMetaId", "()Ljava/lang/String;", "getResourceId", "getResourceType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocArtifactInfo implements Serializable {

    @SerializedName("artifact_meta_id")
    private final String artifactMetaId;

    @SerializedName("resource_id")
    private final String resourceId;

    @SerializedName("resource_type")
    private final int resourceType;

    public DocArtifactInfo() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ DocArtifactInfo copy$default(DocArtifactInfo r100, String r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.artifactMetaId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.resourceId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.resourceType;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.artifactMetaId;
    }

    public final String component2() {
        return this.resourceId;
    }

    public final int component3() {
        return this.resourceType;
    }

    public final DocArtifactInfo copy(String r100, String r101, int r102) {
        return new DocArtifactInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocArtifactInfo) == true) goto L8;
        return false;
    L8:
        DocArtifactInfo r101 = (DocArtifactInfo) r100;
        if (Intrinsics.areEqual(this.artifactMetaId, r101.artifactMetaId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L15;
        return false;
    L15:
        if (this.resourceType == r101.resourceType) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.artifactMetaId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.resourceId;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.resourceType;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DocArtifactInfo(artifactMetaId=" + this.artifactMetaId + ", resourceId=" + this.resourceId + ", resourceType=" + this.resourceType + ')';
    }

    public final String getArtifactMetaId() {
        return this.artifactMetaId;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final int getResourceType() {
        return this.resourceType;
    }

    public DocArtifactInfo(String r100, String r101, int r102) {
        this.artifactMetaId = r100;
        this.resourceId = r101;
        this.resourceType = r102;
    }

    public /* synthetic */ DocArtifactInfo(String r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
