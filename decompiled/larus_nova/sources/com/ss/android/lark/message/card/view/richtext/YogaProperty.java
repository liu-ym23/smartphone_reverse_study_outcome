package com.ss.android.lark.message.card.view.richtext;

import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
public class YogaProperty implements Serializable {
    private static final long serialVersionUID = 5197740916295279064L;
    public int alignContent;
    public int alignItems;
    public int alignSelf;
    public float aspectRatio;
    public float bottom;
    public int display;
    public float flexBasis;
    public int flexDirection;
    public float flexGrow;
    public float flexShrink;
    public int flexWrap;
    public float height;
    public float heightPercent;
    public int justifyContent;
    public float left;
    public float marginBottom;
    public float marginBottomPercent;
    public float marginLeft;
    public float marginLeftPercent;
    public float marginRight;
    public float marginRightPercent;
    public float marginTop;
    public float marginTopPercent;
    public float maxHeight;
    public float maxHeightPercent;
    public float maxWidth;
    public float maxWidthPercent;
    public float minHeight;
    public float minHeightPercent;
    public float minWidth;
    public float minWidthPercent;
    public float paddingBottom;
    public float paddingLeft;
    public float paddingRight;
    public float paddingTop;
    public int position;
    public float right;
    public float top;
    public float width;
    public float widthPercent;

    public int hashCode() {
        int r100 = ((this.flexDirection * 31) + this.flexWrap) * 31;
        float r101 = this.flexBasis;
        int r102 = 0;
        if (r101 == 0.0f) goto L5;
        int r103 = Float.floatToIntBits(r101);
    L6:
        int r104 = (r100 + r103) * 31;
        float r105 = this.flexGrow;
        if (r105 == 0.0f) goto L9;
        int r106 = Float.floatToIntBits(r105);
    L10:
        int r107 = (r104 + r106) * 31;
        float r108 = this.flexShrink;
        if (r108 == 0.0f) goto L13;
        int r109 = Float.floatToIntBits(r108);
    L14:
        int r110 = (((((((((((((r107 + r109) * 31) + this.justifyContent) * 31) + this.alignContent) * 31) + this.alignItems) * 31) + this.alignSelf) * 31) + this.display) * 31) + this.position) * 31;
        float r111 = this.aspectRatio;
        if (r111 == 0.0f) goto L17;
        int r112 = Float.floatToIntBits(r111);
    L18:
        int r113 = (r110 + r112) * 31;
        float r114 = this.maxWidth;
        if (r114 == 0.0f) goto L21;
        int r115 = Float.floatToIntBits(r114);
    L22:
        int r116 = (r113 + r115) * 31;
        float r117 = this.maxWidthPercent;
        if (r117 == 0.0f) goto L25;
        int r118 = Float.floatToIntBits(r117);
    L26:
        int r119 = (r116 + r118) * 31;
        float r120 = this.minWidth;
        if (r120 == 0.0f) goto L29;
        int r121 = Float.floatToIntBits(r120);
    L30:
        int r122 = (r119 + r121) * 31;
        float r123 = this.minWidthPercent;
        if (r123 == 0.0f) goto L33;
        int r124 = Float.floatToIntBits(r123);
    L34:
        int r125 = (r122 + r124) * 31;
        float r126 = this.width;
        if (r126 == 0.0f) goto L37;
        int r127 = Float.floatToIntBits(r126);
    L38:
        int r128 = (r125 + r127) * 31;
        float r129 = this.widthPercent;
        if (r129 == 0.0f) goto L41;
        int r130 = Float.floatToIntBits(r129);
    L42:
        int r131 = (r128 + r130) * 31;
        float r132 = this.maxHeight;
        if (r132 == 0.0f) goto L45;
        int r133 = Float.floatToIntBits(r132);
    L46:
        int r134 = (r131 + r133) * 31;
        float r135 = this.maxHeightPercent;
        if (r135 == 0.0f) goto L49;
        int r136 = Float.floatToIntBits(r135);
    L50:
        int r137 = (r134 + r136) * 31;
        float r138 = this.minHeight;
        if (r138 == 0.0f) goto L53;
        int r139 = Float.floatToIntBits(r138);
    L54:
        int r140 = (r137 + r139) * 31;
        float r141 = this.minHeightPercent;
        if (r141 == 0.0f) goto L57;
        int r142 = Float.floatToIntBits(r141);
    L58:
        int r143 = (r140 + r142) * 31;
        float r144 = this.height;
        if (r144 == 0.0f) goto L61;
        int r145 = Float.floatToIntBits(r144);
    L62:
        int r146 = (r143 + r145) * 31;
        float r147 = this.heightPercent;
        if (r147 == 0.0f) goto L65;
        int r148 = Float.floatToIntBits(r147);
    L66:
        int r149 = (r146 + r148) * 31;
        float r150 = this.marginTop;
        if (r150 == 0.0f) goto L69;
        int r151 = Float.floatToIntBits(r150);
    L70:
        int r152 = (r149 + r151) * 31;
        float r153 = this.marginRight;
        if (r153 == 0.0f) goto L73;
        int r154 = Float.floatToIntBits(r153);
    L74:
        int r155 = (r152 + r154) * 31;
        float r156 = this.marginBottom;
        if (r156 == 0.0f) goto L77;
        int r157 = Float.floatToIntBits(r156);
    L78:
        int r158 = (r155 + r157) * 31;
        float r159 = this.marginLeft;
        if (r159 == 0.0f) goto L81;
        int r160 = Float.floatToIntBits(r159);
    L82:
        int r161 = (r158 + r160) * 31;
        float r162 = this.paddingTop;
        if (r162 == 0.0f) goto L85;
        int r163 = Float.floatToIntBits(r162);
    L86:
        int r164 = (r161 + r163) * 31;
        float r165 = this.paddingRight;
        if (r165 == 0.0f) goto L89;
        int r166 = Float.floatToIntBits(r165);
    L90:
        int r167 = (r164 + r166) * 31;
        float r168 = this.paddingBottom;
        if (r168 == 0.0f) goto L93;
        int r169 = Float.floatToIntBits(r168);
    L94:
        int r170 = (r167 + r169) * 31;
        float r171 = this.paddingLeft;
        if (r171 == 0.0f) goto L97;
        int r172 = Float.floatToIntBits(r171);
    L98:
        int r173 = (r170 + r172) * 31;
        float r174 = this.top;
        if (r174 == 0.0f) goto L101;
        int r175 = Float.floatToIntBits(r174);
    L102:
        int r176 = (r173 + r175) * 31;
        float r177 = this.right;
        if (r177 == 0.0f) goto L105;
        int r178 = Float.floatToIntBits(r177);
    L106:
        int r179 = (r176 + r178) * 31;
        float r180 = this.bottom;
        if (r180 == 0.0f) goto L109;
        int r181 = Float.floatToIntBits(r180);
    L110:
        int r182 = (r179 + r181) * 31;
        float r183 = this.left;
        if (r183 == 0.0f) goto L114;
        r102 = Float.floatToIntBits(r183);
    L114:
        return r182 + r102;
    L109:
        r181 = 0;
        goto L110
    L105:
        r178 = 0;
        goto L106
    L101:
        r175 = 0;
        goto L102
    L97:
        r172 = 0;
        goto L98
    L93:
        r169 = 0;
        goto L94
    L89:
        r166 = 0;
        goto L90
    L85:
        r163 = 0;
        goto L86
    L81:
        r160 = 0;
        goto L82
    L77:
        r157 = 0;
        goto L78
    L73:
        r154 = 0;
        goto L74
    L69:
        r151 = 0;
        goto L70
    L65:
        r148 = 0;
        goto L66
    L61:
        r145 = 0;
        goto L62
    L57:
        r142 = 0;
        goto L58
    L53:
        r139 = 0;
        goto L54
    L49:
        r136 = 0;
        goto L50
    L45:
        r133 = 0;
        goto L46
    L41:
        r130 = 0;
        goto L42
    L37:
        r127 = 0;
        goto L38
    L33:
        r124 = 0;
        goto L34
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public YogaProperty() {
        this.flexDirection = -1;
        this.flexWrap = -1;
        this.flexBasis = 1.0E21f;
        this.flexGrow = -1.0f;
        this.flexShrink = -1.0f;
        this.justifyContent = -1;
        this.alignContent = -1;
        this.alignItems = -1;
        this.alignSelf = -1;
        this.display = -1;
        this.position = -1;
        this.aspectRatio = 1.0E21f;
        this.maxWidth = 1.0E21f;
        this.maxWidthPercent = 1.0E21f;
        this.minWidth = 1.0E21f;
        this.minWidthPercent = 1.0E21f;
        this.width = 1.0E21f;
        this.widthPercent = 1.0E21f;
        this.maxHeight = 1.0E21f;
        this.maxHeightPercent = 1.0E21f;
        this.minHeight = 1.0E21f;
        this.minHeightPercent = 1.0E21f;
        this.height = 1.0E21f;
        this.heightPercent = 1.0E21f;
        this.marginTop = 1.0E21f;
        this.marginTopPercent = 1.0E21f;
        this.marginRight = 1.0E21f;
        this.marginRightPercent = 1.0E21f;
        this.marginBottom = 1.0E21f;
        this.marginBottomPercent = 1.0E21f;
        this.marginLeft = 1.0E21f;
        this.marginLeftPercent = 1.0E21f;
        this.paddingTop = 0.0f;
        this.paddingRight = 0.0f;
        this.paddingBottom = 0.0f;
        this.paddingLeft = 0.0f;
        this.top = 1.0E21f;
        this.right = 1.0E21f;
        this.bottom = 1.0E21f;
        this.left = 1.0E21f;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L120:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L120;
        YogaProperty r101 = (YogaProperty) r100;
        if (this.flexDirection == r101.flexDirection) goto L14;
        return false;
    L14:
        if (this.flexWrap == r101.flexWrap) goto L17;
        return false;
    L17:
        if (Float.compare(r101.flexBasis, this.flexBasis) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(r101.flexGrow, this.flexGrow) == 0) goto L23;
        return false;
    L23:
        if (Float.compare(r101.flexShrink, this.flexShrink) == 0) goto L26;
        return false;
    L26:
        if (this.justifyContent == r101.justifyContent) goto L29;
        return false;
    L29:
        if (this.alignContent == r101.alignContent) goto L32;
        return false;
    L32:
        if (this.alignItems == r101.alignItems) goto L35;
        return false;
    L35:
        if (this.alignSelf == r101.alignSelf) goto L38;
        return false;
    L38:
        if (this.display == r101.display) goto L41;
        return false;
    L41:
        if (this.position == r101.position) goto L44;
        return false;
    L44:
        if (this.aspectRatio == r101.aspectRatio) goto L47;
        return false;
    L47:
        if (Float.compare(r101.maxWidth, this.maxWidth) == 0) goto L50;
        return false;
    L50:
        if (Float.compare(r101.maxWidthPercent, this.maxWidthPercent) == 0) goto L53;
        return false;
    L53:
        if (Float.compare(r101.minWidth, this.minWidth) == 0) goto L56;
        return false;
    L56:
        if (Float.compare(r101.minWidthPercent, this.minWidthPercent) == 0) goto L59;
        return false;
    L59:
        if (Float.compare(r101.width, this.width) == 0) goto L62;
        return false;
    L62:
        if (Float.compare(r101.widthPercent, this.widthPercent) == 0) goto L65;
        return false;
    L65:
        if (Float.compare(r101.maxHeight, this.maxHeight) == 0) goto L68;
        return false;
    L68:
        if (Float.compare(r101.maxHeightPercent, this.maxHeightPercent) == 0) goto L71;
        return false;
    L71:
        if (Float.compare(r101.minHeight, this.minHeight) == 0) goto L74;
        return false;
    L74:
        if (Float.compare(r101.minHeightPercent, this.minHeightPercent) == 0) goto L77;
        return false;
    L77:
        if (Float.compare(r101.height, this.height) == 0) goto L80;
        return false;
    L80:
        if (Float.compare(r101.heightPercent, this.heightPercent) == 0) goto L83;
        return false;
    L83:
        if (Float.compare(r101.marginTop, this.marginTop) == 0) goto L86;
        return false;
    L86:
        if (Float.compare(r101.marginRight, this.marginRight) == 0) goto L89;
        return false;
    L89:
        if (Float.compare(r101.marginBottom, this.marginBottom) == 0) goto L92;
        return false;
    L92:
        if (Float.compare(r101.marginLeft, this.marginLeft) == 0) goto L95;
        return false;
    L95:
        if (Float.compare(r101.paddingTop, this.paddingTop) == 0) goto L98;
        return false;
    L98:
        if (Float.compare(r101.paddingRight, this.paddingRight) == 0) goto L101;
        return false;
    L101:
        if (Float.compare(r101.paddingBottom, this.paddingBottom) == 0) goto L104;
        return false;
    L104:
        if (Float.compare(r101.paddingLeft, this.paddingLeft) == 0) goto L107;
        return false;
    L107:
        if (Float.compare(r101.top, this.top) == 0) goto L110;
        return false;
    L110:
        if (Float.compare(r101.right, this.right) == 0) goto L113;
        return false;
    L113:
        if (Float.compare(r101.bottom, this.bottom) == 0) goto L116;
        return false;
    L116:
        if (Float.compare(r101.left, this.left) == 0) goto L121;
        return false;
    L121:
        return true;
    }
}
