package com.bytedance.lark.pb.feed.v1;

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
public final class OpenAppData extends Message<OpenAppData, Builder> {
    public static final ProtoAdapter<OpenAppData> ADAPTER = null;
    public static final String DEFAULT_ANDROID_SCHEMA = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final Long DEFAULT_DISPLAY_TIME = null;
    public static final String DEFAULT_IOS_SCHEMA = "";
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Boolean DEFAULT_IS_SHORTCUT = null;
    public static final String DEFAULT_LAST_NOTIFICATION_SEQ_ID = "";
    public static final String DEFAULT_LOCALIZED_DIGEST_MESSAGE = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PC_SCHEMA = "";
    public static final Long DEFAULT_RANK_TIME = null;
    public static final Integer DEFAULT_UNREAD_COUNT = null;
    private static final long serialVersionUID = 0;
    public final String android_schema;
    public final String avatar_key;
    public final List<String> avatar_urls;
    public final Digest digest;
    public final Long display_time;
    public final String ios_schema;
    public final Boolean is_remind;
    public final Boolean is_shortcut;
    public final String last_notification_seq_id;
    public final String localized_digest_message;
    public final String name;
    public final String pc_schema;
    public final Long rank_time;
    public final Integer unread_count;

    public static final class Builder extends Message.Builder<OpenAppData, Builder> {
        public String android_schema;
        public String avatar_key;
        public List<String> avatar_urls;
        public Digest digest;
        public Long display_time;
        public String ios_schema;
        public Boolean is_remind;
        public Boolean is_shortcut;
        public String last_notification_seq_id;
        public String localized_digest_message;
        public String name;
        public String pc_schema;
        public Long rank_time;
        public Integer unread_count;

        @Override // com.squareup.wire.Message.Builder
        public OpenAppData build() {
            String r100 = this.name;
            if (r100 == null) goto L9;
            if (this.is_remind == null) goto L9;
            return new OpenAppData(this.name, this.avatar_key, this.unread_count, this.is_remind, this.is_shortcut, this.localized_digest_message, this.display_time, this.rank_time, this.avatar_urls, this.android_schema, this.ios_schema, this.pc_schema, this.last_notification_seq_id, this.digest, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "name", this.is_remind, "is_remind"});
        }

        public Builder() {
            this.avatar_urls = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder android_schema(String r100) {
            this.android_schema = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder avatar_urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.avatar_urls = r100;
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

        public Builder ios_schema(String r100) {
            this.ios_schema = r100;
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

        public Builder last_notification_seq_id(String r100) {
            this.last_notification_seq_id = r100;
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

        public Builder pc_schema(String r100) {
            this.pc_schema = r100;
            return this;
        }

        public Builder rank_time(Long r100) {
            this.rank_time = r100;
            return this;
        }

        public Builder unread_count(Integer r100) {
            this.unread_count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OpenAppData extends ProtoAdapter<OpenAppData> {
        public ProtoAdapter_OpenAppData() {
            super(FieldEncoding.LENGTH_DELIMITED, OpenAppData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OpenAppData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.name = "";
            r101.avatar_key = "";
            r101.unread_count = 0;
            Boolean r102 = Boolean.FALSE;
            r101.is_remind = r102;
            r101.is_shortcut = r102;
            r101.localized_digest_message = "";
            r101.display_time = 0L;
            r101.rank_time = 0L;
            r101.android_schema = "";
            r101.ios_schema = "";
            r101.pc_schema = "";
            r101.last_notification_seq_id = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            switch(r104) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L7:
            r101.digest = Digest.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.last_notification_seq_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.pc_schema = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.ios_schema = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.android_schema = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.avatar_urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L13:
            r101.rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.display_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.localized_digest_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.is_shortcut = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.is_remind = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.unread_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L19:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OpenAppData r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.name);
            String r103 = r100.avatar_key;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Integer r107 = r100.unread_count;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            ProtoAdapter<Boolean> r110 = ProtoAdapter.BOOL;
            int r111 = r109 + r110.encodedSizeWithTag(4, r100.is_remind);
            Boolean r112 = r100.is_shortcut;
            if (r112 == null) goto L13;
            int r113 = r110.encodedSizeWithTag(5, r112);
        L14:
            int r114 = r111 + r113;
            String r115 = r100.localized_digest_message;
            if (r115 == null) goto L17;
            int r116 = r101.encodedSizeWithTag(6, r115);
        L18:
            int r117 = r114 + r116;
            Long r118 = r100.display_time;
            if (r118 == null) goto L21;
            int r119 = ProtoAdapter.INT64.encodedSizeWithTag(7, r118);
        L22:
            int r120 = r117 + r119;
            Long r121 = r100.rank_time;
            if (r121 == null) goto L25;
            int r122 = ProtoAdapter.INT64.encodedSizeWithTag(8, r121);
        L26:
            int r123 = (r120 + r122) + r101.asRepeated().encodedSizeWithTag(9, r100.avatar_urls);
            String r124 = r100.android_schema;
            if (r124 == null) goto L29;
            int r125 = r101.encodedSizeWithTag(10, r124);
        L30:
            int r126 = r123 + r125;
            String r127 = r100.ios_schema;
            if (r127 == null) goto L33;
            int r128 = r101.encodedSizeWithTag(11, r127);
        L34:
            int r129 = r126 + r128;
            String r130 = r100.pc_schema;
            if (r130 == null) goto L37;
            int r131 = r101.encodedSizeWithTag(12, r130);
        L38:
            int r132 = r129 + r131;
            String r133 = r100.last_notification_seq_id;
            if (r133 == null) goto L41;
            int r134 = r101.encodedSizeWithTag(13, r133);
        L42:
            int r135 = r132 + r134;
            Digest r136 = r100.digest;
            if (r136 == null) goto L46;
            r104 = Digest.ADAPTER.encodedSizeWithTag(14, r136);
        L46:
            return (r135 + r104) + r100.unknownFields().size();
        L41:
            r134 = 0;
            goto L42
        L37:
            r131 = 0;
            goto L38
        L33:
            r128 = 0;
            goto L34
        L29:
            r125 = 0;
            goto L30
        L25:
            r122 = 0;
            goto L26
        L21:
            r119 = 0;
            goto L22
        L17:
            r116 = 0;
            goto L18
        L13:
            r113 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OpenAppData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OpenAppData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OpenAppData r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.name);
            String r103 = r101.avatar_key;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            Integer r104 = r101.unread_count;
            if (r104 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L8:
            ProtoAdapter<Boolean> r105 = ProtoAdapter.BOOL;
            r105.encodeWithTag(r100, 4, r101.is_remind);
            Boolean r106 = r101.is_shortcut;
            if (r106 == null) goto L11;
            r105.encodeWithTag(r100, 5, r106);
        L11:
            String r107 = r101.localized_digest_message;
            if (r107 == null) goto L14;
            r102.encodeWithTag(r100, 6, r107);
        L14:
            Long r108 = r101.display_time;
            if (r108 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L17:
            Long r109 = r101.rank_time;
            if (r109 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r109);
        L20:
            r102.asRepeated().encodeWithTag(r100, 9, r101.avatar_urls);
            String r110 = r101.android_schema;
            if (r110 == null) goto L23;
            r102.encodeWithTag(r100, 10, r110);
        L23:
            String r111 = r101.ios_schema;
            if (r111 == null) goto L26;
            r102.encodeWithTag(r100, 11, r111);
        L26:
            String r112 = r101.pc_schema;
            if (r112 == null) goto L29;
            r102.encodeWithTag(r100, 12, r112);
        L29:
            String r113 = r101.last_notification_seq_id;
            if (r113 == null) goto L32;
            r102.encodeWithTag(r100, 13, r113);
        L32:
            Digest r114 = r101.digest;
            if (r114 == null) goto L35;
            Digest.ADAPTER.encodeWithTag(r100, 14, r114);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenAppData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OpenAppData();
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
        r100.unread_count = this.unread_count;
        r100.is_remind = this.is_remind;
        r100.is_shortcut = this.is_shortcut;
        r100.localized_digest_message = this.localized_digest_message;
        r100.display_time = this.display_time;
        r100.rank_time = this.rank_time;
        r100.avatar_urls = Internal.copyOf("avatar_urls", this.avatar_urls);
        r100.android_schema = this.android_schema;
        r100.ios_schema = this.ios_schema;
        r100.pc_schema = this.pc_schema;
        r100.last_notification_seq_id = this.last_notification_seq_id;
        r100.digest = this.digest;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OpenAppData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OpenAppData(String r110, String r111, Integer r112, Boolean r210, Boolean r211, String r212, Long r213, Long r214, List<String> r215, String r216, String r217, String r218, String r219, Digest r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public OpenAppData(String r100, String r101, Integer r102, Boolean r103, Boolean r104, String r105, Long r110, Long r111, List<String> r112, String r113, String r114, String r115, String r116, Digest r117, ByteString r118) {
        super(ADAPTER, r118);
        this.name = r100;
        this.avatar_key = r101;
        this.unread_count = r102;
        this.is_remind = r103;
        this.is_shortcut = r104;
        this.localized_digest_message = r105;
        this.display_time = r110;
        this.rank_time = r111;
        this.avatar_urls = Internal.immutableCopyOf("avatar_urls", r112);
        this.android_schema = r113;
        this.ios_schema = r114;
        this.pc_schema = r115;
        this.last_notification_seq_id = r116;
        this.digest = r117;
    }
}
