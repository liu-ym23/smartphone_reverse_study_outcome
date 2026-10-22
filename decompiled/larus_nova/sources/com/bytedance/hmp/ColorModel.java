package com.bytedance.hmp;

/* JADX INFO: loaded from: classes19.dex */
public class ColorModel extends Ptr {
    public ColorTransferCharacteristic colorTransferCharacteristic() {
        return (ColorTransferCharacteristic) EnumUtil.fromValue(ColorTransferCharacteristic.class, Integer.valueOf(Api.color_model_ctc(this.ptr)));
    }

    public void free() {
        if (this.own == false) goto L6;
        Api.color_model_free(this.ptr);
        return;
    }

    public ColorPrimaries primaries() {
        return (ColorPrimaries) EnumUtil.fromValue(ColorPrimaries.class, Integer.valueOf(Api.color_model_primaries(this.ptr)));
    }

    public ColorRange range() {
        return (ColorRange) EnumUtil.fromValue(ColorRange.class, Integer.valueOf(Api.color_model_range(this.ptr)));
    }

    public ColorSpace space() {
        return (ColorSpace) EnumUtil.fromValue(ColorSpace.class, Integer.valueOf(Api.color_model_space(this.ptr)));
    }

    private ColorModel(long r100, boolean r101) {
        this.ptr = r100;
        this.own = r101;
    }

    public static ColorModel wrap(long r100, boolean r101) {
        return new ColorModel(r100, r101);
    }

    public ColorModel(ColorSpace r100, ColorRange r101, ColorPrimaries r102, ColorTransferCharacteristic r103) {
        this.ptr = Api.color_model_make(r100.getValue(), r101.getValue(), r102.getValue(), r103.getValue());
        this.own = true;
    }
}
