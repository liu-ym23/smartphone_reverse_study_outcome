package com.bytedance.locallife.poi.media.photo;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class o implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlidesPhotosView f262793a;

    public o(SlidesPhotosView r100) {
        this.f262793a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Iterator<T> r101 = this.f262793a.f262728x.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((View.OnAttachStateChangeListener) r101.next()).onViewAttachedToWindow(r100);
        goto L4
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Iterator<T> r101 = this.f262793a.f262728x.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((View.OnAttachStateChangeListener) r101.next()).onViewDetachedFromWindow(r100);
        goto L4
    }
}
