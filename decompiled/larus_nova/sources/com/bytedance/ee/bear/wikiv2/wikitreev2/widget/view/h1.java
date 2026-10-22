package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiTreeMoreProvider f242489a;

    public h1(WikiTreeMoreProvider r100) {
        this.f242489a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SpaceInfo r101 = (SpaceInfo) r100;
        WikiTreeMoreProvider r102 = this.f242489a;
        Intrinsics.checkNotNull(r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r102.f242347o = r101;
        this.f242489a.g();
    }
}
