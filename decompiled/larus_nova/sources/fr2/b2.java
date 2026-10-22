package fr2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b2 implements ti6.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f478492a;

    public b2(o r100) {
        Intrinsics.checkNotNullParameter(r100, "mixer");
        this.f478492a = r100;
    }

    @Override // ti6.j
    public final boolean b(aj6.d r100, aj6.b r101) {
        Intrinsics.checkNotNullParameter(r100, "audiencePos");
        Intrinsics.checkNotNullParameter(r101, "audienceOrientation");
        return this.f478492a.S(new gr2.m(r100), new gr2.k(r101));
    }

    @Override // ti6.j
    public final String a(int r100, int r101, List<ti6.f> r102) {
        Intrinsics.checkNotNullParameter(r102, "mixRegions");
        o r103 = this.f478492a;
        List<ti6.f> r104 = r102;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L7;
        r105.add(new gr2.o((ti6.f) r106.next()));
        goto L4
    L7:
        return r103.L3(r100, r101, r105);
    }
}
