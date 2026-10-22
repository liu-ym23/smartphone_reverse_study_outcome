package com.ss.android.lark.export.flexlayout;

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
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001FBY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020\u0000H\u0016J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010;\u001a\u00020\fHÆ\u0003J\t\u0010<\u001a\u00020\u000eHÆ\u0003J\t\u0010=\u001a\u00020\u0010HÆ\u0003J[\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010?\u001a\u00020\u00102\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020CHÖ\u0001J\t\u0010D\u001a\u00020EHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006G"}, d2 = {"Lcom/ss/android/lark/export/flexlayout/FlexLayoutProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "orientation", "Lcom/ss/android/lark/export/entity/Orientation;", "flexWrap", "Lcom/ss/android/lark/export/flexlayout/FlexLayoutProperty$FlexWrap;", "mainAxisSpacing", "", "crossAxisSpacing", GXTemplateKey.FLEXBOX_PADDING, "Lcom/ss/android/lark/export/entity/preview/Padding;", "mainAxisJustify", "Lcom/ss/android/lark/export/entity/Justify;", "crossAxisAlign", "Lcom/ss/android/lark/tangram/base/style/Align;", "forceUseCompactMode", "", "<init>", "(Lcom/ss/android/lark/export/entity/Orientation;Lcom/ss/android/lark/export/flexlayout/FlexLayoutProperty$FlexWrap;FFLcom/ss/android/lark/export/entity/preview/Padding;Lcom/ss/android/lark/export/entity/Justify;Lcom/ss/android/lark/tangram/base/style/Align;Z)V", "getOrientation", "()Lcom/ss/android/lark/export/entity/Orientation;", "setOrientation", "(Lcom/ss/android/lark/export/entity/Orientation;)V", "getFlexWrap", "()Lcom/ss/android/lark/export/flexlayout/FlexLayoutProperty$FlexWrap;", "setFlexWrap", "(Lcom/ss/android/lark/export/flexlayout/FlexLayoutProperty$FlexWrap;)V", "getMainAxisSpacing", "()F", "setMainAxisSpacing", "(F)V", "getCrossAxisSpacing", "setCrossAxisSpacing", "getPadding", "()Lcom/ss/android/lark/export/entity/preview/Padding;", "setPadding", "(Lcom/ss/android/lark/export/entity/preview/Padding;)V", "getMainAxisJustify", "()Lcom/ss/android/lark/export/entity/Justify;", "setMainAxisJustify", "(Lcom/ss/android/lark/export/entity/Justify;)V", "getCrossAxisAlign", "()Lcom/ss/android/lark/tangram/base/style/Align;", "setCrossAxisAlign", "(Lcom/ss/android/lark/tangram/base/style/Align;)V", "getForceUseCompactMode", "()Z", "setForceUseCompactMode", "(Z)V", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "", "FlexWrap", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlexLayoutProperty extends BaseProperty {
    private Align crossAxisAlign;
    private float crossAxisSpacing;
    private FlexWrap flexWrap;
    private boolean forceUseCompactMode;
    private Justify mainAxisJustify;
    private float mainAxisSpacing;
    private Orientation orientation;
    private Padding padding;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/export/flexlayout/FlexLayoutProperty$FlexWrap;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_WRAP", "WRAP", "WRAP_REVERSE", "LINEAR_WRAP", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FlexWrap extends Enum<FlexWrap> {
        public static final a Companion = null;
        public static final FlexWrap LINEAR_WRAP = null;
        public static final FlexWrap NO_WRAP = null;
        public static final FlexWrap WRAP = null;
        public static final FlexWrap WRAP_REVERSE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FlexWrap[] f420680a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f420681b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            public static FlexWrap a(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L18;
                if (r100 == 2) goto L17;
                if (r100 == 3) goto L16;
                return FlexWrap.NO_WRAP;
            L16:
                return FlexWrap.LINEAR_WRAP;
            L17:
                return FlexWrap.WRAP_REVERSE;
            L18:
                return FlexWrap.WRAP;
            L14:
                return FlexWrap.NO_WRAP;
            }
        }

        public static EnumEntries<FlexWrap> getEntries() {
            return f420681b;
        }

        static {
            FlexWrap r100 = new FlexWrap("NO_WRAP", 0, 0);
            NO_WRAP = r100;
            FlexWrap r101 = new FlexWrap("WRAP", 1, 1);
            WRAP = r101;
            FlexWrap r102 = new FlexWrap("WRAP_REVERSE", 2, 2);
            WRAP_REVERSE = r102;
            FlexWrap r103 = new FlexWrap("LINEAR_WRAP", 3, 3);
            LINEAR_WRAP = r103;
            FlexWrap[] r104 = {r100, r101, r102, r103};
            f420680a = r104;
            f420681b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static FlexWrap[] values() {
            return (FlexWrap[]) f420680a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FlexWrap valueOf(String r100) {
            return (FlexWrap) r27.a.a(FlexWrap.class, r100);
        }

        public FlexWrap(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public FlexLayoutProperty() {
        this(null, null, 0.0f, 0.0f, null, null, null, false, 255, null);
    }

    public static /* synthetic */ FlexLayoutProperty copy$default(FlexLayoutProperty r100, Orientation r110, FlexWrap r111, float r112, float r113, Padding r114, Justify r115, Align r116, boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        Orientation r101 = r100.orientation;
    L7:
        if ((r118 & 2) == 0) goto L9;
        FlexWrap r102 = r100.flexWrap;
    L11:
        if ((r118 & 4) == 0) goto L13;
        float r103 = r100.mainAxisSpacing;
    L15:
        if ((r118 & 8) == 0) goto L17;
        float r104 = r100.crossAxisSpacing;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Padding r105 = r100.padding;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Justify r106 = r100.mainAxisJustify;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Align r107 = r100.crossAxisAlign;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r108 = r100.forceUseCompactMode;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
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
        r101 = r110;
        goto L7
    }

    public final Orientation component1() {
        return this.orientation;
    }

    public final FlexWrap component2() {
        return this.flexWrap;
    }

    public final float component3() {
        return this.mainAxisSpacing;
    }

    public final float component4() {
        return this.crossAxisSpacing;
    }

    public final Padding component5() {
        return this.padding;
    }

    public final Justify component6() {
        return this.mainAxisJustify;
    }

    public final Align component7() {
        return this.crossAxisAlign;
    }

    public final boolean component8() {
        return this.forceUseCompactMode;
    }

    public final FlexLayoutProperty copy(Orientation r110, FlexWrap r111, float r112, float r113, Padding r114, Justify r115, Align r116, boolean r117) {
        Intrinsics.checkNotNullParameter(r110, "orientation");
        Intrinsics.checkNotNullParameter(r111, "flexWrap");
        Intrinsics.checkNotNullParameter(r115, "mainAxisJustify");
        Intrinsics.checkNotNullParameter(r116, "crossAxisAlign");
        return new FlexLayoutProperty(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlexLayoutProperty) == true) goto L8;
        return false;
    L8:
        FlexLayoutProperty r101 = (FlexLayoutProperty) r100;
        if (this.orientation == r101.orientation) goto L12;
        return false;
    L12:
        if (this.flexWrap == r101.flexWrap) goto L15;
        return false;
    L15:
        if (Float.compare(this.mainAxisSpacing, r101.mainAxisSpacing) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.crossAxisSpacing, r101.crossAxisSpacing) == 0) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.padding, r101.padding) == true) goto L24;
        return false;
    L24:
        if (this.mainAxisJustify == r101.mainAxisJustify) goto L27;
        return false;
    L27:
        if (this.crossAxisAlign == r101.crossAxisAlign) goto L30;
        return false;
    L30:
        if (this.forceUseCompactMode == r101.forceUseCompactMode) goto L32;
        return false;
    L32:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = ((((((this.orientation.hashCode() * 31) + this.flexWrap.hashCode()) * 31) + Float.floatToIntBits(this.mainAxisSpacing)) * 31) + Float.floatToIntBits(this.crossAxisSpacing)) * 31;
        Padding r101 = this.padding;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.mainAxisJustify.hashCode()) * 31) + this.crossAxisAlign.hashCode()) * 31;
        if (this.forceUseCompactMode == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "FlexLayoutProperty(orientation=" + this.orientation + ", flexWrap=" + this.flexWrap + ", mainAxisSpacing=" + this.mainAxisSpacing + ", crossAxisSpacing=" + this.crossAxisSpacing + ", padding=" + this.padding + ", mainAxisJustify=" + this.mainAxisJustify + ", crossAxisAlign=" + this.crossAxisAlign + ", forceUseCompactMode=" + this.forceUseCompactMode + ')';
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public FlexLayoutProperty clone() {
        FlexLayoutProperty r110 = new FlexLayoutProperty(null, null, 0.0f, 0.0f, null, null, null, false, 255, null);
        r110.orientation = this.orientation;
        r110.flexWrap = this.flexWrap;
        r110.mainAxisSpacing = this.mainAxisSpacing;
        r110.crossAxisSpacing = this.crossAxisSpacing;
        r110.padding = this.padding;
        r110.mainAxisJustify = this.mainAxisJustify;
        r110.crossAxisAlign = this.crossAxisAlign;
        r110.forceUseCompactMode = this.forceUseCompactMode;
        return r110;
    }

    public final Align getCrossAxisAlign() {
        return this.crossAxisAlign;
    }

    public final float getCrossAxisSpacing() {
        return this.crossAxisSpacing;
    }

    public final FlexWrap getFlexWrap() {
        return this.flexWrap;
    }

    public final boolean getForceUseCompactMode() {
        return this.forceUseCompactMode;
    }

    public final Justify getMainAxisJustify() {
        return this.mainAxisJustify;
    }

    public final float getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final Padding getPadding() {
        return this.padding;
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
        if (r101.hasNext() == false) goto L70;
        Map.Entry<Integer, PreviewData> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        int r104 = 0;
        boolean r105 = false;
        r105 = false;
        int r106 = 0;
        r106 = 0;
        int r107 = 0;
        r107 = 0;
        int r108 = 0;
        r108 = 0;
        r104 = 0;
        if (r103 == ComponentAttribute.orientation.getValue()) goto L9;
        if (r103 == ComponentAttribute.flex_wrap.getValue()) goto L17;
        float r109 = 0.0f;
        if (r103 == ComponentAttribute.main_axis_spacing.getValue()) goto L25;
        if (r103 == ComponentAttribute.cross_axis_spacing.getValue()) goto L33;
        if (r103 == ComponentAttribute.padding.getValue()) goto L41;
        if (r103 == ComponentAttribute.main_axis_justify.getValue()) goto L48;
        if (r103 == ComponentAttribute.cross_axis_align.getValue()) goto L56;
        if (r103 != ComponentAttribute.force_use_compact_mode.getValue()) goto L6;
        PreviewData r110 = r102.getValue();
        if (r110 == null) goto L69;
        Boolean r111 = r110.getBoolean();
        if (r111 == null) goto L69;
        r105 = r111.booleanValue();
    L69:
        this.forceUseCompactMode = r105;
        goto L6
    L56:
        Align.a r112 = Align.Companion;
        PreviewData r113 = r102.getValue();
        if (r113 == null) goto L61;
        Integer r114 = r113.getInt();
        if (r114 == null) goto L61;
        r106 = r114.intValue();
    L61:
        r112.getClass();
        this.crossAxisAlign = Align.a.a(r106);
        goto L6
    L48:
        Justify.a r115 = Justify.Companion;
        PreviewData r116 = r102.getValue();
        if (r116 == null) goto L53;
        Integer r117 = r116.getInt();
        if (r117 == null) goto L53;
        r107 = r117.intValue();
    L53:
        r115.getClass();
        this.mainAxisJustify = Justify.a.a(r107);
        goto L6
    L41:
        PreviewData r118 = r102.getValue();
        if (r118 == null) goto L44;
        Padding r119 = r118.getPadding();
    L45:
        this.padding = r119;
        goto L6
    L44:
        r119 = null;
        goto L45
    L33:
        PreviewData r120 = r102.getValue();
        if (r120 == null) goto L38;
        Float r121 = r120.getFloat();
        if (r121 == null) goto L38;
        r109 = r121.floatValue();
    L38:
        this.crossAxisSpacing = r109;
        goto L6
    L25:
        PreviewData r122 = r102.getValue();
        if (r122 == null) goto L30;
        Float r123 = r122.getFloat();
        if (r123 == null) goto L30;
        r109 = r123.floatValue();
    L30:
        this.mainAxisSpacing = r109;
        goto L6
    L17:
        FlexWrap.a r124 = FlexWrap.Companion;
        PreviewData r125 = r102.getValue();
        if (r125 == null) goto L22;
        Integer r126 = r125.getInt();
        if (r126 == null) goto L22;
        r108 = r126.intValue();
    L22:
        r124.getClass();
        this.flexWrap = FlexWrap.a.a(r108);
        goto L6
    L9:
        Orientation.a r127 = Orientation.Companion;
        PreviewData r128 = r102.getValue();
        if (r128 == null) goto L14;
        Integer r129 = r128.getInt();
        if (r129 == null) goto L14;
        r104 = r129.intValue();
    L14:
        r127.getClass();
        this.orientation = Orientation.a.a(r104);
        goto L6
    }

    public final void setCrossAxisAlign(Align r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.crossAxisAlign = r100;
    }

    public final void setCrossAxisSpacing(float r100) {
        this.crossAxisSpacing = r100;
    }

    public final void setFlexWrap(FlexWrap r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.flexWrap = r100;
    }

    public final void setForceUseCompactMode(boolean r100) {
        this.forceUseCompactMode = r100;
    }

    public final void setMainAxisJustify(Justify r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mainAxisJustify = r100;
    }

    public final void setMainAxisSpacing(float r100) {
        this.mainAxisSpacing = r100;
    }

    public final void setOrientation(Orientation r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.orientation = r100;
    }

    public final void setPadding(Padding r100) {
        this.padding = r100;
    }

    public FlexLayoutProperty(Orientation r100, FlexWrap r101, float r102, float r103, Padding r104, Justify r105, Align r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "orientation");
        Intrinsics.checkNotNullParameter(r101, "flexWrap");
        Intrinsics.checkNotNullParameter(r105, "mainAxisJustify");
        Intrinsics.checkNotNullParameter(r106, "crossAxisAlign");
        super(Type.FLEX_LAYOUT);
        this.orientation = r100;
        this.flexWrap = r101;
        this.mainAxisSpacing = r102;
        this.crossAxisSpacing = r103;
        this.padding = r104;
        this.mainAxisJustify = r105;
        this.crossAxisAlign = r106;
        this.forceUseCompactMode = r107;
    }

    public /* synthetic */ FlexLayoutProperty(Orientation r100, FlexWrap r110, float r111, float r112, Padding r113, Justify r114, Align r115, boolean r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 1) == 0) goto L5;
        Orientation r101 = Orientation.ROW;
    L7:
        if ((r117 & 2) == 0) goto L9;
        FlexWrap r102 = FlexWrap.NO_WRAP;
    L10:
        float r103 = 0.0f;
        if ((r117 & 4) == 0) goto L13;
        float r104 = 0.0f;
    L15:
        if ((r117 & 8) != 0) goto L19;
        r103 = r112;
    L19:
        if ((r117 & 16) == 0) goto L21;
        Padding r105 = null;
    L23:
        if ((r117 & 32) == 0) goto L25;
        Justify r106 = Justify.START;
    L27:
        if ((r117 & 64) == 0) goto L29;
        Align r107 = Align.TOP;
    L31:
        if ((r117 & 128) == 0) goto L33;
        boolean r108 = false;
    L34:
        this(r101, r102, r104, r103, r105, r106, r107, r108);
        return;
    L33:
        r108 = r116;
        goto L34
    L29:
        r107 = r115;
        goto L31
    L25:
        r106 = r114;
        goto L27
    L21:
        r105 = r113;
        goto L23
    L13:
        r104 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L10
    L5:
        r101 = r100;
        goto L7
    }
}
