package com.relax.relaxframework;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f405029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f405030b;

    public c(Map<String, Map<String, Object>> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f405029a = r100;
        this.f405030b = r101;
    }
}
