package lx9;

import com.larus.suggest.impl.wcb.model.WcbSurface;
import com.larus.suggest.impl.wcb.policy.z;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WcbSurface f511239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<z> f511240b;

    public c(WcbSurface r100) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        this.f511239a = r100;
        this.f511240b = new AtomicReference(null);
    }
}
