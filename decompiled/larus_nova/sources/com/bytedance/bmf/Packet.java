package com.bytedance.bmf;

import com.bytedance.hmp.Ptr;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes43.dex */
public class Packet extends Ptr {
    public boolean defined() {
        if (API.bmf_packet_defined(this.ptr) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void free() {
        if (this.own == false) goto L6;
        API.bmf_packet_free(this.ptr);
        return;
    }

    public long timestamp() {
        return API.bmf_packet_timestamp(this.ptr);
    }

    public static Packet generateEofPacket() {
        return wrap(API.bmf_packet_generate_eof_packet(), true);
    }

    public static Packet generateEosPacket() {
        return wrap(API.bmf_packet_generate_eos_packet(), true);
    }

    public Packet(Object r100) {
        if (r100 != null) goto L5;
        this.ptr = 0;
        this.own = false;
        return;
    L5:
        Class<?> r101 = r100.getClass();
        if (r101 != VideoFrame.class) goto L9;
        this.ptr = API.bmf_packet_from_videoframe(((VideoFrame) r100).getPtr());
        this.own = true;
        return;
    L9:
        if (r101 != Packet.class) goto L12;
        this.ptr = ((Packet) r100).getPtr();
        this.own = false;
        return;
    L12:
        if (r101 != JsonParam.class) goto L14;
        this.ptr = API.bmf_packet_from_json_param(((JsonParam) r100).getPtr());
        this.own = true;
        return;
    L14:
        this.ptr = API.bmf_packet_from_json_str(GsonProtectorUtils.toJson(new Gson(), r100));
        this.own = true;
    }

    public Object get(Class r100) throws ClassCastException {
        if (r100 != VideoFrame.class) goto L7;
        return VideoFrame.wrap(API.bmf_packet_get_videoframe(this.ptr), true);
    L7:
        if (r100 != JsonParam.class) goto L11;
        return JsonParam.wrap(API.bmf_packet_get_json_param(this.ptr), true);
    L11:
        if (API.bmf_packet_is_json_param(this.ptr) == false) goto L15;
        String r101 = API.bmf_packet_to_json_str(this.ptr);
        return GsonProtectorUtils.fromJson(new Gson(), r101, r100);
    L15:
        throw new ClassCastException(r100.getName());
    }

    public boolean is(Class r100) {
        if (r100 != VideoFrame.class) goto L7;
        return API.bmf_packet_is_videoframe(this.ptr);
    L7:
        return API.bmf_packet_is_json_param(this.ptr);
    }

    public void setTimestamp(long r100) {
        API.bmf_packet_set_timestamp(this.ptr, r100);
    }

    public Packet(long r100, boolean r101) {
        this.ptr = r100;
        this.own = r101;
    }

    public static Packet wrap(long r100, boolean r101) {
        return new Packet(r100, r101);
    }
}
