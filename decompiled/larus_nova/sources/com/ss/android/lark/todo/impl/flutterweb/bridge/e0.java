package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.utils.TodoStorageUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e0 extends AbsChameleonHandler<UpdateBadgeParam> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f444181a;

    public static final class a {
    }

    static {
    }

    public e0() {
        this.f444181a = LKAPIModules.Biz.Todo.UpdateBadge.getValue();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final String getName() {
        return this.f444181a;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final void handle(UpdateBadgeParam r100, Callback r101) {
        UpdateBadgeParam r102 = r100;
        Intrinsics.checkNotNullParameter(r102, HiAnalyticsConstant.Direction.REQUEST);
        Intrinsics.checkNotNullParameter(r101, "callback");
        Log.i("TodoWeb", "call " + this.f444181a + " with " + r102);
        Integer r103 = r102.getCount();
        if (r103 == null) goto L5;
        int r104 = r103.intValue();
    L6:
        TodoStorageUtil.a().putInt(r104);
        r101.success(null);
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
