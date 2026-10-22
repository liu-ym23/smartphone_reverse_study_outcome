package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class UserSummary extends Message<UserSummary, Builder> {
    public static final ProtoAdapter<UserSummary> ADAPTER = null;
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_OPENID = "";
    public static final String DEFAULT_UNION_ID = "";
    private static final long serialVersionUID = 0;
    public final List<String> avatar_urls;
    public final String display_name;
    public final Map<String, String> i18n_display_name;
    public final Map<String, String> i18n_name;
    public final String name;
    public final String openid;
    public final String union_id;

    public static final class Builder extends Message.Builder<UserSummary, Builder> {
        public List<String> avatar_urls;
        public String display_name;
        public Map<String, String> i18n_display_name;
        public Map<String, String> i18n_name;
        public String name;
        public String openid;
        public String union_id;

        @Override // com.squareup.wire.Message.Builder
        public UserSummary build() {
            String r100 = this.openid;
            if (r100 == null) goto L11;
            if (this.union_id == null) goto L11;
            if (this.name == null) goto L11;
            return new UserSummary(this.openid, this.union_id, this.name, this.i18n_name, this.display_name, this.i18n_display_name, this.avatar_urls, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "openid", this.union_id, "union_id", this.name, "name"});
        }

        public Builder() {
            this.i18n_name = Internal.newMutableMap();
            this.i18n_display_name = Internal.newMutableMap();
            this.avatar_urls = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.avatar_urls = r100;
            return this;
        }

        public Builder display_name(String r100) {
            this.display_name = r100;
            return this;
        }

        public Builder i18n_display_name(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.i18n_display_name = r100;
            return this;
        }

        public Builder i18n_name(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.i18n_name = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder openid(String r100) {
            this.openid = r100;
            return this;
        }

        public Builder union_id(String r100) {
            this.union_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserSummary extends ProtoAdapter<UserSummary> {
        private final ProtoAdapter<Map<String, String>> i18n_display_name;
        private final ProtoAdapter<Map<String, String>> i18n_name;

        public ProtoAdapter_UserSummary() {
            super(FieldEncoding.LENGTH_DELIMITED, UserSummary.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.i18n_name = ProtoAdapter.newMapAdapter(r100, r100);
            this.i18n_display_name = ProtoAdapter.newMapAdapter(r100, r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public UserSummary decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
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
            r101.avatar_urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.i18n_display_name.putAll(this.i18n_display_name.decode(r100));
            goto L3
        L9:
            r101.display_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.i18n_name.putAll(this.i18n_name.decode(r100));
            goto L3
        L11:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.union_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.openid = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UserSummary r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.encodedSizeWithTag(1, r100.openid) + r101.encodedSizeWithTag(2, r100.union_id)) + r101.encodedSizeWithTag(3, r100.name)) + this.i18n_name.encodedSizeWithTag(4, r100.i18n_name);
            String r103 = r100.display_name;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(5, r103);
        L7:
            return (((r102 + r104) + this.i18n_display_name.encodedSizeWithTag(6, r100.i18n_display_name)) + r101.asRepeated().encodedSizeWithTag(7, r100.avatar_urls)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserSummary decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserSummary r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserSummary r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.openid);
            r102.encodeWithTag(r100, 2, r101.union_id);
            r102.encodeWithTag(r100, 3, r101.name);
            this.i18n_name.encodeWithTag(r100, 4, r101.i18n_name);
            String r103 = r101.display_name;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 5, r103);
        L5:
            this.i18n_display_name.encodeWithTag(r100, 6, r101.i18n_display_name);
            r102.asRepeated().encodeWithTag(r100, 7, r101.avatar_urls);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserSummary r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserSummary();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.openid = this.openid;
        r100.union_id = this.union_id;
        r100.name = this.name;
        r100.i18n_name = Internal.copyOf("i18n_name", this.i18n_name);
        r100.display_name = this.display_name;
        r100.i18n_display_name = Internal.copyOf("i18n_display_name", this.i18n_display_name);
        r100.avatar_urls = Internal.copyOf("avatar_urls", this.avatar_urls);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserSummary.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserSummary(String r110, String r111, String r112, Map<String, String> r113, String r114, Map<String, String> r115, List<String> r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public UserSummary(String r100, String r101, String r102, Map<String, String> r103, String r104, Map<String, String> r105, List<String> r106, ByteString r107) {
        super(ADAPTER, r107);
        this.openid = r100;
        this.union_id = r101;
        this.name = r102;
        this.i18n_name = Internal.immutableCopyOf("i18n_name", r103);
        this.display_name = r104;
        this.i18n_display_name = Internal.immutableCopyOf("i18n_display_name", r105);
        this.avatar_urls = Internal.immutableCopyOf("avatar_urls", r106);
    }
}
