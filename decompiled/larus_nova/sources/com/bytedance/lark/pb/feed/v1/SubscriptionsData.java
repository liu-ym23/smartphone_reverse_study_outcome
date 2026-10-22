package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SubscriptionsData extends Message<SubscriptionsData, Builder> {
    public static final ProtoAdapter<SubscriptionsData> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final Long DEFAULT_DISPLAY_TIME = null;
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Boolean DEFAULT_IS_SHORTCUT = null;
    public static final String DEFAULT_LOCALIZED_DIGEST_MESSAGE = "";
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_RANK_TIME = null;
    public static final String DEFAULT_SCHEMA = "";
    public static final Integer DEFAULT_UNREAD_COUNT = null;
    private static final long serialVersionUID = 0;
    public final String avatar_key;
    public final Digest digest;
    public final Long display_time;
    public final Boolean is_remind;
    public final Boolean is_shortcut;
    public final String localized_digest_message;
    public final String name;
    public final Long rank_time;
    public final String schema;
    public final Integer unread_count;

    public static final class Builder extends Message.Builder<SubscriptionsData, Builder> {
        public String avatar_key;
        public Digest digest;
        public Long display_time;
        public Boolean is_remind;
        public Boolean is_shortcut;
        public String localized_digest_message;
        public String name;
        public Long rank_time;
        public String schema;
        public Integer unread_count;

        @Override // com.squareup.wire.Message.Builder
        public SubscriptionsData build() {
            return new SubscriptionsData(this.name, this.avatar_key, this.localized_digest_message, this.schema, this.unread_count, this.is_remind, this.is_shortcut, this.display_time, this.rank_time, this.digest, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder digest(Digest r100) {
            this.digest = r100;
            return this;
        }

        public Builder display_time(Long r100) {
            this.display_time = r100;
            return this;
        }

        public Builder is_remind(Boolean r100) {
            this.is_remind = r100;
            return this;
        }

        public Builder is_shortcut(Boolean r100) {
            this.is_shortcut = r100;
            return this;
        }

        public Builder localized_digest_message(String r100) {
            this.localized_digest_message = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder rank_time(Long r100) {
            this.rank_time = r100;
            return this;
        }

        public Builder schema(String r100) {
            this.schema = r100;
            return this;
        }

        public Builder unread_count(Integer r100) {
            this.unread_count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscriptionsData extends ProtoAdapter<SubscriptionsData> {
        public ProtoAdapter_SubscriptionsData() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscriptionsData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscriptionsData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.name = "";
            r101.avatar_key = "";
            r101.localized_digest_message = "";
            r101.schema = "";
            r101.unread_count = 0;
            Boolean r102 = Boolean.FALSE;
            r101.is_remind = r102;
            r101.is_shortcut = r102;
            r101.display_time = 0L;
            r101.rank_time = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L17;
            switch(r104) {
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
            r101.digest = Digest.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.display_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.is_shortcut = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.is_remind = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.unread_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            r101.schema = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.localized_digest_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SubscriptionsData r100) {
            String r101 = r100.name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.avatar_key;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.localized_digest_message;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.schema;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Integer r113 = r100.unread_count;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.is_remind;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.is_shortcut;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Long r122 = r100.display_time;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Long r125 = r100.rank_time;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.INT64.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Digest r128 = r100.digest;
            if (r128 == null) goto L42;
            r102 = Digest.ADAPTER.encodedSizeWithTag(10, r128);
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
        public /* bridge */ /* synthetic */ SubscriptionsData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscriptionsData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubscriptionsData r101) throws IOException {
            String r102 = r101.name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.avatar_key;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.localized_digest_message;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.schema;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Integer r106 = r101.unread_count;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.is_remind;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.is_shortcut;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            Long r109 = r101.display_time;
            if (r109 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r109);
        L26:
            Long r110 = r101.rank_time;
            if (r110 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 9, r110);
        L29:
            Digest r111 = r101.digest;
            if (r111 == null) goto L32;
            Digest.ADAPTER.encodeWithTag(r100, 10, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubscriptionsData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscriptionsData();
        DEFAULT_UNREAD_COUNT = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_REMIND = r100;
        DEFAULT_IS_SHORTCUT = r100;
        DEFAULT_DISPLAY_TIME = 0L;
        DEFAULT_RANK_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.avatar_key = this.avatar_key;
        r100.localized_digest_message = this.localized_digest_message;
        r100.schema = this.schema;
        r100.unread_count = this.unread_count;
        r100.is_remind = this.is_remind;
        r100.is_shortcut = this.is_shortcut;
        r100.display_time = this.display_time;
        r100.rank_time = this.rank_time;
        r100.digest = this.digest;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SubscriptionsData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SubscriptionsData(String r110, String r111, String r112, String r113, Integer r114, Boolean r115, Boolean r116, Long r210, Long r211, Digest r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public SubscriptionsData(String r100, String r101, String r102, String r103, Integer r104, Boolean r105, Boolean r106, Long r107, Long r110, Digest r111, ByteString r112) {
        super(ADAPTER, r112);
        this.name = r100;
        this.avatar_key = r101;
        this.localized_digest_message = r102;
        this.schema = r103;
        this.unread_count = r104;
        this.is_remind = r105;
        this.is_shortcut = r106;
        this.display_time = r107;
        this.rank_time = r110;
        this.digest = r111;
    }
}
