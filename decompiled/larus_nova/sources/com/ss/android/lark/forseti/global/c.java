package com.ss.android.lark.forseti.global;

import com.ss.android.lark.api.bean.ForsetiScreenMode;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ForsetiViewMode f424463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ForsetiScreenMode f424464b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f424463a == r101.f424463a) goto L12;
        return false;
    L12:
        if (this.f424464b == r101.f424464b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f424463a.hashCode() * 31) + this.f424464b.hashCode();
    }

    public final String toString() {
        return "ForsetiChainManagerExtraInfo(viewMode=" + this.f424463a + ", screenMode=" + this.f424464b + ')';
    }

    public c(ForsetiViewMode r100, ForsetiScreenMode r101) {
        Intrinsics.checkNotNullParameter(r100, "viewMode");
        Intrinsics.checkNotNullParameter(r101, "screenMode");
        this.f424463a = r100;
        this.f424464b = r101;
    }
}
