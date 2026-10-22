package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantStyleConfigModel;", "Ljava/io/Serializable;", "container", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantConfig;", "slider", "item", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantItemConfig;", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantConfig;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantConfig;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantItemConfig;)V", "getContainer", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantConfig;", "getItem", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantItemConfig;", "getSlider", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderNAPendantStyleConfigModel implements Serializable {

    @SerializedName("container")
    private final HeaderNAPendantConfig container;

    @SerializedName("item")
    private final HeaderNAPendantItemConfig item;

    @SerializedName("slider")
    private final HeaderNAPendantConfig slider;

    public HeaderNAPendantStyleConfigModel() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ HeaderNAPendantStyleConfigModel copy$default(HeaderNAPendantStyleConfigModel r0, HeaderNAPendantConfig r1, HeaderNAPendantConfig r2, HeaderNAPendantItemConfig r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.container;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.slider;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.item;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final HeaderNAPendantConfig component1() {
        return this.container;
    }

    public final HeaderNAPendantConfig component2() {
        return this.slider;
    }

    public final HeaderNAPendantItemConfig component3() {
        return this.item;
    }

    public final HeaderNAPendantStyleConfigModel copy(HeaderNAPendantConfig r2, HeaderNAPendantConfig r3, HeaderNAPendantItemConfig r4) {
        return new HeaderNAPendantStyleConfigModel(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HeaderNAPendantStyleConfigModel) == false) goto L12;
        HeaderNAPendantStyleConfigModel r4 = (HeaderNAPendantStyleConfigModel) r3;
        if (Intrinsics.areEqual(this.container, r4.container) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.slider, r4.slider) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.item, r4.item) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        HeaderNAPendantConfig r0 = this.container;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        HeaderNAPendantConfig r4 = this.slider;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        HeaderNAPendantItemConfig r7 = this.item;
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
        return "HeaderNAPendantStyleConfigModel(container=" + this.container + ", slider=" + this.slider + ", item=" + this.item + ")";
    }

    public final HeaderNAPendantConfig getContainer() {
        return this.container;
    }

    public final HeaderNAPendantItemConfig getItem() {
        return this.item;
    }

    public final HeaderNAPendantConfig getSlider() {
        return this.slider;
    }

    public HeaderNAPendantStyleConfigModel(HeaderNAPendantConfig r1, HeaderNAPendantConfig r2, HeaderNAPendantItemConfig r3) {
        this.container = r1;
        this.slider = r2;
        this.item = r3;
    }

    public /* synthetic */ HeaderNAPendantStyleConfigModel(HeaderNAPendantConfig r2, HeaderNAPendantConfig r3, HeaderNAPendantItemConfig r4, int r5, DefaultConstructorMarker r6) {
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
