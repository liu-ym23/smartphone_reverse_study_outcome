package com.lynx.react.bridge.mapbuffer;

import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public class ReadableCompactArrayBuffer extends d implements com.lynx.react.bridge.mapbuffer.a {

    public class a implements Iterator<com.lynx.react.bridge.mapbuffer.a.InterfaceC4560a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f381449a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f381449a.hasNext();
        }

        @Override // java.util.Iterator
        public final com.lynx.react.bridge.mapbuffer.a.InterfaceC4560a next() {
            return (com.lynx.react.bridge.mapbuffer.a.InterfaceC4560a) this.f381449a.next();
        }

        public a(ReadableCompactArrayBuffer r100) {
            r100.getClass();
            this.f381449a = new c(r100);
        }
    }

    @Override // com.lynx.react.bridge.mapbuffer.d
    public final int a(int r100) {
        return (r100 * 8) + 8;
    }

    @Override // java.lang.Iterable
    public final Iterator<com.lynx.react.bridge.mapbuffer.a.InterfaceC4560a> iterator() {
        return new a(this);
    }

    public ReadableCompactArrayBuffer(ByteBuffer r100, int r101) {
        super(r100, r101, 0, 0);
    }

    public static ReadableCompactArrayBuffer fromByteBufferWithCount(byte[] r100, int r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new ReadableCompactArrayBuffer(ByteBuffer.wrap(r100), r101);
    }
}
