package com.bytedance.hmp;

/* JADX INFO: loaded from: classes19.dex */
public class PixelInfo extends Ptr {
    public ColorModel colorModel() {
        return ColorModel.wrap(Api.pixel_info_color_model(this.ptr), false);
    }

    public ColorTransferCharacteristic colorTransferCharacteristic() {
        return (ColorTransferCharacteristic) EnumUtil.fromValue(ColorTransferCharacteristic.class, Integer.valueOf(Api.pixel_info_primaries(this.ptr)));
    }

    public PixelFormat format() {
        return (PixelFormat) EnumUtil.fromValue(PixelFormat.class, Integer.valueOf(Api.pixel_info_format(this.ptr)));
    }

    public void free() {
        if (this.own == false) goto L6;
        Api.pixel_info_free(this.ptr);
        return;
    }

    public ColorSpace inferSpace() {
        return (ColorSpace) EnumUtil.fromValue(ColorSpace.class, Integer.valueOf(Api.pixel_info_infer_space(this.ptr)));
    }

    public boolean isRgbx() {
        return Api.pixel_info_is_rgbx(this.ptr);
    }

    public ColorPrimaries primaries() {
        return (ColorPrimaries) EnumUtil.fromValue(ColorPrimaries.class, Integer.valueOf(Api.pixel_info_primaries(this.ptr)));
    }

    public ColorRange range() {
        return (ColorRange) EnumUtil.fromValue(ColorRange.class, Integer.valueOf(Api.pixel_info_range(this.ptr)));
    }

    public ColorSpace space() {
        return (ColorSpace) EnumUtil.fromValue(ColorSpace.class, Integer.valueOf(Api.pixel_info_space(this.ptr)));
    }

    public String toString() {
        return Api.pixel_info_stringfy(this.ptr);
    }

    public PixelInfo(PixelFormat r100) {
        this.ptr = Api.pixel_info_make(r100.getValue(), ColorSpace.CS_UNSPECIFIED.getValue(), ColorRange.CR_UNSPECIFIED.getValue());
        this.own = true;
    }

    public PixelInfo(PixelFormat r100, ColorModel r101) {
        this.ptr = Api.pixel_info_make(r100.getValue(), r101.getPtr());
        this.own = true;
    }

    public static PixelInfo wrap(long r100, boolean r101) {
        return new PixelInfo(r100, r101);
    }

    private PixelInfo(long r100, boolean r101) {
        this.ptr = r100;
        this.own = r101;
    }

    public PixelInfo(PixelFormat r100, ColorSpace r101, ColorRange r102) {
        this.ptr = Api.pixel_info_make(r100.getValue(), r101.getValue(), r102.getValue());
        this.own = true;
    }
}
