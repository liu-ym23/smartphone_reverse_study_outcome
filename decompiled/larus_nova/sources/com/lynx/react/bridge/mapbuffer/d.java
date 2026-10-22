package com.lynx.react.bridge.mapbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: loaded from: classes32.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f381455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f381456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f381457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f381458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f381459e;

    public class a implements MapBuffer.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f381460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f381461b;

        @Override // com.lynx.react.bridge.mapbuffer.a.InterfaceC4560a
        public final int a() {
            d r100 = this.f381461b;
            int r101 = this.f381460a + r100.f381458d;
            return r100.f381455a.getInt(r101);
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.a, com.lynx.react.bridge.mapbuffer.a.InterfaceC4560a
        public final double b() {
            d r100 = this.f381461b;
            int r101 = this.f381460a + r100.f381458d;
            return r100.f381455a.getDouble(r101);
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.a, com.lynx.react.bridge.mapbuffer.a.InterfaceC4560a
        public final long c() {
            d r100 = this.f381461b;
            int r101 = this.f381460a + r100.f381458d;
            return r100.f381455a.getLong(r101);
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.a
        public final boolean e() {
            d r100 = this.f381461b;
            int r101 = this.f381460a + r100.f381458d;
            if (r100.f381455a.getInt(r101) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.a
        public final ReadableMapBuffer f() {
            d r100 = this.f381461b;
            return new ReadableMapBuffer(ByteBuffer.wrap(r100.c(this.f381460a + r100.f381458d)), -1);
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.a
        public final int getKey() {
            d r100 = this.f381461b;
            int r101 = this.f381460a;
            return r100.f381455a.getShort(r101);
        }

        @Override // com.lynx.react.bridge.mapbuffer.a.InterfaceC4560a
        public final String getString() {
            d r100 = this.f381461b;
            return new String(r100.c(this.f381460a + r100.f381458d), Charset.defaultCharset());
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.a
        public MapBuffer.DataType getType() {
            MapBuffer.DataType[] r100 = MapBuffer.DataType.values();
            d r101 = this.f381461b;
            int r102 = this.f381460a + r101.f381457c;
            return r100[r101.f381455a.getShort(r102)];
        }

        public a(d r100, int r101) {
            this.f381461b = r100;
            this.f381460a = 0;
            this.f381460a = r101;
        }
    }

    public abstract int a(int r100);

    public final int hashCode() {
        this.f381455a.rewind();
        return this.f381455a.hashCode();
    }

    public final int count() {
        return this.f381456b;
    }

    public final byte[] c(int r100) {
        int r101 = this.f381459e + this.f381455a.getInt(r100);
        int r102 = this.f381455a.getInt(r101);
        byte[] r103 = new byte[r102];
        ByteBuffer r104 = this.f381455a;
        r104.position(r101 + 4);
        this.f381455a.get(r103, 0, r102);
        return r103;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        d r101 = (d) r100;
        if (this.f381456b == r101.f381456b) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.f381455a, r101.f381455a) == false) goto L15;
        return true;
    }

    public d(ByteBuffer r100, int r101, int r102, int r103) {
        this.f381457c = 0;
        this.f381458d = 0;
        this.f381455a = r100;
        this.f381456b = r101;
        this.f381457c = r102;
        this.f381458d = r103;
        if (r100 == null) goto L9;
        r100.order(ByteOrder.nativeOrder());
        if (this.f381456b != (-1)) goto L7;
        r100.position(2);
        this.f381456b = r100.getShort(r100.position());
    L7:
        this.f381459e = a(this.f381456b);
        return;
    }
}
