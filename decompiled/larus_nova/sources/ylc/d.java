package ylc;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f568353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f568354b;

    public /* synthetic */ d() {
        this(20, SetsKt.emptySet());
    }

    public d(int r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r101, "heartbeatKeyWhiteList");
        this.f568353a = r100;
        this.f568354b = r101;
    }
}
