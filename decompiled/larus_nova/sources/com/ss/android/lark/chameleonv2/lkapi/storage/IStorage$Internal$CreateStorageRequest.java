package com.ss.android.lark.chameleonv2.lkapi.storage;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003JY\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$CreateStorageRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "expireSeconds", "", "partition", "", "spaceTypeX", "storageFileTypeX", "userId", "valueMaxKb", "valueMaxPolicyX", "valueTotalMaxKb", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "getExpireSeconds", "()I", "getPartition", "()Ljava/lang/String;", "getSpaceTypeX", "getStorageFileTypeX", "getUserId", "getValueMaxKb", "getValueMaxPolicyX", "getValueTotalMaxKb", "storageFileType", "Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageFileType;", "getStorageFileType", "()Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageFileType;", "spaceType", "getSpaceType", "valueMaxPolicy", "Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$ValueMaxPolicy;", "getValueMaxPolicy", "()Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$ValueMaxPolicy;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IStorage$Internal$CreateStorageRequest implements NonProguard {
    private final int expireSeconds;
    private final String partition;
    private final String spaceTypeX;
    private final String storageFileTypeX;
    private final String userId;
    private final int valueMaxKb;
    private final String valueMaxPolicyX;
    private final int valueTotalMaxKb;

    public static /* synthetic */ IStorage$Internal$CreateStorageRequest copy$default(IStorage$Internal$CreateStorageRequest r100, int r110, String r111, String r112, String r113, String r114, int r115, String r116, int r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        int r101 = r100.expireSeconds;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.partition;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.spaceTypeX;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.storageFileTypeX;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.userId;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r106 = r100.valueMaxKb;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.valueMaxPolicyX;
    L31:
        if ((r118 & 128) == 0) goto L33;
        int r108 = r100.valueTotalMaxKb;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final int component1() {
        return this.expireSeconds;
    }

    public final String component2() {
        return this.partition;
    }

    public final String component3() {
        return this.spaceTypeX;
    }

    public final String component4() {
        return this.storageFileTypeX;
    }

    public final String component5() {
        return this.userId;
    }

    public final int component6() {
        return this.valueMaxKb;
    }

    public final String component7() {
        return this.valueMaxPolicyX;
    }

    public final int component8() {
        return this.valueTotalMaxKb;
    }

    public final IStorage$Internal$CreateStorageRequest copy(int r110, String r111, @JSONField(name = "spaceType") String r112, @JSONField(name = "storageFileType") String r113, String r114, int r115, @JSONField(name = "valueMaxPolicy") String r116, int r117) {
        Intrinsics.checkNotNullParameter(r111, "partition");
        Intrinsics.checkNotNullParameter(r112, "spaceTypeX");
        Intrinsics.checkNotNullParameter(r113, "storageFileTypeX");
        Intrinsics.checkNotNullParameter(r114, "userId");
        Intrinsics.checkNotNullParameter(r116, "valueMaxPolicyX");
        return new IStorage$Internal$CreateStorageRequest(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IStorage$Internal$CreateStorageRequest) == true) goto L8;
        return false;
    L8:
        IStorage$Internal$CreateStorageRequest r101 = (IStorage$Internal$CreateStorageRequest) r100;
        if (this.expireSeconds == r101.expireSeconds) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.partition, r101.partition) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.spaceTypeX, r101.spaceTypeX) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.storageFileTypeX, r101.storageFileTypeX) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L24;
        return false;
    L24:
        if (this.valueMaxKb == r101.valueMaxKb) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.valueMaxPolicyX, r101.valueMaxPolicyX) == true) goto L30;
        return false;
    L30:
        if (this.valueTotalMaxKb == r101.valueTotalMaxKb) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((this.expireSeconds * 31) + this.partition.hashCode()) * 31) + this.spaceTypeX.hashCode()) * 31) + this.storageFileTypeX.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.valueMaxKb) * 31) + this.valueMaxPolicyX.hashCode()) * 31) + this.valueTotalMaxKb;
    }

    public String toString() {
        return "CreateStorageRequest(expireSeconds=" + this.expireSeconds + ", partition=" + this.partition + ", spaceTypeX=" + this.spaceTypeX + ", storageFileTypeX=" + this.storageFileTypeX + ", userId=" + this.userId + ", valueMaxKb=" + this.valueMaxKb + ", valueMaxPolicyX=" + this.valueMaxPolicyX + ", valueTotalMaxKb=" + this.valueTotalMaxKb + ')';
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

    public final IStorage$Internal$ValueMaxPolicy getValueMaxPolicy() {
        IStorage$Internal$ValueMaxPolicy.a r100 = IStorage$Internal$ValueMaxPolicy.Companion;
        String r101 = this.valueMaxPolicyX;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "value");
        IStorage$Internal$ValueMaxPolicy[] r102 = IStorage$Internal$ValueMaxPolicy.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        IStorage$Internal$ValueMaxPolicy r105 = r102[r104];
        if (Intrinsics.areEqual(r105.getValue(), r101) == true) goto L9;
        r104 = r104 + 1;
    L9:
        if (r105 == null) goto L12;
        return r105;
    L12:
        return IStorage$Internal$ValueMaxPolicy.Noeviction;
    L8:
        r105 = null;
        goto L9
    }

    public final int getExpireSeconds() {
        return this.expireSeconds;
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

    public final int getValueMaxKb() {
        return this.valueMaxKb;
    }

    public final String getValueMaxPolicyX() {
        return this.valueMaxPolicyX;
    }

    public final int getValueTotalMaxKb() {
        return this.valueTotalMaxKb;
    }

    public IStorage$Internal$CreateStorageRequest(int r100, String r101, @JSONField(name = "spaceType") String r102, @JSONField(name = "storageFileType") String r103, String r104, int r105, @JSONField(name = "valueMaxPolicy") String r106, int r107) {
        Intrinsics.checkNotNullParameter(r101, "partition");
        Intrinsics.checkNotNullParameter(r102, "spaceTypeX");
        Intrinsics.checkNotNullParameter(r103, "storageFileTypeX");
        Intrinsics.checkNotNullParameter(r104, "userId");
        Intrinsics.checkNotNullParameter(r106, "valueMaxPolicyX");
        this.expireSeconds = r100;
        this.partition = r101;
        this.spaceTypeX = r102;
        this.storageFileTypeX = r103;
        this.userId = r104;
        this.valueMaxKb = r105;
        this.valueMaxPolicyX = r106;
        this.valueTotalMaxKb = r107;
    }
}
