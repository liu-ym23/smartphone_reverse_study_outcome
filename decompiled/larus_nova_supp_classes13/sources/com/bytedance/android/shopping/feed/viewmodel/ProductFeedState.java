package com.bytedance.android.shopping.feed.viewmodel;

import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.jedi.arch.State;
import d63.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yd3.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/feed/viewmodel/ProductFeedState;", "Lcom/bytedance/jedi/arch/State;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFeedState implements State {
    public final q a;
    public final ActivityVO b;
    public final boolean c;
    public final boolean d;
    public final List<Object> e;
    public final List<rd3.a> f;
    public final List<rd3.a> g;
    public final boolean h;
    public final boolean i;
    public final List<rd3.a> j;
    public final int k;
    public final p l;
    public final boolean m;
    public final p n;
    public final List<rd3.a> o;
    public final List<rd3.a> p;
    public final String q;

    public ProductFeedState() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ProductFeedState) == false) goto L40;
        ProductFeedState r4 = (ProductFeedState) r3;
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
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (this.i == r4.i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (this.k == r4.k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (this.m == r4.m) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r4.o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r4.p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.q, r4.q) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        q r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ActivityVO r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = 1;
        ?? r9 = r7;
        if (r7 == false) goto L13;
        r9 = 1;
    L13:
        int r10 = (r6 + r9) * 31;
        boolean r11 = this.d;
        ?? r12 = r11;
        if (r11 == false) goto L16;
        r12 = 1;
    L16:
        int r13 = (r10 + r12) * 31;
        List<Object> r14 = this.e;
        if (r14 == null) goto L19;
        int r15 = r14.hashCode();
    L20:
        int r16 = (r13 + r15) * 31;
        List<rd3.a> r17 = this.f;
        if (r17 == null) goto L23;
        int r18 = r17.hashCode();
    L24:
        int r19 = (r16 + r18) * 31;
        List<rd3.a> r20 = this.g;
        if (r20 == null) goto L27;
        int r21 = r20.hashCode();
    L28:
        int r22 = (r19 + r21) * 31;
        boolean r23 = this.h;
        ?? r24 = r23;
        if (r23 == false) goto L31;
        r24 = 1;
    L31:
        int r25 = (r22 + r24) * 31;
        boolean r26 = this.i;
        ?? r27 = r26;
        if (r26 == false) goto L34;
        r27 = 1;
    L34:
        int r28 = (r25 + r27) * 31;
        List<rd3.a> r29 = this.j;
        if (r29 == null) goto L37;
        int r30 = r29.hashCode();
    L38:
        int r31 = (((r28 + r30) * 31) + this.k) * 31;
        p r32 = this.l;
        if (r32 == null) goto L41;
        int r33 = r32.hashCode();
    L42:
        int r34 = (r31 + r33) * 31;
        boolean r35 = this.m;
        if (r35 == true) goto L46;
        r8 = r35;
    L46:
        int r36 = (r34 + r8) * 31;
        p r37 = this.n;
        if (r37 == null) goto L49;
        int r38 = r37.hashCode();
    L50:
        int r39 = (r36 + r38) * 31;
        List<rd3.a> r40 = this.o;
        if (r40 == null) goto L53;
        int r41 = r40.hashCode();
    L54:
        int r42 = (r39 + r41) * 31;
        List<rd3.a> r43 = this.p;
        if (r43 == null) goto L57;
        int r44 = r43.hashCode();
    L58:
        int r45 = (r42 + r44) * 31;
        String r46 = this.q;
        if (r46 == null) goto L62;
        r1 = r46.hashCode();
    L62:
        return r45 + r1;
    L57:
        r44 = 0;
        goto L58
    L53:
        r41 = 0;
        goto L54
    L49:
        r38 = 0;
        goto L50
    L41:
        r33 = 0;
        goto L42
    L37:
        r30 = 0;
        goto L38
    L27:
        r21 = 0;
        goto L28
    L23:
        r18 = 0;
        goto L24
    L19:
        r15 = 0;
        goto L20
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductFeedState(navBtnVO=" + this.a + ", activityVO=" + this.b + ", isLoadingMore=" + this.c + ", hasMore=" + this.d + ", headerList=" + this.e + ", guessULikeList=" + this.f + ", firstLoadGuessULikeResourceCardList=" + this.g + ", isRecommendUpdateRequest=" + this.h + ", isResourceCardLoaded=" + this.i + ", cardList=" + this.j + ", topicCardPosition=" + this.k + ", mallDivertResourceCard=" + this.l + ", isFloatMallIconVisible=" + this.m + ", searchCard=" + this.n + ", goodPriceCards=" + this.o + ", goodPriceStrips=" + this.p + ", removeGoodPriceCardByProdId=" + this.q + ")";
    }

    public /* synthetic */ ProductFeedState(int r19) {
        this(null, null, false, true, CollectionsKt.emptyList(), new ArrayList(), new ArrayList(), false, false, new ArrayList(), -1, null, false, null, null, null, null);
    }

    public ProductFeedState(q r7, ActivityVO r8, boolean r9, boolean r10, List<? extends Object> r11, List<rd3.a> r12, List<rd3.a> r13, boolean r14, boolean r15, List<rd3.a> r16, int r17, p r18, boolean r19, p r20, List<rd3.a> r21, List<rd3.a> r22, String r23) {
        Intrinsics.checkNotNullParameter(r11, "headerList");
        Intrinsics.checkNotNullParameter(r12, "guessULikeList");
        Intrinsics.checkNotNullParameter(r13, "firstLoadGuessULikeResourceCardList");
        Intrinsics.checkNotNullParameter(r16, "cardList");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        this.m = r19;
        this.n = r20;
        this.o = r21;
        this.p = r22;
        this.q = r23;
    }

    public static ProductFeedState a(ProductFeedState r22, ActivityVO r23, boolean r24, boolean r25, List r26, List r27, List r28, boolean r29, boolean r30, int r31, p r32, boolean r33, p r34, List r35, List r36, String r37, int r38) {
        List<rd3.a> r3 = null;
        if ((r38 & 1) == 0) goto L5;
        q r5 = r22.a;
    L7:
        if ((r38 & 2) == 0) goto L9;
        ActivityVO r6 = r22.b;
    L11:
        if ((r38 & 4) == 0) goto L13;
        boolean r7 = r22.c;
    L15:
        if ((r38 & 8) == 0) goto L17;
        boolean r8 = r22.d;
    L19:
        if ((r38 & 16) == 0) goto L21;
        List r9 = r22.e;
    L23:
        if ((r38 & 32) == 0) goto L25;
        List r10 = r22.f;
    L27:
        if ((r38 & 64) == 0) goto L29;
        List r11 = r22.g;
    L31:
        if ((r38 & 128) == 0) goto L33;
        boolean r12 = r22.h;
    L35:
        if ((r38 & 256) == 0) goto L37;
        boolean r13 = r22.i;
    L39:
        if ((r38 & 512) == 0) goto L41;
        r3 = r22.j;
    L41:
        List<rd3.a> r14 = r3;
        if ((r38 & 1024) == 0) goto L44;
        int r15 = r22.k;
    L46:
        if ((r38 & 2048) == 0) goto L48;
        p r16 = r22.l;
    L50:
        if ((r38 & 4096) == 0) goto L52;
        boolean r17 = r22.m;
    L54:
        if ((r38 & 8192) == 0) goto L56;
        p r18 = r22.n;
    L58:
        if ((r38 & 16384) == 0) goto L60;
        List r19 = r22.o;
    L62:
        if ((32768 & r38) == 0) goto L64;
        List r20 = r22.p;
    L66:
        if ((r38 & 65536) == 0) goto L68;
        String r21 = r22.q;
    L69:
        r22.getClass();
        Intrinsics.checkNotNullParameter(r9, "headerList");
        Intrinsics.checkNotNullParameter(r10, "guessULikeList");
        Intrinsics.checkNotNullParameter(r11, "firstLoadGuessULikeResourceCardList");
        Intrinsics.checkNotNullParameter(r14, "cardList");
        return new ProductFeedState(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    L68:
        r21 = r37;
        goto L69
    L64:
        r20 = r36;
        goto L66
    L60:
        r19 = r35;
        goto L62
    L56:
        r18 = r34;
        goto L58
    L52:
        r17 = r33;
        goto L54
    L48:
        r16 = r32;
        goto L50
    L44:
        r15 = r31;
        goto L46
    L37:
        r13 = r30;
        goto L39
    L33:
        r12 = r29;
        goto L35
    L29:
        r11 = r28;
        goto L31
    L25:
        r10 = r27;
        goto L27
    L21:
        r9 = r26;
        goto L23
    L17:
        r8 = r25;
        goto L19
    L13:
        r7 = r24;
        goto L15
    L9:
        r6 = r23;
        goto L11
    L5:
        r5 = null;
        goto L7
    }
}
