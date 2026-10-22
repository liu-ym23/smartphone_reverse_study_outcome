package com.bytedance.awemeopen.apps.framework.card.impression;

import android.view.View;
import android.view.ViewTreeObserver;
import cy3.b;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f193832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2794a f193833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f193834c;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.card.impression.a$a, reason: collision with other inner class name */
    public interface InterfaceC2794a {
        void l(boolean r100);
    }

    public a(View r100, InterfaceC2794a r101) {
        this.f193834c = false;
        ViewTreeObserver.OnScrollChangedListener r102 = new b(this);
        this.f193832a = r100;
        this.f193833b = r101;
        r100.getViewTreeObserver().addOnScrollChangedListener(r102);
    }
}
