package com.larus.larkfeed.impl.voice.analytics;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes30.dex */
public final class b<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f355588a;

    public b(a r100) {
        this.f355588a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        Collection r102 = ((Map) r100).values();
        a r103 = this.f355588a;
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L16;
        zac.a r105 = (zac.a) r104.next();
        if (r105.f571113d == false) goto L4;
        String r106 = r105.f571110a;
        String r107 = r105.f571111b.f571116a;
        if (r107 != null) goto L10;
    L13:
        boolean r108 = true;
    L14:
        a.c(r103, r106, !r108);
        goto L4
    L10:
        if (StringsKt.isBlank(r107) == true) goto L13;
        r108 = false;
        goto L14
    L16:
        return Unit.INSTANCE;
    }
}
