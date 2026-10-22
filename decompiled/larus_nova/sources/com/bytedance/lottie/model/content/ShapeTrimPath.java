package com.bytedance.lottie.model.content;

import com.alipay.sdk.m.u.i;
import com.bytedance.lottie.LottieDrawable;
import nz6.r;
import sz6.b;

/* JADX INFO: loaded from: classes21.dex */
public final class ShapeTrimPath implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f264485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rz6.b f264486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rz6.b f264487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rz6.b f264488d;

    public static final enum Type extends Enum<Type> {
        public static final Type Individually = null;
        public static final Type Simultaneously = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f264489a = null;

        static {
            Type r100 = new Type("Simultaneously", 0);
            Simultaneously = r100;
            Type r101 = new Type("Individually", 1);
            Individually = r101;
            f264489a = new Type[]{r100, r101};
        }

        public static Type[] values() {
            return (Type[]) f264489a.clone();
        }

        public static Type forId(int r100) {
            if (r100 == 1) goto L11;
            if (r100 != 2) goto L9;
            return Individually;
        L9:
            throw new IllegalArgumentException("Unknown trim path type " + r100);
        L11:
            return Simultaneously;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String toString() {
        return "Trim Path: {start: " + this.f264486b + ", end: " + this.f264487c + ", offset: " + this.f264488d + i.f25855d;
    }

    public Type getType() {
        return this.f264485a;
    }

    @Override // sz6.b
    public final nz6.b a(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101) {
        return new r(r101, this);
    }

    public ShapeTrimPath(String r100, Type r101, rz6.b r102, rz6.b r103, rz6.b r104) {
        this.f264485a = r101;
        this.f264486b = r102;
        this.f264487c = r103;
        this.f264488d = r104;
    }
}
