package com.lynx.react.bridge;

import java.nio.ByteBuffer;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final class PiperData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f381443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataType f381444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f381445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f381446d;

    public static final enum DataType extends Enum<DataType> {
        public static final DataType Empty = null;
        public static final DataType Map = null;
        public static final DataType String = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DataType[] f381447a = null;

        static {
            DataType r100 = new DataType("Empty", 0);
            Empty = r100;
            DataType r101 = new DataType("String", 1);
            String = r101;
            DataType r102 = new DataType("Map", 2);
            Map = r102;
            f381447a = new DataType[]{r100, r101, r102};
        }

        public static DataType[] values() {
            return (DataType[]) f381447a.clone();
        }

        public static DataType valueOf(String r100) {
            return (DataType) a.a(DataType.class, r100);
        }

        public DataType(String r100, int r101) {
            super(r100, r101);
        }
    }

    private static native long nativeParseStringData(String r100);

    private static native void nativeReleaseData(long r100);

    public long getNativePtr() {
        return 0;
    }

    private boolean recycleIfIsDisposable() {
        if (this.f381445c == false) goto L8;
        if (this.f381444b == DataType.Empty) goto L8;
        a();
    L8:
        return this.f381445c;
    }

    public final void a() {
        this.f381444b = DataType.Empty;
        this.f381443a = null;
    }

    public int getBufferPosition() {
        ByteBuffer r100 = this.f381443a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.position();
    }

    public int getDataType() {
        return this.f381444b.ordinal();
    }

    public PiperData() {
        this.f381443a = null;
        this.f381444b = DataType.Empty;
        this.f381445c = false;
    }

    public final void finalize() throws Throwable {
        super.finalize();
        if (this.f381444b == DataType.Empty) goto L6;
        a();
        return;
    }

    public ByteBuffer getBuffer() {
        return this.f381443a;
    }

    public PiperData(Object r100, boolean r101) {
        this.f381443a = null;
        this.f381444b = DataType.Empty;
        this.f381445c = false;
        this.f381444b = DataType.Map;
        j7a.a.f497652a.getClass();
        this.f381443a = j7a.a.b(r100);
        this.f381445c = r101;
        this.f381446d = r100;
    }
}
