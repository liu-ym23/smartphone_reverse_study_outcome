package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class k extends xc8.h {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f304438p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f304439q;

    public static final class a {
    }

    static {
    }

    public abstract void n(Message r100, boolean r101);

    public final boolean getShowProgress() {
        return ((Boolean) this.f304438p.getValue()).booleanValue();
    }

    public final Integer getCurrentLoadingProgress() {
        return this.f304439q;
    }

    public k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f304438p = LazyKt.lazy(new j());
    }

    public void o(int r100) {
        FLogger.f375446a.i("BaseProgressLoadingBox", "onLoadingProgressUpdate " + r100);
        this.f304439q = Integer.valueOf(r100);
    }

    public final void setCurrentLoadingProgress(Integer r100) {
        this.f304439q = r100;
    }
}
