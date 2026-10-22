package com.bytedance.lark.pb.search.v2;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ExtraInfoBlockSegment extends Message<ExtraInfoBlockSegment, Builder> {
    public static final ProtoAdapter<ExtraInfoBlockSegment> ADAPTER = null;
    public static final Boolean DEFAULT_IS_OMISSIBLE = null;
    public static final String DEFAULT_TEXT_HIGHLIGHTED = "";
    public static final SegmentTextType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_omissible;
    public final String text_highlighted;
    public final SegmentTextType type;
    public final UserProfile user_profile;

    public static final class Builder extends Message.Builder<ExtraInfoBlockSegment, Builder> {
        public Boolean is_omissible;
        public String text_highlighted;
        public SegmentTextType type;
        public UserProfile user_profile;

        @Override // com.squareup.wire.Message.Builder
        public ExtraInfoBlockSegment build() {
            return new ExtraInfoBlockSegment(this.text_highlighted, this.is_omissible, this.type, this.user_profile, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_omissible(Boolean r100) {
            this.is_omissible = r100;
            return this;
        }

        public Builder text_highlighted(String r100) {
            this.text_highlighted = r100;
            return this;
        }

        public Builder type(SegmentTextType r100) {
            this.type = r100;
            return this;
        }

        public Builder user_profile(UserProfile r100) {
            this.user_profile = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtraInfoBlockSegment extends ProtoAdapter<ExtraInfoBlockSegment> {
        public ProtoAdapter_ExtraInfoBlockSegment() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtraInfoBlockSegment.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExtraInfoBlockSegment decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.text_highlighted = "";
            r101.is_omissible = Boolean.FALSE;
            r101.type = SegmentTextType.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.text_highlighted = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.is_omissible = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.type = SegmentTextType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.user_profile = UserProfile.ADAPTER.decode(r100);
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
        public int encodedSize2(ExtraInfoBlockSegment r100) {
            String r101 = r100.text_highlighted;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_omissible;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            SegmentTextType r107 = r100.type;
            if (r107 == null) goto L13;
            int r108 = SegmentTextType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            UserProfile r110 = r100.user_profile;
            if (r110 == null) goto L18;
            r102 = UserProfile.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ExtraInfoBlockSegment decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExtraInfoBlockSegment r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExtraInfoBlockSegment r101) throws IOException {
            String r102 = r101.text_highlighted;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_omissible;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            SegmentTextType r104 = r101.type;
            if (r104 == null) goto L11;
            SegmentTextType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            UserProfile r105 = r101.user_profile;
            if (r105 == null) goto L14;
            UserProfile.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtraInfoBlockSegment r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SegmentTextType extends Enum<SegmentTextType> implements WireEnum {
        private static final /* synthetic */ SegmentTextType[] $VALUES = null;
        public static final ProtoAdapter<SegmentTextType> ADAPTER = null;
        public static final SegmentTextType TEXT = null;
        public static final SegmentTextType TIMESTAMP = null;
        public static final SegmentTextType UNKNOWN = null;
        public static final SegmentTextType USERPROFILE = null;
        private final int value;

        static {
            SegmentTextType r100 = new SegmentTextType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            SegmentTextType r101 = new SegmentTextType(CardAdapter.TEXT, 1, 1);
            TEXT = r101;
            SegmentTextType r102 = new SegmentTextType("TIMESTAMP", 2, 2);
            TIMESTAMP = r102;
            SegmentTextType r103 = new SegmentTextType("USERPROFILE", 3, 3);
            USERPROFILE = r103;
            $VALUES = new SegmentTextType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(SegmentTextType.class);
        }

        public static SegmentTextType[] values() {
            return (SegmentTextType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SegmentTextType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return USERPROFILE;
        L14:
            return TIMESTAMP;
        L16:
            return TEXT;
        L18:
            return UNKNOWN;
        }

        public static SegmentTextType valueOf(String r100) {
            return (SegmentTextType) a.a(SegmentTextType.class, r100);
        }

        private SegmentTextType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class UserProfile extends Message<UserProfile, Builder> {
        public static final ProtoAdapter<UserProfile> ADAPTER = null;
        public static final String DEFAULT_AVATAR_KEY = "";
        public static final String DEFAULT_USER_ID = "";
        public static final String DEFAULT_USER_NAME = "";
        private static final long serialVersionUID = 0;
        public final String avatar_key;
        public final String user_id;
        public final String user_name;

        public static final class Builder extends Message.Builder<UserProfile, Builder> {
            public String avatar_key;
            public String user_id;
            public String user_name;

            @Override // com.squareup.wire.Message.Builder
            public UserProfile build() {
                return new UserProfile(this.user_id, this.user_name, this.avatar_key, super.buildUnknownFields());
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

            public Builder user_id(String r100) {
                this.user_id = r100;
                return this;
            }

            public Builder user_name(String r100) {
                this.user_name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UserProfile extends ProtoAdapter<UserProfile> {
            public ProtoAdapter_UserProfile() {
                super(FieldEncoding.LENGTH_DELIMITED, UserProfile.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UserProfile decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.user_id = "";
                r101.user_name = "";
                r101.avatar_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.user_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.user_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.avatar_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(UserProfile r100) {
                String r101 = r100.user_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.user_name;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.avatar_key;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ UserProfile decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UserProfile r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UserProfile r101) throws IOException {
                String r102 = r101.user_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.user_name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.avatar_key;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserProfile r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserProfile();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_id = this.user_id;
            r100.user_name = this.user_name;
            r100.avatar_key = this.avatar_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UserProfile.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public UserProfile(String r100, String r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public UserProfile(String r100, String r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.user_id = r100;
            this.user_name = r101;
            this.avatar_key = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExtraInfoBlockSegment();
        DEFAULT_IS_OMISSIBLE = Boolean.FALSE;
        DEFAULT_TYPE = SegmentTextType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.text_highlighted = this.text_highlighted;
        r100.is_omissible = this.is_omissible;
        r100.type = this.type;
        r100.user_profile = this.user_profile;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExtraInfoBlockSegment.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExtraInfoBlockSegment(String r100, Boolean r101, SegmentTextType r102, UserProfile r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ExtraInfoBlockSegment(String r100, Boolean r101, SegmentTextType r102, UserProfile r103, ByteString r104) {
        super(ADAPTER, r104);
        this.text_highlighted = r100;
        this.is_omissible = r101;
        this.type = r102;
        this.user_profile = r103;
    }
}
