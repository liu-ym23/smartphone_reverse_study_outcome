package w33;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public class e<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DATA f558140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c<DATA>> f558141b;

    public e(DATA r100) {
        this.f558140a = r100;
        this.f558141b = new ArrayList();
    }

    public final void a(c<DATA> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        ((ArrayList) this.f558141b).add(r100);
    }
}
