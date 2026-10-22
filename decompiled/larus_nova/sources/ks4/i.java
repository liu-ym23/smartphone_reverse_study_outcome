package ks4;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i {
    static {
    }

    public static JavaOnlyArray a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        JavaOnlyArray r101 = new JavaOnlyArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();
        if ((r103 instanceof Map) == true) goto L7;
        if ((r103 instanceof List) == true) goto L10;
        r101.add(r103);
        goto L4
    L10:
        r101.add(a((List) r103));
        goto L4
    L7:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        r101.add(b((Map) r103));
        goto L4
    L12:
        return r101;
    }

    public static JavaOnlyMap b(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        JavaOnlyMap r101 = new JavaOnlyMap();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if ((r105 instanceof Map) == true) goto L7;
        if ((r105 instanceof List) == true) goto L10;
        r101.put(r104, r105);
        goto L4
    L10:
        r101.put(r104, a((List) r105));
        goto L4
    L7:
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        r101.put(r104, b((Map) r105));
        goto L4
    L12:
        return r101;
    }
}
