package com.bytedance.ug.sdk.luckydog.api.task.taskmanager;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f271707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f271708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f271709c;

    public final Map<String, Object> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("session_id", this.f271707a), TuplesKt.to("index", Integer.valueOf(this.f271708b)), TuplesKt.to("global_task_id", this.f271709c)});
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L17:
        return true;
    L5:
        if ((r100 instanceof f) == false) goto L16;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f271707a, r101.f271707a) == false) goto L16;
        if (this.f271708b != r101.f271708b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L16;
        if (Intrinsics.areEqual(this.f271709c, r101.f271709c) == false) goto L16;
    L11:
        r102 = false;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f271707a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f271708b) * 31;
        String r104 = this.f271709c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FullPathParams(sessionId=" + this.f271707a + ", index=" + this.f271708b + ", globalTaskId=" + this.f271709c + ")";
    }

    public f(String r100, String r101) {
        this.f271707a = r100;
        this.f271708b = 1;
        this.f271709c = r101;
    }
}
