package com.bytedance.salamander.anniex;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class q4<T extends Map<String, ? extends Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ia7.a f268320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f268321b;

    /* JADX WARN: Multi-variable type inference failed */
    public q4(Map r100, Context r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "url");
        ia7.a r103 = new ia7.a(r101, r102, r100);
        r103.getBridgeHandler();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f268320a = r103;
        Intrinsics.checkNotNullParameter(new x2(r103.getBridgeHandler()), "<set-?>");
        this.f268321b = r100;
    }
}
