package com.bytedance.sdk.xbridge.cn.storage.utils;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/h;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "value", "d", "", "created_name", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "lastAccessTime", "getLastAccessTime", "lastModifiedTime", "c", "expiredTime", "b", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("created_time")
    private final Long created_name;

    @SerializedName("expired_time")
    private final Long expiredTime;

    @SerializedName("last_access_time")
    private final Long lastAccessTime;

    @SerializedName("last_modified_time")
    private final Long lastModifiedTime;

    @SerializedName("type")
    private final String type;

    @SerializedName("value")
    private final String value;

    public h() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.created_name, r101.created_name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lastAccessTime, r101.lastAccessTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lastModifiedTime, r101.lastModifiedTime) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.expiredTime, r101.expiredTime) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.value;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.created_name;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.lastAccessTime;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.lastModifiedTime;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.expiredTime;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
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

    public final String toString() {
        return "UserDomainStorageValue(type=" + this.type + ", value=" + this.value + ", created_name=" + this.created_name + ", lastAccessTime=" + this.lastAccessTime + ", lastModifiedTime=" + this.lastModifiedTime + ", expiredTime=" + this.expiredTime + ')';
    }

    public final Long a() {
        return this.created_name;
    }

    public final Long b() {
        return this.expiredTime;
    }

    public final Long c() {
        return this.lastModifiedTime;
    }

    public final String d() {
        return this.value;
    }

    public final String getType() {
        return this.type;
    }

    public h(String r100, String r101, Long r102, Long r103, Long r104, Long r105) {
        this.type = r100;
        this.value = r101;
        this.created_name = r102;
        this.lastAccessTime = r103;
        this.lastModifiedTime = r104;
        this.expiredTime = r105;
    }
}
