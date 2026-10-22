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
public final class TaskDescriptionUpdateEntity extends Message<TaskDescriptionUpdateEntity, Builder> {
    public static final ProtoAdapter<TaskDescriptionUpdateEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final RichContent task_new_description;
    public final RichContent task_old_description;

    public static final class Builder extends Message.Builder<TaskDescriptionUpdateEntity, Builder> {
        public RichContent task_new_description;
        public RichContent task_old_description;

        @Override // com.squareup.wire.Message.Builder
        public TaskDescriptionUpdateEntity build() {
            return new TaskDescriptionUpdateEntity(this.task_old_description, this.task_new_description, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder task_new_description(RichContent r100) {
            this.task_new_description = r100;
            return this;
        }

        public Builder task_old_description(RichContent r100) {
            this.task_old_description = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskDescriptionUpdateEntity extends ProtoAdapter<TaskDescriptionUpdateEntity> {
        public ProtoAdapter_TaskDescriptionUpdateEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskDescriptionUpdateEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskDescriptionUpdateEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.task_old_description = RichContent.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.task_new_description = RichContent.ADAPTER.decode(r100);
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
        public int encodedSize2(TaskDescriptionUpdateEntity r100) {
            RichContent r101 = r100.task_old_description;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = RichContent.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            RichContent r104 = r100.task_new_description;
            if (r104 == null) goto L10;
            r102 = RichContent.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskDescriptionUpdateEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskDescriptionUpdateEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskDescriptionUpdateEntity r101) throws IOException {
            RichContent r102 = r101.task_old_description;
            if (r102 == null) goto L5;
            RichContent.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            RichContent r103 = r101.task_new_description;
            if (r103 == null) goto L8;
            RichContent.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskDescriptionUpdateEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskDescriptionUpdateEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task_old_description = this.task_old_description;
        r100.task_new_description = this.task_new_description;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskDescriptionUpdateEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskDescriptionUpdateEntity(RichContent r100, RichContent r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskDescriptionUpdateEntity(RichContent r100, RichContent r101, ByteString r102) {
        super(ADAPTER, r102);
        this.task_old_description = r100;
        this.task_new_description = r101;
    }
}
