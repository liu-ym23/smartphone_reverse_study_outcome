package com.bytedance.android.window.shop.innerflow.repo;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.window.base.repository.dto.s;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u001b\u0010\u0006\u001a\u00020\u00002\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/repo/ECWindowInnerFlowComponentDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "Lcom/bytedance/android/ec/window/base/repository/dto/s;", "component1", "components", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getComponents", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowComponentDTO extends CommerceBaseResponse {

    @SerializedName("modules")
    private final List<s> components;

    public ECWindowInnerFlowComponentDTO() {
        List r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECWindowInnerFlowComponentDTO copy$default(ECWindowInnerFlowComponentDTO r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.components;
    L6:
        return r0.copy(r1);
    }

    public final List<s> component1() {
        return this.components;
    }

    public final ECWindowInnerFlowComponentDTO copy(List<s> r2) {
        return new ECWindowInnerFlowComponentDTO(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof ECWindowInnerFlowComponentDTO) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.components, ((ECWindowInnerFlowComponentDTO) r2).components) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        List<s> r0 = this.components;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "ECWindowInnerFlowComponentDTO(components=" + this.components + ")";
    }

    public final List<s> getComponents() {
        return this.components;
    }

    public ECWindowInnerFlowComponentDTO(List<s> r1) {
        this.components = r1;
    }

    public /* synthetic */ ECWindowInnerFlowComponentDTO(List r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
