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
public final class GetPagingSubTaskResponse extends Message<GetPagingSubTaskResponse, Builder> {
    public static final ProtoAdapter<GetPagingSubTaskResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final String DEFAULT_LAST_TOKEN = "";
    public static final ProtoAdapter_GetPagingSubTaskResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Long> guid_to_position;
    public final Boolean has_more;
    public final String last_token;
    public final Map<String, String> sub_task_ranks;
    public final List<Todo> sub_tasks;

    public static final class Builder extends Message.Builder<GetPagingSubTaskResponse, Builder> implements d<GetPagingSubTaskResponse> {
        public Map<String, Long> guid_to_position;
        public Boolean has_more;
        public String last_token;
        public Map<String, String> sub_task_ranks;
        public List<Todo> sub_tasks;

        @Override // com.squareup.wire.Message.Builder
        public GetPagingSubTaskResponse build() {
            return new GetPagingSubTaskResponse(this.sub_tasks, this.guid_to_position, this.has_more, this.last_token, this.sub_task_ranks, super.buildUnknownFields());
        }

        public Builder() {
            this.sub_tasks = Internal.newMutableList();
            this.guid_to_position = Internal.newMutableMap();
            this.sub_task_ranks = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder guid_to_position(Map<String, Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.guid_to_position = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder last_token(String r100) {
            this.last_token = r100;
            return this;
        }

        public Builder sub_task_ranks(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.sub_task_ranks = r100;
            return this;
        }

        public Builder sub_tasks(List<Todo> r100) {
            Internal.checkElementsNotNull(r100);
            this.sub_tasks = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetPagingSubTaskResponse extends ProtoAdapter<GetPagingSubTaskResponse> implements c<GetPagingSubTaskResponse> {
        private final ProtoAdapter<Map<String, Long>> guid_to_position;
        private final ProtoAdapter<Map<String, String>> sub_task_ranks;

        public ProtoAdapter_GetPagingSubTaskResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetPagingSubTaskResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.guid_to_position = ProtoAdapter.newMapAdapter(r100, ProtoAdapter.INT64);
            this.sub_task_ranks = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetPagingSubTaskResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.has_more = Boolean.FALSE;
            r101.last_token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.sub_tasks.add(Todo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.guid_to_position.putAll(this.guid_to_position.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.last_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.sub_task_ranks.putAll(this.sub_task_ranks.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetPagingSubTaskResponse r100) {
            int r101 = Todo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.sub_tasks) + this.guid_to_position.encodedSizeWithTag(2, r100.guid_to_position);
            Boolean r102 = r100.has_more;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.last_token;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(4, r106);
        L10:
            return ((r105 + r103) + this.sub_task_ranks.encodedSizeWithTag(5, r100.sub_task_ranks)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetPagingSubTaskResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetPagingSubTaskResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetPagingSubTaskResponse r101) throws IOException {
            Todo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.sub_tasks);
            this.guid_to_position.encodeWithTag(r100, 2, r101.guid_to_position);
            Boolean r102 = r101.has_more;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r102);
        L5:
            String r103 = r101.last_token;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r103);
        L8:
            this.sub_task_ranks.encodeWithTag(r100, 5, r101.sub_task_ranks);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetPagingSubTaskResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetPagingSubTaskResponse r100 = new ProtoAdapter_GetPagingSubTaskResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.sub_tasks = Internal.copyOf("sub_tasks", this.sub_tasks);
        r100.guid_to_position = Internal.copyOf("guid_to_position", this.guid_to_position);
        r100.has_more = this.has_more;
        r100.last_token = this.last_token;
        r100.sub_task_ranks = Internal.copyOf("sub_task_ranks", this.sub_task_ranks);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetPagingSubTaskResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetPagingSubTaskResponse(List<Todo> r100, Map<String, Long> r101, Boolean r110, String r111, Map<String, String> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public GetPagingSubTaskResponse(List<Todo> r100, Map<String, Long> r101, Boolean r102, String r103, Map<String, String> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.sub_tasks = Internal.immutableCopyOf("sub_tasks", r100);
        this.guid_to_position = Internal.immutableCopyOf("guid_to_position", r101);
        this.has_more = r102;
        this.last_token = r103;
        this.sub_task_ranks = Internal.immutableCopyOf("sub_task_ranks", r104);
    }
}
