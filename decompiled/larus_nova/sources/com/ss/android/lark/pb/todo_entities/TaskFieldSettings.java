package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class TaskFieldSettings extends Message<TaskFieldSettings, Builder> {
    public static final ProtoAdapter<TaskFieldSettings> ADAPTER = null;
    public static final Boolean DEFAULT_MULTIPLE = null;
    public static final Boolean DEFAULT_READONLY = null;
    public static final Boolean DEFAULT_SELF_EDIT_ONLY = null;
    private static final long serialVersionUID = 0;
    public final DatetimeFieldSettings mdatetime_field_settings;
    public final MemberFieldSettings mmember_field_settings;
    public final MultiSelectFieldSettings mmulti_select_field_settings;
    public final Boolean mmultiple;
    public final NumberFieldSettings mnumber_field_settings;
    public final Boolean mreadonly;
    public final Boolean mself_edit_only;
    public final SingleSelectFieldSettings msingle_select_field_settings;
    public final TextFieldSettings mtext_field_settings;

    public static final class Builder extends Message.Builder<TaskFieldSettings, Builder> {
        public DatetimeFieldSettings mdatetime_field_settings;
        public MemberFieldSettings mmember_field_settings;
        public MultiSelectFieldSettings mmulti_select_field_settings;
        public Boolean mmultiple;
        public NumberFieldSettings mnumber_field_settings;
        public Boolean mreadonly;
        public Boolean mself_edit_only;
        public SingleSelectFieldSettings msingle_select_field_settings;
        public TextFieldSettings mtext_field_settings;

        @Override // com.squareup.wire.Message.Builder
        public TaskFieldSettings build() {
            return new TaskFieldSettings(this.mreadonly, this.mmultiple, this.mself_edit_only, this.mnumber_field_settings, this.mmember_field_settings, this.mdatetime_field_settings, this.msingle_select_field_settings, this.mmulti_select_field_settings, this.mtext_field_settings, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder datetime_field_settings(DatetimeFieldSettings r100) {
            this.mdatetime_field_settings = r100;
            this.mnumber_field_settings = null;
            this.mmember_field_settings = null;
            this.msingle_select_field_settings = null;
            this.mmulti_select_field_settings = null;
            this.mtext_field_settings = null;
            return this;
        }

        public Builder member_field_settings(MemberFieldSettings r100) {
            this.mmember_field_settings = r100;
            this.mnumber_field_settings = null;
            this.mdatetime_field_settings = null;
            this.msingle_select_field_settings = null;
            this.mmulti_select_field_settings = null;
            this.mtext_field_settings = null;
            return this;
        }

        public Builder multi_select_field_settings(MultiSelectFieldSettings r100) {
            this.mmulti_select_field_settings = r100;
            this.mnumber_field_settings = null;
            this.mmember_field_settings = null;
            this.mdatetime_field_settings = null;
            this.msingle_select_field_settings = null;
            this.mtext_field_settings = null;
            return this;
        }

        public Builder multiple(Boolean r100) {
            this.mmultiple = r100;
            return this;
        }

        public Builder number_field_settings(NumberFieldSettings r100) {
            this.mnumber_field_settings = r100;
            this.mmember_field_settings = null;
            this.mdatetime_field_settings = null;
            this.msingle_select_field_settings = null;
            this.mmulti_select_field_settings = null;
            this.mtext_field_settings = null;
            return this;
        }

        public Builder readonly(Boolean r100) {
            this.mreadonly = r100;
            return this;
        }

        public Builder self_edit_only(Boolean r100) {
            this.mself_edit_only = r100;
            return this;
        }

        public Builder single_select_field_settings(SingleSelectFieldSettings r100) {
            this.msingle_select_field_settings = r100;
            this.mnumber_field_settings = null;
            this.mmember_field_settings = null;
            this.mdatetime_field_settings = null;
            this.mmulti_select_field_settings = null;
            this.mtext_field_settings = null;
            return this;
        }

        public Builder text_field_settings(TextFieldSettings r100) {
            this.mtext_field_settings = r100;
            this.mnumber_field_settings = null;
            this.mmember_field_settings = null;
            this.mdatetime_field_settings = null;
            this.msingle_select_field_settings = null;
            this.mmulti_select_field_settings = null;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskFieldSettings extends ProtoAdapter<TaskFieldSettings> {
        public ProtoAdapter_TaskFieldSettings() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskFieldSettings.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskFieldSettings decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.mreadonly = r102;
            r101.mmultiple = r102;
            r101.mself_edit_only = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L22;
            if (r104 != 1) goto L8;
            r101.mreadonly = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.mmultiple = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.mself_edit_only = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            switch(r104) {
                case 101: goto L18;
                case 102: goto L17;
                case 103: goto L16;
                case 104: goto L15;
                case 105: goto L14;
                case 106: goto L13;
                default: goto L12;
            };
        L13:
            r101.text_field_settings(TextFieldSettings.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.multi_select_field_settings(MultiSelectFieldSettings.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.single_select_field_settings(SingleSelectFieldSettings.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.datetime_field_settings(DatetimeFieldSettings.ADAPTER.decode(r100));
            goto L3
        L17:
            r101.member_field_settings(MemberFieldSettings.ADAPTER.decode(r100));
            goto L3
        L18:
            r101.number_field_settings(NumberFieldSettings.ADAPTER.decode(r100));
            goto L3
        L12:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L22:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskFieldSettings r100) {
            Boolean r101 = r100.mreadonly;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.mmultiple;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mself_edit_only;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            NumberFieldSettings r110 = r100.mnumber_field_settings;
            if (r110 == null) goto L17;
            int r111 = NumberFieldSettings.ADAPTER.encodedSizeWithTag(101, r110);
        L18:
            int r112 = r109 + r111;
            MemberFieldSettings r113 = r100.mmember_field_settings;
            if (r113 == null) goto L21;
            int r114 = MemberFieldSettings.ADAPTER.encodedSizeWithTag(102, r113);
        L22:
            int r115 = r112 + r114;
            DatetimeFieldSettings r116 = r100.mdatetime_field_settings;
            if (r116 == null) goto L25;
            int r117 = DatetimeFieldSettings.ADAPTER.encodedSizeWithTag(103, r116);
        L26:
            int r118 = r115 + r117;
            SingleSelectFieldSettings r119 = r100.msingle_select_field_settings;
            if (r119 == null) goto L29;
            int r120 = SingleSelectFieldSettings.ADAPTER.encodedSizeWithTag(104, r119);
        L30:
            int r121 = r118 + r120;
            MultiSelectFieldSettings r122 = r100.mmulti_select_field_settings;
            if (r122 == null) goto L33;
            int r123 = MultiSelectFieldSettings.ADAPTER.encodedSizeWithTag(105, r122);
        L34:
            int r124 = r121 + r123;
            TextFieldSettings r125 = r100.mtext_field_settings;
            if (r125 == null) goto L38;
            r102 = TextFieldSettings.ADAPTER.encodedSizeWithTag(106, r125);
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
        public /* bridge */ /* synthetic */ TaskFieldSettings decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskFieldSettings r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskFieldSettings r101) throws IOException {
            Boolean r102 = r101.mreadonly;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.mmultiple;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mself_edit_only;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            NumberFieldSettings r105 = r101.mnumber_field_settings;
            if (r105 == null) goto L14;
            NumberFieldSettings.ADAPTER.encodeWithTag(r100, 101, r105);
        L14:
            MemberFieldSettings r106 = r101.mmember_field_settings;
            if (r106 == null) goto L17;
            MemberFieldSettings.ADAPTER.encodeWithTag(r100, 102, r106);
        L17:
            DatetimeFieldSettings r107 = r101.mdatetime_field_settings;
            if (r107 == null) goto L20;
            DatetimeFieldSettings.ADAPTER.encodeWithTag(r100, 103, r107);
        L20:
            SingleSelectFieldSettings r108 = r101.msingle_select_field_settings;
            if (r108 == null) goto L23;
            SingleSelectFieldSettings.ADAPTER.encodeWithTag(r100, 104, r108);
        L23:
            MultiSelectFieldSettings r109 = r101.mmulti_select_field_settings;
            if (r109 == null) goto L26;
            MultiSelectFieldSettings.ADAPTER.encodeWithTag(r100, 105, r109);
        L26:
            TextFieldSettings r110 = r101.mtext_field_settings;
            if (r110 == null) goto L29;
            TextFieldSettings.ADAPTER.encodeWithTag(r100, 106, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskFieldSettings r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskFieldSettings();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_READONLY = r100;
        DEFAULT_MULTIPLE = r100;
        DEFAULT_SELF_EDIT_ONLY = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mreadonly = this.mreadonly;
        r100.mmultiple = this.mmultiple;
        r100.mself_edit_only = this.mself_edit_only;
        r100.mnumber_field_settings = this.mnumber_field_settings;
        r100.mmember_field_settings = this.mmember_field_settings;
        r100.mdatetime_field_settings = this.mdatetime_field_settings;
        r100.msingle_select_field_settings = this.msingle_select_field_settings;
        r100.mmulti_select_field_settings = this.mmulti_select_field_settings;
        r100.mtext_field_settings = this.mtext_field_settings;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskFieldSettings.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskFieldSettings(Boolean r110, Boolean r111, Boolean r112, NumberFieldSettings r113, MemberFieldSettings r114, DatetimeFieldSettings r115, SingleSelectFieldSettings r116, MultiSelectFieldSettings r117, TextFieldSettings r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public TaskFieldSettings(Boolean r100, Boolean r101, Boolean r102, NumberFieldSettings r103, MemberFieldSettings r104, DatetimeFieldSettings r105, SingleSelectFieldSettings r106, MultiSelectFieldSettings r107, TextFieldSettings r110, ByteString r111) {
        super(ADAPTER, r111);
        if (Internal.countNonNull(r103, r104, r105, r106, new Object[]{r107, r110}) > 1) goto L7;
        this.mreadonly = r100;
        this.mmultiple = r101;
        this.mself_edit_only = r102;
        this.mnumber_field_settings = r103;
        this.mmember_field_settings = r104;
        this.mdatetime_field_settings = r105;
        this.msingle_select_field_settings = r106;
        this.mmulti_select_field_settings = r107;
        this.mtext_field_settings = r110;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mnumber_field_settings, mmember_field_settings, mdatetime_field_settings, msingle_select_field_settings, mmulti_select_field_settings, mtext_field_settings may be non-null");
    }
}
