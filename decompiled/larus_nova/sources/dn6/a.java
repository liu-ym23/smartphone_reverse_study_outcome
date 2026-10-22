package dn6;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a {
    public static final List<Pair<String, String>> a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Set<String> r101 = UriProtector.getQueryParameterNames(r100);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        String r104 = (String) r103.next();
        String r105 = UriProtector.getQueryParameter(r100, r104);
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r102.add(TuplesKt.to(r104, r105));
        goto L4
    L9:
        return r102;
    }
}
