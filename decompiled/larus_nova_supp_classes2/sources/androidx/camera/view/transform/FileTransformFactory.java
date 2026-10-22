package androidx.camera.view.transform;

import android.content.ContentResolver;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class FileTransformFactory {
    private boolean mUsingExifOrientation;

    public FileTransformFactory() {
    }

    public boolean isUsingExifOrientation() {
        return this.mUsingExifOrientation;
    }

    public OutputTransform getOutputTransform(InputStream r5) throws IOException {
        Exif r6 = Exif.createFromInputStream(r5);
        Rect r0 = new Rect(0, 0, r6.getWidth(), r6.getHeight());
        Matrix r1 = TransformUtils.getNormalizedToBuffer(r0);
        if (this.mUsingExifOrientation == false) goto L6;
        r1.postConcat(TransformUtils.getExifTransform(r6.getOrientation(), r6.getWidth(), r6.getHeight()));
    L6:
        return new OutputTransform(r1, TransformUtils.rectToSize(r0));
    }

    public void setUsingExifOrientation(boolean r1) {
        this.mUsingExifOrientation = r1;
    }

    public OutputTransform getOutputTransform(File r2) throws IOException {
        FileInputStream r0 = new FileInputStream(r2);
        OutputTransform r3 = getOutputTransform(r0);     // Catch: Throwable -> L6
        r0.close();
        return r3;
    L6:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    public OutputTransform getOutputTransform(ContentResolver r1, Uri r2) throws IOException {
        InputStream r3 = r1.openInputStream(r2);
        OutputTransform r4 = getOutputTransform(r3);     // Catch: Throwable -> L7
        if (r3 == null) goto L6;
        r3.close();
    L6:
        return r4;
    L7:
        th = move-exception;
        if (r3 != null) goto L14;
    L13:
        throw th;
    L14:
        r3.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }
}
