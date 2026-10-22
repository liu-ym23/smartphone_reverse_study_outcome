package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class AppInfo extends Message<AppInfo, Builder> {
    public static final ProtoAdapter<AppInfo> ADAPTER = null;
    public static final String DEFAULT_ACTION_NAME = "";
    public static final String DEFAULT_APPSTORE_DETAIL_APPLINK = "";
    public static final String DEFAULT_APP_ID = "";
    public static final String DEFAULT_DESC = "";
    public static final String DEFAULT_DEVELOPER_USER_ID = "";
    public static final String DEFAULT_HELP_DOC = "";
    public static final String DEFAULT_ITEM_DESC = "";
    public static final String DEFAULT_MOBILE_APPLINK_URL = "";
    public static final Boolean DEFAULT_MOBILE_AVAILABLE = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_REQUIRED_LAUNCH_ABILITY = "";
    private static final long serialVersionUID = 0;
    public final String action_name;
    public final String app_id;
    public final String appstore_detail_applink;
    public final String desc;
    public final String developer_user_id;
    public final String help_doc;
    public final Icon icon;
    public final String item_desc;
    public final String mobile_applink_url;
    public final Boolean mobile_available;
    public final String name;
    public final String required_launch_ability;

    public static final class Builder extends Message.Builder<AppInfo, Builder> {
        public String action_name;
        public String app_id;
        public String appstore_detail_applink;
        public String desc;
        public String developer_user_id;
        public String help_doc;
        public Icon icon;
        public String item_desc;
        public String mobile_applink_url;
        public Boolean mobile_available;
        public String name;
        public String required_launch_ability;

        @Override // com.squareup.wire.Message.Builder
        public AppInfo build() {
            String r100 = this.app_id;
            if (r100 == null) goto L19;
            if (this.desc == null) goto L19;
            if (this.icon == null) goto L19;
            if (this.item_desc == null) goto L19;
            if (this.mobile_available == null) goto L19;
            if (this.name == null) goto L19;
            if (this.required_launch_ability == null) goto L19;
            return new AppInfo(this.app_id, this.desc, this.developer_user_id, this.help_doc, this.icon, this.item_desc, this.mobile_applink_url, this.mobile_available, this.name, this.required_launch_ability, this.appstore_detail_applink, this.action_name, super.buildUnknownFields());
        L19:
            throw Internal.missingRequiredFields(new Object[]{r100, "app_id", this.desc, SocialConstants.PARAM_APP_DESC, this.icon, "icon", this.item_desc, "item_desc", this.mobile_available, "mobile_available", this.name, "name", this.required_launch_ability, "required_launch_ability"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_name(String r100) {
            this.action_name = r100;
            return this;
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder appstore_detail_applink(String r100) {
            this.appstore_detail_applink = r100;
            return this;
        }

        public Builder desc(String r100) {
            this.desc = r100;
            return this;
        }

        public Builder developer_user_id(String r100) {
            this.developer_user_id = r100;
            return this;
        }

        public Builder help_doc(String r100) {
            this.help_doc = r100;
            return this;
        }

        public Builder icon(Icon r100) {
            this.icon = r100;
            return this;
        }

        public Builder item_desc(String r100) {
            this.item_desc = r100;
            return this;
        }

        public Builder mobile_applink_url(String r100) {
            this.mobile_applink_url = r100;
            return this;
        }

        public Builder mobile_available(Boolean r100) {
            this.mobile_available = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder required_launch_ability(String r100) {
            this.required_launch_ability = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AppInfo extends ProtoAdapter<AppInfo> {
        public ProtoAdapter_AppInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, AppInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public AppInfo decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            r101.action_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.appstore_detail_applink = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.required_launch_ability = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mobile_available = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.mobile_applink_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.item_desc = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.icon = Icon.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.help_doc = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.developer_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.desc = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AppInfo r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.app_id) + r101.encodedSizeWithTag(2, r100.desc);
            String r103 = r100.developer_user_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.help_doc;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = ((r106 + r108) + Icon.ADAPTER.encodedSizeWithTag(5, r100.icon)) + r101.encodedSizeWithTag(6, r100.item_desc);
            String r110 = r100.mobile_applink_url;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(7, r110);
        L14:
            int r112 = (((r109 + r111) + ProtoAdapter.BOOL.encodedSizeWithTag(8, r100.mobile_available)) + r101.encodedSizeWithTag(9, r100.name)) + r101.encodedSizeWithTag(10, r100.required_launch_ability);
            String r113 = r100.appstore_detail_applink;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(11, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.action_name;
            if (r116 == null) goto L22;
            r104 = r101.encodedSizeWithTag(12, r116);
        L22:
            return (r115 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ AppInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AppInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AppInfo r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.app_id);
            r102.encodeWithTag(r100, 2, r101.desc);
            String r103 = r101.developer_user_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.help_doc;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            Icon.ADAPTER.encodeWithTag(r100, 5, r101.icon);
            r102.encodeWithTag(r100, 6, r101.item_desc);
            String r105 = r101.mobile_applink_url;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 7, r105);
        L11:
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r101.mobile_available);
            r102.encodeWithTag(r100, 9, r101.name);
            r102.encodeWithTag(r100, 10, r101.required_launch_ability);
            String r106 = r101.appstore_detail_applink;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 11, r106);
        L14:
            String r107 = r101.action_name;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 12, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppInfo();
        DEFAULT_MOBILE_AVAILABLE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_id = this.app_id;
        r100.desc = this.desc;
        r100.developer_user_id = this.developer_user_id;
        r100.help_doc = this.help_doc;
        r100.icon = this.icon;
        r100.item_desc = this.item_desc;
        r100.mobile_applink_url = this.mobile_applink_url;
        r100.mobile_available = this.mobile_available;
        r100.name = this.name;
        r100.required_launch_ability = this.required_launch_ability;
        r100.appstore_detail_applink = this.appstore_detail_applink;
        r100.action_name = this.action_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AppInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AppInfo(String r110, String r111, String r112, String r113, Icon r114, String r210, String r211, Boolean r212, String r213, String r214, String r215, String r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public AppInfo(String r100, String r101, String r102, String r103, Icon r104, String r105, String r106, Boolean r107, String r110, String r111, String r112, String r113, ByteString r114) {
        super(ADAPTER, r114);
        this.app_id = r100;
        this.desc = r101;
        this.developer_user_id = r102;
        this.help_doc = r103;
        this.icon = r104;
        this.item_desc = r105;
        this.mobile_applink_url = r106;
        this.mobile_available = r107;
        this.name = r110;
        this.required_launch_ability = r111;
        this.appstore_detail_applink = r112;
        this.action_name = r113;
    }
}
