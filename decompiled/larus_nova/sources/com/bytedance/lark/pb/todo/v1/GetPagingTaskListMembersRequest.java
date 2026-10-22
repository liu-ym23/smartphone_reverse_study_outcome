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
public final class GetPagingTaskListMembersRequest extends Message<GetPagingTaskListMembersRequest, Builder> {
    public static final ProtoAdapter<GetPagingTaskListMembersRequest> ADAPTER = null;
    public static final Long DEFAULT_COUNT = null;
    public static final String DEFAULT_LAST_TOKEN = "";
    public static final String DEFAULT_TASK_LIST_GUID = "";
    public static final ProtoAdapter_GetPagingTaskListMembersRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long count;
    public final List<TodoItemMemberType> enable_member_type;
    public final String last_token;
    public final String task_list_guid;

    public static final class Builder extends Message.Builder<GetPagingTaskListMembersRequest, Builder> implements d<GetPagingTaskListMembersRequest> {
        public Long count;
        public List<TodoItemMemberType> enable_member_type;
        public String last_token;
        public String task_list_guid;

        @Override // com.squareup.wire.Message.Builder
        public GetPagingTaskListMembersRequest build() {
            return new GetPagingTaskListMembersRequest(this.task_list_guid, this.last_token, this.count, this.enable_member_type, super.buildUnknownFields());
        }

        public Builder() {
            this.enable_member_type = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder count(Long r100) {
            this.count = r100;
            return this;
        }

        public Builder enable_member_type(List<TodoItemMemberType> r100) {
            Internal.checkElementsNotNull(r100);
            this.enable_member_type = r100;
            return this;
        }

        public Builder last_token(String r100) {
            this.last_token = r100;
            return this;
        }

        public Builder task_list_guid(String r100) {
            this.task_list_guid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetPagingTaskListMembersRequest extends ProtoAdapter<GetPagingTaskListMembersRequest> implements c<GetPagingTaskListMembersRequest> {
        public ProtoAdapter_GetPagingTaskListMembersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetPagingTaskListMembersRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetPagingTaskListMembersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.task_list_guid = "";
            r101.last_token = "";
            r101.count = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.task_list_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.last_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.count = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.enable_member_type.add(TodoItemMemberType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetPagingTaskListMembersRequest r100) {
            String r101 = r100.task_list_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.last_token;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.count;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            return ((r106 + r102) + TodoItemMemberType.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.enable_member_type)) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetPagingTaskListMembersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetPagingTaskListMembersRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetPagingTaskListMembersRequest r101) throws IOException {
            String r102 = r101.task_list_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.last_token;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.count;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            TodoItemMemberType.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.enable_member_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetPagingTaskListMembersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetPagingTaskListMembersRequest r100 = new ProtoAdapter_GetPagingTaskListMembersRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_COUNT = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task_list_guid = this.task_list_guid;
        r100.last_token = this.last_token;
        r100.count = this.count;
        r100.enable_member_type = Internal.copyOf("enable_member_type", this.enable_member_type);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetPagingTaskListMembersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetPagingTaskListMembersRequest(String r100, String r101, Long r102, List<TodoItemMemberType> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetPagingTaskListMembersRequest(String r100, String r101, Long r102, List<TodoItemMemberType> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.task_list_guid = r100;
        this.last_token = r101;
        this.count = r102;
        this.enable_member_type = Internal.immutableCopyOf("enable_member_type", r103);
    }
}
