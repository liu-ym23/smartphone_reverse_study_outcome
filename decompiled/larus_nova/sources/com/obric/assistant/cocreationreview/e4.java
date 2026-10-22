package com.obric.assistant.cocreationreview;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387270b;

    public final Map<String, String> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("recommend_task_type", "omni_mobile_task"), TuplesKt.to("recommend_task_origin_query", this.f387270b)});
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e4) == true) goto L8;
        return false;
    L8:
        e4 r101 = (e4) r100;
        if (Intrinsics.areEqual(this.f387269a, r101.f387269a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387270b, r101.f387270b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f387269a.hashCode() * 31) + this.f387270b.hashCode();
    }

    public final String toString() {
        return "CocreationTask(id=" + this.f387269a + ", prompt=" + this.f387270b + ')';
    }

    public e4(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.RETAIN_PROMPT);
        this.f387269a = r100;
        this.f387270b = r101;
    }
}
