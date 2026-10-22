package com.bytedance.locallife.dito.common.plugin;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f257544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f257545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f257546c;

    public a(int r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        LinkedHashMap r102 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r101, "subThreadTimestamps");
        Intrinsics.checkNotNullParameter(r102, "mainThreadTimestamps");
        this.f257544a = r101;
        this.f257545b = r102;
        this.f257546c = null;
    }
}
