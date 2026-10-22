package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskListSectionUpdateEntity extends Message<TaskListSectionUpdateEntity, Builder> {
    public static final ProtoAdapter<TaskListSectionUpdateEntity> ADAPTER = null;
    public static final Boolean DEFAULT_IS_DEFAULT = null;
    public static final String DEFAULT_NEW_SECTION_NAME = "";
    public static final String DEFAULT_OLD_SECTION_NAME = "";
    private static final long serialVersionUID = 0;
    public final Boolean is_default;
    public final String new_section_name;
    public final String old_section_name;

    public static final class Builder extends Message.Builder<TaskListSectionUpdateEntity, Builder> {
        public Boolean is_default;
        public String new_section_name;
        public String old_section_name;

        @Override // com.squareup.wire.Message.Builder
        public TaskListSectionUpdateEntity build() {
            return new TaskListSectionUpdateEntity(this.old_section_name, this.new_section_name, this.is_default, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_default(Boolean r100) {
            this.is_default = r100;
            return this;
        }

        public Builder new_section_name(String r100) {
            this.new_section_name = r100;
            return this;
        }

        public Builder old_section_name(String r100) {
            this.old_section_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskListSectionUpdateEntity extends ProtoAdapter<TaskListSectionUpdateEntity> {
        public ProtoAdapter_TaskListSectionUpdateEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskListSectionUpdateEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskListSectionUpdateEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.old_section_name = "";
            r101.new_section_name = "";
            r101.is_default = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.old_section_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.new_section_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.is_default = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskListSectionUpdateEntity r100) {
            String r101 = r100.old_section_name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.new_section_name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_default;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ TaskListSectionUpdateEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskListSectionUpdateEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskListSectionUpdateEntity r101) throws IOException {
            String r102 = r101.old_section_name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.new_section_name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_default;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskListSectionUpdateEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskListSectionUpdateEntity();
        DEFAULT_IS_DEFAULT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.old_section_name = this.old_section_name;
        r100.new_section_name = this.new_section_name;
        r100.is_default = this.is_default;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskListSectionUpdateEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskListSectionUpdateEntity(String r100, String r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TaskListSectionUpdateEntity(String r100, String r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.old_section_name = r100;
        this.new_section_name = r101;
        this.is_default = r102;
    }
}
