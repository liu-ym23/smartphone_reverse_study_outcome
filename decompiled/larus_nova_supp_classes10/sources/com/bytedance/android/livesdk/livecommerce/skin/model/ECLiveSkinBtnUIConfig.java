package com.bytedance.android.livesdk.livecommerce.skin.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\bHÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBtnUIConfig;", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/AbsECLiveSkinBaseUIConfig;", "enabled", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;", "disabled", "radius", "", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinRadius;", "(Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;Ljava/util/List;)V", "getDisabled", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;", "getEnabled", "getRadius", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSkinBtnUIConfig extends AbsECLiveSkinBaseUIConfig {

    @SerializedName("disabled")
    private final ECLiveSkinBaseViewUIConfig disabled;

    @SerializedName("enabled")
    private final ECLiveSkinBaseViewUIConfig enabled;

    @SerializedName("radius")
    private final List<Integer> radius;

    public ECLiveSkinBtnUIConfig() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECLiveSkinBtnUIConfig copy$default(ECLiveSkinBtnUIConfig r0, ECLiveSkinBaseViewUIConfig r1, ECLiveSkinBaseViewUIConfig r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enabled;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.disabled;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.getRadius();
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final ECLiveSkinBaseViewUIConfig component1() {
        return this.enabled;
    }

    public final ECLiveSkinBaseViewUIConfig component2() {
        return this.disabled;
    }

    public final List<Integer> component3() {
        return getRadius();
    }

    public final ECLiveSkinBtnUIConfig copy(ECLiveSkinBaseViewUIConfig r2, ECLiveSkinBaseViewUIConfig r3, List<Integer> r4) {
        return new ECLiveSkinBtnUIConfig(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECLiveSkinBtnUIConfig) == false) goto L12;
        ECLiveSkinBtnUIConfig r4 = (ECLiveSkinBtnUIConfig) r3;
        if (Intrinsics.areEqual(this.enabled, r4.enabled) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.disabled, r4.disabled) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(getRadius(), r4.getRadius()) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        ECLiveSkinBaseViewUIConfig r0 = this.enabled;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECLiveSkinBaseViewUIConfig r4 = this.disabled;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<Integer> r7 = getRadius();
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ECLiveSkinBtnUIConfig(enabled=" + this.enabled + ", disabled=" + this.disabled + ", radius=" + getRadius() + ")";
    }

    public final ECLiveSkinBaseViewUIConfig getDisabled() {
        return this.disabled;
    }

    public final ECLiveSkinBaseViewUIConfig getEnabled() {
        return this.enabled;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig
    public List<Integer> getRadius() {
        return this.radius;
    }

    public ECLiveSkinBtnUIConfig(ECLiveSkinBaseViewUIConfig r1, ECLiveSkinBaseViewUIConfig r2, List<Integer> r3) {
        this.enabled = r1;
        this.disabled = r2;
        this.radius = r3;
    }

    public /* synthetic */ ECLiveSkinBtnUIConfig(ECLiveSkinBaseViewUIConfig r2, ECLiveSkinBaseViewUIConfig r3, List r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
