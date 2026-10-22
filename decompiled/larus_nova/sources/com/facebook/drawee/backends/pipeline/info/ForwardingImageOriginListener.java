package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public class ForwardingImageOriginListener implements ImageOriginListener {
    private static final String TAG = "ForwardingImageOriginListener";
    private final List<ImageOriginListener> mImageOriginListeners;

    public ForwardingImageOriginListener(ImageOriginListener... r100) {
        ArrayList r101 = new ArrayList(r100.length);
        this.mImageOriginListeners = r101;
        Collections.addAll(r101, r100);
    }

    public synchronized void addImageOriginListener(ImageOriginListener r100) {
        monitor-enter(this);
        this.mImageOriginListeners.add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void removeImageOriginListener(ImageOriginListener r100) {
        monitor-enter(this);
        this.mImageOriginListeners.remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public ForwardingImageOriginListener(Set<ImageOriginListener> r100) {
        this.mImageOriginListeners = new ArrayList(r100);
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public synchronized void onImageLoaded(String r100, int r101, boolean r102) {
        monitor-enter(this);
        int r103 = this.mImageOriginListeners.size();     // Catch: Throwable -> L14
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L12;
        ImageOriginListener r105 = this.mImageOriginListeners.get(r104);     // Catch: Throwable -> L14
        if (r105 == null) goto L11;
        r105.onImageLoaded(r100, r101, r102);     // Catch: Exception -> L9 Throwable -> L14
    L9:
        e = move-exception;
        FLog.e(TAG, "InternalListener exception in onImageLoaded", e);     // Catch: Throwable -> L14
    L11:
        r104 = r104 + 1;
        goto L4
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
