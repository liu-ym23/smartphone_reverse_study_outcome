package yjb;

import androidx.core.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f568115a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(List r100) {
        if (r100 == null) goto L7;
        List r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L5:
        if (r103.hasNext() == false) goto L9;
        Pair r104 = (Pair) r103.next();
        r102.add(new Pair(((xjb.a) r104.first).a(), Integer.valueOf(((List) r104.second).size())));
    L9:
        return String.valueOf(r102);
    L7:
        r102 = null;
        goto L9
    }
}
