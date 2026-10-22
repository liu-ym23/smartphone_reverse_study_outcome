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
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SimpleP2PChatterInfo extends Message<SimpleP2PChatterInfo, Builder> {
    public static final ProtoAdapter<SimpleP2PChatterInfo> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_JOIN_GROUP = null;
    public static final String DEFAULT_CHATTER_ID = "";
    public static final Boolean DEFAULT_IN_CONTACTS = null;
    public static final Boolean DEFAULT_IS_REGISTERED = null;
    public static final String DEFAULT_TENANT_ID = "";
    public static final Chatter.Type DEFAULT_TYPE = null;
    public static final String DEFAULT_WITH_BOT_TAG = "bot";
    private static final long serialVersionUID = 0;
    public final Boolean can_join_group;
    public final String chatter_id;
    public final Boolean in_contacts;
    public final Boolean is_registered;
    public final String tenant_id;
    public final Chatter.Type type;
    public final String with_bot_tag;
    public final WorkStatus work_status;

    public static final class Builder extends Message.Builder<SimpleP2PChatterInfo, Builder> {
        public Boolean can_join_group;
        public String chatter_id;
        public Boolean in_contacts;
        public Boolean is_registered;
        public String tenant_id;
        public Chatter.Type type;
        public String with_bot_tag;
        public WorkStatus work_status;

        @Override // com.squareup.wire.Message.Builder
        public SimpleP2PChatterInfo build() {
            String r100 = this.chatter_id;
            if (r100 == null) goto L7;
            return new SimpleP2PChatterInfo(this.chatter_id, this.type, this.is_registered, this.tenant_id, this.with_bot_tag, this.can_join_group, this.in_contacts, this.work_status, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "chatter_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder can_join_group(Boolean r100) {
            this.can_join_group = r100;
            return this;
        }

        public Builder chatter_id(String r100) {
            this.chatter_id = r100;
            return this;
        }

        public Builder in_contacts(Boolean r100) {
            this.in_contacts = r100;
            return this;
        }

        public Builder is_registered(Boolean r100) {
            this.is_registered = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.tenant_id = r100;
            return this;
        }

        public Builder type(Chatter.Type r100) {
            this.type = r100;
            return this;
        }

        public Builder with_bot_tag(String r100) {
            this.with_bot_tag = r100;
            return this;
        }

        public Builder work_status(WorkStatus r100) {
            this.work_status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SimpleP2PChatterInfo extends ProtoAdapter<SimpleP2PChatterInfo> {
        public ProtoAdapter_SimpleP2PChatterInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, SimpleP2PChatterInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SimpleP2PChatterInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chatter_id = "";
            r101.type = Chatter.Type.UNKNOWN;
            r101.is_registered = Boolean.FALSE;
            r101.tenant_id = "";
            r101.with_bot_tag = "bot";
            Boolean r102 = Boolean.TRUE;
            r101.can_join_group = r102;
            r101.in_contacts = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            switch(r104) {
                case 1: goto L17;
                case 2: goto L20;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.type = Chatter.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.work_status = WorkStatus.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.in_contacts = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.can_join_group = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.with_bot_tag = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.is_registered = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SimpleP2PChatterInfo r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.chatter_id);
            Chatter.Type r103 = r100.type;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = Chatter.Type.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.is_registered;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.tenant_id;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.with_bot_tag;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.can_join_group;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            Boolean r119 = r100.in_contacts;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            WorkStatus r122 = r100.work_status;
            if (r122 == null) goto L30;
            r104 = WorkStatus.ADAPTER.encodedSizeWithTag(8, r122);
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
        public /* bridge */ /* synthetic */ SimpleP2PChatterInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SimpleP2PChatterInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SimpleP2PChatterInfo r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.chatter_id);
            Chatter.Type r103 = r101.type;
            if (r103 == null) goto L5;
            Chatter.Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            Boolean r104 = r101.is_registered;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.tenant_id;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.with_bot_tag;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 5, r106);
        L14:
            Boolean r107 = r101.can_join_group;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L17:
            Boolean r108 = r101.in_contacts;
            if (r108 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L20:
            WorkStatus r109 = r101.work_status;
            if (r109 == null) goto L23;
            WorkStatus.ADAPTER.encodeWithTag(r100, 8, r109);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SimpleP2PChatterInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SimpleP2PChatterInfo();
        DEFAULT_TYPE = Chatter.Type.UNKNOWN;
        DEFAULT_IS_REGISTERED = Boolean.FALSE;
        Boolean r100 = Boolean.TRUE;
        DEFAULT_CAN_JOIN_GROUP = r100;
        DEFAULT_IN_CONTACTS = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chatter_id = this.chatter_id;
        r100.type = this.type;
        r100.is_registered = this.is_registered;
        r100.tenant_id = this.tenant_id;
        r100.with_bot_tag = this.with_bot_tag;
        r100.can_join_group = this.can_join_group;
        r100.in_contacts = this.in_contacts;
        r100.work_status = this.work_status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SimpleP2PChatterInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SimpleP2PChatterInfo(String r110, Chatter.Type r111, Boolean r112, String r113, String r114, Boolean r115, Boolean r116, WorkStatus r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public SimpleP2PChatterInfo(String r100, Chatter.Type r101, Boolean r102, String r103, String r104, Boolean r105, Boolean r106, WorkStatus r107, ByteString r110) {
        super(ADAPTER, r110);
        this.chatter_id = r100;
        this.type = r101;
        this.is_registered = r102;
        this.tenant_id = r103;
        this.with_bot_tag = r104;
        this.can_join_group = r105;
        this.in_contacts = r106;
        this.work_status = r107;
    }
}
