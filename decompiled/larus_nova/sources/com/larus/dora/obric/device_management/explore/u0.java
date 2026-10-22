package com.larus.dora.obric.device_management.explore;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraObricGlassesExploreSectionType f339594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f339595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<q0> f339596c;

    public final DoraObricGlassesExploreSectionType getType() {
        return this.f339594a;
    }

    public u0(DoraObricGlassesExploreSectionType r100, String r101, String r102, List<q0> r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "title");
        this.f339594a = r100;
        this.f339595b = r102;
        this.f339596c = r103;
    }
}
