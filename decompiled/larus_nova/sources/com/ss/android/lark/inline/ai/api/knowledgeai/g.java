package com.ss.android.lark.inline.ai.api.knowledgeai;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f426838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f426839b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f426838a, r101.f426838a) == true) goto L12;
        return false;
    L12:
        if (this.f426839b == r101.f426839b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f426838a.hashCode() * 31;
        long r101 = this.f426839b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "RecentAITopicConfig(spKey=" + this.f426838a + ", expireTimeMs=" + this.f426839b + ')';
    }

    public g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "spKey");
        this.f426838a = r100;
        this.f426839b = 1800000;
    }
}
