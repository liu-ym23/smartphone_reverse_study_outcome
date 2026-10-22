package nd9;

import com.larus.im.service.audio.z0;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vt7.b<z0> f518811a;

    public d() {
        this.f518811a = new vt7.b();
    }

    public final void a(Function1<? super z0, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (this.f518811a.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<z0> r101 = this.f518811a.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r100.invoke(r101.next());
        goto L7
    }
}
