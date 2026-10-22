package com.larus.dora.obric.device_management.explore;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f339503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d1 f339504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d1 f339505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f339506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraObricGlassesExploreActionStateType f339507e;

    public b0(String r100, d1 r101, d1 r102, Map<String, String> r103, DoraObricGlassesExploreActionStateType r104) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r103, "extras");
        this.f339503a = r100;
        this.f339504b = r101;
        this.f339505c = r102;
        this.f339506d = r103;
        this.f339507e = r104;
    }
}
