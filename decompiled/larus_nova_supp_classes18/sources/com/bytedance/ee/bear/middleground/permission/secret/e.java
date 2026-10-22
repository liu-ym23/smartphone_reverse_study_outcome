package com.bytedance.ee.bear.middleground.permission.secret;

import android.view.View;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements Runnable {
    public final /* synthetic */ InputReasonFragment a;

    public e(InputReasonFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a.getView();     // Catch: Throwable -> L8
        if (r0 == null) goto L5;
        UDEditText r1 = (SpaceEditText) r0.findViewById(2131375324);     // Catch: Throwable -> L8
    L6:
        rcb.c.h(r1, null);     // Catch: Throwable -> L8
        return;
    L5:
        r1 = null;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
