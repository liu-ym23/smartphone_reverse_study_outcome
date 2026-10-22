package com.larus.larkfeed.impl.mixedfeed;

import com.larus.utils.t0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements nh9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f355448a;

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f355448a = r100;
    }

    @Override // nh9.a
    public final void v(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "bizIds");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        String r103 = (String) r102.next();
        if ((!StringsKt.isBlank(r103)) == true) goto L9;
        r103 = null;
    L9:
        if (r103 == null) goto L4;
        r101.add(r103);
        goto L4
    L11:
        final List r104 = CollectionsKt.distinct(r101);
        if (r104.isEmpty() == false) goto L14;
        return;
    L14:
        t0.a(new a(this, r104));
    }
}
