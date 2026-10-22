package com.bytedance.lark.pb.basic.v1;

import annotation.OptionsExt;
import com.bytedance.ee.bear.drive.biz.cache.manual.model.ManualOfflineSyncData;
import com.google.protobuf.EnumOptions;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.obric.capabilitykit.EntityProvider;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class FeedCard extends com.squareup.wire.Message<FeedCard, Builder> {
    public static final ProtoAdapter<FeedCard> ADAPTER = null;
    public static final EntityType DEFAULT_ENTITY_TYPE = null;
    public static final FeedType DEFAULT_FEED_TYPE = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_PARENT_CARD_ID = "";
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final EntityType entity_type;
    public final FeedType feed_type;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253499id;
    public final String parent_card_id;
    public final Long update_time;

    public static final class Builder extends com.squareup.wire.Message.Builder<FeedCard, Builder> {
        public EntityType entity_type;
        public FeedType feed_type;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253500id;
        public String parent_card_id;
        public Long update_time;

        @Override // com.squareup.wire.Message.Builder
        public FeedCard build() {
            String r100 = this.f253500id;
            if (r100 == null) goto L9;
            if (this.entity_type == null) goto L9;
            return new FeedCard(this.f253500id, this.entity_type, this.feed_type, this.update_time, this.parent_card_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.entity_type, EntityProvider.KEY_ENTITY_TYPE});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder entity_type(EntityType r100) {
            this.entity_type = r100;
            return this;
        }

        public Builder feed_type(FeedType r100) {
            this.feed_type = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253500id = r100;
            return this;
        }

        public Builder parent_card_id(String r100) {
            this.parent_card_id = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }
    }

    public static final enum EntityType extends Enum<EntityType> implements WireEnum {
        private static final /* synthetic */ EntityType[] $VALUES = null;
        public static final ProtoAdapter<EntityType> ADAPTER = null;
        public static final EntityType APP_FEED = null;
        public static final EntityType BOX = null;
        public static final EntityType CHAT = null;
        public static final EntityType DOC_FEED = null;
        public static final EntityType DOUBAO_CUSTOM = null;
        public static final EntityType EMAIL = null;
        public static final EntityType EMAIL_ROOT_DRAFT = null;
        public static final EnumOptions ENUM_OPTIONS = null;
        public static final EntityType KNOWLEDGE_AI = null;
        public static final EntityType MSG_THREAD = null;
        public static final EntityType MY_AI = null;
        public static final EntityType OPENAPP = null;
        public static final EntityType SUBSCRIPTION = null;
        public static final EntityType THREAD = null;
        public static final EntityType TOPIC = null;
        public static final EntityType UNKNOWN_ENTITY = null;
        private final int value;

        static {
            EntityType r100 = new EntityType("UNKNOWN_ENTITY", 0, 0);
            UNKNOWN_ENTITY = r100;
            EntityType r101 = new EntityType("CHAT", 1, 1);
            CHAT = r101;
            EntityType r102 = new EntityType(CommonConstant.RETKEY.EMAIL, 2, 2);
            EMAIL = r102;
            EntityType r103 = new EntityType("DOC_FEED", 3, 3);
            DOC_FEED = r103;
            EntityType r104 = new EntityType("THREAD", 4, 4);
            THREAD = r104;
            EntityType r105 = new EntityType(ManualOfflineSyncData.DRIVE_TYPE, 5, 5);
            BOX = r105;
            EntityType r110 = new EntityType("OPENAPP", 6, 6);
            OPENAPP = r110;
            EntityType r111 = new EntityType("TOPIC", 7, 7);
            TOPIC = r111;
            EntityType r112 = new EntityType("SUBSCRIPTION", 8, 10);
            SUBSCRIPTION = r112;
            EntityType r113 = new EntityType("MSG_THREAD", 9, 11);
            MSG_THREAD = r113;
            EntityType r114 = new EntityType("MY_AI", 10, 12);
            MY_AI = r114;
            EntityType r106 = new EntityType("APP_FEED", 11, 13);
            APP_FEED = r106;
            EntityType r115 = new EntityType("KNOWLEDGE_AI", 12, 14);
            KNOWLEDGE_AI = r115;
            EntityType r107 = new EntityType("DOUBAO_CUSTOM", 13, 15);
            DOUBAO_CUSTOM = r107;
            EntityType r108 = new EntityType("EMAIL_ROOT_DRAFT", 14, 100);
            EMAIL_ROOT_DRAFT = r108;
            $VALUES = new EntityType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r115, r107, r108};
            ADAPTER = ProtoAdapter.newEnumAdapter(EntityType.class);
            ENUM_OPTIONS = new EnumOptions.Builder().enum_options(new OptionsExt.Builder().iter(Boolean.TRUE).build()).build();
        }

        public static EntityType[] values() {
            return (EntityType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static EntityType fromValue(int r100) {
            if (r100 == 100) goto L37;
            switch(r100) {
                case 0: goto L35;
                case 1: goto L33;
                case 2: goto L31;
                case 3: goto L29;
                case 4: goto L27;
                case 5: goto L25;
                case 6: goto L23;
                case 7: goto L21;
                default: goto L5;
            };
        L5:
            switch(r100) {
                case 10: goto L19;
                case 11: goto L17;
                case 12: goto L15;
                case 13: goto L13;
                case 14: goto L11;
                case 15: goto L9;
                default: goto L6;
            };
        L6:
            return null;
        L9:
            return DOUBAO_CUSTOM;
        L11:
            return KNOWLEDGE_AI;
        L13:
            return APP_FEED;
        L15:
            return MY_AI;
        L17:
            return MSG_THREAD;
        L19:
            return SUBSCRIPTION;
        L21:
            return TOPIC;
        L23:
            return OPENAPP;
        L25:
            return BOX;
        L27:
            return THREAD;
        L29:
            return DOC_FEED;
        L31:
            return EMAIL;
        L33:
            return CHAT;
        L35:
            return UNKNOWN_ENTITY;
        L37:
            return EMAIL_ROOT_DRAFT;
        }

        public static EntityType valueOf(String r100) {
            return (EntityType) a.a(EntityType.class, r100);
        }

        private EntityType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum FeedType extends Enum<FeedType> implements WireEnum {
        private static final /* synthetic */ FeedType[] $VALUES = null;
        public static final ProtoAdapter<FeedType> ADAPTER = null;
        public static final FeedType DONE = null;
        public static final FeedType INBOX = null;
        public static final FeedType MARK_AS_DELETED = null;
        public static final FeedType UNKNOWN = null;
        private final int value;

        static {
            FeedType r100 = new FeedType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            FeedType r101 = new FeedType("INBOX", 1, 1);
            INBOX = r101;
            FeedType r102 = new FeedType("DONE", 2, 2);
            DONE = r102;
            FeedType r103 = new FeedType("MARK_AS_DELETED", 3, 3);
            MARK_AS_DELETED = r103;
            $VALUES = new FeedType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(FeedType.class);
        }

        public static FeedType[] values() {
            return (FeedType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FeedType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return MARK_AS_DELETED;
        L14:
            return DONE;
        L16:
            return INBOX;
        L18:
            return UNKNOWN;
        }

        public static FeedType valueOf(String r100) {
            return (FeedType) a.a(FeedType.class, r100);
        }

        private FeedType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_FeedCard extends ProtoAdapter<FeedCard> {
        public ProtoAdapter_FeedCard() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedCard.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedCard decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253500id = "";
            r101.entity_type = EntityType.UNKNOWN_ENTITY;
            r101.feed_type = FeedType.UNKNOWN;
            r101.update_time = 0L;
            r101.parent_card_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.f253500id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.entity_type = EntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.feed_type = FeedType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.parent_card_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FeedCard r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253499id) + EntityType.ADAPTER.encodedSizeWithTag(2, r100.entity_type);
            FeedType r103 = r100.feed_type;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = FeedType.ADAPTER.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            Long r107 = r100.update_time;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.parent_card_id;
            if (r110 == null) goto L14;
            r104 = r101.encodedSizeWithTag(5, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeedCard decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedCard r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedCard r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253499id);
            EntityType.ADAPTER.encodeWithTag(r100, 2, r101.entity_type);
            FeedType r103 = r101.feed_type;
            if (r103 == null) goto L5;
            FeedType.ADAPTER.encodeWithTag(r100, 3, r103);
        L5:
            Long r104 = r101.update_time;
            if (r104 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r104);
        L8:
            String r105 = r101.parent_card_id;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 5, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedCard r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedCard();
        DEFAULT_ENTITY_TYPE = EntityType.UNKNOWN_ENTITY;
        DEFAULT_FEED_TYPE = FeedType.UNKNOWN;
        DEFAULT_UPDATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253500id = this.f253499id;
        r100.entity_type = this.entity_type;
        r100.feed_type = this.feed_type;
        r100.update_time = this.update_time;
        r100.parent_card_id = this.parent_card_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedCard.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedCard(String r100, EntityType r101, FeedType r110, Long r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public FeedCard(String r100, EntityType r101, FeedType r102, Long r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.f253499id = r100;
        this.entity_type = r101;
        this.feed_type = r102;
        this.update_time = r103;
        this.parent_card_id = r104;
    }
}
