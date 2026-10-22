package com.larus.dora.obric.device_management.setting.earbuds;

import java.util.ArrayList;
import java.util.List;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class i<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricEarbudsDSLSettingsFragment f340141a;

    public i(DoraObricEarbudsDSLSettingsFragment r100) {
        this.f340141a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        Triple r102 = (Triple) r100;
        List r103 = (List) r102.component1();
        d59.b r104 = (d59.b) r102.component2();
        e59.b r105 = (e59.b) r102.component3();
        final DoraObricEarbudsDslCardAdapter r106 = this.f340141a.f339684h;
        if (r106 == null) goto L14;
        if (r104 == null) goto L8;
        r106.f339695c = r104;
        g49.d.d("DoraObricEarbudsDslCardAdapter", "setCardContext, cardContext: " + r104);
    L8:
        Intrinsics.checkNotNullParameter(r105, "newState");
        if (Intrinsics.areEqual(r106.f339696d, r105) == true) goto L12;
        r106.f339696d = r105;
        r106.f339697e.post(new m(r106));
    L12:
        Intrinsics.checkNotNullParameter(r103, "newItems");
        g49.d.d("DoraObricEarbudsDslCardAdapter", "setCards, newItems: " + r103.size());
        ((ArrayList) r106.f339694b).clear();
        ((ArrayList) r106.f339694b).addAll(r103);
        r106.f339697e.post(new n(r106));
    L14:
        return Unit.INSTANCE;
    }
}
