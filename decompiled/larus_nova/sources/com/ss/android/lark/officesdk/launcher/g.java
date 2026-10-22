package com.ss.android.lark.officesdk.launcher;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class g implements com.ss.android.lark.app.initiator.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.app.initiator.d f433445a;

    @Inject
    public g(com.ss.android.lark.app.initiator.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mainProcessInitiator");
        this.f433445a = r100;
    }

    @Override // com.ss.android.lark.app.initiator.c
    public final com.ss.android.lark.app.initiator.d a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f433445a;
    }
}
