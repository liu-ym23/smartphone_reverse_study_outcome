package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetTasksResponse extends Message<GetTasksResponse, Builder> {
    public static final ProtoAdapter<GetTasksResponse> ADAPTER = null;
    public static final ProtoAdapter_GetTasksResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, SimpleTodo> ancestors;
    public final List<Todo> tasks;

    public static final class Builder extends Message.Builder<GetTasksResponse, Builder> implements d<GetTasksResponse> {
        public Map<String, SimpleTodo> ancestors;
        public List<Todo> tasks;

        @Override // com.squareup.wire.Message.Builder
        public GetTasksResponse build() {
            return new GetTasksResponse(this.tasks, this.ancestors, super.buildUnknownFields());
        }

        public Builder() {
            this.tasks = Internal.newMutableList();
            this.ancestors = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ancestors(Map<String, SimpleTodo> r100) {
            Internal.checkElementsNotNull(r100);
            this.ancestors = r100;
            return this;
        }

        public Builder tasks(List<Todo> r100) {
            Internal.checkElementsNotNull(r100);
            this.tasks = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTasksResponse extends ProtoAdapter<GetTasksResponse> implements c<GetTasksResponse> {
        private final ProtoAdapter<Map<String, SimpleTodo>> ancestors;

        public ProtoAdapter_GetTasksResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTasksResponse.class);
            this.ancestors = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, SimpleTodo.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTasksResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.tasks.add(Todo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.ancestors.putAll(this.ancestors.decode(r100));
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
        public int encodedSize2(GetTasksResponse r100) {
            return (Todo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.tasks) + this.ancestors.encodedSizeWithTag(2, r100.ancestors)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTasksResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTasksResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTasksResponse r101) throws IOException {
            Todo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.tasks);
            this.ancestors.encodeWithTag(r100, 2, r101.ancestors);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTasksResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetTasksResponse r100 = new ProtoAdapter_GetTasksResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tasks = Internal.copyOf("tasks", this.tasks);
        r100.ancestors = Internal.copyOf("ancestors", this.ancestors);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetTasksResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTasksResponse(List<Todo> r100, Map<String, SimpleTodo> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetTasksResponse(List<Todo> r100, Map<String, SimpleTodo> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.tasks = Internal.immutableCopyOf("tasks", r100);
        this.ancestors = Internal.immutableCopyOf("ancestors", r101);
    }
}
