package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public interface YogaProps {
    YogaAlign getAlignContent();

    YogaAlign getAlignItems();

    YogaAlign getAlignSelf();

    float getAspectRatio();

    float getBorder(YogaEdge r100);

    YogaBoxSizing getBoxSizing();

    YogaValue getFlexBasis();

    YogaFlexDirection getFlexDirection();

    float getFlexGrow();

    float getFlexShrink();

    YogaValue getHeight();

    YogaJustify getJustifyContent();

    YogaValue getMargin(YogaEdge r100);

    YogaValue getMaxHeight();

    YogaValue getMaxWidth();

    YogaValue getMinHeight();

    YogaValue getMinWidth();

    YogaValue getPadding(YogaEdge r100);

    YogaValue getPosition(YogaEdge r100);

    YogaPositionType getPositionType();

    YogaDirection getStyleDirection();

    YogaValue getWidth();

    void setAlignContent(YogaAlign r100);

    void setAlignItems(YogaAlign r100);

    void setAlignSelf(YogaAlign r100);

    void setAspectRatio(float r100);

    void setBaselineFunction(YogaBaselineFunction r100);

    void setBorder(YogaEdge r100, float r101);

    void setBoxSizing(YogaBoxSizing r100);

    void setDirection(YogaDirection r100);

    void setFlex(float r100);

    void setFlexBasis(float r100);

    void setFlexBasisAuto();

    void setFlexBasisPercent(float r100);

    void setFlexDirection(YogaFlexDirection r100);

    void setFlexGrow(float r100);

    void setFlexShrink(float r100);

    void setHeight(float r100);

    void setHeightAuto();

    void setHeightPercent(float r100);

    void setIsReferenceBaseline(boolean r100);

    void setJustifyContent(YogaJustify r100);

    void setMargin(YogaEdge r100, float r101);

    void setMarginAuto(YogaEdge r100);

    void setMarginPercent(YogaEdge r100, float r101);

    void setMaxHeight(float r100);

    void setMaxHeightPercent(float r100);

    void setMaxWidth(float r100);

    void setMaxWidthPercent(float r100);

    void setMeasureFunction(YogaMeasureFunction r100);

    void setMinHeight(float r100);

    void setMinHeightPercent(float r100);

    void setMinWidth(float r100);

    void setMinWidthPercent(float r100);

    void setPadding(YogaEdge r100, float r101);

    void setPaddingPercent(YogaEdge r100, float r101);

    void setPosition(YogaEdge r100, float r101);

    void setPositionPercent(YogaEdge r100, float r101);

    void setPositionType(YogaPositionType r100);

    void setWidth(float r100);

    void setWidthAuto();

    void setWidthPercent(float r100);

    void setWrap(YogaWrap r100);
}
