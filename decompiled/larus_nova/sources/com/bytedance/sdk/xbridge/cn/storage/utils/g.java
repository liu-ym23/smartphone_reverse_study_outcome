package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class g {
    static {
    }

    @JvmStatic
    public static final c a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return UserDomainNativeStorageImpl.f270148b.a(r100.getApplicationContext());
    }
}
