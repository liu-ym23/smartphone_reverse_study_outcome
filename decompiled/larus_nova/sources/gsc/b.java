package gsc;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Regex f482485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<Integer>> f482486b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Regex r100, Map<String, ? extends List<Integer>> r101) {
        Intrinsics.checkNotNullParameter(r100, "expression");
        Intrinsics.checkNotNullParameter(r101, "indexes");
        this.f482485a = r100;
        this.f482486b = r101;
    }
}
