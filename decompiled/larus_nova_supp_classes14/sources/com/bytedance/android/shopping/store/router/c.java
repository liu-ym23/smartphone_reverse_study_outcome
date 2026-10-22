package com.bytedance.android.shopping.store.router;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements uk3.b {
    public final /* synthetic */ Context a;

    public c(Context r1) {
        this.a = r1;
    }

    @Override // uk3.b
    public final void a(Object r3, Activity r4) {
        int r0 = wk3.a.a;
        StringBuilder r1 = new StringBuilder("shopScreenAdapt After:target=");
        Float r2 = null;
        if (r3 == null) goto L5;
        String r5 = r3.getClass().getSimpleName();
    L6:
        r1.append(r5);
        r1.append(",density=");
        if (r4 == null) goto L13;
        Resources r6 = r4.getResources();
        if (r6 == null) goto L13;
        DisplayMetrics r7 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics());
        if (r7 == null) goto L13;
        Float r8 = Float.valueOf(r7.density);
    L14:
        r1.append(r8);
        r1.append(",system.density=");
        Resources r9 = Resources.getSystem();
        r1.append(WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()).density);
        r1.append(",application.density=");
        Resources r10 = ((Application) this.a).getResources();
        if (r10 == null) goto L19;
        DisplayMetrics r11 = WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics());
        if (r11 == null) goto L19;
        r2 = Float.valueOf(r11.density);
    L19:
        r1.append(r2);
        wk3.a.a(r1.toString());
        return;
    L13:
        r8 = null;
        goto L14
    L5:
        r5 = null;
        goto L6
    }

    @Override // uk3.b
    public final void b(Object r3, Activity r4) {
        int r0 = wk3.a.a;
        StringBuilder r1 = new StringBuilder("shopScreenAdapt Before:target=");
        DisplayMetrics r2 = null;
        if (r3 == null) goto L5;
        String r5 = r3.getClass().getSimpleName();
    L6:
        r1.append(r5);
        r1.append(",density=");
        if (r4 == null) goto L13;
        Resources r6 = r4.getResources();
        if (r6 == null) goto L13;
        DisplayMetrics r7 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics());
        if (r7 == null) goto L13;
        Float r8 = Float.valueOf(r7.density);
    L14:
        r1.append(r8);
        r1.append(",system.density=");
        Resources r9 = Resources.getSystem();
        r1.append(WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()).density);
        r1.append(",application.density=");
        Resources r10 = ((Application) this.a).getResources();
        if (r10 == null) goto L19;
        DisplayMetrics r11 = WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics());
        if (r11 == null) goto L19;
        Float r12 = Float.valueOf(r11.density);
    L20:
        r1.append(r12);
        r1.append(",hashcode=");
        Resources r13 = ((Application) this.a).getResources();
        if (r13 == null) goto L23;
        r2 = WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics());
    L23:
        if (r2 == null) goto L25;
        int r14 = r2.hashCode();
    L26:
        r1.append(r14);
        wk3.a.a(r1.toString());
        return;
    L25:
        r14 = 0;
    L19:
        r12 = null;
    L13:
        r8 = null;
        goto L14
    L5:
        r5 = null;
        goto L6
    }
}
