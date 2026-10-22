package com.bytedance.ee.bear.middleground.audio;

import android.content.Context;
import com.bytedance.ee.bear.thread.BearExecutors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements com.ss.android.lark.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f230003a;

    @Override // com.ss.android.lark.a.b
    public final ScheduledExecutorService a() {
        return BearExecutors.e();
    }

    @Override // com.ss.android.lark.a.b
    public Context getContext() {
        return this.f230003a;
    }

    public c(Context r100) {
        this.f230003a = r100;
    }
}
