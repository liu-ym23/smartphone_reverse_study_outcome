package com.bytedance.ee.bear.task;

import android.content.Context;
import com.bytedance.ee.bear.wikiv2.route.WikiRouteTable;
import com.bytedance.ee.bear.wikiv2.route.g;
import fo5.d;
import io.reactivex.Flowable;
import io.reactivex.internal.functions.Functions;
import kotlin.Lazy;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class InitRedirectTableTask extends BaseAsyncLaunchTask {
    public final int c() {
        return 5;
    }

    public InitRedirectTableTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseAsyncLaunchTask
    public final void a(Context r3) {
        a.h("InitRedirectTableTask", "InitRedirectTableTask.execute");
        Lazy r4 = WikiRouteTable.a;
        Flowable.fromCallable(new g()).subscribeOn(d.c()).subscribe(Functions.emptyConsumer(), up5.d.a);
    }
}
