package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DocFeedData extends com.squareup.wire.Message<DocFeedData, Builder> {
    public static final ProtoAdapter<DocFeedData> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_FROM_CHATTER_ID = "";
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Integer DEFAULT_NEW_MESSAGE_COUNT = null;
    private static final long serialVersionUID = 0;
    public final String avatar_key;
    public final Channel channel;
    public final Long create_time;
    public final String from_chatter_id;
    public final String message_id;
    public final Integer new_message_count;

    public static final class Builder extends com.squareup.wire.Message.Builder<DocFeedData, Builder> {
        public String avatar_key;
        public Channel channel;
        public Long create_time;
        public String from_chatter_id;
        public String message_id;
        public Integer new_message_count;

        @Override // com.squareup.wire.Message.Builder
        public DocFeedData build() {
            return new DocFeedData(this.message_id, this.create_time, this.channel, this.from_chatter_id, this.avatar_key, this.new_message_count, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder channel(Channel r100) {
            this.channel = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder from_chatter_id(String r100) {
            this.from_chatter_id = r100;
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
    }

    public static final class ProtoAdapter_DocFeedData extends ProtoAdapter<DocFeedData> {
        public ProtoAdapter_DocFeedData() {
            super(FieldEncoding.LENGTH_DELIMITED, DocFeedData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DocFeedData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.create_time = 0L;
            r101.from_chatter_id = "";
            r101.avatar_key = "";
            r101.new_message_count = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.new_message_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.from_chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.channel = Channel.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DocFeedData r100) {
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
            String r110 = r100.from_chatter_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.avatar_key;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Integer r116 = r100.new_message_count;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ DocFeedData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DocFeedData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DocFeedData r101) throws IOException {
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
            String r105 = r101.from_chatter_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.avatar_key;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            Integer r107 = r101.new_message_count;
            if (r107 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocFeedData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocFeedData();
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_NEW_MESSAGE_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.create_time = this.create_time;
        r100.channel = this.channel;
        r100.from_chatter_id = this.from_chatter_id;
        r100.avatar_key = this.avatar_key;
        r100.new_message_count = this.new_message_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DocFeedData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DocFeedData(String r100, Long r110, Channel r111, String r112, String r113, Integer r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public DocFeedData(String r100, Long r101, Channel r102, String r103, String r104, Integer r105, ByteString r106) {
        super(ADAPTER, r106);
        this.message_id = r100;
        this.create_time = r101;
        this.channel = r102;
        this.from_chatter_id = r103;
        this.avatar_key = r104;
        this.new_message_count = r105;
    }
}
