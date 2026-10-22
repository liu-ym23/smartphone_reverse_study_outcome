package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskListFieldUpdateEntity extends Message<TaskListFieldUpdateEntity, Builder> {
    public static final ProtoAdapter<TaskListFieldUpdateEntity> ADAPTER = null;
    public static final String DEFAULT_FIELD_NAME = "";
    private static final long serialVersionUID = 0;
    public final String field_name;

    public static final class Builder extends Message.Builder<TaskListFieldUpdateEntity, Builder> {
        public String field_name;

        @Override // com.squareup.wire.Message.Builder
        public TaskListFieldUpdateEntity build() {
            return new TaskListFieldUpdateEntity(this.field_name, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder field_name(String r100) {
            this.field_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskListFieldUpdateEntity extends ProtoAdapter<TaskListFieldUpdateEntity> {
        public ProtoAdapter_TaskListFieldUpdateEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskListFieldUpdateEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskListFieldUpdateEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.field_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 2) goto L7;
            r101.field_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskListFieldUpdateEntity r100) {
            String r101 = r100.field_name;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskListFieldUpdateEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskListFieldUpdateEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskListFieldUpdateEntity r101) throws IOException {
            String r102 = r101.field_name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskListFieldUpdateEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskListFieldUpdateEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.field_name = this.field_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskListFieldUpdateEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskListFieldUpdateEntity(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public TaskListFieldUpdateEntity(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.field_name = r100;
    }
}
