package com.bytedance.ee.bear.list.move;

import com.bytedance.ee.bear.list.move.api.SpaceMoveToWikiPuller$Result;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<T, R> implements Function {
    public final /* synthetic */ j a;

    public k(j r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        SpaceMoveToWikiPuller$Result r5 = (SpaceMoveToWikiPuller$Result) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        int r0 = j.k;
        tt5.a.h("SpaceMoveToWikiCommand", "pollingMoveToSpaceStatus()...taskId = " + r5.task_id);
        return j.a(this.a, r5.task_id, 1000);
    }
}
