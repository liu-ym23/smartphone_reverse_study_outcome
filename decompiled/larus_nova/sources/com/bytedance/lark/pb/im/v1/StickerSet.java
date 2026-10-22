package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Image;
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
public final class StickerSet extends Message<StickerSet, Builder> {
    public static final ProtoAdapter<StickerSet> ADAPTER = null;
    public static final String DEFAULT_AUTHOR_ID = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Boolean DEFAULT_HAS_PAID = null;
    public static final Perm DEFAULT_PERM = null;
    public static final String DEFAULT_STICKER_SET_ID = "";
    public static final String DEFAULT_TITLE = "";
    public static final StickerSetType DEFAULT_TYPE = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final Integer DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Archive archive;
    public final String author_id;
    public final Image cover;
    public final String description;
    public final Boolean has_paid;
    public final Image icon;
    public final Perm perm;
    public final Image preview;
    public final String sticker_set_id;
    public final List<Sticker> stickers;
    public final String title;
    public final StickerSetType type;
    public final Long update_time;
    public final Integer version;

    public static final class Builder extends Message.Builder<StickerSet, Builder> {
        public Archive archive;
        public String author_id;
        public Image cover;
        public String description;
        public Boolean has_paid;
        public Image icon;
        public Perm perm;
        public Image preview;
        public String sticker_set_id;
        public List<Sticker> stickers;
        public String title;
        public StickerSetType type;
        public Long update_time;
        public Integer version;

        @Override // com.squareup.wire.Message.Builder
        public StickerSet build() {
            String r100 = this.sticker_set_id;
            if (r100 == null) goto L7;
            return new StickerSet(this.sticker_set_id, this.type, this.author_id, this.cover, this.preview, this.icon, this.version, this.update_time, this.title, this.description, this.stickers, this.archive, this.perm, this.has_paid, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "sticker_set_id"});
        }

        public Builder() {
            this.stickers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder archive(Archive r100) {
            this.archive = r100;
            return this;
        }

        public Builder author_id(String r100) {
            this.author_id = r100;
            return this;
        }

        public Builder cover(Image r100) {
            this.cover = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder has_paid(Boolean r100) {
            this.has_paid = r100;
            return this;
        }

        public Builder icon(Image r100) {
            this.icon = r100;
            return this;
        }

        public Builder perm(Perm r100) {
            this.perm = r100;
            return this;
        }

        public Builder preview(Image r100) {
            this.preview = r100;
            return this;
        }

        public Builder sticker_set_id(String r100) {
            this.sticker_set_id = r100;
            return this;
        }

        public Builder stickers(List<Sticker> r100) {
            Internal.checkElementsNotNull(r100);
            this.stickers = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder type(StickerSetType r100) {
            this.type = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }

        public Builder version(Integer r100) {
            this.version = r100;
            return this;
        }
    }

    public static final enum Perm extends Enum<Perm> implements WireEnum {
        private static final /* synthetic */ Perm[] $VALUES = null;
        public static final ProtoAdapter<Perm> ADAPTER = null;
        public static final Perm ALONE = null;
        public static final Perm OWN = null;
        public static final Perm UNKNOWN = null;
        private final int value;

        static {
            Perm r100 = new Perm("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Perm r101 = new Perm("ALONE", 1, 1);
            ALONE = r101;
            Perm r102 = new Perm("OWN", 2, 2);
            OWN = r102;
            $VALUES = new Perm[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Perm.class);
        }

        public static Perm[] values() {
            return (Perm[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Perm fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return OWN;
        L12:
            return ALONE;
        L14:
            return UNKNOWN;
        }

        public static Perm valueOf(String r100) {
            return (Perm) a.a(Perm.class, r100);
        }

        private Perm(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_StickerSet extends ProtoAdapter<StickerSet> {
        public ProtoAdapter_StickerSet() {
            super(FieldEncoding.LENGTH_DELIMITED, StickerSet.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public StickerSet decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sticker_set_id = "";
            r101.type = StickerSetType.UNKNOWN_STICKER_SET_TYPE;
            r101.author_id = "";
            r101.version = 0;
            r101.update_time = 0L;
            r101.title = "";
            r101.description = "";
            r101.perm = Perm.UNKNOWN;
            r101.has_paid = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            switch(r103) {
                case 1: goto L26;
                case 2: goto L29;
                case 3: goto L21;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L17;
                case 8: goto L16;
                case 9: goto L15;
                case 10: goto L14;
                case 11: goto L13;
                case 12: goto L12;
                case 13: goto L31;
                case 14: goto L7;
                default: goto L6;
            };
        L29:
            r101.type = StickerSetType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L31:
            r101.perm = Perm.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.has_paid = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.archive = Archive.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.stickers.add(Sticker.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            r101.version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L18:
            r101.icon = Image.ADAPTER.decode(r100);
            goto L3
        L19:
            r101.preview = Image.ADAPTER.decode(r100);
            goto L3
        L20:
            r101.cover = Image.ADAPTER.decode(r100);
            goto L3
        L21:
            r101.author_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L26:
            r101.sticker_set_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(StickerSet r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.sticker_set_id);
            StickerSetType r103 = r100.type;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = StickerSetType.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.author_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Image r110 = r100.cover;
            if (r110 == null) goto L13;
            int r111 = Image.ADAPTER.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Image r113 = r100.preview;
            if (r113 == null) goto L17;
            int r114 = Image.ADAPTER.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Image r116 = r100.icon;
            if (r116 == null) goto L21;
            int r117 = Image.ADAPTER.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            Integer r119 = r100.version;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            Long r122 = r100.update_time;
            if (r122 == null) goto L29;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.title;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(9, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.description;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(10, r128);
        L38:
            int r130 = (r127 + r129) + Sticker.ADAPTER.asRepeated().encodedSizeWithTag(11, r100.stickers);
            Archive r131 = r100.archive;
            if (r131 == null) goto L41;
            int r132 = Archive.ADAPTER.encodedSizeWithTag(12, r131);
        L42:
            int r133 = r130 + r132;
            Perm r134 = r100.perm;
            if (r134 == null) goto L45;
            int r135 = Perm.ADAPTER.encodedSizeWithTag(13, r134);
        L46:
            int r136 = r133 + r135;
            Boolean r137 = r100.has_paid;
            if (r137 == null) goto L50;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r137);
        L50:
            return (r136 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ StickerSet decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StickerSet r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, StickerSet r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.sticker_set_id);
            StickerSetType r103 = r101.type;
            if (r103 == null) goto L5;
            StickerSetType.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.author_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            Image r105 = r101.cover;
            if (r105 == null) goto L11;
            Image.ADAPTER.encodeWithTag(r100, 4, r105);
        L11:
            Image r106 = r101.preview;
            if (r106 == null) goto L14;
            Image.ADAPTER.encodeWithTag(r100, 5, r106);
        L14:
            Image r107 = r101.icon;
            if (r107 == null) goto L17;
            Image.ADAPTER.encodeWithTag(r100, 6, r107);
        L17:
            Integer r108 = r101.version;
            if (r108 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
        L20:
            Long r109 = r101.update_time;
            if (r109 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r109);
        L23:
            String r110 = r101.title;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 9, r110);
        L26:
            String r111 = r101.description;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 10, r111);
        L29:
            Sticker.ADAPTER.asRepeated().encodeWithTag(r100, 11, r101.stickers);
            Archive r112 = r101.archive;
            if (r112 == null) goto L32;
            Archive.ADAPTER.encodeWithTag(r100, 12, r112);
        L32:
            Perm r113 = r101.perm;
            if (r113 == null) goto L35;
            Perm.ADAPTER.encodeWithTag(r100, 13, r113);
        L35:
            Boolean r114 = r101.has_paid;
            if (r114 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r114);
        L38:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StickerSet r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StickerSet();
        DEFAULT_TYPE = StickerSetType.UNKNOWN_STICKER_SET_TYPE;
        DEFAULT_VERSION = 0;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_PERM = Perm.UNKNOWN;
        DEFAULT_HAS_PAID = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.sticker_set_id = this.sticker_set_id;
        r100.type = this.type;
        r100.author_id = this.author_id;
        r100.cover = this.cover;
        r100.preview = this.preview;
        r100.icon = this.icon;
        r100.version = this.version;
        r100.update_time = this.update_time;
        r100.title = this.title;
        r100.description = this.description;
        r100.stickers = Internal.copyOf("stickers", this.stickers);
        r100.archive = this.archive;
        r100.perm = this.perm;
        r100.has_paid = this.has_paid;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return StickerSet.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public StickerSet(String r110, StickerSetType r111, String r112, Image r210, Image r211, Image r212, Integer r213, Long r214, String r215, String r216, List<Sticker> r217, Archive r218, Perm r219, Boolean r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public StickerSet(String r100, StickerSetType r101, String r102, Image r103, Image r104, Image r105, Integer r110, Long r111, String r112, String r113, List<Sticker> r114, Archive r115, Perm r116, Boolean r117, ByteString r118) {
        super(ADAPTER, r118);
        this.sticker_set_id = r100;
        this.type = r101;
        this.author_id = r102;
        this.cover = r103;
        this.preview = r104;
        this.icon = r105;
        this.version = r110;
        this.update_time = r111;
        this.title = r112;
        this.description = r113;
        this.stickers = Internal.immutableCopyOf("stickers", r114);
        this.archive = r115;
        this.perm = r116;
        this.has_paid = r117;
    }
}
