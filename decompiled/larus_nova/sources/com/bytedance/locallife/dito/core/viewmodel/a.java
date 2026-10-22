package com.bytedance.locallife.dito.core.viewmodel;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f258064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f258065b;

    public a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter("component_data_show", "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f258064a = r100;
        this.f258065b = r101;
    }
}
