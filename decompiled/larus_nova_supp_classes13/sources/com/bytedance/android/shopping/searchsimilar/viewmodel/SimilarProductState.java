package com.bytedance.android.shopping.searchsimilar.viewmodel;

import com.bytedance.android.shopping.searchsimilar.model.ProductFrame;
import com.bytedance.android.shopping.searchsimilar.model.SortRuleInfo;
import com.bytedance.jedi.arch.State;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rd3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/viewmodel/SimilarProductState;", "Lcom/bytedance/jedi/arch/State;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductState implements State {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final List<a> d;
    public final List<ProductFrame> e;
    public final List<SortRuleInfo> f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public SimilarProductState() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SimilarProductState) == false) goto L24;
        SimilarProductState r4 = (SimilarProductState) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (this.i == r4.i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (r6 + r8) * 31;
        List<a> r10 = this.d;
        int r11 = 0;
        if (r10 == null) goto L14;
        int r12 = r10.hashCode();
    L15:
        int r13 = (r9 + r12) * 31;
        List<ProductFrame> r14 = this.e;
        if (r14 == null) goto L18;
        int r15 = r14.hashCode();
    L19:
        int r16 = (r13 + r15) * 31;
        List<SortRuleInfo> r17 = this.f;
        if (r17 == null) goto L22;
        r11 = r17.hashCode();
    L22:
        int r18 = (r16 + r11) * 31;
        boolean r19 = this.g;
        ?? r20 = r19;
        if (r19 == false) goto L25;
        r20 = 1;
    L25:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.h;
        ?? r23 = r22;
        if (r22 == false) goto L28;
        r23 = 1;
    L28:
        int r24 = (r21 + r23) * 31;
        boolean r25 = this.i;
        if (r25 == true) goto L33;
        r1 = r25;
    L33:
        return r24 + r1;
    L18:
        r15 = 0;
        goto L19
    L14:
        r12 = 0;
        goto L15
    }

    public final String toString() {
        return "SimilarProductState(isLoadingMore=" + this.a + ", hasMore=" + this.b + ", isInitializeLoadingSuccess=" + this.c + ", similarProductList=" + this.d + ", productFrameList=" + this.e + ", sortRuleList=" + this.f + ", isLoadingError=" + this.g + ", isNoData=" + this.h + ", isRefreshLoad=" + this.i + ")";
    }

    public /* synthetic */ SimilarProductState(int r11) {
        this(false, true, false, new ArrayList(), null, null, false, false, true);
    }

    public SimilarProductState(boolean r2, boolean r3, boolean r4, List<a> r5, List<ProductFrame> r6, List<SortRuleInfo> r7, boolean r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "similarProductList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public static SimilarProductState a(SimilarProductState r10, boolean r11, boolean r12, boolean r13, List r14, List r15, List r16, boolean r17, boolean r18, boolean r19, int r20) {
        if ((r20 & 1) == 0) goto L5;
        boolean r2 = r10.a;
    L7:
        if ((r20 & 2) == 0) goto L9;
        boolean r3 = r10.b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        boolean r4 = r10.c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        List r5 = r10.d;
    L19:
        if ((r20 & 16) == 0) goto L21;
        List r6 = r10.e;
    L23:
        if ((r20 & 32) == 0) goto L25;
        List r7 = r10.f;
    L27:
        if ((r20 & 64) == 0) goto L29;
        boolean r8 = r10.g;
    L31:
        if ((r20 & 128) == 0) goto L33;
        boolean r9 = r10.h;
    L35:
        if ((r20 & 256) == 0) goto L37;
        boolean r1 = r10.i;
    L38:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "similarProductList");
        return new SimilarProductState(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L38
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }
}
