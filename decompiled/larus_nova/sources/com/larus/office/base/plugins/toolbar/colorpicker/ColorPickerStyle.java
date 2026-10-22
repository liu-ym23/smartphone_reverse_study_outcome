package com.larus.office.base.plugins.toolbar.colorpicker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/colorpicker/ColorPickerStyle;", "", "<init>", "(Ljava/lang/String;I)V", "FONT_COLOR", "HIGHLIGHT", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ColorPickerStyle extends Enum<ColorPickerStyle> {
    public static final ColorPickerStyle FONT_COLOR = null;
    public static final ColorPickerStyle HIGHLIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ColorPickerStyle[] f360843a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360844b = null;

    public static EnumEntries<ColorPickerStyle> getEntries() {
        return f360844b;
    }

    static {
        ColorPickerStyle r100 = new ColorPickerStyle("FONT_COLOR", 0);
        FONT_COLOR = r100;
        ColorPickerStyle r101 = new ColorPickerStyle("HIGHLIGHT", 1);
        HIGHLIGHT = r101;
        ColorPickerStyle[] r102 = {r100, r101};
        f360843a = r102;
        f360844b = EnumEntriesKt.enumEntries(r102);
    }

    public static ColorPickerStyle[] values() {
        return (ColorPickerStyle[]) f360843a.clone();
    }

    public static ColorPickerStyle valueOf(String r100) {
        return (ColorPickerStyle) r27.a.a(ColorPickerStyle.class, r100);
    }

    public ColorPickerStyle(String r100, int r101) {
        super(r100, r101);
    }
}
