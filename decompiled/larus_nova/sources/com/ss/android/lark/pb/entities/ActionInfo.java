package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class ActionInfo extends com.squareup.wire.Message<ActionInfo, Builder> {
    public static final ProtoAdapter<ActionInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ActionCode maction_code;
    public final ActionExtraInfo mextra;
    public final Map<String, String> mi18n_text;
    public final ActionOperateCode moperator_code;

    public static final enum ActionCode extends Enum<ActionCode> implements WireEnum {
        private static final /* synthetic */ ActionCode[] $VALUES = null;
        public static final ActionCode ACTION_APPLY_USE = null;
        public static final ActionCode ACTION_CONTACT_ADMIN = null;
        public static final ActionCode ACTION_NONE = null;
        public static final ProtoAdapter<ActionCode> ADAPTER = null;
        private final int value;

        static {
            ActionCode r100 = new ActionCode("ACTION_NONE", 0, 0);
            ACTION_NONE = r100;
            ActionCode r101 = new ActionCode("ACTION_CONTACT_ADMIN", 1, 1);
            ACTION_CONTACT_ADMIN = r101;
            ActionCode r102 = new ActionCode("ACTION_APPLY_USE", 2, 2);
            ACTION_APPLY_USE = r102;
            $VALUES = new ActionCode[]{r100, r101, r102};
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
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return ACTION_APPLY_USE;
        L12:
            return ACTION_CONTACT_ADMIN;
        L14:
            return ACTION_NONE;
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
        private final int value;

        static {
            ActionOperateCode r100 = new ActionOperateCode("CLOSE_WINDOW", 0, 1);
            CLOSE_WINDOW = r100;
            ActionOperateCode r101 = new ActionOperateCode("CLOSE_APP", 1, 2);
            CLOSE_APP = r101;
            $VALUES = new ActionOperateCode[]{r100, r101};
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
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return CLOSE_APP;
        L11:
            return CLOSE_WINDOW;
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
        public ActionCode maction_code;
        public ActionExtraInfo mextra;
        public Map<String, String> mi18n_text;
        public ActionOperateCode moperator_code;

        @Override // com.squareup.wire.Message.Builder
        public ActionInfo build() {
            return new ActionInfo(this.mi18n_text, this.moperator_code, this.maction_code, this.mextra, super.buildUnknownFields());
        }

        public Builder() {
            this.mi18n_text = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder action_code(ActionCode r100) {
            this.maction_code = r100;
            return this;
        }

        public Builder extra(ActionExtraInfo r100) {
            this.mextra = r100;
            return this;
        }

        public Builder i18n_text(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_text = r100;
            return this;
        }

        public Builder operator_code(ActionOperateCode r100) {
            this.moperator_code = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ActionInfo extends ProtoAdapter<ActionInfo> {
        private final ProtoAdapter<Map<String, String>> mi18n_text;

        public ProtoAdapter_ActionInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ActionInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mi18n_text = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ActionInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.mi18n_text.putAll(this.mi18n_text.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.moperator_code = ActionOperateCode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.maction_code = ActionCode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mextra = ActionExtraInfo.ADAPTER.decode(r100);
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
            int r101 = this.mi18n_text.encodedSizeWithTag(1, r100.mi18n_text);
            ActionOperateCode r102 = r100.moperator_code;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ActionOperateCode.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            ActionCode r106 = r100.maction_code;
            if (r106 == null) goto L9;
            int r107 = ActionCode.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            ActionExtraInfo r109 = r100.mextra;
            if (r109 == null) goto L14;
            r103 = ActionExtraInfo.ADAPTER.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
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
            this.mi18n_text.encodeWithTag(r100, 1, r101.mi18n_text);
            ActionOperateCode r102 = r101.moperator_code;
            if (r102 == null) goto L5;
            ActionOperateCode.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            ActionCode r103 = r101.maction_code;
            if (r103 == null) goto L8;
            ActionCode.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            ActionExtraInfo r104 = r101.mextra;
            if (r104 == null) goto L11;
            ActionExtraInfo.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ActionInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ActionInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mi18n_text = Internal.copyOf("mi18n_text", this.mi18n_text);
        r100.moperator_code = this.moperator_code;
        r100.maction_code = this.maction_code;
        r100.mextra = this.mextra;
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

    public ActionInfo(Map<String, String> r100, ActionOperateCode r101, ActionCode r102, ActionExtraInfo r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ActionInfo(Map<String, String> r100, ActionOperateCode r101, ActionCode r102, ActionExtraInfo r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mi18n_text = Internal.immutableCopyOf("mi18n_text", r100);
        this.moperator_code = r101;
        this.maction_code = r102;
        this.mextra = r103;
    }
}
