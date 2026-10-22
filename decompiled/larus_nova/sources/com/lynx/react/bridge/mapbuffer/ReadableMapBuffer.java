package com.lynx.react.bridge.mapbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public class ReadableMapBuffer extends d implements MapBuffer {

    public class a implements Iterator<MapBuffer.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f381450a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f381450a.hasNext();
        }

        @Override // java.util.Iterator
        public final MapBuffer.a next() {
            return (MapBuffer.a) this.f381450a.next();
        }

        public a(ReadableMapBuffer r100) {
            r100.getClass();
            this.f381450a = new c(r100);
        }
    }

    @Override // com.lynx.react.bridge.mapbuffer.d
    public final int a(int r100) {
        return (r100 * 12) + 8;
    }

    @Override // java.lang.Iterable
    public final Iterator<MapBuffer.a> iterator() {
        return new a(this);
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public final ReadableMapBuffer b(int r100) {
        return new ReadableMapBuffer(ByteBuffer.wrap(c(e(r100, MapBuffer.DataType.ARRAY))), -1);
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public final boolean contains(int r100) {
        if (d(r100) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public final int d(int r100) {
        int r101 = this.f381456b - 1;
        int r102 = 0;
    L3:
        if (r102 > r101) goto L10;
        int r103 = (r102 + r101) >> 1;
        short r104 = this.f381455a.getShort((r103 * 12) + 8);
        if (r104 < r100) goto L6;
        if (r104 <= r100) goto L9;
        r101 = r103 - 1;
        goto L3
    L9:
        return r103;
    L6:
        r102 = r103 + 1;
        goto L3
    L10:
        return -1;
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public final boolean getBoolean(int r100) {
        int r101 = e(r100, MapBuffer.DataType.BOOL);
        if (this.f381455a.getInt(r101) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public final double getDouble(int r100) {
        int r101 = e(r100, MapBuffer.DataType.DOUBLE);
        return this.f381455a.getDouble(r101);
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public final int getInt(int r100) {
        int r101 = e(r100, MapBuffer.DataType.INT);
        return this.f381455a.getInt(r101);
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public final long getLong(int r100) {
        int r101 = e(r100, MapBuffer.DataType.LONG);
        return this.f381455a.getLong(r101);
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public final String getString(int r100) {
        return new String(c(e(r100, MapBuffer.DataType.STRING)), Charset.defaultCharset());
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public MapBuffer.DataType getType(int r100) {
        int r101 = ((d(r100) * 12) + 8) + 2;
        short r102 = this.f381455a.getShort(r101);
        return MapBuffer.DataType.values()[r102];
    }

    public ReadableMapBuffer(ByteBuffer r100, int r101) {
        super(r100, r101, 2, 4);
    }

    public static ReadableMapBuffer fromByteBufferWithCount(byte[] r100, int r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new ReadableMapBuffer(ByteBuffer.wrap(r100), r101);
    }

    public final int e(int r100, MapBuffer.DataType r101) {
        int r102 = d(r100);
        if (r102 != (-1)) goto L5;
        return -1;
    L5:
        int r103 = (r102 * 12) + 8;
        MapBuffer.DataType r104 = MapBuffer.DataType.values()[this.f381455a.getShort(r103 + 2)];
        if (r104 != r101) goto L10;
        return r103 + 4;
    L10:
        throw new RuntimeException("Expected " + r101 + " for key: " + r100 + ", found " + r104 + " instead.");
    }
}
