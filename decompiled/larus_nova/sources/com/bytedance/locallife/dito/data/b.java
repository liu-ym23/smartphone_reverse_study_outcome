package com.bytedance.locallife.dito.data;

import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseDitoView<?> f258195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseDitoModel<?> f258196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f258197c;

    public b(BaseDitoView<?> r100, BaseDitoModel<?> r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "ditoView");
        Intrinsics.checkNotNullParameter(r102, "dataMap");
        this.f258195a = r100;
        this.f258196b = r101;
        this.f258197c = r102;
    }
}
