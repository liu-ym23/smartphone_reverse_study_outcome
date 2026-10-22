package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.log.Log;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class o extends AbsChameleonHandler<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f444201a;

    public o() {
        this.f444201a = LKAPIModules.Biz.Todo.GetZoomLevel.getValue();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final String getName() {
        return this.f444201a;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final void handle(Callback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Log.i("TodoWeb", "call " + this.f444201a);
        r100.success(MapsKt.mapOf(TuplesKt.to("zoomLevel", Integer.valueOf(zz7.b.d().getLevel()))));
    }
}
