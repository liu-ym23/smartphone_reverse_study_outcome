package com.ss.android.videoshop.mediaview;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;

/* JADX INFO: loaded from: classes40.dex */
public interface a {

    /* JADX INFO: renamed from: com.ss.android.videoshop.mediaview.a$a, reason: collision with other inner class name */
    public interface InterfaceC5459a {
    }

    Bitmap getBitmap();

    int getHeight();

    Surface getSurface();

    SurfaceHolder getSurfaceHolder();

    View getView();

    int getWidth();

    void setPlayEntity(tic.a r100);

    void setSurfaceCallback(InterfaceC5459a r100);
}
