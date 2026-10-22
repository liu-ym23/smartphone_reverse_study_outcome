package com.bytedance.ee.bear.templates;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements Runnable {
    public final /* synthetic */ TemplateViewHolder2 a;

    public m(TemplateViewHolder2 r1) {
        this.a = r1;
    }

    public final void a() {
        Rect r0 = new Rect(this.a.h.getLeft() - cu5.c.b(20), this.a.h.getTop() - cu5.c.b(20), this.a.a.getRight(), this.a.a.getBottom());
        ViewParent r1 = this.a.h.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L5;
        ViewGroup r2 = (ViewGroup) r1;
    L6:
        if (r2 == null) goto L9;
        r2.setTouchDelegate(new TouchDelegate(r0, this.a.h));
        return;
    L9:
        return;
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
