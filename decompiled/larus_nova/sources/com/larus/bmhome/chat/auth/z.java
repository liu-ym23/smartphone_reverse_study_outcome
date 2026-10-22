package com.larus.bmhome.chat.auth;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.auth.model.PluginItem;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class z implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PluginListFragment f297377a;

    public /* synthetic */ z(PluginListFragment r100) {
        this.f297377a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r110) {
        PluginListFragment r100 = this.f297377a;
        List r111 = (List) r110;
        int r101 = PluginListFragment.f297294k;
        Intrinsics.checkNotNullParameter(r111, "it");
        PluginListAdapter r102 = r100.U90();
        List r112 = CollectionsKt.toMutableList(r111);
        ListProtector.add(r112, 0, new PluginItem(null, null, null, null, null, null, null, null, 255, null));
        r102.submitList(r112);
        return Unit.INSTANCE;
    }
}
