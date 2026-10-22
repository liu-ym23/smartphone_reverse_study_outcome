package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/ColorPickerItemType;", "", "<init>", "(Ljava/lang/String;I)V", "TITLE", "COLOR_ITEM", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ColorPickerItemType extends Enum<ColorPickerItemType> {
    public static final ColorPickerItemType COLOR_ITEM = null;
    public static final ColorPickerItemType TITLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ColorPickerItemType[] f238635a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f238636b = null;

    public static EnumEntries<ColorPickerItemType> getEntries() {
        return f238636b;
    }

    static {
        ColorPickerItemType r100 = new ColorPickerItemType("TITLE", 0);
        TITLE = r100;
        ColorPickerItemType r101 = new ColorPickerItemType("COLOR_ITEM", 1);
        COLOR_ITEM = r101;
        ColorPickerItemType[] r102 = {r100, r101};
        f238635a = r102;
        f238636b = EnumEntriesKt.enumEntries(r102);
    }

    public static ColorPickerItemType[] values() {
        return (ColorPickerItemType[]) f238635a.clone();
    }

    public static ColorPickerItemType valueOf(String r100) {
        return (ColorPickerItemType) r27.a.a(ColorPickerItemType.class, r100);
    }

    public ColorPickerItemType(String r100, int r101) {
        super(r100, r101);
    }
}
