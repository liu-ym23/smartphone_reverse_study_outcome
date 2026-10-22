package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/DetailSkuPropertiesFragmentParams;", "Ljava/io/Serializable;", "", "component1", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailSkuVO;", "component2", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/t;", "component3", "tabPosition", "vo", "viewModel", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getTabPosition", "()I", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailSkuVO;", "getVo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailSkuVO;", "a", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/t;", "getViewModel", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/t;", "<init>", "(ILcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailSkuVO;Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/t;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DetailSkuPropertiesFragmentParams implements Serializable {
    public final transient t a;
    private final int tabPosition;
    private final AnchorV4DetailSkuVO vo;

    public DetailSkuPropertiesFragmentParams() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ DetailSkuPropertiesFragmentParams copy$default(DetailSkuPropertiesFragmentParams r0, int r1, AnchorV4DetailSkuVO r2, t r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.tabPosition;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.vo;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.a;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.tabPosition;
    }

    public final AnchorV4DetailSkuVO component2() {
        return this.vo;
    }

    public final t component3() {
        return this.a;
    }

    public final DetailSkuPropertiesFragmentParams copy(int r2, AnchorV4DetailSkuVO r3, t r4) {
        return new DetailSkuPropertiesFragmentParams(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof DetailSkuPropertiesFragmentParams) == false) goto L12;
        DetailSkuPropertiesFragmentParams r4 = (DetailSkuPropertiesFragmentParams) r3;
        if (this.tabPosition == r4.tabPosition) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.vo, r4.vo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r0 = this.tabPosition * 31;
        AnchorV4DetailSkuVO r1 = this.vo;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        t r5 = this.a;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "DetailSkuPropertiesFragmentParams(tabPosition=" + this.tabPosition + ", vo=" + this.vo + ", viewModel=" + this.a + ")";
    }

    public final int getTabPosition() {
        return this.tabPosition;
    }

    public final t getViewModel() {
        return this.a;
    }

    public final AnchorV4DetailSkuVO getVo() {
        return this.vo;
    }

    public DetailSkuPropertiesFragmentParams(int r1, AnchorV4DetailSkuVO r2, t r3) {
        this.tabPosition = r1;
        this.vo = r2;
        this.a = r3;
    }

    public /* synthetic */ DetailSkuPropertiesFragmentParams(int r2, AnchorV4DetailSkuVO r3, t r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
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
