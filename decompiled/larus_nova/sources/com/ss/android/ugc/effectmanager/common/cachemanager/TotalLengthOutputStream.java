package com.ss.android.ugc.effectmanager.common.cachemanager;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0010H\u0016R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/effectmanager/common/cachemanager/TotalLengthOutputStream;", "Ljava/io/FilterOutputStream;", "outStream", "Ljava/io/OutputStream;", "(Ljava/io/OutputStream;)V", "<set-?>", "", "length", "getLength", "()J", "close", "", "write", "b", "", "off", "", "len", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class TotalLengthOutputStream extends FilterOutputStream {
    private long length;

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterOutputStream) this).out.close();
    }

    public final long getLength() {
        return this.length;
    }

    public TotalLengthOutputStream(OutputStream r100) {
        super(r100);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r100) {
        ((FilterOutputStream) this).out.write(r100);
        this.length++;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) {
        ((FilterOutputStream) this).out.write(r100, r101, r102);
        this.length += (long) r102;
    }
}
