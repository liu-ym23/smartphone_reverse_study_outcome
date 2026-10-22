package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CreateSubTasksResponse extends Message<CreateSubTasksResponse, Builder> {
    public static final ProtoAdapter<CreateSubTasksResponse> ADAPTER = null;
    public static final ProtoAdapter_CreateSubTasksResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Todo> sub_tasks;

    public static final class Builder extends Message.Builder<CreateSubTasksResponse, Builder> implements d<CreateSubTasksResponse> {
        public List<Todo> sub_tasks;

        @Override // com.squareup.wire.Message.Builder
        public CreateSubTasksResponse build() {
            return new CreateSubTasksResponse(this.sub_tasks, super.buildUnknownFields());
        }

        public Builder() {
            this.sub_tasks = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder sub_tasks(List<Todo> r100) {
            Internal.checkElementsNotNull(r100);
            this.sub_tasks = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateSubTasksResponse extends ProtoAdapter<CreateSubTasksResponse> implements c<CreateSubTasksResponse> {
        public ProtoAdapter_CreateSubTasksResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateSubTasksResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateSubTasksResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.sub_tasks.add(Todo.ADAPTER.decode(r100));
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
        public int encodedSize2(CreateSubTasksResponse r100) {
            return Todo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.sub_tasks) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateSubTasksResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateSubTasksResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateSubTasksResponse r101) throws IOException {
            Todo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.sub_tasks);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateSubTasksResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateSubTasksResponse r100 = new ProtoAdapter_CreateSubTasksResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.sub_tasks = Internal.copyOf("sub_tasks", this.sub_tasks);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateSubTasksResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateSubTasksResponse(List<Todo> r100) {
        this(r100, ByteString.EMPTY);
    }

    public CreateSubTasksResponse(List<Todo> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.sub_tasks = Internal.immutableCopyOf("sub_tasks", r100);
    }
}
