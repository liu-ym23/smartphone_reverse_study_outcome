package com.bytedance.ttcnpa;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ttcnpa/TtCnpaBytesResult;", "", "Lcom/bytedance/ttcnpa/TtCnpaResult;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/ttcnpa/TtCnpaResult;", "getResult", "()Lcom/bytedance/ttcnpa/TtCnpaResult;", "setResult", "(Lcom/bytedance/ttcnpa/TtCnpaResult;)V", "result", "ttcnpa_release"}, k = 1, mv = {1, 7, 1})
public final class TtCnpaBytesResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TtCnpaResult f271043a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TtCnpaBytesResult) == true) goto L8;
        return false;
    L8:
        TtCnpaBytesResult r101 = (TtCnpaBytesResult) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f271043a, r101.f271043a) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return 0 + this.f271043a.hashCode();
    }

    public final String toString() {
        return "TtCnpaBytesResult(bytesResult=" + Arrays.toString(null) + ", result=" + this.f271043a + ')';
    }

    public final void setResult(TtCnpaResult r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f271043a = r100;
    }
}
