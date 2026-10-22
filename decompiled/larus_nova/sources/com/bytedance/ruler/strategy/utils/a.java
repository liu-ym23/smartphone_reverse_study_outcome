package com.bytedance.ruler.strategy.utils;

import com.bytedance.express.command.Primitive;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f267748a = null;

    static {
        int[] r100 = new int[Primitive.values().length];
        f267748a = r100;
        r100[Primitive.LONG.ordinal()] = 1;
        r100[Primitive.INT.ordinal()] = 2;
        r100[Primitive.FLOAT.ordinal()] = 3;
        r100[Primitive.DOUBLE.ordinal()] = 4;
        r100[Primitive.CHAR.ordinal()] = 5;
        r100[Primitive.STRING.ordinal()] = 6;
        r100[Primitive.BOOL.ordinal()] = 7;
        r100[Primitive.NULL.ordinal()] = 8;
    }
}
