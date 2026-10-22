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
public final class GetPagingTaskListsResponse extends Message<GetPagingTaskListsResponse, Builder> {
    public static final ProtoAdapter<GetPagingTaskListsResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final Long DEFAULT_LAST_TOKEN = null;
    public static final ProtoAdapter_GetPagingTaskListsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean has_more;
    public final Long last_token;
    public final List<TaskContainer> task_lists;

    public static final class Builder extends Message.Builder<GetPagingTaskListsResponse, Builder> implements d<GetPagingTaskListsResponse> {
        public Boolean has_more;
        public Long last_token;
        public List<TaskContainer> task_lists;

        @Override // com.squareup.wire.Message.Builder
        public GetPagingTaskListsResponse build() {
            return new GetPagingTaskListsResponse(this.task_lists, this.last_token, this.has_more, super.buildUnknownFields());
        }

        public Builder() {
            this.task_lists = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder last_token(Long r100) {
            this.last_token = r100;
            return this;
        }

        public Builder task_lists(List<TaskContainer> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_lists = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetPagingTaskListsResponse extends ProtoAdapter<GetPagingTaskListsResponse> implements c<GetPagingTaskListsResponse> {
        public ProtoAdapter_GetPagingTaskListsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetPagingTaskListsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetPagingTaskListsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.last_token = 0L;
            r101.has_more = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.task_lists.add(TaskContainer.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.last_token = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetPagingTaskListsResponse r100) {
            int r101 = TaskContainer.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.task_lists);
            Long r102 = r100.last_token;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.has_more;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetPagingTaskListsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetPagingTaskListsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetPagingTaskListsResponse r101) throws IOException {
            TaskContainer.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.task_lists);
            Long r102 = r101.last_token;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.has_more;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetPagingTaskListsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetPagingTaskListsResponse r100 = new ProtoAdapter_GetPagingTaskListsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_LAST_TOKEN = 0L;
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task_lists = Internal.copyOf("task_lists", this.task_lists);
        r100.last_token = this.last_token;
        r100.has_more = this.has_more;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetPagingTaskListsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetPagingTaskListsResponse(List<TaskContainer> r100, Long r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetPagingTaskListsResponse(List<TaskContainer> r100, Long r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.task_lists = Internal.immutableCopyOf("task_lists", r100);
        this.last_token = r101;
        this.has_more = r102;
    }
}
