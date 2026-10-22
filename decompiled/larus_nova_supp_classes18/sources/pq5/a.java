package pq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final boolean a(j r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (c.a(b.c(r3.n, 0)) == true) goto L5;
        return false;
    L5:
        if (r3.o == 1) goto L7;
        return false;
    L7:
        if (c.a(r3.f) == true) goto L12;
        return true;
    L12:
        return false;
    }
}
