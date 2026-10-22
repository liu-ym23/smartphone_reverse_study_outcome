package com.ss.android.lark.widget.photo.preview.video.cover;

import android.view.View;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes38.dex */
public final class p<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f447231a;

    public p(View r100) {
        this.f447231a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        boolean r101 = ((Boolean) r100).booleanValue();
        View r102 = this.f447231a;
        if (r101 == false) goto L5;
        int r103 = 0;
    L6:
        r102.setVisibility(r103);
        return;
    L5:
        r103 = 8;
        goto L6
    }
}
