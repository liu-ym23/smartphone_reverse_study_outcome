package mp0;

import com.bytedance.android.scope.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f514697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final lp0.a f514698b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        Iterator r100 = ((ArrayList) this.f514697a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((d) r100.next()).onStop();
        goto L4
    }

    public c(lp0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f514698b = r100;
        this.f514697a = new ArrayList();
    }
}
