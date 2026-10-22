package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UserGroupEntity extends Message<UserGroupEntity, Builder> {
    public static final ProtoAdapter<UserGroupEntity> ADAPTER = null;
    public static final Long DEFAULT_CACHE_TIME = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final Long DEFAULT_ID = null;
    public static final Integer DEFAULT_MEMBER_COUNT = null;
    public static final Long DEFAULT_SERVER_TIME = null;
    public static final Integer DEFAULT_STATUS = null;
    private static final long serialVersionUID = 0;
    public final Long cache_time;
    public final String description;
    public final String display_name;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f253667id;
    public final Integer member_count;
    public final Long server_time;
    public final Integer status;

    public static final class Builder extends Message.Builder<UserGroupEntity, Builder> {
        public Long cache_time;
        public String description;
        public String display_name;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f253668id;
        public Integer member_count;
        public Long server_time;
        public Integer status;

        @Override // com.squareup.wire.Message.Builder
        public UserGroupEntity build() {
            return new UserGroupEntity(this.f253668id, this.display_name, this.description, this.member_count, this.status, this.server_time, this.cache_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cache_time(Long r100) {
            this.cache_time = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder display_name(String r100) {
            this.display_name = r100;
            return this;
        }

        public Builder id(Long r100) {
            this.f253668id = r100;
            return this;
        }

        public Builder member_count(Integer r100) {
            this.member_count = r100;
            return this;
        }

        public Builder server_time(Long r100) {
            this.server_time = r100;
            return this;
        }

        public Builder status(Integer r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserGroupEntity extends ProtoAdapter<UserGroupEntity> {
        public ProtoAdapter_UserGroupEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, UserGroupEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserGroupEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253668id = 0L;
            r101.display_name = "";
            r101.description = "";
            r101.member_count = 0;
            r101.status = 0;
            r101.server_time = 0L;
            r101.cache_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.cache_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.server_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.status = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.member_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.display_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.f253668id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UserGroupEntity r100) {
            Long r101 = r100.f253667id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.display_name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.description;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Integer r110 = r100.member_count;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Integer r113 = r100.status;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.server_time;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.cache_time;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ UserGroupEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserGroupEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserGroupEntity r101) throws IOException {
            Long r102 = r101.f253667id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.display_name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.description;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Integer r105 = r101.member_count;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L14:
            Integer r106 = r101.status;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L17:
            Long r107 = r101.server_time;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.cache_time;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserGroupEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserGroupEntity();
        DEFAULT_ID = 0L;
        DEFAULT_MEMBER_COUNT = 0;
        DEFAULT_STATUS = 0;
        DEFAULT_SERVER_TIME = 0L;
        DEFAULT_CACHE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253668id = this.f253667id;
        r100.display_name = this.display_name;
        r100.description = this.description;
        r100.member_count = this.member_count;
        r100.status = this.status;
        r100.server_time = this.server_time;
        r100.cache_time = this.cache_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserGroupEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserGroupEntity(Long r110, String r111, String r112, Integer r113, Integer r114, Long r115, Long r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public UserGroupEntity(Long r100, String r101, String r102, Integer r103, Integer r104, Long r105, Long r106, ByteString r107) {
        super(ADAPTER, r107);
        this.f253667id = r100;
        this.display_name = r101;
        this.description = r102;
        this.member_count = r103;
        this.status = r104;
        this.server_time = r105;
        this.cache_time = r106;
    }
}
