package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001)B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J3\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0006HÖ\u0001J\t\u0010(\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/OverSizeTextProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "Ljava/io/Serializable;", "text", "", "numberOfLines", "", "fontSize", "fontWeight", "Lcom/ss/android/lark/chat/preview/entity/component/property/OverSizeTextProperty$FontWeight;", "<init>", "(Ljava/lang/String;IILcom/ss/android/lark/chat/preview/entity/component/property/OverSizeTextProperty$FontWeight;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getNumberOfLines", "()I", "setNumberOfLines", "(I)V", "getFontSize", "setFontSize", "getFontWeight", "()Lcom/ss/android/lark/chat/preview/entity/component/property/OverSizeTextProperty$FontWeight;", "setFontWeight", "(Lcom/ss/android/lark/chat/preview/entity/component/property/OverSizeTextProperty$FontWeight;)V", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "FontWeight", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OverSizeTextProperty extends BaseProperty {
    private int fontSize;
    private FontWeight fontWeight;
    private int numberOfLines;
    private String text;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/OverSizeTextProperty$FontWeight;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "REGULAR", "SEMI_BOLD", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FontWeight extends Enum<FontWeight> {
        public static final a Companion = null;
        public static final FontWeight REGULAR = null;
        public static final FontWeight SEMI_BOLD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FontWeight[] f416255a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416256b = null;
        private int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<FontWeight> getEntries() {
            return f416256b;
        }

        static {
            FontWeight r100 = new FontWeight("REGULAR", 0, 0);
            REGULAR = r100;
            FontWeight r101 = new FontWeight("SEMI_BOLD", 1, 1);
            SEMI_BOLD = r101;
            FontWeight[] r102 = {r100, r101};
            f416255a = r102;
            f416256b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static FontWeight[] values() {
            return (FontWeight[]) f416255a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FontWeight valueOf(String r100) {
            return (FontWeight) r27.a.a(FontWeight.class, r100);
        }

        public final void setValue(int r100) {
            this.value = r100;
        }

        public FontWeight(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public OverSizeTextProperty() {
        this(null, 0, 0, null, 15, null);
    }

    public static /* synthetic */ OverSizeTextProperty copy$default(OverSizeTextProperty r100, String r101, int r102, int r103, FontWeight r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.numberOfLines;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.fontSize;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.fontWeight;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.numberOfLines;
    }

    public final int component3() {
        return this.fontSize;
    }

    public final FontWeight component4() {
        return this.fontWeight;
    }

    public final OverSizeTextProperty copy(String r100, int r101, int r102, FontWeight r103) {
        Intrinsics.checkNotNullParameter(r103, "fontWeight");
        return new OverSizeTextProperty(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OverSizeTextProperty) == true) goto L8;
        return false;
    L8:
        OverSizeTextProperty r101 = (OverSizeTextProperty) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (this.numberOfLines == r101.numberOfLines) goto L15;
        return false;
    L15:
        if (this.fontSize == r101.fontSize) goto L18;
        return false;
    L18:
        if (this.fontWeight == r101.fontWeight) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        String r100 = this.text;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((r101 * 31) + this.numberOfLines) * 31) + this.fontSize) * 31) + this.fontWeight.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "OverSizeTextProperty(text=" + this.text + ", numberOfLines=" + this.numberOfLines + ", fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ')';
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final int getNumberOfLines() {
        return this.numberOfLines;
    }

    public final String getText() {
        return this.text;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r101 = r100.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L47;
        Map.Entry<Integer, PreviewData> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        if (r103 == ComponentAttribute.text.getValue()) goto L9;
        int r104 = 0;
        if (r103 == ComponentAttribute.number_of_lines.getValue()) goto L17;
        if (r103 == ComponentAttribute.font_size.getValue()) goto L25;
        if (r103 != ComponentAttribute.font_weight.getValue()) goto L6;
        FontWeight.a r105 = FontWeight.Companion;
        PreviewData r106 = r102.getValue();
        if (r106 == null) goto L39;
        Integer r107 = r106.getInt();
        if (r107 == null) goto L39;
        r104 = r107.intValue();
    L39:
        r105.getClass();
        if (r104 != 0) goto L42;
        FontWeight r108 = FontWeight.REGULAR;
    L46:
        this.fontWeight = r108;
        goto L6
    L42:
        if (r104 == 1) goto L44;
        r108 = FontWeight.REGULAR;
        goto L46
    L44:
        r108 = FontWeight.SEMI_BOLD;
        goto L46
    L25:
        PreviewData r109 = r102.getValue();
        if (r109 == null) goto L30;
        Integer r110 = r109.getInt();
        if (r110 == null) goto L30;
        int r111 = r110.intValue();
    L31:
        this.fontSize = r111;
    L30:
        r111 = 36;
        goto L31
    L17:
        PreviewData r112 = r102.getValue();
        if (r112 == null) goto L22;
        Integer r113 = r112.getInt();
        if (r113 == null) goto L22;
        r104 = r113.intValue();
    L22:
        this.numberOfLines = r104;
        goto L6
    L9:
        PreviewData r114 = r102.getValue();
        if (r114 == null) goto L13;
        String r115 = r114.getString();
        if (r115 == null) goto L13;
    L14:
        this.text = r115;
    L13:
        r115 = "";
        goto L14
    }

    public final void setFontSize(int r100) {
        this.fontSize = r100;
    }

    public final void setFontWeight(FontWeight r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fontWeight = r100;
    }

    public final void setNumberOfLines(int r100) {
        this.numberOfLines = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public OverSizeTextProperty(String r100, int r101, int r102, FontWeight r103) {
        Intrinsics.checkNotNullParameter(r103, "fontWeight");
        super(Type.OVERSIZED_TEXT);
        this.text = r100;
        this.numberOfLines = r101;
        this.fontSize = r102;
        this.fontWeight = r103;
    }

    public /* synthetic */ OverSizeTextProperty(String r100, int r101, int r102, FontWeight r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 36;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = FontWeight.REGULAR;
    L14:
        this(r100, r101, r102, r103);
    }
}
