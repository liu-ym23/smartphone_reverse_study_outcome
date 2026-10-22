package com.bytedance.lark.molten_livequery;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f253333i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f253334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Long> f253335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Long> f253336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<g> f253337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<g> f253338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<g> f253339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<g> f253340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f253341h;

    public static final class a {
        public a() {
        }
    }

    static {
        f253333i = new a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f253334a == r101.f253334a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253335b, r101.f253335b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f253336c, r101.f253336c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f253337d, r101.f253337d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f253338e, r101.f253338e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f253339f, r101.f253339f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f253340g, r101.f253340g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f253341h, r101.f253341h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        if (this.f253334a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((((((((((r100 * 31) + this.f253335b.hashCode()) * 31) + this.f253336c.hashCode()) * 31) + this.f253337d.hashCode()) * 31) + this.f253338e.hashCode()) * 31) + this.f253339f.hashCode()) * 31) + this.f253340g.hashCode()) * 31;
        byte[] r102 = this.f253341h;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = Arrays.hashCode(r102);
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "LiveQueryDiffs(isEmpty=" + this.f253334a + ", insertSections=" + this.f253335b + ", deleteSections=" + this.f253336c + ", insertItems=" + this.f253337d + ", deleteItems=" + this.f253338e + ", reloadItemsFrom=" + this.f253339f + ", reloadItemsTo=" + this.f253340g + ", keyChange=" + Arrays.toString(this.f253341h) + ')';
    }

    public f(boolean r100, List<Long> r101, List<Long> r102, List<g> r103, List<g> r104, List<g> r105, List<g> r106, byte[] r107) {
        Intrinsics.checkNotNullParameter(r101, "insertSections");
        Intrinsics.checkNotNullParameter(r102, "deleteSections");
        Intrinsics.checkNotNullParameter(r103, "insertItems");
        Intrinsics.checkNotNullParameter(r104, "deleteItems");
        Intrinsics.checkNotNullParameter(r105, "reloadItemsFrom");
        Intrinsics.checkNotNullParameter(r106, "reloadItemsTo");
        this.f253334a = r100;
        this.f253335b = r101;
        this.f253336c = r102;
        this.f253337d = r103;
        this.f253338e = r104;
        this.f253339f = r105;
        this.f253340g = r106;
        this.f253341h = r107;
    }
}
