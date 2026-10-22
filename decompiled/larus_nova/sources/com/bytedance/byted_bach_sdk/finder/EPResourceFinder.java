package com.bytedance.byted_bach_sdk.finder;

import com.bef.effectsdk.ResourceFinder;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: loaded from: classes8.dex */
public class EPResourceFinder extends BachResourceFinder {
    private native long nativeCreate(long r100);

    private native void nativeDestroy(long r100);

    @Override // com.bytedance.byted_bach_sdk.finder.BachResourceFinder
    public void destroy() {
        if (this.isDestroyed == false) goto L5;
        return;
    L5:
        this.isDestroyed = true;
        nativeDestroy(this.m_nativePtr);
    }

    private static long generateLongKey() {
        byte[] r100 = new byte[8];
        System.arraycopy(toBytes(UUID.randomUUID()), 0, r100, 0, 8);
        return ByteBuffer.wrap(r100).getLong();
    }

    public void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public EPResourceFinder(ResourceFinder r100) {
        this.m_nativePtr = nativeCreate(r100.createNativeResourceFinder(generateLongKey()));
    }

    private static byte[] toBytes(UUID r100) {
        ByteBuffer r101 = ByteBuffer.allocate(16);
        r101.putLong(r100.getMostSignificantBits());
        r101.putLong(r100.getLeastSignificantBits());
        return r101.array();
    }

    public EPResourceFinder(long r100) {
        this.m_nativePtr = nativeCreate(r100);
    }
}
