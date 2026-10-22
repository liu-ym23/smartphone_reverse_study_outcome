package io.noties.markwon.ext.onetex;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f492469g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f492470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f492471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f492472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f492473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f492474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f492475f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f492476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f492477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f492478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f492479d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f492480e;

        public a(float r100) {
            this.f492480e = r100;
            this.f492476a = true;
            int r101 = this.f492477b;
            this.f492478c = r101;
            this.f492479d = r101;
        }
    }

    public static final class b {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L40:
        return true;
    L5:
        if ((r100 instanceof t) == false) goto L39;
        t r101 = (t) r100;
        if (Float.compare(this.f492470a, r101.f492470a) != 0) goto L39;
        if (Float.compare(this.f492471b, r101.f492471b) != 0) goto L39;
        if (Intrinsics.areEqual(null, null) == false) goto L39;
        if (Intrinsics.areEqual(null, null) == false) goto L39;
        if (this.f492472c != r101.f492472c) goto L17;
        boolean r102 = true;
    L18:
        if (r102 == false) goto L39;
        if (this.f492473d != r101.f492473d) goto L22;
        boolean r103 = true;
    L23:
        if (r103 == false) goto L39;
        if (Intrinsics.areEqual(null, null) == false) goto L39;
        if (Intrinsics.areEqual(null, null) == false) goto L39;
        if (this.f492474e != r101.f492474e) goto L31;
        boolean r104 = true;
    L32:
        if (r104 == false) goto L39;
        if (this.f492475f != r101.f492475f) goto L36;
        boolean r105 = true;
    L37:
        if (r105 == false) goto L39;
    L36:
        r105 = false;
        goto L37
    L31:
        r104 = false;
        goto L32
    L22:
        r103 = false;
        goto L23
    L17:
        r102 = false;
    L39:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        int r100 = ((((((Float.floatToIntBits(this.f492470a) * 31) + Float.floatToIntBits(this.f492471b)) * 31) + 0) * 31) + 0) * 31;
        boolean r101 = this.f492472c;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return ((((((((((r100 + r102) * 31) + this.f492473d) * 31) + 0) * 31) + 0) * 31) + this.f492474e) * 31) + this.f492475f;
    }

    public final String toString() {
        return "LatexMathTheme(inlineTextSize=" + this.f492470a + ", blockTextSize=" + this.f492471b + ", inlineBackgroundProvider=null, blockBackgroundProvider=null, blockFitCanvas=" + this.f492472c + ", blockHorizontalAlignment=" + this.f492473d + ", inlinePadding=null, blockPadding=null, inlineTextColor=" + this.f492474e + ", blockTextColor=" + this.f492475f + ")";
    }

    public t(a r100) {
        float r101 = 0;
        float r102 = 0.0f;
        if (0.0f <= r101) goto L5;
        float r103 = 0.0f;
    L6:
        if (0.0f > r101) goto L9;
        r102 = r100.f492480e;
    L9:
        boolean r104 = r100.f492476a;
        int r105 = r100.f492478c;
        if (r105 > 0) goto L13;
        r105 = r100.f492477b;
    L13:
        int r106 = r100.f492479d;
        if (r106 > 0) goto L17;
        r106 = r100.f492477b;
    L17:
        this.f492470a = r103;
        this.f492471b = r102;
        this.f492472c = r104;
        this.f492473d = 17;
        this.f492474e = r105;
        this.f492475f = r106;
        return;
    L5:
        r103 = r100.f492480e;
        goto L6
    }
}
