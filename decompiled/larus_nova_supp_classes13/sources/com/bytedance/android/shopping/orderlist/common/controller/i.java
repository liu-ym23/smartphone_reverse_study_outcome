package com.bytedance.android.shopping.orderlist.common.controller;

import android.os.MessageQueue;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements MessageQueue.IdleHandler {
    public final /* synthetic */ h a;
    public final /* synthetic */ List b;

    public i(h r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        this.a.a(this.b);
        return false;
    }
}
