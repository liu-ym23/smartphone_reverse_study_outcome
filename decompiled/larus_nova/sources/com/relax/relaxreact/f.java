package com.relax.relaxreact;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<Object, ? extends o1> f405492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Object, Object, Boolean> f405493b;

    public f(Function1<Object, ? extends o1> r100, Function2<Object, Object, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, ChameleonOpenTracker.Stage.RENDER);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405492a = r100;
        this.f405493b = r101;
    }
}
