package com.ss.android.lark.framework.assembly.diskmanage;

import ebb.g;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<Set<g>> f425631a;

    @Override // com.ss.android.lark.framework.assembly.diskmanage.d
    public final List<g> a() {
        return CollectionsKt.toList(this.f425631a.get());
    }

    @Inject
    public b(Provider<Set<g>> r100) {
        Intrinsics.checkNotNullParameter(r100, "cleanTasks");
        this.f425631a = r100;
    }
}
