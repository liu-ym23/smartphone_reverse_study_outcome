package com.facebook.cache.disk;

import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes22.dex */
public class TempEncodedImage extends EncodedImage {
    private int offset;

    public int getOffset() {
        return this.offset;
    }

    public TempEncodedImage(Supplier<FileInputStream> r100) {
        super(r100);
    }

    public void setOffset(int r100) {
        this.offset = r100;
    }

    public TempEncodedImage(CloseableReference<PooledByteBuffer> r100) {
        super(r100);
    }

    public TempEncodedImage(Supplier<FileInputStream> r100, int r101) {
        super(r100, r101);
    }
}
