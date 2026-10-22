package p9a;

import android.net.Uri;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class f {
    public static final String a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<String> r101 = r100.getPathSegments();
        if (r101 == null) goto L5;
        String r102 = (String) CollectionsKt.firstOrNull(r101);
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static final String b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getHost();
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }
}
