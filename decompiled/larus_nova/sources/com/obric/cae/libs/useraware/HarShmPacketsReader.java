package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.system.OsConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes33.dex */
public class HarShmPacketsReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f395941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedMemory f395942b;

    public HarShmPacketsReader() {
    }

    public static int getSingleBufferSize() {
        return 65536;
    }

    public void closeShm() {
        ByteBuffer r100 = this.f395941a;
        if (r100 == null) goto L5;
        SharedMemory.unmap(r100);
        this.f395941a = null;
    L5:
        SharedMemory r101 = this.f395942b;
        if (r101 == null) goto L9;
        r101.close();
        this.f395942b = null;
        return;
    }

    public ByteBuffer getHarShmMappedBuffer() {
        return this.f395941a;
    }

    public boolean openShm(ParcelFileDescriptor r100) {
        this.f395942b = SharedMemory.fromFileDescriptor(r100);     // Catch: Throwable -> L6 ErrnoException -> L8
        r100.close();     // Catch: Throwable -> L6 ErrnoException -> L8
        SharedMemory r101 = this.f395942b;     // Catch: Throwable -> L6 ErrnoException -> L8
        this.f395941a = r101.map(OsConstants.PROT_READ, 0, r101.getSize());     // Catch: Throwable -> L6 ErrnoException -> L8
        return true;
    L6:
        e = move-exception;
        this.f395941a = null;
        e.printStackTrace();
        return false;
    }

    public List<UnifiedDataPacket> processDataBatch(ByteBuffer r100, int r110, int r111) {
        int r112 = r110 * 65536;
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L3:
        if (r102 >= r111) goto L24;
        r100.position(r112 + r102);
        if (r100.remaining() < 4) goto L24;
        int r103 = r100.getInt();
        if (r103 <= 0) goto L24;
        if (r103 > 65536) goto L24;
        if (r100.remaining() < r103) goto L24;
        byte[] r104 = new byte[r103];
        r100.get(r104);
        Parcelable.Creator<UnifiedDataPacket> r105 = UnifiedDataPacket.CREATOR;
        Parcel r106 = Parcel.obtain();
        r106.unmarshall(r104, 0, r103);     // Catch: Throwable -> L20
        r106.setDataPosition(0);     // Catch: Throwable -> L20
        UnifiedDataPacket r107 = r105.createFromParcel(r106);     // Catch: Throwable -> L20
        r106.recycle();
        UnifiedDataPacket r108 = r107;
        if (r108 == null) goto L19;
        r101.add(r108);
    L19:
        r102 = r102 + (r103 + 4);
    L20:
        th = move-exception;
        r106.recycle();
        throw th;
    L24:
        return r101;
    }
}
