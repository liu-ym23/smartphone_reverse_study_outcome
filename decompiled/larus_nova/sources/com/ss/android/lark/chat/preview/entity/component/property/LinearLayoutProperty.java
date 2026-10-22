package com.ss.android.lark.chat.preview.entity.component.property;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.Justify;
import com.ss.android.lark.export.entity.Orientation;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.Padding;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.tangram.base.style.Align;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u0000H\u0016J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\u000bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\rHÆ\u0003JQ\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020<HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006="}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/LinearLayoutProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "orientation", "Lcom/ss/android/lark/export/entity/Orientation;", "spacing", "", "wrapWidth", GXTemplateKey.FLEXBOX_PADDING, "mainAxisJustify", "Lcom/ss/android/lark/export/entity/Justify;", "crossAxisAlign", "Lcom/ss/android/lark/tangram/base/style/Align;", "sidePadding", "Lcom/ss/android/lark/export/entity/preview/Padding;", "<init>", "(Lcom/ss/android/lark/export/entity/Orientation;FFFLcom/ss/android/lark/export/entity/Justify;Lcom/ss/android/lark/tangram/base/style/Align;Lcom/ss/android/lark/export/entity/preview/Padding;)V", "getOrientation", "()Lcom/ss/android/lark/export/entity/Orientation;", "setOrientation", "(Lcom/ss/android/lark/export/entity/Orientation;)V", "getSpacing", "()F", "setSpacing", "(F)V", "getWrapWidth", "setWrapWidth", "getPadding", "setPadding", "getMainAxisJustify", "()Lcom/ss/android/lark/export/entity/Justify;", "setMainAxisJustify", "(Lcom/ss/android/lark/export/entity/Justify;)V", "getCrossAxisAlign", "()Lcom/ss/android/lark/tangram/base/style/Align;", "setCrossAxisAlign", "(Lcom/ss/android/lark/tangram/base/style/Align;)V", "getSidePadding", "()Lcom/ss/android/lark/export/entity/preview/Padding;", "setSidePadding", "(Lcom/ss/android/lark/export/entity/preview/Padding;)V", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinearLayoutProperty extends BaseProperty {
    private Align crossAxisAlign;
    private Justify mainAxisJustify;
    private Orientation orientation;
    private float padding;
    private Padding sidePadding;
    private float spacing;
    private float wrapWidth;

    public LinearLayoutProperty() {
        this(null, 0.0f, 0.0f, 0.0f, null, null, null, 127, null);
    }

    public static /* synthetic */ LinearLayoutProperty copy$default(LinearLayoutProperty r100, Orientation r101, float r102, float r103, float r104, Justify r110, Align r111, Padding r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.orientation;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.spacing;
    L8:
        float r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.wrapWidth;
    L11:
        float r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.padding;
    L14:
        float r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.mainAxisJustify;
    L17:
        Justify r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.crossAxisAlign;
    L20:
        Align r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.sidePadding;
    L23:
        Orientation r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Orientation component1() {
        return this.orientation;
    }

    public final float component2() {
        return this.spacing;
    }

    public final float component3() {
        return this.wrapWidth;
    }

    public final float component4() {
        return this.padding;
    }

    public final Justify component5() {
        return this.mainAxisJustify;
    }

    public final Align component6() {
        return this.crossAxisAlign;
    }

    public final Padding component7() {
        return this.sidePadding;
    }

    public final LinearLayoutProperty copy(Orientation r110, float r111, float r112, float r113, Justify r114, Align r115, Padding r116) {
        Intrinsics.checkNotNullParameter(r110, "orientation");
        Intrinsics.checkNotNullParameter(r114, "mainAxisJustify");
        Intrinsics.checkNotNullParameter(r115, "crossAxisAlign");
        return new LinearLayoutProperty(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LinearLayoutProperty) == true) goto L8;
        return false;
    L8:
        LinearLayoutProperty r101 = (LinearLayoutProperty) r100;
        if (this.orientation == r101.orientation) goto L12;
        return false;
    L12:
        if (Float.compare(this.spacing, r101.spacing) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.wrapWidth, r101.wrapWidth) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.padding, r101.padding) == 0) goto L21;
        return false;
    L21:
        if (this.mainAxisJustify == r101.mainAxisJustify) goto L24;
        return false;
    L24:
        if (this.crossAxisAlign == r101.crossAxisAlign) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.sidePadding, r101.sidePadding) == true) goto L29;
        return false;
    L29:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = ((((((((((this.orientation.hashCode() * 31) + Float.floatToIntBits(this.spacing)) * 31) + Float.floatToIntBits(this.wrapWidth)) * 31) + Float.floatToIntBits(this.padding)) * 31) + this.mainAxisJustify.hashCode()) * 31) + this.crossAxisAlign.hashCode()) * 31;
        Padding r101 = this.sidePadding;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "LinearLayoutProperty(orientation=" + this.orientation + ", spacing=" + this.spacing + ", wrapWidth=" + this.wrapWidth + ", padding=" + this.padding + ", mainAxisJustify=" + this.mainAxisJustify + ", crossAxisAlign=" + this.crossAxisAlign + ", sidePadding=" + this.sidePadding + ')';
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public LinearLayoutProperty clone() {
        LinearLayoutProperty r100 = new LinearLayoutProperty(this.orientation, this.spacing, this.wrapWidth, this.padding, this.mainAxisJustify, this.crossAxisAlign, this.sidePadding);
        r100.setMarginLeft(getMarginLeft());
        r100.setMarginRight(getMarginRight());
        r100.setMarginTop(getMarginTop());
        r100.setMarginBottom(getMarginBottom());
        return r100;
    }

    public final Align getCrossAxisAlign() {
        return this.crossAxisAlign;
    }

    public final Justify getMainAxisJustify() {
        return this.mainAxisJustify;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final float getPadding() {
        return this.padding;
    }

    public final Padding getSidePadding() {
        return this.sidePadding;
    }

    public final float getSpacing() {
        return this.spacing;
    }

    public final float getWrapWidth() {
        return this.wrapWidth;
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public /* bridge */ /* synthetic */ Props clone() {
        return clone();
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r101 = r100.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L62;
        Map.Entry<Integer, PreviewData> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        int r104 = 0;
        if (r103 == ComponentAttribute.orientation.getValue()) goto L9;
        float r105 = 0.0f;
        if (r103 == ComponentAttribute.spacing.getValue()) goto L17;
        if (r103 == ComponentAttribute.wrap_width.getValue()) goto L25;
        if (r103 == ComponentAttribute.padding.getValue()) goto L33;
        if (r103 == ComponentAttribute.main_axis_justify.getValue()) goto L41;
        if (r103 == ComponentAttribute.cross_axis_align.getValue()) goto L49;
        if (r103 != ComponentAttribute.side_padding.getValue()) goto L6;
        PreviewData r106 = r102.getValue();
        if (r106 == null) goto L60;
        Padding r107 = r106.getPadding();
    L61:
        this.sidePadding = r107;
        goto L6
    L60:
        r107 = null;
        goto L61
    L49:
        Align.a r108 = Align.Companion;
        PreviewData r109 = r102.getValue();
        if (r109 == null) goto L54;
        Integer r110 = r109.getInt();
        if (r110 == null) goto L54;
        r104 = r110.intValue();
    L54:
        r108.getClass();
        this.crossAxisAlign = Align.a.a(r104);
        goto L6
    L41:
        Justify.a r111 = Justify.Companion;
        PreviewData r112 = r102.getValue();
        if (r112 == null) goto L46;
        Integer r113 = r112.getInt();
        if (r113 == null) goto L46;
        r104 = r113.intValue();
    L46:
        r111.getClass();
        this.mainAxisJustify = Justify.a.a(r104);
        goto L6
    L33:
        PreviewData r114 = r102.getValue();
        if (r114 == null) goto L38;
        Float r115 = r114.getFloat();
        if (r115 == null) goto L38;
        r105 = r115.floatValue();
    L38:
        this.padding = r105;
        goto L6
    L25:
        PreviewData r116 = r102.getValue();
        if (r116 == null) goto L30;
        Float r117 = r116.getFloat();
        if (r117 == null) goto L30;
        r105 = r117.floatValue();
    L30:
        this.wrapWidth = r105;
        goto L6
    L17:
        PreviewData r118 = r102.getValue();
        if (r118 == null) goto L22;
        Float r119 = r118.getFloat();
        if (r119 == null) goto L22;
        r105 = r119.floatValue();
    L22:
        this.spacing = r105;
        goto L6
    L9:
        Orientation.a r120 = Orientation.Companion;
        PreviewData r121 = r102.getValue();
        if (r121 == null) goto L14;
        Integer r122 = r121.getInt();
        if (r122 == null) goto L14;
        r104 = r122.intValue();
    L14:
        r120.getClass();
        this.orientation = Orientation.a.a(r104);
        goto L6
    }

    public final void setCrossAxisAlign(Align r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.crossAxisAlign = r100;
    }

    public final void setMainAxisJustify(Justify r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mainAxisJustify = r100;
    }

    public final void setOrientation(Orientation r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.orientation = r100;
    }

    public final void setPadding(float r100) {
        this.padding = r100;
    }

    public final void setSidePadding(Padding r100) {
        this.sidePadding = r100;
    }

    public final void setSpacing(float r100) {
        this.spacing = r100;
    }

    public final void setWrapWidth(float r100) {
        this.wrapWidth = r100;
    }

    public LinearLayoutProperty(Orientation r100, float r101, float r102, float r103, Justify r104, Align r105, Padding r106) {
        Intrinsics.checkNotNullParameter(r100, "orientation");
        Intrinsics.checkNotNullParameter(r104, "mainAxisJustify");
        Intrinsics.checkNotNullParameter(r105, "crossAxisAlign");
        super(Type.LINEAR_LAYOUT);
        this.orientation = r100;
        this.spacing = r101;
        this.wrapWidth = r102;
        this.padding = r103;
        this.mainAxisJustify = r104;
        this.crossAxisAlign = r105;
        this.sidePadding = r106;
    }

    public /* synthetic */ LinearLayoutProperty(Orientation r100, float r101, float r102, float r103, Justify r110, Align r111, Padding r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        r100 = Orientation.ROW;
    L5:
        float r104 = 0.0f;
        if ((r113 & 2) == 0) goto L8;
        float r115 = 0.0f;
    L10:
        if ((r113 & 4) == 0) goto L12;
        float r105 = 0.0f;
    L14:
        if ((r113 & 8) != 0) goto L18;
        r104 = r103;
    L18:
        if ((r113 & 16) == 0) goto L20;
        r110 = Justify.START;
    L20:
        Justify r106 = r110;
        if ((r113 & 32) == 0) goto L23;
        r111 = Align.TOP;
    L23:
        Align r107 = r111;
        if ((r113 & 64) == 0) goto L26;
        r112 = null;
    L26:
        Orientation r108 = r100;
        float r109 = r115;
        float r116 = r105;
        float r117 = r104;
        this(r108, r109, r116, r117, r106, r107, r112);
        return;
    L12:
        r105 = r102;
        goto L14
    L8:
        r115 = r101;
        goto L10
    }
}
