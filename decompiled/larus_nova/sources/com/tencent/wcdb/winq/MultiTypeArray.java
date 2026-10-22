package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;
import com.tencent.wcdb.base.Value;
import java.util.Arrays;

/* JADX INFO: loaded from: classes41.dex */
class MultiTypeArray {
    double[] doubleValues;
    long[] longValues;
    String[] stringValues;
    int[] types;

    /* JADX INFO: renamed from: com.tencent.wcdb.winq.MultiTypeArray$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$wcdb$winq$ColumnType = null;

        static {
            int[] r100 = new int[ColumnType.values().length];
            $SwitchMap$com$tencent$wcdb$winq$ColumnType = r100;
            r100[ColumnType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.Integer.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.Float.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.Text.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public MultiTypeArray(Object[] r110) {
        int r100 = r110.length;
        this.types = new int[r100];
        this.longValues = new long[r100];
        this.doubleValues = new double[r100];
        this.stringValues = new String[r100];
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r101 >= r100) goto L37;
        Object r105 = r110[r101];
        switch(getObjectType(r105)) {
            case 0: goto L34;
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L7;
            default: goto L36;
        };
    L7:
        Value r106 = (Value) r105;
        int r107 = AnonymousClass1.$SwitchMap$com$tencent$wcdb$winq$ColumnType[r106.getType().ordinal()];
        if (r107 == 1) goto L17;
        if (r107 == 2) goto L16;
        if (r107 != 3) goto L12;
        this.types[r101] = 5;
        this.doubleValues[r104] = r106.getDouble();
    L23:
        r104 = r104 + 1;
        goto L36
    L12:
        if (r107 != 4) goto L36;
        this.types[r101] = 6;
        this.stringValues[r102] = r106.getText();
    L20:
        r102 = r102 + 1;
        goto L36
    L16:
        this.types[r101] = 3;
        this.longValues[r103] = r106.getLong();
    L35:
        r103 = r103 + 1;
        goto L36
    L17:
        this.types[r101] = 1;
        goto L35
    L18:
        Identifier r108 = (Identifier) r105;
        this.types[r101] = Identifier.getCppType(r108);
        this.longValues[r103] = CppObject.get(r108);
        goto L35
    L19:
        this.types[r101] = 6;
        this.stringValues[r102] = (String) r105;
        goto L20
    L21:
        this.types[r101] = 5;
        this.doubleValues[r104] = ((Double) r105).doubleValue();
        goto L23
    L22:
        this.types[r101] = 5;
        this.doubleValues[r104] = ((Float) r105).floatValue();
        goto L23
    L24:
        this.types[r101] = 3;
        this.longValues[r103] = ((Long) r105).longValue();
        goto L35
    L25:
        this.types[r101] = 3;
        this.longValues[r103] = ((Integer) r105).intValue();
        goto L35
    L26:
        this.types[r101] = 3;
        this.longValues[r103] = ((Short) r105).shortValue();
        goto L35
    L27:
        this.types[r101] = 3;
        this.longValues[r103] = ((Byte) r105).byteValue();
        goto L35
    L28:
        this.types[r101] = 3;
        this.longValues[r103] = ((Character) r105).charValue();
        goto L35
    L29:
        this.types[r101] = 2;
        long[] r109 = this.longValues;
        if (((Boolean) r105).booleanValue() == false) goto L32;
        long r111 = 1;
    L33:
        r109[r103] = r111;
        goto L35
    L32:
        r111 = 0;
        goto L33
    L34:
        this.types[r101] = 1;
    L36:
        r101 = r101 + 1;
        goto L3
    L37:
        String[] r112 = this.stringValues;
        if ((((double) r112.length) * 0.75d) <= r102) goto L49;
        if (r102 != 0) goto L41;
        this.stringValues = null;
        return;
    L41:
        this.stringValues = (String[]) Arrays.copyOf(r112, r102);
        return;
    }

    public static int getObjectType(Object r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if ((r100 instanceof Identifier) == false) goto L9;
        return 10;
    L9:
        Class<?> r101 = r100.getClass();
        if (r101 != String.class) goto L14;
        return 9;
    L14:
        if (r101 != Integer.class) goto L18;
        return 5;
    L18:
        if (r101 != Float.class) goto L22;
        return 7;
    L22:
        if (r101 != Double.class) goto L26;
        return 8;
    L26:
        if (r101 != Boolean.class) goto L30;
        return 1;
    L30:
        if (r101 != Short.class) goto L34;
        return 4;
    L34:
        if (r101 != Long.class) goto L38;
        return 6;
    L38:
        if (r101 != Character.class) goto L42;
        return 2;
    L42:
        if (r101 != Byte.class) goto L46;
        return 3;
    L46:
        if (r101 != Value.class) goto L49;
        return 11;
    L49:
        return 12;
    }
}
