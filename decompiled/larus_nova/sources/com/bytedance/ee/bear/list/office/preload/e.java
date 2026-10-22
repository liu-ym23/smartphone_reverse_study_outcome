package com.bytedance.ee.bear.list.office.preload;

import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f229152e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f229153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f229154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Document> f229155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f229156d;

    public static final class a {
        public static e a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            return new e(false, r100, new ArrayList(), null);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f229153a == r101.f229153a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f229154b, r101.f229154b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f229155c, r101.f229155c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f229156d, r101.f229156d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f229153a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.f229154b.hashCode()) * 31) + this.f229155c.hashCode()) * 31;
        g r102 = this.f229156d;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeSpacePreloadConsumeResult(hit=" + this.f229153a + ", reason=" + this.f229154b + ", documents=" + this.f229155c + ", entry=" + this.f229156d + ')';
    }

    public e(boolean r100, String r101, ArrayList<Document> r102, g r103) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r102, "documents");
        this.f229153a = r100;
        this.f229154b = r101;
        this.f229155c = r102;
        this.f229156d = r103;
    }
}
