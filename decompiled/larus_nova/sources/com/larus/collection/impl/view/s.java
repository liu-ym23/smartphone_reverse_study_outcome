package com.larus.collection.impl.view;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes26.dex */
public final class s implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalCollectionItemHolder f325648a;

    public s(NormalCollectionItemHolder r100) {
        this.f325648a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        NormalCollectionItemHolder r102 = this.f325648a;
        if (r101 == null) goto L5;
        int r103 = (int) r101.getX();
    L6:
        r102.f325624j = r103;
        NormalCollectionItemHolder r104 = this.f325648a;
        if (r101 == null) goto L9;
        int r105 = (int) r101.getY();
    L10:
        r104.f325625k = r105;
        return false;
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }
}
