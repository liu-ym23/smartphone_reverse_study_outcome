package com.larus.camera.impl.utils;

import android.content.Context;
import android.view.OrientationEventListener;

/* JADX INFO: loaded from: classes26.dex */
public final class d0 extends OrientationEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f322746a;

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int r100) {
        if (r100 != (-1)) goto L5;
        return;
    L5:
        this.f322746a.getClass();
        int r101 = 0;
        if (r100 > 60) goto L8;
    L24:
        c0 r102 = this.f322746a;
        if (r102.f322740b != r101) goto L27;
        return;
    L27:
        r102.f322740b = r101;
        if (r102.f322739a.invoke(Integer.valueOf(r101)).booleanValue() == true) goto L31;
        disable();
        return;
    L31:
        return;
    L8:
        if (r100 > 300) goto L24;
        if (61 > r100) goto L14;
        if (r100 >= 136) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
        r101 = 90;
        goto L24
    L17:
        if (136 <= r100) goto L19;
    L21:
        if (r101 == 0) goto L23;
        r101 = 180;
        goto L24
    L23:
        r101 = 270;
        goto L24
    L19:
        if (r100 >= 226) goto L21;
        r101 = 1;
    L14:
        r103 = false;
        goto L15
    }

    public d0(c0 r100, Context r101) {
        this.f322746a = r100;
        super(r101);
    }
}
