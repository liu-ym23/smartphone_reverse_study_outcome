package com.bytedance.lark.pb.basic.v1;

import com.obric.miniapp.alarm.AlarmSessionType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class CardVisitInfo extends com.squareup.wire.Message<CardVisitInfo, Builder> {
    public static final ProtoAdapter<CardVisitInfo> ADAPTER = null;
    public static final String DEFAULT_AUTH_FILE_KEY = "";
    public static final String DEFAULT_ENTITY_ID = "";
    public static final File.EntityType DEFAULT_ENTITY_TYPE = null;
    public static final Long DEFAULT_INNER_MSG_ID = null;
    public static final DownloadFileScene DEFAULT_SCENE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String auth_file_key;
    public final String entity_id;
    public final File.EntityType entity_type;
    public final Map<String, String> ext;
    public final Map<String, String> im_ext;
    public final Long inner_msg_id;
    public final DownloadFileScene scene_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<CardVisitInfo, Builder> {
        public String auth_file_key;
        public String entity_id;
        public File.EntityType entity_type;
        public Map<String, String> ext;
        public Map<String, String> im_ext;
        public Long inner_msg_id;
        public DownloadFileScene scene_type;

        @Override // com.squareup.wire.Message.Builder
        public CardVisitInfo build() {
            return new CardVisitInfo(this.scene_type, this.entity_type, this.entity_id, this.inner_msg_id, this.auth_file_key, this.im_ext, this.ext, super.buildUnknownFields());
        }

        public Builder() {
            this.im_ext = Internal.newMutableMap();
            this.ext = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder auth_file_key(String r100) {
            this.auth_file_key = r100;
            return this;
        }

        public Builder entity_id(String r100) {
            this.entity_id = r100;
            return this;
        }

        public Builder entity_type(File.EntityType r100) {
            this.entity_type = r100;
            return this;
        }

        public Builder ext(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.ext = r100;
            return this;
        }

        public Builder im_ext(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.im_ext = r100;
            return this;
        }

        public Builder inner_msg_id(Long r100) {
            this.inner_msg_id = r100;
            return this;
        }

        public Builder scene_type(DownloadFileScene r100) {
            this.scene_type = r100;
            return this;
        }
    }

    public static final enum DownloadFileScene extends Enum<DownloadFileScene> implements WireEnum {
        private static final /* synthetic */ DownloadFileScene[] $VALUES = null;
        public static final ProtoAdapter<DownloadFileScene> ADAPTER = null;
        public static final DownloadFileScene CHAT = null;
        public static final DownloadFileScene FAVORITE = null;
        public static final DownloadFileScene ImFeedAudio = null;
        public static final DownloadFileScene MessageLink = null;
        public static final DownloadFileScene TODO = null;
        public static final DownloadFileScene UNKNOWN = null;
        public static final DownloadFileScene UniversalCard = null;
        private final int value;

        static {
            DownloadFileScene r100 = new DownloadFileScene("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            DownloadFileScene r101 = new DownloadFileScene("CHAT", 1, 1);
            CHAT = r101;
            DownloadFileScene r102 = new DownloadFileScene("FAVORITE", 2, 2);
            FAVORITE = r102;
            DownloadFileScene r103 = new DownloadFileScene(AlarmSessionType.TODO, 3, 3);
            TODO = r103;
            DownloadFileScene r104 = new DownloadFileScene("ImFeedAudio", 4, 7);
            ImFeedAudio = r104;
            DownloadFileScene r105 = new DownloadFileScene("MessageLink", 5, 8);
            MessageLink = r105;
            DownloadFileScene r110 = new DownloadFileScene("UniversalCard", 6, 9);
            UniversalCard = r110;
            $VALUES = new DownloadFileScene[]{r100, r101, r102, r103, r104, r105, r110};
            ADAPTER = ProtoAdapter.newEnumAdapter(DownloadFileScene.class);
        }

        public static DownloadFileScene[] values() {
            return (DownloadFileScene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DownloadFileScene fromValue(int r100) {
            if (r100 == 0) goto L30;
            if (r100 == 1) goto L28;
            if (r100 == 2) goto L26;
            if (r100 == 3) goto L24;
            if (r100 == 7) goto L22;
            if (r100 == 8) goto L20;
            if (r100 == 9) goto L18;
            return null;
        L18:
            return UniversalCard;
        L20:
            return MessageLink;
        L22:
            return ImFeedAudio;
        L24:
            return TODO;
        L26:
            return FAVORITE;
        L28:
            return CHAT;
        L30:
            return UNKNOWN;
        }

        public static DownloadFileScene valueOf(String r100) {
            return (DownloadFileScene) a.a(DownloadFileScene.class, r100);
        }

        private DownloadFileScene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_CardVisitInfo extends ProtoAdapter<CardVisitInfo> {
        private final ProtoAdapter<Map<String, String>> ext;
        private final ProtoAdapter<Map<String, String>> im_ext;

        public ProtoAdapter_CardVisitInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CardVisitInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.im_ext = ProtoAdapter.newMapAdapter(r100, r100);
            this.ext = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CardVisitInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scene_type = DownloadFileScene.UNKNOWN;
            r101.entity_type = File.EntityType.MESSAGE;
            r101.entity_id = "";
            r101.inner_msg_id = 0L;
            r101.auth_file_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L20;
            switch(r103) {
                case 1: goto L24;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L22;
                case 7: goto L7;
                default: goto L6;
            };
        L22:
            r101.entity_type = File.EntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L24:
            r101.scene_type = DownloadFileScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.im_ext.putAll(this.im_ext.decode(r100));
            goto L3
        L12:
            r101.ext.putAll(this.ext.decode(r100));
            goto L3
        L13:
            r101.auth_file_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.inner_msg_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.entity_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CardVisitInfo r100) {
            DownloadFileScene r101 = r100.scene_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = DownloadFileScene.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            File.EntityType r104 = r100.entity_type;
            if (r104 == null) goto L9;
            int r105 = File.EntityType.ADAPTER.encodedSizeWithTag(6, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.entity_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(2, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.inner_msg_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(3, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.auth_file_key;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r113);
        L22:
            return (((r112 + r102) + this.im_ext.encodedSizeWithTag(7, r100.im_ext)) + this.ext.encodedSizeWithTag(5, r100.ext)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ CardVisitInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CardVisitInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CardVisitInfo r101) throws IOException {
            DownloadFileScene r102 = r101.scene_type;
            if (r102 == null) goto L5;
            DownloadFileScene.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            File.EntityType r103 = r101.entity_type;
            if (r103 == null) goto L8;
            File.EntityType.ADAPTER.encodeWithTag(r100, 6, r103);
        L8:
            String r104 = r101.entity_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r104);
        L11:
            Long r105 = r101.inner_msg_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r105);
        L14:
            String r106 = r101.auth_file_key;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r106);
        L17:
            this.im_ext.encodeWithTag(r100, 7, r101.im_ext);
            this.ext.encodeWithTag(r100, 5, r101.ext);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CardVisitInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CardVisitInfo();
        DEFAULT_SCENE_TYPE = DownloadFileScene.UNKNOWN;
        DEFAULT_ENTITY_TYPE = File.EntityType.MESSAGE;
        DEFAULT_INNER_MSG_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scene_type = this.scene_type;
        r100.entity_type = this.entity_type;
        r100.entity_id = this.entity_id;
        r100.inner_msg_id = this.inner_msg_id;
        r100.auth_file_key = this.auth_file_key;
        r100.im_ext = Internal.copyOf("im_ext", this.im_ext);
        r100.ext = Internal.copyOf("ext", this.ext);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CardVisitInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CardVisitInfo(DownloadFileScene r110, File.EntityType r111, String r112, Long r113, String r114, Map<String, String> r115, Map<String, String> r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public CardVisitInfo(DownloadFileScene r100, File.EntityType r101, String r102, Long r103, String r104, Map<String, String> r105, Map<String, String> r106, ByteString r107) {
        super(ADAPTER, r107);
        this.scene_type = r100;
        this.entity_type = r101;
        this.entity_id = r102;
        this.inner_msg_id = r103;
        this.auth_file_key = r104;
        this.im_ext = Internal.immutableCopyOf("im_ext", r105);
        this.ext = Internal.immutableCopyOf("ext", r106);
    }
}
