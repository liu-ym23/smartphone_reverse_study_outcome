package com.bytedance.lark.pb.space.doc.v1;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.bytedance.lark.pb.basic.v1.Icon;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.bytedance.lark.pb.basic.v1.TagData;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DocHistory extends Message<DocHistory, Builder> {
    public static final ProtoAdapter<DocHistory> ADAPTER = null;
    public static final String DEFAULT_CREATOR_ID = "";
    public static final String DEFAULT_DOC_ID = "";
    public static final Doc.Type DEFAULT_DOC_TYPE = null;
    public static final String DEFAULT_EDITOR_ID = "";
    public static final String DEFAULT_ICON_INFO = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Long DEFAULT_OPEN_TIME = null;
    public static final String DEFAULT_TITLE = "";
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final String DEFAULT_URL = "";
    public static final Doc.Type DEFAULT_WIKI_SUBTYPE = null;
    private static final long serialVersionUID = 0;
    public final String creator_id;
    public final String doc_id;
    public final Doc.Type doc_type;
    public final String editor_id;
    public final Icon icon;
    public final String icon_info;
    public final Boolean is_cross_tenant;
    public final Long open_time;
    public final TagData relation_tag;
    public final List<Tag> tags;
    public final String title;
    public final Long update_time;
    public final String url;
    public final Doc.Type wiki_subtype;

    public static final class Builder extends Message.Builder<DocHistory, Builder> {
        public String creator_id;
        public String doc_id;
        public Doc.Type doc_type;
        public String editor_id;
        public Icon icon;
        public String icon_info;
        public Boolean is_cross_tenant;
        public Long open_time;
        public TagData relation_tag;
        public List<Tag> tags;
        public String title;
        public Long update_time;
        public String url;
        public Doc.Type wiki_subtype;

        @Override // com.squareup.wire.Message.Builder
        public DocHistory build() {
            return new DocHistory(this.url, this.doc_type, this.title, this.creator_id, this.editor_id, this.update_time, this.open_time, this.doc_id, this.is_cross_tenant, this.icon, this.tags, this.wiki_subtype, this.relation_tag, this.icon_info, super.buildUnknownFields());
        }

        public Builder() {
            this.tags = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder creator_id(String r100) {
            this.creator_id = r100;
            return this;
        }

        public Builder doc_id(String r100) {
            this.doc_id = r100;
            return this;
        }

        public Builder doc_type(Doc.Type r100) {
            this.doc_type = r100;
            return this;
        }

        public Builder editor_id(String r100) {
            this.editor_id = r100;
            return this;
        }

        public Builder icon(Icon r100) {
            this.icon = r100;
            return this;
        }

        public Builder icon_info(String r100) {
            this.icon_info = r100;
            return this;
        }

        public Builder is_cross_tenant(Boolean r100) {
            this.is_cross_tenant = r100;
            return this;
        }

        public Builder open_time(Long r100) {
            this.open_time = r100;
            return this;
        }

        public Builder relation_tag(TagData r100) {
            this.relation_tag = r100;
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

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }

        public Builder wiki_subtype(Doc.Type r100) {
            this.wiki_subtype = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DocHistory extends ProtoAdapter<DocHistory> {
        public ProtoAdapter_DocHistory() {
            super(FieldEncoding.LENGTH_DELIMITED, DocHistory.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DocHistory decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.url = "";
            Doc.Type r102 = Doc.Type.UNKNOWN;
            r101.doc_type = r102;
            r101.title = "";
            r101.creator_id = "";
            r101.editor_id = "";
            r101.update_time = 0L;
            r101.open_time = 0L;
            r101.doc_id = "";
            r101.is_cross_tenant = Boolean.FALSE;
            r101.wiki_subtype = r102;
            r101.icon_info = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L30;
            switch(r104) {
                case 1: goto L29;
                case 2: goto L36;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L17;
                case 11: goto L32;
                case 12: goto L34;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L32:
            r101.tags.add(Tag.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L34:
            r101.wiki_subtype = Doc.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L36:
            r101.doc_type = Doc.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.icon_info = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.relation_tag = TagData.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.icon = Icon.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.is_cross_tenant = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.doc_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.open_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L21:
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L22:
            r101.editor_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.creator_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L29:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L30:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DocHistory r100) {
            String r101 = r100.url;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Doc.Type r104 = r100.doc_type;
            if (r104 == null) goto L9;
            int r105 = Doc.Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.title;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.creator_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.editor_id;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.update_time;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.open_time;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.doc_id;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.is_cross_tenant;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Icon r128 = r100.icon;
            if (r128 == null) goto L41;
            int r129 = Icon.ADAPTER.encodedSizeWithTag(10, r128);
        L42:
            int r130 = (r127 + r129) + Tag.ADAPTER.asRepeated().encodedSizeWithTag(11, r100.tags);
            Doc.Type r131 = r100.wiki_subtype;
            if (r131 == null) goto L45;
            int r132 = Doc.Type.ADAPTER.encodedSizeWithTag(12, r131);
        L46:
            int r133 = r130 + r132;
            TagData r134 = r100.relation_tag;
            if (r134 == null) goto L49;
            int r135 = TagData.ADAPTER.encodedSizeWithTag(13, r134);
        L50:
            int r136 = r133 + r135;
            String r137 = r100.icon_info;
            if (r137 == null) goto L54;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(14, r137);
        L54:
            return (r136 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ DocHistory decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DocHistory r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DocHistory r101) throws IOException {
            String r102 = r101.url;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Doc.Type r103 = r101.doc_type;
            if (r103 == null) goto L8;
            Doc.Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.title;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.creator_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.editor_id;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            Long r107 = r101.update_time;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.open_time;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.doc_id;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            Boolean r110 = r101.is_cross_tenant;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L29:
            Icon r111 = r101.icon;
            if (r111 == null) goto L32;
            Icon.ADAPTER.encodeWithTag(r100, 10, r111);
        L32:
            Tag.ADAPTER.asRepeated().encodeWithTag(r100, 11, r101.tags);
            Doc.Type r112 = r101.wiki_subtype;
            if (r112 == null) goto L35;
            Doc.Type.ADAPTER.encodeWithTag(r100, 12, r112);
        L35:
            TagData r113 = r101.relation_tag;
            if (r113 == null) goto L38;
            TagData.ADAPTER.encodeWithTag(r100, 13, r113);
        L38:
            String r114 = r101.icon_info;
            if (r114 == null) goto L41;
            ProtoAdapter.STRING.encodeWithTag(r100, 14, r114);
        L41:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocHistory r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocHistory();
        Doc.Type r100 = Doc.Type.UNKNOWN;
        DEFAULT_DOC_TYPE = r100;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_OPEN_TIME = 0L;
        DEFAULT_IS_CROSS_TENANT = Boolean.FALSE;
        DEFAULT_WIKI_SUBTYPE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.doc_type = this.doc_type;
        r100.title = this.title;
        r100.creator_id = this.creator_id;
        r100.editor_id = this.editor_id;
        r100.update_time = this.update_time;
        r100.open_time = this.open_time;
        r100.doc_id = this.doc_id;
        r100.is_cross_tenant = this.is_cross_tenant;
        r100.icon = this.icon;
        r100.tags = Internal.copyOf(PromotionProductPrivilegesStruct.TAGS, this.tags);
        r100.wiki_subtype = this.wiki_subtype;
        r100.relation_tag = this.relation_tag;
        r100.icon_info = this.icon_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DocHistory.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DocHistory(String r110, Doc.Type r111, String r112, String r210, String r211, Long r212, Long r213, String r214, Boolean r215, Icon r216, List<Tag> r217, Doc.Type r218, TagData r219, String r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public DocHistory(String r100, Doc.Type r101, String r102, String r103, String r104, Long r105, Long r110, String r111, Boolean r112, Icon r113, List<Tag> r114, Doc.Type r115, TagData r116, String r117, ByteString r118) {
        super(ADAPTER, r118);
        this.url = r100;
        this.doc_type = r101;
        this.title = r102;
        this.creator_id = r103;
        this.editor_id = r104;
        this.update_time = r105;
        this.open_time = r110;
        this.doc_id = r111;
        this.is_cross_tenant = r112;
        this.icon = r113;
        this.tags = Internal.immutableCopyOf(PromotionProductPrivilegesStruct.TAGS, r114);
        this.wiki_subtype = r115;
        this.relation_tag = r116;
        this.icon_info = r117;
    }
}
