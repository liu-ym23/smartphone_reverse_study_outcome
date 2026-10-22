package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final b a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return NativeStorageImpl.f270142c.a(r100.getApplicationContext());
    }
}
