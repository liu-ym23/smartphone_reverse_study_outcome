package com.bytedance.applog.priority;

import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class o implements Function0 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public /* synthetic */ o(boolean r1, int r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        boolean r0 = this.a;
        int r1 = this.b;
        String r2 = this.c;
        List r3 = PriorityWrapper.f;
        return "match: " + r0 + " eventType: " + r1 + " eventName: " + r2;
    }
}
