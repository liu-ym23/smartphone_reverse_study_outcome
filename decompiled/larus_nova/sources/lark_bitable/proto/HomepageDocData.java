package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class HomepageDocData extends Message<HomepageDocData, Builder> {
    public static final ProtoAdapter<HomepageDocData> ADAPTER = null;
    public static final Integer DEFAULT_BIZ_TYPE = null;
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final Long DEFAULT_EDIT_TIME = null;
    public static final String DEFAULT_ICON = "";
    public static final Boolean DEFAULT_IS_MY_LIBRARY = null;
    public static final Boolean DEFAULT_IS_OWNER = null;
    public static final Boolean DEFAULT_IS_STARED = null;
    public static final Integer DEFAULT_OBJ_BIZ_TYPE = null;
    public static final String DEFAULT_OBJ_TOKEN = "";
    public static final Long DEFAULT_OPEN_TIME = null;
    public static final Long DEFAULT_STAR_TIME = null;
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_URL = "";
    public static final String DEFAULT_WIKI_SPACE_NAME = "";
    private static final long serialVersionUID = 0;
    public final Integer biz_type;
    public final Long create_time;
    public final Long edit_time;
    public final String icon;
    public final Boolean is_my_library;
    public final Boolean is_owner;
    public final Boolean is_stared;
    public final Integer obj_biz_type;
    public final String obj_token;
    public final Long open_time;
    public final Long star_time;
    public final HomepageTagConfig tag;
    public final String title;
    public final String token;
    public final String url;
    public final String wiki_space_name;

    public static final class Builder extends Message.Builder<HomepageDocData, Builder> {
        public Integer biz_type;
        public Long create_time;
        public Long edit_time;
        public String icon;
        public Boolean is_my_library;
        public Boolean is_owner;
        public Boolean is_stared;
        public Integer obj_biz_type;
        public String obj_token;
        public Long open_time;
        public Long star_time;
        public HomepageTagConfig tag;
        public String title;
        public String token;
        public String url;
        public String wiki_space_name;

        @Override // com.squareup.wire.Message.Builder
        public HomepageDocData build() {
            String r100 = this.token;
            if (r100 == null) goto L37;
            if (this.icon == null) goto L37;
            if (this.title == null) goto L37;
            if (this.biz_type == null) goto L37;
            if (this.obj_biz_type == null) goto L37;
            if (this.obj_token == null) goto L37;
            if (this.open_time == null) goto L37;
            if (this.star_time == null) goto L37;
            if (this.create_time == null) goto L37;
            if (this.edit_time == null) goto L37;
            if (this.tag == null) goto L37;
            if (this.is_owner == null) goto L37;
            if (this.is_stared == null) goto L37;
            if (this.is_my_library == null) goto L37;
            if (this.wiki_space_name == null) goto L37;
            if (this.url == null) goto L37;
            return new HomepageDocData(this.token, this.icon, this.title, this.biz_type, this.obj_biz_type, this.obj_token, this.open_time, this.star_time, this.create_time, this.edit_time, this.tag, this.is_owner, this.is_stared, this.is_my_library, this.wiki_space_name, this.url, super.buildUnknownFields());
        L37:
            throw Internal.missingRequiredFields(new Object[]{r100, "token", this.icon, "icon", this.title, "title", this.biz_type, "biz_type", this.obj_biz_type, "obj_biz_type", this.obj_token, "obj_token", this.open_time, "open_time", this.star_time, "star_time", this.create_time, "create_time", this.edit_time, "edit_time", this.tag, "tag", this.is_owner, "is_owner", this.is_stared, "is_stared", this.is_my_library, "is_my_library", this.wiki_space_name, "wiki_space_name", this.url, "url"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz_type(Integer r100) {
            this.biz_type = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder edit_time(Long r100) {
            this.edit_time = r100;
            return this;
        }

        public Builder icon(String r100) {
            this.icon = r100;
            return this;
        }

        public Builder is_my_library(Boolean r100) {
            this.is_my_library = r100;
            return this;
        }

        public Builder is_owner(Boolean r100) {
            this.is_owner = r100;
            return this;
        }

        public Builder is_stared(Boolean r100) {
            this.is_stared = r100;
            return this;
        }

        public Builder obj_biz_type(Integer r100) {
            this.obj_biz_type = r100;
            return this;
        }

        public Builder obj_token(String r100) {
            this.obj_token = r100;
            return this;
        }

        public Builder open_time(Long r100) {
            this.open_time = r100;
            return this;
        }

        public Builder star_time(Long r100) {
            this.star_time = r100;
            return this;
        }

        public Builder tag(HomepageTagConfig r100) {
            this.tag = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }

        public Builder wiki_space_name(String r100) {
            this.wiki_space_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HomepageDocData extends ProtoAdapter<HomepageDocData> {
        public ProtoAdapter_HomepageDocData() {
            super(FieldEncoding.LENGTH_DELIMITED, HomepageDocData.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public HomepageDocData decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L23;
            switch(r103) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L11;
                case 13: goto L10;
                case 14: goto L9;
                case 15: goto L8;
                case 16: goto L7;
                default: goto L6;
            };
        L7:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.wiki_space_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.is_my_library = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.is_stared = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.is_owner = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.tag = HomepageTagConfig.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.edit_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.star_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.open_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            r101.obj_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.obj_biz_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L19:
            r101.biz_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L20:
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.icon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L23:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(HomepageDocData r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.token) + r101.encodedSizeWithTag(2, r100.icon)) + r101.encodedSizeWithTag(3, r100.title);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            int r104 = ((r102 + r103.encodedSizeWithTag(4, r100.biz_type)) + r103.encodedSizeWithTag(5, r100.obj_biz_type)) + r101.encodedSizeWithTag(6, r100.obj_token);
            ProtoAdapter<Long> r105 = ProtoAdapter.INT64;
            int r106 = ((((r104 + r105.encodedSizeWithTag(7, r100.open_time)) + r105.encodedSizeWithTag(8, r100.star_time)) + r105.encodedSizeWithTag(9, r100.create_time)) + r105.encodedSizeWithTag(10, r100.edit_time)) + HomepageTagConfig.ADAPTER.encodedSizeWithTag(11, r100.tag);
            ProtoAdapter<Boolean> r107 = ProtoAdapter.BOOL;
            return (((((r106 + r107.encodedSizeWithTag(12, r100.is_owner)) + r107.encodedSizeWithTag(13, r100.is_stared)) + r107.encodedSizeWithTag(14, r100.is_my_library)) + r101.encodedSizeWithTag(15, r100.wiki_space_name)) + r101.encodedSizeWithTag(16, r100.url)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ HomepageDocData decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HomepageDocData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HomepageDocData r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.token);
            r102.encodeWithTag(r100, 2, r101.icon);
            r102.encodeWithTag(r100, 3, r101.title);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            r103.encodeWithTag(r100, 4, r101.biz_type);
            r103.encodeWithTag(r100, 5, r101.obj_biz_type);
            r102.encodeWithTag(r100, 6, r101.obj_token);
            ProtoAdapter<Long> r104 = ProtoAdapter.INT64;
            r104.encodeWithTag(r100, 7, r101.open_time);
            r104.encodeWithTag(r100, 8, r101.star_time);
            r104.encodeWithTag(r100, 9, r101.create_time);
            r104.encodeWithTag(r100, 10, r101.edit_time);
            HomepageTagConfig.ADAPTER.encodeWithTag(r100, 11, r101.tag);
            ProtoAdapter<Boolean> r105 = ProtoAdapter.BOOL;
            r105.encodeWithTag(r100, 12, r101.is_owner);
            r105.encodeWithTag(r100, 13, r101.is_stared);
            r105.encodeWithTag(r100, 14, r101.is_my_library);
            r102.encodeWithTag(r100, 15, r101.wiki_space_name);
            r102.encodeWithTag(r100, 16, r101.url);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HomepageDocData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HomepageDocData();
        DEFAULT_BIZ_TYPE = 0;
        DEFAULT_OBJ_BIZ_TYPE = 0;
        DEFAULT_OPEN_TIME = 0L;
        DEFAULT_STAR_TIME = 0L;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_EDIT_TIME = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_OWNER = r100;
        DEFAULT_IS_STARED = r100;
        DEFAULT_IS_MY_LIBRARY = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.token = this.token;
        r100.icon = this.icon;
        r100.title = this.title;
        r100.biz_type = this.biz_type;
        r100.obj_biz_type = this.obj_biz_type;
        r100.obj_token = this.obj_token;
        r100.open_time = this.open_time;
        r100.star_time = this.star_time;
        r100.create_time = this.create_time;
        r100.edit_time = this.edit_time;
        r100.tag = this.tag;
        r100.is_owner = this.is_owner;
        r100.is_stared = this.is_stared;
        r100.is_my_library = this.is_my_library;
        r100.wiki_space_name = this.wiki_space_name;
        r100.url = this.url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HomepageDocData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public HomepageDocData(String r110, String r210, String r211, Integer r212, Integer r213, String r214, Long r215, Long r216, Long r217, Long r218, HomepageTagConfig r219, Boolean r310, Boolean r311, Boolean r312, String r313, String r314) {
        this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, ByteString.EMPTY);
    }

    public HomepageDocData(String r100, String r101, String r102, Integer r103, Integer r104, String r105, Long r110, Long r111, Long r112, Long r113, HomepageTagConfig r114, Boolean r115, Boolean r116, Boolean r117, String r118, String r119, ByteString r210) {
        super(ADAPTER, r210);
        this.token = r100;
        this.icon = r101;
        this.title = r102;
        this.biz_type = r103;
        this.obj_biz_type = r104;
        this.obj_token = r105;
        this.open_time = r110;
        this.star_time = r111;
        this.create_time = r112;
        this.edit_time = r113;
        this.tag = r114;
        this.is_owner = r115;
        this.is_stared = r116;
        this.is_my_library = r117;
        this.wiki_space_name = r118;
        this.url = r119;
    }
}
