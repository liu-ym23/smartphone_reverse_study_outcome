package com.bytedance.ee.bear.bitable.toolbox.viewmodel;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.common.query.EQueryType;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.EPanelAction;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.EPanelOperationAction;
import com.google.gson.Gson;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface b {
    void a(Function1<? super EPanelAction, Unit> r1);

    <T> Observable<T> b(EQueryType r1, JSONObject r2, Class<T> r3, Gson r4);

    void c(EPanelOperationAction r1, JSONObject r2);

    void d(Function1<? super EPanelAction, Unit> r1);

    void handleOrientationState(boolean r1);
}
