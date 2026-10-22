package uh3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Luh3/a;", "", "epInfo", "Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Object;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("ep_info")
    private final Object epInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.epInfo, ((a) r100).epInfo) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.epInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "AdditionModulesData(epInfo=" + this.epInfo + ")";
    }

    public a() {
        this.epInfo = null;
    }

    public final Object a() {
        return this.epInfo;
    }
}
