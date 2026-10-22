package com.bytedance.android.shopping.api.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003HÆ\u0003J3\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R$\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/WireFrameSetting;", "Ljava/io/Serializable;", "scene", "", "", "category", "(Ljava/util/List;Ljava/util/List;)V", "getCategory", "()Ljava/util/List;", "getScene", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class WireFrameSetting implements Serializable {

    @SerializedName("category")
    private final List<List<Integer>> category;

    @SerializedName("scene")
    private final List<Integer> scene;

    public WireFrameSetting() {
        List r0 = null;
        this(r0, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WireFrameSetting copy$default(WireFrameSetting r0, List r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.scene;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.category;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<Integer> component1() {
        return this.scene;
    }

    public final List<List<Integer>> component2() {
        return this.category;
    }

    public final WireFrameSetting copy(List<Integer> r2, List<? extends List<Integer>> r3) {
        return new WireFrameSetting(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof WireFrameSetting) == false) goto L10;
        WireFrameSetting r4 = (WireFrameSetting) r3;
        if (Intrinsics.areEqual(this.scene, r4.scene) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.category, r4.category) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<Integer> r0 = this.scene;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<List<Integer>> r4 = this.category;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "WireFrameSetting(scene=" + this.scene + ", category=" + this.category + ")";
    }

    public final List<List<Integer>> getCategory() {
        return this.category;
    }

    public final List<Integer> getScene() {
        return this.scene;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WireFrameSetting(List<Integer> r1, List<? extends List<Integer>> r2) {
        this.scene = r1;
        this.category = r2;
    }

    public /* synthetic */ WireFrameSetting(List r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
