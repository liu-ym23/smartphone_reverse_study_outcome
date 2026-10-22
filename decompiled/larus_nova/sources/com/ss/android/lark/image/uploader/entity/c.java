package com.ss.android.lark.image.uploader.entity;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f426410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f426411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Integer> f426412c;

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uploadToken");
        this.f426410a = r100;
        this.f426411b = CollectionsKt.emptyList();
        this.f426412c = MapsKt.emptyMap();
    }
}
