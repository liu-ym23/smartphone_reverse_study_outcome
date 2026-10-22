package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveToSpaceStatusPuller;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y<T, R> implements Function {
    public final /* synthetic */ t a;
    public final /* synthetic */ String b;

    public y(t r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r4) {
        MoveToSpaceStatusPuller.Result r5 = (MoveToSpaceStatusPuller.Result) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        tt5.a.h("WikiFolderBlockMoreViewDelegate", "getMoveToSpaceStatus()...result = " + r5);
        int r0 = r5.status;
        if (r0 != MoveToSpaceStatusPuller.MoveToSpaceStatus.MOVING.getStatus()) goto L6;
        return t.j(this.a, this.b, 500);
    L6:
        if (r0 != MoveToSpaceStatusPuller.MoveToSpaceStatus.MOVE_DONE.getStatus()) goto L9;
        return Flowable.just(r5);
    L9:
        if (r0 == MoveToSpaceStatusPuller.MoveToSpaceStatus.MOVE_FAILED.getStatus()) goto L15;
        r5.status = MoveToSpaceStatusPuller.MoveToSpaceStatus.UNKNOWN.getStatus();
        Flowable r6 = Flowable.just(r5);
        Intrinsics.checkNotNull(r6);
        return r6;
    L15:
        return Flowable.just(r5);
    }
}
