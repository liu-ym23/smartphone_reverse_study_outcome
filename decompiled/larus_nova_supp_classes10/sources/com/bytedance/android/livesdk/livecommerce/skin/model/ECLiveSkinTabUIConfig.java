package com.bytedance.android.livesdk.livecommerce.skin.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tHÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\t8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinTabUIConfig;", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/AbsECLiveSkinBaseUIConfig;", "selected", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;", "unselected", "disabled", "radius", "", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinRadius;", "(Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;Ljava/util/List;)V", "getDisabled", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;", "getRadius", "()Ljava/util/List;", "getSelected", "getUnselected", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSkinTabUIConfig extends AbsECLiveSkinBaseUIConfig {

    @SerializedName("disabled")
    private final ECLiveSkinBaseViewUIConfig disabled;

    @SerializedName("radius")
    private final List<Integer> radius;

    @SerializedName("selected")
    private final ECLiveSkinBaseViewUIConfig selected;

    @SerializedName("unselected")
    private final ECLiveSkinBaseViewUIConfig unselected;

    public ECLiveSkinTabUIConfig() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECLiveSkinTabUIConfig copy$default(ECLiveSkinTabUIConfig r0, ECLiveSkinBaseViewUIConfig r1, ECLiveSkinBaseViewUIConfig r2, ECLiveSkinBaseViewUIConfig r3, List r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.selected;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.unselected;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.disabled;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.getRadius();
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final ECLiveSkinBaseViewUIConfig component1() {
        return this.selected;
    }

    public final ECLiveSkinBaseViewUIConfig component2() {
        return this.unselected;
    }

    public final ECLiveSkinBaseViewUIConfig component3() {
        return this.disabled;
    }

    public final List<Integer> component4() {
        return getRadius();
    }

    public final ECLiveSkinTabUIConfig copy(ECLiveSkinBaseViewUIConfig r2, ECLiveSkinBaseViewUIConfig r3, ECLiveSkinBaseViewUIConfig r4, List<Integer> r5) {
        return new ECLiveSkinTabUIConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECLiveSkinTabUIConfig) == false) goto L14;
        ECLiveSkinTabUIConfig r4 = (ECLiveSkinTabUIConfig) r3;
        if (Intrinsics.areEqual(this.selected, r4.selected) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.unselected, r4.unselected) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.disabled, r4.disabled) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getRadius(), r4.getRadius()) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        ECLiveSkinBaseViewUIConfig r0 = this.selected;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECLiveSkinBaseViewUIConfig r4 = this.unselected;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECLiveSkinBaseViewUIConfig r7 = this.disabled;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<Integer> r10 = getRadius();
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ECLiveSkinTabUIConfig(selected=" + this.selected + ", unselected=" + this.unselected + ", disabled=" + this.disabled + ", radius=" + getRadius() + ")";
    }

    public final ECLiveSkinBaseViewUIConfig getDisabled() {
        return this.disabled;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig
    public List<Integer> getRadius() {
        return this.radius;
    }

    public final ECLiveSkinBaseViewUIConfig getSelected() {
        return this.selected;
    }

    public final ECLiveSkinBaseViewUIConfig getUnselected() {
        return this.unselected;
    }

    public ECLiveSkinTabUIConfig(ECLiveSkinBaseViewUIConfig r1, ECLiveSkinBaseViewUIConfig r2, ECLiveSkinBaseViewUIConfig r3, List<Integer> r4) {
        this.selected = r1;
        this.unselected = r2;
        this.disabled = r3;
        this.radius = r4;
    }

    public /* synthetic */ ECLiveSkinTabUIConfig(ECLiveSkinBaseViewUIConfig r2, ECLiveSkinBaseViewUIConfig r3, ECLiveSkinBaseViewUIConfig r4, List r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
