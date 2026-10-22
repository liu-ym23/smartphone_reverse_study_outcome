package com.larus.bmhome.creative.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {
    public static final String a(Uri r100) {
        Intrinsics.checkNotNullParameter("is_from_push", "queryParameterToRemove");
        if (r100 == null) goto L20;
        Uri.Builder r101 = r100.buildUpon();
        if (r101 == null) goto L27;
        Uri.Builder r102 = r101.clearQuery();
        if (r102 == null) goto L28;
        Iterator<String> r103 = UriProtector.getQueryParameterNames(r100).iterator();
    L11:
        if (r103.hasNext() == false) goto L19;
        String r104 = r103.next();
        if (Intrinsics.areEqual(r104, "is_from_push") == true) goto L11;
        Iterator<String> r105 = UriProtector.getQueryParameters(r100, r104).iterator();
    L16:
        if (r105.hasNext() == false) goto L11;
        r102.appendQueryParameter(r104, r105.next());
        goto L16
    L19:
        return r102.build().toString();
    L28:
        return null;
    L27:
        return null;
    L20:
        return null;
    }
}
