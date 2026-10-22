package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskFieldValue extends Message<TaskFieldValue, Builder> {
    public static final ProtoAdapter<TaskFieldValue> ADAPTER = null;
    public static final String DEFAULT_FIELD_KEY = "";
    public static final FieldType DEFAULT_FIELD_TYPE = null;
    public static final String DEFAULT_TASK_GUID = "";
    private static final long serialVersionUID = 0;
    public final DatetimeFieldValue datetime_field_value;
    public final String field_key;
    public final FieldType field_type;
    public final MemberFieldValue member_field_value;
    public final MultiSelectFieldValue multi_select_field_value;
    public final NumberFieldValue number_field_value;
    public final SingleSelectFieldValue single_select_field_value;
    public final String task_guid;
    public final TextFieldValue text_field_value;

    public static final class Builder extends Message.Builder<TaskFieldValue, Builder> {
        public DatetimeFieldValue datetime_field_value;
        public String field_key;
        public FieldType field_type;
        public MemberFieldValue member_field_value;
        public MultiSelectFieldValue multi_select_field_value;
        public NumberFieldValue number_field_value;
        public SingleSelectFieldValue single_select_field_value;
        public String task_guid;
        public TextFieldValue text_field_value;

        @Override // com.squareup.wire.Message.Builder
        public TaskFieldValue build() {
            return new TaskFieldValue(this.field_key, this.field_type, this.task_guid, this.member_field_value, this.number_field_value, this.datetime_field_value, this.single_select_field_value, this.multi_select_field_value, this.text_field_value, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder datetime_field_value(DatetimeFieldValue r100) {
            this.datetime_field_value = r100;
            this.member_field_value = null;
            this.number_field_value = null;
            this.single_select_field_value = null;
            this.multi_select_field_value = null;
            this.text_field_value = null;
            return this;
        }

        public Builder field_key(String r100) {
            this.field_key = r100;
            return this;
        }

        public Builder field_type(FieldType r100) {
            this.field_type = r100;
            return this;
        }

        public Builder member_field_value(MemberFieldValue r100) {
            this.member_field_value = r100;
            this.number_field_value = null;
            this.datetime_field_value = null;
            this.single_select_field_value = null;
            this.multi_select_field_value = null;
            this.text_field_value = null;
            return this;
        }

        public Builder multi_select_field_value(MultiSelectFieldValue r100) {
            this.multi_select_field_value = r100;
            this.member_field_value = null;
            this.number_field_value = null;
            this.datetime_field_value = null;
            this.single_select_field_value = null;
            this.text_field_value = null;
            return this;
        }

        public Builder number_field_value(NumberFieldValue r100) {
            this.number_field_value = r100;
            this.member_field_value = null;
            this.datetime_field_value = null;
            this.single_select_field_value = null;
            this.multi_select_field_value = null;
            this.text_field_value = null;
            return this;
        }

        public Builder single_select_field_value(SingleSelectFieldValue r100) {
            this.single_select_field_value = r100;
            this.member_field_value = null;
            this.number_field_value = null;
            this.datetime_field_value = null;
            this.multi_select_field_value = null;
            this.text_field_value = null;
            return this;
        }

        public Builder task_guid(String r100) {
            this.task_guid = r100;
            return this;
        }

        public Builder text_field_value(TextFieldValue r100) {
            this.text_field_value = r100;
            this.member_field_value = null;
            this.number_field_value = null;
            this.datetime_field_value = null;
            this.single_select_field_value = null;
            this.multi_select_field_value = null;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskFieldValue extends ProtoAdapter<TaskFieldValue> {
        public ProtoAdapter_TaskFieldValue() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskFieldValue.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskFieldValue decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.field_key = "";
            r101.field_type = FieldType.UNKNOWN_FIELD_TYPE;
            r101.task_guid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L25;
            if (r103 != 1) goto L8;
            r101.field_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.field_type = FieldType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.task_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            switch(r103) {
                case 101: goto L18;
                case 102: goto L17;
                case 103: goto L16;
                case 104: goto L15;
                case 105: goto L14;
                case 106: goto L13;
                default: goto L12;
            };
        L13:
            r101.text_field_value(TextFieldValue.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.multi_select_field_value(MultiSelectFieldValue.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.single_select_field_value(SingleSelectFieldValue.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.datetime_field_value(DatetimeFieldValue.ADAPTER.decode(r100));
            goto L3
        L17:
            r101.number_field_value(NumberFieldValue.ADAPTER.decode(r100));
            goto L3
        L18:
            r101.member_field_value(MemberFieldValue.ADAPTER.decode(r100));
            goto L3
        L12:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L25:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskFieldValue r100) {
            String r101 = r100.field_key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            FieldType r104 = r100.field_type;
            if (r104 == null) goto L9;
            int r105 = FieldType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.task_guid;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            MemberFieldValue r110 = r100.member_field_value;
            if (r110 == null) goto L17;
            int r111 = MemberFieldValue.ADAPTER.encodedSizeWithTag(101, r110);
        L18:
            int r112 = r109 + r111;
            NumberFieldValue r113 = r100.number_field_value;
            if (r113 == null) goto L21;
            int r114 = NumberFieldValue.ADAPTER.encodedSizeWithTag(102, r113);
        L22:
            int r115 = r112 + r114;
            DatetimeFieldValue r116 = r100.datetime_field_value;
            if (r116 == null) goto L25;
            int r117 = DatetimeFieldValue.ADAPTER.encodedSizeWithTag(103, r116);
        L26:
            int r118 = r115 + r117;
            SingleSelectFieldValue r119 = r100.single_select_field_value;
            if (r119 == null) goto L29;
            int r120 = SingleSelectFieldValue.ADAPTER.encodedSizeWithTag(104, r119);
        L30:
            int r121 = r118 + r120;
            MultiSelectFieldValue r122 = r100.multi_select_field_value;
            if (r122 == null) goto L33;
            int r123 = MultiSelectFieldValue.ADAPTER.encodedSizeWithTag(105, r122);
        L34:
            int r124 = r121 + r123;
            TextFieldValue r125 = r100.text_field_value;
            if (r125 == null) goto L38;
            r102 = TextFieldValue.ADAPTER.encodedSizeWithTag(106, r125);
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
        public /* bridge */ /* synthetic */ TaskFieldValue decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskFieldValue r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskFieldValue r101) throws IOException {
            String r102 = r101.field_key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            FieldType r103 = r101.field_type;
            if (r103 == null) goto L8;
            FieldType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.task_guid;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            MemberFieldValue r105 = r101.member_field_value;
            if (r105 == null) goto L14;
            MemberFieldValue.ADAPTER.encodeWithTag(r100, 101, r105);
        L14:
            NumberFieldValue r106 = r101.number_field_value;
            if (r106 == null) goto L17;
            NumberFieldValue.ADAPTER.encodeWithTag(r100, 102, r106);
        L17:
            DatetimeFieldValue r107 = r101.datetime_field_value;
            if (r107 == null) goto L20;
            DatetimeFieldValue.ADAPTER.encodeWithTag(r100, 103, r107);
        L20:
            SingleSelectFieldValue r108 = r101.single_select_field_value;
            if (r108 == null) goto L23;
            SingleSelectFieldValue.ADAPTER.encodeWithTag(r100, 104, r108);
        L23:
            MultiSelectFieldValue r109 = r101.multi_select_field_value;
            if (r109 == null) goto L26;
            MultiSelectFieldValue.ADAPTER.encodeWithTag(r100, 105, r109);
        L26:
            TextFieldValue r110 = r101.text_field_value;
            if (r110 == null) goto L29;
            TextFieldValue.ADAPTER.encodeWithTag(r100, 106, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskFieldValue r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskFieldValue();
        DEFAULT_FIELD_TYPE = FieldType.UNKNOWN_FIELD_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.field_key = this.field_key;
        r100.field_type = this.field_type;
        r100.task_guid = this.task_guid;
        r100.member_field_value = this.member_field_value;
        r100.number_field_value = this.number_field_value;
        r100.datetime_field_value = this.datetime_field_value;
        r100.single_select_field_value = this.single_select_field_value;
        r100.multi_select_field_value = this.multi_select_field_value;
        r100.text_field_value = this.text_field_value;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskFieldValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskFieldValue(String r110, FieldType r111, String r112, MemberFieldValue r113, NumberFieldValue r114, DatetimeFieldValue r115, SingleSelectFieldValue r116, MultiSelectFieldValue r117, TextFieldValue r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public TaskFieldValue(String r100, FieldType r101, String r102, MemberFieldValue r103, NumberFieldValue r104, DatetimeFieldValue r105, SingleSelectFieldValue r106, MultiSelectFieldValue r107, TextFieldValue r110, ByteString r111) {
        super(ADAPTER, r111);
        if (Internal.countNonNull(r103, r104, r105, r106, new Object[]{r107, r110}) > 1) goto L7;
        this.field_key = r100;
        this.field_type = r101;
        this.task_guid = r102;
        this.member_field_value = r103;
        this.number_field_value = r104;
        this.datetime_field_value = r105;
        this.single_select_field_value = r106;
        this.multi_select_field_value = r107;
        this.text_field_value = r110;
        return;
    L7:
        throw new IllegalArgumentException("at most one of member_field_value, number_field_value, datetime_field_value, single_select_field_value, multi_select_field_value, text_field_value may be non-null");
    }
}
