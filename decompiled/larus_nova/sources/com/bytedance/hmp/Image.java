package com.bytedance.hmp;

/* JADX INFO: loaded from: classes19.dex */
public class Image extends Ptr {
    public int cdim() {
        return Api.image_cdim(this.ptr);
    }

    public Image clone() {
        return wrap(Api.image_clone(this.ptr), true);
    }

    public ColorModel colorModel() {
        return ColorModel.wrap(Api.image_color_model(this.ptr), false);
    }

    public Tensor data() {
        return Tensor.wrap(Api.image_data(this.ptr), false);
    }

    public boolean defined() {
        return Api.image_defined(this.ptr);
    }

    public int deviceIndex() {
        return Api.image_device_index(this.ptr);
    }

    public DeviceType deviceType() {
        return (DeviceType) EnumUtil.fromValue(DeviceType.class, Integer.valueOf(Api.image_device_type(this.ptr)));
    }

    public ScalarType dtype() {
        return (ScalarType) EnumUtil.fromValue(ScalarType.class, Integer.valueOf(Api.image_dtype(this.ptr)));
    }

    public void free() {
        if (this.own == false) goto L6;
        Api.image_free(this.ptr);
        return;
    }

    public int hdim() {
        return Api.image_hdim(this.ptr);
    }

    public int height() {
        return Api.image_height(this.ptr);
    }

    public int nchannels() {
        return Api.image_nchannels(this.ptr);
    }

    public String toString() {
        return Api.image_stringfy(this.ptr);
    }

    public int wdim() {
        return Api.image_wdim(this.ptr);
    }

    public int width() {
        return Api.image_width(this.ptr);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8361clone() throws CloneNotSupportedException {
        return clone();
    }

    public void copyFrom(Image r100) {
        Api.image_copy_from(this.ptr, r100.getPtr());
    }

    public void setColorModel(ColorModel r100) {
        Api.image_set_color_model(this.ptr, r100.getPtr());
    }

    public Image(Tensor r100, ChannelFormat r101) {
        this.ptr = Api.image_make(r100.getPtr(), r101.getValue());
        this.own = true;
    }

    public static Image wrap(long r100, boolean r101) {
        return new Image(r100, r101);
    }

    public Image to(String r100, boolean r101) {
        return wrap(Api.image_to_device(this.ptr, r100, r101), true);
    }

    private Image(long r100, boolean r101) {
        this.ptr = r100;
        this.own = r101;
    }

    public Image to(Device r100, boolean r101) {
        return to(r100.toString(), r101);
    }

    public Image(Tensor r100, ChannelFormat r101, ColorModel r102) {
        this.ptr = Api.image_make(r100.getPtr(), r101.getValue(), r102.getPtr());
        this.own = true;
    }

    public Image crop(int r100, int r101, int r102, int r110) {
        return wrap(Api.image_crop(this.ptr, r100, r101, r102, r110), true);
    }

    public Image(int r100, int r101, int r110, ChannelFormat r111, ScalarType r112, String r113, boolean r114) {
        this.ptr = Api.image_make(r100, r101, r110, r111.getValue(), r112.getValue(), r113, r114);
        this.own = true;
    }
}
