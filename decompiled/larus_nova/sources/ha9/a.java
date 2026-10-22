package ha9;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f484411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f484412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, ga9.f<?>> f484413c;

    public a() {
        g r100 = g.f484424a;
        Intrinsics.checkNotNullParameter(r100, "reporter");
        this.f484411a = r100;
        this.f484412b = false;
        this.f484413c = new ConcurrentHashMap();
    }
}
