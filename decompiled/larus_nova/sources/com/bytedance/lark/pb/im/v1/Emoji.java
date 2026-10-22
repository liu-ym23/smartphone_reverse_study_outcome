package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Emoji extends Message<Emoji, Builder> {
    public static final ProtoAdapter<Emoji> ADAPTER = null;
    public static final Integer DEFAULT_HEIGHT = null;
    public static final String DEFAULT_IMAGE_KEY = "";
    public static final Boolean DEFAULT_IS_DELETED = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_TEXT = "";
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final EasterEgg easter_egg;
    public final Integer height;
    public final String image_key;
    public final Boolean is_deleted;
    public final String key;
    public final List<String> skin_keys;
    public final String text;
    public final Integer width;

    public static final class Builder extends Message.Builder<Emoji, Builder> {
        public EasterEgg easter_egg;
        public Integer height;
        public String image_key;
        public Boolean is_deleted;
        public String key;
        public List<String> skin_keys;
        public String text;
        public Integer width;

        @Override // com.squareup.wire.Message.Builder
        public Emoji build() {
            return new Emoji(this.key, this.text, this.image_key, this.is_deleted, this.skin_keys, this.width, this.height, this.easter_egg, super.buildUnknownFields());
        }

        public Builder() {
            this.skin_keys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder easter_egg(EasterEgg r100) {
            this.easter_egg = r100;
            return this;
        }

        public Builder height(Integer r100) {
            this.height = r100;
            return this;
        }

        public Builder image_key(String r100) {
            this.image_key = r100;
            return this;
        }

        public Builder is_deleted(Boolean r100) {
            this.is_deleted = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder skin_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.skin_keys = r100;
            return this;
        }

        public Builder text(String r100) {
            this.text = r100;
            return this;
        }

        public Builder width(Integer r100) {
            this.width = r100;
            return this;
        }
    }

    public static final class EasterEgg extends Message<EasterEgg, Builder> {
        public static final ProtoAdapter<EasterEgg> ADAPTER = null;
        public static final String DEFAULT_ANIMATION_KEY = "";
        public static final AnimationType DEFAULT_ANIMATION_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String animation_key;
        public final AnimationType animation_type;
        public final Map<Integer, Integer> easter_egg_play_threshold;

        public static final enum AnimationType extends Enum<AnimationType> implements WireEnum {
            private static final /* synthetic */ AnimationType[] $VALUES = null;
            public static final ProtoAdapter<AnimationType> ADAPTER = null;
            public static final AnimationType ATMOSPHERELAYER = null;
            public static final AnimationType DEFAULT = null;
            public static final AnimationType UNKNOWN = null;
            private final int value;

            static {
                AnimationType r100 = new AnimationType("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                AnimationType r101 = new AnimationType("DEFAULT", 1, 1);
                DEFAULT = r101;
                AnimationType r102 = new AnimationType("ATMOSPHERELAYER", 2, 2);
                ATMOSPHERELAYER = r102;
                $VALUES = new AnimationType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(AnimationType.class);
            }

            public static AnimationType[] values() {
                return (AnimationType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static AnimationType fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return ATMOSPHERELAYER;
            L12:
                return DEFAULT;
            L14:
                return UNKNOWN;
            }

            public static AnimationType valueOf(String r100) {
                return (AnimationType) a.a(AnimationType.class, r100);
            }

            private AnimationType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class Builder extends Message.Builder<EasterEgg, Builder> {
            public String animation_key;
            public AnimationType animation_type;
            public Map<Integer, Integer> easter_egg_play_threshold;

            @Override // com.squareup.wire.Message.Builder
            public EasterEgg build() {
                return new EasterEgg(this.animation_key, this.easter_egg_play_threshold, this.animation_type, super.buildUnknownFields());
            }

            public Builder() {
                this.easter_egg_play_threshold = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder animation_key(String r100) {
                this.animation_key = r100;
                return this;
            }

            public Builder animation_type(AnimationType r100) {
                this.animation_type = r100;
                return this;
            }

            public Builder easter_egg_play_threshold(Map<Integer, Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.easter_egg_play_threshold = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_EasterEgg extends ProtoAdapter<EasterEgg> {
            private final ProtoAdapter<Map<Integer, Integer>> easter_egg_play_threshold;

            public ProtoAdapter_EasterEgg() {
                super(FieldEncoding.LENGTH_DELIMITED, EasterEgg.class);
                ProtoAdapter<Integer> r100 = ProtoAdapter.INT32;
                this.easter_egg_play_threshold = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EasterEgg decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.animation_key = "";
                r101.animation_type = AnimationType.UNKNOWN;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.animation_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.easter_egg_play_threshold.putAll(this.easter_egg_play_threshold.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.animation_type = AnimationType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
            public int encodedSize2(EasterEgg r100) {
                String r101 = r100.animation_key;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                int r104 = r103 + this.easter_egg_play_threshold.encodedSizeWithTag(2, r100.easter_egg_play_threshold);
                AnimationType r105 = r100.animation_type;
                if (r105 == null) goto L10;
                r102 = AnimationType.ADAPTER.encodedSizeWithTag(3, r105);
            L10:
                return (r104 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ EasterEgg decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(EasterEgg r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, EasterEgg r101) throws IOException {
                String r102 = r101.animation_key;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                this.easter_egg_play_threshold.encodeWithTag(r100, 2, r101.easter_egg_play_threshold);
                AnimationType r103 = r101.animation_type;
                if (r103 == null) goto L8;
                AnimationType.ADAPTER.encodeWithTag(r100, 3, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EasterEgg r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EasterEgg();
            DEFAULT_ANIMATION_TYPE = AnimationType.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.animation_key = this.animation_key;
            r100.easter_egg_play_threshold = Internal.copyOf("easter_egg_play_threshold", this.easter_egg_play_threshold);
            r100.animation_type = this.animation_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return EasterEgg.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public EasterEgg(String r100, Map<Integer, Integer> r101, AnimationType r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public EasterEgg(String r100, Map<Integer, Integer> r101, AnimationType r102, ByteString r103) {
            super(ADAPTER, r103);
            this.animation_key = r100;
            this.easter_egg_play_threshold = Internal.immutableCopyOf("easter_egg_play_threshold", r101);
            this.animation_type = r102;
        }
    }

    public static final class ProtoAdapter_Emoji extends ProtoAdapter<Emoji> {
        public ProtoAdapter_Emoji() {
            super(FieldEncoding.LENGTH_DELIMITED, Emoji.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Emoji decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.text = "";
            r101.image_key = "";
            r101.is_deleted = Boolean.FALSE;
            r101.width = 0;
            r101.height = 0;
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
            r101.easter_egg = EasterEgg.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.height = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.width = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.skin_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.is_deleted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.image_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.key = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(Emoji r100) {
            String r101 = r100.key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.text;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.image_key;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_deleted;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = (r109 + r111) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, r100.skin_keys);
            Integer r113 = r100.width;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(6, r113);
        L22:
            int r115 = r112 + r114;
            Integer r116 = r100.height;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(7, r116);
        L26:
            int r118 = r115 + r117;
            EasterEgg r119 = r100.easter_egg;
            if (r119 == null) goto L30;
            r102 = EasterEgg.ADAPTER.encodedSizeWithTag(8, r119);
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
        public /* bridge */ /* synthetic */ Emoji decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Emoji r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Emoji r101) throws IOException {
            String r102 = r101.key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.text;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.image_key;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.is_deleted;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 5, r101.skin_keys);
            Integer r106 = r101.width;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r106);
        L17:
            Integer r107 = r101.height;
            if (r107 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r107);
        L20:
            EasterEgg r108 = r101.easter_egg;
            if (r108 == null) goto L23;
            EasterEgg.ADAPTER.encodeWithTag(r100, 8, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Emoji r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Emoji();
        DEFAULT_IS_DELETED = Boolean.FALSE;
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.text = this.text;
        r100.image_key = this.image_key;
        r100.is_deleted = this.is_deleted;
        r100.skin_keys = Internal.copyOf("skin_keys", this.skin_keys);
        r100.width = this.width;
        r100.height = this.height;
        r100.easter_egg = this.easter_egg;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Emoji.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Emoji(String r110, String r111, String r112, Boolean r113, List<String> r114, Integer r115, Integer r116, EasterEgg r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public Emoji(String r100, String r101, String r102, Boolean r103, List<String> r104, Integer r105, Integer r106, EasterEgg r107, ByteString r110) {
        super(ADAPTER, r110);
        this.key = r100;
        this.text = r101;
        this.image_key = r102;
        this.is_deleted = r103;
        this.skin_keys = Internal.immutableCopyOf("skin_keys", r104);
        this.width = r105;
        this.height = r106;
        this.easter_egg = r107;
    }
}
