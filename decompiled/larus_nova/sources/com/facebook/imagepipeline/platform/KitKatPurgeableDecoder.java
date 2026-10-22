package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;

/* JADX INFO: loaded from: classes23.dex */
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder {
    private final FlexByteArrayPool mFlexByteArrayPool;

    public KitKatPurgeableDecoder(FlexByteArrayPool r100) {
        this.mFlexByteArrayPool = r100;
    }

    private static void putEOI(byte[] r100, int r101) {
        r100[r101] = -1;
        r100[r101 + 1] = -39;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> r100, BitmapFactory.Options r101) {
        PooledByteBuffer r102 = r100.get();
        int r103 = r102.size();
        CloseableReference<byte[]> r104 = this.mFlexByteArrayPool.get(r103);
        byte[] r105 = r104.get();     // Catch: Throwable -> L6
        r102.read(0, r105, 0, r103);     // Catch: Throwable -> L6
        Bitmap r106 = (Bitmap) Preconditions.checkNotNull(BitmapFactory.decodeByteArray(r105, 0, r103, r101), "BitmapFactory returned null");     // Catch: Throwable -> L6
        CloseableReference.closeSafely(r104);
        return r106;
    L6:
        th = move-exception;
        CloseableReference.closeSafely(r104);
        throw th;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> r100, int r101, BitmapFactory.Options r102) {
        if (DalvikPurgeableDecoder.endsWithEOI(r100, r101) == false) goto L5;
        byte[] r103 = null;
    L6:
        PooledByteBuffer r104 = r100.get();
        if (r101 > r104.size()) goto L9;
        boolean r105 = true;
    L10:
        Preconditions.checkArgument(r105);
        int r106 = r101 + 2;
        CloseableReference<byte[]> r107 = this.mFlexByteArrayPool.get(r106);
        byte[] r108 = r107.get();     // Catch: Throwable -> L17
        r104.read(0, r108, 0, r101);     // Catch: Throwable -> L17
        if (r103 == null) goto L14;
        putEOI(r108, r101);     // Catch: Throwable -> L17
        r101 = r106;
    L14:
        Bitmap r109 = (Bitmap) Preconditions.checkNotNull(BitmapFactory.decodeByteArray(r108, 0, r101, r102), "BitmapFactory returned null");     // Catch: Throwable -> L17
        CloseableReference.closeSafely(r107);
        return r109;
    L17:
        th = move-exception;
        CloseableReference.closeSafely(r107);
        throw th;
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = DalvikPurgeableDecoder.EOI;
        goto L6
    }
}
