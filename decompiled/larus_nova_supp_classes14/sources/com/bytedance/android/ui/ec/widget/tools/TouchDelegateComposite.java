package com.bytedance.android.ui.ec.widget.tools;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/tools/TouchDelegateComposite;", "Landroid/view/TouchDelegate;", "view", "Landroid/view/View;", "emptyRect", "Landroid/graphics/Rect;", "(Landroid/view/View;Landroid/graphics/Rect;)V", "delegates", "", "addDelegate", "", "delegate", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TouchDelegateComposite extends TouchDelegate {
    private final List<TouchDelegate> delegates;
    private final Rect emptyRect;

    public final void addDelegate(TouchDelegate r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.delegates.add(r2);
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        float r0 = r7.getX();
        float r1 = r7.getY();
        Iterator<T> r2 = this.delegates.iterator();
    L3:
        boolean r4 = false;
    L5:
        if (r2.hasNext() == false) goto L10;
        TouchDelegate r5 = (TouchDelegate) r2.next();
        r7.setLocation(r0, r1);
        if (r5.onTouchEvent(r7) == true) goto L9;
        if (r4 == false) goto L3;
    L9:
        r4 = true;
        goto L5
    L10:
        return r4;
    }

    public TouchDelegateComposite(View r2, Rect r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "emptyRect");
        super(r3, r2);
        this.emptyRect = r3;
        this.delegates = new ArrayList();
    }

    public /* synthetic */ TouchDelegateComposite(View r1, Rect r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new Rect();
    L5:
        this(r1, r2);
    }
}
