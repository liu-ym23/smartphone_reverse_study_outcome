package mo5;

import com.bytedance.ee.bear.tts.impl.TtsAlbumViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public static final String a(g r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        j r2 = (j) r1.i().getValue();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.a;
    }

    public static final Integer b(g r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        j r2 = (j) r1.i().getValue();
        if (r2 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r2.b);
    }

    public static final List<g> d(a r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return (List) r1.b().getValue();
    }

    public static final g e(a r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        i r2 = (i) r1.e().getValue();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (g) r2.b;
    }

    public static final int c(TtsAlbumViewModel r3, g r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "itemVM");
        List r5 = (List) r3.b().getValue();
        if (r5 == null) goto L11;
        Iterator r6 = r5.iterator();
        int r0 = 0;
    L6:
        if (r6.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((g) r6.next()).a(), r4.a()) == true) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        return r0;
    L15:
        return -1;
    L11:
        return -1;
    }
}
