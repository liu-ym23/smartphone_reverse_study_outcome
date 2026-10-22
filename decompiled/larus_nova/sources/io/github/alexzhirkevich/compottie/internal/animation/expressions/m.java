package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class m {
    public static final f a(List<? extends f> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        f r102 = (f) ListProtector.get(r100, r101);
        if ((r102 instanceof wrc.a) == true) goto L5;
        return r102;
    L5:
        return ((wrc.a) r102).f560916c;
    }

    public static final f b(List<? extends f> r100, int r101, String... r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "name");
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        f r103 = (f) r102.next();
        if ((r103 instanceof wrc.a) == false) goto L4;
        int r104 = r110.length;
        boolean r105 = false;
        int r106 = 0;
    L8:
        if (r106 >= r104) goto L13;
        String r107 = r110[r106];
        if (Intrinsics.areEqual(((wrc.a) r103).f560915b, r107) == true) goto L11;
        r106 = r106 + 1;
        goto L8
    L11:
        r105 = true;
    L13:
        if (r105 == false) goto L4;
        return ((wrc.a) r103).f560916c;
    L16:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        f r108 = (f) CollectionsKt.getOrNull(r100, r101);
        if ((r108 instanceof wrc.a) == true) goto L19;
        return r108;
    L19:
        return ((wrc.a) r108).f560916c;
    }
}
