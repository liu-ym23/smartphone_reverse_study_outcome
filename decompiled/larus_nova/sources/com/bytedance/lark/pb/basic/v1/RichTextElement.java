package com.bytedance.lark.pb.basic.v1;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.facebook.keyframes.model.KFAnimation;
import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class RichTextElement extends com.squareup.wire.Message<RichTextElement, Builder> {
    public static final ProtoAdapter<RichTextElement> ADAPTER = null;
    public static final String DEFAULT_LAST_UPGRADE_VERSION = "";
    public static final ByteString DEFAULT_SER_UPGRADE_ELEMENT = null;
    public static final Tag DEFAULT_TAG = null;
    private static final long serialVersionUID = 0;
    public final List<String> child_ids;
    public final String last_upgrade_version;
    public final PropertySet property;
    public final ByteString ser_upgrade_element;
    public final Map<String, String> style;
    public final List<String> style_keys;
    public final Tag tag;
    public final Map<String, String> wide_style;

    public static final class AnchorProperty extends com.squareup.wire.Message<AnchorProperty, Builder> {
        public static final ProtoAdapter<AnchorProperty> ADAPTER = null;
        public static final String DEFAULT_ANDROID_HREF = "";
        public static final Boolean DEFAULT_CLOSE_CARD_PREVIEW = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_HREF = "";
        public static final String DEFAULT_I18N_KEY = "";
        public static final String DEFAULT_IOS_HREF = "";
        public static final Boolean DEFAULT_IS_CUSTOM = null;
        public static final String DEFAULT_PC_HREF = "";
        public static final Scene DEFAULT_SCENE = null;
        public static final SpecialURL DEFAULT_SPECIAL_URL = null;
        public static final String DEFAULT_TEXT_CONTENT = "";
        private static final long serialVersionUID = 0;
        public final String android_href;
        public final Boolean close_card_preview;
        public final String content;
        public final String href;
        public final String i18n_key;
        public final String ios_href;
        public final Boolean is_custom;
        public final String pc_href;
        public final Scene scene;
        public final SpecialURL special_url;
        public final String text_content;

        public static final class Builder extends com.squareup.wire.Message.Builder<AnchorProperty, Builder> {
            public String android_href;
            public Boolean close_card_preview;
            public String content;
            public String href;
            public String i18n_key;
            public String ios_href;
            public Boolean is_custom;
            public String pc_href;
            public Scene scene;
            public SpecialURL special_url;
            public String text_content;

            @Override // com.squareup.wire.Message.Builder
            public AnchorProperty build() {
                String r100 = this.href;
                if (r100 == null) goto L9;
                if (this.content == null) goto L9;
                return new AnchorProperty(this.href, this.content, this.text_content, this.special_url, this.i18n_key, this.ios_href, this.android_href, this.pc_href, this.is_custom, this.scene, this.close_card_preview, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "href", this.content, "content"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder android_href(String r100) {
                this.android_href = r100;
                return this;
            }

            public Builder close_card_preview(Boolean r100) {
                this.close_card_preview = r100;
                return this;
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder href(String r100) {
                this.href = r100;
                return this;
            }

            public Builder i18n_key(String r100) {
                this.i18n_key = r100;
                return this;
            }

            public Builder ios_href(String r100) {
                this.ios_href = r100;
                return this;
            }

            public Builder is_custom(Boolean r100) {
                this.is_custom = r100;
                return this;
            }

            public Builder pc_href(String r100) {
                this.pc_href = r100;
                return this;
            }

            public Builder scene(Scene r100) {
                this.scene = r100;
                return this;
            }

            public Builder special_url(SpecialURL r100) {
                this.special_url = r100;
                return this;
            }

            public Builder text_content(String r100) {
                this.text_content = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AnchorProperty extends ProtoAdapter<AnchorProperty> {
            public ProtoAdapter_AnchorProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, AnchorProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AnchorProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.href = "";
                r101.content = "";
                r101.text_content = "";
                r101.special_url = SpecialURL.UNKNOWN_URL;
                r101.i18n_key = "";
                r101.ios_href = "";
                r101.android_href = "";
                r101.pc_href = "";
                Boolean r102 = Boolean.FALSE;
                r101.is_custom = r102;
                r101.scene = Scene.UNKNOWN;
                r101.close_card_preview = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L24;
                switch(r104) {
                    case 1: goto L23;
                    case 2: goto L22;
                    case 3: goto L21;
                    case 4: goto L26;
                    case 5: goto L16;
                    case 6: goto L15;
                    case 7: goto L14;
                    case 8: goto L13;
                    case 9: goto L12;
                    case 10: goto L28;
                    case 11: goto L7;
                    default: goto L6;
                };
            L26:
                r101.special_url = SpecialURL.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L28:
                r101.scene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.close_card_preview = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.is_custom = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.pc_href = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.android_href = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.ios_href = ProtoAdapter.STRING.decode(r100);
                goto L3
            L16:
                r101.i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L21:
                r101.text_content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L22:
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L23:
                r101.href = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L24:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(AnchorProperty r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.href) + r101.encodedSizeWithTag(2, r100.content);
                String r103 = r100.text_content;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(3, r103);
            L6:
                int r106 = r102 + r105;
                SpecialURL r107 = r100.special_url;
                if (r107 == null) goto L9;
                int r108 = SpecialURL.ADAPTER.encodedSizeWithTag(4, r107);
            L10:
                int r109 = r106 + r108;
                String r110 = r100.i18n_key;
                if (r110 == null) goto L13;
                int r111 = r101.encodedSizeWithTag(5, r110);
            L14:
                int r112 = r109 + r111;
                String r113 = r100.ios_href;
                if (r113 == null) goto L17;
                int r114 = r101.encodedSizeWithTag(6, r113);
            L18:
                int r115 = r112 + r114;
                String r116 = r100.android_href;
                if (r116 == null) goto L21;
                int r117 = r101.encodedSizeWithTag(7, r116);
            L22:
                int r118 = r115 + r117;
                String r119 = r100.pc_href;
                if (r119 == null) goto L25;
                int r120 = r101.encodedSizeWithTag(8, r119);
            L26:
                int r121 = r118 + r120;
                Boolean r122 = r100.is_custom;
                if (r122 == null) goto L29;
                int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r122);
            L30:
                int r124 = r121 + r123;
                Scene r125 = r100.scene;
                if (r125 == null) goto L33;
                int r126 = Scene.ADAPTER.encodedSizeWithTag(10, r125);
            L34:
                int r127 = r124 + r126;
                Boolean r128 = r100.close_card_preview;
                if (r128 == null) goto L38;
                r104 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r128);
            L38:
                return (r127 + r104) + r100.unknownFields().size();
            L33:
                r126 = 0;
                goto L34
            L29:
                r123 = 0;
                goto L30
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
            public /* bridge */ /* synthetic */ AnchorProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AnchorProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AnchorProperty r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.href);
                r102.encodeWithTag(r100, 2, r101.content);
                String r103 = r101.text_content;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 3, r103);
            L5:
                SpecialURL r104 = r101.special_url;
                if (r104 == null) goto L8;
                SpecialURL.ADAPTER.encodeWithTag(r100, 4, r104);
            L8:
                String r105 = r101.i18n_key;
                if (r105 == null) goto L11;
                r102.encodeWithTag(r100, 5, r105);
            L11:
                String r106 = r101.ios_href;
                if (r106 == null) goto L14;
                r102.encodeWithTag(r100, 6, r106);
            L14:
                String r107 = r101.android_href;
                if (r107 == null) goto L17;
                r102.encodeWithTag(r100, 7, r107);
            L17:
                String r108 = r101.pc_href;
                if (r108 == null) goto L20;
                r102.encodeWithTag(r100, 8, r108);
            L20:
                Boolean r109 = r101.is_custom;
                if (r109 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 9, r109);
            L23:
                Scene r110 = r101.scene;
                if (r110 == null) goto L26;
                Scene.ADAPTER.encodeWithTag(r100, 10, r110);
            L26:
                Boolean r111 = r101.close_card_preview;
                if (r111 == null) goto L29;
                ProtoAdapter.BOOL.encodeWithTag(r100, 11, r111);
            L29:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AnchorProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Scene extends Enum<Scene> implements WireEnum {
            private static final /* synthetic */ Scene[] $VALUES = null;
            public static final ProtoAdapter<Scene> ADAPTER = null;
            public static final Scene COPY_PASTE_ANCHOR = null;
            public static final Scene COPY_PASTE_TEXT = null;
            public static final Scene CUSTOM_EDIT = null;
            public static final Scene SEVER_PARSE = null;
            public static final Scene UNKNOWN = null;
            private final int value;

            static {
                Scene r100 = new Scene("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Scene r101 = new Scene("COPY_PASTE_ANCHOR", 1, 1);
                COPY_PASTE_ANCHOR = r101;
                Scene r102 = new Scene("COPY_PASTE_TEXT", 2, 2);
                COPY_PASTE_TEXT = r102;
                Scene r103 = new Scene("CUSTOM_EDIT", 3, 3);
                CUSTOM_EDIT = r103;
                Scene r104 = new Scene("SEVER_PARSE", 4, 4);
                SEVER_PARSE = r104;
                $VALUES = new Scene[]{r100, r101, r102, r103, r104};
                ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
            }

            public static Scene[] values() {
                return (Scene[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Scene fromValue(int r100) {
                if (r100 == 0) goto L22;
                if (r100 == 1) goto L20;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L16;
                if (r100 == 4) goto L14;
                return null;
            L14:
                return SEVER_PARSE;
            L16:
                return CUSTOM_EDIT;
            L18:
                return COPY_PASTE_TEXT;
            L20:
                return COPY_PASTE_ANCHOR;
            L22:
                return UNKNOWN;
            }

            public static Scene valueOf(String r100) {
                return (Scene) a.a(Scene.class, r100);
            }

            private Scene(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AnchorProperty();
            DEFAULT_SPECIAL_URL = SpecialURL.UNKNOWN_URL;
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_CUSTOM = r100;
            DEFAULT_SCENE = Scene.UNKNOWN;
            DEFAULT_CLOSE_CARD_PREVIEW = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.href = this.href;
            r100.content = this.content;
            r100.text_content = this.text_content;
            r100.special_url = this.special_url;
            r100.i18n_key = this.i18n_key;
            r100.ios_href = this.ios_href;
            r100.android_href = this.android_href;
            r100.pc_href = this.pc_href;
            r100.is_custom = this.is_custom;
            r100.scene = this.scene;
            r100.close_card_preview = this.close_card_preview;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AnchorProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AnchorProperty(String r110, String r111, String r112, SpecialURL r113, String r114, String r115, String r210, String r211, Boolean r212, Scene r213, Boolean r214) {
            this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
        }

        public AnchorProperty(String r100, String r101, String r102, SpecialURL r103, String r104, String r105, String r106, String r107, Boolean r110, Scene r111, Boolean r112, ByteString r113) {
            super(ADAPTER, r113);
            this.href = r100;
            this.content = r101;
            this.text_content = r102;
            this.special_url = r103;
            this.i18n_key = r104;
            this.ios_href = r105;
            this.android_href = r106;
            this.pc_href = r107;
            this.is_custom = r110;
            this.scene = r111;
            this.close_card_preview = r112;
        }
    }

    public static final class AtProperty extends com.squareup.wire.Message<AtProperty, Builder> {
        public static final ProtoAdapter<AtProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final Boolean DEFAULT_IS_ANONYMOUS = null;
        public static final Boolean DEFAULT_IS_HIGHLIGHT = null;
        public static final Boolean DEFAULT_IS_OUTER = null;
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final String content;
        public final Boolean is_anonymous;
        public final Boolean is_highlight;
        public final Boolean is_outer;
        public final String user_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<AtProperty, Builder> {
            public String content;
            public Boolean is_anonymous;
            public Boolean is_highlight;
            public Boolean is_outer;
            public String user_id;

            @Override // com.squareup.wire.Message.Builder
            public AtProperty build() {
                String r100 = this.user_id;
                if (r100 == null) goto L9;
                if (this.content == null) goto L9;
                return new AtProperty(this.user_id, this.content, this.is_outer, this.is_anonymous, this.is_highlight, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "user_id", this.content, "content"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder is_anonymous(Boolean r100) {
                this.is_anonymous = r100;
                return this;
            }

            public Builder is_highlight(Boolean r100) {
                this.is_highlight = r100;
                return this;
            }

            public Builder is_outer(Boolean r100) {
                this.is_outer = r100;
                return this;
            }

            public Builder user_id(String r100) {
                this.user_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AtProperty extends ProtoAdapter<AtProperty> {
            public ProtoAdapter_AtProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, AtProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AtProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.user_id = "";
                r101.content = "";
                Boolean r102 = Boolean.FALSE;
                r101.is_outer = r102;
                r101.is_anonymous = r102;
                r101.is_highlight = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L21;
                if (r104 != 1) goto L8;
                r101.user_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r104 != 3) goto L12;
                r101.is_outer = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                if (r104 != 4) goto L14;
                r101.is_anonymous = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L14:
                if (r104 != 5) goto L15;
                r101.is_highlight = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L15:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(AtProperty r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.user_id) + r101.encodedSizeWithTag(2, r100.content);
                Boolean r103 = r100.is_outer;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r103);
            L6:
                int r106 = r102 + r105;
                Boolean r107 = r100.is_anonymous;
                if (r107 == null) goto L9;
                int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r107);
            L10:
                int r109 = r106 + r108;
                Boolean r110 = r100.is_highlight;
                if (r110 == null) goto L14;
                r104 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r110);
            L14:
                return (r109 + r104) + r100.unknownFields().size();
            L9:
                r108 = 0;
                goto L10
            L5:
                r105 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AtProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AtProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AtProperty r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.user_id);
                r102.encodeWithTag(r100, 2, r101.content);
                Boolean r103 = r101.is_outer;
                if (r103 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
            L5:
                Boolean r104 = r101.is_anonymous;
                if (r104 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
            L8:
                Boolean r105 = r101.is_highlight;
                if (r105 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AtProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AtProperty();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_OUTER = r100;
            DEFAULT_IS_ANONYMOUS = r100;
            DEFAULT_IS_HIGHLIGHT = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_id = this.user_id;
            r100.content = this.content;
            r100.is_outer = this.is_outer;
            r100.is_anonymous = this.is_anonymous;
            r100.is_highlight = this.is_highlight;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AtProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AtProperty(String r100, String r101, Boolean r110, Boolean r111, Boolean r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public AtProperty(String r100, String r101, Boolean r102, Boolean r103, Boolean r104, ByteString r105) {
            super(ADAPTER, r105);
            this.user_id = r100;
            this.content = r101;
            this.is_outer = r102;
            this.is_anonymous = r103;
            this.is_highlight = r104;
        }
    }

    public static final class AtUserGroupProperty extends com.squareup.wire.Message<AtUserGroupProperty, Builder> {
        public static final ProtoAdapter<AtUserGroupProperty> ADAPTER = null;
        public static final String DEFAULT_DEFAULT_GROUP_NAME = "";
        public static final Long DEFAULT_USER_GROUP_ID = null;
        private static final long serialVersionUID = 0;
        public final String default_group_name;
        public final Map<String, String> i18n_group_name;
        public final Long user_group_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<AtUserGroupProperty, Builder> {
            public String default_group_name;
            public Map<String, String> i18n_group_name;
            public Long user_group_id;

            @Override // com.squareup.wire.Message.Builder
            public AtUserGroupProperty build() {
                return new AtUserGroupProperty(this.user_group_id, this.default_group_name, this.i18n_group_name, super.buildUnknownFields());
            }

            public Builder() {
                this.i18n_group_name = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder default_group_name(String r100) {
                this.default_group_name = r100;
                return this;
            }

            public Builder i18n_group_name(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.i18n_group_name = r100;
                return this;
            }

            public Builder user_group_id(Long r100) {
                this.user_group_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AtUserGroupProperty extends ProtoAdapter<AtUserGroupProperty> {
            private final ProtoAdapter<Map<String, String>> i18n_group_name;

            public ProtoAdapter_AtUserGroupProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, AtUserGroupProperty.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.i18n_group_name = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AtUserGroupProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.user_group_id = 0L;
                r101.default_group_name = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.user_group_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.default_group_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.i18n_group_name.putAll(this.i18n_group_name.decode(r100));
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
            public int encodedSize2(AtUserGroupProperty r100) {
                Long r101 = r100.user_group_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.default_group_name;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return ((r103 + r102) + this.i18n_group_name.encodedSizeWithTag(3, r100.i18n_group_name)) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AtUserGroupProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AtUserGroupProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AtUserGroupProperty r101) throws IOException {
                Long r102 = r101.user_group_id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.default_group_name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                this.i18n_group_name.encodeWithTag(r100, 3, r101.i18n_group_name);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AtUserGroupProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AtUserGroupProperty();
            DEFAULT_USER_GROUP_ID = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_group_id = this.user_group_id;
            r100.default_group_name = this.default_group_name;
            r100.i18n_group_name = Internal.copyOf("i18n_group_name", this.i18n_group_name);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AtUserGroupProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public AtUserGroupProperty(Long r100, String r101, Map<String, String> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public AtUserGroupProperty(Long r100, String r101, Map<String, String> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.user_group_id = r100;
            this.default_group_name = r101;
            this.i18n_group_name = Internal.immutableCopyOf("i18n_group_name", r102);
        }
    }

    public static final class BoldProperty extends com.squareup.wire.Message<BoldProperty, Builder> {
        public static final ProtoAdapter<BoldProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String content;
        public final String i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<BoldProperty, Builder> {
            public String content;
            public String i18n_key;

            @Override // com.squareup.wire.Message.Builder
            public BoldProperty build() {
                String r100 = this.content;
                if (r100 == null) goto L7;
                return new BoldProperty(this.content, this.i18n_key, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "content"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder i18n_key(String r100) {
                this.i18n_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_BoldProperty extends ProtoAdapter<BoldProperty> {
            public ProtoAdapter_BoldProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, BoldProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public BoldProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.content = "";
                r101.i18n_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(BoldProperty r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.content);
                String r103 = r100.i18n_key;
                if (r103 == null) goto L5;
                int r104 = r101.encodedSizeWithTag(2, r103);
            L7:
                return (r102 + r104) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ BoldProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(BoldProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, BoldProperty r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.content);
                String r103 = r101.i18n_key;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 2, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BoldProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BoldProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.content = this.content;
            r100.i18n_key = this.i18n_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return BoldProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public BoldProperty(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public BoldProperty(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.content = r100;
            this.i18n_key = r101;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<RichTextElement, Builder> {
        public List<String> child_ids;
        public String last_upgrade_version;
        public PropertySet property;
        public ByteString ser_upgrade_element;
        public Map<String, String> style;
        public List<String> style_keys;
        public Tag tag;
        public Map<String, String> wide_style;

        @Override // com.squareup.wire.Message.Builder
        public RichTextElement build() {
            Tag r100 = this.tag;
            if (r100 == null) goto L9;
            if (this.property == null) goto L9;
            return new RichTextElement(this.tag, this.style, this.property, this.child_ids, this.style_keys, this.wide_style, this.ser_upgrade_element, this.last_upgrade_version, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "tag", this.property, KFAnimation.PROPERTY_TYPE_JSON_FIELD});
        }

        public Builder() {
            this.style = Internal.newMutableMap();
            this.child_ids = Internal.newMutableList();
            this.style_keys = Internal.newMutableList();
            this.wide_style = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder child_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.child_ids = r100;
            return this;
        }

        public Builder last_upgrade_version(String r100) {
            this.last_upgrade_version = r100;
            return this;
        }

        public Builder property(PropertySet r100) {
            this.property = r100;
            return this;
        }

        public Builder ser_upgrade_element(ByteString r100) {
            this.ser_upgrade_element = r100;
            return this;
        }

        public Builder style(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.style = r100;
            return this;
        }

        public Builder style_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.style_keys = r100;
            return this;
        }

        public Builder tag(Tag r100) {
            this.tag = r100;
            return this;
        }

        public Builder wide_style(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.wide_style = r100;
            return this;
        }
    }

    public static final class ButtonConfirmProperty extends com.squareup.wire.Message<ButtonConfirmProperty, Builder> {
        public static final ProtoAdapter<ButtonConfirmProperty> ADAPTER = null;
        public static final String DEFAULT_CONFIRM = "";
        public static final String DEFAULT_CONFIRM_I18N_KEY = "";
        public static final String DEFAULT_DISMISS = "";
        public static final String DEFAULT_DISMISS_I18N_KEY = "";
        public static final String DEFAULT_TEXT = "";
        public static final String DEFAULT_TEXT_I18N_KEY = "";
        public static final String DEFAULT_TITLE = "";
        public static final String DEFAULT_TITLE_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String confirm;
        public final String confirm_i18n_key;
        public final String dismiss;
        public final String dismiss_i18n_key;
        public final String text;
        public final String text_i18n_key;
        public final String title;
        public final String title_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<ButtonConfirmProperty, Builder> {
            public String confirm;
            public String confirm_i18n_key;
            public String dismiss;
            public String dismiss_i18n_key;
            public String text;
            public String text_i18n_key;
            public String title;
            public String title_i18n_key;

            @Override // com.squareup.wire.Message.Builder
            public ButtonConfirmProperty build() {
                String r100 = this.title;
                if (r100 == null) goto L13;
                if (this.text == null) goto L13;
                if (this.confirm == null) goto L13;
                if (this.dismiss == null) goto L13;
                return new ButtonConfirmProperty(this.title, this.text, this.confirm, this.dismiss, this.title_i18n_key, this.text_i18n_key, this.confirm_i18n_key, this.dismiss_i18n_key, super.buildUnknownFields());
            L13:
                throw Internal.missingRequiredFields(new Object[]{r100, "title", this.text, "text", this.confirm, "confirm", this.dismiss, "dismiss"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder confirm(String r100) {
                this.confirm = r100;
                return this;
            }

            public Builder confirm_i18n_key(String r100) {
                this.confirm_i18n_key = r100;
                return this;
            }

            public Builder dismiss(String r100) {
                this.dismiss = r100;
                return this;
            }

            public Builder dismiss_i18n_key(String r100) {
                this.dismiss_i18n_key = r100;
                return this;
            }

            public Builder text(String r100) {
                this.text = r100;
                return this;
            }

            public Builder text_i18n_key(String r100) {
                this.text_i18n_key = r100;
                return this;
            }

            public Builder title(String r100) {
                this.title = r100;
                return this;
            }

            public Builder title_i18n_key(String r100) {
                this.title_i18n_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ButtonConfirmProperty extends ProtoAdapter<ButtonConfirmProperty> {
            public ProtoAdapter_ButtonConfirmProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ButtonConfirmProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ButtonConfirmProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.title = "";
                r101.text = "";
                r101.confirm = "";
                r101.dismiss = "";
                r101.title_i18n_key = "";
                r101.text_i18n_key = "";
                r101.confirm_i18n_key = "";
                r101.dismiss_i18n_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                switch(r103) {
                    case 1: goto L14;
                    case 2: goto L13;
                    case 3: goto L12;
                    case 4: goto L11;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L7:
                r101.dismiss_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.confirm_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.text_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.title_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.dismiss = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.confirm = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.text = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ButtonConfirmProperty r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = ((r101.encodedSizeWithTag(1, r100.title) + r101.encodedSizeWithTag(2, r100.text)) + r101.encodedSizeWithTag(3, r100.confirm)) + r101.encodedSizeWithTag(4, r100.dismiss);
                String r103 = r100.title_i18n_key;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(5, r103);
            L6:
                int r106 = r102 + r105;
                String r107 = r100.text_i18n_key;
                if (r107 == null) goto L9;
                int r108 = r101.encodedSizeWithTag(6, r107);
            L10:
                int r109 = r106 + r108;
                String r110 = r100.confirm_i18n_key;
                if (r110 == null) goto L13;
                int r111 = r101.encodedSizeWithTag(7, r110);
            L14:
                int r112 = r109 + r111;
                String r113 = r100.dismiss_i18n_key;
                if (r113 == null) goto L18;
                r104 = r101.encodedSizeWithTag(8, r113);
            L18:
                return (r112 + r104) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ ButtonConfirmProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ButtonConfirmProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ButtonConfirmProperty r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.title);
                r102.encodeWithTag(r100, 2, r101.text);
                r102.encodeWithTag(r100, 3, r101.confirm);
                r102.encodeWithTag(r100, 4, r101.dismiss);
                String r103 = r101.title_i18n_key;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 5, r103);
            L5:
                String r104 = r101.text_i18n_key;
                if (r104 == null) goto L8;
                r102.encodeWithTag(r100, 6, r104);
            L8:
                String r105 = r101.confirm_i18n_key;
                if (r105 == null) goto L11;
                r102.encodeWithTag(r100, 7, r105);
            L11:
                String r106 = r101.dismiss_i18n_key;
                if (r106 == null) goto L14;
                r102.encodeWithTag(r100, 8, r106);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ButtonConfirmProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ButtonConfirmProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.title = this.title;
            r100.text = this.text;
            r100.confirm = this.confirm;
            r100.dismiss = this.dismiss;
            r100.title_i18n_key = this.title_i18n_key;
            r100.text_i18n_key = this.text_i18n_key;
            r100.confirm_i18n_key = this.confirm_i18n_key;
            r100.dismiss_i18n_key = this.dismiss_i18n_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ButtonConfirmProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ButtonConfirmProperty(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
        }

        public ButtonConfirmProperty(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, ByteString r110) {
            super(ADAPTER, r110);
            this.title = r100;
            this.text = r101;
            this.confirm = r102;
            this.dismiss = r103;
            this.title_i18n_key = r104;
            this.text_i18n_key = r105;
            this.confirm_i18n_key = r106;
            this.dismiss_i18n_key = r107;
        }
    }

    public static final class ButtonLoadingProperty extends com.squareup.wire.Message<ButtonLoadingProperty, Builder> {
        public static final ProtoAdapter<ButtonLoadingProperty> ADAPTER = null;
        public static final String DEFAULT_BEGIN = "";
        public static final String DEFAULT_BEGIN_I18N_KEY = "";
        public static final String DEFAULT_FAIL = "";
        public static final String DEFAULT_FAIL_I18N_KEY = "";
        public static final String DEFAULT_SUCCESS = "";
        public static final String DEFAULT_SUCCESS_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String begin;
        public final String begin_i18n_key;
        public final String fail;
        public final String fail_i18n_key;
        public final String success;
        public final String success_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<ButtonLoadingProperty, Builder> {
            public String begin;
            public String begin_i18n_key;
            public String fail;
            public String fail_i18n_key;
            public String success;
            public String success_i18n_key;

            @Override // com.squareup.wire.Message.Builder
            public ButtonLoadingProperty build() {
                String r100 = this.begin;
                if (r100 == null) goto L11;
                if (this.success == null) goto L11;
                if (this.fail == null) goto L11;
                return new ButtonLoadingProperty(this.begin, this.success, this.fail, this.begin_i18n_key, this.success_i18n_key, this.fail_i18n_key, super.buildUnknownFields());
            L11:
                throw Internal.missingRequiredFields(new Object[]{r100, GearStrategyConsts.EV_SELECT_BEGIN, this.success, "success", this.fail, "fail"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder begin(String r100) {
                this.begin = r100;
                return this;
            }

            public Builder begin_i18n_key(String r100) {
                this.begin_i18n_key = r100;
                return this;
            }

            public Builder fail(String r100) {
                this.fail = r100;
                return this;
            }

            public Builder fail_i18n_key(String r100) {
                this.fail_i18n_key = r100;
                return this;
            }

            public Builder success(String r100) {
                this.success = r100;
                return this;
            }

            public Builder success_i18n_key(String r100) {
                this.success_i18n_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ButtonLoadingProperty extends ProtoAdapter<ButtonLoadingProperty> {
            public ProtoAdapter_ButtonLoadingProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ButtonLoadingProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ButtonLoadingProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.begin = "";
                r101.success = "";
                r101.fail = "";
                r101.begin_i18n_key = "";
                r101.success_i18n_key = "";
                r101.fail_i18n_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L13;
                switch(r103) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r101.fail_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.success_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.begin_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.fail = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.success = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.begin = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L13:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ButtonLoadingProperty r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = (r101.encodedSizeWithTag(1, r100.begin) + r101.encodedSizeWithTag(2, r100.success)) + r101.encodedSizeWithTag(3, r100.fail);
                String r103 = r100.begin_i18n_key;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(4, r103);
            L6:
                int r106 = r102 + r105;
                String r107 = r100.success_i18n_key;
                if (r107 == null) goto L9;
                int r108 = r101.encodedSizeWithTag(5, r107);
            L10:
                int r109 = r106 + r108;
                String r110 = r100.fail_i18n_key;
                if (r110 == null) goto L14;
                r104 = r101.encodedSizeWithTag(6, r110);
            L14:
                return (r109 + r104) + r100.unknownFields().size();
            L9:
                r108 = 0;
                goto L10
            L5:
                r105 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ButtonLoadingProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ButtonLoadingProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ButtonLoadingProperty r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.begin);
                r102.encodeWithTag(r100, 2, r101.success);
                r102.encodeWithTag(r100, 3, r101.fail);
                String r103 = r101.begin_i18n_key;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 4, r103);
            L5:
                String r104 = r101.success_i18n_key;
                if (r104 == null) goto L8;
                r102.encodeWithTag(r100, 5, r104);
            L8:
                String r105 = r101.fail_i18n_key;
                if (r105 == null) goto L11;
                r102.encodeWithTag(r100, 6, r105);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ButtonLoadingProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ButtonLoadingProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.begin = this.begin;
            r100.success = this.success;
            r100.fail = this.fail;
            r100.begin_i18n_key = this.begin_i18n_key;
            r100.success_i18n_key = this.success_i18n_key;
            r100.fail_i18n_key = this.fail_i18n_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ButtonLoadingProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ButtonLoadingProperty(String r100, String r110, String r111, String r112, String r113, String r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public ButtonLoadingProperty(String r100, String r101, String r102, String r103, String r104, String r105, ByteString r106) {
            super(ADAPTER, r106);
            this.begin = r100;
            this.success = r101;
            this.fail = r102;
            this.begin_i18n_key = r103;
            this.success_i18n_key = r104;
            this.fail_i18n_key = r105;
        }
    }

    public static final class ButtonProperty extends com.squareup.wire.Message<ButtonProperty, Builder> {
        public static final ProtoAdapter<ButtonProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final Boolean DEFAULT_ACTIVE = null;
        public static final Boolean DEFAULT_DISABLE = null;
        public static final Boolean DEFAULT_IS_LOADING = null;
        public static final String DEFAULT_MODE = "";
        private static final long serialVersionUID = 0;
        public final String action_id;
        public final Boolean active;
        public final ButtonConfirmProperty confirm;
        public final Boolean disable;
        public final Boolean is_loading;
        public final ButtonLoadingProperty loading;
        public final String mode;

        public static final class Builder extends com.squareup.wire.Message.Builder<ButtonProperty, Builder> {
            public String action_id;
            public Boolean active;
            public ButtonConfirmProperty confirm;
            public Boolean disable;
            public Boolean is_loading;
            public ButtonLoadingProperty loading;
            public String mode;

            @Override // com.squareup.wire.Message.Builder
            public ButtonProperty build() {
                return new ButtonProperty(this.action_id, this.disable, this.active, this.confirm, this.loading, this.is_loading, this.mode, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.action_id = r100;
                return this;
            }

            public Builder active(Boolean r100) {
                this.active = r100;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r100) {
                this.confirm = r100;
                return this;
            }

            public Builder disable(Boolean r100) {
                this.disable = r100;
                return this;
            }

            public Builder is_loading(Boolean r100) {
                this.is_loading = r100;
                return this;
            }

            public Builder loading(ButtonLoadingProperty r100) {
                this.loading = r100;
                return this;
            }

            public Builder mode(String r100) {
                this.mode = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ButtonProperty extends ProtoAdapter<ButtonProperty> {
            public ProtoAdapter_ButtonProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ButtonProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ButtonProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.action_id = "";
                Boolean r102 = Boolean.FALSE;
                r101.disable = r102;
                r101.active = r102;
                r101.is_loading = r102;
                r101.mode = "";
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L14;
                switch(r104) {
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
                r101.mode = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.is_loading = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.loading = ButtonLoadingProperty.ADAPTER.decode(r100);
                goto L3
            L10:
                r101.confirm = ButtonConfirmProperty.ADAPTER.decode(r100);
                goto L3
            L11:
                r101.active = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.disable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L14:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ButtonProperty r100) {
                String r101 = r100.action_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.disable;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.active;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                ButtonConfirmProperty r110 = r100.confirm;
                if (r110 == null) goto L17;
                int r111 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                ButtonLoadingProperty r113 = r100.loading;
                if (r113 == null) goto L21;
                int r114 = ButtonLoadingProperty.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.is_loading;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                String r119 = r100.mode;
                if (r119 == null) goto L30;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
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
            public /* bridge */ /* synthetic */ ButtonProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ButtonProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ButtonProperty r101) throws IOException {
                String r102 = r101.action_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.disable;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.active;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                ButtonConfirmProperty r105 = r101.confirm;
                if (r105 == null) goto L14;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                ButtonLoadingProperty r106 = r101.loading;
                if (r106 == null) goto L17;
                ButtonLoadingProperty.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.is_loading;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                String r108 = r101.mode;
                if (r108 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ButtonProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ButtonProperty();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_DISABLE = r100;
            DEFAULT_ACTIVE = r100;
            DEFAULT_IS_LOADING = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.action_id = this.action_id;
            r100.disable = this.disable;
            r100.active = this.active;
            r100.confirm = this.confirm;
            r100.loading = this.loading;
            r100.is_loading = this.is_loading;
            r100.mode = this.mode;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ButtonProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ButtonProperty(String r110, Boolean r111, Boolean r112, ButtonConfirmProperty r113, ButtonLoadingProperty r114, Boolean r115, String r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public ButtonProperty(String r100, Boolean r101, Boolean r102, ButtonConfirmProperty r103, ButtonLoadingProperty r104, Boolean r105, String r106, ByteString r107) {
            super(ADAPTER, r107);
            this.action_id = r100;
            this.disable = r101;
            this.active = r102;
            this.confirm = r103;
            this.loading = r104;
            this.is_loading = r105;
            this.mode = r106;
        }
    }

    public static final class CodeBlockProperty extends com.squareup.wire.Message<CodeBlockProperty, Builder> {
        public static final ProtoAdapter<CodeBlockProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final Language DEFAULT_LANGUAGE = null;
        private static final long serialVersionUID = 0;
        public final String content;
        public final Language language;
        public final List<StyleRef> style_refs;
        public final List<Style> styles;

        public static final class Builder extends com.squareup.wire.Message.Builder<CodeBlockProperty, Builder> {
            public String content;
            public Language language;
            public List<StyleRef> style_refs;
            public List<Style> styles;

            @Override // com.squareup.wire.Message.Builder
            public CodeBlockProperty build() {
                return new CodeBlockProperty(this.language, this.content, this.style_refs, this.styles, super.buildUnknownFields());
            }

            public Builder() {
                this.style_refs = Internal.newMutableList();
                this.styles = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder language(Language r100) {
                this.language = r100;
                return this;
            }

            public Builder style_refs(List<StyleRef> r100) {
                Internal.checkElementsNotNull(r100);
                this.style_refs = r100;
                return this;
            }

            public Builder styles(List<Style> r100) {
                Internal.checkElementsNotNull(r100);
                this.styles = r100;
                return this;
            }
        }

        public static final enum Language extends Enum<Language> implements WireEnum {
            private static final /* synthetic */ Language[] $VALUES = null;
            public static final ProtoAdapter<Language> ADAPTER = null;
            public static final Language APACHE = null;
            public static final Language BASH = null;
            public static final Language COFFE_SCRIPT = null;
            public static final Language CPLUSPLUS = null;
            public static final Language CS = null;
            public static final Language DJANGO = null;
            public static final Language GO = null;
            public static final Language HTML = null;
            public static final Language HTTP = null;
            public static final Language JAVA = null;
            public static final Language JS = null;
            public static final Language JSON = null;
            public static final Language KOTLIN = null;
            public static final Language LUA = null;
            public static final Language MAKEFILE = null;
            public static final Language MARKDOWN = null;
            public static final Language NGINX = null;
            public static final Language OBJC = null;
            public static final Language PERL = null;
            public static final Language PHP = null;
            public static final Language PYTHON = null;
            public static final Language RUBY = null;
            public static final Language SCSS = null;
            public static final Language SHELL = null;
            public static final Language SQL = null;
            public static final Language XML = null;
            private final int value;

            static {
                Language r100 = new Language("JS", 0, 0);
                JS = r100;
                Language r101 = new Language("APACHE", 1, 1);
                APACHE = r101;
                Language r102 = new Language("BASH", 2, 2);
                BASH = r102;
                Language r103 = new Language("CS", 3, 3);
                CS = r103;
                Language r104 = new Language("CPLUSPLUS", 4, 4);
                CPLUSPLUS = r104;
                Language r105 = new Language("COFFE_SCRIPT", 5, 5);
                COFFE_SCRIPT = r105;
                Language r110 = new Language("HTML", 6, 6);
                HTML = r110;
                Language r111 = new Language("XML", 7, 7);
                XML = r111;
                Language r112 = new Language("HTTP", 8, 8);
                HTTP = r112;
                Language r113 = new Language("JSON", 9, 9);
                JSON = r113;
                Language r114 = new Language("JAVA", 10, 10);
                JAVA = r114;
                Language r115 = new Language("MAKEFILE", 11, 11);
                MAKEFILE = r115;
                Language r106 = new Language("MARKDOWN", 12, 12);
                MARKDOWN = r106;
                Language r107 = new Language("NGINX", 13, 13);
                NGINX = r107;
                Language r108 = new Language("OBJC", 14, 14);
                OBJC = r108;
                Language r109 = new Language("PHP", 15, 15);
                PHP = r109;
                Language r116 = new Language("PERL", 16, 16);
                PERL = r116;
                Language r117 = new Language("PYTHON", 17, 17);
                PYTHON = r117;
                Language r118 = new Language("RUBY", 18, 18);
                RUBY = r118;
                Language r119 = new Language("SQL", 19, 19);
                SQL = r119;
                Language r120 = new Language("SHELL", 20, 20);
                SHELL = r120;
                Language r121 = new Language("GO", 21, 21);
                GO = r121;
                Language r122 = new Language("SCSS", 22, 22);
                SCSS = r122;
                Language r123 = new Language("LUA", 23, 23);
                LUA = r123;
                Language r124 = new Language("DJANGO", 24, 24);
                DJANGO = r124;
                Language r125 = new Language("KOTLIN", 25, 25);
                KOTLIN = r125;
                $VALUES = new Language[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125};
                ADAPTER = ProtoAdapter.newEnumAdapter(Language.class);
            }

            public static Language[] values() {
                return (Language[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Language fromValue(int r100) {
                switch(r100) {
                    case 0: goto L56;
                    case 1: goto L54;
                    case 2: goto L52;
                    case 3: goto L50;
                    case 4: goto L48;
                    case 5: goto L46;
                    case 6: goto L44;
                    case 7: goto L42;
                    case 8: goto L40;
                    case 9: goto L38;
                    case 10: goto L36;
                    case 11: goto L34;
                    case 12: goto L32;
                    case 13: goto L30;
                    case 14: goto L28;
                    case 15: goto L26;
                    case 16: goto L24;
                    case 17: goto L22;
                    case 18: goto L20;
                    case 19: goto L18;
                    case 20: goto L16;
                    case 21: goto L14;
                    case 22: goto L12;
                    case 23: goto L10;
                    case 24: goto L8;
                    case 25: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return KOTLIN;
            L8:
                return DJANGO;
            L10:
                return LUA;
            L12:
                return SCSS;
            L14:
                return GO;
            L16:
                return SHELL;
            L18:
                return SQL;
            L20:
                return RUBY;
            L22:
                return PYTHON;
            L24:
                return PERL;
            L26:
                return PHP;
            L28:
                return OBJC;
            L30:
                return NGINX;
            L32:
                return MARKDOWN;
            L34:
                return MAKEFILE;
            L36:
                return JAVA;
            L38:
                return JSON;
            L40:
                return HTTP;
            L42:
                return XML;
            L44:
                return HTML;
            L46:
                return COFFE_SCRIPT;
            L48:
                return CPLUSPLUS;
            L50:
                return CS;
            L52:
                return BASH;
            L54:
                return APACHE;
            L56:
                return JS;
            }

            public static Language valueOf(String r100) {
                return (Language) a.a(Language.class, r100);
            }

            private Language(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_CodeBlockProperty extends ProtoAdapter<CodeBlockProperty> {
            public ProtoAdapter_CodeBlockProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, CodeBlockProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CodeBlockProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.language = Language.JS;
                r101.content = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.language = Language.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.style_refs.add(StyleRef.ADAPTER.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.styles.add(Style.ADAPTER.decode(r100));
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
            public int encodedSize2(CodeBlockProperty r100) {
                Language r101 = r100.language;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Language.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.content;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (((r103 + r102) + StyleRef.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.style_refs)) + Style.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.styles)) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CodeBlockProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CodeBlockProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CodeBlockProperty r101) throws IOException {
                Language r102 = r101.language;
                if (r102 == null) goto L5;
                Language.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.content;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                StyleRef.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.style_refs);
                Style.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.styles);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CodeBlockProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final class Style extends com.squareup.wire.Message<Style, Builder> {
            public static final ProtoAdapter<Style> ADAPTER = null;
            public static final String DEFAULT_NAME = "";
            public static final StyleType DEFAULT_TYPE = null;
            public static final String DEFAULT_VALUE = "";
            private static final long serialVersionUID = 0;
            public final String name;
            public final StyleType type;
            public final String value;

            public static final class Builder extends com.squareup.wire.Message.Builder<Style, Builder> {
                public String name;
                public StyleType type;
                public String value;

                @Override // com.squareup.wire.Message.Builder
                public Style build() {
                    return new Style(this.type, this.name, this.value, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder name(String r100) {
                    this.name = r100;
                    return this;
                }

                public Builder type(StyleType r100) {
                    this.type = r100;
                    return this;
                }

                public Builder value(String r100) {
                    this.value = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_Style extends ProtoAdapter<Style> {
                public ProtoAdapter_Style() {
                    super(FieldEncoding.LENGTH_DELIMITED, Style.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Style decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.type = StyleType.CUSTOMIZE;
                    r101.name = "";
                    r101.value = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L18;
                    if (r103 != 1) goto L8;
                    r101.type = StyleType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                L16:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.name = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L11;
                    r101.value = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L11:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L18:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(Style r100) {
                    StyleType r101 = r100.type;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = StyleType.ADAPTER.encodedSizeWithTag(1, r101);
                L6:
                    String r104 = r100.name;
                    if (r104 == null) goto L9;
                    int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    String r107 = r100.value;
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
                public /* bridge */ /* synthetic */ Style decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Style r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Style r101) throws IOException {
                    StyleType r102 = r101.type;
                    if (r102 == null) goto L5;
                    StyleType.ADAPTER.encodeWithTag(r100, 1, r102);
                L5:
                    String r103 = r101.name;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                L8:
                    String r104 = r101.value;
                    if (r104 == null) goto L11;
                    ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
                L11:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Style r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Style();
                DEFAULT_TYPE = StyleType.CUSTOMIZE;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.type = this.type;
                r100.name = this.name;
                r100.value = this.value;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Style.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public Style(StyleType r100, String r101, String r102) {
                this(r100, r101, r102, ByteString.EMPTY);
            }

            public Style(StyleType r100, String r101, String r102, ByteString r103) {
                super(ADAPTER, r103);
                this.type = r100;
                this.name = r101;
                this.value = r102;
            }
        }

        public static final class StyleRef extends com.squareup.wire.Message<StyleRef, Builder> {
            public static final ProtoAdapter<StyleRef> ADAPTER = null;
            public static final Integer DEFAULT_LENGTH = null;
            public static final Integer DEFAULT_LOCATION = null;
            private static final long serialVersionUID = 0;
            public final Integer length;
            public final Integer location;
            public final List<Integer> style_ids;

            public static final class Builder extends com.squareup.wire.Message.Builder<StyleRef, Builder> {
                public Integer length;
                public Integer location;
                public List<Integer> style_ids;

                @Override // com.squareup.wire.Message.Builder
                public StyleRef build() {
                    return new StyleRef(this.location, this.length, this.style_ids, super.buildUnknownFields());
                }

                public Builder() {
                    this.style_ids = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder length(Integer r100) {
                    this.length = r100;
                    return this;
                }

                public Builder location(Integer r100) {
                    this.location = r100;
                    return this;
                }

                public Builder style_ids(List<Integer> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.style_ids = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_StyleRef extends ProtoAdapter<StyleRef> {
                public ProtoAdapter_StyleRef() {
                    super(FieldEncoding.LENGTH_DELIMITED, StyleRef.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public StyleRef decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.location = 0;
                    r101.length = 0;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L15;
                    if (r103 != 1) goto L8;
                    r101.location = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.length = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L11;
                    r101.style_ids.add(ProtoAdapter.INT32.decode(r100));
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
                public int encodedSize2(StyleRef r100) {
                    Integer r101 = r100.location;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
                L6:
                    Integer r104 = r100.length;
                    if (r104 == null) goto L10;
                    r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
                L10:
                    return ((r103 + r102) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(3, r100.style_ids)) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ StyleRef decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(StyleRef r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, StyleRef r101) throws IOException {
                    Integer r102 = r101.location;
                    if (r102 == null) goto L5;
                    ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
                L5:
                    Integer r103 = r101.length;
                    if (r103 == null) goto L8;
                    ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
                L8:
                    ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 3, r101.style_ids);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StyleRef r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_StyleRef();
                DEFAULT_LOCATION = 0;
                DEFAULT_LENGTH = 0;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.location = this.location;
                r100.length = this.length;
                r100.style_ids = Internal.copyOf("style_ids", this.style_ids);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return StyleRef.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public StyleRef(Integer r100, Integer r101, List<Integer> r102) {
                this(r100, r101, r102, ByteString.EMPTY);
            }

            public StyleRef(Integer r100, Integer r101, List<Integer> r102, ByteString r103) {
                super(ADAPTER, r103);
                this.location = r100;
                this.length = r101;
                this.style_ids = Internal.immutableCopyOf("style_ids", r102);
            }
        }

        public static final enum StyleType extends Enum<StyleType> implements WireEnum {
            private static final /* synthetic */ StyleType[] $VALUES = null;
            public static final ProtoAdapter<StyleType> ADAPTER = null;
            public static final StyleType CUSTOMIZE = null;
            public static final StyleType GRAMMAR = null;
            private final int value;

            static {
                StyleType r100 = new StyleType("CUSTOMIZE", 0, 0);
                CUSTOMIZE = r100;
                StyleType r101 = new StyleType("GRAMMAR", 1, 1);
                GRAMMAR = r101;
                $VALUES = new StyleType[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(StyleType.class);
            }

            public static StyleType[] values() {
                return (StyleType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static StyleType fromValue(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return GRAMMAR;
            L10:
                return CUSTOMIZE;
            }

            public static StyleType valueOf(String r100) {
                return (StyleType) a.a(StyleType.class, r100);
            }

            private StyleType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CodeBlockProperty();
            DEFAULT_LANGUAGE = Language.JS;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.language = this.language;
            r100.content = this.content;
            r100.style_refs = Internal.copyOf("style_refs", this.style_refs);
            r100.styles = Internal.copyOf("styles", this.styles);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CodeBlockProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CodeBlockProperty(Language r100, String r101, List<StyleRef> r102, List<Style> r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public CodeBlockProperty(Language r100, String r101, List<StyleRef> r102, List<Style> r103, ByteString r104) {
            super(ADAPTER, r104);
            this.language = r100;
            this.content = r101;
            this.style_refs = Internal.immutableCopyOf("style_refs", r102);
            this.styles = Internal.immutableCopyOf("styles", r103);
        }
    }

    public static final class CodeBlockV2Property extends com.squareup.wire.Message<CodeBlockV2Property, Builder> {
        public static final ProtoAdapter<CodeBlockV2Property> ADAPTER = null;
        public static final Language DEFAULT_LANGUAGE = null;
        public static final Integer DEFAULT_VERSION = null;
        public static final Boolean DEFAULT_WORD_WRAP = null;
        private static final long serialVersionUID = 0;
        public final List<LineContent> contents;
        public final Language language;
        public final Integer version;
        public final Boolean word_wrap;

        public static final class Builder extends com.squareup.wire.Message.Builder<CodeBlockV2Property, Builder> {
            public List<LineContent> contents;
            public Language language;
            public Integer version;
            public Boolean word_wrap;

            @Override // com.squareup.wire.Message.Builder
            public CodeBlockV2Property build() {
                return new CodeBlockV2Property(this.language, this.contents, this.word_wrap, this.version, super.buildUnknownFields());
            }

            public Builder() {
                this.contents = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder contents(List<LineContent> r100) {
                Internal.checkElementsNotNull(r100);
                this.contents = r100;
                return this;
            }

            public Builder language(Language r100) {
                this.language = r100;
                return this;
            }

            public Builder version(Integer r100) {
                this.version = r100;
                return this;
            }

            public Builder word_wrap(Boolean r100) {
                this.word_wrap = r100;
                return this;
            }
        }

        public static final class Content extends com.squareup.wire.Message<Content, Builder> {
            public static final ProtoAdapter<Content> ADAPTER = null;
            public static final String DEFAULT_CONTENT = "";
            public static final ContentType DEFAULT_TYPE = null;
            private static final long serialVersionUID = 0;
            public final String content;
            public final Map<String, String> style;
            public final ContentType type;

            public static final class Builder extends com.squareup.wire.Message.Builder<Content, Builder> {
                public String content;
                public Map<String, String> style;
                public ContentType type;

                @Override // com.squareup.wire.Message.Builder
                public Content build() {
                    return new Content(this.content, this.type, this.style, super.buildUnknownFields());
                }

                public Builder() {
                    this.style = Internal.newMutableMap();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder content(String r100) {
                    this.content = r100;
                    return this;
                }

                public Builder style(Map<String, String> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.style = r100;
                    return this;
                }

                public Builder type(ContentType r100) {
                    this.type = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_Content extends ProtoAdapter<Content> {
                private final ProtoAdapter<Map<String, String>> style;

                public ProtoAdapter_Content() {
                    super(FieldEncoding.LENGTH_DELIMITED, Content.class);
                    ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                    this.style = ProtoAdapter.newMapAdapter(r100, r100);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Content decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.content = "";
                    r101.type = ContentType.TEXT;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L18;
                    if (r103 != 1) goto L8;
                    r101.content = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.type = ContentType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
                L15:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r103 != 3) goto L11;
                    r101.style.putAll(this.style.decode(r100));
                    goto L3
                L11:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L18:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(Content r100) {
                    String r101 = r100.content;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    ContentType r104 = r100.type;
                    if (r104 == null) goto L10;
                    r102 = ContentType.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    return ((r103 + r102) + this.style.encodedSizeWithTag(3, r100.style)) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ Content decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Content r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Content r101) throws IOException {
                    String r102 = r101.content;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    ContentType r103 = r101.type;
                    if (r103 == null) goto L8;
                    ContentType.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    this.style.encodeWithTag(r100, 3, r101.style);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Content r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Content();
                DEFAULT_TYPE = ContentType.TEXT;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.content = this.content;
                r100.type = this.type;
                r100.style = Internal.copyOf("style", this.style);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Content.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public Content(String r100, ContentType r101, Map<String, String> r102) {
                this(r100, r101, r102, ByteString.EMPTY);
            }

            public Content(String r100, ContentType r101, Map<String, String> r102, ByteString r103) {
                super(ADAPTER, r103);
                this.content = r100;
                this.type = r101;
                this.style = Internal.immutableCopyOf("style", r102);
            }
        }

        public static final enum ContentType extends Enum<ContentType> implements WireEnum {
            private static final /* synthetic */ ContentType[] $VALUES = null;
            public static final ProtoAdapter<ContentType> ADAPTER = null;
            public static final ContentType ADDITION = null;
            public static final ContentType ATTR = null;
            public static final ContentType ATTRIBUTE = null;
            public static final ContentType BUILT_IN = null;
            public static final ContentType BULLET = null;
            public static final ContentType CHAR_ESCAPE = null;
            public static final ContentType CLASS = null;
            public static final ContentType CODE = null;
            public static final ContentType COMMENT = null;
            public static final ContentType DELETION = null;
            public static final ContentType DOCTAG = null;
            public static final ContentType EMPHASIS = null;
            public static final ContentType FORMULA = null;
            public static final ContentType FUNCTION = null;
            public static final ContentType KEYWORD = null;
            public static final ContentType LINK = null;
            public static final ContentType LITERAL = null;
            public static final ContentType META = null;
            public static final ContentType META_KEYWORD = null;
            public static final ContentType META_PROMPT = null;
            public static final ContentType META_STRING = null;
            public static final ContentType NAME = null;
            public static final ContentType NUMBER = null;
            public static final ContentType OPERATOR = null;
            public static final ContentType PARAMS = null;
            public static final ContentType PROPERTY = null;
            public static final ContentType PUNCTUATION = null;
            public static final ContentType QUOTE = null;
            public static final ContentType REGEXP = null;
            public static final ContentType SECTION = null;
            public static final ContentType SELECTOR_ATTR = null;
            public static final ContentType SELECTOR_CLASS = null;
            public static final ContentType SELECTOR_ID = null;
            public static final ContentType SELECTOR_PSEUDO = null;
            public static final ContentType SELECTOR_TAG = null;
            public static final ContentType STRING = null;
            public static final ContentType SUBST = null;
            public static final ContentType SYMBOL = null;
            public static final ContentType TAG = null;
            public static final ContentType TEMPLATE_TAG = null;
            public static final ContentType TEMPLATE_VARIABLE = null;
            public static final ContentType TEXT = null;
            public static final ContentType TITLE = null;
            public static final ContentType TITLE_CLASS = null;
            public static final ContentType TITLE_CLASS_INHERITED = null;
            public static final ContentType TITLE_FUNCTION = null;
            public static final ContentType TITLE_FUNCTION_INVOKE = null;
            public static final ContentType TYPE = null;
            public static final ContentType VARIABLE = null;
            public static final ContentType VARIABLE_CONSTANT = null;
            public static final ContentType VARIABLE_LANGUAGE = null;
            private final int value;

            static {
                ContentType r100 = new ContentType(CardAdapter.TEXT, 0, 0);
                TEXT = r100;
                ContentType r101 = new ContentType("KEYWORD", 1, 1);
                KEYWORD = r101;
                ContentType r102 = new ContentType("BUILT_IN", 2, 2);
                BUILT_IN = r102;
                ContentType r103 = new ContentType("TYPE", 3, 3);
                TYPE = r103;
                ContentType r104 = new ContentType("LITERAL", 4, 4);
                LITERAL = r104;
                ContentType r105 = new ContentType("NUMBER", 5, 5);
                NUMBER = r105;
                ContentType r110 = new ContentType("OPERATOR", 6, 6);
                OPERATOR = r110;
                ContentType r111 = new ContentType("PUNCTUATION", 7, 7);
                PUNCTUATION = r111;
                ContentType r112 = new ContentType("PROPERTY", 8, 8);
                PROPERTY = r112;
                ContentType r113 = new ContentType("REGEXP", 9, 9);
                REGEXP = r113;
                ContentType r114 = new ContentType("STRING", 10, 10);
                STRING = r114;
                ContentType r115 = new ContentType("CHAR_ESCAPE", 11, 11);
                CHAR_ESCAPE = r115;
                ContentType r106 = new ContentType("SUBST", 12, 12);
                SUBST = r106;
                ContentType r107 = new ContentType("SYMBOL", 13, 13);
                SYMBOL = r107;
                ContentType r108 = new ContentType("CLASS", 14, 14);
                CLASS = r108;
                ContentType r109 = new ContentType("FUNCTION", 15, 15);
                FUNCTION = r109;
                ContentType r116 = new ContentType("VARIABLE", 16, 16);
                VARIABLE = r116;
                ContentType r117 = new ContentType("VARIABLE_LANGUAGE", 17, 17);
                VARIABLE_LANGUAGE = r117;
                ContentType r118 = new ContentType("VARIABLE_CONSTANT", 18, 18);
                VARIABLE_CONSTANT = r118;
                ContentType r119 = new ContentType("TITLE", 19, 19);
                TITLE = r119;
                ContentType r120 = new ContentType("TITLE_CLASS", 20, 20);
                TITLE_CLASS = r120;
                ContentType r121 = new ContentType("TITLE_CLASS_INHERITED", 21, 21);
                TITLE_CLASS_INHERITED = r121;
                ContentType r122 = new ContentType("TITLE_FUNCTION", 22, 22);
                TITLE_FUNCTION = r122;
                ContentType r123 = new ContentType("TITLE_FUNCTION_INVOKE", 23, 23);
                TITLE_FUNCTION_INVOKE = r123;
                ContentType r124 = new ContentType("PARAMS", 24, 24);
                PARAMS = r124;
                ContentType r125 = new ContentType("COMMENT", 25, 25);
                COMMENT = r125;
                ContentType r126 = new ContentType("DOCTAG", 26, 26);
                DOCTAG = r126;
                ContentType r127 = new ContentType("META", 27, 27);
                META = r127;
                ContentType r128 = new ContentType("META_PROMPT", 28, 28);
                META_PROMPT = r128;
                ContentType r129 = new ContentType("META_KEYWORD", 29, 29);
                META_KEYWORD = r129;
                ContentType r130 = new ContentType("META_STRING", 30, 30);
                META_STRING = r130;
                ContentType r131 = new ContentType("SECTION", 31, 31);
                SECTION = r131;
                ContentType r132 = new ContentType("TAG", 32, 32);
                TAG = r132;
                ContentType r133 = new ContentType("NAME", 33, 33);
                NAME = r133;
                ContentType r134 = new ContentType("ATTR", 34, 34);
                ATTR = r134;
                ContentType r135 = new ContentType("ATTRIBUTE", 35, 35);
                ATTRIBUTE = r135;
                ContentType r136 = new ContentType("BULLET", 36, 36);
                BULLET = r136;
                ContentType r137 = new ContentType("CODE", 37, 37);
                CODE = r137;
                ContentType r138 = new ContentType("EMPHASIS", 38, 38);
                EMPHASIS = r138;
                ContentType r139 = new ContentType("FORMULA", 39, 39);
                FORMULA = r139;
                ContentType r140 = new ContentType("LINK", 40, 40);
                LINK = r140;
                ContentType r141 = new ContentType("QUOTE", 41, 41);
                QUOTE = r141;
                ContentType r142 = new ContentType("SELECTOR_TAG", 42, 42);
                SELECTOR_TAG = r142;
                ContentType r143 = new ContentType("SELECTOR_ID", 43, 43);
                SELECTOR_ID = r143;
                ContentType r144 = new ContentType("SELECTOR_CLASS", 44, 44);
                SELECTOR_CLASS = r144;
                ContentType r145 = new ContentType("SELECTOR_ATTR", 45, 45);
                SELECTOR_ATTR = r145;
                ContentType r146 = new ContentType("SELECTOR_PSEUDO", 46, 46);
                SELECTOR_PSEUDO = r146;
                ContentType r147 = new ContentType("TEMPLATE_TAG", 47, 47);
                TEMPLATE_TAG = r147;
                ContentType r148 = new ContentType("TEMPLATE_VARIABLE", 48, 48);
                TEMPLATE_VARIABLE = r148;
                ContentType r149 = new ContentType("ADDITION", 49, 49);
                ADDITION = r149;
                ContentType r150 = new ContentType("DELETION", 50, 50);
                DELETION = r150;
                $VALUES = new ContentType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150};
                ADAPTER = ProtoAdapter.newEnumAdapter(ContentType.class);
            }

            public static ContentType[] values() {
                return (ContentType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static ContentType fromValue(int r100) {
                switch(r100) {
                    case 0: goto L106;
                    case 1: goto L104;
                    case 2: goto L102;
                    case 3: goto L100;
                    case 4: goto L98;
                    case 5: goto L96;
                    case 6: goto L94;
                    case 7: goto L92;
                    case 8: goto L90;
                    case 9: goto L88;
                    case 10: goto L86;
                    case 11: goto L84;
                    case 12: goto L82;
                    case 13: goto L80;
                    case 14: goto L78;
                    case 15: goto L76;
                    case 16: goto L74;
                    case 17: goto L72;
                    case 18: goto L70;
                    case 19: goto L68;
                    case 20: goto L66;
                    case 21: goto L64;
                    case 22: goto L62;
                    case 23: goto L60;
                    case 24: goto L58;
                    case 25: goto L56;
                    case 26: goto L54;
                    case 27: goto L52;
                    case 28: goto L50;
                    case 29: goto L48;
                    case 30: goto L46;
                    case 31: goto L44;
                    case 32: goto L42;
                    case 33: goto L40;
                    case 34: goto L38;
                    case 35: goto L36;
                    case 36: goto L34;
                    case 37: goto L32;
                    case 38: goto L30;
                    case 39: goto L28;
                    case 40: goto L26;
                    case 41: goto L24;
                    case 42: goto L22;
                    case 43: goto L20;
                    case 44: goto L18;
                    case 45: goto L16;
                    case 46: goto L14;
                    case 47: goto L12;
                    case 48: goto L10;
                    case 49: goto L8;
                    case 50: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return DELETION;
            L8:
                return ADDITION;
            L10:
                return TEMPLATE_VARIABLE;
            L12:
                return TEMPLATE_TAG;
            L14:
                return SELECTOR_PSEUDO;
            L16:
                return SELECTOR_ATTR;
            L18:
                return SELECTOR_CLASS;
            L20:
                return SELECTOR_ID;
            L22:
                return SELECTOR_TAG;
            L24:
                return QUOTE;
            L26:
                return LINK;
            L28:
                return FORMULA;
            L30:
                return EMPHASIS;
            L32:
                return CODE;
            L34:
                return BULLET;
            L36:
                return ATTRIBUTE;
            L38:
                return ATTR;
            L40:
                return NAME;
            L42:
                return TAG;
            L44:
                return SECTION;
            L46:
                return META_STRING;
            L48:
                return META_KEYWORD;
            L50:
                return META_PROMPT;
            L52:
                return META;
            L54:
                return DOCTAG;
            L56:
                return COMMENT;
            L58:
                return PARAMS;
            L60:
                return TITLE_FUNCTION_INVOKE;
            L62:
                return TITLE_FUNCTION;
            L64:
                return TITLE_CLASS_INHERITED;
            L66:
                return TITLE_CLASS;
            L68:
                return TITLE;
            L70:
                return VARIABLE_CONSTANT;
            L72:
                return VARIABLE_LANGUAGE;
            L74:
                return VARIABLE;
            L76:
                return FUNCTION;
            L78:
                return CLASS;
            L80:
                return SYMBOL;
            L82:
                return SUBST;
            L84:
                return CHAR_ESCAPE;
            L86:
                return STRING;
            L88:
                return REGEXP;
            L90:
                return PROPERTY;
            L92:
                return PUNCTUATION;
            L94:
                return OPERATOR;
            L96:
                return NUMBER;
            L98:
                return LITERAL;
            L100:
                return TYPE;
            L102:
                return BUILT_IN;
            L104:
                return KEYWORD;
            L106:
                return TEXT;
            }

            public static ContentType valueOf(String r100) {
                return (ContentType) a.a(ContentType.class, r100);
            }

            private ContentType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final enum Language extends Enum<Language> implements WireEnum {
            private static final /* synthetic */ Language[] $VALUES = null;
            public static final Language ABAP = null;
            public static final Language ADA = null;
            public static final ProtoAdapter<Language> ADAPTER = null;
            public static final Language APACHE = null;
            public static final Language APEX = null;
            public static final Language ASSEMBLY = null;
            public static final Language BASH = null;
            public static final Language C = null;
            public static final Language CMAKE = null;
            public static final Language COBOL = null;
            public static final Language COFFEE_SCRIPT = null;
            public static final Language CPP = null;
            public static final Language CSS = null;
            public static final Language C_SHARP = null;
            public static final Language D = null;
            public static final Language DART = null;
            public static final Language DELPHI = null;
            public static final Language DIFF = null;
            public static final Language DJANGO = null;
            public static final Language DOCKER_FILE = null;
            public static final Language ERLANG = null;
            public static final Language FORTRAN = null;
            public static final Language GHERKIN = null;
            public static final Language GO = null;
            public static final Language GRAPHQL = null;
            public static final Language GROOVY = null;
            public static final Language HASKELL = null;
            public static final Language HTML = null;
            public static final Language HTMLBARS = null;
            public static final Language HTTP = null;
            public static final Language JAVA = null;
            public static final Language JAVASCRIPT = null;
            public static final Language JSON = null;
            public static final Language JULIA = null;
            public static final Language KOTLIN = null;
            public static final Language LATEX = null;
            public static final Language LISP = null;
            public static final Language LUA = null;
            public static final Language MAKEFILE = null;
            public static final Language MARKDOWN = null;
            public static final Language MATLAB = null;
            public static final Language NGINX = null;
            public static final Language OBJECTIVE_C = null;
            public static final Language OPENGL_SHADING_LANGUAGE = null;
            public static final Language PERL = null;
            public static final Language PHP = null;
            public static final Language PLAIN_TEXT = null;
            public static final Language POWERSHELL = null;
            public static final Language PROLOG = null;
            public static final Language PROPERTIES = null;
            public static final Language PROTOBUF = null;
            public static final Language PYTHON = null;
            public static final Language R = null;
            public static final Language RUBY = null;
            public static final Language RUST = null;
            public static final Language SAS = null;
            public static final Language SCALA = null;
            public static final Language SCHEME = null;
            public static final Language SCSS = null;
            public static final Language SHELL = null;
            public static final Language SOLIDITY = null;
            public static final Language SQL = null;
            public static final Language SWIFT = null;
            public static final Language THRIFT = null;
            public static final Language TOML = null;
            public static final Language TYPESCRIPT = null;
            public static final Language VBSCRIPT = null;
            public static final Language VISUAL_BASIC = null;
            public static final Language XML = null;
            public static final Language YAML = null;
            private final int value;

            static {
                Language r100 = new Language("PLAIN_TEXT", 0, 0);
                PLAIN_TEXT = r100;
                Language r101 = new Language("ABAP", 1, 1);
                ABAP = r101;
                Language r102 = new Language("ADA", 2, 2);
                ADA = r102;
                Language r103 = new Language("APACHE", 3, 3);
                APACHE = r103;
                Language r104 = new Language("APEX", 4, 4);
                APEX = r104;
                Language r105 = new Language("ASSEMBLY", 5, 5);
                ASSEMBLY = r105;
                Language r110 = new Language("BASH", 6, 6);
                BASH = r110;
                Language r111 = new Language("C_SHARP", 7, 7);
                C_SHARP = r111;
                Language r112 = new Language("CPP", 8, 8);
                CPP = r112;
                Language r113 = new Language("C", 9, 9);
                C = r113;
                Language r114 = new Language("CMAKE", 10, 10);
                CMAKE = r114;
                Language r115 = new Language("COBOL", 11, 11);
                COBOL = r115;
                Language r106 = new Language("CSS", 12, 12);
                CSS = r106;
                Language r107 = new Language("COFFEE_SCRIPT", 13, 13);
                COFFEE_SCRIPT = r107;
                Language r108 = new Language("D", 14, 14);
                D = r108;
                Language r109 = new Language("DART", 15, 15);
                DART = r109;
                Language r116 = new Language("DELPHI", 16, 16);
                DELPHI = r116;
                Language r117 = new Language("DIFF", 17, 17);
                DIFF = r117;
                Language r118 = new Language("DJANGO", 18, 18);
                DJANGO = r118;
                Language r119 = new Language("DOCKER_FILE", 19, 19);
                DOCKER_FILE = r119;
                Language r120 = new Language("ERLANG", 20, 20);
                ERLANG = r120;
                Language r121 = new Language("FORTRAN", 21, 21);
                FORTRAN = r121;
                Language r122 = new Language("GHERKIN", 22, 22);
                GHERKIN = r122;
                Language r123 = new Language("GO", 23, 23);
                GO = r123;
                Language r124 = new Language("GRAPHQL", 24, 24);
                GRAPHQL = r124;
                Language r125 = new Language("GROOVY", 25, 25);
                GROOVY = r125;
                Language r126 = new Language("HTML", 26, 26);
                HTML = r126;
                Language r127 = new Language("HTMLBARS", 27, 27);
                HTMLBARS = r127;
                Language r128 = new Language("HTTP", 28, 28);
                HTTP = r128;
                Language r129 = new Language("HASKELL", 29, 29);
                HASKELL = r129;
                Language r130 = new Language("JSON", 30, 30);
                JSON = r130;
                Language r131 = new Language("JAVA", 31, 31);
                JAVA = r131;
                Language r132 = new Language("JAVASCRIPT", 32, 32);
                JAVASCRIPT = r132;
                Language r133 = new Language("JULIA", 33, 33);
                JULIA = r133;
                Language r134 = new Language("KOTLIN", 34, 34);
                KOTLIN = r134;
                Language r135 = new Language("LATEX", 35, 35);
                LATEX = r135;
                Language r136 = new Language("LISP", 36, 36);
                LISP = r136;
                Language r137 = new Language("LUA", 37, 37);
                LUA = r137;
                Language r138 = new Language("MATLAB", 38, 38);
                MATLAB = r138;
                Language r139 = new Language("MAKEFILE", 39, 39);
                MAKEFILE = r139;
                Language r140 = new Language("MARKDOWN", 40, 40);
                MARKDOWN = r140;
                Language r141 = new Language("NGINX", 41, 41);
                NGINX = r141;
                Language r142 = new Language("OBJECTIVE_C", 42, 42);
                OBJECTIVE_C = r142;
                Language r143 = new Language("OPENGL_SHADING_LANGUAGE", 43, 43);
                OPENGL_SHADING_LANGUAGE = r143;
                Language r144 = new Language("PHP", 44, 44);
                PHP = r144;
                Language r145 = new Language("PERL", 45, 45);
                PERL = r145;
                Language r146 = new Language("POWERSHELL", 46, 46);
                POWERSHELL = r146;
                Language r147 = new Language("PROLOG", 47, 47);
                PROLOG = r147;
                Language r148 = new Language("PROPERTIES", 48, 48);
                PROPERTIES = r148;
                Language r149 = new Language("PROTOBUF", 49, 49);
                PROTOBUF = r149;
                Language r150 = new Language("PYTHON", 50, 50);
                PYTHON = r150;
                Language r151 = new Language("R", 51, 51);
                R = r151;
                Language r152 = new Language("RUBY", 52, 52);
                RUBY = r152;
                Language r153 = new Language("RUST", 53, 53);
                RUST = r153;
                Language r154 = new Language("SAS", 54, 54);
                SAS = r154;
                Language r155 = new Language("SCSS", 55, 55);
                SCSS = r155;
                Language r156 = new Language("SQL", 56, 56);
                SQL = r156;
                Language r157 = new Language("SCALA", 57, 57);
                SCALA = r157;
                Language r158 = new Language("SCHEME", 58, 58);
                SCHEME = r158;
                Language r159 = new Language("SHELL", 59, 59);
                SHELL = r159;
                Language r160 = new Language("SOLIDITY", 60, 60);
                SOLIDITY = r160;
                Language r161 = new Language("SWIFT", 61, 61);
                SWIFT = r161;
                Language r162 = new Language("TOML", 62, 62);
                TOML = r162;
                Language r163 = new Language("THRIFT", 63, 63);
                THRIFT = r163;
                Language r164 = new Language("TYPESCRIPT", 64, 64);
                TYPESCRIPT = r164;
                Language r165 = new Language("VBSCRIPT", 65, 65);
                VBSCRIPT = r165;
                Language r166 = new Language("VISUAL_BASIC", 66, 66);
                VISUAL_BASIC = r166;
                Language r167 = new Language("XML", 67, 67);
                XML = r167;
                Language r168 = new Language("YAML", 68, 68);
                YAML = r168;
                $VALUES = new Language[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168};
                ADAPTER = ProtoAdapter.newEnumAdapter(Language.class);
            }

            public static Language[] values() {
                return (Language[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Language fromValue(int r100) {
                switch(r100) {
                    case 0: goto L142;
                    case 1: goto L140;
                    case 2: goto L138;
                    case 3: goto L136;
                    case 4: goto L134;
                    case 5: goto L132;
                    case 6: goto L130;
                    case 7: goto L128;
                    case 8: goto L126;
                    case 9: goto L124;
                    case 10: goto L122;
                    case 11: goto L120;
                    case 12: goto L118;
                    case 13: goto L116;
                    case 14: goto L114;
                    case 15: goto L112;
                    case 16: goto L110;
                    case 17: goto L108;
                    case 18: goto L106;
                    case 19: goto L104;
                    case 20: goto L102;
                    case 21: goto L100;
                    case 22: goto L98;
                    case 23: goto L96;
                    case 24: goto L94;
                    case 25: goto L92;
                    case 26: goto L90;
                    case 27: goto L88;
                    case 28: goto L86;
                    case 29: goto L84;
                    case 30: goto L82;
                    case 31: goto L80;
                    case 32: goto L78;
                    case 33: goto L76;
                    case 34: goto L74;
                    case 35: goto L72;
                    case 36: goto L70;
                    case 37: goto L68;
                    case 38: goto L66;
                    case 39: goto L64;
                    case 40: goto L62;
                    case 41: goto L60;
                    case 42: goto L58;
                    case 43: goto L56;
                    case 44: goto L54;
                    case 45: goto L52;
                    case 46: goto L50;
                    case 47: goto L48;
                    case 48: goto L46;
                    case 49: goto L44;
                    case 50: goto L42;
                    case 51: goto L40;
                    case 52: goto L38;
                    case 53: goto L36;
                    case 54: goto L34;
                    case 55: goto L32;
                    case 56: goto L30;
                    case 57: goto L28;
                    case 58: goto L26;
                    case 59: goto L24;
                    case 60: goto L22;
                    case 61: goto L20;
                    case 62: goto L18;
                    case 63: goto L16;
                    case 64: goto L14;
                    case 65: goto L12;
                    case 66: goto L10;
                    case 67: goto L8;
                    case 68: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return YAML;
            L8:
                return XML;
            L10:
                return VISUAL_BASIC;
            L12:
                return VBSCRIPT;
            L14:
                return TYPESCRIPT;
            L16:
                return THRIFT;
            L18:
                return TOML;
            L20:
                return SWIFT;
            L22:
                return SOLIDITY;
            L24:
                return SHELL;
            L26:
                return SCHEME;
            L28:
                return SCALA;
            L30:
                return SQL;
            L32:
                return SCSS;
            L34:
                return SAS;
            L36:
                return RUST;
            L38:
                return RUBY;
            L40:
                return R;
            L42:
                return PYTHON;
            L44:
                return PROTOBUF;
            L46:
                return PROPERTIES;
            L48:
                return PROLOG;
            L50:
                return POWERSHELL;
            L52:
                return PERL;
            L54:
                return PHP;
            L56:
                return OPENGL_SHADING_LANGUAGE;
            L58:
                return OBJECTIVE_C;
            L60:
                return NGINX;
            L62:
                return MARKDOWN;
            L64:
                return MAKEFILE;
            L66:
                return MATLAB;
            L68:
                return LUA;
            L70:
                return LISP;
            L72:
                return LATEX;
            L74:
                return KOTLIN;
            L76:
                return JULIA;
            L78:
                return JAVASCRIPT;
            L80:
                return JAVA;
            L82:
                return JSON;
            L84:
                return HASKELL;
            L86:
                return HTTP;
            L88:
                return HTMLBARS;
            L90:
                return HTML;
            L92:
                return GROOVY;
            L94:
                return GRAPHQL;
            L96:
                return GO;
            L98:
                return GHERKIN;
            L100:
                return FORTRAN;
            L102:
                return ERLANG;
            L104:
                return DOCKER_FILE;
            L106:
                return DJANGO;
            L108:
                return DIFF;
            L110:
                return DELPHI;
            L112:
                return DART;
            L114:
                return D;
            L116:
                return COFFEE_SCRIPT;
            L118:
                return CSS;
            L120:
                return COBOL;
            L122:
                return CMAKE;
            L124:
                return C;
            L126:
                return CPP;
            L128:
                return C_SHARP;
            L130:
                return BASH;
            L132:
                return ASSEMBLY;
            L134:
                return APEX;
            L136:
                return APACHE;
            L138:
                return ADA;
            L140:
                return ABAP;
            L142:
                return PLAIN_TEXT;
            }

            public static Language valueOf(String r100) {
                return (Language) a.a(Language.class, r100);
            }

            private Language(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class LineContent extends com.squareup.wire.Message<LineContent, Builder> {
            public static final ProtoAdapter<LineContent> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final List<Content> contents;

            public static final class Builder extends com.squareup.wire.Message.Builder<LineContent, Builder> {
                public List<Content> contents;

                @Override // com.squareup.wire.Message.Builder
                public LineContent build() {
                    return new LineContent(this.contents, super.buildUnknownFields());
                }

                public Builder() {
                    this.contents = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder contents(List<Content> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.contents = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_LineContent extends ProtoAdapter<LineContent> {
                public ProtoAdapter_LineContent() {
                    super(FieldEncoding.LENGTH_DELIMITED, LineContent.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public LineContent decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.contents.add(Content.ADAPTER.decode(r100));
                    goto L3
                L7:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L9:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(LineContent r100) {
                    return Content.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.contents) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ LineContent decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(LineContent r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, LineContent r101) throws IOException {
                    Content.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.contents);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LineContent r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_LineContent();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.contents = Internal.copyOf("contents", this.contents);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return LineContent.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public LineContent(List<Content> r100) {
                this(r100, ByteString.EMPTY);
            }

            public LineContent(List<Content> r100, ByteString r101) {
                super(ADAPTER, r101);
                this.contents = Internal.immutableCopyOf("contents", r100);
            }
        }

        public static final class ProtoAdapter_CodeBlockV2Property extends ProtoAdapter<CodeBlockV2Property> {
            public ProtoAdapter_CodeBlockV2Property() {
                super(FieldEncoding.LENGTH_DELIMITED, CodeBlockV2Property.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CodeBlockV2Property decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.language = Language.PLAIN_TEXT;
                r101.word_wrap = Boolean.FALSE;
                r101.version = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.language = Language.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.contents.add(LineContent.ADAPTER.decode(r100));
                goto L3
            L10:
                if (r103 != 4) goto L12;
                r101.word_wrap = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                if (r103 != 5) goto L13;
                r101.version = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(CodeBlockV2Property r100) {
                Language r101 = r100.language;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Language.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                int r104 = r103 + LineContent.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.contents);
                Boolean r105 = r100.word_wrap;
                if (r105 == null) goto L9;
                int r106 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r105);
            L10:
                int r107 = r104 + r106;
                Integer r108 = r100.version;
                if (r108 == null) goto L14;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(5, r108);
            L14:
                return (r107 + r102) + r100.unknownFields().size();
            L9:
                r106 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CodeBlockV2Property decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CodeBlockV2Property r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CodeBlockV2Property r101) throws IOException {
                Language r102 = r101.language;
                if (r102 == null) goto L5;
                Language.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                LineContent.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.contents);
                Boolean r103 = r101.word_wrap;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
            L8:
                Integer r104 = r101.version;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 5, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CodeBlockV2Property r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CodeBlockV2Property();
            DEFAULT_LANGUAGE = Language.PLAIN_TEXT;
            DEFAULT_WORD_WRAP = Boolean.FALSE;
            DEFAULT_VERSION = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.language = this.language;
            r100.contents = Internal.copyOf("contents", this.contents);
            r100.word_wrap = this.word_wrap;
            r100.version = this.version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CodeBlockV2Property.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CodeBlockV2Property(Language r100, List<LineContent> r101, Boolean r102, Integer r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public CodeBlockV2Property(Language r100, List<LineContent> r101, Boolean r102, Integer r103, ByteString r104) {
            super(ADAPTER, r104);
            this.language = r100;
            this.contents = Internal.immutableCopyOf("contents", r101);
            this.word_wrap = r102;
            this.version = r103;
        }
    }

    public static final class CodeProperty extends com.squareup.wire.Message<CodeProperty, Builder> {
        public static final ProtoAdapter<CodeProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<CodeProperty, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public CodeProperty build() {
                return new CodeProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_CodeProperty extends ProtoAdapter<CodeProperty> {
            public ProtoAdapter_CodeProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, CodeProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CodeProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CodeProperty r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CodeProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CodeProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CodeProperty r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CodeProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CodeProperty();
        }

        public CodeProperty() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CodeProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public CodeProperty(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class ColumnProperty extends com.squareup.wire.Message<ColumnProperty, Builder> {
        public static final ProtoAdapter<ColumnProperty> ADAPTER = null;
        public static final Integer DEFAULT_WIDTH = null;
        private static final long serialVersionUID = 0;
        public final Integer width;

        public static final class Builder extends com.squareup.wire.Message.Builder<ColumnProperty, Builder> {
            public Integer width;

            @Override // com.squareup.wire.Message.Builder
            public ColumnProperty build() {
                return new ColumnProperty(this.width, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder width(Integer r100) {
                this.width = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ColumnProperty extends ProtoAdapter<ColumnProperty> {
            public ProtoAdapter_ColumnProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ColumnProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ColumnProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.width = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.width = ProtoAdapter.INT32.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ColumnProperty r100) {
                Integer r101 = r100.width;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ColumnProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ColumnProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ColumnProperty r101) throws IOException {
                Integer r102 = r101.width;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ColumnProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ColumnProperty();
            DEFAULT_WIDTH = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.width = this.width;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ColumnProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ColumnProperty(Integer r100) {
            this(r100, ByteString.EMPTY);
        }

        public ColumnProperty(Integer r100, ByteString r101) {
            super(ADAPTER, r101);
            this.width = r100;
        }
    }

    public static final class ColumnsProperty extends com.squareup.wire.Message<ColumnsProperty, Builder> {
        public static final ProtoAdapter<ColumnsProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ColumnsProperty, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public ColumnsProperty build() {
                return new ColumnsProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_ColumnsProperty extends ProtoAdapter<ColumnsProperty> {
            public ProtoAdapter_ColumnsProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ColumnsProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ColumnsProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ColumnsProperty r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ColumnsProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ColumnsProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ColumnsProperty r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ColumnsProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ColumnsProperty();
        }

        public ColumnsProperty() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ColumnsProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ColumnsProperty(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class DatePickerProperty extends com.squareup.wire.Message<DatePickerProperty, Builder> {
        public static final ProtoAdapter<DatePickerProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final Boolean DEFAULT_DISABLE = null;
        public static final String DEFAULT_INITIAL_DATE = "";
        public static final Boolean DEFAULT_IS_LOADING = null;
        public static final String DEFAULT_PLACE_HOLDER = "";
        public static final String DEFAULT_PLACE_HOLDER_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String action_id;
        public final ButtonConfirmProperty confirm;
        public final Boolean disable;
        public final String initial_date;
        public final Boolean is_loading;
        public final String place_holder;
        public final String place_holder_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<DatePickerProperty, Builder> {
            public String action_id;
            public ButtonConfirmProperty confirm;
            public Boolean disable;
            public String initial_date;
            public Boolean is_loading;
            public String place_holder;
            public String place_holder_i18n_key;

            @Override // com.squareup.wire.Message.Builder
            public DatePickerProperty build() {
                return new DatePickerProperty(this.action_id, this.place_holder, this.place_holder_i18n_key, this.initial_date, this.confirm, this.disable, this.is_loading, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.action_id = r100;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r100) {
                this.confirm = r100;
                return this;
            }

            public Builder disable(Boolean r100) {
                this.disable = r100;
                return this;
            }

            public Builder initial_date(String r100) {
                this.initial_date = r100;
                return this;
            }

            public Builder is_loading(Boolean r100) {
                this.is_loading = r100;
                return this;
            }

            public Builder place_holder(String r100) {
                this.place_holder = r100;
                return this;
            }

            public Builder place_holder_i18n_key(String r100) {
                this.place_holder_i18n_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DatePickerProperty extends ProtoAdapter<DatePickerProperty> {
            public ProtoAdapter_DatePickerProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, DatePickerProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DatePickerProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.action_id = "";
                r101.place_holder = "";
                r101.place_holder_i18n_key = "";
                r101.initial_date = "";
                Boolean r102 = Boolean.FALSE;
                r101.disable = r102;
                r101.is_loading = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L14;
                switch(r104) {
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
                r101.is_loading = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.disable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.confirm = ButtonConfirmProperty.ADAPTER.decode(r100);
                goto L3
            L10:
                r101.initial_date = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.place_holder_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.place_holder = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L14:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DatePickerProperty r100) {
                String r101 = r100.action_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.place_holder;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.place_holder_i18n_key;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.initial_date;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                ButtonConfirmProperty r113 = r100.confirm;
                if (r113 == null) goto L21;
                int r114 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.disable;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Boolean r119 = r100.is_loading;
                if (r119 == null) goto L30;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
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
            public /* bridge */ /* synthetic */ DatePickerProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DatePickerProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DatePickerProperty r101) throws IOException {
                String r102 = r101.action_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.place_holder;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.place_holder_i18n_key;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.initial_date;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                ButtonConfirmProperty r106 = r101.confirm;
                if (r106 == null) goto L17;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.disable;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                Boolean r108 = r101.is_loading;
                if (r108 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DatePickerProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DatePickerProperty();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_DISABLE = r100;
            DEFAULT_IS_LOADING = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.action_id = this.action_id;
            r100.place_holder = this.place_holder;
            r100.place_holder_i18n_key = this.place_holder_i18n_key;
            r100.initial_date = this.initial_date;
            r100.confirm = this.confirm;
            r100.disable = this.disable;
            r100.is_loading = this.is_loading;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DatePickerProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DatePickerProperty(String r110, String r111, String r112, String r113, ButtonConfirmProperty r114, Boolean r115, Boolean r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public DatePickerProperty(String r100, String r101, String r102, String r103, ButtonConfirmProperty r104, Boolean r105, Boolean r106, ByteString r107) {
            super(ADAPTER, r107);
            this.action_id = r100;
            this.place_holder = r101;
            this.place_holder_i18n_key = r102;
            this.initial_date = r103;
            this.confirm = r104;
            this.disable = r105;
            this.is_loading = r106;
        }
    }

    public static final class DatetimePickerProperty extends com.squareup.wire.Message<DatetimePickerProperty, Builder> {
        public static final ProtoAdapter<DatetimePickerProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final Boolean DEFAULT_DISABLE = null;
        public static final String DEFAULT_INITIAL_DATETIME = "";
        public static final Boolean DEFAULT_IS_LOADING = null;
        public static final String DEFAULT_PLACE_HOLDER = "";
        public static final String DEFAULT_PLACE_HOLDER_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String action_id;
        public final ButtonConfirmProperty confirm;
        public final Boolean disable;
        public final String initial_datetime;
        public final Boolean is_loading;
        public final String place_holder;
        public final String place_holder_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<DatetimePickerProperty, Builder> {
            public String action_id;
            public ButtonConfirmProperty confirm;
            public Boolean disable;
            public String initial_datetime;
            public Boolean is_loading;
            public String place_holder;
            public String place_holder_i18n_key;

            @Override // com.squareup.wire.Message.Builder
            public DatetimePickerProperty build() {
                return new DatetimePickerProperty(this.action_id, this.place_holder, this.place_holder_i18n_key, this.initial_datetime, this.confirm, this.disable, this.is_loading, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.action_id = r100;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r100) {
                this.confirm = r100;
                return this;
            }

            public Builder disable(Boolean r100) {
                this.disable = r100;
                return this;
            }

            public Builder initial_datetime(String r100) {
                this.initial_datetime = r100;
                return this;
            }

            public Builder is_loading(Boolean r100) {
                this.is_loading = r100;
                return this;
            }

            public Builder place_holder(String r100) {
                this.place_holder = r100;
                return this;
            }

            public Builder place_holder_i18n_key(String r100) {
                this.place_holder_i18n_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DatetimePickerProperty extends ProtoAdapter<DatetimePickerProperty> {
            public ProtoAdapter_DatetimePickerProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, DatetimePickerProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DatetimePickerProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.action_id = "";
                r101.place_holder = "";
                r101.place_holder_i18n_key = "";
                r101.initial_datetime = "";
                Boolean r102 = Boolean.FALSE;
                r101.disable = r102;
                r101.is_loading = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L14;
                switch(r104) {
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
                r101.is_loading = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.disable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.confirm = ButtonConfirmProperty.ADAPTER.decode(r100);
                goto L3
            L10:
                r101.initial_datetime = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.place_holder_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.place_holder = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L14:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DatetimePickerProperty r100) {
                String r101 = r100.action_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.place_holder;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.place_holder_i18n_key;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.initial_datetime;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                ButtonConfirmProperty r113 = r100.confirm;
                if (r113 == null) goto L21;
                int r114 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.disable;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Boolean r119 = r100.is_loading;
                if (r119 == null) goto L30;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
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
            public /* bridge */ /* synthetic */ DatetimePickerProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DatetimePickerProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DatetimePickerProperty r101) throws IOException {
                String r102 = r101.action_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.place_holder;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.place_holder_i18n_key;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.initial_datetime;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                ButtonConfirmProperty r106 = r101.confirm;
                if (r106 == null) goto L17;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.disable;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                Boolean r108 = r101.is_loading;
                if (r108 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DatetimePickerProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DatetimePickerProperty();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_DISABLE = r100;
            DEFAULT_IS_LOADING = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.action_id = this.action_id;
            r100.place_holder = this.place_holder;
            r100.place_holder_i18n_key = this.place_holder_i18n_key;
            r100.initial_datetime = this.initial_datetime;
            r100.confirm = this.confirm;
            r100.disable = this.disable;
            r100.is_loading = this.is_loading;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DatetimePickerProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DatetimePickerProperty(String r110, String r111, String r112, String r113, ButtonConfirmProperty r114, Boolean r115, Boolean r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public DatetimePickerProperty(String r100, String r101, String r102, String r103, ButtonConfirmProperty r104, Boolean r105, Boolean r106, ByteString r107) {
            super(ADAPTER, r107);
            this.action_id = r100;
            this.place_holder = r101;
            this.place_holder_i18n_key = r102;
            this.initial_datetime = r103;
            this.confirm = r104;
            this.disable = r105;
            this.is_loading = r106;
        }
    }

    public static final class DivProperty extends com.squareup.wire.Message<DivProperty, Builder> {
        public static final ProtoAdapter<DivProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<DivProperty, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public DivProperty build() {
                return new DivProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_DivProperty extends ProtoAdapter<DivProperty> {
            public ProtoAdapter_DivProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, DivProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DivProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DivProperty r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DivProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DivProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DivProperty r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DivProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DivProperty();
        }

        public DivProperty() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DivProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DivProperty(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class DocsProperty extends com.squareup.wire.Message<DocsProperty, Builder> {
        public static final ProtoAdapter<DocsProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<DocsProperty, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public DocsProperty build() {
                return new DocsProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_DocsProperty extends ProtoAdapter<DocsProperty> {
            public ProtoAdapter_DocsProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, DocsProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DocsProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DocsProperty r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DocsProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DocsProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DocsProperty r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocsProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocsProperty();
        }

        public DocsProperty() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DocsProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DocsProperty(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class EmotionProperty extends com.squareup.wire.Message<EmotionProperty, Builder> {
        public static final ProtoAdapter<EmotionProperty> ADAPTER = null;
        public static final String DEFAULT_KEY = "";
        private static final long serialVersionUID = 0;
        public final String key;

        public static final class Builder extends com.squareup.wire.Message.Builder<EmotionProperty, Builder> {
            public String key;

            @Override // com.squareup.wire.Message.Builder
            public EmotionProperty build() {
                String r100 = this.key;
                if (r100 == null) goto L7;
                return new EmotionProperty(this.key, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "key"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder key(String r100) {
                this.key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_EmotionProperty extends ProtoAdapter<EmotionProperty> {
            public ProtoAdapter_EmotionProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, EmotionProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EmotionProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(EmotionProperty r100) {
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.key) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ EmotionProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(EmotionProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, EmotionProperty r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.key);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EmotionProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EmotionProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.key = this.key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return EmotionProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public EmotionProperty(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public EmotionProperty(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.key = r100;
        }
    }

    public static final class FigureProperty extends com.squareup.wire.Message<FigureProperty, Builder> {
        public static final ProtoAdapter<FigureProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<FigureProperty, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public FigureProperty build() {
                return new FigureProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_FigureProperty extends ProtoAdapter<FigureProperty> {
            public ProtoAdapter_FigureProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, FigureProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FigureProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(FigureProperty r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ FigureProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FigureProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FigureProperty r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FigureProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FigureProperty();
        }

        public FigureProperty() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FigureProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public FigureProperty(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class H1Property extends com.squareup.wire.Message<H1Property, Builder> {
        public static final ProtoAdapter<H1Property> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<H1Property, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public H1Property build() {
                return new H1Property(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_H1Property extends ProtoAdapter<H1Property> {
            public ProtoAdapter_H1Property() {
                super(FieldEncoding.LENGTH_DELIMITED, H1Property.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public H1Property decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(H1Property r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ H1Property decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(H1Property r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, H1Property r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, H1Property r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_H1Property();
        }

        public H1Property() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return H1Property.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public H1Property(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class H2Property extends com.squareup.wire.Message<H2Property, Builder> {
        public static final ProtoAdapter<H2Property> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<H2Property, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public H2Property build() {
                return new H2Property(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_H2Property extends ProtoAdapter<H2Property> {
            public ProtoAdapter_H2Property() {
                super(FieldEncoding.LENGTH_DELIMITED, H2Property.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public H2Property decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(H2Property r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ H2Property decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(H2Property r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, H2Property r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, H2Property r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_H2Property();
        }

        public H2Property() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return H2Property.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public H2Property(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class H3Property extends com.squareup.wire.Message<H3Property, Builder> {
        public static final ProtoAdapter<H3Property> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<H3Property, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public H3Property build() {
                return new H3Property(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_H3Property extends ProtoAdapter<H3Property> {
            public ProtoAdapter_H3Property() {
                super(FieldEncoding.LENGTH_DELIMITED, H3Property.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public H3Property decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(H3Property r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ H3Property decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(H3Property r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, H3Property r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, H3Property r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_H3Property();
        }

        public H3Property() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return H3Property.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public H3Property(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class H4Property extends com.squareup.wire.Message<H4Property, Builder> {
        public static final ProtoAdapter<H4Property> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<H4Property, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public H4Property build() {
                return new H4Property(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_H4Property extends ProtoAdapter<H4Property> {
            public ProtoAdapter_H4Property() {
                super(FieldEncoding.LENGTH_DELIMITED, H4Property.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public H4Property decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(H4Property r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ H4Property decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(H4Property r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, H4Property r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, H4Property r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_H4Property();
        }

        public H4Property() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return H4Property.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public H4Property(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class H5Property extends com.squareup.wire.Message<H5Property, Builder> {
        public static final ProtoAdapter<H5Property> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<H5Property, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public H5Property build() {
                return new H5Property(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_H5Property extends ProtoAdapter<H5Property> {
            public ProtoAdapter_H5Property() {
                super(FieldEncoding.LENGTH_DELIMITED, H5Property.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public H5Property decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(H5Property r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ H5Property decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(H5Property r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, H5Property r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, H5Property r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_H5Property();
        }

        public H5Property() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return H5Property.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public H5Property(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class H6Property extends com.squareup.wire.Message<H6Property, Builder> {
        public static final ProtoAdapter<H6Property> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<H6Property, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public H6Property build() {
                return new H6Property(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_H6Property extends ProtoAdapter<H6Property> {
            public ProtoAdapter_H6Property() {
                super(FieldEncoding.LENGTH_DELIMITED, H6Property.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public H6Property decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(H6Property r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ H6Property decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(H6Property r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, H6Property r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, H6Property r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_H6Property();
        }

        public H6Property() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return H6Property.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public H6Property(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class HRProperty extends com.squareup.wire.Message<HRProperty, Builder> {
        public static final ProtoAdapter<HRProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<HRProperty, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public HRProperty build() {
                return new HRProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_HRProperty extends ProtoAdapter<HRProperty> {
            public ProtoAdapter_HRProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, HRProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public HRProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(HRProperty r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ HRProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(HRProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, HRProperty r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HRProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_HRProperty();
        }

        public HRProperty() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return HRProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public HRProperty(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final enum HorizontalAlign extends Enum<HorizontalAlign> implements WireEnum {
        private static final /* synthetic */ HorizontalAlign[] $VALUES = null;
        public static final ProtoAdapter<HorizontalAlign> ADAPTER = null;
        public static final HorizontalAlign HORIZONTAL_ALIGN_CENTER = null;
        public static final HorizontalAlign HORIZONTAL_ALIGN_LEFT = null;
        public static final HorizontalAlign HORIZONTAL_ALIGN_RIGHT = null;
        public static final HorizontalAlign HORIZONTAL_ALIGN_UNKNOWN = null;
        private final int value;

        static {
            HorizontalAlign r100 = new HorizontalAlign("HORIZONTAL_ALIGN_UNKNOWN", 0, 0);
            HORIZONTAL_ALIGN_UNKNOWN = r100;
            HorizontalAlign r101 = new HorizontalAlign("HORIZONTAL_ALIGN_LEFT", 1, 1);
            HORIZONTAL_ALIGN_LEFT = r101;
            HorizontalAlign r102 = new HorizontalAlign("HORIZONTAL_ALIGN_CENTER", 2, 2);
            HORIZONTAL_ALIGN_CENTER = r102;
            HorizontalAlign r103 = new HorizontalAlign("HORIZONTAL_ALIGN_RIGHT", 3, 3);
            HORIZONTAL_ALIGN_RIGHT = r103;
            $VALUES = new HorizontalAlign[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(HorizontalAlign.class);
        }

        public static HorizontalAlign[] values() {
            return (HorizontalAlign[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static HorizontalAlign fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return HORIZONTAL_ALIGN_RIGHT;
        L14:
            return HORIZONTAL_ALIGN_CENTER;
        L16:
            return HORIZONTAL_ALIGN_LEFT;
        L18:
            return HORIZONTAL_ALIGN_UNKNOWN;
        }

        public static HorizontalAlign valueOf(String r100) {
            return (HorizontalAlign) a.a(HorizontalAlign.class, r100);
        }

        private HorizontalAlign(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ImageGalleryProperty extends com.squareup.wire.Message<ImageGalleryProperty, Builder> {
        public static final ProtoAdapter<ImageGalleryProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ImageGalleryProperty, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public ImageGalleryProperty build() {
                return new ImageGalleryProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_ImageGalleryProperty extends ProtoAdapter<ImageGalleryProperty> {
            public ProtoAdapter_ImageGalleryProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ImageGalleryProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ImageGalleryProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ImageGalleryProperty r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ImageGalleryProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ImageGalleryProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ImageGalleryProperty r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageGalleryProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ImageGalleryProperty();
        }

        public ImageGalleryProperty() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ImageGalleryProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ImageGalleryProperty(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class ImageProperty extends com.squareup.wire.Message<ImageProperty, Builder> {
        public static final ProtoAdapter<ImageProperty> ADAPTER = null;
        public static final String DEFAULT_ALT = "";
        public static final String DEFAULT_ALT_I18N_KEY = "";
        public static final Integer DEFAULT_CUSTOM_WIDTH = null;
        public static final String DEFAULT_FS_UNIT = "";
        public static final Integer DEFAULT_HEIGHT = null;
        public static final Boolean DEFAULT_IMG_CAN_PREVIEW = null;
        public static final ByteString DEFAULT_INLINE_PREVIEW = null;
        public static final Boolean DEFAULT_IS_ORIGIN_SOURCE = null;
        public static final String DEFAULT_MIDDLE_KEY = "";
        public static final Boolean DEFAULT_NEED_COPY = null;
        public static final Integer DEFAULT_ORIGIN_HEIGHT = null;
        public static final String DEFAULT_ORIGIN_KEY = "";
        public static final Long DEFAULT_ORIGIN_SIZE = null;
        public static final Integer DEFAULT_ORIGIN_WIDTH = null;
        public static final Boolean DEFAULT_RESOURCE_IS_CLEANED = null;
        public static final String DEFAULT_RESOURCE_MSG_LINK_TOKEN = "";
        public static final String DEFAULT_RESOURCE_PREVIEW_TOKEN = "";
        public static final Integer DEFAULT_SHOW_MODE = null;
        public static final String DEFAULT_THUMB_KEY = "";
        public static final String DEFAULT_TOKEN = "";
        public static final String DEFAULT_UPLOAD_ID = "";
        public static final Integer DEFAULT_WIDTH = null;
        private static final long serialVersionUID = 0;
        public final String alt;
        public final String alt_i18n_key;
        public final ResourceCleanScene clean_resource_scene;
        public final Image cover;
        public final Integer custom_width;
        public final String fs_unit;
        public final Integer height;
        public final Boolean img_can_preview;
        public final ByteString inline_preview;
        public final Image intact;
        public final Boolean is_origin_source;
        public final String middle_key;
        public final Image middle_mp4;
        public final Image middle_webp;
        public final Boolean need_copy;
        public final Image origin;
        public final Integer origin_height;
        public final String origin_key;
        public final Long origin_size;
        public final Integer origin_width;
        public final Boolean resource_is_cleaned;
        public final String resource_msg_link_token;
        public final String resource_preview_token;
        public final Integer show_mode;
        public final String thumb_key;
        public final Image thumbnail_webp;
        public final String token;
        public final String upload_id;
        public final List<String> urls;
        public final Integer width;

        public static final class Builder extends com.squareup.wire.Message.Builder<ImageProperty, Builder> {
            public String alt;
            public String alt_i18n_key;
            public ResourceCleanScene clean_resource_scene;
            public Image cover;
            public Integer custom_width;
            public String fs_unit;
            public Integer height;
            public Boolean img_can_preview;
            public ByteString inline_preview;
            public Image intact;
            public Boolean is_origin_source;
            public String middle_key;
            public Image middle_mp4;
            public Image middle_webp;
            public Boolean need_copy;
            public Image origin;
            public Integer origin_height;
            public String origin_key;
            public Long origin_size;
            public Integer origin_width;
            public Boolean resource_is_cleaned;
            public String resource_msg_link_token;
            public String resource_preview_token;
            public Integer show_mode;
            public String thumb_key;
            public Image thumbnail_webp;
            public String token;
            public String upload_id;
            public List<String> urls;
            public Integer width;

            @Override // com.squareup.wire.Message.Builder
            public ImageProperty build() {
                return new ImageProperty(this.urls, this.token, this.origin_key, this.middle_key, this.thumb_key, this.origin_width, this.origin_height, this.fs_unit, this.alt, this.alt_i18n_key, this.img_can_preview, this.thumbnail_webp, this.middle_webp, this.middle_mp4, this.cover, this.custom_width, this.intact, this.is_origin_source, this.origin_size, this.upload_id, this.inline_preview, this.show_mode, this.need_copy, this.origin, this.width, this.height, this.resource_preview_token, this.resource_is_cleaned, this.clean_resource_scene, this.resource_msg_link_token, super.buildUnknownFields());
            }

            public Builder() {
                this.urls = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder alt(String r100) {
                this.alt = r100;
                return this;
            }

            public Builder alt_i18n_key(String r100) {
                this.alt_i18n_key = r100;
                return this;
            }

            public Builder clean_resource_scene(ResourceCleanScene r100) {
                this.clean_resource_scene = r100;
                return this;
            }

            public Builder cover(Image r100) {
                this.cover = r100;
                return this;
            }

            public Builder custom_width(Integer r100) {
                this.custom_width = r100;
                return this;
            }

            public Builder fs_unit(String r100) {
                this.fs_unit = r100;
                return this;
            }

            public Builder height(Integer r100) {
                this.height = r100;
                return this;
            }

            public Builder img_can_preview(Boolean r100) {
                this.img_can_preview = r100;
                return this;
            }

            public Builder inline_preview(ByteString r100) {
                this.inline_preview = r100;
                return this;
            }

            public Builder intact(Image r100) {
                this.intact = r100;
                return this;
            }

            public Builder is_origin_source(Boolean r100) {
                this.is_origin_source = r100;
                return this;
            }

            public Builder middle_key(String r100) {
                this.middle_key = r100;
                return this;
            }

            public Builder middle_mp4(Image r100) {
                this.middle_mp4 = r100;
                return this;
            }

            public Builder middle_webp(Image r100) {
                this.middle_webp = r100;
                return this;
            }

            public Builder need_copy(Boolean r100) {
                this.need_copy = r100;
                return this;
            }

            public Builder origin(Image r100) {
                this.origin = r100;
                return this;
            }

            public Builder origin_height(Integer r100) {
                this.origin_height = r100;
                return this;
            }

            public Builder origin_key(String r100) {
                this.origin_key = r100;
                return this;
            }

            public Builder origin_size(Long r100) {
                this.origin_size = r100;
                return this;
            }

            public Builder origin_width(Integer r100) {
                this.origin_width = r100;
                return this;
            }

            public Builder resource_is_cleaned(Boolean r100) {
                this.resource_is_cleaned = r100;
                return this;
            }

            public Builder resource_msg_link_token(String r100) {
                this.resource_msg_link_token = r100;
                return this;
            }

            public Builder resource_preview_token(String r100) {
                this.resource_preview_token = r100;
                return this;
            }

            public Builder show_mode(Integer r100) {
                this.show_mode = r100;
                return this;
            }

            public Builder thumb_key(String r100) {
                this.thumb_key = r100;
                return this;
            }

            public Builder thumbnail_webp(Image r100) {
                this.thumbnail_webp = r100;
                return this;
            }

            public Builder token(String r100) {
                this.token = r100;
                return this;
            }

            public Builder upload_id(String r100) {
                this.upload_id = r100;
                return this;
            }

            public Builder urls(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.urls = r100;
                return this;
            }

            public Builder width(Integer r100) {
                this.width = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ImageProperty extends ProtoAdapter<ImageProperty> {
            public ProtoAdapter_ImageProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ImageProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ImageProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.token = "";
                r101.origin_key = "";
                r101.middle_key = "";
                r101.thumb_key = "";
                r101.origin_width = 0;
                r101.origin_height = 0;
                r101.fs_unit = "";
                r101.alt = "";
                r101.alt_i18n_key = "";
                Boolean r102 = Boolean.FALSE;
                r101.img_can_preview = r102;
                r101.custom_width = 0;
                r101.is_origin_source = r102;
                r101.origin_size = 0L;
                r101.upload_id = "";
                r101.inline_preview = ByteString.EMPTY;
                r101.show_mode = 0;
                r101.need_copy = r102;
                r101.width = 0;
                r101.height = 0;
                r101.resource_preview_token = "";
                r101.resource_is_cleaned = r102;
                r101.resource_msg_link_token = "";
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L37;
                switch(r104) {
                    case 1: goto L36;
                    case 2: goto L35;
                    case 3: goto L34;
                    case 4: goto L33;
                    case 5: goto L32;
                    case 6: goto L31;
                    case 7: goto L30;
                    case 8: goto L29;
                    case 9: goto L28;
                    case 10: goto L27;
                    case 11: goto L26;
                    case 12: goto L25;
                    case 13: goto L24;
                    case 14: goto L23;
                    case 15: goto L22;
                    case 16: goto L21;
                    case 17: goto L20;
                    case 18: goto L6;
                    case 19: goto L6;
                    case 20: goto L19;
                    case 21: goto L18;
                    case 22: goto L17;
                    case 23: goto L16;
                    case 24: goto L15;
                    case 25: goto L14;
                    case 26: goto L13;
                    case 27: goto L12;
                    case 28: goto L11;
                    case 29: goto L10;
                    case 30: goto L9;
                    case 31: goto L8;
                    case 32: goto L7;
                    default: goto L6;
                };
            L7:
                r101.resource_msg_link_token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.clean_resource_scene = ResourceCleanScene.ADAPTER.decode(r100);
                goto L3
            L9:
                r101.resource_is_cleaned = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                r101.resource_preview_token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.height = ProtoAdapter.UINT32.decode(r100);
                goto L3
            L12:
                r101.width = ProtoAdapter.UINT32.decode(r100);
                goto L3
            L13:
                r101.origin = Image.ADAPTER.decode(r100);
                goto L3
            L14:
                r101.need_copy = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L15:
                r101.show_mode = ProtoAdapter.INT32.decode(r100);
                goto L3
            L16:
                r101.inline_preview = ProtoAdapter.BYTES.decode(r100);
                goto L3
            L17:
                r101.upload_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L18:
                r101.origin_size = ProtoAdapter.UINT64.decode(r100);
                goto L3
            L19:
                r101.is_origin_source = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L20:
                r101.intact = Image.ADAPTER.decode(r100);
                goto L3
            L21:
                r101.custom_width = ProtoAdapter.INT32.decode(r100);
                goto L3
            L22:
                r101.cover = Image.ADAPTER.decode(r100);
                goto L3
            L23:
                r101.middle_mp4 = Image.ADAPTER.decode(r100);
                goto L3
            L24:
                r101.middle_webp = Image.ADAPTER.decode(r100);
                goto L3
            L25:
                r101.thumbnail_webp = Image.ADAPTER.decode(r100);
                goto L3
            L26:
                r101.img_can_preview = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L27:
                r101.alt_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L28:
                r101.alt = ProtoAdapter.STRING.decode(r100);
                goto L3
            L29:
                r101.fs_unit = ProtoAdapter.STRING.decode(r100);
                goto L3
            L30:
                r101.origin_height = ProtoAdapter.INT32.decode(r100);
                goto L3
            L31:
                r101.origin_width = ProtoAdapter.INT32.decode(r100);
                goto L3
            L32:
                r101.thumb_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L33:
                r101.middle_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L34:
                r101.origin_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L35:
                r101.token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L36:
                r101.urls.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L37:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ImageProperty r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.urls);
                String r103 = r100.token;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(2, r103);
            L6:
                int r106 = r102 + r105;
                String r107 = r100.origin_key;
                if (r107 == null) goto L9;
                int r108 = r101.encodedSizeWithTag(3, r107);
            L10:
                int r109 = r106 + r108;
                String r110 = r100.middle_key;
                if (r110 == null) goto L13;
                int r111 = r101.encodedSizeWithTag(4, r110);
            L14:
                int r112 = r109 + r111;
                String r113 = r100.thumb_key;
                if (r113 == null) goto L17;
                int r114 = r101.encodedSizeWithTag(5, r113);
            L18:
                int r115 = r112 + r114;
                Integer r116 = r100.origin_width;
                if (r116 == null) goto L21;
                int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
            L22:
                int r118 = r115 + r117;
                Integer r119 = r100.origin_height;
                if (r119 == null) goto L25;
                int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
            L26:
                int r121 = r118 + r120;
                String r122 = r100.fs_unit;
                if (r122 == null) goto L29;
                int r123 = r101.encodedSizeWithTag(8, r122);
            L30:
                int r124 = r121 + r123;
                String r125 = r100.alt;
                if (r125 == null) goto L33;
                int r126 = r101.encodedSizeWithTag(9, r125);
            L34:
                int r127 = r124 + r126;
                String r128 = r100.alt_i18n_key;
                if (r128 == null) goto L37;
                int r129 = r101.encodedSizeWithTag(10, r128);
            L38:
                int r130 = r127 + r129;
                Boolean r131 = r100.img_can_preview;
                if (r131 == null) goto L41;
                int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r131);
            L42:
                int r133 = r130 + r132;
                Image r134 = r100.thumbnail_webp;
                if (r134 == null) goto L45;
                int r135 = Image.ADAPTER.encodedSizeWithTag(12, r134);
            L46:
                int r136 = r133 + r135;
                Image r137 = r100.middle_webp;
                if (r137 == null) goto L49;
                int r138 = Image.ADAPTER.encodedSizeWithTag(13, r137);
            L50:
                int r139 = r136 + r138;
                Image r140 = r100.middle_mp4;
                if (r140 == null) goto L53;
                int r141 = Image.ADAPTER.encodedSizeWithTag(14, r140);
            L54:
                int r142 = r139 + r141;
                Image r143 = r100.cover;
                if (r143 == null) goto L57;
                int r144 = Image.ADAPTER.encodedSizeWithTag(15, r143);
            L58:
                int r145 = r142 + r144;
                Integer r146 = r100.custom_width;
                if (r146 == null) goto L61;
                int r147 = ProtoAdapter.INT32.encodedSizeWithTag(16, r146);
            L62:
                int r148 = r145 + r147;
                Image r149 = r100.intact;
                if (r149 == null) goto L65;
                int r150 = Image.ADAPTER.encodedSizeWithTag(17, r149);
            L66:
                int r151 = r148 + r150;
                Boolean r152 = r100.is_origin_source;
                if (r152 == null) goto L69;
                int r153 = ProtoAdapter.BOOL.encodedSizeWithTag(20, r152);
            L70:
                int r154 = r151 + r153;
                Long r155 = r100.origin_size;
                if (r155 == null) goto L73;
                int r156 = ProtoAdapter.UINT64.encodedSizeWithTag(21, r155);
            L74:
                int r157 = r154 + r156;
                String r158 = r100.upload_id;
                if (r158 == null) goto L77;
                int r159 = r101.encodedSizeWithTag(22, r158);
            L78:
                int r160 = r157 + r159;
                ByteString r161 = r100.inline_preview;
                if (r161 == null) goto L81;
                int r162 = ProtoAdapter.BYTES.encodedSizeWithTag(23, r161);
            L82:
                int r163 = r160 + r162;
                Integer r164 = r100.show_mode;
                if (r164 == null) goto L85;
                int r165 = ProtoAdapter.INT32.encodedSizeWithTag(24, r164);
            L86:
                int r166 = r163 + r165;
                Boolean r167 = r100.need_copy;
                if (r167 == null) goto L89;
                int r168 = ProtoAdapter.BOOL.encodedSizeWithTag(25, r167);
            L90:
                int r169 = r166 + r168;
                Image r170 = r100.origin;
                if (r170 == null) goto L93;
                int r171 = Image.ADAPTER.encodedSizeWithTag(26, r170);
            L94:
                int r172 = r169 + r171;
                Integer r173 = r100.width;
                if (r173 == null) goto L97;
                int r174 = ProtoAdapter.UINT32.encodedSizeWithTag(27, r173);
            L98:
                int r175 = r172 + r174;
                Integer r176 = r100.height;
                if (r176 == null) goto L101;
                int r177 = ProtoAdapter.UINT32.encodedSizeWithTag(28, r176);
            L102:
                int r178 = r175 + r177;
                String r179 = r100.resource_preview_token;
                if (r179 == null) goto L105;
                int r180 = r101.encodedSizeWithTag(29, r179);
            L106:
                int r181 = r178 + r180;
                Boolean r182 = r100.resource_is_cleaned;
                if (r182 == null) goto L109;
                int r183 = ProtoAdapter.BOOL.encodedSizeWithTag(30, r182);
            L110:
                int r184 = r181 + r183;
                ResourceCleanScene r185 = r100.clean_resource_scene;
                if (r185 == null) goto L113;
                int r186 = ResourceCleanScene.ADAPTER.encodedSizeWithTag(31, r185);
            L114:
                int r187 = r184 + r186;
                String r188 = r100.resource_msg_link_token;
                if (r188 == null) goto L118;
                r104 = r101.encodedSizeWithTag(32, r188);
            L118:
                return (r187 + r104) + r100.unknownFields().size();
            L113:
                r186 = 0;
                goto L114
            L109:
                r183 = 0;
                goto L110
            L105:
                r180 = 0;
                goto L106
            L101:
                r177 = 0;
                goto L102
            L97:
                r174 = 0;
                goto L98
            L93:
                r171 = 0;
                goto L94
            L89:
                r168 = 0;
                goto L90
            L85:
                r165 = 0;
                goto L86
            L81:
                r162 = 0;
                goto L82
            L77:
                r159 = 0;
                goto L78
            L73:
                r156 = 0;
                goto L74
            L69:
                r153 = 0;
                goto L70
            L65:
                r150 = 0;
                goto L66
            L61:
                r147 = 0;
                goto L62
            L57:
                r144 = 0;
                goto L58
            L53:
                r141 = 0;
                goto L54
            L49:
                r138 = 0;
                goto L50
            L45:
                r135 = 0;
                goto L46
            L41:
                r132 = 0;
                goto L42
            L37:
                r129 = 0;
                goto L38
            L33:
                r126 = 0;
                goto L34
            L29:
                r123 = 0;
                goto L30
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
            public /* bridge */ /* synthetic */ ImageProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ImageProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ImageProperty r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.asRepeated().encodeWithTag(r100, 1, r101.urls);
                String r103 = r101.token;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 2, r103);
            L5:
                String r104 = r101.origin_key;
                if (r104 == null) goto L8;
                r102.encodeWithTag(r100, 3, r104);
            L8:
                String r105 = r101.middle_key;
                if (r105 == null) goto L11;
                r102.encodeWithTag(r100, 4, r105);
            L11:
                String r106 = r101.thumb_key;
                if (r106 == null) goto L14;
                r102.encodeWithTag(r100, 5, r106);
            L14:
                Integer r107 = r101.origin_width;
                if (r107 == null) goto L17;
                ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
            L17:
                Integer r108 = r101.origin_height;
                if (r108 == null) goto L20;
                ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
            L20:
                String r109 = r101.fs_unit;
                if (r109 == null) goto L23;
                r102.encodeWithTag(r100, 8, r109);
            L23:
                String r110 = r101.alt;
                if (r110 == null) goto L26;
                r102.encodeWithTag(r100, 9, r110);
            L26:
                String r111 = r101.alt_i18n_key;
                if (r111 == null) goto L29;
                r102.encodeWithTag(r100, 10, r111);
            L29:
                Boolean r112 = r101.img_can_preview;
                if (r112 == null) goto L32;
                ProtoAdapter.BOOL.encodeWithTag(r100, 11, r112);
            L32:
                Image r113 = r101.thumbnail_webp;
                if (r113 == null) goto L35;
                Image.ADAPTER.encodeWithTag(r100, 12, r113);
            L35:
                Image r114 = r101.middle_webp;
                if (r114 == null) goto L38;
                Image.ADAPTER.encodeWithTag(r100, 13, r114);
            L38:
                Image r115 = r101.middle_mp4;
                if (r115 == null) goto L41;
                Image.ADAPTER.encodeWithTag(r100, 14, r115);
            L41:
                Image r116 = r101.cover;
                if (r116 == null) goto L44;
                Image.ADAPTER.encodeWithTag(r100, 15, r116);
            L44:
                Integer r117 = r101.custom_width;
                if (r117 == null) goto L47;
                ProtoAdapter.INT32.encodeWithTag(r100, 16, r117);
            L47:
                Image r118 = r101.intact;
                if (r118 == null) goto L50;
                Image.ADAPTER.encodeWithTag(r100, 17, r118);
            L50:
                Boolean r119 = r101.is_origin_source;
                if (r119 == null) goto L53;
                ProtoAdapter.BOOL.encodeWithTag(r100, 20, r119);
            L53:
                Long r120 = r101.origin_size;
                if (r120 == null) goto L56;
                ProtoAdapter.UINT64.encodeWithTag(r100, 21, r120);
            L56:
                String r121 = r101.upload_id;
                if (r121 == null) goto L59;
                r102.encodeWithTag(r100, 22, r121);
            L59:
                ByteString r122 = r101.inline_preview;
                if (r122 == null) goto L62;
                ProtoAdapter.BYTES.encodeWithTag(r100, 23, r122);
            L62:
                Integer r123 = r101.show_mode;
                if (r123 == null) goto L65;
                ProtoAdapter.INT32.encodeWithTag(r100, 24, r123);
            L65:
                Boolean r124 = r101.need_copy;
                if (r124 == null) goto L68;
                ProtoAdapter.BOOL.encodeWithTag(r100, 25, r124);
            L68:
                Image r125 = r101.origin;
                if (r125 == null) goto L71;
                Image.ADAPTER.encodeWithTag(r100, 26, r125);
            L71:
                Integer r126 = r101.width;
                if (r126 == null) goto L74;
                ProtoAdapter.UINT32.encodeWithTag(r100, 27, r126);
            L74:
                Integer r127 = r101.height;
                if (r127 == null) goto L77;
                ProtoAdapter.UINT32.encodeWithTag(r100, 28, r127);
            L77:
                String r128 = r101.resource_preview_token;
                if (r128 == null) goto L80;
                r102.encodeWithTag(r100, 29, r128);
            L80:
                Boolean r129 = r101.resource_is_cleaned;
                if (r129 == null) goto L83;
                ProtoAdapter.BOOL.encodeWithTag(r100, 30, r129);
            L83:
                ResourceCleanScene r130 = r101.clean_resource_scene;
                if (r130 == null) goto L86;
                ResourceCleanScene.ADAPTER.encodeWithTag(r100, 31, r130);
            L86:
                String r131 = r101.resource_msg_link_token;
                if (r131 == null) goto L89;
                r102.encodeWithTag(r100, 32, r131);
            L89:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ImageProperty();
            DEFAULT_ORIGIN_WIDTH = 0;
            DEFAULT_ORIGIN_HEIGHT = 0;
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IMG_CAN_PREVIEW = r100;
            DEFAULT_CUSTOM_WIDTH = 0;
            DEFAULT_IS_ORIGIN_SOURCE = r100;
            DEFAULT_ORIGIN_SIZE = 0L;
            DEFAULT_INLINE_PREVIEW = ByteString.EMPTY;
            DEFAULT_SHOW_MODE = 0;
            DEFAULT_NEED_COPY = r100;
            DEFAULT_WIDTH = 0;
            DEFAULT_HEIGHT = 0;
            DEFAULT_RESOURCE_IS_CLEANED = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.urls = Internal.copyOf("urls", this.urls);
            r100.token = this.token;
            r100.origin_key = this.origin_key;
            r100.middle_key = this.middle_key;
            r100.thumb_key = this.thumb_key;
            r100.origin_width = this.origin_width;
            r100.origin_height = this.origin_height;
            r100.fs_unit = this.fs_unit;
            r100.alt = this.alt;
            r100.alt_i18n_key = this.alt_i18n_key;
            r100.img_can_preview = this.img_can_preview;
            r100.thumbnail_webp = this.thumbnail_webp;
            r100.middle_webp = this.middle_webp;
            r100.middle_mp4 = this.middle_mp4;
            r100.cover = this.cover;
            r100.custom_width = this.custom_width;
            r100.intact = this.intact;
            r100.is_origin_source = this.is_origin_source;
            r100.origin_size = this.origin_size;
            r100.upload_id = this.upload_id;
            r100.inline_preview = this.inline_preview;
            r100.show_mode = this.show_mode;
            r100.need_copy = this.need_copy;
            r100.origin = this.origin;
            r100.width = this.width;
            r100.height = this.height;
            r100.resource_preview_token = this.resource_preview_token;
            r100.resource_is_cleaned = this.resource_is_cleaned;
            r100.clean_resource_scene = this.clean_resource_scene;
            r100.resource_msg_link_token = this.resource_msg_link_token;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ImageProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ImageProperty(List<String> r310, String r311, String r312, String r313, String r314, Integer r315, Integer r316, String r410, String r411, String r412, Boolean r413, Image r414, Image r415, Image r416, Image r417, Integer r418, Image r419, Boolean r510, Long r511, String r512, ByteString r513, Integer r514, Boolean r515, Image r516, Integer r517, Integer r518, String r519, Boolean r610, ResourceCleanScene r611, String r612) {
            this(r310, r311, r312, r313, r314, r315, r316, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, ByteString.EMPTY);
        }

        public ImageProperty(List<String> r100, String r101, String r102, String r103, String r104, Integer r105, Integer r110, String r111, String r112, String r113, Boolean r114, Image r115, Image r116, Image r117, Image r118, Integer r119, Image r210, Boolean r211, Long r212, String r213, ByteString r214, Integer r215, Boolean r216, Image r217, Integer r218, Integer r219, String r310, Boolean r311, ResourceCleanScene r312, String r313, ByteString r314) {
            super(ADAPTER, r314);
            this.urls = Internal.immutableCopyOf("urls", r100);
            this.token = r101;
            this.origin_key = r102;
            this.middle_key = r103;
            this.thumb_key = r104;
            this.origin_width = r105;
            this.origin_height = r110;
            this.fs_unit = r111;
            this.alt = r112;
            this.alt_i18n_key = r113;
            this.img_can_preview = r114;
            this.thumbnail_webp = r115;
            this.middle_webp = r116;
            this.middle_mp4 = r117;
            this.cover = r118;
            this.custom_width = r119;
            this.intact = r210;
            this.is_origin_source = r211;
            this.origin_size = r212;
            this.upload_id = r213;
            this.inline_preview = r214;
            this.show_mode = r215;
            this.need_copy = r216;
            this.origin = r217;
            this.width = r218;
            this.height = r219;
            this.resource_preview_token = r310;
            this.resource_is_cleaned = r311;
            this.clean_resource_scene = r312;
            this.resource_msg_link_token = r313;
        }
    }

    public static final class ItalicProperty extends com.squareup.wire.Message<ItalicProperty, Builder> {
        public static final ProtoAdapter<ItalicProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String content;
        public final String i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<ItalicProperty, Builder> {
            public String content;
            public String i18n_key;

            @Override // com.squareup.wire.Message.Builder
            public ItalicProperty build() {
                String r100 = this.content;
                if (r100 == null) goto L7;
                return new ItalicProperty(this.content, this.i18n_key, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "content"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder i18n_key(String r100) {
                this.i18n_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ItalicProperty extends ProtoAdapter<ItalicProperty> {
            public ProtoAdapter_ItalicProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ItalicProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ItalicProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.content = "";
                r101.i18n_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ItalicProperty r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.content);
                String r103 = r100.i18n_key;
                if (r103 == null) goto L5;
                int r104 = r101.encodedSizeWithTag(2, r103);
            L7:
                return (r102 + r104) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ItalicProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ItalicProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ItalicProperty r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.content);
                String r103 = r101.i18n_key;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 2, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ItalicProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ItalicProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.content = this.content;
            r100.i18n_key = this.i18n_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ItalicProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ItalicProperty(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ItalicProperty(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.content = r100;
            this.i18n_key = r101;
        }
    }

    public static final class LIProperty extends com.squareup.wire.Message<LIProperty, Builder> {
        public static final ProtoAdapter<LIProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<LIProperty, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public LIProperty build() {
                return new LIProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_LIProperty extends ProtoAdapter<LIProperty> {
            public ProtoAdapter_LIProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, LIProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LIProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(LIProperty r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ LIProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LIProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LIProperty r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LIProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LIProperty();
        }

        public LIProperty() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LIProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public LIProperty(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class LinkProperty extends com.squareup.wire.Message<LinkProperty, Builder> {
        public static final ProtoAdapter<LinkProperty> ADAPTER = null;
        public static final String DEFAULT_ANDROID_URL = "";
        public static final String DEFAULT_IOS_URL = "";
        public static final String DEFAULT_PC_URL = "";
        public static final LinkScene DEFAULT_SCENE = null;
        public static final SpecialURL DEFAULT_SPECIAL_URL = null;
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final String android_url;
        public final String ios_url;
        public final String pc_url;
        public final LinkScene scene;
        public final SpecialURL special_url;
        public final String url;

        public static final class Builder extends com.squareup.wire.Message.Builder<LinkProperty, Builder> {
            public String android_url;
            public String ios_url;
            public String pc_url;
            public LinkScene scene;
            public SpecialURL special_url;
            public String url;

            @Override // com.squareup.wire.Message.Builder
            public LinkProperty build() {
                return new LinkProperty(this.url, this.ios_url, this.android_url, this.pc_url, this.special_url, this.scene, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder android_url(String r100) {
                this.android_url = r100;
                return this;
            }

            public Builder ios_url(String r100) {
                this.ios_url = r100;
                return this;
            }

            public Builder pc_url(String r100) {
                this.pc_url = r100;
                return this;
            }

            public Builder scene(LinkScene r100) {
                this.scene = r100;
                return this;
            }

            public Builder special_url(SpecialURL r100) {
                this.special_url = r100;
                return this;
            }

            public Builder url(String r100) {
                this.url = r100;
                return this;
            }
        }

        public static final enum LinkScene extends Enum<LinkScene> implements WireEnum {
            private static final /* synthetic */ LinkScene[] $VALUES = null;
            public static final ProtoAdapter<LinkScene> ADAPTER = null;
            public static final LinkScene CardLink = null;
            public static final LinkScene ContentLink = null;
            public static final LinkScene FooterLink = null;
            public static final LinkScene UNKNOWN = null;
            private final int value;

            static {
                LinkScene r100 = new LinkScene("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                LinkScene r101 = new LinkScene("CardLink", 1, 1);
                CardLink = r101;
                LinkScene r102 = new LinkScene("ContentLink", 2, 2);
                ContentLink = r102;
                LinkScene r103 = new LinkScene("FooterLink", 3, 3);
                FooterLink = r103;
                $VALUES = new LinkScene[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(LinkScene.class);
            }

            public static LinkScene[] values() {
                return (LinkScene[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static LinkScene fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return FooterLink;
            L14:
                return ContentLink;
            L16:
                return CardLink;
            L18:
                return UNKNOWN;
            }

            public static LinkScene valueOf(String r100) {
                return (LinkScene) a.a(LinkScene.class, r100);
            }

            private LinkScene(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_LinkProperty extends ProtoAdapter<LinkProperty> {
            public ProtoAdapter_LinkProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, LinkProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LinkProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.url = "";
                r101.ios_url = "";
                r101.android_url = "";
                r101.pc_url = "";
                r101.special_url = SpecialURL.UNKNOWN_URL;
                r101.scene = LinkScene.UNKNOWN;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L19;
                switch(r103) {
                    case 1: goto L18;
                    case 2: goto L17;
                    case 3: goto L16;
                    case 4: goto L15;
                    case 5: goto L23;
                    case 6: goto L21;
                    default: goto L6;
                };
            L21:
                r101.scene = LinkScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L23:
                r101.special_url = SpecialURL.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L15:
                r101.pc_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L16:
                r101.android_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L17:
                r101.ios_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L18:
                r101.url = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(LinkProperty r100) {
                String r101 = r100.url;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.ios_url;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.android_url;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.pc_url;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                SpecialURL r113 = r100.special_url;
                if (r113 == null) goto L21;
                int r114 = SpecialURL.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                LinkScene r116 = r100.scene;
                if (r116 == null) goto L26;
                r102 = LinkScene.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                return (r115 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ LinkProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LinkProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LinkProperty r101) throws IOException {
                String r102 = r101.url;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.ios_url;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.android_url;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.pc_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                SpecialURL r106 = r101.special_url;
                if (r106 == null) goto L17;
                SpecialURL.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                LinkScene r107 = r101.scene;
                if (r107 == null) goto L20;
                LinkScene.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LinkProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LinkProperty();
            DEFAULT_SPECIAL_URL = SpecialURL.UNKNOWN_URL;
            DEFAULT_SCENE = LinkScene.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.url = this.url;
            r100.ios_url = this.ios_url;
            r100.android_url = this.android_url;
            r100.pc_url = this.pc_url;
            r100.special_url = this.special_url;
            r100.scene = this.scene;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LinkProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public LinkProperty(String r100, String r110, String r111, String r112, SpecialURL r113, LinkScene r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public LinkProperty(String r100, String r101, String r102, String r103, SpecialURL r104, LinkScene r105, ByteString r106) {
            super(ADAPTER, r106);
            this.url = r100;
            this.ios_url = r101;
            this.android_url = r102;
            this.pc_url = r103;
            this.special_url = r104;
            this.scene = r105;
        }
    }

    public static final class MarkdownProperty extends com.squareup.wire.Message<MarkdownProperty, Builder> {
        public static final ProtoAdapter<MarkdownProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final Boolean DEFAULT_IS_AT_ALL = null;
        private static final long serialVersionUID = 0;
        public final List<Long> at_user_ids;
        public final Map<String, AtProperty> at_users;
        public final String content;
        public final Map<String, ImageSetV2> images;
        public final Boolean is_at_all;

        public static final class Builder extends com.squareup.wire.Message.Builder<MarkdownProperty, Builder> {
            public List<Long> at_user_ids;
            public Map<String, AtProperty> at_users;
            public String content;
            public Map<String, ImageSetV2> images;
            public Boolean is_at_all;

            @Override // com.squareup.wire.Message.Builder
            public MarkdownProperty build() {
                return new MarkdownProperty(this.content, this.images, this.at_user_ids, this.is_at_all, this.at_users, super.buildUnknownFields());
            }

            public Builder() {
                this.images = Internal.newMutableMap();
                this.at_user_ids = Internal.newMutableList();
                this.at_users = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder at_user_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.at_user_ids = r100;
                return this;
            }

            public Builder at_users(Map<String, AtProperty> r100) {
                Internal.checkElementsNotNull(r100);
                this.at_users = r100;
                return this;
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder images(Map<String, ImageSetV2> r100) {
                Internal.checkElementsNotNull(r100);
                this.images = r100;
                return this;
            }

            public Builder is_at_all(Boolean r100) {
                this.is_at_all = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MarkdownProperty extends ProtoAdapter<MarkdownProperty> {
            private final ProtoAdapter<Map<String, AtProperty>> at_users;
            private final ProtoAdapter<Map<String, ImageSetV2>> images;

            public ProtoAdapter_MarkdownProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, MarkdownProperty.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.images = ProtoAdapter.newMapAdapter(r100, ImageSetV2.ADAPTER);
                this.at_users = ProtoAdapter.newMapAdapter(r100, AtProperty.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MarkdownProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.content = "";
                r101.is_at_all = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.images.putAll(this.images.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.at_user_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.is_at_all = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.at_users.putAll(this.at_users.decode(r100));
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MarkdownProperty r100) {
                String r101 = r100.content;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                int r104 = (r103 + this.images.encodedSizeWithTag(2, r100.images)) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(3, r100.at_user_ids);
                Boolean r105 = r100.is_at_all;
                if (r105 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r105);
            L10:
                return ((r104 + r102) + this.at_users.encodedSizeWithTag(5, r100.at_users)) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MarkdownProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MarkdownProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MarkdownProperty r101) throws IOException {
                String r102 = r101.content;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                this.images.encodeWithTag(r100, 2, r101.images);
                ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 3, r101.at_user_ids);
                Boolean r103 = r101.is_at_all;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
            L8:
                this.at_users.encodeWithTag(r100, 5, r101.at_users);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MarkdownProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MarkdownProperty();
            DEFAULT_IS_AT_ALL = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.content = this.content;
            r100.images = Internal.copyOf("images", this.images);
            r100.at_user_ids = Internal.copyOf("at_user_ids", this.at_user_ids);
            r100.is_at_all = this.is_at_all;
            r100.at_users = Internal.copyOf("at_users", this.at_users);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MarkdownProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MarkdownProperty(String r100, Map<String, ImageSetV2> r101, List<Long> r110, Boolean r111, Map<String, AtProperty> r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public MarkdownProperty(String r100, Map<String, ImageSetV2> r101, List<Long> r102, Boolean r103, Map<String, AtProperty> r104, ByteString r105) {
            super(ADAPTER, r105);
            this.content = r100;
            this.images = Internal.immutableCopyOf("images", r101);
            this.at_user_ids = Internal.immutableCopyOf("at_user_ids", r102);
            this.is_at_all = r103;
            this.at_users = Internal.immutableCopyOf("at_users", r104);
        }
    }

    public static final class MediaProperty extends com.squareup.wire.Message<MediaProperty, Builder> {
        public static final ProtoAdapter<MediaProperty> ADAPTER = null;
        public static final String DEFAULT_COMPRESS_PATH = "";
        public static final String DEFAULT_CRYPTO_TOKEN = "";
        public static final Integer DEFAULT_DURATION = null;
        public static final String DEFAULT_FS_UNIT = "";
        public static final Integer DEFAULT_HEIGHT = null;
        public static final ByteString DEFAULT_IMAGE_DATA = null;
        public static final String DEFAULT_IMAGE_PATH = "";
        public static final String DEFAULT_IMAGE_UPLOAD_ID = "";
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_MEDIA_UPLOAD_ID = "";
        public static final String DEFAULT_MIME = "";
        public static final String DEFAULT_NAME = "";
        public static final Boolean DEFAULT_NEED_COPY_IMG = null;
        public static final Boolean DEFAULT_NEED_COPY_MEDIA = null;
        public static final String DEFAULT_ORIGIN_PATH = "";
        public static final Boolean DEFAULT_RESOURCE_IS_CLEANED = null;
        public static final String DEFAULT_RESOURCE_MSG_LINK_TOKEN = "";
        public static final String DEFAULT_RESOURCE_PREVIEW_TOKEN = "";
        public static final Long DEFAULT_SIZE = null;
        public static final Source DEFAULT_SOURCE = null;
        public static final String DEFAULT_URL = "";
        public static final Integer DEFAULT_WIDTH = null;
        private static final long serialVersionUID = 0;
        public final ResourceCleanScene clean_resource_scene;
        public final String compress_path;
        public final String crypto_token;
        public final Integer duration;
        public final String fs_unit;
        public final Integer height;
        public final ImageSet image;
        public final ByteString image_data;
        public final String image_path;
        public final String image_upload_id;
        public final String key;
        public final String media_upload_id;
        public final String mime;
        public final String name;
        public final Boolean need_copy_img;
        public final Boolean need_copy_media;
        public final String origin_path;
        public final Boolean resource_is_cleaned;
        public final String resource_msg_link_token;
        public final String resource_preview_token;
        public final Long size;
        public final Source source;
        public final String url;
        public final Integer width;

        public static final class Builder extends com.squareup.wire.Message.Builder<MediaProperty, Builder> {
            public ResourceCleanScene clean_resource_scene;
            public String compress_path;
            public String crypto_token;
            public Integer duration;
            public String fs_unit;
            public Integer height;
            public ImageSet image;
            public ByteString image_data;
            public String image_path;
            public String image_upload_id;
            public String key;
            public String media_upload_id;
            public String mime;
            public String name;
            public Boolean need_copy_img;
            public Boolean need_copy_media;
            public String origin_path;
            public Boolean resource_is_cleaned;
            public String resource_msg_link_token;
            public String resource_preview_token;
            public Long size;
            public Source source;
            public String url;
            public Integer width;

            @Override // com.squareup.wire.Message.Builder
            public MediaProperty build() {
                return new MediaProperty(this.key, this.name, this.size, this.mime, this.source, this.image, this.duration, this.fs_unit, this.crypto_token, this.need_copy_img, this.need_copy_media, this.compress_path, this.origin_path, this.image_data, this.width, this.height, this.url, this.image_path, this.image_upload_id, this.media_upload_id, this.resource_preview_token, this.resource_is_cleaned, this.clean_resource_scene, this.resource_msg_link_token, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder clean_resource_scene(ResourceCleanScene r100) {
                this.clean_resource_scene = r100;
                return this;
            }

            public Builder compress_path(String r100) {
                this.compress_path = r100;
                return this;
            }

            public Builder crypto_token(String r100) {
                this.crypto_token = r100;
                return this;
            }

            public Builder duration(Integer r100) {
                this.duration = r100;
                return this;
            }

            public Builder fs_unit(String r100) {
                this.fs_unit = r100;
                return this;
            }

            public Builder height(Integer r100) {
                this.height = r100;
                return this;
            }

            public Builder image(ImageSet r100) {
                this.image = r100;
                return this;
            }

            public Builder image_data(ByteString r100) {
                this.image_data = r100;
                return this;
            }

            public Builder image_path(String r100) {
                this.image_path = r100;
                return this;
            }

            public Builder image_upload_id(String r100) {
                this.image_upload_id = r100;
                return this;
            }

            public Builder key(String r100) {
                this.key = r100;
                return this;
            }

            public Builder media_upload_id(String r100) {
                this.media_upload_id = r100;
                return this;
            }

            public Builder mime(String r100) {
                this.mime = r100;
                return this;
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }

            public Builder need_copy_img(Boolean r100) {
                this.need_copy_img = r100;
                return this;
            }

            public Builder need_copy_media(Boolean r100) {
                this.need_copy_media = r100;
                return this;
            }

            public Builder origin_path(String r100) {
                this.origin_path = r100;
                return this;
            }

            public Builder resource_is_cleaned(Boolean r100) {
                this.resource_is_cleaned = r100;
                return this;
            }

            public Builder resource_msg_link_token(String r100) {
                this.resource_msg_link_token = r100;
                return this;
            }

            public Builder resource_preview_token(String r100) {
                this.resource_preview_token = r100;
                return this;
            }

            public Builder size(Long r100) {
                this.size = r100;
                return this;
            }

            public Builder source(Source r100) {
                this.source = r100;
                return this;
            }

            public Builder url(String r100) {
                this.url = r100;
                return this;
            }

            public Builder width(Integer r100) {
                this.width = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MediaProperty extends ProtoAdapter<MediaProperty> {
            public ProtoAdapter_MediaProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, MediaProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MediaProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.key = "";
                r101.name = "";
                r101.size = 0L;
                r101.mime = "";
                r101.source = Source.UNKNOWN;
                r101.duration = 0;
                r101.fs_unit = "";
                r101.crypto_token = "";
                Boolean r102 = Boolean.FALSE;
                r101.need_copy_img = r102;
                r101.need_copy_media = r102;
                r101.compress_path = "";
                r101.origin_path = "";
                r101.image_data = ByteString.EMPTY;
                r101.width = 0;
                r101.height = 0;
                r101.url = "";
                r101.image_path = "";
                r101.image_upload_id = "";
                r101.media_upload_id = "";
                r101.resource_preview_token = "";
                r101.resource_is_cleaned = r102;
                r101.resource_msg_link_token = "";
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L35;
                switch(r104) {
                    case 1: goto L34;
                    case 2: goto L33;
                    case 3: goto L32;
                    case 4: goto L31;
                    case 5: goto L37;
                    case 6: goto L26;
                    case 7: goto L25;
                    case 8: goto L24;
                    case 9: goto L23;
                    case 10: goto L22;
                    case 11: goto L21;
                    default: goto L6;
                };
            L37:
                r101.source = Source.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
            L29:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L21:
                r101.need_copy_media = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L22:
                r101.need_copy_img = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L23:
                r101.crypto_token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L24:
                r101.fs_unit = ProtoAdapter.STRING.decode(r100);
                goto L3
            L25:
                r101.duration = ProtoAdapter.INT32.decode(r100);
                goto L3
            L26:
                r101.image = ImageSet.ADAPTER.decode(r100);
                goto L3
            L31:
                r101.mime = ProtoAdapter.STRING.decode(r100);
                goto L3
            L32:
                r101.size = ProtoAdapter.INT64.decode(r100);
                goto L3
            L33:
                r101.name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L34:
                r101.key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                switch(r104) {
                    case 100: goto L20;
                    case 101: goto L19;
                    case 102: goto L18;
                    case 103: goto L17;
                    case 104: goto L16;
                    case 105: goto L15;
                    case 106: goto L14;
                    case 107: goto L13;
                    case 108: goto L12;
                    case 109: goto L11;
                    case 110: goto L10;
                    case 111: goto L9;
                    case 112: goto L8;
                    default: goto L7;
                };
            L8:
                r101.resource_msg_link_token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.clean_resource_scene = ResourceCleanScene.ADAPTER.decode(r100);
                goto L3
            L10:
                r101.resource_is_cleaned = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                r101.resource_preview_token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.media_upload_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.image_upload_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.image_path = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L16:
                r101.height = ProtoAdapter.INT32.decode(r100);
                goto L3
            L17:
                r101.width = ProtoAdapter.INT32.decode(r100);
                goto L3
            L18:
                r101.image_data = ProtoAdapter.BYTES.decode(r100);
                goto L3
            L19:
                r101.origin_path = ProtoAdapter.STRING.decode(r100);
                goto L3
            L20:
                r101.compress_path = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L35:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MediaProperty r100) {
                String r101 = r100.key;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.name;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.size;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.mime;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Source r113 = r100.source;
                if (r113 == null) goto L21;
                int r114 = Source.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                ImageSet r116 = r100.image;
                if (r116 == null) goto L25;
                int r117 = ImageSet.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Integer r119 = r100.duration;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                String r122 = r100.fs_unit;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                String r125 = r100.crypto_token;
                if (r125 == null) goto L37;
                int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
            L38:
                int r127 = r124 + r126;
                Boolean r128 = r100.need_copy_img;
                if (r128 == null) goto L41;
                int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r128);
            L42:
                int r130 = r127 + r129;
                Boolean r131 = r100.need_copy_media;
                if (r131 == null) goto L45;
                int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r131);
            L46:
                int r133 = r130 + r132;
                String r134 = r100.compress_path;
                if (r134 == null) goto L49;
                int r135 = ProtoAdapter.STRING.encodedSizeWithTag(100, r134);
            L50:
                int r136 = r133 + r135;
                String r137 = r100.origin_path;
                if (r137 == null) goto L53;
                int r138 = ProtoAdapter.STRING.encodedSizeWithTag(101, r137);
            L54:
                int r139 = r136 + r138;
                ByteString r140 = r100.image_data;
                if (r140 == null) goto L57;
                int r141 = ProtoAdapter.BYTES.encodedSizeWithTag(102, r140);
            L58:
                int r142 = r139 + r141;
                Integer r143 = r100.width;
                if (r143 == null) goto L61;
                int r144 = ProtoAdapter.INT32.encodedSizeWithTag(103, r143);
            L62:
                int r145 = r142 + r144;
                Integer r146 = r100.height;
                if (r146 == null) goto L65;
                int r147 = ProtoAdapter.INT32.encodedSizeWithTag(104, r146);
            L66:
                int r148 = r145 + r147;
                String r149 = r100.url;
                if (r149 == null) goto L69;
                int r150 = ProtoAdapter.STRING.encodedSizeWithTag(105, r149);
            L70:
                int r151 = r148 + r150;
                String r152 = r100.image_path;
                if (r152 == null) goto L73;
                int r153 = ProtoAdapter.STRING.encodedSizeWithTag(106, r152);
            L74:
                int r154 = r151 + r153;
                String r155 = r100.image_upload_id;
                if (r155 == null) goto L77;
                int r156 = ProtoAdapter.STRING.encodedSizeWithTag(107, r155);
            L78:
                int r157 = r154 + r156;
                String r158 = r100.media_upload_id;
                if (r158 == null) goto L81;
                int r159 = ProtoAdapter.STRING.encodedSizeWithTag(108, r158);
            L82:
                int r160 = r157 + r159;
                String r161 = r100.resource_preview_token;
                if (r161 == null) goto L85;
                int r162 = ProtoAdapter.STRING.encodedSizeWithTag(109, r161);
            L86:
                int r163 = r160 + r162;
                Boolean r164 = r100.resource_is_cleaned;
                if (r164 == null) goto L89;
                int r165 = ProtoAdapter.BOOL.encodedSizeWithTag(110, r164);
            L90:
                int r166 = r163 + r165;
                ResourceCleanScene r167 = r100.clean_resource_scene;
                if (r167 == null) goto L93;
                int r168 = ResourceCleanScene.ADAPTER.encodedSizeWithTag(111, r167);
            L94:
                int r169 = r166 + r168;
                String r170 = r100.resource_msg_link_token;
                if (r170 == null) goto L98;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(112, r170);
            L98:
                return (r169 + r102) + r100.unknownFields().size();
            L93:
                r168 = 0;
                goto L94
            L89:
                r165 = 0;
                goto L90
            L85:
                r162 = 0;
                goto L86
            L81:
                r159 = 0;
                goto L82
            L77:
                r156 = 0;
                goto L78
            L73:
                r153 = 0;
                goto L74
            L69:
                r150 = 0;
                goto L70
            L65:
                r147 = 0;
                goto L66
            L61:
                r144 = 0;
                goto L62
            L57:
                r141 = 0;
                goto L58
            L53:
                r138 = 0;
                goto L54
            L49:
                r135 = 0;
                goto L50
            L45:
                r132 = 0;
                goto L46
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
            public /* bridge */ /* synthetic */ MediaProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MediaProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MediaProperty r101) throws IOException {
                String r102 = r101.key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.size;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.mime;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                Source r106 = r101.source;
                if (r106 == null) goto L17;
                Source.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                ImageSet r107 = r101.image;
                if (r107 == null) goto L20;
                ImageSet.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                Integer r108 = r101.duration;
                if (r108 == null) goto L23;
                ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
            L23:
                String r109 = r101.fs_unit;
                if (r109 == null) goto L26;
                ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
            L26:
                String r110 = r101.crypto_token;
                if (r110 == null) goto L29;
                ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
            L29:
                Boolean r111 = r101.need_copy_img;
                if (r111 == null) goto L32;
                ProtoAdapter.BOOL.encodeWithTag(r100, 10, r111);
            L32:
                Boolean r112 = r101.need_copy_media;
                if (r112 == null) goto L35;
                ProtoAdapter.BOOL.encodeWithTag(r100, 11, r112);
            L35:
                String r113 = r101.compress_path;
                if (r113 == null) goto L38;
                ProtoAdapter.STRING.encodeWithTag(r100, 100, r113);
            L38:
                String r114 = r101.origin_path;
                if (r114 == null) goto L41;
                ProtoAdapter.STRING.encodeWithTag(r100, 101, r114);
            L41:
                ByteString r115 = r101.image_data;
                if (r115 == null) goto L44;
                ProtoAdapter.BYTES.encodeWithTag(r100, 102, r115);
            L44:
                Integer r116 = r101.width;
                if (r116 == null) goto L47;
                ProtoAdapter.INT32.encodeWithTag(r100, 103, r116);
            L47:
                Integer r117 = r101.height;
                if (r117 == null) goto L50;
                ProtoAdapter.INT32.encodeWithTag(r100, 104, r117);
            L50:
                String r118 = r101.url;
                if (r118 == null) goto L53;
                ProtoAdapter.STRING.encodeWithTag(r100, 105, r118);
            L53:
                String r119 = r101.image_path;
                if (r119 == null) goto L56;
                ProtoAdapter.STRING.encodeWithTag(r100, 106, r119);
            L56:
                String r120 = r101.image_upload_id;
                if (r120 == null) goto L59;
                ProtoAdapter.STRING.encodeWithTag(r100, 107, r120);
            L59:
                String r121 = r101.media_upload_id;
                if (r121 == null) goto L62;
                ProtoAdapter.STRING.encodeWithTag(r100, 108, r121);
            L62:
                String r122 = r101.resource_preview_token;
                if (r122 == null) goto L65;
                ProtoAdapter.STRING.encodeWithTag(r100, 109, r122);
            L65:
                Boolean r123 = r101.resource_is_cleaned;
                if (r123 == null) goto L68;
                ProtoAdapter.BOOL.encodeWithTag(r100, 110, r123);
            L68:
                ResourceCleanScene r124 = r101.clean_resource_scene;
                if (r124 == null) goto L71;
                ResourceCleanScene.ADAPTER.encodeWithTag(r100, 111, r124);
            L71:
                String r125 = r101.resource_msg_link_token;
                if (r125 == null) goto L74;
                ProtoAdapter.STRING.encodeWithTag(r100, 112, r125);
            L74:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MediaProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Source extends Enum<Source> implements WireEnum {
            private static final /* synthetic */ Source[] $VALUES = null;
            public static final ProtoAdapter<Source> ADAPTER = null;
            public static final Source LARK = null;
            public static final Source UNKNOWN = null;
            private final int value;

            static {
                Source r100 = new Source("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Source r101 = new Source(AccountType.LARK, 1, 1);
                LARK = r101;
                $VALUES = new Source[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(Source.class);
            }

            public static Source[] values() {
                return (Source[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Source fromValue(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return LARK;
            L10:
                return UNKNOWN;
            }

            public static Source valueOf(String r100) {
                return (Source) a.a(Source.class, r100);
            }

            private Source(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MediaProperty();
            DEFAULT_SIZE = 0L;
            DEFAULT_SOURCE = Source.UNKNOWN;
            DEFAULT_DURATION = 0;
            Boolean r100 = Boolean.FALSE;
            DEFAULT_NEED_COPY_IMG = r100;
            DEFAULT_NEED_COPY_MEDIA = r100;
            DEFAULT_IMAGE_DATA = ByteString.EMPTY;
            DEFAULT_WIDTH = 0;
            DEFAULT_HEIGHT = 0;
            DEFAULT_RESOURCE_IS_CLEANED = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.key = this.key;
            r100.name = this.name;
            r100.size = this.size;
            r100.mime = this.mime;
            r100.source = this.source;
            r100.image = this.image;
            r100.duration = this.duration;
            r100.fs_unit = this.fs_unit;
            r100.crypto_token = this.crypto_token;
            r100.need_copy_img = this.need_copy_img;
            r100.need_copy_media = this.need_copy_media;
            r100.compress_path = this.compress_path;
            r100.origin_path = this.origin_path;
            r100.image_data = this.image_data;
            r100.width = this.width;
            r100.height = this.height;
            r100.url = this.url;
            r100.image_path = this.image_path;
            r100.image_upload_id = this.image_upload_id;
            r100.media_upload_id = this.media_upload_id;
            r100.resource_preview_token = this.resource_preview_token;
            r100.resource_is_cleaned = this.resource_is_cleaned;
            r100.clean_resource_scene = this.clean_resource_scene;
            r100.resource_msg_link_token = this.resource_msg_link_token;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MediaProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MediaProperty(String r210, String r211, Long r212, String r310, Source r311, ImageSet r312, Integer r313, String r314, String r315, Boolean r316, Boolean r317, String r318, String r319, ByteString r410, Integer r411, Integer r412, String r413, String r414, String r415, String r416, String r417, Boolean r418, ResourceCleanScene r419, String r510) {
            this(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, ByteString.EMPTY);
        }

        public MediaProperty(String r100, String r101, Long r102, String r103, Source r104, ImageSet r105, Integer r110, String r111, String r112, Boolean r113, Boolean r114, String r115, String r116, ByteString r117, Integer r118, Integer r119, String r210, String r211, String r212, String r213, String r214, Boolean r215, ResourceCleanScene r216, String r217, ByteString r218) {
            super(ADAPTER, r218);
            this.key = r100;
            this.name = r101;
            this.size = r102;
            this.mime = r103;
            this.source = r104;
            this.image = r105;
            this.duration = r110;
            this.fs_unit = r111;
            this.crypto_token = r112;
            this.need_copy_img = r113;
            this.need_copy_media = r114;
            this.compress_path = r115;
            this.origin_path = r116;
            this.image_data = r117;
            this.width = r118;
            this.height = r119;
            this.url = r210;
            this.image_path = r211;
            this.image_upload_id = r212;
            this.media_upload_id = r213;
            this.resource_preview_token = r214;
            this.resource_is_cleaned = r215;
            this.clean_resource_scene = r216;
            this.resource_msg_link_token = r217;
        }
    }

    public static final class MentionItem extends com.squareup.wire.Message<MentionItem, Builder> {
        public static final ProtoAdapter<MentionItem> ADAPTER = null;
        public static final String DEFAULT_ID = "";
        public static final MentionType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final String f253541id;
        public final MentionType type;

        public static final class Builder extends com.squareup.wire.Message.Builder<MentionItem, Builder> {

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            public String f253542id;
            public MentionType type;

            @Override // com.squareup.wire.Message.Builder
            public MentionItem build() {
                String r100 = this.f253542id;
                if (r100 == null) goto L9;
                if (this.type == null) goto L9;
                return new MentionItem(this.f253542id, this.type, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "id", this.type, "type"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder id(String r100) {
                this.f253542id = r100;
                return this;
            }

            public Builder type(MentionType r100) {
                this.type = r100;
                return this;
            }
        }

        public static final enum MentionType extends Enum<MentionType> implements WireEnum {
            private static final /* synthetic */ MentionType[] $VALUES = null;
            public static final ProtoAdapter<MentionType> ADAPTER = null;
            public static final MentionType HASH_TAG = null;
            public static final MentionType UNKNOWN_MENTION_TYPE = null;
            private final int value;

            static {
                MentionType r100 = new MentionType("UNKNOWN_MENTION_TYPE", 0, 0);
                UNKNOWN_MENTION_TYPE = r100;
                MentionType r101 = new MentionType("HASH_TAG", 1, 1);
                HASH_TAG = r101;
                $VALUES = new MentionType[]{r100, r101};
                ADAPTER = ProtoAdapter.newEnumAdapter(MentionType.class);
            }

            public static MentionType[] values() {
                return (MentionType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static MentionType fromValue(int r100) {
                if (r100 == 0) goto L10;
                if (r100 == 1) goto L8;
                return null;
            L8:
                return HASH_TAG;
            L10:
                return UNKNOWN_MENTION_TYPE;
            }

            public static MentionType valueOf(String r100) {
                return (MentionType) a.a(MentionType.class, r100);
            }

            private MentionType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_MentionItem extends ProtoAdapter<MentionItem> {
            public ProtoAdapter_MentionItem() {
                super(FieldEncoding.LENGTH_DELIMITED, MentionItem.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MentionItem decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.f253542id = "";
                r101.type = MentionType.UNKNOWN_MENTION_TYPE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.f253542id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.type = MentionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MentionItem r100) {
                return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253541id) + MentionType.ADAPTER.encodedSizeWithTag(2, r100.type)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MentionItem decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MentionItem r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MentionItem r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253541id);
                MentionType.ADAPTER.encodeWithTag(r100, 2, r101.type);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MentionItem r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MentionItem();
            DEFAULT_TYPE = MentionType.UNKNOWN_MENTION_TYPE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.f253542id = this.f253541id;
            r100.type = this.type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MentionItem.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MentionItem(String r100, MentionType r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public MentionItem(String r100, MentionType r101, ByteString r102) {
            super(ADAPTER, r102);
            this.f253541id = r100;
            this.type = r101;
        }
    }

    public static final class MentionProperty extends com.squareup.wire.Message<MentionProperty, Builder> {
        public static final ProtoAdapter<MentionProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        private static final long serialVersionUID = 0;
        public final String content;
        public final MentionItem item;

        public static final class Builder extends com.squareup.wire.Message.Builder<MentionProperty, Builder> {
            public String content;
            public MentionItem item;

            @Override // com.squareup.wire.Message.Builder
            public MentionProperty build() {
                MentionItem r100 = this.item;
                if (r100 == null) goto L9;
                if (this.content == null) goto L9;
                return new MentionProperty(this.item, this.content, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, MapController.ITEM_LAYER_TAG, this.content, "content"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder item(MentionItem r100) {
                this.item = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MentionProperty extends ProtoAdapter<MentionProperty> {
            public ProtoAdapter_MentionProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, MentionProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MentionProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.content = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.item = MentionItem.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MentionProperty r100) {
                return (MentionItem.ADAPTER.encodedSizeWithTag(1, r100.item) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.content)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ MentionProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MentionProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MentionProperty r101) throws IOException {
                MentionItem.ADAPTER.encodeWithTag(r100, 1, r101.item);
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.content);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MentionProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MentionProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.item = this.item;
            r100.content = this.content;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MentionProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MentionProperty(MentionItem r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public MentionProperty(MentionItem r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.item = r100;
            this.content = r101;
        }
    }

    public static final class MenuOption extends com.squareup.wire.Message<MenuOption, Builder> {
        public static final ProtoAdapter<MenuOption> ADAPTER = null;
        public static final String DEFAULT_OPTION_ACTION_ID = "";
        public static final String DEFAULT_TEXT = "";
        public static final String DEFAULT_TEXT_I18N_KEY = "";
        public static final String DEFAULT_VALUE = "";
        private static final long serialVersionUID = 0;
        public final String option_action_id;
        public final String text;
        public final String text_i18n_key;
        public final CardAction.Url url;
        public final String value;

        public static final class Builder extends com.squareup.wire.Message.Builder<MenuOption, Builder> {
            public String option_action_id;
            public String text;
            public String text_i18n_key;
            public CardAction.Url url;
            public String value;

            @Override // com.squareup.wire.Message.Builder
            public MenuOption build() {
                return new MenuOption(this.text, this.text_i18n_key, this.value, this.url, this.option_action_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder option_action_id(String r100) {
                this.option_action_id = r100;
                return this;
            }

            public Builder text(String r100) {
                this.text = r100;
                return this;
            }

            public Builder text_i18n_key(String r100) {
                this.text_i18n_key = r100;
                return this;
            }

            public Builder url(CardAction.Url r100) {
                this.url = r100;
                return this;
            }

            public Builder value(String r100) {
                this.value = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MenuOption extends ProtoAdapter<MenuOption> {
            public ProtoAdapter_MenuOption() {
                super(FieldEncoding.LENGTH_DELIMITED, MenuOption.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MenuOption decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.text = "";
                r101.text_i18n_key = "";
                r101.value = "";
                r101.option_action_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.text = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.text_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.value = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.url = CardAction.Url.ADAPTER.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.option_action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(MenuOption r100) {
                String r101 = r100.text;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.text_i18n_key;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.value;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                CardAction.Url r110 = r100.url;
                if (r110 == null) goto L17;
                int r111 = CardAction.Url.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.option_action_id;
                if (r113 == null) goto L22;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                return (r112 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ MenuOption decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MenuOption r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MenuOption r101) throws IOException {
                String r102 = r101.text;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.text_i18n_key;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.value;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                CardAction.Url r105 = r101.url;
                if (r105 == null) goto L14;
                CardAction.Url.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.option_action_id;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MenuOption r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MenuOption();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.text = this.text;
            r100.text_i18n_key = this.text_i18n_key;
            r100.value = this.value;
            r100.url = this.url;
            r100.option_action_id = this.option_action_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MenuOption.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MenuOption(String r100, String r101, String r110, CardAction.Url r111, String r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public MenuOption(String r100, String r101, String r102, CardAction.Url r103, String r104, ByteString r105) {
            super(ADAPTER, r105);
            this.text = r100;
            this.text_i18n_key = r101;
            this.value = r102;
            this.url = r103;
            this.option_action_id = r104;
        }
    }

    public static final class MyAIToolProperty extends com.squareup.wire.Message<MyAIToolProperty, Builder> {
        public static final ProtoAdapter<MyAIToolProperty> ADAPTER = null;
        public static final Icon DEFAULT_ICON = null;
        public static final String DEFAULT_NAME = "";
        public static final Status DEFAULT_STATUS = null;
        public static final String DEFAULT_TEXT = "";
        public static final String DEFAULT_TOOL_ID = "";
        public static final String DEFAULT_TOOL_RUNTIME_ID = "";
        private static final long serialVersionUID = 0;
        public final Map<String, String> i18n_name;
        public final Icon icon;
        public final String name;
        public final Status status;
        public final String text;
        public final String tool_id;
        public final String tool_runtime_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<MyAIToolProperty, Builder> {
            public Map<String, String> i18n_name;
            public Icon icon;
            public String name;
            public Status status;
            public String text;
            public String tool_id;
            public String tool_runtime_id;

            @Override // com.squareup.wire.Message.Builder
            public MyAIToolProperty build() {
                return new MyAIToolProperty(this.tool_id, this.tool_runtime_id, this.status, this.i18n_name, this.name, this.text, this.icon, super.buildUnknownFields());
            }

            public Builder() {
                this.i18n_name = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder i18n_name(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.i18n_name = r100;
                return this;
            }

            public Builder icon(Icon r100) {
                this.icon = r100;
                return this;
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }

            public Builder status(Status r100) {
                this.status = r100;
                return this;
            }

            public Builder text(String r100) {
                this.text = r100;
                return this;
            }

            public Builder tool_id(String r100) {
                this.tool_id = r100;
                return this;
            }

            public Builder tool_runtime_id(String r100) {
                this.tool_runtime_id = r100;
                return this;
            }
        }

        public static final enum Icon extends Enum<Icon> implements WireEnum {
            private static final /* synthetic */ Icon[] $VALUES = null;
            public static final ProtoAdapter<Icon> ADAPTER = null;
            public static final Icon ANALYZING = null;
            public static final Icon GENERATING = null;
            public static final Icon LOADING = null;
            public static final Icon NONE = null;
            public static final Icon RETRIEVING = null;
            private final int value;

            static {
                Icon r100 = new Icon("LOADING", 0, 0);
                LOADING = r100;
                Icon r101 = new Icon("ANALYZING", 1, 1);
                ANALYZING = r101;
                Icon r102 = new Icon("RETRIEVING", 2, 2);
                RETRIEVING = r102;
                Icon r103 = new Icon("GENERATING", 3, 3);
                GENERATING = r103;
                Icon r104 = new Icon(UserProfileEvent.POSITION_NONE, 4, 4);
                NONE = r104;
                $VALUES = new Icon[]{r100, r101, r102, r103, r104};
                ADAPTER = ProtoAdapter.newEnumAdapter(Icon.class);
            }

            public static Icon[] values() {
                return (Icon[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Icon fromValue(int r100) {
                if (r100 == 0) goto L22;
                if (r100 == 1) goto L20;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L16;
                if (r100 == 4) goto L14;
                return null;
            L14:
                return NONE;
            L16:
                return GENERATING;
            L18:
                return RETRIEVING;
            L20:
                return ANALYZING;
            L22:
                return LOADING;
            }

            public static Icon valueOf(String r100) {
                return (Icon) a.a(Icon.class, r100);
            }

            private Icon(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class ProtoAdapter_MyAIToolProperty extends ProtoAdapter<MyAIToolProperty> {
            private final ProtoAdapter<Map<String, String>> i18n_name;

            public ProtoAdapter_MyAIToolProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, MyAIToolProperty.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.i18n_name = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MyAIToolProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.tool_id = "";
                r101.tool_runtime_id = "";
                r101.status = Status.RUNING;
                r101.name = "";
                r101.text = "";
                r101.icon = Icon.LOADING;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L20;
                switch(r103) {
                    case 1: goto L19;
                    case 2: goto L18;
                    case 3: goto L22;
                    case 4: goto L13;
                    case 5: goto L12;
                    case 6: goto L11;
                    case 7: goto L24;
                    default: goto L6;
                };
            L22:
                r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L24:
                r101.icon = Icon.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r101.text = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.i18n_name.putAll(this.i18n_name.decode(r100));
                goto L3
            L18:
                r101.tool_runtime_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L19:
                r101.tool_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(MyAIToolProperty r100) {
                String r101 = r100.tool_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.tool_runtime_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Status r107 = r100.status;
                if (r107 == null) goto L13;
                int r108 = Status.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = (r106 + r108) + this.i18n_name.encodedSizeWithTag(4, r100.i18n_name);
                String r110 = r100.name;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(5, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.text;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(6, r113);
            L22:
                int r115 = r112 + r114;
                Icon r116 = r100.icon;
                if (r116 == null) goto L26;
                r102 = Icon.ADAPTER.encodedSizeWithTag(7, r116);
            L26:
                return (r115 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ MyAIToolProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(MyAIToolProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, MyAIToolProperty r101) throws IOException {
                String r102 = r101.tool_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.tool_runtime_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Status r104 = r101.status;
                if (r104 == null) goto L11;
                Status.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                this.i18n_name.encodeWithTag(r100, 4, r101.i18n_name);
                String r105 = r101.name;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
            L14:
                String r106 = r101.text;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
            L17:
                Icon r107 = r101.icon;
                if (r107 == null) goto L20;
                Icon.ADAPTER.encodeWithTag(r100, 7, r107);
            L20:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MyAIToolProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Status extends Enum<Status> implements WireEnum {
            private static final /* synthetic */ Status[] $VALUES = null;
            public static final ProtoAdapter<Status> ADAPTER = null;
            public static final Status FAILED = null;
            public static final Status RUNING = null;
            public static final Status SUCCESS = null;
            private final int value;

            static {
                Status r100 = new Status("RUNING", 0, 0);
                RUNING = r100;
                Status r101 = new Status("SUCCESS", 1, 1);
                SUCCESS = r101;
                Status r102 = new Status("FAILED", 2, 2);
                FAILED = r102;
                $VALUES = new Status[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
            }

            public static Status[] values() {
                return (Status[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Status fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return FAILED;
            L12:
                return SUCCESS;
            L14:
                return RUNING;
            }

            public static Status valueOf(String r100) {
                return (Status) a.a(Status.class, r100);
            }

            private Status(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MyAIToolProperty();
            DEFAULT_STATUS = Status.RUNING;
            DEFAULT_ICON = Icon.LOADING;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.tool_id = this.tool_id;
            r100.tool_runtime_id = this.tool_runtime_id;
            r100.status = this.status;
            r100.i18n_name = Internal.copyOf("i18n_name", this.i18n_name);
            r100.name = this.name;
            r100.text = this.text;
            r100.icon = this.icon;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return MyAIToolProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public MyAIToolProperty(String r110, String r111, Status r112, Map<String, String> r113, String r114, String r115, Icon r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public MyAIToolProperty(String r100, String r101, Status r102, Map<String, String> r103, String r104, String r105, Icon r106, ByteString r107) {
            super(ADAPTER, r107);
            this.tool_id = r100;
            this.tool_runtime_id = r101;
            this.status = r102;
            this.i18n_name = Internal.immutableCopyOf("i18n_name", r103);
            this.name = r104;
            this.text = r105;
            this.icon = r106;
        }
    }

    public static final class OLProperty extends com.squareup.wire.Message<OLProperty, Builder> {
        public static final ProtoAdapter<OLProperty> ADAPTER = null;
        public static final Integer DEFAULT_START = null;
        public static final Type DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final Integer start;
        public final Type type;

        public static final class Builder extends com.squareup.wire.Message.Builder<OLProperty, Builder> {
            public Integer start;
            public Type type;

            @Override // com.squareup.wire.Message.Builder
            public OLProperty build() {
                return new OLProperty(this.type, this.start, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder start(Integer r100) {
                this.start = r100;
                return this;
            }

            public Builder type(Type r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OLProperty extends ProtoAdapter<OLProperty> {
            public ProtoAdapter_OLProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, OLProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OLProperty decode(ProtoReader r110) throws IOException {
                Builder r100 = new Builder();
                r100.type = Type.NUMBER;
                r100.start = 1;
                long r101 = r110.beginMessage();
            L3:
                int r102 = r110.nextTag();
                if (r102 == (-1)) goto L14;
                if (r102 != 1) goto L7;
                r100.type = Type.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r100.addUnknownField(r102, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                if (r102 != 2) goto L8;
                r100.start = ProtoAdapter.INT32.decode(r110);
                goto L3
            L8:
                FieldEncoding r103 = r110.peekFieldEncoding();
                r100.addUnknownField(r102, r103, r103.rawProtoAdapter().decode(r110));
                goto L3
            L14:
                r110.endMessage(r101);
                return r100.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(OLProperty r100) {
                Type r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.start;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OLProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OLProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OLProperty r101) throws IOException {
                Type r102 = r101.type;
                if (r102 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.start;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OLProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type LOWERCASE_A = null;
            public static final Type LOWERCASE_ROMAN = null;
            public static final Type NONE = null;
            public static final Type NUMBER = null;
            public static final Type UPPERCASE_A = null;
            public static final Type UPPERCASE_ROMAN = null;
            private final int value;

            static {
                Type r100 = new Type("NUMBER", 0, 0);
                NUMBER = r100;
                Type r101 = new Type("LOWERCASE_A", 1, 1);
                LOWERCASE_A = r101;
                Type r102 = new Type("UPPERCASE_A", 2, 2);
                UPPERCASE_A = r102;
                Type r103 = new Type("LOWERCASE_ROMAN", 3, 3);
                LOWERCASE_ROMAN = r103;
                Type r104 = new Type("UPPERCASE_ROMAN", 4, 4);
                UPPERCASE_ROMAN = r104;
                Type r105 = new Type(UserProfileEvent.POSITION_NONE, 5, 5);
                NONE = r105;
                $VALUES = new Type[]{r100, r101, r102, r103, r104, r105};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r100) {
                if (r100 == 0) goto L26;
                if (r100 == 1) goto L24;
                if (r100 == 2) goto L22;
                if (r100 == 3) goto L20;
                if (r100 == 4) goto L18;
                if (r100 == 5) goto L16;
                return null;
            L16:
                return NONE;
            L18:
                return UPPERCASE_ROMAN;
            L20:
                return LOWERCASE_ROMAN;
            L22:
                return UPPERCASE_A;
            L24:
                return LOWERCASE_A;
            L26:
                return NUMBER;
            }

            public static Type valueOf(String r100) {
                return (Type) a.a(Type.class, r100);
            }

            private Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OLProperty();
            DEFAULT_TYPE = Type.NUMBER;
            DEFAULT_START = 1;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.start = this.start;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OLProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public OLProperty(Type r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public OLProperty(Type r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.type = r100;
            this.start = r101;
        }
    }

    public static final class OverflowMenuProperty extends com.squareup.wire.Message<OverflowMenuProperty, Builder> {
        public static final ProtoAdapter<OverflowMenuProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final Boolean DEFAULT_DISABLE = null;
        public static final Boolean DEFAULT_IS_LOADING = null;
        private static final long serialVersionUID = 0;
        public final String action_id;
        public final ButtonConfirmProperty confirm;
        public final Boolean disable;
        public final Boolean is_loading;
        public final List<MenuOption> options;

        public static final class Builder extends com.squareup.wire.Message.Builder<OverflowMenuProperty, Builder> {
            public String action_id;
            public ButtonConfirmProperty confirm;
            public Boolean disable;
            public Boolean is_loading;
            public List<MenuOption> options;

            @Override // com.squareup.wire.Message.Builder
            public OverflowMenuProperty build() {
                return new OverflowMenuProperty(this.action_id, this.options, this.confirm, this.disable, this.is_loading, super.buildUnknownFields());
            }

            public Builder() {
                this.options = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.action_id = r100;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r100) {
                this.confirm = r100;
                return this;
            }

            public Builder disable(Boolean r100) {
                this.disable = r100;
                return this;
            }

            public Builder is_loading(Boolean r100) {
                this.is_loading = r100;
                return this;
            }

            public Builder options(List<MenuOption> r100) {
                Internal.checkElementsNotNull(r100);
                this.options = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OverflowMenuProperty extends ProtoAdapter<OverflowMenuProperty> {
            public ProtoAdapter_OverflowMenuProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, OverflowMenuProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OverflowMenuProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.action_id = "";
                Boolean r102 = Boolean.FALSE;
                r101.disable = r102;
                r101.is_loading = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L21;
                if (r104 != 1) goto L8;
                r101.action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r104 != 2) goto L10;
                r101.options.add(MenuOption.ADAPTER.decode(r100));
                goto L3
            L10:
                if (r104 != 3) goto L12;
                r101.confirm = ButtonConfirmProperty.ADAPTER.decode(r100);
                goto L3
            L12:
                if (r104 != 4) goto L14;
                r101.disable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L14:
                if (r104 != 5) goto L15;
                r101.is_loading = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L15:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(OverflowMenuProperty r100) {
                String r101 = r100.action_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                int r104 = r103 + MenuOption.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.options);
                ButtonConfirmProperty r105 = r100.confirm;
                if (r105 == null) goto L9;
                int r106 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(3, r105);
            L10:
                int r107 = r104 + r106;
                Boolean r108 = r100.disable;
                if (r108 == null) goto L13;
                int r109 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r108);
            L14:
                int r110 = r107 + r109;
                Boolean r111 = r100.is_loading;
                if (r111 == null) goto L18;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r111);
            L18:
                return (r110 + r102) + r100.unknownFields().size();
            L13:
                r109 = 0;
                goto L14
            L9:
                r106 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OverflowMenuProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OverflowMenuProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OverflowMenuProperty r101) throws IOException {
                String r102 = r101.action_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                MenuOption.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.options);
                ButtonConfirmProperty r103 = r101.confirm;
                if (r103 == null) goto L8;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r100, 3, r103);
            L8:
                Boolean r104 = r101.disable;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
            L11:
                Boolean r105 = r101.is_loading;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OverflowMenuProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OverflowMenuProperty();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_DISABLE = r100;
            DEFAULT_IS_LOADING = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.action_id = this.action_id;
            r100.options = Internal.copyOf("options", this.options);
            r100.confirm = this.confirm;
            r100.disable = this.disable;
            r100.is_loading = this.is_loading;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OverflowMenuProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public OverflowMenuProperty(String r100, List<MenuOption> r101, ButtonConfirmProperty r110, Boolean r111, Boolean r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public OverflowMenuProperty(String r100, List<MenuOption> r101, ButtonConfirmProperty r102, Boolean r103, Boolean r104, ByteString r105) {
            super(ADAPTER, r105);
            this.action_id = r100;
            this.options = Internal.immutableCopyOf("options", r101);
            this.confirm = r102;
            this.disable = r103;
            this.is_loading = r104;
        }
    }

    public static final class ParagraphProperty extends com.squareup.wire.Message<ParagraphProperty, Builder> {
        public static final ProtoAdapter<ParagraphProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ParagraphProperty, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public ParagraphProperty build() {
                return new ParagraphProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_ParagraphProperty extends ProtoAdapter<ParagraphProperty> {
            public ProtoAdapter_ParagraphProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ParagraphProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ParagraphProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ParagraphProperty r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ParagraphProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ParagraphProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ParagraphProperty r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ParagraphProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ParagraphProperty();
        }

        public ParagraphProperty() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ParagraphProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ParagraphProperty(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class ProgressSelectOptionProperty extends com.squareup.wire.Message<ProgressSelectOptionProperty, Builder> {
        public static final ProtoAdapter<ProgressSelectOptionProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_ACTION_PARAM_NAME = "";
        public static final String DEFAULT_ACTION_PARAM_VALUE = "";
        public static final String DEFAULT_CONTENT = "";
        public static final Boolean DEFAULT_DISABLE = null;
        public static final Integer DEFAULT_NUMBER_OF_SELECTED = null;
        public static final Integer DEFAULT_NUMBER_OF_TOTAL = null;
        public static final String DEFAULT_OPTION_CASE = "";
        public static final Boolean DEFAULT_SELECTED = null;
        private static final long serialVersionUID = 0;
        public final String action_id;
        public final String action_param_name;
        public final String action_param_value;
        public final String content;
        public final Boolean disable;
        public final Integer number_of_selected;
        public final Integer number_of_total;
        public final String option_case;
        public final Boolean selected;

        public static final class Builder extends com.squareup.wire.Message.Builder<ProgressSelectOptionProperty, Builder> {
            public String action_id;
            public String action_param_name;
            public String action_param_value;
            public String content;
            public Boolean disable;
            public Integer number_of_selected;
            public Integer number_of_total;
            public String option_case;
            public Boolean selected;

            @Override // com.squareup.wire.Message.Builder
            public ProgressSelectOptionProperty build() {
                return new ProgressSelectOptionProperty(this.action_id, this.action_param_name, this.action_param_value, this.disable, this.selected, this.option_case, this.content, this.number_of_selected, this.number_of_total, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.action_id = r100;
                return this;
            }

            public Builder action_param_name(String r100) {
                this.action_param_name = r100;
                return this;
            }

            public Builder action_param_value(String r100) {
                this.action_param_value = r100;
                return this;
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder disable(Boolean r100) {
                this.disable = r100;
                return this;
            }

            public Builder number_of_selected(Integer r100) {
                this.number_of_selected = r100;
                return this;
            }

            public Builder number_of_total(Integer r100) {
                this.number_of_total = r100;
                return this;
            }

            public Builder option_case(String r100) {
                this.option_case = r100;
                return this;
            }

            public Builder selected(Boolean r100) {
                this.selected = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ProgressSelectOptionProperty extends ProtoAdapter<ProgressSelectOptionProperty> {
            public ProtoAdapter_ProgressSelectOptionProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ProgressSelectOptionProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ProgressSelectOptionProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.action_id = "";
                r101.action_param_name = "";
                r101.action_param_value = "";
                Boolean r102 = Boolean.FALSE;
                r101.disable = r102;
                r101.selected = r102;
                r101.option_case = "";
                r101.content = "";
                r101.number_of_selected = 0;
                r101.number_of_total = 0;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L16;
                switch(r104) {
                    case 1: goto L15;
                    case 2: goto L14;
                    case 3: goto L13;
                    case 4: goto L12;
                    case 5: goto L11;
                    case 6: goto L10;
                    case 7: goto L9;
                    case 8: goto L8;
                    case 9: goto L7;
                    default: goto L6;
                };
            L7:
                r101.number_of_total = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                r101.number_of_selected = ProtoAdapter.INT32.decode(r100);
                goto L3
            L9:
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.option_case = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.selected = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.disable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.action_param_value = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.action_param_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L16:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ProgressSelectOptionProperty r100) {
                String r101 = r100.action_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.action_param_name;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.action_param_value;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.disable;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Boolean r113 = r100.selected;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.option_case;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                String r119 = r100.content;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                Integer r122 = r100.number_of_selected;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.INT32.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                Integer r125 = r100.number_of_total;
                if (r125 == null) goto L38;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(9, r125);
            L38:
                return (r124 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ ProgressSelectOptionProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ProgressSelectOptionProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ProgressSelectOptionProperty r101) throws IOException {
                String r102 = r101.action_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.action_param_name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.action_param_value;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.disable;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                Boolean r106 = r101.selected;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
            L17:
                String r107 = r101.option_case;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
            L20:
                String r108 = r101.content;
                if (r108 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
            L23:
                Integer r109 = r101.number_of_selected;
                if (r109 == null) goto L26;
                ProtoAdapter.INT32.encodeWithTag(r100, 8, r109);
            L26:
                Integer r110 = r101.number_of_total;
                if (r110 == null) goto L29;
                ProtoAdapter.INT32.encodeWithTag(r100, 9, r110);
            L29:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ProgressSelectOptionProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ProgressSelectOptionProperty();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_DISABLE = r100;
            DEFAULT_SELECTED = r100;
            DEFAULT_NUMBER_OF_SELECTED = 0;
            DEFAULT_NUMBER_OF_TOTAL = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.action_id = this.action_id;
            r100.action_param_name = this.action_param_name;
            r100.action_param_value = this.action_param_value;
            r100.disable = this.disable;
            r100.selected = this.selected;
            r100.option_case = this.option_case;
            r100.content = this.content;
            r100.number_of_selected = this.number_of_selected;
            r100.number_of_total = this.number_of_total;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ProgressSelectOptionProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ProgressSelectOptionProperty(String r110, String r111, String r112, Boolean r113, Boolean r114, String r115, String r116, Integer r117, Integer r210) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
        }

        public ProgressSelectOptionProperty(String r100, String r101, String r102, Boolean r103, Boolean r104, String r105, String r106, Integer r107, Integer r110, ByteString r111) {
            super(ADAPTER, r111);
            this.action_id = r100;
            this.action_param_name = r101;
            this.action_param_value = r102;
            this.disable = r103;
            this.selected = r104;
            this.option_case = r105;
            this.content = r106;
            this.number_of_selected = r107;
            this.number_of_total = r110;
        }
    }

    public static final class PropertySet extends com.squareup.wire.Message<PropertySet, Builder> {
        public static final ProtoAdapter<PropertySet> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final AnchorProperty anchor;

        /* JADX INFO: renamed from: at, reason: collision with root package name */
        public final AtProperty f253543at;
        public final AtUserGroupProperty at_user_group;
        public final BoldProperty bold;
        public final ButtonProperty button;
        public final CodeProperty code;
        public final CodeBlockProperty code_block;
        public final CodeBlockV2Property code_block_v2;
        public final ColumnProperty column;
        public final ColumnsProperty columns;
        public final DatePickerProperty date_picker;
        public final DatetimePickerProperty datetime_picker;
        public final DivProperty div;
        public final DocsProperty docs;
        public final EmotionProperty emotion;
        public final FigureProperty figure;

        /* JADX INFO: renamed from: h1, reason: collision with root package name */
        public final H1Property f253544h1;

        /* JADX INFO: renamed from: h2, reason: collision with root package name */
        public final H2Property f253545h2;

        /* JADX INFO: renamed from: h3, reason: collision with root package name */
        public final H3Property f253546h3;

        /* JADX INFO: renamed from: h4, reason: collision with root package name */
        public final H4Property f253547h4;

        /* JADX INFO: renamed from: h5, reason: collision with root package name */
        public final H5Property f253548h5;

        /* JADX INFO: renamed from: h6, reason: collision with root package name */
        public final H6Property f253549h6;

        /* JADX INFO: renamed from: hr, reason: collision with root package name */
        public final HRProperty f253550hr;
        public final ImageProperty image;
        public final ImageGalleryProperty image_gallery;
        public final ItalicProperty italic;

        /* JADX INFO: renamed from: li, reason: collision with root package name */
        public final LIProperty f253551li;
        public final LinkProperty link;
        public final MarkdownProperty markdown;
        public final MediaProperty media;
        public final MentionProperty mention;
        public final MyAIToolProperty my_ai_tool;

        /* JADX INFO: renamed from: ol, reason: collision with root package name */
        public final OLProperty f253552ol;
        public final OverflowMenuProperty overflow_menu;
        public final ParagraphProperty paragraph;
        public final ProgressSelectOptionProperty progress;
        public final QuoteProperty quote;
        public final ReactionProperty reaction;
        public final SelectProperty select;
        public final SelectMenuProperty select_menu;
        public final TableProperty table;
        public final TableCellProperty table_cell;
        public final TableRowProperty table_row;
        public final TextProperty text;
        public final TextableAreaProperty textable_area;
        public final TimeProperty time;
        public final TimePickerProperty time_picker;

        /* JADX INFO: renamed from: ul, reason: collision with root package name */
        public final ULProperty f253553ul;
        public final UnderlineProperty underline;
        public final UnknownProperty unknown;

        public static final class Builder extends com.squareup.wire.Message.Builder<PropertySet, Builder> {
            public AnchorProperty anchor;

            /* JADX INFO: renamed from: at, reason: collision with root package name */
            public AtProperty f253554at;
            public AtUserGroupProperty at_user_group;
            public BoldProperty bold;
            public ButtonProperty button;
            public CodeProperty code;
            public CodeBlockProperty code_block;
            public CodeBlockV2Property code_block_v2;
            public ColumnProperty column;
            public ColumnsProperty columns;
            public DatePickerProperty date_picker;
            public DatetimePickerProperty datetime_picker;
            public DivProperty div;
            public DocsProperty docs;
            public EmotionProperty emotion;
            public FigureProperty figure;

            /* JADX INFO: renamed from: h1, reason: collision with root package name */
            public H1Property f253555h1;

            /* JADX INFO: renamed from: h2, reason: collision with root package name */
            public H2Property f253556h2;

            /* JADX INFO: renamed from: h3, reason: collision with root package name */
            public H3Property f253557h3;

            /* JADX INFO: renamed from: h4, reason: collision with root package name */
            public H4Property f253558h4;

            /* JADX INFO: renamed from: h5, reason: collision with root package name */
            public H5Property f253559h5;

            /* JADX INFO: renamed from: h6, reason: collision with root package name */
            public H6Property f253560h6;

            /* JADX INFO: renamed from: hr, reason: collision with root package name */
            public HRProperty f253561hr;
            public ImageProperty image;
            public ImageGalleryProperty image_gallery;
            public ItalicProperty italic;

            /* JADX INFO: renamed from: li, reason: collision with root package name */
            public LIProperty f253562li;
            public LinkProperty link;
            public MarkdownProperty markdown;
            public MediaProperty media;
            public MentionProperty mention;
            public MyAIToolProperty my_ai_tool;

            /* JADX INFO: renamed from: ol, reason: collision with root package name */
            public OLProperty f253563ol;
            public OverflowMenuProperty overflow_menu;
            public ParagraphProperty paragraph;
            public ProgressSelectOptionProperty progress;
            public QuoteProperty quote;
            public ReactionProperty reaction;
            public SelectProperty select;
            public SelectMenuProperty select_menu;
            public TableProperty table;
            public TableCellProperty table_cell;
            public TableRowProperty table_row;
            public TextProperty text;
            public TextableAreaProperty textable_area;
            public TimeProperty time;
            public TimePickerProperty time_picker;

            /* JADX INFO: renamed from: ul, reason: collision with root package name */
            public ULProperty f253564ul;
            public UnderlineProperty underline;
            public UnknownProperty unknown;

            @Override // com.squareup.wire.Message.Builder
            public PropertySet build() {
                return new PropertySet(this.paragraph, this.figure, this.text, this.italic, this.bold, this.underline, this.anchor, this.f253554at, this.image, this.emotion, this.button, this.select, this.progress, this.div, this.textable_area, this.time, this.link, this.media, this.select_menu, this.overflow_menu, this.date_picker, this.docs, this.f253555h1, this.f253556h2, this.f253557h3, this.f253564ul, this.f253563ol, this.f253562li, this.quote, this.code, this.code_block, this.f253561hr, this.time_picker, this.datetime_picker, this.reaction, this.mention, this.code_block_v2, this.my_ai_tool, this.f253558h4, this.f253559h5, this.f253560h6, this.table, this.table_row, this.table_cell, this.columns, this.column, this.at_user_group, this.image_gallery, this.markdown, this.unknown, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder anchor(AnchorProperty r100) {
                this.anchor = r100;
                return this;
            }

            public Builder at(AtProperty r100) {
                this.f253554at = r100;
                return this;
            }

            public Builder at_user_group(AtUserGroupProperty r100) {
                this.at_user_group = r100;
                return this;
            }

            public Builder bold(BoldProperty r100) {
                this.bold = r100;
                return this;
            }

            public Builder button(ButtonProperty r100) {
                this.button = r100;
                return this;
            }

            public Builder code(CodeProperty r100) {
                this.code = r100;
                return this;
            }

            public Builder code_block(CodeBlockProperty r100) {
                this.code_block = r100;
                return this;
            }

            public Builder code_block_v2(CodeBlockV2Property r100) {
                this.code_block_v2 = r100;
                return this;
            }

            public Builder column(ColumnProperty r100) {
                this.column = r100;
                return this;
            }

            public Builder columns(ColumnsProperty r100) {
                this.columns = r100;
                return this;
            }

            public Builder date_picker(DatePickerProperty r100) {
                this.date_picker = r100;
                return this;
            }

            public Builder datetime_picker(DatetimePickerProperty r100) {
                this.datetime_picker = r100;
                return this;
            }

            public Builder div(DivProperty r100) {
                this.div = r100;
                return this;
            }

            public Builder docs(DocsProperty r100) {
                this.docs = r100;
                return this;
            }

            public Builder emotion(EmotionProperty r100) {
                this.emotion = r100;
                return this;
            }

            public Builder figure(FigureProperty r100) {
                this.figure = r100;
                return this;
            }

            public Builder h1(H1Property r100) {
                this.f253555h1 = r100;
                return this;
            }

            public Builder h2(H2Property r100) {
                this.f253556h2 = r100;
                return this;
            }

            public Builder h3(H3Property r100) {
                this.f253557h3 = r100;
                return this;
            }

            public Builder h4(H4Property r100) {
                this.f253558h4 = r100;
                return this;
            }

            public Builder h5(H5Property r100) {
                this.f253559h5 = r100;
                return this;
            }

            public Builder h6(H6Property r100) {
                this.f253560h6 = r100;
                return this;
            }

            public Builder hr(HRProperty r100) {
                this.f253561hr = r100;
                return this;
            }

            public Builder image(ImageProperty r100) {
                this.image = r100;
                return this;
            }

            public Builder image_gallery(ImageGalleryProperty r100) {
                this.image_gallery = r100;
                return this;
            }

            public Builder italic(ItalicProperty r100) {
                this.italic = r100;
                return this;
            }

            public Builder li(LIProperty r100) {
                this.f253562li = r100;
                return this;
            }

            public Builder link(LinkProperty r100) {
                this.link = r100;
                return this;
            }

            public Builder markdown(MarkdownProperty r100) {
                this.markdown = r100;
                return this;
            }

            public Builder media(MediaProperty r100) {
                this.media = r100;
                return this;
            }

            public Builder mention(MentionProperty r100) {
                this.mention = r100;
                return this;
            }

            public Builder my_ai_tool(MyAIToolProperty r100) {
                this.my_ai_tool = r100;
                return this;
            }

            public Builder ol(OLProperty r100) {
                this.f253563ol = r100;
                return this;
            }

            public Builder overflow_menu(OverflowMenuProperty r100) {
                this.overflow_menu = r100;
                return this;
            }

            public Builder paragraph(ParagraphProperty r100) {
                this.paragraph = r100;
                return this;
            }

            public Builder progress(ProgressSelectOptionProperty r100) {
                this.progress = r100;
                return this;
            }

            public Builder quote(QuoteProperty r100) {
                this.quote = r100;
                return this;
            }

            public Builder reaction(ReactionProperty r100) {
                this.reaction = r100;
                return this;
            }

            public Builder select(SelectProperty r100) {
                this.select = r100;
                return this;
            }

            public Builder select_menu(SelectMenuProperty r100) {
                this.select_menu = r100;
                return this;
            }

            public Builder table(TableProperty r100) {
                this.table = r100;
                return this;
            }

            public Builder table_cell(TableCellProperty r100) {
                this.table_cell = r100;
                return this;
            }

            public Builder table_row(TableRowProperty r100) {
                this.table_row = r100;
                return this;
            }

            public Builder text(TextProperty r100) {
                this.text = r100;
                return this;
            }

            public Builder textable_area(TextableAreaProperty r100) {
                this.textable_area = r100;
                return this;
            }

            public Builder time(TimeProperty r100) {
                this.time = r100;
                return this;
            }

            public Builder time_picker(TimePickerProperty r100) {
                this.time_picker = r100;
                return this;
            }

            public Builder ul(ULProperty r100) {
                this.f253564ul = r100;
                return this;
            }

            public Builder underline(UnderlineProperty r100) {
                this.underline = r100;
                return this;
            }

            public Builder unknown(UnknownProperty r100) {
                this.unknown = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_PropertySet extends ProtoAdapter<PropertySet> {
            public ProtoAdapter_PropertySet() {
                super(FieldEncoding.LENGTH_DELIMITED, PropertySet.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PropertySet decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L59;
                if (r103 != 404) goto L7;
                r101.unknown = UnknownProperty.ADAPTER.decode(r100);
                goto L3
            L7:
                switch(r103) {
                    case 1: goto L57;
                    case 2: goto L56;
                    case 3: goto L55;
                    case 4: goto L54;
                    case 5: goto L53;
                    case 6: goto L52;
                    case 7: goto L51;
                    case 8: goto L50;
                    case 9: goto L49;
                    case 10: goto L48;
                    case 11: goto L47;
                    case 12: goto L46;
                    case 13: goto L45;
                    case 14: goto L44;
                    case 15: goto L43;
                    case 16: goto L42;
                    case 17: goto L41;
                    case 18: goto L40;
                    case 19: goto L39;
                    case 20: goto L38;
                    case 21: goto L37;
                    case 22: goto L36;
                    case 23: goto L35;
                    case 24: goto L34;
                    case 25: goto L33;
                    case 26: goto L32;
                    case 27: goto L31;
                    case 28: goto L30;
                    case 29: goto L29;
                    case 30: goto L28;
                    case 31: goto L27;
                    case 32: goto L26;
                    case 33: goto L25;
                    case 34: goto L24;
                    case 35: goto L23;
                    case 36: goto L22;
                    case 37: goto L21;
                    case 38: goto L20;
                    case 39: goto L19;
                    case 40: goto L18;
                    case 41: goto L17;
                    case 42: goto L16;
                    case 43: goto L15;
                    case 44: goto L14;
                    case 45: goto L13;
                    case 46: goto L12;
                    case 47: goto L11;
                    case 48: goto L10;
                    case 49: goto L9;
                    default: goto L8;
                };
            L9:
                r101.markdown = MarkdownProperty.ADAPTER.decode(r100);
                goto L3
            L10:
                r101.image_gallery = ImageGalleryProperty.ADAPTER.decode(r100);
                goto L3
            L11:
                r101.at_user_group = AtUserGroupProperty.ADAPTER.decode(r100);
                goto L3
            L12:
                r101.column = ColumnProperty.ADAPTER.decode(r100);
                goto L3
            L13:
                r101.columns = ColumnsProperty.ADAPTER.decode(r100);
                goto L3
            L14:
                r101.table_cell = TableCellProperty.ADAPTER.decode(r100);
                goto L3
            L15:
                r101.table_row = TableRowProperty.ADAPTER.decode(r100);
                goto L3
            L16:
                r101.table = TableProperty.ADAPTER.decode(r100);
                goto L3
            L17:
                r101.f253560h6 = H6Property.ADAPTER.decode(r100);
                goto L3
            L18:
                r101.f253559h5 = H5Property.ADAPTER.decode(r100);
                goto L3
            L19:
                r101.f253558h4 = H4Property.ADAPTER.decode(r100);
                goto L3
            L20:
                r101.my_ai_tool = MyAIToolProperty.ADAPTER.decode(r100);
                goto L3
            L21:
                r101.code_block_v2 = CodeBlockV2Property.ADAPTER.decode(r100);
                goto L3
            L22:
                r101.mention = MentionProperty.ADAPTER.decode(r100);
                goto L3
            L23:
                r101.reaction = ReactionProperty.ADAPTER.decode(r100);
                goto L3
            L24:
                r101.datetime_picker = DatetimePickerProperty.ADAPTER.decode(r100);
                goto L3
            L25:
                r101.time_picker = TimePickerProperty.ADAPTER.decode(r100);
                goto L3
            L26:
                r101.f253561hr = HRProperty.ADAPTER.decode(r100);
                goto L3
            L27:
                r101.code_block = CodeBlockProperty.ADAPTER.decode(r100);
                goto L3
            L28:
                r101.code = CodeProperty.ADAPTER.decode(r100);
                goto L3
            L29:
                r101.quote = QuoteProperty.ADAPTER.decode(r100);
                goto L3
            L30:
                r101.f253562li = LIProperty.ADAPTER.decode(r100);
                goto L3
            L31:
                r101.f253563ol = OLProperty.ADAPTER.decode(r100);
                goto L3
            L32:
                r101.f253564ul = ULProperty.ADAPTER.decode(r100);
                goto L3
            L33:
                r101.f253557h3 = H3Property.ADAPTER.decode(r100);
                goto L3
            L34:
                r101.f253556h2 = H2Property.ADAPTER.decode(r100);
                goto L3
            L35:
                r101.f253555h1 = H1Property.ADAPTER.decode(r100);
                goto L3
            L36:
                r101.docs = DocsProperty.ADAPTER.decode(r100);
                goto L3
            L37:
                r101.date_picker = DatePickerProperty.ADAPTER.decode(r100);
                goto L3
            L38:
                r101.overflow_menu = OverflowMenuProperty.ADAPTER.decode(r100);
                goto L3
            L39:
                r101.select_menu = SelectMenuProperty.ADAPTER.decode(r100);
                goto L3
            L40:
                r101.media = MediaProperty.ADAPTER.decode(r100);
                goto L3
            L41:
                r101.link = LinkProperty.ADAPTER.decode(r100);
                goto L3
            L42:
                r101.time = TimeProperty.ADAPTER.decode(r100);
                goto L3
            L43:
                r101.textable_area = TextableAreaProperty.ADAPTER.decode(r100);
                goto L3
            L44:
                r101.div = DivProperty.ADAPTER.decode(r100);
                goto L3
            L45:
                r101.progress = ProgressSelectOptionProperty.ADAPTER.decode(r100);
                goto L3
            L46:
                r101.select = SelectProperty.ADAPTER.decode(r100);
                goto L3
            L47:
                r101.button = ButtonProperty.ADAPTER.decode(r100);
                goto L3
            L48:
                r101.emotion = EmotionProperty.ADAPTER.decode(r100);
                goto L3
            L49:
                r101.image = ImageProperty.ADAPTER.decode(r100);
                goto L3
            L50:
                r101.f253554at = AtProperty.ADAPTER.decode(r100);
                goto L3
            L51:
                r101.anchor = AnchorProperty.ADAPTER.decode(r100);
                goto L3
            L52:
                r101.underline = UnderlineProperty.ADAPTER.decode(r100);
                goto L3
            L53:
                r101.bold = BoldProperty.ADAPTER.decode(r100);
                goto L3
            L54:
                r101.italic = ItalicProperty.ADAPTER.decode(r100);
                goto L3
            L55:
                r101.text = TextProperty.ADAPTER.decode(r100);
                goto L3
            L56:
                r101.figure = FigureProperty.ADAPTER.decode(r100);
                goto L3
            L57:
                r101.paragraph = ParagraphProperty.ADAPTER.decode(r100);
                goto L3
            L8:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L59:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(PropertySet r100) {
                ParagraphProperty r101 = r100.paragraph;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ParagraphProperty.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                FigureProperty r104 = r100.figure;
                if (r104 == null) goto L9;
                int r105 = FigureProperty.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                TextProperty r107 = r100.text;
                if (r107 == null) goto L13;
                int r108 = TextProperty.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                ItalicProperty r110 = r100.italic;
                if (r110 == null) goto L17;
                int r111 = ItalicProperty.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                BoldProperty r113 = r100.bold;
                if (r113 == null) goto L21;
                int r114 = BoldProperty.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                UnderlineProperty r116 = r100.underline;
                if (r116 == null) goto L25;
                int r117 = UnderlineProperty.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                AnchorProperty r119 = r100.anchor;
                if (r119 == null) goto L29;
                int r120 = AnchorProperty.ADAPTER.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                AtProperty r122 = r100.f253543at;
                if (r122 == null) goto L33;
                int r123 = AtProperty.ADAPTER.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                ImageProperty r125 = r100.image;
                if (r125 == null) goto L37;
                int r126 = ImageProperty.ADAPTER.encodedSizeWithTag(9, r125);
            L38:
                int r127 = r124 + r126;
                EmotionProperty r128 = r100.emotion;
                if (r128 == null) goto L41;
                int r129 = EmotionProperty.ADAPTER.encodedSizeWithTag(10, r128);
            L42:
                int r130 = r127 + r129;
                ButtonProperty r131 = r100.button;
                if (r131 == null) goto L45;
                int r132 = ButtonProperty.ADAPTER.encodedSizeWithTag(11, r131);
            L46:
                int r133 = r130 + r132;
                SelectProperty r134 = r100.select;
                if (r134 == null) goto L49;
                int r135 = SelectProperty.ADAPTER.encodedSizeWithTag(12, r134);
            L50:
                int r136 = r133 + r135;
                ProgressSelectOptionProperty r137 = r100.progress;
                if (r137 == null) goto L53;
                int r138 = ProgressSelectOptionProperty.ADAPTER.encodedSizeWithTag(13, r137);
            L54:
                int r139 = r136 + r138;
                DivProperty r140 = r100.div;
                if (r140 == null) goto L57;
                int r141 = DivProperty.ADAPTER.encodedSizeWithTag(14, r140);
            L58:
                int r142 = r139 + r141;
                TextableAreaProperty r143 = r100.textable_area;
                if (r143 == null) goto L61;
                int r144 = TextableAreaProperty.ADAPTER.encodedSizeWithTag(15, r143);
            L62:
                int r145 = r142 + r144;
                TimeProperty r146 = r100.time;
                if (r146 == null) goto L65;
                int r147 = TimeProperty.ADAPTER.encodedSizeWithTag(16, r146);
            L66:
                int r148 = r145 + r147;
                LinkProperty r149 = r100.link;
                if (r149 == null) goto L69;
                int r150 = LinkProperty.ADAPTER.encodedSizeWithTag(17, r149);
            L70:
                int r151 = r148 + r150;
                MediaProperty r152 = r100.media;
                if (r152 == null) goto L73;
                int r153 = MediaProperty.ADAPTER.encodedSizeWithTag(18, r152);
            L74:
                int r154 = r151 + r153;
                SelectMenuProperty r155 = r100.select_menu;
                if (r155 == null) goto L77;
                int r156 = SelectMenuProperty.ADAPTER.encodedSizeWithTag(19, r155);
            L78:
                int r157 = r154 + r156;
                OverflowMenuProperty r158 = r100.overflow_menu;
                if (r158 == null) goto L81;
                int r159 = OverflowMenuProperty.ADAPTER.encodedSizeWithTag(20, r158);
            L82:
                int r160 = r157 + r159;
                DatePickerProperty r161 = r100.date_picker;
                if (r161 == null) goto L85;
                int r162 = DatePickerProperty.ADAPTER.encodedSizeWithTag(21, r161);
            L86:
                int r163 = r160 + r162;
                DocsProperty r164 = r100.docs;
                if (r164 == null) goto L89;
                int r165 = DocsProperty.ADAPTER.encodedSizeWithTag(22, r164);
            L90:
                int r166 = r163 + r165;
                H1Property r167 = r100.f253544h1;
                if (r167 == null) goto L93;
                int r168 = H1Property.ADAPTER.encodedSizeWithTag(23, r167);
            L94:
                int r169 = r166 + r168;
                H2Property r170 = r100.f253545h2;
                if (r170 == null) goto L97;
                int r171 = H2Property.ADAPTER.encodedSizeWithTag(24, r170);
            L98:
                int r172 = r169 + r171;
                H3Property r173 = r100.f253546h3;
                if (r173 == null) goto L101;
                int r174 = H3Property.ADAPTER.encodedSizeWithTag(25, r173);
            L102:
                int r175 = r172 + r174;
                ULProperty r176 = r100.f253553ul;
                if (r176 == null) goto L105;
                int r177 = ULProperty.ADAPTER.encodedSizeWithTag(26, r176);
            L106:
                int r178 = r175 + r177;
                OLProperty r179 = r100.f253552ol;
                if (r179 == null) goto L109;
                int r180 = OLProperty.ADAPTER.encodedSizeWithTag(27, r179);
            L110:
                int r181 = r178 + r180;
                LIProperty r182 = r100.f253551li;
                if (r182 == null) goto L113;
                int r183 = LIProperty.ADAPTER.encodedSizeWithTag(28, r182);
            L114:
                int r184 = r181 + r183;
                QuoteProperty r185 = r100.quote;
                if (r185 == null) goto L117;
                int r186 = QuoteProperty.ADAPTER.encodedSizeWithTag(29, r185);
            L118:
                int r187 = r184 + r186;
                CodeProperty r188 = r100.code;
                if (r188 == null) goto L121;
                int r189 = CodeProperty.ADAPTER.encodedSizeWithTag(30, r188);
            L122:
                int r190 = r187 + r189;
                CodeBlockProperty r191 = r100.code_block;
                if (r191 == null) goto L125;
                int r192 = CodeBlockProperty.ADAPTER.encodedSizeWithTag(31, r191);
            L126:
                int r193 = r190 + r192;
                HRProperty r194 = r100.f253550hr;
                if (r194 == null) goto L129;
                int r195 = HRProperty.ADAPTER.encodedSizeWithTag(32, r194);
            L130:
                int r196 = r193 + r195;
                TimePickerProperty r197 = r100.time_picker;
                if (r197 == null) goto L133;
                int r198 = TimePickerProperty.ADAPTER.encodedSizeWithTag(33, r197);
            L134:
                int r199 = r196 + r198;
                DatetimePickerProperty r200 = r100.datetime_picker;
                if (r200 == null) goto L137;
                int r201 = DatetimePickerProperty.ADAPTER.encodedSizeWithTag(34, r200);
            L138:
                int r202 = r199 + r201;
                ReactionProperty r203 = r100.reaction;
                if (r203 == null) goto L141;
                int r204 = ReactionProperty.ADAPTER.encodedSizeWithTag(35, r203);
            L142:
                int r205 = r202 + r204;
                MentionProperty r206 = r100.mention;
                if (r206 == null) goto L145;
                int r207 = MentionProperty.ADAPTER.encodedSizeWithTag(36, r206);
            L146:
                int r208 = r205 + r207;
                CodeBlockV2Property r209 = r100.code_block_v2;
                if (r209 == null) goto L149;
                int r210 = CodeBlockV2Property.ADAPTER.encodedSizeWithTag(37, r209);
            L150:
                int r211 = r208 + r210;
                MyAIToolProperty r212 = r100.my_ai_tool;
                if (r212 == null) goto L153;
                int r213 = MyAIToolProperty.ADAPTER.encodedSizeWithTag(38, r212);
            L154:
                int r214 = r211 + r213;
                H4Property r215 = r100.f253547h4;
                if (r215 == null) goto L157;
                int r216 = H4Property.ADAPTER.encodedSizeWithTag(39, r215);
            L158:
                int r217 = r214 + r216;
                H5Property r218 = r100.f253548h5;
                if (r218 == null) goto L161;
                int r219 = H5Property.ADAPTER.encodedSizeWithTag(40, r218);
            L162:
                int r220 = r217 + r219;
                H6Property r221 = r100.f253549h6;
                if (r221 == null) goto L165;
                int r222 = H6Property.ADAPTER.encodedSizeWithTag(41, r221);
            L166:
                int r223 = r220 + r222;
                TableProperty r224 = r100.table;
                if (r224 == null) goto L169;
                int r225 = TableProperty.ADAPTER.encodedSizeWithTag(42, r224);
            L170:
                int r226 = r223 + r225;
                TableRowProperty r227 = r100.table_row;
                if (r227 == null) goto L173;
                int r228 = TableRowProperty.ADAPTER.encodedSizeWithTag(43, r227);
            L174:
                int r229 = r226 + r228;
                TableCellProperty r230 = r100.table_cell;
                if (r230 == null) goto L177;
                int r231 = TableCellProperty.ADAPTER.encodedSizeWithTag(44, r230);
            L178:
                int r232 = r229 + r231;
                ColumnsProperty r233 = r100.columns;
                if (r233 == null) goto L181;
                int r234 = ColumnsProperty.ADAPTER.encodedSizeWithTag(45, r233);
            L182:
                int r235 = r232 + r234;
                ColumnProperty r236 = r100.column;
                if (r236 == null) goto L185;
                int r237 = ColumnProperty.ADAPTER.encodedSizeWithTag(46, r236);
            L186:
                int r238 = r235 + r237;
                AtUserGroupProperty r239 = r100.at_user_group;
                if (r239 == null) goto L189;
                int r240 = AtUserGroupProperty.ADAPTER.encodedSizeWithTag(47, r239);
            L190:
                int r241 = r238 + r240;
                ImageGalleryProperty r242 = r100.image_gallery;
                if (r242 == null) goto L193;
                int r243 = ImageGalleryProperty.ADAPTER.encodedSizeWithTag(48, r242);
            L194:
                int r244 = r241 + r243;
                MarkdownProperty r245 = r100.markdown;
                if (r245 == null) goto L197;
                int r246 = MarkdownProperty.ADAPTER.encodedSizeWithTag(49, r245);
            L198:
                int r247 = r244 + r246;
                UnknownProperty r248 = r100.unknown;
                if (r248 == null) goto L202;
                r102 = UnknownProperty.ADAPTER.encodedSizeWithTag(404, r248);
            L202:
                return (r247 + r102) + r100.unknownFields().size();
            L197:
                r246 = 0;
                goto L198
            L193:
                r243 = 0;
                goto L194
            L189:
                r240 = 0;
                goto L190
            L185:
                r237 = 0;
                goto L186
            L181:
                r234 = 0;
                goto L182
            L177:
                r231 = 0;
                goto L178
            L173:
                r228 = 0;
                goto L174
            L169:
                r225 = 0;
                goto L170
            L165:
                r222 = 0;
                goto L166
            L161:
                r219 = 0;
                goto L162
            L157:
                r216 = 0;
                goto L158
            L153:
                r213 = 0;
                goto L154
            L149:
                r210 = 0;
                goto L150
            L145:
                r207 = 0;
                goto L146
            L141:
                r204 = 0;
                goto L142
            L137:
                r201 = 0;
                goto L138
            L133:
                r198 = 0;
                goto L134
            L129:
                r195 = 0;
                goto L130
            L125:
                r192 = 0;
                goto L126
            L121:
                r189 = 0;
                goto L122
            L117:
                r186 = 0;
                goto L118
            L113:
                r183 = 0;
                goto L114
            L109:
                r180 = 0;
                goto L110
            L105:
                r177 = 0;
                goto L106
            L101:
                r174 = 0;
                goto L102
            L97:
                r171 = 0;
                goto L98
            L93:
                r168 = 0;
                goto L94
            L89:
                r165 = 0;
                goto L90
            L85:
                r162 = 0;
                goto L86
            L81:
                r159 = 0;
                goto L82
            L77:
                r156 = 0;
                goto L78
            L73:
                r153 = 0;
                goto L74
            L69:
                r150 = 0;
                goto L70
            L65:
                r147 = 0;
                goto L66
            L61:
                r144 = 0;
                goto L62
            L57:
                r141 = 0;
                goto L58
            L53:
                r138 = 0;
                goto L54
            L49:
                r135 = 0;
                goto L50
            L45:
                r132 = 0;
                goto L46
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
            public /* bridge */ /* synthetic */ PropertySet decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(PropertySet r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, PropertySet r101) throws IOException {
                ParagraphProperty r102 = r101.paragraph;
                if (r102 == null) goto L5;
                ParagraphProperty.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                FigureProperty r103 = r101.figure;
                if (r103 == null) goto L8;
                FigureProperty.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                TextProperty r104 = r101.text;
                if (r104 == null) goto L11;
                TextProperty.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                ItalicProperty r105 = r101.italic;
                if (r105 == null) goto L14;
                ItalicProperty.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                BoldProperty r106 = r101.bold;
                if (r106 == null) goto L17;
                BoldProperty.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                UnderlineProperty r107 = r101.underline;
                if (r107 == null) goto L20;
                UnderlineProperty.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                AnchorProperty r108 = r101.anchor;
                if (r108 == null) goto L23;
                AnchorProperty.ADAPTER.encodeWithTag(r100, 7, r108);
            L23:
                AtProperty r109 = r101.f253543at;
                if (r109 == null) goto L26;
                AtProperty.ADAPTER.encodeWithTag(r100, 8, r109);
            L26:
                ImageProperty r110 = r101.image;
                if (r110 == null) goto L29;
                ImageProperty.ADAPTER.encodeWithTag(r100, 9, r110);
            L29:
                EmotionProperty r111 = r101.emotion;
                if (r111 == null) goto L32;
                EmotionProperty.ADAPTER.encodeWithTag(r100, 10, r111);
            L32:
                ButtonProperty r112 = r101.button;
                if (r112 == null) goto L35;
                ButtonProperty.ADAPTER.encodeWithTag(r100, 11, r112);
            L35:
                SelectProperty r113 = r101.select;
                if (r113 == null) goto L38;
                SelectProperty.ADAPTER.encodeWithTag(r100, 12, r113);
            L38:
                ProgressSelectOptionProperty r114 = r101.progress;
                if (r114 == null) goto L41;
                ProgressSelectOptionProperty.ADAPTER.encodeWithTag(r100, 13, r114);
            L41:
                DivProperty r115 = r101.div;
                if (r115 == null) goto L44;
                DivProperty.ADAPTER.encodeWithTag(r100, 14, r115);
            L44:
                TextableAreaProperty r116 = r101.textable_area;
                if (r116 == null) goto L47;
                TextableAreaProperty.ADAPTER.encodeWithTag(r100, 15, r116);
            L47:
                TimeProperty r117 = r101.time;
                if (r117 == null) goto L50;
                TimeProperty.ADAPTER.encodeWithTag(r100, 16, r117);
            L50:
                LinkProperty r118 = r101.link;
                if (r118 == null) goto L53;
                LinkProperty.ADAPTER.encodeWithTag(r100, 17, r118);
            L53:
                MediaProperty r119 = r101.media;
                if (r119 == null) goto L56;
                MediaProperty.ADAPTER.encodeWithTag(r100, 18, r119);
            L56:
                SelectMenuProperty r120 = r101.select_menu;
                if (r120 == null) goto L59;
                SelectMenuProperty.ADAPTER.encodeWithTag(r100, 19, r120);
            L59:
                OverflowMenuProperty r121 = r101.overflow_menu;
                if (r121 == null) goto L62;
                OverflowMenuProperty.ADAPTER.encodeWithTag(r100, 20, r121);
            L62:
                DatePickerProperty r122 = r101.date_picker;
                if (r122 == null) goto L65;
                DatePickerProperty.ADAPTER.encodeWithTag(r100, 21, r122);
            L65:
                DocsProperty r123 = r101.docs;
                if (r123 == null) goto L68;
                DocsProperty.ADAPTER.encodeWithTag(r100, 22, r123);
            L68:
                H1Property r124 = r101.f253544h1;
                if (r124 == null) goto L71;
                H1Property.ADAPTER.encodeWithTag(r100, 23, r124);
            L71:
                H2Property r125 = r101.f253545h2;
                if (r125 == null) goto L74;
                H2Property.ADAPTER.encodeWithTag(r100, 24, r125);
            L74:
                H3Property r126 = r101.f253546h3;
                if (r126 == null) goto L77;
                H3Property.ADAPTER.encodeWithTag(r100, 25, r126);
            L77:
                ULProperty r127 = r101.f253553ul;
                if (r127 == null) goto L80;
                ULProperty.ADAPTER.encodeWithTag(r100, 26, r127);
            L80:
                OLProperty r128 = r101.f253552ol;
                if (r128 == null) goto L83;
                OLProperty.ADAPTER.encodeWithTag(r100, 27, r128);
            L83:
                LIProperty r129 = r101.f253551li;
                if (r129 == null) goto L86;
                LIProperty.ADAPTER.encodeWithTag(r100, 28, r129);
            L86:
                QuoteProperty r130 = r101.quote;
                if (r130 == null) goto L89;
                QuoteProperty.ADAPTER.encodeWithTag(r100, 29, r130);
            L89:
                CodeProperty r131 = r101.code;
                if (r131 == null) goto L92;
                CodeProperty.ADAPTER.encodeWithTag(r100, 30, r131);
            L92:
                CodeBlockProperty r132 = r101.code_block;
                if (r132 == null) goto L95;
                CodeBlockProperty.ADAPTER.encodeWithTag(r100, 31, r132);
            L95:
                HRProperty r133 = r101.f253550hr;
                if (r133 == null) goto L98;
                HRProperty.ADAPTER.encodeWithTag(r100, 32, r133);
            L98:
                TimePickerProperty r134 = r101.time_picker;
                if (r134 == null) goto L101;
                TimePickerProperty.ADAPTER.encodeWithTag(r100, 33, r134);
            L101:
                DatetimePickerProperty r135 = r101.datetime_picker;
                if (r135 == null) goto L104;
                DatetimePickerProperty.ADAPTER.encodeWithTag(r100, 34, r135);
            L104:
                ReactionProperty r136 = r101.reaction;
                if (r136 == null) goto L107;
                ReactionProperty.ADAPTER.encodeWithTag(r100, 35, r136);
            L107:
                MentionProperty r137 = r101.mention;
                if (r137 == null) goto L110;
                MentionProperty.ADAPTER.encodeWithTag(r100, 36, r137);
            L110:
                CodeBlockV2Property r138 = r101.code_block_v2;
                if (r138 == null) goto L113;
                CodeBlockV2Property.ADAPTER.encodeWithTag(r100, 37, r138);
            L113:
                MyAIToolProperty r139 = r101.my_ai_tool;
                if (r139 == null) goto L116;
                MyAIToolProperty.ADAPTER.encodeWithTag(r100, 38, r139);
            L116:
                H4Property r140 = r101.f253547h4;
                if (r140 == null) goto L119;
                H4Property.ADAPTER.encodeWithTag(r100, 39, r140);
            L119:
                H5Property r141 = r101.f253548h5;
                if (r141 == null) goto L122;
                H5Property.ADAPTER.encodeWithTag(r100, 40, r141);
            L122:
                H6Property r142 = r101.f253549h6;
                if (r142 == null) goto L125;
                H6Property.ADAPTER.encodeWithTag(r100, 41, r142);
            L125:
                TableProperty r143 = r101.table;
                if (r143 == null) goto L128;
                TableProperty.ADAPTER.encodeWithTag(r100, 42, r143);
            L128:
                TableRowProperty r144 = r101.table_row;
                if (r144 == null) goto L131;
                TableRowProperty.ADAPTER.encodeWithTag(r100, 43, r144);
            L131:
                TableCellProperty r145 = r101.table_cell;
                if (r145 == null) goto L134;
                TableCellProperty.ADAPTER.encodeWithTag(r100, 44, r145);
            L134:
                ColumnsProperty r146 = r101.columns;
                if (r146 == null) goto L137;
                ColumnsProperty.ADAPTER.encodeWithTag(r100, 45, r146);
            L137:
                ColumnProperty r147 = r101.column;
                if (r147 == null) goto L140;
                ColumnProperty.ADAPTER.encodeWithTag(r100, 46, r147);
            L140:
                AtUserGroupProperty r148 = r101.at_user_group;
                if (r148 == null) goto L143;
                AtUserGroupProperty.ADAPTER.encodeWithTag(r100, 47, r148);
            L143:
                ImageGalleryProperty r149 = r101.image_gallery;
                if (r149 == null) goto L146;
                ImageGalleryProperty.ADAPTER.encodeWithTag(r100, 48, r149);
            L146:
                MarkdownProperty r150 = r101.markdown;
                if (r150 == null) goto L149;
                MarkdownProperty.ADAPTER.encodeWithTag(r100, 49, r150);
            L149:
                UnknownProperty r151 = r101.unknown;
                if (r151 == null) goto L152;
                UnknownProperty.ADAPTER.encodeWithTag(r100, 404, r151);
            L152:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PropertySet r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PropertySet();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.paragraph = this.paragraph;
            r100.figure = this.figure;
            r100.text = this.text;
            r100.italic = this.italic;
            r100.bold = this.bold;
            r100.underline = this.underline;
            r100.anchor = this.anchor;
            r100.f253554at = this.f253543at;
            r100.image = this.image;
            r100.emotion = this.emotion;
            r100.button = this.button;
            r100.select = this.select;
            r100.progress = this.progress;
            r100.div = this.div;
            r100.textable_area = this.textable_area;
            r100.time = this.time;
            r100.link = this.link;
            r100.media = this.media;
            r100.select_menu = this.select_menu;
            r100.overflow_menu = this.overflow_menu;
            r100.date_picker = this.date_picker;
            r100.docs = this.docs;
            r100.f253555h1 = this.f253544h1;
            r100.f253556h2 = this.f253545h2;
            r100.f253557h3 = this.f253546h3;
            r100.f253564ul = this.f253553ul;
            r100.f253563ol = this.f253552ol;
            r100.f253562li = this.f253551li;
            r100.quote = this.quote;
            r100.code = this.code;
            r100.code_block = this.code_block;
            r100.f253561hr = this.f253550hr;
            r100.time_picker = this.time_picker;
            r100.datetime_picker = this.datetime_picker;
            r100.reaction = this.reaction;
            r100.mention = this.mention;
            r100.code_block_v2 = this.code_block_v2;
            r100.my_ai_tool = this.my_ai_tool;
            r100.f253558h4 = this.f253547h4;
            r100.f253559h5 = this.f253548h5;
            r100.f253560h6 = this.f253549h6;
            r100.table = this.table;
            r100.table_row = this.table_row;
            r100.table_cell = this.table_cell;
            r100.columns = this.columns;
            r100.column = this.column;
            r100.at_user_group = this.at_user_group;
            r100.image_gallery = this.image_gallery;
            r100.markdown = this.markdown;
            r100.unknown = this.unknown;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return PropertySet.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public PropertySet(ParagraphProperty r510, FigureProperty r511, TextProperty r512, ItalicProperty r513, BoldProperty r514, UnderlineProperty r515, AnchorProperty r516, AtProperty r610, ImageProperty r611, EmotionProperty r612, ButtonProperty r613, SelectProperty r614, ProgressSelectOptionProperty r615, DivProperty r616, TextableAreaProperty r617, TimeProperty r618, LinkProperty r619, MediaProperty r710, SelectMenuProperty r711, OverflowMenuProperty r712, DatePickerProperty r713, DocsProperty r714, H1Property r715, H2Property r716, H3Property r717, ULProperty r718, OLProperty r719, LIProperty r810, QuoteProperty r811, CodeProperty r812, CodeBlockProperty r813, HRProperty r814, TimePickerProperty r815, DatetimePickerProperty r816, ReactionProperty r817, MentionProperty r818, CodeBlockV2Property r819, MyAIToolProperty r910, H4Property r911, H5Property r912, H6Property r913, TableProperty r914, TableRowProperty r915, TableCellProperty r916, ColumnsProperty r917, ColumnProperty r918, AtUserGroupProperty r919, ImageGalleryProperty r100, MarkdownProperty r101, UnknownProperty r102) {
            this(r510, r511, r512, r513, r514, r515, r516, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r100, r101, r102, ByteString.EMPTY);
        }

        public PropertySet(ParagraphProperty r100, FigureProperty r101, TextProperty r102, ItalicProperty r103, BoldProperty r104, UnderlineProperty r105, AnchorProperty r110, AtProperty r111, ImageProperty r112, EmotionProperty r113, ButtonProperty r114, SelectProperty r115, ProgressSelectOptionProperty r116, DivProperty r117, TextableAreaProperty r118, TimeProperty r119, LinkProperty r210, MediaProperty r211, SelectMenuProperty r212, OverflowMenuProperty r213, DatePickerProperty r214, DocsProperty r215, H1Property r216, H2Property r217, H3Property r218, ULProperty r219, OLProperty r310, LIProperty r311, QuoteProperty r312, CodeProperty r313, CodeBlockProperty r314, HRProperty r315, TimePickerProperty r316, DatetimePickerProperty r317, ReactionProperty r318, MentionProperty r319, CodeBlockV2Property r410, MyAIToolProperty r411, H4Property r412, H5Property r413, H6Property r414, TableProperty r415, TableRowProperty r416, TableCellProperty r417, ColumnsProperty r418, ColumnProperty r419, AtUserGroupProperty r510, ImageGalleryProperty r511, MarkdownProperty r512, UnknownProperty r513, ByteString r514) {
            super(ADAPTER, r514);
            this.paragraph = r100;
            this.figure = r101;
            this.text = r102;
            this.italic = r103;
            this.bold = r104;
            this.underline = r105;
            this.anchor = r110;
            this.f253543at = r111;
            this.image = r112;
            this.emotion = r113;
            this.button = r114;
            this.select = r115;
            this.progress = r116;
            this.div = r117;
            this.textable_area = r118;
            this.time = r119;
            this.link = r210;
            this.media = r211;
            this.select_menu = r212;
            this.overflow_menu = r213;
            this.date_picker = r214;
            this.docs = r215;
            this.f253544h1 = r216;
            this.f253545h2 = r217;
            this.f253546h3 = r218;
            this.f253553ul = r219;
            this.f253552ol = r310;
            this.f253551li = r311;
            this.quote = r312;
            this.code = r313;
            this.code_block = r314;
            this.f253550hr = r315;
            this.time_picker = r316;
            this.datetime_picker = r317;
            this.reaction = r318;
            this.mention = r319;
            this.code_block_v2 = r410;
            this.my_ai_tool = r411;
            this.f253547h4 = r412;
            this.f253548h5 = r413;
            this.f253549h6 = r414;
            this.table = r415;
            this.table_row = r416;
            this.table_cell = r417;
            this.columns = r418;
            this.column = r419;
            this.at_user_group = r510;
            this.image_gallery = r511;
            this.markdown = r512;
            this.unknown = r513;
        }
    }

    public static final class ProtoAdapter_RichTextElement extends ProtoAdapter<RichTextElement> {
        private final ProtoAdapter<Map<String, String>> style;
        private final ProtoAdapter<Map<String, String>> wide_style;

        public ProtoAdapter_RichTextElement() {
            super(FieldEncoding.LENGTH_DELIMITED, RichTextElement.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.style = ProtoAdapter.newMapAdapter(r100, r100);
            this.wide_style = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RichTextElement decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.tag = Tag.UNKNOWN;
            r101.ser_upgrade_element = ByteString.EMPTY;
            r101.last_upgrade_version = "";
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
            r101.tag = Tag.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.last_upgrade_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.ser_upgrade_element = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L9:
            r101.wide_style.putAll(this.wide_style.decode(r100));
            goto L3
        L10:
            r101.style_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.child_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.property = PropertySet.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.style.putAll(this.style.decode(r100));
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
        public int encodedSize2(RichTextElement r100) {
            int r101 = (Tag.ADAPTER.encodedSizeWithTag(1, r100.tag) + this.style.encodedSizeWithTag(2, r100.style)) + PropertySet.ADAPTER.encodedSizeWithTag(3, r100.property);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = ((r101 + r102.asRepeated().encodedSizeWithTag(4, r100.child_ids)) + r102.asRepeated().encodedSizeWithTag(5, r100.style_keys)) + this.wide_style.encodedSizeWithTag(6, r100.wide_style);
            ByteString r104 = r100.ser_upgrade_element;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = ProtoAdapter.BYTES.encodedSizeWithTag(7, r104);
        L6:
            int r107 = r103 + r106;
            String r108 = r100.last_upgrade_version;
            if (r108 == null) goto L10;
            r105 = r102.encodedSizeWithTag(8, r108);
        L10:
            return (r107 + r105) + r100.unknownFields().size();
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RichTextElement decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RichTextElement r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RichTextElement r101) throws IOException {
            Tag.ADAPTER.encodeWithTag(r100, 1, r101.tag);
            this.style.encodeWithTag(r100, 2, r101.style);
            PropertySet.ADAPTER.encodeWithTag(r100, 3, r101.property);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 4, r101.child_ids);
            r102.asRepeated().encodeWithTag(r100, 5, r101.style_keys);
            this.wide_style.encodeWithTag(r100, 6, r101.wide_style);
            ByteString r103 = r101.ser_upgrade_element;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 7, r103);
        L5:
            String r104 = r101.last_upgrade_version;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 8, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RichTextElement r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class QuoteProperty extends com.squareup.wire.Message<QuoteProperty, Builder> {
        public static final ProtoAdapter<QuoteProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<QuoteProperty, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public QuoteProperty build() {
                return new QuoteProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_QuoteProperty extends ProtoAdapter<QuoteProperty> {
            public ProtoAdapter_QuoteProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, QuoteProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public QuoteProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(QuoteProperty r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ QuoteProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(QuoteProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, QuoteProperty r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QuoteProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_QuoteProperty();
        }

        public QuoteProperty() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return QuoteProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public QuoteProperty(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final class ReactionProperty extends com.squareup.wire.Message<ReactionProperty, Builder> {
        public static final ProtoAdapter<ReactionProperty> ADAPTER = null;
        public static final String DEFAULT_KEY = "";
        private static final long serialVersionUID = 0;
        public final String key;

        public static final class Builder extends com.squareup.wire.Message.Builder<ReactionProperty, Builder> {
            public String key;

            @Override // com.squareup.wire.Message.Builder
            public ReactionProperty build() {
                String r100 = this.key;
                if (r100 == null) goto L7;
                return new ReactionProperty(this.key, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "key"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder key(String r100) {
                this.key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ReactionProperty extends ProtoAdapter<ReactionProperty> {
            public ProtoAdapter_ReactionProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ReactionProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ReactionProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ReactionProperty r100) {
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.key) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ReactionProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ReactionProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ReactionProperty r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.key);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ReactionProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ReactionProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.key = this.key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ReactionProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ReactionProperty(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public ReactionProperty(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.key = r100;
        }
    }

    public static final class SelectMenuProperty extends com.squareup.wire.Message<SelectMenuProperty, Builder> {
        public static final ProtoAdapter<SelectMenuProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final Boolean DEFAULT_DISABLE = null;
        public static final String DEFAULT_INITIAL_OPTION = "";
        public static final Boolean DEFAULT_IS_LOADING = null;
        public static final String DEFAULT_PLACE_HOLDER = "";
        public static final String DEFAULT_PLACE_HOLDER_I18N_KEY = "";
        public static final Type DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String action_id;
        public final ButtonConfirmProperty confirm;
        public final Boolean disable;
        public final String initial_option;
        public final Boolean is_loading;
        public final List<MenuOption> options;
        public final String place_holder;
        public final String place_holder_i18n_key;
        public final Type type;

        public static final class Builder extends com.squareup.wire.Message.Builder<SelectMenuProperty, Builder> {
            public String action_id;
            public ButtonConfirmProperty confirm;
            public Boolean disable;
            public String initial_option;
            public Boolean is_loading;
            public List<MenuOption> options;
            public String place_holder;
            public String place_holder_i18n_key;
            public Type type;

            @Override // com.squareup.wire.Message.Builder
            public SelectMenuProperty build() {
                return new SelectMenuProperty(this.type, this.action_id, this.place_holder, this.place_holder_i18n_key, this.initial_option, this.options, this.confirm, this.disable, this.is_loading, super.buildUnknownFields());
            }

            public Builder() {
                this.options = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.action_id = r100;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r100) {
                this.confirm = r100;
                return this;
            }

            public Builder disable(Boolean r100) {
                this.disable = r100;
                return this;
            }

            public Builder initial_option(String r100) {
                this.initial_option = r100;
                return this;
            }

            public Builder is_loading(Boolean r100) {
                this.is_loading = r100;
                return this;
            }

            public Builder options(List<MenuOption> r100) {
                Internal.checkElementsNotNull(r100);
                this.options = r100;
                return this;
            }

            public Builder place_holder(String r100) {
                this.place_holder = r100;
                return this;
            }

            public Builder place_holder_i18n_key(String r100) {
                this.place_holder_i18n_key = r100;
                return this;
            }

            public Builder type(Type r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SelectMenuProperty extends ProtoAdapter<SelectMenuProperty> {
            public ProtoAdapter_SelectMenuProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, SelectMenuProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SelectMenuProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = Type.UNKNOWN;
                r101.action_id = "";
                r101.place_holder = "";
                r101.place_holder_i18n_key = "";
                r101.initial_option = "";
                Boolean r102 = Boolean.FALSE;
                r101.disable = r102;
                r101.is_loading = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L19;
                switch(r104) {
                    case 1: goto L21;
                    case 2: goto L14;
                    case 3: goto L13;
                    case 4: goto L12;
                    case 5: goto L11;
                    case 6: goto L10;
                    case 7: goto L9;
                    case 8: goto L8;
                    case 9: goto L7;
                    default: goto L6;
                };
            L21:
                r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.is_loading = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.disable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.confirm = ButtonConfirmProperty.ADAPTER.decode(r100);
                goto L3
            L10:
                r101.options.add(MenuOption.ADAPTER.decode(r100));
                goto L3
            L11:
                r101.initial_option = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.place_holder_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.place_holder = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L19:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SelectMenuProperty r100) {
                Type r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.action_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.place_holder;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.place_holder_i18n_key;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.initial_option;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                int r115 = (r112 + r114) + MenuOption.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.options);
                ButtonConfirmProperty r116 = r100.confirm;
                if (r116 == null) goto L25;
                int r117 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(7, r116);
            L26:
                int r118 = r115 + r117;
                Boolean r119 = r100.disable;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r119);
            L30:
                int r121 = r118 + r120;
                Boolean r122 = r100.is_loading;
                if (r122 == null) goto L34;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r122);
            L34:
                return (r121 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ SelectMenuProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SelectMenuProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SelectMenuProperty r101) throws IOException {
                Type r102 = r101.type;
                if (r102 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.action_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.place_holder;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.place_holder_i18n_key;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.initial_option;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                MenuOption.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.options);
                ButtonConfirmProperty r107 = r101.confirm;
                if (r107 == null) goto L20;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r100, 7, r107);
            L20:
                Boolean r108 = r101.disable;
                if (r108 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
            L23:
                Boolean r109 = r101.is_loading;
                if (r109 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r100, 9, r109);
            L26:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SelectMenuProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type PERSON = null;
            public static final Type STATIC = null;
            public static final Type UNKNOWN = null;
            private final int value;

            static {
                Type r100 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                Type r101 = new Type("STATIC", 1, 1);
                STATIC = r101;
                Type r102 = new Type("PERSON", 2, 2);
                PERSON = r102;
                $VALUES = new Type[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return PERSON;
            L12:
                return STATIC;
            L14:
                return UNKNOWN;
            }

            public static Type valueOf(String r100) {
                return (Type) a.a(Type.class, r100);
            }

            private Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SelectMenuProperty();
            DEFAULT_TYPE = Type.UNKNOWN;
            Boolean r100 = Boolean.FALSE;
            DEFAULT_DISABLE = r100;
            DEFAULT_IS_LOADING = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.action_id = this.action_id;
            r100.place_holder = this.place_holder;
            r100.place_holder_i18n_key = this.place_holder_i18n_key;
            r100.initial_option = this.initial_option;
            r100.options = Internal.copyOf("options", this.options);
            r100.confirm = this.confirm;
            r100.disable = this.disable;
            r100.is_loading = this.is_loading;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SelectMenuProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public SelectMenuProperty(Type r110, String r111, String r112, String r113, String r114, List<MenuOption> r115, ButtonConfirmProperty r116, Boolean r117, Boolean r210) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
        }

        public SelectMenuProperty(Type r100, String r101, String r102, String r103, String r104, List<MenuOption> r105, ButtonConfirmProperty r106, Boolean r107, Boolean r110, ByteString r111) {
            super(ADAPTER, r111);
            this.type = r100;
            this.action_id = r101;
            this.place_holder = r102;
            this.place_holder_i18n_key = r103;
            this.initial_option = r104;
            this.options = Internal.immutableCopyOf("options", r105);
            this.confirm = r106;
            this.disable = r107;
            this.is_loading = r110;
        }
    }

    public static final class SelectProperty extends com.squareup.wire.Message<SelectProperty, Builder> {
        public static final ProtoAdapter<SelectProperty> ADAPTER = null;
        public static final Integer DEFAULT_MAX_PICK_NUM = null;
        public static final Integer DEFAULT_MIN_PICK_NUM = null;
        private static final long serialVersionUID = 0;
        public final Integer max_pick_num;
        public final Integer min_pick_num;

        public static final class Builder extends com.squareup.wire.Message.Builder<SelectProperty, Builder> {
            public Integer max_pick_num;
            public Integer min_pick_num;

            @Override // com.squareup.wire.Message.Builder
            public SelectProperty build() {
                return new SelectProperty(this.min_pick_num, this.max_pick_num, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder max_pick_num(Integer r100) {
                this.max_pick_num = r100;
                return this;
            }

            public Builder min_pick_num(Integer r100) {
                this.min_pick_num = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SelectProperty extends ProtoAdapter<SelectProperty> {
            public ProtoAdapter_SelectProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, SelectProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SelectProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.min_pick_num = 1;
                r101.max_pick_num = 1;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 4) goto L8;
                r101.min_pick_num = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 5) goto L9;
                r101.max_pick_num = ProtoAdapter.INT32.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SelectProperty r100) {
                Integer r101 = r100.min_pick_num;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(4, r101);
            L6:
                Integer r104 = r100.max_pick_num;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(5, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SelectProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SelectProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SelectProperty r101) throws IOException {
                Integer r102 = r101.min_pick_num;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 4, r102);
            L5:
                Integer r103 = r101.max_pick_num;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 5, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SelectProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SelectProperty();
            DEFAULT_MIN_PICK_NUM = 1;
            DEFAULT_MAX_PICK_NUM = 1;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.min_pick_num = this.min_pick_num;
            r100.max_pick_num = this.max_pick_num;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SelectProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public SelectProperty(Integer r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public SelectProperty(Integer r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.min_pick_num = r100;
            this.max_pick_num = r101;
        }
    }

    public static final class TableCellProperty extends com.squareup.wire.Message<TableCellProperty, Builder> {
        public static final ProtoAdapter<TableCellProperty> ADAPTER = null;
        public static final Integer DEFAULT_COLSPAN = null;
        public static final HorizontalAlign DEFAULT_HORIZONTAL_ALIGN = null;
        public static final Boolean DEFAULT_IS_MERGED = null;
        public static final Integer DEFAULT_ROWSPAN = null;
        public static final VerticalAlign DEFAULT_VERTICAL_ALIGN = null;
        private static final long serialVersionUID = 0;
        public final Integer colspan;
        public final HorizontalAlign horizontal_align;
        public final Boolean is_merged;
        public final Integer rowspan;
        public final VerticalAlign vertical_align;

        public static final class Builder extends com.squareup.wire.Message.Builder<TableCellProperty, Builder> {
            public Integer colspan;
            public HorizontalAlign horizontal_align;
            public Boolean is_merged;
            public Integer rowspan;
            public VerticalAlign vertical_align;

            @Override // com.squareup.wire.Message.Builder
            public TableCellProperty build() {
                return new TableCellProperty(this.colspan, this.rowspan, this.horizontal_align, this.vertical_align, this.is_merged, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder colspan(Integer r100) {
                this.colspan = r100;
                return this;
            }

            public Builder horizontal_align(HorizontalAlign r100) {
                this.horizontal_align = r100;
                return this;
            }

            public Builder is_merged(Boolean r100) {
                this.is_merged = r100;
                return this;
            }

            public Builder rowspan(Integer r100) {
                this.rowspan = r100;
                return this;
            }

            public Builder vertical_align(VerticalAlign r100) {
                this.vertical_align = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TableCellProperty extends ProtoAdapter<TableCellProperty> {
            public ProtoAdapter_TableCellProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TableCellProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TableCellProperty decode(ProtoReader r110) throws IOException {
                Builder r100 = new Builder();
                r100.colspan = 1;
                r100.rowspan = 1;
                r100.horizontal_align = HorizontalAlign.HORIZONTAL_ALIGN_UNKNOWN;
                r100.vertical_align = VerticalAlign.VERTICAL_ALIGN_UNKNOWN;
                r100.is_merged = Boolean.FALSE;
                long r101 = r110.beginMessage();
            L3:
                int r102 = r110.nextTag();
                if (r102 == (-1)) goto L26;
                if (r102 != 1) goto L7;
                r100.colspan = ProtoAdapter.INT32.decode(r110);
                goto L3
            L7:
                if (r102 != 2) goto L9;
                r100.rowspan = ProtoAdapter.INT32.decode(r110);
                goto L3
            L9:
                if (r102 != 3) goto L11;
                r100.horizontal_align = HorizontalAlign.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r100.addUnknownField(r102, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                if (r102 != 4) goto L13;
                r100.vertical_align = VerticalAlign.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r100.addUnknownField(r102, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L13:
                if (r102 != 5) goto L14;
                r100.is_merged = ProtoAdapter.BOOL.decode(r110);
                goto L3
            L14:
                FieldEncoding r103 = r110.peekFieldEncoding();
                r100.addUnknownField(r102, r103, r103.rawProtoAdapter().decode(r110));
                goto L3
            L26:
                r110.endMessage(r101);
                return r100.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TableCellProperty r100) {
                Integer r101 = r100.colspan;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.rowspan;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                HorizontalAlign r107 = r100.horizontal_align;
                if (r107 == null) goto L13;
                int r108 = HorizontalAlign.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                VerticalAlign r110 = r100.vertical_align;
                if (r110 == null) goto L17;
                int r111 = VerticalAlign.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Boolean r113 = r100.is_merged;
                if (r113 == null) goto L22;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
            L22:
                return (r112 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ TableCellProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TableCellProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TableCellProperty r101) throws IOException {
                Integer r102 = r101.colspan;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.rowspan;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                HorizontalAlign r104 = r101.horizontal_align;
                if (r104 == null) goto L11;
                HorizontalAlign.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                VerticalAlign r105 = r101.vertical_align;
                if (r105 == null) goto L14;
                VerticalAlign.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                Boolean r106 = r101.is_merged;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TableCellProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TableCellProperty();
            DEFAULT_COLSPAN = 1;
            DEFAULT_ROWSPAN = 1;
            DEFAULT_HORIZONTAL_ALIGN = HorizontalAlign.HORIZONTAL_ALIGN_UNKNOWN;
            DEFAULT_VERTICAL_ALIGN = VerticalAlign.VERTICAL_ALIGN_UNKNOWN;
            DEFAULT_IS_MERGED = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.colspan = this.colspan;
            r100.rowspan = this.rowspan;
            r100.horizontal_align = this.horizontal_align;
            r100.vertical_align = this.vertical_align;
            r100.is_merged = this.is_merged;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TableCellProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TableCellProperty(Integer r100, Integer r101, HorizontalAlign r110, VerticalAlign r111, Boolean r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public TableCellProperty(Integer r100, Integer r101, HorizontalAlign r102, VerticalAlign r103, Boolean r104, ByteString r105) {
            super(ADAPTER, r105);
            this.colspan = r100;
            this.rowspan = r101;
            this.horizontal_align = r102;
            this.vertical_align = r103;
            this.is_merged = r104;
        }
    }

    public static final class TableProperty extends com.squareup.wire.Message<TableProperty, Builder> {
        public static final ProtoAdapter<TableProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Column> columns;

        public static final class Builder extends com.squareup.wire.Message.Builder<TableProperty, Builder> {
            public List<Column> columns;

            @Override // com.squareup.wire.Message.Builder
            public TableProperty build() {
                return new TableProperty(this.columns, super.buildUnknownFields());
            }

            public Builder() {
                this.columns = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder columns(List<Column> r100) {
                Internal.checkElementsNotNull(r100);
                this.columns = r100;
                return this;
            }
        }

        public static final class Column extends com.squareup.wire.Message<Column, Builder> {
            public static final ProtoAdapter<Column> ADAPTER = null;
            public static final HorizontalAlign DEFAULT_HORIZONTAL_ALIGN = null;
            public static final Boolean DEFAULT_IS_HEADER = null;
            public static final VerticalAlign DEFAULT_VERTICAL_ALIGN = null;
            public static final Integer DEFAULT_WIDTH = null;
            private static final long serialVersionUID = 0;
            public final HorizontalAlign horizontal_align;
            public final Boolean is_header;
            public final VerticalAlign vertical_align;
            public final Integer width;

            public static final class Builder extends com.squareup.wire.Message.Builder<Column, Builder> {
                public HorizontalAlign horizontal_align;
                public Boolean is_header;
                public VerticalAlign vertical_align;
                public Integer width;

                @Override // com.squareup.wire.Message.Builder
                public Column build() {
                    return new Column(this.width, this.horizontal_align, this.vertical_align, this.is_header, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder horizontal_align(HorizontalAlign r100) {
                    this.horizontal_align = r100;
                    return this;
                }

                public Builder is_header(Boolean r100) {
                    this.is_header = r100;
                    return this;
                }

                public Builder vertical_align(VerticalAlign r100) {
                    this.vertical_align = r100;
                    return this;
                }

                public Builder width(Integer r100) {
                    this.width = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_Column extends ProtoAdapter<Column> {
                public ProtoAdapter_Column() {
                    super(FieldEncoding.LENGTH_DELIMITED, Column.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Column decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.width = 0;
                    r101.horizontal_align = HorizontalAlign.HORIZONTAL_ALIGN_UNKNOWN;
                    r101.vertical_align = VerticalAlign.VERTICAL_ALIGN_UNKNOWN;
                    r101.is_header = Boolean.FALSE;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L24;
                    if (r103 != 1) goto L8;
                    r101.width = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.horizontal_align = HorizontalAlign.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
                L21:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.vertical_align = VerticalAlign.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
                L17:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.is_header = ProtoAdapter.BOOL.decode(r100);
                    goto L3
                L13:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L24:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(Column r100) {
                    Integer r101 = r100.width;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
                L6:
                    HorizontalAlign r104 = r100.horizontal_align;
                    if (r104 == null) goto L9;
                    int r105 = HorizontalAlign.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    VerticalAlign r107 = r100.vertical_align;
                    if (r107 == null) goto L13;
                    int r108 = VerticalAlign.ADAPTER.encodedSizeWithTag(3, r107);
                L14:
                    int r109 = r106 + r108;
                    Boolean r110 = r100.is_header;
                    if (r110 == null) goto L18;
                    r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
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
                public /* bridge */ /* synthetic */ Column decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Column r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Column r101) throws IOException {
                    Integer r102 = r101.width;
                    if (r102 == null) goto L5;
                    ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
                L5:
                    HorizontalAlign r103 = r101.horizontal_align;
                    if (r103 == null) goto L8;
                    HorizontalAlign.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    VerticalAlign r104 = r101.vertical_align;
                    if (r104 == null) goto L11;
                    VerticalAlign.ADAPTER.encodeWithTag(r100, 3, r104);
                L11:
                    Boolean r105 = r101.is_header;
                    if (r105 == null) goto L14;
                    ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
                L14:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Column r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Column();
                DEFAULT_WIDTH = 0;
                DEFAULT_HORIZONTAL_ALIGN = HorizontalAlign.HORIZONTAL_ALIGN_UNKNOWN;
                DEFAULT_VERTICAL_ALIGN = VerticalAlign.VERTICAL_ALIGN_UNKNOWN;
                DEFAULT_IS_HEADER = Boolean.FALSE;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.width = this.width;
                r100.horizontal_align = this.horizontal_align;
                r100.vertical_align = this.vertical_align;
                r100.is_header = this.is_header;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Column.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public Column(Integer r100, HorizontalAlign r101, VerticalAlign r102, Boolean r110) {
                this(r100, r101, r102, r110, ByteString.EMPTY);
            }

            public Column(Integer r100, HorizontalAlign r101, VerticalAlign r102, Boolean r103, ByteString r104) {
                super(ADAPTER, r104);
                this.width = r100;
                this.horizontal_align = r101;
                this.vertical_align = r102;
                this.is_header = r103;
            }
        }

        public static final class ProtoAdapter_TableProperty extends ProtoAdapter<TableProperty> {
            public ProtoAdapter_TableProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TableProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TableProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.columns.add(Column.ADAPTER.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TableProperty r100) {
                return Column.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.columns) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TableProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TableProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TableProperty r101) throws IOException {
                Column.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.columns);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TableProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TableProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.columns = Internal.copyOf("columns", this.columns);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TableProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TableProperty(List<Column> r100) {
            this(r100, ByteString.EMPTY);
        }

        public TableProperty(List<Column> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.columns = Internal.immutableCopyOf("columns", r100);
        }
    }

    public static final class TableRowProperty extends com.squareup.wire.Message<TableRowProperty, Builder> {
        public static final ProtoAdapter<TableRowProperty> ADAPTER = null;
        public static final HorizontalAlign DEFAULT_HORIZONTAL_ALIGN = null;
        public static final Boolean DEFAULT_IS_HEADER = null;
        public static final VerticalAlign DEFAULT_VERTICAL_ALIGN = null;
        private static final long serialVersionUID = 0;
        public final HorizontalAlign horizontal_align;
        public final Boolean is_header;
        public final VerticalAlign vertical_align;

        public static final class Builder extends com.squareup.wire.Message.Builder<TableRowProperty, Builder> {
            public HorizontalAlign horizontal_align;
            public Boolean is_header;
            public VerticalAlign vertical_align;

            @Override // com.squareup.wire.Message.Builder
            public TableRowProperty build() {
                return new TableRowProperty(this.horizontal_align, this.vertical_align, this.is_header, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder horizontal_align(HorizontalAlign r100) {
                this.horizontal_align = r100;
                return this;
            }

            public Builder is_header(Boolean r100) {
                this.is_header = r100;
                return this;
            }

            public Builder vertical_align(VerticalAlign r100) {
                this.vertical_align = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TableRowProperty extends ProtoAdapter<TableRowProperty> {
            public ProtoAdapter_TableRowProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TableRowProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TableRowProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.horizontal_align = HorizontalAlign.HORIZONTAL_ALIGN_UNKNOWN;
                r101.vertical_align = VerticalAlign.VERTICAL_ALIGN_UNKNOWN;
                r101.is_header = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.horizontal_align = HorizontalAlign.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.vertical_align = VerticalAlign.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.is_header = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TableRowProperty r100) {
                HorizontalAlign r101 = r100.horizontal_align;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = HorizontalAlign.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                VerticalAlign r104 = r100.vertical_align;
                if (r104 == null) goto L9;
                int r105 = VerticalAlign.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.is_header;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ TableRowProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TableRowProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TableRowProperty r101) throws IOException {
                HorizontalAlign r102 = r101.horizontal_align;
                if (r102 == null) goto L5;
                HorizontalAlign.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                VerticalAlign r103 = r101.vertical_align;
                if (r103 == null) goto L8;
                VerticalAlign.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.is_header;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TableRowProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TableRowProperty();
            DEFAULT_HORIZONTAL_ALIGN = HorizontalAlign.HORIZONTAL_ALIGN_UNKNOWN;
            DEFAULT_VERTICAL_ALIGN = VerticalAlign.VERTICAL_ALIGN_UNKNOWN;
            DEFAULT_IS_HEADER = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.horizontal_align = this.horizontal_align;
            r100.vertical_align = this.vertical_align;
            r100.is_header = this.is_header;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TableRowProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TableRowProperty(HorizontalAlign r100, VerticalAlign r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public TableRowProperty(HorizontalAlign r100, VerticalAlign r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.horizontal_align = r100;
            this.vertical_align = r101;
            this.is_header = r102;
        }
    }

    public static final enum Tag extends Enum<Tag> implements WireEnum {
        private static final /* synthetic */ Tag[] $VALUES = null;
        public static final Tag A = null;
        public static final ProtoAdapter<Tag> ADAPTER = null;
        public static final Tag AT = null;
        public static final Tag AT_USER_GROUP = null;
        public static final Tag B = null;
        public static final Tag BUTTON = null;
        public static final Tag CODE = null;
        public static final Tag CODE_BLOCK = null;
        public static final Tag CODE_BLOCK_V2 = null;
        public static final Tag COLUMN = null;
        public static final Tag COLUMNS = null;
        public static final Tag DATEPICKER = null;
        public static final Tag DATETIMEPICKER = null;
        public static final Tag DIV = null;
        public static final Tag DOCS = null;
        public static final Tag EMOTION = null;
        public static final Tag FIGURE = null;
        public static final Tag H1 = null;
        public static final Tag H2 = null;
        public static final Tag H3 = null;
        public static final Tag H4 = null;
        public static final Tag H5 = null;
        public static final Tag H6 = null;
        public static final Tag HR = null;
        public static final Tag I = null;
        public static final Tag IMAGE_GALLERY = null;
        public static final Tag IMG = null;
        public static final Tag LI = null;
        public static final Tag LINK = null;
        public static final Tag MARKDOWN = null;
        public static final Tag MEDIA = null;
        public static final Tag MENTION = null;
        public static final Tag MY_AI_TOOL = null;
        public static final Tag OL = null;
        public static final Tag OVERFLOWMENU = null;
        public static final Tag P = null;
        public static final Tag PROGRESSSELECT = null;
        public static final Tag QUOTE = null;
        public static final Tag REACTION = null;
        public static final Tag SELECT = null;
        public static final Tag SELECTMENU = null;
        public static final Tag TABLE = null;
        public static final Tag TABLE_CELL = null;
        public static final Tag TABLE_ROW = null;
        public static final Tag TEXT = null;
        public static final Tag TEXTABLEAREA = null;
        public static final Tag TIME = null;
        public static final Tag TIMEPICKER = null;
        public static final Tag U = null;
        public static final Tag UL = null;
        public static final Tag UNKNOWN = null;
        private final int value;

        static {
            Tag r100 = new Tag("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Tag r101 = new Tag(CardAdapter.TEXT, 1, 1);
            TEXT = r101;
            Tag r102 = new Tag("IMG", 2, 2);
            IMG = r102;
            Tag r103 = new Tag("P", 3, 3);
            P = r103;
            Tag r104 = new Tag("FIGURE", 4, 4);
            FIGURE = r104;
            Tag r105 = new Tag("AT", 5, 5);
            AT = r105;
            Tag r110 = new Tag(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 6, 6);
            A = r110;
            Tag r111 = new Tag("B", 7, 7);
            B = r111;
            Tag r112 = new Tag("I", 8, 8);
            I = r112;
            Tag r113 = new Tag("U", 9, 9);
            U = r113;
            Tag r114 = new Tag("EMOTION", 10, 10);
            EMOTION = r114;
            Tag r115 = new Tag("BUTTON", 11, 11);
            BUTTON = r115;
            Tag r106 = new Tag("SELECT", 12, 12);
            SELECT = r106;
            Tag r107 = new Tag("PROGRESSSELECT", 13, 13);
            PROGRESSSELECT = r107;
            Tag r108 = new Tag("DIV", 14, 14);
            DIV = r108;
            Tag r109 = new Tag("TEXTABLEAREA", 15, 15);
            TEXTABLEAREA = r109;
            Tag r116 = new Tag("TIME", 16, 16);
            TIME = r116;
            Tag r117 = new Tag("LINK", 17, 17);
            LINK = r117;
            Tag r118 = new Tag("MEDIA", 18, 18);
            MEDIA = r118;
            Tag r119 = new Tag("SELECTMENU", 19, 19);
            SELECTMENU = r119;
            Tag r120 = new Tag("OVERFLOWMENU", 20, 20);
            OVERFLOWMENU = r120;
            Tag r121 = new Tag("DATEPICKER", 21, 21);
            DATEPICKER = r121;
            Tag r122 = new Tag("DOCS", 22, 22);
            DOCS = r122;
            Tag r123 = new Tag("H1", 23, 23);
            H1 = r123;
            Tag r124 = new Tag("H2", 24, 24);
            H2 = r124;
            Tag r125 = new Tag("H3", 25, 25);
            H3 = r125;
            Tag r126 = new Tag("UL", 26, 26);
            UL = r126;
            Tag r127 = new Tag("OL", 27, 27);
            OL = r127;
            Tag r128 = new Tag("LI", 28, 28);
            LI = r128;
            Tag r129 = new Tag("QUOTE", 29, 29);
            QUOTE = r129;
            Tag r130 = new Tag("CODE", 30, 30);
            CODE = r130;
            Tag r131 = new Tag("CODE_BLOCK", 31, 31);
            CODE_BLOCK = r131;
            Tag r132 = new Tag("HR", 32, 32);
            HR = r132;
            Tag r133 = new Tag("TIMEPICKER", 33, 33);
            TIMEPICKER = r133;
            Tag r134 = new Tag("DATETIMEPICKER", 34, 34);
            DATETIMEPICKER = r134;
            Tag r135 = new Tag(CardAdapter.REACTION, 35, 35);
            REACTION = r135;
            Tag r136 = new Tag("MENTION", 36, 36);
            MENTION = r136;
            Tag r137 = new Tag("CODE_BLOCK_V2", 37, 37);
            CODE_BLOCK_V2 = r137;
            Tag r138 = new Tag("MY_AI_TOOL", 38, 38);
            MY_AI_TOOL = r138;
            Tag r139 = new Tag("TABLE", 39, 39);
            TABLE = r139;
            Tag r140 = new Tag("TABLE_ROW", 40, 40);
            TABLE_ROW = r140;
            Tag r141 = new Tag("TABLE_CELL", 41, 41);
            TABLE_CELL = r141;
            Tag r142 = new Tag("COLUMNS", 42, 42);
            COLUMNS = r142;
            Tag r143 = new Tag("COLUMN", 43, 43);
            COLUMN = r143;
            Tag r144 = new Tag("H4", 44, 44);
            H4 = r144;
            Tag r145 = new Tag("H5", 45, 45);
            H5 = r145;
            Tag r146 = new Tag("H6", 46, 46);
            H6 = r146;
            Tag r147 = new Tag("AT_USER_GROUP", 47, 47);
            AT_USER_GROUP = r147;
            Tag r148 = new Tag("IMAGE_GALLERY", 48, 48);
            IMAGE_GALLERY = r148;
            Tag r149 = new Tag("MARKDOWN", 49, 49);
            MARKDOWN = r149;
            $VALUES = new Tag[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149};
            ADAPTER = ProtoAdapter.newEnumAdapter(Tag.class);
        }

        public static Tag[] values() {
            return (Tag[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Tag fromValue(int r100) {
            switch(r100) {
                case 0: goto L104;
                case 1: goto L102;
                case 2: goto L100;
                case 3: goto L98;
                case 4: goto L96;
                case 5: goto L94;
                case 6: goto L92;
                case 7: goto L90;
                case 8: goto L88;
                case 9: goto L86;
                case 10: goto L84;
                case 11: goto L82;
                case 12: goto L80;
                case 13: goto L78;
                case 14: goto L76;
                case 15: goto L74;
                case 16: goto L72;
                case 17: goto L70;
                case 18: goto L68;
                case 19: goto L66;
                case 20: goto L64;
                case 21: goto L62;
                case 22: goto L60;
                case 23: goto L58;
                case 24: goto L56;
                case 25: goto L54;
                case 26: goto L52;
                case 27: goto L50;
                case 28: goto L48;
                case 29: goto L46;
                case 30: goto L44;
                case 31: goto L42;
                case 32: goto L40;
                case 33: goto L38;
                case 34: goto L36;
                case 35: goto L34;
                case 36: goto L32;
                case 37: goto L30;
                case 38: goto L28;
                case 39: goto L26;
                case 40: goto L24;
                case 41: goto L22;
                case 42: goto L20;
                case 43: goto L18;
                case 44: goto L16;
                case 45: goto L14;
                case 46: goto L12;
                case 47: goto L10;
                case 48: goto L8;
                case 49: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return MARKDOWN;
        L8:
            return IMAGE_GALLERY;
        L10:
            return AT_USER_GROUP;
        L12:
            return H6;
        L14:
            return H5;
        L16:
            return H4;
        L18:
            return COLUMN;
        L20:
            return COLUMNS;
        L22:
            return TABLE_CELL;
        L24:
            return TABLE_ROW;
        L26:
            return TABLE;
        L28:
            return MY_AI_TOOL;
        L30:
            return CODE_BLOCK_V2;
        L32:
            return MENTION;
        L34:
            return REACTION;
        L36:
            return DATETIMEPICKER;
        L38:
            return TIMEPICKER;
        L40:
            return HR;
        L42:
            return CODE_BLOCK;
        L44:
            return CODE;
        L46:
            return QUOTE;
        L48:
            return LI;
        L50:
            return OL;
        L52:
            return UL;
        L54:
            return H3;
        L56:
            return H2;
        L58:
            return H1;
        L60:
            return DOCS;
        L62:
            return DATEPICKER;
        L64:
            return OVERFLOWMENU;
        L66:
            return SELECTMENU;
        L68:
            return MEDIA;
        L70:
            return LINK;
        L72:
            return TIME;
        L74:
            return TEXTABLEAREA;
        L76:
            return DIV;
        L78:
            return PROGRESSSELECT;
        L80:
            return SELECT;
        L82:
            return BUTTON;
        L84:
            return EMOTION;
        L86:
            return U;
        L88:
            return I;
        L90:
            return B;
        L92:
            return A;
        L94:
            return AT;
        L96:
            return FIGURE;
        L98:
            return P;
        L100:
            return IMG;
        L102:
            return TEXT;
        L104:
            return UNKNOWN;
        }

        public static Tag valueOf(String r100) {
            return (Tag) a.a(Tag.class, r100);
        }

        private Tag(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class TextProperty extends com.squareup.wire.Message<TextProperty, Builder> {
        public static final ProtoAdapter<TextProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_I18N_KEY = "";
        public static final Integer DEFAULT_NUMBEROFLINES = null;
        private static final long serialVersionUID = 0;
        public final String content;
        public final String i18n_key;
        public final Integer numberOfLines;

        public static final class Builder extends com.squareup.wire.Message.Builder<TextProperty, Builder> {
            public String content;
            public String i18n_key;
            public Integer numberOfLines;

            @Override // com.squareup.wire.Message.Builder
            public TextProperty build() {
                String r100 = this.content;
                if (r100 == null) goto L7;
                return new TextProperty(this.content, this.i18n_key, this.numberOfLines, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "content"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder i18n_key(String r100) {
                this.i18n_key = r100;
                return this;
            }

            public Builder numberOfLines(Integer r100) {
                this.numberOfLines = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TextProperty extends ProtoAdapter<TextProperty> {
            public ProtoAdapter_TextProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TextProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TextProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.content = "";
                r101.i18n_key = "";
                r101.numberOfLines = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.numberOfLines = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(TextProperty r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.content);
                String r103 = r100.i18n_key;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(2, r103);
            L6:
                int r106 = r102 + r105;
                Integer r107 = r100.numberOfLines;
                if (r107 == null) goto L10;
                r104 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
            L10:
                return (r106 + r104) + r100.unknownFields().size();
            L5:
                r105 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TextProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TextProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TextProperty r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.content);
                String r103 = r101.i18n_key;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 2, r103);
            L5:
                Integer r104 = r101.numberOfLines;
                if (r104 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TextProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TextProperty();
            DEFAULT_NUMBEROFLINES = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.content = this.content;
            r100.i18n_key = this.i18n_key;
            r100.numberOfLines = this.numberOfLines;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TextProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TextProperty(String r100, String r101, Integer r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public TextProperty(String r100, String r101, Integer r102, ByteString r103) {
            super(ADAPTER, r103);
            this.content = r100;
            this.i18n_key = r101;
            this.numberOfLines = r102;
        }
    }

    public static final class TextableAreaProperty extends com.squareup.wire.Message<TextableAreaProperty, Builder> {
        public static final ProtoAdapter<TextableAreaProperty> ADAPTER = null;
        public static final Integer DEFAULT_NUMBEROFLINES = null;
        private static final long serialVersionUID = 0;
        public final Integer numberOfLines;

        public static final class Builder extends com.squareup.wire.Message.Builder<TextableAreaProperty, Builder> {
            public Integer numberOfLines;

            @Override // com.squareup.wire.Message.Builder
            public TextableAreaProperty build() {
                return new TextableAreaProperty(this.numberOfLines, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder numberOfLines(Integer r100) {
                this.numberOfLines = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TextableAreaProperty extends ProtoAdapter<TextableAreaProperty> {
            public ProtoAdapter_TextableAreaProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TextableAreaProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TextableAreaProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.numberOfLines = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.numberOfLines = ProtoAdapter.INT32.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TextableAreaProperty r100) {
                Integer r101 = r100.numberOfLines;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TextableAreaProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TextableAreaProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TextableAreaProperty r101) throws IOException {
                Integer r102 = r101.numberOfLines;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TextableAreaProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TextableAreaProperty();
            DEFAULT_NUMBEROFLINES = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.numberOfLines = this.numberOfLines;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TextableAreaProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TextableAreaProperty(Integer r100) {
            this(r100, ByteString.EMPTY);
        }

        public TextableAreaProperty(Integer r100, ByteString r101) {
            super(ADAPTER, r101);
            this.numberOfLines = r100;
        }
    }

    public static final class TimePickerProperty extends com.squareup.wire.Message<TimePickerProperty, Builder> {
        public static final ProtoAdapter<TimePickerProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final Boolean DEFAULT_DISABLE = null;
        public static final String DEFAULT_INITIAL_TIME = "";
        public static final Boolean DEFAULT_IS_LOADING = null;
        public static final String DEFAULT_PLACE_HOLDER = "";
        public static final String DEFAULT_PLACE_HOLDER_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String action_id;
        public final ButtonConfirmProperty confirm;
        public final Boolean disable;
        public final String initial_time;
        public final Boolean is_loading;
        public final String place_holder;
        public final String place_holder_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<TimePickerProperty, Builder> {
            public String action_id;
            public ButtonConfirmProperty confirm;
            public Boolean disable;
            public String initial_time;
            public Boolean is_loading;
            public String place_holder;
            public String place_holder_i18n_key;

            @Override // com.squareup.wire.Message.Builder
            public TimePickerProperty build() {
                return new TimePickerProperty(this.action_id, this.place_holder, this.place_holder_i18n_key, this.initial_time, this.confirm, this.disable, this.is_loading, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.action_id = r100;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r100) {
                this.confirm = r100;
                return this;
            }

            public Builder disable(Boolean r100) {
                this.disable = r100;
                return this;
            }

            public Builder initial_time(String r100) {
                this.initial_time = r100;
                return this;
            }

            public Builder is_loading(Boolean r100) {
                this.is_loading = r100;
                return this;
            }

            public Builder place_holder(String r100) {
                this.place_holder = r100;
                return this;
            }

            public Builder place_holder_i18n_key(String r100) {
                this.place_holder_i18n_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TimePickerProperty extends ProtoAdapter<TimePickerProperty> {
            public ProtoAdapter_TimePickerProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TimePickerProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TimePickerProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.action_id = "";
                r101.place_holder = "";
                r101.place_holder_i18n_key = "";
                r101.initial_time = "";
                Boolean r102 = Boolean.FALSE;
                r101.disable = r102;
                r101.is_loading = r102;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L14;
                switch(r104) {
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
                r101.is_loading = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                r101.disable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                r101.confirm = ButtonConfirmProperty.ADAPTER.decode(r100);
                goto L3
            L10:
                r101.initial_time = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.place_holder_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.place_holder = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.action_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L14:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TimePickerProperty r100) {
                String r101 = r100.action_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.place_holder;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.place_holder_i18n_key;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.initial_time;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                ButtonConfirmProperty r113 = r100.confirm;
                if (r113 == null) goto L21;
                int r114 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                Boolean r116 = r100.disable;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Boolean r119 = r100.is_loading;
                if (r119 == null) goto L30;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
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
            public /* bridge */ /* synthetic */ TimePickerProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TimePickerProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TimePickerProperty r101) throws IOException {
                String r102 = r101.action_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.place_holder;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.place_holder_i18n_key;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.initial_time;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                ButtonConfirmProperty r106 = r101.confirm;
                if (r106 == null) goto L17;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                Boolean r107 = r101.disable;
                if (r107 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
            L20:
                Boolean r108 = r101.is_loading;
                if (r108 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
            L23:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TimePickerProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimePickerProperty();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_DISABLE = r100;
            DEFAULT_IS_LOADING = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.action_id = this.action_id;
            r100.place_holder = this.place_holder;
            r100.place_holder_i18n_key = this.place_holder_i18n_key;
            r100.initial_time = this.initial_time;
            r100.confirm = this.confirm;
            r100.disable = this.disable;
            r100.is_loading = this.is_loading;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TimePickerProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TimePickerProperty(String r110, String r111, String r112, String r113, ButtonConfirmProperty r114, Boolean r115, Boolean r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public TimePickerProperty(String r100, String r101, String r102, String r103, ButtonConfirmProperty r104, Boolean r105, Boolean r106, ByteString r107) {
            super(ADAPTER, r107);
            this.action_id = r100;
            this.place_holder = r101;
            this.place_holder_i18n_key = r102;
            this.initial_time = r103;
            this.confirm = r104;
            this.disable = r105;
            this.is_loading = r106;
        }
    }

    public static final class TimeProperty extends com.squareup.wire.Message<TimeProperty, Builder> {
        public static final ProtoAdapter<TimeProperty> ADAPTER = null;
        public static final String DEFAULT_FORMAT = "YYYY.MM.DD(dddd) HH:mm (GMT)";
        public static final String DEFAULT_FORMAT_TYPE = "";
        public static final String DEFAULT_LINK = "";
        public static final Long DEFAULT_MILLISECOND_SINCE1970 = null;
        private static final long serialVersionUID = 0;
        public final String format;
        public final String format_type;
        public final String link;
        public final Long millisecond_since1970;

        public static final class Builder extends com.squareup.wire.Message.Builder<TimeProperty, Builder> {
            public String format;
            public String format_type;
            public String link;
            public Long millisecond_since1970;

            @Override // com.squareup.wire.Message.Builder
            public TimeProperty build() {
                Long r100 = this.millisecond_since1970;
                if (r100 == null) goto L7;
                return new TimeProperty(this.millisecond_since1970, this.format, this.link, this.format_type, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "millisecond_since1970"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder format(String r100) {
                this.format = r100;
                return this;
            }

            public Builder format_type(String r100) {
                this.format_type = r100;
                return this;
            }

            public Builder link(String r100) {
                this.link = r100;
                return this;
            }

            public Builder millisecond_since1970(Long r100) {
                this.millisecond_since1970 = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TimeProperty extends ProtoAdapter<TimeProperty> {
            public ProtoAdapter_TimeProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, TimeProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TimeProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.millisecond_since1970 = 0L;
                r101.format = "YYYY.MM.DD(dddd) HH:mm (GMT)";
                r101.link = "";
                r101.format_type = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.millisecond_since1970 = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.format = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.link = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.format_type = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TimeProperty r100) {
                int r101 = ProtoAdapter.INT64.encodedSizeWithTag(1, r100.millisecond_since1970);
                String r102 = r100.format;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
            L6:
                int r105 = r101 + r104;
                String r106 = r100.link;
                if (r106 == null) goto L9;
                int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
            L10:
                int r108 = r105 + r107;
                String r109 = r100.format_type;
                if (r109 == null) goto L14;
                r103 = ProtoAdapter.STRING.encodedSizeWithTag(4, r109);
            L14:
                return (r108 + r103) + r100.unknownFields().size();
            L9:
                r107 = 0;
                goto L10
            L5:
                r104 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TimeProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TimeProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TimeProperty r101) throws IOException {
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.millisecond_since1970);
                String r102 = r101.format;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
            L5:
                String r103 = r101.link;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
            L8:
                String r104 = r101.format_type;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TimeProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimeProperty();
            DEFAULT_MILLISECOND_SINCE1970 = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.millisecond_since1970 = this.millisecond_since1970;
            r100.format = this.format;
            r100.link = this.link;
            r100.format_type = this.format_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TimeProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TimeProperty(Long r100, String r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public TimeProperty(Long r100, String r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.millisecond_since1970 = r100;
            this.format = r101;
            this.link = r102;
            this.format_type = r103;
        }
    }

    public static final class ULProperty extends com.squareup.wire.Message<ULProperty, Builder> {
        public static final ProtoAdapter<ULProperty> ADAPTER = null;
        public static final Type DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final Type type;

        public static final class Builder extends com.squareup.wire.Message.Builder<ULProperty, Builder> {
            public Type type;

            @Override // com.squareup.wire.Message.Builder
            public ULProperty build() {
                return new ULProperty(this.type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder type(Type r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ULProperty extends ProtoAdapter<ULProperty> {
            public ProtoAdapter_ULProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, ULProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ULProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = Type.DISC;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ULProperty r100) {
                Type r101 = r100.type;
                if (r101 == null) goto L5;
                int r102 = Type.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ULProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ULProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ULProperty r101) throws IOException {
                Type r102 = r101.type;
                if (r102 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ULProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type CIRCLE = null;
            public static final Type DISC = null;
            public static final Type NONE = null;
            public static final Type SQUARE = null;
            private final int value;

            static {
                Type r100 = new Type("DISC", 0, 0);
                DISC = r100;
                Type r101 = new Type("CIRCLE", 1, 1);
                CIRCLE = r101;
                Type r102 = new Type("SQUARE", 2, 2);
                SQUARE = r102;
                Type r103 = new Type(UserProfileEvent.POSITION_NONE, 3, 3);
                NONE = r103;
                $VALUES = new Type[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return NONE;
            L14:
                return SQUARE;
            L16:
                return CIRCLE;
            L18:
                return DISC;
            }

            public static Type valueOf(String r100) {
                return (Type) a.a(Type.class, r100);
            }

            private Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ULProperty();
            DEFAULT_TYPE = Type.DISC;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ULProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ULProperty(Type r100) {
            this(r100, ByteString.EMPTY);
        }

        public ULProperty(Type r100, ByteString r101) {
            super(ADAPTER, r101);
            this.type = r100;
        }
    }

    public static final class UnderlineProperty extends com.squareup.wire.Message<UnderlineProperty, Builder> {
        public static final ProtoAdapter<UnderlineProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String content;
        public final String i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<UnderlineProperty, Builder> {
            public String content;
            public String i18n_key;

            @Override // com.squareup.wire.Message.Builder
            public UnderlineProperty build() {
                String r100 = this.content;
                if (r100 == null) goto L7;
                return new UnderlineProperty(this.content, this.i18n_key, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "content"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder i18n_key(String r100) {
                this.i18n_key = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UnderlineProperty extends ProtoAdapter<UnderlineProperty> {
            public ProtoAdapter_UnderlineProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, UnderlineProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UnderlineProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.content = "";
                r101.i18n_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(UnderlineProperty r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.content);
                String r103 = r100.i18n_key;
                if (r103 == null) goto L5;
                int r104 = r101.encodedSizeWithTag(2, r103);
            L7:
                return (r102 + r104) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ UnderlineProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UnderlineProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UnderlineProperty r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.content);
                String r103 = r101.i18n_key;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 2, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UnderlineProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UnderlineProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.content = this.content;
            r100.i18n_key = this.i18n_key;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UnderlineProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public UnderlineProperty(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public UnderlineProperty(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.content = r100;
            this.i18n_key = r101;
        }
    }

    public static final class UnknownProperty extends com.squareup.wire.Message<UnknownProperty, Builder> {
        public static final ProtoAdapter<UnknownProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<UnknownProperty, Builder> {
            @Override // com.squareup.wire.Message.Builder
            public UnknownProperty build() {
                return new UnknownProperty(super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }
        }

        public static final class ProtoAdapter_UnknownProperty extends ProtoAdapter<UnknownProperty> {
            public ProtoAdapter_UnknownProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, UnknownProperty.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UnknownProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L6;
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L6:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(UnknownProperty r100) {
                return r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ UnknownProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UnknownProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UnknownProperty r101) throws IOException {
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UnknownProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UnknownProperty();
        }

        public UnknownProperty() {
            this(ByteString.EMPTY);
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UnknownProperty.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public UnknownProperty(ByteString r100) {
            super(ADAPTER, r100);
        }
    }

    public static final enum VerticalAlign extends Enum<VerticalAlign> implements WireEnum {
        private static final /* synthetic */ VerticalAlign[] $VALUES = null;
        public static final ProtoAdapter<VerticalAlign> ADAPTER = null;
        public static final VerticalAlign VERTICAL_ALIGN_BOTTOM = null;
        public static final VerticalAlign VERTICAL_ALIGN_CENTER = null;
        public static final VerticalAlign VERTICAL_ALIGN_TOP = null;
        public static final VerticalAlign VERTICAL_ALIGN_UNKNOWN = null;
        private final int value;

        static {
            VerticalAlign r100 = new VerticalAlign("VERTICAL_ALIGN_UNKNOWN", 0, 0);
            VERTICAL_ALIGN_UNKNOWN = r100;
            VerticalAlign r101 = new VerticalAlign("VERTICAL_ALIGN_TOP", 1, 1);
            VERTICAL_ALIGN_TOP = r101;
            VerticalAlign r102 = new VerticalAlign("VERTICAL_ALIGN_CENTER", 2, 2);
            VERTICAL_ALIGN_CENTER = r102;
            VerticalAlign r103 = new VerticalAlign("VERTICAL_ALIGN_BOTTOM", 3, 3);
            VERTICAL_ALIGN_BOTTOM = r103;
            $VALUES = new VerticalAlign[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(VerticalAlign.class);
        }

        public static VerticalAlign[] values() {
            return (VerticalAlign[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static VerticalAlign fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return VERTICAL_ALIGN_BOTTOM;
        L14:
            return VERTICAL_ALIGN_CENTER;
        L16:
            return VERTICAL_ALIGN_TOP;
        L18:
            return VERTICAL_ALIGN_UNKNOWN;
        }

        public static VerticalAlign valueOf(String r100) {
            return (VerticalAlign) a.a(VerticalAlign.class, r100);
        }

        private VerticalAlign(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RichTextElement();
        DEFAULT_TAG = Tag.UNKNOWN;
        DEFAULT_SER_UPGRADE_ELEMENT = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tag = this.tag;
        r100.style = Internal.copyOf("style", this.style);
        r100.property = this.property;
        r100.child_ids = Internal.copyOf("child_ids", this.child_ids);
        r100.style_keys = Internal.copyOf("style_keys", this.style_keys);
        r100.wide_style = Internal.copyOf("wide_style", this.wide_style);
        r100.ser_upgrade_element = this.ser_upgrade_element;
        r100.last_upgrade_version = this.last_upgrade_version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RichTextElement.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public RichTextElement(Tag r110, Map<String, String> r111, PropertySet r112, List<String> r113, List<String> r114, Map<String, String> r115, ByteString r116, String r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public RichTextElement(Tag r100, Map<String, String> r101, PropertySet r102, List<String> r103, List<String> r104, Map<String, String> r105, ByteString r106, String r107, ByteString r110) {
        super(ADAPTER, r110);
        this.tag = r100;
        this.style = Internal.immutableCopyOf("style", r101);
        this.property = r102;
        this.child_ids = Internal.immutableCopyOf("child_ids", r103);
        this.style_keys = Internal.immutableCopyOf("style_keys", r104);
        this.wide_style = Internal.immutableCopyOf("wide_style", r105);
        this.ser_upgrade_element = r106;
        this.last_upgrade_version = r107;
    }
}
