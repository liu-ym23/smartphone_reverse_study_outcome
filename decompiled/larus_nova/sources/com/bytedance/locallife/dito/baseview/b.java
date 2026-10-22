package com.bytedance.locallife.dito.baseview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseDitoView<?> f257321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f257322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f257323c;

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f257322b == false) goto L8;
        BaseDitoView<?> r101 = this.f257321a;
        if (r101 == null) goto L8;
        r101.H(r100);
    L8:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f257323c == false) goto L9;
        View r102 = (View) SequencesKt.firstOrNull(ViewGroupKt.getChildren(this));
        if (r102 == null) goto L9;
        if (r102.getLayoutParams() == null) goto L9;
        r102.getLayoutParams().height = r102.getMeasuredHeight();
    L9:
        super.onMeasure(r100, r101);
    }

    public b(Context r100, BaseDitoView r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f257321a = r101;
        this.f257322b = r102;
        this.f257323c = r103;
    }
}
