package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.DocType;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PhoenixMeta extends Message<PhoenixMeta, Builder> {
    public static final ProtoAdapter<PhoenixMeta> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_EDIT_USER_ID = "";
    public static final String DEFAULT_EDIT_USER_NAME = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Long DEFAULT_LAST_OPEN_TIME = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_OWNER_ID = "";
    public static final String DEFAULT_OWNER_NAME = "";
    public static final Integer DEFAULT_POSITION = null;
    public static final Long DEFAULT_SPACE_ID = null;
    public static final String DEFAULT_SPACE_NAME = "";
    public static final Integer DEFAULT_THREAD_CHAT_POSITION = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final Integer DEFAULT_THREAD_POSITION = null;
    public static final String DEFAULT_TOKEN = "";
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final Long mcreate_time;
    public final String medit_user_id;
    public final String medit_user_name;
    public final String mid;
    public final Boolean mis_cross_tenant;
    public final Long mlast_open_time;
    public final String mmessage_id;
    public final String mowner_id;
    public final String mowner_name;
    public final Integer mposition;
    public final Long mspace_id;
    public final String mspace_name;
    public final Integer mthread_chat_position;
    public final String mthread_id;
    public final Integer mthread_position;
    public final String mtoken;
    public final DocType mtype;
    public final Long mupdate_time;
    public final String murl;

    public static final class Builder extends Message.Builder<PhoenixMeta, Builder> {
        public String mchat_id;
        public Long mcreate_time;
        public String medit_user_id;
        public String medit_user_name;
        public String mid;
        public Boolean mis_cross_tenant;
        public Long mlast_open_time;
        public String mmessage_id;
        public String mowner_id;
        public String mowner_name;
        public Integer mposition;
        public Long mspace_id;
        public String mspace_name;
        public Integer mthread_chat_position;
        public String mthread_id;
        public Integer mthread_position;
        public String mtoken;
        public DocType mtype;
        public Long mupdate_time;
        public String murl;

        @Override // com.squareup.wire.Message.Builder
        public PhoenixMeta build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new PhoenixMeta(this.mid, this.mtype, this.mupdate_time, this.mis_cross_tenant, this.mchat_id, this.mposition, this.mthread_id, this.mthread_position, this.mthread_chat_position, this.mmessage_id, this.mcreate_time, this.mlast_open_time, this.medit_user_id, this.medit_user_name, this.murl, this.mspace_id, this.mspace_name, this.mtoken, this.mowner_id, this.mowner_name, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.mcreate_time = r100;
            return this;
        }

        public Builder edit_user_id(String r100) {
            this.medit_user_id = r100;
            return this;
        }

        public Builder edit_user_name(String r100) {
            this.medit_user_name = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.mis_cross_tenant = r100;
            return this;
        }

        public Builder last_open_time(Long r100) {
            this.mlast_open_time = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.mmessage_id = r100;
            return this;
        }

        public Builder owner_id(String r100) {
            this.mowner_id = r100;
            return this;
        }

        public Builder owner_name(String r100) {
            this.mowner_name = r100;
            return this;
        }

        public Builder position(Integer r100) {
            this.mposition = r100;
            return this;
        }

        public Builder space_id(Long r100) {
            this.mspace_id = r100;
            return this;
        }

        public Builder space_name(String r100) {
            this.mspace_name = r100;
            return this;
        }

        public Builder thread_chat_position(Integer r100) {
            this.mthread_chat_position = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.mthread_id = r100;
            return this;
        }

        public Builder thread_position(Integer r100) {
            this.mthread_position = r100;
            return this;
        }

        public Builder token(String r100) {
            this.mtoken = r100;
            return this;
        }

        public Builder type(DocType r100) {
            this.mtype = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.mupdate_time = r100;
            return this;
        }

        public Builder url(String r100) {
            this.murl = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PhoenixMeta extends ProtoAdapter<PhoenixMeta> {
        public ProtoAdapter_PhoenixMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, PhoenixMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PhoenixMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mupdate_time = 0L;
            r101.mis_cross_tenant = Boolean.FALSE;
            r101.mchat_id = "";
            r101.mposition = 0;
            r101.mthread_id = "";
            r101.mthread_position = 0;
            r101.mthread_chat_position = 0;
            r101.mmessage_id = "";
            r101.mcreate_time = 0L;
            r101.mlast_open_time = 0L;
            r101.medit_user_id = "";
            r101.medit_user_name = "";
            r101.murl = "";
            r101.mspace_id = 0L;
            r101.mspace_name = "";
            r101.mtoken = "";
            r101.mowner_id = "";
            r101.mowner_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L30;
            switch(r103) {
                case 1: goto L29;
                case 2: goto L32;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L17;
                case 11: goto L16;
                case 12: goto L15;
                case 13: goto L14;
                case 14: goto L13;
                case 15: goto L12;
                case 16: goto L6;
                case 17: goto L11;
                case 18: goto L10;
                case 19: goto L9;
                case 20: goto L8;
                case 21: goto L7;
                default: goto L6;
            };
        L32:
            r101.mtype = DocType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mowner_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mowner_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mtoken = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.mspace_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mspace_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.murl = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.medit_user_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.medit_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mlast_open_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.mcreate_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            r101.mmessage_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.mthread_chat_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L19:
            r101.mthread_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L20:
            r101.mthread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.mposition = ProtoAdapter.INT32.decode(r100);
            goto L3
        L22:
            r101.mchat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.mis_cross_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.mupdate_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L29:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L30:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PhoenixMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid);
            DocType r103 = r100.mtype;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = DocType.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Long r107 = r100.mupdate_time;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.mis_cross_tenant;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.mchat_id;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Integer r116 = r100.mposition;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.mthread_id;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            Integer r122 = r100.mthread_position;
            if (r122 == null) goto L29;
            int r123 = ProtoAdapter.INT32.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            Integer r125 = r100.mthread_chat_position;
            if (r125 == null) goto L33;
            int r126 = ProtoAdapter.INT32.encodedSizeWithTag(9, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.mmessage_id;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(10, r128);
        L38:
            int r130 = r127 + r129;
            Long r131 = r100.mcreate_time;
            if (r131 == null) goto L41;
            int r132 = ProtoAdapter.INT64.encodedSizeWithTag(11, r131);
        L42:
            int r133 = r130 + r132;
            Long r134 = r100.mlast_open_time;
            if (r134 == null) goto L45;
            int r135 = ProtoAdapter.INT64.encodedSizeWithTag(12, r134);
        L46:
            int r136 = r133 + r135;
            String r137 = r100.medit_user_id;
            if (r137 == null) goto L49;
            int r138 = r101.encodedSizeWithTag(13, r137);
        L50:
            int r139 = r136 + r138;
            String r140 = r100.medit_user_name;
            if (r140 == null) goto L53;
            int r141 = r101.encodedSizeWithTag(14, r140);
        L54:
            int r142 = r139 + r141;
            String r143 = r100.murl;
            if (r143 == null) goto L57;
            int r144 = r101.encodedSizeWithTag(15, r143);
        L58:
            int r145 = r142 + r144;
            Long r146 = r100.mspace_id;
            if (r146 == null) goto L61;
            int r147 = ProtoAdapter.INT64.encodedSizeWithTag(17, r146);
        L62:
            int r148 = r145 + r147;
            String r149 = r100.mspace_name;
            if (r149 == null) goto L65;
            int r150 = r101.encodedSizeWithTag(18, r149);
        L66:
            int r151 = r148 + r150;
            String r152 = r100.mtoken;
            if (r152 == null) goto L69;
            int r153 = r101.encodedSizeWithTag(19, r152);
        L70:
            int r154 = r151 + r153;
            String r155 = r100.mowner_id;
            if (r155 == null) goto L73;
            int r156 = r101.encodedSizeWithTag(20, r155);
        L74:
            int r157 = r154 + r156;
            String r158 = r100.mowner_name;
            if (r158 == null) goto L78;
            r104 = r101.encodedSizeWithTag(21, r158);
        L78:
            return (r157 + r104) + r100.unknownFields().size();
        L73:
            r156 = 0;
            goto L74
        L69:
            r153 = 0;
            goto L70
        L65:
            r150 = 0;
            goto L66
        L61:
            r147 = 0;
            goto L62
        L57:
            r144 = 0;
            goto L58
        L53:
            r141 = 0;
            goto L54
        L49:
            r138 = 0;
            goto L50
        L45:
            r135 = 0;
            goto L46
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
        public /* bridge */ /* synthetic */ PhoenixMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PhoenixMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PhoenixMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            DocType r103 = r101.mtype;
            if (r103 == null) goto L5;
            DocType.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            Long r104 = r101.mupdate_time;
            if (r104 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L8:
            Boolean r105 = r101.mis_cross_tenant;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.mchat_id;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 5, r106);
        L14:
            Integer r107 = r101.mposition;
            if (r107 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.mthread_id;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            Integer r109 = r101.mthread_position;
            if (r109 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r109);
        L23:
            Integer r110 = r101.mthread_chat_position;
            if (r110 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 9, r110);
        L26:
            String r111 = r101.mmessage_id;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 10, r111);
        L29:
            Long r112 = r101.mcreate_time;
            if (r112 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 11, r112);
        L32:
            Long r113 = r101.mlast_open_time;
            if (r113 == null) goto L35;
            ProtoAdapter.INT64.encodeWithTag(r100, 12, r113);
        L35:
            String r114 = r101.medit_user_id;
            if (r114 == null) goto L38;
            r102.encodeWithTag(r100, 13, r114);
        L38:
            String r115 = r101.medit_user_name;
            if (r115 == null) goto L41;
            r102.encodeWithTag(r100, 14, r115);
        L41:
            String r116 = r101.murl;
            if (r116 == null) goto L44;
            r102.encodeWithTag(r100, 15, r116);
        L44:
            Long r117 = r101.mspace_id;
            if (r117 == null) goto L47;
            ProtoAdapter.INT64.encodeWithTag(r100, 17, r117);
        L47:
            String r118 = r101.mspace_name;
            if (r118 == null) goto L50;
            r102.encodeWithTag(r100, 18, r118);
        L50:
            String r119 = r101.mtoken;
            if (r119 == null) goto L53;
            r102.encodeWithTag(r100, 19, r119);
        L53:
            String r120 = r101.mowner_id;
            if (r120 == null) goto L56;
            r102.encodeWithTag(r100, 20, r120);
        L56:
            String r121 = r101.mowner_name;
            if (r121 == null) goto L59;
            r102.encodeWithTag(r100, 21, r121);
        L59:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PhoenixMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PhoenixMeta();
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_IS_CROSS_TENANT = Boolean.FALSE;
        DEFAULT_POSITION = 0;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_THREAD_CHAT_POSITION = 0;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_LAST_OPEN_TIME = 0L;
        DEFAULT_SPACE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mtype = this.mtype;
        r100.mupdate_time = this.mupdate_time;
        r100.mis_cross_tenant = this.mis_cross_tenant;
        r100.mchat_id = this.mchat_id;
        r100.mposition = this.mposition;
        r100.mthread_id = this.mthread_id;
        r100.mthread_position = this.mthread_position;
        r100.mthread_chat_position = this.mthread_chat_position;
        r100.mmessage_id = this.mmessage_id;
        r100.mcreate_time = this.mcreate_time;
        r100.mlast_open_time = this.mlast_open_time;
        r100.medit_user_id = this.medit_user_id;
        r100.medit_user_name = this.medit_user_name;
        r100.murl = this.murl;
        r100.mspace_id = this.mspace_id;
        r100.mspace_name = this.mspace_name;
        r100.mtoken = this.mtoken;
        r100.mowner_id = this.mowner_id;
        r100.mowner_name = this.mowner_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PhoenixMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PhoenixMeta(String r210, DocType r211, Long r212, Boolean r213, String r214, Integer r215, String r216, Integer r310, Integer r311, String r312, Long r313, Long r314, String r315, String r316, String r317, Long r318, String r319, String r410, String r411, String r412) {
        this(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, ByteString.EMPTY);
    }

    public PhoenixMeta(String r100, DocType r101, Long r102, Boolean r103, String r104, Integer r105, String r110, Integer r111, Integer r112, String r113, Long r114, Long r115, String r116, String r117, String r118, Long r119, String r210, String r211, String r212, String r213, ByteString r214) {
        super(ADAPTER, r214);
        this.mid = r100;
        this.mtype = r101;
        this.mupdate_time = r102;
        this.mis_cross_tenant = r103;
        this.mchat_id = r104;
        this.mposition = r105;
        this.mthread_id = r110;
        this.mthread_position = r111;
        this.mthread_chat_position = r112;
        this.mmessage_id = r113;
        this.mcreate_time = r114;
        this.mlast_open_time = r115;
        this.medit_user_id = r116;
        this.medit_user_name = r117;
        this.murl = r118;
        this.mspace_id = r119;
        this.mspace_name = r210;
        this.mtoken = r211;
        this.mowner_id = r212;
        this.mowner_name = r213;
    }
}
