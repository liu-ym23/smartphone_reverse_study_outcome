package com.lynx.animax.loader;

import android.graphics.Bitmap;
import u4a.j;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXCloseableBitmapReferenceNativeAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f380300a;

    public void close() {
        this.f380300a.close();
    }

    public Bitmap get() {
        return this.f380300a.get();
    }

    public boolean isValid() {
        return this.f380300a.isValid();
    }

    public AnimaXCloseableBitmapReferenceNativeAdapter(j r100) {
        this.f380300a = r100;
    }
}
