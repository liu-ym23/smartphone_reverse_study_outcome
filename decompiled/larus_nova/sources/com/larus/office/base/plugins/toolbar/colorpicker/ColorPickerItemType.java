package com.larus.office.base.plugins.toolbar.colorpicker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/colorpicker/ColorPickerItemType;", "", "<init>", "(Ljava/lang/String;I)V", "TITLE", "COLOR_ITEM", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ColorPickerItemType extends Enum<ColorPickerItemType> {
    public static final ColorPickerItemType COLOR_ITEM = null;
    public static final ColorPickerItemType TITLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ColorPickerItemType[] f360841a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360842b = null;

    public static EnumEntries<ColorPickerItemType> getEntries() {
        return f360842b;
    }

    static {
        ColorPickerItemType r100 = new ColorPickerItemType("TITLE", 0);
        TITLE = r100;
        ColorPickerItemType r101 = new ColorPickerItemType("COLOR_ITEM", 1);
        COLOR_ITEM = r101;
        ColorPickerItemType[] r102 = {r100, r101};
        f360841a = r102;
        f360842b = EnumEntriesKt.enumEntries(r102);
    }

    public static ColorPickerItemType[] values() {
        return (ColorPickerItemType[]) f360841a.clone();
    }

    public static ColorPickerItemType valueOf(String r100) {
        return (ColorPickerItemType) r27.a.a(ColorPickerItemType.class, r100);
    }

    public ColorPickerItemType(String r100, int r101) {
        super(r100, r101);
    }
}
