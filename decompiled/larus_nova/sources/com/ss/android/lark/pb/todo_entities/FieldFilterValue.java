package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class FieldFilterValue extends Message<FieldFilterValue, Builder> {
    public static final ProtoAdapter<FieldFilterValue> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DatetimeFieldFilterValue mdatetime_value;
    public final MemberFieldFilterValue mmember_value;
    public final NumberFieldFilterValue mnumber_value;
    public final OptionFieldFilterValue moption_value;
    public final TaskCompleteStatusFieldFilterValue mtask_complete_status_value;
    public final TaskSectionFieldFilterValue mtask_section_value;
    public final TaskSourceTypeFieldFilterValue mtask_source_type_value;
    public final TaskSourceFieldFilterValue mtask_source_value;
    public final TextFieldFilterValue mtext_value;

    public static final class Builder extends Message.Builder<FieldFilterValue, Builder> {
        public DatetimeFieldFilterValue mdatetime_value;
        public MemberFieldFilterValue mmember_value;
        public NumberFieldFilterValue mnumber_value;
        public OptionFieldFilterValue moption_value;
        public TaskCompleteStatusFieldFilterValue mtask_complete_status_value;
        public TaskSectionFieldFilterValue mtask_section_value;
        public TaskSourceTypeFieldFilterValue mtask_source_type_value;
        public TaskSourceFieldFilterValue mtask_source_value;
        public TextFieldFilterValue mtext_value;

        @Override // com.squareup.wire.Message.Builder
        public FieldFilterValue build() {
            return new FieldFilterValue(this.mmember_value, this.mdatetime_value, this.mnumber_value, this.moption_value, this.mtext_value, this.mtask_complete_status_value, this.mtask_source_type_value, this.mtask_source_value, this.mtask_section_value, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder datetime_value(DatetimeFieldFilterValue r100) {
            this.mdatetime_value = r100;
            return this;
        }

        public Builder member_value(MemberFieldFilterValue r100) {
            this.mmember_value = r100;
            return this;
        }

        public Builder number_value(NumberFieldFilterValue r100) {
            this.mnumber_value = r100;
            return this;
        }

        public Builder option_value(OptionFieldFilterValue r100) {
            this.moption_value = r100;
            return this;
        }

        public Builder task_complete_status_value(TaskCompleteStatusFieldFilterValue r100) {
            this.mtask_complete_status_value = r100;
            return this;
        }

        public Builder task_section_value(TaskSectionFieldFilterValue r100) {
            this.mtask_section_value = r100;
            return this;
        }

        public Builder task_source_type_value(TaskSourceTypeFieldFilterValue r100) {
            this.mtask_source_type_value = r100;
            return this;
        }

        public Builder task_source_value(TaskSourceFieldFilterValue r100) {
            this.mtask_source_value = r100;
            return this;
        }

        public Builder text_value(TextFieldFilterValue r100) {
            this.mtext_value = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FieldFilterValue extends ProtoAdapter<FieldFilterValue> {
        public ProtoAdapter_FieldFilterValue() {
            super(FieldEncoding.LENGTH_DELIMITED, FieldFilterValue.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FieldFilterValue decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L26;
            if (r103 != 1) goto L8;
            r101.mmember_value = MemberFieldFilterValue.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mdatetime_value = DatetimeFieldFilterValue.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mnumber_value = NumberFieldFilterValue.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.moption_value = OptionFieldFilterValue.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mtext_value = TextFieldFilterValue.ADAPTER.decode(r100);
            goto L3
        L15:
            switch(r103) {
                case 100: goto L20;
                case 101: goto L19;
                case 102: goto L18;
                case 103: goto L17;
                default: goto L16;
            };
        L17:
            r101.mtask_section_value = TaskSectionFieldFilterValue.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.mtask_source_value = TaskSourceFieldFilterValue.ADAPTER.decode(r100);
            goto L3
        L19:
            r101.mtask_source_type_value = TaskSourceTypeFieldFilterValue.ADAPTER.decode(r100);
            goto L3
        L20:
            r101.mtask_complete_status_value = TaskCompleteStatusFieldFilterValue.ADAPTER.decode(r100);
            goto L3
        L16:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L26:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FieldFilterValue r100) {
            MemberFieldFilterValue r101 = r100.mmember_value;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = MemberFieldFilterValue.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            DatetimeFieldFilterValue r104 = r100.mdatetime_value;
            if (r104 == null) goto L9;
            int r105 = DatetimeFieldFilterValue.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            NumberFieldFilterValue r107 = r100.mnumber_value;
            if (r107 == null) goto L13;
            int r108 = NumberFieldFilterValue.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            OptionFieldFilterValue r110 = r100.moption_value;
            if (r110 == null) goto L17;
            int r111 = OptionFieldFilterValue.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            TextFieldFilterValue r113 = r100.mtext_value;
            if (r113 == null) goto L21;
            int r114 = TextFieldFilterValue.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            TaskCompleteStatusFieldFilterValue r116 = r100.mtask_complete_status_value;
            if (r116 == null) goto L25;
            int r117 = TaskCompleteStatusFieldFilterValue.ADAPTER.encodedSizeWithTag(100, r116);
        L26:
            int r118 = r115 + r117;
            TaskSourceTypeFieldFilterValue r119 = r100.mtask_source_type_value;
            if (r119 == null) goto L29;
            int r120 = TaskSourceTypeFieldFilterValue.ADAPTER.encodedSizeWithTag(101, r119);
        L30:
            int r121 = r118 + r120;
            TaskSourceFieldFilterValue r122 = r100.mtask_source_value;
            if (r122 == null) goto L33;
            int r123 = TaskSourceFieldFilterValue.ADAPTER.encodedSizeWithTag(102, r122);
        L34:
            int r124 = r121 + r123;
            TaskSectionFieldFilterValue r125 = r100.mtask_section_value;
            if (r125 == null) goto L38;
            r102 = TaskSectionFieldFilterValue.ADAPTER.encodedSizeWithTag(103, r125);
        L38:
            return (r124 + r102) + r100.unknownFields().size();
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FieldFilterValue decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FieldFilterValue r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FieldFilterValue r101) throws IOException {
            MemberFieldFilterValue r102 = r101.mmember_value;
            if (r102 == null) goto L5;
            MemberFieldFilterValue.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            DatetimeFieldFilterValue r103 = r101.mdatetime_value;
            if (r103 == null) goto L8;
            DatetimeFieldFilterValue.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            NumberFieldFilterValue r104 = r101.mnumber_value;
            if (r104 == null) goto L11;
            NumberFieldFilterValue.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            OptionFieldFilterValue r105 = r101.moption_value;
            if (r105 == null) goto L14;
            OptionFieldFilterValue.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            TextFieldFilterValue r106 = r101.mtext_value;
            if (r106 == null) goto L17;
            TextFieldFilterValue.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            TaskCompleteStatusFieldFilterValue r107 = r101.mtask_complete_status_value;
            if (r107 == null) goto L20;
            TaskCompleteStatusFieldFilterValue.ADAPTER.encodeWithTag(r100, 100, r107);
        L20:
            TaskSourceTypeFieldFilterValue r108 = r101.mtask_source_type_value;
            if (r108 == null) goto L23;
            TaskSourceTypeFieldFilterValue.ADAPTER.encodeWithTag(r100, 101, r108);
        L23:
            TaskSourceFieldFilterValue r109 = r101.mtask_source_value;
            if (r109 == null) goto L26;
            TaskSourceFieldFilterValue.ADAPTER.encodeWithTag(r100, 102, r109);
        L26:
            TaskSectionFieldFilterValue r110 = r101.mtask_section_value;
            if (r110 == null) goto L29;
            TaskSectionFieldFilterValue.ADAPTER.encodeWithTag(r100, 103, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FieldFilterValue r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FieldFilterValue();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmember_value = this.mmember_value;
        r100.mdatetime_value = this.mdatetime_value;
        r100.mnumber_value = this.mnumber_value;
        r100.moption_value = this.moption_value;
        r100.mtext_value = this.mtext_value;
        r100.mtask_complete_status_value = this.mtask_complete_status_value;
        r100.mtask_source_type_value = this.mtask_source_type_value;
        r100.mtask_source_value = this.mtask_source_value;
        r100.mtask_section_value = this.mtask_section_value;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FieldFilterValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FieldFilterValue(MemberFieldFilterValue r110, DatetimeFieldFilterValue r111, NumberFieldFilterValue r112, OptionFieldFilterValue r113, TextFieldFilterValue r114, TaskCompleteStatusFieldFilterValue r115, TaskSourceTypeFieldFilterValue r116, TaskSourceFieldFilterValue r117, TaskSectionFieldFilterValue r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public FieldFilterValue(MemberFieldFilterValue r100, DatetimeFieldFilterValue r101, NumberFieldFilterValue r102, OptionFieldFilterValue r103, TextFieldFilterValue r104, TaskCompleteStatusFieldFilterValue r105, TaskSourceTypeFieldFilterValue r106, TaskSourceFieldFilterValue r107, TaskSectionFieldFilterValue r110, ByteString r111) {
        super(ADAPTER, r111);
        this.mmember_value = r100;
        this.mdatetime_value = r101;
        this.mnumber_value = r102;
        this.moption_value = r103;
        this.mtext_value = r104;
        this.mtask_complete_status_value = r105;
        this.mtask_source_type_value = r106;
        this.mtask_source_value = r107;
        this.mtask_section_value = r110;
    }
}
