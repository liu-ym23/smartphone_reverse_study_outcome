package com.larus.dora.obric.device_management.explore;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f339490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f339491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f339492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f339493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraObricGlassesExploreActionStateType f339494e;

    public a0(String r100, String r101, String r102, Map<String, String> r103, DoraObricGlassesExploreActionStateType r104) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "title");
        this.f339490a = r100;
        this.f339491b = r101;
        this.f339492c = r102;
        this.f339493d = r103;
        this.f339494e = r104;
    }
}
