package com.bytedance.livesdk.ktvcommon.download.model;

import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f255954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f255955b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f255954a, r101.f255954a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f255955b, r101.f255955b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<f> r100 = this.f255954a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f255955b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DownloadBatch(batch=" + this.f255954a + ", description=" + this.f255955b + ")";
    }

    public c(List<f> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, OPTrace.BATCH_DATA_KEY);
        Intrinsics.checkNotNullParameter(r101, "description");
        this.f255954a = r100;
        this.f255955b = r101;
    }
}
