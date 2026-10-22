package com.bytedance.locallife.live.util;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f260704a = 0;

    static {
    }

    public static Map b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = UriProtector.getQueryParameterNames(r100).iterator();     // Catch: Exception -> L9
    L5:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();     // Catch: Exception -> L9
        r101.put(r103, UriProtector.getQueryParameter(r100, r103));     // Catch: Exception -> L9
    L8:
        return r101;
    }

    public static Uri a(Uri r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "keys");
        if (r101.isEmpty() == false) goto L5;
        return r100;
    L5:
        Set<String> r102 = UriProtector.getQueryParameterNames(r100);
        if (r102 != null) goto L8;
        return r100;
    L8:
        Uri.Builder r103 = r100.buildUpon().clearQuery();
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L10:
        if (r105.hasNext() == false) goto L14;
        Object r106 = r105.next();
        if ((!r101.contains((String) r106)) == false) goto L10;
        r104.add(r106);
        goto L10
    L14:
        Iterator r107 = r104.iterator();
    L16:
        if (r107.hasNext() == false) goto L19;
        String r108 = (String) r107.next();
        r103.appendQueryParameter(r108, UriProtector.getQueryParameter(r100, r108));
        goto L16
    L19:
        return r103.build();
    }
}
