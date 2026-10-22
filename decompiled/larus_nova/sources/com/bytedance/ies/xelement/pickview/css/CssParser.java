package com.bytedance.ies.xelement.pickview.css;

import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class CssParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f250307a = null;

    static {
        f250307a = LazyKt.lazy(CssParser$knownCssProperties$2.INSTANCE);
    }

    public static List a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cssString");
        List r101 = StringsKt.split$default(r100, new String[]{i.f25853b}, false, 0, 6, null);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        List r104 = StringsKt.split$default((String) r103.next(), new String[]{":"}, false, 0, 6, null);
        if (r104.size() != 2) goto L8;
        Pair r105 = new Pair(StringsKt.trim((String) ListProtector.get(r104, 0)).toString(), StringsKt.trim((String) ListProtector.get(r104, 1)).toString());
    L9:
        r102.add(r105);
        goto L4
    L8:
        r105 = null;
        goto L9
    L10:
        List r106 = CollectionsKt.filterNotNull(r102);
        ArrayList r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L12:
        if (r108.hasNext() == false) goto L16;
        Object r109 = r108.next();
        if (((List) f250307a.getValue()).contains(((Pair) r109).getFirst()) == false) goto L12;
        r107.add(r109);
        goto L12
    L16:
        return r107;
    }
}
