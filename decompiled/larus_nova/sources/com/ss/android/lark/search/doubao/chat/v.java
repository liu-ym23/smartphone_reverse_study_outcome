package com.ss.android.lark.search.doubao.chat;

import android.content.Context;
import com.ss.android.lark.search.ui.result.BinderConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f440099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BinderConfig f440100b;

    public final Context getContext() {
        return this.f440099a;
    }

    public v(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f440099a = r100;
        this.f440100b = new BinderConfig(r100);
    }
}
