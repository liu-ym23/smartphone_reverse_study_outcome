package com.lynx.clay.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes32.dex */
public final class k extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f380667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f380668b;

    public k(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        Bitmap r101 = this.f380667a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isRecycled() == true) goto L13;
        r100.drawBitmap(this.f380667a, null, new Rect(0, 0, getWidth(), getHeight()), null);
        Runnable r102 = this.f380668b;
        if (r102 == null) goto L12;
        this.f380668b = null;
        r102.run();
        return;
    L12:
        return;
    }
}
