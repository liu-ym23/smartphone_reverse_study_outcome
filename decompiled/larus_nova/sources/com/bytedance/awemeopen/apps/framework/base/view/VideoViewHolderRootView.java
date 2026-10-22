package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/VideoViewHolderRootView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnTouchListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/view/View$OnTouchListener;", "getLongPressFastSpeedListener", "()Landroid/view/View$OnTouchListener;", "setLongPressFastSpeedListener", "(Landroid/view/View$OnTouchListener;)V", "longPressFastSpeedListener", "b", "getPinchListener", "setPinchListener", "pinchListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class VideoViewHolderRootView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnTouchListener f193226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnTouchListener f193227b;

    public VideoViewHolderRootView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VideoViewHolderRootView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final View.OnTouchListener getLongPressFastSpeedListener() {
        return this.f193226a;
    }

    public final View.OnTouchListener getPinchListener() {
        return this.f193227b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        View.OnTouchListener r101 = this.f193226a;
        boolean r102 = false;
        if (r101 == null) goto L11;
        if (r101 != null) goto L6;
    L8:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L11;
        return true;
    L6:
        if (r101.onTouch(this, r100) != true) goto L8;
        r103 = true;
    L11:
        View.OnTouchListener r104 = this.f193227b;
        if (r104 == null) goto L20;
        if (r104 != null) goto L15;
    L17:
        if (r102 == false) goto L20;
        return true;
    L15:
        if (r104.onTouch(this, r100) != true) goto L17;
        r102 = true;
    L20:
        return super.dispatchTouchEvent(r100);
    }

    public final void setLongPressFastSpeedListener(View.OnTouchListener r100) {
        this.f193226a = r100;
    }

    public final void setPinchListener(View.OnTouchListener r100) {
        this.f193227b = r100;
    }

    public VideoViewHolderRootView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
    }

    public /* synthetic */ VideoViewHolderRootView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
