package com.bytedance.ee.bear.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/profile/VerticalScrollInterceptLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastY", "", "delegate", "Lcom/bytedance/ee/bear/profile/VerticalScrollInterceptLayout$Delegate;", "setDelegate", "", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "Delegate", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VerticalScrollInterceptLayout extends LinearLayout {
    public float a;
    public a b;

    public interface a {
        boolean a(float r1);
    }

    public VerticalScrollInterceptLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VerticalScrollInterceptLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        if (r4 != null) goto L6;
        this.a = 0.0f;
        return false;
    L6:
        int r1 = r4.getAction();
        if (r1 != 0) goto L9;
        this.a = r4.getRawY();
    L20:
        return false;
    L9:
        if (r1 != 2) goto L20;
        float r2 = r4.getRawY() - this.a;
        this.a = r4.getRawY();
        if (Math.abs(r2) <= 10.0f) goto L20;
        a r5 = this.b;
        if (r5 != null) goto L16;
        return false;
    L16:
        if (r5.a(r2) != true) goto L22;
        return true;
    L22:
        return false;
    }

    public final void setDelegate(a r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.b = r2;
    }

    public VerticalScrollInterceptLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ VerticalScrollInterceptLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
