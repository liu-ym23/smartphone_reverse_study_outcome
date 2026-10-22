package com.bytedance.lark.pb.basic.v1;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.squareup.wire.FieldEncoding;
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
public final class Doc extends com.squareup.wire.Message<Doc, Builder> {
    public static final ProtoAdapter<Doc> ADAPTER = null;
    public static final String DEFAULT_ABSTRACT_ = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_ICON_KEY = "";
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_OWNER_ID = null;
    public static final String DEFAULT_OWNER_NAME = "";
    public static final Type DEFAULT_TYPE = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final String abstract_;
    public final Long create_time;
    public final Icon icon;
    public final String icon_key;
    public final String key;
    public final String name;
    public final Long owner_id;
    public final String owner_name;
    public final List<Tag> tags;
    public final Type type;
    public final Long update_time;
    public final String url;

    public static final class Builder extends com.squareup.wire.Message.Builder<Doc, Builder> {
        public String abstract_;
        public Long create_time;
        public Icon icon;
        public String icon_key;
        public String key;
        public String name;
        public Long owner_id;
        public String owner_name;
        public List<Tag> tags;
        public Type type;
        public Long update_time;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public Doc build() {
            return new Doc(this.key, this.url, this.type, this.name, this.icon_key, this.abstract_, this.create_time, this.update_time, this.owner_name, this.owner_id, this.icon, this.tags, super.buildUnknownFields());
        }

        public Builder() {
            this.tags = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder abstract_(String r100) {
            this.abstract_ = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder icon(Icon r100) {
            this.icon = r100;
            return this;
        }

        public Builder icon_key(String r100) {
            this.icon_key = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder owner_id(Long r100) {
            this.owner_id = r100;
            return this;
        }

        public Builder owner_name(String r100) {
            this.owner_name = r100;
            return this;
        }

        public Builder tags(List<Tag> r100) {
            Internal.checkElementsNotNull(r100);
            this.tags = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Doc extends ProtoAdapter<Doc> {
        public ProtoAdapter_Doc() {
            super(FieldEncoding.LENGTH_DELIMITED, Doc.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Doc decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.url = "";
            r101.type = Type.UNKNOWN;
            r101.name = "";
            r101.icon_key = "";
            r101.abstract_ = "";
            r101.create_time = 0L;
            r101.update_time = 0L;
            r101.owner_name = "";
            r101.owner_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L25;
            switch(r103) {
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L29;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                case 12: goto L27;
                default: goto L6;
            };
        L27:
            r101.tags.add(Tag.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L29:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.icon = Icon.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.owner_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            r101.owner_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.abstract_ = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.icon_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L25:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Doc r100) {
            String r101 = r100.key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.url;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Type r107 = r100.type;
            if (r107 == null) goto L13;
            int r108 = Type.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.name;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.icon_key;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.abstract_;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.create_time;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Long r122 = r100.update_time;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.owner_name;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Long r128 = r100.owner_id;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.INT64.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            Icon r131 = r100.icon;
            if (r131 == null) goto L46;
            r102 = Icon.ADAPTER.encodedSizeWithTag(11, r131);
        L46:
            return ((r130 + r102) + Tag.ADAPTER.asRepeated().encodedSizeWithTag(12, r100.tags)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Doc decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Doc r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Doc r101) throws IOException {
            String r102 = r101.key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.url;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Type r104 = r101.type;
            if (r104 == null) goto L11;
            Type.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.name;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.icon_key;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.abstract_;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.create_time;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L23:
            Long r109 = r101.update_time;
            if (r109 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.owner_name;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            Long r111 = r101.owner_id;
            if (r111 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 10, r111);
        L32:
            Icon r112 = r101.icon;
            if (r112 == null) goto L35;
            Icon.ADAPTER.encodeWithTag(r100, 11, r112);
        L35:
            Tag.ADAPTER.asRepeated().encodeWithTag(r100, 12, r101.tags);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Doc r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type BITABLE = null;
        public static final Type CATALOG = null;
        public static final Type DOC = null;
        public static final Type DOCX = null;
        public static final Type DOCX_SYNCED_BLOCK = null;
        public static final Type FILE = null;
        public static final Type FOLDER = null;
        public static final Type MIAODA = null;
        public static final Type MIAODA_APP_DEVELOPMENT = null;
        public static final Type MINDNOTE = null;
        public static final Type SHEET = null;
        public static final Type SHORTCUT = null;
        public static final Type SLIDE = null;
        public static final Type SLIDES = null;
        public static final Type UNKNOWN = null;
        public static final Type WIKI = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, 1);
            DOC = r101;
            Type r102 = new Type("SHEET", 2, 2);
            SHEET = r102;
            Type r103 = new Type("BITABLE", 3, 3);
            BITABLE = r103;
            Type r104 = new Type(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, 4, 4);
            MINDNOTE = r104;
            Type r105 = new Type("FILE", 5, 5);
            FILE = r105;
            Type r110 = new Type("SLIDE", 6, 6);
            SLIDE = r110;
            Type r111 = new Type("WIKI", 7, 7);
            WIKI = r111;
            Type r112 = new Type(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 8, 8);
            DOCX = r112;
            Type r113 = new Type("FOLDER", 9, 9);
            FOLDER = r113;
            Type r114 = new Type("CATALOG", 10, 10);
            CATALOG = r114;
            Type r115 = new Type("SLIDES", 11, 11);
            SLIDES = r115;
            Type r106 = new Type("SHORTCUT", 12, 12);
            SHORTCUT = r106;
            Type r107 = new Type("DOCX_SYNCED_BLOCK", 13, 13);
            DOCX_SYNCED_BLOCK = r107;
            Type r108 = new Type("MIAODA", 14, 14);
            MIAODA = r108;
            Type r109 = new Type("MIAODA_APP_DEVELOPMENT", 15, 15);
            MIAODA_APP_DEVELOPMENT = r109;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109};
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
            switch(r100) {
                case 0: goto L36;
                case 1: goto L34;
                case 2: goto L32;
                case 3: goto L30;
                case 4: goto L28;
                case 5: goto L26;
                case 6: goto L24;
                case 7: goto L22;
                case 8: goto L20;
                case 9: goto L18;
                case 10: goto L16;
                case 11: goto L14;
                case 12: goto L12;
                case 13: goto L10;
                case 14: goto L8;
                case 15: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return MIAODA_APP_DEVELOPMENT;
        L8:
            return MIAODA;
        L10:
            return DOCX_SYNCED_BLOCK;
        L12:
            return SHORTCUT;
        L14:
            return SLIDES;
        L16:
            return CATALOG;
        L18:
            return FOLDER;
        L20:
            return DOCX;
        L22:
            return WIKI;
        L24:
            return SLIDE;
        L26:
            return FILE;
        L28:
            return MINDNOTE;
        L30:
            return BITABLE;
        L32:
            return SHEET;
        L34:
            return DOC;
        L36:
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
        ADAPTER = new ProtoAdapter_Doc();
        DEFAULT_TYPE = Type.UNKNOWN;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_OWNER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.url = this.url;
        r100.type = this.type;
        r100.name = this.name;
        r100.icon_key = this.icon_key;
        r100.abstract_ = this.abstract_;
        r100.create_time = this.create_time;
        r100.update_time = this.update_time;
        r100.owner_name = this.owner_name;
        r100.owner_id = this.owner_id;
        r100.icon = this.icon;
        r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Doc.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Doc(String r110, String r111, Type r112, String r113, String r114, String r210, Long r211, Long r212, String r213, Long r214, Icon r215, List<Tag> r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public Doc(String r100, String r101, Type r102, String r103, String r104, String r105, Long r106, Long r107, String r110, Long r111, Icon r112, List<Tag> r113, ByteString r114) {
        super(ADAPTER, r114);
        this.key = r100;
        this.url = r101;
        this.type = r102;
        this.name = r103;
        this.icon_key = r104;
        this.abstract_ = r105;
        this.create_time = r106;
        this.update_time = r107;
        this.owner_name = r110;
        this.owner_id = r111;
        this.icon = r112;
        this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r113);
    }
}
