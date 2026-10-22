package com.ss.android.ttvecamera;

import android.media.Image;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes38.dex */
public class TEPlane {
    Image.Plane[] planes;

    public TEPlane() {
    }

    public Image.Plane[] getPlanes() {
        return this.planes;
    }

    public TEPlane(Image.Plane[] r100) {
        this.planes = r100;
    }

    public ByteBuffer getPlaneBuffer(int r100) {
        Image.Plane[] r101 = this.planes;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.length > r100) goto L7;
        return null;
    L7:
        return r101[r100].getBuffer();
    }
}
