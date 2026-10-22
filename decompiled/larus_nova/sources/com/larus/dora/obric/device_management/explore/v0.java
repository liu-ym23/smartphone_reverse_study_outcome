package com.larus.dora.obric.device_management.explore;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraObricGlassesExploreSectionType f339597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f339598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d1 f339599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<r0> f339600d;

    public final DoraObricGlassesExploreSectionType getType() {
        return this.f339597a;
    }

    public v0(DoraObricGlassesExploreSectionType r100, String r101, d1 r102, List<r0> r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, "items");
        this.f339597a = r100;
        this.f339598b = r101;
        this.f339599c = r102;
        this.f339600d = r103;
    }
}
