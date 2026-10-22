package com.bytedance.bmf;

import com.bytedance.hmp.Ptr;

/* JADX INFO: loaded from: classes43.dex */
public class Task extends Ptr {
    public void free() {
        if (this.own == false) goto L6;
        API.bmf_task_free(this.ptr);
        return;
    }

    public int[] getInputStreamIds() {
        return API.bmf_task_get_input_stream_ids(this.ptr);
    }

    public int[] getOutputStreamIds() {
        return API.bmf_task_get_output_stream_ids(this.ptr);
    }

    public long timestamp() {
        return API.bmf_task_timestamp(this.ptr);
    }

    public Packet popPacketFromInputQueue(int r100) {
        return Packet.wrap(API.bmf_task_pop_packet_from_input_queue(this.ptr, r100), true);
    }

    public Packet popPacketFromOutputQueue(int r100) {
        return Packet.wrap(API.bmf_task_pop_packet_from_out_queue(this.ptr, r100), true);
    }

    public void setTimestamp(long r100) {
        API.bmf_task_set_timestamp(this.ptr, r100);
    }

    public Task(long r100, boolean r101) {
        this.ptr = r100;
        this.own = r101;
    }

    public static Task wrap(long r100, boolean r101) {
        return new Task(r100, r101);
    }

    public void fillInputPacket(int r100, Packet r101) {
        API.bmf_task_fill_input_packet(this.ptr, r100, r101.getPtr());
    }

    public void fillOutputPacket(int r100, Packet r101) {
        API.bmf_task_fill_output_packet(this.ptr, r100, r101.getPtr());
    }

    public Task(int r100, int[] r101, int[] r102) {
        this.ptr = API.bmf_task_make(r100, r101, r102);
        this.own = true;
    }
}
