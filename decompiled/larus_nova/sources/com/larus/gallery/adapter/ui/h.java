package com.larus.gallery.adapter.ui;

import com.larus.gallery.adapter.r;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;

/* JADX INFO: loaded from: classes29.dex */
public final class h implements l19.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseScaleGalleryView f343773a;

    public h(BaseScaleGalleryView r100) {
        this.f343773a = r100;
    }

    @Override // l19.f
    public final void onTransitionBegin(int r100) {
        FLogger.f375446a.i(this.f343773a.f343730b, "onTransitionBegin " + r100);
        Iterator<T> r101 = this.f343773a.f343732d.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((l19.f) r101.next()).onTransitionBegin(r100);
        goto L4
    L6:
        r r102 = this.f343773a.getListener();
        if (r102 == null) goto L11;
        r102.j();
        return;
    }

    @Override // l19.f
    public final void onTransitionEnd(int r100) {
        FLogger.f375446a.i(this.f343773a.f343730b, "onTransitionEnd " + r100);
        Iterator<T> r101 = this.f343773a.f343732d.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((l19.f) r101.next()).onTransitionEnd(r100);
        goto L4
    L6:
        r r102 = this.f343773a.getListener();
        if (r102 != null) goto L9;
        return;
    L9:
        if (this.f343773a.f() == false) goto L13;
        BaseScaleGalleryView r103 = this.f343773a;
        if (r103.d(r103.getControllerImp().f327679l) == true) goto L13;
        boolean r104 = true;
    L14:
        r102.i(r104);
        return;
    L13:
        r104 = false;
        goto L14
    }

    @Override // l19.f
    public final void onTransitionChanged(int r100, float r101) {
        FLogger.f375446a.i(this.f343773a.f343730b, "onTransitionChanged " + r100 + ' ' + r101 + ' ' + this.f343773a.getDismissAnimationType());
        Iterator<T> r102 = this.f343773a.f343732d.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        ((l19.f) r102.next()).onTransitionChanged(r100, r101);
        goto L4
    L7:
        if (r100 == 2) goto L9;
        return;
    L9:
        if (this.f343773a.getDismissAnimationType() != 1) goto L14;
        this.f343773a.setAlpha(1 - r101);
        return;
    }
}
