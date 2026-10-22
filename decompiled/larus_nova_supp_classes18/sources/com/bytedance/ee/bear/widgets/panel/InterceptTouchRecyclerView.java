package com.bytedance.ee.bear.widgets.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/widgets/panel/InterceptTouchRecyclerView;", "Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "touchInterceptor", "Lcom/bytedance/ee/bear/widgets/panel/InterceptTouchRecyclerView$ITouchInterceptor;", "downX", "", "downY", "lastX", "lastY", "setTouchInterceptor", "", "interceptor", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "ITouchInterceptor", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class InterceptTouchRecyclerView extends BaseRecyclerView {
    public a l;
    public float m;
    public float n;

    public interface a {
        boolean a(MotionEvent r1, float r2, float r3);
    }

    public InterceptTouchRecyclerView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        a r0 = this.l;
        if (r0 == null) goto L11;
        if (r3.getAction() != 0) goto L11;
        r3.getRawX();
        this.n = r3.getRawY();
        r3.getRawX();
        this.m = r3.getRawY();
        if (r0.a(r3, 0.0f, 0.0f) == false) goto L11;
        return true;
    L11:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r3);
    }

    public final boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        a r0 = this.l;
        if (r0 == null) goto L15;
        r6.getRawX();
        float r1 = r6.getRawY();
        int r2 = r6.getAction();
        if (r2 != 1) goto L7;
    L11:
        float r3 = this.n - r1;
        this.n = r1;
        if (r0.a(r6, this.m - r1, r3) == false) goto L15;
        return true;
    L7:
        if (r2 == 2) goto L11;
        if (r2 == 3) goto L11;
    L15:
        return super/*androidx.recyclerview.widget.RecyclerView*/.onTouchEvent(r6);
    }

    public final void setTouchInterceptor(a r1) {
        this.l = r1;
    }

    public InterceptTouchRecyclerView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    public InterceptTouchRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }
}
