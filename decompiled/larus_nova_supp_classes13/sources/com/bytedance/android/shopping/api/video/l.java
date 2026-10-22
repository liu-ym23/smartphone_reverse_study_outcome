package com.bytedance.android.shopping.api.video;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l {
    public static final /* synthetic */ int i = 0;
    public final AVScene a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final boolean e;
    public final SelectBitrateResolutionStrategy f;
    public final boolean g;
    public final boolean h;

    public static final class a {
    }

    static {
    }

    public l() {
        this(null, false, false, false, null, false, false, 255);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l) == false) goto L22;
        l r4 = (l) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
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
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
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
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        AVScene r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.c;
        ?? r9 = r8;
        if (r8 == false) goto L12;
        r9 = 1;
    L12:
        int r10 = (((r7 + r9) * 31) + this.d) * 31;
        boolean r11 = this.e;
        ?? r12 = r11;
        if (r11 == false) goto L15;
        r12 = 1;
    L15:
        int r13 = (r10 + r12) * 31;
        SelectBitrateResolutionStrategy r14 = this.f;
        if (r14 == null) goto L18;
        r1 = r14.hashCode();
    L18:
        int r15 = (r13 + r1) * 31;
        boolean r16 = this.g;
        ?? r17 = r16;
        if (r16 == false) goto L21;
        r17 = 1;
    L21:
        int r18 = (r15 + r17) * 31;
        boolean r19 = this.h;
        if (r19 == true) goto L26;
        r5 = r19;
    L26:
        return r18 + r5;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SimPlayerStrategyConfig(scene=" + this.a + ", delayInitPlayer=" + this.b + ", enablePlayerPoolManager=" + this.c + ", playerPoolSize=" + this.d + ", enableStopReleaseHelper=" + this.e + ", videoBitrateStrategy=" + this.f + ", keepScreenOnPlaying=" + this.g + ", adaptVideoSizeChange=" + this.h + ")";
    }

    public l(AVScene r4, boolean r5, boolean r6, boolean r7, SelectBitrateResolutionStrategy r8, boolean r9, boolean r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r4 = AVScene.CONTENT_DEFAULT;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r5 = false;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r6 = false;
    L12:
        if ((r11 & 8) == 0) goto L14;
        int r0 = 3;
    L16:
        if ((r11 & 16) == 0) goto L19;
        r7 = false;
    L19:
        if ((r11 & 32) == 0) goto L22;
        r8 = SelectBitrateResolutionStrategy.DEFAULT;
    L22:
        if ((r11 & 64) == 0) goto L25;
        r9 = false;
    L25:
        if ((r11 & 128) == 0) goto L27;
        r10 = false;
    L27:
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r8, "videoBitrateStrategy");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r0;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        return;
    L14:
        r0 = 0;
        goto L16
    }
}
