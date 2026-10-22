package com.ss.android.lark.chameleonv2.lkapi.storage;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006 "}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$GetStorageRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "storageFileTypeX", "", "spaceTypeX", "userId", "partition", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getStorageFileTypeX", "()Ljava/lang/String;", "getSpaceTypeX", "getUserId", "getPartition", "storageFileType", "Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageFileType;", "getStorageFileType", "()Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageFileType;", "spaceType", "getSpaceType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IStorage$Internal$GetStorageRequest implements NonProguard {
    private final String partition;
    private final String spaceTypeX;
    private final String storageFileTypeX;
    private final String userId;

    public static /* synthetic */ IStorage$Internal$GetStorageRequest copy$default(IStorage$Internal$GetStorageRequest r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.storageFileTypeX;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.spaceTypeX;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.userId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.partition;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.storageFileTypeX;
    }

    public final String component2() {
        return this.spaceTypeX;
    }

    public final String component3() {
        return this.userId;
    }

    public final String component4() {
        return this.partition;
    }

    public final IStorage$Internal$GetStorageRequest copy(@JSONField(name = "storageFileType") String r100, @JSONField(name = "spaceType") String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "storageFileTypeX");
        Intrinsics.checkNotNullParameter(r101, "spaceTypeX");
        Intrinsics.checkNotNullParameter(r102, "userId");
        Intrinsics.checkNotNullParameter(r103, "partition");
        return new IStorage$Internal$GetStorageRequest(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IStorage$Internal$GetStorageRequest) == true) goto L8;
        return false;
    L8:
        IStorage$Internal$GetStorageRequest r101 = (IStorage$Internal$GetStorageRequest) r100;
        if (Intrinsics.areEqual(this.storageFileTypeX, r101.storageFileTypeX) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.spaceTypeX, r101.spaceTypeX) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.partition, r101.partition) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.storageFileTypeX.hashCode() * 31) + this.spaceTypeX.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.partition.hashCode();
    }

    public String toString() {
        return "GetStorageRequest(storageFileTypeX=" + this.storageFileTypeX + ", spaceTypeX=" + this.spaceTypeX + ", userId=" + this.userId + ", partition=" + this.partition + ')';
    }

    public final IStorage$Internal$StorageFileType getSpaceType() {
        IStorage$Internal$StorageFileType.a r100 = IStorage$Internal$StorageFileType.Companion;
        String r101 = this.spaceTypeX;
        r100.getClass();
        return IStorage$Internal$StorageFileType.a.a(r101);
    }

    public final IStorage$Internal$StorageFileType getStorageFileType() {
        IStorage$Internal$StorageFileType.a r100 = IStorage$Internal$StorageFileType.Companion;
        String r101 = this.storageFileTypeX;
        r100.getClass();
        return IStorage$Internal$StorageFileType.a.a(r101);
    }

    public final String getPartition() {
        return this.partition;
    }

    public final String getSpaceTypeX() {
        return this.spaceTypeX;
    }

    public final String getStorageFileTypeX() {
        return this.storageFileTypeX;
    }

    public final String getUserId() {
        return this.userId;
    }

    public IStorage$Internal$GetStorageRequest(@JSONField(name = "storageFileType") String r100, @JSONField(name = "spaceType") String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "storageFileTypeX");
        Intrinsics.checkNotNullParameter(r101, "spaceTypeX");
        Intrinsics.checkNotNullParameter(r102, "userId");
        Intrinsics.checkNotNullParameter(r103, "partition");
        this.storageFileTypeX = r100;
        this.spaceTypeX = r101;
        this.userId = r102;
        this.partition = r103;
    }
}
