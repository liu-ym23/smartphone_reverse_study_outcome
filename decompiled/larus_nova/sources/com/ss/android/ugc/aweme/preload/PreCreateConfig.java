package com.ss.android.ugc.aweme.preload;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/preload/PreCreateConfig;", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PreCreateConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f451370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f451371b;

    public PreCreateConfig() {
        this(0, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreCreateConfig) == true) goto L8;
        return false;
    L8:
        PreCreateConfig r101 = (PreCreateConfig) r100;
        if (this.f451370a == r101.f451370a) goto L12;
        return false;
    L12:
        if (this.f451371b == r101.f451371b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f451370a * 31;
        if (this.f451371b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "PreCreateConfig(count=" + this.f451370a + ", async=" + this.f451371b + ')';
    }

    public PreCreateConfig(int r100, boolean r101) {
        this.f451370a = r100;
        this.f451371b = r101;
    }
}
