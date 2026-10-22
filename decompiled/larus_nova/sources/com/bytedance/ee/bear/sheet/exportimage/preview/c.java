package com.bytedance.ee.bear.sheet.exportimage.preview;

import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetImagePreviewFragment f237583a;

    public c(SheetImagePreviewFragment r100) {
        this.f237583a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        FrameLayout r102 = this.f237583a.f237539k;
        if (r102 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L7;
        int r103 = 0;
    L8:
        r102.setVisibility(r103);
        return;
    L7:
        r103 = 8;
        goto L8
    }
}
