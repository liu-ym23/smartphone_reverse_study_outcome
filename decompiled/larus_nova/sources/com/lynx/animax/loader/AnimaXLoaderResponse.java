package com.lynx.animax.loader;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final class AnimaXLoaderResponse<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f380307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f380308b;

    public static final enum Type extends Enum<Type> {
        public static final Type BITMAP = null;
        public static final Type BYTE_ARRAY = null;
        public static final Type ERROR = null;
        public static final Type STRING_FILE_PATH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f380309a = null;

        static {
            Type r100 = new Type("STRING_FILE_PATH", 0);
            STRING_FILE_PATH = r100;
            Type r101 = new Type("BYTE_ARRAY", 1);
            BYTE_ARRAY = r101;
            Type r102 = new Type("BITMAP", 2);
            BITMAP = r102;
            Type r103 = new Type("ERROR", 3);
            ERROR = r103;
            f380309a = new Type[]{r100, r101, r102, r103};
        }

        public static Type[] values() {
            return (Type[]) f380309a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public Type getType() {
        return this.f380307a;
    }

    public static AnimaXLoaderResponse<byte[]> a(byte[] r100) {
        return new AnimaXLoaderResponse(Type.BYTE_ARRAY, r100);
    }

    public static AnimaXLoaderResponse<Throwable> b(Throwable r100) {
        return new AnimaXLoaderResponse(Type.ERROR, r100);
    }

    public AnimaXLoaderResponse(Type r100, T r101) {
        this.f380307a = r100;
        this.f380308b = r101;
    }
}
