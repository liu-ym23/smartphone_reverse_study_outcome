package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TopicGroup extends com.squareup.wire.Message<TopicGroup, Builder> {
    public static final ProtoAdapter<TopicGroup> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253579id;
    public final Type type;
    public final UserSetting user_setting;

    public static final class Builder extends com.squareup.wire.Message.Builder<TopicGroup, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253580id;
        public Type type;
        public UserSetting user_setting;

        @Override // com.squareup.wire.Message.Builder
        public TopicGroup build() {
            String r100 = this.f253580id;
            if (r100 == null) goto L9;
            if (this.type == null) goto L9;
            return new TopicGroup(this.f253580id, this.type, this.user_setting, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.type, "type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f253580id = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder user_setting(UserSetting r100) {
            this.user_setting = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TopicGroup extends ProtoAdapter<TopicGroup> {
        public ProtoAdapter_TopicGroup() {
            super(FieldEncoding.LENGTH_DELIMITED, TopicGroup.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TopicGroup decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253580id = "";
            r101.type = Type.UNKNOWN_TYPE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.f253580id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.user_setting = UserSetting.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TopicGroup r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253579id) + Type.ADAPTER.encodedSizeWithTag(2, r100.type);
            UserSetting r102 = r100.user_setting;
            if (r102 == null) goto L5;
            int r103 = UserSetting.ADAPTER.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TopicGroup decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TopicGroup r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TopicGroup r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253579id);
            Type.ADAPTER.encodeWithTag(r100, 2, r101.type);
            UserSetting r102 = r101.user_setting;
            if (r102 == null) goto L5;
            UserSetting.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TopicGroup r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type DEFAULT = null;
        public static final Type NORMAL = null;
        public static final Type PUBLIC = null;
        public static final Type UNKNOWN_TYPE = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            Type r101 = new Type(EffectConstants.NORMAL, 1, 1);
            NORMAL = r101;
            Type r102 = new Type("DEFAULT", 2, 2);
            DEFAULT = r102;
            Type r103 = new Type("PUBLIC", 3, 3);
            PUBLIC = r103;
            $VALUES = new Type[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return PUBLIC;
        L14:
            return DEFAULT;
        L16:
            return NORMAL;
        L18:
            return UNKNOWN_TYPE;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class UserSetting extends com.squareup.wire.Message<UserSetting, Builder> {
        public static final ProtoAdapter<UserSetting> ADAPTER = null;
        public static final Boolean DEFAULT_IS_FAVORITE = null;
        public static final TopicGroupRole DEFAULT_TOPIC_GROUP_ROLE = null;
        public static final Long DEFAULT_UPDATE_TIME = null;
        private static final long serialVersionUID = 0;
        public final Boolean is_favorite;
        public final TopicGroupRole topic_group_role;
        public final Long update_time;

        public static final class Builder extends com.squareup.wire.Message.Builder<UserSetting, Builder> {
            public Boolean is_favorite;
            public TopicGroupRole topic_group_role;
            public Long update_time;

            @Override // com.squareup.wire.Message.Builder
            public UserSetting build() {
                return new UserSetting(this.is_favorite, this.update_time, this.topic_group_role, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder is_favorite(Boolean r100) {
                this.is_favorite = r100;
                return this;
            }

            public Builder topic_group_role(TopicGroupRole r100) {
                this.topic_group_role = r100;
                return this;
            }

            public Builder update_time(Long r100) {
                this.update_time = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UserSetting extends ProtoAdapter<UserSetting> {
            public ProtoAdapter_UserSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, UserSetting.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UserSetting decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.is_favorite = Boolean.FALSE;
                r101.update_time = 0L;
                r101.topic_group_role = TopicGroupRole.UNKNOWN_ROLE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.is_favorite = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.update_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.topic_group_role = TopicGroupRole.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(UserSetting r100) {
                Boolean r101 = r100.is_favorite;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.update_time;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                TopicGroupRole r107 = r100.topic_group_role;
                if (r107 == null) goto L14;
                r102 = TopicGroupRole.ADAPTER.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ UserSetting decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UserSetting r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UserSetting r101) throws IOException {
                Boolean r102 = r101.is_favorite;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.update_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                TopicGroupRole r104 = r101.topic_group_role;
                if (r104 == null) goto L11;
                TopicGroupRole.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserSetting r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserSetting();
            DEFAULT_IS_FAVORITE = Boolean.FALSE;
            DEFAULT_UPDATE_TIME = 0L;
            DEFAULT_TOPIC_GROUP_ROLE = TopicGroupRole.UNKNOWN_ROLE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_favorite = this.is_favorite;
            r100.update_time = this.update_time;
            r100.topic_group_role = this.topic_group_role;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UserSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public UserSetting(Boolean r100, Long r101, TopicGroupRole r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public UserSetting(Boolean r100, Long r101, TopicGroupRole r102, ByteString r103) {
            super(ADAPTER, r103);
            this.is_favorite = r100;
            this.update_time = r101;
            this.topic_group_role = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TopicGroup();
        DEFAULT_TYPE = Type.UNKNOWN_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253580id = this.f253579id;
        r100.type = this.type;
        r100.user_setting = this.user_setting;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TopicGroup.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TopicGroup(String r100, Type r101, UserSetting r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TopicGroup(String r100, Type r101, UserSetting r102, ByteString r103) {
        super(ADAPTER, r103);
        this.f253579id = r100;
        this.type = r101;
        this.user_setting = r102;
    }
}
