package com.bytedance.navigation.kmp.handler.tracker;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e37.j f265928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f265929b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f265928a, r101.f265928a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f265929b, r101.f265929b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f265928a.hashCode() * 31) + this.f265929b.hashCode();
    }

    public final String toString() {
        return "NavigationVoiceTraceToken(context=" + this.f265928a + ", navigationId=" + this.f265929b + ")";
    }

    public final e37.j getContext() {
        return this.f265928a;
    }

    public l(e37.j r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "navigationId");
        this.f265928a = r100;
        this.f265929b = r101;
    }
}
