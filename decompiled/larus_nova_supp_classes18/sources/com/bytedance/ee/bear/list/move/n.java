package com.bytedance.ee.bear.list.move;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.move.api.SpaceMoveToWikiStatusPuller$Params;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n<T, R> implements Function {
    public final /* synthetic */ j a;
    public final /* synthetic */ String b;

    public n(j r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r4) {
        Intrinsics.checkNotNullParameter((Boolean) r4, "it");
        NetService r5 = this.a.i;
        SpaceMoveToWikiStatusPuller$Params r0 = new SpaceMoveToWikiStatusPuller$Params(this.b);
        NetService.f r1 = new NetService.f("/space/api/wiki/v2/tree/move_from_space2_status/");
        ((NetService.e) r1).c = 2;
        r1.b("task_id", r0.task_id);
        return r5.Vc(new com.bytedance.ee.bear.list.move.api.e()).a(r1).map(new com.bytedance.ee.bear.list.move.api.d());
    }
}
