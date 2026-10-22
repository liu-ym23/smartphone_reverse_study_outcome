package org.apache.commons.imaging.palette;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
final enum ColorComponent extends Enum<ColorComponent> {
    private static final /* synthetic */ ColorComponent[] $VALUES = null;
    public static final ColorComponent ALPHA = null;
    public static final ColorComponent BLUE = null;
    public static final ColorComponent GREEN = null;
    public static final ColorComponent RED = null;
    private final int shift;

    static {
        ColorComponent r100 = new ColorComponent("ALPHA", 0, 24);
        ALPHA = r100;
        ColorComponent r101 = new ColorComponent("RED", 1, 16);
        RED = r101;
        ColorComponent r102 = new ColorComponent("GREEN", 2, 8);
        GREEN = r102;
        ColorComponent r103 = new ColorComponent("BLUE", 3, 0);
        BLUE = r103;
        $VALUES = new ColorComponent[]{r100, r101, r102, r103};
    }

    public static ColorComponent[] values() {
        return (ColorComponent[]) $VALUES.clone();
    }

    public static ColorComponent valueOf(String r100) {
        return (ColorComponent) a.a(ColorComponent.class, r100);
    }

    public int argbComponent(int r100) {
        return (r100 >> this.shift) & 255;
    }

    private ColorComponent(String r100, int r101, int r102) {
        super(r100, r101);
        this.shift = r102;
    }
}
