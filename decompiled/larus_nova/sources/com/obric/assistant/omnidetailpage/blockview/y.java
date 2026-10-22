package com.obric.assistant.omnidetailpage.blockview;

import android.view.View;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class y implements BaseResourceViewHolder.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskHeaderView f390729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function3<ifa.a, View, Integer, Unit> f390730b;

    /* JADX WARN: Multi-variable type inference failed */
    public y(TaskHeaderView r100, Function3<? super ifa.a, ? super View, ? super Integer, Unit> r101) {
        this.f390729a = r100;
        this.f390730b = r101;
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder.a
    public final boolean b(String r100, View r101) {
        BaseResourceViewHolder.a.C4120a.a(r100, r101);
        return false;
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder.a
    public final void a(String r100, int r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, BaseSwitches.V);
        ifa.a r103 = this.f390729a.f390579d.get(r100);
        if (r103 == null) goto L6;
        this.f390730b.invoke(r103, r102, Integer.valueOf(r101));
        return;
    }
}
