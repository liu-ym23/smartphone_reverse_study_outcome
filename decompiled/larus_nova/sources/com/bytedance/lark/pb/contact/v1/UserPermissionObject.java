package com.bytedance.lark.pb.contact.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class UserPermissionObject extends Message<UserPermissionObject, Builder> {
    public static final ProtoAdapter<UserPermissionObject> ADAPTER = null;
    public static final String DEFAULT_IMAGE_KEY = "";
    public static final String DEFAULT_OBJECT_ID = "";
    public static final String DEFAULT_OBJECT_NAME = "";
    public static final String DEFAULT_OBJECT_NAME_LOCAL = "";
    public static final ObjectType DEFAULT_OBJECT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String image_key;
    public final Map<String, String> object_i18n_name;
    public final String object_id;
    public final String object_name;
    public final String object_name_local;
    public final ObjectType object_type;

    public static final class Builder extends Message.Builder<UserPermissionObject, Builder> {
        public String image_key;
        public Map<String, String> object_i18n_name;
        public String object_id;
        public String object_name;
        public String object_name_local;
        public ObjectType object_type;

        @Override // com.squareup.wire.Message.Builder
        public UserPermissionObject build() {
            return new UserPermissionObject(this.object_type, this.object_id, this.object_name, this.object_i18n_name, this.object_name_local, this.image_key, super.buildUnknownFields());
        }

        public Builder() {
            this.object_i18n_name = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder image_key(String r100) {
            this.image_key = r100;
            return this;
        }

        public Builder object_i18n_name(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.object_i18n_name = r100;
            return this;
        }

        public Builder object_id(String r100) {
            this.object_id = r100;
            return this;
        }

        public Builder object_name(String r100) {
            this.object_name = r100;
            return this;
        }

        public Builder object_name_local(String r100) {
            this.object_name_local = r100;
            return this;
        }

        public Builder object_type(ObjectType r100) {
            this.object_type = r100;
            return this;
        }
    }

    public static final enum ObjectType extends Enum<ObjectType> implements WireEnum {
        private static final /* synthetic */ ObjectType[] $VALUES = null;
        public static final ProtoAdapter<ObjectType> ADAPTER = null;
        public static final ObjectType CHAT = null;
        public static final ObjectType CUSTOM_GROUP = null;
        public static final ObjectType TEAM = null;
        public static final ObjectType UNKNOWN_OBJECT_TYPE = null;
        public static final ObjectType USER = null;
        public static final ObjectType USER_TYPE = null;
        private final int value;

        static {
            ObjectType r100 = new ObjectType("UNKNOWN_OBJECT_TYPE", 0, 0);
            UNKNOWN_OBJECT_TYPE = r100;
            ObjectType r101 = new ObjectType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            ObjectType r102 = new ObjectType("CHAT", 2, 2);
            CHAT = r102;
            ObjectType r103 = new ObjectType("USER_TYPE", 3, 3);
            USER_TYPE = r103;
            ObjectType r104 = new ObjectType("TEAM", 4, 4);
            TEAM = r104;
            ObjectType r105 = new ObjectType("CUSTOM_GROUP", 5, 5);
            CUSTOM_GROUP = r105;
            $VALUES = new ObjectType[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(ObjectType.class);
        }

        public static ObjectType[] values() {
            return (ObjectType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ObjectType fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return CUSTOM_GROUP;
        L18:
            return TEAM;
        L20:
            return USER_TYPE;
        L22:
            return CHAT;
        L24:
            return USER;
        L26:
            return UNKNOWN_OBJECT_TYPE;
        }

        public static ObjectType valueOf(String r100) {
            return (ObjectType) a.a(ObjectType.class, r100);
        }

        private ObjectType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_UserPermissionObject extends ProtoAdapter<UserPermissionObject> {
        private final ProtoAdapter<Map<String, String>> object_i18n_name;

        public ProtoAdapter_UserPermissionObject() {
            super(FieldEncoding.LENGTH_DELIMITED, UserPermissionObject.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.object_i18n_name = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserPermissionObject decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.object_type = ObjectType.UNKNOWN_OBJECT_TYPE;
            r101.object_id = "";
            r101.object_name = "";
            r101.object_name_local = "";
            r101.image_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.object_type = ObjectType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.object_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.object_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.object_i18n_name.putAll(this.object_i18n_name.decode(r100));
            goto L3
        L14:
            if (r103 != 10) goto L16;
            r101.object_name_local = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            if (r103 != 11) goto L17;
            r101.image_key = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UserPermissionObject r100) {
            ObjectType r101 = r100.object_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ObjectType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.object_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.object_name;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = (r106 + r108) + this.object_i18n_name.encodedSizeWithTag(4, r100.object_i18n_name);
            String r110 = r100.object_name_local;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(10, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.image_key;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(11, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ UserPermissionObject decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserPermissionObject r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserPermissionObject r101) throws IOException {
            ObjectType r102 = r101.object_type;
            if (r102 == null) goto L5;
            ObjectType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.object_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.object_name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            this.object_i18n_name.encodeWithTag(r100, 4, r101.object_i18n_name);
            String r105 = r101.object_name_local;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r105);
        L14:
            String r106 = r101.image_key;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserPermissionObject r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserPermissionObject();
        DEFAULT_OBJECT_TYPE = ObjectType.UNKNOWN_OBJECT_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.object_type = this.object_type;
        r100.object_id = this.object_id;
        r100.object_name = this.object_name;
        r100.object_i18n_name = Internal.copyOf("object_i18n_name", this.object_i18n_name);
        r100.object_name_local = this.object_name_local;
        r100.image_key = this.image_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserPermissionObject.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserPermissionObject(ObjectType r100, String r110, String r111, Map<String, String> r112, String r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public UserPermissionObject(ObjectType r100, String r101, String r102, Map<String, String> r103, String r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.object_type = r100;
        this.object_id = r101;
        this.object_name = r102;
        this.object_i18n_name = Internal.immutableCopyOf("object_i18n_name", r103);
        this.object_name_local = r104;
        this.image_key = r105;
    }
}
