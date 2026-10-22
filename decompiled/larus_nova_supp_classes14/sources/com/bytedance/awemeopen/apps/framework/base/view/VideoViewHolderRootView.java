package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/VideoViewHolderRootView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnTouchListener;", "a", "Landroid/view/View$OnTouchListener;", "getLongPressFastSpeedListener", "()Landroid/view/View$OnTouchListener;", "setLongPressFastSpeedListener", "(Landroid/view/View$OnTouchListener;)V", "longPressFastSpeedListener", "b", "getPinchListener", "setPinchListener", "pinchListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class VideoViewHolderRootView extends RelativeLayout {
    public View.OnTouchListener a;
    public View.OnTouchListener b;

    public VideoViewHolderRootView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VideoViewHolderRootView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final View.OnTouchListener getLongPressFastSpeedListener() {
        return this.a;
    }

    public final View.OnTouchListener getPinchListener() {
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        View.OnTouchListener r0 = this.a;
        boolean r1 = false;
        if (r0 == null) goto L11;
        if (r0 != null) goto L6;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L11;
        return true;
    L6:
        if (r0.onTouch(this, r4) != true) goto L8;
        r2 = true;
    L11:
        View.OnTouchListener r3 = this.b;
        if (r3 == null) goto L20;
        if (r3 != null) goto L15;
    L17:
        if (r1 == false) goto L20;
        return true;
    L15:
        if (r3.onTouch(this, r4) != true) goto L17;
        r1 = true;
    L20:
        return super.dispatchTouchEvent(r4);
    }

    public final void setLongPressFastSpeedListener(View.OnTouchListener r1) {
        this.a = r1;
    }

    public final void setPinchListener(View.OnTouchListener r1) {
        this.b = r1;
    }

    public VideoViewHolderRootView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
    }

    public /* synthetic */ VideoViewHolderRootView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
