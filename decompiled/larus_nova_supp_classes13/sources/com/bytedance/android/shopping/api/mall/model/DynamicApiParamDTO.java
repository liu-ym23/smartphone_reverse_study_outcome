package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0003J!\u0010\t\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/DynamicApiParamDTO;", "", "dynamicParams", "", "", "(Ljava/util/Map;)V", "getDynamicParams", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DynamicApiParamDTO {

    @SerializedName("dynamic_params")
    private final Map<String, Object> dynamicParams;

    public DynamicApiParamDTO() {
        Map r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DynamicApiParamDTO copy$default(DynamicApiParamDTO r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.dynamicParams;
    L6:
        return r0.copy(r1);
    }

    public final Map<String, Object> component1() {
        return this.dynamicParams;
    }

    public final DynamicApiParamDTO copy(Map<String, ? extends Object> r2) {
        return new DynamicApiParamDTO(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof DynamicApiParamDTO) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.dynamicParams, ((DynamicApiParamDTO) r2).dynamicParams) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        Map<String, Object> r0 = this.dynamicParams;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "DynamicApiParamDTO(dynamicParams=" + this.dynamicParams + ")";
    }

    public final Map<String, Object> getDynamicParams() {
        return this.dynamicParams;
    }

    public DynamicApiParamDTO(Map<String, ? extends Object> r1) {
        this.dynamicParams = r1;
    }

    public /* synthetic */ DynamicApiParamDTO(Map r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
