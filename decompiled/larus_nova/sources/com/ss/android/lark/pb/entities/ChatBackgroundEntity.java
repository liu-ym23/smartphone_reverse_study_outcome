package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatBackgroundEntity extends com.squareup.wire.Message<ChatBackgroundEntity, Builder> {
    public static final ProtoAdapter<ChatBackgroundEntity> ADAPTER = null;
    public static final String DEFAULT_FSUNIT = "";
    public static final String DEFAULT_IMAGE_KEY = "";
    private static final long serialVersionUID = 0;
    public final ColorInfo mcolor;
    public final String mfsunit;
    public final String mimage_key;
    public final BackgroundMode mmode;

    public static final enum BackgroundMode extends Enum<BackgroundMode> implements WireEnum {
        private static final /* synthetic */ BackgroundMode[] $VALUES = null;
        public static final ProtoAdapter<BackgroundMode> ADAPTER = null;
        public static final BackgroundMode COLOR_MODE = null;
        public static final BackgroundMode IMAGE_MODE = null;
        public static final BackgroundMode ORIGIN_MODE = null;
        private final int value;

        static {
            BackgroundMode r100 = new BackgroundMode("ORIGIN_MODE", 0, 0);
            ORIGIN_MODE = r100;
            BackgroundMode r101 = new BackgroundMode("COLOR_MODE", 1, 1);
            COLOR_MODE = r101;
            BackgroundMode r102 = new BackgroundMode("IMAGE_MODE", 2, 2);
            IMAGE_MODE = r102;
            $VALUES = new BackgroundMode[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(BackgroundMode.class);
        }

        public static BackgroundMode[] values() {
            return (BackgroundMode[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static BackgroundMode fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return IMAGE_MODE;
        L12:
            return COLOR_MODE;
        L14:
            return ORIGIN_MODE;
        }

        public static BackgroundMode valueOf(String r100) {
            return (BackgroundMode) a.a(BackgroundMode.class, r100);
        }

        private BackgroundMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatBackgroundEntity, Builder> {
        public ColorInfo mcolor;
        public String mfsunit;
        public String mimage_key;
        public BackgroundMode mmode;

        @Override // com.squareup.wire.Message.Builder
        public ChatBackgroundEntity build() {
            return new ChatBackgroundEntity(this.mmode, this.mcolor, this.mimage_key, this.mfsunit, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder color(ColorInfo r100) {
            this.mcolor = r100;
            return this;
        }

        public Builder fsunit(String r100) {
            this.mfsunit = r100;
            return this;
        }

        public Builder image_key(String r100) {
            this.mimage_key = r100;
            return this;
        }

        public Builder mode(BackgroundMode r100) {
            this.mmode = r100;
            return this;
        }
    }

    public static final class ColorInfo extends com.squareup.wire.Message<ColorInfo, Builder> {
        public static final ProtoAdapter<ColorInfo> ADAPTER = null;
        public static final Integer DEFAULT_DARK_COLOR = null;
        public static final Integer DEFAULT_LIGHT_COLOR = null;
        public static final String DEFAULT_UD_TOKEN = "";
        private static final long serialVersionUID = 0;
        public final Integer mdark_color;
        public final Integer mlight_color;
        public final String mud_token;

        public static final class Builder extends com.squareup.wire.Message.Builder<ColorInfo, Builder> {
            public Integer mdark_color;
            public Integer mlight_color;
            public String mud_token;

            @Override // com.squareup.wire.Message.Builder
            public ColorInfo build() {
                return new ColorInfo(this.mud_token, this.mlight_color, this.mdark_color, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder dark_color(Integer r100) {
                this.mdark_color = r100;
                return this;
            }

            public Builder light_color(Integer r100) {
                this.mlight_color = r100;
                return this;
            }

            public Builder ud_token(String r100) {
                this.mud_token = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ColorInfo extends ProtoAdapter<ColorInfo> {
            public ProtoAdapter_ColorInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ColorInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ColorInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mud_token = "";
                r101.mlight_color = 0;
                r101.mdark_color = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mud_token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mlight_color = ProtoAdapter.UINT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mdark_color = ProtoAdapter.UINT32.decode(r100);
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
            public int encodedSize2(ColorInfo r100) {
                String r101 = r100.mud_token;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.mlight_color;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.UINT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Integer r107 = r100.mdark_color;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.UINT32.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ ColorInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ColorInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ColorInfo r101) throws IOException {
                String r102 = r101.mud_token;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.mlight_color;
                if (r103 == null) goto L8;
                ProtoAdapter.UINT32.encodeWithTag(r100, 2, r103);
            L8:
                Integer r104 = r101.mdark_color;
                if (r104 == null) goto L11;
                ProtoAdapter.UINT32.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ColorInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ColorInfo();
            DEFAULT_LIGHT_COLOR = 0;
            DEFAULT_DARK_COLOR = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mud_token = this.mud_token;
            r100.mlight_color = this.mlight_color;
            r100.mdark_color = this.mdark_color;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ColorInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ColorInfo(String r100, Integer r101, Integer r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ColorInfo(String r100, Integer r101, Integer r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mud_token = r100;
            this.mlight_color = r101;
            this.mdark_color = r102;
        }
    }

    public static final class ProtoAdapter_ChatBackgroundEntity extends ProtoAdapter<ChatBackgroundEntity> {
        public ProtoAdapter_ChatBackgroundEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatBackgroundEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatBackgroundEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mimage_key = "";
            r101.mfsunit = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mmode = BackgroundMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mcolor = ColorInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mimage_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mfsunit = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ChatBackgroundEntity r100) {
            BackgroundMode r101 = r100.mmode;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = BackgroundMode.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            ColorInfo r104 = r100.mcolor;
            if (r104 == null) goto L9;
            int r105 = ColorInfo.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mimage_key;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mfsunit;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ ChatBackgroundEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatBackgroundEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatBackgroundEntity r101) throws IOException {
            BackgroundMode r102 = r101.mmode;
            if (r102 == null) goto L5;
            BackgroundMode.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ColorInfo r103 = r101.mcolor;
            if (r103 == null) goto L8;
            ColorInfo.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mimage_key;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mfsunit;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatBackgroundEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatBackgroundEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmode = this.mmode;
        r100.mcolor = this.mcolor;
        r100.mimage_key = this.mimage_key;
        r100.mfsunit = this.mfsunit;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatBackgroundEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatBackgroundEntity(BackgroundMode r100, ColorInfo r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ChatBackgroundEntity(BackgroundMode r100, ColorInfo r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mmode = r100;
        this.mcolor = r101;
        this.mimage_key = r102;
        this.mfsunit = r103;
    }
}
