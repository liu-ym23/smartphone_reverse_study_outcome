package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MailData extends com.squareup.wire.Message<MailData, Builder> {
    public static final ProtoAdapter<MailData> ADAPTER = null;
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_FEED_CARD_ID = "";
    public static final String DEFAULT_FEED_ID = "";
    public static final String DEFAULT_FROM_CHATTER_ID = "";
    public static final String DEFAULT_LABEL_ID = "";
    public static final String DEFAULT_MAIL_ACCOUNT_ID = "";
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Integer DEFAULT_NEW_MESSAGE_COUNT = null;
    public static final String DEFAULT_THREAD_ID = "";
    private static final long serialVersionUID = 0;
    public final Channel channel;
    public final Long create_time;
    public final String feed_card_id;
    public final String feed_id;
    public final String from_chatter_id;
    public final String label_id;
    public final String mail_account_id;
    public final String message_id;
    public final Integer new_message_count;
    public final String thread_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<MailData, Builder> {
        public Channel channel;
        public Long create_time;
        public String feed_card_id;
        public String feed_id;
        public String from_chatter_id;
        public String label_id;
        public String mail_account_id;
        public String message_id;
        public Integer new_message_count;
        public String thread_id;

        @Override // com.squareup.wire.Message.Builder
        public MailData build() {
            return new MailData(this.message_id, this.create_time, this.channel, this.thread_id, this.new_message_count, this.from_chatter_id, this.label_id, this.mail_account_id, this.feed_card_id, this.feed_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder channel(Channel r100) {
            this.channel = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder feed_card_id(String r100) {
            this.feed_card_id = r100;
            return this;
        }

        public Builder feed_id(String r100) {
            this.feed_id = r100;
            return this;
        }

        public Builder from_chatter_id(String r100) {
            this.from_chatter_id = r100;
            return this;
        }

        public Builder label_id(String r100) {
            this.label_id = r100;
            return this;
        }

        public Builder mail_account_id(String r100) {
            this.mail_account_id = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder new_message_count(Integer r100) {
            this.new_message_count = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.thread_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MailData extends ProtoAdapter<MailData> {
        public ProtoAdapter_MailData() {
            super(FieldEncoding.LENGTH_DELIMITED, MailData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MailData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.create_time = 0L;
            r101.thread_id = "";
            r101.new_message_count = 0;
            r101.from_chatter_id = "";
            r101.label_id = "";
            r101.mail_account_id = "";
            r101.feed_card_id = "";
            r101.feed_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.feed_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.feed_card_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mail_account_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.label_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.from_chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.new_message_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            r101.thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.channel = Channel.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MailData r100) {
            String r101 = r100.message_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.create_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Channel r107 = r100.channel;
            if (r107 == null) goto L13;
            int r108 = Channel.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.thread_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Integer r113 = r100.new_message_count;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.from_chatter_id;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.label_id;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.mail_account_id;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.feed_card_id;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.feed_id;
            if (r128 == null) goto L42;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            return (r127 + r102) + r100.unknownFields().size();
        L37:
            r126 = 0;
            goto L38
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
        public /* bridge */ /* synthetic */ MailData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MailData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MailData r101) throws IOException {
            String r102 = r101.message_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.create_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Channel r104 = r101.channel;
            if (r104 == null) goto L11;
            Channel.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.thread_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Integer r106 = r101.new_message_count;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.from_chatter_id;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.label_id;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.mail_account_id;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.feed_card_id;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.feed_id;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MailData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MailData();
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_NEW_MESSAGE_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.create_time = this.create_time;
        r100.channel = this.channel;
        r100.thread_id = this.thread_id;
        r100.new_message_count = this.new_message_count;
        r100.from_chatter_id = this.from_chatter_id;
        r100.label_id = this.label_id;
        r100.mail_account_id = this.mail_account_id;
        r100.feed_card_id = this.feed_card_id;
        r100.feed_id = this.feed_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MailData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MailData(String r110, Long r111, Channel r112, String r113, Integer r114, String r115, String r116, String r210, String r211, String r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public MailData(String r100, Long r101, Channel r102, String r103, Integer r104, String r105, String r106, String r107, String r110, String r111, ByteString r112) {
        super(ADAPTER, r112);
        this.message_id = r100;
        this.create_time = r101;
        this.channel = r102;
        this.thread_id = r103;
        this.new_message_count = r104;
        this.from_chatter_id = r105;
        this.label_id = r106;
        this.mail_account_id = r107;
        this.feed_card_id = r110;
        this.feed_id = r111;
    }
}
