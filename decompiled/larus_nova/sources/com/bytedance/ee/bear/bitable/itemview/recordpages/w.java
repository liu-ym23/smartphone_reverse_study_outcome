package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class w extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Boolean, Unit> f214246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f214247b;

    /* JADX WARN: Multi-variable type inference failed */
    public w(Context r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f214246a = r101;
        this.f214247b = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        float r104 = Math.abs(r102);
        float r105 = Math.abs(r103);
        boolean r106 = false;
        if (r105 > r104) goto L5;
    L11:
        return false;
    L5:
        if (r105 <= this.f214247b) goto L11;
        Function1<Boolean, Unit> r107 = this.f214246a;
        if (r103 >= 0.0f) goto L9;
        r106 = true;
    L9:
        r107.invoke(Boolean.valueOf(r106));
        return true;
    }
}
