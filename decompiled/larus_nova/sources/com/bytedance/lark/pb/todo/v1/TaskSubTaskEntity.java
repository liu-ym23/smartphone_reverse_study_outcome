package com.bytedance.lark.pb.todo.v1;

import com.bytedance.lark.pb.basic.v1.RichContent;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskSubTaskEntity extends Message<TaskSubTaskEntity, Builder> {
    public static final ProtoAdapter<TaskSubTaskEntity> ADAPTER = null;
    public static final String DEFAULT_SUBTASK_GUID = "";
    private static final long serialVersionUID = 0;
    public final String subtask_guid;
    public final RichContent subtask_summary;

    public static final class Builder extends Message.Builder<TaskSubTaskEntity, Builder> {
        public String subtask_guid;
        public RichContent subtask_summary;

        @Override // com.squareup.wire.Message.Builder
        public TaskSubTaskEntity build() {
            return new TaskSubTaskEntity(this.subtask_guid, this.subtask_summary, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder subtask_guid(String r100) {
            this.subtask_guid = r100;
            return this;
        }

        public Builder subtask_summary(RichContent r100) {
            this.subtask_summary = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskSubTaskEntity extends ProtoAdapter<TaskSubTaskEntity> {
        public ProtoAdapter_TaskSubTaskEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskSubTaskEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskSubTaskEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.subtask_guid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.subtask_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.subtask_summary = RichContent.ADAPTER.decode(r100);
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
        public int encodedSize2(TaskSubTaskEntity r100) {
            String r101 = r100.subtask_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            RichContent r104 = r100.subtask_summary;
            if (r104 == null) goto L10;
            r102 = RichContent.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskSubTaskEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskSubTaskEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskSubTaskEntity r101) throws IOException {
            String r102 = r101.subtask_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            RichContent r103 = r101.subtask_summary;
            if (r103 == null) goto L8;
            RichContent.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskSubTaskEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskSubTaskEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.subtask_guid = this.subtask_guid;
        r100.subtask_summary = this.subtask_summary;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskSubTaskEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskSubTaskEntity(String r100, RichContent r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskSubTaskEntity(String r100, RichContent r101, ByteString r102) {
        super(ADAPTER, r102);
        this.subtask_guid = r100;
        this.subtask_summary = r101;
    }
}
