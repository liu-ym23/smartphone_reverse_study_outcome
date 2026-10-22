package com.bytedance.lark.pb.basic.v1;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Oncall extends com.squareup.wire.Message<Oncall, Builder> {
    public static final ProtoAdapter<Oncall> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PHONE_NUMBER = "";
    public static final Boolean DEFAULT_REPORT_LOCATION = null;
    private static final long serialVersionUID = 0;
    public final ImageSet avatar;
    public final String avatar_key;
    public final String avatar_path;
    public final String chat_id;
    public final String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253525id;
    public final String name;
    public final String phone_number;
    public final Boolean report_location;
    public final List<Tag> tags;

    public static final class Builder extends com.squareup.wire.Message.Builder<Oncall, Builder> {
        public ImageSet avatar;
        public String avatar_key;
        public String avatar_path;
        public String chat_id;
        public String description;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253526id;
        public String name;
        public String phone_number;
        public Boolean report_location;
        public List<Tag> tags;

        @Override // com.squareup.wire.Message.Builder
        public Oncall build() {
            String r100 = this.f253526id;
            if (r100 == null) goto L9;
            if (this.name == null) goto L9;
            return new Oncall(this.f253526id, this.name, this.description, this.avatar, this.chat_id, this.avatar_key, this.phone_number, this.report_location, this.avatar_path, this.tags, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.name, "name"});
        }

        public Builder() {
            this.tags = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder avatar(ImageSet r100) {
            this.avatar = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder avatar_path(String r100) {
            this.avatar_path = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253526id = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder phone_number(String r100) {
            this.phone_number = r100;
            return this;
        }

        public Builder report_location(Boolean r100) {
            this.report_location = r100;
            return this;
        }

        public Builder tags(List<Tag> r100) {
            Internal.checkElementsNotNull(r100);
            this.tags = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Oncall extends ProtoAdapter<Oncall> {
        public ProtoAdapter_Oncall() {
            super(FieldEncoding.LENGTH_DELIMITED, Oncall.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Oncall decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253526id = "";
            r101.name = "";
            r101.description = "";
            r101.chat_id = "";
            r101.avatar_key = "";
            r101.phone_number = "";
            r101.report_location = Boolean.FALSE;
            r101.avatar_path = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L20;
            switch(r103) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L22;
                default: goto L6;
            };
        L22:
            r101.tags.add(Tag.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.avatar_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.report_location = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.phone_number = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.avatar = ImageSet.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.f253526id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(Oncall r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253525id) + r101.encodedSizeWithTag(2, r100.name);
            String r103 = r100.description;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            ImageSet r107 = r100.avatar;
            if (r107 == null) goto L9;
            int r108 = ImageSet.ADAPTER.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.chat_id;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.avatar_key;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.phone_number;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(7, r116);
        L22:
            int r118 = r115 + r117;
            Boolean r119 = r100.report_location;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r119);
        L26:
            int r121 = r118 + r120;
            String r122 = r100.avatar_path;
            if (r122 == null) goto L30;
            r104 = r101.encodedSizeWithTag(9, r122);
        L30:
            return ((r121 + r104) + Tag.ADAPTER.asRepeated().encodedSizeWithTag(10, r100.tags)) + r100.unknownFields().size();
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ Oncall decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Oncall r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Oncall r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253525id);
            r102.encodeWithTag(r100, 2, r101.name);
            String r103 = r101.description;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            ImageSet r104 = r101.avatar;
            if (r104 == null) goto L8;
            ImageSet.ADAPTER.encodeWithTag(r100, 4, r104);
        L8:
            String r105 = r101.chat_id;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 5, r105);
        L11:
            String r106 = r101.avatar_key;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 6, r106);
        L14:
            String r107 = r101.phone_number;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 7, r107);
        L17:
            Boolean r108 = r101.report_location;
            if (r108 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
        L20:
            String r109 = r101.avatar_path;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 9, r109);
        L23:
            Tag.ADAPTER.asRepeated().encodeWithTag(r100, 10, r101.tags);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Oncall r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Oncall();
        DEFAULT_REPORT_LOCATION = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253526id = this.f253525id;
        r100.name = this.name;
        r100.description = this.description;
        r100.avatar = this.avatar;
        r100.chat_id = this.chat_id;
        r100.avatar_key = this.avatar_key;
        r100.phone_number = this.phone_number;
        r100.report_location = this.report_location;
        r100.avatar_path = this.avatar_path;
        r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Oncall.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Oncall(String r110, String r111, String r112, ImageSet r113, String r114, String r115, String r116, Boolean r210, String r211, List<Tag> r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public Oncall(String r100, String r101, String r102, ImageSet r103, String r104, String r105, String r106, Boolean r107, String r110, List<Tag> r111, ByteString r112) {
        super(ADAPTER, r112);
        this.f253525id = r100;
        this.name = r101;
        this.description = r102;
        this.avatar = r103;
        this.chat_id = r104;
        this.avatar_key = r105;
        this.phone_number = r106;
        this.report_location = r107;
        this.avatar_path = r110;
        this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r111);
    }
}
