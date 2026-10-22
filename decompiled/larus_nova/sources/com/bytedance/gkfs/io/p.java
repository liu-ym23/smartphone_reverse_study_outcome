package com.bytedance.gkfs.io;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f245245d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f245246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f245247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GkFSError f245248c;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L12;
        p r101 = (p) r100;
        if (this.f245246a == r101.f245246a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f245247b, r101.f245247b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f245248c, r101.f245248c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.f245246a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        Throwable r103 = this.f245247b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        GkFSError r107 = this.f245248c;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "GkFSStatus(isSuccess=" + this.f245246a + ", error=" + this.f245247b + ", errorCode=" + this.f245248c + ")";
    }

    static {
        f245245d = new p(true, null, GkFSError.NO_ERROR);
    }

    public p(boolean r100, Throwable r101, GkFSError r102) {
        this.f245246a = r100;
        this.f245247b = r101;
        this.f245248c = r102;
    }
}
