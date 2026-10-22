package com.relax.relaxreact;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e {
    public static final <P> s<P> a(Function1<? super P, ? extends o1> r100) {
        Intrinsics.checkNotNullParameter(r100, ChameleonOpenTracker.Stage.RENDER);
        return new s(r100);
    }
}
