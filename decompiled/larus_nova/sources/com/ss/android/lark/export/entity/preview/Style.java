package com.ss.android.lark.export.entity.preview;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.lark.tangram.base.style.Align;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.tangram.base.style.Value;
import com.ss.android.lark.tangram.base.style.ValueType;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 I2\u00020\u0001:\u0002IJB³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107J\u001c\u00108\u001a\u0002052\u0006\u00109\u001a\u00020:2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<H\u0007J\u0017\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010@J\u0006\u0010A\u001a\u00020\u0017J\u0006\u0010B\u001a\u00020\u0017J\b\u0010C\u001a\u00020\u0000H\u0016J\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0096\u0002J\b\u0010H\u001a\u00020\u0014H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006K"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Style;", "Lcom/ss/android/lark/tangram/base/style/TCStyle;", "sizeLevel", "Lcom/ss/android/lark/export/entity/preview/SizeLevel;", "fontLevel", "Lcom/ss/android/lark/export/entity/preview/FontLevel;", "textColorV2", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "border", "Lcom/ss/android/lark/export/entity/preview/Border;", "backgroundColor", "Lcom/ss/android/lark/export/entity/preview/Gradient;", "width", "Lcom/ss/android/lark/tangram/base/style/Value;", "height", "minWidth", "minHeight", "maxWidth", "maxHeight", "growWeight", "", "shrinkWeight", "aspectRatio", "", "alignSelf", "Lcom/ss/android/lark/tangram/base/style/Align;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/SizeLevel;Lcom/ss/android/lark/export/entity/preview/FontLevel;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/Border;Lcom/ss/android/lark/export/entity/preview/Gradient;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;Lcom/ss/android/lark/tangram/base/style/Value;IIFLcom/ss/android/lark/tangram/base/style/Align;)V", "getSizeLevel", "()Lcom/ss/android/lark/export/entity/preview/SizeLevel;", "setSizeLevel", "(Lcom/ss/android/lark/export/entity/preview/SizeLevel;)V", "getFontLevel", "()Lcom/ss/android/lark/export/entity/preview/FontLevel;", "setFontLevel", "(Lcom/ss/android/lark/export/entity/preview/FontLevel;)V", "getTextColorV2", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "setTextColorV2", "(Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "getBorder", "()Lcom/ss/android/lark/export/entity/preview/Border;", "setBorder", "(Lcom/ss/android/lark/export/entity/preview/Border;)V", "getBackgroundColor", "()Lcom/ss/android/lark/export/entity/preview/Gradient;", "setBackgroundColor", "(Lcom/ss/android/lark/export/entity/preview/Gradient;)V", "getAlignSelf", "()Lcom/ss/android/lark/tangram/base/style/Align;", "setAlignSelf", "(Lcom/ss/android/lark/tangram/base/style/Align;)V", "patchData", "", "urlPreviewStyleData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewStyleData;", "applyBackground", "view", "Landroid/view/View;", "mapper", "Lcom/ss/android/lark/export/entity/preview/IColorKeyResMapper;", "getOrientationFromAngle", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "angle", "(Ljava/lang/Integer;)Landroid/graphics/drawable/GradientDrawable$Orientation;", "getWidth", "getHeight", "clone", "equals", "", "other", "", "hashCode", "Companion", "Builder", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Style extends TCStyle {
    public static final b Companion = null;
    private Align alignSelf;
    private Gradient backgroundColor;
    private Border border;
    private FontLevel fontLevel;
    private SizeLevel sizeLevel;
    private ThemeColor textColorV2;

    public static final class a extends TCStyle.a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final SizeLevel f420668j;

        public final Style a() {
            return new Style(this.f420668j, null, null, null, null, this.f441156a, this.f441157b, this.f441160e, this.f441161f, this.f441162g, this.f441163h, 0, 0, 0.0f, null, 16384, null);
        }

        public a() {
            this.f420668j = SizeLevel.NORMAL;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public Style() {
        this(null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0.0f, null, 32767, null);
    }

    public final void applyBackground(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        applyBackground$default(this, r100, null, 2, null);
    }

    @JvmStatic
    /* JADX INFO: renamed from: default, reason: not valid java name */
    public static final Style m8636default() {
        Companion.getClass();
        return new a().a();
    }

    @Override // com.ss.android.lark.tangram.base.style.TCStyle
    public Style clone() {
        SizeLevel r100 = this.sizeLevel;
        FontLevel r101 = this.fontLevel;
        if (r101 == null) goto L5;
        FontLevel r102 = r101.clone();
    L6:
        ThemeColor r103 = this.textColorV2;
        if (r103 == null) goto L9;
        ThemeColor r104 = r103.clone();
    L10:
        Border r105 = this.border;
        if (r105 == null) goto L13;
        Border r106 = r105.clone();
    L14:
        Gradient r107 = this.backgroundColor;
        if (r107 == null) goto L17;
        Gradient r108 = r107.clone();
    L18:
        Value r109 = getWidth();
        if (r109 == null) goto L21;
        Value r110 = r109.clone();
    L22:
        Value r111 = getHeight();
        if (r111 == null) goto L25;
        Value r112 = r111.clone();
    L26:
        Value r113 = getMinWidth();
        if (r113 == null) goto L29;
        Value r114 = r113.clone();
    L30:
        Value r115 = getMinHeight();
        if (r115 == null) goto L33;
        Value r116 = r115.clone();
    L34:
        Value r117 = getMaxWidth();
        if (r117 == null) goto L37;
        Value r118 = r117.clone();
    L38:
        Value r119 = getMaxHeight();
        if (r119 == null) goto L41;
        Value r210 = r119.clone();
    L42:
        Style r120 = new Style(r100, r102, r104, r106, r108, r110, r112, r114, r116, r118, r210, getGrowWeight(), getShrinkWeight(), getAspectRatio(), null, 16384, null);
        r120.setScaleWidth(getScaleWidth().clone());
        r120.setScaleHeight(getScaleHeight().clone());
        return r120;
    L41:
        r210 = null;
        goto L42
    L37:
        r118 = null;
        goto L38
    L33:
        r116 = null;
        goto L34
    L29:
        r114 = null;
        goto L30
    L25:
        r112 = null;
        goto L26
    L21:
        r110 = null;
        goto L22
    L17:
        r108 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final float getHeight() {
        Value r100 = getHeight();
        if (r100 == null) goto L5;
        ValueType r101 = r100.getValueType();
    L7:
        if (r101 != ValueType.POINT) goto L14;
        Value r102 = getHeight();
        if (r102 == null) goto L15;
        Float r103 = r102.getValue();
        if (r103 != null) goto L13;
        return 0.0f;
    L13:
        return r103.floatValue();
    L15:
        return 0.0f;
    L14:
        return 0.0f;
    L5:
        r101 = null;
        goto L7
    }

    public final float getWidth() {
        Value r100 = getWidth();
        if (r100 == null) goto L5;
        ValueType r101 = r100.getValueType();
    L7:
        if (r101 != ValueType.POINT) goto L14;
        Value r102 = getWidth();
        if (r102 == null) goto L15;
        Float r103 = r102.getValue();
        if (r103 != null) goto L13;
        return 0.0f;
    L13:
        return r103.floatValue();
    L15:
        return 0.0f;
    L14:
        return 0.0f;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.ss.android.lark.tangram.base.style.TCStyle
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        SizeLevel r101 = this.sizeLevel;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        FontLevel r105 = this.fontLevel;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        ThemeColor r108 = this.textColorV2;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        Border r111 = this.border;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        Gradient r114 = this.backgroundColor;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
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

    public final Align getAlignSelf() {
        return this.alignSelf;
    }

    public final Gradient getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Border getBorder() {
        return this.border;
    }

    public final FontLevel getFontLevel() {
        return this.fontLevel;
    }

    public final SizeLevel getSizeLevel() {
        return this.sizeLevel;
    }

    public final ThemeColor getTextColorV2() {
        return this.textColorV2;
    }

    @Override // com.ss.android.lark.tangram.base.style.TCStyle
    public /* bridge */ /* synthetic */ TCStyle clone() {
        return clone();
    }

    @Override // com.ss.android.lark.tangram.base.style.TCStyle
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Style) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        Style r101 = (Style) r100;
        if (this.sizeLevel == r101.sizeLevel) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fontLevel, r101.fontLevel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.textColorV2, r101.textColorV2) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.border, r101.border) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L26;
        return false;
    L26:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void patchData(UrlPreviewStyleData r110) {
        Integer r100 = null;
        Object[] r101 = 0;
        Object[] r102 = 0;
        Object[] r103 = 0;
        Object[] r104 = 0;
        Object[] r105 = 0;
        Object[] r106 = 0;
        Object[] r107 = 0;
        Object[] r108 = 0;
        Object[] r109 = 0;
        Object[] r111 = 0;
        Object[] r112 = 0;
        Object[] r113 = 0;
        Object[] r114 = 0;
        if (r110 == null) goto L5;
        HashMap<Integer, PreviewData> r115 = r110.getPreviewStyleData();
    L6:
        if (r115 != null) goto L8;
        return;
    L8:
        Iterator<Map.Entry<Integer, PreviewData>> r116 = r110.getPreviewStyleData().entrySet().iterator();
    L10:
        if (r116.hasNext() == false) goto L252;
        Map.Entry<Integer, PreviewData> r117 = r116.next();
        int r118 = r117.getKey().intValue();
        int r119 = 2;
        int r120 = 1;
        int r121 = 0;
        if (r118 == ComponentAttribute.size_level.getValue()) goto L13;
        if (r118 == ComponentAttribute.font_level.getValue()) goto L35;
        if (r118 == ComponentAttribute.theme_color.getValue()) goto L42;
        if (r118 == ComponentAttribute.border_width.getValue()) goto L49;
        if (r118 == ComponentAttribute.border_corner_radius.getValue()) goto L63;
        if (r118 == ComponentAttribute.border_theme_color.getValue()) goto L77;
        if (r118 == ComponentAttribute.background_type.getValue()) goto L91;
        if (r118 == ComponentAttribute.background_linear_deg.getValue()) goto L115;
        if (r118 == ComponentAttribute.background_linear_theme_colors.getValue()) goto L149;
        if (r118 == ComponentAttribute.width.getValue()) goto L187;
        if (r118 == ComponentAttribute.height.getValue()) goto L194;
        if (r118 == ComponentAttribute.max_width.getValue()) goto L201;
        if (r118 == ComponentAttribute.max_height.getValue()) goto L208;
        if (r118 == ComponentAttribute.min_width.getValue()) goto L215;
        if (r118 == ComponentAttribute.min_height.getValue()) goto L222;
        if (r118 == ComponentAttribute.grow_weight.getValue()) goto L229;
        if (r118 == ComponentAttribute.shrink_weight.getValue()) goto L237;
        if (r118 != ComponentAttribute.aspect_ratio.getValue()) goto L10;
        PreviewData r122 = r117.getValue();
        if (r122 == null) goto L250;
        Integer r123 = r122.getInt();
        if (r123 == null) goto L250;
        float r124 = r123.intValue() / 100.0f;
    L251:
        setAspectRatio(r124);
    L250:
        r124 = 0.0f;
        goto L251
    L237:
        PreviewData r125 = r117.getValue();
        if (r125 == null) goto L242;
        Integer r126 = r125.getInt();
        if (r126 == null) goto L242;
        r121 = r126.intValue();
    L242:
        setShrinkWeight(r121);
        goto L10
    L229:
        PreviewData r127 = r117.getValue();
        if (r127 == null) goto L234;
        Integer r128 = r127.getInt();
        if (r128 == null) goto L234;
        r121 = r128.intValue();
    L234:
        setGrowWeight(r121);
        goto L10
    L222:
        PreviewData r129 = r117.getValue();
        if (r129 == null) goto L225;
        Value r130 = r129.getLayoutValue();
    L226:
        setMinHeight(r130);
        goto L10
    L225:
        r130 = null;
        goto L226
    L215:
        PreviewData r131 = r117.getValue();
        if (r131 == null) goto L218;
        Value r132 = r131.getLayoutValue();
    L219:
        setMinWidth(r132);
        goto L10
    L218:
        r132 = null;
        goto L219
    L208:
        PreviewData r133 = r117.getValue();
        if (r133 == null) goto L211;
        Value r134 = r133.getLayoutValue();
    L212:
        setMaxHeight(r134);
        goto L10
    L211:
        r134 = null;
        goto L212
    L201:
        PreviewData r135 = r117.getValue();
        if (r135 == null) goto L204;
        Value r136 = r135.getLayoutValue();
    L205:
        setMaxWidth(r136);
        goto L10
    L204:
        r136 = null;
        goto L205
    L194:
        PreviewData r137 = r117.getValue();
        if (r137 == null) goto L197;
        Value r138 = r137.getLayoutValue();
    L198:
        setHeight(r138);
        goto L10
    L197:
        r138 = null;
        goto L198
    L187:
        PreviewData r139 = r117.getValue();
        if (r139 == null) goto L190;
        Value r140 = r139.getLayoutValue();
    L191:
        setWidth(r140);
        goto L10
    L190:
        r140 = null;
        goto L191
    L149:
        Gradient r141 = this.backgroundColor;
        if (r141 == null) goto L151;
        if (r141.getContent() == null) goto L160;
        Gradient r142 = this.backgroundColor;
        if (r142 == null) goto L172;
        Gradient.Content r143 = r142.getContent();
    L174:
        if ((r143 instanceof Gradient.Linear) == false) goto L176;
        Gradient.Linear r144 = (Gradient.Linear) r143;
    L177:
        if (r144 == null) goto L10;
        PreviewData r145 = r117.getValue();
        if (r145 == null) goto L183;
        ThemeColors r146 = r145.getThemeColors();
        if (r146 == null) goto L183;
        ArrayList<ThemeColor> r147 = r146.getThemecolors();
    L184:
        r144.setThemeColors(r147);
    L183:
        r147 = null;
        goto L184
    L176:
        r144 = null;
        goto L177
    L172:
        r143 = null;
        goto L174
    L160:
        Gradient r148 = this.backgroundColor;
        if (r148 == null) goto L10;
        PreviewData r149 = r117.getValue();
        if (r149 == null) goto L167;
        ThemeColors r150 = r149.getThemeColors();
        if (r150 == null) goto L167;
        ArrayList<ThemeColor> r151 = r150.getThemecolors();
    L168:
        r148.setContent(new Gradient.Linear(r100, r151, r120, r114 == true ? 1 : 0));
    L167:
        r151 = null;
        goto L168
    L151:
        PreviewData r152 = r117.getValue();
        if (r152 == null) goto L156;
        ThemeColors r153 = r152.getThemeColors();
        if (r153 == null) goto L156;
        ArrayList<ThemeColor> r154 = r153.getThemecolors();
    L157:
        this.backgroundColor = new Gradient(r111 == true ? 1 : 0, new Gradient.Linear(r113 == true ? 1 : 0, r154, r120, r112 == true ? 1 : 0), r120, r109 == true ? 1 : 0);
    L156:
        r154 = null;
        goto L157
    L115:
        Gradient r155 = this.backgroundColor;
        if (r155 == null) goto L117;
        if (r155.getContent() == null) goto L125;
        Gradient r156 = this.backgroundColor;
        if (r156 == null) goto L136;
        Gradient.Content r157 = r156.getContent();
    L138:
        if ((r157 instanceof Gradient.Linear) == false) goto L140;
        Gradient.Linear r158 = (Gradient.Linear) r157;
    L141:
        if (r158 == null) goto L10;
        PreviewData r159 = r117.getValue();
        if (r159 == null) goto L145;
        Integer r160 = r159.getInt();
    L146:
        r158.setDeg(r160);
        goto L10
    L145:
        r160 = null;
        goto L146
    L140:
        r158 = null;
        goto L141
    L136:
        r157 = null;
        goto L138
    L125:
        Gradient r161 = this.backgroundColor;
        if (r161 == null) goto L10;
        PreviewData r162 = r117.getValue();
        if (r162 == null) goto L132;
        Integer r163 = r162.getInt();
        if (r163 == null) goto L132;
        r121 = r163.intValue();
    L132:
        r161.setContent(new Gradient.Linear(Integer.valueOf(r121), r108 == true ? 1 : 0, r119, r107 == true ? 1 : 0));
        goto L10
    L117:
        PreviewData r164 = r117.getValue();
        if (r164 == null) goto L122;
        Integer r165 = r164.getInt();
        if (r165 == null) goto L122;
        r121 = r165.intValue();
    L122:
        this.backgroundColor = new Gradient(r104 == true ? 1 : 0, new Gradient.Linear(Integer.valueOf(r121), r106 == true ? 1 : 0, r119, r105 == true ? 1 : 0), r120, r103 == true ? 1 : 0);
        goto L10
    L91:
        Gradient r166 = this.backgroundColor;
        if (r166 == null) goto L93;
        Gradient.GradientType.a r167 = Gradient.GradientType.Companion;
        PreviewData r168 = r117.getValue();
        if (r168 == null) goto L108;
        Integer r169 = r168.getInt();
        if (r169 == null) goto L108;
        r121 = r169.intValue();
    L108:
        r167.getClass();
        if (r121 != 0) goto L111;
        Gradient.GradientType r170 = Gradient.GradientType.LINEAR;
    L112:
        r166.setType(r170);
        goto L10
    L111:
        r170 = Gradient.GradientType.LINEAR;
        goto L112
    L93:
        Gradient.GradientType.a r171 = Gradient.GradientType.Companion;
        PreviewData r172 = r117.getValue();
        if (r172 == null) goto L98;
        Integer r173 = r172.getInt();
        if (r173 == null) goto L98;
        r121 = r173.intValue();
    L98:
        r171.getClass();
        if (r121 != 0) goto L101;
        Gradient.GradientType r174 = Gradient.GradientType.LINEAR;
    L102:
        this.backgroundColor = new Gradient(r174, r102 == true ? 1 : 0, r119, r101 == true ? 1 : 0);
        goto L10
    L101:
        r174 = Gradient.GradientType.LINEAR;
        goto L102
    L77:
        Border r175 = this.border;
        if (r175 == null) goto L79;
        PreviewData r176 = r117.getValue();
        if (r176 == null) goto L87;
        ThemeColor r177 = r176.getThemeColor();
    L88:
        r175.setThemeColor(r177);
        goto L10
    L87:
        r177 = null;
        goto L88
    L79:
        Float r178 = null;
        Float r179 = null;
        PreviewData r180 = r117.getValue();
        if (r180 == null) goto L82;
        ThemeColor r181 = r180.getThemeColor();
    L83:
        this.border = new Border(r178, r179, r181, 3, null);
        goto L10
    L82:
        r181 = null;
        goto L83
    L63:
        Border r182 = this.border;
        if (r182 == null) goto L65;
        PreviewData r183 = r117.getValue();
        if (r183 == null) goto L73;
        Float r184 = r183.getFloat();
    L74:
        r182.setCornerRadius(r184);
        goto L10
    L73:
        r184 = null;
        goto L74
    L65:
        Float r185 = null;
        PreviewData r186 = r117.getValue();
        if (r186 == null) goto L68;
        Float r187 = r186.getFloat();
    L69:
        this.border = new Border(r185, r187, null, 5, null);
        goto L10
    L68:
        r187 = null;
        goto L69
    L49:
        Border r188 = this.border;
        if (r188 == null) goto L51;
        PreviewData r189 = r117.getValue();
        if (r189 == null) goto L59;
        Float r190 = r189.getFloat();
    L60:
        r188.setWidth(r190);
        goto L10
    L59:
        r190 = null;
        goto L60
    L51:
        PreviewData r191 = r117.getValue();
        if (r191 == null) goto L54;
        Float r192 = r191.getFloat();
    L55:
        this.border = new Border(r192, null, null, 6, null);
        goto L10
    L54:
        r192 = null;
        goto L55
    L42:
        PreviewData r193 = r117.getValue();
        if (r193 == null) goto L45;
        ThemeColor r194 = r193.getThemeColor();
    L46:
        this.textColorV2 = r194;
        goto L10
    L45:
        r194 = null;
        goto L46
    L35:
        PreviewData r195 = r117.getValue();
        if (r195 == null) goto L38;
        FontLevel r196 = r195.getFontLevel();
    L39:
        this.fontLevel = r196;
        goto L10
    L38:
        r196 = null;
        goto L39
    L13:
        PreviewData r197 = r117.getValue();
        if (r197 == null) goto L16;
        Integer r198 = r197.getInt();
    L17:
        if (r198 != null) goto L19;
        SizeLevel r199 = null;
    L32:
        this.sizeLevel = r199;
        goto L10
    L19:
        SizeLevel.a r200 = SizeLevel.Companion;
        PreviewData r201 = r117.getValue();
        if (r201 == null) goto L24;
        Integer r202 = r201.getInt();
        if (r202 == null) goto L24;
        r121 = r202.intValue();
    L24:
        r200.getClass();
        if (r121 == 0) goto L31;
        if (r121 == 1) goto L30;
        if (r121 == 2) goto L29;
        r199 = SizeLevel.NORMAL;
        goto L32
    L29:
        r199 = SizeLevel.LARGE;
        goto L32
    L30:
        r199 = SizeLevel.SMALL;
        goto L32
    L31:
        r199 = SizeLevel.NORMAL;
        goto L32
    L16:
        r198 = null;
        goto L17
    L252:
        return;
    L5:
        r115 = null;
        goto L6
    }

    public final void setAlignSelf(Align r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.alignSelf = r100;
    }

    public final void setBackgroundColor(Gradient r100) {
        this.backgroundColor = r100;
    }

    public final void setBorder(Border r100) {
        this.border = r100;
    }

    public final void setFontLevel(FontLevel r100) {
        this.fontLevel = r100;
    }

    public final void setSizeLevel(SizeLevel r100) {
        this.sizeLevel = r100;
    }

    public final void setTextColorV2(ThemeColor r100) {
        this.textColorV2 = r100;
    }

    public final void applyBackground(View r100, ycb.a r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setBackground(null);
        Gradient r101 = this.backgroundColor;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getType() != Gradient.GradientType.LINEAR) goto L62;
        Gradient.Content r102 = r101.getContent();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Gradient.Linear");
        Gradient.Linear r103 = (Gradient.Linear) r102;
        ArrayList<ThemeColor> r104 = r103.getThemeColors();
        if (r104 == null) goto L63;
        int[] r105 = new int[r104.size()];
        int r106 = r104.size();
        int r107 = 0;
    L9:
        if (r107 >= r106) goto L11;
        r105[r107] = com.ss.android.lark.export.entity.preview.a.a((ThemeColor) ListProtector.get(r104, r107), r100.getContext(), r110);
        r107 = r107 + 1;
        goto L9
    L11:
        GradientDrawable r108 = new GradientDrawable();
        if (r104.size() != 1) goto L15;
        r108.setColor(r105[0]);
    L45:
        Border r109 = this.border;
        if (r109 == null) goto L58;
        Float r111 = r109.getCornerRadius();
        if (r111 == null) goto L50;
        r108.setCornerRadius(UIHelper.dp2px(r111.floatValue()));
    L50:
        ThemeColor r112 = r109.getThemeColor();
        Float r113 = r109.getWidth();
        if (r113 == null) goto L53;
        float r114 = r113.floatValue();
    L54:
        if (r112 == null) goto L58;
        if (r114 <= 0.0f) goto L58;
        r108.setStroke(UIHelper.dp2px(r114), com.ss.android.lark.export.entity.preview.a.a(r112, r100.getContext(), r110));
        goto L58
    L53:
        r114 = 0.0f;
    L58:
        r100.setBackground(r108);
        return;
    L15:
        if (r104.size() <= 1) goto L45;
        Integer r115 = r103.getDeg();
        if (r115 == null) goto L43;
        int r116 = Math.abs(r115.intValue()) % 360;
        if (r116 != 0) goto L21;
        GradientDrawable.Orientation r117 = GradientDrawable.Orientation.BOTTOM_TOP;
    L44:
        r108.setOrientation(r117);
        r108.setColors(r105);
        goto L45
    L21:
        if (r116 != 45) goto L23;
        r117 = GradientDrawable.Orientation.BL_TR;
        goto L44
    L23:
        if (r116 != 90) goto L25;
        r117 = GradientDrawable.Orientation.LEFT_RIGHT;
        goto L44
    L25:
        if (r116 != 135) goto L27;
        r117 = GradientDrawable.Orientation.TL_BR;
        goto L44
    L27:
        if (r116 != 180) goto L29;
        r117 = GradientDrawable.Orientation.TOP_BOTTOM;
        goto L44
    L29:
        if (r116 != 225) goto L31;
        r117 = GradientDrawable.Orientation.TR_BL;
        goto L44
    L31:
        if (r116 != 270) goto L33;
        r117 = GradientDrawable.Orientation.RIGHT_LEFT;
        goto L44
    L33:
        if (r116 == 315) goto L35;
        r117 = GradientDrawable.Orientation.LEFT_RIGHT;
        goto L44
    L35:
        r117 = GradientDrawable.Orientation.BR_TL;
        goto L44
    L43:
        r117 = GradientDrawable.Orientation.LEFT_RIGHT;
        goto L44
    L63:
        return;
    }

    public static /* synthetic */ void applyBackground$default(Style r100, View r101, ycb.a r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.applyBackground(r101, r102);
    }

    public Style(SizeLevel r110, FontLevel r111, ThemeColor r210, Border r211, Gradient r212, Value r213, Value r214, Value r215, Value r216, Value r217, Value r218, int r219, int r310, float r311, Align r312) {
        Intrinsics.checkNotNullParameter(r312, "alignSelf");
        super(r213, r214, r215, r216, r217, r218, r219, r310, r311, null, null, r312, ISmModel.VERSION_0600, null);
        this.sizeLevel = r110;
        this.fontLevel = r111;
        this.textColorV2 = r210;
        this.border = r211;
        this.backgroundColor = r212;
        this.alignSelf = r312;
    }

    public /* synthetic */ Style(SizeLevel r110, FontLevel r111, ThemeColor r112, Border r113, Gradient r210, Value r211, Value r212, Value r213, Value r214, Value r215, Value r216, int r217, int r218, float r219, Align r310, int r311, DefaultConstructorMarker r312) {
        if ((r311 & 1) == 0) goto L5;
        SizeLevel r100 = SizeLevel.NORMAL;
    L6:
        Value r101 = null;
        if ((r311 & 2) == 0) goto L9;
        FontLevel r102 = null;
    L11:
        if ((r311 & 4) == 0) goto L13;
        ThemeColor r103 = null;
    L15:
        if ((r311 & 8) == 0) goto L17;
        Border r104 = null;
    L19:
        if ((r311 & 16) == 0) goto L21;
        Gradient r105 = null;
    L23:
        if ((r311 & 32) == 0) goto L25;
        Value r106 = null;
    L27:
        if ((r311 & 64) == 0) goto L29;
        Value r107 = null;
    L31:
        if ((r311 & 128) == 0) goto L33;
        Value r108 = null;
    L35:
        if ((r311 & 256) == 0) goto L37;
        Value r114 = null;
    L39:
        if ((r311 & 512) == 0) goto L41;
        Value r115 = null;
    L43:
        if ((r311 & 1024) != 0) goto L46;
        r101 = r216;
    L46:
        int r116 = 0;
        if ((r311 & 2048) == 0) goto L49;
        int r117 = 0;
    L51:
        if ((r311 & 4096) != 0) goto L55;
        r116 = r218;
    L55:
        if ((r311 & 8192) == 0) goto L57;
        float r118 = 0.0f;
    L59:
        if ((r311 & 16384) == 0) goto L61;
        Align r109 = Align.TOP;
    L62:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r114, r115, r101, r117, r116, r118, r109);
        return;
    L61:
        r109 = r310;
        goto L62
    L57:
        r118 = r219;
        goto L59
    L49:
        r117 = r217;
        goto L51
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
