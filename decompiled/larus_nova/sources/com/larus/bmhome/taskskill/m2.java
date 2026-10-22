package com.larus.bmhome.taskskill;

import com.larus.bmhome.taskskill.model.PcDevice;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m2 {
    public static final boolean a(PcDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<Integer> r101 = r100.q();
        if (r101 != null) goto L5;
        return false;
    L5:
        List<Integer> r102 = l2.f314334a;
        com.larus.platform.service.p1 r103 = com.larus.platform.service.p1.f365785a;
        List<Integer> r104 = l2.f314334a;
        if ((r104 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L21;
        if ((!r101.contains(Integer.valueOf(((Number) r105.next()).intValue()))) == false) goto L12;
        return true;
    L21:
        return false;
    L8:
        if (r104.isEmpty() == false) goto L10;
        return false;
    }
}
