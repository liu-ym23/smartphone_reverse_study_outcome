package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class FrameSpec extends Identifier {
    private static native void configAndCurrentRow(long r100);

    private static native void configAndFollowing(long r100, int r101, long r102);

    private static native void configAndPreceding(long r100, int r101, long r102);

    private static native void configAndUnboundedFollowing(long r100);

    private static native void configBetweenCurrentRow(long r100);

    private static native void configBetweenFollowing(long r100, int r101, long r102);

    private static native void configBetweenPreceding(long r100, int r101, long r102);

    private static native void configBetweenUnboundedPreceding(long r100);

    private static native void configCurrentRow(long r100);

    private static native void configPreceding(long r100, int r101, long r102);

    private static native void configRange(long r100);

    private static native void configRows(long r100);

    private static native void configUnboundedPreceding(long r100);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 30;
    }

    public FrameSpec andCurrentRow() {
        configAndCurrentRow(this.cppObj);
        return this;
    }

    public FrameSpec andUnboundedFollowing() {
        configAndUnboundedFollowing(this.cppObj);
        return this;
    }

    public FrameSpec betweenCurrentRow() {
        configBetweenCurrentRow(this.cppObj);
        return this;
    }

    public FrameSpec betweenUnboundedPreceding() {
        configBetweenUnboundedPreceding(this.cppObj);
        return this;
    }

    public FrameSpec currentRow() {
        configCurrentRow(this.cppObj);
        return this;
    }

    public FrameSpec range() {
        configRange(this.cppObj);
        return this;
    }

    public FrameSpec rows() {
        configRows(this.cppObj);
        return this;
    }

    public FrameSpec unboundedPreceding() {
        configUnboundedPreceding(this.cppObj);
        return this;
    }

    public FrameSpec() {
        this.cppObj = createCppObj();
    }

    public FrameSpec andFollowing(ExpressionConvertible r100) {
        configAndFollowing(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100));
        return this;
    }

    public FrameSpec andPreceding(ExpressionConvertible r100) {
        configAndPreceding(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100));
        return this;
    }

    public FrameSpec betweenFollowing(ExpressionConvertible r100) {
        configBetweenFollowing(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100));
        return this;
    }

    public FrameSpec betweenPreceding(ExpressionConvertible r100) {
        configBetweenPreceding(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100));
        return this;
    }

    public FrameSpec preceding(ExpressionConvertible r100) {
        configPreceding(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100));
        return this;
    }

    public FrameSpec andFollowing(long r100) {
        configAndFollowing(this.cppObj, 3, r100);
        return this;
    }

    public FrameSpec andPreceding(long r100) {
        configAndPreceding(this.cppObj, 3, r100);
        return this;
    }

    public FrameSpec betweenFollowing(long r100) {
        configBetweenFollowing(this.cppObj, 3, r100);
        return this;
    }

    public FrameSpec betweenPreceding(long r100) {
        configBetweenPreceding(this.cppObj, 3, r100);
        return this;
    }

    public FrameSpec preceding(long r100) {
        configPreceding(this.cppObj, 3, r100);
        return this;
    }
}
