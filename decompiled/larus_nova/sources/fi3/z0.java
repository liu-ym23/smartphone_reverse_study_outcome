package fi3;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lfi3/z0;", "", "", RemoteMessageConst.TO, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "from", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z0 {

    @SerializedName("from")
    private final String from;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    @SerializedName(RemoteMessageConst.TO)
    private final String f477357to;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z0) == false) goto L10;
        z0 r101 = (z0) r100;
        if (Intrinsics.areEqual(this.f477357to, r101.f477357to) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.from, r101.from) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f477357to;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.from;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UltimateUpdateParams(to=" + this.f477357to + ", from=" + this.from + ")";
    }

    public z0() {
        this.f477357to = null;
        this.from = null;
    }

    public final String a() {
        return this.from;
    }

    public final String b() {
        return this.f477357to;
    }
}
