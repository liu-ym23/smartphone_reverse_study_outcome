package com.bytedance.awemeopen.apps.framework.card.impression;

import android.view.View;
import android.view.ViewTreeObserver;
import cy3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final View a;
    public final InterfaceC0067a b;
    public boolean c;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.card.impression.a$a, reason: collision with other inner class name */
    public interface InterfaceC0067a {
        void l(boolean r1);
    }

    public a(View r2, InterfaceC0067a r3) {
        this.c = false;
        ViewTreeObserver.OnScrollChangedListener r0 = new b(this);
        this.a = r2;
        this.b = r3;
        r2.getViewTreeObserver().addOnScrollChangedListener(r0);
    }
}
