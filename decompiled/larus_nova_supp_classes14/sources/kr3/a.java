package kr3;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return "";
    L13:
        if (StringsKt.startsWith$default(r4, "/", false, 2, null) == false) goto L16;
        return r4;
    L16:
        return "/" + r4;
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static Uri b(Uri r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "queryParameterName");
        Intrinsics.checkNotNullParameter(r7, "queryParameterValue");
        if (r5.isHierarchical() == true) goto L5;
        return r5;
    L5:
        Uri.Builder r0 = r5.buildUpon().clearQuery();
        Iterator r1 = UriProtector.getQueryParameterNames(r5).iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        String r2 = (String) r1.next();
        if (Intrinsics.areEqual(r2, r6) == false) goto L10;
        r0.appendQueryParameter(r6, r7);
        goto L7
    L10:
        Iterator r3 = UriProtector.getQueryParameters(r5, r2).iterator();
    L12:
        if (r3.hasNext() == false) goto L7;
        r0.appendQueryParameter(r2, (String) r3.next());
        goto L12
    L16:
        return r0.build();
    }
}
