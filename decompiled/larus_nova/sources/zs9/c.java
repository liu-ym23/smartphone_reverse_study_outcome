package zs9;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f573498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f573499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<b> f573500c;

    public c() {
        this.f573500c = CollectionsKt.emptyList();
    }

    public final void a(List<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f573500c = r100;
    }
}
