package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class p0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSpaceMoreProvider f242535a;

    public p0(WikiSpaceMoreProvider r100) {
        this.f242535a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SpaceInfo r101 = (SpaceInfo) r100;
        Intrinsics.checkNotNullParameter(r101, "spaceInfo");
        WikiSpaceMoreProvider r102 = this.f242535a;
        r102.f242297s = r101;
        r102.g();
    }
}
