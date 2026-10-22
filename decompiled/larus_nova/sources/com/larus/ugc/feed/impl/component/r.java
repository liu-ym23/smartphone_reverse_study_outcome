package com.larus.ugc.feed.impl.component;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class r implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationFeedComponent f374712a;

    public /* synthetic */ r(CreationFeedComponent r100) {
        this.f374712a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        CreationFeedComponent r102 = this.f374712a;
        ((Integer) r100).intValue();
        int r103 = CreationFeedComponent.H;
        Intrinsics.checkNotNullParameter((RecyclerView.ViewHolder) r101, "<unused var>");
        return Boolean.valueOf(r102.f374654u);
    }
}
