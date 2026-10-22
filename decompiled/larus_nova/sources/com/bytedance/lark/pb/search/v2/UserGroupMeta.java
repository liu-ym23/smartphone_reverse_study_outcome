package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.basic.v1.UserGroupType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UserGroupMeta extends Message<UserGroupMeta, Builder> {
    public static final ProtoAdapter<UserGroupMeta> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_TYPE = null;
    public static final UserGroupType DEFAULT_USERGROUPTYPE = null;
    private static final long serialVersionUID = 0;
    public final String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253747id;
    public final String name;
    public final Integer type;
    public final UserGroupType userGroupType;

    public static final class Builder extends Message.Builder<UserGroupMeta, Builder> {
        public String description;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253748id;
        public String name;
        public Integer type;
        public UserGroupType userGroupType;

        @Override // com.squareup.wire.Message.Builder
        public UserGroupMeta build() {
            String r100 = this.f253748id;
            if (r100 == null) goto L7;
            return new UserGroupMeta(this.f253748id, this.type, this.name, this.description, this.userGroupType, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253748id = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder type(Integer r100) {
            this.type = r100;
            return this;
        }

        public Builder userGroupType(UserGroupType r100) {
            this.userGroupType = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserGroupMeta extends ProtoAdapter<UserGroupMeta> {
        public ProtoAdapter_UserGroupMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, UserGroupMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserGroupMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253748id = "";
            r101.type = 0;
            r101.name = "";
            r101.description = "";
            r101.userGroupType = UserGroupType.UserGroupType_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.f253748id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.userGroupType = UserGroupType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UserGroupMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253747id);
            Integer r103 = r100.type;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.name;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.description;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            UserGroupType r113 = r100.userGroupType;
            if (r113 == null) goto L18;
            r104 = UserGroupType.ADAPTER.encodedSizeWithTag(5, r113);
        L18:
            return (r112 + r104) + r100.unknownFields().size();
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserGroupMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserGroupMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserGroupMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253747id);
            Integer r103 = r101.type;
            if (r103 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.name;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.description;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            UserGroupType r106 = r101.userGroupType;
            if (r106 == null) goto L14;
            UserGroupType.ADAPTER.encodeWithTag(r100, 5, r106);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserGroupMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserGroupMeta();
        DEFAULT_TYPE = 0;
        DEFAULT_USERGROUPTYPE = UserGroupType.UserGroupType_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253748id = this.f253747id;
        r100.type = this.type;
        r100.name = this.name;
        r100.description = this.description;
        r100.userGroupType = this.userGroupType;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserGroupMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserGroupMeta(String r100, Integer r101, String r110, String r111, UserGroupType r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public UserGroupMeta(String r100, Integer r101, String r102, String r103, UserGroupType r104, ByteString r105) {
        super(ADAPTER, r105);
        this.f253747id = r100;
        this.type = r101;
        this.name = r102;
        this.description = r103;
        this.userGroupType = r104;
    }
}
