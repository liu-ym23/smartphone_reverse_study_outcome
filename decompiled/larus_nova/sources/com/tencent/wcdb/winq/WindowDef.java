package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;
import java.util.Arrays;

/* JADX INFO: loaded from: classes41.dex */
public class WindowDef extends Identifier {
    private static native void configFrameSpec(long r100, long r101);

    private static native void configOrders(long r100, long[] r101);

    private static native void configPartitions(long r100, int[] r101, long[] r102, double[] r103, String[] r104);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 16;
    }

    public WindowDef() {
        this.cppObj = createCppObj();
    }

    public WindowDef frameSpec(FrameSpec r100) {
        configFrameSpec(this.cppObj, CppObject.get(r100));
        return this;
    }

    public WindowDef orderBy(OrderingTerm... r100) {
        if (r100 != null) goto L4;
    L11:
        return this;
    L4:
        if (r100.length == 0) goto L11;
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L10;
        r101[r102] = CppObject.get(r100[r102]);
        r102 = r102 + 1;
        goto L8
    L10:
        configOrders(this.cppObj, r101);
        goto L11
    }

    public WindowDef partitionBy(ExpressionConvertible... r100) {
        if (r100 != null) goto L4;
    L11:
        return this;
    L4:
        if (r100.length == 0) goto L11;
        int[] r101 = new int[r100.length];
        long[] r102 = new long[r100.length];
        int r103 = 0;
    L8:
        if (r103 >= r100.length) goto L10;
        r101[r103] = Identifier.getCppType(r100[r103]);
        r102[r103] = CppObject.get(r100[r103]);
        r103 = r103 + 1;
        goto L8
    L10:
        configPartitions(this.cppObj, r101, r102, null, null);
        goto L11
    }

    public WindowDef partitionBy(String... r100) {
        if (r100 != null) goto L4;
    L7:
        return this;
    L4:
        if (r100.length == 0) goto L7;
        int[] r101 = new int[r100.length];
        Arrays.fill(r101, 6);
        configPartitions(this.cppObj, r101, null, null, r100);
        goto L7
    }
}
