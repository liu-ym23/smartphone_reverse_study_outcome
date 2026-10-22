package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/model/SaveCollectionResponse;", "", "collectionStatus", "", "collectionId", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getCollectionStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCollectionId", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/platform/model/SaveCollectionResponse;", "equals", "", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SaveCollectionResponse {

    @SerializedName("collection_id")
    private final String collectionId;

    @SerializedName("status")
    private final Integer collectionStatus;

    /* JADX WARN: Multi-variable type inference failed */
    public SaveCollectionResponse() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SaveCollectionResponse copy$default(SaveCollectionResponse r100, Integer r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.collectionStatus;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.collectionId;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.collectionStatus;
    }

    public final String component2() {
        return this.collectionId;
    }

    public final SaveCollectionResponse copy(Integer r100, String r101) {
        return new SaveCollectionResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SaveCollectionResponse) == true) goto L8;
        return false;
    L8:
        SaveCollectionResponse r101 = (SaveCollectionResponse) r100;
        if (Intrinsics.areEqual(this.collectionStatus, r101.collectionStatus) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.collectionId, r101.collectionId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.collectionStatus;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.collectionId;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SaveCollectionResponse(collectionStatus=" + this.collectionStatus + ", collectionId=" + this.collectionId + ')';
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final Integer getCollectionStatus() {
        return this.collectionStatus;
    }

    public SaveCollectionResponse(Integer r100, String r101) {
        this.collectionStatus = r100;
        this.collectionId = r101;
    }

    public /* synthetic */ SaveCollectionResponse(Integer r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
