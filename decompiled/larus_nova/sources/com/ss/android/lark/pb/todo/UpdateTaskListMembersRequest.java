package com.ss.android.lark.pb.todo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.todo_entities.TaskListMember;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class UpdateTaskListMembersRequest extends Message<UpdateTaskListMembersRequest, Builder> {
    public static final ProtoAdapter<UpdateTaskListMembersRequest> ADAPTER = null;
    public static final String DEFAULT_NOTE = "";
    public static final Boolean DEFAULT_SEND_NOTE = null;
    public static final String DEFAULT_TASK_LIST_GUID = "";
    private static final long serialVersionUID = 0;
    public final String mnote;
    public final Boolean msend_note;
    public final String mtask_list_guid;
    public final Map<Long, TaskListMember> mupdated_member;

    public static final class Builder extends Message.Builder<UpdateTaskListMembersRequest, Builder> {
        public String mnote;
        public Boolean msend_note;
        public String mtask_list_guid;
        public Map<Long, TaskListMember> mupdated_member;

        @Override // com.squareup.wire.Message.Builder
        public UpdateTaskListMembersRequest build() {
            return new UpdateTaskListMembersRequest(this.mtask_list_guid, this.mupdated_member, this.msend_note, this.mnote, super.buildUnknownFields());
        }

        public Builder() {
            this.mupdated_member = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder note(String r100) {
            this.mnote = r100;
            return this;
        }

        public Builder send_note(Boolean r100) {
            this.msend_note = r100;
            return this;
        }

        public Builder task_list_guid(String r100) {
            this.mtask_list_guid = r100;
            return this;
        }

        public Builder updated_member(Map<Long, TaskListMember> r100) {
            Internal.checkElementsNotNull(r100);
            this.mupdated_member = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateTaskListMembersRequest extends ProtoAdapter<UpdateTaskListMembersRequest> {
        private final ProtoAdapter<Map<Long, TaskListMember>> mupdated_member;

        public ProtoAdapter_UpdateTaskListMembersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateTaskListMembersRequest.class);
            this.mupdated_member = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, TaskListMember.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateTaskListMembersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtask_list_guid = "";
            r101.msend_note = Boolean.FALSE;
            r101.mnote = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mtask_list_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mupdated_member.putAll(this.mupdated_member.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.msend_note = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mnote = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UpdateTaskListMembersRequest r100) {
            String r101 = r100.mtask_list_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + this.mupdated_member.encodedSizeWithTag(2, r100.mupdated_member);
            Boolean r105 = r100.msend_note;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            String r108 = r100.mnote;
            if (r108 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r108);
        L14:
            return (r107 + r102) + r100.unknownFields().size();
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateTaskListMembersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateTaskListMembersRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateTaskListMembersRequest r101) throws IOException {
            String r102 = r101.mtask_list_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            this.mupdated_member.encodeWithTag(r100, 2, r101.mupdated_member);
            Boolean r103 = r101.msend_note;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            String r104 = r101.mnote;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateTaskListMembersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateTaskListMembersRequest();
        DEFAULT_SEND_NOTE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtask_list_guid = this.mtask_list_guid;
        r100.mupdated_member = Internal.copyOf("mupdated_member", this.mupdated_member);
        r100.msend_note = this.msend_note;
        r100.mnote = this.mnote;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateTaskListMembersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateTaskListMembersRequest(String r100, Map<Long, TaskListMember> r101, Boolean r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public UpdateTaskListMembersRequest(String r100, Map<Long, TaskListMember> r101, Boolean r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mtask_list_guid = r100;
        this.mupdated_member = Internal.immutableCopyOf("mupdated_member", r101);
        this.msend_note = r102;
        this.mnote = r103;
    }
}
