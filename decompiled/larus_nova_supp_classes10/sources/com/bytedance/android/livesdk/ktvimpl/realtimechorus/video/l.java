package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements Runnable {
    public final /* synthetic */ VideoChorusWidget a;

    public l(VideoChorusWidget r1) {
        this.a = r1;
    }

    public final void a() {
        VideoChorusWidget r0 = this.a;
        ViewGroup r1 = ((Widget) r0).containerView;
        if (r1 != null) goto L5;
        return;
    L5:
        View r2 = ((Widget) r0).contentView;
        if (r2 != null) goto L8;
        return;
    L8:
        int r3 = Math.min(r1.getWidth(), (int) (r1.getHeight() * 0.5625f));
        int r4 = r1.getHeight();
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(r3, -2);
        r5.gravity = 17;
        Unit r6 = Unit.INSTANCE;
        r2.setLayoutParams(r5);
        if (r4 != 0) goto L11;
        float r7 = 1.0f;
    L12:
        r2.setScaleX(r7);
        r2.setScaleY(r7);
        r2.setPivotX(0.0f);
        r2.setPivotY(0.0f);
        r2.requestLayout();
        return;
    L11:
        r7 = r1.getHeight() / r4;
        goto L12
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
