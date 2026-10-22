package com.bytedance.ee.bear.drive.view.preview.image.progressloader.decode;

import o95.b;
import o95.c;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ImageWrapper<D, E> {
    public final boolean a;
    public final c<D> b;
    public final c<E> c;
    public final Type d;

    public static final enum Type extends Enum<Type> {
        public static final Type DECODED = null;
        public static final Type ENCODED = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r0 = new Type("ENCODED", 0);
            ENCODED = r0;
            Type r1 = new Type("DECODED", 1);
            DECODED = r1;
            a = new Type[]{r0, r1};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    public Type getType() {
        return this.d;
    }

    public ImageWrapper(o95.a r1, b r2, Type r3, boolean r4) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.a = r4;
    }
}
