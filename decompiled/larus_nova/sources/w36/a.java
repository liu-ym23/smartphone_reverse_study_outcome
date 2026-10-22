package w36;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final String a(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100.isHierarchical() == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return null;
    L8:
        return UriProtector.getQueryParameter(r100, r101);
    }

    public static final Uri b(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "queryParameterName");
        if (r100.isHierarchical() == true) goto L5;
        return r100;
    L5:
        Uri.Builder r102 = r100.buildUpon().clearQuery();
        Iterator<String> r103 = UriProtector.getQueryParameterNames(r100).iterator();
    L7:
        if (r103.hasNext() == false) goto L15;
        String r104 = r103.next();
        if (Intrinsics.areEqual(r104, r101) == true) goto L7;
        Iterator<String> r105 = UriProtector.getQueryParameters(r100, r104).iterator();
    L12:
        if (r105.hasNext() == false) goto L7;
        r102.appendQueryParameter(r104, r105.next());
        goto L12
    L15:
        return r102.build();
    }

    public static final Uri c(Uri r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "queryParameterNames");
        if (r100.isHierarchical() == true) goto L5;
        return r100;
    L5:
        Uri.Builder r102 = r100.buildUpon().clearQuery();
        Iterator<String> r103 = UriProtector.getQueryParameterNames(r100).iterator();
    L7:
        if (r103.hasNext() == false) goto L15;
        String r104 = r103.next();
        if (r101.contains(r104) == true) goto L7;
        Iterator<String> r105 = UriProtector.getQueryParameters(r100, r104).iterator();
    L12:
        if (r105.hasNext() == false) goto L7;
        r102.appendQueryParameter(r104, r105.next());
        goto L12
    L15:
        return r102.build();
    }
}
