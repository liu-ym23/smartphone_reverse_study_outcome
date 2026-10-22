package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\b\u0010\u0013¨\u0006 "}, d2 = {"Lcom/larus/platform/model/CollectionDetail;", "", "referenceId", "", "status", "", "collectionType", "snapshot", "isLike", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "getReferenceId", "()Ljava/lang/String;", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCollectionType", "getSnapshot", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/platform/model/CollectionDetail;", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollectionDetail {

    @SerializedName("collection_type")
    private final Integer collectionType;

    @SerializedName("is_like")
    private final Boolean isLike;

    @SerializedName("reference_id")
    private final String referenceId;

    @SerializedName("snapshot")
    private final String snapshot;

    @SerializedName("status")
    private final Integer status;

    public CollectionDetail() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CollectionDetail copy$default(CollectionDetail r100, String r101, Integer r102, Integer r103, String r104, Boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.referenceId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.status;
    L8:
        Integer r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.collectionType;
    L11:
        Integer r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.snapshot;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.isLike;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.referenceId;
    }

    public final Integer component2() {
        return this.status;
    }

    public final Integer component3() {
        return this.collectionType;
    }

    public final String component4() {
        return this.snapshot;
    }

    public final Boolean component5() {
        return this.isLike;
    }

    public final CollectionDetail copy(String r100, Integer r101, Integer r110, String r111, Boolean r112) {
        return new CollectionDetail(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CollectionDetail) == true) goto L8;
        return false;
    L8:
        CollectionDetail r101 = (CollectionDetail) r100;
        if (Intrinsics.areEqual(this.referenceId, r101.referenceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.collectionType, r101.collectionType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.snapshot, r101.snapshot) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isLike, r101.isLike) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.referenceId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.status;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.collectionType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.snapshot;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isLike;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "CollectionDetail(referenceId=" + this.referenceId + ", status=" + this.status + ", collectionType=" + this.collectionType + ", snapshot=" + this.snapshot + ", isLike=" + this.isLike + ')';
    }

    public final Integer getCollectionType() {
        return this.collectionType;
    }

    public final String getReferenceId() {
        return this.referenceId;
    }

    public final String getSnapshot() {
        return this.snapshot;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Boolean isLike() {
        return this.isLike;
    }

    public CollectionDetail(String r100, Integer r101, Integer r102, String r103, Boolean r104) {
        this.referenceId = r100;
        this.status = r101;
        this.collectionType = r102;
        this.snapshot = r103;
        this.isLike = r104;
    }

    public /* synthetic */ CollectionDetail(String r100, Integer r101, Integer r102, String r103, Boolean r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        Integer r111 = r101;
        if ((r105 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        Integer r106 = r102;
        if ((r105 & 8) == 0) goto L14;
        r103 = null;
    L14:
        String r107 = r103;
        if ((r105 & 16) == 0) goto L17;
        r104 = Boolean.FALSE;
    L17:
        String r108 = r100;
        this(r108, r111, r106, r107, r104);
    }
}
