package androidx.camera.core.processing;

import androidx.camera.core.ImageCaptureException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface Operation<I, O> {
    O apply(I r1) throws ImageCaptureException;
}
