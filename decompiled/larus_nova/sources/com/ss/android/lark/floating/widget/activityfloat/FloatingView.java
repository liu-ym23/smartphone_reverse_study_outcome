package com.ss.android.lark.floating.widget.activityfloat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vfb.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000f\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/floating/widget/activityfloat/FloatingView;", "Lcom/ss/android/lark/floating/widget/activityfloat/AbstractDragFloatingView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setFloatConfig", "", "config", "Lcom/ss/android/lark/floating/data/FloatConfig;", "getLayoutId", "", "()Ljava/lang/Integer;", "renderView", "view", "Landroid/view/View;", "float_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatingView extends AbstractDragFloatingView {
    @Override // com.ss.android.lark.floating.widget.activityfloat.AbstractDragFloatingView
    public final void d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // com.ss.android.lark.floating.widget.activityfloat.AbstractDragFloatingView
    public Integer getLayoutId() {
        return getConfig().f554606a;
    }

    public final void setFloatConfig(a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        setConfig(r100);
        c(getContext());
        requestLayout();
    }

    public FloatingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0);
    }
}
