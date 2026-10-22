package androidx.camera.core.impl;

import androidx.camera.core.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface ImageInfoProcessor {
    CaptureStage getCaptureStage();

    boolean process(ImageInfo r1);
}
