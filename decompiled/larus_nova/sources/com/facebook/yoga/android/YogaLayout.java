package com.facebook.yoga.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class YogaLayout extends ViewGroup {
    private final YogaNode mYogaNode;
    private final Map<View, YogaNode> mYogaNodes;

    public static class LayoutParams extends ViewGroup.LayoutParams {
        SparseArray<Float> numericAttributes;
        SparseArray<String> stringAttributes;

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            if ((r100 instanceof LayoutParams) == false) goto L5;
            LayoutParams r101 = (LayoutParams) r100;
            this.numericAttributes = r101.numericAttributes.clone();
            this.stringAttributes = r101.stringAttributes.clone();
            return;
        L5:
            this.numericAttributes = new SparseArray();
            this.stringAttributes = new SparseArray();
            if (r100.width < 0) goto L9;
            this.numericAttributes.put(55, Float.valueOf(((ViewGroup.LayoutParams) this).width));
        L9:
            if (r100.height < 0) goto L13;
            this.numericAttributes.put(20, Float.valueOf(((ViewGroup.LayoutParams) this).height));
            return;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.numericAttributes = new SparseArray();
            this.stringAttributes = new SparseArray();
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.yg_alignContent, R.attr.yg_alignItems, R.attr.yg_alignSelf, R.attr.yg_aspectRatio, R.attr.yg_borderAll, R.attr.yg_borderBottom, R.attr.yg_borderEnd, R.attr.yg_borderHorizontal, R.attr.yg_borderLeft, R.attr.yg_borderRight, R.attr.yg_borderStart, R.attr.yg_borderTop, R.attr.yg_borderVertical, R.attr.yg_direction, R.attr.yg_display, R.attr.yg_flex, R.attr.yg_flexBasis, R.attr.yg_flexDirection, R.attr.yg_flexGrow, R.attr.yg_flexShrink, R.attr.yg_height, R.attr.yg_justifyContent, R.attr.yg_marginAll, R.attr.yg_marginBottom, R.attr.yg_marginEnd, R.attr.yg_marginHorizontal, R.attr.yg_marginLeft, R.attr.yg_marginRight, R.attr.yg_marginStart, R.attr.yg_marginTop, R.attr.yg_marginVertical, R.attr.yg_maxHeight, R.attr.yg_maxWidth, R.attr.yg_minHeight, R.attr.yg_minWidth, R.attr.yg_overflow, R.attr.yg_paddingAll, R.attr.yg_paddingBottom, R.attr.yg_paddingEnd, R.attr.yg_paddingHorizontal, R.attr.yg_paddingLeft, R.attr.yg_paddingRight, R.attr.yg_paddingStart, R.attr.yg_paddingTop, R.attr.yg_paddingVertical, R.attr.yg_positionAll, R.attr.yg_positionBottom, R.attr.yg_positionEnd, R.attr.yg_positionHorizontal, R.attr.yg_positionLeft, R.attr.yg_positionRight, R.attr.yg_positionStart, R.attr.yg_positionTop, R.attr.yg_positionType, R.attr.yg_positionVertical, R.attr.yg_width, R.attr.yg_wrap});
            int r103 = ((ViewGroup.LayoutParams) this).width;
            if (r103 < 0) goto L5;
            this.numericAttributes.put(55, Float.valueOf(r103));
        L5:
            int r104 = ((ViewGroup.LayoutParams) this).height;
            if (r104 < 0) goto L8;
            this.numericAttributes.put(20, Float.valueOf(r104));
        L8:
            int r105 = r102.getIndexCount();
            int r106 = 0;
        L9:
            if (r106 >= r105) goto L18;
            int r107 = r102.getIndex(r106);
            TypedValue r108 = new TypedValue();
            r102.getValue(r107, r108);
            int r109 = r108.type;
            if (r109 != 5) goto L14;
            this.numericAttributes.put(r107, Float.valueOf(r102.getDimensionPixelSize(r107, 0)));
        L17:
            r106 = r106 + 1;
            goto L9
        L14:
            if (r109 != 3) goto L16;
            this.stringAttributes.put(r107, r102.getString(r107));
            goto L17
        L16:
            this.numericAttributes.put(r107, Float.valueOf(r102.getFloat(r107, 0.0f)));
            goto L17
        L18:
            r102.recycle();
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.numericAttributes = new SparseArray();
            this.stringAttributes = new SparseArray();
            if (r100 < 0) goto L5;
            this.numericAttributes.put(55, Float.valueOf(r100));
        L5:
            if (r101 < 0) goto L8;
            this.numericAttributes.put(20, Float.valueOf(r101));
            return;
        }
    }

    public static class ViewMeasureFunction implements YogaMeasureFunction {
        public ViewMeasureFunction() {
        }

        private int viewMeasureSpecFromYogaMeasureMode(YogaMeasureMode r100) {
            if (r100 != YogaMeasureMode.AT_MOST) goto L7;
            return Integer.MIN_VALUE;
        L7:
            if (r100 != YogaMeasureMode.EXACTLY) goto L10;
            return 1073741824;
        L10:
            return 0;
        }

        @Override // com.facebook.yoga.YogaMeasureFunction
        public long measure(YogaNode r100, float r101, YogaMeasureMode r102, float r103, YogaMeasureMode r104) {
            View r105 = (View) r100.getData();
            if (r105 == null) goto L10;
            if ((r105 instanceof YogaLayout) == true) goto L10;
            r105.measure(View.MeasureSpec.makeMeasureSpec((int) r101, viewMeasureSpecFromYogaMeasureMode(r102)), View.MeasureSpec.makeMeasureSpec((int) r103, viewMeasureSpecFromYogaMeasureMode(r104)));
            return YogaMeasureOutput.make(r105.getMeasuredWidth(), r105.getMeasuredHeight());
        L10:
            return YogaMeasureOutput.make(0, 0);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        removeViewFromYogaTree(getChildAt(r101), false);
        r101 = r101 + 1;
        goto L3
    L5:
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        removeViewFromYogaTree(getChildAt(r101), true);
        r101 = r101 + 1;
        goto L3
    L5:
        super.removeAllViewsInLayout();
    }

    public YogaNode getYogaNode() {
        return this.mYogaNode;
    }

    public YogaLayout(Context r100) {
        this(r100, null, 0);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public YogaNode getYogaNodeForView(View r100) {
        return this.mYogaNodes.get(r100);
    }

    public void invalidate(View r100) {
        if (this.mYogaNodes.containsKey(r100) == false) goto L6;
        this.mYogaNodes.get(r100).dirty();
        return;
    L6:
        int r101 = this.mYogaNode.getChildCount();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L12;
        YogaNode r103 = this.mYogaNode.getChildAt(r102);
        if ((r103.getData() instanceof YogaLayout) == false) goto L11;
        ((YogaLayout) r103.getData()).invalidate(r100);
    L11:
        r102 = r102 + 1;
        goto L7
    L12:
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r100) {
        removeViewFromYogaTree(r100, false);
        super.removeView(r100);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int r100) {
        removeViewFromYogaTree(getChildAt(r100), false);
        super.removeViewAt(r100);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View r100) {
        removeViewFromYogaTree(r100, true);
        super.removeViewInLayout(r100);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new LayoutParams(r100);
    }

    public YogaLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    private void createLayout(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        int r104 = View.MeasureSpec.getMode(r100);
        int r105 = View.MeasureSpec.getMode(r101);
        if (r105 != 1073741824) goto L5;
        this.mYogaNode.setHeight(r103);
    L5:
        if (r104 != 1073741824) goto L8;
        this.mYogaNode.setWidth(r102);
    L8:
        if (r105 != Integer.MIN_VALUE) goto L10;
        this.mYogaNode.setMaxHeight(r103);
    L10:
        if (r104 != Integer.MIN_VALUE) goto L12;
        this.mYogaNode.setMaxWidth(r102);
    L12:
        this.mYogaNode.calculateLayout(1.0E21f, 1.0E21f);
    }

    private void removeViewFromYogaTree(View r100, boolean r101) {
        YogaNode r102 = this.mYogaNodes.get(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        YogaNode r103 = r102.getOwner();
        int r104 = 0;
    L7:
        if (r104 >= r103.getChildCount()) goto L12;
        if (r103.getChildAt(r104).equals(r102) == true) goto L10;
        r104 = r104 + 1;
        goto L7
    L10:
        r103.removeChildAt(r104);
    L12:
        r102.setData(null);
        this.mYogaNodes.remove(r100);
        if (r101 == false) goto L18;
        this.mYogaNode.calculateLayout(1.0E21f, 1.0E21f);
        return;
    }

    public void addView(View r100, YogaNode r101) {
        this.mYogaNodes.put(r100, r101);
        addView(r100);
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        if ((getParent() instanceof YogaLayout) == true) goto L5;
        createLayout(r100, r101);
    L5:
        setMeasuredDimension(Math.round(this.mYogaNode.getLayoutWidth()), Math.round(this.mYogaNode.getLayoutHeight()));
    }

    @Override // android.view.ViewGroup
    public void removeViews(int r100, int r101) {
        int r102 = r100;
    L4:
        if (r102 >= (r100 + r101)) goto L6;
        removeViewFromYogaTree(getChildAt(r102), false);
        r102 = r102 + 1;
        goto L4
    L6:
        super.removeViews(r100, r101);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int r100, int r101) {
        int r102 = r100;
    L4:
        if (r102 >= (r100 + r101)) goto L6;
        removeViewFromYogaTree(getChildAt(r102), true);
        r102 = r102 + 1;
        goto L4
    L6:
        super.removeViewsInLayout(r100, r101);
    }

    public YogaLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        YogaNode r103 = new YogaNode();
        this.mYogaNode = r103;
        this.mYogaNodes = new HashMap();
        r103.setData(this);
        r103.setMeasureFunction(new ViewMeasureFunction());
        if (r101 == null) goto L5;
        LayoutParams r104 = new LayoutParams(r100, r101);
    L6:
        applyLayoutParams(r104, r103, this);
        return;
    L5:
        r104 = (LayoutParams) generateDefaultLayoutParams();
        goto L6
    }

    public static void applyLayoutParams(LayoutParams r110, YogaNode r111, View r112) {
        int r100 = 1;
        if (r112.getResources().getConfiguration().getLayoutDirection() != 1) goto L5;
        r111.setDirection(YogaDirection.RTL);
    L5:
        Drawable r101 = r112.getBackground();
        if (r101 == null) goto L10;
        Rect r102 = new Rect();
        if (r101.getPadding(r102) == false) goto L10;
        r111.setPadding(YogaEdge.LEFT, r102.left);
        r111.setPadding(YogaEdge.TOP, r102.top);
        r111.setPadding(YogaEdge.RIGHT, r102.right);
        r111.setPadding(YogaEdge.BOTTOM, r102.bottom);
    L10:
        int r103 = 0;
    L11:
        int r104 = 16;
        int r105 = 30;
        if (r103 >= r110.numericAttributes.size()) goto L174;
        int r106 = r110.numericAttributes.keyAt(r103);
        float r107 = r110.numericAttributes.valueAt(r103).floatValue();
        if (r106 != 0) goto L16;
        r111.setAlignContent(YogaAlign.fromInt(Math.round(r107)));
    L173:
        r103 = r103 + 1;
        r100 = 1;
        goto L11
    L16:
        if (r106 != r100) goto L19;
        r111.setAlignItems(YogaAlign.fromInt(Math.round(r107)));
        goto L173
    L19:
        if (r106 != 2) goto L22;
        r111.setAlignSelf(YogaAlign.fromInt(Math.round(r107)));
        goto L173
    L22:
        if (r106 != 3) goto L25;
        r111.setAspectRatio(r107);
        goto L173
    L25:
        if (r106 != 8) goto L28;
        r111.setBorder(YogaEdge.LEFT, r107);
        goto L173
    L28:
        if (r106 != 11) goto L31;
        r111.setBorder(YogaEdge.TOP, r107);
        goto L173
    L31:
        if (r106 != 9) goto L34;
        r111.setBorder(YogaEdge.RIGHT, r107);
        goto L173
    L34:
        if (r106 != 5) goto L37;
        r111.setBorder(YogaEdge.BOTTOM, r107);
        goto L173
    L37:
        if (r106 != 10) goto L40;
        r111.setBorder(YogaEdge.START, r107);
        goto L173
    L40:
        if (r106 != 6) goto L43;
        r111.setBorder(YogaEdge.END, r107);
        goto L173
    L43:
        if (r106 != 7) goto L46;
        r111.setBorder(YogaEdge.HORIZONTAL, r107);
        goto L173
    L46:
        if (r106 != 12) goto L49;
        r111.setBorder(YogaEdge.VERTICAL, r107);
        goto L173
    L49:
        if (r106 != 4) goto L52;
        r111.setBorder(YogaEdge.ALL, r107);
        goto L173
    L52:
        if (r106 != 13) goto L55;
        r111.setDirection(YogaDirection.fromInt(Math.round(r107)));
        goto L173
    L55:
        if (r106 != 14) goto L58;
        r111.setDisplay(YogaDisplay.fromInt(Math.round(r107)));
        goto L173
    L58:
        if (r106 != 15) goto L60;
        r111.setFlex(r107);
        goto L173
    L60:
        if (r106 != 16) goto L63;
        r111.setFlexBasis(r107);
        goto L173
    L63:
        if (r106 != 17) goto L66;
        r111.setFlexDirection(YogaFlexDirection.fromInt(Math.round(r107)));
        goto L173
    L66:
        if (r106 != 18) goto L69;
        r111.setFlexGrow(r107);
        goto L173
    L69:
        if (r106 != 19) goto L71;
        r111.setFlexShrink(r107);
        goto L173
    L71:
        if (r106 != 20) goto L73;
        r111.setHeight(r107);
        goto L173
    L73:
        if (r106 != 26) goto L76;
        r111.setMargin(YogaEdge.LEFT, r107);
        goto L173
    L76:
        if (r106 != 21) goto L78;
        r111.setJustifyContent(YogaJustify.fromInt(Math.round(r107)));
        goto L173
    L78:
        if (r106 != 29) goto L80;
        r111.setMargin(YogaEdge.TOP, r107);
        goto L173
    L80:
        if (r106 != 27) goto L82;
        r111.setMargin(YogaEdge.RIGHT, r107);
        goto L173
    L82:
        if (r106 != 23) goto L84;
        r111.setMargin(YogaEdge.BOTTOM, r107);
        goto L173
    L84:
        if (r106 != 28) goto L86;
        r111.setMargin(YogaEdge.START, r107);
        goto L173
    L86:
        if (r106 != 24) goto L88;
        r111.setMargin(YogaEdge.END, r107);
        goto L173
    L88:
        if (r106 != 25) goto L90;
        r111.setMargin(YogaEdge.HORIZONTAL, r107);
        goto L173
    L90:
        if (r106 != 30) goto L93;
        r111.setMargin(YogaEdge.VERTICAL, r107);
        goto L173
    L93:
        if (r106 != 22) goto L96;
        r111.setMargin(YogaEdge.ALL, r107);
        goto L173
    L96:
        if (r106 != 31) goto L99;
        r111.setMaxHeight(r107);
        goto L173
    L99:
        if (r106 != 32) goto L102;
        r111.setMaxWidth(r107);
        goto L173
    L102:
        if (r106 != 33) goto L105;
        r111.setMinHeight(r107);
        goto L173
    L105:
        if (r106 != 34) goto L108;
        r111.setMinWidth(r107);
        goto L173
    L108:
        if (r106 != 35) goto L111;
        r111.setOverflow(YogaOverflow.fromInt(Math.round(r107)));
        goto L173
    L111:
        if (r106 != 40) goto L114;
        r111.setPadding(YogaEdge.LEFT, r107);
        goto L173
    L114:
        if (r106 != 43) goto L117;
        r111.setPadding(YogaEdge.TOP, r107);
        goto L173
    L117:
        if (r106 != 41) goto L120;
        r111.setPadding(YogaEdge.RIGHT, r107);
        goto L173
    L120:
        if (r106 != 37) goto L123;
        r111.setPadding(YogaEdge.BOTTOM, r107);
        goto L173
    L123:
        if (r106 != 42) goto L126;
        r111.setPadding(YogaEdge.START, r107);
        goto L173
    L126:
        if (r106 != 38) goto L129;
        r111.setPadding(YogaEdge.END, r107);
        goto L173
    L129:
        if (r106 != 39) goto L132;
        r111.setPadding(YogaEdge.HORIZONTAL, r107);
        goto L173
    L132:
        if (r106 != 44) goto L135;
        r111.setPadding(YogaEdge.VERTICAL, r107);
        goto L173
    L135:
        if (r106 != 36) goto L138;
        r111.setPadding(YogaEdge.ALL, r107);
        goto L173
    L138:
        if (r106 != 49) goto L141;
        r111.setPosition(YogaEdge.LEFT, r107);
        goto L173
    L141:
        if (r106 != 52) goto L144;
        r111.setPosition(YogaEdge.TOP, r107);
        goto L173
    L144:
        if (r106 != 50) goto L147;
        r111.setPosition(YogaEdge.RIGHT, r107);
        goto L173
    L147:
        if (r106 != 46) goto L150;
        r111.setPosition(YogaEdge.BOTTOM, r107);
        goto L173
    L150:
        if (r106 != 51) goto L153;
        r111.setPosition(YogaEdge.START, r107);
        goto L173
    L153:
        if (r106 != 47) goto L156;
        r111.setPosition(YogaEdge.END, r107);
        goto L173
    L156:
        if (r106 != 48) goto L159;
        r111.setPosition(YogaEdge.HORIZONTAL, r107);
        goto L173
    L159:
        if (r106 != 54) goto L162;
        r111.setPosition(YogaEdge.VERTICAL, r107);
        goto L173
    L162:
        if (r106 != 45) goto L165;
        r111.setPosition(YogaEdge.ALL, r107);
        goto L173
    L165:
        if (r106 != 53) goto L168;
        r111.setPositionType(YogaPositionType.fromInt(Math.round(r107)));
        goto L173
    L168:
        if (r106 != 55) goto L171;
        r111.setWidth(r107);
        goto L173
    L171:
        if (r106 != 56) goto L173;
        r111.setWrap(YogaWrap.fromInt(Math.round(r107)));
        goto L173
    L174:
        int r108 = 0;
    L176:
        if (r108 >= r110.stringAttributes.size()) goto L297;
        int r109 = r110.stringAttributes.keyAt(r108);
        String r113 = r110.stringAttributes.valueAt(r108);
        if (r113.equals("auto") == false) goto L199;
        if (r109 != 26) goto L181;
        r111.setMarginAuto(YogaEdge.LEFT);
        goto L199
    L181:
        if (r109 != 29) goto L183;
        r111.setMarginAuto(YogaEdge.TOP);
        goto L199
    L183:
        if (r109 != 27) goto L185;
        r111.setMarginAuto(YogaEdge.RIGHT);
        goto L199
    L185:
        if (r109 != 23) goto L187;
        r111.setMarginAuto(YogaEdge.BOTTOM);
        goto L199
    L187:
        if (r109 != 28) goto L189;
        r111.setMarginAuto(YogaEdge.START);
        goto L199
    L189:
        if (r109 != 24) goto L191;
        r111.setMarginAuto(YogaEdge.END);
        goto L199
    L191:
        if (r109 != 25) goto L193;
        r111.setMarginAuto(YogaEdge.HORIZONTAL);
        goto L199
    L193:
        if (r109 != r105) goto L196;
        r111.setMarginAuto(YogaEdge.VERTICAL);
        goto L199
    L196:
        if (r109 != 22) goto L199;
        r111.setMarginAuto(YogaEdge.ALL);
    L199:
        if (r113.endsWith(GXTemplateKey.GAIAX_PE) == false) goto L296;
        float r114 = Float.parseFloat(r113.substring(0, r113.length() - 1));
        if (r109 != r104) goto L204;
        r111.setFlexBasisPercent(r114);
        goto L296
    L204:
        if (r109 != 20) goto L206;
        r111.setHeightPercent(r114);
        goto L296
    L206:
        if (r109 != 26) goto L208;
        r111.setMarginPercent(YogaEdge.LEFT, r114);
        goto L296
    L208:
        if (r109 != 29) goto L210;
        r111.setMarginPercent(YogaEdge.TOP, r114);
        goto L296
    L210:
        if (r109 != 27) goto L212;
        r111.setMarginPercent(YogaEdge.RIGHT, r114);
        goto L296
    L212:
        if (r109 != 23) goto L214;
        r111.setMarginPercent(YogaEdge.BOTTOM, r114);
        goto L296
    L214:
        if (r109 != 28) goto L216;
        r111.setMarginPercent(YogaEdge.START, r114);
        goto L296
    L216:
        if (r109 != 24) goto L218;
        r111.setMarginPercent(YogaEdge.END, r114);
        goto L296
    L218:
        if (r109 != 25) goto L221;
        r111.setMarginPercent(YogaEdge.HORIZONTAL, r114);
        goto L296
    L221:
        if (r109 != 30) goto L224;
        r111.setMarginPercent(YogaEdge.VERTICAL, r114);
        goto L296
    L224:
        if (r109 != 22) goto L227;
        r111.setMarginPercent(YogaEdge.ALL, r114);
        goto L296
    L227:
        if (r109 != 31) goto L230;
        r111.setMaxHeightPercent(r114);
        goto L296
    L230:
        if (r109 != 32) goto L233;
        r111.setMaxWidthPercent(r114);
        goto L296
    L233:
        if (r109 != 33) goto L236;
        r111.setMinHeightPercent(r114);
        goto L296
    L236:
        if (r109 != 34) goto L239;
        r111.setMinWidthPercent(r114);
        goto L296
    L239:
        if (r109 != 40) goto L242;
        r111.setPaddingPercent(YogaEdge.LEFT, r114);
        goto L296
    L242:
        if (r109 != 43) goto L245;
        r111.setPaddingPercent(YogaEdge.TOP, r114);
        goto L296
    L245:
        if (r109 != 41) goto L248;
        r111.setPaddingPercent(YogaEdge.RIGHT, r114);
        goto L296
    L248:
        if (r109 != 37) goto L251;
        r111.setPaddingPercent(YogaEdge.BOTTOM, r114);
        goto L296
    L251:
        if (r109 != 42) goto L254;
        r111.setPaddingPercent(YogaEdge.START, r114);
        goto L296
    L254:
        if (r109 != 38) goto L257;
        r111.setPaddingPercent(YogaEdge.END, r114);
        goto L296
    L257:
        if (r109 != 39) goto L260;
        r111.setPaddingPercent(YogaEdge.HORIZONTAL, r114);
        goto L296
    L260:
        if (r109 != 44) goto L263;
        r111.setPaddingPercent(YogaEdge.VERTICAL, r114);
        goto L296
    L263:
        if (r109 != 36) goto L266;
        r111.setPaddingPercent(YogaEdge.ALL, r114);
        goto L296
    L266:
        if (r109 != 49) goto L269;
        r111.setPositionPercent(YogaEdge.LEFT, r114);
        goto L296
    L269:
        if (r109 != 52) goto L272;
        r111.setPositionPercent(YogaEdge.TOP, r114);
        goto L296
    L272:
        if (r109 != 50) goto L275;
        r111.setPositionPercent(YogaEdge.RIGHT, r114);
        goto L296
    L275:
        if (r109 != 46) goto L278;
        r111.setPositionPercent(YogaEdge.BOTTOM, r114);
        goto L296
    L278:
        if (r109 != 51) goto L281;
        r111.setPositionPercent(YogaEdge.START, r114);
        goto L296
    L281:
        if (r109 != 47) goto L284;
        r111.setPositionPercent(YogaEdge.END, r114);
        goto L296
    L284:
        if (r109 != 48) goto L287;
        r111.setPositionPercent(YogaEdge.HORIZONTAL, r114);
        goto L296
    L287:
        if (r109 != 54) goto L290;
        r111.setPositionPercent(YogaEdge.VERTICAL, r114);
        goto L296
    L290:
        if (r109 != 45) goto L293;
        r111.setPositionPercent(YogaEdge.ALL, r114);
        goto L296
    L293:
        if (r109 != 55) goto L296;
        r111.setWidthPercent(r114);
    L296:
        r108 = r108 + 1;
        r104 = 16;
        r105 = 30;
        goto L176
    }

    private void applyLayoutRecursive(YogaNode r100, float r101, float r102) {
        View r103 = (View) r100.getData();
        if (r103 == null) goto L9;
        if (r103 == this) goto L9;
        if (r103.getVisibility() != 8) goto L8;
        return;
    L8:
        int r104 = Math.round(r100.getLayoutX() + r101);
        int r105 = Math.round(r100.getLayoutY() + r102);
        r103.measure(View.MeasureSpec.makeMeasureSpec(Math.round(r100.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(r100.getLayoutHeight()), 1073741824));
        r103.layout(r104, r105, r103.getMeasuredWidth() + r104, r103.getMeasuredHeight() + r105);
    L9:
        int r106 = r100.getChildCount();
        int r107 = 0;
    L10:
        if (r107 >= r106) goto L19;
        if (equals(r103) == false) goto L15;
        applyLayoutRecursive(r100.getChildAt(r107), r101, r102);
    L18:
        r107 = r107 + 1;
        goto L10
    L15:
        if ((r103 instanceof YogaLayout) == true) goto L18;
        applyLayoutRecursive(r100.getChildAt(r107), r100.getLayoutX() + r101, r100.getLayoutY() + r102);
        goto L18
    }

    @Override // android.view.ViewGroup
    public void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        this.mYogaNode.setMeasureFunction(null);
        if ((r100 instanceof VirtualYogaLayout) == false) goto L6;
        VirtualYogaLayout r103 = (VirtualYogaLayout) r100;
        r103.transferChildren(this);
        YogaNode r104 = r103.getYogaNode();
        YogaNode r105 = this.mYogaNode;
        r105.addChildAt(r104, r105.getChildCount());
        return;
    L6:
        super.addView(r100, r101, r102);
        if (this.mYogaNodes.containsKey(r100) == false) goto L10;
        return;
    L10:
        if ((r100 instanceof YogaLayout) == false) goto L13;
        YogaNode r106 = ((YogaLayout) r100).getYogaNode();
    L17:
        applyLayoutParams((LayoutParams) r100.getLayoutParams(), r106, r100);
        this.mYogaNodes.put(r100, r106);
        YogaNode r107 = this.mYogaNode;
        r107.addChildAt(r106, r107.getChildCount());
        return;
    L13:
        if (this.mYogaNodes.containsKey(r100) == false) goto L15;
        r106 = this.mYogaNodes.get(r100);
    L16:
        r106.setData(r100);
        r106.setMeasureFunction(new ViewMeasureFunction());
        goto L17
    L15:
        r106 = new YogaNode();
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if ((getParent() instanceof YogaLayout) == true) goto L5;
        createLayout(View.MeasureSpec.makeMeasureSpec(r103 - r101, 1073741824), View.MeasureSpec.makeMeasureSpec(r104 - r102, 1073741824));
    L5:
        applyLayoutRecursive(this.mYogaNode, 0.0f, 0.0f);
    }
}
