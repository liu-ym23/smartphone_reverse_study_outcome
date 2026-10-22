package com.bytedance.hmp;

/* JADX INFO: loaded from: classes19.dex */
public class Stream extends Ptr {

    public class Guard extends Ptr {
        final /* synthetic */ Stream this$0;

        public void free() {
            if (this.own == false) goto L6;
            Api.stream_guard_free(this.ptr);
            return;
        }

        public Guard(Stream r100) {
            this.this$0 = r100;
            this.ptr = Api.stream_guard_create(r100.ptr);
            this.own = true;
        }
    }

    public int deviceIndex() {
        return Api.stream_device_index(this.ptr);
    }

    public DeviceType deviceType() {
        return (DeviceType) EnumUtil.fromValue(DeviceType.class, Integer.valueOf(Api.stream_device_type(this.ptr)));
    }

    public void free() {
        if (this.own == false) goto L6;
        Api.stream_free(this.ptr);
        return;
    }

    public long handle() {
        return Api.stream_handle(this.ptr);
    }

    public boolean query() {
        return Api.stream_query(this.ptr);
    }

    public void synchronize() {
        Api.stream_synchronize(this.ptr);
    }

    public static Stream current(DeviceType r100) {
        return wrap(Api.stream_current(r100.getValue()), true);
    }

    public static void setCurrent(Stream r100) {
        Api.stream_set_current(r100.ptr);
    }

    public Stream(DeviceType r100, long r101) {
        this.ptr = Api.stream_make(r100.getValue(), r101);
        this.own = true;
    }

    public static Stream wrap(long r100, boolean r101) {
        return new Stream(r100, r101);
    }

    public Stream(long r100, boolean r101) {
        this.ptr = r100;
        this.own = r101;
    }
}
