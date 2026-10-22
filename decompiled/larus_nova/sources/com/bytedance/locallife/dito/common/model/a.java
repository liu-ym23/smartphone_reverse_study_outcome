package com.bytedance.locallife.dito.common.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/dito/common/model/a;", "", "", "nodeTag", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "stringifyCost", "J", "c", "()J", "decodeCost", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("decodeCost")
    private final long decodeCost;

    @SerializedName("nodeTag")
    private final String nodeTag;

    @SerializedName("stringifyCost")
    private final long stringifyCost;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.nodeTag, r101.nodeTag) == true) goto L12;
        return false;
    L12:
        if (this.stringifyCost == r101.stringifyCost) goto L15;
        return false;
    L15:
        if (this.decodeCost == r101.decodeCost) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.nodeTag.hashCode() * 31;
        long r101 = this.stringifyCost;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.decodeCost;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "LynxDataDecodeCostModel(nodeTag=" + this.nodeTag + ", stringifyCost=" + this.stringifyCost + ", decodeCost=" + this.decodeCost + ')';
    }

    public final long a() {
        return this.decodeCost;
    }

    public final String b() {
        return this.nodeTag;
    }

    public final long c() {
        return this.stringifyCost;
    }

    public a(String r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "nodeTag");
        this.nodeTag = r100;
        this.stringifyCost = r101;
        this.decodeCost = r102;
    }
}
