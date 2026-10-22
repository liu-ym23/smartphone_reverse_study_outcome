package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveToSpacePuller;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z<T, R> implements Function {
    public final /* synthetic */ t a;

    public z(t r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        MoveToSpacePuller.Result r5 = (MoveToSpacePuller.Result) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        tt5.a.h("WikiFolderBlockMoreViewDelegate", "pollingMoveToSpaceStatus()...taskId = " + r5.task_id);
        return t.j(this.a, r5.task_id, 1000);
    }
}
