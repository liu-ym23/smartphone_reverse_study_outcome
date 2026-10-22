package com.bytedance.ies.xbridge.storage.utils;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xbridge/storage/utils/b;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("type")
    private final String type;

    @SerializedName("value")
    private final String value;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.type.hashCode() * 31) + this.value.hashCode();
    }

    public final String toString() {
        return "StorageValue(type=" + this.type + ", value=" + this.value + ')';
    }

    public final String a() {
        return this.value;
    }

    public final String getType() {
        return this.type;
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.type = r100;
        this.value = r101;
    }
}
