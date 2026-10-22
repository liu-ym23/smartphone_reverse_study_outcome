package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ d a;

    public m(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r17) {
        float r0 = ((Number) r17).floatValue();
        BaseInfoServiceSnapshotTransitionController r2 = this.a.b;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.i == false) goto L7;
        return;
    L7:
        if (Float.isNaN(r0) == false) goto L9;
        return;
    L9:
        if (r0 < 0.0f) goto L82;
        float r1 = RangesKt.coerceIn(r0, 0.0f, 1.0f);
        if (r2.a == false) goto L14;
        float r5 = 1.0f - r1;
    L16:
        if (r2.b != null) goto L21;
        if (r5 > 0.001f) goto L21;
        return;
    L21:
        if (r2.k == true) goto L24;
        r2.k = true;
        dm.a.a("PdpSnapshotTransition").b("slide offset=" + r1 + " stableExpanded=" + r2.a, null);
    L24:
        if (r2.b != null) goto L66;
        boolean r6 = !r2.a;
        BaseInfoServiceSnapshotTransitionController.g r10 = r2.e();
        if (r10 == null) goto L50;
        r2.k();
        r2.c();
        boolean r12 = r2.a;
        if (r12 == false) goto L31;
        BaseInfoServiceSnapshotTransitionController.c r13 = r2.d;
    L32:
        if (r13 != null) goto L34;
    L38:
        if (r12 == false) goto L40;
        r2.d = null;
    L42:
        if (Build.VERSION.SDK_INT < 26) goto L44;
        r2.g("snapshot_cache_miss");
        r13 = null;
    L49:
        if (r13 == null) goto L50;
        ColorDrawable r11 = new ColorDrawable(-1);
        r11.setAlpha(255);
        r11.setBounds(r13.b);
        BitmapDrawable r14 = new BitmapDrawable(r2.q.getResources(), r13.d);
        r14.setAlpha(255);
        r14.setBounds(r13.b);
        r2.q.getOverlay().add(r11);
        r2.q.getOverlay().add(r14);
        r2.e = new BaseInfoServiceSnapshotTransitionController.a(r14, r11);
        r2.n(r10, r6);
        r2.b = new BaseInfoServiceSnapshotTransitionController.f(r6, r13.b, r10.c, r13.e);
        if (ViewCompat.isAttachedToWindow(r2.q) == false) goto L55;
        a r8 = new a(r2);
        r2.g = r8;
        r2.q.getViewTreeObserver().addOnPreDrawListener(r8);
    L55:
        dm.a.b r9 = dm.a.a("PdpSnapshotTransition");
        StringBuilder r15 = new StringBuilder("begin targetExpanded=");
        r15.append(r6);
        r15.append(" bounds=");
        r15.append(r13.b);
        r15.append(" baseInfo=");
        r15.append(r10.a.getSliceId());
        r15.append(" headerAttached=");
        if (r10.c == null) goto L58;
        boolean r7 = true;
    L59:
        r15.append(r7);
        r15.append(" serviceAttached=");
        if (r10.b == null) goto L62;
        boolean r16 = true;
    L63:
        r15.append(r16);
        r9.b(r15.toString(), null);
        boolean r18 = true;
    L64:
        if (r18 == true) goto L66;
        return;
    L62:
        r16 = false;
        goto L63
    L58:
        r7 = false;
        goto L59
    L44:
        Rect r19 = r10.d;
        View r110 = r10.c;
        if (r110 == null) goto L47;
        r2.q.getLocationInWindow(r2.o);
        r110.getLocationInWindow(r2.p);
        Integer r111 = Integer.valueOf(r10.d.top - ((r2.p[1] - r2.o[1]) + r110.getHeight()));
    L48:
        r13 = r2.b(r19, r12, r111);
        goto L49
    L47:
        r111 = null;
        goto L48
    L40:
        r2.c = null;
        goto L42
    L34:
        if (r13.a != r2.q) goto L38;
        if (r13.c != r12) goto L38;
        dm.a.a("PdpSnapshotTransition").b("snapshot cache hit expanded=" + r2.a + " captureBounds=" + r13.b + " currentBounds=" + r10.d, null);
        goto L49
    L31:
        r13 = r2.c;
    L50:
        r18 = false;
    L66:
        BaseInfoServiceSnapshotTransitionController.f r20 = r2.b;
        if (r20 != null) goto L70;
        return;
    L70:
        if (r20.a == true) goto L74;
        r1 = 1.0f - r1;
    L74:
        if (r1 > 0.001f) goto L76;
        r2.h(r2.a);
        return;
    L76:
        r20.e = RangesKt.coerceIn(r1, 0.0f, 1.0f);
        r2.m(r20);
        return;
    L14:
        r5 = r1;
        goto L16
    }
}
