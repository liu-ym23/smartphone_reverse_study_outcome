package com.bytedance.lark.pb.contact.v2;

import com.bytedance.lark.pb.basic.v1.ContactSource;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUserProfileRequest extends Message<GetUserProfileRequest, Builder> {
    public static final ProtoAdapter<GetUserProfileRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_CONTACT_TOKEN = "";
    public static final Boolean DEFAULT_IS_SUPPORT_MEMO_RICHTEXT = null;
    public static final Boolean DEFAULT_IS_SUPPORT_ONE_WAY_RELATION = null;
    public static final Boolean DEFAULT_NEED_AUDIT = null;
    public static final Scene DEFAULT_SCENE = null;
    public static final ContactSource DEFAULT_SOURCE = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final String DEFAULT_USER_ID = "";
    public static final Boolean DEFAULT_USE_NEW_LAYOUT = null;
    public static final ProtoAdapter_GetUserProfileRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final String contact_token;
    public final Boolean is_support_memo_richtext;
    public final Boolean is_support_one_way_relation;
    public final Boolean need_audit;
    public final Scene scene;
    public final ContactSource source;
    public final SyncDataStrategy sync_data_strategy;
    public final Boolean use_new_layout;
    public final String user_id;

    public static final class Builder extends Message.Builder<GetUserProfileRequest, Builder> implements d<GetUserProfileRequest> {
        public String chat_id;
        public String contact_token;
        public Boolean is_support_memo_richtext;
        public Boolean is_support_one_way_relation;
        public Boolean need_audit;
        public Scene scene;
        public ContactSource source;
        public SyncDataStrategy sync_data_strategy;
        public Boolean use_new_layout;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public GetUserProfileRequest build() {
            Scene r100 = this.scene;
            if (r100 == null) goto L9;
            if (this.sync_data_strategy == null) goto L9;
            return new GetUserProfileRequest(this.scene, this.sync_data_strategy, this.user_id, this.contact_token, this.chat_id, this.source, this.need_audit, this.is_support_one_way_relation, this.use_new_layout, this.is_support_memo_richtext, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "scene", this.sync_data_strategy, "sync_data_strategy"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder contact_token(String r100) {
            this.contact_token = r100;
            return this;
        }

        public Builder is_support_memo_richtext(Boolean r100) {
            this.is_support_memo_richtext = r100;
            return this;
        }

        public Builder is_support_one_way_relation(Boolean r100) {
            this.is_support_one_way_relation = r100;
            return this;
        }

        public Builder need_audit(Boolean r100) {
            this.need_audit = r100;
            return this;
        }

        public Builder scene(Scene r100) {
            this.scene = r100;
            return this;
        }

        public Builder source(ContactSource r100) {
            this.source = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }

        public Builder use_new_layout(Boolean r100) {
            this.use_new_layout = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserProfileRequest extends ProtoAdapter<GetUserProfileRequest> implements c<GetUserProfileRequest> {
        public ProtoAdapter_GetUserProfileRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserProfileRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserProfileRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scene = Scene.UNKNOWN;
            r101.sync_data_strategy = SyncDataStrategy.LOCAL;
            r101.user_id = "";
            r101.contact_token = "";
            r101.chat_id = "";
            r101.source = ContactSource.UNKNOWN_SOURCE;
            Boolean r102 = Boolean.FALSE;
            r101.need_audit = r102;
            r101.is_support_one_way_relation = r102;
            r101.use_new_layout = r102;
            r101.is_support_memo_richtext = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L29;
            if (r104 != 14) goto L7;
            r101.need_audit = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L7:
            switch(r104) {
                case 1: goto L35;
                case 2: goto L31;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L33;
                default: goto L8;
            };
        L31:
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L33:
            r101.source = ContactSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L35:
            r101.scene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
        L26:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L17:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.contact_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            switch(r104) {
                case 100: goto L12;
                case 101: goto L11;
                case 102: goto L10;
                default: goto L9;
            };
        L10:
            r101.is_support_memo_richtext = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.use_new_layout = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.is_support_one_way_relation = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L29:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetUserProfileRequest r100) {
            int r101 = Scene.ADAPTER.encodedSizeWithTag(1, r100.scene) + SyncDataStrategy.ADAPTER.encodedSizeWithTag(2, r100.sync_data_strategy);
            String r102 = r100.user_id;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.contact_token;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(4, r106);
        L10:
            int r108 = r105 + r107;
            String r109 = r100.chat_id;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.STRING.encodedSizeWithTag(5, r109);
        L14:
            int r111 = r108 + r110;
            ContactSource r112 = r100.source;
            if (r112 == null) goto L17;
            int r113 = ContactSource.ADAPTER.encodedSizeWithTag(6, r112);
        L18:
            int r114 = r111 + r113;
            Boolean r115 = r100.need_audit;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r115);
        L22:
            int r117 = r114 + r116;
            Boolean r118 = r100.is_support_one_way_relation;
            if (r118 == null) goto L25;
            int r119 = ProtoAdapter.BOOL.encodedSizeWithTag(100, r118);
        L26:
            int r120 = r117 + r119;
            Boolean r121 = r100.use_new_layout;
            if (r121 == null) goto L29;
            int r122 = ProtoAdapter.BOOL.encodedSizeWithTag(101, r121);
        L30:
            int r123 = r120 + r122;
            Boolean r124 = r100.is_support_memo_richtext;
            if (r124 == null) goto L34;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(102, r124);
        L34:
            return (r123 + r103) + r100.unknownFields().size();
        L29:
            r122 = 0;
            goto L30
        L25:
            r119 = 0;
            goto L26
        L21:
            r116 = 0;
            goto L22
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserProfileRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserProfileRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserProfileRequest r101) throws IOException {
            Scene.ADAPTER.encodeWithTag(r100, 1, r101.scene);
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 2, r101.sync_data_strategy);
            String r102 = r101.user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r102);
        L5:
            String r103 = r101.contact_token;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r103);
        L8:
            String r104 = r101.chat_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r104);
        L11:
            ContactSource r105 = r101.source;
            if (r105 == null) goto L14;
            ContactSource.ADAPTER.encodeWithTag(r100, 6, r105);
        L14:
            Boolean r106 = r101.need_audit;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r106);
        L17:
            Boolean r107 = r101.is_support_one_way_relation;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 100, r107);
        L20:
            Boolean r108 = r101.use_new_layout;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 101, r108);
        L23:
            Boolean r109 = r101.is_support_memo_richtext;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 102, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserProfileRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene BY_CONTACT_TOKEN = null;
        public static final Scene BY_USER_ID = null;
        public static final Scene IN_CHAT = null;
        public static final Scene UNKNOWN = null;
        private final int value;

        static {
            Scene r100 = new Scene("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Scene r101 = new Scene("BY_USER_ID", 1, 1);
            BY_USER_ID = r101;
            Scene r102 = new Scene("BY_CONTACT_TOKEN", 2, 2);
            BY_CONTACT_TOKEN = r102;
            Scene r103 = new Scene("IN_CHAT", 3, 100);
            IN_CHAT = r103;
            $VALUES = new Scene[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 100) goto L12;
            return null;
        L12:
            return IN_CHAT;
        L14:
            return BY_CONTACT_TOKEN;
        L16:
            return BY_USER_ID;
        L18:
            return UNKNOWN;
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        private Scene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_GetUserProfileRequest r100 = new ProtoAdapter_GetUserProfileRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SCENE = Scene.UNKNOWN;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.LOCAL;
        DEFAULT_SOURCE = ContactSource.UNKNOWN_SOURCE;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_NEED_AUDIT = r101;
        DEFAULT_IS_SUPPORT_ONE_WAY_RELATION = r101;
        DEFAULT_USE_NEW_LAYOUT = r101;
        DEFAULT_IS_SUPPORT_MEMO_RICHTEXT = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scene = this.scene;
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.user_id = this.user_id;
        r100.contact_token = this.contact_token;
        r100.chat_id = this.chat_id;
        r100.source = this.source;
        r100.need_audit = this.need_audit;
        r100.is_support_one_way_relation = this.is_support_one_way_relation;
        r100.use_new_layout = this.use_new_layout;
        r100.is_support_memo_richtext = this.is_support_memo_richtext;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserProfileRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserProfileRequest(Scene r110, SyncDataStrategy r111, String r112, String r113, String r114, ContactSource r115, Boolean r116, Boolean r210, Boolean r211, Boolean r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public GetUserProfileRequest(Scene r100, SyncDataStrategy r101, String r102, String r103, String r104, ContactSource r105, Boolean r106, Boolean r107, Boolean r110, Boolean r111, ByteString r112) {
        super(ADAPTER, r112);
        this.scene = r100;
        this.sync_data_strategy = r101;
        this.user_id = r102;
        this.contact_token = r103;
        this.chat_id = r104;
        this.source = r105;
        this.need_audit = r106;
        this.is_support_one_way_relation = r107;
        this.use_new_layout = r110;
        this.is_support_memo_richtext = r111;
    }
}
