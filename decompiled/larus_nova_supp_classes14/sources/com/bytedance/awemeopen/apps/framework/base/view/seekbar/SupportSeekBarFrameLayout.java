package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u001b\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0013\u0010\u0017B#\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0013\u0010\u001aR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SupportSeekBarFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/i;", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/f;", "a", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/f;", "getSeekBarTouchDelegate", "()Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/f;", "setSeekBarTouchDelegate", "(Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/f;)V", "seekBarTouchDelegate", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class SupportSeekBarFrameLayout extends FrameLayout implements i {
    public f a;
    public final Paint b;

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    public final Paint getPaint() {
        return this.b;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.i
    public f getSeekBarTouchDelegate() {
        return this.a;
    }

    public SupportSeekBarFrameLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
        this.b = new Paint();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        Intrinsics.checkNotNullParameter(r2, "ev");
        f r0 = getSeekBarTouchDelegate();
        if (r0 == null) goto L5;
        boolean r1 = r0.a(r2);
    L6:
        if (r1 == false) goto L10;
        requestDisallowInterceptTouchEvent(true);
        return true;
    L10:
        return super.onInterceptTouchEvent(r2);
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r2, "ev");
        f r0 = getSeekBarTouchDelegate();
        if (r0 == null) goto L5;
        boolean r1 = r0.a(r2);
    L6:
        if (r1 == false) goto L10;
        return true;
    L10:
        return super.onTouchEvent(r2);
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.i
    public void setSeekBarTouchDelegate(f r1) {
        this.a = r1;
    }

    public SupportSeekBarFrameLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3);
        this.b = new Paint();
    }

    public SupportSeekBarFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.b = new Paint();
    }
}
