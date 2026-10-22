package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateTaskContainerRefRequest extends Message<UpdateTaskContainerRefRequest, Builder> {
    public static final ProtoAdapter<UpdateTaskContainerRefRequest> ADAPTER = null;
    public static final ProtoAdapter_UpdateTaskContainerRefRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TaskContainerRef new_task_container_ref;
    public final TaskContainerRef old_task_container_ref;

    public static final class Builder extends Message.Builder<UpdateTaskContainerRefRequest, Builder> implements d<UpdateTaskContainerRefRequest> {
        public TaskContainerRef new_task_container_ref;
        public TaskContainerRef old_task_container_ref;

        @Override // com.squareup.wire.Message.Builder
        public UpdateTaskContainerRefRequest build() {
            return new UpdateTaskContainerRefRequest(this.old_task_container_ref, this.new_task_container_ref, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder new_task_container_ref(TaskContainerRef r100) {
            this.new_task_container_ref = r100;
            return this;
        }

        public Builder old_task_container_ref(TaskContainerRef r100) {
            this.old_task_container_ref = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateTaskContainerRefRequest extends ProtoAdapter<UpdateTaskContainerRefRequest> implements c<UpdateTaskContainerRefRequest> {
        public ProtoAdapter_UpdateTaskContainerRefRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateTaskContainerRefRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateTaskContainerRefRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.old_task_container_ref = TaskContainerRef.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.new_task_container_ref = TaskContainerRef.ADAPTER.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpdateTaskContainerRefRequest r100) {
            TaskContainerRef r101 = r100.old_task_container_ref;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TaskContainerRef.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TaskContainerRef r104 = r100.new_task_container_ref;
            if (r104 == null) goto L10;
            r102 = TaskContainerRef.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateTaskContainerRefRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateTaskContainerRefRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateTaskContainerRefRequest r101) throws IOException {
            TaskContainerRef r102 = r101.old_task_container_ref;
            if (r102 == null) goto L5;
            TaskContainerRef.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TaskContainerRef r103 = r101.new_task_container_ref;
            if (r103 == null) goto L8;
            TaskContainerRef.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateTaskContainerRefRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateTaskContainerRefRequest r100 = new ProtoAdapter_UpdateTaskContainerRefRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.old_task_container_ref = this.old_task_container_ref;
        r100.new_task_container_ref = this.new_task_container_ref;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateTaskContainerRefRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateTaskContainerRefRequest(TaskContainerRef r100, TaskContainerRef r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UpdateTaskContainerRefRequest(TaskContainerRef r100, TaskContainerRef r101, ByteString r102) {
        super(ADAPTER, r102);
        this.old_task_container_ref = r100;
        this.new_task_container_ref = r101;
    }
}
