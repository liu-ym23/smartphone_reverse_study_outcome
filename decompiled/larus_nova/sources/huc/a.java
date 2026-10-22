package huc;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class a<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e<T>> f487263a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends e<? super T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "formatters");
        this.f487263a = r100;
    }
}
