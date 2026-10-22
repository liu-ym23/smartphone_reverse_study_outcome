package com.bytedance.express.command;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final Primitive a(int r100) {
        if (r100 == Integer.MAX_VALUE) goto L16;
        switch(r100) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            default: goto L17;
        };
    L17:
        return Primitive.UNSUPPORTED;
    L18:
        return Primitive.COLLECTION;
    L19:
        return Primitive.STRING;
    L20:
        return Primitive.CHAR;
    L21:
        return Primitive.DOUBLE;
    L22:
        return Primitive.FLOAT;
    L23:
        return Primitive.LONG;
    L24:
        return Primitive.INT;
    L25:
        return Primitive.BOOL;
    L26:
        return Primitive.NULL;
    L16:
        return Primitive.UNSUPPORTED;
    }
}
