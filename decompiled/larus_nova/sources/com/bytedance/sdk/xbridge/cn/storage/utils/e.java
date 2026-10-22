package com.bytedance.sdk.xbridge.cn.storage.utils;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/e;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "value", "b", "", "expiredTime", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("expired_time")
    private final Long expiredTime;

    @SerializedName("type")
    private final String type;

    @SerializedName("value")
    private final String value;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.expiredTime, r101.expiredTime) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.type.hashCode() * 31) + this.value.hashCode()) * 31;
        Long r101 = this.expiredTime;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "StorageValue(type=" + this.type + ", value=" + this.value + ", expiredTime=" + this.expiredTime + ')';
    }

    public final Long a() {
        return this.expiredTime;
    }

    public final String b() {
        return this.value;
    }

    public final String getType() {
        return this.type;
    }

    public e(String r100, String r101, Long r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.type = r100;
        this.value = r101;
        this.expiredTime = r102;
    }
}
