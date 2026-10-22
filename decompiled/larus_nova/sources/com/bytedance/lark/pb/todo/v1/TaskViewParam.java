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

/* JADX INFO: loaded from: classes20.dex */
public final class TaskViewParam extends Message<TaskViewParam, Builder> {
    public static final ProtoAdapter<TaskViewParam> ADAPTER = null;
    public static final TaskView.Type DEFAULT_VIEW_TYPE = null;
    private static final long serialVersionUID = 0;
    public final List<String> builtin_field_keys;
    public final List<FieldType> custom_field_types;
    public final TaskView.Type view_type;

    public static final class Builder extends Message.Builder<TaskViewParam, Builder> {
        public List<String> builtin_field_keys;
        public List<FieldType> custom_field_types;
        public TaskView.Type view_type;

        @Override // com.squareup.wire.Message.Builder
        public TaskViewParam build() {
            return new TaskViewParam(this.view_type, this.builtin_field_keys, this.custom_field_types, super.buildUnknownFields());
        }

        public Builder() {
            this.builtin_field_keys = Internal.newMutableList();
            this.custom_field_types = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder builtin_field_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.builtin_field_keys = r100;
            return this;
        }

        public Builder custom_field_types(List<FieldType> r100) {
            Internal.checkElementsNotNull(r100);
            this.custom_field_types = r100;
            return this;
        }

        public Builder view_type(TaskView.Type r100) {
            this.view_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskViewParam extends ProtoAdapter<TaskViewParam> {
        public ProtoAdapter_TaskViewParam() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskViewParam.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskViewParam decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.view_type = TaskView.Type.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.view_type = TaskView.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.builtin_field_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.custom_field_types.add(FieldType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskViewParam r100) {
            TaskView.Type r101 = r100.view_type;
            if (r101 == null) goto L5;
            int r102 = TaskView.Type.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return ((r102 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.builtin_field_keys)) + FieldType.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.custom_field_types)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskViewParam decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskViewParam r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskViewParam r101) throws IOException {
            TaskView.Type r102 = r101.view_type;
            if (r102 == null) goto L5;
            TaskView.Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.builtin_field_keys);
            FieldType.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.custom_field_types);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskViewParam r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskViewParam();
        DEFAULT_VIEW_TYPE = TaskView.Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.view_type = this.view_type;
        r100.builtin_field_keys = Internal.copyOf("builtin_field_keys", this.builtin_field_keys);
        r100.custom_field_types = Internal.copyOf("custom_field_types", this.custom_field_types);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskViewParam.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskViewParam(TaskView.Type r100, List<String> r101, List<FieldType> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TaskViewParam(TaskView.Type r100, List<String> r101, List<FieldType> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.view_type = r100;
        this.builtin_field_keys = Internal.immutableCopyOf("builtin_field_keys", r101);
        this.custom_field_types = Internal.immutableCopyOf("custom_field_types", r102);
    }
}
