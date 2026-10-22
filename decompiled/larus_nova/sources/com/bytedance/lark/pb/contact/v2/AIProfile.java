package com.bytedance.lark.pb.contact.v2;

import com.bytedance.lark.pb.basic.v1.AvatarMedal;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class AIProfile extends Message<AIProfile, Builder> {
    public static final ProtoAdapter<AIProfile> ADAPTER = null;
    public static final String DEFAULT_ALIAS = "";
    public static final String DEFAULT_ANOTHER_NAME = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_DEFAULT_AVATAR = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAME_WITH_ANOTHER_NAME = "";
    public static final String DEFAULT_PROFILE_USER_NAME = "";
    private static final long serialVersionUID = 0;
    public final String alias;
    public final String another_name;
    public final String avatar_key;
    public final AvatarMedal avatar_medal;
    public final Chatter.Description description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253615id;
    public final Boolean is_default_avatar;
    public final String name;
    public final String name_with_another_name;
    public final String profile_user_name;
    public final ImageSetPassThrough top_image;

    public static final class Builder extends Message.Builder<AIProfile, Builder> {
        public String alias;
        public String another_name;
        public String avatar_key;
        public AvatarMedal avatar_medal;
        public Chatter.Description description;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253616id;
        public Boolean is_default_avatar;
        public String name;
        public String name_with_another_name;
        public String profile_user_name;
        public ImageSetPassThrough top_image;

        @Override // com.squareup.wire.Message.Builder
        public AIProfile build() {
            return new AIProfile(this.top_image, this.f253616id, this.name, this.name_with_another_name, this.another_name, this.alias, this.profile_user_name, this.avatar_key, this.avatar_medal, this.is_default_avatar, this.description, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder alias(String r100) {
            this.alias = r100;
            return this;
        }

        public Builder another_name(String r100) {
            this.another_name = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder avatar_medal(AvatarMedal r100) {
            this.avatar_medal = r100;
            return this;
        }

        public Builder description(Chatter.Description r100) {
            this.description = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253616id = r100;
            return this;
        }

        public Builder is_default_avatar(Boolean r100) {
            this.is_default_avatar = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder name_with_another_name(String r100) {
            this.name_with_another_name = r100;
            return this;
        }

        public Builder profile_user_name(String r100) {
            this.profile_user_name = r100;
            return this;
        }

        public Builder top_image(ImageSetPassThrough r100) {
            this.top_image = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AIProfile extends ProtoAdapter<AIProfile> {
        public ProtoAdapter_AIProfile() {
            super(FieldEncoding.LENGTH_DELIMITED, AIProfile.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AIProfile decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253616id = "";
            r101.name = "";
            r101.name_with_another_name = "";
            r101.another_name = "";
            r101.alias = "";
            r101.profile_user_name = "";
            r101.avatar_key = "";
            r101.is_default_avatar = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L20;
            if (r103 != 1) goto L7;
            r101.top_image = ImageSetPassThrough.ADAPTER.decode(r100);
            goto L3
        L7:
            switch(r103) {
                case 50: goto L18;
                case 51: goto L17;
                case 52: goto L16;
                case 53: goto L15;
                case 54: goto L14;
                case 55: goto L13;
                case 56: goto L12;
                case 57: goto L11;
                case 58: goto L10;
                case 59: goto L9;
                default: goto L8;
            };
        L9:
            r101.description = Chatter.Description.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.is_default_avatar = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.avatar_medal = AvatarMedal.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.profile_user_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.alias = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.another_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.name_with_another_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.f253616id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AIProfile r100) {
            ImageSetPassThrough r101 = r100.top_image;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.f253615id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(50, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.name;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(51, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.name_with_another_name;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(52, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.another_name;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(53, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.alias;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(54, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.profile_user_name;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(55, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.avatar_key;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(56, r122);
        L34:
            int r124 = r121 + r123;
            AvatarMedal r125 = r100.avatar_medal;
            if (r125 == null) goto L37;
            int r126 = AvatarMedal.ADAPTER.encodedSizeWithTag(57, r125);
        L38:
            int r127 = r124 + r126;
            Boolean r128 = r100.is_default_avatar;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(58, r128);
        L42:
            int r130 = r127 + r129;
            Chatter.Description r131 = r100.description;
            if (r131 == null) goto L46;
            r102 = Chatter.Description.ADAPTER.encodedSizeWithTag(59, r131);
        L46:
            return (r130 + r102) + r100.unknownFields().size();
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
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
        public /* bridge */ /* synthetic */ AIProfile decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AIProfile r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AIProfile r101) throws IOException {
            ImageSetPassThrough r102 = r101.top_image;
            if (r102 == null) goto L5;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.f253615id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 50, r103);
        L8:
            String r104 = r101.name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 51, r104);
        L11:
            String r105 = r101.name_with_another_name;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 52, r105);
        L14:
            String r106 = r101.another_name;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 53, r106);
        L17:
            String r107 = r101.alias;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 54, r107);
        L20:
            String r108 = r101.profile_user_name;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 55, r108);
        L23:
            String r109 = r101.avatar_key;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 56, r109);
        L26:
            AvatarMedal r110 = r101.avatar_medal;
            if (r110 == null) goto L29;
            AvatarMedal.ADAPTER.encodeWithTag(r100, 57, r110);
        L29:
            Boolean r111 = r101.is_default_avatar;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 58, r111);
        L32:
            Chatter.Description r112 = r101.description;
            if (r112 == null) goto L35;
            Chatter.Description.ADAPTER.encodeWithTag(r100, 59, r112);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AIProfile r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AIProfile();
        DEFAULT_IS_DEFAULT_AVATAR = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.top_image = this.top_image;
        r100.f253616id = this.f253615id;
        r100.name = this.name;
        r100.name_with_another_name = this.name_with_another_name;
        r100.another_name = this.another_name;
        r100.alias = this.alias;
        r100.profile_user_name = this.profile_user_name;
        r100.avatar_key = this.avatar_key;
        r100.avatar_medal = this.avatar_medal;
        r100.is_default_avatar = this.is_default_avatar;
        r100.description = this.description;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AIProfile.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AIProfile(ImageSetPassThrough r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, AvatarMedal r212, Boolean r213, Chatter.Description r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public AIProfile(ImageSetPassThrough r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, AvatarMedal r110, Boolean r111, Chatter.Description r112, ByteString r113) {
        super(ADAPTER, r113);
        this.top_image = r100;
        this.f253615id = r101;
        this.name = r102;
        this.name_with_another_name = r103;
        this.another_name = r104;
        this.alias = r105;
        this.profile_user_name = r106;
        this.avatar_key = r107;
        this.avatar_medal = r110;
        this.is_default_avatar = r111;
        this.description = r112;
    }
}
