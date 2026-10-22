package com.bytedance.lark.policy.model;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/lark/policy/model/CheckPointcutResponse;", "", "resultMap", "", "", "", "<init>", "(Ljava/util/Map;)V", "getResultMap", "()Ljava/util/Map;", "component1", "copy", "equals", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("isUnderControlled")
    private final Map<String, Boolean> resultMap;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.resultMap, ((c) r100).resultMap) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.resultMap.hashCode();
    }

    public final String toString() {
        return "CheckPointcutResponse(resultMap=" + this.resultMap + ')';
    }

    public c() {
        LinkedHashMap r100 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r100, "resultMap");
        this.resultMap = r100;
    }

    public final Map<String, Boolean> a() {
        return this.resultMap;
    }
}
