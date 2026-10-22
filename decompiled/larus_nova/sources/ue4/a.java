package ue4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f549805a = 0;

    static {
    }

    public static View a(Context r100, int r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return LayoutInflater.from(CJEnv.a()).inflate(r101, r102);
    L5:
        e = move-exception;
        CJReporter r103 = CJReporter.f202294a;
        CJReporter.m(null, "plugin_res_exception", 2, e);
        return LayoutInflater.from(r100).inflate(r101, r102);
    }
}
