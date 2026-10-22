package com.bytedance.lark.pb.search.v1;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class SearchAtInfo extends Message<SearchAtInfo, Builder> {
    public static final ProtoAdapter<SearchAtInfo> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final String DEFAULT_CHANNEL_ID = "";
    public static final String DEFAULT_CHANNEL_NAME = "";
    public static final String DEFAULT_LOCALIZED_USER_NAME = "";
    public static final AtType DEFAULT_TYPE = null;
    public static final String DEFAULT_USER_ID = "";
    private static final long serialVersionUID = 0;
    public final String avatar_key;
    public final String avatar_path;
    public final List<String> avatar_urls;
    public final String channel_id;
    public final String channel_name;
    public final String localized_user_name;
    public final AtType type;
    public final String user_id;

    public static final enum AtType extends Enum<AtType> implements WireEnum {
        private static final /* synthetic */ AtType[] $VALUES = null;
        public static final ProtoAdapter<AtType> ADAPTER = null;
        public static final AtType ALL = null;
        public static final AtType USER = null;
        private final int value;

        static {
            AtType r100 = new AtType(AccountType.ALL, 0, 1);
            ALL = r100;
            AtType r101 = new AtType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 2);
            USER = r101;
            $VALUES = new AtType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(AtType.class);
        }

        public static AtType[] values() {
            return (AtType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AtType fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return USER;
        L11:
            return ALL;
        }

        public static AtType valueOf(String r100) {
            return (AtType) a.a(AtType.class, r100);
        }

        private AtType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<SearchAtInfo, Builder> {
        public String avatar_key;
        public String avatar_path;
        public List<String> avatar_urls;
        public String channel_id;
        public String channel_name;
        public String localized_user_name;
        public AtType type;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public SearchAtInfo build() {
            AtType r100 = this.type;
            if (r100 == null) goto L7;
            return new SearchAtInfo(this.type, this.user_id, this.localized_user_name, this.channel_id, this.channel_name, this.avatar_key, this.avatar_path, this.avatar_urls, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "type"});
        }

        public Builder() {
            this.avatar_urls = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder avatar_path(String r100) {
            this.avatar_path = r100;
            return this;
        }

        public Builder avatar_urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.avatar_urls = r100;
            return this;
        }

        public Builder channel_id(String r100) {
            this.channel_id = r100;
            return this;
        }

        public Builder channel_name(String r100) {
            this.channel_name = r100;
            return this;
        }

        public Builder localized_user_name(String r100) {
            this.localized_user_name = r100;
            return this;
        }

        public Builder type(AtType r100) {
            this.type = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchAtInfo extends ProtoAdapter<SearchAtInfo> {
        public ProtoAdapter_SearchAtInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchAtInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchAtInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = AtType.ALL;
            r101.user_id = "";
            r101.localized_user_name = "";
            r101.channel_id = "";
            r101.channel_name = "";
            r101.avatar_key = "";
            r101.avatar_path = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L20;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.type = AtType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.avatar_urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.avatar_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.channel_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.channel_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.localized_user_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SearchAtInfo r100) {
            int r101 = AtType.ADAPTER.encodedSizeWithTag(1, r100.type);
            String r102 = r100.user_id;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.localized_user_name;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            String r109 = r100.channel_id;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.STRING.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            String r112 = r100.channel_name;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.STRING.encodedSizeWithTag(5, r112);
        L18:
            int r114 = r111 + r113;
            String r115 = r100.avatar_key;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.STRING.encodedSizeWithTag(6, r115);
        L22:
            int r117 = r114 + r116;
            String r118 = r100.avatar_path;
            if (r118 == null) goto L26;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(7, r118);
        L26:
            return ((r117 + r103) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(8, r100.avatar_urls)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ SearchAtInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchAtInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchAtInfo r101) throws IOException {
            AtType.ADAPTER.encodeWithTag(r100, 1, r101.type);
            String r102 = r101.user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.localized_user_name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            String r104 = r101.channel_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            String r105 = r101.channel_name;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
        L14:
            String r106 = r101.avatar_key;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
        L17:
            String r107 = r101.avatar_path;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r107);
        L20:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 8, r101.avatar_urls);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchAtInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchAtInfo();
        DEFAULT_TYPE = AtType.ALL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.user_id = this.user_id;
        r100.localized_user_name = this.localized_user_name;
        r100.channel_id = this.channel_id;
        r100.channel_name = this.channel_name;
        r100.avatar_key = this.avatar_key;
        r100.avatar_path = this.avatar_path;
        r100.avatar_urls = Internal.copyOf("avatar_urls", this.avatar_urls);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchAtInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchAtInfo(AtType r110, String r111, String r112, String r113, String r114, String r115, String r116, List<String> r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public SearchAtInfo(AtType r100, String r101, String r102, String r103, String r104, String r105, String r106, List<String> r107, ByteString r110) {
        super(ADAPTER, r110);
        this.type = r100;
        this.user_id = r101;
        this.localized_user_name = r102;
        this.channel_id = r103;
        this.channel_name = r104;
        this.avatar_key = r105;
        this.avatar_path = r106;
        this.avatar_urls = Internal.immutableCopyOf("avatar_urls", r107);
    }
}
