package com.bytedance.ruler;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f267702e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f267703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f267704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f267705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f267706d;

    public static final class a {
    }

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (this.f267703a == r101.f267703a) goto L8;
        return false;
    L8:
        if (this.f267704b == r101.f267704b) goto L10;
        return false;
    L10:
        if (this.f267705c == r101.f267705c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f267706d, r101.f267706d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r100 = this.f267703a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f267704b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f267705c;
        if (r107 == true) goto L12;
        r101 = r107;
    L12:
        int r108 = (r106 + r101) * 31;
        List<String> r109 = this.f267706d;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L17:
        return r108 + r110;
    L15:
        r110 = 0;
        goto L17
    }

    static {
        f267702e = new e(0);
    }

    public final String toString() {
        return "{\"useFFF\"=" + this.f267703a + ",\"enableSelectCache\"=" + this.f267704b + ",\"useRuleFFF\"=" + this.f267705c + ", \"reportParams\":" + this.f267706d + '}';
    }

    public /* synthetic */ e(int r100) {
        this(false, false, false, null);
    }

    public e(boolean r100, boolean r101, boolean r102, List<String> r103) {
        this.f267703a = r100;
        this.f267704b = r101;
        this.f267705c = r102;
        this.f267706d = r103;
    }
}
