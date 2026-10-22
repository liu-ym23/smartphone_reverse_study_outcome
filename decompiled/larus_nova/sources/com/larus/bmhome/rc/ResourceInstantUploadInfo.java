package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/larus/bmhome/rc/ResourceInstantUploadInfo;", "", "preQueryHit", "", "fingerprintMeta", "Lcom/larus/bmhome/rc/ResourceFingerprintMeta;", "targetMeta", "Lcom/larus/bmhome/rc/ResourceTargetMeta;", "registerUri", "", "<init>", "(Ljava/lang/Boolean;Lcom/larus/bmhome/rc/ResourceFingerprintMeta;Lcom/larus/bmhome/rc/ResourceTargetMeta;Ljava/lang/String;)V", "getPreQueryHit", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFingerprintMeta", "()Lcom/larus/bmhome/rc/ResourceFingerprintMeta;", "getTargetMeta", "()Lcom/larus/bmhome/rc/ResourceTargetMeta;", "getRegisterUri", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Lcom/larus/bmhome/rc/ResourceFingerprintMeta;Lcom/larus/bmhome/rc/ResourceTargetMeta;Ljava/lang/String;)Lcom/larus/bmhome/rc/ResourceInstantUploadInfo;", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceInstantUploadInfo {

    @SerializedName("fingerprint_meta")
    private final ResourceFingerprintMeta fingerprintMeta;

    @SerializedName("pre_query_hit")
    private final Boolean preQueryHit;

    @SerializedName("register_uri")
    private final String registerUri;

    @SerializedName("target_meta")
    private final ResourceTargetMeta targetMeta;

    public ResourceInstantUploadInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ResourceInstantUploadInfo copy$default(ResourceInstantUploadInfo r100, Boolean r101, ResourceFingerprintMeta r102, ResourceTargetMeta r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.preQueryHit;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.fingerprintMeta;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.targetMeta;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.registerUri;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Boolean component1() {
        return this.preQueryHit;
    }

    public final ResourceFingerprintMeta component2() {
        return this.fingerprintMeta;
    }

    public final ResourceTargetMeta component3() {
        return this.targetMeta;
    }

    public final String component4() {
        return this.registerUri;
    }

    public final ResourceInstantUploadInfo copy(Boolean r100, ResourceFingerprintMeta r101, ResourceTargetMeta r102, String r103) {
        return new ResourceInstantUploadInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResourceInstantUploadInfo) == true) goto L8;
        return false;
    L8:
        ResourceInstantUploadInfo r101 = (ResourceInstantUploadInfo) r100;
        if (Intrinsics.areEqual(this.preQueryHit, r101.preQueryHit) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fingerprintMeta, r101.fingerprintMeta) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.targetMeta, r101.targetMeta) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.registerUri, r101.registerUri) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.preQueryHit;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ResourceFingerprintMeta r104 = this.fingerprintMeta;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ResourceTargetMeta r107 = this.targetMeta;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.registerUri;
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
        return "ResourceInstantUploadInfo(preQueryHit=" + this.preQueryHit + ", fingerprintMeta=" + this.fingerprintMeta + ", targetMeta=" + this.targetMeta + ", registerUri=" + this.registerUri + ')';
    }

    public final ResourceFingerprintMeta getFingerprintMeta() {
        return this.fingerprintMeta;
    }

    public final Boolean getPreQueryHit() {
        return this.preQueryHit;
    }

    public final String getRegisterUri() {
        return this.registerUri;
    }

    public final ResourceTargetMeta getTargetMeta() {
        return this.targetMeta;
    }

    public ResourceInstantUploadInfo(Boolean r100, ResourceFingerprintMeta r101, ResourceTargetMeta r102, String r103) {
        this.preQueryHit = r100;
        this.fingerprintMeta = r101;
        this.targetMeta = r102;
        this.registerUri = r103;
    }

    public /* synthetic */ ResourceInstantUploadInfo(Boolean r100, ResourceFingerprintMeta r101, ResourceTargetMeta r102, String r103, int r104, DefaultConstructorMarker r105) {
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
