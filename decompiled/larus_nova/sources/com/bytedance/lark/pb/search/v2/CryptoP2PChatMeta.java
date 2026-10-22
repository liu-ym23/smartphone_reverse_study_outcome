package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.WorkStatus;
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
public final class CryptoP2PChatMeta extends Message<CryptoP2PChatMeta, Builder> {
    public static final ProtoAdapter<CryptoP2PChatMeta> ADAPTER = null;
    public static final Boolean DEFAULT_ACCEPT_SMS_PHONE_URGENT = null;
    public static final String DEFAULT_CHATTER_ID = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Chatter.Description.Type DEFAULT_DESCRIPTION_FLAG = null;
    public static final Long DEFAULT_DO_NOT_DISTURB_END_TIME = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_REGISTERED = null;
    public static final String DEFAULT_MAIL_ADDRESS = "";
    public static final String DEFAULT_TENANT_ID = "";
    private static final long serialVersionUID = 0;
    public final Boolean accept_sms_phone_urgent;
    public final String chatter_id;
    public final List<Chatter.ChatterCustomStatus> custom_status;
    public final String description;
    public final Chatter.Description.Type description_flag;
    public final Long do_not_disturb_end_time;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253705id;
    public final Boolean is_registered;
    public final String mail_address;
    public final SimpleP2PChatInfo p2p_chat_info;
    public final TagData relation_tag;
    public final String tenant_id;
    public final WorkStatus work_status;

    public static final class Builder extends Message.Builder<CryptoP2PChatMeta, Builder> {
        public Boolean accept_sms_phone_urgent;
        public String chatter_id;
        public List<Chatter.ChatterCustomStatus> custom_status;
        public String description;
        public Chatter.Description.Type description_flag;
        public Long do_not_disturb_end_time;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253706id;
        public Boolean is_registered;
        public String mail_address;
        public SimpleP2PChatInfo p2p_chat_info;
        public TagData relation_tag;
        public String tenant_id;
        public WorkStatus work_status;

        @Override // com.squareup.wire.Message.Builder
        public CryptoP2PChatMeta build() {
            String r100 = this.f253706id;
            if (r100 == null) goto L7;
            return new CryptoP2PChatMeta(this.f253706id, this.is_registered, this.tenant_id, this.mail_address, this.do_not_disturb_end_time, this.accept_sms_phone_urgent, this.description, this.description_flag, this.work_status, this.chatter_id, this.p2p_chat_info, this.custom_status, this.relation_tag, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
            this.custom_status = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder accept_sms_phone_urgent(Boolean r100) {
            this.accept_sms_phone_urgent = r100;
            return this;
        }

        public Builder chatter_id(String r100) {
            this.chatter_id = r100;
            return this;
        }

        public Builder custom_status(List<Chatter.ChatterCustomStatus> r100) {
            Internal.checkElementsNotNull(r100);
            this.custom_status = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder description_flag(Chatter.Description.Type r100) {
            this.description_flag = r100;
            return this;
        }

        public Builder do_not_disturb_end_time(Long r100) {
            this.do_not_disturb_end_time = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253706id = r100;
            return this;
        }

        public Builder is_registered(Boolean r100) {
            this.is_registered = r100;
            return this;
        }

        public Builder mail_address(String r100) {
            this.mail_address = r100;
            return this;
        }

        public Builder p2p_chat_info(SimpleP2PChatInfo r100) {
            this.p2p_chat_info = r100;
            return this;
        }

        public Builder relation_tag(TagData r100) {
            this.relation_tag = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.tenant_id = r100;
            return this;
        }

        public Builder work_status(WorkStatus r100) {
            this.work_status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CryptoP2PChatMeta extends ProtoAdapter<CryptoP2PChatMeta> {
        public ProtoAdapter_CryptoP2PChatMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, CryptoP2PChatMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CryptoP2PChatMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253706id = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_registered = r102;
            r101.tenant_id = "";
            r101.mail_address = "";
            r101.do_not_disturb_end_time = 0L;
            r101.accept_sms_phone_urgent = r102;
            r101.description = "";
            r101.description_flag = Chatter.Description.Type.ON_DEFAULT;
            r101.chatter_id = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L23;
            switch(r104) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L25;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L25:
            r101.description_flag = Chatter.Description.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.relation_tag = TagData.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.custom_status.add(Chatter.ChatterCustomStatus.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.p2p_chat_info = SimpleP2PChatInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.work_status = WorkStatus.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.accept_sms_phone_urgent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.do_not_disturb_end_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L19:
            r101.mail_address = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.is_registered = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L22:
            r101.f253706id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L23:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CryptoP2PChatMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253705id);
            Boolean r103 = r100.is_registered;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.tenant_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.mail_address;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Long r113 = r100.do_not_disturb_end_time;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.accept_sms_phone_urgent;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.description;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            Chatter.Description.Type r122 = r100.description_flag;
            if (r122 == null) goto L29;
            int r123 = Chatter.Description.Type.ADAPTER.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            WorkStatus r125 = r100.work_status;
            if (r125 == null) goto L33;
            int r126 = WorkStatus.ADAPTER.encodedSizeWithTag(9, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.chatter_id;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(10, r128);
        L38:
            int r130 = r127 + r129;
            SimpleP2PChatInfo r131 = r100.p2p_chat_info;
            if (r131 == null) goto L41;
            int r132 = SimpleP2PChatInfo.ADAPTER.encodedSizeWithTag(11, r131);
        L42:
            int r133 = (r130 + r132) + Chatter.ChatterCustomStatus.ADAPTER.asRepeated().encodedSizeWithTag(12, r100.custom_status);
            TagData r134 = r100.relation_tag;
            if (r134 == null) goto L46;
            r104 = TagData.ADAPTER.encodedSizeWithTag(13, r134);
        L46:
            return (r133 + r104) + r100.unknownFields().size();
        L41:
            r132 = 0;
            goto L42
        L37:
            r129 = 0;
            goto L38
        L33:
            r126 = 0;
            goto L34
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CryptoP2PChatMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CryptoP2PChatMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CryptoP2PChatMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253705id);
            Boolean r103 = r101.is_registered;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.tenant_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.mail_address;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            Long r106 = r101.do_not_disturb_end_time;
            if (r106 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L14:
            Boolean r107 = r101.accept_sms_phone_urgent;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.description;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            Chatter.Description.Type r109 = r101.description_flag;
            if (r109 == null) goto L23;
            Chatter.Description.Type.ADAPTER.encodeWithTag(r100, 8, r109);
        L23:
            WorkStatus r110 = r101.work_status;
            if (r110 == null) goto L26;
            WorkStatus.ADAPTER.encodeWithTag(r100, 9, r110);
        L26:
            String r111 = r101.chatter_id;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 10, r111);
        L29:
            SimpleP2PChatInfo r112 = r101.p2p_chat_info;
            if (r112 == null) goto L32;
            SimpleP2PChatInfo.ADAPTER.encodeWithTag(r100, 11, r112);
        L32:
            Chatter.ChatterCustomStatus.ADAPTER.asRepeated().encodeWithTag(r100, 12, r101.custom_status);
            TagData r113 = r101.relation_tag;
            if (r113 == null) goto L35;
            TagData.ADAPTER.encodeWithTag(r100, 13, r113);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CryptoP2PChatMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CryptoP2PChatMeta();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_REGISTERED = r100;
        DEFAULT_DO_NOT_DISTURB_END_TIME = 0L;
        DEFAULT_ACCEPT_SMS_PHONE_URGENT = r100;
        DEFAULT_DESCRIPTION_FLAG = Chatter.Description.Type.ON_DEFAULT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253706id = this.f253705id;
        r100.is_registered = this.is_registered;
        r100.tenant_id = this.tenant_id;
        r100.mail_address = this.mail_address;
        r100.do_not_disturb_end_time = this.do_not_disturb_end_time;
        r100.accept_sms_phone_urgent = this.accept_sms_phone_urgent;
        r100.description = this.description;
        r100.description_flag = this.description_flag;
        r100.work_status = this.work_status;
        r100.chatter_id = this.chatter_id;
        r100.p2p_chat_info = this.p2p_chat_info;
        r100.custom_status = Internal.copyOf("custom_status", this.custom_status);
        r100.relation_tag = this.relation_tag;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CryptoP2PChatMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CryptoP2PChatMeta(String r110, Boolean r111, String r112, String r113, Long r210, Boolean r211, String r212, Chatter.Description.Type r213, WorkStatus r214, String r215, SimpleP2PChatInfo r216, List<Chatter.ChatterCustomStatus> r217, TagData r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public CryptoP2PChatMeta(String r100, Boolean r101, String r102, String r103, Long r104, Boolean r105, String r106, Chatter.Description.Type r107, WorkStatus r110, String r111, SimpleP2PChatInfo r112, List<Chatter.ChatterCustomStatus> r113, TagData r114, ByteString r115) {
        super(ADAPTER, r115);
        this.f253705id = r100;
        this.is_registered = r101;
        this.tenant_id = r102;
        this.mail_address = r103;
        this.do_not_disturb_end_time = r104;
        this.accept_sms_phone_urgent = r105;
        this.description = r106;
        this.description_flag = r107;
        this.work_status = r110;
        this.chatter_id = r111;
        this.p2p_chat_info = r112;
        this.custom_status = Internal.immutableCopyOf("custom_status", r113);
        this.relation_tag = r114;
    }
}
