package si8;

import com.larus.bmhome.video.Content;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import oi8.k;
import pi8.o;

/* JADX INFO: loaded from: classes25.dex */
public final class b implements pi8.a {
    public b() {
    }

    @Override // pi8.a
    public final o a(k r100, oi8.c r101) {
        Intrinsics.checkNotNullParameter(r100, "originData");
        ArrayList r102 = new ArrayList();
        com.larus.bmhome.chat.search.b r103 = r100.e();
        if (r103 == null) goto L7;
        com.larus.bmhome.chat.search.b.C4070b r104 = r103.d();
        if (r104 == null) goto L7;
        List<Content> r105 = r104.a();
    L8:
        List<Content> r106 = r105;
        if (r106 != null) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == true) goto L17;
        Iterator<T> r108 = r105.iterator();
    L20:
        if (r108.hasNext() == false) goto L23;
        r102.add((Content) r108.next());
        goto L20
    L23:
        return new o(r102, true);
    L17:
        return new o(r102, true);
    L11:
        if (r106.isEmpty() == true) goto L14;
        r107 = false;
    L7:
        r105 = null;
        goto L8
    }
}
