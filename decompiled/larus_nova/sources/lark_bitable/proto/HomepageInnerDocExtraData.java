package lark_bitable.proto;

import com.bytedance.ee.bear.document.DocViewModel;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class HomepageInnerDocExtraData extends Message<HomepageInnerDocExtraData, Builder> {
    public static final ProtoAdapter<HomepageInnerDocExtraData> ADAPTER = null;
    public static final String DEFAULT_APP_ID = "";
    public static final Long DEFAULT_BIZ_TYPE = null;
    public static final String DEFAULT_COMPLAINT = "";
    public static final Boolean DEFAULT_COPIABLE = null;
    public static final String DEFAULT_DOC_DESCRIPTION = "";
    public static final Boolean DEFAULT_FILE_RISK_TAG = null;
    public static final Boolean DEFAULT_HAS_PERM = null;
    public static final String DEFAULT_ICON = "";
    public static final Integer DEFAULT_ICON_ENCRYPTED_TYPE = null;
    public static final String DEFAULT_ICON_KEY = "";
    public static final String DEFAULT_ICON_NONCE = "";
    public static final Boolean DEFAULT_IS_EXTERNAL = null;
    public static final Boolean DEFAULT_IS_SHARE_ROOT = null;
    public static final Boolean DEFAULT_IS_VISITED = null;
    public static final Boolean DEFAULT_NOT_WIKI_OBJ = null;
    public static final String DEFAULT_SPACE_ID = "";
    public static final Integer DEFAULT_TEMPLATE_TYPE = null;
    public static final String DEFAULT_WIKI_HOMEPAGE = "";
    public static final String DEFAULT_WIKI_SPACE_CREATE_UID = "";
    public static final String DEFAULT_WIKI_SPACE_ID = "";
    public static final String DEFAULT_WIKI_SPACE_NAME = "";
    public static final Integer DEFAULT_WIKI_SPACE_TYPE = null;
    public static final Integer DEFAULT_WIKI_SUBTYPE = null;
    public static final String DEFAULT_WIKI_SUB_TOKEN = "";
    public static final String DEFAULT_WIKI_VERSION = "";
    private static final long serialVersionUID = 0;
    public final String app_id;
    public final Long biz_type;
    public final String complaint;
    public final Boolean copiable;
    public final String doc_description;
    public final Boolean file_risk_tag;
    public final Boolean has_perm;
    public final String icon;
    public final Integer icon_encrypted_type;
    public final String icon_key;
    public final String icon_nonce;
    public final Boolean is_external;
    public final Boolean is_share_root;
    public final Boolean is_visited;
    public final Boolean not_wiki_obj;
    public final String space_id;
    public final Integer template_type;
    public final String wiki_homepage;
    public final String wiki_space_create_uid;
    public final String wiki_space_id;
    public final String wiki_space_name;
    public final Integer wiki_space_type;
    public final String wiki_sub_token;
    public final Integer wiki_subtype;
    public final String wiki_version;

    public static final class Builder extends Message.Builder<HomepageInnerDocExtraData, Builder> {
        public String app_id;
        public Long biz_type;
        public String complaint;
        public Boolean copiable;
        public String doc_description;
        public Boolean file_risk_tag;
        public Boolean has_perm;
        public String icon;
        public Integer icon_encrypted_type;
        public String icon_key;
        public String icon_nonce;
        public Boolean is_external;
        public Boolean is_share_root;
        public Boolean is_visited;
        public Boolean not_wiki_obj;
        public String space_id;
        public Integer template_type;
        public String wiki_homepage;
        public String wiki_space_create_uid;
        public String wiki_space_id;
        public String wiki_space_name;
        public Integer wiki_space_type;
        public String wiki_sub_token;
        public Integer wiki_subtype;
        public String wiki_version;

        @Override // com.squareup.wire.Message.Builder
        public HomepageInnerDocExtraData build() {
            String r100 = this.icon_key;
            if (r100 == null) goto L55;
            if (this.space_id == null) goto L55;
            if (this.is_visited == null) goto L55;
            if (this.has_perm == null) goto L55;
            if (this.copiable == null) goto L55;
            if (this.is_share_root == null) goto L55;
            if (this.icon_encrypted_type == null) goto L55;
            if (this.icon_nonce == null) goto L55;
            if (this.icon == null) goto L55;
            if (this.app_id == null) goto L55;
            if (this.not_wiki_obj == null) goto L55;
            if (this.template_type == null) goto L55;
            if (this.wiki_space_id == null) goto L55;
            if (this.wiki_space_name == null) goto L55;
            if (this.wiki_sub_token == null) goto L55;
            if (this.wiki_version == null) goto L55;
            if (this.biz_type == null) goto L55;
            if (this.file_risk_tag == null) goto L55;
            if (this.is_external == null) goto L55;
            if (this.wiki_space_create_uid == null) goto L55;
            if (this.wiki_space_type == null) goto L55;
            if (this.wiki_subtype == null) goto L55;
            if (this.wiki_homepage == null) goto L55;
            if (this.complaint == null) goto L55;
            if (this.doc_description == null) goto L55;
            return new HomepageInnerDocExtraData(this.icon_key, this.space_id, this.is_visited, this.has_perm, this.copiable, this.is_share_root, this.icon_encrypted_type, this.icon_nonce, this.icon, this.app_id, this.not_wiki_obj, this.template_type, this.wiki_space_id, this.wiki_space_name, this.wiki_sub_token, this.wiki_version, this.biz_type, this.file_risk_tag, this.is_external, this.wiki_space_create_uid, this.wiki_space_type, this.wiki_subtype, this.wiki_homepage, this.complaint, this.doc_description, super.buildUnknownFields());
        L55:
            throw Internal.missingRequiredFields(new Object[]{r100, "icon_key", this.space_id, DocViewModel.EXTRA_SPACE_ID, this.is_visited, "is_visited", this.has_perm, "has_perm", this.copiable, "copiable", this.is_share_root, "is_share_root", this.icon_encrypted_type, "icon_encrypted_type", this.icon_nonce, "icon_nonce", this.icon, "icon", this.app_id, "app_id", this.not_wiki_obj, "not_wiki_obj", this.template_type, "template_type", this.wiki_space_id, "wiki_space_id", this.wiki_space_name, "wiki_space_name", this.wiki_sub_token, "wiki_sub_token", this.wiki_version, "wiki_version", this.biz_type, "biz_type", this.file_risk_tag, "file_risk_tag", this.is_external, "is_external", this.wiki_space_create_uid, "wiki_space_create_uid", this.wiki_space_type, "wiki_space_type", this.wiki_subtype, "wiki_subtype", this.wiki_homepage, "wiki_homepage", this.complaint, "complaint", this.doc_description, "doc_description"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder biz_type(Long r100) {
            this.biz_type = r100;
            return this;
        }

        public Builder complaint(String r100) {
            this.complaint = r100;
            return this;
        }

        public Builder copiable(Boolean r100) {
            this.copiable = r100;
            return this;
        }

        public Builder doc_description(String r100) {
            this.doc_description = r100;
            return this;
        }

        public Builder file_risk_tag(Boolean r100) {
            this.file_risk_tag = r100;
            return this;
        }

        public Builder has_perm(Boolean r100) {
            this.has_perm = r100;
            return this;
        }

        public Builder icon(String r100) {
            this.icon = r100;
            return this;
        }

        public Builder icon_encrypted_type(Integer r100) {
            this.icon_encrypted_type = r100;
            return this;
        }

        public Builder icon_key(String r100) {
            this.icon_key = r100;
            return this;
        }

        public Builder icon_nonce(String r100) {
            this.icon_nonce = r100;
            return this;
        }

        public Builder is_external(Boolean r100) {
            this.is_external = r100;
            return this;
        }

        public Builder is_share_root(Boolean r100) {
            this.is_share_root = r100;
            return this;
        }

        public Builder is_visited(Boolean r100) {
            this.is_visited = r100;
            return this;
        }

        public Builder not_wiki_obj(Boolean r100) {
            this.not_wiki_obj = r100;
            return this;
        }

        public Builder space_id(String r100) {
            this.space_id = r100;
            return this;
        }

        public Builder template_type(Integer r100) {
            this.template_type = r100;
            return this;
        }

        public Builder wiki_homepage(String r100) {
            this.wiki_homepage = r100;
            return this;
        }

        public Builder wiki_space_create_uid(String r100) {
            this.wiki_space_create_uid = r100;
            return this;
        }

        public Builder wiki_space_id(String r100) {
            this.wiki_space_id = r100;
            return this;
        }

        public Builder wiki_space_name(String r100) {
            this.wiki_space_name = r100;
            return this;
        }

        public Builder wiki_space_type(Integer r100) {
            this.wiki_space_type = r100;
            return this;
        }

        public Builder wiki_sub_token(String r100) {
            this.wiki_sub_token = r100;
            return this;
        }

        public Builder wiki_subtype(Integer r100) {
            this.wiki_subtype = r100;
            return this;
        }

        public Builder wiki_version(String r100) {
            this.wiki_version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HomepageInnerDocExtraData extends ProtoAdapter<HomepageInnerDocExtraData> {
        public ProtoAdapter_HomepageInnerDocExtraData() {
            super(FieldEncoding.LENGTH_DELIMITED, HomepageInnerDocExtraData.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public HomepageInnerDocExtraData decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L32;
            switch(r103) {
                case 1: goto L31;
                case 2: goto L30;
                case 3: goto L29;
                case 4: goto L28;
                case 5: goto L27;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L24;
                case 9: goto L23;
                case 10: goto L22;
                case 11: goto L21;
                case 12: goto L20;
                case 13: goto L19;
                case 14: goto L18;
                case 15: goto L17;
                case 16: goto L16;
                case 17: goto L15;
                case 18: goto L14;
                case 19: goto L13;
                case 20: goto L12;
                case 21: goto L11;
                case 22: goto L10;
                case 23: goto L9;
                case 24: goto L8;
                case 25: goto L7;
                default: goto L6;
            };
        L7:
            r101.doc_description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.complaint = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.wiki_homepage = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.wiki_subtype = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.wiki_space_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.wiki_space_create_uid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.is_external = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.file_risk_tag = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.biz_type = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.wiki_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.wiki_sub_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.wiki_space_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.wiki_space_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.template_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L21:
            r101.not_wiki_obj = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L22:
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.icon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.icon_nonce = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.icon_encrypted_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L26:
            r101.is_share_root = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L27:
            r101.copiable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L28:
            r101.has_perm = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L29:
            r101.is_visited = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L30:
            r101.space_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.icon_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L32:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(HomepageInnerDocExtraData r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.icon_key) + r101.encodedSizeWithTag(2, r100.space_id);
            ProtoAdapter<Boolean> r103 = ProtoAdapter.BOOL;
            int r104 = (((r102 + r103.encodedSizeWithTag(3, r100.is_visited)) + r103.encodedSizeWithTag(4, r100.has_perm)) + r103.encodedSizeWithTag(5, r100.copiable)) + r103.encodedSizeWithTag(6, r100.is_share_root);
            ProtoAdapter<Integer> r105 = ProtoAdapter.INT32;
            return (((((((((((((((((((r104 + r105.encodedSizeWithTag(7, r100.icon_encrypted_type)) + r101.encodedSizeWithTag(8, r100.icon_nonce)) + r101.encodedSizeWithTag(9, r100.icon)) + r101.encodedSizeWithTag(10, r100.app_id)) + r103.encodedSizeWithTag(11, r100.not_wiki_obj)) + r105.encodedSizeWithTag(12, r100.template_type)) + r101.encodedSizeWithTag(13, r100.wiki_space_id)) + r101.encodedSizeWithTag(14, r100.wiki_space_name)) + r101.encodedSizeWithTag(15, r100.wiki_sub_token)) + r101.encodedSizeWithTag(16, r100.wiki_version)) + ProtoAdapter.INT64.encodedSizeWithTag(17, r100.biz_type)) + r103.encodedSizeWithTag(18, r100.file_risk_tag)) + r103.encodedSizeWithTag(19, r100.is_external)) + r101.encodedSizeWithTag(20, r100.wiki_space_create_uid)) + r105.encodedSizeWithTag(21, r100.wiki_space_type)) + r105.encodedSizeWithTag(22, r100.wiki_subtype)) + r101.encodedSizeWithTag(23, r100.wiki_homepage)) + r101.encodedSizeWithTag(24, r100.complaint)) + r101.encodedSizeWithTag(25, r100.doc_description)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ HomepageInnerDocExtraData decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HomepageInnerDocExtraData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HomepageInnerDocExtraData r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.icon_key);
            r102.encodeWithTag(r100, 2, r101.space_id);
            ProtoAdapter<Boolean> r103 = ProtoAdapter.BOOL;
            r103.encodeWithTag(r100, 3, r101.is_visited);
            r103.encodeWithTag(r100, 4, r101.has_perm);
            r103.encodeWithTag(r100, 5, r101.copiable);
            r103.encodeWithTag(r100, 6, r101.is_share_root);
            ProtoAdapter<Integer> r104 = ProtoAdapter.INT32;
            r104.encodeWithTag(r100, 7, r101.icon_encrypted_type);
            r102.encodeWithTag(r100, 8, r101.icon_nonce);
            r102.encodeWithTag(r100, 9, r101.icon);
            r102.encodeWithTag(r100, 10, r101.app_id);
            r103.encodeWithTag(r100, 11, r101.not_wiki_obj);
            r104.encodeWithTag(r100, 12, r101.template_type);
            r102.encodeWithTag(r100, 13, r101.wiki_space_id);
            r102.encodeWithTag(r100, 14, r101.wiki_space_name);
            r102.encodeWithTag(r100, 15, r101.wiki_sub_token);
            r102.encodeWithTag(r100, 16, r101.wiki_version);
            ProtoAdapter.INT64.encodeWithTag(r100, 17, r101.biz_type);
            r103.encodeWithTag(r100, 18, r101.file_risk_tag);
            r103.encodeWithTag(r100, 19, r101.is_external);
            r102.encodeWithTag(r100, 20, r101.wiki_space_create_uid);
            r104.encodeWithTag(r100, 21, r101.wiki_space_type);
            r104.encodeWithTag(r100, 22, r101.wiki_subtype);
            r102.encodeWithTag(r100, 23, r101.wiki_homepage);
            r102.encodeWithTag(r100, 24, r101.complaint);
            r102.encodeWithTag(r100, 25, r101.doc_description);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HomepageInnerDocExtraData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HomepageInnerDocExtraData();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_VISITED = r100;
        DEFAULT_HAS_PERM = r100;
        DEFAULT_COPIABLE = r100;
        DEFAULT_IS_SHARE_ROOT = r100;
        DEFAULT_ICON_ENCRYPTED_TYPE = 0;
        DEFAULT_NOT_WIKI_OBJ = r100;
        DEFAULT_TEMPLATE_TYPE = 0;
        DEFAULT_BIZ_TYPE = 0L;
        DEFAULT_FILE_RISK_TAG = r100;
        DEFAULT_IS_EXTERNAL = r100;
        DEFAULT_WIKI_SPACE_TYPE = 0;
        DEFAULT_WIKI_SUBTYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.icon_key = this.icon_key;
        r100.space_id = this.space_id;
        r100.is_visited = this.is_visited;
        r100.has_perm = this.has_perm;
        r100.copiable = this.copiable;
        r100.is_share_root = this.is_share_root;
        r100.icon_encrypted_type = this.icon_encrypted_type;
        r100.icon_nonce = this.icon_nonce;
        r100.icon = this.icon;
        r100.app_id = this.app_id;
        r100.not_wiki_obj = this.not_wiki_obj;
        r100.template_type = this.template_type;
        r100.wiki_space_id = this.wiki_space_id;
        r100.wiki_space_name = this.wiki_space_name;
        r100.wiki_sub_token = this.wiki_sub_token;
        r100.wiki_version = this.wiki_version;
        r100.biz_type = this.biz_type;
        r100.file_risk_tag = this.file_risk_tag;
        r100.is_external = this.is_external;
        r100.wiki_space_create_uid = this.wiki_space_create_uid;
        r100.wiki_space_type = this.wiki_space_type;
        r100.wiki_subtype = this.wiki_subtype;
        r100.wiki_homepage = this.wiki_homepage;
        r100.complaint = this.complaint;
        r100.doc_description = this.doc_description;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HomepageInnerDocExtraData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public HomepageInnerDocExtraData(String r210, String r211, Boolean r310, Boolean r311, Boolean r312, Boolean r313, Integer r314, String r315, String r316, String r317, Boolean r318, Integer r319, String r410, String r411, String r412, String r413, Long r414, Boolean r415, Boolean r416, String r417, Integer r418, Integer r419, String r510, String r511, String r512) {
        this(r210, r211, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, ByteString.EMPTY);
    }

    public HomepageInnerDocExtraData(String r100, String r101, Boolean r102, Boolean r103, Boolean r104, Boolean r105, Integer r110, String r111, String r112, String r113, Boolean r114, Integer r115, String r116, String r117, String r118, String r119, Long r210, Boolean r211, Boolean r212, String r213, Integer r214, Integer r215, String r216, String r217, String r218, ByteString r219) {
        super(ADAPTER, r219);
        this.icon_key = r100;
        this.space_id = r101;
        this.is_visited = r102;
        this.has_perm = r103;
        this.copiable = r104;
        this.is_share_root = r105;
        this.icon_encrypted_type = r110;
        this.icon_nonce = r111;
        this.icon = r112;
        this.app_id = r113;
        this.not_wiki_obj = r114;
        this.template_type = r115;
        this.wiki_space_id = r116;
        this.wiki_space_name = r117;
        this.wiki_sub_token = r118;
        this.wiki_version = r119;
        this.biz_type = r210;
        this.file_risk_tag = r211;
        this.is_external = r212;
        this.wiki_space_create_uid = r213;
        this.wiki_space_type = r214;
        this.wiki_subtype = r215;
        this.wiki_homepage = r216;
        this.complaint = r217;
        this.doc_description = r218;
    }
}
