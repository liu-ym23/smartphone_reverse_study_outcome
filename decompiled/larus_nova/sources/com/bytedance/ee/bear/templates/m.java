package com.bytedance.ee.bear.templates;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TemplateViewHolder2 f239125a;

    public m(TemplateViewHolder2 r100) {
        this.f239125a = r100;
    }

    public final void a() {
        Rect r100 = new Rect(this.f239125a.f238827h.getLeft() - cu5.c.b(20), this.f239125a.f238827h.getTop() - cu5.c.b(20), this.f239125a.f238820a.getRight(), this.f239125a.f238820a.getBottom());
        ViewParent r101 = this.f239125a.f238827h.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r102 = (ViewGroup) r101;
    L6:
        if (r102 == null) goto L9;
        r102.setTouchDelegate(new TouchDelegate(r100, this.f239125a.f238827h));
        return;
    L9:
        return;
    L5:
        r102 = null;
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
