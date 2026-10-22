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
public final class DocFeed extends com.squareup.wire.Message<DocFeed, Builder> {
    public static final ProtoAdapter<DocFeed> ADAPTER = null;
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_DOC_URL = "";
    public static final FeedCard.FeedType DEFAULT_FEED_TYPE = null;
    public static final String DEFAULT_ICON_INFO = "";
    public static final String DEFAULT_ICON_KEY = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_DELETED = null;
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Boolean DEFAULT_IS_SHORTCUT = null;
    public static final Integer DEFAULT_NEW_MESSAGE_COUNT = null;
    public static final String DEFAULT_OWNER_ID = "";
    public static final String DEFAULT_TITLE = "";
    public static final Type DEFAULT_TYPE = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final Long create_time;
    public final List<String> doc_message_ids;
    public final String doc_url;
    public final FeedCard.FeedType feed_type;
    public final String icon_info;
    public final String icon_key;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253479id;
    public final Boolean is_cross_tenant;
    public final Boolean is_deleted;
    public final Boolean is_remind;
    public final Boolean is_shortcut;
    public final Integer new_message_count;
    public final String owner_id;
    public final List<Tag> tags;
    public final String title;
    public final Type type;
    public final Long update_time;

    public static final class Builder extends com.squareup.wire.Message.Builder<DocFeed, Builder> {
        public Long create_time;
        public List<String> doc_message_ids;
        public String doc_url;
        public FeedCard.FeedType feed_type;
        public String icon_info;
        public String icon_key;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253480id;
        public Boolean is_cross_tenant;
        public Boolean is_deleted;
        public Boolean is_remind;
        public Boolean is_shortcut;
        public Integer new_message_count;
        public String owner_id;
        public List<Tag> tags;
        public String title;
        public Type type;
        public Long update_time;

        @Override // com.squareup.wire.Message.Builder
        public DocFeed build() {
            String r100 = this.f253480id;
            if (r100 == null) goto L7;
            return new DocFeed(this.f253480id, this.title, this.type, this.icon_key, this.doc_url, this.create_time, this.update_time, this.owner_id, this.new_message_count, this.doc_message_ids, this.is_deleted, this.is_remind, this.feed_type, this.is_cross_tenant, this.is_shortcut, this.tags, this.icon_info, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
            this.doc_message_ids = Internal.newMutableList();
            this.tags = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder doc_message_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.doc_message_ids = r100;
            return this;
        }

        public Builder doc_url(String r100) {
            this.doc_url = r100;
            return this;
        }

        public Builder feed_type(FeedCard.FeedType r100) {
            this.feed_type = r100;
            return this;
        }

        public Builder icon_info(String r100) {
            this.icon_info = r100;
            return this;
        }

        public Builder icon_key(String r100) {
            this.icon_key = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253480id = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.is_cross_tenant = r100;
            return this;
        }

        public Builder is_deleted(Boolean r100) {
            this.is_deleted = r100;
            return this;
        }

        public Builder is_remind(Boolean r100) {
            this.is_remind = r100;
            return this;
        }

        public Builder is_shortcut(Boolean r100) {
            this.is_shortcut = r100;
            return this;
        }

        public Builder new_message_count(Integer r100) {
            this.new_message_count = r100;
            return this;
        }

        public Builder owner_id(String r100) {
            this.owner_id = r100;
            return this;
        }

        public Builder tags(List<Tag> r100) {
            Internal.checkElementsNotNull(r100);
            this.tags = r100;
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

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DocFeed extends ProtoAdapter<DocFeed> {
        public ProtoAdapter_DocFeed() {
            super(FieldEncoding.LENGTH_DELIMITED, DocFeed.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DocFeed decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253480id = "";
            r101.title = "";
            r101.type = Type.DOC;
            r101.icon_key = "";
            r101.doc_url = "";
            r101.create_time = 0L;
            r101.update_time = 0L;
            r101.owner_id = "";
            r101.new_message_count = 0;
            Boolean r102 = Boolean.FALSE;
            r101.is_deleted = r102;
            r101.is_remind = r102;
            r101.feed_type = FeedCard.FeedType.INBOX;
            r101.is_cross_tenant = r102;
            r101.is_shortcut = r102;
            r101.icon_info = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L33;
            switch(r104) {
                case 1: goto L32;
                case 2: goto L31;
                case 3: goto L39;
                case 4: goto L26;
                case 5: goto L25;
                case 6: goto L24;
                case 7: goto L23;
                case 8: goto L22;
                case 9: goto L21;
                case 10: goto L20;
                case 11: goto L19;
                case 12: goto L18;
                case 13: goto L37;
                case 14: goto L13;
                case 15: goto L12;
                case 16: goto L35;
                case 17: goto L7;
                default: goto L6;
            };
        L35:
            r101.tags.add(Tag.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L37:
            r101.feed_type = FeedCard.FeedType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L39:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
        L29:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.icon_info = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.is_shortcut = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.is_cross_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.is_remind = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.is_deleted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L20:
            r101.doc_message_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L21:
            r101.new_message_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L22:
            r101.owner_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L24:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L25:
            r101.doc_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L26:
            r101.icon_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L32:
            r101.f253480id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L33:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DocFeed r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253479id);
            String r103 = r100.title;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Type r107 = r100.type;
            if (r107 == null) goto L9;
            int r108 = Type.ADAPTER.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.icon_key;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.doc_url;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Long r116 = r100.create_time;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            Long r119 = r100.update_time;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            String r122 = r100.owner_id;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            Integer r125 = r100.new_message_count;
            if (r125 == null) goto L33;
            int r126 = ProtoAdapter.INT32.encodedSizeWithTag(9, r125);
        L34:
            int r127 = (r124 + r126) + r101.asRepeated().encodedSizeWithTag(10, r100.doc_message_ids);
            Boolean r128 = r100.is_deleted;
            if (r128 == null) goto L37;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r128);
        L38:
            int r130 = r127 + r129;
            Boolean r131 = r100.is_remind;
            if (r131 == null) goto L41;
            int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r131);
        L42:
            int r133 = r130 + r132;
            FeedCard.FeedType r134 = r100.feed_type;
            if (r134 == null) goto L45;
            int r135 = FeedCard.FeedType.ADAPTER.encodedSizeWithTag(13, r134);
        L46:
            int r136 = r133 + r135;
            Boolean r137 = r100.is_cross_tenant;
            if (r137 == null) goto L49;
            int r138 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r137);
        L50:
            int r139 = r136 + r138;
            Boolean r140 = r100.is_shortcut;
            if (r140 == null) goto L53;
            int r141 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r140);
        L54:
            int r142 = (r139 + r141) + Tag.ADAPTER.asRepeated().encodedSizeWithTag(16, r100.tags);
            String r143 = r100.icon_info;
            if (r143 == null) goto L58;
            r104 = r101.encodedSizeWithTag(17, r143);
        L58:
            return (r142 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ DocFeed decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DocFeed r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DocFeed r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253479id);
            String r103 = r101.title;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            Type r104 = r101.type;
            if (r104 == null) goto L8;
            Type.ADAPTER.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.icon_key;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.doc_url;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 5, r106);
        L14:
            Long r107 = r101.create_time;
            if (r107 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L17:
            Long r108 = r101.update_time;
            if (r108 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L20:
            String r109 = r101.owner_id;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 8, r109);
        L23:
            Integer r110 = r101.new_message_count;
            if (r110 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 9, r110);
        L26:
            r102.asRepeated().encodeWithTag(r100, 10, r101.doc_message_ids);
            Boolean r111 = r101.is_deleted;
            if (r111 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r111);
        L29:
            Boolean r112 = r101.is_remind;
            if (r112 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r112);
        L32:
            FeedCard.FeedType r113 = r101.feed_type;
            if (r113 == null) goto L35;
            FeedCard.FeedType.ADAPTER.encodeWithTag(r100, 13, r113);
        L35:
            Boolean r114 = r101.is_cross_tenant;
            if (r114 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r114);
        L38:
            Boolean r115 = r101.is_shortcut;
            if (r115 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 15, r115);
        L41:
            Tag.ADAPTER.asRepeated().encodeWithTag(r100, 16, r101.tags);
            String r116 = r101.icon_info;
            if (r116 == null) goto L44;
            r102.encodeWithTag(r100, 17, r116);
        L44:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocFeed r101) throws IOException {
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
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
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
                case 0: goto L34;
                case 1: goto L32;
                case 2: goto L30;
                case 3: goto L28;
                case 4: goto L26;
                case 5: goto L24;
                case 6: goto L22;
                case 7: goto L20;
                case 8: goto L18;
                case 9: goto L16;
                case 10: goto L14;
                case 11: goto L12;
                case 12: goto L10;
                case 13: goto L8;
                case 14: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return MIAODA;
        L8:
            return DOCX_SYNCED_BLOCK;
        L10:
            return SHORTCUT;
        L12:
            return SLIDES;
        L14:
            return CATALOG;
        L16:
            return FOLDER;
        L18:
            return DOCX;
        L20:
            return WIKI;
        L22:
            return SLIDE;
        L24:
            return FILE;
        L26:
            return MINDNOTE;
        L28:
            return BITABLE;
        L30:
            return SHEET;
        L32:
            return DOC;
        L34:
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
        ADAPTER = new ProtoAdapter_DocFeed();
        DEFAULT_TYPE = Type.DOC;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_NEW_MESSAGE_COUNT = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_DELETED = r100;
        DEFAULT_IS_REMIND = r100;
        DEFAULT_FEED_TYPE = FeedCard.FeedType.INBOX;
        DEFAULT_IS_CROSS_TENANT = r100;
        DEFAULT_IS_SHORTCUT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253480id = this.f253479id;
        r100.title = this.title;
        r100.type = this.type;
        r100.icon_key = this.icon_key;
        r100.doc_url = this.doc_url;
        r100.create_time = this.create_time;
        r100.update_time = this.update_time;
        r100.owner_id = this.owner_id;
        r100.new_message_count = this.new_message_count;
        r100.doc_message_ids = Internal.copyOf("doc_message_ids", this.doc_message_ids);
        r100.is_deleted = this.is_deleted;
        r100.is_remind = this.is_remind;
        r100.feed_type = this.feed_type;
        r100.is_cross_tenant = this.is_cross_tenant;
        r100.is_shortcut = this.is_shortcut;
        r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
        r100.icon_info = this.icon_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DocFeed.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DocFeed(String r210, String r211, Type r212, String r213, String r214, Long r215, Long r216, String r217, Integer r218, List<String> r219, Boolean r310, Boolean r311, FeedCard.FeedType r312, Boolean r313, Boolean r314, List<Tag> r315, String r316) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, ByteString.EMPTY);
    }

    public DocFeed(String r100, String r101, Type r102, String r103, String r104, Long r105, Long r110, String r111, Integer r112, List<String> r113, Boolean r114, Boolean r115, FeedCard.FeedType r116, Boolean r117, Boolean r118, List<Tag> r119, String r210, ByteString r211) {
        super(ADAPTER, r211);
        this.f253479id = r100;
        this.title = r101;
        this.type = r102;
        this.icon_key = r103;
        this.doc_url = r104;
        this.create_time = r105;
        this.update_time = r110;
        this.owner_id = r111;
        this.new_message_count = r112;
        this.doc_message_ids = Internal.immutableCopyOf("doc_message_ids", r113);
        this.is_deleted = r114;
        this.is_remind = r115;
        this.feed_type = r116;
        this.is_cross_tenant = r117;
        this.is_shortcut = r118;
        this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r119);
        this.icon_info = r210;
    }
}
