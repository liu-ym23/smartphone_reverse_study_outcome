package com.bytedance.ee.bear.list.move;

import com.bytedance.ee.bear.list.move.api.SpaceMoveToWikiStatusPuller$MoveObj;
import com.bytedance.ee.bear.list.move.api.SpaceMoveToWikiStatusPuller$MoveToWikiStatus;
import com.bytedance.ee.bear.list.move.api.SpaceMoveToWikiStatusPuller$Result;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o<T, R> implements Function {
    public final /* synthetic */ j a;
    public final /* synthetic */ String b;

    public o(j r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r7) {
        SpaceMoveToWikiStatusPuller$Result r8 = (SpaceMoveToWikiStatusPuller$Result) r7;
        Intrinsics.checkNotNullParameter(r8, "result");
        int r0 = j.k;
        tt5.a.h("SpaceMoveToWikiCommand", "getMoveToSpaceStatus()...result = " + r8);
        ArrayList<SpaceMoveToWikiStatusPuller$MoveObj> r1 = r8.move_objs;
        j r2 = this.a;
        Iterator<T> r3 = r1.iterator();
    L3:
        Object r4 = null;
        if (r3.hasNext() == false) goto L11;
        Object r5 = r3.next();
        String r6 = ((SpaceMoveToWikiStatusPuller$MoveObj) r5).obj_token;
        SpaceSelectorBean r9 = r2.e;
        if (r9 == null) goto L9;
        r4 = r9.b;
    L9:
        if (Intrinsics.areEqual(r6, r4) == false) goto L3;
        r4 = r5;
    L11:
        SpaceMoveToWikiStatusPuller$MoveObj r10 = (SpaceMoveToWikiStatusPuller$MoveObj) r4;
        if (r10 == null) goto L14;
        int r11 = r10.status;
    L16:
        if (r11 != SpaceMoveToWikiStatusPuller$MoveToWikiStatus.MOVING.getStatus()) goto L19;
        return j.a(this.a, this.b, 500);
    L19:
        if (r11 != SpaceMoveToWikiStatusPuller$MoveToWikiStatus.MOVE_DONE.getStatus()) goto L22;
        return Flowable.just(r8);
    L22:
        if (r11 == SpaceMoveToWikiStatusPuller$MoveToWikiStatus.MOVE_FAILED.getStatus()) goto L31;
        r8.task_status = SpaceMoveToWikiStatusPuller$MoveToWikiStatus.UNKNOWN.getStatus();
        return Flowable.just(r8);
    L31:
        return Flowable.just(r8);
    L14:
        r11 = -1;
        goto L16
    }
}
