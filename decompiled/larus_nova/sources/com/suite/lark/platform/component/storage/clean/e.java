package com.suite.lark.platform.component.storage.clean;

import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class e implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f460603b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<j> f460604a;

    public static final class a {
    }

    static {
    }

    @Override // com.suite.lark.platform.component.storage.clean.k
    public final Set<j> a() {
        return this.f460604a;
    }

    @Inject
    public e(Set<j> r100) {
        Intrinsics.checkNotNullParameter(r100, "cleanModules");
        this.f460604a = r100;
    }
}
