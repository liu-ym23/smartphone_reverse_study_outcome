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
public final class UpdateTaskContainerRefResponse extends Message<UpdateTaskContainerRefResponse, Builder> {
    public static final ProtoAdapter<UpdateTaskContainerRefResponse> ADAPTER = null;
    public static final ProtoAdapter_UpdateTaskContainerRefResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TaskContainerRef task_container_ref;

    public static final class Builder extends Message.Builder<UpdateTaskContainerRefResponse, Builder> implements d<UpdateTaskContainerRefResponse> {
        public TaskContainerRef task_container_ref;

        @Override // com.squareup.wire.Message.Builder
        public UpdateTaskContainerRefResponse build() {
            return new UpdateTaskContainerRefResponse(this.task_container_ref, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder task_container_ref(TaskContainerRef r100) {
            this.task_container_ref = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateTaskContainerRefResponse extends ProtoAdapter<UpdateTaskContainerRefResponse> implements c<UpdateTaskContainerRefResponse> {
        public ProtoAdapter_UpdateTaskContainerRefResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateTaskContainerRefResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateTaskContainerRefResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.task_container_ref = TaskContainerRef.ADAPTER.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpdateTaskContainerRefResponse r100) {
            TaskContainerRef r101 = r100.task_container_ref;
            if (r101 == null) goto L5;
            int r102 = TaskContainerRef.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateTaskContainerRefResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateTaskContainerRefResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateTaskContainerRefResponse r101) throws IOException {
            TaskContainerRef r102 = r101.task_container_ref;
            if (r102 == null) goto L5;
            TaskContainerRef.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateTaskContainerRefResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateTaskContainerRefResponse r100 = new ProtoAdapter_UpdateTaskContainerRefResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task_container_ref = this.task_container_ref;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateTaskContainerRefResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateTaskContainerRefResponse(TaskContainerRef r100) {
        this(r100, ByteString.EMPTY);
    }

    public UpdateTaskContainerRefResponse(TaskContainerRef r100, ByteString r101) {
        super(ADAPTER, r101);
        this.task_container_ref = r100;
    }
}
