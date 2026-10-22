package com.obric.assistant.chat;

import com.larus.ui.arch.modulizer.di.ContainerFilter;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    public static final void a(p1a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<ContainerFilter> r101 = x48.a.f562447a;
        Iterator<T> r102 = x48.a.f562447a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r100.e((ContainerFilter) r102.next());
        goto L4
    }
}
