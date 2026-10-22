package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatTheme extends com.squareup.wire.Message<ChatTheme, Builder> {
    public static final ProtoAdapter<ChatTheme> ADAPTER = null;
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final ChatBackgroundEntity mbackground_entity;
    public final Scene mcomponent_scene;
    public final Map<String, String> mi18n_name;
    public final Long mid;
    public final String mname;
    public final ThemeType mtheme_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatTheme, Builder> {
        public ChatBackgroundEntity mbackground_entity;
        public Scene mcomponent_scene;
        public Map<String, String> mi18n_name;
        public Long mid;
        public String mname;
        public ThemeType mtheme_type;

        @Override // com.squareup.wire.Message.Builder
        public ChatTheme build() {
            return new ChatTheme(this.mcomponent_scene, this.mid, this.mbackground_entity, this.mname, this.mi18n_name, this.mtheme_type, super.buildUnknownFields());
        }

        public Builder() {
            this.mi18n_name = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder background_entity(ChatBackgroundEntity r100) {
            this.mbackground_entity = r100;
            return this;
        }

        public Builder component_scene(Scene r100) {
            this.mcomponent_scene = r100;
            return this;
        }

        public Builder i18n_name(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_name = r100;
            return this;
        }

        public Builder id(Long r100) {
            this.mid = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder theme_type(ThemeType r100) {
            this.mtheme_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatTheme extends ProtoAdapter<ChatTheme> {
        private final ProtoAdapter<Map<String, String>> mi18n_name;

        public ProtoAdapter_ChatTheme() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatTheme.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mi18n_name = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatTheme decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = 0L;
            r101.mname = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L21;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L23;
                default: goto L6;
            };
        L21:
            r101.mcomponent_scene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r101.mtheme_type = ThemeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.mi18n_name.putAll(this.mi18n_name.decode(r100));
            goto L3
        L12:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mbackground_entity = ChatBackgroundEntity.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.mid = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(ChatTheme r100) {
            Scene r101 = r100.mcomponent_scene;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Scene.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mid;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ChatBackgroundEntity r107 = r100.mbackground_entity;
            if (r107 == null) goto L13;
            int r108 = ChatBackgroundEntity.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mname;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = (r109 + r111) + this.mi18n_name.encodedSizeWithTag(5, r100.mi18n_name);
            ThemeType r113 = r100.mtheme_type;
            if (r113 == null) goto L22;
            r102 = ThemeType.ADAPTER.encodedSizeWithTag(6, r113);
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
        public /* bridge */ /* synthetic */ ChatTheme decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatTheme r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatTheme r101) throws IOException {
            Scene r102 = r101.mcomponent_scene;
            if (r102 == null) goto L5;
            Scene.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mid;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            ChatBackgroundEntity r104 = r101.mbackground_entity;
            if (r104 == null) goto L11;
            ChatBackgroundEntity.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mname;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            this.mi18n_name.encodeWithTag(r100, 5, r101.mi18n_name);
            ThemeType r106 = r101.mtheme_type;
            if (r106 == null) goto L17;
            ThemeType.ADAPTER.encodeWithTag(r100, 6, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatTheme r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene BRIGHT = null;
        public static final Scene DARK = null;
        public static final Scene DEFAULT_SCENE = null;
        private final int value;

        static {
            Scene r100 = new Scene("DEFAULT_SCENE", 0, 0);
            DEFAULT_SCENE = r100;
            Scene r101 = new Scene("DARK", 1, 1);
            DARK = r101;
            Scene r102 = new Scene("BRIGHT", 2, 2);
            BRIGHT = r102;
            $VALUES = new Scene[]{r100, r101, r102};
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
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return BRIGHT;
        L12:
            return DARK;
        L14:
            return DEFAULT_SCENE;
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        private Scene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ThemeType extends Enum<ThemeType> implements WireEnum {
        private static final /* synthetic */ ThemeType[] $VALUES = null;
        public static final ProtoAdapter<ThemeType> ADAPTER = null;
        public static final ThemeType CUSTOMIZE_THEME = null;
        public static final ThemeType SYSTEM_THEME = null;
        public static final ThemeType UNKNOWN_TYPE = null;
        private final int value;

        static {
            ThemeType r100 = new ThemeType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            ThemeType r101 = new ThemeType("SYSTEM_THEME", 1, 1);
            SYSTEM_THEME = r101;
            ThemeType r102 = new ThemeType("CUSTOMIZE_THEME", 2, 2);
            CUSTOMIZE_THEME = r102;
            $VALUES = new ThemeType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ThemeType.class);
        }

        public static ThemeType[] values() {
            return (ThemeType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ThemeType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CUSTOMIZE_THEME;
        L12:
            return SYSTEM_THEME;
        L14:
            return UNKNOWN_TYPE;
        }

        public static ThemeType valueOf(String r100) {
            return (ThemeType) a.a(ThemeType.class, r100);
        }

        private ThemeType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatTheme();
        DEFAULT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcomponent_scene = this.mcomponent_scene;
        r100.mid = this.mid;
        r100.mbackground_entity = this.mbackground_entity;
        r100.mname = this.mname;
        r100.mi18n_name = Internal.copyOf("mi18n_name", this.mi18n_name);
        r100.mtheme_type = this.mtheme_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatTheme.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatTheme(Scene r100, Long r110, ChatBackgroundEntity r111, String r112, Map<String, String> r113, ThemeType r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public ChatTheme(Scene r100, Long r101, ChatBackgroundEntity r102, String r103, Map<String, String> r104, ThemeType r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mcomponent_scene = r100;
        this.mid = r101;
        this.mbackground_entity = r102;
        this.mname = r103;
        this.mi18n_name = Internal.immutableCopyOf("mi18n_name", r104);
        this.mtheme_type = r105;
    }
}
