package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f200693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BdpTask.Builder f200694b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e0) == false) goto L10;
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f200693a, r101.f200693a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f200694b, r101.f200694b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        i0 r100 = this.f200693a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        BdpTask.Builder r104 = this.f200694b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PopTaskBuilder(switchType=" + this.f200693a + ", builder=" + this.f200694b + ")";
    }

    public e0(i0 r100, BdpTask.Builder r101) {
        this.f200693a = r100;
        this.f200694b = r101;
    }
}
