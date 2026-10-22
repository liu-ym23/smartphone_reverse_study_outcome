package mo5;

import com.bytedance.ee.bear.tts.impl.TtsAlbumViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h {
    /* JADX WARN: Multi-variable type inference failed */
    public static final String a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        j r101 = (j) r100.i().getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f514586a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Integer b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        j r101 = (j) r100.i().getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r101.f514587b);
    }

    public static final List<g> d(a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (List) r100.b().getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final g e(a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        i r101 = (i) r100.e().getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return (g) r101.f514585b;
    }

    public static final int c(TtsAlbumViewModel r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "itemVM");
        List r102 = (List) r100.b().getValue();
        if (r102 == null) goto L11;
        Iterator r103 = r102.iterator();
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((g) r103.next()).a(), r101.a()) == true) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return r104;
    L15:
        return -1;
    L11:
        return -1;
    }
}
