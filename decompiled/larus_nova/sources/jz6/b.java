package jz6;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static final Uri a(Uri r100, Map<String, String> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "params");
        Uri.Builder r103 = r100.buildUpon();
        if (r102 == false) goto L11;
        Map<String, String> r104 = MapsKt.toMutableMap(r101);
        r103.clearQuery();
        Iterator<T> r105 = UriProtector.getQueryParameterNames(r100).iterator();
    L6:
        if (r105.hasNext() == false) goto L10;
        String r106 = (String) r105.next();
        if (r101.containsKey(r106) == true) goto L6;
        r104.put(r106, UriProtector.getQueryParameter(r100, r106));
        goto L6
    L10:
        r101 = r104;
    L11:
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r108 = r101.entrySet().iterator();
    L13:
        if (r108.hasNext() == false) goto L17;
        Map.Entry<String, String> r109 = r108.next();
        if (ap6.a.b(r109.getValue()) == false) goto L13;
        r107.put(r109.getKey(), r109.getValue());
        goto L13
    L17:
        Iterator r110 = r107.entrySet().iterator();
    L19:
        if (r110.hasNext() == false) goto L22;
        Map.Entry r111 = (Map.Entry) r110.next();
        r103.appendQueryParameter((String) r111.getKey(), (String) r111.getValue());
        goto L19
    L22:
        return r103.build();
    }
}
