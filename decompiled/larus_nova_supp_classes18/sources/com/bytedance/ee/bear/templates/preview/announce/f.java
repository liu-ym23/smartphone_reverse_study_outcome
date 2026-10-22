package com.bytedance.ee.bear.templates.preview.announce;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements Runnable {
    public final /* synthetic */ TemplateCardPanelFragment a;

    public f(TemplateCardPanelFragment r1) {
        this.a = r1;
    }

    public final void a() {
        AnnounceTemplateViewModel r0 = this.a.k;
        int[] r1 = null;
        if (r0 == null) goto L5;
        int[] r2 = r0.getPanelLocOnScreen();
    L6:
        if (r2 != null) goto L16;
        int[] r3 = new int[2];
        AnnounceTemplateViewModel r4 = this.a.k;
        if (r4 == null) goto L10;
        r4.setPanelLocOnScreen(r3);
    L10:
        TemplateCardPanelFragment r5 = this.a;
        ConstraintLayout r6 = r5.j;
        if (r6 == null) goto L16;
        AnnounceTemplateViewModel r7 = r5.k;
        if (r7 == null) goto L15;
        r1 = r7.getPanelLocOnScreen();
    L15:
        Intrinsics.checkNotNull(r1);
        r6.getLocationOnScreen(r1);
    L16:
        AnnounceTemplateViewModel r8 = this.a.k;
        if (r8 == null) goto L21;
        TemplateData r9 = r8.getTemplateData();
        if (r9 == null) goto L21;
        boolean r10 = Intrinsics.areEqual(r9.getNeedAnimation(), Boolean.TRUE);
    L22:
        if (r10 == false) goto L24;
        TemplateCardPanelFragment.ba0(this.a);
        return;
    L24:
        AnnounceTemplateViewModel r11 = this.a.k;
        if (r11 == null) goto L29;
        MutableLiveData<Boolean> r12 = r11.m569getPanelActive();
        if (r12 == null) goto L29;
        r12.setValue(Boolean.TRUE);
    L29:
        ConstraintLayout r13 = this.a.j;
        if (r13 == null) goto L34;
        r13.setVisibility(0);
        return;
    L34:
        return;
    L21:
        r10 = false;
        goto L22
    L5:
        r2 = null;
        goto L6
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
