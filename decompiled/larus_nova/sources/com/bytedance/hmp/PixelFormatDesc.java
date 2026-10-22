package com.bytedance.hmp;

/* JADX INFO: loaded from: classes19.dex */
public class PixelFormatDesc extends Ptr {
    public ScalarType dtype() {
        return (ScalarType) EnumUtil.fromValue(ScalarType.class, Integer.valueOf(Api.pixel_format_desc_dtype(this.ptr)));
    }

    public int format() {
        return Api.pixel_format_desc_format(this.ptr);
    }

    public void free() {
        if (this.own == false) goto L6;
        Api.pixel_format_desc_free(this.ptr);
        return;
    }

    public int nplanes() {
        return Api.pixel_format_desc_nplanes(this.ptr);
    }

    public PixelFormatDesc(PixelFormat r100) {
        this.ptr = Api.pixel_format_desc_make(r100.getValue());
        this.own = true;
    }

    public int channels(int r100) {
        return Api.pixel_format_desc_channels(this.ptr, r100);
    }

    private PixelFormatDesc(long r100, boolean r101) {
        this.ptr = r100;
        this.own = r101;
    }

    public static PixelFormatDesc wrap(long r100, boolean r101) {
        return new PixelFormatDesc(r100, r101);
    }

    public int infer_height(int r100, int r101) {
        return Api.pixel_format_desc_infer_height(this.ptr, r100, r101);
    }

    public int infer_nitems(int r100, int r101) {
        return Api.pixel_format_desc_infer_nitems(this.ptr, r100, r101);
    }

    public int infer_width(int r100, int r101) {
        return Api.pixel_format_desc_infer_width(this.ptr, r100, r101);
    }

    public int infer_nitems(int r100, int r101, int r102) {
        return Api.pixel_format_desc_infer_nitems(this.ptr, r100, r101, r102);
    }
}
