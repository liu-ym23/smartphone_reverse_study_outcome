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
public final class TaskViewFieldConfig extends Message<TaskViewFieldConfig, Builder> {
    public static final ProtoAdapter<TaskViewFieldConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> enable_filter_field_keys;
    public final List<String> enable_group_field_keys;
    public final List<String> enable_sort_field_keys;
    public final List<String> enable_system_field_keys;

    public static final class Builder extends Message.Builder<TaskViewFieldConfig, Builder> {
        public List<String> enable_filter_field_keys;
        public List<String> enable_group_field_keys;
        public List<String> enable_sort_field_keys;
        public List<String> enable_system_field_keys;

        @Override // com.squareup.wire.Message.Builder
        public TaskViewFieldConfig build() {
            return new TaskViewFieldConfig(this.enable_system_field_keys, this.enable_filter_field_keys, this.enable_group_field_keys, this.enable_sort_field_keys, super.buildUnknownFields());
        }

        public Builder() {
            this.enable_system_field_keys = Internal.newMutableList();
            this.enable_filter_field_keys = Internal.newMutableList();
            this.enable_group_field_keys = Internal.newMutableList();
            this.enable_sort_field_keys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder enable_filter_field_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.enable_filter_field_keys = r100;
            return this;
        }

        public Builder enable_group_field_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.enable_group_field_keys = r100;
            return this;
        }

        public Builder enable_sort_field_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.enable_sort_field_keys = r100;
            return this;
        }

        public Builder enable_system_field_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.enable_system_field_keys = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskViewFieldConfig extends ProtoAdapter<TaskViewFieldConfig> {
        public ProtoAdapter_TaskViewFieldConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskViewFieldConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskViewFieldConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.enable_system_field_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.enable_filter_field_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.enable_group_field_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.enable_sort_field_keys.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(TaskViewFieldConfig r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.asRepeated().encodedSizeWithTag(1, r100.enable_system_field_keys) + r101.asRepeated().encodedSizeWithTag(2, r100.enable_filter_field_keys)) + r101.asRepeated().encodedSizeWithTag(3, r100.enable_group_field_keys)) + r101.asRepeated().encodedSizeWithTag(4, r100.enable_sort_field_keys)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskViewFieldConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskViewFieldConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskViewFieldConfig r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.enable_system_field_keys);
            r102.asRepeated().encodeWithTag(r100, 2, r101.enable_filter_field_keys);
            r102.asRepeated().encodeWithTag(r100, 3, r101.enable_group_field_keys);
            r102.asRepeated().encodeWithTag(r100, 4, r101.enable_sort_field_keys);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskViewFieldConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskViewFieldConfig();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.enable_system_field_keys = Internal.copyOf("enable_system_field_keys", this.enable_system_field_keys);
        r100.enable_filter_field_keys = Internal.copyOf("enable_filter_field_keys", this.enable_filter_field_keys);
        r100.enable_group_field_keys = Internal.copyOf("enable_group_field_keys", this.enable_group_field_keys);
        r100.enable_sort_field_keys = Internal.copyOf("enable_sort_field_keys", this.enable_sort_field_keys);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskViewFieldConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskViewFieldConfig(List<String> r100, List<String> r101, List<String> r102, List<String> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TaskViewFieldConfig(List<String> r100, List<String> r101, List<String> r102, List<String> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.enable_system_field_keys = Internal.immutableCopyOf("enable_system_field_keys", r100);
        this.enable_filter_field_keys = Internal.immutableCopyOf("enable_filter_field_keys", r101);
        this.enable_group_field_keys = Internal.immutableCopyOf("enable_group_field_keys", r102);
        this.enable_sort_field_keys = Internal.immutableCopyOf("enable_sort_field_keys", r103);
    }
}
