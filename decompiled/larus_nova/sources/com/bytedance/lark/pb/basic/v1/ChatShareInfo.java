package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ChatShareInfo extends com.squareup.wire.Message<ChatShareInfo, Builder> {
    public static final ProtoAdapter<ChatShareInfo> ADAPTER = null;
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final Long DEFAULT_EXPIRE_TIME = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_SHARE_CHAT_ID = "";
    public static final ShareStatus DEFAULT_STATUS = null;
    public static final ShareTargetType DEFAULT_TARGET_TYPE = null;
    public static final String DEFAULT_TOKEN = "";
    public static final ShareType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Long create_time;
    public final Long expire_time;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253457id;
    public final QrCodeExtra qr_code_extra;
    public final String share_chat_id;
    public final ShareChatterExtra share_chatter_extra;
    public final ShareStatus status;
    public final TargetChatExtra target_chat_extra;
    public final TargetChatterExtra target_chatter_extra;
    public final TargetDocExtra target_doc_extra;
    public final ShareTargetType target_type;
    public final String token;
    public final ShareType type;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatShareInfo, Builder> {
        public Long create_time;
        public Long expire_time;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253458id;
        public QrCodeExtra qr_code_extra;
        public String share_chat_id;
        public ShareChatterExtra share_chatter_extra;
        public ShareStatus status;
        public TargetChatExtra target_chat_extra;
        public TargetChatterExtra target_chatter_extra;
        public TargetDocExtra target_doc_extra;
        public ShareTargetType target_type;
        public String token;
        public ShareType type;

        @Override // com.squareup.wire.Message.Builder
        public ChatShareInfo build() {
            return new ChatShareInfo(this.f253458id, this.type, this.status, this.target_type, this.share_chat_id, this.token, this.create_time, this.expire_time, this.share_chatter_extra, this.qr_code_extra, this.target_doc_extra, this.target_chat_extra, this.target_chatter_extra, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder expire_time(Long r100) {
            this.expire_time = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253458id = r100;
            return this;
        }

        public Builder qr_code_extra(QrCodeExtra r100) {
            this.qr_code_extra = r100;
            return this;
        }

        public Builder share_chat_id(String r100) {
            this.share_chat_id = r100;
            return this;
        }

        public Builder share_chatter_extra(ShareChatterExtra r100) {
            this.share_chatter_extra = r100;
            return this;
        }

        public Builder status(ShareStatus r100) {
            this.status = r100;
            return this;
        }

        public Builder target_chat_extra(TargetChatExtra r100) {
            this.target_chat_extra = r100;
            return this;
        }

        public Builder target_chatter_extra(TargetChatterExtra r100) {
            this.target_chatter_extra = r100;
            return this;
        }

        public Builder target_doc_extra(TargetDocExtra r100) {
            this.target_doc_extra = r100;
            return this;
        }

        public Builder target_type(ShareTargetType r100) {
            this.target_type = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder type(ShareType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatShareInfo extends ProtoAdapter<ChatShareInfo> {
        public ProtoAdapter_ChatShareInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatShareInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatShareInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253458id = "";
            r101.type = ShareType.UNKNOWN_TYPE;
            r101.status = ShareStatus.UNKNOWN_STATE;
            r101.target_type = ShareTargetType.UNKNOWN_TARGET_TYPE;
            r101.share_chat_id = "";
            r101.token = "";
            r101.create_time = 0L;
            r101.expire_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L29;
            switch(r103) {
                case 1: goto L28;
                case 2: goto L33;
                case 3: goto L35;
                case 4: goto L31;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L31:
            r101.target_type = ShareTargetType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L33:
            r101.type = ShareType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
        L26:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L35:
            r101.status = ShareStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.target_chatter_extra = TargetChatterExtra.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.target_chat_extra = TargetChatExtra.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.target_doc_extra = TargetDocExtra.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.qr_code_extra = QrCodeExtra.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.share_chatter_extra = ShareChatterExtra.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.expire_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.share_chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L28:
            r101.f253458id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L29:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatShareInfo r100) {
            String r101 = r100.f253457id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ShareType r104 = r100.type;
            if (r104 == null) goto L9;
            int r105 = ShareType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ShareStatus r107 = r100.status;
            if (r107 == null) goto L13;
            int r108 = ShareStatus.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ShareTargetType r110 = r100.target_type;
            if (r110 == null) goto L17;
            int r111 = ShareTargetType.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.share_chat_id;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.token;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.create_time;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Long r122 = r100.expire_time;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            ShareChatterExtra r125 = r100.share_chatter_extra;
            if (r125 == null) goto L37;
            int r126 = ShareChatterExtra.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            QrCodeExtra r128 = r100.qr_code_extra;
            if (r128 == null) goto L41;
            int r129 = QrCodeExtra.ADAPTER.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            TargetDocExtra r131 = r100.target_doc_extra;
            if (r131 == null) goto L45;
            int r132 = TargetDocExtra.ADAPTER.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            TargetChatExtra r134 = r100.target_chat_extra;
            if (r134 == null) goto L49;
            int r135 = TargetChatExtra.ADAPTER.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            TargetChatterExtra r137 = r100.target_chatter_extra;
            if (r137 == null) goto L54;
            r102 = TargetChatterExtra.ADAPTER.encodedSizeWithTag(13, r137);
        L54:
            return (r136 + r102) + r100.unknownFields().size();
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
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
        public /* bridge */ /* synthetic */ ChatShareInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatShareInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatShareInfo r101) throws IOException {
            String r102 = r101.f253457id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ShareType r103 = r101.type;
            if (r103 == null) goto L8;
            ShareType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ShareStatus r104 = r101.status;
            if (r104 == null) goto L11;
            ShareStatus.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            ShareTargetType r105 = r101.target_type;
            if (r105 == null) goto L14;
            ShareTargetType.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.share_chat_id;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.token;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.create_time;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L23:
            Long r109 = r101.expire_time;
            if (r109 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r109);
        L26:
            ShareChatterExtra r110 = r101.share_chatter_extra;
            if (r110 == null) goto L29;
            ShareChatterExtra.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            QrCodeExtra r111 = r101.qr_code_extra;
            if (r111 == null) goto L32;
            QrCodeExtra.ADAPTER.encodeWithTag(r100, 10, r111);
        L32:
            TargetDocExtra r112 = r101.target_doc_extra;
            if (r112 == null) goto L35;
            TargetDocExtra.ADAPTER.encodeWithTag(r100, 11, r112);
        L35:
            TargetChatExtra r113 = r101.target_chat_extra;
            if (r113 == null) goto L38;
            TargetChatExtra.ADAPTER.encodeWithTag(r100, 12, r113);
        L38:
            TargetChatterExtra r114 = r101.target_chatter_extra;
            if (r114 == null) goto L41;
            TargetChatterExtra.ADAPTER.encodeWithTag(r100, 13, r114);
        L41:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatShareInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class QrCodeExtra extends com.squareup.wire.Message<QrCodeExtra, Builder> {
        public static final ProtoAdapter<QrCodeExtra> ADAPTER = null;
        public static final String DEFAULT_SHARED_URL = "";
        private static final long serialVersionUID = 0;
        public final String shared_url;

        public static final class Builder extends com.squareup.wire.Message.Builder<QrCodeExtra, Builder> {
            public String shared_url;

            @Override // com.squareup.wire.Message.Builder
            public QrCodeExtra build() {
                return new QrCodeExtra(this.shared_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder shared_url(String r100) {
                this.shared_url = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_QrCodeExtra extends ProtoAdapter<QrCodeExtra> {
            public ProtoAdapter_QrCodeExtra() {
                super(FieldEncoding.LENGTH_DELIMITED, QrCodeExtra.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public QrCodeExtra decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.shared_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.shared_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(QrCodeExtra r100) {
                String r101 = r100.shared_url;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ QrCodeExtra decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(QrCodeExtra r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, QrCodeExtra r101) throws IOException {
                String r102 = r101.shared_url;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QrCodeExtra r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_QrCodeExtra();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.shared_url = this.shared_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return QrCodeExtra.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public QrCodeExtra(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public QrCodeExtra(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.shared_url = r100;
        }
    }

    public static final class ShareChatterExtra extends com.squareup.wire.Message<ShareChatterExtra, Builder> {
        public static final ProtoAdapter<ShareChatterExtra> ADAPTER = null;
        public static final String DEFAULT_AVATAR_KEY = "";
        public static final String DEFAULT_NAME = "";
        public static final String DEFAULT_SHARE_CHATTER_ID = "";
        private static final long serialVersionUID = 0;
        public final String avatar_key;
        public final String name;
        public final String share_chatter_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<ShareChatterExtra, Builder> {
            public String avatar_key;
            public String name;
            public String share_chatter_id;

            @Override // com.squareup.wire.Message.Builder
            public ShareChatterExtra build() {
                return new ShareChatterExtra(this.share_chatter_id, this.name, this.avatar_key, super.buildUnknownFields());
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

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }

            public Builder share_chatter_id(String r100) {
                this.share_chatter_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ShareChatterExtra extends ProtoAdapter<ShareChatterExtra> {
            public ProtoAdapter_ShareChatterExtra() {
                super(FieldEncoding.LENGTH_DELIMITED, ShareChatterExtra.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ShareChatterExtra decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.share_chatter_id = "";
                r101.name = "";
                r101.avatar_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.share_chatter_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.avatar_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ShareChatterExtra r100) {
                String r101 = r100.share_chatter_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.name;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.avatar_key;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ShareChatterExtra decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ShareChatterExtra r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ShareChatterExtra r101) throws IOException {
                String r102 = r101.share_chatter_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.avatar_key;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShareChatterExtra r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ShareChatterExtra();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.share_chatter_id = this.share_chatter_id;
            r100.name = this.name;
            r100.avatar_key = this.avatar_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ShareChatterExtra.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ShareChatterExtra(String r100, String r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ShareChatterExtra(String r100, String r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.share_chatter_id = r100;
            this.name = r101;
            this.avatar_key = r102;
        }
    }

    public static final enum ShareStatus extends Enum<ShareStatus> implements WireEnum {
        private static final /* synthetic */ ShareStatus[] $VALUES = null;
        public static final ShareStatus ACTIVE = null;
        public static final ProtoAdapter<ShareStatus> ADAPTER = null;
        public static final ShareStatus DEACTIVED = null;
        public static final ShareStatus EXPIRED = null;
        public static final ShareStatus UNKNOWN_STATE = null;
        private final int value;

        static {
            ShareStatus r100 = new ShareStatus("UNKNOWN_STATE", 0, 0);
            UNKNOWN_STATE = r100;
            ShareStatus r101 = new ShareStatus("ACTIVE", 1, 1);
            ACTIVE = r101;
            ShareStatus r102 = new ShareStatus("EXPIRED", 2, 2);
            EXPIRED = r102;
            ShareStatus r103 = new ShareStatus("DEACTIVED", 3, 3);
            DEACTIVED = r103;
            $VALUES = new ShareStatus[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(ShareStatus.class);
        }

        public static ShareStatus[] values() {
            return (ShareStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ShareStatus fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return DEACTIVED;
        L14:
            return EXPIRED;
        L16:
            return ACTIVE;
        L18:
            return UNKNOWN_STATE;
        }

        public static ShareStatus valueOf(String r100) {
            return (ShareStatus) a.a(ShareStatus.class, r100);
        }

        private ShareStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ShareTargetType extends Enum<ShareTargetType> implements WireEnum {
        private static final /* synthetic */ ShareTargetType[] $VALUES = null;
        public static final ProtoAdapter<ShareTargetType> ADAPTER = null;
        public static final ShareTargetType TARGET_CHAT = null;
        public static final ShareTargetType TARGET_CHATTER = null;
        public static final ShareTargetType TARGET_DOC = null;
        public static final ShareTargetType TARGET_LINK = null;
        public static final ShareTargetType TARGET_QRCODE = null;
        public static final ShareTargetType UNKNOWN_TARGET_TYPE = null;
        private final int value;

        static {
            ShareTargetType r100 = new ShareTargetType("UNKNOWN_TARGET_TYPE", 0, 0);
            UNKNOWN_TARGET_TYPE = r100;
            ShareTargetType r101 = new ShareTargetType("TARGET_CHAT", 1, 1);
            TARGET_CHAT = r101;
            ShareTargetType r102 = new ShareTargetType("TARGET_CHATTER", 2, 2);
            TARGET_CHATTER = r102;
            ShareTargetType r103 = new ShareTargetType("TARGET_QRCODE", 3, 3);
            TARGET_QRCODE = r103;
            ShareTargetType r104 = new ShareTargetType("TARGET_DOC", 4, 4);
            TARGET_DOC = r104;
            ShareTargetType r105 = new ShareTargetType("TARGET_LINK", 5, 5);
            TARGET_LINK = r105;
            $VALUES = new ShareTargetType[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(ShareTargetType.class);
        }

        public static ShareTargetType[] values() {
            return (ShareTargetType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ShareTargetType fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return TARGET_LINK;
        L18:
            return TARGET_DOC;
        L20:
            return TARGET_QRCODE;
        L22:
            return TARGET_CHATTER;
        L24:
            return TARGET_CHAT;
        L26:
            return UNKNOWN_TARGET_TYPE;
        }

        public static ShareTargetType valueOf(String r100) {
            return (ShareTargetType) a.a(ShareTargetType.class, r100);
        }

        private ShareTargetType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ShareType extends Enum<ShareType> implements WireEnum {
        private static final /* synthetic */ ShareType[] $VALUES = null;
        public static final ProtoAdapter<ShareType> ADAPTER = null;
        public static final ShareType CARD_DOC = null;
        public static final ShareType CARD_MESSAGE = null;
        public static final ShareType LINK = null;
        public static final ShareType QRCODE = null;
        public static final ShareType UNKNOWN_TYPE = null;
        private final int value;

        static {
            ShareType r100 = new ShareType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            ShareType r101 = new ShareType("CARD_MESSAGE", 1, 1);
            CARD_MESSAGE = r101;
            ShareType r102 = new ShareType("QRCODE", 2, 2);
            QRCODE = r102;
            ShareType r103 = new ShareType("CARD_DOC", 3, 3);
            CARD_DOC = r103;
            ShareType r104 = new ShareType("LINK", 4, 4);
            LINK = r104;
            $VALUES = new ShareType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(ShareType.class);
        }

        public static ShareType[] values() {
            return (ShareType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ShareType fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return LINK;
        L16:
            return CARD_DOC;
        L18:
            return QRCODE;
        L20:
            return CARD_MESSAGE;
        L22:
            return UNKNOWN_TYPE;
        }

        public static ShareType valueOf(String r100) {
            return (ShareType) a.a(ShareType.class, r100);
        }

        private ShareType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class TargetChatExtra extends com.squareup.wire.Message<TargetChatExtra, Builder> {
        public static final ProtoAdapter<TargetChatExtra> ADAPTER = null;
        public static final String DEFAULT_CHAT_ID = "";
        public static final String DEFAULT_CHAT_NAME = "";
        private static final long serialVersionUID = 0;
        public final String chat_id;
        public final String chat_name;

        public static final class Builder extends com.squareup.wire.Message.Builder<TargetChatExtra, Builder> {
            public String chat_id;
            public String chat_name;

            @Override // com.squareup.wire.Message.Builder
            public TargetChatExtra build() {
                return new TargetChatExtra(this.chat_id, this.chat_name, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder chat_id(String r100) {
                this.chat_id = r100;
                return this;
            }

            public Builder chat_name(String r100) {
                this.chat_name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TargetChatExtra extends ProtoAdapter<TargetChatExtra> {
            public ProtoAdapter_TargetChatExtra() {
                super(FieldEncoding.LENGTH_DELIMITED, TargetChatExtra.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TargetChatExtra decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.chat_id = "";
                r101.chat_name = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.chat_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.chat_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TargetChatExtra r100) {
                String r101 = r100.chat_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.chat_name;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TargetChatExtra decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TargetChatExtra r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TargetChatExtra r101) throws IOException {
                String r102 = r101.chat_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.chat_name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TargetChatExtra r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TargetChatExtra();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chat_id = this.chat_id;
            r100.chat_name = this.chat_name;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TargetChatExtra.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TargetChatExtra(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public TargetChatExtra(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.chat_id = r100;
            this.chat_name = r101;
        }
    }

    public static final class TargetChatterExtra extends com.squareup.wire.Message<TargetChatterExtra, Builder> {
        public static final ProtoAdapter<TargetChatterExtra> ADAPTER = null;
        public static final String DEFAULT_CHATTER_ID = "";
        public static final String DEFAULT_NAME = "";
        private static final long serialVersionUID = 0;
        public final String chatter_id;
        public final String name;

        public static final class Builder extends com.squareup.wire.Message.Builder<TargetChatterExtra, Builder> {
            public String chatter_id;
            public String name;

            @Override // com.squareup.wire.Message.Builder
            public TargetChatterExtra build() {
                return new TargetChatterExtra(this.chatter_id, this.name, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder chatter_id(String r100) {
                this.chatter_id = r100;
                return this;
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TargetChatterExtra extends ProtoAdapter<TargetChatterExtra> {
            public ProtoAdapter_TargetChatterExtra() {
                super(FieldEncoding.LENGTH_DELIMITED, TargetChatterExtra.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TargetChatterExtra decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.chatter_id = "";
                r101.name = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.chatter_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TargetChatterExtra r100) {
                String r101 = r100.chatter_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.name;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TargetChatterExtra decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TargetChatterExtra r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TargetChatterExtra r101) throws IOException {
                String r102 = r101.chatter_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TargetChatterExtra r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TargetChatterExtra();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chatter_id = this.chatter_id;
            r100.name = this.name;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TargetChatterExtra.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TargetChatterExtra(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public TargetChatterExtra(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.chatter_id = r100;
            this.name = r101;
        }
    }

    public static final class TargetDocExtra extends com.squareup.wire.Message<TargetDocExtra, Builder> {
        public static final ProtoAdapter<TargetDocExtra> ADAPTER = null;
        public static final String DEFAULT_DOC_NAME = "";
        public static final Doc.Type DEFAULT_DOC_TYPE = null;
        public static final String DEFAULT_DOC_URL = "";
        public static final Boolean DEFAULT_UNAUTHORIZED = null;
        private static final long serialVersionUID = 0;
        public final String doc_name;
        public final Doc.Type doc_type;
        public final String doc_url;
        public final Boolean unauthorized;

        public static final class Builder extends com.squareup.wire.Message.Builder<TargetDocExtra, Builder> {
            public String doc_name;
            public Doc.Type doc_type;
            public String doc_url;
            public Boolean unauthorized;

            @Override // com.squareup.wire.Message.Builder
            public TargetDocExtra build() {
                return new TargetDocExtra(this.doc_url, this.doc_name, this.doc_type, this.unauthorized, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder doc_name(String r100) {
                this.doc_name = r100;
                return this;
            }

            public Builder doc_type(Doc.Type r100) {
                this.doc_type = r100;
                return this;
            }

            public Builder doc_url(String r100) {
                this.doc_url = r100;
                return this;
            }

            public Builder unauthorized(Boolean r100) {
                this.unauthorized = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TargetDocExtra extends ProtoAdapter<TargetDocExtra> {
            public ProtoAdapter_TargetDocExtra() {
                super(FieldEncoding.LENGTH_DELIMITED, TargetDocExtra.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TargetDocExtra decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.doc_url = "";
                r101.doc_name = "";
                r101.doc_type = Doc.Type.UNKNOWN;
                r101.unauthorized = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.doc_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.doc_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.doc_type = Doc.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.unauthorized = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TargetDocExtra r100) {
                String r101 = r100.doc_url;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.doc_name;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Doc.Type r107 = r100.doc_type;
                if (r107 == null) goto L13;
                int r108 = Doc.Type.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.unauthorized;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
            L18:
                return (r109 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ TargetDocExtra decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TargetDocExtra r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TargetDocExtra r101) throws IOException {
                String r102 = r101.doc_url;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.doc_name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Doc.Type r104 = r101.doc_type;
                if (r104 == null) goto L11;
                Doc.Type.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.unauthorized;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TargetDocExtra r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TargetDocExtra();
            DEFAULT_DOC_TYPE = Doc.Type.UNKNOWN;
            DEFAULT_UNAUTHORIZED = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.doc_url = this.doc_url;
            r100.doc_name = this.doc_name;
            r100.doc_type = this.doc_type;
            r100.unauthorized = this.unauthorized;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TargetDocExtra.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TargetDocExtra(String r100, String r101, Doc.Type r102, Boolean r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public TargetDocExtra(String r100, String r101, Doc.Type r102, Boolean r103, ByteString r104) {
            super(ADAPTER, r104);
            this.doc_url = r100;
            this.doc_name = r101;
            this.doc_type = r102;
            this.unauthorized = r103;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatShareInfo();
        DEFAULT_TYPE = ShareType.UNKNOWN_TYPE;
        DEFAULT_STATUS = ShareStatus.UNKNOWN_STATE;
        DEFAULT_TARGET_TYPE = ShareTargetType.UNKNOWN_TARGET_TYPE;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_EXPIRE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253458id = this.f253457id;
        r100.type = this.type;
        r100.status = this.status;
        r100.target_type = this.target_type;
        r100.share_chat_id = this.share_chat_id;
        r100.token = this.token;
        r100.create_time = this.create_time;
        r100.expire_time = this.expire_time;
        r100.share_chatter_extra = this.share_chatter_extra;
        r100.qr_code_extra = this.qr_code_extra;
        r100.target_doc_extra = this.target_doc_extra;
        r100.target_chat_extra = this.target_chat_extra;
        r100.target_chatter_extra = this.target_chatter_extra;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatShareInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatShareInfo(String r110, ShareType r111, ShareStatus r112, ShareTargetType r113, String r210, String r211, Long r212, Long r213, ShareChatterExtra r214, QrCodeExtra r215, TargetDocExtra r216, TargetChatExtra r217, TargetChatterExtra r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public ChatShareInfo(String r100, ShareType r101, ShareStatus r102, ShareTargetType r103, String r104, String r105, Long r106, Long r107, ShareChatterExtra r110, QrCodeExtra r111, TargetDocExtra r112, TargetChatExtra r113, TargetChatterExtra r114, ByteString r115) {
        super(ADAPTER, r115);
        this.f253457id = r100;
        this.type = r101;
        this.status = r102;
        this.target_type = r103;
        this.share_chat_id = r104;
        this.token = r105;
        this.create_time = r106;
        this.expire_time = r107;
        this.share_chatter_extra = r110;
        this.qr_code_extra = r111;
        this.target_doc_extra = r112;
        this.target_chat_extra = r113;
        this.target_chatter_extra = r114;
    }
}
