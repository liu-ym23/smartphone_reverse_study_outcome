package com.bytedance.gkfs.io;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f245214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f245215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<d> f245216c;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L12;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f245214a, r101.f245214a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f245215b, r101.f245215b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f245216c, r101.f245216c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        File r100 = this.f245214a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        m r104 = this.f245215b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<d> r107 = this.f245216c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GkFSFileMeta(majorFile=" + this.f245214a + ", header=" + this.f245215b + ", chunks=" + this.f245216c + ")";
    }

    static {
        new PolarisFileWrapper("");
        m r100 = m.f245226d;
        m r101 = m.f245226d;
        CollectionsKt.emptyList();
    }

    public k(File r100, m r101, List<d> r102) {
        this.f245214a = r100;
        this.f245215b = r101;
        this.f245216c = r102;
    }
}
