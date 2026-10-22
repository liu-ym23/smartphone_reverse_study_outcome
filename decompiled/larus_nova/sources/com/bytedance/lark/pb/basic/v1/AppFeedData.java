package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class AppFeedData extends com.squareup.wire.Message<AppFeedData, Builder> {
    public static final ProtoAdapter<AppFeedData> ADAPTER = null;
    public static final String DEFAULT_ANDROID_SCHEMA = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_IOS_SCHEMA = "";
    public static final String DEFAULT_LAST_NOTIFICATION_SEQ_ID = "";
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_PC_SCHEMA = "";
    private static final long serialVersionUID = 0;
    public final String android_schema;
    public final String avatar_key;
    public final String avatar_path;
    public final Channel channel;
    public final Long create_time;
    public final String ios_schema;
    public final String last_notification_seq_id;
    public final String message_id;
    public final String pc_schema;

    public static final class Builder extends com.squareup.wire.Message.Builder<AppFeedData, Builder> {
        public String android_schema;
        public String avatar_key;
        public String avatar_path;
        public Channel channel;
        public Long create_time;
        public String ios_schema;
        public String last_notification_seq_id;
        public String message_id;
        public String pc_schema;

        @Override // com.squareup.wire.Message.Builder
        public AppFeedData build() {
            return new AppFeedData(this.message_id, this.create_time, this.avatar_key, this.avatar_path, this.android_schema, this.ios_schema, this.pc_schema, this.last_notification_seq_id, this.channel, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
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

        public Builder avatar_path(String r100) {
            this.avatar_path = r100;
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

        public Builder ios_schema(String r100) {
            this.ios_schema = r100;
            return this;
        }

        public Builder last_notification_seq_id(String r100) {
            this.last_notification_seq_id = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder pc_schema(String r100) {
            this.pc_schema = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AppFeedData extends ProtoAdapter<AppFeedData> {
        public ProtoAdapter_AppFeedData() {
            super(FieldEncoding.LENGTH_DELIMITED, AppFeedData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AppFeedData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.create_time = 0L;
            r101.avatar_key = "";
            r101.avatar_path = "";
            r101.android_schema = "";
            r101.ios_schema = "";
            r101.pc_schema = "";
            r101.last_notification_seq_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
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
            r101.channel = Channel.ADAPTER.decode(r100);
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
            r101.avatar_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AppFeedData r100) {
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
            String r107 = r100.avatar_key;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.avatar_path;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.android_schema;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.ios_schema;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.pc_schema;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.last_notification_seq_id;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Channel r125 = r100.channel;
            if (r125 == null) goto L38;
            r102 = Channel.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            return (r124 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ AppFeedData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AppFeedData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AppFeedData r101) throws IOException {
            String r102 = r101.message_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.create_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.avatar_key;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.avatar_path;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.android_schema;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.ios_schema;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.pc_schema;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.last_notification_seq_id;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            Channel r110 = r101.channel;
            if (r110 == null) goto L29;
            Channel.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppFeedData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppFeedData();
        DEFAULT_CREATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.create_time = this.create_time;
        r100.avatar_key = this.avatar_key;
        r100.avatar_path = this.avatar_path;
        r100.android_schema = this.android_schema;
        r100.ios_schema = this.ios_schema;
        r100.pc_schema = this.pc_schema;
        r100.last_notification_seq_id = this.last_notification_seq_id;
        r100.channel = this.channel;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AppFeedData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AppFeedData(String r110, Long r111, String r112, String r113, String r114, String r115, String r116, String r117, Channel r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public AppFeedData(String r100, Long r101, String r102, String r103, String r104, String r105, String r106, String r107, Channel r110, ByteString r111) {
        super(ADAPTER, r111);
        this.message_id = r100;
        this.create_time = r101;
        this.avatar_key = r102;
        this.avatar_path = r103;
        this.android_schema = r104;
        this.ios_schema = r105;
        this.pc_schema = r106;
        this.last_notification_seq_id = r107;
        this.channel = r110;
    }
}
