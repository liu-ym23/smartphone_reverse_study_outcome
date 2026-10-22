package ru1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.parse.ExpressNodeType;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f539248a = null;

    static {
        int[] r100 = new int[ExpressNodeType.values().length];
        f539248a = r100;
        r100[ExpressNodeType.PARAM.ordinal()] = 1;
        r100[ExpressNodeType.CONST_FLOAT.ordinal()] = 2;
        r100[ExpressNodeType.CONST_INT.ordinal()] = 3;
        r100[ExpressNodeType.CONST_DOUBLE.ordinal()] = 4;
        r100[ExpressNodeType.CONST_LONG.ordinal()] = 5;
        r100[ExpressNodeType.CONST_BOOLEAN.ordinal()] = 6;
        r100[ExpressNodeType.OPERATOR_AND.ordinal()] = 7;
        r100[ExpressNodeType.OPERATOR_OR.ordinal()] = 8;
        r100[ExpressNodeType.OPERATOR_COMPARE.ordinal()] = 9;
    }
}
