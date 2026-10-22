package com.ss.android.lark.keyboard.edittext2.edittors.inlinecode;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.InlineCodeCenterSpan;
import com.ss.android.lark.widget.span.InlineCodeInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class EditorInlineCodeCenterSpan extends InlineCodeCenterSpan {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f429069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f429070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f429071i;

    public EditorInlineCodeCenterSpan(Context r100, final InlineCodeInfo r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanInfo");
        super(r100, r101);
        this.f429069g = r100;
        LazyThreadSafetyMode r102 = LazyThreadSafetyMode.NONE;
        this.f429070h = LazyKt.lazy(r102, new EditorInlineCodeCenterSpan$startSpan$2(this, r101));
        this.f429071i = LazyKt.lazy(r102, new EditorInlineCodeCenterSpan$endSpan$2(this, r101));
    }
}
