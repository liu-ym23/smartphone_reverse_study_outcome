package com.larus.office.base.net;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/office/base/net/CurrentVersionInfo;", "", "artifactMetaId", "", "artifactVersionId", "sourceMeta", "Lcom/larus/office/base/net/SourceMeta;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/office/base/net/SourceMeta;)V", "getArtifactMetaId", "()Ljava/lang/String;", "getArtifactVersionId", "getSourceMeta", "()Lcom/larus/office/base/net/SourceMeta;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("artifact_meta_id")
    private final String artifactMetaId;

    @SerializedName("id")
    private final String artifactVersionId;

    @SerializedName("source_meta")
    private final i sourceMeta;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.artifactMetaId, r101.artifactMetaId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.artifactVersionId, r101.artifactVersionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceMeta, r101.sourceMeta) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.artifactMetaId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.artifactVersionId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        i r107 = this.sourceMeta;
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

    public final String toString() {
        return "CurrentVersionInfo(artifactMetaId=" + this.artifactMetaId + ", artifactVersionId=" + this.artifactVersionId + ", sourceMeta=" + this.sourceMeta + ')';
    }

    public c() {
        this.artifactMetaId = null;
        this.artifactVersionId = null;
        this.sourceMeta = null;
    }

    public final String a() {
        return this.artifactVersionId;
    }

    public final i b() {
        return this.sourceMeta;
    }
}
