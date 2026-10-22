package jk6;

import com.bytedance.live.richcontent.ResourceInfo;
import com.bytedance.live.richcontent.engine.SpanRendClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements ik6.c {
    public d() {
    }

    @Override // ik6.c
    public final void a(SpanRendClient r100, ik6.d r101) {
        Intrinsics.checkNotNullParameter(r100, "client");
        Intrinsics.checkNotNullParameter(r101, "rendItem");
        Iterator<T> r102 = r101.f490269a.f472943a.iterator();
    L4:
        if (r102.hasNext() == false) goto L19;
        ek6.d r103 = (ek6.d) r102.next();
        ik6.a r104 = r100.a(r103);
        if (r104 == null) goto L4;
        List<ek6.b> r105 = r104.b(r103);
        if (r105 == null) goto L4;
        Iterator<T> r106 = r105.iterator();
    L11:
        if (r106.hasNext() == false) goto L4;
        ResourceInfo r107 = new ResourceInfo((ek6.b) r106.next(), r103);
        Intrinsics.checkNotNullParameter(r107, "resourceInfo");
        if (r101.f490273e != null) goto L15;
        r101.f490273e = new ArrayList();
    L15:
        List<ResourceInfo> r108 = r101.f490273e;
        if (r108 == null) goto L18;
        r108.add(r107);
    L18:
        r104.d(r101, r103, r107.f255740a);
        goto L11
    }
}
