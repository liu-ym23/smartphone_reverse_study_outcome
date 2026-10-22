package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.search.v1.SearchAtInfo;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SimpleP2PChatInfo extends Message<SimpleP2PChatInfo, Builder> {
    public static final ProtoAdapter<SimpleP2PChatInfo> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final String DEFAULT_LAST_MESSAGE_ID = "";
    public static final Integer DEFAULT_LAST_MESSAGE_POSITION = null;
    public static final Integer DEFAULT_LAST_MESSAGE_POSITION_BADGE_COUNT = null;
    public static final Integer DEFAULT_READ_POSITION = null;
    public static final Integer DEFAULT_READ_POSITION_BADGE_COUNT = null;
    private static final long serialVersionUID = 0;
    public final SearchAtInfo at_info;
    public final String chat_id;
    public final Boolean is_remind;
    public final String last_message_id;
    public final Integer last_message_position;
    public final Integer last_message_position_badge_count;
    public final Integer read_position;
    public final Integer read_position_badge_count;

    public static final class Builder extends Message.Builder<SimpleP2PChatInfo, Builder> {
        public SearchAtInfo at_info;
        public String chat_id;
        public Boolean is_remind;
        public String last_message_id;
        public Integer last_message_position;
        public Integer last_message_position_badge_count;
        public Integer read_position;
        public Integer read_position_badge_count;

        @Override // com.squareup.wire.Message.Builder
        public SimpleP2PChatInfo build() {
            return new SimpleP2PChatInfo(this.chat_id, this.read_position, this.read_position_badge_count, this.last_message_id, this.last_message_position, this.last_message_position_badge_count, this.at_info, this.is_remind, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder at_info(SearchAtInfo r100) {
            this.at_info = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder is_remind(Boolean r100) {
            this.is_remind = r100;
            return this;
        }

        public Builder last_message_id(String r100) {
            this.last_message_id = r100;
            return this;
        }

        public Builder last_message_position(Integer r100) {
            this.last_message_position = r100;
            return this;
        }

        public Builder last_message_position_badge_count(Integer r100) {
            this.last_message_position_badge_count = r100;
            return this;
        }

        public Builder read_position(Integer r100) {
            this.read_position = r100;
            return this;
        }

        public Builder read_position_badge_count(Integer r100) {
            this.read_position_badge_count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SimpleP2PChatInfo extends ProtoAdapter<SimpleP2PChatInfo> {
        public ProtoAdapter_SimpleP2PChatInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, SimpleP2PChatInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SimpleP2PChatInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.read_position = 0;
            r101.read_position_badge_count = 0;
            r101.last_message_id = "";
            r101.last_message_position = 0;
            r101.last_message_position_badge_count = 0;
            r101.is_remind = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            switch(r103) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r101.is_remind = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.at_info = SearchAtInfo.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.last_message_position_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.last_message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.last_message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.read_position_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            r101.read_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SimpleP2PChatInfo r100) {
            String r101 = r100.chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.read_position;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.read_position_badge_count;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.last_message_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Integer r113 = r100.last_message_position;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Integer r116 = r100.last_message_position_badge_count;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            SearchAtInfo r119 = r100.at_info;
            if (r119 == null) goto L29;
            int r120 = SearchAtInfo.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.is_remind;
            if (r122 == null) goto L34;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
        L34:
            return (r121 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ SimpleP2PChatInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SimpleP2PChatInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SimpleP2PChatInfo r101) throws IOException {
            String r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.read_position;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.read_position_badge_count;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.last_message_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Integer r106 = r101.last_message_position;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L17:
            Integer r107 = r101.last_message_position_badge_count;
            if (r107 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L20:
            SearchAtInfo r108 = r101.at_info;
            if (r108 == null) goto L23;
            SearchAtInfo.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            Boolean r109 = r101.is_remind;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SimpleP2PChatInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SimpleP2PChatInfo();
        DEFAULT_READ_POSITION = 0;
        DEFAULT_READ_POSITION_BADGE_COUNT = 0;
        DEFAULT_LAST_MESSAGE_POSITION = 0;
        DEFAULT_LAST_MESSAGE_POSITION_BADGE_COUNT = 0;
        DEFAULT_IS_REMIND = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.read_position = this.read_position;
        r100.read_position_badge_count = this.read_position_badge_count;
        r100.last_message_id = this.last_message_id;
        r100.last_message_position = this.last_message_position;
        r100.last_message_position_badge_count = this.last_message_position_badge_count;
        r100.at_info = this.at_info;
        r100.is_remind = this.is_remind;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SimpleP2PChatInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SimpleP2PChatInfo(String r110, Integer r111, Integer r112, String r113, Integer r114, Integer r115, SearchAtInfo r116, Boolean r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public SimpleP2PChatInfo(String r100, Integer r101, Integer r102, String r103, Integer r104, Integer r105, SearchAtInfo r106, Boolean r107, ByteString r110) {
        super(ADAPTER, r110);
        this.chat_id = r100;
        this.read_position = r101;
        this.read_position_badge_count = r102;
        this.last_message_id = r103;
        this.last_message_position = r104;
        this.last_message_position_badge_count = r105;
        this.at_info = r106;
        this.is_remind = r107;
    }
}
