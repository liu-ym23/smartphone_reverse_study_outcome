package com.bytedance.locallife.photo.internal.photodraweeview.transition;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransitionPhotoDraweeView f262068a;

    public c(TransitionPhotoDraweeView r100) {
        this.f262068a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TransitionPhotoDraweeView r100 = this.f262068a;     // Catch: Throwable -> L8
        int r101 = TransitionPhotoDraweeView.f262041t;     // Catch: Throwable -> L8
        r100.getClass();     // Catch: Throwable -> L8
        Iterator r102 = new ArrayList(r100.f262046e).iterator();     // Catch: Throwable -> L8
    L4:
        if (r102.hasNext() == false) goto L6;
        ((a) r102.next()).onTransitionChanged(1, 0.0f);     // Catch: Throwable -> L8
        goto L4
    L6:
        TransitionPhotoDraweeView.f(this.f262068a, 2);     // Catch: Throwable -> L8
        TransitionPhotoDraweeView.f(this.f262068a, 1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
