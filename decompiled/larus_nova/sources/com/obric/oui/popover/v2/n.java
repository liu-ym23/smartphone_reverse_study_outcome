package com.obric.oui.popover.v2;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
public final class n implements c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f402440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<WeakReference<c>> f402441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f402442c;

    @Override // com.obric.oui.popover.v2.c.d
    public final void bubbleShow() {
        this.f402440a.getClass();
        if (this.f402440a.f402450h > 0) goto L5;
        return;
    L5:
        WeakReference<c> r100 = this.f402441b.element;
        if (r100 != null) goto L12;
        wma.a r101 = wma.b.f560377a;
        if (wma.b.e(8) == true) goto L27;
        wma.b.f560377a.a("OTooltip", "auto dismiss schedule skipped: popover reference missing.");
        return;
    L27:
        return;
    L12:
        c r102 = r100.get();
        if (r102 == null) goto L19;
        View r103 = r102.getContentView();
        if (r103 == null) goto L19;
        r103.removeCallbacks(this.f402442c);
    L19:
        c r104 = r100.get();
        if (r104 == null) goto L28;
        View r105 = r104.getContentView();
        if (r105 == null) goto L29;
        r105.postDelayed(this.f402442c, this.f402440a.f402450h);
        return;
    L29:
        return;
    }

    public n(o r100, Ref.ObjectRef r101, l r102) {
        this.f402440a = r100;
        this.f402441b = r101;
        this.f402442c = r102;
    }
}
