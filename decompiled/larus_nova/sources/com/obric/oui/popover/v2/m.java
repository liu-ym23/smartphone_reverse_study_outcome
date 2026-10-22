package com.obric.oui.popover.v2;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
public final class m implements c.InterfaceC4677c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<WeakReference<c>> f402437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f402438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f402439c;

    @Override // com.obric.oui.popover.v2.c.InterfaceC4677c
    public final void bubbleDismiss() {
        WeakReference<c> r100 = this.f402437a.element;
        if (r100 == null) goto L12;
        c r101 = r100.get();
        if (r101 == null) goto L12;
        View r102 = r101.getContentView();
        if (r102 == null) goto L12;
        r102.removeCallbacks(this.f402438b);
    L12:
        this.f402439c.getClass();
    }

    public m(Ref.ObjectRef r100, l r101, o r102) {
        this.f402437a = r100;
        this.f402438b = r101;
        this.f402439c = r102;
    }
}
