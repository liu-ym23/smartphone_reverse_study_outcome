package com.ss.android.lark.pb.settings;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class UserPermissionObject extends Message<UserPermissionObject, Builder> {
    public static final ProtoAdapter<UserPermissionObject> ADAPTER = null;
    public static final String DEFAULT_OBJECT_ID = "";
    public static final String DEFAULT_OBJECT_NAME = "";
    private static final long serialVersionUID = 0;
    public final Map<String, String> mobject_i18n_name;
    public final String mobject_id;
    public final String mobject_name;
    public final UserPermissionObjectType mobject_type;

    public static final class Builder extends Message.Builder<UserPermissionObject, Builder> {
        public Map<String, String> mobject_i18n_name;
        public String mobject_id;
        public String mobject_name;
        public UserPermissionObjectType mobject_type;

        @Override // com.squareup.wire.Message.Builder
        public UserPermissionObject build() {
            return new UserPermissionObject(this.mobject_type, this.mobject_id, this.mobject_name, this.mobject_i18n_name, super.buildUnknownFields());
        }

        public Builder() {
            this.mobject_i18n_name = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder object_i18n_name(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mobject_i18n_name = r100;
            return this;
        }

        public Builder object_id(String r100) {
            this.mobject_id = r100;
            return this;
        }

        public Builder object_name(String r100) {
            this.mobject_name = r100;
            return this;
        }

        public Builder object_type(UserPermissionObjectType r100) {
            this.mobject_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserPermissionObject extends ProtoAdapter<UserPermissionObject> {
        private final ProtoAdapter<Map<String, String>> mobject_i18n_name;

        public ProtoAdapter_UserPermissionObject() {
            super(FieldEncoding.LENGTH_DELIMITED, UserPermissionObject.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mobject_i18n_name = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserPermissionObject decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mobject_id = "";
            r101.mobject_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mobject_type = UserPermissionObjectType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mobject_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mobject_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mobject_i18n_name.putAll(this.mobject_i18n_name.decode(r100));
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
        public int encodedSize2(UserPermissionObject r100) {
            UserPermissionObjectType r101 = r100.mobject_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = UserPermissionObjectType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mobject_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mobject_name;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return ((r106 + r102) + this.mobject_i18n_name.encodedSizeWithTag(4, r100.mobject_i18n_name)) + r100.unknownFields().size();
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
            UserPermissionObjectType r102 = r101.mobject_type;
            if (r102 == null) goto L5;
            UserPermissionObjectType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mobject_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mobject_name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            this.mobject_i18n_name.encodeWithTag(r100, 4, r101.mobject_i18n_name);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserPermissionObject r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserPermissionObject();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mobject_type = this.mobject_type;
        r100.mobject_id = this.mobject_id;
        r100.mobject_name = this.mobject_name;
        r100.mobject_i18n_name = Internal.copyOf("mobject_i18n_name", this.mobject_i18n_name);
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

    public UserPermissionObject(UserPermissionObjectType r100, String r101, String r102, Map<String, String> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public UserPermissionObject(UserPermissionObjectType r100, String r101, String r102, Map<String, String> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mobject_type = r100;
        this.mobject_id = r101;
        this.mobject_name = r102;
        this.mobject_i18n_name = Internal.immutableCopyOf("mobject_i18n_name", r103);
    }
}
