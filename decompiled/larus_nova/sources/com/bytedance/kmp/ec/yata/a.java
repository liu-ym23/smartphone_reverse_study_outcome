package com.bytedance.kmp.ec.yata;

import android.content.Context;
import com.bytedance.kmp.ec.yata.common.biz.callback.c;
import com.bytedance.kmp.ec.yata.common.biz.callback.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import v96.f;
import v96.i;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a implements f, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f251249a;

    @Override // v96.f
    public v96.b a() {
        return null;
    }

    public com.bytedance.kmp.ec.yata.common.biz.callback.f c() {
        return null;
    }

    @Override // v96.f
    public d d() {
        return null;
    }

    public c e() {
        return null;
    }

    @Override // v96.f
    public v96.c getErrorHandler() {
        return null;
    }

    @Override // v96.i
    public Context getContext() {
        return this.f251249a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f251249a = r100;
    }
}
