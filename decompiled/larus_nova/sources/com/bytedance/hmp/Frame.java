package com.bytedance.hmp;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes19.dex */
public class Frame extends Ptr {
    public Frame clone() {
        return wrap(Api.frame_clone(this.ptr), true);
    }

    public boolean defined() {
        return Api.frame_defined(this.ptr);
    }

    public int deviceIndex() {
        return Api.frame_device_index(this.ptr);
    }

    public DeviceType deviceType() {
        return (DeviceType) EnumUtil.fromValue(DeviceType.class, Integer.valueOf(Api.frame_device_type(this.ptr)));
    }

    public ScalarType dtype() {
        return (ScalarType) EnumUtil.fromValue(ScalarType.class, Integer.valueOf(Api.frame_dtype(this.ptr)));
    }

    public PixelFormat format() {
        return (PixelFormat) EnumUtil.fromValue(PixelFormat.class, Integer.valueOf(Api.frame_format(this.ptr)));
    }

    public void free() {
        if (this.own == false) goto L6;
        Api.frame_free(this.ptr);
        return;
    }

    public int height() {
        return Api.frame_height(this.ptr);
    }

    public int nplanes() {
        return Api.frame_nplanes(this.ptr);
    }

    public PixelInfo pixInfo() {
        return PixelInfo.wrap(Api.frame_pix_info(this.ptr), false);
    }

    public String toString() {
        return Api.frame_stringfy(this.ptr);
    }

    public int width() {
        return Api.frame_width(this.ptr);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8360clone() throws CloneNotSupportedException {
        return clone();
    }

    public Frame(Bitmap r100) {
        this.ptr = Api.frame_make(r100);
        this.own = true;
    }

    public void copyFrom(Frame r100) {
        Api.frame_copy_from(this.ptr, r100.getPtr());
    }

    public Tensor plane(int r100) {
        return Tensor.wrap(Api.frame_plane(this.ptr, r100), false);
    }

    public Image toImage(ChannelFormat r100) {
        return Image.wrap(Api.frame_to_image(this.ptr, r100.getValue()), true);
    }

    public void unlock(Bitmap r100) {
        Api.frame_unlock(r100);
    }

    public Frame(Tensor[] r100, PixelInfo r101) {
        long[] r102 = new long[r100.length];
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        r102[r103] = r100[r103].getPtr();
        r103 = r103 + 1;
        goto L4
    L6:
        this.ptr = Api.frame_make(r102, r101.getPtr());
        this.own = true;
    }

    public static Frame fromImage(Image r100, PixelInfo r101) {
        return wrap(Api.frame_from_image(r100.getPtr(), r101.getPtr()), true);
    }

    public static Frame wrap(long r100, boolean r101) {
        return new Frame(r100, r101);
    }

    public Frame to(String r100, boolean r101) {
        return wrap(Api.frame_to_device(this.ptr, r100, r101), true);
    }

    private Frame(long r100, boolean r101) {
        this.ptr = r100;
        this.own = r101;
    }

    public Frame to(Device r100, boolean r101) {
        return to(r100.toString(), r101);
    }

    public Frame(Tensor[] r100, int r101, int r102, PixelInfo r103) {
        long[] r104 = new long[r100.length];
        int r105 = 0;
    L4:
        if (r105 >= r100.length) goto L6;
        r104[r105] = r100[r105].getPtr();
        r105 = r105 + 1;
        goto L4
    L6:
        this.ptr = Api.frame_make(r104, r101, r102, r103.getPtr());
        this.own = true;
    }

    public Frame crop(int r100, int r101, int r102, int r110) {
        return wrap(Api.frame_crop(this.ptr, r100, r101, r102, r110), true);
    }

    public Frame(int r100, int r101, PixelInfo r102, Device r103) {
        this.ptr = Api.frame_make(r100, r101, r102.getPtr(), r103.toString());
        this.own = true;
    }

    public Frame(int r100, int r101, PixelInfo r102, String r103) {
        this.ptr = Api.frame_make(r100, r101, r102.getPtr(), r103);
        this.own = true;
    }
}
