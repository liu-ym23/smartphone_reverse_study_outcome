package com.bytedance.locallife.dito.common.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u00010BU\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b-\u0010.J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\f\u001a\u00020\u0002HÆ\u0003J\t\u0010\r\u001a\u00020\u0002HÆ\u0003JW\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0016\u001a\u00020\nHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b+\u0010\u001eR\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b,\u0010\u001e¨\u00061"}, d2 = {"Lcom/bytedance/locallife/dito/common/data/DitoImageTextData;", "Ljava/io/Serializable;", "", "component1", "Lcom/bytedance/locallife/dito/common/data/DitoIconData;", "component2", "Lcom/bytedance/locallife/dito/common/data/DitoToolbarStyle;", "component3", "Lcom/bytedance/locallife/dito/common/data/DitoTextData;", "component4", "", "component5", "component6", "component7", "type", "icon", "style", "text", "clickEvent", "height", "width", "copy", "toString", "hashCode", "", "other", "", "equals", "I", "getType", "()I", "Lcom/bytedance/locallife/dito/common/data/DitoIconData;", "getIcon", "()Lcom/bytedance/locallife/dito/common/data/DitoIconData;", "Lcom/bytedance/locallife/dito/common/data/DitoToolbarStyle;", "getStyle", "()Lcom/bytedance/locallife/dito/common/data/DitoToolbarStyle;", "Lcom/bytedance/locallife/dito/common/data/DitoTextData;", "getText", "()Lcom/bytedance/locallife/dito/common/data/DitoTextData;", "Ljava/lang/String;", "getClickEvent", "()Ljava/lang/String;", "getHeight", "getWidth", "<init>", "(ILcom/bytedance/locallife/dito/common/data/DitoIconData;Lcom/bytedance/locallife/dito/common/data/DitoToolbarStyle;Lcom/bytedance/locallife/dito/common/data/DitoTextData;Ljava/lang/String;II)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoImageTextData implements Serializable {
    public static final a Companion = null;
    public static final int TYPE_BUTTON_TEXT = 2;
    public static final int TYPE_FILTER_TEXT = 4;
    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_PRIMARY_TEXT = 3;
    public static final int TYPE_TEXT = 1;

    @SerializedName("clickEvent")
    private final String clickEvent;
    private final int height;
    private final DitoIconData icon;
    private final DitoToolbarStyle style;
    private final DitoTextData text;
    private final int type;
    private final int width;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DitoImageTextData() {
        this(0, null, null, null, null, 0, 0, 127, null);
    }

    public static /* synthetic */ DitoImageTextData copy$default(DitoImageTextData r100, int r101, DitoIconData r102, DitoToolbarStyle r103, DitoTextData r104, String r110, int r111, int r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.icon;
    L8:
        DitoIconData r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.style;
    L11:
        DitoToolbarStyle r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.text;
    L14:
        DitoTextData r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.clickEvent;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.height;
    L20:
        int r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.width;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.type;
    }

    public final DitoIconData component2() {
        return this.icon;
    }

    public final DitoToolbarStyle component3() {
        return this.style;
    }

    public final DitoTextData component4() {
        return this.text;
    }

    public final String component5() {
        return this.clickEvent;
    }

    public final int component6() {
        return this.height;
    }

    public final int component7() {
        return this.width;
    }

    public final DitoImageTextData copy(int r110, DitoIconData r111, DitoToolbarStyle r112, DitoTextData r113, String r114, int r115, int r116) {
        return new DitoImageTextData(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DitoImageTextData) == true) goto L8;
        return false;
    L8:
        DitoImageTextData r101 = (DitoImageTextData) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.clickEvent, r101.clickEvent) == true) goto L24;
        return false;
    L24:
        if (this.height == r101.height) goto L27;
        return false;
    L27:
        if (this.width == r101.width) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = this.type * 31;
        DitoIconData r101 = this.icon;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        DitoToolbarStyle r105 = this.style;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        DitoTextData r108 = this.text;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.clickEvent;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return ((((r110 + r102) * 31) + this.height) * 31) + this.width;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "DitoImageTextData(type=" + this.type + ", icon=" + this.icon + ", style=" + this.style + ", text=" + this.text + ", clickEvent=" + this.clickEvent + ", height=" + this.height + ", width=" + this.width + ')';
    }

    public final String getClickEvent() {
        return this.clickEvent;
    }

    public final int getHeight() {
        return this.height;
    }

    public final DitoIconData getIcon() {
        return this.icon;
    }

    public final DitoToolbarStyle getStyle() {
        return this.style;
    }

    public final DitoTextData getText() {
        return this.text;
    }

    public final int getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public DitoImageTextData(int r100, DitoIconData r101, DitoToolbarStyle r102, DitoTextData r103, String r104, int r105, int r106) {
        this.type = r100;
        this.icon = r101;
        this.style = r102;
        this.text = r103;
        this.clickEvent = r104;
        this.height = r105;
        this.width = r106;
    }

    public /* synthetic */ DitoImageTextData(int r100, DitoIconData r101, DitoToolbarStyle r102, DitoTextData r110, String r111, int r112, int r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        int r116 = 0;
    L6:
        String r103 = null;
        if ((r114 & 2) == 0) goto L9;
        DitoIconData r104 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        DitoToolbarStyle r105 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        DitoTextData r106 = null;
    L19:
        if ((r114 & 16) != 0) goto L23;
        r103 = r111;
    L23:
        if ((r114 & 32) == 0) goto L25;
        int r107 = 0;
    L27:
        if ((r114 & 64) == 0) goto L29;
        int r117 = 0;
    L30:
        this(r116, r104, r105, r106, r103, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L17:
        r106 = r110;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L6
    }
}
