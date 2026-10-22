package com.bytedance.ee.bear.facade.common.empty;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final d a;
    public final View b;
    public final EmptyStateSource c;

    public final void a(EmptyStateSource.b r4) {
        tt5.a.h("EmptyViewMediator", "updateEmptyState");
        if (r4 != null) goto L5;
        return;
    L5:
        int r5 = r4.a;
        tt5.a.h("EmptyViewMediator", "emptyState.getState:" + r5);
        if (r5 != 0) goto L8;
    L55:
        this.a.show();
        View r6 = this.b;
        if (r6 == null) goto L58;
        r6.setVisibility(4);
    L58:
        this.a.showLoading();
        return;
    L8:
        if (r5 != 1) goto L10;
        this.a.show();
        View r7 = this.b;
        if (r7 == null) goto L54;
        r7.setVisibility(4);
    L54:
        this.a.showNoContent();
        return;
    L10:
        if (r5 != 2) goto L12;
        this.a.hide();
        View r8 = this.b;
        if (r8 == null) goto L68;
        r8.setVisibility(0);
        return;
    L68:
        return;
    L12:
        if (r5 == 3) goto L44;
        if (r5 != 4) goto L15;
        this.a.show();
        View r9 = this.b;
        if (r9 == null) goto L43;
        r9.setVisibility(4);
    L43:
        this.a.showNoNetworkError();
        return;
    L15:
        if (r5 != 5) goto L17;
        this.a.show();
        View r10 = this.b;
        if (r10 == null) goto L39;
        r10.setVisibility(4);
    L39:
        this.a.showNoFound();
        return;
    L17:
        if (r5 == 99) goto L32;
        switch(r5) {
            case 7: goto L28;
            case 8: goto L55;
            case 9: goto L24;
            case 10: goto L20;
            default: goto L19;
        };
    L19:
        tt5.a.d("EmptyViewMediator", "onChanged: unknown state = " + r5);
        return;
    L20:
        this.a.show();
        View r11 = this.b;
        if (r11 == null) goto L23;
        r11.setVisibility(4);
    L23:
        this.a.showNoSupport();
        return;
    L24:
        this.a.show();
        View r12 = this.b;
        if (r12 == null) goto L27;
        r12.setVisibility(4);
    L27:
        this.a.showWikiDeleted();
        return;
    L28:
        this.a.show();
        View r13 = this.b;
        if (r13 == null) goto L31;
        r13.setVisibility(4);
    L31:
        this.a.showTimeout();
        return;
    L32:
        this.a.show();
        View r14 = this.b;
        if (r14 == null) goto L35;
        r14.setVisibility(4);
    L35:
        this.a.showNoPermission();
        return;
    L44:
        this.a.show();
        View r16 = this.b;
        if (r16 == null) goto L47;
        r16.setVisibility(4);
    L47:
        this.a.a();
    }

    public c(d r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public c(Context r1, LifecycleOwner r2, EmptyView r3, View r4) {
        this.a = r3;
        this.b = r4;
        EmptyStateSource r5 = new EmptyStateSource(r1);
        this.c = r5;
        r5.observe(r2, new b(this));
    }
}
