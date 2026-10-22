package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveToSpacePuller;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l0<T, R> implements Function {
    public final /* synthetic */ c0 a;

    public l0(c0 r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        MoveToSpacePuller.Result r5 = (MoveToSpacePuller.Result) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        tt5.a.h("WikiItemMoreViewDelegate", "pollingMoveToSpaceStatus()...taskId = " + r5.task_id);
        return c0.j(this.a, r5.task_id, 1000);
    }
}
