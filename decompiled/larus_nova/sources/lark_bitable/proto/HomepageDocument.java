package lark_bitable.proto;

import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class HomepageDocument extends Message<HomepageDocument, Builder> {
    public static final ProtoAdapter<HomepageDocument> ADAPTER = null;
    public static final Long DEFAULT_ACTIVITY_TIME = null;
    public static final Long DEFAULT_CAN_SET_SEC_LABEL = null;
    public static final String DEFAULT_CREATE_CN_NAME = "";
    public static final String DEFAULT_CREATE_EN_NAME = "";
    public static final String DEFAULT_CREATE_TENANT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final Integer DEFAULT_DELETE_FLAG = null;
    public static final String DEFAULT_DELETE_UID = "";
    public static final Long DEFAULT_EDIT_TIME = null;
    public static final String DEFAULT_EDIT_UID = "";
    public static final Long DEFAULT_GET_SEC_LABEL_CODE = null;
    public static final String DEFAULT_ICON_FSUNIT = "";
    public static final String DEFAULT_ICON_INFO = "";
    public static final String DEFAULT_ICON_KEY = "";
    public static final Integer DEFAULT_ICON_TYPE = null;
    public static final Boolean DEFAULT_IS_PINED = null;
    public static final Boolean DEFAULT_IS_STARED = null;
    public static final Boolean DEFAULT_IS_SUBSCRIBED = null;
    public static final Long DEFAULT_MY_EDIT_TIME = null;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_OBJ_BIZ_TYPE = null;
    public static final String DEFAULT_OBJ_TOKEN = "";
    public static final Long DEFAULT_OPEN_TIME = null;
    public static final String DEFAULT_OWNER_ID = "";
    public static final Integer DEFAULT_OWNER_TYPE = null;
    public static final Long DEFAULT_PATH_COUNT = null;
    public static final Integer DEFAULT_R_TYPE = null;
    public static final Boolean DEFAULT_SECRET_KEY_DELETE = null;
    public static final String DEFAULT_SECURITY_LABEL_ID = "";
    public static final Integer DEFAULT_SECURITY_LEVEL = null;
    public static final String DEFAULT_SECURITY_NAME = "";
    public static final String DEFAULT_SHARER_ID = "";
    public static final String DEFAULT_SHARE_CN_NAME = "";
    public static final String DEFAULT_SHARE_EN_NAME = "";
    public static final Long DEFAULT_SHARE_TIME = null;
    public static final Long DEFAULT_STAR_TIME = null;
    public static final String DEFAULT_THUMBNAIL = "";
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final Long activity_time;
    public final Long can_set_sec_label;
    public final String create_cn_name;
    public final String create_en_name;
    public final String create_tenant_id;
    public final Long create_time;
    public final Integer delete_flag;
    public final String delete_uid;
    public final Long edit_time;
    public final String edit_uid;
    public final HomepageInnerDocExtraData extra;
    public final Long get_sec_label_code;
    public final String icon_fsunit;
    public final String icon_info;
    public final String icon_key;
    public final Integer icon_type;
    public final Boolean is_pined;
    public final Boolean is_stared;
    public final Boolean is_subscribed;
    public final Long my_edit_time;
    public final String name;
    public final Integer obj_biz_type;
    public final String obj_token;
    public final Long open_time;
    public final String owner_id;
    public final Integer owner_type;
    public final Long path_count;
    public final Integer r_type;
    public final Boolean secret_key_delete;
    public final String security_label_id;
    public final Integer security_level;
    public final String security_name;
    public final String share_cn_name;
    public final String share_en_name;
    public final Long share_time;
    public final String sharer_id;
    public final Long star_time;
    public final String thumbnail;
    public final String token;
    public final String url;

    public static final class Builder extends Message.Builder<HomepageDocument, Builder> {
        public Long activity_time;
        public Long can_set_sec_label;
        public String create_cn_name;
        public String create_en_name;
        public String create_tenant_id;
        public Long create_time;
        public Integer delete_flag;
        public String delete_uid;
        public Long edit_time;
        public String edit_uid;
        public HomepageInnerDocExtraData extra;
        public Long get_sec_label_code;
        public String icon_fsunit;
        public String icon_info;
        public String icon_key;
        public Integer icon_type;
        public Boolean is_pined;
        public Boolean is_stared;
        public Boolean is_subscribed;
        public Long my_edit_time;
        public String name;
        public Integer obj_biz_type;
        public String obj_token;
        public Long open_time;
        public String owner_id;
        public Integer owner_type;
        public Long path_count;
        public Integer r_type;
        public Boolean secret_key_delete;
        public String security_label_id;
        public Integer security_level;
        public String security_name;
        public String share_cn_name;
        public String share_en_name;
        public Long share_time;
        public String sharer_id;
        public Long star_time;
        public String thumbnail;
        public String token;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public HomepageDocument build() {
            String r100 = this.url;
            if (r100 == null) goto L85;
            if (this.owner_type == null) goto L85;
            if (this.security_name == null) goto L85;
            if (this.path_count == null) goto L85;
            if (this.obj_biz_type == null) goto L85;
            if (this.delete_uid == null) goto L85;
            if (this.token == null) goto L85;
            if (this.obj_token == null) goto L85;
            if (this.r_type == null) goto L85;
            if (this.extra == null) goto L85;
            if (this.open_time == null) goto L85;
            if (this.star_time == null) goto L85;
            if (this.get_sec_label_code == null) goto L85;
            if (this.can_set_sec_label == null) goto L85;
            if (this.name == null) goto L85;
            if (this.secret_key_delete == null) goto L85;
            if (this.edit_uid == null) goto L85;
            if (this.delete_flag == null) goto L85;
            if (this.icon_info == null) goto L85;
            if (this.activity_time == null) goto L85;
            if (this.edit_time == null) goto L85;
            if (this.security_label_id == null) goto L85;
            if (this.is_stared == null) goto L85;
            if (this.is_pined == null) goto L85;
            if (this.thumbnail == null) goto L85;
            if (this.security_level == null) goto L85;
            if (this.owner_id == null) goto L85;
            if (this.create_time == null) goto L85;
            if (this.my_edit_time == null) goto L85;
            if (this.sharer_id == null) goto L85;
            if (this.is_subscribed == null) goto L85;
            if (this.share_time == null) goto L85;
            if (this.icon_key == null) goto L85;
            if (this.icon_type == null) goto L85;
            if (this.icon_fsunit == null) goto L85;
            if (this.create_tenant_id == null) goto L85;
            if (this.create_cn_name == null) goto L85;
            if (this.create_en_name == null) goto L85;
            if (this.share_cn_name == null) goto L85;
            if (this.share_en_name == null) goto L85;
            return new HomepageDocument(this.url, this.owner_type, this.security_name, this.path_count, this.obj_biz_type, this.delete_uid, this.token, this.obj_token, this.r_type, this.extra, this.open_time, this.star_time, this.get_sec_label_code, this.can_set_sec_label, this.name, this.secret_key_delete, this.edit_uid, this.delete_flag, this.icon_info, this.activity_time, this.edit_time, this.security_label_id, this.is_stared, this.is_pined, this.thumbnail, this.security_level, this.owner_id, this.create_time, this.my_edit_time, this.sharer_id, this.is_subscribed, this.share_time, this.icon_key, this.icon_type, this.icon_fsunit, this.create_tenant_id, this.create_cn_name, this.create_en_name, this.share_cn_name, this.share_en_name, super.buildUnknownFields());
        L85:
            throw Internal.missingRequiredFields(new Object[]{r100, "url", this.owner_type, "owner_type", this.security_name, "security_name", this.path_count, "path_count", this.obj_biz_type, "obj_biz_type", this.delete_uid, "delete_uid", this.token, "token", this.obj_token, "obj_token", this.r_type, "r_type", this.extra, "extra", this.open_time, "open_time", this.star_time, "star_time", this.get_sec_label_code, "get_sec_label_code", this.can_set_sec_label, "can_set_sec_label", this.name, "name", this.secret_key_delete, "secret_key_delete", this.edit_uid, "edit_uid", this.delete_flag, "delete_flag", this.icon_info, "icon_info", this.activity_time, "activity_time", this.edit_time, "edit_time", this.security_label_id, "security_label_id", this.is_stared, "is_stared", this.is_pined, "is_pined", this.thumbnail, DocCallbackImpl.KEY_THUMBNAIL, this.security_level, "security_level", this.owner_id, "owner_id", this.create_time, "create_time", this.my_edit_time, "my_edit_time", this.sharer_id, "sharer_id", this.is_subscribed, "is_subscribed", this.share_time, "share_time", this.icon_key, "icon_key", this.icon_type, "icon_type", this.icon_fsunit, "icon_fsunit", this.create_tenant_id, "create_tenant_id", this.create_cn_name, "create_cn_name", this.create_en_name, "create_en_name", this.share_cn_name, "share_cn_name", this.share_en_name, "share_en_name"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder activity_time(Long r100) {
            this.activity_time = r100;
            return this;
        }

        public Builder can_set_sec_label(Long r100) {
            this.can_set_sec_label = r100;
            return this;
        }

        public Builder create_cn_name(String r100) {
            this.create_cn_name = r100;
            return this;
        }

        public Builder create_en_name(String r100) {
            this.create_en_name = r100;
            return this;
        }

        public Builder create_tenant_id(String r100) {
            this.create_tenant_id = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder delete_flag(Integer r100) {
            this.delete_flag = r100;
            return this;
        }

        public Builder delete_uid(String r100) {
            this.delete_uid = r100;
            return this;
        }

        public Builder edit_time(Long r100) {
            this.edit_time = r100;
            return this;
        }

        public Builder edit_uid(String r100) {
            this.edit_uid = r100;
            return this;
        }

        public Builder extra(HomepageInnerDocExtraData r100) {
            this.extra = r100;
            return this;
        }

        public Builder get_sec_label_code(Long r100) {
            this.get_sec_label_code = r100;
            return this;
        }

        public Builder icon_fsunit(String r100) {
            this.icon_fsunit = r100;
            return this;
        }

        public Builder icon_info(String r100) {
            this.icon_info = r100;
            return this;
        }

        public Builder icon_key(String r100) {
            this.icon_key = r100;
            return this;
        }

        public Builder icon_type(Integer r100) {
            this.icon_type = r100;
            return this;
        }

        public Builder is_pined(Boolean r100) {
            this.is_pined = r100;
            return this;
        }

        public Builder is_stared(Boolean r100) {
            this.is_stared = r100;
            return this;
        }

        public Builder is_subscribed(Boolean r100) {
            this.is_subscribed = r100;
            return this;
        }

        public Builder my_edit_time(Long r100) {
            this.my_edit_time = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
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

        public Builder owner_id(String r100) {
            this.owner_id = r100;
            return this;
        }

        public Builder owner_type(Integer r100) {
            this.owner_type = r100;
            return this;
        }

        public Builder path_count(Long r100) {
            this.path_count = r100;
            return this;
        }

        public Builder r_type(Integer r100) {
            this.r_type = r100;
            return this;
        }

        public Builder secret_key_delete(Boolean r100) {
            this.secret_key_delete = r100;
            return this;
        }

        public Builder security_label_id(String r100) {
            this.security_label_id = r100;
            return this;
        }

        public Builder security_level(Integer r100) {
            this.security_level = r100;
            return this;
        }

        public Builder security_name(String r100) {
            this.security_name = r100;
            return this;
        }

        public Builder share_cn_name(String r100) {
            this.share_cn_name = r100;
            return this;
        }

        public Builder share_en_name(String r100) {
            this.share_en_name = r100;
            return this;
        }

        public Builder share_time(Long r100) {
            this.share_time = r100;
            return this;
        }

        public Builder sharer_id(String r100) {
            this.sharer_id = r100;
            return this;
        }

        public Builder star_time(Long r100) {
            this.star_time = r100;
            return this;
        }

        public Builder thumbnail(String r100) {
            this.thumbnail = r100;
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
    }

    public static final class ProtoAdapter_HomepageDocument extends ProtoAdapter<HomepageDocument> {
        public ProtoAdapter_HomepageDocument() {
            super(FieldEncoding.LENGTH_DELIMITED, HomepageDocument.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public HomepageDocument decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L47;
            switch(r103) {
                case 1: goto L46;
                case 2: goto L45;
                case 3: goto L44;
                case 4: goto L43;
                case 5: goto L42;
                case 6: goto L41;
                case 7: goto L40;
                case 8: goto L39;
                case 9: goto L38;
                case 10: goto L37;
                case 11: goto L36;
                case 12: goto L35;
                case 13: goto L34;
                case 14: goto L33;
                case 15: goto L32;
                case 16: goto L31;
                case 17: goto L30;
                case 18: goto L29;
                case 19: goto L28;
                case 20: goto L27;
                case 21: goto L26;
                case 22: goto L25;
                case 23: goto L24;
                case 24: goto L23;
                case 25: goto L22;
                case 26: goto L21;
                case 27: goto L20;
                case 28: goto L19;
                case 29: goto L18;
                case 30: goto L17;
                case 31: goto L16;
                case 32: goto L15;
                case 33: goto L14;
                case 34: goto L13;
                case 35: goto L12;
                case 36: goto L11;
                case 37: goto L10;
                case 38: goto L9;
                case 39: goto L8;
                case 40: goto L7;
                default: goto L6;
            };
        L7:
            r101.share_en_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.share_cn_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.create_en_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.create_cn_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.create_tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.icon_fsunit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.icon_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.icon_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.share_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.is_subscribed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.sharer_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.my_edit_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L19:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L20:
            r101.owner_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.security_level = ProtoAdapter.INT32.decode(r100);
            goto L3
        L22:
            r101.thumbnail = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.is_pined = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.is_stared = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L25:
            r101.security_label_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L26:
            r101.edit_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L27:
            r101.activity_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L28:
            r101.icon_info = ProtoAdapter.STRING.decode(r100);
            goto L3
        L29:
            r101.delete_flag = ProtoAdapter.INT32.decode(r100);
            goto L3
        L30:
            r101.edit_uid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.secret_key_delete = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L32:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L33:
            r101.can_set_sec_label = ProtoAdapter.INT64.decode(r100);
            goto L3
        L34:
            r101.get_sec_label_code = ProtoAdapter.INT64.decode(r100);
            goto L3
        L35:
            r101.star_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L36:
            r101.open_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L37:
            r101.extra = HomepageInnerDocExtraData.ADAPTER.decode(r100);
            goto L3
        L38:
            r101.r_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L39:
            r101.obj_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L40:
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L41:
            r101.delete_uid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L42:
            r101.obj_biz_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L43:
            r101.path_count = ProtoAdapter.INT64.decode(r100);
            goto L3
        L44:
            r101.security_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L45:
            r101.owner_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L46:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L47:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(HomepageDocument r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.url);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            int r104 = (r102 + r103.encodedSizeWithTag(2, r100.owner_type)) + r101.encodedSizeWithTag(3, r100.security_name);
            ProtoAdapter<Long> r105 = ProtoAdapter.INT64;
            int r106 = (((((((((((r104 + r105.encodedSizeWithTag(4, r100.path_count)) + r103.encodedSizeWithTag(5, r100.obj_biz_type)) + r101.encodedSizeWithTag(6, r100.delete_uid)) + r101.encodedSizeWithTag(7, r100.token)) + r101.encodedSizeWithTag(8, r100.obj_token)) + r103.encodedSizeWithTag(9, r100.r_type)) + HomepageInnerDocExtraData.ADAPTER.encodedSizeWithTag(10, r100.extra)) + r105.encodedSizeWithTag(11, r100.open_time)) + r105.encodedSizeWithTag(12, r100.star_time)) + r105.encodedSizeWithTag(13, r100.get_sec_label_code)) + r105.encodedSizeWithTag(14, r100.can_set_sec_label)) + r101.encodedSizeWithTag(15, r100.name);
            ProtoAdapter<Boolean> r107 = ProtoAdapter.BOOL;
            return (((((((((((((((((((((((((r106 + r107.encodedSizeWithTag(16, r100.secret_key_delete)) + r101.encodedSizeWithTag(17, r100.edit_uid)) + r103.encodedSizeWithTag(18, r100.delete_flag)) + r101.encodedSizeWithTag(19, r100.icon_info)) + r105.encodedSizeWithTag(20, r100.activity_time)) + r105.encodedSizeWithTag(21, r100.edit_time)) + r101.encodedSizeWithTag(22, r100.security_label_id)) + r107.encodedSizeWithTag(23, r100.is_stared)) + r107.encodedSizeWithTag(24, r100.is_pined)) + r101.encodedSizeWithTag(25, r100.thumbnail)) + r103.encodedSizeWithTag(26, r100.security_level)) + r101.encodedSizeWithTag(27, r100.owner_id)) + r105.encodedSizeWithTag(28, r100.create_time)) + r105.encodedSizeWithTag(29, r100.my_edit_time)) + r101.encodedSizeWithTag(30, r100.sharer_id)) + r107.encodedSizeWithTag(31, r100.is_subscribed)) + r105.encodedSizeWithTag(32, r100.share_time)) + r101.encodedSizeWithTag(33, r100.icon_key)) + r103.encodedSizeWithTag(34, r100.icon_type)) + r101.encodedSizeWithTag(35, r100.icon_fsunit)) + r101.encodedSizeWithTag(36, r100.create_tenant_id)) + r101.encodedSizeWithTag(37, r100.create_cn_name)) + r101.encodedSizeWithTag(38, r100.create_en_name)) + r101.encodedSizeWithTag(39, r100.share_cn_name)) + r101.encodedSizeWithTag(40, r100.share_en_name)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ HomepageDocument decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HomepageDocument r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HomepageDocument r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.url);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            r103.encodeWithTag(r100, 2, r101.owner_type);
            r102.encodeWithTag(r100, 3, r101.security_name);
            ProtoAdapter<Long> r104 = ProtoAdapter.INT64;
            r104.encodeWithTag(r100, 4, r101.path_count);
            r103.encodeWithTag(r100, 5, r101.obj_biz_type);
            r102.encodeWithTag(r100, 6, r101.delete_uid);
            r102.encodeWithTag(r100, 7, r101.token);
            r102.encodeWithTag(r100, 8, r101.obj_token);
            r103.encodeWithTag(r100, 9, r101.r_type);
            HomepageInnerDocExtraData.ADAPTER.encodeWithTag(r100, 10, r101.extra);
            r104.encodeWithTag(r100, 11, r101.open_time);
            r104.encodeWithTag(r100, 12, r101.star_time);
            r104.encodeWithTag(r100, 13, r101.get_sec_label_code);
            r104.encodeWithTag(r100, 14, r101.can_set_sec_label);
            r102.encodeWithTag(r100, 15, r101.name);
            ProtoAdapter<Boolean> r105 = ProtoAdapter.BOOL;
            r105.encodeWithTag(r100, 16, r101.secret_key_delete);
            r102.encodeWithTag(r100, 17, r101.edit_uid);
            r103.encodeWithTag(r100, 18, r101.delete_flag);
            r102.encodeWithTag(r100, 19, r101.icon_info);
            r104.encodeWithTag(r100, 20, r101.activity_time);
            r104.encodeWithTag(r100, 21, r101.edit_time);
            r102.encodeWithTag(r100, 22, r101.security_label_id);
            r105.encodeWithTag(r100, 23, r101.is_stared);
            r105.encodeWithTag(r100, 24, r101.is_pined);
            r102.encodeWithTag(r100, 25, r101.thumbnail);
            r103.encodeWithTag(r100, 26, r101.security_level);
            r102.encodeWithTag(r100, 27, r101.owner_id);
            r104.encodeWithTag(r100, 28, r101.create_time);
            r104.encodeWithTag(r100, 29, r101.my_edit_time);
            r102.encodeWithTag(r100, 30, r101.sharer_id);
            r105.encodeWithTag(r100, 31, r101.is_subscribed);
            r104.encodeWithTag(r100, 32, r101.share_time);
            r102.encodeWithTag(r100, 33, r101.icon_key);
            r103.encodeWithTag(r100, 34, r101.icon_type);
            r102.encodeWithTag(r100, 35, r101.icon_fsunit);
            r102.encodeWithTag(r100, 36, r101.create_tenant_id);
            r102.encodeWithTag(r100, 37, r101.create_cn_name);
            r102.encodeWithTag(r100, 38, r101.create_en_name);
            r102.encodeWithTag(r100, 39, r101.share_cn_name);
            r102.encodeWithTag(r100, 40, r101.share_en_name);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HomepageDocument r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HomepageDocument();
        DEFAULT_OWNER_TYPE = 0;
        DEFAULT_PATH_COUNT = 0L;
        DEFAULT_OBJ_BIZ_TYPE = 0;
        DEFAULT_R_TYPE = 0;
        DEFAULT_OPEN_TIME = 0L;
        DEFAULT_STAR_TIME = 0L;
        DEFAULT_GET_SEC_LABEL_CODE = 0L;
        DEFAULT_CAN_SET_SEC_LABEL = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_SECRET_KEY_DELETE = r100;
        DEFAULT_DELETE_FLAG = 0;
        DEFAULT_ACTIVITY_TIME = 0L;
        DEFAULT_EDIT_TIME = 0L;
        DEFAULT_IS_STARED = r100;
        DEFAULT_IS_PINED = r100;
        DEFAULT_SECURITY_LEVEL = 0;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_MY_EDIT_TIME = 0L;
        DEFAULT_IS_SUBSCRIBED = r100;
        DEFAULT_SHARE_TIME = 0L;
        DEFAULT_ICON_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.owner_type = this.owner_type;
        r100.security_name = this.security_name;
        r100.path_count = this.path_count;
        r100.obj_biz_type = this.obj_biz_type;
        r100.delete_uid = this.delete_uid;
        r100.token = this.token;
        r100.obj_token = this.obj_token;
        r100.r_type = this.r_type;
        r100.extra = this.extra;
        r100.open_time = this.open_time;
        r100.star_time = this.star_time;
        r100.get_sec_label_code = this.get_sec_label_code;
        r100.can_set_sec_label = this.can_set_sec_label;
        r100.name = this.name;
        r100.secret_key_delete = this.secret_key_delete;
        r100.edit_uid = this.edit_uid;
        r100.delete_flag = this.delete_flag;
        r100.icon_info = this.icon_info;
        r100.activity_time = this.activity_time;
        r100.edit_time = this.edit_time;
        r100.security_label_id = this.security_label_id;
        r100.is_stared = this.is_stared;
        r100.is_pined = this.is_pined;
        r100.thumbnail = this.thumbnail;
        r100.security_level = this.security_level;
        r100.owner_id = this.owner_id;
        r100.create_time = this.create_time;
        r100.my_edit_time = this.my_edit_time;
        r100.sharer_id = this.sharer_id;
        r100.is_subscribed = this.is_subscribed;
        r100.share_time = this.share_time;
        r100.icon_key = this.icon_key;
        r100.icon_type = this.icon_type;
        r100.icon_fsunit = this.icon_fsunit;
        r100.create_tenant_id = this.create_tenant_id;
        r100.create_cn_name = this.create_cn_name;
        r100.create_en_name = this.create_en_name;
        r100.share_cn_name = this.share_cn_name;
        r100.share_en_name = this.share_en_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HomepageDocument.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public HomepageDocument(String r410, Integer r411, String r412, Long r413, Integer r414, String r415, String r416, String r510, Integer r511, HomepageInnerDocExtraData r512, Long r513, Long r514, Long r515, Long r516, String r517, Boolean r518, String r519, Integer r610, String r611, Long r612, Long r613, String r614, Boolean r615, Boolean r616, String r617, Integer r618, String r619, Long r710, Long r711, String r712, Boolean r713, Long r714, String r715, Integer r716, String r717, String r718, String r719, String r810, String r811, String r812) {
        this(r410, r411, r412, r413, r414, r415, r416, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, ByteString.EMPTY);
    }

    public HomepageDocument(String r100, Integer r101, String r102, Long r103, Integer r104, String r105, String r110, String r111, Integer r112, HomepageInnerDocExtraData r113, Long r114, Long r115, Long r116, Long r117, String r118, Boolean r119, String r210, Integer r211, String r212, Long r213, Long r214, String r215, Boolean r216, Boolean r217, String r218, Integer r219, String r310, Long r311, Long r312, String r313, Boolean r314, Long r315, String r316, Integer r317, String r318, String r319, String r410, String r411, String r412, String r413, ByteString r414) {
        super(ADAPTER, r414);
        this.url = r100;
        this.owner_type = r101;
        this.security_name = r102;
        this.path_count = r103;
        this.obj_biz_type = r104;
        this.delete_uid = r105;
        this.token = r110;
        this.obj_token = r111;
        this.r_type = r112;
        this.extra = r113;
        this.open_time = r114;
        this.star_time = r115;
        this.get_sec_label_code = r116;
        this.can_set_sec_label = r117;
        this.name = r118;
        this.secret_key_delete = r119;
        this.edit_uid = r210;
        this.delete_flag = r211;
        this.icon_info = r212;
        this.activity_time = r213;
        this.edit_time = r214;
        this.security_label_id = r215;
        this.is_stared = r216;
        this.is_pined = r217;
        this.thumbnail = r218;
        this.security_level = r219;
        this.owner_id = r310;
        this.create_time = r311;
        this.my_edit_time = r312;
        this.sharer_id = r313;
        this.is_subscribed = r314;
        this.share_time = r315;
        this.icon_key = r316;
        this.icon_type = r317;
        this.icon_fsunit = r318;
        this.create_tenant_id = r319;
        this.create_cn_name = r410;
        this.create_en_name = r411;
        this.share_cn_name = r412;
        this.share_en_name = r413;
    }
}
