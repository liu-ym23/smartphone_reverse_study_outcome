package com.ss.android.lark.widget.span;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class m0 extends b {
    public m0(Context r100, b.AbstractC5432b<?> r101, Function1<? super b, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "loadInfo");
        Intrinsics.checkNotNullParameter(r102, "imageLoadHandle");
        super(r100, r101, r102);
    }
}
