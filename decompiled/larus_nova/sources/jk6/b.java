package jk6;

import com.bytedance.live.richcontent.engine.SpanRendClient;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements ik6.c {
    public b() {
    }

    @Override // ik6.c
    public final void a(SpanRendClient r100, ik6.d r101) {
        Intrinsics.checkNotNullParameter(r100, "client");
        Intrinsics.checkNotNullParameter(r101, "rendItem");
        Iterator<T> r102 = r101.f490269a.f472943a.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        ek6.d r103 = (ek6.d) r102.next();
        ik6.a r104 = r100.a(r103);
        if (r104 == null) goto L4;
        r104.f(r101, r103);
        goto L4
    }
}
