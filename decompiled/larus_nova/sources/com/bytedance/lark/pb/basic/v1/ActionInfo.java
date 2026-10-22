package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ActionInfo extends com.squareup.wire.Message<ActionInfo, Builder> {
    public static final ProtoAdapter<ActionInfo> ADAPTER = null;
    public static final ActionCode DEFAULT_ACTION_CODE = null;
    public static final String DEFAULT_I18N_TEXT = "";
    public static final ActionOperateCode DEFAULT_OPERATOR_CODE = null;
    private static final long serialVersionUID = 0;
    public final ActionCode action_code;
    public final ActionExtraInfo extra;
    public final String i18n_text;
    public final ActionOperateCode operator_code;

    public static final enum ActionCode extends Enum<ActionCode> implements WireEnum {
        private static final /* synthetic */ ActionCode[] $VALUES = null;
        public static final ActionCode ACTION_APPLY_USE = null;
        public static final ActionCode ACTION_APPLY_VISIBLE = null;
        public static final ActionCode ACTION_CONTACT_ADMIN = null;
        public static final ActionCode ACTION_NONE = null;
        public static final ProtoAdapter<ActionCode> ADAPTER = null;
        public static final ActionCode UNKNOWN = null;
        private final int value;

        static {
            ActionCode r100 = new ActionCode("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ActionCode r101 = new ActionCode("ACTION_NONE", 1, 1);
            ACTION_NONE = r101;
            ActionCode r102 = new ActionCode("ACTION_CONTACT_ADMIN", 2, 2);
            ACTION_CONTACT_ADMIN = r102;
            ActionCode r103 = new ActionCode("ACTION_APPLY_USE", 3, 3);
            ACTION_APPLY_USE = r103;
            ActionCode r104 = new ActionCode("ACTION_APPLY_VISIBLE", 4, 4);
            ACTION_APPLY_VISIBLE = r104;
            $VALUES = new ActionCode[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(ActionCode.class);
        }

        public static ActionCode[] values() {
            return (ActionCode[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ActionCode fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return ACTION_APPLY_VISIBLE;
        L16:
            return ACTION_APPLY_USE;
        L18:
            return ACTION_CONTACT_ADMIN;
        L20:
            return ACTION_NONE;
        L22:
            return UNKNOWN;
        }

        public static ActionCode valueOf(String r100) {
            return (ActionCode) a.a(ActionCode.class, r100);
        }

        private ActionCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ActionOperateCode extends Enum<ActionOperateCode> implements WireEnum {
        private static final /* synthetic */ ActionOperateCode[] $VALUES = null;
        public static final ProtoAdapter<ActionOperateCode> ADAPTER = null;
        public static final ActionOperateCode CLOSE_APP = null;
        public static final ActionOperateCode CLOSE_WINDOW = null;
        public static final ActionOperateCode UNKNOWN_OP = null;
        private final int value;

        static {
            ActionOperateCode r100 = new ActionOperateCode("UNKNOWN_OP", 0, 0);
            UNKNOWN_OP = r100;
            ActionOperateCode r101 = new ActionOperateCode("CLOSE_WINDOW", 1, 1);
            CLOSE_WINDOW = r101;
            ActionOperateCode r102 = new ActionOperateCode("CLOSE_APP", 2, 2);
            CLOSE_APP = r102;
            $VALUES = new ActionOperateCode[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ActionOperateCode.class);
        }

        public static ActionOperateCode[] values() {
            return (ActionOperateCode[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ActionOperateCode fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CLOSE_APP;
        L12:
            return CLOSE_WINDOW;
        L14:
            return UNKNOWN_OP;
        }

        public static ActionOperateCode valueOf(String r100) {
            return (ActionOperateCode) a.a(ActionOperateCode.class, r100);
        }

        private ActionOperateCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<ActionInfo, Builder> {
        public ActionCode action_code;
        public ActionExtraInfo extra;
        public String i18n_text;
        public ActionOperateCode operator_code;

        @Override // com.squareup.wire.Message.Builder
        public ActionInfo build() {
            return new ActionInfo(this.i18n_text, this.operator_code, this.action_code, this.extra, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder action_code(ActionCode r100) {
            this.action_code = r100;
            return this;
        }

        public Builder extra(ActionExtraInfo r100) {
            this.extra = r100;
            return this;
        }

        public Builder i18n_text(String r100) {
            this.i18n_text = r100;
            return this;
        }

        public Builder operator_code(ActionOperateCode r100) {
            this.operator_code = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ActionInfo extends ProtoAdapter<ActionInfo> {
        public ProtoAdapter_ActionInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ActionInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ActionInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.i18n_text = "";
            r101.operator_code = ActionOperateCode.UNKNOWN_OP;
            r101.action_code = ActionCode.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.i18n_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.operator_code = ActionOperateCode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.action_code = ActionCode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.extra = ActionExtraInfo.ADAPTER.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ActionInfo r100) {
            String r101 = r100.i18n_text;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ActionOperateCode r104 = r100.operator_code;
            if (r104 == null) goto L9;
            int r105 = ActionOperateCode.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ActionCode r107 = r100.action_code;
            if (r107 == null) goto L13;
            int r108 = ActionCode.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ActionExtraInfo r110 = r100.extra;
            if (r110 == null) goto L18;
            r102 = ActionExtraInfo.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ActionInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ActionInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ActionInfo r101) throws IOException {
            String r102 = r101.i18n_text;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ActionOperateCode r103 = r101.operator_code;
            if (r103 == null) goto L8;
            ActionOperateCode.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ActionCode r104 = r101.action_code;
            if (r104 == null) goto L11;
            ActionCode.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            ActionExtraInfo r105 = r101.extra;
            if (r105 == null) goto L14;
            ActionExtraInfo.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ActionInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ActionInfo();
        DEFAULT_OPERATOR_CODE = ActionOperateCode.UNKNOWN_OP;
        DEFAULT_ACTION_CODE = ActionCode.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.i18n_text = this.i18n_text;
        r100.operator_code = this.operator_code;
        r100.action_code = this.action_code;
        r100.extra = this.extra;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ActionInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ActionInfo(String r100, ActionOperateCode r101, ActionCode r102, ActionExtraInfo r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ActionInfo(String r100, ActionOperateCode r101, ActionCode r102, ActionExtraInfo r103, ByteString r104) {
        super(ADAPTER, r104);
        this.i18n_text = r100;
        this.operator_code = r101;
        this.action_code = r102;
        this.extra = r103;
    }
}
