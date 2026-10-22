package com.bytedance.android.shopping.sameproduct.viewmodel;

import com.bytedance.jedi.arch.State;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rd3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/viewmodel/SameProductState;", "Lcom/bytedance/jedi/arch/State;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameProductState implements State {
    public final List<Object> a;
    public final List<a> b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    public SameProductState() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SameProductState) == false) goto L22;
        SameProductState r4 = (SameProductState) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        List<Object> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<a> r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        boolean r6 = this.c;
        ?? r7 = 1;
        ?? r8 = r6;
        if (r6 == false) goto L12;
        r8 = 1;
    L12:
        int r9 = (r5 + r8) * 31;
        boolean r10 = this.d;
        ?? r11 = r10;
        if (r10 == false) goto L15;
        r11 = 1;
    L15:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.e;
        ?? r14 = r13;
        if (r13 == false) goto L18;
        r14 = 1;
    L18:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.f;
        ?? r17 = r16;
        if (r16 == false) goto L21;
        r17 = 1;
    L21:
        int r18 = (r15 + r17) * 31;
        boolean r19 = this.g;
        ?? r20 = r19;
        if (r19 == false) goto L24;
        r20 = 1;
    L24:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.h;
        if (r22 == true) goto L29;
        r7 = r22;
    L29:
        return r21 + r7;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SameProductState(headerList=" + this.a + ", sameProductList=" + this.b + ", isMainProductLoading=" + this.c + ", isProductListLoading=" + this.d + ", hasMoreSameProduct=" + this.e + ", isMainProductApiError=" + this.f + ", isProductListApiError=" + this.g + ", loadedProductListApi=" + this.h + ")";
    }

    public /* synthetic */ SameProductState(int r10) {
        this(CollectionsKt.emptyList(), new ArrayList(), false, false, true, false, false, false);
    }

    public SameProductState(List<? extends Object> r2, List<a> r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "headerList");
        Intrinsics.checkNotNullParameter(r3, "sameProductList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public static SameProductState a(SameProductState r9, List r10, List r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, int r18) {
        if ((r18 & 1) == 0) goto L5;
        List r2 = r9.a;
    L7:
        if ((r18 & 2) == 0) goto L9;
        List r3 = r9.b;
    L11:
        if ((r18 & 4) == 0) goto L13;
        boolean r4 = r9.c;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = r9.d;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = r9.e;
    L23:
        if ((r18 & 32) == 0) goto L25;
        boolean r7 = r9.f;
    L27:
        if ((r18 & 64) == 0) goto L29;
        boolean r8 = r9.g;
    L31:
        if ((r18 & 128) == 0) goto L33;
        boolean r1 = r9.h;
    L34:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r2, "headerList");
        Intrinsics.checkNotNullParameter(r3, "sameProductList");
        return new SameProductState(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L34
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }
}
