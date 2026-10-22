package com.bytedance.badger.x;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f199366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f199367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f199368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f199369d;

    public /* synthetic */ a0(int r100, List r101, int r102) {
        if ((r102 & 4) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 8) == 0) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        this(false, null, r100, r101);
    }

    public a0(boolean r100, String r101, int r102, List r103) {
        this.f199366a = r100;
        this.f199367b = r101;
        this.f199368c = r102;
        this.f199369d = r103;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L22:
        return true;
    L5:
        if ((r100 instanceof a0) == false) goto L21;
        a0 r101 = (a0) r100;
        if (this.f199366a != r101.f199366a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L21;
        if (Intrinsics.areEqual(this.f199367b, r101.f199367b) == false) goto L21;
        if (this.f199368c != r101.f199368c) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L21;
        if (Intrinsics.areEqual(this.f199369d, r101.f199369d) == false) goto L21;
    L16:
        r103 = false;
        goto L17
    L9:
        r102 = false;
    L21:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.f199366a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f199367b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (((r102 + r105) * 31) + this.f199368c) * 31;
        List r107 = this.f199369d;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "SourceExecutionResult(success=" + this.f199366a + ", deviceFp1=" + this.f199367b + ", attempts=" + this.f199368c + ", errors=" + this.f199369d + ")";
    }
}
