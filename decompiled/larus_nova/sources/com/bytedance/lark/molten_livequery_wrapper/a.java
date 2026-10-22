package com.bytedance.lark.molten_livequery_wrapper;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f253352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Long> f253353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Long> f253354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<e> f253355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<e> f253356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<e> f253357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<e> f253358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f253359h;

    public final String toString() {
        return "DiffResult(isEmpty=" + this.f253352a + ", insertSections=" + this.f253353b + ", deleteSections=" + this.f253354c + ", insertItems=" + this.f253355d + ", deleteItems=" + this.f253356e + ", reloadItemsFrom=" + this.f253357f + ", reloadItemsTo=" + this.f253358g + ", keyChange=" + Arrays.toString(this.f253359h) + ')';
    }

    public final int hashCode() {
        if (this.f253352a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((((((((((r100 * 31) + this.f253353b.hashCode()) * 31) + this.f253354c.hashCode()) * 31) + this.f253355d.hashCode()) * 31) + this.f253356e.hashCode()) * 31) + this.f253357f.hashCode()) * 31) + this.f253358g.hashCode()) * 31;
        byte[] r102 = this.f253359h;
        if (r102 == null) goto L9;
        int r103 = Arrays.hashCode(r102);
    L11:
        return r101 + r103;
    L9:
        r103 = 0;
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f253352a == r101.f253352a) goto L11;
    L33:
        return false;
    L11:
        if (Intrinsics.areEqual(this.f253353b, r101.f253353b) == false) goto L33;
        if (Intrinsics.areEqual(this.f253354c, r101.f253354c) == false) goto L33;
        if (Intrinsics.areEqual(this.f253355d, r101.f253355d) == false) goto L33;
        if (Intrinsics.areEqual(this.f253356e, r101.f253356e) == false) goto L33;
        if (Intrinsics.areEqual(this.f253357f, r101.f253357f) == false) goto L33;
        if (Intrinsics.areEqual(this.f253358g, r101.f253358g) == false) goto L33;
        byte[] r102 = this.f253359h;
        if (r102 == null) goto L30;
        byte[] r103 = r101.f253359h;
        if (r103 != null) goto L28;
        r103 = new byte[0];
    L28:
        if (Arrays.equals(r102, r103) != true) goto L30;
        boolean r104 = true;
    L31:
        if (r104 == false) goto L33;
        return true;
    L30:
        r104 = false;
        goto L31
    }

    public a(boolean r100, List<Long> r101, List<Long> r102, List<e> r103, List<e> r104, List<e> r105, List<e> r106, byte[] r107) {
        Intrinsics.checkNotNullParameter(r101, "insertSections");
        Intrinsics.checkNotNullParameter(r102, "deleteSections");
        Intrinsics.checkNotNullParameter(r103, "insertItems");
        Intrinsics.checkNotNullParameter(r104, "deleteItems");
        Intrinsics.checkNotNullParameter(r105, "reloadItemsFrom");
        Intrinsics.checkNotNullParameter(r106, "reloadItemsTo");
        this.f253352a = r100;
        this.f253353b = r101;
        this.f253354c = r102;
        this.f253355d = r103;
        this.f253356e = r104;
        this.f253357f = r105;
        this.f253358g = r106;
        this.f253359h = r107;
    }
}
