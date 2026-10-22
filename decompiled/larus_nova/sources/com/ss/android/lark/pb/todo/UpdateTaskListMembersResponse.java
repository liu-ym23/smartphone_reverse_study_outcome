package com.ss.android.lark.pb.todo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.todo_entities.TaskListMember;
import com.ss.android.lark.pb.todo_entities.TodoChat;
import com.ss.android.lark.pb.todo_entities.TodoDoc;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class UpdateTaskListMembersResponse extends Message<UpdateTaskListMembersResponse, Builder> {
    public static final ProtoAdapter<UpdateTaskListMembersResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, TodoChat> mchats;
    public final List<Long> mpassed_ids;
    public final List<Long> mrefused_ids;
    public final Map<String, TodoDoc> mtodo_docs;
    public final Map<Long, TaskListMember> mupdated_member;

    public static final class Builder extends Message.Builder<UpdateTaskListMembersResponse, Builder> {
        public Map<Long, TodoChat> mchats;
        public List<Long> mpassed_ids;
        public List<Long> mrefused_ids;
        public Map<String, TodoDoc> mtodo_docs;
        public Map<Long, TaskListMember> mupdated_member;

        @Override // com.squareup.wire.Message.Builder
        public UpdateTaskListMembersResponse build() {
            return new UpdateTaskListMembersResponse(this.mpassed_ids, this.mrefused_ids, this.mupdated_member, this.mchats, this.mtodo_docs, super.buildUnknownFields());
        }

        public Builder() {
            this.mpassed_ids = Internal.newMutableList();
            this.mrefused_ids = Internal.newMutableList();
            this.mupdated_member = Internal.newMutableMap();
            this.mchats = Internal.newMutableMap();
            this.mtodo_docs = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chats(Map<Long, TodoChat> r100) {
            Internal.checkElementsNotNull(r100);
            this.mchats = r100;
            return this;
        }

        public Builder passed_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mpassed_ids = r100;
            return this;
        }

        public Builder refused_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mrefused_ids = r100;
            return this;
        }

        public Builder todo_docs(Map<String, TodoDoc> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtodo_docs = r100;
            return this;
        }

        public Builder updated_member(Map<Long, TaskListMember> r100) {
            Internal.checkElementsNotNull(r100);
            this.mupdated_member = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateTaskListMembersResponse extends ProtoAdapter<UpdateTaskListMembersResponse> {
        private final ProtoAdapter<Map<Long, TodoChat>> mchats;
        private final ProtoAdapter<Map<String, TodoDoc>> mtodo_docs;
        private final ProtoAdapter<Map<Long, TaskListMember>> mupdated_member;

        public ProtoAdapter_UpdateTaskListMembersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateTaskListMembersResponse.class);
            ProtoAdapter<Long> r100 = ProtoAdapter.INT64;
            this.mupdated_member = ProtoAdapter.newMapAdapter(r100, TaskListMember.ADAPTER);
            this.mchats = ProtoAdapter.newMapAdapter(r100, TodoChat.ADAPTER);
            this.mtodo_docs = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, TodoDoc.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateTaskListMembersResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mpassed_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mrefused_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mupdated_member.putAll(this.mupdated_member.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mchats.putAll(this.mchats.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mtodo_docs.putAll(this.mtodo_docs.decode(r100));
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
        public int encodedSize2(UpdateTaskListMembersResponse r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            return ((((r101.asRepeated().encodedSizeWithTag(1, r100.mpassed_ids) + r101.asRepeated().encodedSizeWithTag(2, r100.mrefused_ids)) + this.mupdated_member.encodedSizeWithTag(3, r100.mupdated_member)) + this.mchats.encodedSizeWithTag(4, r100.mchats)) + this.mtodo_docs.encodedSizeWithTag(5, r100.mtodo_docs)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateTaskListMembersResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateTaskListMembersResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateTaskListMembersResponse r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.asRepeated().encodeWithTag(r100, 1, r101.mpassed_ids);
            r102.asRepeated().encodeWithTag(r100, 2, r101.mrefused_ids);
            this.mupdated_member.encodeWithTag(r100, 3, r101.mupdated_member);
            this.mchats.encodeWithTag(r100, 4, r101.mchats);
            this.mtodo_docs.encodeWithTag(r100, 5, r101.mtodo_docs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateTaskListMembersResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateTaskListMembersResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mpassed_ids = Internal.copyOf("mpassed_ids", this.mpassed_ids);
        r100.mrefused_ids = Internal.copyOf("mrefused_ids", this.mrefused_ids);
        r100.mupdated_member = Internal.copyOf("mupdated_member", this.mupdated_member);
        r100.mchats = Internal.copyOf("mchats", this.mchats);
        r100.mtodo_docs = Internal.copyOf("mtodo_docs", this.mtodo_docs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateTaskListMembersResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateTaskListMembersResponse(List<Long> r100, List<Long> r101, Map<Long, TaskListMember> r110, Map<Long, TodoChat> r111, Map<String, TodoDoc> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public UpdateTaskListMembersResponse(List<Long> r100, List<Long> r101, Map<Long, TaskListMember> r102, Map<Long, TodoChat> r103, Map<String, TodoDoc> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mpassed_ids = Internal.immutableCopyOf("mpassed_ids", r100);
        this.mrefused_ids = Internal.immutableCopyOf("mrefused_ids", r101);
        this.mupdated_member = Internal.immutableCopyOf("mupdated_member", r102);
        this.mchats = Internal.immutableCopyOf("mchats", r103);
        this.mtodo_docs = Internal.immutableCopyOf("mtodo_docs", r104);
    }
}
