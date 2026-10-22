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
public final class TaskSummaryUpdateEntity extends Message<TaskSummaryUpdateEntity, Builder> {
    public static final ProtoAdapter<TaskSummaryUpdateEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final RichContent task_new_summary;
    public final RichContent task_old_summary;

    public static final class Builder extends Message.Builder<TaskSummaryUpdateEntity, Builder> {
        public RichContent task_new_summary;
        public RichContent task_old_summary;

        @Override // com.squareup.wire.Message.Builder
        public TaskSummaryUpdateEntity build() {
            return new TaskSummaryUpdateEntity(this.task_old_summary, this.task_new_summary, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder task_new_summary(RichContent r100) {
            this.task_new_summary = r100;
            return this;
        }

        public Builder task_old_summary(RichContent r100) {
            this.task_old_summary = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskSummaryUpdateEntity extends ProtoAdapter<TaskSummaryUpdateEntity> {
        public ProtoAdapter_TaskSummaryUpdateEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskSummaryUpdateEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskSummaryUpdateEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.task_old_summary = RichContent.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.task_new_summary = RichContent.ADAPTER.decode(r100);
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
        public int encodedSize2(TaskSummaryUpdateEntity r100) {
            RichContent r101 = r100.task_old_summary;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = RichContent.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            RichContent r104 = r100.task_new_summary;
            if (r104 == null) goto L10;
            r102 = RichContent.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskSummaryUpdateEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskSummaryUpdateEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskSummaryUpdateEntity r101) throws IOException {
            RichContent r102 = r101.task_old_summary;
            if (r102 == null) goto L5;
            RichContent.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            RichContent r103 = r101.task_new_summary;
            if (r103 == null) goto L8;
            RichContent.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskSummaryUpdateEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskSummaryUpdateEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task_old_summary = this.task_old_summary;
        r100.task_new_summary = this.task_new_summary;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskSummaryUpdateEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskSummaryUpdateEntity(RichContent r100, RichContent r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskSummaryUpdateEntity(RichContent r100, RichContent r101, ByteString r102) {
        super(ADAPTER, r102);
        this.task_old_summary = r100;
        this.task_new_summary = r101;
    }
}
