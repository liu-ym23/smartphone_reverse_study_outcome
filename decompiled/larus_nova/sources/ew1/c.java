package ew1;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c {
    public static final String a(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "cleanArgs");
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L11
        Uri.Builder r103 = r102.buildUpon();     // Catch: Throwable -> L11
        r103.clearQuery();     // Catch: Throwable -> L11
        Iterator<T> r104 = UriProtector.getQueryParameterNames(r102).iterator();     // Catch: Throwable -> L11
    L5:
        if (r104.hasNext() == false) goto L9;
        String r105 = (String) r104.next();     // Catch: Throwable -> L11
        if (r101.contains(r105) == true) goto L5;
        r103.appendQueryParameter(r105, UriProtector.getQueryParameter(r102, r105));     // Catch: Throwable -> L11
        goto L5
    L9:
        return r103.build().toString();
    L19:
        return r100;
    }
}
