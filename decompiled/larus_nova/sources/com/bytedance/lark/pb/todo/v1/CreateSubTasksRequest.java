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
public final class CreateSubTasksRequest extends Message<CreateSubTasksRequest, Builder> {
    public static final ProtoAdapter<CreateSubTasksRequest> ADAPTER = null;
    public static final String DEFAULT_ANCESTOR_GUID = "";
    public static final ProtoAdapter_CreateSubTasksRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String ancestor_guid;
    public final List<Todo> sub_tasks;

    public static final class Builder extends Message.Builder<CreateSubTasksRequest, Builder> implements d<CreateSubTasksRequest> {
        public String ancestor_guid;
        public List<Todo> sub_tasks;

        @Override // com.squareup.wire.Message.Builder
        public CreateSubTasksRequest build() {
            return new CreateSubTasksRequest(this.ancestor_guid, this.sub_tasks, super.buildUnknownFields());
        }

        public Builder() {
            this.sub_tasks = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ancestor_guid(String r100) {
            this.ancestor_guid = r100;
            return this;
        }

        public Builder sub_tasks(List<Todo> r100) {
            Internal.checkElementsNotNull(r100);
            this.sub_tasks = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateSubTasksRequest extends ProtoAdapter<CreateSubTasksRequest> implements c<CreateSubTasksRequest> {
        public ProtoAdapter_CreateSubTasksRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateSubTasksRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateSubTasksRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.ancestor_guid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.ancestor_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.sub_tasks.add(Todo.ADAPTER.decode(r100));
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
        public int encodedSize2(CreateSubTasksRequest r100) {
            String r101 = r100.ancestor_guid;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + Todo.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.sub_tasks)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateSubTasksRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateSubTasksRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateSubTasksRequest r101) throws IOException {
            String r102 = r101.ancestor_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Todo.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.sub_tasks);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateSubTasksRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateSubTasksRequest r100 = new ProtoAdapter_CreateSubTasksRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ancestor_guid = this.ancestor_guid;
        r100.sub_tasks = Internal.copyOf("sub_tasks", this.sub_tasks);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateSubTasksRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateSubTasksRequest(String r100, List<Todo> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CreateSubTasksRequest(String r100, List<Todo> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.ancestor_guid = r100;
        this.sub_tasks = Internal.immutableCopyOf("sub_tasks", r101);
    }
}
