package com.bytedance.ee.bear.middleground.audio;

import android.content.Context;
import com.bytedance.ee.bear.thread.BearExecutors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements com.ss.android.lark.a.b {
    public final /* synthetic */ Context a;

    public final ScheduledExecutorService a() {
        return BearExecutors.e();
    }

    public Context getContext() {
        return this.a;
    }

    public c(Context r1) {
        this.a = r1;
    }
}
