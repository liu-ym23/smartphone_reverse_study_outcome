package ud6;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f549736a;

    public abstract Object a(List<? extends Object> r100);

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "symbol");
        this.f549736a = r100;
    }
}
