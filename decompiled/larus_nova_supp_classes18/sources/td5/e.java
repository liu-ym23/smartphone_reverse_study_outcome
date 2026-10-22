package td5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final int a;
    public final String b;
    public final String c;
    public final boolean d;
    public int e;
    public final int f;
    public final boolean g;
    public final boolean h;

    public /* synthetic */ e(int r10, String r11, String r12, boolean r13, int r14, int r15, boolean r16) {
        this(r10, r11, r12, r13, r14, r15, r16, false);
    }

    public e(int r2, String r3, String r4, boolean r5, int r6, int r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r3, "objToken");
        Intrinsics.checkNotNullParameter(r4, "title");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
