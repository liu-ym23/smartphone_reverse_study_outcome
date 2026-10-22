package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerItemType;", "", "<init>", "(Ljava/lang/String;I)V", "TITLE", "COLOR_ITEM", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ColorPickerItemType extends Enum<ColorPickerItemType> {
    public static final ColorPickerItemType COLOR_ITEM = null;
    public static final ColorPickerItemType TITLE = null;
    public static final /* synthetic */ ColorPickerItemType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ColorPickerItemType> getEntries() {
        return b;
    }

    static {
        ColorPickerItemType r0 = new ColorPickerItemType("TITLE", 0);
        TITLE = r0;
        ColorPickerItemType r1 = new ColorPickerItemType("COLOR_ITEM", 1);
        COLOR_ITEM = r1;
        ColorPickerItemType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ColorPickerItemType[] values() {
        return (ColorPickerItemType[]) a.clone();
    }

    public static ColorPickerItemType valueOf(String r1) {
        return (ColorPickerItemType) r27.a.a(ColorPickerItemType.class, r1);
    }

    public ColorPickerItemType(String r1, int r2) {
        super(r1, r2);
    }
}
