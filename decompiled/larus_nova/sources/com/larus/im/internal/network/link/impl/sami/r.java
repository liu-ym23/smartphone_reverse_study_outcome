package com.larus.im.internal.network.link.impl.sami;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f349491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f349492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f349493c;

    public final void setResult(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f349493c = r100;
    }

    public r(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f349492b = "Success";
        this.f349491a = 0;
        this.f349492b = r100;
        setResult(Boolean.valueOf(r101));
    }

    public r(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f349492b = "Success";
        this.f349491a = r100;
        this.f349492b = r101;
    }
}
