package com.bytedance.lark.pb.tool.v1;

import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class MakeUserOnlineV2Response extends Message<MakeUserOnlineV2Response, Builder> {
    public static final ProtoAdapter<MakeUserOnlineV2Response> ADAPTER = null;
    public static final Long DEFAULT_DESTINATION_CONTAINER_ID = null;
    public static final OnlineScenario DEFAULT_ONLINE_SCENARIO = null;
    public static final Long DEFAULT_USER_CONTAINER_ID = null;
    public static final ProtoAdapter_MakeUserOnlineV2Response RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long destination_container_id;
    public final DomainSettings domain_settings;
    public final OnlineScenario online_scenario;
    public final Map<String, String> settings;
    public final User user;
    public final Long user_container_id;

    public static final class Builder extends Message.Builder<MakeUserOnlineV2Response, Builder> implements b<MakeUserOnlineV2Response> {
        public Long destination_container_id;
        public DomainSettings domain_settings;
        public OnlineScenario online_scenario;
        public Map<String, String> settings;
        public User user;
        public Long user_container_id;

        @Override // com.squareup.wire.Message.Builder
        public MakeUserOnlineV2Response build() {
            Long r100 = this.destination_container_id;
            if (r100 == null) goto L9;
            if (this.user_container_id == null) goto L9;
            return new MakeUserOnlineV2Response(this.destination_container_id, this.user_container_id, this.user, this.domain_settings, this.settings, this.online_scenario, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "destination_container_id", this.user_container_id, "user_container_id"});
        }

        public Builder() {
            this.settings = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder destination_container_id(Long r100) {
            this.destination_container_id = r100;
            return this;
        }

        public Builder domain_settings(DomainSettings r100) {
            this.domain_settings = r100;
            return this;
        }

        public Builder online_scenario(OnlineScenario r100) {
            this.online_scenario = r100;
            return this;
        }

        public Builder settings(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.settings = r100;
            return this;
        }

        public Builder user(User r100) {
            this.user = r100;
            return this;
        }

        public Builder user_container_id(Long r100) {
            this.user_container_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MakeUserOnlineV2Response extends ProtoAdapter<MakeUserOnlineV2Response> implements a<MakeUserOnlineV2Response> {
        private final ProtoAdapter<Map<String, String>> settings;

        public ProtoAdapter_MakeUserOnlineV2Response() {
            super(FieldEncoding.LENGTH_DELIMITED, MakeUserOnlineV2Response.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.settings = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MakeUserOnlineV2Response decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.destination_container_id = 0L;
            r101.user_container_id = 0L;
            r101.online_scenario = OnlineScenario.NORMAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.destination_container_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.user_container_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.user = User.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 5) goto L14;
            r101.domain_settings = DomainSettings.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 6) goto L16;
            r101.settings.putAll(this.settings.decode(r100));
            goto L3
        L16:
            if (r103 != 7) goto L17;
            r101.online_scenario = OnlineScenario.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L17:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MakeUserOnlineV2Response r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.UINT64;
            int r102 = r101.encodedSizeWithTag(1, r100.destination_container_id) + r101.encodedSizeWithTag(2, r100.user_container_id);
            User r103 = r100.user;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = User.ADAPTER.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            DomainSettings r107 = r100.domain_settings;
            if (r107 == null) goto L9;
            int r108 = DomainSettings.ADAPTER.encodedSizeWithTag(5, r107);
        L10:
            int r109 = (r106 + r108) + this.settings.encodedSizeWithTag(6, r100.settings);
            OnlineScenario r110 = r100.online_scenario;
            if (r110 == null) goto L14;
            r104 = OnlineScenario.ADAPTER.encodedSizeWithTag(7, r110);
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
        public /* bridge */ /* synthetic */ MakeUserOnlineV2Response decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MakeUserOnlineV2Response r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MakeUserOnlineV2Response r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.UINT64;
            r102.encodeWithTag(r100, 1, r101.destination_container_id);
            r102.encodeWithTag(r100, 2, r101.user_container_id);
            User r103 = r101.user;
            if (r103 == null) goto L5;
            User.ADAPTER.encodeWithTag(r100, 3, r103);
        L5:
            DomainSettings r104 = r101.domain_settings;
            if (r104 == null) goto L8;
            DomainSettings.ADAPTER.encodeWithTag(r100, 5, r104);
        L8:
            this.settings.encodeWithTag(r100, 6, r101.settings);
            OnlineScenario r105 = r101.online_scenario;
            if (r105 == null) goto L11;
            OnlineScenario.ADAPTER.encodeWithTag(r100, 7, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MakeUserOnlineV2Response r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class User extends Message<User, Builder> {
        public static final ProtoAdapter<User> ADAPTER = null;
        public static final String DEFAULT_AVATAR_KEY = "";
        public static final String DEFAULT_AVATAR_URL = "";
        public static final String DEFAULT_NAME = "";
        public static final Integer DEFAULT_STATUS = null;
        public static final Long DEFAULT_USER_ID = null;
        private static final long serialVersionUID = 0;
        public final String avatar_key;
        public final String avatar_url;
        public final String name;
        public final Integer status;
        public final Long user_id;

        public static final class Builder extends Message.Builder<User, Builder> {
            public String avatar_key;
            public String avatar_url;
            public String name;
            public Integer status;
            public Long user_id;

            @Override // com.squareup.wire.Message.Builder
            public User build() {
                Long r100 = this.user_id;
                if (r100 == null) goto L7;
                return new User(this.user_id, this.name, this.avatar_url, this.status, this.avatar_key, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "user_id"});
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

            public Builder avatar_url(String r100) {
                this.avatar_url = r100;
                return this;
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }

            public Builder status(Integer r100) {
                this.status = r100;
                return this;
            }

            public Builder user_id(Long r100) {
                this.user_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_User extends ProtoAdapter<User> {
            public ProtoAdapter_User() {
                super(FieldEncoding.LENGTH_DELIMITED, User.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public User decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.user_id = 0L;
                r101.name = "";
                r101.avatar_url = "";
                r101.status = 0;
                r101.avatar_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.user_id = ProtoAdapter.UINT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.avatar_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.status = ProtoAdapter.INT32.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.avatar_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(User r100) {
                int r101 = ProtoAdapter.UINT64.encodedSizeWithTag(1, r100.user_id);
                String r102 = r100.name;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
            L6:
                int r105 = r101 + r104;
                String r106 = r100.avatar_url;
                if (r106 == null) goto L9;
                int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
            L10:
                int r108 = r105 + r107;
                Integer r109 = r100.status;
                if (r109 == null) goto L13;
                int r110 = ProtoAdapter.INT32.encodedSizeWithTag(4, r109);
            L14:
                int r111 = r108 + r110;
                String r112 = r100.avatar_key;
                if (r112 == null) goto L18;
                r103 = ProtoAdapter.STRING.encodedSizeWithTag(5, r112);
            L18:
                return (r111 + r103) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ User decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(User r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, User r101) throws IOException {
                ProtoAdapter.UINT64.encodeWithTag(r100, 1, r101.user_id);
                String r102 = r101.name;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
            L5:
                String r103 = r101.avatar_url;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
            L8:
                Integer r104 = r101.status;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 4, r104);
            L11:
                String r105 = r101.avatar_key;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, User r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_User();
            DEFAULT_USER_ID = 0L;
            DEFAULT_STATUS = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_id = this.user_id;
            r100.name = this.name;
            r100.avatar_url = this.avatar_url;
            r100.status = this.status;
            r100.avatar_key = this.avatar_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return User.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public User(Long r100, String r101, String r110, Integer r111, String r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public User(Long r100, String r101, String r102, Integer r103, String r104, ByteString r105) {
            super(ADAPTER, r105);
            this.user_id = r100;
            this.name = r101;
            this.avatar_url = r102;
            this.status = r103;
            this.avatar_key = r104;
        }
    }

    static {
        ProtoAdapter_MakeUserOnlineV2Response r100 = new ProtoAdapter_MakeUserOnlineV2Response();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DESTINATION_CONTAINER_ID = 0L;
        DEFAULT_USER_CONTAINER_ID = 0L;
        DEFAULT_ONLINE_SCENARIO = OnlineScenario.NORMAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.destination_container_id = this.destination_container_id;
        r100.user_container_id = this.user_container_id;
        r100.user = this.user;
        r100.domain_settings = this.domain_settings;
        r100.settings = Internal.copyOf("settings", this.settings);
        r100.online_scenario = this.online_scenario;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MakeUserOnlineV2Response.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MakeUserOnlineV2Response(Long r100, Long r110, User r111, DomainSettings r112, Map<String, String> r113, OnlineScenario r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public MakeUserOnlineV2Response(Long r100, Long r101, User r102, DomainSettings r103, Map<String, String> r104, OnlineScenario r105, ByteString r106) {
        super(ADAPTER, r106);
        this.destination_container_id = r100;
        this.user_container_id = r101;
        this.user = r102;
        this.domain_settings = r103;
        this.settings = Internal.immutableCopyOf("settings", r104);
        this.online_scenario = r105;
    }
}
