package com.bytedance.hmp;

/* JADX INFO: loaded from: classes19.dex */
public class Device extends Ptr {

    public class Guard extends Ptr {
        final /* synthetic */ Device this$0;

        public void free() {
            if (this.own == false) goto L6;
            Api.device_guard_free(this.ptr);
            return;
        }

        public Guard(Device r100) {
            this.this$0 = r100;
            this.ptr = Api.device_guard_make(r100.ptr);
            this.own = true;
        }
    }

    public static boolean hasCuda() {
        if (count(DeviceType.kCUDA) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void free() {
        if (this.own == false) goto L6;
        Api.device_free(this.ptr);
        return;
    }

    public int index() {
        return Api.device_index(this.ptr);
    }

    public String toString() {
        return Api.device_stringfy(this.ptr);
    }

    public DeviceType type() {
        return (DeviceType) EnumUtil.fromValue(DeviceType.class, Integer.valueOf(Api.device_type(this.ptr)));
    }

    public Device() {
        this.ptr = Api.device_make("");
        this.own = true;
    }

    public Device(String r100) {
        this.ptr = Api.device_make(r100);
        this.own = true;
    }

    public static int count(DeviceType r100) {
        return Api.device_count(r100.getValue());
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Device) == false) goto L14;
        Device r101 = (Device) r100;
        if (type() == r101.type()) goto L10;
    L12:
        return false;
    L10:
        if (index() != r101.index()) goto L12;
        return true;
    L14:
        return false;
    }

    public Device(DeviceType r100, int r101) {
        this.ptr = Api.device_make(r100.getValue(), r101);
        this.own = true;
    }

    public static Device wrap(long r100, boolean r101) {
        return new Device(r100, r101);
    }

    private Device(long r100, boolean r101) {
        this.ptr = r100;
        this.own = r101;
    }
}
