package com.lynx.tasm.utils;

import com.alibaba.gaiax.template.GXTemplateKey;

/* JADX INFO: loaded from: classes32.dex */
public final class SizeValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f384080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f384081b;

    public static final enum Type extends Enum<Type> {
        public static final Type DEVICE_PX = null;
        public static final Type PERCENTAGE = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f384082a = null;

        static {
            Type r100 = new Type("UNKNOWN", 0);
            UNKNOWN = r100;
            Type r101 = new Type("PERCENTAGE", 1);
            PERCENTAGE = r101;
            Type r102 = new Type("DEVICE_PX", 2);
            DEVICE_PX = r102;
            f384082a = new Type[]{r100, r101, r102};
        }

        public static Type[] values() {
            return (Type[]) f384082a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public SizeValue() {
        this.f384081b = Type.UNKNOWN;
        this.f384080a = 0.0f;
    }

    public static SizeValue b(String r100) {
        if (r100 != null) goto L4;
        int r101 = 0;
    L6:
        if (r101 <= 1) goto L12;
        if (r100.endsWith(GXTemplateKey.GAIAX_PE) == false) goto L12;
        float r102 = n.a(r100, 0.0f);
        return new SizeValue(Type.PERCENTAGE, r102);
    L12:
        if (r101 > 2) goto L14;
        return null;
    L14:
        if (r100.endsWith(GXTemplateKey.GAIAX_PX) == false) goto L19;
        float r103 = n.a(r100, 0.0f);
        return new SizeValue(Type.DEVICE_PX, r103);
    L19:
        return null;
    L4:
        r101 = r100.length();
        goto L6
    }

    public final float a(float r100) {
        Type r101 = this.f384081b;
        if (r101 != Type.PERCENTAGE) goto L7;
        return this.f384080a * r100;
    L7:
        if (r101 == Type.DEVICE_PX) goto L9;
        return 0.0f;
    L9:
        return this.f384080a;
    }

    public SizeValue(Type r100, float r101) {
        this.f384081b = r100;
        this.f384080a = r101;
    }
}
