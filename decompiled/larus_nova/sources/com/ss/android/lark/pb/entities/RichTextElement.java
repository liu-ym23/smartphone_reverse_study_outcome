package com.ss.android.lark.pb.entities;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
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

/* JADX INFO: loaded from: classes37.dex */
public final class RichTextElement extends com.squareup.wire.Message<RichTextElement, Builder> {
    public static final ProtoAdapter<RichTextElement> ADAPTER = null;
    public static final ByteString DEFAULT_PROPERTY = null;
    public static final ByteString DEFAULT_UPGRADE_ELEMENT = null;
    private static final long serialVersionUID = 0;
    public final List<String> mchild_ids;
    public final ByteString mproperty;
    public final Map<String, String> mstyle;
    public final List<String> mstyle_keys;
    public final Tag mtag;
    public final ByteString mupgrade_element;

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
        public static final String DEFAULT_TEXT_CONTENT = "";
        private static final long serialVersionUID = 0;
        public final String mandroid_href;
        public final Boolean mclose_card_preview;
        public final String mcontent;
        public final String mhref;
        public final String mi18n_key;
        public final String mios_href;
        public final Boolean mis_custom;
        public final String mpc_href;
        public final Scene mscene;
        public final SpecialURL mspecial_url;
        public final String mtext_content;

        public static final class Builder extends com.squareup.wire.Message.Builder<AnchorProperty, Builder> {
            public String mandroid_href;
            public Boolean mclose_card_preview;
            public String mcontent;
            public String mhref;
            public String mi18n_key;
            public String mios_href;
            public Boolean mis_custom;
            public String mpc_href;
            public Scene mscene;
            public SpecialURL mspecial_url;
            public String mtext_content;

            @Override // com.squareup.wire.Message.Builder
            public AnchorProperty build() {
                String r100 = this.mhref;
                if (r100 == null) goto L9;
                if (this.mcontent == null) goto L9;
                return new AnchorProperty(this.mhref, this.mcontent, this.mtext_content, this.mspecial_url, this.mi18n_key, this.mios_href, this.mandroid_href, this.mpc_href, this.mis_custom, this.mscene, this.mclose_card_preview, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "mhref", this.mcontent, "mcontent"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder android_href(String r100) {
                this.mandroid_href = r100;
                return this;
            }

            public Builder close_card_preview(Boolean r100) {
                this.mclose_card_preview = r100;
                return this;
            }

            public Builder content(String r100) {
                this.mcontent = r100;
                return this;
            }

            public Builder href(String r100) {
                this.mhref = r100;
                return this;
            }

            public Builder i18n_key(String r100) {
                this.mi18n_key = r100;
                return this;
            }

            public Builder ios_href(String r100) {
                this.mios_href = r100;
                return this;
            }

            public Builder is_custom(Boolean r100) {
                this.mis_custom = r100;
                return this;
            }

            public Builder pc_href(String r100) {
                this.mpc_href = r100;
                return this;
            }

            public Builder scene(Scene r100) {
                this.mscene = r100;
                return this;
            }

            public Builder special_url(SpecialURL r100) {
                this.mspecial_url = r100;
                return this;
            }

            public Builder text_content(String r100) {
                this.mtext_content = r100;
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
                r101.mhref = "";
                r101.mcontent = "";
                r101.mtext_content = "";
                r101.mi18n_key = "";
                r101.mios_href = "";
                r101.mandroid_href = "";
                r101.mpc_href = "";
                Boolean r102 = Boolean.FALSE;
                r101.mis_custom = r102;
                r101.mclose_card_preview = r102;
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
                r101.mspecial_url = SpecialURL.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L28:
                r101.mscene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.mclose_card_preview = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.mis_custom = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.mpc_href = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.mandroid_href = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.mios_href = ProtoAdapter.STRING.decode(r100);
                goto L3
            L16:
                r101.mi18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L21:
                r101.mtext_content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L22:
                r101.mcontent = ProtoAdapter.STRING.decode(r100);
                goto L3
            L23:
                r101.mhref = ProtoAdapter.STRING.decode(r100);
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
                int r102 = r101.encodedSizeWithTag(1, r100.mhref) + r101.encodedSizeWithTag(2, r100.mcontent);
                String r103 = r100.mtext_content;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(3, r103);
            L6:
                int r106 = r102 + r105;
                SpecialURL r107 = r100.mspecial_url;
                if (r107 == null) goto L9;
                int r108 = SpecialURL.ADAPTER.encodedSizeWithTag(4, r107);
            L10:
                int r109 = r106 + r108;
                String r110 = r100.mi18n_key;
                if (r110 == null) goto L13;
                int r111 = r101.encodedSizeWithTag(5, r110);
            L14:
                int r112 = r109 + r111;
                String r113 = r100.mios_href;
                if (r113 == null) goto L17;
                int r114 = r101.encodedSizeWithTag(6, r113);
            L18:
                int r115 = r112 + r114;
                String r116 = r100.mandroid_href;
                if (r116 == null) goto L21;
                int r117 = r101.encodedSizeWithTag(7, r116);
            L22:
                int r118 = r115 + r117;
                String r119 = r100.mpc_href;
                if (r119 == null) goto L25;
                int r120 = r101.encodedSizeWithTag(8, r119);
            L26:
                int r121 = r118 + r120;
                Boolean r122 = r100.mis_custom;
                if (r122 == null) goto L29;
                int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r122);
            L30:
                int r124 = r121 + r123;
                Scene r125 = r100.mscene;
                if (r125 == null) goto L33;
                int r126 = Scene.ADAPTER.encodedSizeWithTag(10, r125);
            L34:
                int r127 = r124 + r126;
                Boolean r128 = r100.mclose_card_preview;
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
                r102.encodeWithTag(r100, 1, r101.mhref);
                r102.encodeWithTag(r100, 2, r101.mcontent);
                String r103 = r101.mtext_content;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 3, r103);
            L5:
                SpecialURL r104 = r101.mspecial_url;
                if (r104 == null) goto L8;
                SpecialURL.ADAPTER.encodeWithTag(r100, 4, r104);
            L8:
                String r105 = r101.mi18n_key;
                if (r105 == null) goto L11;
                r102.encodeWithTag(r100, 5, r105);
            L11:
                String r106 = r101.mios_href;
                if (r106 == null) goto L14;
                r102.encodeWithTag(r100, 6, r106);
            L14:
                String r107 = r101.mandroid_href;
                if (r107 == null) goto L17;
                r102.encodeWithTag(r100, 7, r107);
            L17:
                String r108 = r101.mpc_href;
                if (r108 == null) goto L20;
                r102.encodeWithTag(r100, 8, r108);
            L20:
                Boolean r109 = r101.mis_custom;
                if (r109 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r100, 9, r109);
            L23:
                Scene r110 = r101.mscene;
                if (r110 == null) goto L26;
                Scene.ADAPTER.encodeWithTag(r100, 10, r110);
            L26:
                Boolean r111 = r101.mclose_card_preview;
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
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IS_CUSTOM = r100;
            DEFAULT_CLOSE_CARD_PREVIEW = r100;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mhref = this.mhref;
            r100.mcontent = this.mcontent;
            r100.mtext_content = this.mtext_content;
            r100.mspecial_url = this.mspecial_url;
            r100.mi18n_key = this.mi18n_key;
            r100.mios_href = this.mios_href;
            r100.mandroid_href = this.mandroid_href;
            r100.mpc_href = this.mpc_href;
            r100.mis_custom = this.mis_custom;
            r100.mscene = this.mscene;
            r100.mclose_card_preview = this.mclose_card_preview;
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
            this.mhref = r100;
            this.mcontent = r101;
            this.mtext_content = r102;
            this.mspecial_url = r103;
            this.mi18n_key = r104;
            this.mios_href = r105;
            this.mandroid_href = r106;
            this.mpc_href = r107;
            this.mis_custom = r110;
            this.mscene = r111;
            this.mclose_card_preview = r112;
        }
    }

    public static final class AtProperty extends com.squareup.wire.Message<AtProperty, Builder> {
        public static final ProtoAdapter<AtProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final String muser_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<AtProperty, Builder> {
            public String mcontent;
            public String muser_id;

            @Override // com.squareup.wire.Message.Builder
            public AtProperty build() {
                String r100 = this.muser_id;
                if (r100 == null) goto L9;
                if (this.mcontent == null) goto L9;
                return new AtProperty(this.muser_id, this.mcontent, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "muser_id", this.mcontent, "mcontent"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.mcontent = r100;
                return this;
            }

            public Builder user_id(String r100) {
                this.muser_id = r100;
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
                r101.muser_id = "";
                r101.mcontent = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.muser_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mcontent = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(AtProperty r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                return (r101.encodedSizeWithTag(1, r100.muser_id) + r101.encodedSizeWithTag(2, r100.mcontent)) + r100.unknownFields().size();
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
                r102.encodeWithTag(r100, 1, r101.muser_id);
                r102.encodeWithTag(r100, 2, r101.mcontent);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AtProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AtProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.muser_id = this.muser_id;
            r100.mcontent = this.mcontent;
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

        public AtProperty(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public AtProperty(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.muser_id = r100;
            this.mcontent = r101;
        }
    }

    public static final class AtUserGroupProperty extends com.squareup.wire.Message<AtUserGroupProperty, Builder> {
        public static final ProtoAdapter<AtUserGroupProperty> ADAPTER = null;
        public static final String DEFAULT_DEFAULT_GROUP_NAME = "";
        public static final Long DEFAULT_USER_GROUP_ID = null;
        private static final long serialVersionUID = 0;
        public final String mdefault_group_name;
        public final Map<String, String> mi18n_group_name;
        public final Long muser_group_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<AtUserGroupProperty, Builder> {
            public String mdefault_group_name;
            public Map<String, String> mi18n_group_name;
            public Long muser_group_id;

            @Override // com.squareup.wire.Message.Builder
            public AtUserGroupProperty build() {
                return new AtUserGroupProperty(this.muser_group_id, this.mdefault_group_name, this.mi18n_group_name, super.buildUnknownFields());
            }

            public Builder() {
                this.mi18n_group_name = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder default_group_name(String r100) {
                this.mdefault_group_name = r100;
                return this;
            }

            public Builder i18n_group_name(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.mi18n_group_name = r100;
                return this;
            }

            public Builder user_group_id(Long r100) {
                this.muser_group_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AtUserGroupProperty extends ProtoAdapter<AtUserGroupProperty> {
            private final ProtoAdapter<Map<String, String>> mi18n_group_name;

            public ProtoAdapter_AtUserGroupProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, AtUserGroupProperty.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.mi18n_group_name = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AtUserGroupProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.muser_group_id = 0L;
                r101.mdefault_group_name = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.muser_group_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mdefault_group_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mi18n_group_name.putAll(this.mi18n_group_name.decode(r100));
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
                Long r101 = r100.muser_group_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mdefault_group_name;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return ((r103 + r102) + this.mi18n_group_name.encodedSizeWithTag(3, r100.mi18n_group_name)) + r100.unknownFields().size();
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
                Long r102 = r101.muser_group_id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mdefault_group_name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                this.mi18n_group_name.encodeWithTag(r100, 3, r101.mi18n_group_name);
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
            r100.muser_group_id = this.muser_group_id;
            r100.mdefault_group_name = this.mdefault_group_name;
            r100.mi18n_group_name = Internal.copyOf("mi18n_group_name", this.mi18n_group_name);
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
            this.muser_group_id = r100;
            this.mdefault_group_name = r101;
            this.mi18n_group_name = Internal.immutableCopyOf("mi18n_group_name", r102);
        }
    }

    public static final class BoldProperty extends com.squareup.wire.Message<BoldProperty, Builder> {
        public static final ProtoAdapter<BoldProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final String mi18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<BoldProperty, Builder> {
            public String mcontent;
            public String mi18n_key;

            @Override // com.squareup.wire.Message.Builder
            public BoldProperty build() {
                String r100 = this.mcontent;
                if (r100 == null) goto L7;
                return new BoldProperty(this.mcontent, this.mi18n_key, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "mcontent"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.mcontent = r100;
                return this;
            }

            public Builder i18n_key(String r100) {
                this.mi18n_key = r100;
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
                r101.mcontent = "";
                r101.mi18n_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mcontent = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mi18n_key = ProtoAdapter.STRING.decode(r100);
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
                int r102 = r101.encodedSizeWithTag(1, r100.mcontent);
                String r103 = r100.mi18n_key;
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
                r102.encodeWithTag(r100, 1, r101.mcontent);
                String r103 = r101.mi18n_key;
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
            r100.mcontent = this.mcontent;
            r100.mi18n_key = this.mi18n_key;
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
            this.mcontent = r100;
            this.mi18n_key = r101;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<RichTextElement, Builder> {
        public List<String> mchild_ids;
        public ByteString mproperty;
        public Map<String, String> mstyle;
        public List<String> mstyle_keys;
        public Tag mtag;
        public ByteString mupgrade_element;

        @Override // com.squareup.wire.Message.Builder
        public RichTextElement build() {
            Tag r100 = this.mtag;
            if (r100 == null) goto L9;
            if (this.mproperty == null) goto L9;
            return new RichTextElement(this.mtag, this.mstyle, this.mproperty, this.mchild_ids, this.mstyle_keys, this.mupgrade_element, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mtag", this.mproperty, "mproperty"});
        }

        public Builder() {
            this.mstyle = Internal.newMutableMap();
            this.mchild_ids = Internal.newMutableList();
            this.mstyle_keys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder child_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mchild_ids = r100;
            return this;
        }

        public Builder property(ByteString r100) {
            this.mproperty = r100;
            return this;
        }

        public Builder style(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mstyle = r100;
            return this;
        }

        public Builder style_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mstyle_keys = r100;
            return this;
        }

        public Builder tag(Tag r100) {
            this.mtag = r100;
            return this;
        }

        public Builder upgrade_element(ByteString r100) {
            this.mupgrade_element = r100;
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
        public final String mconfirm;
        public final String mconfirm_i18n_key;
        public final String mdismiss;
        public final String mdismiss_i18n_key;
        public final String mtext;
        public final String mtext_i18n_key;
        public final String mtitle;
        public final String mtitle_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<ButtonConfirmProperty, Builder> {
            public String mconfirm;
            public String mconfirm_i18n_key;
            public String mdismiss;
            public String mdismiss_i18n_key;
            public String mtext;
            public String mtext_i18n_key;
            public String mtitle;
            public String mtitle_i18n_key;

            @Override // com.squareup.wire.Message.Builder
            public ButtonConfirmProperty build() {
                String r100 = this.mtitle;
                if (r100 == null) goto L13;
                if (this.mtext == null) goto L13;
                if (this.mconfirm == null) goto L13;
                if (this.mdismiss == null) goto L13;
                return new ButtonConfirmProperty(this.mtitle, this.mtext, this.mconfirm, this.mdismiss, this.mtitle_i18n_key, this.mtext_i18n_key, this.mconfirm_i18n_key, this.mdismiss_i18n_key, super.buildUnknownFields());
            L13:
                throw Internal.missingRequiredFields(new Object[]{r100, "mtitle", this.mtext, "mtext", this.mconfirm, "mconfirm", this.mdismiss, "mdismiss"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder confirm(String r100) {
                this.mconfirm = r100;
                return this;
            }

            public Builder confirm_i18n_key(String r100) {
                this.mconfirm_i18n_key = r100;
                return this;
            }

            public Builder dismiss(String r100) {
                this.mdismiss = r100;
                return this;
            }

            public Builder dismiss_i18n_key(String r100) {
                this.mdismiss_i18n_key = r100;
                return this;
            }

            public Builder text(String r100) {
                this.mtext = r100;
                return this;
            }

            public Builder text_i18n_key(String r100) {
                this.mtext_i18n_key = r100;
                return this;
            }

            public Builder title(String r100) {
                this.mtitle = r100;
                return this;
            }

            public Builder title_i18n_key(String r100) {
                this.mtitle_i18n_key = r100;
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
                r101.mtitle = "";
                r101.mtext = "";
                r101.mconfirm = "";
                r101.mdismiss = "";
                r101.mtitle_i18n_key = "";
                r101.mtext_i18n_key = "";
                r101.mconfirm_i18n_key = "";
                r101.mdismiss_i18n_key = "";
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
                r101.mdismiss_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.mconfirm_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.mtext_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.mtitle_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.mdismiss = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.mconfirm = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.mtext = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.mtitle = ProtoAdapter.STRING.decode(r100);
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
                int r102 = ((r101.encodedSizeWithTag(1, r100.mtitle) + r101.encodedSizeWithTag(2, r100.mtext)) + r101.encodedSizeWithTag(3, r100.mconfirm)) + r101.encodedSizeWithTag(4, r100.mdismiss);
                String r103 = r100.mtitle_i18n_key;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(5, r103);
            L6:
                int r106 = r102 + r105;
                String r107 = r100.mtext_i18n_key;
                if (r107 == null) goto L9;
                int r108 = r101.encodedSizeWithTag(6, r107);
            L10:
                int r109 = r106 + r108;
                String r110 = r100.mconfirm_i18n_key;
                if (r110 == null) goto L13;
                int r111 = r101.encodedSizeWithTag(7, r110);
            L14:
                int r112 = r109 + r111;
                String r113 = r100.mdismiss_i18n_key;
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
                r102.encodeWithTag(r100, 1, r101.mtitle);
                r102.encodeWithTag(r100, 2, r101.mtext);
                r102.encodeWithTag(r100, 3, r101.mconfirm);
                r102.encodeWithTag(r100, 4, r101.mdismiss);
                String r103 = r101.mtitle_i18n_key;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 5, r103);
            L5:
                String r104 = r101.mtext_i18n_key;
                if (r104 == null) goto L8;
                r102.encodeWithTag(r100, 6, r104);
            L8:
                String r105 = r101.mconfirm_i18n_key;
                if (r105 == null) goto L11;
                r102.encodeWithTag(r100, 7, r105);
            L11:
                String r106 = r101.mdismiss_i18n_key;
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
            r100.mtitle = this.mtitle;
            r100.mtext = this.mtext;
            r100.mconfirm = this.mconfirm;
            r100.mdismiss = this.mdismiss;
            r100.mtitle_i18n_key = this.mtitle_i18n_key;
            r100.mtext_i18n_key = this.mtext_i18n_key;
            r100.mconfirm_i18n_key = this.mconfirm_i18n_key;
            r100.mdismiss_i18n_key = this.mdismiss_i18n_key;
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
            this.mtitle = r100;
            this.mtext = r101;
            this.mconfirm = r102;
            this.mdismiss = r103;
            this.mtitle_i18n_key = r104;
            this.mtext_i18n_key = r105;
            this.mconfirm_i18n_key = r106;
            this.mdismiss_i18n_key = r107;
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
        public final String mbegin;
        public final String mbegin_i18n_key;
        public final String mfail;
        public final String mfail_i18n_key;
        public final String msuccess;
        public final String msuccess_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<ButtonLoadingProperty, Builder> {
            public String mbegin;
            public String mbegin_i18n_key;
            public String mfail;
            public String mfail_i18n_key;
            public String msuccess;
            public String msuccess_i18n_key;

            @Override // com.squareup.wire.Message.Builder
            public ButtonLoadingProperty build() {
                String r100 = this.mbegin;
                if (r100 == null) goto L11;
                if (this.msuccess == null) goto L11;
                if (this.mfail == null) goto L11;
                return new ButtonLoadingProperty(this.mbegin, this.msuccess, this.mfail, this.mbegin_i18n_key, this.msuccess_i18n_key, this.mfail_i18n_key, super.buildUnknownFields());
            L11:
                throw Internal.missingRequiredFields(new Object[]{r100, "mbegin", this.msuccess, "msuccess", this.mfail, "mfail"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder begin(String r100) {
                this.mbegin = r100;
                return this;
            }

            public Builder begin_i18n_key(String r100) {
                this.mbegin_i18n_key = r100;
                return this;
            }

            public Builder fail(String r100) {
                this.mfail = r100;
                return this;
            }

            public Builder fail_i18n_key(String r100) {
                this.mfail_i18n_key = r100;
                return this;
            }

            public Builder success(String r100) {
                this.msuccess = r100;
                return this;
            }

            public Builder success_i18n_key(String r100) {
                this.msuccess_i18n_key = r100;
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
                r101.mbegin = "";
                r101.msuccess = "";
                r101.mfail = "";
                r101.mbegin_i18n_key = "";
                r101.msuccess_i18n_key = "";
                r101.mfail_i18n_key = "";
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
                r101.mfail_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.msuccess_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.mbegin_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.mfail = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.msuccess = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.mbegin = ProtoAdapter.STRING.decode(r100);
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
                int r102 = (r101.encodedSizeWithTag(1, r100.mbegin) + r101.encodedSizeWithTag(2, r100.msuccess)) + r101.encodedSizeWithTag(3, r100.mfail);
                String r103 = r100.mbegin_i18n_key;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(4, r103);
            L6:
                int r106 = r102 + r105;
                String r107 = r100.msuccess_i18n_key;
                if (r107 == null) goto L9;
                int r108 = r101.encodedSizeWithTag(5, r107);
            L10:
                int r109 = r106 + r108;
                String r110 = r100.mfail_i18n_key;
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
                r102.encodeWithTag(r100, 1, r101.mbegin);
                r102.encodeWithTag(r100, 2, r101.msuccess);
                r102.encodeWithTag(r100, 3, r101.mfail);
                String r103 = r101.mbegin_i18n_key;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 4, r103);
            L5:
                String r104 = r101.msuccess_i18n_key;
                if (r104 == null) goto L8;
                r102.encodeWithTag(r100, 5, r104);
            L8:
                String r105 = r101.mfail_i18n_key;
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
            r100.mbegin = this.mbegin;
            r100.msuccess = this.msuccess;
            r100.mfail = this.mfail;
            r100.mbegin_i18n_key = this.mbegin_i18n_key;
            r100.msuccess_i18n_key = this.msuccess_i18n_key;
            r100.mfail_i18n_key = this.mfail_i18n_key;
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
            this.mbegin = r100;
            this.msuccess = r101;
            this.mfail = r102;
            this.mbegin_i18n_key = r103;
            this.msuccess_i18n_key = r104;
            this.mfail_i18n_key = r105;
        }
    }

    public static final class ButtonProperty extends com.squareup.wire.Message<ButtonProperty, Builder> {
        public static final ProtoAdapter<ButtonProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final Boolean DEFAULT_ACTIVE = null;
        public static final Boolean DEFAULT_DISABLE = null;
        public static final String DEFAULT_MODE = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final Boolean mactive;
        public final ButtonConfirmProperty mconfirm;
        public final Boolean mdisable;
        public final ButtonLoadingProperty mloading;
        public final String mmode;

        public static final class Builder extends com.squareup.wire.Message.Builder<ButtonProperty, Builder> {
            public String maction_id;
            public Boolean mactive;
            public ButtonConfirmProperty mconfirm;
            public Boolean mdisable;
            public ButtonLoadingProperty mloading;
            public String mmode;

            @Override // com.squareup.wire.Message.Builder
            public ButtonProperty build() {
                return new ButtonProperty(this.maction_id, this.mdisable, this.mactive, this.mconfirm, this.mloading, this.mmode, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.maction_id = r100;
                return this;
            }

            public Builder active(Boolean r100) {
                this.mactive = r100;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r100) {
                this.mconfirm = r100;
                return this;
            }

            public Builder disable(Boolean r100) {
                this.mdisable = r100;
                return this;
            }

            public Builder loading(ButtonLoadingProperty r100) {
                this.mloading = r100;
                return this;
            }

            public Builder mode(String r100) {
                this.mmode = r100;
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
                r101.maction_id = "";
                Boolean r102 = Boolean.FALSE;
                r101.mdisable = r102;
                r101.mactive = r102;
                r101.mmode = "";
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L13;
                switch(r104) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r101.mmode = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.mloading = ButtonLoadingProperty.ADAPTER.decode(r100);
                goto L3
            L9:
                r101.mconfirm = ButtonConfirmProperty.ADAPTER.decode(r100);
                goto L3
            L10:
                r101.mactive = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                r101.mdisable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.maction_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L13:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ButtonProperty r100) {
                String r101 = r100.maction_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.mdisable;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.mactive;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                ButtonConfirmProperty r110 = r100.mconfirm;
                if (r110 == null) goto L17;
                int r111 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                ButtonLoadingProperty r113 = r100.mloading;
                if (r113 == null) goto L21;
                int r114 = ButtonLoadingProperty.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.mmode;
                if (r116 == null) goto L26;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
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
            public /* bridge */ /* synthetic */ ButtonProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ButtonProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ButtonProperty r101) throws IOException {
                String r102 = r101.maction_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.mdisable;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.mactive;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                ButtonConfirmProperty r105 = r101.mconfirm;
                if (r105 == null) goto L14;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                ButtonLoadingProperty r106 = r101.mloading;
                if (r106 == null) goto L17;
                ButtonLoadingProperty.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                String r107 = r101.mmode;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
            L20:
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
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.maction_id = this.maction_id;
            r100.mdisable = this.mdisable;
            r100.mactive = this.mactive;
            r100.mconfirm = this.mconfirm;
            r100.mloading = this.mloading;
            r100.mmode = this.mmode;
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

        public ButtonProperty(String r100, Boolean r110, Boolean r111, ButtonConfirmProperty r112, ButtonLoadingProperty r113, String r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public ButtonProperty(String r100, Boolean r101, Boolean r102, ButtonConfirmProperty r103, ButtonLoadingProperty r104, String r105, ByteString r106) {
            super(ADAPTER, r106);
            this.maction_id = r100;
            this.mdisable = r101;
            this.mactive = r102;
            this.mconfirm = r103;
            this.mloading = r104;
            this.mmode = r105;
        }
    }

    public static final class CodeBlockProperty extends com.squareup.wire.Message<CodeBlockProperty, Builder> {
        public static final ProtoAdapter<CodeBlockProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final Language mlanguage;
        public final List<StyleRef> mstyle_refs;
        public final List<Style> mstyles;

        public static final class Builder extends com.squareup.wire.Message.Builder<CodeBlockProperty, Builder> {
            public String mcontent;
            public Language mlanguage;
            public List<StyleRef> mstyle_refs;
            public List<Style> mstyles;

            @Override // com.squareup.wire.Message.Builder
            public CodeBlockProperty build() {
                return new CodeBlockProperty(this.mlanguage, this.mcontent, this.mstyle_refs, this.mstyles, super.buildUnknownFields());
            }

            public Builder() {
                this.mstyle_refs = Internal.newMutableList();
                this.mstyles = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.mcontent = r100;
                return this;
            }

            public Builder language(Language r100) {
                this.mlanguage = r100;
                return this;
            }

            public Builder style_refs(List<StyleRef> r100) {
                Internal.checkElementsNotNull(r100);
                this.mstyle_refs = r100;
                return this;
            }

            public Builder styles(List<Style> r100) {
                Internal.checkElementsNotNull(r100);
                this.mstyles = r100;
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
                r101.mcontent = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.mlanguage = Language.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mcontent = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mstyle_refs.add(StyleRef.ADAPTER.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.mstyles.add(Style.ADAPTER.decode(r100));
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
                Language r101 = r100.mlanguage;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Language.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mcontent;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (((r103 + r102) + StyleRef.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.mstyle_refs)) + Style.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mstyles)) + r100.unknownFields().size();
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
                Language r102 = r101.mlanguage;
                if (r102 == null) goto L5;
                Language.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mcontent;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                StyleRef.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.mstyle_refs);
                Style.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mstyles);
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
            public static final String DEFAULT_VALUE = "";
            private static final long serialVersionUID = 0;
            public final String mname;
            public final StyleType mtype;
            public final String mvalue;

            public static final class Builder extends com.squareup.wire.Message.Builder<Style, Builder> {
                public String mname;
                public StyleType mtype;
                public String mvalue;

                @Override // com.squareup.wire.Message.Builder
                public Style build() {
                    return new Style(this.mtype, this.mname, this.mvalue, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder name(String r100) {
                    this.mname = r100;
                    return this;
                }

                public Builder type(StyleType r100) {
                    this.mtype = r100;
                    return this;
                }

                public Builder value(String r100) {
                    this.mvalue = r100;
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
                    r101.mname = "";
                    r101.mvalue = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L18;
                    if (r103 != 1) goto L8;
                    r101.mtype = StyleType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                L16:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.mname = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L11;
                    r101.mvalue = ProtoAdapter.STRING.decode(r100);
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
                    StyleType r101 = r100.mtype;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = StyleType.ADAPTER.encodedSizeWithTag(1, r101);
                L6:
                    String r104 = r100.mname;
                    if (r104 == null) goto L9;
                    int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    String r107 = r100.mvalue;
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
                    StyleType r102 = r101.mtype;
                    if (r102 == null) goto L5;
                    StyleType.ADAPTER.encodeWithTag(r100, 1, r102);
                L5:
                    String r103 = r101.mname;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                L8:
                    String r104 = r101.mvalue;
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
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.mtype = this.mtype;
                r100.mname = this.mname;
                r100.mvalue = this.mvalue;
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
                this.mtype = r100;
                this.mname = r101;
                this.mvalue = r102;
            }
        }

        public static final class StyleRef extends com.squareup.wire.Message<StyleRef, Builder> {
            public static final ProtoAdapter<StyleRef> ADAPTER = null;
            public static final Integer DEFAULT_LENGTH = null;
            public static final Integer DEFAULT_LOCATION = null;
            private static final long serialVersionUID = 0;
            public final Integer mlength;
            public final Integer mlocation;
            public final List<Integer> mstyle_ids;

            public static final class Builder extends com.squareup.wire.Message.Builder<StyleRef, Builder> {
                public Integer mlength;
                public Integer mlocation;
                public List<Integer> mstyle_ids;

                @Override // com.squareup.wire.Message.Builder
                public StyleRef build() {
                    return new StyleRef(this.mlocation, this.mlength, this.mstyle_ids, super.buildUnknownFields());
                }

                public Builder() {
                    this.mstyle_ids = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder length(Integer r100) {
                    this.mlength = r100;
                    return this;
                }

                public Builder location(Integer r100) {
                    this.mlocation = r100;
                    return this;
                }

                public Builder style_ids(List<Integer> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.mstyle_ids = r100;
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
                    r101.mlocation = 0;
                    r101.mlength = 0;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L15;
                    if (r103 != 1) goto L8;
                    r101.mlocation = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.mlength = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L11;
                    r101.mstyle_ids.add(ProtoAdapter.INT32.decode(r100));
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
                    Integer r101 = r100.mlocation;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
                L6:
                    Integer r104 = r100.mlength;
                    if (r104 == null) goto L10;
                    r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
                L10:
                    return ((r103 + r102) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(3, r100.mstyle_ids)) + r100.unknownFields().size();
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
                    Integer r102 = r101.mlocation;
                    if (r102 == null) goto L5;
                    ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
                L5:
                    Integer r103 = r101.mlength;
                    if (r103 == null) goto L8;
                    ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
                L8:
                    ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 3, r101.mstyle_ids);
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
                r100.mlocation = this.mlocation;
                r100.mlength = this.mlength;
                r100.mstyle_ids = Internal.copyOf("mstyle_ids", this.mstyle_ids);
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
                this.mlocation = r100;
                this.mlength = r101;
                this.mstyle_ids = Internal.immutableCopyOf("mstyle_ids", r102);
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
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mlanguage = this.mlanguage;
            r100.mcontent = this.mcontent;
            r100.mstyle_refs = Internal.copyOf("mstyle_refs", this.mstyle_refs);
            r100.mstyles = Internal.copyOf("mstyles", this.mstyles);
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
            this.mlanguage = r100;
            this.mcontent = r101;
            this.mstyle_refs = Internal.immutableCopyOf("mstyle_refs", r102);
            this.mstyles = Internal.immutableCopyOf("mstyles", r103);
        }
    }

    public static final class CodeBlockV2Property extends com.squareup.wire.Message<CodeBlockV2Property, Builder> {
        public static final ProtoAdapter<CodeBlockV2Property> ADAPTER = null;
        public static final Integer DEFAULT_VERSION = null;
        public static final Boolean DEFAULT_WORD_WRAP = null;
        private static final long serialVersionUID = 0;
        public final List<LineContent> mcontents;
        public final Language mlanguage;
        public final Integer mversion;
        public final Boolean mword_wrap;

        public static final class Builder extends com.squareup.wire.Message.Builder<CodeBlockV2Property, Builder> {
            public List<LineContent> mcontents;
            public Language mlanguage;
            public Integer mversion;
            public Boolean mword_wrap;

            @Override // com.squareup.wire.Message.Builder
            public CodeBlockV2Property build() {
                return new CodeBlockV2Property(this.mlanguage, this.mcontents, this.mword_wrap, this.mversion, super.buildUnknownFields());
            }

            public Builder() {
                this.mcontents = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder contents(List<LineContent> r100) {
                Internal.checkElementsNotNull(r100);
                this.mcontents = r100;
                return this;
            }

            public Builder language(Language r100) {
                this.mlanguage = r100;
                return this;
            }

            public Builder version(Integer r100) {
                this.mversion = r100;
                return this;
            }

            public Builder word_wrap(Boolean r100) {
                this.mword_wrap = r100;
                return this;
            }
        }

        public static final class Content extends com.squareup.wire.Message<Content, Builder> {
            public static final ProtoAdapter<Content> ADAPTER = null;
            public static final String DEFAULT_CONTENT = "";
            private static final long serialVersionUID = 0;
            public final String mcontent;
            public final Map<String, String> mstyle;
            public final ContentType mtype;

            public static final class Builder extends com.squareup.wire.Message.Builder<Content, Builder> {
                public String mcontent;
                public Map<String, String> mstyle;
                public ContentType mtype;

                @Override // com.squareup.wire.Message.Builder
                public Content build() {
                    return new Content(this.mcontent, this.mtype, this.mstyle, super.buildUnknownFields());
                }

                public Builder() {
                    this.mstyle = Internal.newMutableMap();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder content(String r100) {
                    this.mcontent = r100;
                    return this;
                }

                public Builder style(Map<String, String> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.mstyle = r100;
                    return this;
                }

                public Builder type(ContentType r100) {
                    this.mtype = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_Content extends ProtoAdapter<Content> {
                private final ProtoAdapter<Map<String, String>> mstyle;

                public ProtoAdapter_Content() {
                    super(FieldEncoding.LENGTH_DELIMITED, Content.class);
                    ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                    this.mstyle = ProtoAdapter.newMapAdapter(r100, r100);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Content decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.mcontent = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L18;
                    if (r103 != 1) goto L8;
                    r101.mcontent = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.mtype = ContentType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
                L15:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r103 != 3) goto L11;
                    r101.mstyle.putAll(this.mstyle.decode(r100));
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
                    String r101 = r100.mcontent;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    ContentType r104 = r100.mtype;
                    if (r104 == null) goto L10;
                    r102 = ContentType.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    return ((r103 + r102) + this.mstyle.encodedSizeWithTag(3, r100.mstyle)) + r100.unknownFields().size();
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
                    String r102 = r101.mcontent;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    ContentType r103 = r101.mtype;
                    if (r103 == null) goto L8;
                    ContentType.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    this.mstyle.encodeWithTag(r100, 3, r101.mstyle);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Content r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Content();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.mcontent = this.mcontent;
                r100.mtype = this.mtype;
                r100.mstyle = Internal.copyOf("mstyle", this.mstyle);
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
                this.mcontent = r100;
                this.mtype = r101;
                this.mstyle = Internal.immutableCopyOf("mstyle", r102);
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
            public final List<Content> mcontents;

            public static final class Builder extends com.squareup.wire.Message.Builder<LineContent, Builder> {
                public List<Content> mcontents;

                @Override // com.squareup.wire.Message.Builder
                public LineContent build() {
                    return new LineContent(this.mcontents, super.buildUnknownFields());
                }

                public Builder() {
                    this.mcontents = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder contents(List<Content> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.mcontents = r100;
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
                    r101.mcontents.add(Content.ADAPTER.decode(r100));
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
                    return Content.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mcontents) + r100.unknownFields().size();
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
                    Content.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mcontents);
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
                r100.mcontents = Internal.copyOf("mcontents", this.mcontents);
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
                this.mcontents = Internal.immutableCopyOf("mcontents", r100);
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
                r101.mword_wrap = Boolean.FALSE;
                r101.mversion = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.mlanguage = Language.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mcontents.add(LineContent.ADAPTER.decode(r100));
                goto L3
            L10:
                if (r103 != 4) goto L12;
                r101.mword_wrap = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                if (r103 != 5) goto L13;
                r101.mversion = ProtoAdapter.INT32.decode(r100);
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
                Language r101 = r100.mlanguage;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Language.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                int r104 = r103 + LineContent.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mcontents);
                Boolean r105 = r100.mword_wrap;
                if (r105 == null) goto L9;
                int r106 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r105);
            L10:
                int r107 = r104 + r106;
                Integer r108 = r100.mversion;
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
                Language r102 = r101.mlanguage;
                if (r102 == null) goto L5;
                Language.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                LineContent.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mcontents);
                Boolean r103 = r101.mword_wrap;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
            L8:
                Integer r104 = r101.mversion;
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
            DEFAULT_WORD_WRAP = Boolean.FALSE;
            DEFAULT_VERSION = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mlanguage = this.mlanguage;
            r100.mcontents = Internal.copyOf("mcontents", this.mcontents);
            r100.mword_wrap = this.mword_wrap;
            r100.mversion = this.mversion;
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
            this.mlanguage = r100;
            this.mcontents = Internal.immutableCopyOf("mcontents", r101);
            this.mword_wrap = r102;
            this.mversion = r103;
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
        public final Integer mwidth;

        public static final class Builder extends com.squareup.wire.Message.Builder<ColumnProperty, Builder> {
            public Integer mwidth;

            @Override // com.squareup.wire.Message.Builder
            public ColumnProperty build() {
                return new ColumnProperty(this.mwidth, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder width(Integer r100) {
                this.mwidth = r100;
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
                r101.mwidth = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mwidth = ProtoAdapter.INT32.decode(r100);
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
                Integer r101 = r100.mwidth;
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
                Integer r102 = r101.mwidth;
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
            r100.mwidth = this.mwidth;
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
            this.mwidth = r100;
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
        public static final String DEFAULT_INITIAL_DATE = "";
        public static final String DEFAULT_PLACE_HOLDER = "";
        public static final String DEFAULT_PLACE_HOLDER_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final ButtonConfirmProperty mconfirm;
        public final String minitial_date;
        public final String mplace_holder;
        public final String mplace_holder_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<DatePickerProperty, Builder> {
            public String maction_id;
            public ButtonConfirmProperty mconfirm;
            public String minitial_date;
            public String mplace_holder;
            public String mplace_holder_i18n_key;

            @Override // com.squareup.wire.Message.Builder
            public DatePickerProperty build() {
                return new DatePickerProperty(this.maction_id, this.mplace_holder, this.mplace_holder_i18n_key, this.minitial_date, this.mconfirm, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.maction_id = r100;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r100) {
                this.mconfirm = r100;
                return this;
            }

            public Builder initial_date(String r100) {
                this.minitial_date = r100;
                return this;
            }

            public Builder place_holder(String r100) {
                this.mplace_holder = r100;
                return this;
            }

            public Builder place_holder_i18n_key(String r100) {
                this.mplace_holder_i18n_key = r100;
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
                r101.maction_id = "";
                r101.mplace_holder = "";
                r101.mplace_holder_i18n_key = "";
                r101.minitial_date = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.maction_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mplace_holder = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mplace_holder_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.minitial_date = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.mconfirm = ButtonConfirmProperty.ADAPTER.decode(r100);
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
            public int encodedSize2(DatePickerProperty r100) {
                String r101 = r100.maction_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mplace_holder;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mplace_holder_i18n_key;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.minitial_date;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                ButtonConfirmProperty r113 = r100.mconfirm;
                if (r113 == null) goto L22;
                r102 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(5, r113);
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
            public /* bridge */ /* synthetic */ DatePickerProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DatePickerProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DatePickerProperty r101) throws IOException {
                String r102 = r101.maction_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mplace_holder;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mplace_holder_i18n_key;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.minitial_date;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                ButtonConfirmProperty r106 = r101.mconfirm;
                if (r106 == null) goto L17;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DatePickerProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DatePickerProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.maction_id = this.maction_id;
            r100.mplace_holder = this.mplace_holder;
            r100.mplace_holder_i18n_key = this.mplace_holder_i18n_key;
            r100.minitial_date = this.minitial_date;
            r100.mconfirm = this.mconfirm;
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

        public DatePickerProperty(String r100, String r101, String r110, String r111, ButtonConfirmProperty r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public DatePickerProperty(String r100, String r101, String r102, String r103, ButtonConfirmProperty r104, ByteString r105) {
            super(ADAPTER, r105);
            this.maction_id = r100;
            this.mplace_holder = r101;
            this.mplace_holder_i18n_key = r102;
            this.minitial_date = r103;
            this.mconfirm = r104;
        }
    }

    public static final class DatetimePickerProperty extends com.squareup.wire.Message<DatetimePickerProperty, Builder> {
        public static final ProtoAdapter<DatetimePickerProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_INITIAL_DATETIME = "";
        public static final String DEFAULT_PLACE_HOLDER = "";
        public static final String DEFAULT_PLACE_HOLDER_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final ButtonConfirmProperty mconfirm;
        public final String minitial_datetime;
        public final String mplace_holder;
        public final String mplace_holder_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<DatetimePickerProperty, Builder> {
            public String maction_id;
            public ButtonConfirmProperty mconfirm;
            public String minitial_datetime;
            public String mplace_holder;
            public String mplace_holder_i18n_key;

            @Override // com.squareup.wire.Message.Builder
            public DatetimePickerProperty build() {
                return new DatetimePickerProperty(this.maction_id, this.mplace_holder, this.mplace_holder_i18n_key, this.minitial_datetime, this.mconfirm, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.maction_id = r100;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r100) {
                this.mconfirm = r100;
                return this;
            }

            public Builder initial_datetime(String r100) {
                this.minitial_datetime = r100;
                return this;
            }

            public Builder place_holder(String r100) {
                this.mplace_holder = r100;
                return this;
            }

            public Builder place_holder_i18n_key(String r100) {
                this.mplace_holder_i18n_key = r100;
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
                r101.maction_id = "";
                r101.mplace_holder = "";
                r101.mplace_holder_i18n_key = "";
                r101.minitial_datetime = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.maction_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mplace_holder = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mplace_holder_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.minitial_datetime = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.mconfirm = ButtonConfirmProperty.ADAPTER.decode(r100);
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
            public int encodedSize2(DatetimePickerProperty r100) {
                String r101 = r100.maction_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mplace_holder;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mplace_holder_i18n_key;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.minitial_datetime;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                ButtonConfirmProperty r113 = r100.mconfirm;
                if (r113 == null) goto L22;
                r102 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(5, r113);
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
            public /* bridge */ /* synthetic */ DatetimePickerProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DatetimePickerProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DatetimePickerProperty r101) throws IOException {
                String r102 = r101.maction_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mplace_holder;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mplace_holder_i18n_key;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.minitial_datetime;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                ButtonConfirmProperty r106 = r101.mconfirm;
                if (r106 == null) goto L17;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DatetimePickerProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DatetimePickerProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.maction_id = this.maction_id;
            r100.mplace_holder = this.mplace_holder;
            r100.mplace_holder_i18n_key = this.mplace_holder_i18n_key;
            r100.minitial_datetime = this.minitial_datetime;
            r100.mconfirm = this.mconfirm;
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

        public DatetimePickerProperty(String r100, String r101, String r110, String r111, ButtonConfirmProperty r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public DatetimePickerProperty(String r100, String r101, String r102, String r103, ButtonConfirmProperty r104, ByteString r105) {
            super(ADAPTER, r105);
            this.maction_id = r100;
            this.mplace_holder = r101;
            this.mplace_holder_i18n_key = r102;
            this.minitial_datetime = r103;
            this.mconfirm = r104;
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
        public final String mkey;

        public static final class Builder extends com.squareup.wire.Message.Builder<EmotionProperty, Builder> {
            public String mkey;

            @Override // com.squareup.wire.Message.Builder
            public EmotionProperty build() {
                String r100 = this.mkey;
                if (r100 == null) goto L7;
                return new EmotionProperty(this.mkey, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "mkey"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder key(String r100) {
                this.mkey = r100;
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
                r101.mkey = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mkey = ProtoAdapter.STRING.decode(r100);
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
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mkey) + r100.unknownFields().size();
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
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mkey);
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
            r100.mkey = this.mkey;
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
            this.mkey = r100;
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

    public static final class ImageProperty extends com.squareup.wire.Message<ImageProperty, Builder> {
        public static final ProtoAdapter<ImageProperty> ADAPTER = null;
        public static final String DEFAULT_ALT = "";
        public static final String DEFAULT_ALT_I18N_KEY = "";
        public static final Integer DEFAULT_CUSTOM_WIDTH = null;
        public static final String DEFAULT_FS_UNIT = "";
        public static final Integer DEFAULT_HEIGHT = null;
        public static final Boolean DEFAULT_IMG_CAN_PREVIEW = null;
        public static final Boolean DEFAULT_IS_ORIGIN_SOURCE = null;
        public static final String DEFAULT_MIDDLE_KEY = "";
        public static final Integer DEFAULT_ORIGIN_HEIGHT = null;
        public static final String DEFAULT_ORIGIN_KEY = "";
        public static final Long DEFAULT_ORIGIN_SIZE = null;
        public static final Integer DEFAULT_ORIGIN_WIDTH = null;
        public static final Integer DEFAULT_SHOW_MODE = null;
        public static final String DEFAULT_THUMB_KEY = "";
        public static final String DEFAULT_TOKEN = "";
        public static final Integer DEFAULT_WIDTH = null;
        private static final long serialVersionUID = 0;
        public final String malt;
        public final String malt_i18n_key;
        public final Cipher mcipher;
        public final Crypto.Type mcipher_type;
        public final Image mcover;
        public final Integer mcustom_width;
        public final String mfs_unit;
        public final Integer mheight;
        public final ImageSetV2 mimage;
        public final Boolean mimg_can_preview;
        public final Boolean mis_origin_source;
        public final String mmiddle_key;
        public final Image mmiddle_mp4;
        public final Image mmiddle_webp;
        public final Integer morigin_height;
        public final String morigin_key;
        public final Long morigin_size;
        public final Integer morigin_width;
        public final Integer mshow_mode;
        public final String mthumb_key;
        public final Image mthumbnail_webp;
        public final String mtoken;
        public final List<String> murls;
        public final Integer mwidth;

        public static final class Builder extends com.squareup.wire.Message.Builder<ImageProperty, Builder> {
            public String malt;
            public String malt_i18n_key;
            public Cipher mcipher;
            public Crypto.Type mcipher_type;
            public Image mcover;
            public Integer mcustom_width;
            public String mfs_unit;
            public Integer mheight;
            public ImageSetV2 mimage;
            public Boolean mimg_can_preview;
            public Boolean mis_origin_source;
            public String mmiddle_key;
            public Image mmiddle_mp4;
            public Image mmiddle_webp;
            public Integer morigin_height;
            public String morigin_key;
            public Long morigin_size;
            public Integer morigin_width;
            public Integer mshow_mode;
            public String mthumb_key;
            public Image mthumbnail_webp;
            public String mtoken;
            public List<String> murls;
            public Integer mwidth;

            @Override // com.squareup.wire.Message.Builder
            public ImageProperty build() {
                return new ImageProperty(this.mtoken, this.malt, this.malt_i18n_key, this.mimg_can_preview, this.mcipher, this.mcipher_type, this.morigin_key, this.mfs_unit, this.murls, this.mmiddle_key, this.mthumb_key, this.morigin_width, this.morigin_height, this.mthumbnail_webp, this.mmiddle_webp, this.mmiddle_mp4, this.mcover, this.mimage, this.mcustom_width, this.mis_origin_source, this.morigin_size, this.mshow_mode, this.mwidth, this.mheight, super.buildUnknownFields());
            }

            public Builder() {
                this.murls = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder alt(String r100) {
                this.malt = r100;
                return this;
            }

            public Builder alt_i18n_key(String r100) {
                this.malt_i18n_key = r100;
                return this;
            }

            public Builder cipher(Cipher r100) {
                this.mcipher = r100;
                return this;
            }

            public Builder cipher_type(Crypto.Type r100) {
                this.mcipher_type = r100;
                return this;
            }

            public Builder cover(Image r100) {
                this.mcover = r100;
                return this;
            }

            public Builder custom_width(Integer r100) {
                this.mcustom_width = r100;
                return this;
            }

            public Builder fs_unit(String r100) {
                this.mfs_unit = r100;
                return this;
            }

            public Builder height(Integer r100) {
                this.mheight = r100;
                return this;
            }

            public Builder image(ImageSetV2 r100) {
                this.mimage = r100;
                return this;
            }

            public Builder img_can_preview(Boolean r100) {
                this.mimg_can_preview = r100;
                return this;
            }

            public Builder is_origin_source(Boolean r100) {
                this.mis_origin_source = r100;
                return this;
            }

            public Builder middle_key(String r100) {
                this.mmiddle_key = r100;
                return this;
            }

            public Builder middle_mp4(Image r100) {
                this.mmiddle_mp4 = r100;
                return this;
            }

            public Builder middle_webp(Image r100) {
                this.mmiddle_webp = r100;
                return this;
            }

            public Builder origin_height(Integer r100) {
                this.morigin_height = r100;
                return this;
            }

            public Builder origin_key(String r100) {
                this.morigin_key = r100;
                return this;
            }

            public Builder origin_size(Long r100) {
                this.morigin_size = r100;
                return this;
            }

            public Builder origin_width(Integer r100) {
                this.morigin_width = r100;
                return this;
            }

            public Builder show_mode(Integer r100) {
                this.mshow_mode = r100;
                return this;
            }

            public Builder thumb_key(String r100) {
                this.mthumb_key = r100;
                return this;
            }

            public Builder thumbnail_webp(Image r100) {
                this.mthumbnail_webp = r100;
                return this;
            }

            public Builder token(String r100) {
                this.mtoken = r100;
                return this;
            }

            public Builder urls(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.murls = r100;
                return this;
            }

            public Builder width(Integer r100) {
                this.mwidth = r100;
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
                r101.mtoken = "";
                r101.malt = "";
                r101.malt_i18n_key = "";
                Boolean r102 = Boolean.FALSE;
                r101.mimg_can_preview = r102;
                r101.morigin_key = "";
                r101.mfs_unit = "";
                r101.mmiddle_key = "";
                r101.mthumb_key = "";
                r101.morigin_width = 0;
                r101.morigin_height = 0;
                r101.mcustom_width = 0;
                r101.mis_origin_source = r102;
                r101.morigin_size = 0L;
                r101.mshow_mode = 0;
                r101.mwidth = 0;
                r101.mheight = 0;
                long r103 = r100.beginMessage();
            L3:
                int r104 = r100.nextTag();
                if (r104 == (-1)) goto L34;
                switch(r104) {
                    case 1: goto L33;
                    case 2: goto L32;
                    case 3: goto L31;
                    case 4: goto L30;
                    case 5: goto L29;
                    case 6: goto L28;
                    case 7: goto L27;
                    case 8: goto L26;
                    case 9: goto L25;
                    case 10: goto L24;
                    case 11: goto L23;
                    case 12: goto L22;
                    case 13: goto L21;
                    case 14: goto L20;
                    case 15: goto L19;
                    case 16: goto L18;
                    case 17: goto L17;
                    case 18: goto L16;
                    case 19: goto L36;
                    case 20: goto L11;
                    case 21: goto L10;
                    case 22: goto L9;
                    case 23: goto L8;
                    case 24: goto L7;
                    default: goto L6;
                };
            L36:
                r101.mcipher_type = Crypto.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.mheight = ProtoAdapter.UINT32.decode(r100);
                goto L3
            L8:
                r101.mwidth = ProtoAdapter.UINT32.decode(r100);
                goto L3
            L9:
                r101.mshow_mode = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                r101.morigin_size = ProtoAdapter.UINT64.decode(r100);
                goto L3
            L11:
                r101.mis_origin_source = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L16:
                r101.mcustom_width = ProtoAdapter.INT32.decode(r100);
                goto L3
            L17:
                r101.mimage = ImageSetV2.ADAPTER.decode(r100);
                goto L3
            L18:
                r101.mcover = Image.ADAPTER.decode(r100);
                goto L3
            L19:
                r101.mmiddle_mp4 = Image.ADAPTER.decode(r100);
                goto L3
            L20:
                r101.mmiddle_webp = Image.ADAPTER.decode(r100);
                goto L3
            L21:
                r101.mthumbnail_webp = Image.ADAPTER.decode(r100);
                goto L3
            L22:
                r101.mimg_can_preview = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L23:
                r101.malt_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L24:
                r101.malt = ProtoAdapter.STRING.decode(r100);
                goto L3
            L25:
                r101.mfs_unit = ProtoAdapter.STRING.decode(r100);
                goto L3
            L26:
                r101.morigin_height = ProtoAdapter.INT32.decode(r100);
                goto L3
            L27:
                r101.morigin_width = ProtoAdapter.INT32.decode(r100);
                goto L3
            L28:
                r101.mthumb_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L29:
                r101.mmiddle_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L30:
                r101.morigin_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L31:
                r101.mcipher = Cipher.ADAPTER.decode(r100);
                goto L3
            L32:
                r101.mtoken = ProtoAdapter.STRING.decode(r100);
                goto L3
            L33:
                r101.murls.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L6:
                FieldEncoding r105 = r100.peekFieldEncoding();
                r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
                goto L3
            L34:
                r100.endMessage(r103);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ImageProperty r100) {
                String r101 = r100.mtoken;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r101);
            L6:
                String r104 = r100.malt;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(10, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.malt_i18n_key;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(11, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.mimg_can_preview;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r110);
            L18:
                int r112 = r109 + r111;
                Cipher r113 = r100.mcipher;
                if (r113 == null) goto L21;
                int r114 = Cipher.ADAPTER.encodedSizeWithTag(3, r113);
            L22:
                int r115 = r112 + r114;
                Crypto.Type r116 = r100.mcipher_type;
                if (r116 == null) goto L25;
                int r117 = Crypto.Type.ADAPTER.encodedSizeWithTag(19, r116);
            L26:
                int r118 = r115 + r117;
                String r119 = r100.morigin_key;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.STRING.encodedSizeWithTag(4, r119);
            L30:
                int r121 = r118 + r120;
                String r122 = r100.mfs_unit;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.STRING.encodedSizeWithTag(9, r122);
            L34:
                int r124 = r121 + r123;
                ProtoAdapter<String> r125 = ProtoAdapter.STRING;
                int r126 = r124 + r125.asRepeated().encodedSizeWithTag(1, r100.murls);
                String r127 = r100.mmiddle_key;
                if (r127 == null) goto L37;
                int r128 = r125.encodedSizeWithTag(5, r127);
            L38:
                int r129 = r126 + r128;
                String r130 = r100.mthumb_key;
                if (r130 == null) goto L41;
                int r131 = r125.encodedSizeWithTag(6, r130);
            L42:
                int r132 = r129 + r131;
                Integer r133 = r100.morigin_width;
                if (r133 == null) goto L45;
                int r134 = ProtoAdapter.INT32.encodedSizeWithTag(7, r133);
            L46:
                int r135 = r132 + r134;
                Integer r136 = r100.morigin_height;
                if (r136 == null) goto L49;
                int r137 = ProtoAdapter.INT32.encodedSizeWithTag(8, r136);
            L50:
                int r138 = r135 + r137;
                Image r139 = r100.mthumbnail_webp;
                if (r139 == null) goto L53;
                int r140 = Image.ADAPTER.encodedSizeWithTag(13, r139);
            L54:
                int r141 = r138 + r140;
                Image r142 = r100.mmiddle_webp;
                if (r142 == null) goto L57;
                int r143 = Image.ADAPTER.encodedSizeWithTag(14, r142);
            L58:
                int r144 = r141 + r143;
                Image r145 = r100.mmiddle_mp4;
                if (r145 == null) goto L61;
                int r146 = Image.ADAPTER.encodedSizeWithTag(15, r145);
            L62:
                int r147 = r144 + r146;
                Image r148 = r100.mcover;
                if (r148 == null) goto L65;
                int r149 = Image.ADAPTER.encodedSizeWithTag(16, r148);
            L66:
                int r150 = r147 + r149;
                ImageSetV2 r151 = r100.mimage;
                if (r151 == null) goto L69;
                int r152 = ImageSetV2.ADAPTER.encodedSizeWithTag(17, r151);
            L70:
                int r153 = r150 + r152;
                Integer r154 = r100.mcustom_width;
                if (r154 == null) goto L73;
                int r155 = ProtoAdapter.INT32.encodedSizeWithTag(18, r154);
            L74:
                int r156 = r153 + r155;
                Boolean r157 = r100.mis_origin_source;
                if (r157 == null) goto L77;
                int r158 = ProtoAdapter.BOOL.encodedSizeWithTag(20, r157);
            L78:
                int r159 = r156 + r158;
                Long r160 = r100.morigin_size;
                if (r160 == null) goto L81;
                int r161 = ProtoAdapter.UINT64.encodedSizeWithTag(21, r160);
            L82:
                int r162 = r159 + r161;
                Integer r163 = r100.mshow_mode;
                if (r163 == null) goto L85;
                int r164 = ProtoAdapter.INT32.encodedSizeWithTag(22, r163);
            L86:
                int r165 = r162 + r164;
                Integer r166 = r100.mwidth;
                if (r166 == null) goto L89;
                int r167 = ProtoAdapter.UINT32.encodedSizeWithTag(23, r166);
            L90:
                int r168 = r165 + r167;
                Integer r169 = r100.mheight;
                if (r169 == null) goto L94;
                r102 = ProtoAdapter.UINT32.encodedSizeWithTag(24, r169);
            L94:
                return (r168 + r102) + r100.unknownFields().size();
            L89:
                r167 = 0;
                goto L90
            L85:
                r164 = 0;
                goto L86
            L81:
                r161 = 0;
                goto L82
            L77:
                r158 = 0;
                goto L78
            L73:
                r155 = 0;
                goto L74
            L69:
                r152 = 0;
                goto L70
            L65:
                r149 = 0;
                goto L66
            L61:
                r146 = 0;
                goto L62
            L57:
                r143 = 0;
                goto L58
            L53:
                r140 = 0;
                goto L54
            L49:
                r137 = 0;
                goto L50
            L45:
                r134 = 0;
                goto L46
            L41:
                r131 = 0;
                goto L42
            L37:
                r128 = 0;
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
            public /* bridge */ /* synthetic */ ImageProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ImageProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ImageProperty r101) throws IOException {
                String r102 = r101.mtoken;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
            L5:
                String r103 = r101.malt;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 10, r103);
            L8:
                String r104 = r101.malt_i18n_key;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 11, r104);
            L11:
                Boolean r105 = r101.mimg_can_preview;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 12, r105);
            L14:
                Cipher r106 = r101.mcipher;
                if (r106 == null) goto L17;
                Cipher.ADAPTER.encodeWithTag(r100, 3, r106);
            L17:
                Crypto.Type r107 = r101.mcipher_type;
                if (r107 == null) goto L20;
                Crypto.Type.ADAPTER.encodeWithTag(r100, 19, r107);
            L20:
                String r108 = r101.morigin_key;
                if (r108 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r108);
            L23:
                String r109 = r101.mfs_unit;
                if (r109 == null) goto L26;
                ProtoAdapter.STRING.encodeWithTag(r100, 9, r109);
            L26:
                ProtoAdapter<String> r110 = ProtoAdapter.STRING;
                r110.asRepeated().encodeWithTag(r100, 1, r101.murls);
                String r111 = r101.mmiddle_key;
                if (r111 == null) goto L29;
                r110.encodeWithTag(r100, 5, r111);
            L29:
                String r112 = r101.mthumb_key;
                if (r112 == null) goto L32;
                r110.encodeWithTag(r100, 6, r112);
            L32:
                Integer r113 = r101.morigin_width;
                if (r113 == null) goto L35;
                ProtoAdapter.INT32.encodeWithTag(r100, 7, r113);
            L35:
                Integer r114 = r101.morigin_height;
                if (r114 == null) goto L38;
                ProtoAdapter.INT32.encodeWithTag(r100, 8, r114);
            L38:
                Image r115 = r101.mthumbnail_webp;
                if (r115 == null) goto L41;
                Image.ADAPTER.encodeWithTag(r100, 13, r115);
            L41:
                Image r116 = r101.mmiddle_webp;
                if (r116 == null) goto L44;
                Image.ADAPTER.encodeWithTag(r100, 14, r116);
            L44:
                Image r117 = r101.mmiddle_mp4;
                if (r117 == null) goto L47;
                Image.ADAPTER.encodeWithTag(r100, 15, r117);
            L47:
                Image r118 = r101.mcover;
                if (r118 == null) goto L50;
                Image.ADAPTER.encodeWithTag(r100, 16, r118);
            L50:
                ImageSetV2 r119 = r101.mimage;
                if (r119 == null) goto L53;
                ImageSetV2.ADAPTER.encodeWithTag(r100, 17, r119);
            L53:
                Integer r120 = r101.mcustom_width;
                if (r120 == null) goto L56;
                ProtoAdapter.INT32.encodeWithTag(r100, 18, r120);
            L56:
                Boolean r121 = r101.mis_origin_source;
                if (r121 == null) goto L59;
                ProtoAdapter.BOOL.encodeWithTag(r100, 20, r121);
            L59:
                Long r122 = r101.morigin_size;
                if (r122 == null) goto L62;
                ProtoAdapter.UINT64.encodeWithTag(r100, 21, r122);
            L62:
                Integer r123 = r101.mshow_mode;
                if (r123 == null) goto L65;
                ProtoAdapter.INT32.encodeWithTag(r100, 22, r123);
            L65:
                Integer r124 = r101.mwidth;
                if (r124 == null) goto L68;
                ProtoAdapter.UINT32.encodeWithTag(r100, 23, r124);
            L68:
                Integer r125 = r101.mheight;
                if (r125 == null) goto L71;
                ProtoAdapter.UINT32.encodeWithTag(r100, 24, r125);
            L71:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ImageProperty();
            Boolean r100 = Boolean.FALSE;
            DEFAULT_IMG_CAN_PREVIEW = r100;
            DEFAULT_ORIGIN_WIDTH = 0;
            DEFAULT_ORIGIN_HEIGHT = 0;
            DEFAULT_CUSTOM_WIDTH = 0;
            DEFAULT_IS_ORIGIN_SOURCE = r100;
            DEFAULT_ORIGIN_SIZE = 0L;
            DEFAULT_SHOW_MODE = 0;
            DEFAULT_WIDTH = 0;
            DEFAULT_HEIGHT = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mtoken = this.mtoken;
            r100.malt = this.malt;
            r100.malt_i18n_key = this.malt_i18n_key;
            r100.mimg_can_preview = this.mimg_can_preview;
            r100.mcipher = this.mcipher;
            r100.mcipher_type = this.mcipher_type;
            r100.morigin_key = this.morigin_key;
            r100.mfs_unit = this.mfs_unit;
            r100.murls = Internal.copyOf("murls", this.murls);
            r100.mmiddle_key = this.mmiddle_key;
            r100.mthumb_key = this.mthumb_key;
            r100.morigin_width = this.morigin_width;
            r100.morigin_height = this.morigin_height;
            r100.mthumbnail_webp = this.mthumbnail_webp;
            r100.mmiddle_webp = this.mmiddle_webp;
            r100.mmiddle_mp4 = this.mmiddle_mp4;
            r100.mcover = this.mcover;
            r100.mimage = this.mimage;
            r100.mcustom_width = this.mcustom_width;
            r100.mis_origin_source = this.mis_origin_source;
            r100.morigin_size = this.morigin_size;
            r100.mshow_mode = this.mshow_mode;
            r100.mwidth = this.mwidth;
            r100.mheight = this.mheight;
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

        public ImageProperty(String r210, String r211, String r212, Boolean r310, Cipher r311, Crypto.Type r312, String r313, String r314, List<String> r315, String r316, String r317, Integer r318, Integer r319, Image r410, Image r411, Image r412, Image r413, ImageSetV2 r414, Integer r415, Boolean r416, Long r417, Integer r418, Integer r419, Integer r510) {
            this(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, ByteString.EMPTY);
        }

        public ImageProperty(String r100, String r101, String r102, Boolean r103, Cipher r104, Crypto.Type r105, String r110, String r111, List<String> r112, String r113, String r114, Integer r115, Integer r116, Image r117, Image r118, Image r119, Image r210, ImageSetV2 r211, Integer r212, Boolean r213, Long r214, Integer r215, Integer r216, Integer r217, ByteString r218) {
            super(ADAPTER, r218);
            this.mtoken = r100;
            this.malt = r101;
            this.malt_i18n_key = r102;
            this.mimg_can_preview = r103;
            this.mcipher = r104;
            this.mcipher_type = r105;
            this.morigin_key = r110;
            this.mfs_unit = r111;
            this.murls = Internal.immutableCopyOf("murls", r112);
            this.mmiddle_key = r113;
            this.mthumb_key = r114;
            this.morigin_width = r115;
            this.morigin_height = r116;
            this.mthumbnail_webp = r117;
            this.mmiddle_webp = r118;
            this.mmiddle_mp4 = r119;
            this.mcover = r210;
            this.mimage = r211;
            this.mcustom_width = r212;
            this.mis_origin_source = r213;
            this.morigin_size = r214;
            this.mshow_mode = r215;
            this.mwidth = r216;
            this.mheight = r217;
        }
    }

    public static final class ItalicProperty extends com.squareup.wire.Message<ItalicProperty, Builder> {
        public static final ProtoAdapter<ItalicProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final String mi18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<ItalicProperty, Builder> {
            public String mcontent;
            public String mi18n_key;

            @Override // com.squareup.wire.Message.Builder
            public ItalicProperty build() {
                String r100 = this.mcontent;
                if (r100 == null) goto L7;
                return new ItalicProperty(this.mcontent, this.mi18n_key, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "mcontent"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.mcontent = r100;
                return this;
            }

            public Builder i18n_key(String r100) {
                this.mi18n_key = r100;
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
                r101.mcontent = "";
                r101.mi18n_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mcontent = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mi18n_key = ProtoAdapter.STRING.decode(r100);
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
                int r102 = r101.encodedSizeWithTag(1, r100.mcontent);
                String r103 = r100.mi18n_key;
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
                r102.encodeWithTag(r100, 1, r101.mcontent);
                String r103 = r101.mi18n_key;
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
            r100.mcontent = this.mcontent;
            r100.mi18n_key = this.mi18n_key;
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
            this.mcontent = r100;
            this.mi18n_key = r101;
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
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final String mandroid_url;
        public final String mios_url;
        public final String mpc_url;
        public final LinkScene mscene;
        public final SpecialURL mspecial_url;
        public final String murl;

        public static final class Builder extends com.squareup.wire.Message.Builder<LinkProperty, Builder> {
            public String mandroid_url;
            public String mios_url;
            public String mpc_url;
            public LinkScene mscene;
            public SpecialURL mspecial_url;
            public String murl;

            @Override // com.squareup.wire.Message.Builder
            public LinkProperty build() {
                return new LinkProperty(this.murl, this.mios_url, this.mandroid_url, this.mpc_url, this.mspecial_url, this.mscene, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder android_url(String r100) {
                this.mandroid_url = r100;
                return this;
            }

            public Builder ios_url(String r100) {
                this.mios_url = r100;
                return this;
            }

            public Builder pc_url(String r100) {
                this.mpc_url = r100;
                return this;
            }

            public Builder scene(LinkScene r100) {
                this.mscene = r100;
                return this;
            }

            public Builder special_url(SpecialURL r100) {
                this.mspecial_url = r100;
                return this;
            }

            public Builder url(String r100) {
                this.murl = r100;
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
                r101.murl = "";
                r101.mios_url = "";
                r101.mandroid_url = "";
                r101.mpc_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L19;
                switch(r103) {
                    case 1: goto L18;
                    case 2: goto L17;
                    case 3: goto L16;
                    case 4: goto L15;
                    case 5: goto L21;
                    case 6: goto L23;
                    default: goto L6;
                };
            L21:
                r101.mspecial_url = SpecialURL.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L23:
                r101.mscene = LinkScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L15:
                r101.mpc_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L16:
                r101.mandroid_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L17:
                r101.mios_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L18:
                r101.murl = ProtoAdapter.STRING.decode(r100);
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
                String r101 = r100.murl;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mios_url;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mandroid_url;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.mpc_url;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                SpecialURL r113 = r100.mspecial_url;
                if (r113 == null) goto L21;
                int r114 = SpecialURL.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                LinkScene r116 = r100.mscene;
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
                String r102 = r101.murl;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mios_url;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mandroid_url;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.mpc_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                SpecialURL r106 = r101.mspecial_url;
                if (r106 == null) goto L17;
                SpecialURL.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                LinkScene r107 = r101.mscene;
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
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.murl = this.murl;
            r100.mios_url = this.mios_url;
            r100.mandroid_url = this.mandroid_url;
            r100.mpc_url = this.mpc_url;
            r100.mspecial_url = this.mspecial_url;
            r100.mscene = this.mscene;
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
            this.murl = r100;
            this.mios_url = r101;
            this.mandroid_url = r102;
            this.mpc_url = r103;
            this.mspecial_url = r104;
            this.mscene = r105;
        }
    }

    public static final class MarkdownProperty extends com.squareup.wire.Message<MarkdownProperty, Builder> {
        public static final ProtoAdapter<MarkdownProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final Boolean DEFAULT_IS_AT_ALL = null;
        private static final long serialVersionUID = 0;
        public final List<Long> mat_user_ids;
        public final String mcontent;
        public final Map<String, ImageSetV2> mimages;
        public final Boolean mis_at_all;

        public static final class Builder extends com.squareup.wire.Message.Builder<MarkdownProperty, Builder> {
            public List<Long> mat_user_ids;
            public String mcontent;
            public Map<String, ImageSetV2> mimages;
            public Boolean mis_at_all;

            @Override // com.squareup.wire.Message.Builder
            public MarkdownProperty build() {
                return new MarkdownProperty(this.mcontent, this.mimages, this.mat_user_ids, this.mis_at_all, super.buildUnknownFields());
            }

            public Builder() {
                this.mimages = Internal.newMutableMap();
                this.mat_user_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder at_user_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.mat_user_ids = r100;
                return this;
            }

            public Builder content(String r100) {
                this.mcontent = r100;
                return this;
            }

            public Builder images(Map<String, ImageSetV2> r100) {
                Internal.checkElementsNotNull(r100);
                this.mimages = r100;
                return this;
            }

            public Builder is_at_all(Boolean r100) {
                this.mis_at_all = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_MarkdownProperty extends ProtoAdapter<MarkdownProperty> {
            private final ProtoAdapter<Map<String, ImageSetV2>> mimages;

            public ProtoAdapter_MarkdownProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, MarkdownProperty.class);
                this.mimages = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ImageSetV2.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MarkdownProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mcontent = "";
                r101.mis_at_all = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mcontent = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mimages.putAll(this.mimages.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mat_user_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.mis_at_all = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(MarkdownProperty r100) {
                String r101 = r100.mcontent;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                int r104 = (r103 + this.mimages.encodedSizeWithTag(2, r100.mimages)) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(3, r100.mat_user_ids);
                Boolean r105 = r100.mis_at_all;
                if (r105 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r105);
            L10:
                return (r104 + r102) + r100.unknownFields().size();
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
                String r102 = r101.mcontent;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                this.mimages.encodeWithTag(r100, 2, r101.mimages);
                ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 3, r101.mat_user_ids);
                Boolean r103 = r101.mis_at_all;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
            L8:
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
            r100.mcontent = this.mcontent;
            r100.mimages = Internal.copyOf("mimages", this.mimages);
            r100.mat_user_ids = Internal.copyOf("mat_user_ids", this.mat_user_ids);
            r100.mis_at_all = this.mis_at_all;
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

        public MarkdownProperty(String r100, Map<String, ImageSetV2> r101, List<Long> r102, Boolean r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public MarkdownProperty(String r100, Map<String, ImageSetV2> r101, List<Long> r102, Boolean r103, ByteString r104) {
            super(ADAPTER, r104);
            this.mcontent = r100;
            this.mimages = Internal.immutableCopyOf("mimages", r101);
            this.mat_user_ids = Internal.immutableCopyOf("mat_user_ids", r102);
            this.mis_at_all = r103;
        }
    }

    public static final class MediaProperty extends com.squareup.wire.Message<MediaProperty, Builder> {
        public static final ProtoAdapter<MediaProperty> ADAPTER = null;
        public static final ByteString DEFAULT_CRYPTO = null;
        public static final String DEFAULT_CRYPTO_TOKEN = "";
        public static final Integer DEFAULT_DURATION = null;
        public static final String DEFAULT_FS_UNIT = "";
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_MIME = "";
        public static final String DEFAULT_NAME = "";
        public static final Long DEFAULT_SIZE = null;
        private static final long serialVersionUID = 0;
        public final ByteString mcrypto;
        public final String mcrypto_token;
        public final Integer mduration;
        public final String mfs_unit;
        public final ImageSet mimage;
        public final String mkey;
        public final String mmime;
        public final String mname;
        public final Long msize;
        public final Source msource;

        public static final class Builder extends com.squareup.wire.Message.Builder<MediaProperty, Builder> {
            public ByteString mcrypto;
            public String mcrypto_token;
            public Integer mduration;
            public String mfs_unit;
            public ImageSet mimage;
            public String mkey;
            public String mmime;
            public String mname;
            public Long msize;
            public Source msource;

            @Override // com.squareup.wire.Message.Builder
            public MediaProperty build() {
                return new MediaProperty(this.mkey, this.mname, this.msize, this.mmime, this.msource, this.mimage, this.mduration, this.mfs_unit, this.mcrypto_token, this.mcrypto, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder crypto(ByteString r100) {
                this.mcrypto = r100;
                return this;
            }

            public Builder crypto_token(String r100) {
                this.mcrypto_token = r100;
                return this;
            }

            public Builder duration(Integer r100) {
                this.mduration = r100;
                return this;
            }

            public Builder fs_unit(String r100) {
                this.mfs_unit = r100;
                return this;
            }

            public Builder image(ImageSet r100) {
                this.mimage = r100;
                return this;
            }

            public Builder key(String r100) {
                this.mkey = r100;
                return this;
            }

            public Builder mime(String r100) {
                this.mmime = r100;
                return this;
            }

            public Builder name(String r100) {
                this.mname = r100;
                return this;
            }

            public Builder size(Long r100) {
                this.msize = r100;
                return this;
            }

            public Builder source(Source r100) {
                this.msource = r100;
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
                r101.mkey = "";
                r101.mname = "";
                r101.msize = 0L;
                r101.mmime = "";
                r101.mduration = 0;
                r101.mfs_unit = "";
                r101.mcrypto_token = "";
                r101.mcrypto = ByteString.EMPTY;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L20;
                switch(r103) {
                    case 1: goto L19;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L22;
                    case 6: goto L11;
                    case 7: goto L10;
                    case 8: goto L9;
                    case 9: goto L8;
                    case 10: goto L7;
                    default: goto L6;
                };
            L22:
                r101.msource = Source.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.mcrypto = ProtoAdapter.BYTES.decode(r100);
                goto L3
            L8:
                r101.mcrypto_token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L9:
                r101.mfs_unit = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.mduration = ProtoAdapter.INT32.decode(r100);
                goto L3
            L11:
                r101.mimage = ImageSet.ADAPTER.decode(r100);
                goto L3
            L16:
                r101.mmime = ProtoAdapter.STRING.decode(r100);
                goto L3
            L17:
                r101.msize = ProtoAdapter.INT64.decode(r100);
                goto L3
            L18:
                r101.mname = ProtoAdapter.STRING.decode(r100);
                goto L3
            L19:
                r101.mkey = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(MediaProperty r100) {
                String r101 = r100.mkey;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mname;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.msize;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.mmime;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Source r113 = r100.msource;
                if (r113 == null) goto L21;
                int r114 = Source.ADAPTER.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                ImageSet r116 = r100.mimage;
                if (r116 == null) goto L25;
                int r117 = ImageSet.ADAPTER.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                Integer r119 = r100.mduration;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                String r122 = r100.mfs_unit;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                String r125 = r100.mcrypto_token;
                if (r125 == null) goto L37;
                int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
            L38:
                int r127 = r124 + r126;
                ByteString r128 = r100.mcrypto;
                if (r128 == null) goto L42;
                r102 = ProtoAdapter.BYTES.encodedSizeWithTag(10, r128);
            L42:
                return (r127 + r102) + r100.unknownFields().size();
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
                String r102 = r101.mkey;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mname;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.msize;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.mmime;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                Source r106 = r101.msource;
                if (r106 == null) goto L17;
                Source.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                ImageSet r107 = r101.mimage;
                if (r107 == null) goto L20;
                ImageSet.ADAPTER.encodeWithTag(r100, 6, r107);
            L20:
                Integer r108 = r101.mduration;
                if (r108 == null) goto L23;
                ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
            L23:
                String r109 = r101.mfs_unit;
                if (r109 == null) goto L26;
                ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
            L26:
                String r110 = r101.mcrypto_token;
                if (r110 == null) goto L29;
                ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
            L29:
                ByteString r111 = r101.mcrypto;
                if (r111 == null) goto L32;
                ProtoAdapter.BYTES.encodeWithTag(r100, 10, r111);
            L32:
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
            DEFAULT_DURATION = 0;
            DEFAULT_CRYPTO = ByteString.EMPTY;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mkey = this.mkey;
            r100.mname = this.mname;
            r100.msize = this.msize;
            r100.mmime = this.mmime;
            r100.msource = this.msource;
            r100.mimage = this.mimage;
            r100.mduration = this.mduration;
            r100.mfs_unit = this.mfs_unit;
            r100.mcrypto_token = this.mcrypto_token;
            r100.mcrypto = this.mcrypto;
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

        public MediaProperty(String r110, String r111, Long r112, String r113, Source r114, ImageSet r115, Integer r116, String r210, String r211, ByteString r212) {
            this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
        }

        public MediaProperty(String r100, String r101, Long r102, String r103, Source r104, ImageSet r105, Integer r106, String r107, String r110, ByteString r111, ByteString r112) {
            super(ADAPTER, r112);
            this.mkey = r100;
            this.mname = r101;
            this.msize = r102;
            this.mmime = r103;
            this.msource = r104;
            this.mimage = r105;
            this.mduration = r106;
            this.mfs_unit = r107;
            this.mcrypto_token = r110;
            this.mcrypto = r111;
        }
    }

    public static final class MentionItem extends com.squareup.wire.Message<MentionItem, Builder> {
        public static final ProtoAdapter<MentionItem> ADAPTER = null;
        public static final String DEFAULT_ID = "";
        private static final long serialVersionUID = 0;
        public final String mid;
        public final MentionType mtype;

        public static final class Builder extends com.squareup.wire.Message.Builder<MentionItem, Builder> {
            public String mid;
            public MentionType mtype;

            @Override // com.squareup.wire.Message.Builder
            public MentionItem build() {
                String r100 = this.mid;
                if (r100 == null) goto L9;
                if (this.mtype == null) goto L9;
                return new MentionItem(this.mid, this.mtype, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "mid", this.mtype, GearStrategyConsts.EV_MEDIA_TYPE});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder id(String r100) {
                this.mid = r100;
                return this;
            }

            public Builder type(MentionType r100) {
                this.mtype = r100;
                return this;
            }
        }

        public static final enum MentionType extends Enum<MentionType> implements WireEnum {
            private static final /* synthetic */ MentionType[] $VALUES = null;
            public static final ProtoAdapter<MentionType> ADAPTER = null;
            public static final MentionType HASH_TAG = null;
            public static final MentionType MOMENTS_HASHTAG = null;
            public static final MentionType UNKNOWN_MENTION_TYPE = null;
            private final int value;

            static {
                MentionType r100 = new MentionType("UNKNOWN_MENTION_TYPE", 0, 0);
                UNKNOWN_MENTION_TYPE = r100;
                MentionType r101 = new MentionType("HASH_TAG", 1, 1);
                HASH_TAG = r101;
                MentionType r102 = new MentionType("MOMENTS_HASHTAG", 2, 2);
                MOMENTS_HASHTAG = r102;
                $VALUES = new MentionType[]{r100, r101, r102};
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
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return MOMENTS_HASHTAG;
            L12:
                return HASH_TAG;
            L14:
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
                r101.mid = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mid = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mtype = MentionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
                return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mid) + MentionType.ADAPTER.encodedSizeWithTag(2, r100.mtype)) + r100.unknownFields().size();
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
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mid);
                MentionType.ADAPTER.encodeWithTag(r100, 2, r101.mtype);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MentionItem r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MentionItem();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mid = this.mid;
            r100.mtype = this.mtype;
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
            this.mid = r100;
            this.mtype = r101;
        }
    }

    public static final class MentionProperty extends com.squareup.wire.Message<MentionProperty, Builder> {
        public static final ProtoAdapter<MentionProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final MentionItem mitem;

        public static final class Builder extends com.squareup.wire.Message.Builder<MentionProperty, Builder> {
            public String mcontent;
            public MentionItem mitem;

            @Override // com.squareup.wire.Message.Builder
            public MentionProperty build() {
                MentionItem r100 = this.mitem;
                if (r100 == null) goto L9;
                if (this.mcontent == null) goto L9;
                return new MentionProperty(this.mitem, this.mcontent, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "mitem", this.mcontent, "mcontent"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.mcontent = r100;
                return this;
            }

            public Builder item(MentionItem r100) {
                this.mitem = r100;
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
                r101.mcontent = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mitem = MentionItem.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mcontent = ProtoAdapter.STRING.decode(r100);
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
                return (MentionItem.ADAPTER.encodedSizeWithTag(1, r100.mitem) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.mcontent)) + r100.unknownFields().size();
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
                MentionItem.ADAPTER.encodeWithTag(r100, 1, r101.mitem);
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.mcontent);
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
            r100.mitem = this.mitem;
            r100.mcontent = this.mcontent;
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
            this.mitem = r100;
            this.mcontent = r101;
        }
    }

    public static final class MenuOption extends com.squareup.wire.Message<MenuOption, Builder> {
        public static final ProtoAdapter<MenuOption> ADAPTER = null;
        public static final String DEFAULT_OPTION_ACTION_ID = "";
        public static final String DEFAULT_TEXT = "";
        public static final String DEFAULT_TEXT_I18N_KEY = "";
        public static final String DEFAULT_VALUE = "";
        private static final long serialVersionUID = 0;
        public final String moption_action_id;
        public final String mtext;
        public final String mtext_i18n_key;
        public final CardAction.Url murl;
        public final String mvalue;

        public static final class Builder extends com.squareup.wire.Message.Builder<MenuOption, Builder> {
            public String moption_action_id;
            public String mtext;
            public String mtext_i18n_key;
            public CardAction.Url murl;
            public String mvalue;

            @Override // com.squareup.wire.Message.Builder
            public MenuOption build() {
                return new MenuOption(this.mtext, this.mtext_i18n_key, this.mvalue, this.murl, this.moption_action_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder option_action_id(String r100) {
                this.moption_action_id = r100;
                return this;
            }

            public Builder text(String r100) {
                this.mtext = r100;
                return this;
            }

            public Builder text_i18n_key(String r100) {
                this.mtext_i18n_key = r100;
                return this;
            }

            public Builder url(CardAction.Url r100) {
                this.murl = r100;
                return this;
            }

            public Builder value(String r100) {
                this.mvalue = r100;
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
                r101.mtext = "";
                r101.mtext_i18n_key = "";
                r101.mvalue = "";
                r101.moption_action_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.mtext = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mtext_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mvalue = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.murl = CardAction.Url.ADAPTER.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.moption_action_id = ProtoAdapter.STRING.decode(r100);
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
                String r101 = r100.mtext;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mtext_i18n_key;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mvalue;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                CardAction.Url r110 = r100.murl;
                if (r110 == null) goto L17;
                int r111 = CardAction.Url.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.moption_action_id;
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
                String r102 = r101.mtext;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mtext_i18n_key;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mvalue;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                CardAction.Url r105 = r101.murl;
                if (r105 == null) goto L14;
                CardAction.Url.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.moption_action_id;
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
            r100.mtext = this.mtext;
            r100.mtext_i18n_key = this.mtext_i18n_key;
            r100.mvalue = this.mvalue;
            r100.murl = this.murl;
            r100.moption_action_id = this.moption_action_id;
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
            this.mtext = r100;
            this.mtext_i18n_key = r101;
            this.mvalue = r102;
            this.murl = r103;
            this.moption_action_id = r104;
        }
    }

    public static final class MyAIToolProperty extends com.squareup.wire.Message<MyAIToolProperty, Builder> {
        public static final ProtoAdapter<MyAIToolProperty> ADAPTER = null;
        public static final String DEFAULT_NAME = "";
        public static final String DEFAULT_TEXT = "";
        public static final String DEFAULT_TOOL_ID = "";
        public static final String DEFAULT_TOOL_RUNTIME_ID = "";
        private static final long serialVersionUID = 0;
        public final Map<String, String> mi18n_name;
        public final Icon micon;
        public final String mname;
        public final Status mstatus;
        public final String mtext;
        public final String mtool_id;
        public final String mtool_runtime_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<MyAIToolProperty, Builder> {
            public Map<String, String> mi18n_name;
            public Icon micon;
            public String mname;
            public Status mstatus;
            public String mtext;
            public String mtool_id;
            public String mtool_runtime_id;

            @Override // com.squareup.wire.Message.Builder
            public MyAIToolProperty build() {
                return new MyAIToolProperty(this.mtool_id, this.mtool_runtime_id, this.mstatus, this.mi18n_name, this.mname, this.mtext, this.micon, super.buildUnknownFields());
            }

            public Builder() {
                this.mi18n_name = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder i18n_name(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.mi18n_name = r100;
                return this;
            }

            public Builder icon(Icon r100) {
                this.micon = r100;
                return this;
            }

            public Builder name(String r100) {
                this.mname = r100;
                return this;
            }

            public Builder status(Status r100) {
                this.mstatus = r100;
                return this;
            }

            public Builder text(String r100) {
                this.mtext = r100;
                return this;
            }

            public Builder tool_id(String r100) {
                this.mtool_id = r100;
                return this;
            }

            public Builder tool_runtime_id(String r100) {
                this.mtool_runtime_id = r100;
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
            private final ProtoAdapter<Map<String, String>> mi18n_name;

            public ProtoAdapter_MyAIToolProperty() {
                super(FieldEncoding.LENGTH_DELIMITED, MyAIToolProperty.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.mi18n_name = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MyAIToolProperty decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mtool_id = "";
                r101.mtool_runtime_id = "";
                r101.mname = "";
                r101.mtext = "";
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
                r101.mstatus = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L24:
                r101.micon = Icon.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r101.mtext = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.mname = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                r101.mi18n_name.putAll(this.mi18n_name.decode(r100));
                goto L3
            L18:
                r101.mtool_runtime_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L19:
                r101.mtool_id = ProtoAdapter.STRING.decode(r100);
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
                String r101 = r100.mtool_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mtool_runtime_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Status r107 = r100.mstatus;
                if (r107 == null) goto L13;
                int r108 = Status.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = (r106 + r108) + this.mi18n_name.encodedSizeWithTag(4, r100.mi18n_name);
                String r110 = r100.mname;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(5, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.mtext;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(6, r113);
            L22:
                int r115 = r112 + r114;
                Icon r116 = r100.micon;
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
                String r102 = r101.mtool_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mtool_runtime_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Status r104 = r101.mstatus;
                if (r104 == null) goto L11;
                Status.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                this.mi18n_name.encodeWithTag(r100, 4, r101.mi18n_name);
                String r105 = r101.mname;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r105);
            L14:
                String r106 = r101.mtext;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
            L17:
                Icon r107 = r101.micon;
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
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mtool_id = this.mtool_id;
            r100.mtool_runtime_id = this.mtool_runtime_id;
            r100.mstatus = this.mstatus;
            r100.mi18n_name = Internal.copyOf("mi18n_name", this.mi18n_name);
            r100.mname = this.mname;
            r100.mtext = this.mtext;
            r100.micon = this.micon;
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
            this.mtool_id = r100;
            this.mtool_runtime_id = r101;
            this.mstatus = r102;
            this.mi18n_name = Internal.immutableCopyOf("mi18n_name", r103);
            this.mname = r104;
            this.mtext = r105;
            this.micon = r106;
        }
    }

    public static final class OLProperty extends com.squareup.wire.Message<OLProperty, Builder> {
        public static final ProtoAdapter<OLProperty> ADAPTER = null;
        public static final Integer DEFAULT_START = null;
        private static final long serialVersionUID = 0;
        public final Integer mstart;
        public final Type mtype;

        public static final class Builder extends com.squareup.wire.Message.Builder<OLProperty, Builder> {
            public Integer mstart;
            public Type mtype;

            @Override // com.squareup.wire.Message.Builder
            public OLProperty build() {
                return new OLProperty(this.mtype, this.mstart, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder start(Integer r100) {
                this.mstart = r100;
                return this;
            }

            public Builder type(Type r100) {
                this.mtype = r100;
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
                r100.mstart = 1;
                long r101 = r110.beginMessage();
            L3:
                int r102 = r110.nextTag();
                if (r102 == (-1)) goto L14;
                if (r102 != 1) goto L7;
                r100.mtype = Type.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r100.addUnknownField(r102, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                if (r102 != 2) goto L8;
                r100.mstart = ProtoAdapter.INT32.decode(r110);
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
                Type r101 = r100.mtype;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.mstart;
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
                Type r102 = r101.mtype;
                if (r102 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.mstart;
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
            DEFAULT_START = 1;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mtype = this.mtype;
            r100.mstart = this.mstart;
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
            this.mtype = r100;
            this.mstart = r101;
        }
    }

    public static final class OverflowMenuProperty extends com.squareup.wire.Message<OverflowMenuProperty, Builder> {
        public static final ProtoAdapter<OverflowMenuProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final ButtonConfirmProperty mconfirm;
        public final List<MenuOption> moptions;

        public static final class Builder extends com.squareup.wire.Message.Builder<OverflowMenuProperty, Builder> {
            public String maction_id;
            public ButtonConfirmProperty mconfirm;
            public List<MenuOption> moptions;

            @Override // com.squareup.wire.Message.Builder
            public OverflowMenuProperty build() {
                return new OverflowMenuProperty(this.maction_id, this.moptions, this.mconfirm, super.buildUnknownFields());
            }

            public Builder() {
                this.moptions = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.maction_id = r100;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r100) {
                this.mconfirm = r100;
                return this;
            }

            public Builder options(List<MenuOption> r100) {
                Internal.checkElementsNotNull(r100);
                this.moptions = r100;
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
                r101.maction_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.maction_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.moptions.add(MenuOption.ADAPTER.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mconfirm = ButtonConfirmProperty.ADAPTER.decode(r100);
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
            public int encodedSize2(OverflowMenuProperty r100) {
                String r101 = r100.maction_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                int r104 = r103 + MenuOption.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.moptions);
                ButtonConfirmProperty r105 = r100.mconfirm;
                if (r105 == null) goto L10;
                r102 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(3, r105);
            L10:
                return (r104 + r102) + r100.unknownFields().size();
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
                String r102 = r101.maction_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                MenuOption.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.moptions);
                ButtonConfirmProperty r103 = r101.mconfirm;
                if (r103 == null) goto L8;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r100, 3, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OverflowMenuProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OverflowMenuProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.maction_id = this.maction_id;
            r100.moptions = Internal.copyOf("moptions", this.moptions);
            r100.mconfirm = this.mconfirm;
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

        public OverflowMenuProperty(String r100, List<MenuOption> r101, ButtonConfirmProperty r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public OverflowMenuProperty(String r100, List<MenuOption> r101, ButtonConfirmProperty r102, ByteString r103) {
            super(ADAPTER, r103);
            this.maction_id = r100;
            this.moptions = Internal.immutableCopyOf("moptions", r101);
            this.mconfirm = r102;
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
        public final String maction_id;
        public final String maction_param_name;
        public final String maction_param_value;
        public final String mcontent;
        public final Boolean mdisable;
        public final Integer mnumber_of_selected;
        public final Integer mnumber_of_total;
        public final String moption_case;
        public final Boolean mselected;

        public static final class Builder extends com.squareup.wire.Message.Builder<ProgressSelectOptionProperty, Builder> {
            public String maction_id;
            public String maction_param_name;
            public String maction_param_value;
            public String mcontent;
            public Boolean mdisable;
            public Integer mnumber_of_selected;
            public Integer mnumber_of_total;
            public String moption_case;
            public Boolean mselected;

            @Override // com.squareup.wire.Message.Builder
            public ProgressSelectOptionProperty build() {
                return new ProgressSelectOptionProperty(this.maction_id, this.maction_param_name, this.maction_param_value, this.mdisable, this.mselected, this.moption_case, this.mcontent, this.mnumber_of_selected, this.mnumber_of_total, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.maction_id = r100;
                return this;
            }

            public Builder action_param_name(String r100) {
                this.maction_param_name = r100;
                return this;
            }

            public Builder action_param_value(String r100) {
                this.maction_param_value = r100;
                return this;
            }

            public Builder content(String r100) {
                this.mcontent = r100;
                return this;
            }

            public Builder disable(Boolean r100) {
                this.mdisable = r100;
                return this;
            }

            public Builder number_of_selected(Integer r100) {
                this.mnumber_of_selected = r100;
                return this;
            }

            public Builder number_of_total(Integer r100) {
                this.mnumber_of_total = r100;
                return this;
            }

            public Builder option_case(String r100) {
                this.moption_case = r100;
                return this;
            }

            public Builder selected(Boolean r100) {
                this.mselected = r100;
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
                r101.maction_id = "";
                r101.maction_param_name = "";
                r101.maction_param_value = "";
                Boolean r102 = Boolean.FALSE;
                r101.mdisable = r102;
                r101.mselected = r102;
                r101.moption_case = "";
                r101.mcontent = "";
                r101.mnumber_of_selected = 0;
                r101.mnumber_of_total = 0;
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
                r101.mnumber_of_total = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                r101.mnumber_of_selected = ProtoAdapter.INT32.decode(r100);
                goto L3
            L9:
                r101.mcontent = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.moption_case = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.mselected = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L12:
                r101.mdisable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                r101.maction_param_value = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                r101.maction_param_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L15:
                r101.maction_id = ProtoAdapter.STRING.decode(r100);
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
                String r101 = r100.maction_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.maction_param_name;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.maction_param_value;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.mdisable;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Boolean r113 = r100.mselected;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
            L22:
                int r115 = r112 + r114;
                String r116 = r100.moption_case;
                if (r116 == null) goto L25;
                int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
            L26:
                int r118 = r115 + r117;
                String r119 = r100.mcontent;
                if (r119 == null) goto L29;
                int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
            L30:
                int r121 = r118 + r120;
                Integer r122 = r100.mnumber_of_selected;
                if (r122 == null) goto L33;
                int r123 = ProtoAdapter.INT32.encodedSizeWithTag(8, r122);
            L34:
                int r124 = r121 + r123;
                Integer r125 = r100.mnumber_of_total;
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
                String r102 = r101.maction_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.maction_param_name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.maction_param_value;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.mdisable;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                Boolean r106 = r101.mselected;
                if (r106 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
            L17:
                String r107 = r101.moption_case;
                if (r107 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
            L20:
                String r108 = r101.mcontent;
                if (r108 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
            L23:
                Integer r109 = r101.mnumber_of_selected;
                if (r109 == null) goto L26;
                ProtoAdapter.INT32.encodeWithTag(r100, 8, r109);
            L26:
                Integer r110 = r101.mnumber_of_total;
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
            r100.maction_id = this.maction_id;
            r100.maction_param_name = this.maction_param_name;
            r100.maction_param_value = this.maction_param_value;
            r100.mdisable = this.mdisable;
            r100.mselected = this.mselected;
            r100.moption_case = this.moption_case;
            r100.mcontent = this.mcontent;
            r100.mnumber_of_selected = this.mnumber_of_selected;
            r100.mnumber_of_total = this.mnumber_of_total;
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
            this.maction_id = r100;
            this.maction_param_name = r101;
            this.maction_param_value = r102;
            this.mdisable = r103;
            this.mselected = r104;
            this.moption_case = r105;
            this.mcontent = r106;
            this.mnumber_of_selected = r107;
            this.mnumber_of_total = r110;
        }
    }

    public static final class ProtoAdapter_RichTextElement extends ProtoAdapter<RichTextElement> {
        private final ProtoAdapter<Map<String, String>> mstyle;

        public ProtoAdapter_RichTextElement() {
            super(FieldEncoding.LENGTH_DELIMITED, RichTextElement.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mstyle = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RichTextElement decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            ByteString r102 = ByteString.EMPTY;
            r101.mproperty = r102;
            r101.mupgrade_element = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L16;
            switch(r104) {
                case 1: goto L18;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.mtag = Tag.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mupgrade_element = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L8:
            r101.mstyle_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            r101.mchild_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.mproperty = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L11:
            r101.mstyle.putAll(this.mstyle.decode(r100));
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
        public int encodedSize2(RichTextElement r100) {
            int r101 = Tag.ADAPTER.encodedSizeWithTag(1, r100.mtag) + this.mstyle.encodedSizeWithTag(2, r100.mstyle);
            ProtoAdapter<ByteString> r102 = ProtoAdapter.BYTES;
            int r103 = r101 + r102.encodedSizeWithTag(3, r100.mproperty);
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            int r105 = (r103 + r104.asRepeated().encodedSizeWithTag(4, r100.mchild_ids)) + r104.asRepeated().encodedSizeWithTag(5, r100.mstyle_keys);
            ByteString r106 = r100.mupgrade_element;
            if (r106 == null) goto L5;
            int r107 = r102.encodedSizeWithTag(6, r106);
        L7:
            return (r105 + r107) + r100.unknownFields().size();
        L5:
            r107 = 0;
            goto L7
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
            Tag.ADAPTER.encodeWithTag(r100, 1, r101.mtag);
            this.mstyle.encodeWithTag(r100, 2, r101.mstyle);
            ProtoAdapter<ByteString> r102 = ProtoAdapter.BYTES;
            r102.encodeWithTag(r100, 3, r101.mproperty);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.asRepeated().encodeWithTag(r100, 4, r101.mchild_ids);
            r103.asRepeated().encodeWithTag(r100, 5, r101.mstyle_keys);
            ByteString r104 = r101.mupgrade_element;
            if (r104 == null) goto L5;
            r102.encodeWithTag(r100, 6, r104);
        L5:
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
        public final String mkey;

        public static final class Builder extends com.squareup.wire.Message.Builder<ReactionProperty, Builder> {
            public String mkey;

            @Override // com.squareup.wire.Message.Builder
            public ReactionProperty build() {
                String r100 = this.mkey;
                if (r100 == null) goto L7;
                return new ReactionProperty(this.mkey, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "mkey"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder key(String r100) {
                this.mkey = r100;
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
                r101.mkey = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mkey = ProtoAdapter.STRING.decode(r100);
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
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mkey) + r100.unknownFields().size();
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
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mkey);
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
            r100.mkey = this.mkey;
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
            this.mkey = r100;
        }
    }

    public static final class SelectMenuProperty extends com.squareup.wire.Message<SelectMenuProperty, Builder> {
        public static final ProtoAdapter<SelectMenuProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_INITIAL_OPTION = "";
        public static final String DEFAULT_PLACE_HOLDER = "";
        public static final String DEFAULT_PLACE_HOLDER_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final ButtonConfirmProperty mconfirm;
        public final String minitial_option;
        public final List<MenuOption> moptions;
        public final String mplace_holder;
        public final String mplace_holder_i18n_key;
        public final Type mtype;

        public static final class Builder extends com.squareup.wire.Message.Builder<SelectMenuProperty, Builder> {
            public String maction_id;
            public ButtonConfirmProperty mconfirm;
            public String minitial_option;
            public List<MenuOption> moptions;
            public String mplace_holder;
            public String mplace_holder_i18n_key;
            public Type mtype;

            @Override // com.squareup.wire.Message.Builder
            public SelectMenuProperty build() {
                return new SelectMenuProperty(this.mtype, this.maction_id, this.mplace_holder, this.mplace_holder_i18n_key, this.minitial_option, this.moptions, this.mconfirm, super.buildUnknownFields());
            }

            public Builder() {
                this.moptions = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.maction_id = r100;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r100) {
                this.mconfirm = r100;
                return this;
            }

            public Builder initial_option(String r100) {
                this.minitial_option = r100;
                return this;
            }

            public Builder options(List<MenuOption> r100) {
                Internal.checkElementsNotNull(r100);
                this.moptions = r100;
                return this;
            }

            public Builder place_holder(String r100) {
                this.mplace_holder = r100;
                return this;
            }

            public Builder place_holder_i18n_key(String r100) {
                this.mplace_holder_i18n_key = r100;
                return this;
            }

            public Builder type(Type r100) {
                this.mtype = r100;
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
                r101.maction_id = "";
                r101.mplace_holder = "";
                r101.mplace_holder_i18n_key = "";
                r101.minitial_option = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L17;
                switch(r103) {
                    case 1: goto L19;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L19:
                r101.mtype = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r101.mconfirm = ButtonConfirmProperty.ADAPTER.decode(r100);
                goto L3
            L8:
                r101.moptions.add(MenuOption.ADAPTER.decode(r100));
                goto L3
            L9:
                r101.minitial_option = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.mplace_holder_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.mplace_holder = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.maction_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L17:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(SelectMenuProperty r100) {
                Type r101 = r100.mtype;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.maction_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mplace_holder;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.mplace_holder_i18n_key;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                String r113 = r100.minitial_option;
                if (r113 == null) goto L21;
                int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
            L22:
                int r115 = (r112 + r114) + MenuOption.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.moptions);
                ButtonConfirmProperty r116 = r100.mconfirm;
                if (r116 == null) goto L26;
                r102 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(7, r116);
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
            public /* bridge */ /* synthetic */ SelectMenuProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SelectMenuProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SelectMenuProperty r101) throws IOException {
                Type r102 = r101.mtype;
                if (r102 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.maction_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mplace_holder;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.mplace_holder_i18n_key;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                String r106 = r101.minitial_option;
                if (r106 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
            L17:
                MenuOption.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.moptions);
                ButtonConfirmProperty r107 = r101.mconfirm;
                if (r107 == null) goto L20;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r100, 7, r107);
            L20:
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
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mtype = this.mtype;
            r100.maction_id = this.maction_id;
            r100.mplace_holder = this.mplace_holder;
            r100.mplace_holder_i18n_key = this.mplace_holder_i18n_key;
            r100.minitial_option = this.minitial_option;
            r100.moptions = Internal.copyOf("moptions", this.moptions);
            r100.mconfirm = this.mconfirm;
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

        public SelectMenuProperty(Type r110, String r111, String r112, String r113, String r114, List<MenuOption> r115, ButtonConfirmProperty r116) {
            this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
        }

        public SelectMenuProperty(Type r100, String r101, String r102, String r103, String r104, List<MenuOption> r105, ButtonConfirmProperty r106, ByteString r107) {
            super(ADAPTER, r107);
            this.mtype = r100;
            this.maction_id = r101;
            this.mplace_holder = r102;
            this.mplace_holder_i18n_key = r103;
            this.minitial_option = r104;
            this.moptions = Internal.immutableCopyOf("moptions", r105);
            this.mconfirm = r106;
        }
    }

    public static final class SelectProperty extends com.squareup.wire.Message<SelectProperty, Builder> {
        public static final ProtoAdapter<SelectProperty> ADAPTER = null;
        public static final Integer DEFAULT_MAX_PICK_NUM = null;
        public static final Integer DEFAULT_MIN_PICK_NUM = null;
        private static final long serialVersionUID = 0;
        public final Integer mmax_pick_num;
        public final Integer mmin_pick_num;

        public static final class Builder extends com.squareup.wire.Message.Builder<SelectProperty, Builder> {
            public Integer mmax_pick_num;
            public Integer mmin_pick_num;

            @Override // com.squareup.wire.Message.Builder
            public SelectProperty build() {
                return new SelectProperty(this.mmin_pick_num, this.mmax_pick_num, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder max_pick_num(Integer r100) {
                this.mmax_pick_num = r100;
                return this;
            }

            public Builder min_pick_num(Integer r100) {
                this.mmin_pick_num = r100;
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
                r101.mmin_pick_num = 1;
                r101.mmax_pick_num = 1;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 4) goto L8;
                r101.mmin_pick_num = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 5) goto L9;
                r101.mmax_pick_num = ProtoAdapter.INT32.decode(r100);
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
                Integer r101 = r100.mmin_pick_num;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(4, r101);
            L6:
                Integer r104 = r100.mmax_pick_num;
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
                Integer r102 = r101.mmin_pick_num;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 4, r102);
            L5:
                Integer r103 = r101.mmax_pick_num;
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
            r100.mmin_pick_num = this.mmin_pick_num;
            r100.mmax_pick_num = this.mmax_pick_num;
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
            this.mmin_pick_num = r100;
            this.mmax_pick_num = r101;
        }
    }

    public static final class TableCellProperty extends com.squareup.wire.Message<TableCellProperty, Builder> {
        public static final ProtoAdapter<TableCellProperty> ADAPTER = null;
        public static final Integer DEFAULT_COLSPAN = null;
        public static final Boolean DEFAULT_IS_MERGED = null;
        public static final Integer DEFAULT_ROWSPAN = null;
        private static final long serialVersionUID = 0;
        public final Integer mcolspan;
        public final HorizontalAlign mhorizontal_align;
        public final Boolean mis_merged;
        public final Integer mrowspan;
        public final VerticalAlign mvertical_align;

        public static final class Builder extends com.squareup.wire.Message.Builder<TableCellProperty, Builder> {
            public Integer mcolspan;
            public HorizontalAlign mhorizontal_align;
            public Boolean mis_merged;
            public Integer mrowspan;
            public VerticalAlign mvertical_align;

            @Override // com.squareup.wire.Message.Builder
            public TableCellProperty build() {
                return new TableCellProperty(this.mcolspan, this.mrowspan, this.mhorizontal_align, this.mvertical_align, this.mis_merged, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder colspan(Integer r100) {
                this.mcolspan = r100;
                return this;
            }

            public Builder horizontal_align(HorizontalAlign r100) {
                this.mhorizontal_align = r100;
                return this;
            }

            public Builder is_merged(Boolean r100) {
                this.mis_merged = r100;
                return this;
            }

            public Builder rowspan(Integer r100) {
                this.mrowspan = r100;
                return this;
            }

            public Builder vertical_align(VerticalAlign r100) {
                this.mvertical_align = r100;
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
                r100.mcolspan = 1;
                r100.mrowspan = 1;
                r100.mis_merged = Boolean.FALSE;
                long r101 = r110.beginMessage();
            L3:
                int r102 = r110.nextTag();
                if (r102 == (-1)) goto L26;
                if (r102 != 1) goto L7;
                r100.mcolspan = ProtoAdapter.INT32.decode(r110);
                goto L3
            L7:
                if (r102 != 2) goto L9;
                r100.mrowspan = ProtoAdapter.INT32.decode(r110);
                goto L3
            L9:
                if (r102 != 3) goto L11;
                r100.mhorizontal_align = HorizontalAlign.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r100.addUnknownField(r102, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                if (r102 != 4) goto L13;
                r100.mvertical_align = VerticalAlign.ADAPTER.decode(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r100.addUnknownField(r102, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L13:
                if (r102 != 5) goto L14;
                r100.mis_merged = ProtoAdapter.BOOL.decode(r110);
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
                Integer r101 = r100.mcolspan;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.mrowspan;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                HorizontalAlign r107 = r100.mhorizontal_align;
                if (r107 == null) goto L13;
                int r108 = HorizontalAlign.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                VerticalAlign r110 = r100.mvertical_align;
                if (r110 == null) goto L17;
                int r111 = VerticalAlign.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Boolean r113 = r100.mis_merged;
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
                Integer r102 = r101.mcolspan;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.mrowspan;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                HorizontalAlign r104 = r101.mhorizontal_align;
                if (r104 == null) goto L11;
                HorizontalAlign.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                VerticalAlign r105 = r101.mvertical_align;
                if (r105 == null) goto L14;
                VerticalAlign.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                Boolean r106 = r101.mis_merged;
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
            DEFAULT_IS_MERGED = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mcolspan = this.mcolspan;
            r100.mrowspan = this.mrowspan;
            r100.mhorizontal_align = this.mhorizontal_align;
            r100.mvertical_align = this.mvertical_align;
            r100.mis_merged = this.mis_merged;
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
            this.mcolspan = r100;
            this.mrowspan = r101;
            this.mhorizontal_align = r102;
            this.mvertical_align = r103;
            this.mis_merged = r104;
        }
    }

    public static final class TableProperty extends com.squareup.wire.Message<TableProperty, Builder> {
        public static final ProtoAdapter<TableProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Column> mcolumns;

        public static final class Builder extends com.squareup.wire.Message.Builder<TableProperty, Builder> {
            public List<Column> mcolumns;

            @Override // com.squareup.wire.Message.Builder
            public TableProperty build() {
                return new TableProperty(this.mcolumns, super.buildUnknownFields());
            }

            public Builder() {
                this.mcolumns = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder columns(List<Column> r100) {
                Internal.checkElementsNotNull(r100);
                this.mcolumns = r100;
                return this;
            }
        }

        public static final class Column extends com.squareup.wire.Message<Column, Builder> {
            public static final ProtoAdapter<Column> ADAPTER = null;
            public static final Boolean DEFAULT_IS_HEADER = null;
            public static final Integer DEFAULT_WIDTH = null;
            private static final long serialVersionUID = 0;
            public final HorizontalAlign mhorizontal_align;
            public final Boolean mis_header;
            public final VerticalAlign mvertical_align;
            public final Integer mwidth;

            public static final class Builder extends com.squareup.wire.Message.Builder<Column, Builder> {
                public HorizontalAlign mhorizontal_align;
                public Boolean mis_header;
                public VerticalAlign mvertical_align;
                public Integer mwidth;

                @Override // com.squareup.wire.Message.Builder
                public Column build() {
                    return new Column(this.mwidth, this.mhorizontal_align, this.mvertical_align, this.mis_header, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder horizontal_align(HorizontalAlign r100) {
                    this.mhorizontal_align = r100;
                    return this;
                }

                public Builder is_header(Boolean r100) {
                    this.mis_header = r100;
                    return this;
                }

                public Builder vertical_align(VerticalAlign r100) {
                    this.mvertical_align = r100;
                    return this;
                }

                public Builder width(Integer r100) {
                    this.mwidth = r100;
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
                    r101.mwidth = 0;
                    r101.mis_header = Boolean.FALSE;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L24;
                    if (r103 != 1) goto L8;
                    r101.mwidth = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.mhorizontal_align = HorizontalAlign.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
                L21:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.mvertical_align = VerticalAlign.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
                L17:
                    e = move-exception;
                    r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.mis_header = ProtoAdapter.BOOL.decode(r100);
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
                    Integer r101 = r100.mwidth;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
                L6:
                    HorizontalAlign r104 = r100.mhorizontal_align;
                    if (r104 == null) goto L9;
                    int r105 = HorizontalAlign.ADAPTER.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    VerticalAlign r107 = r100.mvertical_align;
                    if (r107 == null) goto L13;
                    int r108 = VerticalAlign.ADAPTER.encodedSizeWithTag(3, r107);
                L14:
                    int r109 = r106 + r108;
                    Boolean r110 = r100.mis_header;
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
                    Integer r102 = r101.mwidth;
                    if (r102 == null) goto L5;
                    ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
                L5:
                    HorizontalAlign r103 = r101.mhorizontal_align;
                    if (r103 == null) goto L8;
                    HorizontalAlign.ADAPTER.encodeWithTag(r100, 2, r103);
                L8:
                    VerticalAlign r104 = r101.mvertical_align;
                    if (r104 == null) goto L11;
                    VerticalAlign.ADAPTER.encodeWithTag(r100, 3, r104);
                L11:
                    Boolean r105 = r101.mis_header;
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
                DEFAULT_IS_HEADER = Boolean.FALSE;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.mwidth = this.mwidth;
                r100.mhorizontal_align = this.mhorizontal_align;
                r100.mvertical_align = this.mvertical_align;
                r100.mis_header = this.mis_header;
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
                this.mwidth = r100;
                this.mhorizontal_align = r101;
                this.mvertical_align = r102;
                this.mis_header = r103;
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
                r101.mcolumns.add(Column.ADAPTER.decode(r100));
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
                return Column.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mcolumns) + r100.unknownFields().size();
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
                Column.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mcolumns);
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
            r100.mcolumns = Internal.copyOf("mcolumns", this.mcolumns);
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
            this.mcolumns = Internal.immutableCopyOf("mcolumns", r100);
        }
    }

    public static final class TableRowProperty extends com.squareup.wire.Message<TableRowProperty, Builder> {
        public static final ProtoAdapter<TableRowProperty> ADAPTER = null;
        public static final Boolean DEFAULT_IS_HEADER = null;
        private static final long serialVersionUID = 0;
        public final HorizontalAlign mhorizontal_align;
        public final Boolean mis_header;
        public final VerticalAlign mvertical_align;

        public static final class Builder extends com.squareup.wire.Message.Builder<TableRowProperty, Builder> {
            public HorizontalAlign mhorizontal_align;
            public Boolean mis_header;
            public VerticalAlign mvertical_align;

            @Override // com.squareup.wire.Message.Builder
            public TableRowProperty build() {
                return new TableRowProperty(this.mhorizontal_align, this.mvertical_align, this.mis_header, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder horizontal_align(HorizontalAlign r100) {
                this.mhorizontal_align = r100;
                return this;
            }

            public Builder is_header(Boolean r100) {
                this.mis_header = r100;
                return this;
            }

            public Builder vertical_align(VerticalAlign r100) {
                this.mvertical_align = r100;
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
                r101.mis_header = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.mhorizontal_align = HorizontalAlign.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mvertical_align = VerticalAlign.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mis_header = ProtoAdapter.BOOL.decode(r100);
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
                HorizontalAlign r101 = r100.mhorizontal_align;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = HorizontalAlign.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                VerticalAlign r104 = r100.mvertical_align;
                if (r104 == null) goto L9;
                int r105 = VerticalAlign.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.mis_header;
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
                HorizontalAlign r102 = r101.mhorizontal_align;
                if (r102 == null) goto L5;
                HorizontalAlign.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                VerticalAlign r103 = r101.mvertical_align;
                if (r103 == null) goto L8;
                VerticalAlign.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.mis_header;
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
            DEFAULT_IS_HEADER = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mhorizontal_align = this.mhorizontal_align;
            r100.mvertical_align = this.mvertical_align;
            r100.mis_header = this.mis_header;
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
            this.mhorizontal_align = r100;
            this.mvertical_align = r101;
            this.mis_header = r102;
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
        public static final Tag PROGRESS_SELECT_OPTION = null;
        public static final Tag QUOTE = null;
        public static final Tag REACTION = null;
        public static final Tag SELECT = null;
        public static final Tag SELECTMENU = null;
        public static final Tag TABLE = null;
        public static final Tag TABLE_CELL = null;
        public static final Tag TABLE_ROW = null;
        public static final Tag TEXT = null;
        public static final Tag TEXTABLE_AREA = null;
        public static final Tag TIME = null;
        public static final Tag TIMEPICKER = null;
        public static final Tag U = null;
        public static final Tag UL = null;
        public static final Tag UNKNOWN_TAG = null;
        private final int value;

        static {
            Tag r100 = new Tag("UNKNOWN_TAG", 0, 0);
            UNKNOWN_TAG = r100;
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
            Tag r107 = new Tag("PROGRESS_SELECT_OPTION", 13, 13);
            PROGRESS_SELECT_OPTION = r107;
            Tag r108 = new Tag("DIV", 14, 14);
            DIV = r108;
            Tag r109 = new Tag("TEXTABLE_AREA", 15, 15);
            TEXTABLE_AREA = r109;
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
            Tag r148 = new Tag("MARKDOWN", 48, 49);
            MARKDOWN = r148;
            $VALUES = new Tag[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148};
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
                case 0: goto L102;
                case 1: goto L100;
                case 2: goto L98;
                case 3: goto L96;
                case 4: goto L94;
                case 5: goto L92;
                case 6: goto L90;
                case 7: goto L88;
                case 8: goto L86;
                case 9: goto L84;
                case 10: goto L82;
                case 11: goto L80;
                case 12: goto L78;
                case 13: goto L76;
                case 14: goto L74;
                case 15: goto L72;
                case 16: goto L70;
                case 17: goto L68;
                case 18: goto L66;
                case 19: goto L64;
                case 20: goto L62;
                case 21: goto L60;
                case 22: goto L58;
                case 23: goto L56;
                case 24: goto L54;
                case 25: goto L52;
                case 26: goto L50;
                case 27: goto L48;
                case 28: goto L46;
                case 29: goto L44;
                case 30: goto L42;
                case 31: goto L40;
                case 32: goto L38;
                case 33: goto L36;
                case 34: goto L34;
                case 35: goto L32;
                case 36: goto L30;
                case 37: goto L28;
                case 38: goto L26;
                case 39: goto L24;
                case 40: goto L22;
                case 41: goto L20;
                case 42: goto L18;
                case 43: goto L16;
                case 44: goto L14;
                case 45: goto L12;
                case 46: goto L10;
                case 47: goto L8;
                case 48: goto L3;
                case 49: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return MARKDOWN;
        L8:
            return AT_USER_GROUP;
        L10:
            return H6;
        L12:
            return H5;
        L14:
            return H4;
        L16:
            return COLUMN;
        L18:
            return COLUMNS;
        L20:
            return TABLE_CELL;
        L22:
            return TABLE_ROW;
        L24:
            return TABLE;
        L26:
            return MY_AI_TOOL;
        L28:
            return CODE_BLOCK_V2;
        L30:
            return MENTION;
        L32:
            return REACTION;
        L34:
            return DATETIMEPICKER;
        L36:
            return TIMEPICKER;
        L38:
            return HR;
        L40:
            return CODE_BLOCK;
        L42:
            return CODE;
        L44:
            return QUOTE;
        L46:
            return LI;
        L48:
            return OL;
        L50:
            return UL;
        L52:
            return H3;
        L54:
            return H2;
        L56:
            return H1;
        L58:
            return DOCS;
        L60:
            return DATEPICKER;
        L62:
            return OVERFLOWMENU;
        L64:
            return SELECTMENU;
        L66:
            return MEDIA;
        L68:
            return LINK;
        L70:
            return TIME;
        L72:
            return TEXTABLE_AREA;
        L74:
            return DIV;
        L76:
            return PROGRESS_SELECT_OPTION;
        L78:
            return SELECT;
        L80:
            return BUTTON;
        L82:
            return EMOTION;
        L84:
            return U;
        L86:
            return I;
        L88:
            return B;
        L90:
            return A;
        L92:
            return AT;
        L94:
            return FIGURE;
        L96:
            return P;
        L98:
            return IMG;
        L100:
            return TEXT;
        L102:
            return UNKNOWN_TAG;
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
        public final String mcontent;
        public final String mi18n_key;
        public final Integer mnumberOfLines;

        public static final class Builder extends com.squareup.wire.Message.Builder<TextProperty, Builder> {
            public String mcontent;
            public String mi18n_key;
            public Integer mnumberOfLines;

            @Override // com.squareup.wire.Message.Builder
            public TextProperty build() {
                String r100 = this.mcontent;
                if (r100 == null) goto L7;
                return new TextProperty(this.mcontent, this.mi18n_key, this.mnumberOfLines, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "mcontent"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.mcontent = r100;
                return this;
            }

            public Builder i18n_key(String r100) {
                this.mi18n_key = r100;
                return this;
            }

            public Builder numberOfLines(Integer r100) {
                this.mnumberOfLines = r100;
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
                r101.mcontent = "";
                r101.mi18n_key = "";
                r101.mnumberOfLines = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mcontent = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mi18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mnumberOfLines = ProtoAdapter.INT32.decode(r100);
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
                int r102 = r101.encodedSizeWithTag(1, r100.mcontent);
                String r103 = r100.mi18n_key;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(2, r103);
            L6:
                int r106 = r102 + r105;
                Integer r107 = r100.mnumberOfLines;
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
                r102.encodeWithTag(r100, 1, r101.mcontent);
                String r103 = r101.mi18n_key;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 2, r103);
            L5:
                Integer r104 = r101.mnumberOfLines;
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
            r100.mcontent = this.mcontent;
            r100.mi18n_key = this.mi18n_key;
            r100.mnumberOfLines = this.mnumberOfLines;
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
            this.mcontent = r100;
            this.mi18n_key = r101;
            this.mnumberOfLines = r102;
        }
    }

    public static final class TextableAreaProperty extends com.squareup.wire.Message<TextableAreaProperty, Builder> {
        public static final ProtoAdapter<TextableAreaProperty> ADAPTER = null;
        public static final Integer DEFAULT_NUMBEROFLINES = null;
        private static final long serialVersionUID = 0;
        public final Integer mnumberOfLines;

        public static final class Builder extends com.squareup.wire.Message.Builder<TextableAreaProperty, Builder> {
            public Integer mnumberOfLines;

            @Override // com.squareup.wire.Message.Builder
            public TextableAreaProperty build() {
                return new TextableAreaProperty(this.mnumberOfLines, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder numberOfLines(Integer r100) {
                this.mnumberOfLines = r100;
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
                r101.mnumberOfLines = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mnumberOfLines = ProtoAdapter.INT32.decode(r100);
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
                Integer r101 = r100.mnumberOfLines;
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
                Integer r102 = r101.mnumberOfLines;
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
            r100.mnumberOfLines = this.mnumberOfLines;
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
            this.mnumberOfLines = r100;
        }
    }

    public static final class TimePickerProperty extends com.squareup.wire.Message<TimePickerProperty, Builder> {
        public static final ProtoAdapter<TimePickerProperty> ADAPTER = null;
        public static final String DEFAULT_ACTION_ID = "";
        public static final String DEFAULT_INITIAL_TIME = "";
        public static final String DEFAULT_PLACE_HOLDER = "";
        public static final String DEFAULT_PLACE_HOLDER_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String maction_id;
        public final ButtonConfirmProperty mconfirm;
        public final String minitial_time;
        public final String mplace_holder;
        public final String mplace_holder_i18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<TimePickerProperty, Builder> {
            public String maction_id;
            public ButtonConfirmProperty mconfirm;
            public String minitial_time;
            public String mplace_holder;
            public String mplace_holder_i18n_key;

            @Override // com.squareup.wire.Message.Builder
            public TimePickerProperty build() {
                return new TimePickerProperty(this.maction_id, this.mplace_holder, this.mplace_holder_i18n_key, this.minitial_time, this.mconfirm, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder action_id(String r100) {
                this.maction_id = r100;
                return this;
            }

            public Builder confirm(ButtonConfirmProperty r100) {
                this.mconfirm = r100;
                return this;
            }

            public Builder initial_time(String r100) {
                this.minitial_time = r100;
                return this;
            }

            public Builder place_holder(String r100) {
                this.mplace_holder = r100;
                return this;
            }

            public Builder place_holder_i18n_key(String r100) {
                this.mplace_holder_i18n_key = r100;
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
                r101.maction_id = "";
                r101.mplace_holder = "";
                r101.mplace_holder_i18n_key = "";
                r101.minitial_time = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.maction_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mplace_holder = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mplace_holder_i18n_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.minitial_time = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.mconfirm = ButtonConfirmProperty.ADAPTER.decode(r100);
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
            public int encodedSize2(TimePickerProperty r100) {
                String r101 = r100.maction_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mplace_holder;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mplace_holder_i18n_key;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.minitial_time;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                ButtonConfirmProperty r113 = r100.mconfirm;
                if (r113 == null) goto L22;
                r102 = ButtonConfirmProperty.ADAPTER.encodedSizeWithTag(5, r113);
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
            public /* bridge */ /* synthetic */ TimePickerProperty decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TimePickerProperty r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TimePickerProperty r101) throws IOException {
                String r102 = r101.maction_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mplace_holder;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mplace_holder_i18n_key;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.minitial_time;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                ButtonConfirmProperty r106 = r101.mconfirm;
                if (r106 == null) goto L17;
                ButtonConfirmProperty.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TimePickerProperty r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimePickerProperty();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.maction_id = this.maction_id;
            r100.mplace_holder = this.mplace_holder;
            r100.mplace_holder_i18n_key = this.mplace_holder_i18n_key;
            r100.minitial_time = this.minitial_time;
            r100.mconfirm = this.mconfirm;
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

        public TimePickerProperty(String r100, String r101, String r110, String r111, ButtonConfirmProperty r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public TimePickerProperty(String r100, String r101, String r102, String r103, ButtonConfirmProperty r104, ByteString r105) {
            super(ADAPTER, r105);
            this.maction_id = r100;
            this.mplace_holder = r101;
            this.mplace_holder_i18n_key = r102;
            this.minitial_time = r103;
            this.mconfirm = r104;
        }
    }

    public static final class TimeProperty extends com.squareup.wire.Message<TimeProperty, Builder> {
        public static final ProtoAdapter<TimeProperty> ADAPTER = null;
        public static final String DEFAULT_FORMAT = "YYYY.MM.DD(dddd) HH:mm (GMT)";
        public static final String DEFAULT_FORMAT_TYPE = "";
        public static final String DEFAULT_LINK = "";
        public static final Long DEFAULT_MILLISECOND_SINCE1970 = null;
        private static final long serialVersionUID = 0;
        public final String mformat;
        public final String mformat_type;
        public final String mlink;
        public final Long mmillisecond_since1970;

        public static final class Builder extends com.squareup.wire.Message.Builder<TimeProperty, Builder> {
            public String mformat;
            public String mformat_type;
            public String mlink;
            public Long mmillisecond_since1970;

            @Override // com.squareup.wire.Message.Builder
            public TimeProperty build() {
                Long r100 = this.mmillisecond_since1970;
                if (r100 == null) goto L7;
                return new TimeProperty(this.mmillisecond_since1970, this.mformat, this.mlink, this.mformat_type, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "mmillisecond_since1970"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder format(String r100) {
                this.mformat = r100;
                return this;
            }

            public Builder format_type(String r100) {
                this.mformat_type = r100;
                return this;
            }

            public Builder link(String r100) {
                this.mlink = r100;
                return this;
            }

            public Builder millisecond_since1970(Long r100) {
                this.mmillisecond_since1970 = r100;
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
                r101.mmillisecond_since1970 = 0L;
                r101.mformat = "YYYY.MM.DD(dddd) HH:mm (GMT)";
                r101.mlink = "";
                r101.mformat_type = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mmillisecond_since1970 = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mformat = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mlink = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.mformat_type = ProtoAdapter.STRING.decode(r100);
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
                int r101 = ProtoAdapter.INT64.encodedSizeWithTag(1, r100.mmillisecond_since1970);
                String r102 = r100.mformat;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
            L6:
                int r105 = r101 + r104;
                String r106 = r100.mlink;
                if (r106 == null) goto L9;
                int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
            L10:
                int r108 = r105 + r107;
                String r109 = r100.mformat_type;
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
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.mmillisecond_since1970);
                String r102 = r101.mformat;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
            L5:
                String r103 = r101.mlink;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
            L8:
                String r104 = r101.mformat_type;
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
            r100.mmillisecond_since1970 = this.mmillisecond_since1970;
            r100.mformat = this.mformat;
            r100.mlink = this.mlink;
            r100.mformat_type = this.mformat_type;
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
            this.mmillisecond_since1970 = r100;
            this.mformat = r101;
            this.mlink = r102;
            this.mformat_type = r103;
        }
    }

    public static final class ULProperty extends com.squareup.wire.Message<ULProperty, Builder> {
        public static final ProtoAdapter<ULProperty> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Type mtype;

        public static final class Builder extends com.squareup.wire.Message.Builder<ULProperty, Builder> {
            public Type mtype;

            @Override // com.squareup.wire.Message.Builder
            public ULProperty build() {
                return new ULProperty(this.mtype, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder type(Type r100) {
                this.mtype = r100;
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
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.mtype = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
                Type r101 = r100.mtype;
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
                Type r102 = r101.mtype;
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
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mtype = this.mtype;
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
            this.mtype = r100;
        }
    }

    public static final class UnderlineProperty extends com.squareup.wire.Message<UnderlineProperty, Builder> {
        public static final ProtoAdapter<UnderlineProperty> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_I18N_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final String mi18n_key;

        public static final class Builder extends com.squareup.wire.Message.Builder<UnderlineProperty, Builder> {
            public String mcontent;
            public String mi18n_key;

            @Override // com.squareup.wire.Message.Builder
            public UnderlineProperty build() {
                String r100 = this.mcontent;
                if (r100 == null) goto L7;
                return new UnderlineProperty(this.mcontent, this.mi18n_key, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "mcontent"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.mcontent = r100;
                return this;
            }

            public Builder i18n_key(String r100) {
                this.mi18n_key = r100;
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
                r101.mcontent = "";
                r101.mi18n_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mcontent = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mi18n_key = ProtoAdapter.STRING.decode(r100);
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
                int r102 = r101.encodedSizeWithTag(1, r100.mcontent);
                String r103 = r100.mi18n_key;
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
                r102.encodeWithTag(r100, 1, r101.mcontent);
                String r103 = r101.mi18n_key;
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
            r100.mcontent = this.mcontent;
            r100.mi18n_key = this.mi18n_key;
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
            this.mcontent = r100;
            this.mi18n_key = r101;
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
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_PROPERTY = r100;
        DEFAULT_UPGRADE_ELEMENT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtag = this.mtag;
        r100.mstyle = Internal.copyOf("mstyle", this.mstyle);
        r100.mproperty = this.mproperty;
        r100.mchild_ids = Internal.copyOf("mchild_ids", this.mchild_ids);
        r100.mstyle_keys = Internal.copyOf("mstyle_keys", this.mstyle_keys);
        r100.mupgrade_element = this.mupgrade_element;
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

    public RichTextElement(Tag r100, Map<String, String> r110, ByteString r111, List<String> r112, List<String> r113, ByteString r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public RichTextElement(Tag r100, Map<String, String> r101, ByteString r102, List<String> r103, List<String> r104, ByteString r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mtag = r100;
        this.mstyle = Internal.immutableCopyOf("mstyle", r101);
        this.mproperty = r102;
        this.mchild_ids = Internal.immutableCopyOf("mchild_ids", r103);
        this.mstyle_keys = Internal.immutableCopyOf("mstyle_keys", r104);
        this.mupgrade_element = r105;
    }
}
