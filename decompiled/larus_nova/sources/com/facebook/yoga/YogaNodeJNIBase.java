package com.facebook.yoga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class YogaNodeJNIBase extends YogaNode implements Cloneable {
    private static final byte BORDER = 4;
    private static final byte HAS_NEW_LAYOUT = 16;
    private static final byte LAYOUT_BORDER_START_INDEX = 14;
    private static final byte LAYOUT_DIRECTION_INDEX = 5;
    private static final byte LAYOUT_EDGE_SET_FLAG_INDEX = 0;
    private static final byte LAYOUT_HEIGHT_INDEX = 2;
    private static final byte LAYOUT_LEFT_INDEX = 3;
    private static final byte LAYOUT_MARGIN_START_INDEX = 6;
    private static final byte LAYOUT_PADDING_START_INDEX = 10;
    private static final byte LAYOUT_TOP_INDEX = 4;
    private static final byte LAYOUT_WIDTH_INDEX = 1;
    private static final byte MARGIN = 1;
    private static final byte PADDING = 2;

    @Nullable
    private float[] arr;

    @Nullable
    private YogaBaselineFunction mBaselineFunction;

    @Nullable
    private List<YogaNodeJNIBase> mChildren;

    @Nullable
    private YogaConfig mConfig;

    @Nullable
    private Object mData;
    private boolean mHasNewLayout;
    private int mLayoutDirection;

    @Nullable
    private YogaMeasureFunction mMeasureFunction;
    protected long mNativePointer;

    @Nullable
    private YogaNodeJNIBase mOwner;

    /* JADX INFO: renamed from: com.facebook.yoga.YogaNodeJNIBase$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$yoga$YogaEdge = null;

        static {
            int[] r100 = new int[YogaEdge.values().length];
            $SwitchMap$com$facebook$yoga$YogaEdge = r100;
            r100[YogaEdge.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$facebook$yoga$YogaEdge[YogaEdge.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$facebook$yoga$YogaEdge[YogaEdge.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$facebook$yoga$YogaEdge[YogaEdge.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$facebook$yoga$YogaEdge[YogaEdge.START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$facebook$yoga$YogaEdge[YogaEdge.END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    private void clearChildren() {
        this.mChildren = null;
        YogaNative.jni_YGNodeRemoveAllChildrenJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public void reset() {
        this.mMeasureFunction = null;
        this.mBaselineFunction = null;
        this.mData = null;
        this.arr = null;
        this.mHasNewLayout = true;
        this.mLayoutDirection = 0;
        YogaNative.jni_YGNodeResetJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public void dirty() {
        YogaNative.jni_YGNodeMarkDirtyJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaAlign getAlignContent() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignContentJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaAlign getAlignItems() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignItemsJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaAlign getAlignSelf() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignSelfJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getAspectRatio() {
        return YogaNative.jni_YGNodeStyleGetAspectRatioJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaBoxSizing getBoxSizing() {
        return YogaBoxSizing.fromInt(YogaNative.jni_YGNodeStyleGetBoxSizingJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public int getChildCount() {
        List<YogaNodeJNIBase> r100 = this.mChildren;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaDisplay getDisplay() {
        return YogaDisplay.fromInt(YogaNative.jni_YGNodeStyleGetDisplayJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public float getFlex() {
        return YogaNative.jni_YGNodeStyleGetFlexJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getFlexBasis() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetFlexBasisJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaFlexDirection getFlexDirection() {
        return YogaFlexDirection.fromInt(YogaNative.jni_YGNodeStyleGetFlexDirectionJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getFlexGrow() {
        return YogaNative.jni_YGNodeStyleGetFlexGrowJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getFlexShrink() {
        return YogaNative.jni_YGNodeStyleGetFlexShrinkJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetHeightJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaJustify getJustifyContent() {
        return YogaJustify.fromInt(YogaNative.jni_YGNodeStyleGetJustifyContentJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaDirection getLayoutDirection() {
        float[] r100 = this.arr;
        if (r100 == null) goto L5;
        int r101 = (int) r100[5];
    L7:
        return YogaDirection.fromInt(r101);
    L5:
        r101 = this.mLayoutDirection;
        goto L7
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutHeight() {
        float[] r100 = this.arr;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100[2];
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutWidth() {
        float[] r100 = this.arr;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100[1];
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutX() {
        float[] r100 = this.arr;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100[3];
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutY() {
        float[] r100 = this.arr;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100[4];
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMaxHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMaxHeightJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMaxWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMaxWidthJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMinHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMinHeightJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMinWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMinWidthJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaOverflow getOverflow() {
        return YogaOverflow.fromInt(YogaNative.jni_YGNodeStyleGetOverflowJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaPositionType getPositionType() {
        return YogaPositionType.fromInt(YogaNative.jni_YGNodeStyleGetPositionTypeJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaDirection getStyleDirection() {
        return YogaDirection.fromInt(YogaNative.jni_YGNodeStyleGetDirectionJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetWidthJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaWrap getWrap() {
        return YogaWrap.fromInt(YogaNative.jni_YGNodeStyleGetFlexWrapJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean hasNewLayout() {
        float[] r100 = this.arr;
        if (r100 == null) goto L9;
        if ((((int) r100[0]) & 16) != 16) goto L10;
        return true;
    L10:
        return false;
    L9:
        return this.mHasNewLayout;
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isBaselineDefined() {
        if (this.mBaselineFunction == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isDirty() {
        return YogaNative.jni_YGNodeIsDirtyJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isMeasureDefined() {
        if (this.mMeasureFunction == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isReferenceBaseline() {
        return YogaNative.jni_YGNodeIsReferenceBaselineJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public void markLayoutSeen() {
        float[] r100 = this.arr;
        if (r100 == null) goto L5;
        r100[0] = ((int) r100[0]) & (-17);
    L5:
        this.mHasNewLayout = false;
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexBasisAuto() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setHeightAuto() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWidthAuto() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.mNativePointer);
    }

    public YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase cloneWithChildren() {
        YogaNodeJNIBase r100 = (YogaNodeJNIBase) super.clone();     // Catch: CloneNotSupportedException -> L11
        if (r100.mChildren == null) goto L5;
        r100.mChildren = new ArrayList(r100.mChildren);     // Catch: CloneNotSupportedException -> L11
    L5:
        long r101 = YogaNative.jni_YGNodeCloneJNI(this.mNativePointer);     // Catch: CloneNotSupportedException -> L11
        r100.mOwner = null;     // Catch: CloneNotSupportedException -> L11
        r100.mNativePointer = r101;     // Catch: CloneNotSupportedException -> L11
        int r102 = 0;
    L6:
        if (r102 >= r100.getChildCount()) goto L10;
        r100.swapChildAt(r100.getChildAt(r102).cloneWithChildren(), r102);     // Catch: CloneNotSupportedException -> L11
        r102 = r102 + 1;
        goto L6
    L10:
        return r100;
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase cloneWithoutChildren() {
        YogaNodeJNIBase r100 = (YogaNodeJNIBase) super.clone();     // Catch: CloneNotSupportedException -> L4
        long r101 = YogaNative.jni_YGNodeCloneJNI(this.mNativePointer);     // Catch: CloneNotSupportedException -> L4
        r100.mOwner = null;     // Catch: CloneNotSupportedException -> L4
        r100.mNativePointer = r101;     // Catch: CloneNotSupportedException -> L4
        r100.clearChildren();     // Catch: CloneNotSupportedException -> L4
        return r100;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.facebook.yoga.YogaNode
    @Nullable
    public /* bridge */ /* synthetic */ YogaNode getOwner() {
        return getOwner();
    }

    @Override // com.facebook.yoga.YogaNode
    @Nullable
    public /* bridge */ /* synthetic */ YogaNode getParent() {
        return getParent();
    }

    @Override // com.facebook.yoga.YogaNode
    @Nullable
    public Object getData() {
        return this.mData;
    }

    @Override // com.facebook.yoga.YogaNode
    public /* bridge */ /* synthetic */ YogaNode cloneWithChildren() {
        return cloneWithChildren();
    }

    @Override // com.facebook.yoga.YogaNode
    public /* bridge */ /* synthetic */ YogaNode cloneWithoutChildren() {
        return cloneWithoutChildren();
    }

    @Override // com.facebook.yoga.YogaNode
    @Nullable
    public YogaNodeJNIBase getOwner() {
        return this.mOwner;
    }

    @Override // com.facebook.yoga.YogaNode
    @Nullable
    public YogaNodeJNIBase getParent() {
        return getOwner();
    }

    private YogaNodeJNIBase(long r100) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.mHasNewLayout = true;
        if (r100 == 0) goto L7;
        this.mNativePointer = r100;
        return;
    L7:
        throw new IllegalStateException("Failed to allocate native memory");
    }

    private void freeze(YogaNode r100) {
        Object r101 = getData();
        if ((r101 instanceof YogaNode.Inputs) == false) goto L6;
        ((YogaNode.Inputs) r101).freeze(this, r100);
        return;
    }

    private static YogaValue valueFromLong(long r100) {
        return new YogaValue(Float.intBitsToFloat((int) r100), (int) (r100 >> 32));
    }

    @Override // com.facebook.yoga.YogaNode
    public void copyStyle(YogaNode r100) {
        if ((r100 instanceof YogaNodeJNIBase) == true) goto L5;
        return;
    L5:
        YogaNative.jni_YGNodeCopyStyleJNI(this.mNativePointer, ((YogaNodeJNIBase) r100).mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getBorder(YogaEdge r100) {
        return YogaNative.jni_YGNodeStyleGetBorderJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase getChildAt(int r100) {
        List<YogaNodeJNIBase> r101 = this.mChildren;
        if (r101 == null) goto L7;
        return r101.get(r100);
    L7:
        throw new IllegalStateException("YogaNode does not have children");
    }

    @Override // com.facebook.yoga.YogaNode
    public float getGap(YogaGutter r100) {
        return YogaNative.jni_YGNodeStyleGetGapJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutBorder(YogaEdge r100) {
        float[] r101 = this.arr;
        if (r101 == null) goto L36;
        int r102 = 0;
        float r103 = r101[0];
        if ((((int) r103) & 4) == 4) goto L7;
        return 0.0f;
    L7:
        if ((((int) r103) & 1) != 1) goto L9;
        int r104 = 0;
    L10:
        int r105 = 14 - r104;
        if ((((int) r103) & 2) == 2) goto L14;
        r102 = 4;
    L14:
        int r106 = r105 - r102;
        switch(AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaEdge[r100.ordinal()]) {
            case 1: goto L35;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L29;
            case 5: goto L24;
            case 6: goto L19;
            default: goto L17;
        };
    L17:
        throw new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
    L19:
        if (getLayoutDirection() != YogaDirection.RTL) goto L22;
        return this.arr[r106];
    L22:
        return this.arr[r106 + 2];
    L24:
        if (getLayoutDirection() != YogaDirection.RTL) goto L27;
        return this.arr[r106 + 2];
    L27:
        return this.arr[r106];
    L29:
        return this.arr[r106 + 3];
    L31:
        return this.arr[r106 + 2];
    L33:
        return this.arr[r106 + 1];
    L35:
        return this.arr[r106];
    L9:
        r104 = 4;
        goto L10
    L36:
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutMargin(YogaEdge r100) {
        float[] r101 = this.arr;
        if (r101 != null) goto L5;
        return 0.0f;
    L5:
        if ((((int) r101[0]) & 1) == 1) goto L7;
        return 0.0f;
    L7:
        switch(AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaEdge[r100.ordinal()]) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L16;
            case 6: goto L11;
            default: goto L9;
        };
    L9:
        throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
    L11:
        if (getLayoutDirection() != YogaDirection.RTL) goto L14;
        return this.arr[6];
    L14:
        return this.arr[8];
    L16:
        if (getLayoutDirection() != YogaDirection.RTL) goto L19;
        return this.arr[8];
    L19:
        return this.arr[6];
    L21:
        return this.arr[9];
    L23:
        return this.arr[8];
    L25:
        return this.arr[7];
    L27:
        return this.arr[6];
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutPadding(YogaEdge r100) {
        float[] r101 = this.arr;
        if (r101 == null) goto L32;
        int r102 = 0;
        float r103 = r101[0];
        if ((((int) r103) & 2) == 2) goto L7;
        return 0.0f;
    L7:
        if ((((int) r103) & 1) == 1) goto L10;
        r102 = 4;
    L10:
        int r104 = 10 - r102;
        switch(AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaEdge[r100.ordinal()]) {
            case 1: goto L31;
            case 2: goto L29;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L20;
            case 6: goto L15;
            default: goto L13;
        };
    L13:
        throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
    L15:
        if (getLayoutDirection() != YogaDirection.RTL) goto L18;
        return this.arr[r104];
    L18:
        return this.arr[r104 + 2];
    L20:
        if (getLayoutDirection() != YogaDirection.RTL) goto L23;
        return this.arr[r104 + 2];
    L23:
        return this.arr[r104];
    L25:
        return this.arr[r104 + 3];
    L27:
        return this.arr[r104 + 2];
    L29:
        return this.arr[r104 + 1];
    L31:
        return this.arr[r104];
    L32:
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMargin(YogaEdge r100) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMarginJNI(this.mNativePointer, r100.intValue()));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getPadding(YogaEdge r100) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetPaddingJNI(this.mNativePointer, r100.intValue()));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getPosition(YogaEdge r100) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetPositionJNI(this.mNativePointer, r100.intValue()));
    }

    @Override // com.facebook.yoga.YogaNode
    public int indexOf(YogaNode r100) {
        List<YogaNodeJNIBase> r101 = this.mChildren;
        if (r101 != null) goto L6;
        return -1;
    L6:
        return r101.indexOf(r100);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase removeChildAt(int r100) {
        List<YogaNodeJNIBase> r101 = this.mChildren;
        if (r101 == null) goto L7;
        YogaNodeJNIBase r102 = r101.remove(r100);
        r102.mOwner = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.mNativePointer, r102.mNativePointer);
        return r102;
    L7:
        throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setAlignContent(YogaAlign r100) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setAlignItems(YogaAlign r100) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setAlignSelf(YogaAlign r100) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public void setAlwaysFormsContainingBlock(boolean r100) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setAspectRatio(float r100) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setBaselineFunction(YogaBaselineFunction r100) {
        this.mBaselineFunction = r100;
        long r101 = this.mNativePointer;
        if (r100 == null) goto L5;
        boolean r102 = true;
    L6:
        YogaNative.jni_YGNodeSetHasBaselineFuncJNI(r101, r102);
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setBoxSizing(YogaBoxSizing r100) {
        YogaNative.jni_YGNodeStyleSetBoxSizingJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public void setData(Object r100) {
        this.mData = r100;
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setDirection(YogaDirection r100) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public void setDisplay(YogaDisplay r100) {
        YogaNative.jni_YGNodeStyleSetDisplayJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlex(float r100) {
        YogaNative.jni_YGNodeStyleSetFlexJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexBasis(float r100) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexBasisPercent(float r100) {
        YogaNative.jni_YGNodeStyleSetFlexBasisPercentJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexDirection(YogaFlexDirection r100) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexGrow(float r100) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexShrink(float r100) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setHeight(float r100) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setHeightPercent(float r100) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setIsReferenceBaseline(boolean r100) {
        YogaNative.jni_YGNodeSetIsReferenceBaselineJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setJustifyContent(YogaJustify r100) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMarginAuto(YogaEdge r100) {
        YogaNative.jni_YGNodeStyleSetMarginAutoJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxHeight(float r100) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxHeightPercent(float r100) {
        YogaNative.jni_YGNodeStyleSetMaxHeightPercentJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxWidth(float r100) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxWidthPercent(float r100) {
        YogaNative.jni_YGNodeStyleSetMaxWidthPercentJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMeasureFunction(YogaMeasureFunction r100) {
        this.mMeasureFunction = r100;
        long r101 = this.mNativePointer;
        if (r100 == null) goto L5;
        boolean r102 = true;
    L6:
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(r101, r102);
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinHeight(float r100) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinHeightPercent(float r100) {
        YogaNative.jni_YGNodeStyleSetMinHeightPercentJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinWidth(float r100) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinWidthPercent(float r100) {
        YogaNative.jni_YGNodeStyleSetMinWidthPercentJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setOverflow(YogaOverflow r100) {
        YogaNative.jni_YGNodeStyleSetOverflowJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public void setPositionAuto(YogaEdge r100) {
        YogaNative.jni_YGNodeStyleSetPositionAutoJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPositionType(YogaPositionType r100) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWidth(float r100) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWidthPercent(float r100) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWrap(YogaWrap r100) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.mNativePointer, r100.intValue());
    }

    public YogaNodeJNIBase(YogaConfig r100) {
        this(YogaNative.jni_YGNodeNewWithConfigJNI(((YogaConfigJNIBase) r100).mNativePointer));
        this.mConfig = r100;
    }

    @Override // com.facebook.yoga.YogaNode
    public /* bridge */ /* synthetic */ YogaNode getChildAt(int r100) {
        return getChildAt(r100);
    }

    @Override // com.facebook.yoga.YogaNode
    public /* bridge */ /* synthetic */ YogaNode removeChildAt(int r100) {
        return removeChildAt(r100);
    }

    private final long replaceChild(YogaNodeJNIBase r100, int r101) {
        List<YogaNodeJNIBase> r102 = this.mChildren;
        if (r102 == null) goto L7;
        r102.remove(r101);
        this.mChildren.add(r101, r100);
        r100.mOwner = this;
        return r100.mNativePointer;
    L7:
        throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
    }

    @Override // com.facebook.yoga.YogaNode
    public void addChildAt(YogaNode r100, int r101) {
        if ((r100 instanceof YogaNodeJNIBase) == true) goto L5;
        return;
    L5:
        YogaNodeJNIBase r102 = (YogaNodeJNIBase) r100;
        if (r102.mOwner != null) goto L13;
        if (this.mChildren != null) goto L10;
        this.mChildren = new ArrayList(4);
    L10:
        this.mChildren.add(r101, r102);
        r102.mOwner = this;
        YogaNative.jni_YGNodeInsertChildJNI(this.mNativePointer, r102.mNativePointer, r101);
        return;
    L13:
        throw new IllegalStateException("Child already has a parent, it must be removed first.");
    }

    public final float baseline(float r100, float r101) {
        return this.mBaselineFunction.baseline(this, r100, r101);
    }

    @Override // com.facebook.yoga.YogaNode
    public void calculateLayout(float r100, float r110) {
        freeze(null);
        ArrayList r101 = new ArrayList();
        r101.add(this);
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= r101.size()) goto L12;
        YogaNodeJNIBase r104 = (YogaNodeJNIBase) r101.get(r103);
        List<YogaNodeJNIBase> r105 = r104.mChildren;
        if (r105 == null) goto L11;
        Iterator<YogaNodeJNIBase> r106 = r105.iterator();
    L9:
        if (r106.hasNext() == false) goto L11;
        YogaNodeJNIBase r107 = r106.next();
        r107.freeze(r104);
        r101.add(r107);
    L11:
        r103 = r103 + 1;
        goto L4
    L12:
        YogaNodeJNIBase[] r108 = (YogaNodeJNIBase[]) r101.toArray(new YogaNodeJNIBase[r101.size()]);
        long[] r109 = new long[r108.length];
    L14:
        if (r102 >= r108.length) goto L16;
        r109[r102] = r108[r102].mNativePointer;
        r102 = r102 + 1;
        goto L14
    L16:
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.mNativePointer, r100, r110, r109, r108);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setBorder(YogaEdge r100, float r101) {
        YogaNative.jni_YGNodeStyleSetBorderJNI(this.mNativePointer, r100.intValue(), r101);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setGap(YogaGutter r100, float r101) {
        YogaNative.jni_YGNodeStyleSetGapJNI(this.mNativePointer, r100.intValue(), r101);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setGapPercent(YogaGutter r100, float r101) {
        YogaNative.jni_YGNodeStyleSetGapPercentJNI(this.mNativePointer, r100.intValue(), r101);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMargin(YogaEdge r100, float r101) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.mNativePointer, r100.intValue(), r101);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMarginPercent(YogaEdge r100, float r101) {
        YogaNative.jni_YGNodeStyleSetMarginPercentJNI(this.mNativePointer, r100.intValue(), r101);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPadding(YogaEdge r100, float r101) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.mNativePointer, r100.intValue(), r101);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPaddingPercent(YogaEdge r100, float r101) {
        YogaNative.jni_YGNodeStyleSetPaddingPercentJNI(this.mNativePointer, r100.intValue(), r101);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPosition(YogaEdge r100, float r101) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.mNativePointer, r100.intValue(), r101);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPositionPercent(YogaEdge r100, float r101) {
        YogaNative.jni_YGNodeStyleSetPositionPercentJNI(this.mNativePointer, r100.intValue(), r101);
    }

    public void swapChildAt(YogaNode r100, int r101) {
        if ((r100 instanceof YogaNodeJNIBase) == true) goto L5;
        return;
    L5:
        YogaNodeJNIBase r102 = (YogaNodeJNIBase) r100;
        this.mChildren.remove(r101);
        this.mChildren.add(r101, r102);
        r102.mOwner = this;
        YogaNative.jni_YGNodeSwapChildJNI(this.mNativePointer, r102.mNativePointer, r101);
    }

    public final long measure(float r100, int r101, float r110, int r111) {
        if (isMeasureDefined() == false) goto L7;
        return this.mMeasureFunction.measure(this, r100, YogaMeasureMode.fromInt(r101), r110, YogaMeasureMode.fromInt(r111));
    L7:
        throw new RuntimeException("Measure function isn't defined!");
    }
}
