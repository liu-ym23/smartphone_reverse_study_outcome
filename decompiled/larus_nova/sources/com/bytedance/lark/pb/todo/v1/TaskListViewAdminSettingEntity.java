package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskListViewAdminSettingEntity extends Message<TaskListViewAdminSettingEntity, Builder> {
    public static final ProtoAdapter<TaskListViewAdminSettingEntity> ADAPTER = null;
    public static final String DEFAULT_VIEW_GUID = "";
    public static final TaskView.Type DEFAULT_VIEW_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String view_guid;
    public final TaskView.Type view_type;

    public static final class Builder extends Message.Builder<TaskListViewAdminSettingEntity, Builder> {
        public String view_guid;
        public TaskView.Type view_type;

        @Override // com.squareup.wire.Message.Builder
        public TaskListViewAdminSettingEntity build() {
            return new TaskListViewAdminSettingEntity(this.view_guid, this.view_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder view_guid(String r100) {
            this.view_guid = r100;
            return this;
        }

        public Builder view_type(TaskView.Type r100) {
            this.view_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskListViewAdminSettingEntity extends ProtoAdapter<TaskListViewAdminSettingEntity> {
        public ProtoAdapter_TaskListViewAdminSettingEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskListViewAdminSettingEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskListViewAdminSettingEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.view_guid = "";
            r101.view_type = TaskView.Type.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.view_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.view_type = TaskView.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskListViewAdminSettingEntity r100) {
            String r101 = r100.view_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            TaskView.Type r104 = r100.view_type;
            if (r104 == null) goto L10;
            r102 = TaskView.Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskListViewAdminSettingEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskListViewAdminSettingEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskListViewAdminSettingEntity r101) throws IOException {
            String r102 = r101.view_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            TaskView.Type r103 = r101.view_type;
            if (r103 == null) goto L8;
            TaskView.Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskListViewAdminSettingEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskListViewAdminSettingEntity();
        DEFAULT_VIEW_TYPE = TaskView.Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.view_guid = this.view_guid;
        r100.view_type = this.view_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskListViewAdminSettingEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskListViewAdminSettingEntity(String r100, TaskView.Type r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskListViewAdminSettingEntity(String r100, TaskView.Type r101, ByteString r102) {
        super(ADAPTER, r102);
        this.view_guid = r100;
        this.view_type = r101;
    }
}
