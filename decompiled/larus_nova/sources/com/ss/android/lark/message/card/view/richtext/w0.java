package com.ss.android.lark.message.card.view.richtext;

import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;

/* JADX INFO: loaded from: classes36.dex */
public final class w0 {
    public static YogaNode a(YogaProperty r100) {
        YogaNode r101 = new YogaNode();
        if (r100 != null) goto L5;
        return r101;
    L5:
        int r102 = r100.position;
        if (r102 == (-1)) goto L8;
        r101.setPositionType(YogaPositionType.fromInt(r102));
    L10:
        if (YogaConstants.isUndefined(r100.aspectRatio) == true) goto L12;
        r101.setAspectRatio(r100.aspectRatio);
    L12:
        int r103 = r100.flexDirection;
        if (r103 == (-1)) goto L15;
        r101.setFlexDirection(YogaFlexDirection.fromInt(r103));
    L16:
        int r104 = r100.flexWrap;
        if (r104 == (-1)) goto L19;
        r101.setWrap(YogaWrap.fromInt(r104));
    L21:
        if (YogaConstants.isUndefined(r100.flexBasis) == true) goto L23;
        r101.setFlexBasis(r100.flexBasis);
    L25:
        if (Float.compare(r100.flexGrow, -1.0f) == 0) goto L27;
        r101.setFlexGrow(r100.flexGrow);
    L29:
        if (Float.compare(r100.flexShrink, -1.0f) == 0) goto L31;
        r101.setFlexShrink(r100.flexShrink);
    L32:
        int r105 = r100.justifyContent;
        if (r105 == (-1)) goto L35;
        r101.setJustifyContent(YogaJustify.fromInt(r105));
    L36:
        int r106 = r100.alignContent;
        if (r106 == (-1)) goto L39;
        r101.setAlignContent(YogaAlign.fromInt(r106));
    L40:
        int r107 = r100.alignItems;
        if (r107 == (-1)) goto L43;
        r101.setAlignItems(YogaAlign.fromInt(r107));
    L44:
        int r108 = r100.alignSelf;
        if (r108 == (-1)) goto L47;
        r101.setAlignSelf(YogaAlign.fromInt(r108));
    L48:
        int r109 = r100.display;
        if (r109 == (-1)) goto L51;
        r101.setDisplay(YogaDisplay.fromInt(r109));
    L53:
        if (YogaConstants.isUndefined(r100.maxWidth) == true) goto L56;
        r101.setMaxWidth(r100.maxWidth);
    L59:
        if (YogaConstants.isUndefined(r100.minWidth) == true) goto L62;
        r101.setMinWidth(r100.minWidth);
    L65:
        if (YogaConstants.isUndefined(r100.width) == true) goto L68;
        r101.setWidth(r100.width);
    L72:
        if (YogaConstants.isUndefined(r100.maxHeight) == true) goto L75;
        r101.setMaxHeight(r100.maxHeight);
    L78:
        if (YogaConstants.isUndefined(r100.minHeight) == true) goto L81;
        r101.setMinHeight(r100.minHeight);
    L84:
        if (YogaConstants.isUndefined(r100.height) == true) goto L87;
        r101.setHeight(r100.height);
    L91:
        if (YogaConstants.isUndefined(r100.marginTop) == true) goto L94;
        r101.setMargin(YogaEdge.TOP, r100.marginTop);
    L97:
        if (YogaConstants.isUndefined(r100.marginRight) == true) goto L100;
        r101.setMargin(YogaEdge.RIGHT, r100.marginRight);
    L103:
        if (YogaConstants.isUndefined(r100.marginBottom) == true) goto L106;
        r101.setMargin(YogaEdge.BOTTOM, r100.marginBottom);
    L109:
        if (YogaConstants.isUndefined(r100.marginLeft) == true) goto L112;
        r101.setMargin(YogaEdge.LEFT, r100.marginLeft);
    L114:
        YogaEdge r110 = YogaEdge.TOP;
        r101.setPadding(r110, r100.paddingTop);
        YogaEdge r111 = YogaEdge.RIGHT;
        r101.setPadding(r111, r100.paddingRight);
        YogaEdge r112 = YogaEdge.BOTTOM;
        r101.setPadding(r112, r100.paddingBottom);
        YogaEdge r113 = YogaEdge.LEFT;
        r101.setPadding(r113, r100.paddingLeft);
        if (YogaConstants.isUndefined(r100.left) == true) goto L118;
        r101.setPosition(r113, r100.left);
    L118:
        if (YogaConstants.isUndefined(r100.right) == true) goto L121;
        r101.setPosition(r111, r100.right);
    L121:
        if (YogaConstants.isUndefined(r100.top) == true) goto L124;
        r101.setPosition(r110, r100.top);
    L124:
        if (YogaConstants.isUndefined(r100.bottom) == true) goto L126;
        r101.setPosition(r112, r100.bottom);
    L126:
        return r101;
    L112:
        if (YogaConstants.isUndefined(r100.marginLeftPercent) == true) goto L114;
        r101.setMarginPercent(YogaEdge.LEFT, r100.marginLeftPercent);
        goto L114
    L106:
        if (YogaConstants.isUndefined(r100.marginBottomPercent) == true) goto L109;
        r101.setMarginPercent(YogaEdge.BOTTOM, r100.marginBottomPercent);
        goto L109
    L100:
        if (YogaConstants.isUndefined(r100.marginRightPercent) == true) goto L103;
        r101.setMarginPercent(YogaEdge.RIGHT, r100.marginRightPercent);
        goto L103
    L94:
        if (YogaConstants.isUndefined(r100.marginTopPercent) == true) goto L97;
        r101.setMarginPercent(YogaEdge.TOP, r100.marginTopPercent);
        goto L97
    L87:
        if (YogaConstants.isUndefined(r100.heightPercent) == true) goto L89;
        r101.setHeightPercent(r100.heightPercent);
        goto L91
    L89:
        r101.setHeightAuto();
        goto L91
    L81:
        if (YogaConstants.isUndefined(r100.minHeightPercent) == true) goto L84;
        r101.setMinHeightPercent(r100.minHeightPercent);
        goto L84
    L75:
        if (YogaConstants.isUndefined(r100.maxHeightPercent) == true) goto L78;
        r101.setMaxHeightPercent(r100.maxHeightPercent);
        goto L78
    L68:
        if (YogaConstants.isUndefined(r100.widthPercent) == true) goto L70;
        r101.setWidthPercent(r100.widthPercent);
        goto L72
    L70:
        r101.setWidthAuto();
        goto L72
    L62:
        if (YogaConstants.isUndefined(r100.minWidthPercent) == true) goto L65;
        r101.setMinWidthPercent(r100.minWidthPercent);
        goto L65
    L56:
        if (YogaConstants.isUndefined(r100.maxWidthPercent) == true) goto L59;
        r101.setMaxWidthPercent(r100.maxWidthPercent);
        goto L59
    L51:
        r101.setDisplay(YogaDisplay.FLEX);
        goto L53
    L47:
        r101.setAlignSelf(YogaAlign.AUTO);
        goto L48
    L43:
        r101.setAlignItems(YogaAlign.STRETCH);
        goto L44
    L39:
        r101.setAlignContent(YogaAlign.AUTO);
        goto L40
    L35:
        r101.setJustifyContent(YogaJustify.FLEX_START);
        goto L36
    L31:
        r101.setFlexShrink(1.0f);
        goto L32
    L27:
        r101.setFlexGrow(0.0f);
        goto L29
    L23:
        r101.setFlexBasisAuto();
        goto L25
    L19:
        r101.setWrap(YogaWrap.WRAP);
        goto L21
    L15:
        r101.setFlexDirection(YogaFlexDirection.ROW);
        goto L16
    L8:
        r101.setPositionType(YogaPositionType.RELATIVE);
        goto L10
    }
}
