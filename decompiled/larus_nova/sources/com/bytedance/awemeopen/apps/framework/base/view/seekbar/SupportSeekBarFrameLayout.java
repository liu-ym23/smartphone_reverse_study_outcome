package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u001b\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0013\u0010\u0017B#\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0013\u0010\u001aR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SupportSeekBarFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/i;", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/f;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/f;", "getSeekBarTouchDelegate", "()Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/f;", "setSeekBarTouchDelegate", "(Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/f;)V", "seekBarTouchDelegate", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class SupportSeekBarFrameLayout extends FrameLayout implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f193651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f193652b;

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    public final Paint getPaint() {
        return this.f193652b;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.i
    public f getSeekBarTouchDelegate() {
        return this.f193651a;
    }

    public SupportSeekBarFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.f193652b = new Paint();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        Intrinsics.checkNotNullParameter(r100, "ev");
        f r101 = getSeekBarTouchDelegate();
        if (r101 == null) goto L5;
        boolean r102 = r101.a(r100);
    L6:
        if (r102 == false) goto L10;
        requestDisallowInterceptTouchEvent(true);
        return true;
    L10:
        return super.onInterceptTouchEvent(r100);
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r100, "ev");
        f r101 = getSeekBarTouchDelegate();
        if (r101 == null) goto L5;
        boolean r102 = r101.a(r100);
    L6:
        if (r102 == false) goto L10;
        return true;
    L10:
        return super.onTouchEvent(r100);
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.i
    public void setSeekBarTouchDelegate(f r100) {
        this.f193651a = r100;
    }

    public SupportSeekBarFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101);
        this.f193652b = new Paint();
    }

    public SupportSeekBarFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f193652b = new Paint();
    }
}
