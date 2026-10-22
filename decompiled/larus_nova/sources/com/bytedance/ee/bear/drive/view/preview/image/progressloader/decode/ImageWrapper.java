package com.bytedance.ee.bear.drive.view.preview.image.progressloader.decode;

import o95.b;
import o95.c;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final class ImageWrapper<D, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f224976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c<D> f224977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c<E> f224978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Type f224979d;

    public static final enum Type extends Enum<Type> {
        public static final Type DECODED = null;
        public static final Type ENCODED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f224980a = null;

        static {
            Type r100 = new Type("ENCODED", 0);
            ENCODED = r100;
            Type r101 = new Type("DECODED", 1);
            DECODED = r101;
            f224980a = new Type[]{r100, r101};
        }

        public static Type[] values() {
            return (Type[]) f224980a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public Type getType() {
        return this.f224979d;
    }

    public ImageWrapper(o95.a r100, b r101, Type r102, boolean r103) {
        this.f224977b = r100;
        this.f224978c = r101;
        this.f224979d = r102;
        this.f224976a = r103;
    }
}
