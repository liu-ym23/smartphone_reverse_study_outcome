package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class y3 extends v1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f405359e = 0;

    public static final class a {
        public static y3 a(int r100) {
            y3 r101 = new y3(PropertyValueType.INT32);
            int r102 = com.bytedance.rts.foundation.d.f267577a;
            r101.f405318c = r100;
            return r101;
        }

        public static y3 b(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            y3 r101 = new y3(PropertyValueType.OBJECT);
            r101.f405319d = r100;
            return r101;
        }

        public static y3 c(double r100, ModifierValuePattern r101) {
            Intrinsics.checkNotNullParameter(r101, "pattern");
            y3 r102 = new y3(PropertyValueType.PATTERN);
            r102.f405318c = r100;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r102.f405317b = r101;
            return r102;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f405360a = null;

        static {
            int[] r100 = new int[PropertyValueType.values().length];
            r100[PropertyValueType.INT32.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[PropertyValueType.DOUBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[PropertyValueType.PATTERN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[PropertyValueType.OBJECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[PropertyValueType.EMPTY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f405360a = r100;
        }
    }

    static {
    }

    @Override // com.relax.relaxframework.v1
    public final Object b() {
        PropertyValueType r100 = getType();
        int r101 = b.f405360a[r100.ordinal()];
        if (r101 != 1) goto L5;
        int r102 = com.bytedance.rts.foundation.c.f267576a;
        return Integer.valueOf((int) this.f405318c);
    L5:
        if (r101 == 2) goto L21;
        if (r101 != 3) goto L9;
        ModifierValuePattern r103 = this.f405317b;
        if (r103 == ModifierValuePattern.ENUM) goto L17;
        double r104 = this.f405318c;
        RelaxInstance.Companion.getClass();
        RelaxInstance r105 = RelaxInstance.access$getCurrentInstance$cp();
        Intrinsics.checkNotNull(r105);
        return Double.valueOf(RelaxFrameworkKt.T(r104, r103, r105.getViewportMetrics()).f405177a);
    L17:
        return Double.valueOf(this.f405318c);
    L9:
        if (r101 == 4) goto L13;
        return null;
    L13:
        return this.f405319d;
    L21:
        return Double.valueOf(this.f405318c);
    }

    public y3(PropertyValueType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        super(r100);
    }

    @Override // com.relax.relaxframework.v1
    public final boolean a(v1 r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if (getType() == r100.getType()) goto L5;
        return false;
    L5:
        PropertyValueType r101 = getType();
        int r102 = b.f405360a[r101.ordinal()];
        if (r102 == 1) goto L29;
        if (r102 == 2) goto L25;
        if (r102 == 3) goto L16;
        if (r102 == 5) goto L14;
        return false;
    L14:
        return true;
    L16:
        if (this.f405317b == r100.f405317b) goto L18;
        return false;
    L18:
        if (this.f405318c != r100.f405318c) goto L20;
        boolean r103 = true;
    L21:
        if (r103 == false) goto L33;
        return true;
    L33:
        return false;
    L20:
        r103 = false;
        goto L21
    L25:
        if (this.f405318c != r100.f405318c) goto L34;
        return true;
    L34:
        return false;
    L29:
        if (this.f405318c != r100.f405318c) goto L35;
        return true;
    L35:
        return false;
    }
}
