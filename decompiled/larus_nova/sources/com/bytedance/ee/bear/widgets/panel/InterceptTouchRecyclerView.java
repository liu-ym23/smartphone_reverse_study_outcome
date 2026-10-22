package com.bytedance.ee.bear.widgets.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/widgets/panel/InterceptTouchRecyclerView;", "Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "touchInterceptor", "Lcom/bytedance/ee/bear/widgets/panel/InterceptTouchRecyclerView$ITouchInterceptor;", "downX", "", "downY", "lastX", "lastY", "setTouchInterceptor", "", "interceptor", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "ITouchInterceptor", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class InterceptTouchRecyclerView extends BaseRecyclerView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f240293l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f240294m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f240295n;

    public interface a {
        boolean a(MotionEvent r100, float r101, float r102);
    }

    public InterceptTouchRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        a r101 = this.f240293l;
        if (r101 == null) goto L11;
        if (r100.getAction() != 0) goto L11;
        r100.getRawX();
        this.f240295n = r100.getRawY();
        r100.getRawX();
        this.f240294m = r100.getRawY();
        if (r101.a(r100, 0.0f, 0.0f) == false) goto L11;
        return true;
    L11:
        return super.dispatchTouchEvent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        a r101 = this.f240293l;
        if (r101 == null) goto L15;
        r100.getRawX();
        float r102 = r100.getRawY();
        int r103 = r100.getAction();
        if (r103 != 1) goto L7;
    L11:
        float r104 = this.f240295n - r102;
        this.f240295n = r102;
        if (r101.a(r100, this.f240294m - r102, r104) == false) goto L15;
        return true;
    L7:
        if (r103 == 2) goto L11;
        if (r103 == 3) goto L11;
    L15:
        return super.onTouchEvent(r100);
    }

    public final void setTouchInterceptor(a r100) {
        this.f240293l = r100;
    }

    public InterceptTouchRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public InterceptTouchRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }
}
