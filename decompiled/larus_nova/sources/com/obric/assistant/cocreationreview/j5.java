package com.obric.assistant.cocreationreview;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class j5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f387335a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j5) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f387335a, ((j5) r100).f387335a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f387335a.hashCode();
    }

    public final String toString() {
        return "ModuleCardBuildContext(context=" + this.f387335a + ')';
    }

    public final Context getContext() {
        return this.f387335a;
    }

    public j5(CocreationReviewActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f387335a = r100;
    }
}
