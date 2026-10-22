package com.bytedance.gkfs.io;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f245240e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f245241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f245242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.gkfs.cdc.c f245243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f245244d;

    public static final class a {
        public static o a(File r210, PolarisFileWrapper r211, Throwable r212, GkFSError r213) {
            return new o(new k(r211, new m(0, 0, 7), CollectionsKt.emptyList()), r210, com.bytedance.gkfs.cdc.c.f245150g, new n(new p(false, r212, r213), 0, 0, null, 0, 0, 0, 254));
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L14;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f245241a, r101.f245241a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f245242b, r101.f245242b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f245243c, r101.f245243c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f245244d, r101.f245244d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        k r100 = this.f245241a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        File r104 = this.f245242b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        com.bytedance.gkfs.cdc.c r107 = this.f245243c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        n r110 = this.f245244d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GkFSOutputInfo(meta=" + this.f245241a + ", originFile=" + this.f245242b + ", cdcStatistics=" + this.f245243c + ", storeStatistics=" + this.f245244d + ")";
    }

    public o(k r100, File r101, com.bytedance.gkfs.cdc.c r102, n r103) {
        this.f245241a = r100;
        this.f245242b = r101;
        this.f245243c = r102;
        this.f245244d = r103;
    }
}
