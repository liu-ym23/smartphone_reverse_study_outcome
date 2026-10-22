package com.ss.android.lark.pb.department;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ExtendParam extends Message<ExtendParam, Builder> {
    public static final ProtoAdapter<ExtendParam> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_INVITE_SAME_CHAT_TAG = null;
    public static final Boolean DEFAULT_HAS_LEAD_PERM = null;
    public static final String DEFAULT_IN_CHAT_ID = "";
    public static final Boolean DEFAULT_IS_SECRET_CHAT = null;
    public static final Boolean DEFAULT_NEED_USERS_PROFILE_FIELDS = null;
    private static final long serialVersionUID = 0;
    public final ActionType maction_type;
    public final com.ss.android.lark.pb.misc.ActionType mbusiness_scene;
    public final Boolean mcan_invite_same_chat_tag;
    public final Boolean mhas_lead_perm;
    public final String min_chat_id;
    public final Boolean mis_secret_chat;
    public final Boolean mneed_users_profile_fields;

    public static final class Builder extends Message.Builder<ExtendParam, Builder> {
        public ActionType maction_type;
        public com.ss.android.lark.pb.misc.ActionType mbusiness_scene;
        public Boolean mcan_invite_same_chat_tag;
        public Boolean mhas_lead_perm;
        public String min_chat_id;
        public Boolean mis_secret_chat;
        public Boolean mneed_users_profile_fields;

        @Override // com.squareup.wire.Message.Builder
        public ExtendParam build() {
            return new ExtendParam(this.min_chat_id, this.mcan_invite_same_chat_tag, this.mis_secret_chat, this.maction_type, this.mbusiness_scene, this.mhas_lead_perm, this.mneed_users_profile_fields, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_type(ActionType r100) {
            this.maction_type = r100;
            return this;
        }

        public Builder business_scene(com.ss.android.lark.pb.misc.ActionType r100) {
            this.mbusiness_scene = r100;
            return this;
        }

        public Builder can_invite_same_chat_tag(Boolean r100) {
            this.mcan_invite_same_chat_tag = r100;
            return this;
        }

        public Builder has_lead_perm(Boolean r100) {
            this.mhas_lead_perm = r100;
            return this;
        }

        public Builder in_chat_id(String r100) {
            this.min_chat_id = r100;
            return this;
        }

        public Builder is_secret_chat(Boolean r100) {
            this.mis_secret_chat = r100;
            return this;
        }

        public Builder need_users_profile_fields(Boolean r100) {
            this.mneed_users_profile_fields = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtendParam extends ProtoAdapter<ExtendParam> {
        public ProtoAdapter_ExtendParam() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtendParam.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExtendParam decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.min_chat_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.mcan_invite_same_chat_tag = r102;
            r101.mis_secret_chat = r102;
            r101.mhas_lead_perm = r102;
            r101.mneed_users_profile_fields = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L20;
            switch(r104) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L24;
                case 5: goto L22;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L22:
            r101.mbusiness_scene = com.ss.android.lark.pb.misc.ActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L24:
            r101.maction_type = ActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mneed_users_profile_fields = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.mhas_lead_perm = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.mis_secret_chat = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.mcan_invite_same_chat_tag = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.min_chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ExtendParam r100) {
            String r101 = r100.min_chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.mcan_invite_same_chat_tag;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mis_secret_chat;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ActionType r110 = r100.maction_type;
            if (r110 == null) goto L17;
            int r111 = ActionType.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            com.ss.android.lark.pb.misc.ActionType r113 = r100.mbusiness_scene;
            if (r113 == null) goto L21;
            int r114 = com.ss.android.lark.pb.misc.ActionType.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.mhas_lead_perm;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.mneed_users_profile_fields;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ExtendParam decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExtendParam r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExtendParam r101) throws IOException {
            String r102 = r101.min_chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.mcan_invite_same_chat_tag;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mis_secret_chat;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            ActionType r105 = r101.maction_type;
            if (r105 == null) goto L14;
            ActionType.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            com.ss.android.lark.pb.misc.ActionType r106 = r101.mbusiness_scene;
            if (r106 == null) goto L17;
            com.ss.android.lark.pb.misc.ActionType.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.mhas_lead_perm;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.mneed_users_profile_fields;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtendParam r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExtendParam();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_CAN_INVITE_SAME_CHAT_TAG = r100;
        DEFAULT_IS_SECRET_CHAT = r100;
        DEFAULT_HAS_LEAD_PERM = r100;
        DEFAULT_NEED_USERS_PROFILE_FIELDS = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.min_chat_id = this.min_chat_id;
        r100.mcan_invite_same_chat_tag = this.mcan_invite_same_chat_tag;
        r100.mis_secret_chat = this.mis_secret_chat;
        r100.maction_type = this.maction_type;
        r100.mbusiness_scene = this.mbusiness_scene;
        r100.mhas_lead_perm = this.mhas_lead_perm;
        r100.mneed_users_profile_fields = this.mneed_users_profile_fields;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExtendParam.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExtendParam(String r110, Boolean r111, Boolean r112, ActionType r113, com.ss.android.lark.pb.misc.ActionType r114, Boolean r115, Boolean r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public ExtendParam(String r100, Boolean r101, Boolean r102, ActionType r103, com.ss.android.lark.pb.misc.ActionType r104, Boolean r105, Boolean r106, ByteString r107) {
        super(ADAPTER, r107);
        this.min_chat_id = r100;
        this.mcan_invite_same_chat_tag = r101;
        this.mis_secret_chat = r102;
        this.maction_type = r103;
        this.mbusiness_scene = r104;
        this.mhas_lead_perm = r105;
        this.mneed_users_profile_fields = r106;
    }
}
