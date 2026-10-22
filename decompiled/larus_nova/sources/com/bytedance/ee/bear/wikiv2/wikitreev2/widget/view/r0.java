package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class r0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSpaceMoreProvider f242546a;

    public r0(WikiSpaceMoreProvider r100) {
        this.f242546a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SpacePerm r101 = (SpacePerm) r100;
        Intrinsics.checkNotNullParameter(r101, "spacePerm");
        WikiSpaceMoreProvider r102 = this.f242546a;
        r102.f242298t = r101;
        r102.g();
    }
}
