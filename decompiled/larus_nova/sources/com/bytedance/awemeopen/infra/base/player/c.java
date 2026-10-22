package com.bytedance.awemeopen.infra.base.player;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f198738a = 0;

    static {
    }

    public static void a(j r100) {
        if ((System.currentTimeMillis() / ((long) 1000)) < r100.f198766h) goto L14;
        List<i> r101 = r100.f198759a;
        if (r101 != null) goto L7;
        return;
    L7:
        int r102 = r101.size();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L18;
        i r104 = (i) ListProtector.get(r101, r103);
        List<String> r105 = r104.f198757j;
        if (r105 == null) goto L13;
        Intrinsics.checkNotNull(r105);
        r105 = CollectionsKt.mutableListOf(new String[]{(String) CollectionsKt.last(r105)});
    L13:
        r104.f198757j = r105;
        r103 = r103 + 1;
        goto L8
    L18:
        return;
    }

    public static List b(List r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        j r103 = (j) r102.next();
        a(r103);
        r101.add(c(r103));
        goto L4
    L6:
        return r101;
    }

    public static r64.b c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "playRequest");
        a(r100);
        r64.b r101 = new r64.b();
        String r102 = r100.f198763e;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f536335b = r102;
        long r103 = r100.f198761c;
        if (r103 < 0) goto L8;
        long r104 = r100.f198762d;
        if (r104 > 0) goto L7;
    L9:
        r101.f536334a = r103;
        String r105 = r100.f198763e;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r101.f536335b = r105;
        r101.f536337d = r100.f198765g;
        List<i> r106 = r100.f198759a;
        if (r106 == null) goto L15;
        List<i> r107 = r106;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
    L13:
        if (r109.hasNext() == false) goto L16;
        i r110 = (i) r109.next();
        r64.a r111 = new r64.a(r110.f198748a);
        Intrinsics.checkNotNullParameter(r110.f198749b, "<set-?>");
        r111.f536331a = r110.f198754g;
        Intrinsics.checkNotNullParameter(r110.f198750c, "<set-?>");
        String r112 = r110.f198756i;
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r111.f536332b = r112;
        r111.f536333c = r110.f198757j;
        Intrinsics.checkNotNullParameter(r110.f198758k, "<set-?>");
        r108.add(r111);
    L16:
        r101.f536336c = r108;
        r101.f536338e = r100.f198768j;
        r101.f536339f = null;
        r101.f536340g = r100.f198770l;
        r101.f536341h = r100.f198771m;
        return r101;
    L15:
        r108 = null;
        goto L16
    L7:
        if (r103 <= r104) goto L9;
    L8:
        r103 = 0;
        goto L9
    }
}
