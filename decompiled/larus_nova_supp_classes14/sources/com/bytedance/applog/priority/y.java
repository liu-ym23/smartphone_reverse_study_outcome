package com.bytedance.applog.priority;

import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class y implements Function0 {
    public final /* synthetic */ int a;

    public /* synthetic */ y(int r1) {
        this.a = r1;
    }

    public final Object invoke() {
        int r0 = this.a;
        List r1 = PriorityWrapper.f;
        return "new session to native failed: " + r0;
    }
}
