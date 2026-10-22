package com.ss.android.lark.pb.todo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.todo_entities.TodoItemMemberRole;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ApplyTaskListPermissionRequest extends Message<ApplyTaskListPermissionRequest, Builder> {
    public static final ProtoAdapter<ApplyTaskListPermissionRequest> ADAPTER = null;
    public static final String DEFAULT_NOTE = "";
    public static final String DEFAULT_TASK_LIST_GUID = "";
    private static final long serialVersionUID = 0;
    public final String mnote;
    public final TodoItemMemberRole mrole;
    public final String mtask_list_guid;

    public static final class Builder extends Message.Builder<ApplyTaskListPermissionRequest, Builder> {
        public String mnote;
        public TodoItemMemberRole mrole;
        public String mtask_list_guid;

        @Override // com.squareup.wire.Message.Builder
        public ApplyTaskListPermissionRequest build() {
            return new ApplyTaskListPermissionRequest(this.mtask_list_guid, this.mrole, this.mnote, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder note(String r100) {
            this.mnote = r100;
            return this;
        }

        public Builder role(TodoItemMemberRole r100) {
            this.mrole = r100;
            return this;
        }

        public Builder task_list_guid(String r100) {
            this.mtask_list_guid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ApplyTaskListPermissionRequest extends ProtoAdapter<ApplyTaskListPermissionRequest> {
        public ProtoAdapter_ApplyTaskListPermissionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ApplyTaskListPermissionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ApplyTaskListPermissionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtask_list_guid = "";
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
            r101.mrole = TodoItemMemberRole.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mnote = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ApplyTaskListPermissionRequest r100) {
            String r101 = r100.mtask_list_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            TodoItemMemberRole r104 = r100.mrole;
            if (r104 == null) goto L9;
            int r105 = TodoItemMemberRole.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mnote;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ApplyTaskListPermissionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ApplyTaskListPermissionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ApplyTaskListPermissionRequest r101) throws IOException {
            String r102 = r101.mtask_list_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            TodoItemMemberRole r103 = r101.mrole;
            if (r103 == null) goto L8;
            TodoItemMemberRole.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mnote;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ApplyTaskListPermissionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ApplyTaskListPermissionRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtask_list_guid = this.mtask_list_guid;
        r100.mrole = this.mrole;
        r100.mnote = this.mnote;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ApplyTaskListPermissionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ApplyTaskListPermissionRequest(String r100, TodoItemMemberRole r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ApplyTaskListPermissionRequest(String r100, TodoItemMemberRole r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mtask_list_guid = r100;
        this.mrole = r101;
        this.mnote = r102;
    }
}
