package com.larus.platform.model.upload;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/platform/model/upload/ResourceUploadTargetMeta;", "Ljava/io/Serializable;", "targetUri", "", "targetResourceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTargetUri", "()Ljava/lang/String;", "getTargetResourceId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceUploadTargetMeta implements Serializable {
    private final String targetResourceId;
    private final String targetUri;

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceUploadTargetMeta() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ResourceUploadTargetMeta copy$default(ResourceUploadTargetMeta r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.targetUri;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.targetResourceId;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.targetUri;
    }

    public final String component2() {
        return this.targetResourceId;
    }

    public final ResourceUploadTargetMeta copy(String r100, String r101) {
        return new ResourceUploadTargetMeta(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResourceUploadTargetMeta) == true) goto L8;
        return false;
    L8:
        ResourceUploadTargetMeta r101 = (ResourceUploadTargetMeta) r100;
        if (Intrinsics.areEqual(this.targetUri, r101.targetUri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.targetResourceId, r101.targetResourceId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.targetUri;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.targetResourceId;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ResourceUploadTargetMeta(targetUri=" + this.targetUri + ", targetResourceId=" + this.targetResourceId + ')';
    }

    public final String getTargetResourceId() {
        return this.targetResourceId;
    }

    public final String getTargetUri() {
        return this.targetUri;
    }

    public ResourceUploadTargetMeta(String r100, String r101) {
        this.targetUri = r100;
        this.targetResourceId = r101;
    }

    public /* synthetic */ ResourceUploadTargetMeta(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
