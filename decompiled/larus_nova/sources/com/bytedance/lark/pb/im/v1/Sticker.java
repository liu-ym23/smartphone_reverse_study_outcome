package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Sticker extends Message<Sticker, Builder> {
    public static final ProtoAdapter<Sticker> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Boolean DEFAULT_HAS_PAID = null;
    public static final Mode DEFAULT_MODE = null;
    public static final Integer DEFAULT_POSITION = null;
    public static final String DEFAULT_SMALL_URL = "";
    public static final String DEFAULT_STICKER_ID = "";
    public static final String DEFAULT_STICKER_SET_ID = "";
    private static final long serialVersionUID = 0;
    public final String description;
    public final Boolean has_paid;
    public final ImageSet image;
    public final Mode mode;
    public final Integer position;
    public final String small_url;
    public final String sticker_id;
    public final String sticker_set_id;

    public static final class Builder extends Message.Builder<Sticker, Builder> {
        public String description;
        public Boolean has_paid;
        public ImageSet image;
        public Mode mode;
        public Integer position;
        public String small_url;
        public String sticker_id;
        public String sticker_set_id;

        @Override // com.squareup.wire.Message.Builder
        public Sticker build() {
            return new Sticker(this.position, this.image, this.description, this.mode, this.has_paid, this.sticker_set_id, this.sticker_id, this.small_url, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder has_paid(Boolean r100) {
            this.has_paid = r100;
            return this;
        }

        public Builder image(ImageSet r100) {
            this.image = r100;
            return this;
        }

        public Builder mode(Mode r100) {
            this.mode = r100;
            return this;
        }

        public Builder position(Integer r100) {
            this.position = r100;
            return this;
        }

        public Builder small_url(String r100) {
            this.small_url = r100;
            return this;
        }

        public Builder sticker_id(String r100) {
            this.sticker_id = r100;
            return this;
        }

        public Builder sticker_set_id(String r100) {
            this.sticker_set_id = r100;
            return this;
        }
    }

    public static final enum Mode extends Enum<Mode> implements WireEnum {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final ProtoAdapter<Mode> ADAPTER = null;
        public static final Mode MEME = null;
        public static final Mode STICKER = null;
        public static final Mode UNKNOWN = null;
        private final int value;

        static {
            Mode r100 = new Mode("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Mode r101 = new Mode("STICKER", 1, 1);
            STICKER = r101;
            Mode r102 = new Mode("MEME", 2, 2);
            MEME = r102;
            $VALUES = new Mode[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Mode.class);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Mode fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return MEME;
        L12:
            return STICKER;
        L14:
            return UNKNOWN;
        }

        public static Mode valueOf(String r100) {
            return (Mode) a.a(Mode.class, r100);
        }

        private Mode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_Sticker extends ProtoAdapter<Sticker> {
        public ProtoAdapter_Sticker() {
            super(FieldEncoding.LENGTH_DELIMITED, Sticker.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Sticker decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.position = 0;
            r101.description = "";
            r101.mode = Mode.UNKNOWN;
            r101.has_paid = Boolean.FALSE;
            r101.sticker_set_id = "";
            r101.sticker_id = "";
            r101.small_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L20;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.mode = Mode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.small_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.sticker_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.sticker_set_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.has_paid = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.image = ImageSet.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.position = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(Sticker r100) {
            Integer r101 = r100.position;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            ImageSet r104 = r100.image;
            if (r104 == null) goto L9;
            int r105 = ImageSet.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.description;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Mode r110 = r100.mode;
            if (r110 == null) goto L17;
            int r111 = Mode.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.has_paid;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.sticker_set_id;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.sticker_id;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.small_url;
            if (r122 == null) goto L34;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
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
        public /* bridge */ /* synthetic */ Sticker decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Sticker r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Sticker r101) throws IOException {
            Integer r102 = r101.position;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            ImageSet r103 = r101.image;
            if (r103 == null) goto L8;
            ImageSet.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.description;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Mode r105 = r101.mode;
            if (r105 == null) goto L14;
            Mode.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.has_paid;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.sticker_set_id;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.sticker_id;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.small_url;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Sticker r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Sticker();
        DEFAULT_POSITION = 0;
        DEFAULT_MODE = Mode.UNKNOWN;
        DEFAULT_HAS_PAID = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.position = this.position;
        r100.image = this.image;
        r100.description = this.description;
        r100.mode = this.mode;
        r100.has_paid = this.has_paid;
        r100.sticker_set_id = this.sticker_set_id;
        r100.sticker_id = this.sticker_id;
        r100.small_url = this.small_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Sticker.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Sticker(Integer r110, ImageSet r111, String r112, Mode r113, Boolean r114, String r115, String r116, String r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public Sticker(Integer r100, ImageSet r101, String r102, Mode r103, Boolean r104, String r105, String r106, String r107, ByteString r110) {
        super(ADAPTER, r110);
        this.position = r100;
        this.image = r101;
        this.description = r102;
        this.mode = r103;
        this.has_paid = r104;
        this.sticker_set_id = r105;
        this.sticker_id = r106;
        this.small_url = r107;
    }
}
