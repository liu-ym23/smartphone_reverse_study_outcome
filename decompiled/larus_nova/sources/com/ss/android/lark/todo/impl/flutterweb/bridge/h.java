package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h extends AbsChameleonHandler<GetChatByIdParam> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f444188a;

    public h() {
        this.f444188a = LKAPIModules.Biz.Todo.GetChatById.getValue();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final String getName() {
        return this.f444188a;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final void handle(GetChatByIdParam r100, Callback r101) {
        GetChatByIdParam r102 = r100;
        Intrinsics.checkNotNullParameter(r102, HiAnalyticsConstant.Direction.REQUEST);
        Intrinsics.checkNotNullParameter(r101, "callback");
        Log.i("TodoWeb", "call " + this.f444188a);
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new g(r102, r101));
    }
}
