package com.facebook.yoga;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class YogaNode implements YogaProps {

    public interface Inputs {
        void freeze(YogaNode r100, @Nullable YogaNode r101);
    }

    public YogaNode() {
    }

    public abstract void addChildAt(YogaNode r100, int r101);

    public abstract void calculateLayout(float r100, float r101);

    public abstract YogaNode cloneWithChildren();

    public abstract YogaNode cloneWithoutChildren();

    public abstract void copyStyle(YogaNode r100);

    public abstract void dirty();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaAlign getAlignContent();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaAlign getAlignItems();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaAlign getAlignSelf();

    @Override // com.facebook.yoga.YogaProps
    public abstract float getAspectRatio();

    @Override // com.facebook.yoga.YogaProps
    public abstract float getBorder(YogaEdge r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaBoxSizing getBoxSizing();

    public abstract YogaNode getChildAt(int r100);

    public abstract int getChildCount();

    @Nullable
    public abstract Object getData();

    public abstract YogaDisplay getDisplay();

    public abstract float getFlex();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getFlexBasis();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaFlexDirection getFlexDirection();

    @Override // com.facebook.yoga.YogaProps
    public abstract float getFlexGrow();

    @Override // com.facebook.yoga.YogaProps
    public abstract float getFlexShrink();

    public abstract float getGap(YogaGutter r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getHeight();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaJustify getJustifyContent();

    public abstract float getLayoutBorder(YogaEdge r100);

    public abstract YogaDirection getLayoutDirection();

    public abstract float getLayoutHeight();

    public abstract float getLayoutMargin(YogaEdge r100);

    public abstract float getLayoutPadding(YogaEdge r100);

    public abstract float getLayoutWidth();

    public abstract float getLayoutX();

    public abstract float getLayoutY();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getMargin(YogaEdge r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getMaxHeight();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getMaxWidth();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getMinHeight();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getMinWidth();

    public abstract YogaOverflow getOverflow();

    @Nullable
    public abstract YogaNode getOwner();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getPadding(YogaEdge r100);

    @Nullable
    public abstract YogaNode getParent();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getPosition(YogaEdge r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaPositionType getPositionType();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaDirection getStyleDirection();

    @Override // com.facebook.yoga.YogaProps
    public abstract YogaValue getWidth();

    public abstract YogaWrap getWrap();

    public abstract boolean hasNewLayout();

    public abstract int indexOf(YogaNode r100);

    public abstract boolean isBaselineDefined();

    public abstract boolean isDirty();

    public abstract boolean isMeasureDefined();

    public abstract boolean isReferenceBaseline();

    public abstract void markLayoutSeen();

    public abstract YogaNode removeChildAt(int r100);

    public abstract void reset();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setAlignContent(YogaAlign r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setAlignItems(YogaAlign r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setAlignSelf(YogaAlign r100);

    public abstract void setAlwaysFormsContainingBlock(boolean r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setAspectRatio(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setBaselineFunction(YogaBaselineFunction r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setBorder(YogaEdge r100, float r101);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setBoxSizing(YogaBoxSizing r100);

    public abstract void setData(Object r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setDirection(YogaDirection r100);

    public abstract void setDisplay(YogaDisplay r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlex(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexBasis(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexBasisAuto();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexBasisPercent(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexDirection(YogaFlexDirection r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexGrow(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setFlexShrink(float r100);

    public abstract void setGap(YogaGutter r100, float r101);

    public abstract void setGapPercent(YogaGutter r100, float r101);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setHeight(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setHeightAuto();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setHeightPercent(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setIsReferenceBaseline(boolean r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setJustifyContent(YogaJustify r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMargin(YogaEdge r100, float r101);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMarginAuto(YogaEdge r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMarginPercent(YogaEdge r100, float r101);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMaxHeight(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMaxHeightPercent(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMaxWidth(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMaxWidthPercent(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMeasureFunction(YogaMeasureFunction r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinHeight(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinHeightPercent(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinWidth(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setMinWidthPercent(float r100);

    public abstract void setOverflow(YogaOverflow r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setPadding(YogaEdge r100, float r101);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setPaddingPercent(YogaEdge r100, float r101);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setPosition(YogaEdge r100, float r101);

    public abstract void setPositionAuto(YogaEdge r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setPositionPercent(YogaEdge r100, float r101);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setPositionType(YogaPositionType r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setWidth(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setWidthAuto();

    @Override // com.facebook.yoga.YogaProps
    public abstract void setWidthPercent(float r100);

    @Override // com.facebook.yoga.YogaProps
    public abstract void setWrap(YogaWrap r100);
}
