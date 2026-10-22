package ue8;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f549808a;

    public b() {
        this.f549808a = new int[2];
    }

    @Override // ue8.i
    public final c a(List<j> r100, Set<String> r110) {
        Intrinsics.checkNotNullParameter(r100, "currentlyVisible");
        Intrinsics.checkNotNullParameter(r110, "previouslyExposed");
        ArrayList r101 = (ArrayList) r100;
        if (r101.isEmpty() == true) goto L5;
        Iterator r102 = r101.iterator();
        String r103 = null;
        int r104 = Integer.MIN_VALUE;
        int r105 = Integer.MAX_VALUE;
        j r106 = null;
    L8:
        if (r102.hasNext() == false) goto L17;
        j r107 = (j) r102.next();
        View r108 = r107.f549827b.get();
        if (r108 == null) goto L8;
        r108.getLocationOnScreen(this.f549808a);
        int[] r109 = this.f549808a;
        int r111 = r109[1];
        int r112 = r109[0];
        if (r111 > r104) goto L16;
        if (r111 != r104) goto L8;
        if (r112 >= r105) goto L8;
    L16:
        r106 = r107;
        r104 = r111;
        r105 = r112;
        goto L8
    L17:
        if (r106 != null) goto L19;
    L21:
        List r113 = CollectionsKt.emptyList();
    L22:
        if (r106 == null) goto L24;
        r103 = r106.f549826a;
    L24:
        ArrayList r114 = new ArrayList();
        Iterator<T> r115 = r110.iterator();
    L26:
        if (r115.hasNext() == false) goto L31;
        Object r116 = r115.next();
        if ((!Intrinsics.areEqual((String) r116, r103)) == false) goto L26;
        r114.add(r116);
        goto L26
    L31:
        return new c(r113, r114);
    L19:
        if (r106.f549829d == true) goto L21;
        r113 = CollectionsKt.listOf(r106);
        goto L22
    L5:
        return new c(CollectionsKt.emptyList(), CollectionsKt.toList(r110));
    }
}
