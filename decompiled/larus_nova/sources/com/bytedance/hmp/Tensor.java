package com.bytedance.hmp;

/* JADX INFO: loaded from: classes19.dex */
public class Tensor extends Ptr {
    public Tensor alias() {
        return wrap(Api.tensor_alias(this.ptr), true);
    }

    public Tensor clone() {
        return wrap(Api.tensor_clone(this.ptr), true);
    }

    public long dataPtr() {
        return Api.tensor_data_ptr(this.ptr);
    }

    public boolean defined() {
        return Api.tensor_defined(this.ptr);
    }

    public int deviceIndex() {
        return Api.tensor_device_index(this.ptr);
    }

    public DeviceType deviceType() {
        return (DeviceType) EnumUtil.fromValue(DeviceType.class, Integer.valueOf(Api.tensor_device_type(this.ptr)));
    }

    public long dim() {
        return Api.tensor_dim(this.ptr);
    }

    public ScalarType dtype() {
        return (ScalarType) EnumUtil.fromValue(ScalarType.class, Integer.valueOf(Api.tensor_dtype(this.ptr)));
    }

    public void free() {
        if (this.own == false) goto L6;
        Api.tensor_free(this.ptr);
        return;
    }

    public boolean isContiguous() {
        return Api.tensor_is_contiguous(this.ptr);
    }

    public long itemsize() {
        return Api.tensor_itemsize(this.ptr);
    }

    public long nbytes() {
        return Api.tensor_nbytes(this.ptr);
    }

    public long nitems() {
        return Api.tensor_nitems(this.ptr);
    }

    public String toString() {
        return Api.tensor_stringfy(this.ptr);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8362clone() throws CloneNotSupportedException {
        return clone();
    }

    public void copyFrom(Tensor r100) {
        Api.tensor_copy_from(this.ptr, r100.getPtr());
    }

    public void fill(double r100) {
        Scalar r101 = new Scalar(r100);
        Api.tensor_fill(this.ptr, r101.getPtr());
        r101.free();
    }

    public Tensor permute(long[] r100) {
        return wrap(Api.tensor_permute(this.ptr, r100), true);
    }

    public Tensor reshape(long[] r100) {
        return wrap(Api.tensor_reshape(this.ptr, r100), true);
    }

    public long size(long r100) {
        return Api.tensor_size(this.ptr, r100);
    }

    public Tensor squeeze(long r100) {
        return wrap(Api.tensor_squeeze(this.ptr, r100), true);
    }

    public long stride(long r100) {
        return Api.tensor_stride(this.ptr, r100);
    }

    public Tensor to(ScalarType r100) {
        return wrap(Api.tensor_to_dtype(this.ptr, r100.getValue()), true);
    }

    public void toFile(String r100) {
        Api.tensor_to_file(this.ptr, r100);
    }

    public Tensor unsqueeze(long r100) {
        return wrap(Api.tensor_unsqueeze(this.ptr, r100), true);
    }

    public Tensor view(long[] r100) {
        return wrap(Api.tensor_view(this.ptr, r100), true);
    }

    public void fill(long r100) {
        Scalar r101 = new Scalar(r100);
        Api.tensor_fill(this.ptr, r101.getPtr());
        r101.free();
    }

    public void fill(boolean r100) {
        Scalar r101 = new Scalar(r100);
        Api.tensor_fill(this.ptr, r101.getPtr());
        r101.free();
    }

    public Tensor(long r100, boolean r101) {
        this.ptr = r100;
        this.own = r101;
    }

    public static Tensor wrap(long r100, boolean r101) {
        return new Tensor(r100, r101);
    }

    public Tensor select(long r100, long r101) {
        return wrap(Api.tensor_select(this.ptr, r100, r101), true);
    }

    public Tensor to(String r100, boolean r101) {
        return wrap(Api.tensor_to_device(this.ptr, r100, r101), true);
    }

    public Tensor to(Device r100, boolean r101) {
        return to(r100.toString(), r101);
    }

    public static Tensor empty(long[] r100, ScalarType r101, String r102, boolean r103) {
        return wrap(Api.tensor_empty(r100, r101.getValue(), r102, r103), true);
    }

    public static Tensor fromFile(String r100, ScalarType r101, long r102, long r110) {
        return wrap(Api.tensor_from_file(r100, r101.getValue(), r102, r110), true);
    }

    public Tensor slice(long r110, long r111, long r112, long r113) {
        return wrap(Api.tensor_slice(this.ptr, r110, r111, r112, r113), true);
    }

    public static Tensor empty(long[] r100, ScalarType r101, Device r102, boolean r103) {
        return empty(r100, r101, r102.toString(), r103);
    }

    public static Tensor arange(long r100, long r110, long r111, ScalarType r112, String r113, boolean r114) {
        return wrap(Api.tensor_arange(r100, r110, r111, r112.getValue(), r113, r114), true);
    }

    public static Tensor arange(long r100, long r110, long r111, ScalarType r112, Device r113, boolean r114) {
        return arange(r100, r110, r111, r112, r113.toString(), r114);
    }
}
