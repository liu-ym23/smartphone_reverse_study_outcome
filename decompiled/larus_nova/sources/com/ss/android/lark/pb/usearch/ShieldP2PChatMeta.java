package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.ChatterCustomStatus;
import com.ss.android.lark.pb.entities.TagData;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ShieldP2PChatMeta extends Message<ShieldP2PChatMeta, Builder> {
    public static final ProtoAdapter<ShieldP2PChatMeta> ADAPTER = null;
    public static final Boolean DEFAULT_ACCEPT_SMS_PHONE_URGENT = null;
    public static final String DEFAULT_CHATTER_ID = "";
    public static final Long DEFAULT_DO_NOT_DISTURB_END_TIME = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_REGISTERED = null;
    public static final String DEFAULT_MAIL_ADDRESS = "";
    public static final String DEFAULT_TENANT_ID = "";
    private static final long serialVersionUID = 0;
    public final Boolean maccept_sms_phone_urgent;
    public final String mchatter_id;
    public final List<ChatterCustomStatus> mcustom_statuses;
    public final Long mdo_not_disturb_end_time;
    public final String mid;
    public final Boolean mis_registered;
    public final String mmail_address;
    public final TagData mrelation_tag;
    public final String mtenant_id;

    public static final class Builder extends Message.Builder<ShieldP2PChatMeta, Builder> {
        public Boolean maccept_sms_phone_urgent;
        public String mchatter_id;
        public List<ChatterCustomStatus> mcustom_statuses;
        public Long mdo_not_disturb_end_time;
        public String mid;
        public Boolean mis_registered;
        public String mmail_address;
        public TagData mrelation_tag;
        public String mtenant_id;

        @Override // com.squareup.wire.Message.Builder
        public ShieldP2PChatMeta build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new ShieldP2PChatMeta(this.mid, this.mis_registered, this.mtenant_id, this.mmail_address, this.mdo_not_disturb_end_time, this.maccept_sms_phone_urgent, this.mchatter_id, this.mcustom_statuses, this.mrelation_tag, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
            this.mcustom_statuses = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder accept_sms_phone_urgent(Boolean r100) {
            this.maccept_sms_phone_urgent = r100;
            return this;
        }

        public Builder chatter_id(String r100) {
            this.mchatter_id = r100;
            return this;
        }

        public Builder custom_statuses(List<ChatterCustomStatus> r100) {
            Internal.checkElementsNotNull(r100);
            this.mcustom_statuses = r100;
            return this;
        }

        public Builder do_not_disturb_end_time(Long r100) {
            this.mdo_not_disturb_end_time = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder is_registered(Boolean r100) {
            this.mis_registered = r100;
            return this;
        }

        public Builder mail_address(String r100) {
            this.mmail_address = r100;
            return this;
        }

        public Builder relation_tag(TagData r100) {
            this.mrelation_tag = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.mtenant_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ShieldP2PChatMeta extends ProtoAdapter<ShieldP2PChatMeta> {
        public ProtoAdapter_ShieldP2PChatMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, ShieldP2PChatMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ShieldP2PChatMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            Boolean r102 = Boolean.FALSE;
            r101.mis_registered = r102;
            r101.mtenant_id = "";
            r101.mmail_address = "";
            r101.mdo_not_disturb_end_time = 0L;
            r101.maccept_sms_phone_urgent = r102;
            r101.mchatter_id = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L16;
            switch(r104) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.mrelation_tag = TagData.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.mcustom_statuses.add(ChatterCustomStatus.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.mchatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.maccept_sms_phone_urgent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.mdo_not_disturb_end_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.mmail_address = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mtenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mis_registered = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ShieldP2PChatMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid);
            Boolean r103 = r100.mis_registered;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.mtenant_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.mmail_address;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Long r113 = r100.mdo_not_disturb_end_time;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.maccept_sms_phone_urgent;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.mchatter_id;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = (r118 + r120) + ChatterCustomStatus.ADAPTER.asRepeated().encodedSizeWithTag(8, r100.mcustom_statuses);
            TagData r122 = r100.mrelation_tag;
            if (r122 == null) goto L30;
            r104 = TagData.ADAPTER.encodedSizeWithTag(9, r122);
        L30:
            return (r121 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ShieldP2PChatMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ShieldP2PChatMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ShieldP2PChatMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            Boolean r103 = r101.mis_registered;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.mtenant_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.mmail_address;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            Long r106 = r101.mdo_not_disturb_end_time;
            if (r106 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L14:
            Boolean r107 = r101.maccept_sms_phone_urgent;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.mchatter_id;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            ChatterCustomStatus.ADAPTER.asRepeated().encodeWithTag(r100, 8, r101.mcustom_statuses);
            TagData r109 = r101.mrelation_tag;
            if (r109 == null) goto L23;
            TagData.ADAPTER.encodeWithTag(r100, 9, r109);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShieldP2PChatMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ShieldP2PChatMeta();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_REGISTERED = r100;
        DEFAULT_DO_NOT_DISTURB_END_TIME = 0L;
        DEFAULT_ACCEPT_SMS_PHONE_URGENT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mis_registered = this.mis_registered;
        r100.mtenant_id = this.mtenant_id;
        r100.mmail_address = this.mmail_address;
        r100.mdo_not_disturb_end_time = this.mdo_not_disturb_end_time;
        r100.maccept_sms_phone_urgent = this.maccept_sms_phone_urgent;
        r100.mchatter_id = this.mchatter_id;
        r100.mcustom_statuses = Internal.copyOf("mcustom_statuses", this.mcustom_statuses);
        r100.mrelation_tag = this.mrelation_tag;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ShieldP2PChatMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ShieldP2PChatMeta(String r110, Boolean r111, String r112, String r113, Long r114, Boolean r115, String r116, List<ChatterCustomStatus> r117, TagData r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public ShieldP2PChatMeta(String r100, Boolean r101, String r102, String r103, Long r104, Boolean r105, String r106, List<ChatterCustomStatus> r107, TagData r110, ByteString r111) {
        super(ADAPTER, r111);
        this.mid = r100;
        this.mis_registered = r101;
        this.mtenant_id = r102;
        this.mmail_address = r103;
        this.mdo_not_disturb_end_time = r104;
        this.maccept_sms_phone_urgent = r105;
        this.mchatter_id = r106;
        this.mcustom_statuses = Internal.immutableCopyOf("mcustom_statuses", r107);
        this.mrelation_tag = r110;
    }
}
