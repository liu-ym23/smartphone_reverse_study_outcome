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
public final class GetPagingTaskListMembersResponse extends Message<GetPagingTaskListMembersResponse, Builder> {
    public static final ProtoAdapter<GetPagingTaskListMembersResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final String DEFAULT_LAST_TOKEN = "";
    public static final Long DEFAULT_TOTAL_COUNT = null;
    public static final ProtoAdapter_GetPagingTaskListMembersResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean has_more;
    public final String last_token;
    public final List<TaskListMember> task_list_members;
    public final Long total_count;

    public static final class Builder extends Message.Builder<GetPagingTaskListMembersResponse, Builder> implements d<GetPagingTaskListMembersResponse> {
        public Boolean has_more;
        public String last_token;
        public List<TaskListMember> task_list_members;
        public Long total_count;

        @Override // com.squareup.wire.Message.Builder
        public GetPagingTaskListMembersResponse build() {
            return new GetPagingTaskListMembersResponse(this.task_list_members, this.has_more, this.last_token, this.total_count, super.buildUnknownFields());
        }

        public Builder() {
            this.task_list_members = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder last_token(String r100) {
            this.last_token = r100;
            return this;
        }

        public Builder task_list_members(List<TaskListMember> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_list_members = r100;
            return this;
        }

        public Builder total_count(Long r100) {
            this.total_count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetPagingTaskListMembersResponse extends ProtoAdapter<GetPagingTaskListMembersResponse> implements c<GetPagingTaskListMembersResponse> {
        public ProtoAdapter_GetPagingTaskListMembersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetPagingTaskListMembersResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetPagingTaskListMembersResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.has_more = Boolean.FALSE;
            r101.last_token = "";
            r101.total_count = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.task_list_members.add(TaskListMember.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.last_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.total_count = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetPagingTaskListMembersResponse r100) {
            int r101 = TaskListMember.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.task_list_members);
            Boolean r102 = r100.has_more;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.last_token;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Long r109 = r100.total_count;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.INT64.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetPagingTaskListMembersResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetPagingTaskListMembersResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetPagingTaskListMembersResponse r101) throws IOException {
            TaskListMember.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.task_list_members);
            Boolean r102 = r101.has_more;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.last_token;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            Long r104 = r101.total_count;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetPagingTaskListMembersResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetPagingTaskListMembersResponse r100 = new ProtoAdapter_GetPagingTaskListMembersResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HAS_MORE = Boolean.FALSE;
        DEFAULT_TOTAL_COUNT = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task_list_members = Internal.copyOf("task_list_members", this.task_list_members);
        r100.has_more = this.has_more;
        r100.last_token = this.last_token;
        r100.total_count = this.total_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetPagingTaskListMembersResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetPagingTaskListMembersResponse(List<TaskListMember> r100, Boolean r101, String r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetPagingTaskListMembersResponse(List<TaskListMember> r100, Boolean r101, String r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.task_list_members = Internal.immutableCopyOf("task_list_members", r100);
        this.has_more = r101;
        this.last_token = r102;
        this.total_count = r103;
    }
}
