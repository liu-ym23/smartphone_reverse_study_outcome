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
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class EmojiPanel extends Message<EmojiPanel, Builder> {
    public static final ProtoAdapter<EmojiPanel> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Emojis> emojis_order;

    public static final class Builder extends Message.Builder<EmojiPanel, Builder> {
        public List<Emojis> emojis_order;

        @Override // com.squareup.wire.Message.Builder
        public EmojiPanel build() {
            return new EmojiPanel(this.emojis_order, super.buildUnknownFields());
        }

        public Builder() {
            this.emojis_order = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder emojis_order(List<Emojis> r100) {
            Internal.checkElementsNotNull(r100);
            this.emojis_order = r100;
            return this;
        }
    }

    public static final class Emojis extends Message<Emojis, Builder> {
        public static final ProtoAdapter<Emojis> ADAPTER = null;
        public static final String DEFAULT_ICON_KEY = "";
        public static final String DEFAULT_SOURCE = "";
        public static final String DEFAULT_TITLE = "";
        public static final Type DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String icon_key;
        public final List<EmojiKey> keys;
        public final String source;
        public final String title;
        public final Type type;

        public static final class Builder extends Message.Builder<Emojis, Builder> {
            public String icon_key;
            public List<EmojiKey> keys;
            public String source;
            public String title;
            public Type type;

            @Override // com.squareup.wire.Message.Builder
            public Emojis build() {
                return new Emojis(this.type, this.icon_key, this.title, this.source, this.keys, super.buildUnknownFields());
            }

            public Builder() {
                this.keys = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder icon_key(String r100) {
                this.icon_key = r100;
                return this;
            }

            public Builder keys(List<EmojiKey> r100) {
                Internal.checkElementsNotNull(r100);
                this.keys = r100;
                return this;
            }

            public Builder source(String r100) {
                this.source = r100;
                return this;
            }

            public Builder title(String r100) {
                this.title = r100;
                return this;
            }

            public Builder type(Type r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class EmojiKey extends Message<EmojiKey, Builder> {
            public static final ProtoAdapter<EmojiKey> ADAPTER = null;
            public static final String DEFAULT_KEY = "";
            public static final String DEFAULT_SELECTED_SKIN_KEY = "";
            private static final long serialVersionUID = 0;
            public final String key;
            public final String selected_skin_key;

            public static final class Builder extends Message.Builder<EmojiKey, Builder> {
                public String key;
                public String selected_skin_key;

                @Override // com.squareup.wire.Message.Builder
                public EmojiKey build() {
                    return new EmojiKey(this.key, this.selected_skin_key, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder key(String r100) {
                    this.key = r100;
                    return this;
                }

                public Builder selected_skin_key(String r100) {
                    this.selected_skin_key = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_EmojiKey extends ProtoAdapter<EmojiKey> {
                public ProtoAdapter_EmojiKey() {
                    super(FieldEncoding.LENGTH_DELIMITED, EmojiKey.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public EmojiKey decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.key = "";
                    r101.selected_skin_key = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L12;
                    if (r103 != 1) goto L8;
                    r101.key = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.selected_skin_key = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(EmojiKey r100) {
                    String r101 = r100.key;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    String r104 = r100.selected_skin_key;
                    if (r104 == null) goto L10;
                    r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                L10:
                    return (r103 + r102) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ EmojiKey decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(EmojiKey r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, EmojiKey r101) throws IOException {
                    String r102 = r101.key;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    String r103 = r101.selected_skin_key;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                L8:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EmojiKey r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_EmojiKey();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.key = this.key;
                r100.selected_skin_key = this.selected_skin_key;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return EmojiKey.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public EmojiKey(String r100, String r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public EmojiKey(String r100, String r101, ByteString r102) {
                super(ADAPTER, r102);
                this.key = r100;
                this.selected_skin_key = r101;
            }
        }

        public static final class ProtoAdapter_Emojis extends ProtoAdapter<Emojis> {
            public ProtoAdapter_Emojis() {
                super(FieldEncoding.LENGTH_DELIMITED, Emojis.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Emojis decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = Type.UNKNOWN;
                r101.icon_key = "";
                r101.title = "";
                r101.source = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.icon_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.source = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.keys.add(EmojiKey.ADAPTER.decode(r100));
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L24:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Emojis r100) {
                Type r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.icon_key;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.title;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.source;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                return ((r109 + r102) + EmojiKey.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.keys)) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Emojis decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Emojis r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Emojis r101) throws IOException {
                Type r102 = r101.type;
                if (r102 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.icon_key;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.title;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.source;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                EmojiKey.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.keys);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Emojis r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Emojis();
            DEFAULT_TYPE = Type.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.icon_key = this.icon_key;
            r100.title = this.title;
            r100.source = this.source;
            r100.keys = Internal.copyOf("keys", this.keys);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Emojis.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Emojis(Type r100, String r101, String r110, String r111, List<EmojiKey> r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public Emojis(Type r100, String r101, String r102, String r103, List<EmojiKey> r104, ByteString r105) {
            super(ADAPTER, r105);
            this.type = r100;
            this.icon_key = r101;
            this.title = r102;
            this.source = r103;
            this.keys = Internal.immutableCopyOf("keys", r104);
        }
    }

    public static final class ProtoAdapter_EmojiPanel extends ProtoAdapter<EmojiPanel> {
        public ProtoAdapter_EmojiPanel() {
            super(FieldEncoding.LENGTH_DELIMITED, EmojiPanel.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EmojiPanel decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.emojis_order.add(Emojis.ADAPTER.decode(r100));
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
        public int encodedSize2(EmojiPanel r100) {
            return Emojis.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.emojis_order) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EmojiPanel decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EmojiPanel r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EmojiPanel r101) throws IOException {
            Emojis.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.emojis_order);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EmojiPanel r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type CUSTOM = null;
        public static final Type DEFAULT = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("DEFAULT", 1, 1);
            DEFAULT = r101;
            Type r102 = new Type("CUSTOM", 2, 2);
            CUSTOM = r102;
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
            return CUSTOM;
        L12:
            return DEFAULT;
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
        ADAPTER = new ProtoAdapter_EmojiPanel();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.emojis_order = Internal.copyOf("emojis_order", this.emojis_order);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EmojiPanel.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EmojiPanel(List<Emojis> r100) {
        this(r100, ByteString.EMPTY);
    }

    public EmojiPanel(List<Emojis> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.emojis_order = Internal.immutableCopyOf("emojis_order", r100);
    }
}
