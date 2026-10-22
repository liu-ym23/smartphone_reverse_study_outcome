package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerStyle;", "", "<init>", "(Ljava/lang/String;I)V", "FONT_COLOR", "HIGHLIGHT", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ColorPickerStyle extends Enum<ColorPickerStyle> {
    public static final ColorPickerStyle FONT_COLOR = null;
    public static final ColorPickerStyle HIGHLIGHT = null;
    public static final /* synthetic */ ColorPickerStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ColorPickerStyle> getEntries() {
        return b;
    }

    static {
        ColorPickerStyle r0 = new ColorPickerStyle("FONT_COLOR", 0);
        FONT_COLOR = r0;
        ColorPickerStyle r1 = new ColorPickerStyle("HIGHLIGHT", 1);
        HIGHLIGHT = r1;
        ColorPickerStyle[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ColorPickerStyle[] values() {
        return (ColorPickerStyle[]) a.clone();
    }

    public static ColorPickerStyle valueOf(String r1) {
        return (ColorPickerStyle) r27.a.a(ColorPickerStyle.class, r1);
    }

    public ColorPickerStyle(String r1, int r2) {
        super(r1, r2);
    }
}
